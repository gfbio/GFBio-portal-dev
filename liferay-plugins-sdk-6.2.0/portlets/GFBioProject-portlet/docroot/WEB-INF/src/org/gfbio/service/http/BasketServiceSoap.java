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

import org.gfbio.service.BasketServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.BasketServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.BasketSoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.Basket}, that is translated to a
 * {@link org.gfbio.model.BasketSoap}. Methods that SOAP cannot
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
 * @see BasketServiceHttp
 * @see org.gfbio.model.BasketSoap
 * @see org.gfbio.service.BasketServiceUtil
 * @generated
 */
public class BasketServiceSoap {
	public static org.gfbio.model.BasketSoap getBasketById(long basketId)
		throws RemoteException {
		try {
			org.gfbio.model.Basket returnValue = BasketServiceUtil.getBasketById(basketId);

			return org.gfbio.model.BasketSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.BasketSoap[] getBasketsByIds(long[] basketIds)
		throws RemoteException {
		try {
			java.util.List<org.gfbio.model.Basket> returnValue = BasketServiceUtil.getBasketsByIds(basketIds);

			return org.gfbio.model.BasketSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.BasketSoap[] getBasketsByUserAndPeriod(
		long userId, int period) throws RemoteException {
		try {
			java.util.List<org.gfbio.model.Basket> returnValue = BasketServiceUtil.getBasketsByUserAndPeriod(userId,
					period);

			return org.gfbio.model.BasketSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.BasketSoap[] getBasketsByUserId(long userId)
		throws RemoteException {
		try {
			java.util.List<org.gfbio.model.Basket> returnValue = BasketServiceUtil.getBasketsByUserId(userId);

			return org.gfbio.model.BasketSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Long[] getBasketsIdByUserAndPeriod(long userId,
		int period) throws RemoteException {
		try {
			java.util.List<java.lang.Long> returnValue = BasketServiceUtil.getBasketsIdByUserAndPeriod(userId,
					period);

			return returnValue.toArray(new java.lang.Long[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Long[] getBasketsIdByUserId(long userId)
		throws RemoteException {
		try {
			java.util.List<java.lang.Long> returnValue = BasketServiceUtil.getBasketsIdByUserId(userId);

			return returnValue.toArray(new java.lang.Long[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long updateBasket(long basketId, long userId,
		java.lang.String name, java.lang.String basketJSON,
		java.lang.String queryJSON) throws RemoteException {
		try {
			long returnValue = BasketServiceUtil.updateBasket(basketId, userId,
					name, basketJSON, queryJSON);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.BasketSoap removeBasket(long basketId)
		throws RemoteException {
		try {
			org.gfbio.model.Basket returnValue = BasketServiceUtil.removeBasket(basketId);

			return org.gfbio.model.BasketSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BasketServiceSoap.class);
}