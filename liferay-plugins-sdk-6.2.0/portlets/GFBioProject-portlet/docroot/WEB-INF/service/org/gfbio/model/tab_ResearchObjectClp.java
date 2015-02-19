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
import org.gfbio.service.tab_ResearchObjectLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Felicitas Loeffler
 */
public class tab_ResearchObjectClp extends BaseModelImpl<tab_ResearchObject>
	implements tab_ResearchObject {
	public tab_ResearchObjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return tab_ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return tab_ResearchObject.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ro_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRo_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ro_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ro_ID", getRo_ID());
		attributes.put("ro_name", getRo_name());
		attributes.put("ro_meta", getRo_meta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ro_ID = (Long)attributes.get("ro_ID");

		if (ro_ID != null) {
			setRo_ID(ro_ID);
		}

		String ro_name = (String)attributes.get("ro_name");

		if (ro_name != null) {
			setRo_name(ro_name);
		}

		String ro_meta = (String)attributes.get("ro_meta");

		if (ro_meta != null) {
			setRo_meta(ro_meta);
		}
	}

	@Override
	public long getRo_ID() {
		return _ro_ID;
	}

	@Override
	public void setRo_ID(long ro_ID) {
		_ro_ID = ro_ID;

		if (_tab_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _tab_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setRo_ID", long.class);

				method.invoke(_tab_ResearchObjectRemoteModel, ro_ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRo_name() {
		return _ro_name;
	}

	@Override
	public void setRo_name(String ro_name) {
		_ro_name = ro_name;

		if (_tab_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _tab_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setRo_name", String.class);

				method.invoke(_tab_ResearchObjectRemoteModel, ro_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRo_meta() {
		return _ro_meta;
	}

	@Override
	public void setRo_meta(String ro_meta) {
		_ro_meta = ro_meta;

		if (_tab_ResearchObjectRemoteModel != null) {
			try {
				Class<?> clazz = _tab_ResearchObjectRemoteModel.getClass();

				Method method = clazz.getMethod("setRo_meta", String.class);

				method.invoke(_tab_ResearchObjectRemoteModel, ro_meta);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> gettab_ResearchObjectRemoteModel() {
		return _tab_ResearchObjectRemoteModel;
	}

	public void settab_ResearchObjectRemoteModel(
		BaseModel<?> tab_ResearchObjectRemoteModel) {
		_tab_ResearchObjectRemoteModel = tab_ResearchObjectRemoteModel;
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

		Class<?> remoteModelClass = _tab_ResearchObjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tab_ResearchObjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			tab_ResearchObjectLocalServiceUtil.addtab_ResearchObject(this);
		}
		else {
			tab_ResearchObjectLocalServiceUtil.updatetab_ResearchObject(this);
		}
	}

	@Override
	public tab_ResearchObject toEscapedModel() {
		return (tab_ResearchObject)ProxyUtil.newProxyInstance(tab_ResearchObject.class.getClassLoader(),
			new Class[] { tab_ResearchObject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		tab_ResearchObjectClp clone = new tab_ResearchObjectClp();

		clone.setRo_ID(getRo_ID());
		clone.setRo_name(getRo_name());
		clone.setRo_meta(getRo_meta());

		return clone;
	}

	@Override
	public int compareTo(tab_ResearchObject tab_ResearchObject) {
		int value = 0;

		value = getRo_name().compareTo(tab_ResearchObject.getRo_name());

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

		if (!(obj instanceof tab_ResearchObjectClp)) {
			return false;
		}

		tab_ResearchObjectClp tab_ResearchObject = (tab_ResearchObjectClp)obj;

		long primaryKey = tab_ResearchObject.getPrimaryKey();

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

		sb.append("{ro_ID=");
		sb.append(getRo_ID());
		sb.append(", ro_name=");
		sb.append(getRo_name());
		sb.append(", ro_meta=");
		sb.append(getRo_meta());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.tab_ResearchObject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ro_ID</column-name><column-value><![CDATA[");
		sb.append(getRo_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ro_name</column-name><column-value><![CDATA[");
		sb.append(getRo_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ro_meta</column-name><column-value><![CDATA[");
		sb.append(getRo_meta());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ro_ID;
	private String _ro_name;
	private String _ro_meta;
	private BaseModel<?> _tab_ResearchObjectRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}