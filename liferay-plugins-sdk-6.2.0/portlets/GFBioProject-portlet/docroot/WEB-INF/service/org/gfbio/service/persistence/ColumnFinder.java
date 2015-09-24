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

package org.gfbio.service.persistence;

/**
 * @author Marcel Froemming
 */
public interface ColumnFinder {
	public java.util.List<org.gfbio.model.Column> getColumnsWithRelation(
		java.lang.String columnName);

	public java.util.List getColumnIdsWithoutRelation(
		java.lang.String columnName);

	public java.util.List getColumnNameById(long columnid);

	public java.util.List getHeadIdsByColumnName(java.lang.String columnName);
}