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
public class ContentFinderUtil {
	public static java.util.List getRowIds(long headId) {
		return getFinder().getRowIds(headId);
	}

	public static java.util.List getCellContent(long headId, long rowId,
		long columnId) {
		return getFinder().getCellContent(headId, rowId, columnId);
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