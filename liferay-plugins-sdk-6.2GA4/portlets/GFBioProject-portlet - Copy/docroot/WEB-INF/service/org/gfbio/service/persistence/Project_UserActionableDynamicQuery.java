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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.model.Project_User;

import org.gfbio.service.Project_UserLocalServiceUtil;

/**
 * @author Marcel Froemming
 * @generated
 */
public abstract class Project_UserActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public Project_UserActionableDynamicQuery() throws SystemException {
		setBaseLocalService(Project_UserLocalServiceUtil.getService());
		setClass(Project_User.class);

		setClassLoader(org.gfbio.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.projectID");
	}
}