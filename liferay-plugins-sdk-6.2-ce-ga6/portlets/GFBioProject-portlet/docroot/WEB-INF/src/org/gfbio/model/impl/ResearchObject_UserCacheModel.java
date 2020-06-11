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

import org.gfbio.model.ResearchObject_User;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResearchObject_User in entity cache.
 *
 * @author Marcel Froemming
 * @see ResearchObject_User
 * @generated
 */
public class ResearchObject_UserCacheModel implements CacheModel<ResearchObject_User>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{researchObjectID=");
		sb.append(researchObjectID);
		sb.append(", researchObjectVersion=");
		sb.append(researchObjectVersion);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResearchObject_User toEntityModel() {
		ResearchObject_UserImpl researchObject_UserImpl = new ResearchObject_UserImpl();

		researchObject_UserImpl.setResearchObjectID(researchObjectID);
		researchObject_UserImpl.setResearchObjectVersion(researchObjectVersion);
		researchObject_UserImpl.setUserID(userID);

		if (startDate == Long.MIN_VALUE) {
			researchObject_UserImpl.setStartDate(null);
		}
		else {
			researchObject_UserImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			researchObject_UserImpl.setEndDate(null);
		}
		else {
			researchObject_UserImpl.setEndDate(new Date(endDate));
		}

		if (userType == null) {
			researchObject_UserImpl.setUserType(StringPool.BLANK);
		}
		else {
			researchObject_UserImpl.setUserType(userType);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			researchObject_UserImpl.setLastModifiedDate(null);
		}
		else {
			researchObject_UserImpl.setLastModifiedDate(new Date(
					lastModifiedDate));
		}

		researchObject_UserImpl.resetOriginalValues();

		return researchObject_UserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		researchObjectID = objectInput.readLong();
		researchObjectVersion = objectInput.readInt();
		userID = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		userType = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeInt(researchObjectVersion);
		objectOutput.writeLong(userID);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (userType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userType);
		}

		objectOutput.writeLong(lastModifiedDate);
	}

	public long researchObjectID;
	public int researchObjectVersion;
	public long userID;
	public long startDate;
	public long endDate;
	public String userType;
	public long lastModifiedDate;
}