/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import org.gfbio.service.Basket_UserServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.Basket_UserServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.Basket_UserSoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.Basket_User}, that is translated to a
 * {@link org.gfbio.model.Basket_UserSoap}. Methods that SOAP cannot
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
 * @author Felicitas Loeffler
 * @see Basket_UserServiceHttp
 * @see org.gfbio.model.Basket_UserSoap
 * @see org.gfbio.service.Basket_UserServiceUtil
 * @generated
 */
public class Basket_UserServiceSoap {
	public static org.gfbio.model.Basket_UserSoap[] getBasketList(long userID)
		throws RemoteException {
		try {
			java.util.List<org.gfbio.model.Basket_User> returnValue = Basket_UserServiceUtil.getBasketList(userID);

			return org.gfbio.model.Basket_UserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long updateBasket(long basketID, long userID,
		java.lang.String name, java.lang.String basketJSON)
		throws RemoteException {
		try {
			long returnValue = Basket_UserServiceUtil.updateBasket(basketID,
					userID, name, basketJSON);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.Basket_UserSoap removeBasket(long basketID)
		throws RemoteException {
		try {
			org.gfbio.model.Basket_User returnValue = Basket_UserServiceUtil.removeBasket(basketID);

			return org.gfbio.model.Basket_UserSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(Basket_UserServiceSoap.class);
}