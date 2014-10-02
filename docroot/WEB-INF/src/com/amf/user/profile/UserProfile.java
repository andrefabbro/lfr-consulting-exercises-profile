
package com.amf.user.profile;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.GeneralProfileLocalServiceUtil;
import com.amf.user.profile.service.GeneralProfileServiceUtil;
import com.amf.user.profile.service.MovieInterestLocalServiceUtil;
import com.amf.user.profile.service.MovieInterestServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;

/**
 * Portlet implementation class UserProfile
 */
public class UserProfile extends MVCPortlet {

	private final static String BASIC_INFO_DOMAIN_NAME =
		"com.amf.user.profile.model.BasicInfo";

	private long companyId;

	private long groupId;

	private long userId;

	private Contact selectedContact;

	private GeneralProfile generalProfile;

	private MovieInterest movieInterest;

	/**
	 * Determine the value of the visibility flag (0 = private, 1 = protected
	 * and 2 = public) based on the resource permission
	 * 
	 * @param className
	 *            the resource class
	 * @param entityPk
	 *            the resource primaryKey
	 * @param roleMemberId
	 *            the id of the role member
	 * @param roleGuestId
	 *            the id of the role guest
	 * @return String flag the flag indicating that is privave, protected or
	 *         public
	 * @throws PortalException
	 * @throws SystemException
	 */
	private String proccessVisibilitySetting(
		String className, String entityPk, long roleMemberId, long roleGuestId)
		throws PortalException, SystemException {

		// set to private
		String visibility = "0";

		long[] rolesId = {
			roleMemberId, roleGuestId
		};

		if (ResourcePermissionLocalServiceUtil.hasResourcePermission(
			companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, entityPk,
			rolesId, ActionKeys.VIEW))
			visibility = "2";
		else if (ResourcePermissionLocalServiceUtil.hasResourcePermission(
			companyId, className, ResourceConstants.SCOPE_INDIVIDUAL, entityPk,
			roleMemberId, ActionKeys.VIEW))
			visibility = "1";

		return visibility;
	}

	/**
	 * Proccess the permission for the entity based on the flag (private,
	 * protected or public)
	 * 
	 * @param flagValue
	 * @param className
	 * @param entityPk
	 * @param roleMemberId
	 * @param roleGuestId
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void proccessPermissionsForEntity(
		String flagValue, String className, String entityPk, long roleMemberId,
		long roleGuestId)
		throws PortalException, SystemException {

		// deletes all resource permissions before add all
		for (int scope : ResourceConstants.SCOPES) {
			ResourcePermissionLocalServiceUtil.removeResourcePermission(
				companyId, className, scope, String.valueOf(entityPk),
				roleMemberId, ActionKeys.VIEW);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(
				companyId, className, scope, String.valueOf(entityPk),
				roleGuestId, ActionKeys.VIEW);
		}

		// if the flag is protected or public, add the proper resources for it,
		// the last two parameters (groupPermissions and guestPermissions)
		// define the visibility
		if (flagValue.equals("1"))
			ResourceLocalServiceUtil.addResources(
				companyId, groupId, userId, className, entityPk, false, true,
				false);
		else if (flagValue.equals("2"))
			ResourceLocalServiceUtil.addResources(
				companyId, groupId, userId, className, entityPk, false, true,
				true);
	}

	/**
	 * Setup the common attributes companyId, groupId and userId
	 * 
	 * @param request
	 */
	private void setUpCommonAttr(PortletRequest request) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		userId = themeDisplay.getUserId();
	}

	/**
	 * Retrives the contact, generalProfile and movieInterest
	 * 
	 * @param request
	 * @param user
	 * @throws SystemException
	 * @throws PrincipalException
	 */
	private void fetchUserProfileByUser(PortletRequest request, User user)
		throws SystemException, PrincipalException {

		selectedContact =
			ContactLocalServiceUtil.fetchContact(user.getContactId());
		generalProfile =
			GeneralProfileServiceUtil.getByUserId(user.getUserId(), groupId);
		movieInterest =
			MovieInterestServiceUtil.getByUserId(user.getUserId(), groupId);
	}

	/**
	 * Sets the request attributes for contact, generalProfile and movieInterest
	 * 
	 * @param request
	 */
	private void setRequestAttributesUserProfile(PortletRequest request) {

		request.setAttribute("selectedContact", selectedContact);
		request.setAttribute("generalProfile", generalProfile);
		request.setAttribute("movieInterest", movieInterest);
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		this.setUpCommonAttr(request);

		String screenName = ParamUtil.getString(request, "screenName");

		try {
			// load user info, if the screename isn't in the URL, it will show
			// de logged user
			User selectedUser = null;
			if (!"".equals(screenName) && screenName != null)
				selectedUser =
					UserLocalServiceUtil.getUserByScreenName(
						companyId, screenName);
			else
				selectedUser = PortalUtil.getUser(request);

			// load general profile and movie interests
			if (selectedUser != null) {
				this.fetchUserProfileByUser(request, selectedUser);
				this.setRequestAttributesUserProfile(request);
			}
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		super.doView(request, response);
	}

	@Override
	public void doEdit(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		try {

			this.setUpCommonAttr(request);

			this.fetchUserProfileByUser(request, PortalUtil.getUser(request));

			this.setRequestAttributesUserProfile(request);

			// prepare the birthday date field
			if (selectedContact != null &&
				selectedContact.getBirthday() != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(selectedContact.getBirthday());
				request.setAttribute(
					"birthdayDay", cal.get(Calendar.DAY_OF_MONTH));
				request.setAttribute("birthdayMonth", cal.get(Calendar.MONTH));
				request.setAttribute("birthdayYear", cal.get(Calendar.YEAR));
			}
		}
		catch (SystemException | PortalException e) {
			e.printStackTrace();
		}

		super.doEdit(request, response);
	}

	@Override
	public void doConfig(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		this.setUpCommonAttr(request);

		try {

			User selectedUser = PortalUtil.getUser(request);
			GeneralProfile generalProfile =
				GeneralProfileServiceUtil.getByUserId(userId, groupId);
			MovieInterest movieInterest =
				MovieInterestServiceUtil.getByUserId(userId, groupId);
			Contact selectedContact =
				ContactLocalServiceUtil.getContact(selectedUser.getContactId());

			if (generalProfile == null) {
				SessionErrors.add(
					request, "you-have-to-edit-your-profile-first");
				include(configTemplate, request, response);
				return;
			}

			Role roleMember =
				RoleLocalServiceUtil.getRole(
					companyId, RoleConstants.SITE_MEMBER);
			Role roleGuest =
				RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);

			// gets the configured visibility settings
			String basic_info =
				this.proccessVisibilitySetting(
					BASIC_INFO_DOMAIN_NAME,
					selectedContact.getPrimaryKeyObj().toString(),
					roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

			String general_profile =
				this.proccessVisibilitySetting(
					GeneralProfile.class.getName(),
					generalProfile.getPrimaryKeyObj().toString(),
					roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

			String movie_interest =
				this.proccessVisibilitySetting(
					MovieInterest.class.getName(),
					movieInterest.getPrimaryKeyObj().toString(),
					roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

			request.setAttribute("basic_info", basic_info);
			request.setAttribute("general_profile", general_profile);
			request.setAttribute("movie_interest", movie_interest);
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		super.doConfig(request, response);
	}

	/**
	 * Action responsible for save the privacy settings for the user
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	public void savePrivacyAction(ActionRequest request, ActionResponse response)
		throws IOException, PortletException {

		this.setUpCommonAttr(request);

		String basic_info =
			ParamUtil.getString(request, "basic_info", StringPool.BLANK);
		String general_profile =
			ParamUtil.getString(request, "general_profile", StringPool.BLANK);
		String movie_interest =
			ParamUtil.getString(request, "movie_interest", StringPool.BLANK);

		System.out.println("basic_info: " + basic_info);
		System.out.println("general_profile: " + general_profile);
		System.out.println("movie_interest: " + movie_interest);

		try {

			User selectedUser = PortalUtil.getUser(request);

			this.fetchUserProfileByUser(request, selectedUser);

			Role roleMember =
				RoleLocalServiceUtil.getRole(
					companyId, RoleConstants.SITE_MEMBER);
			Role roleGuest =
				RoleLocalServiceUtil.getRole(companyId, RoleConstants.GUEST);

			this.proccessPermissionsForEntity(
				basic_info, BASIC_INFO_DOMAIN_NAME,
				selectedContact.getPrimaryKeyObj().toString(),
				roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

			this.proccessPermissionsForEntity(
				general_profile, GeneralProfile.class.getName(),
				generalProfile.getPrimaryKeyObj().toString(),
				roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

			this.proccessPermissionsForEntity(
				movie_interest, MovieInterest.class.getName(),
				movieInterest.getPrimaryKeyObj().toString(),
				roleMember.getPrimaryKey(), roleGuest.getPrimaryKey());

		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}

		PortalUtil.copyRequestParameters(request, response);
		response.setRenderParameter("jspPage", "/html/userprofile/privacy.jsp");
	}

	/**
	 * Saves the profile for the user
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	public void saveProfileAction(ActionRequest request, ActionResponse response)
		throws IOException, PortletException {

		this.setUpCommonAttr(request);

		String firstName =
			ParamUtil.getString(request, "first_name", StringPool.BLANK);
		String lastName =
			ParamUtil.getString(request, "last_name", StringPool.BLANK);
		Boolean male = ParamUtil.getBoolean(request, "male", true);
		Date birthday =
			ParamUtil.getDate(request, "birthday", new SimpleDateFormat(
				"MM/dd/yyyy"), null);

		// perform server side validations
		if (StringPool.BLANK.equals(firstName))
			SessionErrors.add(request, "required-field-firstname");
		if (StringPool.BLANK.equals(lastName))
			SessionErrors.add(request, "required-field-lastname");
		if (birthday == null)
			SessionErrors.add(request, "required-field-birthday");

		DateTime dtbirthday = new DateTime(birthday);
		Interval interval = new Interval(dtbirthday, new Instant());
		if (interval.toPeriod().getYears() < 13)
			SessionErrors.add(request, "age-not-allowed");

		if (!SessionErrors.isEmpty(request)) {
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/html/userprofile/edit.jsp");
		}
		else {

			try {

				// load the profile from user
				User selectedUser = PortalUtil.getUser(request);

				// retrieve the user profile
				this.fetchUserProfileByUser(request, selectedUser);

				// creates the profile objects if the user haven't yet
				if (generalProfile == null)
					generalProfile =
						GeneralProfileLocalServiceUtil.createGeneralProfile(0);
				if (movieInterest == null)
					movieInterest =
						MovieInterestLocalServiceUtil.createMovieInterest(0);

				// gets the form input and populate the profile objects

				Calendar birthdayCalendar = Calendar.getInstance();
				birthdayCalendar.setTime(birthday);

				generalProfile.setAboutMe(ParamUtil.getString(
					request, "about_me"));
				generalProfile.setFavoriteQuotes(ParamUtil.getString(
					request, "favorite_quotes"));

				movieInterest.setFavoriteMovie(ParamUtil.getString(
					request, "favorite_movie"));
				movieInterest.setFavoriteGenre(ParamUtil.getString(
					request, "favorite_genre"));
				movieInterest.setLeastFavMovie(ParamUtil.getString(
					request, "least_fav_movie"));
				movieInterest.setFavoriteActor(ParamUtil.getString(
					request, "favorite_actor"));

				// execute the update or insert

				selectedContact =
					ContactLocalServiceUtil.updateContact(
						selectedContact.getContactId(),
						selectedContact.getEmailAddress(), firstName,
						selectedContact.getMiddleName(), lastName,
						selectedContact.getPrefixId(),
						selectedContact.getSuffixId(), male,
						birthdayCalendar.get(Calendar.MONTH),
						birthdayCalendar.get(Calendar.DAY_OF_MONTH),
						birthdayCalendar.get(Calendar.YEAR),
						selectedContact.getSmsSn(), selectedContact.getAimSn(),
						selectedContact.getFacebookSn(),
						selectedContact.getIcqSn(),
						selectedContact.getJabberSn(),
						selectedContact.getMsnSn(),
						selectedContact.getMySpaceSn(),
						selectedContact.getSkypeSn(),
						selectedContact.getTwitterSn(),
						selectedContact.getYmSn(),
						selectedContact.getJobTitle());

				// if is the first time the user is filling the profile, adds
				// the contact resource
				if (generalProfile.getGeneralProfileId() == 0)
					ResourceLocalServiceUtil.addResources(
						companyId, groupId, userId, BASIC_INFO_DOMAIN_NAME,
						selectedContact.getPrimaryKey(), false, true, true);

				generalProfile =
					(generalProfile.getGeneralProfileId() == 0)
						? GeneralProfileServiceUtil.addGeneralProfile(
							groupId, companyId, userId,
							selectedUser.getLogin(),
							generalProfile.getAboutMe(),
							generalProfile.getFavoriteQuotes())
						: GeneralProfileServiceUtil.updateGeneralProfile(
							generalProfile.getGeneralProfileId(), groupId,
							generalProfile.getAboutMe(),
							generalProfile.getFavoriteQuotes());

				movieInterest =
					(movieInterest.getMovieInterestId() == 0)
						? MovieInterestServiceUtil.addMovieInterest(
							groupId, companyId, userId,
							selectedUser.getLogin(),
							movieInterest.getFavoriteMovie(),
							movieInterest.getFavoriteGenre(),
							movieInterest.getLeastFavMovie(),
							movieInterest.getFavoriteActor())
						: MovieInterestServiceUtil.updateMovieInterest(
							movieInterest.getMovieInterestId(), groupId,
							movieInterest.getFavoriteMovie(),
							movieInterest.getFavoriteGenre(),
							movieInterest.getLeastFavMovie(),
							movieInterest.getFavoriteActor());

				// prepare the view
				this.setRequestAttributesUserProfile(request);
				SessionMessages.add(request, "user-profile-updated");
				response.setRenderParameter(
					"jspPage", "/html/userprofile/view.jsp");
			}
			catch (PortalException | SystemException e) {
				e.printStackTrace();
				throw new PortletException(e.getMessage());
			}
		}
	}
}
