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

import org.gfbio.service.SearchFeedbackServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.SearchFeedbackServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.SearchFeedbackSoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.SearchFeedback}, that is translated to a
 * {@link org.gfbio.model.SearchFeedbackSoap}. Methods that SOAP cannot
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
 * @see SearchFeedbackServiceHttp
 * @see org.gfbio.model.SearchFeedbackSoap
 * @see org.gfbio.service.SearchFeedbackServiceUtil
 * @generated
 */
public class SearchFeedbackServiceSoap {
	public static java.lang.String getSearchFeedbackById(long searchFeedbackId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackById(searchFeedbackId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackByIds(
		long[] searchFeedbackIDs) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackByIds(searchFeedbackIDs);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIDByUserId(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIDByUserId(userId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByUserAndPeriod(
		long userId, int period) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByUserAndPeriod(userId,
					period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByRating(int[] ratings)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByRating(ratings);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByRatingsAndPeriod(
		int[] ratings, int period) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByRatingsAndPeriod(ratings,
					period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByQueryString(
		java.lang.String queryString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByQueryString(queryString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByQueryStringAndPeriod(
		java.lang.String queryString, int period) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByQueryStringAndPeriod(queryString,
					period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSearchFeedbackIdByPeriod(int period)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SearchFeedbackServiceUtil.getSearchFeedbackIdByPeriod(period);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long updateSearchFeedback(long searchFeedbackId, long userId,
		java.lang.String queryString, java.lang.String queryFilter,
		java.lang.String datasetDetail, long datasetRank, int rating)
		throws RemoteException {
		try {
			long returnValue = SearchFeedbackServiceUtil.updateSearchFeedback(searchFeedbackId,
					userId, queryString, queryFilter, datasetDetail,
					datasetRank, rating);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.gfbio.model.SearchFeedbackSoap removeSearchFeedback(
		long searchFeedbackId) throws RemoteException {
		try {
			org.gfbio.model.SearchFeedback returnValue = SearchFeedbackServiceUtil.removeSearchFeedback(searchFeedbackId);

			return org.gfbio.model.SearchFeedbackSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SearchFeedbackServiceSoap.class);
}