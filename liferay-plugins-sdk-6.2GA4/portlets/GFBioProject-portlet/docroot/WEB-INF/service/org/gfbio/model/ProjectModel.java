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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Project service. Represents a row in the &quot;gfbio_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.ProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.ProjectImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project
 * @see org.gfbio.model.impl.ProjectImpl
 * @see org.gfbio.model.impl.ProjectModelImpl
 * @generated
 */
public interface ProjectModel extends BaseModel<Project> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project model instance should use the {@link Project} interface instead.
	 */

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project i d of this project.
	 *
	 * @return the project i d of this project
	 */
	public long getProjectID();

	/**
	 * Sets the project i d of this project.
	 *
	 * @param projectID the project i d of this project
	 */
	public void setProjectID(long projectID);

	/**
	 * Returns the parent project i d of this project.
	 *
	 * @return the parent project i d of this project
	 */
	public long getParentProjectID();

	/**
	 * Sets the parent project i d of this project.
	 *
	 * @param parentProjectID the parent project i d of this project
	 */
	public void setParentProjectID(long parentProjectID);

	/**
	 * Returns the name of this project.
	 *
	 * @return the name of this project
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this project.
	 *
	 * @param name the name of this project
	 */
	public void setName(String name);

	/**
	 * Returns the label of this project.
	 *
	 * @return the label of this project
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this project.
	 *
	 * @param label the label of this project
	 */
	public void setLabel(String label);

	/**
	 * Returns the extendeddata of this project.
	 *
	 * @return the extendeddata of this project
	 */
	@AutoEscape
	public String getExtendeddata();

	/**
	 * Sets the extendeddata of this project.
	 *
	 * @param extendeddata the extendeddata of this project
	 */
	public void setExtendeddata(String extendeddata);

	/**
	 * Returns the description of this project.
	 *
	 * @return the description of this project
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this project.
	 *
	 * @param description the description of this project
	 */
	public void setDescription(String description);

	/**
	 * Returns the start date of this project.
	 *
	 * @return the start date of this project
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this project.
	 *
	 * @param startDate the start date of this project
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this project.
	 *
	 * @return the end date of this project
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this project.
	 *
	 * @param endDate the end date of this project
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the status of this project.
	 *
	 * @return the status of this project
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this project.
	 *
	 * @param status the status of this project
	 */
	public void setStatus(String status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(org.gfbio.model.Project project);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.gfbio.model.Project> toCacheModel();

	@Override
	public org.gfbio.model.Project toEscapedModel();

	@Override
	public org.gfbio.model.Project toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}