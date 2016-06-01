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

import org.gfbio.service.persistence.Funding_InstitutionProjectPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Funding_InstitutionProjectServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Funding_InstitutionProjectServiceSoap
 * @generated
 */
public class Funding_InstitutionProjectSoap implements Serializable {
	public static Funding_InstitutionProjectSoap toSoapModel(
		Funding_InstitutionProject model) {
		Funding_InstitutionProjectSoap soapModel = new Funding_InstitutionProjectSoap();

		soapModel.setProjectID(model.getProjectID());
		soapModel.setFundingAgencyID(model.getFundingAgencyID());
		soapModel.setFundingProgramID(model.getFundingProgramID());
		soapModel.setInstitutionID(model.getInstitutionID());

		return soapModel;
	}

	public static Funding_InstitutionProjectSoap[] toSoapModels(
		Funding_InstitutionProject[] models) {
		Funding_InstitutionProjectSoap[] soapModels = new Funding_InstitutionProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Funding_InstitutionProjectSoap[][] toSoapModels(
		Funding_InstitutionProject[][] models) {
		Funding_InstitutionProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Funding_InstitutionProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Funding_InstitutionProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Funding_InstitutionProjectSoap[] toSoapModels(
		List<Funding_InstitutionProject> models) {
		List<Funding_InstitutionProjectSoap> soapModels = new ArrayList<Funding_InstitutionProjectSoap>(models.size());

		for (Funding_InstitutionProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Funding_InstitutionProjectSoap[soapModels.size()]);
	}

	public Funding_InstitutionProjectSoap() {
	}

	public Funding_InstitutionProjectPK getPrimaryKey() {
		return new Funding_InstitutionProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _institutionID);
	}

	public void setPrimaryKey(Funding_InstitutionProjectPK pk) {
		setProjectID(pk.projectID);
		setFundingAgencyID(pk.fundingAgencyID);
		setFundingProgramID(pk.fundingProgramID);
		setInstitutionID(pk.institutionID);
	}

	public long getProjectID() {
		return _projectID;
	}

	public void setProjectID(long projectID) {
		_projectID = projectID;
	}

	public long getFundingAgencyID() {
		return _fundingAgencyID;
	}

	public void setFundingAgencyID(long fundingAgencyID) {
		_fundingAgencyID = fundingAgencyID;
	}

	public long getFundingProgramID() {
		return _fundingProgramID;
	}

	public void setFundingProgramID(long fundingProgramID) {
		_fundingProgramID = fundingProgramID;
	}

	public long getInstitutionID() {
		return _institutionID;
	}

	public void setInstitutionID(long institutionID) {
		_institutionID = institutionID;
	}

	private long _projectID;
	private long _fundingAgencyID;
	private long _fundingProgramID;
	private long _institutionID;
}