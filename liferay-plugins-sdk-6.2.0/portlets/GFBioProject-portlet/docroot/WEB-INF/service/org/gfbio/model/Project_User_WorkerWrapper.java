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
 * This class is a wrapper for {@link Project_User_Worker}.
 * </p>
 *
 * @author froemm
 * @see Project_User_Worker
 * @generated
 */
public class Project_User_WorkerWrapper implements Project_User_Worker,
	ModelWrapper<Project_User_Worker> {
	public Project_User_WorkerWrapper(Project_User_Worker project_User_Worker) {
		_project_User_Worker = project_User_Worker;
	}

	@Override
	public Class<?> getModelClass() {
		return Project_User_Worker.class;
	}

	@Override
	public String getModelClassName() {
		return Project_User_Worker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("userID", getUserID());
		attributes.put("begin", getBegin());
		attributes.put("end", getEnd());

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

		Date begin = (Date)attributes.get("begin");

		if (begin != null) {
			setBegin(begin);
		}

		Date end = (Date)attributes.get("end");

		if (end != null) {
			setEnd(end);
		}
	}

	/**
	* Returns the primary key of this project_ user_ worker.
	*
	* @return the primary key of this project_ user_ worker
	*/
	@Override
	public org.gfbio.service.persistence.Project_User_WorkerPK getPrimaryKey() {
		return _project_User_Worker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project_ user_ worker.
	*
	* @param primaryKey the primary key of this project_ user_ worker
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Project_User_WorkerPK primaryKey) {
		_project_User_Worker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this project_ user_ worker.
	*
	* @return the project i d of this project_ user_ worker
	*/
	@Override
	public long getProjectID() {
		return _project_User_Worker.getProjectID();
	}

	/**
	* Sets the project i d of this project_ user_ worker.
	*
	* @param projectID the project i d of this project_ user_ worker
	*/
	@Override
	public void setProjectID(long projectID) {
		_project_User_Worker.setProjectID(projectID);
	}

	/**
	* Returns the user i d of this project_ user_ worker.
	*
	* @return the user i d of this project_ user_ worker
	*/
	@Override
	public long getUserID() {
		return _project_User_Worker.getUserID();
	}

	/**
	* Sets the user i d of this project_ user_ worker.
	*
	* @param userID the user i d of this project_ user_ worker
	*/
	@Override
	public void setUserID(long userID) {
		_project_User_Worker.setUserID(userID);
	}

	/**
	* Returns the begin of this project_ user_ worker.
	*
	* @return the begin of this project_ user_ worker
	*/
	@Override
	public java.util.Date getBegin() {
		return _project_User_Worker.getBegin();
	}

	/**
	* Sets the begin of this project_ user_ worker.
	*
	* @param begin the begin of this project_ user_ worker
	*/
	@Override
	public void setBegin(java.util.Date begin) {
		_project_User_Worker.setBegin(begin);
	}

	/**
	* Returns the end of this project_ user_ worker.
	*
	* @return the end of this project_ user_ worker
	*/
	@Override
	public java.util.Date getEnd() {
		return _project_User_Worker.getEnd();
	}

	/**
	* Sets the end of this project_ user_ worker.
	*
	* @param end the end of this project_ user_ worker
	*/
	@Override
	public void setEnd(java.util.Date end) {
		_project_User_Worker.setEnd(end);
	}

	@Override
	public boolean isNew() {
		return _project_User_Worker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project_User_Worker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project_User_Worker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project_User_Worker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project_User_Worker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project_User_Worker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project_User_Worker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project_User_Worker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project_User_Worker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project_User_Worker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project_User_Worker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Project_User_WorkerWrapper((Project_User_Worker)_project_User_Worker.clone());
	}

	@Override
	public int compareTo(
		org.gfbio.model.Project_User_Worker project_User_Worker) {
		return _project_User_Worker.compareTo(project_User_Worker);
	}

	@Override
	public int hashCode() {
		return _project_User_Worker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Project_User_Worker> toCacheModel() {
		return _project_User_Worker.toCacheModel();
	}

	@Override
	public org.gfbio.model.Project_User_Worker toEscapedModel() {
		return new Project_User_WorkerWrapper(_project_User_Worker.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Project_User_Worker toUnescapedModel() {
		return new Project_User_WorkerWrapper(_project_User_Worker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project_User_Worker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project_User_Worker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project_User_Worker.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_User_WorkerWrapper)) {
			return false;
		}

		Project_User_WorkerWrapper project_User_WorkerWrapper = (Project_User_WorkerWrapper)obj;

		if (Validator.equals(_project_User_Worker,
					project_User_WorkerWrapper._project_User_Worker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project_User_Worker getWrappedProject_User_Worker() {
		return _project_User_Worker;
	}

	@Override
	public Project_User_Worker getWrappedModel() {
		return _project_User_Worker;
	}

	@Override
	public void resetOriginalValues() {
		_project_User_Worker.resetOriginalValues();
	}

	private Project_User_Worker _project_User_Worker;
}