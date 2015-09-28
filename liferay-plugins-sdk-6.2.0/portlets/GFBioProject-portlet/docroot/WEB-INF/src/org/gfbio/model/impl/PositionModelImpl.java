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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gfbio.model.Position;
import org.gfbio.model.PositionModel;
import org.gfbio.model.PositionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Position service. Represents a row in the &quot;gfbio_Position&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.PositionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PositionImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see PositionImpl
 * @see org.gfbio.model.Position
 * @see org.gfbio.model.PositionModel
 * @generated
 */
@JSON(strict = true)
public class PositionModelImpl extends BaseModelImpl<Position>
	implements PositionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a position model instance should use the {@link org.gfbio.model.Position} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_Position";
	public static final Object[][] TABLE_COLUMNS = {
			{ "positionID", Types.BIGINT },
			{ "headID", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_Position (positionID LONG not null primary key,headID LONG)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_Position";
	public static final String ORDER_BY_JPQL = " ORDER BY position.positionID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_Position.positionID ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.Position"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.Position"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.Position"),
			true);
	public static long HEADID_COLUMN_BITMASK = 1L;
	public static long POSITIONID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Position toModel(PositionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Position model = new PositionImpl();

		model.setPositionID(soapModel.getPositionID());
		model.setHeadID(soapModel.getHeadID());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Position> toModels(PositionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Position> models = new ArrayList<Position>(soapModels.length);

		for (PositionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.Position"));

	public PositionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _positionID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPositionID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _positionID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Position.class;
	}

	@Override
	public String getModelClassName() {
		return Position.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("positionID", getPositionID());
		attributes.put("headID", getHeadID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}
	}

	@JSON
	@Override
	public long getPositionID() {
		return _positionID;
	}

	@Override
	public void setPositionID(long positionID) {
		_columnBitmask = -1L;

		if (!_setOriginalPositionID) {
			_setOriginalPositionID = true;

			_originalPositionID = _positionID;
		}

		_positionID = positionID;
	}

	public long getOriginalPositionID() {
		return _originalPositionID;
	}

	@JSON
	@Override
	public long getHeadID() {
		return _headID;
	}

	@Override
	public void setHeadID(long headID) {
		_columnBitmask |= HEADID_COLUMN_BITMASK;

		if (!_setOriginalHeadID) {
			_setOriginalHeadID = true;

			_originalHeadID = _headID;
		}

		_headID = headID;
	}

	public long getOriginalHeadID() {
		return _originalHeadID;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Position.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Position toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Position)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PositionImpl positionImpl = new PositionImpl();

		positionImpl.setPositionID(getPositionID());
		positionImpl.setHeadID(getHeadID());

		positionImpl.resetOriginalValues();

		return positionImpl;
	}

	@Override
	public int compareTo(Position position) {
		int value = 0;

		if (getPositionID() < position.getPositionID()) {
			value = -1;
		}
		else if (getPositionID() > position.getPositionID()) {
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

		if (!(obj instanceof Position)) {
			return false;
		}

		Position position = (Position)obj;

		long primaryKey = position.getPrimaryKey();

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
	public void resetOriginalValues() {
		PositionModelImpl positionModelImpl = this;

		positionModelImpl._originalPositionID = positionModelImpl._positionID;

		positionModelImpl._setOriginalPositionID = false;

		positionModelImpl._originalHeadID = positionModelImpl._headID;

		positionModelImpl._setOriginalHeadID = false;

		positionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Position> toCacheModel() {
		PositionCacheModel positionCacheModel = new PositionCacheModel();

		positionCacheModel.positionID = getPositionID();

		positionCacheModel.headID = getHeadID();

		return positionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{positionID=");
		sb.append(getPositionID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Position");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>positionID</column-name><column-value><![CDATA[");
		sb.append(getPositionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Position.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Position.class
		};
	private long _positionID;
	private long _originalPositionID;
	private boolean _setOriginalPositionID;
	private long _headID;
	private long _originalHeadID;
	private boolean _setOriginalHeadID;
	private long _columnBitmask;
	private Position _escapedModel;
}