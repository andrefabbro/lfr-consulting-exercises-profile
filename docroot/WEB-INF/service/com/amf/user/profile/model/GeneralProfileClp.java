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

import com.amf.user.profile.service.ClpSerializer;
import com.amf.user.profile.service.GeneralProfileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author andrefabbro
 */
public class GeneralProfileClp extends BaseModelImpl<GeneralProfile>
	implements GeneralProfile {
	public GeneralProfileClp() {
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

	@Override
	public long getGeneralProfileId() {
		return _generalProfileId;
	}

	@Override
	public void setGeneralProfileId(long generalProfileId) {
		_generalProfileId = generalProfileId;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneralProfileId",
						long.class);

				method.invoke(_generalProfileRemoteModel, generalProfileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_generalProfileRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_generalProfileRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_generalProfileRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_generalProfileRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_generalProfileRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_generalProfileRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAboutMe() {
		return _aboutMe;
	}

	@Override
	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setAboutMe", String.class);

				method.invoke(_generalProfileRemoteModel, aboutMe);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFavoriteQuotes() {
		return _favoriteQuotes;
	}

	@Override
	public void setFavoriteQuotes(String favoriteQuotes) {
		_favoriteQuotes = favoriteQuotes;

		if (_generalProfileRemoteModel != null) {
			try {
				Class<?> clazz = _generalProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFavoriteQuotes",
						String.class);

				method.invoke(_generalProfileRemoteModel, favoriteQuotes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneralProfileRemoteModel() {
		return _generalProfileRemoteModel;
	}

	public void setGeneralProfileRemoteModel(
		BaseModel<?> generalProfileRemoteModel) {
		_generalProfileRemoteModel = generalProfileRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _generalProfileRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_generalProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneralProfileLocalServiceUtil.addGeneralProfile(this);
		}
		else {
			GeneralProfileLocalServiceUtil.updateGeneralProfile(this);
		}
	}

	@Override
	public GeneralProfile toEscapedModel() {
		return (GeneralProfile)ProxyUtil.newProxyInstance(GeneralProfile.class.getClassLoader(),
			new Class[] { GeneralProfile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneralProfileClp clone = new GeneralProfileClp();

		clone.setGeneralProfileId(getGeneralProfileId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAboutMe(getAboutMe());
		clone.setFavoriteQuotes(getFavoriteQuotes());

		return clone;
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

		if (!(obj instanceof GeneralProfileClp)) {
			return false;
		}

		GeneralProfileClp generalProfile = (GeneralProfileClp)obj;

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

	private long _generalProfileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _aboutMe;
	private String _favoriteQuotes;
	private BaseModel<?> _generalProfileRemoteModel;
}