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

import org.gfbio.service.persistence.Project_ResearchObjectPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Project_ResearchObjectServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Project_ResearchObjectServiceSoap
 * @generated
 */
public class Project_ResearchObjectSoap implements Serializable {
	public static Project_ResearchObjectSoap toSoapModel(
		Project_ResearchObject model) {
		Project_ResearchObjectSoap soapModel = new Project_ResearchObjectSoap();

		soapModel.setProjectID(model.getProjectID());
		soapModel.setResearchObjectID(model.getResearchObjectID());

		return soapModel;
	}

	public static Project_ResearchObjectSoap[] toSoapModels(
		Project_ResearchObject[] models) {
		Project_ResearchObjectSoap[] soapModels = new Project_ResearchObjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Project_ResearchObjectSoap[][] toSoapModels(
		Project_ResearchObject[][] models) {
		Project_ResearchObjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Project_ResearchObjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Project_ResearchObjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Project_ResearchObjectSoap[] toSoapModels(
		List<Project_ResearchObject> models) {
		List<Project_ResearchObjectSoap> soapModels = new ArrayList<Project_ResearchObjectSoap>(models.size());

		for (Project_ResearchObject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Project_ResearchObjectSoap[soapModels.size()]);
	}

	public Project_ResearchObjectSoap() {
	}

	public Project_ResearchObjectPK getPrimaryKey() {
		return new Project_ResearchObjectPK(_projectID, _researchObjectID);
	}

	public void setPrimaryKey(Project_ResearchObjectPK pk) {
		setProjectID(pk.projectID);
		setResearchObjectID(pk.researchObjectID);
	}

	public long getProjectID() {
		return _projectID;
	}

	public void setProjectID(long projectID) {
		_projectID = projectID;
	}

	public long getResearchObjectID() {
		return _researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;
	}

	private long _projectID;
	private long _researchObjectID;
}