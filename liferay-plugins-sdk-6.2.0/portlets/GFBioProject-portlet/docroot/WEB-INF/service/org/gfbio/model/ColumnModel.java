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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Column service. Represents a row in the &quot;gfbio_Column&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.ColumnModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.ColumnImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Column
 * @see org.gfbio.model.impl.ColumnImpl
 * @see org.gfbio.model.impl.ColumnModelImpl
 * @generated
 */
public interface ColumnModel extends BaseModel<Column> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a column model instance should use the {@link Column} interface instead.
	 */

	/**
	 * Returns the primary key of this column.
	 *
	 * @return the primary key of this column
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this column.
	 *
	 * @param primaryKey the primary key of this column
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the column i d of this column.
	 *
	 * @return the column i d of this column
	 */
	public long getColumnID();

	/**
	 * Sets the column i d of this column.
	 *
	 * @param columnID the column i d of this column
	 */
	public void setColumnID(long columnID);

	/**
	 * Returns the head i d of this column.
	 *
	 * @return the head i d of this column
	 */
	public long getHeadID();

	/**
	 * Sets the head i d of this column.
	 *
	 * @param headID the head i d of this column
	 */
	public void setHeadID(long headID);

	/**
	 * Returns the column_name of this column.
	 *
	 * @return the column_name of this column
	 */
	@AutoEscape
	public String getColumn_name();

	/**
	 * Sets the column_name of this column.
	 *
	 * @param column_name the column_name of this column
	 */
	public void setColumn_name(String column_name);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(org.gfbio.model.Column column);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.gfbio.model.Column> toCacheModel();

	@Override
	public org.gfbio.model.Column toEscapedModel();

	@Override
	public org.gfbio.model.Column toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}