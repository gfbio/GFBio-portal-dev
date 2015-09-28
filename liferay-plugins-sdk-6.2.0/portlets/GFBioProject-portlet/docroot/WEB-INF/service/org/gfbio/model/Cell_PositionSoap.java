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

import org.gfbio.service.persistence.Cell_PositionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Cell_PositionServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.Cell_PositionServiceSoap
 * @generated
 */
public class Cell_PositionSoap implements Serializable {
	public static Cell_PositionSoap toSoapModel(Cell_Position model) {
		Cell_PositionSoap soapModel = new Cell_PositionSoap();

		soapModel.setCellID(model.getCellID());
		soapModel.setPositionID(model.getPositionID());
		soapModel.setColumn(model.getColumn());

		return soapModel;
	}

	public static Cell_PositionSoap[] toSoapModels(Cell_Position[] models) {
		Cell_PositionSoap[] soapModels = new Cell_PositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Cell_PositionSoap[][] toSoapModels(Cell_Position[][] models) {
		Cell_PositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Cell_PositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Cell_PositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Cell_PositionSoap[] toSoapModels(List<Cell_Position> models) {
		List<Cell_PositionSoap> soapModels = new ArrayList<Cell_PositionSoap>(models.size());

		for (Cell_Position model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Cell_PositionSoap[soapModels.size()]);
	}

	public Cell_PositionSoap() {
	}

	public Cell_PositionPK getPrimaryKey() {
		return new Cell_PositionPK(_cellID, _positionID);
	}

	public void setPrimaryKey(Cell_PositionPK pk) {
		setCellID(pk.cellID);
		setPositionID(pk.positionID);
	}

	public long getCellID() {
		return _cellID;
	}

	public void setCellID(long cellID) {
		_cellID = cellID;
	}

	public long getPositionID() {
		return _positionID;
	}

	public void setPositionID(long positionID) {
		_positionID = positionID;
	}

	public int getColumn() {
		return _column;
	}

	public void setColumn(int column) {
		_column = column;
	}

	private long _cellID;
	private long _positionID;
	private int _column;
}