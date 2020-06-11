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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.Project_ResearchObjectModel;
import org.gfbio.model.Project_ResearchObjectSoap;

import org.gfbio.service.persistence.Project_ResearchObjectPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Project_ResearchObject service. Represents a row in the &quot;gfbio_Project_ResearchObject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.Project_ResearchObjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Project_ResearchObjectImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_ResearchObjectImpl
 * @see org.gfbio.model.Project_ResearchObject
 * @see org.gfbio.model.Project_ResearchObjectModel
 * @generated
 */
@JSON(strict = true)
public class Project_ResearchObjectModelImpl extends BaseModelImpl<Project_ResearchObject>
	implements Project_ResearchObjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project_ research object model instance should use the {@link org.gfbio.model.Project_ResearchObject} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_Project_ResearchObject";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectID", Types.BIGINT },
			{ "researchObjectID", Types.BIGINT },
			{ "researchObjectVersion", Types.INTEGER },
			{ "lastmodifieddate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_Project_ResearchObject (projectID LONG not null,researchObjectID LONG not null,researchObjectVersion INTEGER not null,lastmodifieddate DATE null,primary key (projectID, researchObjectID, researchObjectVersion))";
	public static final String TABLE_SQL_DROP = "drop table gfbio_Project_ResearchObject";
	public static final String ORDER_BY_JPQL = " ORDER BY project_ResearchObject.id.projectID ASC, project_ResearchObject.id.researchObjectID ASC, project_ResearchObject.id.researchObjectVersion ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_Project_ResearchObject.projectID ASC, gfbio_Project_ResearchObject.researchObjectID ASC, gfbio_Project_ResearchObject.researchObjectVersion ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.Project_ResearchObject"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.Project_ResearchObject"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.Project_ResearchObject"),
			true);
	public static long PROJECTID_COLUMN_BITMASK = 1L;
	public static long RESEARCHOBJECTID_COLUMN_BITMASK = 2L;
	public static long RESEARCHOBJECTVERSION_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Project_ResearchObject toModel(
		Project_ResearchObjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Project_ResearchObject model = new Project_ResearchObjectImpl();

		model.setProjectID(soapModel.getProjectID());
		model.setResearchObjectID(soapModel.getResearchObjectID());
		model.setResearchObjectVersion(soapModel.getResearchObjectVersion());
		model.setLastModifiedDate(soapModel.getLastModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Project_ResearchObject> toModels(
		Project_ResearchObjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Project_ResearchObject> models = new ArrayList<Project_ResearchObject>(soapModels.length);

		for (Project_ResearchObjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.Project_ResearchObject"));

	public Project_ResearchObjectModelImpl() {
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
	public Class<?> getModelClass() {
		return Project_ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return Project_ResearchObject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("lastModifiedDate", getLastModifiedDate());

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

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
	}

	@JSON
	@Override
	public long getProjectID() {
		return _projectID;
	}

	@Override
	public void setProjectID(long projectID) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectID) {
			_setOriginalProjectID = true;

			_originalProjectID = _projectID;
		}

		_projectID = projectID;
	}

	public long getOriginalProjectID() {
		return _originalProjectID;
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
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Project_ResearchObject toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Project_ResearchObject)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Project_ResearchObjectImpl project_ResearchObjectImpl = new Project_ResearchObjectImpl();

		project_ResearchObjectImpl.setProjectID(getProjectID());
		project_ResearchObjectImpl.setResearchObjectID(getResearchObjectID());
		project_ResearchObjectImpl.setResearchObjectVersion(getResearchObjectVersion());
		project_ResearchObjectImpl.setLastModifiedDate(getLastModifiedDate());

		project_ResearchObjectImpl.resetOriginalValues();

		return project_ResearchObjectImpl;
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

		if (!(obj instanceof Project_ResearchObject)) {
			return false;
		}

		Project_ResearchObject project_ResearchObject = (Project_ResearchObject)obj;

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
	public void resetOriginalValues() {
		Project_ResearchObjectModelImpl project_ResearchObjectModelImpl = this;

		project_ResearchObjectModelImpl._originalProjectID = project_ResearchObjectModelImpl._projectID;

		project_ResearchObjectModelImpl._setOriginalProjectID = false;

		project_ResearchObjectModelImpl._originalResearchObjectID = project_ResearchObjectModelImpl._researchObjectID;

		project_ResearchObjectModelImpl._setOriginalResearchObjectID = false;

		project_ResearchObjectModelImpl._originalResearchObjectVersion = project_ResearchObjectModelImpl._researchObjectVersion;

		project_ResearchObjectModelImpl._setOriginalResearchObjectVersion = false;

		project_ResearchObjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Project_ResearchObject> toCacheModel() {
		Project_ResearchObjectCacheModel project_ResearchObjectCacheModel = new Project_ResearchObjectCacheModel();

		project_ResearchObjectCacheModel.projectID = getProjectID();

		project_ResearchObjectCacheModel.researchObjectID = getResearchObjectID();

		project_ResearchObjectCacheModel.researchObjectVersion = getResearchObjectVersion();

		Date lastModifiedDate = getLastModifiedDate();

		if (lastModifiedDate != null) {
			project_ResearchObjectCacheModel.lastModifiedDate = lastModifiedDate.getTime();
		}
		else {
			project_ResearchObjectCacheModel.lastModifiedDate = Long.MIN_VALUE;
		}

		return project_ResearchObjectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{projectID=");
		sb.append(getProjectID());
		sb.append(", researchObjectID=");
		sb.append(getResearchObjectID());
		sb.append(", researchObjectVersion=");
		sb.append(getResearchObjectVersion());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

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
		sb.append(
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Project_ResearchObject.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Project_ResearchObject.class
		};
	private long _projectID;
	private long _originalProjectID;
	private boolean _setOriginalProjectID;
	private long _researchObjectID;
	private long _originalResearchObjectID;
	private boolean _setOriginalResearchObjectID;
	private int _researchObjectVersion;
	private int _originalResearchObjectVersion;
	private boolean _setOriginalResearchObjectVersion;
	private Date _lastModifiedDate;
	private long _columnBitmask;
	private Project_ResearchObject _escapedModel;
}