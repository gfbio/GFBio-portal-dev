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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.SubmissionServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.SubmissionServiceSoap
 * @generated
 */
public class SubmissionSoap implements Serializable {
	public static SubmissionSoap toSoapModel(Submission model) {
		SubmissionSoap soapModel = new SubmissionSoap();

		soapModel.setSubmissionID(model.getSubmissionID());
		soapModel.setResearchObjectID(model.getResearchObjectID());
		soapModel.setResearchObjectVersion(model.getResearchObjectVersion());
		soapModel.setArchive(model.getArchive());
		soapModel.setBrokerSubmissionID(model.getBrokerSubmissionID());
		soapModel.setArchivePID(model.getArchivePID());
		soapModel.setArchivePIDType(model.getArchivePIDType());
		soapModel.setLastChanged(model.getLastChanged());
		soapModel.setUserID(model.getUserID());
		soapModel.setIsPublic(model.getIsPublic());
		soapModel.setPublicAfter(model.getPublicAfter());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SubmissionSoap[] toSoapModels(Submission[] models) {
		SubmissionSoap[] soapModels = new SubmissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubmissionSoap[][] toSoapModels(Submission[][] models) {
		SubmissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubmissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubmissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubmissionSoap[] toSoapModels(List<Submission> models) {
		List<SubmissionSoap> soapModels = new ArrayList<SubmissionSoap>(models.size());

		for (Submission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubmissionSoap[soapModels.size()]);
	}

	public SubmissionSoap() {
	}

	public long getPrimaryKey() {
		return _submissionID;
	}

	public void setPrimaryKey(long pk) {
		setSubmissionID(pk);
	}

	public long getSubmissionID() {
		return _submissionID;
	}

	public void setSubmissionID(long submissionID) {
		_submissionID = submissionID;
	}

	public long getResearchObjectID() {
		return _researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;
	}

	public long getResearchObjectVersion() {
		return _researchObjectVersion;
	}

	public void setResearchObjectVersion(long researchObjectVersion) {
		_researchObjectVersion = researchObjectVersion;
	}

	public String getArchive() {
		return _archive;
	}

	public void setArchive(String archive) {
		_archive = archive;
	}

	public String getBrokerSubmissionID() {
		return _brokerSubmissionID;
	}

	public void setBrokerSubmissionID(String brokerSubmissionID) {
		_brokerSubmissionID = brokerSubmissionID;
	}

	public String getArchivePID() {
		return _archivePID;
	}

	public void setArchivePID(String archivePID) {
		_archivePID = archivePID;
	}

	public long getArchivePIDType() {
		return _archivePIDType;
	}

	public void setArchivePIDType(long archivePIDType) {
		_archivePIDType = archivePIDType;
	}

	public Date getLastChanged() {
		return _lastChanged;
	}

	public void setLastChanged(Date lastChanged) {
		_lastChanged = lastChanged;
	}

	public long getUserID() {
		return _userID;
	}

	public void setUserID(long userID) {
		_userID = userID;
	}

	public boolean getIsPublic() {
		return _isPublic;
	}

	public boolean isIsPublic() {
		return _isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		_isPublic = isPublic;
	}

	public Date getPublicAfter() {
		return _publicAfter;
	}

	public void setPublicAfter(Date publicAfter) {
		_publicAfter = publicAfter;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _submissionID;
	private long _researchObjectID;
	private long _researchObjectVersion;
	private String _archive;
	private String _brokerSubmissionID;
	private String _archivePID;
	private long _archivePIDType;
	private Date _lastChanged;
	private long _userID;
	private boolean _isPublic;
	private Date _publicAfter;
	private String _status;
}