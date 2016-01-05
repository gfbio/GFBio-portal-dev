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
 * This class is a wrapper for {@link SubmissionRegistry}.
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionRegistry
 * @generated
 */
public class SubmissionRegistryWrapper implements SubmissionRegistry,
	ModelWrapper<SubmissionRegistry> {
	public SubmissionRegistryWrapper(SubmissionRegistry submissionRegistry) {
		_submissionRegistry = submissionRegistry;
	}

	@Override
	public Class<?> getModelClass() {
		return SubmissionRegistry.class;
	}

	@Override
	public String getModelClassName() {
		return SubmissionRegistry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionID", getSubmissionID());
		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("archive", getArchive());
		attributes.put("brokerSubmissionID", getBrokerSubmissionID());
		attributes.put("archivePID", getArchivePID());
		attributes.put("archivePIDType", getArchivePIDType());
		attributes.put("lastChanged", getLastChanged());
		attributes.put("userID", getUserID());
		attributes.put("isPublic", getIsPublic());
		attributes.put("publicAfter", getPublicAfter());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submissionID = (Long)attributes.get("submissionID");

		if (submissionID != null) {
			setSubmissionID(submissionID);
		}

		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Long researchObjectVersion = (Long)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}

		String archive = (String)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String brokerSubmissionID = (String)attributes.get("brokerSubmissionID");

		if (brokerSubmissionID != null) {
			setBrokerSubmissionID(brokerSubmissionID);
		}

		String archivePID = (String)attributes.get("archivePID");

		if (archivePID != null) {
			setArchivePID(archivePID);
		}

		Long archivePIDType = (Long)attributes.get("archivePIDType");

		if (archivePIDType != null) {
			setArchivePIDType(archivePIDType);
		}

		Date lastChanged = (Date)attributes.get("lastChanged");

		if (lastChanged != null) {
			setLastChanged(lastChanged);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Date publicAfter = (Date)attributes.get("publicAfter");

		if (publicAfter != null) {
			setPublicAfter(publicAfter);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this submission registry.
	*
	* @return the primary key of this submission registry
	*/
	@Override
	public long getPrimaryKey() {
		return _submissionRegistry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this submission registry.
	*
	* @param primaryKey the primary key of this submission registry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submissionRegistry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submission i d of this submission registry.
	*
	* @return the submission i d of this submission registry
	*/
	@Override
	public long getSubmissionID() {
		return _submissionRegistry.getSubmissionID();
	}

	/**
	* Sets the submission i d of this submission registry.
	*
	* @param submissionID the submission i d of this submission registry
	*/
	@Override
	public void setSubmissionID(long submissionID) {
		_submissionRegistry.setSubmissionID(submissionID);
	}

	/**
	* Returns the research object i d of this submission registry.
	*
	* @return the research object i d of this submission registry
	*/
	@Override
	public long getResearchObjectID() {
		return _submissionRegistry.getResearchObjectID();
	}

	/**
	* Sets the research object i d of this submission registry.
	*
	* @param researchObjectID the research object i d of this submission registry
	*/
	@Override
	public void setResearchObjectID(long researchObjectID) {
		_submissionRegistry.setResearchObjectID(researchObjectID);
	}

	/**
	* Returns the research object version of this submission registry.
	*
	* @return the research object version of this submission registry
	*/
	@Override
	public long getResearchObjectVersion() {
		return _submissionRegistry.getResearchObjectVersion();
	}

	/**
	* Sets the research object version of this submission registry.
	*
	* @param researchObjectVersion the research object version of this submission registry
	*/
	@Override
	public void setResearchObjectVersion(long researchObjectVersion) {
		_submissionRegistry.setResearchObjectVersion(researchObjectVersion);
	}

	/**
	* Returns the archive of this submission registry.
	*
	* @return the archive of this submission registry
	*/
	@Override
	public java.lang.String getArchive() {
		return _submissionRegistry.getArchive();
	}

	/**
	* Sets the archive of this submission registry.
	*
	* @param archive the archive of this submission registry
	*/
	@Override
	public void setArchive(java.lang.String archive) {
		_submissionRegistry.setArchive(archive);
	}

	/**
	* Returns the broker submission i d of this submission registry.
	*
	* @return the broker submission i d of this submission registry
	*/
	@Override
	public java.lang.String getBrokerSubmissionID() {
		return _submissionRegistry.getBrokerSubmissionID();
	}

	/**
	* Sets the broker submission i d of this submission registry.
	*
	* @param brokerSubmissionID the broker submission i d of this submission registry
	*/
	@Override
	public void setBrokerSubmissionID(java.lang.String brokerSubmissionID) {
		_submissionRegistry.setBrokerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the archive p i d of this submission registry.
	*
	* @return the archive p i d of this submission registry
	*/
	@Override
	public java.lang.String getArchivePID() {
		return _submissionRegistry.getArchivePID();
	}

	/**
	* Sets the archive p i d of this submission registry.
	*
	* @param archivePID the archive p i d of this submission registry
	*/
	@Override
	public void setArchivePID(java.lang.String archivePID) {
		_submissionRegistry.setArchivePID(archivePID);
	}

	/**
	* Returns the archive p i d type of this submission registry.
	*
	* @return the archive p i d type of this submission registry
	*/
	@Override
	public long getArchivePIDType() {
		return _submissionRegistry.getArchivePIDType();
	}

	/**
	* Sets the archive p i d type of this submission registry.
	*
	* @param archivePIDType the archive p i d type of this submission registry
	*/
	@Override
	public void setArchivePIDType(long archivePIDType) {
		_submissionRegistry.setArchivePIDType(archivePIDType);
	}

	/**
	* Returns the last changed of this submission registry.
	*
	* @return the last changed of this submission registry
	*/
	@Override
	public java.util.Date getLastChanged() {
		return _submissionRegistry.getLastChanged();
	}

	/**
	* Sets the last changed of this submission registry.
	*
	* @param lastChanged the last changed of this submission registry
	*/
	@Override
	public void setLastChanged(java.util.Date lastChanged) {
		_submissionRegistry.setLastChanged(lastChanged);
	}

	/**
	* Returns the user i d of this submission registry.
	*
	* @return the user i d of this submission registry
	*/
	@Override
	public long getUserID() {
		return _submissionRegistry.getUserID();
	}

	/**
	* Sets the user i d of this submission registry.
	*
	* @param userID the user i d of this submission registry
	*/
	@Override
	public void setUserID(long userID) {
		_submissionRegistry.setUserID(userID);
	}

	/**
	* Returns the is public of this submission registry.
	*
	* @return the is public of this submission registry
	*/
	@Override
	public boolean getIsPublic() {
		return _submissionRegistry.getIsPublic();
	}

	/**
	* Returns <code>true</code> if this submission registry is is public.
	*
	* @return <code>true</code> if this submission registry is is public; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPublic() {
		return _submissionRegistry.isIsPublic();
	}

	/**
	* Sets whether this submission registry is is public.
	*
	* @param isPublic the is public of this submission registry
	*/
	@Override
	public void setIsPublic(boolean isPublic) {
		_submissionRegistry.setIsPublic(isPublic);
	}

	/**
	* Returns the public after of this submission registry.
	*
	* @return the public after of this submission registry
	*/
	@Override
	public java.util.Date getPublicAfter() {
		return _submissionRegistry.getPublicAfter();
	}

	/**
	* Sets the public after of this submission registry.
	*
	* @param publicAfter the public after of this submission registry
	*/
	@Override
	public void setPublicAfter(java.util.Date publicAfter) {
		_submissionRegistry.setPublicAfter(publicAfter);
	}

	/**
	* Returns the status of this submission registry.
	*
	* @return the status of this submission registry
	*/
	@Override
	public java.lang.String getStatus() {
		return _submissionRegistry.getStatus();
	}

	/**
	* Sets the status of this submission registry.
	*
	* @param status the status of this submission registry
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_submissionRegistry.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _submissionRegistry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_submissionRegistry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _submissionRegistry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submissionRegistry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _submissionRegistry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _submissionRegistry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_submissionRegistry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _submissionRegistry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_submissionRegistry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_submissionRegistry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_submissionRegistry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubmissionRegistryWrapper((SubmissionRegistry)_submissionRegistry.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.SubmissionRegistry submissionRegistry) {
		return _submissionRegistry.compareTo(submissionRegistry);
	}

	@Override
	public int hashCode() {
		return _submissionRegistry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.SubmissionRegistry> toCacheModel() {
		return _submissionRegistry.toCacheModel();
	}

	@Override
	public org.gfbio.model.SubmissionRegistry toEscapedModel() {
		return new SubmissionRegistryWrapper(_submissionRegistry.toEscapedModel());
	}

	@Override
	public org.gfbio.model.SubmissionRegistry toUnescapedModel() {
		return new SubmissionRegistryWrapper(_submissionRegistry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submissionRegistry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _submissionRegistry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_submissionRegistry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionRegistryWrapper)) {
			return false;
		}

		SubmissionRegistryWrapper submissionRegistryWrapper = (SubmissionRegistryWrapper)obj;

		if (Validator.equals(_submissionRegistry,
					submissionRegistryWrapper._submissionRegistry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SubmissionRegistry getWrappedSubmissionRegistry() {
		return _submissionRegistry;
	}

	@Override
	public SubmissionRegistry getWrappedModel() {
		return _submissionRegistry;
	}

	@Override
	public void resetOriginalValues() {
		_submissionRegistry.resetOriginalValues();
	}

	private SubmissionRegistry _submissionRegistry;
}