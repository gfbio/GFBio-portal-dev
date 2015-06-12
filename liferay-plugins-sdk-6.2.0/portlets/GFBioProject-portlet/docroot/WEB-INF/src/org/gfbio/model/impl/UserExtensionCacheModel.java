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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.UserExtension;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserExtension in entity cache.
 *
 * @author Felicitas Loeffler
 * @see UserExtension
 * @generated
 */
public class UserExtensionCacheModel implements CacheModel<UserExtension>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{userID=");
		sb.append(userID);

		return sb.toString();
	}

	@Override
	public UserExtension toEntityModel() {
		UserExtensionImpl userExtensionImpl = new UserExtensionImpl();

		userExtensionImpl.setUserID(userID);

		userExtensionImpl.resetOriginalValues();

		return userExtensionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userID = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userID);
	}

	public long userID;
}