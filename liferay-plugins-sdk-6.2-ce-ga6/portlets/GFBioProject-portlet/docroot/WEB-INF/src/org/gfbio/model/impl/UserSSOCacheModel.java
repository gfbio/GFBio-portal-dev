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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.UserSSO;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserSSO in entity cache.
 *
 * @author Marcel Froemming
 * @see UserSSO
 * @generated
 */
public class UserSSOCacheModel implements CacheModel<UserSSO>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userID=");
		sb.append(userID);
		sb.append(", token=");
		sb.append(token);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserSSO toEntityModel() {
		UserSSOImpl userSSOImpl = new UserSSOImpl();

		userSSOImpl.setUserID(userID);

		if (token == null) {
			userSSOImpl.setToken(StringPool.BLANK);
		}
		else {
			userSSOImpl.setToken(token);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			userSSOImpl.setLastModifiedDate(null);
		}
		else {
			userSSOImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		userSSOImpl.resetOriginalValues();

		return userSSOImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userID = objectInput.readLong();
		token = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userID);

		if (token == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(token);
		}

		objectOutput.writeLong(lastModifiedDate);
	}

	public long userID;
	public String token;
	public long lastModifiedDate;
}