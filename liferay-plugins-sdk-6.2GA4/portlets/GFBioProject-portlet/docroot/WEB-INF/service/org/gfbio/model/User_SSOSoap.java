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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.User_SSOServiceSoap}.
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.http.User_SSOServiceSoap
 * @generated
 */
public class User_SSOSoap implements Serializable {
	public static User_SSOSoap toSoapModel(User_SSO model) {
		User_SSOSoap soapModel = new User_SSOSoap();

		soapModel.setUserID(model.getUserID());
		soapModel.setToken(model.getToken());
		soapModel.setLastModifiedDate(model.getLastModifiedDate());

		return soapModel;
	}

	public static User_SSOSoap[] toSoapModels(User_SSO[] models) {
		User_SSOSoap[] soapModels = new User_SSOSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static User_SSOSoap[][] toSoapModels(User_SSO[][] models) {
		User_SSOSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new User_SSOSoap[models.length][models[0].length];
		}
		else {
			soapModels = new User_SSOSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static User_SSOSoap[] toSoapModels(List<User_SSO> models) {
		List<User_SSOSoap> soapModels = new ArrayList<User_SSOSoap>(models.size());

		for (User_SSO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new User_SSOSoap[soapModels.size()]);
	}

	public User_SSOSoap() {
	}

	public long getPrimaryKey() {
		return _userID;
	}

	public void setPrimaryKey(long pk) {
		setUserID(pk);
	}

	public long getUserID() {
		return _userID;
	}

	public void setUserID(long userID) {
		_userID = userID;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	private long _userID;
	private String _token;
	private Date _lastModifiedDate;
}