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
public class PositionFinderUtil {
	public static java.util.List getRowIds(long headId) {
		return getFinder().getRowIds(headId);
	}

	public static PositionFinder getFinder() {
		if (_finder == null) {
			_finder = (PositionFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					PositionFinder.class.getName());

			ReferenceRegistry.registerReference(PositionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PositionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PositionFinderUtil.class, "_finder");
	}

	private static PositionFinder _finder;
}