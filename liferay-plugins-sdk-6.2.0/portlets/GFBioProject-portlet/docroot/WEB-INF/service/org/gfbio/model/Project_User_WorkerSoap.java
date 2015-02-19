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

import org.gfbio.service.persistence.Project_User_WorkerPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Project_User_WorkerServiceSoap}.
 *
 * @author froemm
 * @see org.gfbio.service.http.Project_User_WorkerServiceSoap
 * @generated
 */
public class Project_User_WorkerSoap implements Serializable {
	public static Project_User_WorkerSoap toSoapModel(Project_User_Worker model) {
		Project_User_WorkerSoap soapModel = new Project_User_WorkerSoap();

		soapModel.setProjectID(model.getProjectID());
		soapModel.setUserID(model.getUserID());
		soapModel.setBegin(model.getBegin());
		soapModel.setEnd(model.getEnd());

		return soapModel;
	}

	public static Project_User_WorkerSoap[] toSoapModels(
		Project_User_Worker[] models) {
		Project_User_WorkerSoap[] soapModels = new Project_User_WorkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Project_User_WorkerSoap[][] toSoapModels(
		Project_User_Worker[][] models) {
		Project_User_WorkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Project_User_WorkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Project_User_WorkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Project_User_WorkerSoap[] toSoapModels(
		List<Project_User_Worker> models) {
		List<Project_User_WorkerSoap> soapModels = new ArrayList<Project_User_WorkerSoap>(models.size());

		for (Project_User_Worker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Project_User_WorkerSoap[soapModels.size()]);
	}

	public Project_User_WorkerSoap() {
	}

	public Project_User_WorkerPK getPrimaryKey() {
		return new Project_User_WorkerPK(_projectID, _userID);
	}

	public void setPrimaryKey(Project_User_WorkerPK pk) {
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

	public Date getBegin() {
		return _begin;
	}

	public void setBegin(Date begin) {
		_begin = begin;
	}

	public Date getEnd() {
		return _end;
	}

	public void setEnd(Date end) {
		_end = end;
	}

	private long _projectID;
	private long _userID;
	private Date _begin;
	private Date _end;
}