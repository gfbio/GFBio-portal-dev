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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.DataProviderServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.DataProviderServiceSoap
 * @generated
 */
public class DataProviderSoap implements Serializable {
	public static DataProviderSoap toSoapModel(DataProvider model) {
		DataProviderSoap soapModel = new DataProviderSoap();

		soapModel.setDataProviderID(model.getDataProviderID());
		soapModel.setName(model.getName());
		soapModel.setLabel(model.getLabel());
		soapModel.setDescription(model.getDescription());
		soapModel.setAddress(model.getAddress());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setTraining(model.getTraining());

		return soapModel;
	}

	public static DataProviderSoap[] toSoapModels(DataProvider[] models) {
		DataProviderSoap[] soapModels = new DataProviderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataProviderSoap[][] toSoapModels(DataProvider[][] models) {
		DataProviderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DataProviderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataProviderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataProviderSoap[] toSoapModels(List<DataProvider> models) {
		List<DataProviderSoap> soapModels = new ArrayList<DataProviderSoap>(models.size());

		for (DataProvider model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataProviderSoap[soapModels.size()]);
	}

	public DataProviderSoap() {
	}

	public long getPrimaryKey() {
		return _dataProviderID;
	}

	public void setPrimaryKey(long pk) {
		setDataProviderID(pk);
	}

	public long getDataProviderID() {
		return _dataProviderID;
	}

	public void setDataProviderID(long dataProviderID) {
		_dataProviderID = dataProviderID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getTraining() {
		return _training;
	}

	public void setTraining(String training) {
		_training = training;
	}

	private long _dataProviderID;
	private String _name;
	private String _label;
	private String _description;
	private String _address;
	private String _website;
	private String _training;
}