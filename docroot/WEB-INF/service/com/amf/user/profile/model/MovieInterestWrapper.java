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
 * This class is a wrapper for {@link MovieInterest}.
 * </p>
 *
 * @author andrefabbro
 * @see MovieInterest
 * @generated
 */
public class MovieInterestWrapper implements MovieInterest,
	ModelWrapper<MovieInterest> {
	public MovieInterestWrapper(MovieInterest movieInterest) {
		_movieInterest = movieInterest;
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

	/**
	* Returns the primary key of this movie interest.
	*
	* @return the primary key of this movie interest
	*/
	@Override
	public long getPrimaryKey() {
		return _movieInterest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this movie interest.
	*
	* @param primaryKey the primary key of this movie interest
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_movieInterest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the movie interest ID of this movie interest.
	*
	* @return the movie interest ID of this movie interest
	*/
	@Override
	public long getMovieInterestId() {
		return _movieInterest.getMovieInterestId();
	}

	/**
	* Sets the movie interest ID of this movie interest.
	*
	* @param movieInterestId the movie interest ID of this movie interest
	*/
	@Override
	public void setMovieInterestId(long movieInterestId) {
		_movieInterest.setMovieInterestId(movieInterestId);
	}

	/**
	* Returns the group ID of this movie interest.
	*
	* @return the group ID of this movie interest
	*/
	@Override
	public long getGroupId() {
		return _movieInterest.getGroupId();
	}

	/**
	* Sets the group ID of this movie interest.
	*
	* @param groupId the group ID of this movie interest
	*/
	@Override
	public void setGroupId(long groupId) {
		_movieInterest.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this movie interest.
	*
	* @return the company ID of this movie interest
	*/
	@Override
	public long getCompanyId() {
		return _movieInterest.getCompanyId();
	}

	/**
	* Sets the company ID of this movie interest.
	*
	* @param companyId the company ID of this movie interest
	*/
	@Override
	public void setCompanyId(long companyId) {
		_movieInterest.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this movie interest.
	*
	* @return the user ID of this movie interest
	*/
	@Override
	public long getUserId() {
		return _movieInterest.getUserId();
	}

	/**
	* Sets the user ID of this movie interest.
	*
	* @param userId the user ID of this movie interest
	*/
	@Override
	public void setUserId(long userId) {
		_movieInterest.setUserId(userId);
	}

	/**
	* Returns the user uuid of this movie interest.
	*
	* @return the user uuid of this movie interest
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _movieInterest.getUserUuid();
	}

	/**
	* Sets the user uuid of this movie interest.
	*
	* @param userUuid the user uuid of this movie interest
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_movieInterest.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this movie interest.
	*
	* @return the user name of this movie interest
	*/
	@Override
	public java.lang.String getUserName() {
		return _movieInterest.getUserName();
	}

	/**
	* Sets the user name of this movie interest.
	*
	* @param userName the user name of this movie interest
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_movieInterest.setUserName(userName);
	}

	/**
	* Returns the create date of this movie interest.
	*
	* @return the create date of this movie interest
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _movieInterest.getCreateDate();
	}

	/**
	* Sets the create date of this movie interest.
	*
	* @param createDate the create date of this movie interest
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_movieInterest.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this movie interest.
	*
	* @return the modified date of this movie interest
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _movieInterest.getModifiedDate();
	}

	/**
	* Sets the modified date of this movie interest.
	*
	* @param modifiedDate the modified date of this movie interest
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_movieInterest.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the favorite movie of this movie interest.
	*
	* @return the favorite movie of this movie interest
	*/
	@Override
	public java.lang.String getFavoriteMovie() {
		return _movieInterest.getFavoriteMovie();
	}

	/**
	* Sets the favorite movie of this movie interest.
	*
	* @param favoriteMovie the favorite movie of this movie interest
	*/
	@Override
	public void setFavoriteMovie(java.lang.String favoriteMovie) {
		_movieInterest.setFavoriteMovie(favoriteMovie);
	}

	/**
	* Returns the favorite genre of this movie interest.
	*
	* @return the favorite genre of this movie interest
	*/
	@Override
	public java.lang.String getFavoriteGenre() {
		return _movieInterest.getFavoriteGenre();
	}

	/**
	* Sets the favorite genre of this movie interest.
	*
	* @param favoriteGenre the favorite genre of this movie interest
	*/
	@Override
	public void setFavoriteGenre(java.lang.String favoriteGenre) {
		_movieInterest.setFavoriteGenre(favoriteGenre);
	}

	/**
	* Returns the least fav movie of this movie interest.
	*
	* @return the least fav movie of this movie interest
	*/
	@Override
	public java.lang.String getLeastFavMovie() {
		return _movieInterest.getLeastFavMovie();
	}

	/**
	* Sets the least fav movie of this movie interest.
	*
	* @param leastFavMovie the least fav movie of this movie interest
	*/
	@Override
	public void setLeastFavMovie(java.lang.String leastFavMovie) {
		_movieInterest.setLeastFavMovie(leastFavMovie);
	}

	/**
	* Returns the favorite actor of this movie interest.
	*
	* @return the favorite actor of this movie interest
	*/
	@Override
	public java.lang.String getFavoriteActor() {
		return _movieInterest.getFavoriteActor();
	}

	/**
	* Sets the favorite actor of this movie interest.
	*
	* @param favoriteActor the favorite actor of this movie interest
	*/
	@Override
	public void setFavoriteActor(java.lang.String favoriteActor) {
		_movieInterest.setFavoriteActor(favoriteActor);
	}

	@Override
	public boolean isNew() {
		return _movieInterest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_movieInterest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _movieInterest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_movieInterest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _movieInterest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _movieInterest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_movieInterest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _movieInterest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_movieInterest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_movieInterest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_movieInterest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MovieInterestWrapper((MovieInterest)_movieInterest.clone());
	}

	@Override
	public int compareTo(com.amf.user.profile.model.MovieInterest movieInterest) {
		return _movieInterest.compareTo(movieInterest);
	}

	@Override
	public int hashCode() {
		return _movieInterest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.amf.user.profile.model.MovieInterest> toCacheModel() {
		return _movieInterest.toCacheModel();
	}

	@Override
	public com.amf.user.profile.model.MovieInterest toEscapedModel() {
		return new MovieInterestWrapper(_movieInterest.toEscapedModel());
	}

	@Override
	public com.amf.user.profile.model.MovieInterest toUnescapedModel() {
		return new MovieInterestWrapper(_movieInterest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _movieInterest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _movieInterest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_movieInterest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MovieInterestWrapper)) {
			return false;
		}

		MovieInterestWrapper movieInterestWrapper = (MovieInterestWrapper)obj;

		if (Validator.equals(_movieInterest, movieInterestWrapper._movieInterest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MovieInterest getWrappedMovieInterest() {
		return _movieInterest;
	}

	@Override
	public MovieInterest getWrappedModel() {
		return _movieInterest;
	}

	@Override
	public void resetOriginalValues() {
		_movieInterest.resetOriginalValues();
	}

	private MovieInterest _movieInterest;
}