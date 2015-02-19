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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.ResearchObjectServiceSoap}.
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.http.ResearchObjectServiceSoap
 * @generated
 */
public class ResearchObjectSoap implements Serializable {
	public static ResearchObjectSoap toSoapModel(ResearchObject model) {
		ResearchObjectSoap soapModel = new ResearchObjectSoap();

		soapModel.setResearchObjectID(model.getResearchObjectID());
		soapModel.setName(model.getName());
		soapModel.setMetadata(model.getMetadata());

		return soapModel;
	}

	public static ResearchObjectSoap[] toSoapModels(ResearchObject[] models) {
		ResearchObjectSoap[] soapModels = new ResearchObjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResearchObjectSoap[][] toSoapModels(ResearchObject[][] models) {
		ResearchObjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResearchObjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResearchObjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResearchObjectSoap[] toSoapModels(List<ResearchObject> models) {
		List<ResearchObjectSoap> soapModels = new ArrayList<ResearchObjectSoap>(models.size());

		for (ResearchObject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResearchObjectSoap[soapModels.size()]);
	}

	public ResearchObjectSoap() {
	}

	public long getPrimaryKey() {
		return _researchObjectID;
	}

	public void setPrimaryKey(long pk) {
		setResearchObjectID(pk);
	}

	public long getResearchObjectID() {
		return _researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		_researchObjectID = researchObjectID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMetadata() {
		return _metadata;
	}

	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	private long _researchObjectID;
	private String _name;
	private String _metadata;
}