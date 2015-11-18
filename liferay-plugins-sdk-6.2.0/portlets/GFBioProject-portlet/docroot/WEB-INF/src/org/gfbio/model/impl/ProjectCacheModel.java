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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Marcel Froemming
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", parentProjectID=");
		sb.append(parentProjectID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setProjectID(projectID);
		projectImpl.setParentProjectID(parentProjectID);

		if (name == null) {
			projectImpl.setName(StringPool.BLANK);
		}
		else {
			projectImpl.setName(name);
		}

		if (label == null) {
			projectImpl.setLabel(StringPool.BLANK);
		}
		else {
			projectImpl.setLabel(label);
		}

		if (description == null) {
			projectImpl.setDescription(StringPool.BLANK);
		}
		else {
			projectImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			projectImpl.setStartDate(null);
		}
		else {
			projectImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectImpl.setEndDate(null);
		}
		else {
			projectImpl.setEndDate(new Date(endDate));
		}

		if (status == null) {
			projectImpl.setStatus(StringPool.BLANK);
		}
		else {
			projectImpl.setStatus(status);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		parentProjectID = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(parentProjectID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long projectID;
	public long parentProjectID;
	public String name;
	public String label;
	public String description;
	public long startDate;
	public long endDate;
	public String status;
}