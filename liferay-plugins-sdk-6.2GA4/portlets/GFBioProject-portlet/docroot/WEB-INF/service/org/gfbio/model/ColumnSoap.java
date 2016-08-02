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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.ColumnServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.ColumnServiceSoap
 * @generated
 */
public class ColumnSoap implements Serializable {
	public static ColumnSoap toSoapModel(Column model) {
		ColumnSoap soapModel = new ColumnSoap();

		soapModel.setColumnID(model.getColumnID());
		soapModel.setHeadID(model.getHeadID());
		soapModel.setColumn_name(model.getColumn_name());

		return soapModel;
	}

	public static ColumnSoap[] toSoapModels(Column[] models) {
		ColumnSoap[] soapModels = new ColumnSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ColumnSoap[][] toSoapModels(Column[][] models) {
		ColumnSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ColumnSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ColumnSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ColumnSoap[] toSoapModels(List<Column> models) {
		List<ColumnSoap> soapModels = new ArrayList<ColumnSoap>(models.size());

		for (Column model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ColumnSoap[soapModels.size()]);
	}

	public ColumnSoap() {
	}

	public long getPrimaryKey() {
		return _columnID;
	}

	public void setPrimaryKey(long pk) {
		setColumnID(pk);
	}

	public long getColumnID() {
		return _columnID;
	}

	public void setColumnID(long columnID) {
		_columnID = columnID;
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	public String getColumn_name() {
		return _column_name;
	}

	public void setColumn_name(String column_name) {
		_column_name = column_name;
	}

	private long _columnID;
	private long _headID;
	private String _column_name;
}