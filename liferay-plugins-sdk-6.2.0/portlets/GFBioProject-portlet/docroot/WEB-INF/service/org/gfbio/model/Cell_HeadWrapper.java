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
 * This class is a wrapper for {@link Cell_Head}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_Head
 * @generated
 */
public class Cell_HeadWrapper implements Cell_Head, ModelWrapper<Cell_Head> {
	public Cell_HeadWrapper(Cell_Head cell_Head) {
		_cell_Head = cell_Head;
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

	/**
	* Returns the primary key of this cell_ head.
	*
	* @return the primary key of this cell_ head
	*/
	@Override
	public org.gfbio.service.persistence.Cell_HeadPK getPrimaryKey() {
		return _cell_Head.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cell_ head.
	*
	* @param primaryKey the primary key of this cell_ head
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.Cell_HeadPK primaryKey) {
		_cell_Head.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cell i d of this cell_ head.
	*
	* @return the cell i d of this cell_ head
	*/
	@Override
	public long getCellID() {
		return _cell_Head.getCellID();
	}

	/**
	* Sets the cell i d of this cell_ head.
	*
	* @param cellID the cell i d of this cell_ head
	*/
	@Override
	public void setCellID(long cellID) {
		_cell_Head.setCellID(cellID);
	}

	/**
	* Returns the head i d of this cell_ head.
	*
	* @return the head i d of this cell_ head
	*/
	@Override
	public long getHeadID() {
		return _cell_Head.getHeadID();
	}

	/**
	* Sets the head i d of this cell_ head.
	*
	* @param headID the head i d of this cell_ head
	*/
	@Override
	public void setHeadID(long headID) {
		_cell_Head.setHeadID(headID);
	}

	/**
	* Returns the column of this cell_ head.
	*
	* @return the column of this cell_ head
	*/
	@Override
	public int getColumn() {
		return _cell_Head.getColumn();
	}

	/**
	* Sets the column of this cell_ head.
	*
	* @param column the column of this cell_ head
	*/
	@Override
	public void setColumn(int column) {
		_cell_Head.setColumn(column);
	}

	@Override
	public boolean isNew() {
		return _cell_Head.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cell_Head.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cell_Head.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cell_Head.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cell_Head.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cell_Head.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cell_Head.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cell_Head.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cell_Head.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cell_Head.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cell_Head.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Cell_HeadWrapper((Cell_Head)_cell_Head.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Cell_Head cell_Head) {
		return _cell_Head.compareTo(cell_Head);
	}

	@Override
	public int hashCode() {
		return _cell_Head.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Cell_Head> toCacheModel() {
		return _cell_Head.toCacheModel();
	}

	@Override
	public org.gfbio.model.Cell_Head toEscapedModel() {
		return new Cell_HeadWrapper(_cell_Head.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Cell_Head toUnescapedModel() {
		return new Cell_HeadWrapper(_cell_Head.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cell_Head.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cell_Head.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cell_Head.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Cell_HeadWrapper)) {
			return false;
		}

		Cell_HeadWrapper cell_HeadWrapper = (Cell_HeadWrapper)obj;

		if (Validator.equals(_cell_Head, cell_HeadWrapper._cell_Head)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cell_Head getWrappedCell_Head() {
		return _cell_Head;
	}

	@Override
	public Cell_Head getWrappedModel() {
		return _cell_Head;
	}

	@Override
	public void resetOriginalValues() {
		_cell_Head.resetOriginalValues();
	}

	private Cell_Head _cell_Head;
}