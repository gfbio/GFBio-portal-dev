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

import org.gfbio.model.Cell_Head;
import org.gfbio.model.Cell_HeadModel;
import org.gfbio.model.Cell_HeadSoap;

import org.gfbio.service.persistence.Cell_HeadPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Cell_Head service. Represents a row in the &quot;gfbio_Cell_Head&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.Cell_HeadModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Cell_HeadImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_HeadImpl
 * @see org.gfbio.model.Cell_Head
 * @see org.gfbio.model.Cell_HeadModel
 * @generated
 */
@JSON(strict = true)
public class Cell_HeadModelImpl extends BaseModelImpl<Cell_Head>
	implements Cell_HeadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cell_ head model instance should use the {@link org.gfbio.model.Cell_Head} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_Cell_Head";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cellID", Types.BIGINT },
			{ "headID", Types.BIGINT },
			{ "column_", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_Cell_Head (cellID LONG not null,headID LONG not null,column_ INTEGER,primary key (cellID, headID))";
	public static final String TABLE_SQL_DROP = "drop table gfbio_Cell_Head";
	public static final String ORDER_BY_JPQL = " ORDER BY cell_Head.id.cellID ASC, cell_Head.id.headID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_Cell_Head.cellID ASC, gfbio_Cell_Head.headID ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.Cell_Head"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.Cell_Head"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.Cell_Head"),
			true);
	public static long CELLID_COLUMN_BITMASK = 1L;
	public static long COLUMN_COLUMN_BITMASK = 2L;
	public static long HEADID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Cell_Head toModel(Cell_HeadSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Cell_Head model = new Cell_HeadImpl();

		model.setCellID(soapModel.getCellID());
		model.setHeadID(soapModel.getHeadID());
		model.setColumn(soapModel.getColumn());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Cell_Head> toModels(Cell_HeadSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Cell_Head> models = new ArrayList<Cell_Head>(soapModels.length);

		for (Cell_HeadSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.Cell_Head"));

	public Cell_HeadModelImpl() {
	}

	@Override
	public Cell_HeadPK getPrimaryKey() {
		return new Cell_HeadPK(_cellID, _headID);
	}

	@Override
	public void setPrimaryKey(Cell_HeadPK primaryKey) {
		setCellID(primaryKey.cellID);
		setHeadID(primaryKey.headID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Cell_HeadPK(_cellID, _headID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Cell_HeadPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Cell_Head.class;
	}

	@Override
	public String getModelClassName() {
		return Cell_Head.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("headID", getHeadID());
		attributes.put("column", getColumn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		Integer column = (Integer)attributes.get("column");

		if (column != null) {
			setColumn(column);
		}
	}

	@JSON
	@Override
	public long getCellID() {
		return _cellID;
	}

	@Override
	public void setCellID(long cellID) {
		_columnBitmask |= CELLID_COLUMN_BITMASK;

		if (!_setOriginalCellID) {
			_setOriginalCellID = true;

			_originalCellID = _cellID;
		}

		_cellID = cellID;
	}

	public long getOriginalCellID() {
		return _originalCellID;
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

	@JSON
	@Override
	public int getColumn() {
		return _column;
	}

	@Override
	public void setColumn(int column) {
		_columnBitmask |= COLUMN_COLUMN_BITMASK;

		if (!_setOriginalColumn) {
			_setOriginalColumn = true;

			_originalColumn = _column;
		}

		_column = column;
	}

	public int getOriginalColumn() {
		return _originalColumn;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Cell_Head toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Cell_Head)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Cell_HeadImpl cell_HeadImpl = new Cell_HeadImpl();

		cell_HeadImpl.setCellID(getCellID());
		cell_HeadImpl.setHeadID(getHeadID());
		cell_HeadImpl.setColumn(getColumn());

		cell_HeadImpl.resetOriginalValues();

		return cell_HeadImpl;
	}

	@Override
	public int compareTo(Cell_Head cell_Head) {
		Cell_HeadPK primaryKey = cell_Head.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cell_Head)) {
			return false;
		}

		Cell_Head cell_Head = (Cell_Head)obj;

		Cell_HeadPK primaryKey = cell_Head.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		Cell_HeadModelImpl cell_HeadModelImpl = this;

		cell_HeadModelImpl._originalCellID = cell_HeadModelImpl._cellID;

		cell_HeadModelImpl._setOriginalCellID = false;

		cell_HeadModelImpl._originalHeadID = cell_HeadModelImpl._headID;

		cell_HeadModelImpl._setOriginalHeadID = false;

		cell_HeadModelImpl._originalColumn = cell_HeadModelImpl._column;

		cell_HeadModelImpl._setOriginalColumn = false;

		cell_HeadModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Cell_Head> toCacheModel() {
		Cell_HeadCacheModel cell_HeadCacheModel = new Cell_HeadCacheModel();

		cell_HeadCacheModel.cellID = getCellID();

		cell_HeadCacheModel.headID = getHeadID();

		cell_HeadCacheModel.column = getColumn();

		return cell_HeadCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cellID=");
		sb.append(getCellID());
		sb.append(", headID=");
		sb.append(getHeadID());
		sb.append(", column=");
		sb.append(getColumn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Cell_Head");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cellID</column-name><column-value><![CDATA[");
		sb.append(getCellID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headID</column-name><column-value><![CDATA[");
		sb.append(getHeadID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>column</column-name><column-value><![CDATA[");
		sb.append(getColumn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Cell_Head.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Cell_Head.class
		};
	private long _cellID;
	private long _originalCellID;
	private boolean _setOriginalCellID;
	private long _headID;
	private long _originalHeadID;
	private boolean _setOriginalHeadID;
	private int _column;
	private int _originalColumn;
	private boolean _setOriginalColumn;
	private long _columnBitmask;
	private Cell_Head _escapedModel;
}