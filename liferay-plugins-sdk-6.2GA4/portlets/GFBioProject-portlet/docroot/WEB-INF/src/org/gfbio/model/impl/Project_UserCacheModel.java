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

import org.gfbio.model.Project_User;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project_User in entity cache.
 *
 * @author Marcel Froemming
 * @see Project_User
 * @generated
 */
public class Project_UserCacheModel implements CacheModel<Project_User>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", usertype=");
		sb.append(usertype);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project_User toEntityModel() {
		Project_UserImpl project_UserImpl = new Project_UserImpl();

		project_UserImpl.setProjectID(projectID);
		project_UserImpl.setUserID(userID);

		if (usertype == null) {
			project_UserImpl.setUsertype(StringPool.BLANK);
		}
		else {
			project_UserImpl.setUsertype(usertype);
		}

		if (startDate == Long.MIN_VALUE) {
			project_UserImpl.setStartDate(null);
		}
		else {
			project_UserImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			project_UserImpl.setEndDate(null);
		}
		else {
			project_UserImpl.setEndDate(new Date(endDate));
		}

		project_UserImpl.resetOriginalValues();

		return project_UserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		userID = objectInput.readLong();
		usertype = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(userID);

		if (usertype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(usertype);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long projectID;
	public long userID;
	public String usertype;
	public long startDate;
	public long endDate;
}