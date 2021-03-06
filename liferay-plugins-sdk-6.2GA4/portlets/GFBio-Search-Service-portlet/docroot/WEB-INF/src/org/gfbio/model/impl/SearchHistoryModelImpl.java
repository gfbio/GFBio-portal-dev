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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gfbio.model.SearchHistory;
import org.gfbio.model.SearchHistoryModel;
import org.gfbio.model.SearchHistorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SearchHistory service. Represents a row in the &quot;gfbio_SearchHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.SearchHistoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SearchHistoryImpl}.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see SearchHistoryImpl
 * @see org.gfbio.model.SearchHistory
 * @see org.gfbio.model.SearchHistoryModel
 * @generated
 */
@JSON(strict = true)
public class SearchHistoryModelImpl extends BaseModelImpl<SearchHistory>
	implements SearchHistoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a search history model instance should use the {@link org.gfbio.model.SearchHistory} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_SearchHistory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "searchHistoryID", Types.BIGINT },
			{ "userID", Types.BIGINT },
			{ "queryString", Types.VARCHAR },
			{ "queryFilter", Types.VARCHAR },
			{ "lastModifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_SearchHistory (searchHistoryID LONG not null primary key,userID LONG,queryString VARCHAR(75) null,queryFilter VARCHAR(75) null,lastModifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_SearchHistory";
	public static final String ORDER_BY_JPQL = " ORDER BY searchHistory.lastModifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_SearchHistory.lastModifiedDate DESC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.SearchHistory"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.SearchHistory"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.SearchHistory"),
			true);
	public static long LASTMODIFIEDDATE_COLUMN_BITMASK = 1L;
	public static long QUERYSTRING_COLUMN_BITMASK = 2L;
	public static long SEARCHHISTORYID_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SearchHistory toModel(SearchHistorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SearchHistory model = new SearchHistoryImpl();

		model.setSearchHistoryID(soapModel.getSearchHistoryID());
		model.setUserID(soapModel.getUserID());
		model.setQueryString(soapModel.getQueryString());
		model.setQueryFilter(soapModel.getQueryFilter());
		model.setLastModifiedDate(soapModel.getLastModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SearchHistory> toModels(SearchHistorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SearchHistory> models = new ArrayList<SearchHistory>(soapModels.length);

		for (SearchHistorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.SearchHistory"));

	public SearchHistoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _searchHistoryID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSearchHistoryID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchHistoryID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("queryFilter", getQueryFilter());
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

		String queryFilter = (String)attributes.get("queryFilter");

		if (queryFilter != null) {
			setQueryFilter(queryFilter);
		}

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
	}

	@JSON
	@Override
	public long getSearchHistoryID() {
		return _searchHistoryID;
	}

	@Override
	public void setSearchHistoryID(long searchHistoryID) {
		_columnBitmask |= SEARCHHISTORYID_COLUMN_BITMASK;

		if (!_setOriginalSearchHistoryID) {
			_setOriginalSearchHistoryID = true;

			_originalSearchHistoryID = _searchHistoryID;
		}

		_searchHistoryID = searchHistoryID;
	}

	public long getOriginalSearchHistoryID() {
		return _originalSearchHistoryID;
	}

	@JSON
	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserID) {
			_setOriginalUserID = true;

			_originalUserID = _userID;
		}

		_userID = userID;
	}

	public long getOriginalUserID() {
		return _originalUserID;
	}

	@JSON
	@Override
	public String getQueryString() {
		if (_queryString == null) {
			return StringPool.BLANK;
		}
		else {
			return _queryString;
		}
	}

	@Override
	public void setQueryString(String queryString) {
		_columnBitmask |= QUERYSTRING_COLUMN_BITMASK;

		if (_originalQueryString == null) {
			_originalQueryString = _queryString;
		}

		_queryString = queryString;
	}

	public String getOriginalQueryString() {
		return GetterUtil.getString(_originalQueryString);
	}

	@JSON
	@Override
	public String getQueryFilter() {
		if (_queryFilter == null) {
			return StringPool.BLANK;
		}
		else {
			return _queryFilter;
		}
	}

	@Override
	public void setQueryFilter(String queryFilter) {
		_queryFilter = queryFilter;
	}

	@JSON
	@Override
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(Date lastModifiedDate) {
		_columnBitmask = -1L;

		if (_originalLastModifiedDate == null) {
			_originalLastModifiedDate = _lastModifiedDate;
		}

		_lastModifiedDate = lastModifiedDate;
	}

	public Date getOriginalLastModifiedDate() {
		return _originalLastModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SearchHistory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SearchHistory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SearchHistory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SearchHistoryImpl searchHistoryImpl = new SearchHistoryImpl();

		searchHistoryImpl.setSearchHistoryID(getSearchHistoryID());
		searchHistoryImpl.setUserID(getUserID());
		searchHistoryImpl.setQueryString(getQueryString());
		searchHistoryImpl.setQueryFilter(getQueryFilter());
		searchHistoryImpl.setLastModifiedDate(getLastModifiedDate());

		searchHistoryImpl.resetOriginalValues();

		return searchHistoryImpl;
	}

	@Override
	public int compareTo(SearchHistory searchHistory) {
		int value = 0;

		value = DateUtil.compareTo(getLastModifiedDate(),
				searchHistory.getLastModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchHistory)) {
			return false;
		}

		SearchHistory searchHistory = (SearchHistory)obj;

		long primaryKey = searchHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SearchHistoryModelImpl searchHistoryModelImpl = this;

		searchHistoryModelImpl._originalSearchHistoryID = searchHistoryModelImpl._searchHistoryID;

		searchHistoryModelImpl._setOriginalSearchHistoryID = false;

		searchHistoryModelImpl._originalUserID = searchHistoryModelImpl._userID;

		searchHistoryModelImpl._setOriginalUserID = false;

		searchHistoryModelImpl._originalQueryString = searchHistoryModelImpl._queryString;

		searchHistoryModelImpl._originalLastModifiedDate = searchHistoryModelImpl._lastModifiedDate;

		searchHistoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SearchHistory> toCacheModel() {
		SearchHistoryCacheModel searchHistoryCacheModel = new SearchHistoryCacheModel();

		searchHistoryCacheModel.searchHistoryID = getSearchHistoryID();

		searchHistoryCacheModel.userID = getUserID();

		searchHistoryCacheModel.queryString = getQueryString();

		String queryString = searchHistoryCacheModel.queryString;

		if ((queryString != null) && (queryString.length() == 0)) {
			searchHistoryCacheModel.queryString = null;
		}

		searchHistoryCacheModel.queryFilter = getQueryFilter();

		String queryFilter = searchHistoryCacheModel.queryFilter;

		if ((queryFilter != null) && (queryFilter.length() == 0)) {
			searchHistoryCacheModel.queryFilter = null;
		}

		Date lastModifiedDate = getLastModifiedDate();

		if (lastModifiedDate != null) {
			searchHistoryCacheModel.lastModifiedDate = lastModifiedDate.getTime();
		}
		else {
			searchHistoryCacheModel.lastModifiedDate = Long.MIN_VALUE;
		}

		return searchHistoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{searchHistoryID=");
		sb.append(getSearchHistoryID());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", queryString=");
		sb.append(getQueryString());
		sb.append(", queryFilter=");
		sb.append(getQueryFilter());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.SearchHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>searchHistoryID</column-name><column-value><![CDATA[");
		sb.append(getSearchHistoryID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queryString</column-name><column-value><![CDATA[");
		sb.append(getQueryString());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queryFilter</column-name><column-value><![CDATA[");
		sb.append(getQueryFilter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SearchHistory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SearchHistory.class
		};
	private long _searchHistoryID;
	private long _originalSearchHistoryID;
	private boolean _setOriginalSearchHistoryID;
	private long _userID;
	private long _originalUserID;
	private boolean _setOriginalUserID;
	private String _queryString;
	private String _originalQueryString;
	private String _queryFilter;
	private Date _lastModifiedDate;
	private Date _originalLastModifiedDate;
	private long _columnBitmask;
	private SearchHistory _escapedModel;
}