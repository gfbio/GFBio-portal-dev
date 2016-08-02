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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.service.ClpSerializer;
import org.gfbio.service.Search_HistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Search_HistoryClp extends BaseModelImpl<Search_History>
	implements Search_History {
	public Search_HistoryClp() {
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

	@Override
	public long getSearchHistoryID() {
		return _searchHistoryID;
	}

	@Override
	public void setSearchHistoryID(long searchHistoryID) {
		_searchHistoryID = searchHistoryID;

		if (_search_HistoryRemoteModel != null) {
			try {
				Class<?> clazz = _search_HistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchHistoryID", long.class);

				method.invoke(_search_HistoryRemoteModel, searchHistoryID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_userID = userID;

		if (_search_HistoryRemoteModel != null) {
			try {
				Class<?> clazz = _search_HistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_search_HistoryRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQueryString() {
		return _queryString;
	}

	@Override
	public void setQueryString(String queryString) {
		_queryString = queryString;

		if (_search_HistoryRemoteModel != null) {
			try {
				Class<?> clazz = _search_HistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setQueryString", String.class);

				method.invoke(_search_HistoryRemoteModel, queryString);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;

		if (_search_HistoryRemoteModel != null) {
			try {
				Class<?> clazz = _search_HistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastModifiedDate",
						Date.class);

				method.invoke(_search_HistoryRemoteModel, lastModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSearch_HistoryRemoteModel() {
		return _search_HistoryRemoteModel;
	}

	public void setSearch_HistoryRemoteModel(
		BaseModel<?> search_HistoryRemoteModel) {
		_search_HistoryRemoteModel = search_HistoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _search_HistoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_search_HistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Search_HistoryLocalServiceUtil.addSearch_History(this);
		}
		else {
			Search_HistoryLocalServiceUtil.updateSearch_History(this);
		}
	}

	@Override
	public Search_History toEscapedModel() {
		return (Search_History)ProxyUtil.newProxyInstance(Search_History.class.getClassLoader(),
			new Class[] { Search_History.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Search_HistoryClp clone = new Search_HistoryClp();

		clone.setSearchHistoryID(getSearchHistoryID());
		clone.setUserID(getUserID());
		clone.setQueryString(getQueryString());
		clone.setLastModifiedDate(getLastModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Search_History search_History) {
		int value = 0;

		value = DateUtil.compareTo(getLastModifiedDate(),
				search_History.getLastModifiedDate());

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

		if (!(obj instanceof Search_HistoryClp)) {
			return false;
		}

		Search_HistoryClp search_History = (Search_HistoryClp)obj;

		long primaryKey = search_History.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{searchHistoryID=");
		sb.append(getSearchHistoryID());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", queryString=");
		sb.append(getQueryString());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Search_History");
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
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _searchHistoryID;
	private long _userID;
	private String _queryString;
	private Date _lastModifiedDate;
	private BaseModel<?> _search_HistoryRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}