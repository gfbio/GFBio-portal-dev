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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project_ResearchObject}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_ResearchObject
 * @generated
 */
public class Project_ResearchObjectWrapper implements Project_ResearchObject,
	ModelWrapper<Project_ResearchObject> {
	public Project_ResearchObjectWrapper(
		Project_ResearchObject project_ResearchObject) {
		_project_ResearchObject = project_ResearchObject;
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
	}

	/**
	* Returns the primary key of this project_ research object.
	*
	* @return the primary key of this project_ research object
	*/
	@Override
	public org.gfbio.service.persistence.Project_ResearchObjectPK getPrimaryKey() {
		return _project_ResearchObject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project_ research object.
	*
	* @param primaryKey the primary key of this project_ research object
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Project_ResearchObjectPK primaryKey) {
		_project_ResearchObject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this project_ research object.
	*
	* @return the project i d of this project_ research object
	*/
	@Override
	public long getProjectID() {
		return _project_ResearchObject.getProjectID();
	}

	/**
	* Sets the project i d of this project_ research object.
	*
	* @param projectID the project i d of this project_ research object
	*/
	@Override
	public void setProjectID(long projectID) {
		_project_ResearchObject.setProjectID(projectID);
	}

	/**
	* Returns the research object i d of this project_ research object.
	*
	* @return the research object i d of this project_ research object
	*/
	@Override
	public long getResearchObjectID() {
		return _project_ResearchObject.getResearchObjectID();
	}

	/**
	* Sets the research object i d of this project_ research object.
	*
	* @param researchObjectID the research object i d of this project_ research object
	*/
	@Override
	public void setResearchObjectID(long researchObjectID) {
		_project_ResearchObject.setResearchObjectID(researchObjectID);
	}

	@Override
	public boolean isNew() {
		return _project_ResearchObject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project_ResearchObject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project_ResearchObject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project_ResearchObject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project_ResearchObject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project_ResearchObject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project_ResearchObject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project_ResearchObject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project_ResearchObject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project_ResearchObject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project_ResearchObject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Project_ResearchObjectWrapper((Project_ResearchObject)_project_ResearchObject.clone());
	}

	@Override
	public int compareTo(
		org.gfbio.model.Project_ResearchObject project_ResearchObject) {
		return _project_ResearchObject.compareTo(project_ResearchObject);
	}

	@Override
	public int hashCode() {
		return _project_ResearchObject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Project_ResearchObject> toCacheModel() {
		return _project_ResearchObject.toCacheModel();
	}

	@Override
	public org.gfbio.model.Project_ResearchObject toEscapedModel() {
		return new Project_ResearchObjectWrapper(_project_ResearchObject.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Project_ResearchObject toUnescapedModel() {
		return new Project_ResearchObjectWrapper(_project_ResearchObject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project_ResearchObject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project_ResearchObject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project_ResearchObject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_ResearchObjectWrapper)) {
			return false;
		}

		Project_ResearchObjectWrapper project_ResearchObjectWrapper = (Project_ResearchObjectWrapper)obj;

		if (Validator.equals(_project_ResearchObject,
					project_ResearchObjectWrapper._project_ResearchObject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project_ResearchObject getWrappedProject_ResearchObject() {
		return _project_ResearchObject;
	}

	@Override
	public Project_ResearchObject getWrappedModel() {
		return _project_ResearchObject;
	}

	@Override
	public void resetOriginalValues() {
		_project_ResearchObject.resetOriginalValues();
	}

	private Project_ResearchObject _project_ResearchObject;
}