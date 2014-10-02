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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.user.profile.service.http.GeneralProfileServiceSoap}.
 *
 * @author andrefabbro
 * @see com.amf.user.profile.service.http.GeneralProfileServiceSoap
 * @generated
 */
public class GeneralProfileSoap implements Serializable {
	public static GeneralProfileSoap toSoapModel(GeneralProfile model) {
		GeneralProfileSoap soapModel = new GeneralProfileSoap();

		soapModel.setGeneralProfileId(model.getGeneralProfileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAboutMe(model.getAboutMe());
		soapModel.setFavoriteQuotes(model.getFavoriteQuotes());

		return soapModel;
	}

	public static GeneralProfileSoap[] toSoapModels(GeneralProfile[] models) {
		GeneralProfileSoap[] soapModels = new GeneralProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneralProfileSoap[][] toSoapModels(GeneralProfile[][] models) {
		GeneralProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneralProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneralProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneralProfileSoap[] toSoapModels(List<GeneralProfile> models) {
		List<GeneralProfileSoap> soapModels = new ArrayList<GeneralProfileSoap>(models.size());

		for (GeneralProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneralProfileSoap[soapModels.size()]);
	}

	public GeneralProfileSoap() {
	}

	public long getPrimaryKey() {
		return _generalProfileId;
	}

	public void setPrimaryKey(long pk) {
		setGeneralProfileId(pk);
	}

	public long getGeneralProfileId() {
		return _generalProfileId;
	}

	public void setGeneralProfileId(long generalProfileId) {
		_generalProfileId = generalProfileId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAboutMe() {
		return _aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		_aboutMe = aboutMe;
	}

	public String getFavoriteQuotes() {
		return _favoriteQuotes;
	}

	public void setFavoriteQuotes(String favoriteQuotes) {
		_favoriteQuotes = favoriteQuotes;
	}

	private long _generalProfileId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _aboutMe;
	private String _favoriteQuotes;
}