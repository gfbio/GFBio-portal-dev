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
	public static java.util.List getCellContent(long headId, long rowId,
		long columnId) {
		return getFinder().getCellContent(headId, rowId, columnId);
	}

	public static java.util.List getCellContentByContentId(long contentId) {
		return getFinder().getCellContentByContentId(contentId);
	}

	public static java.util.List getContentIdsWithoutRelationships(long rowId,
		java.lang.String columnName1, java.lang.String columnName2) {
		return getFinder()
				   .getContentIdsWithoutRelationships(rowId, columnName1,
			columnName2);
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

	public static java.util.List getHeadIdById(long contentId) {
		return getFinder().getHeadIdById(contentId);
	}

	public static java.util.List getContentIdsByRowId(long rowId) {
		return getFinder().getContentIdsByRowId(rowId);
	}

	public static java.util.List getRowIdOfRelation(
		java.lang.String cellContent1, java.lang.String cellContent2) {
		return getFinder().getRowIdOfRelation(cellContent1, cellContent2);
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