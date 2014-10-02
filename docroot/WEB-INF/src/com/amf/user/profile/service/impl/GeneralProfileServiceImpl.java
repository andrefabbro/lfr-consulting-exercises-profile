/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.amf.user.profile.service.impl;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.service.base.GeneralProfileServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the general profile remote service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.amf.user.profile.service.GeneralProfileService} interface. <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 *
 * @author andrefabbro
 * @see com.amf.user.profile.service.base.GeneralProfileServiceBaseImpl
 * @see com.amf.user.profile.service.GeneralProfileServiceUtil
 */
public class GeneralProfileServiceImpl extends GeneralProfileServiceBaseImpl {

	public GeneralProfile getByUserId(long userId, long groupId)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "VIEW"))
			throw new PrincipalException();

		return this.generalProfileLocalService.getByUserId(userId);
	}

	public GeneralProfile addGeneralProfile(
		long groupId, long companyId, long userId, String userName,
		String aboutMe, String favoriteQuotes)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "UPDATE"))
			throw new PrincipalException();

		return this.generalProfileLocalService.addGeneralProfile(
			groupId, companyId, userId, userName, aboutMe, favoriteQuotes);
	}

	public GeneralProfile updateGeneralProfile(
		long generalProfileId, long groupId, String aboutMe,
		String favoriteQuotes)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "UPDATE"))
			throw new PrincipalException();

		return this.generalProfileLocalService.updateGeneralProfile(
			generalProfileId, aboutMe, favoriteQuotes);
	}
}
