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
import org.gfbio.service.HeadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class HeadClp extends BaseModelImpl<Head> implements Head {
	public HeadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Head.class;
	}

	@Override
	public String getModelClassName() {
		return Head.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _headID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHeadID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _headID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("headID", getHeadID());
		attributes.put("name", getName());
		attributes.put("task", getTask());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
		}
	}

	@Override
	public long getHeadID() {
		return _headID;
	}

	@Override
	public void setHeadID(long headID) {
		_headID = headID;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_headRemoteModel, headID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_headRemoteModel, name);
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

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setTask", String.class);

				method.invoke(_headRemoteModel, task);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHeadRemoteModel() {
		return _headRemoteModel;
	}

	public void setHeadRemoteModel(BaseModel<?> headRemoteModel) {
		_headRemoteModel = headRemoteModel;
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

		Class<?> remoteModelClass = _headRemoteModel.getClass();

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

		Object returnValue = method.invoke(_headRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HeadLocalServiceUtil.addHead(this);
		}
		else {
			HeadLocalServiceUtil.updateHead(this);
		}
	}

	@Override
	public Head toEscapedModel() {
		return (Head)ProxyUtil.newProxyInstance(Head.class.getClassLoader(),
			new Class[] { Head.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HeadClp clone = new HeadClp();

		clone.setHeadID(getHeadID());
		clone.setName(getName());
		clone.setTask(getTask());

		return clone;
	}

	@Override
	public int compareTo(Head head) {
		int value = 0;

		value = getName().compareTo(head.getName());

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

		if (!(obj instanceof HeadClp)) {
			return false;
		}

		HeadClp head = (HeadClp)obj;

		long primaryKey = head.getPrimaryKey();

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

		sb.append("{headID=");
		sb.append(getHeadID());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", task=");
		sb.append(getTask());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Head");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>task</column-name><column-value><![CDATA[");
		sb.append(getTask());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _headID;
	private String _name;
	private String _task;
	private BaseModel<?> _headRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}