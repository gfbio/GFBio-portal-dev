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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.service.Basket_UserLocalServiceUtil;
import org.gfbio.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Felicitas Loeffler
 */
public class Basket_UserClp extends BaseModelImpl<Basket_User>
	implements Basket_User {
	public Basket_UserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Basket_User.class;
	}

	@Override
	public String getModelClassName() {
		return Basket_User.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _basketID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBasketID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _basketID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("basketID", getBasketID());
		attributes.put("userID", getUserID());
		attributes.put("name", getName());
		attributes.put("basketJSON", getBasketJSON());
		attributes.put("queryJSON", getQueryJSON());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long basketID = (Long)attributes.get("basketID");

		if (basketID != null) {
			setBasketID(basketID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String basketJSON = (String)attributes.get("basketJSON");

		if (basketJSON != null) {
			setBasketJSON(basketJSON);
		}

		String queryJSON = (String)attributes.get("queryJSON");

		if (queryJSON != null) {
			setQueryJSON(queryJSON);
		}
	}

	@Override
	public long getBasketID() {
		return _basketID;
	}

	@Override
	public void setBasketID(long basketID) {
		_basketID = basketID;

		if (_basket_UserRemoteModel != null) {
			try {
				Class<?> clazz = _basket_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setBasketID", long.class);

				method.invoke(_basket_UserRemoteModel, basketID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_userID = userID;

		if (_basket_UserRemoteModel != null) {
			try {
				Class<?> clazz = _basket_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_basket_UserRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_basket_UserRemoteModel != null) {
			try {
				Class<?> clazz = _basket_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_basket_UserRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBasketJSON() {
		return _basketJSON;
	}

	@Override
	public void setBasketJSON(String basketJSON) {
		_basketJSON = basketJSON;

		if (_basket_UserRemoteModel != null) {
			try {
				Class<?> clazz = _basket_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setBasketJSON", String.class);

				method.invoke(_basket_UserRemoteModel, basketJSON);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQueryJSON() {
		return _queryJSON;
	}

	@Override
	public void setQueryJSON(String queryJSON) {
		_queryJSON = queryJSON;

		if (_basket_UserRemoteModel != null) {
			try {
				Class<?> clazz = _basket_UserRemoteModel.getClass();

				Method method = clazz.getMethod("setQueryJSON", String.class);

				method.invoke(_basket_UserRemoteModel, queryJSON);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBasket_UserRemoteModel() {
		return _basket_UserRemoteModel;
	}

	public void setBasket_UserRemoteModel(BaseModel<?> basket_UserRemoteModel) {
		_basket_UserRemoteModel = basket_UserRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _basket_UserRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_basket_UserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Basket_UserLocalServiceUtil.addBasket_User(this);
		}
		else {
			Basket_UserLocalServiceUtil.updateBasket_User(this);
		}
	}

	@Override
	public Basket_User toEscapedModel() {
		return (Basket_User)ProxyUtil.newProxyInstance(Basket_User.class.getClassLoader(),
			new Class[] { Basket_User.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Basket_UserClp clone = new Basket_UserClp();

		clone.setBasketID(getBasketID());
		clone.setUserID(getUserID());
		clone.setName(getName());
		clone.setBasketJSON(getBasketJSON());
		clone.setQueryJSON(getQueryJSON());

		return clone;
	}

	@Override
	public int compareTo(Basket_User basket_User) {
		long primaryKey = basket_User.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Basket_UserClp)) {
			return false;
		}

		Basket_UserClp basket_User = (Basket_UserClp)obj;

		long primaryKey = basket_User.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{basketID=");
		sb.append(getBasketID());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", basketJSON=");
		sb.append(getBasketJSON());
		sb.append(", queryJSON=");
		sb.append(getQueryJSON());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Basket_User");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>basketID</column-name><column-value><![CDATA[");
		sb.append(getBasketID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>basketJSON</column-name><column-value><![CDATA[");
		sb.append(getBasketJSON());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queryJSON</column-name><column-value><![CDATA[");
		sb.append(getQueryJSON());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _basketID;
	private long _userID;
	private String _name;
	private String _basketJSON;
	private String _queryJSON;
	private BaseModel<?> _basket_UserRemoteModel;
}