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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MovieInterest. This utility wraps
 * {@link com.amf.user.profile.service.impl.MovieInterestLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author andrefabbro
 * @see MovieInterestLocalService
 * @see com.amf.user.profile.service.base.MovieInterestLocalServiceBaseImpl
 * @see com.amf.user.profile.service.impl.MovieInterestLocalServiceImpl
 * @generated
 */
public class MovieInterestLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.amf.user.profile.service.impl.MovieInterestLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the movie interest to the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest addMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMovieInterest(movieInterest);
	}

	/**
	* Creates a new movie interest with the primary key. Does not add the movie interest to the database.
	*
	* @param movieInterestId the primary key for the new movie interest
	* @return the new movie interest
	*/
	public static com.amf.user.profile.model.MovieInterest createMovieInterest(
		long movieInterestId) {
		return getService().createMovieInterest(movieInterestId);
	}

	/**
	* Deletes the movie interest with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest that was removed
	* @throws PortalException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest deleteMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMovieInterest(movieInterestId);
	}

	/**
	* Deletes the movie interest from the database. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest deleteMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMovieInterest(movieInterest);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.amf.user.profile.model.MovieInterest fetchMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMovieInterest(movieInterestId);
	}

	/**
	* Returns the movie interest with the primary key.
	*
	* @param movieInterestId the primary key of the movie interest
	* @return the movie interest
	* @throws PortalException if a movie interest with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest getMovieInterest(
		long movieInterestId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMovieInterest(movieInterestId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.amf.user.profile.model.MovieInterest> getMovieInterests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMovieInterests(start, end);
	}

	/**
	* Returns the number of movie interests.
	*
	* @return the number of movie interests
	* @throws SystemException if a system exception occurred
	*/
	public static int getMovieInterestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMovieInterestsCount();
	}

	/**
	* Updates the movie interest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param movieInterest the movie interest
	* @return the movie interest that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.MovieInterest updateMovieInterest(
		com.amf.user.profile.model.MovieInterest movieInterest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMovieInterest(movieInterest);
	}

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
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByUserId(userId);
	}

	public static com.amf.user.profile.model.MovieInterest addMovieInterest(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String favoriteMovie, java.lang.String favoriteGenre,
		java.lang.String leastFavMovie, java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMovieInterest(groupId, companyId, userId, userName,
			favoriteMovie, favoriteGenre, leastFavMovie, favoriteActor);
	}

	public static com.amf.user.profile.model.MovieInterest updateMovieInterest(
		long movieInterestId, java.lang.String favoriteMovie,
		java.lang.String favoriteGenre, java.lang.String leastFavMovie,
		java.lang.String favoriteActor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMovieInterest(movieInterestId, favoriteMovie,
			favoriteGenre, leastFavMovie, favoriteActor);
	}

	public static void clearService() {
		_service = null;
	}

	public static MovieInterestLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MovieInterestLocalService.class.getName());

			if (invokableLocalService instanceof MovieInterestLocalService) {
				_service = (MovieInterestLocalService)invokableLocalService;
			}
			else {
				_service = new MovieInterestLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MovieInterestLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MovieInterestLocalService service) {
	}

	private static MovieInterestLocalService _service;
}