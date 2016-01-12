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
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.persistence.Project_UserPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Project_UserClp extends BaseModelImpl<Project_User>
	implements Project_User {
	public Project_UserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Project_User.class;
	}

	@Override
	public String getModelClassName() {
		return Project_User.class.getName();
	}

	@Override
	public Project_UserPK getPrimaryKey() {
		return new Project_UserPK(_projectID, _userID);
	}

	@Override
	public void setPrimaryKey(Project_UserPK primaryKey) {
		setProjectID(primaryKey.projectID);
		setUserID(primaryKey.userID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Project_UserPK(_projectID, _userID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Project_UserPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("userID", getUserID());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_projectID = projectID;

		if (_project_UserRemoteModel != null) {
			try {
				Class<?> clazz = _project_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectID", long.class);

				method.invoke(_project_UserRemoteModel, projectID);
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

		if (_project_UserRemoteModel != null) {
			try {
				Class<?> clazz = _project_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_project_UserRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_project_UserRemoteModel != null) {
			try {
				Class<?> clazz = _project_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_project_UserRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_project_UserRemoteModel != null) {
			try {
				Class<?> clazz = _project_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_project_UserRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProject_UserRemoteModel() {
		return _project_UserRemoteModel;
	}

	public void setProject_UserRemoteModel(BaseModel<?> project_UserRemoteModel) {
		_project_UserRemoteModel = project_UserRemoteModel;
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

		Class<?> remoteModelClass = _project_UserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_project_UserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Project_UserLocalServiceUtil.addProject_User(this);
		}
		else {
			Project_UserLocalServiceUtil.updateProject_User(this);
		}
	}

	@Override
	public Project_User toEscapedModel() {
		return (Project_User)ProxyUtil.newProxyInstance(Project_User.class.getClassLoader(),
			new Class[] { Project_User.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Project_UserClp clone = new Project_UserClp();

		clone.setProjectID(getProjectID());
		clone.setUserID(getUserID());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(Project_User project_User) {
		Project_UserPK primaryKey = project_User.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_UserClp)) {
			return false;
		}

		Project_UserClp project_User = (Project_UserClp)obj;

		Project_UserPK primaryKey = project_User.getPrimaryKey();

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
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Project_User");
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectID;
	private long _userID;
	private Date _startDate;
	private Date _endDate;
	private BaseModel<?> _project_UserRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}