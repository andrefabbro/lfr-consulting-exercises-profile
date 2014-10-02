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
 * Provides a wrapper for {@link MovieInterestService}.
 *
 * @author andrefabbro
 * @see MovieInterestService
 * @generated
 */
public class MovieInterestServiceWrapper implements MovieInterestService,
	ServiceWrapper<MovieInterestService> {
	public MovieInterestServiceWrapper(
		MovieInterestService movieInterestService) {
		_movieInterestService = movieInterestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _movieInterestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_movieInterestService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _movieInterestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest getByUserId(long userId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _movieInterestService.getByUserId(userId, groupId);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String favoriteMovie, java.lang.String favoriteGenre,
		java.lang.String leastFavMovie, java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _movieInterestService.addMovieInterest(groupId, companyId,
			userId, userName, favoriteMovie, favoriteGenre, leastFavMovie,
			favoriteActor);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest updateMovieInterest(
		long movieInterestId, long groupId, java.lang.String favoriteMovie,
		java.lang.String favoriteGenre, java.lang.String leastFavMovie,
		java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _movieInterestService.updateMovieInterest(movieInterestId,
			groupId, favoriteMovie, favoriteGenre, leastFavMovie, favoriteActor);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MovieInterestService getWrappedMovieInterestService() {
		return _movieInterestService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMovieInterestService(
		MovieInterestService movieInterestService) {
		_movieInterestService = movieInterestService;
	}

	@Override
	public MovieInterestService getWrappedService() {
		return _movieInterestService;
	}

	@Override
	public void setWrappedService(MovieInterestService movieInterestService) {
		_movieInterestService = movieInterestService;
	}

	private MovieInterestService _movieInterestService;
}