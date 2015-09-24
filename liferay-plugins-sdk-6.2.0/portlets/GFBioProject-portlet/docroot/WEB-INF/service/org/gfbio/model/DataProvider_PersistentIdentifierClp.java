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
import org.gfbio.service.DataProvider_PersistentIdentifierLocalServiceUtil;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marcel Froemming
 */
public class DataProvider_PersistentIdentifierClp extends BaseModelImpl<DataProvider_PersistentIdentifier>
	implements DataProvider_PersistentIdentifier {
	public DataProvider_PersistentIdentifierClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DataProvider_PersistentIdentifier.class;
	}

	@Override
	public String getModelClassName() {
		return DataProvider_PersistentIdentifier.class.getName();
	}

	@Override
	public DataProvider_PersistentIdentifierPK getPrimaryKey() {
		return new DataProvider_PersistentIdentifierPK(_gfbioDataProvider,
			_gfbioPersistentIdentifier);
	}

	@Override
	public void setPrimaryKey(DataProvider_PersistentIdentifierPK primaryKey) {
		setGfbioDataProvider(primaryKey.gfbioDataProvider);
		setGfbioPersistentIdentifier(primaryKey.gfbioPersistentIdentifier);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DataProvider_PersistentIdentifierPK(_gfbioDataProvider,
			_gfbioPersistentIdentifier);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DataProvider_PersistentIdentifierPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gfbioDataProvider", getGfbioDataProvider());
		attributes.put("gfbioPersistentIdentifier",
			getGfbioPersistentIdentifier());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gfbioDataProvider = (Long)attributes.get("gfbioDataProvider");

		if (gfbioDataProvider != null) {
			setGfbioDataProvider(gfbioDataProvider);
		}

		Long gfbioPersistentIdentifier = (Long)attributes.get(
				"gfbioPersistentIdentifier");

		if (gfbioPersistentIdentifier != null) {
			setGfbioPersistentIdentifier(gfbioPersistentIdentifier);
		}
	}

	@Override
	public long getGfbioDataProvider() {
		return _gfbioDataProvider;
	}

	@Override
	public void setGfbioDataProvider(long gfbioDataProvider) {
		_gfbioDataProvider = gfbioDataProvider;

		if (_dataProvider_PersistentIdentifierRemoteModel != null) {
			try {
				Class<?> clazz = _dataProvider_PersistentIdentifierRemoteModel.getClass();

				Method method = clazz.getMethod("setGfbioDataProvider",
						long.class);

				method.invoke(_dataProvider_PersistentIdentifierRemoteModel,
					gfbioDataProvider);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGfbioPersistentIdentifier() {
		return _gfbioPersistentIdentifier;
	}

	@Override
	public void setGfbioPersistentIdentifier(long gfbioPersistentIdentifier) {
		_gfbioPersistentIdentifier = gfbioPersistentIdentifier;

		if (_dataProvider_PersistentIdentifierRemoteModel != null) {
			try {
				Class<?> clazz = _dataProvider_PersistentIdentifierRemoteModel.getClass();

				Method method = clazz.getMethod("setGfbioPersistentIdentifier",
						long.class);

				method.invoke(_dataProvider_PersistentIdentifierRemoteModel,
					gfbioPersistentIdentifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDataProvider_PersistentIdentifierRemoteModel() {
		return _dataProvider_PersistentIdentifierRemoteModel;
	}

	public void setDataProvider_PersistentIdentifierRemoteModel(
		BaseModel<?> dataProvider_PersistentIdentifierRemoteModel) {
		_dataProvider_PersistentIdentifierRemoteModel = dataProvider_PersistentIdentifierRemoteModel;
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

		Class<?> remoteModelClass = _dataProvider_PersistentIdentifierRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dataProvider_PersistentIdentifierRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DataProvider_PersistentIdentifierLocalServiceUtil.addDataProvider_PersistentIdentifier(this);
		}
		else {
			DataProvider_PersistentIdentifierLocalServiceUtil.updateDataProvider_PersistentIdentifier(this);
		}
	}

	@Override
	public DataProvider_PersistentIdentifier toEscapedModel() {
		return (DataProvider_PersistentIdentifier)ProxyUtil.newProxyInstance(DataProvider_PersistentIdentifier.class.getClassLoader(),
			new Class[] { DataProvider_PersistentIdentifier.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DataProvider_PersistentIdentifierClp clone = new DataProvider_PersistentIdentifierClp();

		clone.setGfbioDataProvider(getGfbioDataProvider());
		clone.setGfbioPersistentIdentifier(getGfbioPersistentIdentifier());

		return clone;
	}

	@Override
	public int compareTo(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		DataProvider_PersistentIdentifierPK primaryKey = dataProvider_PersistentIdentifier.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataProvider_PersistentIdentifierClp)) {
			return false;
		}

		DataProvider_PersistentIdentifierClp dataProvider_PersistentIdentifier = (DataProvider_PersistentIdentifierClp)obj;

		DataProvider_PersistentIdentifierPK primaryKey = dataProvider_PersistentIdentifier.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{gfbioDataProvider=");
		sb.append(getGfbioDataProvider());
		sb.append(", gfbioPersistentIdentifier=");
		sb.append(getGfbioPersistentIdentifier());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.DataProvider_PersistentIdentifier");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>gfbioDataProvider</column-name><column-value><![CDATA[");
		sb.append(getGfbioDataProvider());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gfbioPersistentIdentifier</column-name><column-value><![CDATA[");
		sb.append(getGfbioPersistentIdentifier());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _gfbioDataProvider;
	private long _gfbioPersistentIdentifier;
	private BaseModel<?> _dataProvider_PersistentIdentifierRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}