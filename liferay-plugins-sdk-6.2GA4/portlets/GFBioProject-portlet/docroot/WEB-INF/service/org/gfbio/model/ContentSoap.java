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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.ContentServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.ContentServiceSoap
 * @generated
 */
public class ContentSoap implements Serializable {
	public static ContentSoap toSoapModel(Content model) {
		ContentSoap soapModel = new ContentSoap();

		soapModel.setContentID(model.getContentID());
		soapModel.setHeadID(model.getHeadID());
		soapModel.setColumnID(model.getColumnID());
		soapModel.setRowID(model.getRowID());
		soapModel.setCellContent(model.getCellContent());

		return soapModel;
	}

	public static ContentSoap[] toSoapModels(Content[] models) {
		ContentSoap[] soapModels = new ContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContentSoap[][] toSoapModels(Content[][] models) {
		ContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContentSoap[] toSoapModels(List<Content> models) {
		List<ContentSoap> soapModels = new ArrayList<ContentSoap>(models.size());

		for (Content model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContentSoap[soapModels.size()]);
	}

	public ContentSoap() {
	}

	public long getPrimaryKey() {
		return _contentID;
	}

	public void setPrimaryKey(long pk) {
		setContentID(pk);
	}

	public long getContentID() {
		return _contentID;
	}

	public void setContentID(long contentID) {
		_contentID = contentID;
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	public long getColumnID() {
		return _columnID;
	}

	public void setColumnID(long columnID) {
		_columnID = columnID;
	}

	public long getRowID() {
		return _rowID;
	}

	public void setRowID(long rowID) {
		_rowID = rowID;
	}

	public String getCellContent() {
		return _cellContent;
	}

	public void setCellContent(String cellContent) {
		_cellContent = cellContent;
	}

	private long _contentID;
	private long _headID;
	private long _columnID;
	private long _rowID;
	private String _cellContent;
}