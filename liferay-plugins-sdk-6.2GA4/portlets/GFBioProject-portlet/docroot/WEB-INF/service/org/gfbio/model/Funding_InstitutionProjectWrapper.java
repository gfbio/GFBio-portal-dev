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
 * This class is a wrapper for {@link Funding_InstitutionProject}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProject
 * @generated
 */
public class Funding_InstitutionProjectWrapper
	implements Funding_InstitutionProject,
		ModelWrapper<Funding_InstitutionProject> {
	public Funding_InstitutionProjectWrapper(
		Funding_InstitutionProject funding_InstitutionProject) {
		_funding_InstitutionProject = funding_InstitutionProject;
	}

	@Override
	public Class<?> getModelClass() {
		return Funding_InstitutionProject.class;
	}

	@Override
	public String getModelClassName() {
		return Funding_InstitutionProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectID", getProjectID());
		attributes.put("fundingAgencyID", getFundingAgencyID());
		attributes.put("fundingProgramID", getFundingProgramID());
		attributes.put("institutionID", getInstitutionID());

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

		Long institutionID = (Long)attributes.get("institutionID");

		if (institutionID != null) {
			setInstitutionID(institutionID);
		}
	}

	/**
	* Returns the primary key of this funding_ institution project.
	*
	* @return the primary key of this funding_ institution project
	*/
	@Override
	public org.gfbio.service.persistence.Funding_InstitutionProjectPK getPrimaryKey() {
		return _funding_InstitutionProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this funding_ institution project.
	*
	* @param primaryKey the primary key of this funding_ institution project
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Funding_InstitutionProjectPK primaryKey) {
		_funding_InstitutionProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project i d of this funding_ institution project.
	*
	* @return the project i d of this funding_ institution project
	*/
	@Override
	public long getProjectID() {
		return _funding_InstitutionProject.getProjectID();
	}

	/**
	* Sets the project i d of this funding_ institution project.
	*
	* @param projectID the project i d of this funding_ institution project
	*/
	@Override
	public void setProjectID(long projectID) {
		_funding_InstitutionProject.setProjectID(projectID);
	}

	/**
	* Returns the funding agency i d of this funding_ institution project.
	*
	* @return the funding agency i d of this funding_ institution project
	*/
	@Override
	public long getFundingAgencyID() {
		return _funding_InstitutionProject.getFundingAgencyID();
	}

	/**
	* Sets the funding agency i d of this funding_ institution project.
	*
	* @param fundingAgencyID the funding agency i d of this funding_ institution project
	*/
	@Override
	public void setFundingAgencyID(long fundingAgencyID) {
		_funding_InstitutionProject.setFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns the funding program i d of this funding_ institution project.
	*
	* @return the funding program i d of this funding_ institution project
	*/
	@Override
	public long getFundingProgramID() {
		return _funding_InstitutionProject.getFundingProgramID();
	}

	/**
	* Sets the funding program i d of this funding_ institution project.
	*
	* @param fundingProgramID the funding program i d of this funding_ institution project
	*/
	@Override
	public void setFundingProgramID(long fundingProgramID) {
		_funding_InstitutionProject.setFundingProgramID(fundingProgramID);
	}

	/**
	* Returns the institution i d of this funding_ institution project.
	*
	* @return the institution i d of this funding_ institution project
	*/
	@Override
	public long getInstitutionID() {
		return _funding_InstitutionProject.getInstitutionID();
	}

	/**
	* Sets the institution i d of this funding_ institution project.
	*
	* @param institutionID the institution i d of this funding_ institution project
	*/
	@Override
	public void setInstitutionID(long institutionID) {
		_funding_InstitutionProject.setInstitutionID(institutionID);
	}

	@Override
	public boolean isNew() {
		return _funding_InstitutionProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_funding_InstitutionProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _funding_InstitutionProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_funding_InstitutionProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _funding_InstitutionProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _funding_InstitutionProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_funding_InstitutionProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _funding_InstitutionProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_funding_InstitutionProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_funding_InstitutionProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_funding_InstitutionProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Funding_InstitutionProjectWrapper((Funding_InstitutionProject)_funding_InstitutionProject.clone());
	}

	@Override
	public int compareTo(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject) {
		return _funding_InstitutionProject.compareTo(funding_InstitutionProject);
	}

	@Override
	public int hashCode() {
		return _funding_InstitutionProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Funding_InstitutionProject> toCacheModel() {
		return _funding_InstitutionProject.toCacheModel();
	}

	@Override
	public org.gfbio.model.Funding_InstitutionProject toEscapedModel() {
		return new Funding_InstitutionProjectWrapper(_funding_InstitutionProject.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Funding_InstitutionProject toUnescapedModel() {
		return new Funding_InstitutionProjectWrapper(_funding_InstitutionProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _funding_InstitutionProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _funding_InstitutionProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_funding_InstitutionProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Funding_InstitutionProjectWrapper)) {
			return false;
		}

		Funding_InstitutionProjectWrapper funding_InstitutionProjectWrapper = (Funding_InstitutionProjectWrapper)obj;

		if (Validator.equals(_funding_InstitutionProject,
					funding_InstitutionProjectWrapper._funding_InstitutionProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Funding_InstitutionProject getWrappedFunding_InstitutionProject() {
		return _funding_InstitutionProject;
	}

	@Override
	public Funding_InstitutionProject getWrappedModel() {
		return _funding_InstitutionProject;
	}

	@Override
	public void resetOriginalValues() {
		_funding_InstitutionProject.resetOriginalValues();
	}

	private Funding_InstitutionProject _funding_InstitutionProject;
}