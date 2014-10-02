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
import com.amf.user.profile.service.base.MovieInterestLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;

import java.util.Date;

/**
 * The implementation of the movie interest local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.amf.user.profile.service.MovieInterestLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author andrefabbro
 * @see com.amf.user.profile.service.base.MovieInterestLocalServiceBaseImpl
 * @see com.amf.user.profile.service.MovieInterestLocalServiceUtil
 */
public class MovieInterestLocalServiceImpl
	extends MovieInterestLocalServiceBaseImpl {

	public MovieInterest getByUserId(long userId)
		throws SystemException {

		return this.movieInterestPersistence.fetchByUserId(userId);
	}

	public MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, String userName,
		String favoriteMovie, String favoriteGenre, String leastFavMovie,
		String favoriteActor)
		throws SystemException {

		long movieInterestId =
			counterLocalService.increment(MovieInterest.class.getName());

		MovieInterest movieInterest =
			movieInterestPersistence.create(movieInterestId);

		movieInterest.setGroupId(groupId);
		movieInterest.setCompanyId(companyId);
		movieInterest.setUserId(userId);
		movieInterest.setUserName(userName);
		movieInterest.setCreateDate(new Date());
		movieInterest.setFavoriteMovie(favoriteMovie);
		movieInterest.setFavoriteGenre(favoriteGenre);
		movieInterest.setLeastFavMovie(leastFavMovie);
		movieInterest.setFavoriteActor(favoriteActor);

		movieInterest = movieInterestPersistence.update(movieInterest);

		try {
			resourceLocalService.addResources(
				movieInterest.getCompanyId(), movieInterest.getGroupId(),
				movieInterest.getUserId(), MovieInterest.class.getName(),
				movieInterest.getMovieInterestId(), false, true, true);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}

		reindex(movieInterest);

		return movieInterest;
	}

	public MovieInterest updateMovieInterest(
		long movieInterestId, String favoriteMovie, String favoriteGenre,
		String leastFavMovie, String favoriteActor)
		throws SystemException {

		MovieInterest movieInterest =
			movieInterestPersistence.fetchByPrimaryKey(movieInterestId);

		movieInterest.setModifiedDate(new Date());

		movieInterest.setFavoriteMovie(favoriteMovie);
		movieInterest.setFavoriteGenre(favoriteGenre);
		movieInterest.setLeastFavMovie(leastFavMovie);
		movieInterest.setFavoriteActor(favoriteActor);

		movieInterest = movieInterestPersistence.update(movieInterest);

		reindex(movieInterest);

		return movieInterest;
	}

	private void reindex(MovieInterest movieInterest) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(MovieInterest.class);
		try {
			indexer.reindex(movieInterest);
		}
		catch (SearchException e) {
			System.out.println("Search Exception: " + e.getMessage());
		}
	}

}
