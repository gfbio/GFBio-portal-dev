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

import org.gfbio.service.ClpSerializer;
import org.gfbio.service.UserExtensionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Felicitas Loeffler
 */
public class UserExtensionClp extends BaseModelImpl<UserExtension>
	implements UserExtension {
	public UserExtensionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserExtension.class;
	}

	@Override
	public String getModelClassName() {
		return UserExtension.class.getName();
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}
	}

	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_userID = userID;

		if (_userExtensionRemoteModel != null) {
			try {
				Class<?> clazz = _userExtensionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserID", long.class);

				method.invoke(_userExtensionRemoteModel, userID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserExtensionRemoteModel() {
		return _userExtensionRemoteModel;
	}

	public void setUserExtensionRemoteModel(
		BaseModel<?> userExtensionRemoteModel) {
		_userExtensionRemoteModel = userExtensionRemoteModel;
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

		Class<?> remoteModelClass = _userExtensionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userExtensionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserExtensionLocalServiceUtil.addUserExtension(this);
		}
		else {
			UserExtensionLocalServiceUtil.updateUserExtension(this);
		}
	}

	@Override
	public UserExtension toEscapedModel() {
		return (UserExtension)ProxyUtil.newProxyInstance(UserExtension.class.getClassLoader(),
			new Class[] { UserExtension.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserExtensionClp clone = new UserExtensionClp();

		clone.setUserID(getUserID());

		return clone;
	}

	@Override
	public int compareTo(UserExtension userExtension) {
		int value = 0;

		if (getUserID() < userExtension.getUserID()) {
			value = -1;
		}
		else if (getUserID() > userExtension.getUserID()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof UserExtensionClp)) {
			return false;
		}

		UserExtensionClp userExtension = (UserExtensionClp)obj;

		long primaryKey = userExtension.getPrimaryKey();

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
		StringBundler sb = new StringBundler(3);

		sb.append("{userID=");
		sb.append(getUserID());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.UserExtension");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userID;
	private BaseModel<?> _userExtensionRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}