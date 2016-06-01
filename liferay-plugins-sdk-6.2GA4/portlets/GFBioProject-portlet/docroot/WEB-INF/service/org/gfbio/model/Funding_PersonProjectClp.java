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
import org.gfbio.service.Funding_PersonProjectLocalServiceUtil;
import org.gfbio.service.persistence.Funding_PersonProjectPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Funding_PersonProjectClp extends BaseModelImpl<Funding_PersonProject>
	implements Funding_PersonProject {
	public Funding_PersonProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Funding_PersonProject.class;
	}

	@Override
	public String getModelClassName() {
		return Funding_PersonProject.class.getName();
	}

	@Override
	public Funding_PersonProjectPK getPrimaryKey() {
		return new Funding_PersonProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _personID, _personType);
	}

	@Override
	public void setPrimaryKey(Funding_PersonProjectPK primaryKey) {
		setProjectID(primaryKey.projectID);
		setFundingAgencyID(primaryKey.fundingAgencyID);
		setFundingProgramID(primaryKey.fundingProgramID);
		setPersonID(primaryKey.personID);
		setPersonType(primaryKey.personType);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Funding_PersonProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _personID, _personType);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Funding_PersonProjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("fundingAgencyID", getFundingAgencyID());
		attributes.put("fundingProgramID", getFundingProgramID());
		attributes.put("personID", getPersonID());
		attributes.put("personType", getPersonType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long fundingAgencyID = (Long)attributes.get("fundingAgencyID");

		if (fundingAgencyID != null) {
			setFundingAgencyID(fundingAgencyID);
		}

		Long fundingProgramID = (Long)attributes.get("fundingProgramID");

		if (fundingProgramID != null) {
			setFundingProgramID(fundingProgramID);
		}

		Long personID = (Long)attributes.get("personID");

		if (personID != null) {
			setPersonID(personID);
		}

		String personType = (String)attributes.get("personType");

		if (personType != null) {
			setPersonType(personType);
		}
	}

	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_projectID = projectID;

		if (_funding_PersonProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_PersonProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectID", long.class);

				method.invoke(_funding_PersonProjectRemoteModel, projectID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundingAgencyID() {
		return _fundingAgencyID;
	}

	@Override
	public void setFundingAgencyID(long fundingAgencyID) {
		_fundingAgencyID = fundingAgencyID;

		if (_funding_PersonProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_PersonProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingAgencyID", long.class);

				method.invoke(_funding_PersonProjectRemoteModel, fundingAgencyID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFundingProgramID() {
		return _fundingProgramID;
	}

	@Override
	public void setFundingProgramID(long fundingProgramID) {
		_fundingProgramID = fundingProgramID;

		if (_funding_PersonProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_PersonProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingProgramID",
						long.class);

				method.invoke(_funding_PersonProjectRemoteModel,
					fundingProgramID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPersonID() {
		return _personID;
	}

	@Override
	public void setPersonID(long personID) {
		_personID = personID;

		if (_funding_PersonProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_PersonProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonID", long.class);

				method.invoke(_funding_PersonProjectRemoteModel, personID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonType() {
		return _personType;
	}

	@Override
	public void setPersonType(String personType) {
		_personType = personType;

		if (_funding_PersonProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_PersonProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonType", String.class);

				method.invoke(_funding_PersonProjectRemoteModel, personType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFunding_PersonProjectRemoteModel() {
		return _funding_PersonProjectRemoteModel;
	}

	public void setFunding_PersonProjectRemoteModel(
		BaseModel<?> funding_PersonProjectRemoteModel) {
		_funding_PersonProjectRemoteModel = funding_PersonProjectRemoteModel;
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

		Class<?> remoteModelClass = _funding_PersonProjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_funding_PersonProjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Funding_PersonProjectLocalServiceUtil.addFunding_PersonProject(this);
		}
		else {
			Funding_PersonProjectLocalServiceUtil.updateFunding_PersonProject(this);
		}
	}

	@Override
	public Funding_PersonProject toEscapedModel() {
		return (Funding_PersonProject)ProxyUtil.newProxyInstance(Funding_PersonProject.class.getClassLoader(),
			new Class[] { Funding_PersonProject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Funding_PersonProjectClp clone = new Funding_PersonProjectClp();

		clone.setProjectID(getProjectID());
		clone.setFundingAgencyID(getFundingAgencyID());
		clone.setFundingProgramID(getFundingProgramID());
		clone.setPersonID(getPersonID());
		clone.setPersonType(getPersonType());

		return clone;
	}

	@Override
	public int compareTo(Funding_PersonProject funding_PersonProject) {
		Funding_PersonProjectPK primaryKey = funding_PersonProject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Funding_PersonProjectClp)) {
			return false;
		}

		Funding_PersonProjectClp funding_PersonProject = (Funding_PersonProjectClp)obj;

		Funding_PersonProjectPK primaryKey = funding_PersonProject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{projectID=");
		sb.append(getProjectID());
		sb.append(", fundingAgencyID=");
		sb.append(getFundingAgencyID());
		sb.append(", fundingProgramID=");
		sb.append(getFundingProgramID());
		sb.append(", personID=");
		sb.append(getPersonID());
		sb.append(", personType=");
		sb.append(getPersonType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Funding_PersonProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectID</column-name><column-value><![CDATA[");
		sb.append(getProjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingAgencyID</column-name><column-value><![CDATA[");
		sb.append(getFundingAgencyID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingProgramID</column-name><column-value><![CDATA[");
		sb.append(getFundingProgramID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personID</column-name><column-value><![CDATA[");
		sb.append(getPersonID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personType</column-name><column-value><![CDATA[");
		sb.append(getPersonType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectID;
	private long _fundingAgencyID;
	private long _fundingProgramID;
	private long _personID;
	private String _personType;
	private BaseModel<?> _funding_PersonProjectRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}