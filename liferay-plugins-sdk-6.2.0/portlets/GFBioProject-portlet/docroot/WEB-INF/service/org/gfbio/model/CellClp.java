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

import org.gfbio.service.CellLocalServiceUtil;
import org.gfbio.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class CellClp extends BaseModelImpl<Cell> implements Cell {
	public CellClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cell.class;
	}

	@Override
	public String getModelClassName() {
		return Cell.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cellID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCellID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cellID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("content", getContent());
		attributes.put("task", getTask());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
		}
	}

	@Override
	public long getCellID() {
		return _cellID;
	}

	@Override
	public void setCellID(long cellID) {
		_cellID = cellID;

		if (_cellRemoteModel != null) {
			try {
				Class<?> clazz = _cellRemoteModel.getClass();

				Method method = clazz.getMethod("setCellID", long.class);

				method.invoke(_cellRemoteModel, cellID);
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

		if (_cellRemoteModel != null) {
			try {
				Class<?> clazz = _cellRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_cellRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTask() {
		return _task;
	}

	@Override
	public void setTask(String task) {
		_task = task;

		if (_cellRemoteModel != null) {
			try {
				Class<?> clazz = _cellRemoteModel.getClass();

				Method method = clazz.getMethod("setTask", String.class);

				method.invoke(_cellRemoteModel, task);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCellRemoteModel() {
		return _cellRemoteModel;
	}

	public void setCellRemoteModel(BaseModel<?> cellRemoteModel) {
		_cellRemoteModel = cellRemoteModel;
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

		Class<?> remoteModelClass = _cellRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cellRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CellLocalServiceUtil.addCell(this);
		}
		else {
			CellLocalServiceUtil.updateCell(this);
		}
	}

	@Override
	public Cell toEscapedModel() {
		return (Cell)ProxyUtil.newProxyInstance(Cell.class.getClassLoader(),
			new Class[] { Cell.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CellClp clone = new CellClp();

		clone.setCellID(getCellID());
		clone.setContent(getContent());
		clone.setTask(getTask());

		return clone;
	}

	@Override
	public int compareTo(Cell cell) {
		int value = 0;

		value = getContent().compareTo(cell.getContent());

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

		if (!(obj instanceof CellClp)) {
			return false;
		}

		CellClp cell = (CellClp)obj;

		long primaryKey = cell.getPrimaryKey();

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

		sb.append("{cellID=");
		sb.append(getCellID());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", task=");
		sb.append(getTask());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Cell");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cellID</column-name><column-value><![CDATA[");
		sb.append(getCellID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>task</column-name><column-value><![CDATA[");
		sb.append(getTask());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cellID;
	private String _content;
	private String _task;
	private BaseModel<?> _cellRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}