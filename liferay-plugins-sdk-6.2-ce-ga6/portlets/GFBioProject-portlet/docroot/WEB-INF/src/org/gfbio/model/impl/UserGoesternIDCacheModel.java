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

import org.gfbio.model.UserGoesternID;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserGoesternID in entity cache.
 *
 * @author Marcel Froemming
 * @see UserGoesternID
 * @generated
 */
public class UserGoesternIDCacheModel implements CacheModel<UserGoesternID>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userID=");
		sb.append(userID);
		sb.append(", goeSternID=");
		sb.append(goeSternID);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserGoesternID toEntityModel() {
		UserGoesternIDImpl userGoesternIDImpl = new UserGoesternIDImpl();

		userGoesternIDImpl.setUserID(userID);

		if (goeSternID == null) {
			userGoesternIDImpl.setGoeSternID(StringPool.BLANK);
		}
		else {
			userGoesternIDImpl.setGoeSternID(goeSternID);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			userGoesternIDImpl.setLastModifiedDate(null);
		}
		else {
			userGoesternIDImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		userGoesternIDImpl.resetOriginalValues();

		return userGoesternIDImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userID = objectInput.readLong();
		goeSternID = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userID);

		if (goeSternID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(goeSternID);
		}

		objectOutput.writeLong(lastModifiedDate);
	}

	public long userID;
	public String goeSternID;
	public long lastModifiedDate;
}