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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.BasketServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.BasketServiceSoap
 * @generated
 */
public class BasketSoap implements Serializable {
	public static BasketSoap toSoapModel(Basket model) {
		BasketSoap soapModel = new BasketSoap();

		soapModel.setBasketID(model.getBasketID());
		soapModel.setUserID(model.getUserID());
		soapModel.setName(model.getName());
		soapModel.setLastModifiedDate(model.getLastModifiedDate());
		soapModel.setBasketContent(model.getBasketContent());
		soapModel.setQueryJSON(model.getQueryJSON());

		return soapModel;
	}

	public static BasketSoap[] toSoapModels(Basket[] models) {
		BasketSoap[] soapModels = new BasketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BasketSoap[][] toSoapModels(Basket[][] models) {
		BasketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BasketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BasketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BasketSoap[] toSoapModels(List<Basket> models) {
		List<BasketSoap> soapModels = new ArrayList<BasketSoap>(models.size());

		for (Basket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BasketSoap[soapModels.size()]);
	}

	public BasketSoap() {
	}

	public long getPrimaryKey() {
		return _basketID;
	}

	public void setPrimaryKey(long pk) {
		setBasketID(pk);
	}

	public long getBasketID() {
		return _basketID;
	}

	public void setBasketID(long basketID) {
		_basketID = basketID;
	}

	public long getUserID() {
		return _userID;
	}

	public void setUserID(long userID) {
		_userID = userID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	public String getBasketContent() {
		return _basketContent;
	}

	public void setBasketContent(String basketContent) {
		_basketContent = basketContent;
	}

	public String getQueryJSON() {
		return _queryJSON;
	}

	public void setQueryJSON(String queryJSON) {
		_queryJSON = queryJSON;
	}

	private long _basketID;
	private long _userID;
	private String _name;
	private Date _lastModifiedDate;
	private String _basketContent;
	private String _queryJSON;
}