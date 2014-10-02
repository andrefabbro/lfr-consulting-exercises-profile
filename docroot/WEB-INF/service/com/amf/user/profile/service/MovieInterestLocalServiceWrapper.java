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
 * Provides a wrapper for {@link MovieInterestLocalService}.
 *
 * @author andrefabbro
 * @see MovieInterestLocalService
 * @generated
 */
public class MovieInterestLocalServiceWrapper
	implements MovieInterestLocalService,
		ServiceWrapper<MovieInterestLocalService> {
	public MovieInterestLocalServiceWrapper(
		MovieInterestLocalService movieInterestLocalService) {
		_movieInterestLocalService = movieInterestLocalService;
	}

	/**
	* Adds the movie interest to the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest addMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.addMovieInterest(movieInterest);
	}

	/**
	* Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	*
	* @param movieInterestId the primary key for the new movie interest
	* @return the new movie interest
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest createMovieInterest(
		long movieInterestId) {
		return _movieInterestLocalService.createMovieInterest(movieInterestId);
	}

	/**
	* Deletes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest that was removed
	* @throws PortalException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest deleteMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.deleteMovieInterest(movieInterestId);
	}

	/**
	* Deletes the movie interest from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest deleteMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.deleteMovieInterest(movieInterest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _movieInterestLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.MovieInterestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest fetchMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.fetchMovieInterest(movieInterestId);
	}

	/**
	* Returns the movie interest with the primary key.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest
	* @throws PortalException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest getMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.getMovieInterest(movieInterestId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.amf.user.profile.model.MovieInterest> getMovieInterests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.getMovieInterests(start, end);
	}

	/**
	* Returns the number of movie interests.
	*
	* @return the number of movie interests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMovieInterestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.getMovieInterestsCount();
	}

	/**
	* Updates the movie interest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.MovieInterest updateMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.updateMovieInterest(movieInterest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _movieInterestLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_movieInterestLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _movieInterestLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest getByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.getByUserId(userId);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String favoriteMovie, java.lang.String favoriteGenre,
		java.lang.String leastFavMovie, java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.addMovieInterest(groupId, companyId,
			userId, userName, favoriteMovie, favoriteGenre, leastFavMovie,
			favoriteActor);
	}

	@Override
	public com.amf.user.profile.model.MovieInterest updateMovieInterest(
		long movieInterestId, java.lang.String favoriteMovie,
		java.lang.String favoriteGenre, java.lang.String leastFavMovie,
		java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterestLocalService.updateMovieInterest(movieInterestId,
			favoriteMovie, favoriteGenre, leastFavMovie, favoriteActor);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MovieInterestLocalService getWrappedMovieInterestLocalService() {
		return _movieInterestLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMovieInterestLocalService(
		MovieInterestLocalService movieInterestLocalService) {
		_movieInterestLocalService = movieInterestLocalService;
	}

	@Override
	public MovieInterestLocalService getWrappedService() {
		return _movieInterestLocalService;
	}

	@Override
	public void setWrappedService(
		MovieInterestLocalService movieInterestLocalService) {
		_movieInterestLocalService = movieInterestLocalService;
	}

	private MovieInterestLocalService _movieInterestLocalService;
}