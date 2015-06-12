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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cell_Position}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_Position
 * @generated
 */
public class Cell_PositionWrapper implements Cell_Position,
	ModelWrapper<Cell_Position> {
	public Cell_PositionWrapper(Cell_Position cell_Position) {
		_cell_Position = cell_Position;
	}

	@Override
	public Class<?> getModelClass() {
		return Cell_Position.class;
	}

	@Override
	public String getModelClassName() {
		return Cell_Position.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("positionID", getPositionID());
		attributes.put("column", getColumn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
		}

		Integer column = (Integer)attributes.get("column");

		if (column != null) {
			setColumn(column);
		}
	}

	/**
	* Returns the primary key of this cell_ position.
	*
	* @return the primary key of this cell_ position
	*/
	@Override
	public org.gfbio.service.persistence.Cell_PositionPK getPrimaryKey() {
		return _cell_Position.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cell_ position.
	*
	* @param primaryKey the primary key of this cell_ position
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Cell_PositionPK primaryKey) {
		_cell_Position.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cell i d of this cell_ position.
	*
	* @return the cell i d of this cell_ position
	*/
	@Override
	public long getCellID() {
		return _cell_Position.getCellID();
	}

	/**
	* Sets the cell i d of this cell_ position.
	*
	* @param cellID the cell i d of this cell_ position
	*/
	@Override
	public void setCellID(long cellID) {
		_cell_Position.setCellID(cellID);
	}

	/**
	* Returns the position i d of this cell_ position.
	*
	* @return the position i d of this cell_ position
	*/
	@Override
	public long getPositionID() {
		return _cell_Position.getPositionID();
	}

	/**
	* Sets the position i d of this cell_ position.
	*
	* @param positionID the position i d of this cell_ position
	*/
	@Override
	public void setPositionID(long positionID) {
		_cell_Position.setPositionID(positionID);
	}

	/**
	* Returns the column of this cell_ position.
	*
	* @return the column of this cell_ position
	*/
	@Override
	public int getColumn() {
		return _cell_Position.getColumn();
	}

	/**
	* Sets the column of this cell_ position.
	*
	* @param column the column of this cell_ position
	*/
	@Override
	public void setColumn(int column) {
		_cell_Position.setColumn(column);
	}

	@Override
	public boolean isNew() {
		return _cell_Position.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cell_Position.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cell_Position.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cell_Position.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cell_Position.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cell_Position.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cell_Position.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cell_Position.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cell_Position.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cell_Position.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cell_Position.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Cell_PositionWrapper((Cell_Position)_cell_Position.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Cell_Position cell_Position) {
		return _cell_Position.compareTo(cell_Position);
	}

	@Override
	public int hashCode() {
		return _cell_Position.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Cell_Position> toCacheModel() {
		return _cell_Position.toCacheModel();
	}

	@Override
	public org.gfbio.model.Cell_Position toEscapedModel() {
		return new Cell_PositionWrapper(_cell_Position.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Cell_Position toUnescapedModel() {
		return new Cell_PositionWrapper(_cell_Position.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cell_Position.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cell_Position.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cell_Position.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cell_PositionWrapper)) {
			return false;
		}

		Cell_PositionWrapper cell_PositionWrapper = (Cell_PositionWrapper)obj;

		if (Validator.equals(_cell_Position, cell_PositionWrapper._cell_Position)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cell_Position getWrappedCell_Position() {
		return _cell_Position;
	}

	@Override
	public Cell_Position getWrappedModel() {
		return _cell_Position;
	}

	@Override
	public void resetOriginalValues() {
		_cell_Position.resetOriginalValues();
	}

	private Cell_Position _cell_Position;
}