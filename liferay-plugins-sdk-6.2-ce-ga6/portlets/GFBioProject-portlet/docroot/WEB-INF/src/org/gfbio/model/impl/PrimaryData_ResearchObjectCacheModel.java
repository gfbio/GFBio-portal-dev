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

import org.gfbio.model.PrimaryData_ResearchObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PrimaryData_ResearchObject in entity cache.
 *
 * @author Marcel Froemming
 * @see PrimaryData_ResearchObject
 * @generated
 */
public class PrimaryData_ResearchObjectCacheModel implements CacheModel<PrimaryData_ResearchObject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{primaryDataID=");
		sb.append(primaryDataID);
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
	public PrimaryData_ResearchObject toEntityModel() {
		PrimaryData_ResearchObjectImpl primaryData_ResearchObjectImpl = new PrimaryData_ResearchObjectImpl();

		primaryData_ResearchObjectImpl.setPrimaryDataID(primaryDataID);
		primaryData_ResearchObjectImpl.setResearchObjectID(researchObjectID);
		primaryData_ResearchObjectImpl.setResearchObjectVersion(researchObjectVersion);

		if (lastModifiedDate == Long.MIN_VALUE) {
			primaryData_ResearchObjectImpl.setLastModifiedDate(null);
		}
		else {
			primaryData_ResearchObjectImpl.setLastModifiedDate(new Date(
					lastModifiedDate));
		}

		primaryData_ResearchObjectImpl.resetOriginalValues();

		return primaryData_ResearchObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		primaryDataID = objectInput.readLong();
		researchObjectID = objectInput.readLong();
		researchObjectVersion = objectInput.readInt();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(primaryDataID);
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeInt(researchObjectVersion);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long primaryDataID;
	public long researchObjectID;
	public int researchObjectVersion;
	public long lastModifiedDate;
}