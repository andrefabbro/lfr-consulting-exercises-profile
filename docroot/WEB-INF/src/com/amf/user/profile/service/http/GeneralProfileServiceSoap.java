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

package com.amf.user.profile.service.http;

import com.amf.user.profile.service.GeneralProfileServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.amf.user.profile.service.GeneralProfileServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.amf.user.profile.model.GeneralProfileSoap}.
 * If the method in the service utility returns a
 * {@link com.amf.user.profile.model.GeneralProfile}, that is translated to a
 * {@link com.amf.user.profile.model.GeneralProfileSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author andrefabbro
 * @see GeneralProfileServiceHttp
 * @see com.amf.user.profile.model.GeneralProfileSoap
 * @see com.amf.user.profile.service.GeneralProfileServiceUtil
 * @generated
 */
public class GeneralProfileServiceSoap {
	public static com.amf.user.profile.model.GeneralProfileSoap getByUserId(
		long userId, long groupId) throws RemoteException {
		try {
			com.amf.user.profile.model.GeneralProfile returnValue = GeneralProfileServiceUtil.getByUserId(userId,
					groupId);

			return com.amf.user.profile.model.GeneralProfileSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.amf.user.profile.model.GeneralProfileSoap addGeneralProfile(
		long groupId, long companyId, long userId, java.lang.String userName,
		java.lang.String aboutMe, java.lang.String favoriteQuotes)
		throws RemoteException {
		try {
			com.amf.user.profile.model.GeneralProfile returnValue = GeneralProfileServiceUtil.addGeneralProfile(groupId,
					companyId, userId, userName, aboutMe, favoriteQuotes);

			return com.amf.user.profile.model.GeneralProfileSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.amf.user.profile.model.GeneralProfileSoap updateGeneralProfile(
		long generalProfileId, long groupId, java.lang.String aboutMe,
		java.lang.String favoriteQuotes) throws RemoteException {
		try {
			com.amf.user.profile.model.GeneralProfile returnValue = GeneralProfileServiceUtil.updateGeneralProfile(generalProfileId,
					groupId, aboutMe, favoriteQuotes);

			return com.amf.user.profile.model.GeneralProfileSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(GeneralProfileServiceSoap.class);
}