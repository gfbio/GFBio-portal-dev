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
public class ResearchObject_UserFinderUtil {
	public static java.util.List<java.lang.Boolean> getCheckOfResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getFinder()
				   .getCheckOfResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId, int researchObjectVersion) {
		return getFinder()
				   .getOwnerIdsByResearchObjectIds(researchObjectId,
			researchObjectVersion);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjectsByUserId(
		long userId) {
		return getFinder().getResearchObjectsByUserId(userId);
	}

	public static java.util.List getUserIdsByResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getFinder()
				   .getUserIdsByResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static ResearchObject_UserFinder getFinder() {
		if (_finder == null) {
			_finder = (ResearchObject_UserFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ResearchObject_UserFinder.class.getName());

			ReferenceRegistry.registerReference(ResearchObject_UserFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ResearchObject_UserFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ResearchObject_UserFinderUtil.class,
			"_finder");
	}

	private static ResearchObject_UserFinder _finder;
}