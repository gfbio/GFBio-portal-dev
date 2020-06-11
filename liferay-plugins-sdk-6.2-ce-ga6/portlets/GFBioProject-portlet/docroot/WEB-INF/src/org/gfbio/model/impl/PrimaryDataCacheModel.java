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

import org.gfbio.model.PrimaryData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PrimaryData in entity cache.
 *
 * @author Marcel Froemming
 * @see PrimaryData
 * @generated
 */
public class PrimaryDataCacheModel implements CacheModel<PrimaryData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{primaryDataID=");
		sb.append(primaryDataID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", path=");
		sb.append(path);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PrimaryData toEntityModel() {
		PrimaryDataImpl primaryDataImpl = new PrimaryDataImpl();

		primaryDataImpl.setPrimaryDataID(primaryDataID);

		if (name == null) {
			primaryDataImpl.setName(StringPool.BLANK);
		}
		else {
			primaryDataImpl.setName(name);
		}

		if (path == null) {
			primaryDataImpl.setPath(StringPool.BLANK);
		}
		else {
			primaryDataImpl.setPath(path);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			primaryDataImpl.setLastModifiedDate(null);
		}
		else {
			primaryDataImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		primaryDataImpl.resetOriginalValues();

		return primaryDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		primaryDataID = objectInput.readLong();
		name = objectInput.readUTF();
		path = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(primaryDataID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(lastModifiedDate);
	}

	public long primaryDataID;
	public String name;
	public String path;
	public long lastModifiedDate;
}