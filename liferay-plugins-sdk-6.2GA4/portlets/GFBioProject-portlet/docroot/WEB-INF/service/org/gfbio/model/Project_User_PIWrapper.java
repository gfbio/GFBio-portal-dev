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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project_User_PI}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_User_PI
 * @generated
 */
public class Project_User_PIWrapper implements Project_User_PI,
	ModelWrapper<Project_User_PI> {
	public Project_User_PIWrapper(Project_User_PI project_User_PI) {
		_project_User_PI = project_User_PI;
	}

	@Override
	public Class<?> getModelClass() {
		return Project_User_PI.class;
	}

	@Override
	public String getModelClassName() {
		return Project_User_PI.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("userID", getUserID());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this project_ user_ p i.
	*
	* @return the primary key of this project_ user_ p i
	*/
	@Override
	public org.gfbio.service.persistence.Project_User_PIPK getPrimaryKey() {
		return _project_User_PI.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project_ user_ p i.
	*
	* @param primaryKey the primary key of this project_ user_ p i
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Project_User_PIPK primaryKey) {
		_project_User_PI.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this project_ user_ p i.
	*
	* @return the project i d of this project_ user_ p i
	*/
	@Override
	public long getProjectID() {
		return _project_User_PI.getProjectID();
	}

	/**
	* Sets the project i d of this project_ user_ p i.
	*
	* @param projectID the project i d of this project_ user_ p i
	*/
	@Override
	public void setProjectID(long projectID) {
		_project_User_PI.setProjectID(projectID);
	}

	/**
	* Returns the user i d of this project_ user_ p i.
	*
	* @return the user i d of this project_ user_ p i
	*/
	@Override
	public long getUserID() {
		return _project_User_PI.getUserID();
	}

	/**
	* Sets the user i d of this project_ user_ p i.
	*
	* @param userID the user i d of this project_ user_ p i
	*/
	@Override
	public void setUserID(long userID) {
		_project_User_PI.setUserID(userID);
	}

	/**
	* Returns the start date of this project_ user_ p i.
	*
	* @return the start date of this project_ user_ p i
	*/
	@Override
	public java.util.Date getStartDate() {
		return _project_User_PI.getStartDate();
	}

	/**
	* Sets the start date of this project_ user_ p i.
	*
	* @param startDate the start date of this project_ user_ p i
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_project_User_PI.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project_ user_ p i.
	*
	* @return the end date of this project_ user_ p i
	*/
	@Override
	public java.util.Date getEndDate() {
		return _project_User_PI.getEndDate();
	}

	/**
	* Sets the end date of this project_ user_ p i.
	*
	* @param endDate the end date of this project_ user_ p i
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_project_User_PI.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _project_User_PI.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project_User_PI.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project_User_PI.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project_User_PI.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project_User_PI.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project_User_PI.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project_User_PI.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project_User_PI.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project_User_PI.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project_User_PI.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project_User_PI.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Project_User_PIWrapper((Project_User_PI)_project_User_PI.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Project_User_PI project_User_PI) {
		return _project_User_PI.compareTo(project_User_PI);
	}

	@Override
	public int hashCode() {
		return _project_User_PI.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Project_User_PI> toCacheModel() {
		return _project_User_PI.toCacheModel();
	}

	@Override
	public org.gfbio.model.Project_User_PI toEscapedModel() {
		return new Project_User_PIWrapper(_project_User_PI.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Project_User_PI toUnescapedModel() {
		return new Project_User_PIWrapper(_project_User_PI.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project_User_PI.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project_User_PI.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project_User_PI.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_User_PIWrapper)) {
			return false;
		}

		Project_User_PIWrapper project_User_PIWrapper = (Project_User_PIWrapper)obj;

		if (Validator.equals(_project_User_PI,
					project_User_PIWrapper._project_User_PI)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project_User_PI getWrappedProject_User_PI() {
		return _project_User_PI;
	}

	@Override
	public Project_User_PI getWrappedModel() {
		return _project_User_PI;
	}

	@Override
	public void resetOriginalValues() {
		_project_User_PI.resetOriginalValues();
	}

	private Project_User_PI _project_User_PI;
}