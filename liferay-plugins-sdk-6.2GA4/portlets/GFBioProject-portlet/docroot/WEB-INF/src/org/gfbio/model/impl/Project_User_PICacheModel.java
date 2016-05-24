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
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.Project_User_PI;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project_User_PI in entity cache.
 *
 * @author Marcel Froemming
 * @see Project_User_PI
 * @generated
 */
public class Project_User_PICacheModel implements CacheModel<Project_User_PI>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project_User_PI toEntityModel() {
		Project_User_PIImpl project_User_PIImpl = new Project_User_PIImpl();

		project_User_PIImpl.setProjectID(projectID);
		project_User_PIImpl.setUserID(userID);

		if (startDate == Long.MIN_VALUE) {
			project_User_PIImpl.setStartDate(null);
		}
		else {
			project_User_PIImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			project_User_PIImpl.setEndDate(null);
		}
		else {
			project_User_PIImpl.setEndDate(new Date(endDate));
		}

		project_User_PIImpl.resetOriginalValues();

		return project_User_PIImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		userID = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(userID);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long projectID;
	public long userID;
	public long startDate;
	public long endDate;
}