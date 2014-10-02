/**
 * 
 */

package com.amf.user.profile;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.GeneralProfileLocalServiceUtil;
import com.amf.user.profile.service.GeneralProfileServiceUtil;
import com.amf.user.profile.service.MovieInterestLocalServiceUtil;
import com.amf.user.profile.service.MovieInterestServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ContactLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author andrefabbro
 */
public class UserProfilePersistenceUtil {

	private final static String BASIC_INFO_DOMAIN_NAME =
		"com.amf.user.profile.model.BasicInfo";

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
			user.getPrimaryKey(), null, user.getPassword(), user.getPassword(),
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

}
