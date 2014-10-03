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

package com.amf.user.profile.service.impl;

import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.service.base.GeneralProfileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;

import java.util.Date;

/**
 * The implementation of the general profile local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.amf.user.profile.service.GeneralProfileLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author andrefabbro
 * @see com.amf.user.profile.service.base.GeneralProfileLocalServiceBaseImpl
 * @see com.amf.user.profile.service.GeneralProfileLocalServiceUtil
 */
public class GeneralProfileLocalServiceImpl
	extends GeneralProfileLocalServiceBaseImpl {

	public GeneralProfile fetchGeneralProfile(long generalProfileId)
		throws SystemException {

		return this.generalProfilePersistence.fetchByPrimaryKey(generalProfileId);
	}

	public GeneralProfile getByUserId(long userId)
		throws SystemException {

		return this.generalProfilePersistence.fetchByUserId(userId);
	}

	public GeneralProfile addGeneralProfile(
		long groupId, long companyId, long userId, String userName,
		String aboutMe, String favoriteQuotes)
		throws SystemException {

		long generalProfileId =
			counterLocalService.increment(GeneralProfile.class.getName());

		GeneralProfile generalProfile =
			generalProfilePersistence.create(generalProfileId);

		generalProfile.setGroupId(groupId);
		generalProfile.setCompanyId(companyId);
		generalProfile.setUserId(userId);
		generalProfile.setUserName(userName);
		generalProfile.setCreateDate(new Date());

		generalProfile.setAboutMe(aboutMe);
		generalProfile.setFavoriteQuotes(favoriteQuotes);

		generalProfile = generalProfilePersistence.update(generalProfile);

		try {
			resourceLocalService.addResources(
				generalProfile.getCompanyId(), generalProfile.getGroupId(),
				generalProfile.getUserId(), GeneralProfile.class.getName(),
				generalProfile.getGeneralProfileId(), false, true, true);
		}
		catch (PortalException e) {
			System.out.println("Resource Exception: " + e.getMessage());
		}

		this.reindex(generalProfile);

		return generalProfile;
	}

	public GeneralProfile updateGeneralProfile(
		long generalProfileId, String aboutMe, String favoriteQuotes)
		throws SystemException {

		GeneralProfile generalProfile =
			generalProfilePersistence.fetchByPrimaryKey(generalProfileId);

		generalProfile.setModifiedDate(new Date());

		generalProfile.setAboutMe(aboutMe);
		generalProfile.setFavoriteQuotes(favoriteQuotes);

		generalProfile = generalProfilePersistence.update(generalProfile);

		this.reindex(generalProfile);

		return generalProfile;
	}

	private void reindex(GeneralProfile generalProfile) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(GeneralProfile.class);
		try {
			indexer.reindex(generalProfile);
		}
		catch (SearchException e) {
			System.out.println("Search Exception: " + e.getMessage());
		}
	}
}
