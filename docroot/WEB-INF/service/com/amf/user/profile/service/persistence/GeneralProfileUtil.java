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

import com.amf.user.profile.model.GeneralProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the general profile service. This utility wraps {@link GeneralProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfilePersistence
 * @see GeneralProfilePersistenceImpl
 * @generated
 */
public class GeneralProfileUtil {
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
	public static void clearCache(GeneralProfile generalProfile) {
		getPersistence().clearCache(generalProfile);
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
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeneralProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeneralProfile update(GeneralProfile generalProfile)
		throws SystemException {
		return getPersistence().update(generalProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeneralProfile update(GeneralProfile generalProfile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(generalProfile, serviceContext);
	}

	/**
	* Returns the general profile where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching general profile
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile findByUserId(
		long userId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile fetchByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the general profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the general profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile removeByUserId(
		long userId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of general profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching general profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the general profile in the entity cache if it is enabled.
	*
	* @param generalProfile the general profile
	*/
	public static void cacheResult(
		com.amf.user.profile.model.GeneralProfile generalProfile) {
		getPersistence().cacheResult(generalProfile);
	}

	/**
	* Caches the general profiles in the entity cache if it is enabled.
	*
	* @param generalProfiles the general profiles
	*/
	public static void cacheResult(
		java.util.List<com.amf.user.profile.model.GeneralProfile> generalProfiles) {
		getPersistence().cacheResult(generalProfiles);
	}

	/**
	* Creates a new general profile with the primary key. Does not add the general profile to the database.
	*
	* @param generalProfileId the primary key for the new general profile
	* @return the new general profile
	*/
	public static com.amf.user.profile.model.GeneralProfile create(
		long generalProfileId) {
		return getPersistence().create(generalProfileId);
	}

	/**
	* Removes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile that was removed
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile remove(
		long generalProfileId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(generalProfileId);
	}

	public static com.amf.user.profile.model.GeneralProfile updateImpl(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(generalProfile);
	}

	/**
	* Returns the general profile with the primary key or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile findByPrimaryKey(
		long generalProfileId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(generalProfileId);
	}

	/**
	* Returns the general profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile, or <code>null</code> if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.user.profile.model.GeneralProfile fetchByPrimaryKey(
		long generalProfileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(generalProfileId);
	}

	/**
	* Returns all the general profiles.
	*
	* @return the general profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.user.profile.model.GeneralProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the general profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general profiles
	* @param end the upper bound of the range of general profiles (not inclusive)
	* @return the range of general profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.user.profile.model.GeneralProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the general profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general profiles
	* @param end the upper bound of the range of general profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of general profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.user.profile.model.GeneralProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the general profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of general profiles.
	*
	* @return the number of general profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeneralProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeneralProfilePersistence)PortletBeanLocatorUtil.locate(com.amf.user.profile.service.ClpSerializer.getServletContextName(),
					GeneralProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(GeneralProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeneralProfilePersistence persistence) {
	}

	private static GeneralProfilePersistence _persistence;
}