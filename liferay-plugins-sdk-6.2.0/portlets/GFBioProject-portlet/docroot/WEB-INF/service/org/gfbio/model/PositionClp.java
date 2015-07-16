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
import org.gfbio.service.PositionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class PositionClp extends BaseModelImpl<Position> implements Position {
	public PositionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Position.class;
	}

	@Override
	public String getModelClassName() {
		return Position.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _positionID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPositionID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _positionID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("positionID", getPositionID());
		attributes.put("headID", getHeadID());
		attributes.put("columnID", getColumnID());
		attributes.put("rowID", getRowID());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		Long columnID = (Long)attributes.get("columnID");

		if (columnID != null) {
			setColumnID(columnID);
		}

		Long rowID = (Long)attributes.get("rowID");

		if (rowID != null) {
			setRowID(rowID);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getPositionID() {
		return _positionID;
	}

	@Override
	public void setPositionID(long positionID) {
		_positionID = positionID;

		if (_positionRemoteModel != null) {
			try {
				Class<?> clazz = _positionRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionID", long.class);

				method.invoke(_positionRemoteModel, positionID);
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

		if (_positionRemoteModel != null) {
			try {
				Class<?> clazz = _positionRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_positionRemoteModel, headID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getColumnID() {
		return _columnID;
	}

	@Override
	public void setColumnID(long columnID) {
		_columnID = columnID;

		if (_positionRemoteModel != null) {
			try {
				Class<?> clazz = _positionRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnID", long.class);

				method.invoke(_positionRemoteModel, columnID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRowID() {
		return _rowID;
	}

	@Override
	public void setRowID(long rowID) {
		_rowID = rowID;

		if (_positionRemoteModel != null) {
			try {
				Class<?> clazz = _positionRemoteModel.getClass();

				Method method = clazz.getMethod("setRowID", long.class);

				method.invoke(_positionRemoteModel, rowID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_positionRemoteModel != null) {
			try {
				Class<?> clazz = _positionRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_positionRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPositionRemoteModel() {
		return _positionRemoteModel;
	}

	public void setPositionRemoteModel(BaseModel<?> positionRemoteModel) {
		_positionRemoteModel = positionRemoteModel;
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

		Class<?> remoteModelClass = _positionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_positionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PositionLocalServiceUtil.addPosition(this);
		}
		else {
			PositionLocalServiceUtil.updatePosition(this);
		}
	}

	@Override
	public Position toEscapedModel() {
		return (Position)ProxyUtil.newProxyInstance(Position.class.getClassLoader(),
			new Class[] { Position.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PositionClp clone = new PositionClp();

		clone.setPositionID(getPositionID());
		clone.setHeadID(getHeadID());
		clone.setColumnID(getColumnID());
		clone.setRowID(getRowID());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(Position position) {
		int value = 0;

		if (getPositionID() < position.getPositionID()) {
			value = -1;
		}
		else if (getPositionID() > position.getPositionID()) {
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

		if (!(obj instanceof PositionClp)) {
			return false;
		}

		PositionClp position = (PositionClp)obj;

		long primaryKey = position.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{positionID=");
		sb.append(getPositionID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append(", columnID=");
		sb.append(getColumnID());
		sb.append(", rowID=");
		sb.append(getRowID());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Position");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>positionID</column-name><column-value><![CDATA[");
		sb.append(getPositionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columnID</column-name><column-value><![CDATA[");
		sb.append(getColumnID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rowID</column-name><column-value><![CDATA[");
		sb.append(getRowID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _positionID;
	private long _headID;
	private long _columnID;
	private long _rowID;
	private String _content;
	private BaseModel<?> _positionRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}