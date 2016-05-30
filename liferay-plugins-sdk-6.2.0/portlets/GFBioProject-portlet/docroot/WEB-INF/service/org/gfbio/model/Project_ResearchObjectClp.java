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
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.persistence.Project_ResearchObjectPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Project_ResearchObjectClp extends BaseModelImpl<Project_ResearchObject>
	implements Project_ResearchObject {
	public Project_ResearchObjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Project_ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return Project_ResearchObject.class.getName();
	}

	@Override
	public Project_ResearchObjectPK getPrimaryKey() {
		return new Project_ResearchObjectPK(_projectID, _researchObjectID,
			_researchObjectVersion);
	}

	@Override
	public void setPrimaryKey(Project_ResearchObjectPK primaryKey) {
		setProjectID(primaryKey.projectID);
		setResearchObjectID(primaryKey.researchObjectID);
		setResearchObjectVersion(primaryKey.researchObjectVersion);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Project_ResearchObjectPK(_projectID, _researchObjectID,
			_researchObjectVersion);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Project_ResearchObjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Integer researchObjectVersion = (Integer)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}
	}

	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_projectID = projectID;

		if (_project_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _project_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectID", long.class);

				method.invoke(_project_ResearchObjectRemoteModel, projectID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResearchObjectID() {
		return _researchObjectID;
	}

	@Override
	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;

		if (_project_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _project_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectID",
						long.class);

				method.invoke(_project_ResearchObjectRemoteModel,
					researchObjectID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResearchObjectVersion() {
		return _researchObjectVersion;
	}

	@Override
	public void setResearchObjectVersion(int researchObjectVersion) {
		_researchObjectVersion = researchObjectVersion;

		if (_project_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _project_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectVersion",
						int.class);

				method.invoke(_project_ResearchObjectRemoteModel,
					researchObjectVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProject_ResearchObjectRemoteModel() {
		return _project_ResearchObjectRemoteModel;
	}

	public void setProject_ResearchObjectRemoteModel(
		BaseModel<?> project_ResearchObjectRemoteModel) {
		_project_ResearchObjectRemoteModel = project_ResearchObjectRemoteModel;
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

		Class<?> remoteModelClass = _project_ResearchObjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_project_ResearchObjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Project_ResearchObjectLocalServiceUtil.addProject_ResearchObject(this);
		}
		else {
			Project_ResearchObjectLocalServiceUtil.updateProject_ResearchObject(this);
		}
	}

	@Override
	public Project_ResearchObject toEscapedModel() {
		return (Project_ResearchObject)ProxyUtil.newProxyInstance(Project_ResearchObject.class.getClassLoader(),
			new Class[] { Project_ResearchObject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Project_ResearchObjectClp clone = new Project_ResearchObjectClp();

		clone.setProjectID(getProjectID());
		clone.setResearchObjectID(getResearchObjectID());
		clone.setResearchObjectVersion(getResearchObjectVersion());

		return clone;
	}

	@Override
	public int compareTo(Project_ResearchObject project_ResearchObject) {
		Project_ResearchObjectPK primaryKey = project_ResearchObject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_ResearchObjectClp)) {
			return false;
		}

		Project_ResearchObjectClp project_ResearchObject = (Project_ResearchObjectClp)obj;

		Project_ResearchObjectPK primaryKey = project_ResearchObject.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{projectID=");
		sb.append(getProjectID());
		sb.append(", researchObjectID=");
		sb.append(getResearchObjectID());
		sb.append(", researchObjectVersion=");
		sb.append(getResearchObjectVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Project_ResearchObject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectID</column-name><column-value><![CDATA[");
		sb.append(getProjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchObjectID</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchObjectVersion</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectID;
	private long _researchObjectID;
	private int _researchObjectVersion;
	private BaseModel<?> _project_ResearchObjectRemoteModel;
}