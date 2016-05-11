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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Marcel Froemming
 */
public class ContentFinderUtil {
	public static java.util.List checkExistenceOfKeyId(long headId,
		java.lang.String pk) {
		return getFinder().checkExistenceOfKeyId(headId, pk);
	}

	public static java.util.List checkKeyPairInRelationship(long headId,
		java.lang.String pk1, java.lang.String pk2) {
		return getFinder().checkKeyPairInRelationship(headId, pk1, pk2);
	}

	public static java.util.List getCellContent(long headId, long rowId,
		long columnId) {
		return getFinder().getCellContent(headId, rowId, columnId);
	}

	public static java.util.List getCellContentByContentId(long contentId) {
		return getFinder().getCellContentByContentId(contentId);
	}

	public static java.util.List getCellContentByRowIdAndColumnName(
		long rowId, java.lang.String columnName) {
		return getFinder().getCellContentByRowIdAndColumnName(rowId, columnName);
	}

	public static java.util.List getContentIdsWithoutRelationships(long rowId,
		java.lang.String columnName1, java.lang.String columnName2) {
		return getFinder()
				   .getContentIdsWithoutRelationships(rowId, columnName1,
			columnName2);
	}

	public static java.util.List getContentIdsWithNormalTableRelationships(
		long rowId, java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2) {
		return getFinder()
				   .getContentIdsWithNormalTableRelationships(rowId, tableName,
			columnName1, columnName2);
	}

	public static java.util.List getContentIdsWithRelationships(long rowId,
		java.lang.String columnName1, java.lang.String columnName2) {
		return getFinder()
				   .getContentIdsWithRelationships(rowId, columnName1,
			columnName2);
	}

	public static java.util.List getColumnIdById(long contentId) {
		return getFinder().getColumnIdById(contentId);
	}

	public static java.util.List getContentIdsByRowId(long rowId) {
		return getFinder().getContentIdsByRowId(rowId);
	}

	public static java.util.List getHeadIdById(long contentId) {
		return getFinder().getHeadIdById(contentId);
	}

	public static java.util.List getOppositeCellContentsOfRelationsByCellContent(
		long headId, java.lang.String cellcontent) {
		return getFinder()
				   .getOppositeCellContentsOfRelationsByCellContent(headId,
			cellcontent);
	}

	public static java.util.List getRowIds(long headId) {
		return getFinder().getRowIds(headId);
	}

	public static java.util.List getRowIdByCellContent(long headId,
		java.lang.String columnName, java.lang.String cellContent) {
		return getFinder().getRowIdByCellContent(headId, columnName, cellContent);
	}

	public static java.util.List getRowIdByContentId(long contentId) {
		return getFinder().getRowIdByContentId(contentId);
	}

	public static java.util.List getRowIdOfRelation(
		java.lang.String cellContent1, java.lang.String cellContent2) {
		return getFinder().getRowIdOfRelation(cellContent1, cellContent2);
	}

	public static java.util.List getRowInformationByContentId(long contentId) {
		return getFinder().getRowInformationByContentId(contentId);
	}

	public static ContentFinder getFinder() {
		if (_finder == null) {
			_finder = (ContentFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ContentFinder.class.getName());

			ReferenceRegistry.registerReference(ContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContentFinderUtil.class, "_finder");
	}

	private static ContentFinder _finder;
}