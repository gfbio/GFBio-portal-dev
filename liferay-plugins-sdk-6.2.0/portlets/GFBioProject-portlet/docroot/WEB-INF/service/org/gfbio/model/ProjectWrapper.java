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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
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
		attributes.put("extendeddata", getExtendeddata());
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

		String extendeddata = (String)attributes.get("extendeddata");

		if (extendeddata != null) {
			setExtendeddata(extendeddata);
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

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public long getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this project.
	*
	* @return the project i d of this project
	*/
	@Override
	public long getProjectID() {
		return _project.getProjectID();
	}

	/**
	* Sets the project i d of this project.
	*
	* @param projectID the project i d of this project
	*/
	@Override
	public void setProjectID(long projectID) {
		_project.setProjectID(projectID);
	}

	/**
	* Returns the parent project i d of this project.
	*
	* @return the parent project i d of this project
	*/
	@Override
	public long getParentProjectID() {
		return _project.getParentProjectID();
	}

	/**
	* Sets the parent project i d of this project.
	*
	* @param parentProjectID the parent project i d of this project
	*/
	@Override
	public void setParentProjectID(long parentProjectID) {
		_project.setParentProjectID(parentProjectID);
	}

	/**
	* Returns the name of this project.
	*
	* @return the name of this project
	*/
	@Override
	public java.lang.String getName() {
		return _project.getName();
	}

	/**
	* Sets the name of this project.
	*
	* @param name the name of this project
	*/
	@Override
	public void setName(java.lang.String name) {
		_project.setName(name);
	}

	/**
	* Returns the label of this project.
	*
	* @return the label of this project
	*/
	@Override
	public java.lang.String getLabel() {
		return _project.getLabel();
	}

	/**
	* Sets the label of this project.
	*
	* @param label the label of this project
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_project.setLabel(label);
	}

	/**
	* Returns the extendeddata of this project.
	*
	* @return the extendeddata of this project
	*/
	@Override
	public java.lang.String getExtendeddata() {
		return _project.getExtendeddata();
	}

	/**
	* Sets the extendeddata of this project.
	*
	* @param extendeddata the extendeddata of this project
	*/
	@Override
	public void setExtendeddata(java.lang.String extendeddata) {
		_project.setExtendeddata(extendeddata);
	}

	/**
	* Returns the description of this project.
	*
	* @return the description of this project
	*/
	@Override
	public java.lang.String getDescription() {
		return _project.getDescription();
	}

	/**
	* Sets the description of this project.
	*
	* @param description the description of this project
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_project.setDescription(description);
	}

	/**
	* Returns the start date of this project.
	*
	* @return the start date of this project
	*/
	@Override
	public java.util.Date getStartDate() {
		return _project.getStartDate();
	}

	/**
	* Sets the start date of this project.
	*
	* @param startDate the start date of this project
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_project.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project.
	*
	* @return the end date of this project
	*/
	@Override
	public java.util.Date getEndDate() {
		return _project.getEndDate();
	}

	/**
	* Sets the end date of this project.
	*
	* @param endDate the end date of this project
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_project.setEndDate(endDate);
	}

	/**
	* Returns the status of this project.
	*
	* @return the status of this project
	*/
	@Override
	public java.lang.String getStatus() {
		return _project.getStatus();
	}

	/**
	* Sets the status of this project.
	*
	* @param status the status of this project
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_project.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public org.gfbio.model.Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Validator.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project getWrappedProject() {
		return _project;
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private Project _project;
}