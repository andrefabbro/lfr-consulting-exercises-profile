/**
 * 
 */

package com.amf.user.profile.service;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.model.UserProfile;
import com.amf.user.profile.model.extimpl.UserProfileImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author andrefabbro
 */
public class UserProfilePersistenceUtil {

	private final static String BASIC_INFO_DOMAIN_NAME =
		"com.amf.user.profile.model.BasicInfo";

	public static UserProfile getUserProfile(long primaryKey)
		throws PortalException, SystemException {

		// the primary key of UserProfile is the same as of GeneralProfile
		GeneralProfile generalProfile =
			GeneralProfileLocalServiceUtil.getGeneralProfile(primaryKey);

		MovieInterest movieInterest =
			MovieInterestLocalServiceUtil.getByUserId(generalProfile.getUserId());

		User user = UserLocalServiceUtil.getUser(generalProfile.getUserId());

		Contact contact =
			ContactLocalServiceUtil.fetchContact(user.getContactId());

		UserProfile userProfile = new UserProfileImpl();
		userProfile.createFromAttributes(contact, generalProfile, movieInterest);

		return userProfile;
	}

	/**
	 * Perfom Business logic to save all user profile objects
	 * 
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param contact
	 * @param generalProfile
	 * @param movieInterest
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param male
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static void saveUserProfile(
		long companyId, long groupId, long userId, Contact contact,
		GeneralProfile generalProfile, MovieInterest movieInterest,
		String firstName, String lastName, Date birthday, boolean male,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		User user = UserLocalServiceUtil.fetchUser(userId);
		String username = user.getScreenName();

		// gets the form input and populate the profile objects

		Calendar birthdayCalendar = Calendar.getInstance();
		birthdayCalendar.setTime(birthday);

		contact =
			ContactLocalServiceUtil.updateContact(
				contact.getContactId(), contact.getEmailAddress(), firstName,
				contact.getMiddleName(), lastName, contact.getPrefixId(),
				contact.getSuffixId(), male,
				birthdayCalendar.get(Calendar.MONTH),
				birthdayCalendar.get(Calendar.DAY_OF_MONTH),
				birthdayCalendar.get(Calendar.YEAR), contact.getSmsSn(),
				contact.getAimSn(), contact.getFacebookSn(),
				contact.getIcqSn(), contact.getJabberSn(), contact.getMsnSn(),
				contact.getMySpaceSn(), contact.getSkypeSn(),
				contact.getTwitterSn(), contact.getYmSn(),
				contact.getJobTitle());

		// if is the first time the user is filling the profile, adds
		// the contact resource
		if (generalProfile.getGeneralProfileId() == 0)
			ResourceLocalServiceUtil.addResources(
				companyId, groupId, userId, BASIC_INFO_DOMAIN_NAME,
				contact.getPrimaryKey(), false, true, true);

		// update the user register
		saveUserDetails(
			user, contact, serviceContext, firstName, lastName, male,
			birthdayCalendar.get(Calendar.MONTH),
			birthdayCalendar.get(Calendar.DAY_OF_MONTH),
			birthdayCalendar.get(Calendar.YEAR));

		generalProfile =
			(generalProfile.getGeneralProfileId() == 0)
				? GeneralProfileServiceUtil.addGeneralProfile(
					groupId, companyId, userId, username,
					generalProfile.getAboutMe(),
					generalProfile.getFavoriteQuotes())
				: GeneralProfileServiceUtil.updateGeneralProfile(
					generalProfile.getGeneralProfileId(), groupId,
					generalProfile.getAboutMe(),
					generalProfile.getFavoriteQuotes());

		movieInterest =
			(movieInterest.getMovieInterestId() == 0)
				? MovieInterestServiceUtil.addMovieInterest(
					groupId, companyId, userId, username,
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

		// creates a user profile wrapper object to reindex all together
		UserProfile userProfile = new UserProfileImpl();
		userProfile.createFromAttributes(contact, generalProfile, movieInterest);
		reindex(userProfile);

		try {
			ResourceLocalServiceUtil.addResources(
				userProfile.getCompanyId(), userProfile.getGroupId(),
				userProfile.getUserId(), UserProfile.class.getName(),
				userProfile.getUserProfileId(), false, true, true);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
	}

	public static int getUserProfileCount()
		throws SystemException {

		return GeneralProfileLocalServiceUtil.getGeneralProfilesCount();
	}

	public static List<UserProfile> getUserProfiles(int start, int end)
		throws SystemException {

		List<GeneralProfile> generalProfiles =
			GeneralProfileLocalServiceUtil.getGeneralProfiles(start, end);
		List<UserProfile> results = new ArrayList<UserProfile>();

		for (GeneralProfile generalProfile : generalProfiles) {

			MovieInterest movieInterest =
				MovieInterestLocalServiceUtil.getByUserId(generalProfile.getUserId());

			User user =
				UserLocalServiceUtil.fetchUser(generalProfile.getUserId());

			Contact contact =
				ContactLocalServiceUtil.fetchContact(user.getContactId());

			UserProfile userProfile = new UserProfileImpl();
			userProfile.createFromAttributes(
				contact, generalProfile, movieInterest);

			results.add(userProfile);
		}

		return results;
	}

	/**
	 * Support method to update the user in database
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	private static void saveUserDetails(
		User user, Contact contact, ServiceContext serviceContext,
		String firstName, String lastName, boolean male, int birthdayMonth,
		int birthdayDay, int birthdayYear)
		throws SystemException, PortalException {

		UserLocalServiceUtil.updateUser(
			user.getPrimaryKey(), null, null, null,
			false, user.getReminderQueryQuestion(),
			user.getReminderQueryAnswer(), user.getScreenName(),
			user.getEmailAddress(), user.getFacebookId(), user.getOpenId(),
			user.getLanguageId(), user.getTimeZoneId(), user.getGreeting(),
			user.getComments(), firstName, user.getMiddleName(), lastName,
			contact.getPrefixId(), contact.getSuffixId(), male, birthdayMonth,
			birthdayDay, birthdayYear, contact.getSmsSn(), contact.getAimSn(),
			contact.getFacebookSn(), contact.getIcqSn(), contact.getJabberSn(),
			contact.getMsnSn(), contact.getMySpaceSn(), contact.getSkypeSn(),
			contact.getTwitterSn(), contact.getYmSn(), user.getJobTitle(),
			user.getGroupIds(), user.getOrganizationIds(), user.getRoleIds(),
			null, user.getUserGroupIds(), serviceContext);
	}

	private static void reindex(UserProfile userProfile) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(UserProfile.class);
		try {
			indexer.reindex(userProfile);
		}
		catch (SearchException e) {
			System.out.println("Search Exception: " + e.getMessage());
		}
	}

}
