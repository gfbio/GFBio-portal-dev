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
import org.gfbio.service.DataProviderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class DataProviderClp extends BaseModelImpl<DataProvider>
	implements DataProvider {
	public DataProviderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DataProvider.class;
	}

	@Override
	public String getModelClassName() {
		return DataProvider.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dataProviderID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataProviderID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataProviderID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataProviderID", getDataProviderID());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("description", getDescription());
		attributes.put("address", getAddress());
		attributes.put("website", getWebsite());
		attributes.put("training", getTraining());
		attributes.put("physicalobjects", getPhysicalobjects());
		attributes.put("taxonbased", getTaxonbased());
		attributes.put("notaxonbased", getNotaxonbased());
		attributes.put("livingobjects", getLivingobjects());
		attributes.put("deadobjects", getDeadobjects());
		attributes.put("sequencedata", getSequencedata());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataProviderID = (Long)attributes.get("dataProviderID");

		if (dataProviderID != null) {
			setDataProviderID(dataProviderID);
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

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String training = (String)attributes.get("training");

		if (training != null) {
			setTraining(training);
		}

		Boolean physicalobjects = (Boolean)attributes.get("physicalobjects");

		if (physicalobjects != null) {
			setPhysicalobjects(physicalobjects);
		}

		Boolean taxonbased = (Boolean)attributes.get("taxonbased");

		if (taxonbased != null) {
			setTaxonbased(taxonbased);
		}

		Boolean notaxonbased = (Boolean)attributes.get("notaxonbased");

		if (notaxonbased != null) {
			setNotaxonbased(notaxonbased);
		}

		Boolean livingobjects = (Boolean)attributes.get("livingobjects");

		if (livingobjects != null) {
			setLivingobjects(livingobjects);
		}

		Boolean deadobjects = (Boolean)attributes.get("deadobjects");

		if (deadobjects != null) {
			setDeadobjects(deadobjects);
		}

		Boolean sequencedata = (Boolean)attributes.get("sequencedata");

		if (sequencedata != null) {
			setSequencedata(sequencedata);
		}
	}

	@Override
	public long getDataProviderID() {
		return _dataProviderID;
	}

	@Override
	public void setDataProviderID(long dataProviderID) {
		_dataProviderID = dataProviderID;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setDataProviderID", long.class);

				method.invoke(_dataProviderRemoteModel, dataProviderID);
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

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_dataProviderRemoteModel, name);
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

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_dataProviderRemoteModel, label);
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

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_dataProviderRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_dataProviderRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_dataProviderRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTraining() {
		return _training;
	}

	@Override
	public void setTraining(String training) {
		_training = training;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setTraining", String.class);

				method.invoke(_dataProviderRemoteModel, training);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPhysicalobjects() {
		return _physicalobjects;
	}

	@Override
	public boolean isPhysicalobjects() {
		return _physicalobjects;
	}

	@Override
	public void setPhysicalobjects(boolean physicalobjects) {
		_physicalobjects = physicalobjects;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setPhysicalobjects",
						boolean.class);

				method.invoke(_dataProviderRemoteModel, physicalobjects);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTaxonbased() {
		return _taxonbased;
	}

	@Override
	public boolean isTaxonbased() {
		return _taxonbased;
	}

	@Override
	public void setTaxonbased(boolean taxonbased) {
		_taxonbased = taxonbased;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonbased", boolean.class);

				method.invoke(_dataProviderRemoteModel, taxonbased);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNotaxonbased() {
		return _notaxonbased;
	}

	@Override
	public boolean isNotaxonbased() {
		return _notaxonbased;
	}

	@Override
	public void setNotaxonbased(boolean notaxonbased) {
		_notaxonbased = notaxonbased;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setNotaxonbased", boolean.class);

				method.invoke(_dataProviderRemoteModel, notaxonbased);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLivingobjects() {
		return _livingobjects;
	}

	@Override
	public boolean isLivingobjects() {
		return _livingobjects;
	}

	@Override
	public void setLivingobjects(boolean livingobjects) {
		_livingobjects = livingobjects;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setLivingobjects",
						boolean.class);

				method.invoke(_dataProviderRemoteModel, livingobjects);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeadobjects() {
		return _deadobjects;
	}

	@Override
	public boolean isDeadobjects() {
		return _deadobjects;
	}

	@Override
	public void setDeadobjects(boolean deadobjects) {
		_deadobjects = deadobjects;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setDeadobjects", boolean.class);

				method.invoke(_dataProviderRemoteModel, deadobjects);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSequencedata() {
		return _sequencedata;
	}

	@Override
	public boolean isSequencedata() {
		return _sequencedata;
	}

	@Override
	public void setSequencedata(boolean sequencedata) {
		_sequencedata = sequencedata;

		if (_dataProviderRemoteModel != null) {
			try {
				Class<?> clazz = _dataProviderRemoteModel.getClass();

				Method method = clazz.getMethod("setSequencedata", boolean.class);

				method.invoke(_dataProviderRemoteModel, sequencedata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDataProviderRemoteModel() {
		return _dataProviderRemoteModel;
	}

	public void setDataProviderRemoteModel(BaseModel<?> dataProviderRemoteModel) {
		_dataProviderRemoteModel = dataProviderRemoteModel;
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

		Class<?> remoteModelClass = _dataProviderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dataProviderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DataProviderLocalServiceUtil.addDataProvider(this);
		}
		else {
			DataProviderLocalServiceUtil.updateDataProvider(this);
		}
	}

	@Override
	public DataProvider toEscapedModel() {
		return (DataProvider)ProxyUtil.newProxyInstance(DataProvider.class.getClassLoader(),
			new Class[] { DataProvider.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DataProviderClp clone = new DataProviderClp();

		clone.setDataProviderID(getDataProviderID());
		clone.setName(getName());
		clone.setLabel(getLabel());
		clone.setDescription(getDescription());
		clone.setAddress(getAddress());
		clone.setWebsite(getWebsite());
		clone.setTraining(getTraining());
		clone.setPhysicalobjects(getPhysicalobjects());
		clone.setTaxonbased(getTaxonbased());
		clone.setNotaxonbased(getNotaxonbased());
		clone.setLivingobjects(getLivingobjects());
		clone.setDeadobjects(getDeadobjects());
		clone.setSequencedata(getSequencedata());

		return clone;
	}

	@Override
	public int compareTo(DataProvider dataProvider) {
		int value = 0;

		value = getName().compareTo(dataProvider.getName());

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

		if (!(obj instanceof DataProviderClp)) {
			return false;
		}

		DataProviderClp dataProvider = (DataProviderClp)obj;

		long primaryKey = dataProvider.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{dataProviderID=");
		sb.append(getDataProviderID());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", training=");
		sb.append(getTraining());
		sb.append(", physicalobjects=");
		sb.append(getPhysicalobjects());
		sb.append(", taxonbased=");
		sb.append(getTaxonbased());
		sb.append(", notaxonbased=");
		sb.append(getNotaxonbased());
		sb.append(", livingobjects=");
		sb.append(getLivingobjects());
		sb.append(", deadobjects=");
		sb.append(getDeadobjects());
		sb.append(", sequencedata=");
		sb.append(getSequencedata());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.DataProvider");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dataProviderID</column-name><column-value><![CDATA[");
		sb.append(getDataProviderID());
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
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>training</column-name><column-value><![CDATA[");
		sb.append(getTraining());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>physicalobjects</column-name><column-value><![CDATA[");
		sb.append(getPhysicalobjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonbased</column-name><column-value><![CDATA[");
		sb.append(getTaxonbased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notaxonbased</column-name><column-value><![CDATA[");
		sb.append(getNotaxonbased());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>livingobjects</column-name><column-value><![CDATA[");
		sb.append(getLivingobjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deadobjects</column-name><column-value><![CDATA[");
		sb.append(getDeadobjects());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequencedata</column-name><column-value><![CDATA[");
		sb.append(getSequencedata());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dataProviderID;
	private String _name;
	private String _label;
	private String _description;
	private String _address;
	private String _website;
	private String _training;
	private boolean _physicalobjects;
	private boolean _taxonbased;
	private boolean _notaxonbased;
	private boolean _livingobjects;
	private boolean _deadobjects;
	private boolean _sequencedata;
	private BaseModel<?> _dataProviderRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}