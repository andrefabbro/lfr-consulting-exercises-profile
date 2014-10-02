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

import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.base.MovieInterestServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * @author andrefabbro
 * @see com.amf.user.profile.service.base.MovieInterestServiceBaseImpl
 * @see com.amf.user.profile.service.MovieInterestServiceUtil
 */
public class MovieInterestServiceImpl extends MovieInterestServiceBaseImpl {

	public MovieInterest getByUserId(long userId, long groupId)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "VIEW"))
			throw new PrincipalException();

		return this.movieInterestLocalService.getByUserId(userId);
	}

	public MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, String userName,
		String favoriteMovie, String favoriteGenre, String leastFavMovie,
		String favoriteActor)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "UPDATE"))
			throw new PrincipalException();

		return this.movieInterestLocalService.addMovieInterest(
			groupId, companyId, userId, userName, favoriteMovie, favoriteGenre,
			leastFavMovie, favoriteActor);
	}

	public MovieInterest updateMovieInterest(
		long movieInterestId, long groupId, String favoriteMovie,
		String favoriteGenre, String leastFavMovie, String favoriteActor)
		throws SystemException, PrincipalException {

		if (!getPermissionChecker().hasPermission(
			groupId, "com.amf.user.profile.model", groupId, "UPDATE"))
			throw new PrincipalException();

		return this.movieInterestLocalService.updateMovieInterest(
			movieInterestId, favoriteMovie, favoriteGenre, leastFavMovie,
			favoriteActor);
	}
}
