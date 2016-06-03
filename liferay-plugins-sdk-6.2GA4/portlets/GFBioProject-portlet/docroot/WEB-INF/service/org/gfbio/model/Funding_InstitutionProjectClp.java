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
import org.gfbio.service.Funding_InstitutionProjectLocalServiceUtil;
import org.gfbio.service.persistence.Funding_InstitutionProjectPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class Funding_InstitutionProjectClp extends BaseModelImpl<Funding_InstitutionProject>
	implements Funding_InstitutionProject {
	public Funding_InstitutionProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Funding_InstitutionProject.class;
	}

	@Override
	public String getModelClassName() {
		return Funding_InstitutionProject.class.getName();
	}

	@Override
	public Funding_InstitutionProjectPK getPrimaryKey() {
		return new Funding_InstitutionProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _institutionID);
	}

	@Override
	public void setPrimaryKey(Funding_InstitutionProjectPK primaryKey) {
		setProjectID(primaryKey.projectID);
		setFundingAgencyID(primaryKey.fundingAgencyID);
		setFundingProgramID(primaryKey.fundingProgramID);
		setInstitutionID(primaryKey.institutionID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Funding_InstitutionProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _institutionID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Funding_InstitutionProjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("fundingAgencyID", getFundingAgencyID());
		attributes.put("fundingProgramID", getFundingProgramID());
		attributes.put("institutionID", getInstitutionID());

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

		Long institutionID = (Long)attributes.get("institutionID");

		if (institutionID != null) {
			setInstitutionID(institutionID);
		}
	}

	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_projectID = projectID;

		if (_funding_InstitutionProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_InstitutionProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectID", long.class);

				method.invoke(_funding_InstitutionProjectRemoteModel, projectID);
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

		if (_funding_InstitutionProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_InstitutionProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingAgencyID", long.class);

				method.invoke(_funding_InstitutionProjectRemoteModel,
					fundingAgencyID);
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

		if (_funding_InstitutionProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_InstitutionProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingProgramID",
						long.class);

				method.invoke(_funding_InstitutionProjectRemoteModel,
					fundingProgramID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInstitutionID() {
		return _institutionID;
	}

	@Override
	public void setInstitutionID(long institutionID) {
		_institutionID = institutionID;

		if (_funding_InstitutionProjectRemoteModel != null) {
			try {
				Class<?> clazz = _funding_InstitutionProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setInstitutionID", long.class);

				method.invoke(_funding_InstitutionProjectRemoteModel,
					institutionID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFunding_InstitutionProjectRemoteModel() {
		return _funding_InstitutionProjectRemoteModel;
	}

	public void setFunding_InstitutionProjectRemoteModel(
		BaseModel<?> funding_InstitutionProjectRemoteModel) {
		_funding_InstitutionProjectRemoteModel = funding_InstitutionProjectRemoteModel;
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

		Class<?> remoteModelClass = _funding_InstitutionProjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_funding_InstitutionProjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Funding_InstitutionProjectLocalServiceUtil.addFunding_InstitutionProject(this);
		}
		else {
			Funding_InstitutionProjectLocalServiceUtil.updateFunding_InstitutionProject(this);
		}
	}

	@Override
	public Funding_InstitutionProject toEscapedModel() {
		return (Funding_InstitutionProject)ProxyUtil.newProxyInstance(Funding_InstitutionProject.class.getClassLoader(),
			new Class[] { Funding_InstitutionProject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Funding_InstitutionProjectClp clone = new Funding_InstitutionProjectClp();

		clone.setProjectID(getProjectID());
		clone.setFundingAgencyID(getFundingAgencyID());
		clone.setFundingProgramID(getFundingProgramID());
		clone.setInstitutionID(getInstitutionID());

		return clone;
	}

	@Override
	public int compareTo(Funding_InstitutionProject funding_InstitutionProject) {
		Funding_InstitutionProjectPK primaryKey = funding_InstitutionProject.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Funding_InstitutionProjectClp)) {
			return false;
		}

		Funding_InstitutionProjectClp funding_InstitutionProject = (Funding_InstitutionProjectClp)obj;

		Funding_InstitutionProjectPK primaryKey = funding_InstitutionProject.getPrimaryKey();

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
		sb.append(", fundingAgencyID=");
		sb.append(getFundingAgencyID());
		sb.append(", fundingProgramID=");
		sb.append(getFundingProgramID());
		sb.append(", institutionID=");
		sb.append(getInstitutionID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Funding_InstitutionProject");
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
			"<column><column-name>institutionID</column-name><column-value><![CDATA[");
		sb.append(getInstitutionID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectID;
	private long _fundingAgencyID;
	private long _fundingProgramID;
	private long _institutionID;
	private BaseModel<?> _funding_InstitutionProjectRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}