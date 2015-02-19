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

import org.gfbio.model.Project_User_Worker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project_User_Worker in entity cache.
 *
 * @author froemm
 * @see Project_User_Worker
 * @generated
 */
public class Project_User_WorkerCacheModel implements CacheModel<Project_User_Worker>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", begin=");
		sb.append(begin);
		sb.append(", end=");
		sb.append(end);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project_User_Worker toEntityModel() {
		Project_User_WorkerImpl project_User_WorkerImpl = new Project_User_WorkerImpl();

		project_User_WorkerImpl.setProjectID(projectID);
		project_User_WorkerImpl.setUserID(userID);

		if (begin == Long.MIN_VALUE) {
			project_User_WorkerImpl.setBegin(null);
		}
		else {
			project_User_WorkerImpl.setBegin(new Date(begin));
		}

		if (end == Long.MIN_VALUE) {
			project_User_WorkerImpl.setEnd(null);
		}
		else {
			project_User_WorkerImpl.setEnd(new Date(end));
		}

		project_User_WorkerImpl.resetOriginalValues();

		return project_User_WorkerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		userID = objectInput.readLong();
		begin = objectInput.readLong();
		end = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(userID);
		objectOutput.writeLong(begin);
		objectOutput.writeLong(end);
	}

	public long projectID;
	public long userID;
	public long begin;
	public long end;
}