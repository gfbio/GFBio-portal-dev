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

import org.gfbio.service.persistence.SubmissionRegistryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.SubmissionRegistryServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.SubmissionRegistryServiceSoap
 * @generated
 */
public class SubmissionRegistrySoap implements Serializable {
	public static SubmissionRegistrySoap toSoapModel(SubmissionRegistry model) {
		SubmissionRegistrySoap soapModel = new SubmissionRegistrySoap();

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

	public static SubmissionRegistrySoap[] toSoapModels(
		SubmissionRegistry[] models) {
		SubmissionRegistrySoap[] soapModels = new SubmissionRegistrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubmissionRegistrySoap[][] toSoapModels(
		SubmissionRegistry[][] models) {
		SubmissionRegistrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubmissionRegistrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubmissionRegistrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubmissionRegistrySoap[] toSoapModels(
		List<SubmissionRegistry> models) {
		List<SubmissionRegistrySoap> soapModels = new ArrayList<SubmissionRegistrySoap>(models.size());

		for (SubmissionRegistry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubmissionRegistrySoap[soapModels.size()]);
	}

	public SubmissionRegistrySoap() {
	}

	public SubmissionRegistryPK getPrimaryKey() {
		return new SubmissionRegistryPK(_researchObjectID,
			_researchObjectVersion, _archive);
	}

	public void setPrimaryKey(SubmissionRegistryPK pk) {
		setResearchObjectID(pk.researchObjectID);
		setResearchObjectVersion(pk.researchObjectVersion);
		setArchive(pk.archive);
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

	public Boolean getIsPublic() {
		return _isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
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

	private long _researchObjectID;
	private long _researchObjectVersion;
	private String _archive;
	private String _brokerSubmissionID;
	private String _archivePID;
	private long _archivePIDType;
	private Date _lastChanged;
	private long _userID;
	private Boolean _isPublic;
	private Date _publicAfter;
	private String _status;
}