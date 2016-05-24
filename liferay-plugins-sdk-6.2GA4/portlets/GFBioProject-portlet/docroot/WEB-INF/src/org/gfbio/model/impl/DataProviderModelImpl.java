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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gfbio.model.DataProvider;
import org.gfbio.model.DataProviderModel;
import org.gfbio.model.DataProviderSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DataProvider service. Represents a row in the &quot;gfbio_DataProvider&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.DataProviderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataProviderImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProviderImpl
 * @see org.gfbio.model.DataProvider
 * @see org.gfbio.model.DataProviderModel
 * @generated
 */
@JSON(strict = true)
public class DataProviderModelImpl extends BaseModelImpl<DataProvider>
	implements DataProviderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data provider model instance should use the {@link org.gfbio.model.DataProvider} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_DataProvider";
	public static final Object[][] TABLE_COLUMNS = {
			{ "dataProviderID", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "label", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "training", Types.VARCHAR },
			{ "physicalobjects", Types.BOOLEAN },
			{ "taxonbased", Types.BOOLEAN },
			{ "notaxonbased", Types.BOOLEAN },
			{ "livingobjects", Types.BOOLEAN },
			{ "deadobjects", Types.BOOLEAN },
			{ "sequencedata", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_DataProvider (dataProviderID LONG not null primary key,name VARCHAR(75) null,label VARCHAR(75) null,description VARCHAR(75) null,address VARCHAR(75) null,website VARCHAR(75) null,training VARCHAR(75) null,physicalobjects BOOLEAN,taxonbased BOOLEAN,notaxonbased BOOLEAN,livingobjects BOOLEAN,deadobjects BOOLEAN,sequencedata BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_DataProvider";
	public static final String ORDER_BY_JPQL = " ORDER BY dataProvider.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_DataProvider.name ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.DataProvider"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.DataProvider"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.DataProvider"),
			true);
	public static long DATAPROVIDERID_COLUMN_BITMASK = 1L;
	public static long LABEL_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DataProvider toModel(DataProviderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DataProvider model = new DataProviderImpl();

		model.setDataProviderID(soapModel.getDataProviderID());
		model.setName(soapModel.getName());
		model.setLabel(soapModel.getLabel());
		model.setDescription(soapModel.getDescription());
		model.setAddress(soapModel.getAddress());
		model.setWebsite(soapModel.getWebsite());
		model.setTraining(soapModel.getTraining());
		model.setPhysicalobjects(soapModel.getPhysicalobjects());
		model.setTaxonbased(soapModel.getTaxonbased());
		model.setNotaxonbased(soapModel.getNotaxonbased());
		model.setLivingobjects(soapModel.getLivingobjects());
		model.setDeadobjects(soapModel.getDeadobjects());
		model.setSequencedata(soapModel.getSequencedata());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DataProvider> toModels(DataProviderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DataProvider> models = new ArrayList<DataProvider>(soapModels.length);

		for (DataProviderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.DataProvider"));

	public DataProviderModelImpl() {
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
	public Class<?> getModelClass() {
		return DataProvider.class;
	}

	@Override
	public String getModelClassName() {
		return DataProvider.class.getName();
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

	@JSON
	@Override
	public long getDataProviderID() {
		return _dataProviderID;
	}

	@Override
	public void setDataProviderID(long dataProviderID) {
		_columnBitmask |= DATAPROVIDERID_COLUMN_BITMASK;

		if (!_setOriginalDataProviderID) {
			_setOriginalDataProviderID = true;

			_originalDataProviderID = _dataProviderID;
		}

		_dataProviderID = dataProviderID;
	}

	public long getOriginalDataProviderID() {
		return _originalDataProviderID;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getLabel() {
		if (_label == null) {
			return StringPool.BLANK;
		}
		else {
			return _label;
		}
	}

	@Override
	public void setLabel(String label) {
		_columnBitmask |= LABEL_COLUMN_BITMASK;

		if (_originalLabel == null) {
			_originalLabel = _label;
		}

		_label = label;
	}

	public String getOriginalLabel() {
		return GetterUtil.getString(_originalLabel);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		_website = website;
	}

	@JSON
	@Override
	public String getTraining() {
		if (_training == null) {
			return StringPool.BLANK;
		}
		else {
			return _training;
		}
	}

	@Override
	public void setTraining(String training) {
		_training = training;
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DataProvider.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DataProvider toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DataProvider)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataProviderImpl dataProviderImpl = new DataProviderImpl();

		dataProviderImpl.setDataProviderID(getDataProviderID());
		dataProviderImpl.setName(getName());
		dataProviderImpl.setLabel(getLabel());
		dataProviderImpl.setDescription(getDescription());
		dataProviderImpl.setAddress(getAddress());
		dataProviderImpl.setWebsite(getWebsite());
		dataProviderImpl.setTraining(getTraining());
		dataProviderImpl.setPhysicalobjects(getPhysicalobjects());
		dataProviderImpl.setTaxonbased(getTaxonbased());
		dataProviderImpl.setNotaxonbased(getNotaxonbased());
		dataProviderImpl.setLivingobjects(getLivingobjects());
		dataProviderImpl.setDeadobjects(getDeadobjects());
		dataProviderImpl.setSequencedata(getSequencedata());

		dataProviderImpl.resetOriginalValues();

		return dataProviderImpl;
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

		if (!(obj instanceof DataProvider)) {
			return false;
		}

		DataProvider dataProvider = (DataProvider)obj;

		long primaryKey = dataProvider.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DataProviderModelImpl dataProviderModelImpl = this;

		dataProviderModelImpl._originalDataProviderID = dataProviderModelImpl._dataProviderID;

		dataProviderModelImpl._setOriginalDataProviderID = false;

		dataProviderModelImpl._originalName = dataProviderModelImpl._name;

		dataProviderModelImpl._originalLabel = dataProviderModelImpl._label;

		dataProviderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DataProvider> toCacheModel() {
		DataProviderCacheModel dataProviderCacheModel = new DataProviderCacheModel();

		dataProviderCacheModel.dataProviderID = getDataProviderID();

		dataProviderCacheModel.name = getName();

		String name = dataProviderCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			dataProviderCacheModel.name = null;
		}

		dataProviderCacheModel.label = getLabel();

		String label = dataProviderCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			dataProviderCacheModel.label = null;
		}

		dataProviderCacheModel.description = getDescription();

		String description = dataProviderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dataProviderCacheModel.description = null;
		}

		dataProviderCacheModel.address = getAddress();

		String address = dataProviderCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			dataProviderCacheModel.address = null;
		}

		dataProviderCacheModel.website = getWebsite();

		String website = dataProviderCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			dataProviderCacheModel.website = null;
		}

		dataProviderCacheModel.training = getTraining();

		String training = dataProviderCacheModel.training;

		if ((training != null) && (training.length() == 0)) {
			dataProviderCacheModel.training = null;
		}

		dataProviderCacheModel.physicalobjects = getPhysicalobjects();

		dataProviderCacheModel.taxonbased = getTaxonbased();

		dataProviderCacheModel.notaxonbased = getNotaxonbased();

		dataProviderCacheModel.livingobjects = getLivingobjects();

		dataProviderCacheModel.deadobjects = getDeadobjects();

		dataProviderCacheModel.sequencedata = getSequencedata();

		return dataProviderCacheModel;
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

	private static ClassLoader _classLoader = DataProvider.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DataProvider.class
		};
	private long _dataProviderID;
	private long _originalDataProviderID;
	private boolean _setOriginalDataProviderID;
	private String _name;
	private String _originalName;
	private String _label;
	private String _originalLabel;
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
	private long _columnBitmask;
	private DataProvider _escapedModel;
}