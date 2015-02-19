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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.tab_ResearchObjectServiceSoap}.
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.http.tab_ResearchObjectServiceSoap
 * @generated
 */
public class tab_ResearchObjectSoap implements Serializable {
	public static tab_ResearchObjectSoap toSoapModel(tab_ResearchObject model) {
		tab_ResearchObjectSoap soapModel = new tab_ResearchObjectSoap();

		soapModel.setRo_ID(model.getRo_ID());
		soapModel.setRo_name(model.getRo_name());
		soapModel.setRo_meta(model.getRo_meta());

		return soapModel;
	}

	public static tab_ResearchObjectSoap[] toSoapModels(
		tab_ResearchObject[] models) {
		tab_ResearchObjectSoap[] soapModels = new tab_ResearchObjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static tab_ResearchObjectSoap[][] toSoapModels(
		tab_ResearchObject[][] models) {
		tab_ResearchObjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new tab_ResearchObjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new tab_ResearchObjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static tab_ResearchObjectSoap[] toSoapModels(
		List<tab_ResearchObject> models) {
		List<tab_ResearchObjectSoap> soapModels = new ArrayList<tab_ResearchObjectSoap>(models.size());

		for (tab_ResearchObject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new tab_ResearchObjectSoap[soapModels.size()]);
	}

	public tab_ResearchObjectSoap() {
	}

	public long getPrimaryKey() {
		return _ro_ID;
	}

	public void setPrimaryKey(long pk) {
		setRo_ID(pk);
	}

	public long getRo_ID() {
		return _ro_ID;
	}

	public void setRo_ID(long ro_ID) {
		_ro_ID = ro_ID;
	}

	public String getRo_name() {
		return _ro_name;
	}

	public void setRo_name(String ro_name) {
		_ro_name = ro_name;
	}

	public String getRo_meta() {
		return _ro_meta;
	}

	public void setRo_meta(String ro_meta) {
		_ro_meta = ro_meta;
	}

	private long _ro_ID;
	private String _ro_name;
	private String _ro_meta;
}