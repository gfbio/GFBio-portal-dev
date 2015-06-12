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
 * This class is a wrapper for {@link Cell}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell
 * @generated
 */
public class CellWrapper implements Cell, ModelWrapper<Cell> {
	public CellWrapper(Cell cell) {
		_cell = cell;
	}

	@Override
	public Class<?> getModelClass() {
		return Cell.class;
	}

	@Override
	public String getModelClassName() {
		return Cell.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cellID", getCellID());
		attributes.put("content", getContent());
		attributes.put("task", getTask());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cellID = (Long)attributes.get("cellID");

		if (cellID != null) {
			setCellID(cellID);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
		}
	}

	/**
	* Returns the primary key of this cell.
	*
	* @return the primary key of this cell
	*/
	@Override
	public long getPrimaryKey() {
		return _cell.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cell.
	*
	* @param primaryKey the primary key of this cell
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cell.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cell i d of this cell.
	*
	* @return the cell i d of this cell
	*/
	@Override
	public long getCellID() {
		return _cell.getCellID();
	}

	/**
	* Sets the cell i d of this cell.
	*
	* @param cellID the cell i d of this cell
	*/
	@Override
	public void setCellID(long cellID) {
		_cell.setCellID(cellID);
	}

	/**
	* Returns the content of this cell.
	*
	* @return the content of this cell
	*/
	@Override
	public java.lang.String getContent() {
		return _cell.getContent();
	}

	/**
	* Sets the content of this cell.
	*
	* @param content the content of this cell
	*/
	@Override
	public void setContent(java.lang.String content) {
		_cell.setContent(content);
	}

	/**
	* Returns the task of this cell.
	*
	* @return the task of this cell
	*/
	@Override
	public java.lang.String getTask() {
		return _cell.getTask();
	}

	/**
	* Sets the task of this cell.
	*
	* @param task the task of this cell
	*/
	@Override
	public void setTask(java.lang.String task) {
		_cell.setTask(task);
	}

	@Override
	public boolean isNew() {
		return _cell.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cell.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cell.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cell.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cell.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cell.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cell.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cell.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cell.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cell.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cell.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CellWrapper((Cell)_cell.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Cell cell) {
		return _cell.compareTo(cell);
	}

	@Override
	public int hashCode() {
		return _cell.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Cell> toCacheModel() {
		return _cell.toCacheModel();
	}

	@Override
	public org.gfbio.model.Cell toEscapedModel() {
		return new CellWrapper(_cell.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Cell toUnescapedModel() {
		return new CellWrapper(_cell.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cell.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cell.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cell.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CellWrapper)) {
			return false;
		}

		CellWrapper cellWrapper = (CellWrapper)obj;

		if (Validator.equals(_cell, cellWrapper._cell)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cell getWrappedCell() {
		return _cell;
	}

	@Override
	public Cell getWrappedModel() {
		return _cell;
	}

	@Override
	public void resetOriginalValues() {
		_cell.resetOriginalValues();
	}

	private Cell _cell;
}