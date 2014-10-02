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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GeneralProfile in entity cache.
 *
 * @author andrefabbro
 * @see GeneralProfile
 * @generated
 */
public class GeneralProfileCacheModel implements CacheModel<GeneralProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{generalProfileId=");
		sb.append(generalProfileId);
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
		sb.append(", aboutMe=");
		sb.append(aboutMe);
		sb.append(", favoriteQuotes=");
		sb.append(favoriteQuotes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GeneralProfile toEntityModel() {
		GeneralProfileImpl generalProfileImpl = new GeneralProfileImpl();

		generalProfileImpl.setGeneralProfileId(generalProfileId);
		generalProfileImpl.setGroupId(groupId);
		generalProfileImpl.setCompanyId(companyId);
		generalProfileImpl.setUserId(userId);

		if (userName == null) {
			generalProfileImpl.setUserName(StringPool.BLANK);
		}
		else {
			generalProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			generalProfileImpl.setCreateDate(null);
		}
		else {
			generalProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			generalProfileImpl.setModifiedDate(null);
		}
		else {
			generalProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (aboutMe == null) {
			generalProfileImpl.setAboutMe(StringPool.BLANK);
		}
		else {
			generalProfileImpl.setAboutMe(aboutMe);
		}

		if (favoriteQuotes == null) {
			generalProfileImpl.setFavoriteQuotes(StringPool.BLANK);
		}
		else {
			generalProfileImpl.setFavoriteQuotes(favoriteQuotes);
		}

		generalProfileImpl.resetOriginalValues();

		return generalProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		generalProfileId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		aboutMe = objectInput.readUTF();
		favoriteQuotes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(generalProfileId);
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

		if (aboutMe == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aboutMe);
		}

		if (favoriteQuotes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(favoriteQuotes);
		}
	}

	public long generalProfileId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String aboutMe;
	public String favoriteQuotes;
}