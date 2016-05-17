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
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.persistence.ResearchObjectPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class ResearchObjectClp extends BaseModelImpl<ResearchObject>
	implements ResearchObject {
	public ResearchObjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return ResearchObject.class.getName();
	}

	@Override
	public ResearchObjectPK getPrimaryKey() {
		return new ResearchObjectPK(_researchObjectID, _researchObjectVersion);
	}

	@Override
	public void setPrimaryKey(ResearchObjectPK primaryKey) {
		setResearchObjectID(primaryKey.researchObjectID);
		setResearchObjectVersion(primaryKey.researchObjectVersion);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ResearchObjectPK(_researchObjectID, _researchObjectVersion);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ResearchObjectPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("parentResearchObjectID", getParentResearchObjectID());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("description", getDescription());
		attributes.put("extendeddata", getExtendeddata());
		attributes.put("metadataID", getMetadataID());
		attributes.put("licenseID", getLicenseID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Integer researchObjectVersion = (Integer)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}

		Long parentResearchObjectID = (Long)attributes.get(
				"parentResearchObjectID");

		if (parentResearchObjectID != null) {
			setParentResearchObjectID(parentResearchObjectID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String extendeddata = (String)attributes.get("extendeddata");

		if (extendeddata != null) {
			setExtendeddata(extendeddata);
		}

		Long metadataID = (Long)attributes.get("metadataID");

		if (metadataID != null) {
			setMetadataID(metadataID);
		}

		Long licenseID = (Long)attributes.get("licenseID");

		if (licenseID != null) {
			setLicenseID(licenseID);
		}
	}

	@Override
	public long getResearchObjectID() {
		return _researchObjectID;
	}

	@Override
	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectID",
						long.class);

				method.invoke(_researchObjectRemoteModel, researchObjectID);
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

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectVersion",
						int.class);

				method.invoke(_researchObjectRemoteModel, researchObjectVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentResearchObjectID() {
		return _parentResearchObjectID;
	}

	@Override
	public void setParentResearchObjectID(long parentResearchObjectID) {
		_parentResearchObjectID = parentResearchObjectID;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setParentResearchObjectID",
						long.class);

				method.invoke(_researchObjectRemoteModel, parentResearchObjectID);
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

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_researchObjectRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_researchObjectRemoteModel, label);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_researchObjectRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtendeddata() {
		return _extendeddata;
	}

	@Override
	public void setExtendeddata(String extendeddata) {
		_extendeddata = extendeddata;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setExtendeddata", String.class);

				method.invoke(_researchObjectRemoteModel, extendeddata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMetadataID() {
		return _metadataID;
	}

	@Override
	public void setMetadataID(long metadataID) {
		_metadataID = metadataID;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataID", long.class);

				method.invoke(_researchObjectRemoteModel, metadataID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLicenseID() {
		return _licenseID;
	}

	@Override
	public void setLicenseID(long licenseID) {
		_licenseID = licenseID;

		if (_researchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _researchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setLicenseID", long.class);

				method.invoke(_researchObjectRemoteModel, licenseID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getResearchObjectRemoteModel() {
		return _researchObjectRemoteModel;
	}

	public void setResearchObjectRemoteModel(
		BaseModel<?> researchObjectRemoteModel) {
		_researchObjectRemoteModel = researchObjectRemoteModel;
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

		Class<?> remoteModelClass = _researchObjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_researchObjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ResearchObjectLocalServiceUtil.addResearchObject(this);
		}
		else {
			ResearchObjectLocalServiceUtil.updateResearchObject(this);
		}
	}

	@Override
	public ResearchObject toEscapedModel() {
		return (ResearchObject)ProxyUtil.newProxyInstance(ResearchObject.class.getClassLoader(),
			new Class[] { ResearchObject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ResearchObjectClp clone = new ResearchObjectClp();

		clone.setResearchObjectID(getResearchObjectID());
		clone.setResearchObjectVersion(getResearchObjectVersion());
		clone.setParentResearchObjectID(getParentResearchObjectID());
		clone.setName(getName());
		clone.setLabel(getLabel());
		clone.setDescription(getDescription());
		clone.setExtendeddata(getExtendeddata());
		clone.setMetadataID(getMetadataID());
		clone.setLicenseID(getLicenseID());

		return clone;
	}

	@Override
	public int compareTo(ResearchObject researchObject) {
		int value = 0;

		value = getName().compareTo(researchObject.getName());

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

		if (!(obj instanceof ResearchObjectClp)) {
			return false;
		}

		ResearchObjectClp researchObject = (ResearchObjectClp)obj;

		ResearchObjectPK primaryKey = researchObject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{researchObjectID=");
		sb.append(getResearchObjectID());
		sb.append(", researchObjectVersion=");
		sb.append(getResearchObjectVersion());
		sb.append(", parentResearchObjectID=");
		sb.append(getParentResearchObjectID());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", extendeddata=");
		sb.append(getExtendeddata());
		sb.append(", metadataID=");
		sb.append(getMetadataID());
		sb.append(", licenseID=");
		sb.append(getLicenseID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.ResearchObject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>researchObjectID</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchObjectVersion</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentResearchObjectID</column-name><column-value><![CDATA[");
		sb.append(getParentResearchObjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extendeddata</column-name><column-value><![CDATA[");
		sb.append(getExtendeddata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataID</column-name><column-value><![CDATA[");
		sb.append(getMetadataID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>licenseID</column-name><column-value><![CDATA[");
		sb.append(getLicenseID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _researchObjectID;
	private int _researchObjectVersion;
	private long _parentResearchObjectID;
	private String _name;
	private String _label;
	private String _description;
	private String _extendeddata;
	private long _metadataID;
	private long _licenseID;
	private BaseModel<?> _researchObjectRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}