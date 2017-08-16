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
public class PrimaryDataFinderUtil {
	public static java.util.List<java.lang.Boolean> getCheckPrimaryDataExists(
		java.lang.String name, java.lang.String path) {
		return getFinder().getCheckPrimaryDataExists(name, path);
	}

	public static java.util.List getMaxId() {
		return getFinder().getMaxId();
	}

	public static java.util.List<java.lang.String> getPathByPrimaryDataId(
		long primaryDataId) {
		return getFinder().getPathByPrimaryDataId(primaryDataId);
	}

	public static PrimaryDataFinder getFinder() {
		if (_finder == null) {
			_finder = (PrimaryDataFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					PrimaryDataFinder.class.getName());

			ReferenceRegistry.registerReference(PrimaryDataFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PrimaryDataFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PrimaryDataFinderUtil.class,
			"_finder");
	}

	private static PrimaryDataFinder _finder;
}