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
public class ColumnFinderUtil {
	public static java.util.List<org.gfbio.model.Column> getColumnsWithRelation(
		java.lang.String columnName) {
		return getFinder().getColumnsWithRelation(columnName);
	}

	public static java.util.List getHeadIdsWithoutRelationshipsByColumnName(
		java.lang.String columnName) {
		return getFinder().getHeadIdsWithoutRelationshipsByColumnName(columnName);
	}

	public static java.util.List getColumnNameById(long columnid) {
		return getFinder().getColumnNameById(columnid);
	}

	public static java.util.List getCountofColumns(long headId) {
		return getFinder().getCountofColumns(headId);
	}

	public static java.util.List getHeadIdsByColumnName(
		java.lang.String columnName) {
		return getFinder().getHeadIdsByColumnName(columnName);
	}

	public static ColumnFinder getFinder() {
		if (_finder == null) {
			_finder = (ColumnFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ColumnFinder.class.getName());

			ReferenceRegistry.registerReference(ColumnFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ColumnFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ColumnFinderUtil.class, "_finder");
	}

	private static ColumnFinder _finder;
}