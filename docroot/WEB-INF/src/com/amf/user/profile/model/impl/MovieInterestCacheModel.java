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

import com.amf.user.profile.model.MovieInterest;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MovieInterest in entity cache.
 *
 * @author andrefabbro
 * @see MovieInterest
 * @generated
 */
public class MovieInterestCacheModel implements CacheModel<MovieInterest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{movieInterestId=");
		sb.append(movieInterestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", favoriteMovie=");
		sb.append(favoriteMovie);
		sb.append(", favoriteGenre=");
		sb.append(favoriteGenre);
		sb.append(", leastFavMovie=");
		sb.append(leastFavMovie);
		sb.append(", favoriteActor=");
		sb.append(favoriteActor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MovieInterest toEntityModel() {
		MovieInterestImpl movieInterestImpl = new MovieInterestImpl();

		movieInterestImpl.setMovieInterestId(movieInterestId);
		movieInterestImpl.setGroupId(groupId);
		movieInterestImpl.setCompanyId(companyId);
		movieInterestImpl.setUserId(userId);

		if (userName == null) {
			movieInterestImpl.setUserName(StringPool.BLANK);
		}
		else {
			movieInterestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			movieInterestImpl.setCreateDate(null);
		}
		else {
			movieInterestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			movieInterestImpl.setModifiedDate(null);
		}
		else {
			movieInterestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (favoriteMovie == null) {
			movieInterestImpl.setFavoriteMovie(StringPool.BLANK);
		}
		else {
			movieInterestImpl.setFavoriteMovie(favoriteMovie);
		}

		if (favoriteGenre == null) {
			movieInterestImpl.setFavoriteGenre(StringPool.BLANK);
		}
		else {
			movieInterestImpl.setFavoriteGenre(favoriteGenre);
		}

		if (leastFavMovie == null) {
			movieInterestImpl.setLeastFavMovie(StringPool.BLANK);
		}
		else {
			movieInterestImpl.setLeastFavMovie(leastFavMovie);
		}

		if (favoriteActor == null) {
			movieInterestImpl.setFavoriteActor(StringPool.BLANK);
		}
		else {
			movieInterestImpl.setFavoriteActor(favoriteActor);
		}

		movieInterestImpl.resetOriginalValues();

		return movieInterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		movieInterestId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		favoriteMovie = objectInput.readUTF();
		favoriteGenre = objectInput.readUTF();
		leastFavMovie = objectInput.readUTF();
		favoriteActor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(movieInterestId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (favoriteMovie == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(favoriteMovie);
		}

		if (favoriteGenre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(favoriteGenre);
		}

		if (leastFavMovie == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leastFavMovie);
		}

		if (favoriteActor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(favoriteActor);
		}
	}

	public long movieInterestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String favoriteMovie;
	public String favoriteGenre;
	public String leastFavMovie;
	public String favoriteActor;
}