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
 * Provides a wrapper for {@link GeneralProfileLocalService}.
 *
 * @author andrefabbro
 * @see GeneralProfileLocalService
 * @generated
 */
public class GeneralProfileLocalServiceWrapper
	implements GeneralProfileLocalService,
		ServiceWrapper<GeneralProfileLocalService> {
	public GeneralProfileLocalServiceWrapper(
		GeneralProfileLocalService generalProfileLocalService) {
		_generalProfileLocalService = generalProfileLocalService;
	}

	/**
	* Adds the general profile to the database. Also notifies the appropriate model listeners.
	*
	* @param generalProfile the general profile
	* @return the general profile that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.addGeneralProfile(generalProfile);
	}

	/**
	* Creates a new general profile with the primary key. Does not add the general profile to the database.
	*
	* @param generalProfileId the primary key for the new general profile
	* @return the new general profile
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile createGeneralProfile(
		long generalProfileId) {
		return _generalProfileLocalService.createGeneralProfile(generalProfileId);
	}

	/**
	* Deletes the general profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile that was removed
	* @throws PortalException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile deleteGeneralProfile(
		long generalProfileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.deleteGeneralProfile(generalProfileId);
	}

	/**
	* Deletes the general profile from the database. Also notifies the appropriate model listeners.
	*
	* @param generalProfile the general profile
	* @return the general profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile deleteGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.deleteGeneralProfile(generalProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _generalProfileLocalService.dynamicQuery();
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
		return _generalProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _generalProfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _generalProfileLocalService.dynamicQuery(dynamicQuery, start,
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
		return _generalProfileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _generalProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile fetchGeneralProfile(
		long generalProfileId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.fetchGeneralProfile(generalProfileId);
	}

	/**
	* Returns the general profile with the primary key.
	*
	* @param generalProfileId the primary key of the general profile
	* @return the general profile
	* @throws PortalException if a general profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile getGeneralProfile(
		long generalProfileId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.getGeneralProfile(generalProfileId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.amf.user.profile.model.GeneralProfile> getGeneralProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.getGeneralProfiles(start, end);
	}

	/**
	* Returns the number of general profiles.
	*
	* @return the number of general profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeneralProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.getGeneralProfilesCount();
	}

	/**
	* Updates the general profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param generalProfile the general profile
	* @return the general profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
		com.amf.user.profile.model.GeneralProfile generalProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.updateGeneralProfile(generalProfile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _generalProfileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_generalProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _generalProfileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile getByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.getByUserId(userId);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile addGeneralProfile(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String aboutMe, java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.addGeneralProfile(groupId,
			companyId, userId, userName, aboutMe, favoriteQuotes);
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile updateGeneralProfile(
		long generalProfileId, java.lang.String aboutMe,
		java.lang.String favoriteQuotes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfileLocalService.updateGeneralProfile(generalProfileId,
			aboutMe, favoriteQuotes);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneralProfileLocalService getWrappedGeneralProfileLocalService() {
		return _generalProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneralProfileLocalService(
		GeneralProfileLocalService generalProfileLocalService) {
		_generalProfileLocalService = generalProfileLocalService;
	}

	@Override
	public GeneralProfileLocalService getWrappedService() {
		return _generalProfileLocalService;
	}

	@Override
	public void setWrappedService(
		GeneralProfileLocalService generalProfileLocalService) {
		_generalProfileLocalService = generalProfileLocalService;
	}

	private GeneralProfileLocalService _generalProfileLocalService;
}