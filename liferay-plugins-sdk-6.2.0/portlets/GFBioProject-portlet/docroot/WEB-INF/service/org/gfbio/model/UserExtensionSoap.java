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
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.UserExtensionServiceSoap}.
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.http.UserExtensionServiceSoap
 * @generated
 */
public class UserExtensionSoap implements Serializable {
	public static UserExtensionSoap toSoapModel(UserExtension model) {
		UserExtensionSoap soapModel = new UserExtensionSoap();

		soapModel.setUserID(model.getUserID());

		return soapModel;
	}

	public static UserExtensionSoap[] toSoapModels(UserExtension[] models) {
		UserExtensionSoap[] soapModels = new UserExtensionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserExtensionSoap[][] toSoapModels(UserExtension[][] models) {
		UserExtensionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserExtensionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserExtensionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserExtensionSoap[] toSoapModels(List<UserExtension> models) {
		List<UserExtensionSoap> soapModels = new ArrayList<UserExtensionSoap>(models.size());

		for (UserExtension model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserExtensionSoap[soapModels.size()]);
	}

	public UserExtensionSoap() {
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

	private long _userID;
}