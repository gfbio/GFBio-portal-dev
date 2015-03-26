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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.Basket_UserServiceSoap}.
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.http.Basket_UserServiceSoap
 * @generated
 */
public class Basket_UserSoap implements Serializable {
	public static Basket_UserSoap toSoapModel(Basket_User model) {
		Basket_UserSoap soapModel = new Basket_UserSoap();

		soapModel.setBasketID(model.getBasketID());
		soapModel.setUserID(model.getUserID());
		soapModel.setName(model.getName());
		soapModel.setBasketJSON(model.getBasketJSON());
		soapModel.setQueryJSON(model.getQueryJSON());

		return soapModel;
	}

	public static Basket_UserSoap[] toSoapModels(Basket_User[] models) {
		Basket_UserSoap[] soapModels = new Basket_UserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Basket_UserSoap[][] toSoapModels(Basket_User[][] models) {
		Basket_UserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Basket_UserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Basket_UserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Basket_UserSoap[] toSoapModels(List<Basket_User> models) {
		List<Basket_UserSoap> soapModels = new ArrayList<Basket_UserSoap>(models.size());

		for (Basket_User model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Basket_UserSoap[soapModels.size()]);
	}

	public Basket_UserSoap() {
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

	public String getBasketJSON() {
		return _basketJSON;
	}

	public void setBasketJSON(String basketJSON) {
		_basketJSON = basketJSON;
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
	private String _basketJSON;
	private String _queryJSON;
}