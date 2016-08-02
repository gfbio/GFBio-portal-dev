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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.gfbio.service.ClpSerializer;
import org.gfbio.service.User_SSOLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class User_SSOClp extends BaseModelImpl<User_SSO> implements User_SSO {
	public User_SSOClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return User_SSO.class;
	}

	@Override
	public String getModelClassName() {
		return User_SSO.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userID", getUserID());
		attributes.put("token", getToken());
		attributes.put("lastModifiedDate", getLastModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
	}

	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_userID = userID;

		if (_user_SSORemoteModel != null) {
			try {
				Class<?> clazz = _user_SSORemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_user_SSORemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToken() {
		return _token;
	}

	@Override
	public void setToken(String token) {
		_token = token;

		if (_user_SSORemoteModel != null) {
			try {
				Class<?> clazz = _user_SSORemoteModel.getClass();

				Method method = clazz.getMethod("setToken", String.class);

				method.invoke(_user_SSORemoteModel, token);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;

		if (_user_SSORemoteModel != null) {
			try {
				Class<?> clazz = _user_SSORemoteModel.getClass();

				Method method = clazz.getMethod("setLastModifiedDate",
						Date.class);

				method.invoke(_user_SSORemoteModel, lastModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUser_SSORemoteModel() {
		return _user_SSORemoteModel;
	}

	public void setUser_SSORemoteModel(BaseModel<?> user_SSORemoteModel) {
		_user_SSORemoteModel = user_SSORemoteModel;
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

		Class<?> remoteModelClass = _user_SSORemoteModel.getClass();

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

		Object returnValue = method.invoke(_user_SSORemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			User_SSOLocalServiceUtil.addUser_SSO(this);
		}
		else {
			User_SSOLocalServiceUtil.updateUser_SSO(this);
		}
	}

	@Override
	public User_SSO toEscapedModel() {
		return (User_SSO)ProxyUtil.newProxyInstance(User_SSO.class.getClassLoader(),
			new Class[] { User_SSO.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		User_SSOClp clone = new User_SSOClp();

		clone.setUserID(getUserID());
		clone.setToken(getToken());
		clone.setLastModifiedDate(getLastModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(User_SSO user_SSO) {
		int value = 0;

		value = DateUtil.compareTo(getLastModifiedDate(),
				user_SSO.getLastModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof User_SSOClp)) {
			return false;
		}

		User_SSOClp user_SSO = (User_SSOClp)obj;

		long primaryKey = user_SSO.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userID=");
		sb.append(getUserID());
		sb.append(", token=");
		sb.append(getToken());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.User_SSO");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>token</column-name><column-value><![CDATA[");
		sb.append(getToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userID;
	private String _token;
	private Date _lastModifiedDate;
	private BaseModel<?> _user_SSORemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}