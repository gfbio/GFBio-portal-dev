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
import org.gfbio.service.Project_User_WorkerLocalServiceUtil;
import org.gfbio.service.persistence.Project_User_WorkerPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author froemm
 */
public class Project_User_WorkerClp extends BaseModelImpl<Project_User_Worker>
	implements Project_User_Worker {
	public Project_User_WorkerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Project_User_Worker.class;
	}

	@Override
	public String getModelClassName() {
		return Project_User_Worker.class.getName();
	}

	@Override
	public Project_User_WorkerPK getPrimaryKey() {
		return new Project_User_WorkerPK(_projectID, _userID);
	}

	@Override
	public void setPrimaryKey(Project_User_WorkerPK primaryKey) {
		setProjectID(primaryKey.projectID);
		setUserID(primaryKey.userID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Project_User_WorkerPK(_projectID, _userID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Project_User_WorkerPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("userID", getUserID());
		attributes.put("begin", getBegin());
		attributes.put("end", getEnd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		Date begin = (Date)attributes.get("begin");

		if (begin != null) {
			setBegin(begin);
		}

		Date end = (Date)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}
	}

	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_projectID = projectID;

		if (_project_User_WorkerRemoteModel != null) {
			try {
				Class<?> clazz = _project_User_WorkerRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectID", long.class);

				method.invoke(_project_User_WorkerRemoteModel, projectID);
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

		if (_project_User_WorkerRemoteModel != null) {
			try {
				Class<?> clazz = _project_User_WorkerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_project_User_WorkerRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBegin() {
		return _begin;
	}

	@Override
	public void setBegin(Date begin) {
		_begin = begin;

		if (_project_User_WorkerRemoteModel != null) {
			try {
				Class<?> clazz = _project_User_WorkerRemoteModel.getClass();

				Method method = clazz.getMethod("setBegin", Date.class);

				method.invoke(_project_User_WorkerRemoteModel, begin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEnd() {
		return _end;
	}

	@Override
	public void setEnd(Date end) {
		_end = end;

		if (_project_User_WorkerRemoteModel != null) {
			try {
				Class<?> clazz = _project_User_WorkerRemoteModel.getClass();

				Method method = clazz.getMethod("setEnd", Date.class);

				method.invoke(_project_User_WorkerRemoteModel, end);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProject_User_WorkerRemoteModel() {
		return _project_User_WorkerRemoteModel;
	}

	public void setProject_User_WorkerRemoteModel(
		BaseModel<?> project_User_WorkerRemoteModel) {
		_project_User_WorkerRemoteModel = project_User_WorkerRemoteModel;
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

		Class<?> remoteModelClass = _project_User_WorkerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_project_User_WorkerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Project_User_WorkerLocalServiceUtil.addProject_User_Worker(this);
		}
		else {
			Project_User_WorkerLocalServiceUtil.updateProject_User_Worker(this);
		}
	}

	@Override
	public Project_User_Worker toEscapedModel() {
		return (Project_User_Worker)ProxyUtil.newProxyInstance(Project_User_Worker.class.getClassLoader(),
			new Class[] { Project_User_Worker.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Project_User_WorkerClp clone = new Project_User_WorkerClp();

		clone.setProjectID(getProjectID());
		clone.setUserID(getUserID());
		clone.setBegin(getBegin());
		clone.setEnd(getEnd());

		return clone;
	}

	@Override
	public int compareTo(Project_User_Worker project_User_Worker) {
		Project_User_WorkerPK primaryKey = project_User_Worker.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_User_WorkerClp)) {
			return false;
		}

		Project_User_WorkerClp project_User_Worker = (Project_User_WorkerClp)obj;

		Project_User_WorkerPK primaryKey = project_User_Worker.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{projectID=");
		sb.append(getProjectID());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", begin=");
		sb.append(getBegin());
		sb.append(", end=");
		sb.append(getEnd());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Project_User_Worker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectID</column-name><column-value><![CDATA[");
		sb.append(getProjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>begin</column-name><column-value><![CDATA[");
		sb.append(getBegin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>end</column-name><column-value><![CDATA[");
		sb.append(getEnd());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectID;
	private long _userID;
	private Date _begin;
	private Date _end;
	private BaseModel<?> _project_User_WorkerRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}