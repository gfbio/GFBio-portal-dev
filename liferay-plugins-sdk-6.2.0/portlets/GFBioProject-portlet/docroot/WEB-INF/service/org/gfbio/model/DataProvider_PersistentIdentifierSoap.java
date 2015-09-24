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

import org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.DataProvider_PersistentIdentifierServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.DataProvider_PersistentIdentifierServiceSoap
 * @generated
 */
public class DataProvider_PersistentIdentifierSoap implements Serializable {
	public static DataProvider_PersistentIdentifierSoap toSoapModel(
		DataProvider_PersistentIdentifier model) {
		DataProvider_PersistentIdentifierSoap soapModel = new DataProvider_PersistentIdentifierSoap();

		soapModel.setGfbioDataProvider(model.getGfbioDataProvider());
		soapModel.setGfbioPersistentIdentifier(model.getGfbioPersistentIdentifier());

		return soapModel;
	}

	public static DataProvider_PersistentIdentifierSoap[] toSoapModels(
		DataProvider_PersistentIdentifier[] models) {
		DataProvider_PersistentIdentifierSoap[] soapModels = new DataProvider_PersistentIdentifierSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataProvider_PersistentIdentifierSoap[][] toSoapModels(
		DataProvider_PersistentIdentifier[][] models) {
		DataProvider_PersistentIdentifierSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataProvider_PersistentIdentifierSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataProvider_PersistentIdentifierSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataProvider_PersistentIdentifierSoap[] toSoapModels(
		List<DataProvider_PersistentIdentifier> models) {
		List<DataProvider_PersistentIdentifierSoap> soapModels = new ArrayList<DataProvider_PersistentIdentifierSoap>(models.size());

		for (DataProvider_PersistentIdentifier model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataProvider_PersistentIdentifierSoap[soapModels.size()]);
	}

	public DataProvider_PersistentIdentifierSoap() {
	}

	public DataProvider_PersistentIdentifierPK getPrimaryKey() {
		return new DataProvider_PersistentIdentifierPK(_gfbioDataProvider,
			_gfbioPersistentIdentifier);
	}

	public void setPrimaryKey(DataProvider_PersistentIdentifierPK pk) {
		setGfbioDataProvider(pk.gfbioDataProvider);
		setGfbioPersistentIdentifier(pk.gfbioPersistentIdentifier);
	}

	public long getGfbioDataProvider() {
		return _gfbioDataProvider;
	}

	public void setGfbioDataProvider(long gfbioDataProvider) {
		_gfbioDataProvider = gfbioDataProvider;
	}

	public long getGfbioPersistentIdentifier() {
		return _gfbioPersistentIdentifier;
	}

	public void setGfbioPersistentIdentifier(long gfbioPersistentIdentifier) {
		_gfbioPersistentIdentifier = gfbioPersistentIdentifier;
	}

	private long _gfbioDataProvider;
	private long _gfbioPersistentIdentifier;
}