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

import org.gfbio.service.persistence.Project_User_PIPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Project_User_PIServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Project_User_PIServiceSoap
 * @generated
 */
public class Project_User_PISoap implements Serializable {
	public static Project_User_PISoap toSoapModel(Project_User_PI model) {
		Project_User_PISoap soapModel = new Project_User_PISoap();

		soapModel.setProjectID(model.getProjectID());
		soapModel.setUserID(model.getUserID());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static Project_User_PISoap[] toSoapModels(Project_User_PI[] models) {
		Project_User_PISoap[] soapModels = new Project_User_PISoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Project_User_PISoap[][] toSoapModels(
		Project_User_PI[][] models) {
		Project_User_PISoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Project_User_PISoap[models.length][models[0].length];
		}
		else {
			soapModels = new Project_User_PISoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Project_User_PISoap[] toSoapModels(
		List<Project_User_PI> models) {
		List<Project_User_PISoap> soapModels = new ArrayList<Project_User_PISoap>(models.size());

		for (Project_User_PI model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Project_User_PISoap[soapModels.size()]);
	}

	public Project_User_PISoap() {
	}

	public Project_User_PIPK getPrimaryKey() {
		return new Project_User_PIPK(_projectID, _userID);
	}

	public void setPrimaryKey(Project_User_PIPK pk) {
		setProjectID(pk.projectID);
		setUserID(pk.userID);
	}

	public long getProjectID() {
		return _projectID;
	}

	public void setProjectID(long projectID) {
		_projectID = projectID;
	}

	public long getUserID() {
		return _userID;
	}

	public void setUserID(long userID) {
		_userID = userID;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private long _projectID;
	private long _userID;
	private Date _startDate;
	private Date _endDate;
}