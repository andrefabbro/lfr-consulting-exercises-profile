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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the general profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfilePersistenceImpl
 * @see GeneralProfileUtil
 * @generated
 */
public interface GeneralProfilePersistence extends BasePersistence<GeneralProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeneralProfileUtil} to access the general profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the general profile where userId = &#63; or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching general profile
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile findByUserId(long userId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general profile where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching general profile, or <code>null</code> if a matching general profile could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile fetchByUserId(
		long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the general profile where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the general profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile removeByUserId(long userId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general profiles where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching general profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the general profile in the entity cache if it is enabled.
	*
	* @param generalProfile the general profile
	*/
	public void cacheResult(
		com.amf.user.profile.model.GeneralProfile generalProfile);

	/**
	* Caches the general profiles in the entity cache if it is enabled.
	*
	* @param generalProfiles the general profiles
	*/
	public void cacheResult(
		java.util.List<com.amf.user.profile.model.GeneralProfile> generalProfiles);

	/**
	* Creates a new general profile with the primary key. Does not add the general profile to the database.
	*
	* @param generalProfileId the primary key for the new general profile
	* @return the new general profile
	*/
	public com.amf.user.profile.model.GeneralProfile create(
		long generalProfileId);

	/**
	* Removes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile that was removed
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile remove(
		long generalProfileId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.user.profile.model.GeneralProfile updateImpl(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general profile with the primary key or throws a {@link com.amf.user.profile.NoSuchGeneralProfileException} if it could not be found.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile
	* @throws com.amf.user.profile.NoSuchGeneralProfileException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile findByPrimaryKey(
		long generalProfileId)
		throws com.amf.user.profile.NoSuchGeneralProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile, or <code>null</code> if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.user.profile.model.GeneralProfile fetchByPrimaryKey(
		long generalProfileId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the general profiles.
	*
	* @return the general profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.user.profile.model.GeneralProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.user.profile.model.GeneralProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.user.profile.model.GeneralProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the general profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general profiles.
	*
	* @return the number of general profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}