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

package com.amf.user.profile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeneralProfile}.
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfile
 * @generated
 */
public class GeneralProfileWrapper implements GeneralProfile,
	ModelWrapper<GeneralProfile> {
	public GeneralProfileWrapper(GeneralProfile generalProfile) {
		_generalProfile = generalProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return GeneralProfile.class;
	}

	@Override
	public String getModelClassName() {
		return GeneralProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("generalProfileId", getGeneralProfileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("aboutMe", getAboutMe());
		attributes.put("favoriteQuotes", getFavoriteQuotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long generalProfileId = (Long)attributes.get("generalProfileId");

		if (generalProfileId != null) {
			setGeneralProfileId(generalProfileId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String aboutMe = (String)attributes.get("aboutMe");

		if (aboutMe != null) {
			setAboutMe(aboutMe);
		}

		String favoriteQuotes = (String)attributes.get("favoriteQuotes");

		if (favoriteQuotes != null) {
			setFavoriteQuotes(favoriteQuotes);
		}
	}

	/**
	* Returns the primary key of this general profile.
	*
	* @return the primary key of this general profile
	*/
	@Override
	public long getPrimaryKey() {
		return _generalProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this general profile.
	*
	* @param primaryKey the primary key of this general profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_generalProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the general profile ID of this general profile.
	*
	* @return the general profile ID of this general profile
	*/
	@Override
	public long getGeneralProfileId() {
		return _generalProfile.getGeneralProfileId();
	}

	/**
	* Sets the general profile ID of this general profile.
	*
	* @param generalProfileId the general profile ID of this general profile
	*/
	@Override
	public void setGeneralProfileId(long generalProfileId) {
		_generalProfile.setGeneralProfileId(generalProfileId);
	}

	/**
	* Returns the group ID of this general profile.
	*
	* @return the group ID of this general profile
	*/
	@Override
	public long getGroupId() {
		return _generalProfile.getGroupId();
	}

	/**
	* Sets the group ID of this general profile.
	*
	* @param groupId the group ID of this general profile
	*/
	@Override
	public void setGroupId(long groupId) {
		_generalProfile.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this general profile.
	*
	* @return the company ID of this general profile
	*/
	@Override
	public long getCompanyId() {
		return _generalProfile.getCompanyId();
	}

	/**
	* Sets the company ID of this general profile.
	*
	* @param companyId the company ID of this general profile
	*/
	@Override
	public void setCompanyId(long companyId) {
		_generalProfile.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this general profile.
	*
	* @return the user ID of this general profile
	*/
	@Override
	public long getUserId() {
		return _generalProfile.getUserId();
	}

	/**
	* Sets the user ID of this general profile.
	*
	* @param userId the user ID of this general profile
	*/
	@Override
	public void setUserId(long userId) {
		_generalProfile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this general profile.
	*
	* @return the user uuid of this general profile
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalProfile.getUserUuid();
	}

	/**
	* Sets the user uuid of this general profile.
	*
	* @param userUuid the user uuid of this general profile
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_generalProfile.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this general profile.
	*
	* @return the user name of this general profile
	*/
	@Override
	public java.lang.String getUserName() {
		return _generalProfile.getUserName();
	}

	/**
	* Sets the user name of this general profile.
	*
	* @param userName the user name of this general profile
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_generalProfile.setUserName(userName);
	}

	/**
	* Returns the create date of this general profile.
	*
	* @return the create date of this general profile
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _generalProfile.getCreateDate();
	}

	/**
	* Sets the create date of this general profile.
	*
	* @param createDate the create date of this general profile
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_generalProfile.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this general profile.
	*
	* @return the modified date of this general profile
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _generalProfile.getModifiedDate();
	}

	/**
	* Sets the modified date of this general profile.
	*
	* @param modifiedDate the modified date of this general profile
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_generalProfile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the about me of this general profile.
	*
	* @return the about me of this general profile
	*/
	@Override
	public java.lang.String getAboutMe() {
		return _generalProfile.getAboutMe();
	}

	/**
	* Sets the about me of this general profile.
	*
	* @param aboutMe the about me of this general profile
	*/
	@Override
	public void setAboutMe(java.lang.String aboutMe) {
		_generalProfile.setAboutMe(aboutMe);
	}

	/**
	* Returns the favorite quotes of this general profile.
	*
	* @return the favorite quotes of this general profile
	*/
	@Override
	public java.lang.String getFavoriteQuotes() {
		return _generalProfile.getFavoriteQuotes();
	}

	/**
	* Sets the favorite quotes of this general profile.
	*
	* @param favoriteQuotes the favorite quotes of this general profile
	*/
	@Override
	public void setFavoriteQuotes(java.lang.String favoriteQuotes) {
		_generalProfile.setFavoriteQuotes(favoriteQuotes);
	}

	@Override
	public boolean isNew() {
		return _generalProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_generalProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _generalProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_generalProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _generalProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _generalProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_generalProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _generalProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_generalProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_generalProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_generalProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneralProfileWrapper((GeneralProfile)_generalProfile.clone());
	}

	@Override
	public int compareTo(
		com.amf.user.profile.model.GeneralProfile generalProfile) {
		return _generalProfile.compareTo(generalProfile);
	}

	@Override
	public int hashCode() {
		return _generalProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.amf.user.profile.model.GeneralProfile> toCacheModel() {
		return _generalProfile.toCacheModel();
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile toEscapedModel() {
		return new GeneralProfileWrapper(_generalProfile.toEscapedModel());
	}

	@Override
	public com.amf.user.profile.model.GeneralProfile toUnescapedModel() {
		return new GeneralProfileWrapper(_generalProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _generalProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _generalProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_generalProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneralProfileWrapper)) {
			return false;
		}

		GeneralProfileWrapper generalProfileWrapper = (GeneralProfileWrapper)obj;

		if (Validator.equals(_generalProfile,
					generalProfileWrapper._generalProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneralProfile getWrappedGeneralProfile() {
		return _generalProfile;
	}

	@Override
	public GeneralProfile getWrappedModel() {
		return _generalProfile;
	}

	@Override
	public void resetOriginalValues() {
		_generalProfile.resetOriginalValues();
	}

	private GeneralProfile _generalProfile;
}