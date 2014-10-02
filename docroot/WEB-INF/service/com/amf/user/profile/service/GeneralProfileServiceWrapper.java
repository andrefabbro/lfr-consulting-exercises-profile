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

package com.amf.user.profile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeneralProfileService}.
 *
 * @author andrefabbro
 * @see GeneralProfileService
 * @generated
 */
public class GeneralProfileServiceWrapper implements GeneralProfileService,
	ServiceWrapper<GeneralProfileService> {
	public GeneralProfileServiceWrapper(
		GeneralProfileService generalProfileService) {
		_generalProfileService = generalProfileService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _generalProfileService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_generalProfileService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _generalProfileService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile getByUserId(long userId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _generalProfileService.getByUserId(userId, groupId);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String aboutMe, java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _generalProfileService.addGeneralProfile(groupId, companyId,
			userId, userName, aboutMe, favoriteQuotes);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
		long generalProfileId, long groupId, java.lang.String aboutMe,
		java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _generalProfileService.updateGeneralProfile(generalProfileId,
			groupId, aboutMe, favoriteQuotes);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneralProfileService getWrappedGeneralProfileService() {
		return _generalProfileService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneralProfileService(
		GeneralProfileService generalProfileService) {
		_generalProfileService = generalProfileService;
	}

	@Override
	public GeneralProfileService getWrappedService() {
		return _generalProfileService;
	}

	@Override
	public void setWrappedService(GeneralProfileService generalProfileService) {
		_generalProfileService = generalProfileService;
	}

	private GeneralProfileService _generalProfileService;
}