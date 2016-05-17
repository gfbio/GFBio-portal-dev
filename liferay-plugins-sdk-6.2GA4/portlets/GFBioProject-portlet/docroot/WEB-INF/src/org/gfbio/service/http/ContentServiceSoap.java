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

import org.gfbio.service.ContentServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.gfbio.service.ContentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.gfbio.model.ContentSoap}.
 * If the method in the service utility returns a
 * {@link org.gfbio.model.Content}, that is translated to a
 * {@link org.gfbio.model.ContentSoap}. Methods that SOAP cannot
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
 * @see ContentServiceHttp
 * @see org.gfbio.model.ContentSoap
 * @see org.gfbio.service.ContentServiceUtil
 * @generated
 */
public class ContentServiceSoap {
	public static java.lang.String getContentIdsWithRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2)
		throws RemoteException {
		try {
			java.lang.String returnValue = ContentServiceUtil.getContentIdsWithRelationships(rowId,
					tableName1, tableName2);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getContentIdsWithNormalTableRelationships(
		long rowId, java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2) throws RemoteException {
		try {
			java.lang.String returnValue = ContentServiceUtil.getContentIdsWithNormalTableRelationships(rowId,
					tableName, columnName1, columnName2);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.json.simple.JSONObject getRowInformationByContentId(
		long contentId) throws RemoteException {
		try {
			org.json.simple.JSONObject returnValue = ContentServiceUtil.getRowInformationByContentId(contentId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.json.simple.JSONArray getRowInformationOfRelationByContentId(
		long contentId, java.lang.String tableName1, java.lang.String tableName2)
		throws RemoteException {
		try {
			org.json.simple.JSONArray returnValue = ContentServiceUtil.getRowInformationOfRelationByContentId(contentId,
					tableName1, tableName2);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.json.simple.JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(
		org.json.simple.JSONObject requestJson) throws RemoteException {
		try {
			org.json.simple.JSONArray returnValue = ContentServiceUtil.getRowInformationsOfRelationshipsOfSpecificCellContent(requestJson);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ContentServiceSoap.class);
}