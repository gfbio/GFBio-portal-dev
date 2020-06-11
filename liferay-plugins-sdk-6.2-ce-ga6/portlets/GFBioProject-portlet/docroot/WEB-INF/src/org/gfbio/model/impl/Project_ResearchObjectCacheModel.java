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

import org.gfbio.model.Project_ResearchObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project_ResearchObject in entity cache.
 *
 * @author Marcel Froemming
 * @see Project_ResearchObject
 * @generated
 */
public class Project_ResearchObjectCacheModel implements CacheModel<Project_ResearchObject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", researchObjectID=");
		sb.append(researchObjectID);
		sb.append(", researchObjectVersion=");
		sb.append(researchObjectVersion);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project_ResearchObject toEntityModel() {
		Project_ResearchObjectImpl project_ResearchObjectImpl = new Project_ResearchObjectImpl();

		project_ResearchObjectImpl.setProjectID(projectID);
		project_ResearchObjectImpl.setResearchObjectID(researchObjectID);
		project_ResearchObjectImpl.setResearchObjectVersion(researchObjectVersion);

		if (lastModifiedDate == Long.MIN_VALUE) {
			project_ResearchObjectImpl.setLastModifiedDate(null);
		}
		else {
			project_ResearchObjectImpl.setLastModifiedDate(new Date(
					lastModifiedDate));
		}

		project_ResearchObjectImpl.resetOriginalValues();

		return project_ResearchObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		researchObjectID = objectInput.readLong();
		researchObjectVersion = objectInput.readInt();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeInt(researchObjectVersion);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long projectID;
	public long researchObjectID;
	public int researchObjectVersion;
	public long lastModifiedDate;
}