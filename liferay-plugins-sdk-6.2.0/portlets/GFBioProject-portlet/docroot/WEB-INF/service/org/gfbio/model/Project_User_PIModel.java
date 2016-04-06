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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.gfbio.service.persistence.Project_User_PIPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Project_User_PI service. Represents a row in the &quot;gfbio_Project_User_PI&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.Project_User_PIModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.Project_User_PIImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_User_PI
 * @see org.gfbio.model.impl.Project_User_PIImpl
 * @see org.gfbio.model.impl.Project_User_PIModelImpl
 * @generated
 */
public interface Project_User_PIModel extends BaseModel<Project_User_PI> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project_ user_ p i model instance should use the {@link Project_User_PI} interface instead.
	 */

	/**
	 * Returns the primary key of this project_ user_ p i.
	 *
	 * @return the primary key of this project_ user_ p i
	 */
	public Project_User_PIPK getPrimaryKey();

	/**
	 * Sets the primary key of this project_ user_ p i.
	 *
	 * @param primaryKey the primary key of this project_ user_ p i
	 */
	public void setPrimaryKey(Project_User_PIPK primaryKey);

	/**
	 * Returns the project i d of this project_ user_ p i.
	 *
	 * @return the project i d of this project_ user_ p i
	 */
	public long getProjectID();

	/**
	 * Sets the project i d of this project_ user_ p i.
	 *
	 * @param projectID the project i d of this project_ user_ p i
	 */
	public void setProjectID(long projectID);

	/**
	 * Returns the user i d of this project_ user_ p i.
	 *
	 * @return the user i d of this project_ user_ p i
	 */
	public long getUserID();

	/**
	 * Sets the user i d of this project_ user_ p i.
	 *
	 * @param userID the user i d of this project_ user_ p i
	 */
	public void setUserID(long userID);

	/**
	 * Returns the start date of this project_ user_ p i.
	 *
	 * @return the start date of this project_ user_ p i
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this project_ user_ p i.
	 *
	 * @param startDate the start date of this project_ user_ p i
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this project_ user_ p i.
	 *
	 * @return the end date of this project_ user_ p i
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this project_ user_ p i.
	 *
	 * @param endDate the end date of this project_ user_ p i
	 */
	public void setEndDate(Date endDate);

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
	public int compareTo(Project_User_PI project_User_PI);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Project_User_PI> toCacheModel();

	@Override
	public Project_User_PI toEscapedModel();

	@Override
	public Project_User_PI toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}