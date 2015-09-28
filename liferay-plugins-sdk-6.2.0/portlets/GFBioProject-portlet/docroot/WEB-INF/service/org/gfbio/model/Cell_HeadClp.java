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

import org.gfbio.service.Cell_HeadLocalServiceUtil;
import org.gfbio.service.ClpSerializer;
import org.gfbio.service.persistence.Cell_HeadPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Cell_HeadClp extends BaseModelImpl<Cell_Head> implements Cell_Head {
	public Cell_HeadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cell_Head.class;
	}

	@Override
	public String getModelClassName() {
		return Cell_Head.class.getName();
	}

	@Override
	public Cell_HeadPK getPrimaryKey() {
		return new Cell_HeadPK(_cellID, _headID);
	}

	@Override
	public void setPrimaryKey(Cell_HeadPK primaryKey) {
		setCellID(primaryKey.cellID);
		setHeadID(primaryKey.headID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Cell_HeadPK(_cellID, _headID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Cell_HeadPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("headID", getHeadID());
		attributes.put("column", getColumn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		Integer column = (Integer)attributes.get("column");

		if (column != null) {
			setColumn(column);
		}
	}

	@Override
	public long getCellID() {
		return _cellID;
	}

	@Override
	public void setCellID(long cellID) {
		_cellID = cellID;

		if (_cell_HeadRemoteModel != null) {
			try {
				Class<?> clazz = _cell_HeadRemoteModel.getClass();

				Method method = clazz.getMethod("setCellID", long.class);

				method.invoke(_cell_HeadRemoteModel, cellID);
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

		if (_cell_HeadRemoteModel != null) {
			try {
				Class<?> clazz = _cell_HeadRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_cell_HeadRemoteModel, headID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getColumn() {
		return _column;
	}

	@Override
	public void setColumn(int column) {
		_column = column;

		if (_cell_HeadRemoteModel != null) {
			try {
				Class<?> clazz = _cell_HeadRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn", int.class);

				method.invoke(_cell_HeadRemoteModel, column);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCell_HeadRemoteModel() {
		return _cell_HeadRemoteModel;
	}

	public void setCell_HeadRemoteModel(BaseModel<?> cell_HeadRemoteModel) {
		_cell_HeadRemoteModel = cell_HeadRemoteModel;
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

		Class<?> remoteModelClass = _cell_HeadRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cell_HeadRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Cell_HeadLocalServiceUtil.addCell_Head(this);
		}
		else {
			Cell_HeadLocalServiceUtil.updateCell_Head(this);
		}
	}

	@Override
	public Cell_Head toEscapedModel() {
		return (Cell_Head)ProxyUtil.newProxyInstance(Cell_Head.class.getClassLoader(),
			new Class[] { Cell_Head.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Cell_HeadClp clone = new Cell_HeadClp();

		clone.setCellID(getCellID());
		clone.setHeadID(getHeadID());
		clone.setColumn(getColumn());

		return clone;
	}

	@Override
	public int compareTo(Cell_Head cell_Head) {
		Cell_HeadPK primaryKey = cell_Head.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cell_HeadClp)) {
			return false;
		}

		Cell_HeadClp cell_Head = (Cell_HeadClp)obj;

		Cell_HeadPK primaryKey = cell_Head.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cellID=");
		sb.append(getCellID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append(", column=");
		sb.append(getColumn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Cell_Head");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cellID</column-name><column-value><![CDATA[");
		sb.append(getCellID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column</column-name><column-value><![CDATA[");
		sb.append(getColumn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cellID;
	private long _headID;
	private int _column;
	private BaseModel<?> _cell_HeadRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}