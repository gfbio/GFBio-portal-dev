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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.PositionServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.PositionServiceSoap
 * @generated
 */
public class PositionSoap implements Serializable {
	public static PositionSoap toSoapModel(Position model) {
		PositionSoap soapModel = new PositionSoap();

		soapModel.setPositionID(model.getPositionID());
		soapModel.setHeadID(model.getHeadID());

		return soapModel;
	}

	public static PositionSoap[] toSoapModels(Position[] models) {
		PositionSoap[] soapModels = new PositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[][] toSoapModels(Position[][] models) {
		PositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[] toSoapModels(List<Position> models) {
		List<PositionSoap> soapModels = new ArrayList<PositionSoap>(models.size());

		for (Position model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PositionSoap[soapModels.size()]);
	}

	public PositionSoap() {
	}

	public long getPrimaryKey() {
		return _positionID;
	}

	public void setPrimaryKey(long pk) {
		setPositionID(pk);
	}

	public long getPositionID() {
		return _positionID;
	}

	public void setPositionID(long positionID) {
		_positionID = positionID;
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	private long _positionID;
	private long _headID;
}