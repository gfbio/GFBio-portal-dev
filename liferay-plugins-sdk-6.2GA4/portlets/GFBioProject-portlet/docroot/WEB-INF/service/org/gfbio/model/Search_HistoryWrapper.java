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
 * This class is a wrapper for {@link Search_History}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Search_History
 * @generated
 */
public class Search_HistoryWrapper implements Search_History,
	ModelWrapper<Search_History> {
	public Search_HistoryWrapper(Search_History search_History) {
		_search_History = search_History;
	}

	@Override
	public Class<?> getModelClass() {
		return Search_History.class;
	}

	@Override
	public String getModelClassName() {
		return Search_History.class.getName();
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
	* Returns the primary key of this search_ history.
	*
	* @return the primary key of this search_ history
	*/
	@Override
	public long getPrimaryKey() {
		return _search_History.getPrimaryKey();
	}

	/**
	* Sets the primary key of this search_ history.
	*
	* @param primaryKey the primary key of this search_ history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_search_History.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the search history i d of this search_ history.
	*
	* @return the search history i d of this search_ history
	*/
	@Override
	public long getSearchHistoryID() {
		return _search_History.getSearchHistoryID();
	}

	/**
	* Sets the search history i d of this search_ history.
	*
	* @param searchHistoryID the search history i d of this search_ history
	*/
	@Override
	public void setSearchHistoryID(long searchHistoryID) {
		_search_History.setSearchHistoryID(searchHistoryID);
	}

	/**
	* Returns the user i d of this search_ history.
	*
	* @return the user i d of this search_ history
	*/
	@Override
	public long getUserID() {
		return _search_History.getUserID();
	}

	/**
	* Sets the user i d of this search_ history.
	*
	* @param userID the user i d of this search_ history
	*/
	@Override
	public void setUserID(long userID) {
		_search_History.setUserID(userID);
	}

	/**
	* Returns the query string of this search_ history.
	*
	* @return the query string of this search_ history
	*/
	@Override
	public java.lang.String getQueryString() {
		return _search_History.getQueryString();
	}

	/**
	* Sets the query string of this search_ history.
	*
	* @param queryString the query string of this search_ history
	*/
	@Override
	public void setQueryString(java.lang.String queryString) {
		_search_History.setQueryString(queryString);
	}

	/**
	* Returns the last modified date of this search_ history.
	*
	* @return the last modified date of this search_ history
	*/
	@Override
	public java.util.Date getLastModifiedDate() {
		return _search_History.getLastModifiedDate();
	}

	/**
	* Sets the last modified date of this search_ history.
	*
	* @param lastModifiedDate the last modified date of this search_ history
	*/
	@Override
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		_search_History.setLastModifiedDate(lastModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _search_History.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_search_History.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _search_History.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_search_History.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _search_History.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _search_History.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_search_History.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _search_History.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_search_History.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_search_History.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_search_History.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Search_HistoryWrapper((Search_History)_search_History.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Search_History search_History) {
		return _search_History.compareTo(search_History);
	}

	@Override
	public int hashCode() {
		return _search_History.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Search_History> toCacheModel() {
		return _search_History.toCacheModel();
	}

	@Override
	public org.gfbio.model.Search_History toEscapedModel() {
		return new Search_HistoryWrapper(_search_History.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Search_History toUnescapedModel() {
		return new Search_HistoryWrapper(_search_History.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _search_History.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _search_History.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_search_History.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Search_HistoryWrapper)) {
			return false;
		}

		Search_HistoryWrapper search_HistoryWrapper = (Search_HistoryWrapper)obj;

		if (Validator.equals(_search_History,
					search_HistoryWrapper._search_History)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Search_History getWrappedSearch_History() {
		return _search_History;
	}

	@Override
	public Search_History getWrappedModel() {
		return _search_History;
	}

	@Override
	public void resetOriginalValues() {
		_search_History.resetOriginalValues();
	}

	private Search_History _search_History;
}