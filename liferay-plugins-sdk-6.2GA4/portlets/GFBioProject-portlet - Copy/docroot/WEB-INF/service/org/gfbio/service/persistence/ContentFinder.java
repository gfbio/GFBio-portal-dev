/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
public interface ContentFinder {
	public java.util.List checkExistenceOfKeyId(long headId, java.lang.String pk);

	public java.util.List checkKeyPairInRelationship(long headId,
		java.lang.String pk1, java.lang.String pk2);

	public java.util.List getCellContent(long headId, long rowId, long columnId);

	public java.util.List getCellContentByContentId(long contentId);

	public java.util.List getCellContentByRowIdAndColumnName(long rowId,
		java.lang.String columnName);

	public java.util.List getContentIdsOfRelationshipsOfSpecificCellContent(
		long relationTableHeadId, long entitiyTableHeadId,
		java.lang.String entityTableCellContent);

	public java.util.List getContentIdsWithoutRelationships(long id,
		java.lang.String columnName1, java.lang.String columnName2);

	public java.util.List getContentIdsWithNormalTableRelationships(long id,
		java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2);

	public java.util.List getContentIdsWithRelationships(long id,
		java.lang.String columnName1, java.lang.String columnName2);

	public java.util.List getColumnIdById(long contentId);

	public java.util.List getContentIdByRowIdAndColumnName(long rowId,
		java.lang.String columnName);

	public java.util.List getContentIdsByRowId(long rowId);

	public java.util.List getHeadIdById(long contentId);

	public java.util.List getHeadIdByRowId(long rowId);

	public java.util.List getMaxId();

	public java.util.List getOppositeCellContentsOfRelationsByCellContent(
		long headId, java.lang.String cellcontent);

	public java.util.List getOppositeCellContentsOfRelationsByCellContentAndColumn(
		long headId, long columnId, java.lang.String cellcontent);

	public java.util.List getRowIds(long headId);

	public java.util.List getRowIdByCellContent(long headId,
		java.lang.String columnName, java.lang.String cellContent);

	public java.util.List getRowIdByContentId(long contentId);

	public java.util.List getRowIdOfRelation(java.lang.String cellContent1,
		java.lang.String cellContent2);

	public java.util.List getRowInformationByContentId(long contentId);

	public java.util.List getRowInformationByRowId(long rowId);

	public java.util.List getRowIdsOfCategoryWithSpecificType(long typeHeadId,
		java.lang.String typeName, long typeColumnId, long categoryTypeHeadId,
		long categoryTypeCategoryColumnId, long relationTableHeadId,
		java.lang.String relatedId);
}