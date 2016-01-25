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
 * This class is a wrapper for {@link Project_User}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_User
 * @generated
 */
public class Project_UserWrapper implements Project_User,
	ModelWrapper<Project_User> {
	public Project_UserWrapper(Project_User project_User) {
		_project_User = project_User;
	}

	@Override
	public Class<?> getModelClass() {
		return Project_User.class;
	}

	@Override
	public String getModelClassName() {
		return Project_User.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("userID", getUserID());
		attributes.put("usertype", getUsertype());
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

		String usertype = (String)attributes.get("usertype");

		if (usertype != null) {
			setUsertype(usertype);
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
	* Returns the primary key of this project_ user.
	*
	* @return the primary key of this project_ user
	*/
	@Override
	public org.gfbio.service.persistence.Project_UserPK getPrimaryKey() {
		return _project_User.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project_ user.
	*
	* @param primaryKey the primary key of this project_ user
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Project_UserPK primaryKey) {
		_project_User.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this project_ user.
	*
	* @return the project i d of this project_ user
	*/
	@Override
	public long getProjectID() {
		return _project_User.getProjectID();
	}

	/**
	* Sets the project i d of this project_ user.
	*
	* @param projectID the project i d of this project_ user
	*/
	@Override
	public void setProjectID(long projectID) {
		_project_User.setProjectID(projectID);
	}

	/**
	* Returns the user i d of this project_ user.
	*
	* @return the user i d of this project_ user
	*/
	@Override
	public long getUserID() {
		return _project_User.getUserID();
	}

	/**
	* Sets the user i d of this project_ user.
	*
	* @param userID the user i d of this project_ user
	*/
	@Override
	public void setUserID(long userID) {
		_project_User.setUserID(userID);
	}

	/**
	* Returns the usertype of this project_ user.
	*
	* @return the usertype of this project_ user
	*/
	@Override
	public java.lang.String getUsertype() {
		return _project_User.getUsertype();
	}

	/**
	* Sets the usertype of this project_ user.
	*
	* @param usertype the usertype of this project_ user
	*/
	@Override
	public void setUsertype(java.lang.String usertype) {
		_project_User.setUsertype(usertype);
	}

	/**
	* Returns the start date of this project_ user.
	*
	* @return the start date of this project_ user
	*/
	@Override
	public java.util.Date getStartDate() {
		return _project_User.getStartDate();
	}

	/**
	* Sets the start date of this project_ user.
	*
	* @param startDate the start date of this project_ user
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_project_User.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project_ user.
	*
	* @return the end date of this project_ user
	*/
	@Override
	public java.util.Date getEndDate() {
		return _project_User.getEndDate();
	}

	/**
	* Sets the end date of this project_ user.
	*
	* @param endDate the end date of this project_ user
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_project_User.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _project_User.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project_User.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project_User.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project_User.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project_User.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project_User.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project_User.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project_User.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project_User.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project_User.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project_User.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Project_UserWrapper((Project_User)_project_User.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Project_User project_User) {
		return _project_User.compareTo(project_User);
	}

	@Override
	public int hashCode() {
		return _project_User.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Project_User> toCacheModel() {
		return _project_User.toCacheModel();
	}

	@Override
	public org.gfbio.model.Project_User toEscapedModel() {
		return new Project_UserWrapper(_project_User.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Project_User toUnescapedModel() {
		return new Project_UserWrapper(_project_User.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project_User.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project_User.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project_User.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_UserWrapper)) {
			return false;
		}

		Project_UserWrapper project_UserWrapper = (Project_UserWrapper)obj;

		if (Validator.equals(_project_User, project_UserWrapper._project_User)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project_User getWrappedProject_User() {
		return _project_User;
	}

	@Override
	public Project_User getWrappedModel() {
		return _project_User;
	}

	@Override
	public void resetOriginalValues() {
		_project_User.resetOriginalValues();
	}

	private Project_User _project_User;
}