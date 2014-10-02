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

package com.amf.user.profile.service.persistence;

import com.amf.user.profile.model.MovieInterest;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the movie interest service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see MovieInterestPersistenceImpl
 * @see MovieInterestUtil
 * @generated
 */
public interface MovieInterestPersistence extends BasePersistence<MovieInterest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MovieInterestUtil} to access the movie interest persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the movie interest where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching movie interest
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest findByUserId(long userId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the movie interest where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the movie interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest removeByUserId(long userId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of movie interests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching movie interests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the movie interest in the entity cache if it is enabled.
	*
	* @param movieInterest the movie interest
	*/
	public void cacheResult(
		com.amf.user.profile.model.MovieInterest movieInterest);

	/**
	* Caches the movie interests in the entity cache if it is enabled.
	*
	* @param movieInterests the movie interests
	*/
	public void cacheResult(
		java.util.List<com.amf.user.profile.model.MovieInterest> movieInterests);

	/**
	* Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	*
	* @param movieInterestId the primary key for the new movie interest
	* @return the new movie interest
	*/
	public com.amf.user.profile.model.MovieInterest create(long movieInterestId);

	/**
	* Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest that was removed
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest remove(long movieInterestId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.user.profile.model.MovieInterest updateImpl(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the movie interest with the primary key or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest findByPrimaryKey(
		long movieInterestId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the movie interest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest, or <code>null</code> if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.MovieInterest fetchByPrimaryKey(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the movie interests.
	*
	* @return the movie interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.user.profile.model.MovieInterest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the movie interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movie interests
	* @param end the upper bound of the range of movie interests (not inclusive)
	* @return the range of movie interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.user.profile.model.MovieInterest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the movie interests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of movie interests
	* @param end the upper bound of the range of movie interests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of movie interests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.user.profile.model.MovieInterest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the movie interests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of movie interests.
	*
	* @return the number of movie interests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}