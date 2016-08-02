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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Funding_PersonProject}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_PersonProject
 * @generated
 */
public class Funding_PersonProjectWrapper implements Funding_PersonProject,
	ModelWrapper<Funding_PersonProject> {
	public Funding_PersonProjectWrapper(
		Funding_PersonProject funding_PersonProject) {
		_funding_PersonProject = funding_PersonProject;
	}

	@Override
	public Class<?> getModelClass() {
		return Funding_PersonProject.class;
	}

	@Override
	public String getModelClassName() {
		return Funding_PersonProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("fundingAgencyID", getFundingAgencyID());
		attributes.put("fundingProgramID", getFundingProgramID());
		attributes.put("personID", getPersonID());
		attributes.put("personType", getPersonType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectID = (Long)attributes.get("projectID");

		if (projectID != null) {
			setProjectID(projectID);
		}

		Long fundingAgencyID = (Long)attributes.get("fundingAgencyID");

		if (fundingAgencyID != null) {
			setFundingAgencyID(fundingAgencyID);
		}

		Long fundingProgramID = (Long)attributes.get("fundingProgramID");

		if (fundingProgramID != null) {
			setFundingProgramID(fundingProgramID);
		}

		Long personID = (Long)attributes.get("personID");

		if (personID != null) {
			setPersonID(personID);
		}

		String personType = (String)attributes.get("personType");

		if (personType != null) {
			setPersonType(personType);
		}
	}

	/**
	* Returns the primary key of this funding_ person project.
	*
	* @return the primary key of this funding_ person project
	*/
	@Override
	public org.gfbio.service.persistence.Funding_PersonProjectPK getPrimaryKey() {
		return _funding_PersonProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this funding_ person project.
	*
	* @param primaryKey the primary key of this funding_ person project
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Funding_PersonProjectPK primaryKey) {
		_funding_PersonProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this funding_ person project.
	*
	* @return the project i d of this funding_ person project
	*/
	@Override
	public long getProjectID() {
		return _funding_PersonProject.getProjectID();
	}

	/**
	* Sets the project i d of this funding_ person project.
	*
	* @param projectID the project i d of this funding_ person project
	*/
	@Override
	public void setProjectID(long projectID) {
		_funding_PersonProject.setProjectID(projectID);
	}

	/**
	* Returns the funding agency i d of this funding_ person project.
	*
	* @return the funding agency i d of this funding_ person project
	*/
	@Override
	public long getFundingAgencyID() {
		return _funding_PersonProject.getFundingAgencyID();
	}

	/**
	* Sets the funding agency i d of this funding_ person project.
	*
	* @param fundingAgencyID the funding agency i d of this funding_ person project
	*/
	@Override
	public void setFundingAgencyID(long fundingAgencyID) {
		_funding_PersonProject.setFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns the funding program i d of this funding_ person project.
	*
	* @return the funding program i d of this funding_ person project
	*/
	@Override
	public long getFundingProgramID() {
		return _funding_PersonProject.getFundingProgramID();
	}

	/**
	* Sets the funding program i d of this funding_ person project.
	*
	* @param fundingProgramID the funding program i d of this funding_ person project
	*/
	@Override
	public void setFundingProgramID(long fundingProgramID) {
		_funding_PersonProject.setFundingProgramID(fundingProgramID);
	}

	/**
	* Returns the person i d of this funding_ person project.
	*
	* @return the person i d of this funding_ person project
	*/
	@Override
	public long getPersonID() {
		return _funding_PersonProject.getPersonID();
	}

	/**
	* Sets the person i d of this funding_ person project.
	*
	* @param personID the person i d of this funding_ person project
	*/
	@Override
	public void setPersonID(long personID) {
		_funding_PersonProject.setPersonID(personID);
	}

	/**
	* Returns the person type of this funding_ person project.
	*
	* @return the person type of this funding_ person project
	*/
	@Override
	public java.lang.String getPersonType() {
		return _funding_PersonProject.getPersonType();
	}

	/**
	* Sets the person type of this funding_ person project.
	*
	* @param personType the person type of this funding_ person project
	*/
	@Override
	public void setPersonType(java.lang.String personType) {
		_funding_PersonProject.setPersonType(personType);
	}

	@Override
	public boolean isNew() {
		return _funding_PersonProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_funding_PersonProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _funding_PersonProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_funding_PersonProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _funding_PersonProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _funding_PersonProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_funding_PersonProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _funding_PersonProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_funding_PersonProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_funding_PersonProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_funding_PersonProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Funding_PersonProjectWrapper((Funding_PersonProject)_funding_PersonProject.clone());
	}

	@Override
	public int compareTo(
		org.gfbio.model.Funding_PersonProject funding_PersonProject) {
		return _funding_PersonProject.compareTo(funding_PersonProject);
	}

	@Override
	public int hashCode() {
		return _funding_PersonProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Funding_PersonProject> toCacheModel() {
		return _funding_PersonProject.toCacheModel();
	}

	@Override
	public org.gfbio.model.Funding_PersonProject toEscapedModel() {
		return new Funding_PersonProjectWrapper(_funding_PersonProject.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Funding_PersonProject toUnescapedModel() {
		return new Funding_PersonProjectWrapper(_funding_PersonProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _funding_PersonProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _funding_PersonProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_funding_PersonProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Funding_PersonProjectWrapper)) {
			return false;
		}

		Funding_PersonProjectWrapper funding_PersonProjectWrapper = (Funding_PersonProjectWrapper)obj;

		if (Validator.equals(_funding_PersonProject,
					funding_PersonProjectWrapper._funding_PersonProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Funding_PersonProject getWrappedFunding_PersonProject() {
		return _funding_PersonProject;
	}

	@Override
	public Funding_PersonProject getWrappedModel() {
		return _funding_PersonProject;
	}

	@Override
	public void resetOriginalValues() {
		_funding_PersonProject.resetOriginalValues();
	}

	private Funding_PersonProject _funding_PersonProject;
}