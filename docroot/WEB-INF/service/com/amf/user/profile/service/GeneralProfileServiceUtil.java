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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for GeneralProfile. This utility wraps
 * {@link com.amf.user.profile.service.impl.GeneralProfileServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author andrefabbro
 * @see GeneralProfileService
 * @see com.amf.user.profile.service.base.GeneralProfileServiceBaseImpl
 * @see com.amf.user.profile.service.impl.GeneralProfileServiceImpl
 * @generated
 */
public class GeneralProfileServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.amf.user.profile.service.impl.GeneralProfileServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.amf.user.profile.model.GeneralProfile getByUserId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService().getByUserId(userId, groupId);
	}

	public static com.amf.user.profile.model.GeneralProfile addGeneralProfile(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String aboutMe, java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .addGeneralProfile(groupId, companyId, userId, userName,
			aboutMe, favoriteQuotes);
	}

	public static com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
		long generalProfileId, long groupId, java.lang.String aboutMe,
		java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .updateGeneralProfile(generalProfileId, groupId, aboutMe,
			favoriteQuotes);
	}

	public static void clearService() {
		_service = null;
	}

	public static GeneralProfileService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GeneralProfileService.class.getName());

			if (invokableService instanceof GeneralProfileService) {
				_service = (GeneralProfileService)invokableService;
			}
			else {
				_service = new GeneralProfileServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(GeneralProfileServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GeneralProfileService service) {
	}

	private static GeneralProfileService _service;
}