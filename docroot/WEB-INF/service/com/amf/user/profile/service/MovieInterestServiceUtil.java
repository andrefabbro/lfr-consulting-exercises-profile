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
 * Provides the remote service utility for MovieInterest. This utility wraps
 * {@link com.amf.user.profile.service.impl.MovieInterestServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author andrefabbro
 * @see MovieInterestService
 * @see com.amf.user.profile.service.base.MovieInterestServiceBaseImpl
 * @see com.amf.user.profile.service.impl.MovieInterestServiceImpl
 * @generated
 */
public class MovieInterestServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.amf.user.profile.service.impl.MovieInterestServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.amf.user.profile.model.MovieInterest getByUserId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService().getByUserId(userId, groupId);
	}

	public static com.amf.user.profile.model.MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String favoriteMovie, java.lang.String favoriteGenre,
		java.lang.String leastFavMovie, java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .addMovieInterest(groupId, companyId, userId, userName,
			favoriteMovie, favoriteGenre, leastFavMovie, favoriteActor);
	}

	public static com.amf.user.profile.model.MovieInterest updateMovieInterest(
		long movieInterestId, long groupId, java.lang.String favoriteMovie,
		java.lang.String favoriteGenre, java.lang.String leastFavMovie,
		java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService()
				   .updateMovieInterest(movieInterestId, groupId,
			favoriteMovie, favoriteGenre, leastFavMovie, favoriteActor);
	}

	public static void clearService() {
		_service = null;
	}

	public static MovieInterestService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MovieInterestService.class.getName());

			if (invokableService instanceof MovieInterestService) {
				_service = (MovieInterestService)invokableService;
			}
			else {
				_service = new MovieInterestServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(MovieInterestServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MovieInterestService service) {
	}

	private static MovieInterestService _service;
}