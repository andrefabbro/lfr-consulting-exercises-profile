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
 * The base model interface for the MovieInterest service. Represents a row in the &quot;UserProfile_MovieInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.amf.user.profile.model.impl.MovieInterestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.amf.user.profile.model.impl.MovieInterestImpl}.
 * </p>
 *
 * @author andrefabbro
 * @see MovieInterest
 * @see com.amf.user.profile.model.impl.MovieInterestImpl
 * @see com.amf.user.profile.model.impl.MovieInterestModelImpl
 * @generated
 */
public interface MovieInterestModel extends BaseModel<MovieInterest>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a movie interest model instance should use the {@link MovieInterest} interface instead.
	 */

	/**
	 * Returns the primary key of this movie interest.
	 *
	 * @return the primary key of this movie interest
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this movie interest.
	 *
	 * @param primaryKey the primary key of this movie interest
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the movie interest ID of this movie interest.
	 *
	 * @return the movie interest ID of this movie interest
	 */
	public long getMovieInterestId();

	/**
	 * Sets the movie interest ID of this movie interest.
	 *
	 * @param movieInterestId the movie interest ID of this movie interest
	 */
	public void setMovieInterestId(long movieInterestId);

	/**
	 * Returns the group ID of this movie interest.
	 *
	 * @return the group ID of this movie interest
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this movie interest.
	 *
	 * @param groupId the group ID of this movie interest
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this movie interest.
	 *
	 * @return the company ID of this movie interest
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this movie interest.
	 *
	 * @param companyId the company ID of this movie interest
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this movie interest.
	 *
	 * @return the user ID of this movie interest
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this movie interest.
	 *
	 * @param userId the user ID of this movie interest
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this movie interest.
	 *
	 * @return the user uuid of this movie interest
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this movie interest.
	 *
	 * @param userUuid the user uuid of this movie interest
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this movie interest.
	 *
	 * @return the user name of this movie interest
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this movie interest.
	 *
	 * @param userName the user name of this movie interest
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this movie interest.
	 *
	 * @return the create date of this movie interest
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this movie interest.
	 *
	 * @param createDate the create date of this movie interest
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this movie interest.
	 *
	 * @return the modified date of this movie interest
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this movie interest.
	 *
	 * @param modifiedDate the modified date of this movie interest
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the favorite movie of this movie interest.
	 *
	 * @return the favorite movie of this movie interest
	 */
	@AutoEscape
	public String getFavoriteMovie();

	/**
	 * Sets the favorite movie of this movie interest.
	 *
	 * @param favoriteMovie the favorite movie of this movie interest
	 */
	public void setFavoriteMovie(String favoriteMovie);

	/**
	 * Returns the favorite genre of this movie interest.
	 *
	 * @return the favorite genre of this movie interest
	 */
	@AutoEscape
	public String getFavoriteGenre();

	/**
	 * Sets the favorite genre of this movie interest.
	 *
	 * @param favoriteGenre the favorite genre of this movie interest
	 */
	public void setFavoriteGenre(String favoriteGenre);

	/**
	 * Returns the least fav movie of this movie interest.
	 *
	 * @return the least fav movie of this movie interest
	 */
	@AutoEscape
	public String getLeastFavMovie();

	/**
	 * Sets the least fav movie of this movie interest.
	 *
	 * @param leastFavMovie the least fav movie of this movie interest
	 */
	public void setLeastFavMovie(String leastFavMovie);

	/**
	 * Returns the favorite actor of this movie interest.
	 *
	 * @return the favorite actor of this movie interest
	 */
	@AutoEscape
	public String getFavoriteActor();

	/**
	 * Sets the favorite actor of this movie interest.
	 *
	 * @param favoriteActor the favorite actor of this movie interest
	 */
	public void setFavoriteActor(String favoriteActor);

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
	public int compareTo(MovieInterest movieInterest);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MovieInterest> toCacheModel();

	@Override
	public MovieInterest toEscapedModel();

	@Override
	public MovieInterest toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}