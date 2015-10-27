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
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.persistence.SubmissionRegistryPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class SubmissionRegistryClp extends BaseModelImpl<SubmissionRegistry>
	implements SubmissionRegistry {
	public SubmissionRegistryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SubmissionRegistry.class;
	}

	@Override
	public String getModelClassName() {
		return SubmissionRegistry.class.getName();
	}

	@Override
	public SubmissionRegistryPK getPrimaryKey() {
		return new SubmissionRegistryPK(_researchObjectID,
			_researchObjectVersion, _archive);
	}

	@Override
	public void setPrimaryKey(SubmissionRegistryPK primaryKey) {
		setResearchObjectID(primaryKey.researchObjectID);
		setResearchObjectVersion(primaryKey.researchObjectVersion);
		setArchive(primaryKey.archive);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SubmissionRegistryPK(_researchObjectID,
			_researchObjectVersion, _archive);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SubmissionRegistryPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("archive", getArchive());
		attributes.put("brokerSubmissionID", getBrokerSubmissionID());
		attributes.put("archivePID", getArchivePID());
		attributes.put("archivePIDType", getArchivePIDType());
		attributes.put("lastChanged", getLastChanged());
		attributes.put("userID", getUserID());
		attributes.put("isPublic", getIsPublic());
		attributes.put("publicAfter", getPublicAfter());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Long researchObjectVersion = (Long)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}

		String archive = (String)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String brokerSubmissionID = (String)attributes.get("brokerSubmissionID");

		if (brokerSubmissionID != null) {
			setBrokerSubmissionID(brokerSubmissionID);
		}

		String archivePID = (String)attributes.get("archivePID");

		if (archivePID != null) {
			setArchivePID(archivePID);
		}

		Long archivePIDType = (Long)attributes.get("archivePIDType");

		if (archivePIDType != null) {
			setArchivePIDType(archivePIDType);
		}

		Date lastChanged = (Date)attributes.get("lastChanged");

		if (lastChanged != null) {
			setLastChanged(lastChanged);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Date publicAfter = (Date)attributes.get("publicAfter");

		if (publicAfter != null) {
			setPublicAfter(publicAfter);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getResearchObjectID() {
		return _researchObjectID;
	}

	@Override
	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectID",
						long.class);

				method.invoke(_submissionRegistryRemoteModel, researchObjectID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getResearchObjectVersion() {
		return _researchObjectVersion;
	}

	@Override
	public void setResearchObjectVersion(long researchObjectVersion) {
		_researchObjectVersion = researchObjectVersion;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setResearchObjectVersion",
						long.class);

				method.invoke(_submissionRegistryRemoteModel,
					researchObjectVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArchive() {
		return _archive;
	}

	@Override
	public void setArchive(String archive) {
		_archive = archive;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setArchive", String.class);

				method.invoke(_submissionRegistryRemoteModel, archive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBrokerSubmissionID() {
		return _brokerSubmissionID;
	}

	@Override
	public void setBrokerSubmissionID(String brokerSubmissionID) {
		_brokerSubmissionID = brokerSubmissionID;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setBrokerSubmissionID",
						String.class);

				method.invoke(_submissionRegistryRemoteModel, brokerSubmissionID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getArchivePID() {
		return _archivePID;
	}

	@Override
	public void setArchivePID(String archivePID) {
		_archivePID = archivePID;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setArchivePID", String.class);

				method.invoke(_submissionRegistryRemoteModel, archivePID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getArchivePIDType() {
		return _archivePIDType;
	}

	@Override
	public void setArchivePIDType(long archivePIDType) {
		_archivePIDType = archivePIDType;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setArchivePIDType", long.class);

				method.invoke(_submissionRegistryRemoteModel, archivePIDType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastChanged() {
		return _lastChanged;
	}

	@Override
	public void setLastChanged(Date lastChanged) {
		_lastChanged = lastChanged;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastChanged", Date.class);

				method.invoke(_submissionRegistryRemoteModel, lastChanged);
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

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_submissionRegistryRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsPublic() {
		return _isPublic;
	}

	@Override
	public boolean isIsPublic() {
		return _isPublic;
	}

	@Override
	public void setIsPublic(boolean isPublic) {
		_isPublic = isPublic;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPublic", boolean.class);

				method.invoke(_submissionRegistryRemoteModel, isPublic);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublicAfter() {
		return _publicAfter;
	}

	@Override
	public void setPublicAfter(Date publicAfter) {
		_publicAfter = publicAfter;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublicAfter", Date.class);

				method.invoke(_submissionRegistryRemoteModel, publicAfter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_submissionRegistryRemoteModel != null) {
			try {
				Class<?> clazz = _submissionRegistryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_submissionRegistryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubmissionRegistryRemoteModel() {
		return _submissionRegistryRemoteModel;
	}

	public void setSubmissionRegistryRemoteModel(
		BaseModel<?> submissionRegistryRemoteModel) {
		_submissionRegistryRemoteModel = submissionRegistryRemoteModel;
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

		Class<?> remoteModelClass = _submissionRegistryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_submissionRegistryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubmissionRegistryLocalServiceUtil.addSubmissionRegistry(this);
		}
		else {
			SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry(this);
		}
	}

	@Override
	public SubmissionRegistry toEscapedModel() {
		return (SubmissionRegistry)ProxyUtil.newProxyInstance(SubmissionRegistry.class.getClassLoader(),
			new Class[] { SubmissionRegistry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubmissionRegistryClp clone = new SubmissionRegistryClp();

		clone.setResearchObjectID(getResearchObjectID());
		clone.setResearchObjectVersion(getResearchObjectVersion());
		clone.setArchive(getArchive());
		clone.setBrokerSubmissionID(getBrokerSubmissionID());
		clone.setArchivePID(getArchivePID());
		clone.setArchivePIDType(getArchivePIDType());
		clone.setLastChanged(getLastChanged());
		clone.setUserID(getUserID());
		clone.setIsPublic(getIsPublic());
		clone.setPublicAfter(getPublicAfter());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(SubmissionRegistry submissionRegistry) {
		int value = 0;

		if (getResearchObjectID() < submissionRegistry.getResearchObjectID()) {
			value = -1;
		}
		else if (getResearchObjectID() > submissionRegistry.getResearchObjectID()) {
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

		if (!(obj instanceof SubmissionRegistryClp)) {
			return false;
		}

		SubmissionRegistryClp submissionRegistry = (SubmissionRegistryClp)obj;

		SubmissionRegistryPK primaryKey = submissionRegistry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{researchObjectID=");
		sb.append(getResearchObjectID());
		sb.append(", researchObjectVersion=");
		sb.append(getResearchObjectVersion());
		sb.append(", archive=");
		sb.append(getArchive());
		sb.append(", brokerSubmissionID=");
		sb.append(getBrokerSubmissionID());
		sb.append(", archivePID=");
		sb.append(getArchivePID());
		sb.append(", archivePIDType=");
		sb.append(getArchivePIDType());
		sb.append(", lastChanged=");
		sb.append(getLastChanged());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", isPublic=");
		sb.append(getIsPublic());
		sb.append(", publicAfter=");
		sb.append(getPublicAfter());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.SubmissionRegistry");
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
			"<column><column-name>archive</column-name><column-value><![CDATA[");
		sb.append(getArchive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brokerSubmissionID</column-name><column-value><![CDATA[");
		sb.append(getBrokerSubmissionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivePID</column-name><column-value><![CDATA[");
		sb.append(getArchivePID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivePIDType</column-name><column-value><![CDATA[");
		sb.append(getArchivePIDType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastChanged</column-name><column-value><![CDATA[");
		sb.append(getLastChanged());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublic</column-name><column-value><![CDATA[");
		sb.append(getIsPublic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicAfter</column-name><column-value><![CDATA[");
		sb.append(getPublicAfter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _researchObjectID;
	private long _researchObjectVersion;
	private String _archive;
	private String _brokerSubmissionID;
	private String _archivePID;
	private long _archivePIDType;
	private Date _lastChanged;
	private long _userID;
	private boolean _isPublic;
	private Date _publicAfter;
	private String _status;
	private BaseModel<?> _submissionRegistryRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}