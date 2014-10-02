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
import com.amf.user.profile.service.MovieInterestLocalServiceUtil;

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
public class MovieInterestClp extends BaseModelImpl<MovieInterest>
	implements MovieInterest {
	public MovieInterestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MovieInterest.class;
	}

	@Override
	public String getModelClassName() {
		return MovieInterest.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _movieInterestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMovieInterestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _movieInterestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("movieInterestId", getMovieInterestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("favoriteMovie", getFavoriteMovie());
		attributes.put("favoriteGenre", getFavoriteGenre());
		attributes.put("leastFavMovie", getLeastFavMovie());
		attributes.put("favoriteActor", getFavoriteActor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long movieInterestId = (Long)attributes.get("movieInterestId");

		if (movieInterestId != null) {
			setMovieInterestId(movieInterestId);
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

		String favoriteMovie = (String)attributes.get("favoriteMovie");

		if (favoriteMovie != null) {
			setFavoriteMovie(favoriteMovie);
		}

		String favoriteGenre = (String)attributes.get("favoriteGenre");

		if (favoriteGenre != null) {
			setFavoriteGenre(favoriteGenre);
		}

		String leastFavMovie = (String)attributes.get("leastFavMovie");

		if (leastFavMovie != null) {
			setLeastFavMovie(leastFavMovie);
		}

		String favoriteActor = (String)attributes.get("favoriteActor");

		if (favoriteActor != null) {
			setFavoriteActor(favoriteActor);
		}
	}

	@Override
	public long getMovieInterestId() {
		return _movieInterestId;
	}

	@Override
	public void setMovieInterestId(long movieInterestId) {
		_movieInterestId = movieInterestId;

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setMovieInterestId", long.class);

				method.invoke(_movieInterestRemoteModel, movieInterestId);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_movieInterestRemoteModel, groupId);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_movieInterestRemoteModel, companyId);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_movieInterestRemoteModel, userId);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_movieInterestRemoteModel, userName);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_movieInterestRemoteModel, createDate);
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

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_movieInterestRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFavoriteMovie() {
		return _favoriteMovie;
	}

	@Override
	public void setFavoriteMovie(String favoriteMovie) {
		_favoriteMovie = favoriteMovie;

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setFavoriteMovie", String.class);

				method.invoke(_movieInterestRemoteModel, favoriteMovie);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFavoriteGenre() {
		return _favoriteGenre;
	}

	@Override
	public void setFavoriteGenre(String favoriteGenre) {
		_favoriteGenre = favoriteGenre;

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setFavoriteGenre", String.class);

				method.invoke(_movieInterestRemoteModel, favoriteGenre);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeastFavMovie() {
		return _leastFavMovie;
	}

	@Override
	public void setLeastFavMovie(String leastFavMovie) {
		_leastFavMovie = leastFavMovie;

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setLeastFavMovie", String.class);

				method.invoke(_movieInterestRemoteModel, leastFavMovie);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFavoriteActor() {
		return _favoriteActor;
	}

	@Override
	public void setFavoriteActor(String favoriteActor) {
		_favoriteActor = favoriteActor;

		if (_movieInterestRemoteModel != null) {
			try {
				Class<?> clazz = _movieInterestRemoteModel.getClass();

				Method method = clazz.getMethod("setFavoriteActor", String.class);

				method.invoke(_movieInterestRemoteModel, favoriteActor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMovieInterestRemoteModel() {
		return _movieInterestRemoteModel;
	}

	public void setMovieInterestRemoteModel(
		BaseModel<?> movieInterestRemoteModel) {
		_movieInterestRemoteModel = movieInterestRemoteModel;
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

		Class<?> remoteModelClass = _movieInterestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_movieInterestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MovieInterestLocalServiceUtil.addMovieInterest(this);
		}
		else {
			MovieInterestLocalServiceUtil.updateMovieInterest(this);
		}
	}

	@Override
	public MovieInterest toEscapedModel() {
		return (MovieInterest)ProxyUtil.newProxyInstance(MovieInterest.class.getClassLoader(),
			new Class[] { MovieInterest.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MovieInterestClp clone = new MovieInterestClp();

		clone.setMovieInterestId(getMovieInterestId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFavoriteMovie(getFavoriteMovie());
		clone.setFavoriteGenre(getFavoriteGenre());
		clone.setLeastFavMovie(getLeastFavMovie());
		clone.setFavoriteActor(getFavoriteActor());

		return clone;
	}

	@Override
	public int compareTo(MovieInterest movieInterest) {
		long primaryKey = movieInterest.getPrimaryKey();

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

		if (!(obj instanceof MovieInterestClp)) {
			return false;
		}

		MovieInterestClp movieInterest = (MovieInterestClp)obj;

		long primaryKey = movieInterest.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{movieInterestId=");
		sb.append(getMovieInterestId());
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
		sb.append(", favoriteMovie=");
		sb.append(getFavoriteMovie());
		sb.append(", favoriteGenre=");
		sb.append(getFavoriteGenre());
		sb.append(", leastFavMovie=");
		sb.append(getLeastFavMovie());
		sb.append(", favoriteActor=");
		sb.append(getFavoriteActor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.amf.user.profile.model.MovieInterest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>movieInterestId</column-name><column-value><![CDATA[");
		sb.append(getMovieInterestId());
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
			"<column><column-name>favoriteMovie</column-name><column-value><![CDATA[");
		sb.append(getFavoriteMovie());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>favoriteGenre</column-name><column-value><![CDATA[");
		sb.append(getFavoriteGenre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leastFavMovie</column-name><column-value><![CDATA[");
		sb.append(getLeastFavMovie());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>favoriteActor</column-name><column-value><![CDATA[");
		sb.append(getFavoriteActor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _movieInterestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _favoriteMovie;
	private String _favoriteGenre;
	private String _leastFavMovie;
	private String _favoriteActor;
	private BaseModel<?> _movieInterestRemoteModel;
}