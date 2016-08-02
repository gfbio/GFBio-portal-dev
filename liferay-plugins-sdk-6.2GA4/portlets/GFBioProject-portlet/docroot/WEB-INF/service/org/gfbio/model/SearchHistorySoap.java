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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.SearchHistoryServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.SearchHistoryServiceSoap
 * @generated
 */
public class SearchHistorySoap implements Serializable {
	public static SearchHistorySoap toSoapModel(SearchHistory model) {
		SearchHistorySoap soapModel = new SearchHistorySoap();

		soapModel.setSearchHistoryID(model.getSearchHistoryID());
		soapModel.setUserID(model.getUserID());
		soapModel.setQueryString(model.getQueryString());
		soapModel.setLastModifiedDate(model.getLastModifiedDate());

		return soapModel;
	}

	public static SearchHistorySoap[] toSoapModels(SearchHistory[] models) {
		SearchHistorySoap[] soapModels = new SearchHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SearchHistorySoap[][] toSoapModels(SearchHistory[][] models) {
		SearchHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SearchHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SearchHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SearchHistorySoap[] toSoapModels(List<SearchHistory> models) {
		List<SearchHistorySoap> soapModels = new ArrayList<SearchHistorySoap>(models.size());

		for (SearchHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SearchHistorySoap[soapModels.size()]);
	}

	public SearchHistorySoap() {
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