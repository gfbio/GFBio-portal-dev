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
public class PrimaryData_ResearchObjectFinderUtil {
	public static java.util.List<java.lang.Boolean> getCheckOfResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getFinder()
				   .getCheckOfResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static java.util.List getPrimaryDataIdsByResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getFinder()
				   .getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjectsByPrimaryDataId(
		long primaryDataId) {
		return getFinder().getResearchObjectsByPrimaryDataId(primaryDataId);
	}

	public static PrimaryData_ResearchObjectFinder getFinder() {
		if (_finder == null) {
			_finder = (PrimaryData_ResearchObjectFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					PrimaryData_ResearchObjectFinder.class.getName());

			ReferenceRegistry.registerReference(PrimaryData_ResearchObjectFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PrimaryData_ResearchObjectFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PrimaryData_ResearchObjectFinderUtil.class,
			"_finder");
	}

	private static PrimaryData_ResearchObjectFinder _finder;
}