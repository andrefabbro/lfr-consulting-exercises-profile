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

package com.amf.user.profile.service.persistence;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.service.GeneralProfileLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author andrefabbro
 * @generated
 */
public abstract class GeneralProfileActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public GeneralProfileActionableDynamicQuery() throws SystemException {
		setBaseLocalService(GeneralProfileLocalServiceUtil.getService());
		setClass(GeneralProfile.class);

		setClassLoader(com.amf.user.profile.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("generalProfileId");
	}
}