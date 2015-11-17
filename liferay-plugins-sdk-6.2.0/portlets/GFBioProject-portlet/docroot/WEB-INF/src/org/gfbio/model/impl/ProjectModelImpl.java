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

import org.gfbio.model.Project;
import org.gfbio.model.ProjectModel;
import org.gfbio.model.ProjectSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Project service. Represents a row in the &quot;gfbio_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.ProjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see ProjectImpl
 * @see org.gfbio.model.Project
 * @see org.gfbio.model.ProjectModel
 * @generated
 */
@JSON(strict = true)
public class ProjectModelImpl extends BaseModelImpl<Project>
	implements ProjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project model instance should use the {@link org.gfbio.model.Project} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_Project";
	public static final Object[][] TABLE_COLUMNS = {
			{ "projectID", Types.BIGINT },
			{ "parentProjectID", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "label", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_Project (projectID LONG not null primary key,parentProjectID LONG,name VARCHAR(75) null,label VARCHAR(75) null,description VARCHAR(75) null,startDate DATE null,endDate DATE null,status VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_Project";
	public static final String ORDER_BY_JPQL = " ORDER BY project.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_Project.name ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.Project"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.Project"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.Project"),
			true);
	public static long LABEL_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long PARENTPROJECTID_COLUMN_BITMASK = 4L;
	public static long PROJECTID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Project toModel(ProjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Project model = new ProjectImpl();

		model.setProjectID(soapModel.getProjectID());
		model.setParentProjectID(soapModel.getParentProjectID());
		model.setName(soapModel.getName());
		model.setLabel(soapModel.getLabel());
		model.setDescription(soapModel.getDescription());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Project> toModels(ProjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Project> models = new ArrayList<Project>(soapModels.length);

		for (ProjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.Project"));

	public ProjectModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("parentProjectID", getParentProjectID());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("description", getDescription());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long parentProjectID = (Long)attributes.get("parentProjectID");

		if (parentProjectID != null) {
			setParentProjectID(parentProjectID);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public long getParentProjectID() {
		return _parentProjectID;
	}

	@Override
	public void setParentProjectID(long parentProjectID) {
		_columnBitmask |= PARENTPROJECTID_COLUMN_BITMASK;

		if (!_setOriginalParentProjectID) {
			_setOriginalParentProjectID = true;

			_originalParentProjectID = _parentProjectID;
		}

		_parentProjectID = parentProjectID;
	}

	public long getOriginalParentProjectID() {
		return _originalParentProjectID;
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
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Project.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Project toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Project)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setProjectID(getProjectID());
		projectImpl.setParentProjectID(getParentProjectID());
		projectImpl.setName(getName());
		projectImpl.setLabel(getLabel());
		projectImpl.setDescription(getDescription());
		projectImpl.setStartDate(getStartDate());
		projectImpl.setEndDate(getEndDate());
		projectImpl.setStatus(getStatus());

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public int compareTo(Project project) {
		int value = 0;

		value = getName().compareTo(project.getName());

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

		if (!(obj instanceof Project)) {
			return false;
		}

		Project project = (Project)obj;

		long primaryKey = project.getPrimaryKey();

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
		ProjectModelImpl projectModelImpl = this;

		projectModelImpl._originalProjectID = projectModelImpl._projectID;

		projectModelImpl._setOriginalProjectID = false;

		projectModelImpl._originalParentProjectID = projectModelImpl._parentProjectID;

		projectModelImpl._setOriginalParentProjectID = false;

		projectModelImpl._originalName = projectModelImpl._name;

		projectModelImpl._originalLabel = projectModelImpl._label;

		projectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Project> toCacheModel() {
		ProjectCacheModel projectCacheModel = new ProjectCacheModel();

		projectCacheModel.projectID = getProjectID();

		projectCacheModel.parentProjectID = getParentProjectID();

		projectCacheModel.name = getName();

		String name = projectCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			projectCacheModel.name = null;
		}

		projectCacheModel.label = getLabel();

		String label = projectCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			projectCacheModel.label = null;
		}

		projectCacheModel.description = getDescription();

		String description = projectCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			projectCacheModel.description = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			projectCacheModel.startDate = startDate.getTime();
		}
		else {
			projectCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			projectCacheModel.endDate = endDate.getTime();
		}
		else {
			projectCacheModel.endDate = Long.MIN_VALUE;
		}

		projectCacheModel.status = getStatus();

		String status = projectCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			projectCacheModel.status = null;
		}

		return projectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{projectID=");
		sb.append(getProjectID());
		sb.append(", parentProjectID=");
		sb.append(getParentProjectID());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectID</column-name><column-value><![CDATA[");
		sb.append(getProjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentProjectID</column-name><column-value><![CDATA[");
		sb.append(getParentProjectID());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Project.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Project.class
		};
	private long _projectID;
	private long _originalProjectID;
	private boolean _setOriginalProjectID;
	private long _parentProjectID;
	private long _originalParentProjectID;
	private boolean _setOriginalParentProjectID;
	private String _name;
	private String _originalName;
	private String _label;
	private String _originalLabel;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private String _status;
	private long _columnBitmask;
	private Project _escapedModel;
}