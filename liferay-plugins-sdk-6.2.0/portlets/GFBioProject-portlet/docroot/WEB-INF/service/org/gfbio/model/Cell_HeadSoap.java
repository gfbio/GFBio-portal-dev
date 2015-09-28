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

import org.gfbio.service.persistence.Cell_HeadPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Cell_HeadServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Cell_HeadServiceSoap
 * @generated
 */
public class Cell_HeadSoap implements Serializable {
	public static Cell_HeadSoap toSoapModel(Cell_Head model) {
		Cell_HeadSoap soapModel = new Cell_HeadSoap();

		soapModel.setCellID(model.getCellID());
		soapModel.setHeadID(model.getHeadID());
		soapModel.setColumn(model.getColumn());

		return soapModel;
	}

	public static Cell_HeadSoap[] toSoapModels(Cell_Head[] models) {
		Cell_HeadSoap[] soapModels = new Cell_HeadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Cell_HeadSoap[][] toSoapModels(Cell_Head[][] models) {
		Cell_HeadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Cell_HeadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Cell_HeadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Cell_HeadSoap[] toSoapModels(List<Cell_Head> models) {
		List<Cell_HeadSoap> soapModels = new ArrayList<Cell_HeadSoap>(models.size());

		for (Cell_Head model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Cell_HeadSoap[soapModels.size()]);
	}

	public Cell_HeadSoap() {
	}

	public Cell_HeadPK getPrimaryKey() {
		return new Cell_HeadPK(_cellID, _headID);
	}

	public void setPrimaryKey(Cell_HeadPK pk) {
		setCellID(pk.cellID);
		setHeadID(pk.headID);
	}

	public long getCellID() {
		return _cellID;
	}

	public void setCellID(long cellID) {
		_cellID = cellID;
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	public int getColumn() {
		return _column;
	}

	public void setColumn(int column) {
		_column = column;
	}

	private long _cellID;
	private long _headID;
	private int _column;
}