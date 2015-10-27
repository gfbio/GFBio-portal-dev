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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Marcel Froemming
 */
public class HeadFinderUtil {
	public static java.util.List getEntitiesByHeadId(long headId) {
		return getFinder().getEntitiesByHeadId(headId);
	}

	public static java.util.List<org.gfbio.model.Head> getHeadBetweenHeadIds(
		int start, int end) {
		return getFinder().getHeadBetweenHeadIds(start, end);
	}

	public static java.util.List getHeadIdByTableName(
		java.lang.String tableName) {
		return getFinder().getHeadIdByTableName(tableName);
	}

	public static java.util.List getTableNameById(long headId) {
		return getFinder().getTableNameById(headId);
	}

	public static HeadFinder getFinder() {
		if (_finder == null) {
			_finder = (HeadFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					HeadFinder.class.getName());

			ReferenceRegistry.registerReference(HeadFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(HeadFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HeadFinderUtil.class, "_finder");
	}

	private static HeadFinder _finder;
}