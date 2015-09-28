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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.CellServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.CellServiceSoap
 * @generated
 */
public class CellSoap implements Serializable {
	public static CellSoap toSoapModel(Cell model) {
		CellSoap soapModel = new CellSoap();

		soapModel.setCellID(model.getCellID());
		soapModel.setContent(model.getContent());
		soapModel.setTask(model.getTask());

		return soapModel;
	}

	public static CellSoap[] toSoapModels(Cell[] models) {
		CellSoap[] soapModels = new CellSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CellSoap[][] toSoapModels(Cell[][] models) {
		CellSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CellSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CellSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CellSoap[] toSoapModels(List<Cell> models) {
		List<CellSoap> soapModels = new ArrayList<CellSoap>(models.size());

		for (Cell model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CellSoap[soapModels.size()]);
	}

	public CellSoap() {
	}

	public long getPrimaryKey() {
		return _cellID;
	}

	public void setPrimaryKey(long pk) {
		setCellID(pk);
	}

	public long getCellID() {
		return _cellID;
	}

	public void setCellID(long cellID) {
		_cellID = cellID;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getTask() {
		return _task;
	}

	public void setTask(String task) {
		_task = task;
	}

	private long _cellID;
	private String _content;
	private String _task;
}