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
 * This class is a wrapper for {@link Column}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Column
 * @generated
 */
public class ColumnWrapper implements Column, ModelWrapper<Column> {
	public ColumnWrapper(Column column) {
		_column = column;
	}

	@Override
	public Class<?> getModelClass() {
		return Column.class;
	}

	@Override
	public String getModelClassName() {
		return Column.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("columnID", getColumnID());
		attributes.put("headID", getHeadID());
		attributes.put("column_name", getColumn_name());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long columnID = (Long)attributes.get("columnID");

		if (columnID != null) {
			setColumnID(columnID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String column_name = (String)attributes.get("column_name");

		if (column_name != null) {
			setColumn_name(column_name);
		}
	}

	/**
	* Returns the primary key of this column.
	*
	* @return the primary key of this column
	*/
	@Override
	public long getPrimaryKey() {
		return _column.getPrimaryKey();
	}

	/**
	* Sets the primary key of this column.
	*
	* @param primaryKey the primary key of this column
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_column.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the column i d of this column.
	*
	* @return the column i d of this column
	*/
	@Override
	public long getColumnID() {
		return _column.getColumnID();
	}

	/**
	* Sets the column i d of this column.
	*
	* @param columnID the column i d of this column
	*/
	@Override
	public void setColumnID(long columnID) {
		_column.setColumnID(columnID);
	}

	/**
	* Returns the head i d of this column.
	*
	* @return the head i d of this column
	*/
	@Override
	public long getHeadID() {
		return _column.getHeadID();
	}

	/**
	* Sets the head i d of this column.
	*
	* @param headID the head i d of this column
	*/
	@Override
	public void setHeadID(long headID) {
		_column.setHeadID(headID);
	}

	/**
	* Returns the column_name of this column.
	*
	* @return the column_name of this column
	*/
	@Override
	public java.lang.String getColumn_name() {
		return _column.getColumn_name();
	}

	/**
	* Sets the column_name of this column.
	*
	* @param column_name the column_name of this column
	*/
	@Override
	public void setColumn_name(java.lang.String column_name) {
		_column.setColumn_name(column_name);
	}

	@Override
	public boolean isNew() {
		return _column.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_column.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _column.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_column.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _column.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _column.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_column.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _column.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_column.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_column.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_column.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ColumnWrapper((Column)_column.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Column column) {
		return _column.compareTo(column);
	}

	@Override
	public int hashCode() {
		return _column.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Column> toCacheModel() {
		return _column.toCacheModel();
	}

	@Override
	public org.gfbio.model.Column toEscapedModel() {
		return new ColumnWrapper(_column.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Column toUnescapedModel() {
		return new ColumnWrapper(_column.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _column.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _column.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_column.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColumnWrapper)) {
			return false;
		}

		ColumnWrapper columnWrapper = (ColumnWrapper)obj;

		if (Validator.equals(_column, columnWrapper._column)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Column getWrappedColumn() {
		return _column;
	}

	@Override
	public Column getWrappedModel() {
		return _column;
	}

	@Override
	public void resetOriginalValues() {
		_column.resetOriginalValues();
	}

	private Column _column;
}