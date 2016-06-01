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

import org.gfbio.model.ResearchObject;
import org.gfbio.model.ResearchObjectModel;
import org.gfbio.model.ResearchObjectSoap;

import org.gfbio.service.persistence.ResearchObjectPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ResearchObject service. Represents a row in the &quot;gfbio_ResearchObject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.ResearchObjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ResearchObjectImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObjectImpl
 * @see org.gfbio.model.ResearchObject
 * @see org.gfbio.model.ResearchObjectModel
 * @generated
 */
@JSON(strict = true)
public class ResearchObjectModelImpl extends BaseModelImpl<ResearchObject>
	implements ResearchObjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a research object model instance should use the {@link org.gfbio.model.ResearchObject} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_ResearchObject";
	public static final Object[][] TABLE_COLUMNS = {
			{ "researchObjectID", Types.BIGINT },
			{ "researchObjectVersion", Types.INTEGER },
			{ "parentResearchObjectID", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "label", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "extendeddata", Types.VARCHAR },
			{ "metadataID", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_ResearchObject (researchObjectID LONG not null,researchObjectVersion INTEGER not null,parentResearchObjectID LONG,name VARCHAR(75) null,label VARCHAR(75) null,description VARCHAR(75) null,extendeddata VARCHAR(75) null,metadataID LONG,primary key (researchObjectID, researchObjectVersion))";
	public static final String TABLE_SQL_DROP = "drop table gfbio_ResearchObject";
	public static final String ORDER_BY_JPQL = " ORDER BY researchObject.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_ResearchObject.name ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.ResearchObject"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.ResearchObject"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.ResearchObject"),
			true);
	public static long LABEL_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long PARENTRESEARCHOBJECTID_COLUMN_BITMASK = 4L;
	public static long RESEARCHOBJECTID_COLUMN_BITMASK = 8L;
	public static long RESEARCHOBJECTVERSION_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ResearchObject toModel(ResearchObjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ResearchObject model = new ResearchObjectImpl();

		model.setResearchObjectID(soapModel.getResearchObjectID());
		model.setResearchObjectVersion(soapModel.getResearchObjectVersion());
		model.setParentResearchObjectID(soapModel.getParentResearchObjectID());
		model.setName(soapModel.getName());
		model.setLabel(soapModel.getLabel());
		model.setDescription(soapModel.getDescription());
		model.setExtendeddata(soapModel.getExtendeddata());
		model.setMetadataID(soapModel.getMetadataID());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ResearchObject> toModels(ResearchObjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ResearchObject> models = new ArrayList<ResearchObject>(soapModels.length);

		for (ResearchObjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.ResearchObject"));

	public ResearchObjectModelImpl() {
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
	public Class<?> getModelClass() {
		return ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return ResearchObject.class.getName();
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
	}

	@JSON
	@Override
	public long getResearchObjectID() {
		return _researchObjectID;
	}

	@Override
	public void setResearchObjectID(long researchObjectID) {
		_columnBitmask |= RESEARCHOBJECTID_COLUMN_BITMASK;

		if (!_setOriginalResearchObjectID) {
			_setOriginalResearchObjectID = true;

			_originalResearchObjectID = _researchObjectID;
		}

		_researchObjectID = researchObjectID;
	}

	public long getOriginalResearchObjectID() {
		return _originalResearchObjectID;
	}

	@JSON
	@Override
	public int getResearchObjectVersion() {
		return _researchObjectVersion;
	}

	@Override
	public void setResearchObjectVersion(int researchObjectVersion) {
		_columnBitmask |= RESEARCHOBJECTVERSION_COLUMN_BITMASK;

		if (!_setOriginalResearchObjectVersion) {
			_setOriginalResearchObjectVersion = true;

			_originalResearchObjectVersion = _researchObjectVersion;
		}

		_researchObjectVersion = researchObjectVersion;
	}

	public int getOriginalResearchObjectVersion() {
		return _originalResearchObjectVersion;
	}

	@JSON
	@Override
	public long getParentResearchObjectID() {
		return _parentResearchObjectID;
	}

	@Override
	public void setParentResearchObjectID(long parentResearchObjectID) {
		_columnBitmask |= PARENTRESEARCHOBJECTID_COLUMN_BITMASK;

		if (!_setOriginalParentResearchObjectID) {
			_setOriginalParentResearchObjectID = true;

			_originalParentResearchObjectID = _parentResearchObjectID;
		}

		_parentResearchObjectID = parentResearchObjectID;
	}

	public long getOriginalParentResearchObjectID() {
		return _originalParentResearchObjectID;
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
	public String getExtendeddata() {
		if (_extendeddata == null) {
			return StringPool.BLANK;
		}
		else {
			return _extendeddata;
		}
	}

	@Override
	public void setExtendeddata(String extendeddata) {
		_extendeddata = extendeddata;
	}

	@JSON
	@Override
	public long getMetadataID() {
		return _metadataID;
	}

	@Override
	public void setMetadataID(long metadataID) {
		_metadataID = metadataID;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ResearchObject toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ResearchObject)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ResearchObjectImpl researchObjectImpl = new ResearchObjectImpl();

		researchObjectImpl.setResearchObjectID(getResearchObjectID());
		researchObjectImpl.setResearchObjectVersion(getResearchObjectVersion());
		researchObjectImpl.setParentResearchObjectID(getParentResearchObjectID());
		researchObjectImpl.setName(getName());
		researchObjectImpl.setLabel(getLabel());
		researchObjectImpl.setDescription(getDescription());
		researchObjectImpl.setExtendeddata(getExtendeddata());
		researchObjectImpl.setMetadataID(getMetadataID());

		researchObjectImpl.resetOriginalValues();

		return researchObjectImpl;
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

		if (!(obj instanceof ResearchObject)) {
			return false;
		}

		ResearchObject researchObject = (ResearchObject)obj;

		ResearchObjectPK primaryKey = researchObject.getPrimaryKey();

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
	public void resetOriginalValues() {
		ResearchObjectModelImpl researchObjectModelImpl = this;

		researchObjectModelImpl._originalResearchObjectID = researchObjectModelImpl._researchObjectID;

		researchObjectModelImpl._setOriginalResearchObjectID = false;

		researchObjectModelImpl._originalResearchObjectVersion = researchObjectModelImpl._researchObjectVersion;

		researchObjectModelImpl._setOriginalResearchObjectVersion = false;

		researchObjectModelImpl._originalParentResearchObjectID = researchObjectModelImpl._parentResearchObjectID;

		researchObjectModelImpl._setOriginalParentResearchObjectID = false;

		researchObjectModelImpl._originalName = researchObjectModelImpl._name;

		researchObjectModelImpl._originalLabel = researchObjectModelImpl._label;

		researchObjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ResearchObject> toCacheModel() {
		ResearchObjectCacheModel researchObjectCacheModel = new ResearchObjectCacheModel();

		researchObjectCacheModel.researchObjectID = getResearchObjectID();

		researchObjectCacheModel.researchObjectVersion = getResearchObjectVersion();

		researchObjectCacheModel.parentResearchObjectID = getParentResearchObjectID();

		researchObjectCacheModel.name = getName();

		String name = researchObjectCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			researchObjectCacheModel.name = null;
		}

		researchObjectCacheModel.label = getLabel();

		String label = researchObjectCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			researchObjectCacheModel.label = null;
		}

		researchObjectCacheModel.description = getDescription();

		String description = researchObjectCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			researchObjectCacheModel.description = null;
		}

		researchObjectCacheModel.extendeddata = getExtendeddata();

		String extendeddata = researchObjectCacheModel.extendeddata;

		if ((extendeddata != null) && (extendeddata.length() == 0)) {
			researchObjectCacheModel.extendeddata = null;
		}

		researchObjectCacheModel.metadataID = getMetadataID();

		return researchObjectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ResearchObject.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ResearchObject.class
		};
	private long _researchObjectID;
	private long _originalResearchObjectID;
	private boolean _setOriginalResearchObjectID;
	private int _researchObjectVersion;
	private int _originalResearchObjectVersion;
	private boolean _setOriginalResearchObjectVersion;
	private long _parentResearchObjectID;
	private long _originalParentResearchObjectID;
	private boolean _setOriginalParentResearchObjectID;
	private String _name;
	private String _originalName;
	private String _label;
	private String _originalLabel;
	private String _description;
	private String _extendeddata;
	private long _metadataID;
	private long _columnBitmask;
	private ResearchObject _escapedModel;
}