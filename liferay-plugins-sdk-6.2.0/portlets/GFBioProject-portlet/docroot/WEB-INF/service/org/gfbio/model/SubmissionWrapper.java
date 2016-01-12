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
 * This class is a wrapper for {@link Submission}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Submission
 * @generated
 */
public class SubmissionWrapper implements Submission, ModelWrapper<Submission> {
	public SubmissionWrapper(Submission submission) {
		_submission = submission;
	}

	@Override
	public Class<?> getModelClass() {
		return Submission.class;
	}

	@Override
	public String getModelClassName() {
		return Submission.class.getName();
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
	* Returns the primary key of this submission.
	*
	* @return the primary key of this submission
	*/
	@Override
	public long getPrimaryKey() {
		return _submission.getPrimaryKey();
	}

	/**
	* Sets the primary key of this submission.
	*
	* @param primaryKey the primary key of this submission
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_submission.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the submission i d of this submission.
	*
	* @return the submission i d of this submission
	*/
	@Override
	public long getSubmissionID() {
		return _submission.getSubmissionID();
	}

	/**
	* Sets the submission i d of this submission.
	*
	* @param submissionID the submission i d of this submission
	*/
	@Override
	public void setSubmissionID(long submissionID) {
		_submission.setSubmissionID(submissionID);
	}

	/**
	* Returns the research object i d of this submission.
	*
	* @return the research object i d of this submission
	*/
	@Override
	public long getResearchObjectID() {
		return _submission.getResearchObjectID();
	}

	/**
	* Sets the research object i d of this submission.
	*
	* @param researchObjectID the research object i d of this submission
	*/
	@Override
	public void setResearchObjectID(long researchObjectID) {
		_submission.setResearchObjectID(researchObjectID);
	}

	/**
	* Returns the research object version of this submission.
	*
	* @return the research object version of this submission
	*/
	@Override
	public long getResearchObjectVersion() {
		return _submission.getResearchObjectVersion();
	}

	/**
	* Sets the research object version of this submission.
	*
	* @param researchObjectVersion the research object version of this submission
	*/
	@Override
	public void setResearchObjectVersion(long researchObjectVersion) {
		_submission.setResearchObjectVersion(researchObjectVersion);
	}

	/**
	* Returns the archive of this submission.
	*
	* @return the archive of this submission
	*/
	@Override
	public java.lang.String getArchive() {
		return _submission.getArchive();
	}

	/**
	* Sets the archive of this submission.
	*
	* @param archive the archive of this submission
	*/
	@Override
	public void setArchive(java.lang.String archive) {
		_submission.setArchive(archive);
	}

	/**
	* Returns the broker submission i d of this submission.
	*
	* @return the broker submission i d of this submission
	*/
	@Override
	public java.lang.String getBrokerSubmissionID() {
		return _submission.getBrokerSubmissionID();
	}

	/**
	* Sets the broker submission i d of this submission.
	*
	* @param brokerSubmissionID the broker submission i d of this submission
	*/
	@Override
	public void setBrokerSubmissionID(java.lang.String brokerSubmissionID) {
		_submission.setBrokerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the archive p i d of this submission.
	*
	* @return the archive p i d of this submission
	*/
	@Override
	public java.lang.String getArchivePID() {
		return _submission.getArchivePID();
	}

	/**
	* Sets the archive p i d of this submission.
	*
	* @param archivePID the archive p i d of this submission
	*/
	@Override
	public void setArchivePID(java.lang.String archivePID) {
		_submission.setArchivePID(archivePID);
	}

	/**
	* Returns the archive p i d type of this submission.
	*
	* @return the archive p i d type of this submission
	*/
	@Override
	public long getArchivePIDType() {
		return _submission.getArchivePIDType();
	}

	/**
	* Sets the archive p i d type of this submission.
	*
	* @param archivePIDType the archive p i d type of this submission
	*/
	@Override
	public void setArchivePIDType(long archivePIDType) {
		_submission.setArchivePIDType(archivePIDType);
	}

	/**
	* Returns the last changed of this submission.
	*
	* @return the last changed of this submission
	*/
	@Override
	public java.util.Date getLastChanged() {
		return _submission.getLastChanged();
	}

	/**
	* Sets the last changed of this submission.
	*
	* @param lastChanged the last changed of this submission
	*/
	@Override
	public void setLastChanged(java.util.Date lastChanged) {
		_submission.setLastChanged(lastChanged);
	}

	/**
	* Returns the user i d of this submission.
	*
	* @return the user i d of this submission
	*/
	@Override
	public long getUserID() {
		return _submission.getUserID();
	}

	/**
	* Sets the user i d of this submission.
	*
	* @param userID the user i d of this submission
	*/
	@Override
	public void setUserID(long userID) {
		_submission.setUserID(userID);
	}

	/**
	* Returns the is public of this submission.
	*
	* @return the is public of this submission
	*/
	@Override
	public boolean getIsPublic() {
		return _submission.getIsPublic();
	}

	/**
	* Returns <code>true</code> if this submission is is public.
	*
	* @return <code>true</code> if this submission is is public; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPublic() {
		return _submission.isIsPublic();
	}

	/**
	* Sets whether this submission is is public.
	*
	* @param isPublic the is public of this submission
	*/
	@Override
	public void setIsPublic(boolean isPublic) {
		_submission.setIsPublic(isPublic);
	}

	/**
	* Returns the public after of this submission.
	*
	* @return the public after of this submission
	*/
	@Override
	public java.util.Date getPublicAfter() {
		return _submission.getPublicAfter();
	}

	/**
	* Sets the public after of this submission.
	*
	* @param publicAfter the public after of this submission
	*/
	@Override
	public void setPublicAfter(java.util.Date publicAfter) {
		_submission.setPublicAfter(publicAfter);
	}

	/**
	* Returns the status of this submission.
	*
	* @return the status of this submission
	*/
	@Override
	public java.lang.String getStatus() {
		return _submission.getStatus();
	}

	/**
	* Sets the status of this submission.
	*
	* @param status the status of this submission
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_submission.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _submission.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_submission.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _submission.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_submission.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _submission.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _submission.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_submission.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _submission.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_submission.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_submission.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_submission.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubmissionWrapper((Submission)_submission.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Submission submission) {
		return _submission.compareTo(submission);
	}

	@Override
	public int hashCode() {
		return _submission.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Submission> toCacheModel() {
		return _submission.toCacheModel();
	}

	@Override
	public org.gfbio.model.Submission toEscapedModel() {
		return new SubmissionWrapper(_submission.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Submission toUnescapedModel() {
		return new SubmissionWrapper(_submission.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _submission.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _submission.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_submission.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubmissionWrapper)) {
			return false;
		}

		SubmissionWrapper submissionWrapper = (SubmissionWrapper)obj;

		if (Validator.equals(_submission, submissionWrapper._submission)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Submission getWrappedSubmission() {
		return _submission;
	}

	@Override
	public Submission getWrappedModel() {
		return _submission;
	}

	@Override
	public void resetOriginalValues() {
		_submission.resetOriginalValues();
	}

	private Submission _submission;
}