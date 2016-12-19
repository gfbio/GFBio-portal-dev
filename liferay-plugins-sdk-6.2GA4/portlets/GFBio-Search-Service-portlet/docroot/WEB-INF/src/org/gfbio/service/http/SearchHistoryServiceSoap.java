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

import org.gfbio.service.SearchHistoryServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.SearchHistoryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.SearchHistorySoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.SearchHistory}, that is translated to a
 * {@link org.gfbio.model.SearchHistorySoap}. Methods that SOAP cannot
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
 * @author Kobkaew Opasjumruskit
 * @see SearchHistoryServiceHttp
 * @see org.gfbio.model.SearchHistorySoap
 * @see org.gfbio.service.SearchHistoryServiceUtil
 * @generated
 */
public class SearchHistoryServiceSoap {
	public static java.lang.String getSearchHistoryById(long searchHistoryId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryById(searchHistoryId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryByIds(
		long[] searchHistoryIDs) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryByIds(searchHistoryIDs);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryIdByUserId(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryIdByUserId(userId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryIdByUserAndPeriod(
		long userId, int period) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryIdByUserAndPeriod(userId,
					period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryIdByQueryString(
		java.lang.String queryString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryIdByQueryString(queryString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryIdByQueryStringAndPeriod(
		java.lang.String queryString, int period) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryIdByQueryStringAndPeriod(queryString,
					period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchHistoryIdByPeriod(int period)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchHistoryServiceUtil.getSearchHistoryIdByPeriod(period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long updateSearchHistory(long searchHistoryId, long userId,
		java.lang.String queryString, java.lang.String queryFilter)
		throws RemoteException {
		try {
			long returnValue = SearchHistoryServiceUtil.updateSearchHistory(searchHistoryId,
					userId, queryString, queryFilter);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SearchHistorySoap removeSearchHistory(
		long searchHistoryId) throws RemoteException {
		try {
			org.gfbio.model.SearchHistory returnValue = SearchHistoryServiceUtil.removeSearchHistory(searchHistoryId);

			return org.gfbio.model.SearchHistorySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SearchHistoryServiceSoap.class);
}