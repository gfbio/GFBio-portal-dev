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
import org.gfbio.service.HeadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Felicitas Loeffler
 */
public class HeadClp extends BaseModelImpl<Head> implements Head {
	public HeadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Head.class;
	}

	@Override
	public String getModelClassName() {
		return Head.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _headID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHeadID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _headID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("headID", getHeadID());
		attributes.put("name", getName());
<<<<<<< HEAD
		attributes.put("task", getTask());
=======
		attributes.put("type", getType());
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
		attributes.put("column01", getColumn01());
		attributes.put("column02", getColumn02());
		attributes.put("column03", getColumn03());
		attributes.put("column04", getColumn04());
		attributes.put("column05", getColumn05());
		attributes.put("column06", getColumn06());
		attributes.put("column07", getColumn07());
		attributes.put("column08", getColumn08());
		attributes.put("column09", getColumn09());
		attributes.put("column10", getColumn10());
		attributes.put("column11", getColumn11());
		attributes.put("column12", getColumn12());
		attributes.put("column13", getColumn13());
		attributes.put("column14", getColumn14());
		attributes.put("column15", getColumn15());
		attributes.put("column16", getColumn16());
		attributes.put("column17", getColumn17());
		attributes.put("column18", getColumn18());
		attributes.put("column19", getColumn19());
		attributes.put("column20", getColumn20());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

<<<<<<< HEAD
		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
=======
		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
		}

		String column01 = (String)attributes.get("column01");

		if (column01 != null) {
			setColumn01(column01);
		}

		String column02 = (String)attributes.get("column02");

		if (column02 != null) {
			setColumn02(column02);
		}

		String column03 = (String)attributes.get("column03");

		if (column03 != null) {
			setColumn03(column03);
		}

		String column04 = (String)attributes.get("column04");

		if (column04 != null) {
			setColumn04(column04);
		}

		String column05 = (String)attributes.get("column05");

		if (column05 != null) {
			setColumn05(column05);
		}

		String column06 = (String)attributes.get("column06");

		if (column06 != null) {
			setColumn06(column06);
		}

		String column07 = (String)attributes.get("column07");

		if (column07 != null) {
			setColumn07(column07);
		}

		String column08 = (String)attributes.get("column08");

		if (column08 != null) {
			setColumn08(column08);
		}

		String column09 = (String)attributes.get("column09");

		if (column09 != null) {
			setColumn09(column09);
		}

		String column10 = (String)attributes.get("column10");

		if (column10 != null) {
			setColumn10(column10);
		}

		String column11 = (String)attributes.get("column11");

		if (column11 != null) {
			setColumn11(column11);
		}

		String column12 = (String)attributes.get("column12");

		if (column12 != null) {
			setColumn12(column12);
		}

		String column13 = (String)attributes.get("column13");

		if (column13 != null) {
			setColumn13(column13);
		}

		String column14 = (String)attributes.get("column14");

		if (column14 != null) {
			setColumn14(column14);
		}

		String column15 = (String)attributes.get("column15");

		if (column15 != null) {
			setColumn15(column15);
		}

		String column16 = (String)attributes.get("column16");

		if (column16 != null) {
			setColumn16(column16);
		}

		String column17 = (String)attributes.get("column17");

		if (column17 != null) {
			setColumn17(column17);
		}

		String column18 = (String)attributes.get("column18");

		if (column18 != null) {
			setColumn18(column18);
		}

		String column19 = (String)attributes.get("column19");

		if (column19 != null) {
			setColumn19(column19);
		}

		String column20 = (String)attributes.get("column20");

		if (column20 != null) {
			setColumn20(column20);
		}
	}

	@Override
	public long getHeadID() {
		return _headID;
	}

	@Override
	public void setHeadID(long headID) {
		_headID = headID;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadID", long.class);

				method.invoke(_headRemoteModel, headID);
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

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_headRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
<<<<<<< HEAD
	public String getTask() {
		return _task;
	}

	@Override
	public void setTask(String task) {
		_task = task;
=======
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

<<<<<<< HEAD
				Method method = clazz.getMethod("setTask", String.class);

				method.invoke(_headRemoteModel, task);
=======
				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_headRemoteModel, type);
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn01() {
		return _column01;
	}

	@Override
	public void setColumn01(String column01) {
		_column01 = column01;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn01", String.class);

				method.invoke(_headRemoteModel, column01);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn02() {
		return _column02;
	}

	@Override
	public void setColumn02(String column02) {
		_column02 = column02;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn02", String.class);

				method.invoke(_headRemoteModel, column02);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn03() {
		return _column03;
	}

	@Override
	public void setColumn03(String column03) {
		_column03 = column03;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn03", String.class);

				method.invoke(_headRemoteModel, column03);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn04() {
		return _column04;
	}

	@Override
	public void setColumn04(String column04) {
		_column04 = column04;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn04", String.class);

				method.invoke(_headRemoteModel, column04);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn05() {
		return _column05;
	}

	@Override
	public void setColumn05(String column05) {
		_column05 = column05;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn05", String.class);

				method.invoke(_headRemoteModel, column05);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn06() {
		return _column06;
	}

	@Override
	public void setColumn06(String column06) {
		_column06 = column06;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn06", String.class);

				method.invoke(_headRemoteModel, column06);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn07() {
		return _column07;
	}

	@Override
	public void setColumn07(String column07) {
		_column07 = column07;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn07", String.class);

				method.invoke(_headRemoteModel, column07);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn08() {
		return _column08;
	}

	@Override
	public void setColumn08(String column08) {
		_column08 = column08;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn08", String.class);

				method.invoke(_headRemoteModel, column08);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn09() {
		return _column09;
	}

	@Override
	public void setColumn09(String column09) {
		_column09 = column09;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn09", String.class);

				method.invoke(_headRemoteModel, column09);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn10() {
		return _column10;
	}

	@Override
	public void setColumn10(String column10) {
		_column10 = column10;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn10", String.class);

				method.invoke(_headRemoteModel, column10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn11() {
		return _column11;
	}

	@Override
	public void setColumn11(String column11) {
		_column11 = column11;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn11", String.class);

				method.invoke(_headRemoteModel, column11);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn12() {
		return _column12;
	}

	@Override
	public void setColumn12(String column12) {
		_column12 = column12;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn12", String.class);

				method.invoke(_headRemoteModel, column12);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn13() {
		return _column13;
	}

	@Override
	public void setColumn13(String column13) {
		_column13 = column13;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn13", String.class);

				method.invoke(_headRemoteModel, column13);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn14() {
		return _column14;
	}

	@Override
	public void setColumn14(String column14) {
		_column14 = column14;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn14", String.class);

				method.invoke(_headRemoteModel, column14);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn15() {
		return _column15;
	}

	@Override
	public void setColumn15(String column15) {
		_column15 = column15;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn15", String.class);

				method.invoke(_headRemoteModel, column15);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn16() {
		return _column16;
	}

	@Override
	public void setColumn16(String column16) {
		_column16 = column16;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn16", String.class);

				method.invoke(_headRemoteModel, column16);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn17() {
		return _column17;
	}

	@Override
	public void setColumn17(String column17) {
		_column17 = column17;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn17", String.class);

				method.invoke(_headRemoteModel, column17);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn18() {
		return _column18;
	}

	@Override
	public void setColumn18(String column18) {
		_column18 = column18;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn18", String.class);

				method.invoke(_headRemoteModel, column18);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn19() {
		return _column19;
	}

	@Override
	public void setColumn19(String column19) {
		_column19 = column19;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn19", String.class);

				method.invoke(_headRemoteModel, column19);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumn20() {
		return _column20;
	}

	@Override
	public void setColumn20(String column20) {
		_column20 = column20;

		if (_headRemoteModel != null) {
			try {
				Class<?> clazz = _headRemoteModel.getClass();

				Method method = clazz.getMethod("setColumn20", String.class);

				method.invoke(_headRemoteModel, column20);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHeadRemoteModel() {
		return _headRemoteModel;
	}

	public void setHeadRemoteModel(BaseModel<?> headRemoteModel) {
		_headRemoteModel = headRemoteModel;
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

		Class<?> remoteModelClass = _headRemoteModel.getClass();

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

		Object returnValue = method.invoke(_headRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HeadLocalServiceUtil.addHead(this);
		}
		else {
			HeadLocalServiceUtil.updateHead(this);
		}
	}

	@Override
	public Head toEscapedModel() {
		return (Head)ProxyUtil.newProxyInstance(Head.class.getClassLoader(),
			new Class[] { Head.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HeadClp clone = new HeadClp();

		clone.setHeadID(getHeadID());
		clone.setName(getName());
<<<<<<< HEAD
		clone.setTask(getTask());
=======
		clone.setType(getType());
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
		clone.setColumn01(getColumn01());
		clone.setColumn02(getColumn02());
		clone.setColumn03(getColumn03());
		clone.setColumn04(getColumn04());
		clone.setColumn05(getColumn05());
		clone.setColumn06(getColumn06());
		clone.setColumn07(getColumn07());
		clone.setColumn08(getColumn08());
		clone.setColumn09(getColumn09());
		clone.setColumn10(getColumn10());
		clone.setColumn11(getColumn11());
		clone.setColumn12(getColumn12());
		clone.setColumn13(getColumn13());
		clone.setColumn14(getColumn14());
		clone.setColumn15(getColumn15());
		clone.setColumn16(getColumn16());
		clone.setColumn17(getColumn17());
		clone.setColumn18(getColumn18());
		clone.setColumn19(getColumn19());
		clone.setColumn20(getColumn20());

		return clone;
	}

	@Override
	public int compareTo(Head head) {
		int value = 0;

		value = getName().compareTo(head.getName());

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

		if (!(obj instanceof HeadClp)) {
			return false;
		}

		HeadClp head = (HeadClp)obj;

		long primaryKey = head.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

		sb.append("{headID=");
		sb.append(getHeadID());
		sb.append(", name=");
		sb.append(getName());
<<<<<<< HEAD
		sb.append(", task=");
		sb.append(getTask());
=======
		sb.append(", type=");
		sb.append(getType());
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
		sb.append(", column01=");
		sb.append(getColumn01());
		sb.append(", column02=");
		sb.append(getColumn02());
		sb.append(", column03=");
		sb.append(getColumn03());
		sb.append(", column04=");
		sb.append(getColumn04());
		sb.append(", column05=");
		sb.append(getColumn05());
		sb.append(", column06=");
		sb.append(getColumn06());
		sb.append(", column07=");
		sb.append(getColumn07());
		sb.append(", column08=");
		sb.append(getColumn08());
		sb.append(", column09=");
		sb.append(getColumn09());
		sb.append(", column10=");
		sb.append(getColumn10());
		sb.append(", column11=");
		sb.append(getColumn11());
		sb.append(", column12=");
		sb.append(getColumn12());
		sb.append(", column13=");
		sb.append(getColumn13());
		sb.append(", column14=");
		sb.append(getColumn14());
		sb.append(", column15=");
		sb.append(getColumn15());
		sb.append(", column16=");
		sb.append(getColumn16());
		sb.append(", column17=");
		sb.append(getColumn17());
		sb.append(", column18=");
		sb.append(getColumn18());
		sb.append(", column19=");
		sb.append(getColumn19());
		sb.append(", column20=");
		sb.append(getColumn20());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Head");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
<<<<<<< HEAD
			"<column><column-name>task</column-name><column-value><![CDATA[");
		sb.append(getTask());
=======
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column01</column-name><column-value><![CDATA[");
		sb.append(getColumn01());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column02</column-name><column-value><![CDATA[");
		sb.append(getColumn02());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column03</column-name><column-value><![CDATA[");
		sb.append(getColumn03());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column04</column-name><column-value><![CDATA[");
		sb.append(getColumn04());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column05</column-name><column-value><![CDATA[");
		sb.append(getColumn05());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column06</column-name><column-value><![CDATA[");
		sb.append(getColumn06());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column07</column-name><column-value><![CDATA[");
		sb.append(getColumn07());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column08</column-name><column-value><![CDATA[");
		sb.append(getColumn08());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column09</column-name><column-value><![CDATA[");
		sb.append(getColumn09());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column10</column-name><column-value><![CDATA[");
		sb.append(getColumn10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column11</column-name><column-value><![CDATA[");
		sb.append(getColumn11());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column12</column-name><column-value><![CDATA[");
		sb.append(getColumn12());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column13</column-name><column-value><![CDATA[");
		sb.append(getColumn13());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column14</column-name><column-value><![CDATA[");
		sb.append(getColumn14());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column15</column-name><column-value><![CDATA[");
		sb.append(getColumn15());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column16</column-name><column-value><![CDATA[");
		sb.append(getColumn16());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column17</column-name><column-value><![CDATA[");
		sb.append(getColumn17());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column18</column-name><column-value><![CDATA[");
		sb.append(getColumn18());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column19</column-name><column-value><![CDATA[");
		sb.append(getColumn19());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column20</column-name><column-value><![CDATA[");
		sb.append(getColumn20());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _headID;
	private String _name;
<<<<<<< HEAD
	private String _task;
=======
	private String _type;
>>>>>>> d176538f54c6fe9eaf90e718ab7fcc3a5bdc8b96
	private String _column01;
	private String _column02;
	private String _column03;
	private String _column04;
	private String _column05;
	private String _column06;
	private String _column07;
	private String _column08;
	private String _column09;
	private String _column10;
	private String _column11;
	private String _column12;
	private String _column13;
	private String _column14;
	private String _column15;
	private String _column16;
	private String _column17;
	private String _column18;
	private String _column19;
	private String _column20;
	private BaseModel<?> _headRemoteModel;
	private Class<?> _clpSerializerClass = org.gfbio.service.ClpSerializer.class;
}