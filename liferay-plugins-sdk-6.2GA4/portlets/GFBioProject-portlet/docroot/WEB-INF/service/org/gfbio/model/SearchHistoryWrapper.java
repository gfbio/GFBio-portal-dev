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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SearchHistory}.
 * </p>
 *
 * @author Marcel Froemming
 * @see SearchHistory
 * @generated
 */
public class SearchHistoryWrapper implements SearchHistory,
	ModelWrapper<SearchHistory> {
	public SearchHistoryWrapper(SearchHistory searchHistory) {
		_searchHistory = searchHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return SearchHistory.class;
	}

	@Override
	public String getModelClassName() {
		return SearchHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("searchHistoryID", getSearchHistoryID());
		attributes.put("userID", getUserID());
		attributes.put("queryString", getQueryString());
		attributes.put("lastModifiedDate", getLastModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long searchHistoryID = (Long)attributes.get("searchHistoryID");

		if (searchHistoryID != null) {
			setSearchHistoryID(searchHistoryID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String queryString = (String)attributes.get("queryString");

		if (queryString != null) {
			setQueryString(queryString);
		}

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
	}

	/**
	* Returns the primary key of this search history.
	*
	* @return the primary key of this search history
	*/
	@Override
	public long getPrimaryKey() {
		return _searchHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this search history.
	*
	* @param primaryKey the primary key of this search history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_searchHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the search history i d of this search history.
	*
	* @return the search history i d of this search history
	*/
	@Override
	public long getSearchHistoryID() {
		return _searchHistory.getSearchHistoryID();
	}

	/**
	* Sets the search history i d of this search history.
	*
	* @param searchHistoryID the search history i d of this search history
	*/
	@Override
	public void setSearchHistoryID(long searchHistoryID) {
		_searchHistory.setSearchHistoryID(searchHistoryID);
	}

	/**
	* Returns the user i d of this search history.
	*
	* @return the user i d of this search history
	*/
	@Override
	public long getUserID() {
		return _searchHistory.getUserID();
	}

	/**
	* Sets the user i d of this search history.
	*
	* @param userID the user i d of this search history
	*/
	@Override
	public void setUserID(long userID) {
		_searchHistory.setUserID(userID);
	}

	/**
	* Returns the query string of this search history.
	*
	* @return the query string of this search history
	*/
	@Override
	public java.lang.String getQueryString() {
		return _searchHistory.getQueryString();
	}

	/**
	* Sets the query string of this search history.
	*
	* @param queryString the query string of this search history
	*/
	@Override
	public void setQueryString(java.lang.String queryString) {
		_searchHistory.setQueryString(queryString);
	}

	/**
	* Returns the last modified date of this search history.
	*
	* @return the last modified date of this search history
	*/
	@Override
	public java.util.Date getLastModifiedDate() {
		return _searchHistory.getLastModifiedDate();
	}

	/**
	* Sets the last modified date of this search history.
	*
	* @param lastModifiedDate the last modified date of this search history
	*/
	@Override
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		_searchHistory.setLastModifiedDate(lastModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _searchHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_searchHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _searchHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_searchHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _searchHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _searchHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_searchHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _searchHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_searchHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_searchHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_searchHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SearchHistoryWrapper((SearchHistory)_searchHistory.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.SearchHistory searchHistory) {
		return _searchHistory.compareTo(searchHistory);
	}

	@Override
	public int hashCode() {
		return _searchHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.SearchHistory> toCacheModel() {
		return _searchHistory.toCacheModel();
	}

	@Override
	public org.gfbio.model.SearchHistory toEscapedModel() {
		return new SearchHistoryWrapper(_searchHistory.toEscapedModel());
	}

	@Override
	public org.gfbio.model.SearchHistory toUnescapedModel() {
		return new SearchHistoryWrapper(_searchHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _searchHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _searchHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_searchHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchHistoryWrapper)) {
			return false;
		}

		SearchHistoryWrapper searchHistoryWrapper = (SearchHistoryWrapper)obj;

		if (Validator.equals(_searchHistory, searchHistoryWrapper._searchHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SearchHistory getWrappedSearchHistory() {
		return _searchHistory;
	}

	@Override
	public SearchHistory getWrappedModel() {
		return _searchHistory;
	}

	@Override
	public void resetOriginalValues() {
		_searchHistory.resetOriginalValues();
	}

	private SearchHistory _searchHistory;
}