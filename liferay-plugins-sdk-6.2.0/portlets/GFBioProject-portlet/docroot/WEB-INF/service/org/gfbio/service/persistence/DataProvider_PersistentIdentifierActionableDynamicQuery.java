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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.model.DataProvider_PersistentIdentifier;

import org.gfbio.service.DataProvider_PersistentIdentifierLocalServiceUtil;

/**
 * @author Marcel Froemming
 * @generated
 */
public abstract class DataProvider_PersistentIdentifierActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public DataProvider_PersistentIdentifierActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(DataProvider_PersistentIdentifierLocalServiceUtil.getService());
		setClass(DataProvider_PersistentIdentifier.class);

		setClassLoader(org.gfbio.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.gfbioDataProvider");
	}
}