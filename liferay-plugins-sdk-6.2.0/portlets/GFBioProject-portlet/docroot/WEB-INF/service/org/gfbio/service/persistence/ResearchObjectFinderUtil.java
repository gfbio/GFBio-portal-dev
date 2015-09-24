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
public class ResearchObjectFinderUtil {
	public static java.util.List<org.gfbio.model.ResearchObject> getDirectParent(
		long researchObjectId) {
		return getFinder().getDirectParent(researchObjectId);
	}

	public static ResearchObjectFinder getFinder() {
		if (_finder == null) {
			_finder = (ResearchObjectFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ResearchObjectFinder.class.getName());

			ReferenceRegistry.registerReference(ResearchObjectFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ResearchObjectFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ResearchObjectFinderUtil.class,
			"_finder");
	}

	private static ResearchObjectFinder _finder;
}