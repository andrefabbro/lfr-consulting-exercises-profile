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

import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.service.MovieInterestLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author andrefabbro
 * @generated
 */
public abstract class MovieInterestActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MovieInterestActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MovieInterestLocalServiceUtil.getService());
		setClass(MovieInterest.class);

		setClassLoader(com.amf.user.profile.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("movieInterestId");
	}
}