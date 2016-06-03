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

import org.gfbio.service.persistence.Funding_PersonProjectPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Funding_PersonProjectServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Funding_PersonProjectServiceSoap
 * @generated
 */
public class Funding_PersonProjectSoap implements Serializable {
	public static Funding_PersonProjectSoap toSoapModel(
		Funding_PersonProject model) {
		Funding_PersonProjectSoap soapModel = new Funding_PersonProjectSoap();

		soapModel.setProjectID(model.getProjectID());
		soapModel.setFundingAgencyID(model.getFundingAgencyID());
		soapModel.setFundingProgramID(model.getFundingProgramID());
		soapModel.setPersonID(model.getPersonID());
		soapModel.setPersonType(model.getPersonType());

		return soapModel;
	}

	public static Funding_PersonProjectSoap[] toSoapModels(
		Funding_PersonProject[] models) {
		Funding_PersonProjectSoap[] soapModels = new Funding_PersonProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Funding_PersonProjectSoap[][] toSoapModels(
		Funding_PersonProject[][] models) {
		Funding_PersonProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Funding_PersonProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Funding_PersonProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Funding_PersonProjectSoap[] toSoapModels(
		List<Funding_PersonProject> models) {
		List<Funding_PersonProjectSoap> soapModels = new ArrayList<Funding_PersonProjectSoap>(models.size());

		for (Funding_PersonProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Funding_PersonProjectSoap[soapModels.size()]);
	}

	public Funding_PersonProjectSoap() {
	}

	public Funding_PersonProjectPK getPrimaryKey() {
		return new Funding_PersonProjectPK(_projectID, _fundingAgencyID,
			_fundingProgramID, _personID, _personType);
	}

	public void setPrimaryKey(Funding_PersonProjectPK pk) {
		setProjectID(pk.projectID);
		setFundingAgencyID(pk.fundingAgencyID);
		setFundingProgramID(pk.fundingProgramID);
		setPersonID(pk.personID);
		setPersonType(pk.personType);
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

	public long getPersonID() {
		return _personID;
	}

	public void setPersonID(long personID) {
		_personID = personID;
	}

	public String getPersonType() {
		return _personType;
	}

	public void setPersonType(String personType) {
		_personType = personType;
	}

	private long _projectID;
	private long _fundingAgencyID;
	private long _fundingProgramID;
	private long _personID;
	private String _personType;
}