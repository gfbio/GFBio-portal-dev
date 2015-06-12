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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.HeadServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.HeadServiceSoap
 * @generated
 */
public class HeadSoap implements Serializable {
	public static HeadSoap toSoapModel(Head model) {
		HeadSoap soapModel = new HeadSoap();

		soapModel.setHeadID(model.getHeadID());
		soapModel.setName(model.getName());
		soapModel.setTask(model.getTask());

		return soapModel;
	}

	public static HeadSoap[] toSoapModels(Head[] models) {
		HeadSoap[] soapModels = new HeadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeadSoap[][] toSoapModels(Head[][] models) {
		HeadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeadSoap[] toSoapModels(List<Head> models) {
		List<HeadSoap> soapModels = new ArrayList<HeadSoap>(models.size());

		for (Head model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeadSoap[soapModels.size()]);
	}

	public HeadSoap() {
	}

	public long getPrimaryKey() {
		return _headID;
	}

	public void setPrimaryKey(long pk) {
		setHeadID(pk);
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTask() {
		return _task;
	}

	public void setTask(String task) {
		_task = task;
	}

	private long _headID;
	private String _name;
	private String _task;
}