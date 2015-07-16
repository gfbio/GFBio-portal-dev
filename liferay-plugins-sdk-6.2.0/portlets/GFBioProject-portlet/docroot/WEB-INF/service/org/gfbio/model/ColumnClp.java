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

package org.gfbio.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.service.ClpSerializer;
import org.gfbio.service.ColumnLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class ColumnClp extends BaseModelImpl<Column> implements Column {
	public ColumnClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Column.class;
	}

	@Override
	public String getModelClassName() {
		return Column.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _columnID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setColumnID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _columnID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("columnID", getColumnID());
		attributes.put("headID", getHeadID());
		attributes.put("column_name", getColumn_name());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long columnID = (Long)attributes.get("columnID");

		if (columnID != null) {
			setColumnID(columnID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String column_name = (String)attributes.get("column_name");

		if (column_name != null) {
			setColumn_name(column_name);
		}
	}

	@Override
	public long getColumnID() {
		return _columnID;
	}

	@Override
	public void setColumnID(long columnID) {
		_columnID = columnID;

		if (_columnRemoteModel != null) {
			try {
				Class<?> clazz = _columnRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnID", long.class);

				method.invoke(_columnRemoteModel, columnID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHeadID() {
		return _headID;
	}

	@Override
	public void setHeadID(long headID) {
		_headID = headID;

		if (_columnRemoteModel != null) {
			try {
				Class<?> clazz = _columnRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_columnRemoteModel, headID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn_name() {
		return _column_name;
	}

	@Override
	public void setColumn_name(String column_name) {
		_column_name = column_name;

		if (_columnRemoteModel != null) {
			try {
				Class<?> clazz = _columnRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn_name", String.class);

				method.invoke(_columnRemoteModel, column_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getColumnRemoteModel() {
		return _columnRemoteModel;
	}

	public void setColumnRemoteModel(BaseModel<?> columnRemoteModel) {
		_columnRemoteModel = columnRemoteModel;
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

		Class<?> remoteModelClass = _columnRemoteModel.getClass();

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

		Object returnValue = method.invoke(_columnRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ColumnLocalServiceUtil.addColumn(this);
		}
		else {
			ColumnLocalServiceUtil.updateColumn(this);
		}
	}

	@Override
	public Column toEscapedModel() {
		return (Column)ProxyUtil.newProxyInstance(Column.class.getClassLoader(),
			new Class[] { Column.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ColumnClp clone = new ColumnClp();

		clone.setColumnID(getColumnID());
		clone.setHeadID(getHeadID());
		clone.setColumn_name(getColumn_name());

		return clone;
	}

	@Override
	public int compareTo(Column column) {
		int value = 0;

		if (getColumnID() < column.getColumnID()) {
			value = -1;
		}
		else if (getColumnID() > column.getColumnID()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ColumnClp)) {
			return false;
		}

		ColumnClp column = (ColumnClp)obj;

		long primaryKey = column.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{columnID=");
		sb.append(getColumnID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append(", column_name=");
		sb.append(getColumn_name());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Column");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>columnID</column-name><column-value><![CDATA[");
		sb.append(getColumnID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column_name</column-name><column-value><![CDATA[");
		sb.append(getColumn_name());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _columnID;
	private long _headID;
	private String _column_name;
	private BaseModel<?> _columnRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}