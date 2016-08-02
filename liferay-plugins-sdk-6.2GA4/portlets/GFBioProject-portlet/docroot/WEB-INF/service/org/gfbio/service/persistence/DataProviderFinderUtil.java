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
public class DataProviderFinderUtil {
	public static java.util.List<java.lang.Boolean> getCheckOfLabel(
		java.lang.String archiv) {
		return getFinder().getCheckOfLabel(archiv);
	}

	public static java.util.List getDataProviderIdByLabel(
		java.lang.String label) {
		return getFinder().getDataProviderIdByLabel(label);
	}

	public static java.util.List getLabelById(long dataProviderId) {
		return getFinder().getLabelById(dataProviderId);
	}

	public static java.util.List getNameById(long dataProviderId) {
		return getFinder().getNameById(dataProviderId);
	}

	public static java.util.List getLabels() {
		return getFinder().getLabels();
	}

	public static DataProviderFinder getFinder() {
		if (_finder == null) {
			_finder = (DataProviderFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					DataProviderFinder.class.getName());

			ReferenceRegistry.registerReference(DataProviderFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DataProviderFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DataProviderFinderUtil.class,
			"_finder");
	}

	private static DataProviderFinder _finder;
}