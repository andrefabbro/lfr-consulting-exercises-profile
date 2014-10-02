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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the movie interest service. This utility wraps {@link MovieInterestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see MovieInterestPersistence
 * @see MovieInterestPersistenceImpl
 * @generated
 */
public class MovieInterestUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MovieInterest movieInterest) {
		getPersistence().clearCache(movieInterest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MovieInterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MovieInterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MovieInterest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MovieInterest update(MovieInterest movieInterest)
		throws SystemException {
		return getPersistence().update(movieInterest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MovieInterest update(MovieInterest movieInterest,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(movieInterest, serviceContext);
	}

	/**
	* Returns the movie interest where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching movie interest
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest findByUserId(
		long userId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the movie interest where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching movie interest, or <code>null</code> if a matching movie interest could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the movie interest where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the movie interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest removeByUserId(
		long userId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of movie interests where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching movie interests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the movie interest in the entity cache if it is enabled.
	*
	* @param movieInterest the movie interest
	*/
	public static void cacheResult(
		com.amf.user.profile.model.MovieInterest movieInterest) {
		getPersistence().cacheResult(movieInterest);
	}

	/**
	* Caches the movie interests in the entity cache if it is enabled.
	*
	* @param movieInterests the movie interests
	*/
	public static void cacheResult(
		java.util.List<com.amf.user.profile.model.MovieInterest> movieInterests) {
		getPersistence().cacheResult(movieInterests);
	}

	/**
	* Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	*
	* @param movieInterestId the primary key for the new movie interest
	* @return the new movie interest
	*/
	public static com.amf.user.profile.model.MovieInterest create(
		long movieInterestId) {
		return getPersistence().create(movieInterestId);
	}

	/**
	* Removes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest that was removed
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest remove(
		long movieInterestId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(movieInterestId);
	}

	public static com.amf.user.profile.model.MovieInterest updateImpl(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(movieInterest);
	}

	/**
	* Returns the movie interest with the primary key or throws a {@link com.amf.user.profile.NoSuchMovieInterestException} if it could not be found.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest
	* @throws com.amf.user.profile.NoSuchMovieInterestException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest findByPrimaryKey(
		long movieInterestId)
		throws com.amf.user.profile.NoSuchMovieInterestException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(movieInterestId);
	}

	/**
	* Returns the movie interest with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest, or <code>null</code> if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest fetchByPrimaryKey(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(movieInterestId);
	}

	/**
	* Returns all the movie interests.
	*
	* @return the movie interests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.user.profile.model.MovieInterest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.amf.user.profile.model.MovieInterest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.amf.user.profile.model.MovieInterest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the movie interests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of movie interests.
	*
	* @return the number of movie interests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MovieInterestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MovieInterestPersistence)PortletBeanLocatorUtil.locate(com.amf.user.profile.service.ClpSerializer.getServletContextName(),
					MovieInterestPersistence.class.getName());

			ReferenceRegistry.registerReference(MovieInterestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MovieInterestPersistence persistence) {
	}

	private static MovieInterestPersistence _persistence;
}