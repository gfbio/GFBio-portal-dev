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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.model.UserGoesternID;

import org.gfbio.service.UserGoesternIDLocalServiceUtil;

/**
 * The extended model base implementation for the UserGoesternID service. Represents a row in the &quot;gfbio_UserGoesternID&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserGoesternIDImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserGoesternIDImpl
 * @see org.gfbio.model.UserGoesternID
 * @generated
 */
public abstract class UserGoesternIDBaseImpl extends UserGoesternIDModelImpl
	implements UserGoesternID {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user goestern i d model instance should use the {@link UserGoesternID} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserGoesternIDLocalServiceUtil.addUserGoesternID(this);
		}
		else {
			UserGoesternIDLocalServiceUtil.updateUserGoesternID(this);
		}
	}
}