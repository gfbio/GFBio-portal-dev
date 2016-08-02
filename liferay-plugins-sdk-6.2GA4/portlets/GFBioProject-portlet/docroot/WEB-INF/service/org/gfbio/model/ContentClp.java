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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.service.ClpSerializer;
import org.gfbio.service.ContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class ContentClp extends BaseModelImpl<Content> implements Content {
	public ContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Content.class;
	}

	@Override
	public String getModelClassName() {
		return Content.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contentID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContentID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contentID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentID", getContentID());
		attributes.put("headID", getHeadID());
		attributes.put("columnID", getColumnID());
		attributes.put("rowID", getRowID());
		attributes.put("cellContent", getCellContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentID = (Long)attributes.get("contentID");

		if (contentID != null) {
			setContentID(contentID);
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

		String cellContent = (String)attributes.get("cellContent");

		if (cellContent != null) {
			setCellContent(cellContent);
		}
	}

	@Override
	public long getContentID() {
		return _contentID;
	}

	@Override
	public void setContentID(long contentID) {
		_contentID = contentID;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentID", long.class);

				method.invoke(_contentRemoteModel, contentID);
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

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_contentRemoteModel, headID);
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

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnID", long.class);

				method.invoke(_contentRemoteModel, columnID);
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

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setRowID", long.class);

				method.invoke(_contentRemoteModel, rowID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCellContent() {
		return _cellContent;
	}

	@Override
	public void setCellContent(String cellContent) {
		_cellContent = cellContent;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCellContent", String.class);

				method.invoke(_contentRemoteModel, cellContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentRemoteModel() {
		return _contentRemoteModel;
	}

	public void setContentRemoteModel(BaseModel<?> contentRemoteModel) {
		_contentRemoteModel = contentRemoteModel;
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

		Class<?> remoteModelClass = _contentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentLocalServiceUtil.addContent(this);
		}
		else {
			ContentLocalServiceUtil.updateContent(this);
		}
	}

	@Override
	public Content toEscapedModel() {
		return (Content)ProxyUtil.newProxyInstance(Content.class.getClassLoader(),
			new Class[] { Content.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentClp clone = new ContentClp();

		clone.setContentID(getContentID());
		clone.setHeadID(getHeadID());
		clone.setColumnID(getColumnID());
		clone.setRowID(getRowID());
		clone.setCellContent(getCellContent());

		return clone;
	}

	@Override
	public int compareTo(Content content) {
		int value = 0;

		if (getContentID() < content.getContentID()) {
			value = -1;
		}
		else if (getContentID() > content.getContentID()) {
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

		if (!(obj instanceof ContentClp)) {
			return false;
		}

		ContentClp content = (ContentClp)obj;

		long primaryKey = content.getPrimaryKey();

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

		sb.append("{contentID=");
		sb.append(getContentID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append(", columnID=");
		sb.append(getColumnID());
		sb.append(", rowID=");
		sb.append(getRowID());
		sb.append(", cellContent=");
		sb.append(getCellContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Content");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentID</column-name><column-value><![CDATA[");
		sb.append(getContentID());
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
			"<column><column-name>cellContent</column-name><column-value><![CDATA[");
		sb.append(getCellContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentID;
	private long _headID;
	private long _columnID;
	private long _rowID;
	private String _cellContent;
	private BaseModel<?> _contentRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}