/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.gfbio.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.gfbio.service.UserGoesternIDServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.UserGoesternIDServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.UserGoesternIDSoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.UserGoesternID}, that is translated to a
 * {@link org.gfbio.model.UserGoesternIDSoap}. Methods that SOAP cannot
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
 * @author Marcel Froemming
 * @see UserGoesternIDServiceHttp
 * @see org.gfbio.model.UserGoesternIDSoap
 * @see org.gfbio.service.UserGoesternIDServiceUtil
 * @generated
 */
public class UserGoesternIDServiceSoap {
	/**
	* returns the userID of a user being identified by goesternID
	*
	* @param goesternID
	* @return userID
	* @JSONWebService
	*/
	public static long getUserByGoeSternID(java.lang.String goesternID)
		throws RemoteException {
		try {
			long returnValue = UserGoesternIDServiceUtil.getUserByGoeSternID(goesternID);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* returns the goesternID of a user being identified by userID
	*
	* @param userID
	* @return goesternID
	* @JSONWebService
	*/
	public static java.lang.String getGoesternIdByUserID(long userID)
		throws RemoteException {
		try {
			java.lang.String returnValue = UserGoesternIDServiceUtil.getGoesternIdByUserID(userID);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* returns the goesternID of a user being identified by userID
	*
	* @param userID
	* @return the number of user goestern ids
	* @JSONWebService
	*/
	public static int getUserGoesternIDsCount() throws RemoteException {
		try {
			int returnValue = UserGoesternIDServiceUtil.getUserGoesternIDsCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserGoesternIDServiceSoap.class);
}