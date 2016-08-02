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

package org.gfbio.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Search_HistoryServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Search_HistoryServiceSoap
 * @generated
 */
public class Search_HistorySoap implements Serializable {
	public static Search_HistorySoap toSoapModel(Search_History model) {
		Search_HistorySoap soapModel = new Search_HistorySoap();

		soapModel.setSearchHistoryID(model.getSearchHistoryID());
		soapModel.setUserID(model.getUserID());
		soapModel.setQueryString(model.getQueryString());
		soapModel.setLastModifiedDate(model.getLastModifiedDate());

		return soapModel;
	}

	public static Search_HistorySoap[] toSoapModels(Search_History[] models) {
		Search_HistorySoap[] soapModels = new Search_HistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Search_HistorySoap[][] toSoapModels(Search_History[][] models) {
		Search_HistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Search_HistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new Search_HistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Search_HistorySoap[] toSoapModels(List<Search_History> models) {
		List<Search_HistorySoap> soapModels = new ArrayList<Search_HistorySoap>(models.size());

		for (Search_History model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Search_HistorySoap[soapModels.size()]);
	}

	public Search_HistorySoap() {
	}

	public long getPrimaryKey() {
		return _searchHistoryID;
	}

	public void setPrimaryKey(long pk) {
		setSearchHistoryID(pk);
	}

	public long getSearchHistoryID() {
		return _searchHistoryID;
	}

	public void setSearchHistoryID(long searchHistoryID) {
		_searchHistoryID = searchHistoryID;
	}

	public long getUserID() {
		return _userID;
	}

	public void setUserID(long userID) {
		_userID = userID;
	}

	public String getQueryString() {
		return _queryString;
	}

	public void setQueryString(String queryString) {
		_queryString = queryString;
	}

	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	private long _searchHistoryID;
	private long _userID;
	private String _queryString;
	private Date _lastModifiedDate;
}