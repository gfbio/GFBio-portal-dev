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

import org.gfbio.service.Cell_PositionLocalServiceUtil;
import org.gfbio.service.ClpSerializer;
import org.gfbio.service.persistence.Cell_PositionPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Cell_PositionClp extends BaseModelImpl<Cell_Position>
	implements Cell_Position {
	public Cell_PositionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cell_Position.class;
	}

	@Override
	public String getModelClassName() {
		return Cell_Position.class.getName();
	}

	@Override
	public Cell_PositionPK getPrimaryKey() {
		return new Cell_PositionPK(_cellID, _positionID);
	}

	@Override
	public void setPrimaryKey(Cell_PositionPK primaryKey) {
		setCellID(primaryKey.cellID);
		setPositionID(primaryKey.positionID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Cell_PositionPK(_cellID, _positionID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Cell_PositionPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("positionID", getPositionID());
		attributes.put("column", getColumn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
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

		if (_cell_PositionRemoteModel != null) {
			try {
				Class<?> clazz = _cell_PositionRemoteModel.getClass();

				Method method = clazz.getMethod("setCellID", long.class);

				method.invoke(_cell_PositionRemoteModel, cellID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPositionID() {
		return _positionID;
	}

	@Override
	public void setPositionID(long positionID) {
		_positionID = positionID;

		if (_cell_PositionRemoteModel != null) {
			try {
				Class<?> clazz = _cell_PositionRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionID", long.class);

				method.invoke(_cell_PositionRemoteModel, positionID);
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

		if (_cell_PositionRemoteModel != null) {
			try {
				Class<?> clazz = _cell_PositionRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn", int.class);

				method.invoke(_cell_PositionRemoteModel, column);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCell_PositionRemoteModel() {
		return _cell_PositionRemoteModel;
	}

	public void setCell_PositionRemoteModel(
		BaseModel<?> cell_PositionRemoteModel) {
		_cell_PositionRemoteModel = cell_PositionRemoteModel;
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

		Class<?> remoteModelClass = _cell_PositionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cell_PositionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Cell_PositionLocalServiceUtil.addCell_Position(this);
		}
		else {
			Cell_PositionLocalServiceUtil.updateCell_Position(this);
		}
	}

	@Override
	public Cell_Position toEscapedModel() {
		return (Cell_Position)ProxyUtil.newProxyInstance(Cell_Position.class.getClassLoader(),
			new Class[] { Cell_Position.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Cell_PositionClp clone = new Cell_PositionClp();

		clone.setCellID(getCellID());
		clone.setPositionID(getPositionID());
		clone.setColumn(getColumn());

		return clone;
	}

	@Override
	public int compareTo(Cell_Position cell_Position) {
		Cell_PositionPK primaryKey = cell_Position.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cell_PositionClp)) {
			return false;
		}

		Cell_PositionClp cell_Position = (Cell_PositionClp)obj;

		Cell_PositionPK primaryKey = cell_Position.getPrimaryKey();

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
		sb.append(", positionID=");
		sb.append(getPositionID());
		sb.append(", column=");
		sb.append(getColumn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Cell_Position");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cellID</column-name><column-value><![CDATA[");
		sb.append(getCellID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionID</column-name><column-value><![CDATA[");
		sb.append(getPositionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column</column-name><column-value><![CDATA[");
		sb.append(getColumn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cellID;
	private long _positionID;
	private int _column;
	private BaseModel<?> _cell_PositionRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}