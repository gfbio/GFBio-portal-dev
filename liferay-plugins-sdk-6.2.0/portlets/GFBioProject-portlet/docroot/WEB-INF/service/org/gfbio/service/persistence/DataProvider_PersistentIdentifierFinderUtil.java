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
public class DataProvider_PersistentIdentifierFinderUtil {
	public static java.util.List getDataProviderIds(long persistentIdentiferId) {
		return getFinder().getDataProviderIds(persistentIdentiferId);
	}

	public static java.util.List getPersistentIdentiferIds(long dataProviderId) {
		return getFinder().getPersistentIdentiferIds(dataProviderId);
	}

	public static DataProvider_PersistentIdentifierFinder getFinder() {
		if (_finder == null) {
			_finder = (DataProvider_PersistentIdentifierFinder)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					DataProvider_PersistentIdentifierFinder.class.getName());

			ReferenceRegistry.registerReference(DataProvider_PersistentIdentifierFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DataProvider_PersistentIdentifierFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DataProvider_PersistentIdentifierFinderUtil.class,
			"_finder");
	}

	private static DataProvider_PersistentIdentifierFinder _finder;
}