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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the GeneralProfile service. Represents a row in the &quot;UserProfile_GeneralProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.amf.user.profile.model.impl.GeneralProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.amf.user.profile.model.impl.GeneralProfileImpl}.
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfile
 * @see com.amf.user.profile.model.impl.GeneralProfileImpl
 * @see com.amf.user.profile.model.impl.GeneralProfileModelImpl
 * @generated
 */
public interface GeneralProfileModel extends BaseModel<GeneralProfile>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a general profile model instance should use the {@link GeneralProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this general profile.
	 *
	 * @return the primary key of this general profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this general profile.
	 *
	 * @param primaryKey the primary key of this general profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the general profile ID of this general profile.
	 *
	 * @return the general profile ID of this general profile
	 */
	public long getGeneralProfileId();

	/**
	 * Sets the general profile ID of this general profile.
	 *
	 * @param generalProfileId the general profile ID of this general profile
	 */
	public void setGeneralProfileId(long generalProfileId);

	/**
	 * Returns the group ID of this general profile.
	 *
	 * @return the group ID of this general profile
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this general profile.
	 *
	 * @param groupId the group ID of this general profile
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this general profile.
	 *
	 * @return the company ID of this general profile
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this general profile.
	 *
	 * @param companyId the company ID of this general profile
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this general profile.
	 *
	 * @return the user ID of this general profile
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this general profile.
	 *
	 * @param userId the user ID of this general profile
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this general profile.
	 *
	 * @return the user uuid of this general profile
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this general profile.
	 *
	 * @param userUuid the user uuid of this general profile
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this general profile.
	 *
	 * @return the user name of this general profile
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this general profile.
	 *
	 * @param userName the user name of this general profile
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this general profile.
	 *
	 * @return the create date of this general profile
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this general profile.
	 *
	 * @param createDate the create date of this general profile
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this general profile.
	 *
	 * @return the modified date of this general profile
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this general profile.
	 *
	 * @param modifiedDate the modified date of this general profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the about me of this general profile.
	 *
	 * @return the about me of this general profile
	 */
	@AutoEscape
	public String getAboutMe();

	/**
	 * Sets the about me of this general profile.
	 *
	 * @param aboutMe the about me of this general profile
	 */
	public void setAboutMe(String aboutMe);

	/**
	 * Returns the favorite quotes of this general profile.
	 *
	 * @return the favorite quotes of this general profile
	 */
	@AutoEscape
	public String getFavoriteQuotes();

	/**
	 * Sets the favorite quotes of this general profile.
	 *
	 * @param favoriteQuotes the favorite quotes of this general profile
	 */
	public void setFavoriteQuotes(String favoriteQuotes);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(GeneralProfile generalProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GeneralProfile> toCacheModel();

	@Override
	public GeneralProfile toEscapedModel();

	@Override
	public GeneralProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}