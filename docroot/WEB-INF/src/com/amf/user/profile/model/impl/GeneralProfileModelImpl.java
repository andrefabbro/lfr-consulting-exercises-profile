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

package com.amf.user.profile.model.impl;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.GeneralProfileModel;
import com.amf.user.profile.model.GeneralProfileSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the GeneralProfile service. Represents a row in the &quot;UserProfile_GeneralProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.amf.user.profile.model.GeneralProfileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GeneralProfileImpl}.
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfileImpl
 * @see com.amf.user.profile.model.GeneralProfile
 * @see com.amf.user.profile.model.GeneralProfileModel
 * @generated
 */
@JSON(strict = true)
public class GeneralProfileModelImpl extends BaseModelImpl<GeneralProfile>
	implements GeneralProfileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a general profile model instance should use the {@link com.amf.user.profile.model.GeneralProfile} interface instead.
	 */
	public static final String TABLE_NAME = "UserProfile_GeneralProfile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "generalProfileId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "aboutMe", Types.VARCHAR },
			{ "favoriteQuotes", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table UserProfile_GeneralProfile (generalProfileId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,aboutMe TEXT null,favoriteQuotes TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table UserProfile_GeneralProfile";
	public static final String ORDER_BY_JPQL = " ORDER BY generalProfile.generalProfileId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY UserProfile_GeneralProfile.generalProfileId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.amf.user.profile.model.GeneralProfile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.amf.user.profile.model.GeneralProfile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.amf.user.profile.model.GeneralProfile"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;
	public static long GENERALPROFILEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static GeneralProfile toModel(GeneralProfileSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		GeneralProfile model = new GeneralProfileImpl();

		model.setGeneralProfileId(soapModel.getGeneralProfileId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAboutMe(soapModel.getAboutMe());
		model.setFavoriteQuotes(soapModel.getFavoriteQuotes());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<GeneralProfile> toModels(GeneralProfileSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<GeneralProfile> models = new ArrayList<GeneralProfile>(soapModels.length);

		for (GeneralProfileSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.amf.user.profile.model.GeneralProfile"));

	public GeneralProfileModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _generalProfileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGeneralProfileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _generalProfileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public long getGeneralProfileId() {
		return _generalProfileId;
	}

	@Override
	public void setGeneralProfileId(long generalProfileId) {
		_generalProfileId = generalProfileId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getAboutMe() {
		if (_aboutMe == null) {
			return StringPool.BLANK;
		}
		else {
			return _aboutMe;
		}
	}

	@Override
	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	@JSON
	@Override
	public String getFavoriteQuotes() {
		if (_favoriteQuotes == null) {
			return StringPool.BLANK;
		}
		else {
			return _favoriteQuotes;
		}
	}

	@Override
	public void setFavoriteQuotes(String favoriteQuotes) {
		_favoriteQuotes = favoriteQuotes;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			GeneralProfile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GeneralProfile toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GeneralProfile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GeneralProfileImpl generalProfileImpl = new GeneralProfileImpl();

		generalProfileImpl.setGeneralProfileId(getGeneralProfileId());
		generalProfileImpl.setGroupId(getGroupId());
		generalProfileImpl.setCompanyId(getCompanyId());
		generalProfileImpl.setUserId(getUserId());
		generalProfileImpl.setUserName(getUserName());
		generalProfileImpl.setCreateDate(getCreateDate());
		generalProfileImpl.setModifiedDate(getModifiedDate());
		generalProfileImpl.setAboutMe(getAboutMe());
		generalProfileImpl.setFavoriteQuotes(getFavoriteQuotes());

		generalProfileImpl.resetOriginalValues();

		return generalProfileImpl;
	}

	@Override
	public int compareTo(GeneralProfile generalProfile) {
		long primaryKey = generalProfile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneralProfile)) {
			return false;
		}

		GeneralProfile generalProfile = (GeneralProfile)obj;

		long primaryKey = generalProfile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		GeneralProfileModelImpl generalProfileModelImpl = this;

		generalProfileModelImpl._originalUserId = generalProfileModelImpl._userId;

		generalProfileModelImpl._setOriginalUserId = false;

		generalProfileModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GeneralProfile> toCacheModel() {
		GeneralProfileCacheModel generalProfileCacheModel = new GeneralProfileCacheModel();

		generalProfileCacheModel.generalProfileId = getGeneralProfileId();

		generalProfileCacheModel.groupId = getGroupId();

		generalProfileCacheModel.companyId = getCompanyId();

		generalProfileCacheModel.userId = getUserId();

		generalProfileCacheModel.userName = getUserName();

		String userName = generalProfileCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			generalProfileCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			generalProfileCacheModel.createDate = createDate.getTime();
		}
		else {
			generalProfileCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			generalProfileCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			generalProfileCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		generalProfileCacheModel.aboutMe = getAboutMe();

		String aboutMe = generalProfileCacheModel.aboutMe;

		if ((aboutMe != null) && (aboutMe.length() == 0)) {
			generalProfileCacheModel.aboutMe = null;
		}

		generalProfileCacheModel.favoriteQuotes = getFavoriteQuotes();

		String favoriteQuotes = generalProfileCacheModel.favoriteQuotes;

		if ((favoriteQuotes != null) && (favoriteQuotes.length() == 0)) {
			generalProfileCacheModel.favoriteQuotes = null;
		}

		return generalProfileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{generalProfileId=");
		sb.append(getGeneralProfileId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", aboutMe=");
		sb.append(getAboutMe());
		sb.append(", favoriteQuotes=");
		sb.append(getFavoriteQuotes());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.amf.user.profile.model.GeneralProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>generalProfileId</column-name><column-value><![CDATA[");
		sb.append(getGeneralProfileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aboutMe</column-name><column-value><![CDATA[");
		sb.append(getAboutMe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>favoriteQuotes</column-name><column-value><![CDATA[");
		sb.append(getFavoriteQuotes());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = GeneralProfile.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GeneralProfile.class
		};
	private long _generalProfileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _aboutMe;
	private String _favoriteQuotes;
	private long _columnBitmask;
	private GeneralProfile _escapedModel;
}