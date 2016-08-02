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

import org.gfbio.model.Head;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Head in entity cache.
 *
 * @author Marcel Froemming
 * @see Head
 * @generated
 */
public class HeadCacheModel implements CacheModel<Head>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{headID=");
		sb.append(headID);
		sb.append(", table_name=");
		sb.append(table_name);
		sb.append(", table_type=");
		sb.append(table_type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Head toEntityModel() {
		HeadImpl headImpl = new HeadImpl();

		headImpl.setHeadID(headID);

		if (table_name == null) {
			headImpl.setTable_name(StringPool.BLANK);
		}
		else {
			headImpl.setTable_name(table_name);
		}

		if (table_type == null) {
			headImpl.setTable_type(StringPool.BLANK);
		}
		else {
			headImpl.setTable_type(table_type);
		}

		headImpl.resetOriginalValues();

		return headImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		headID = objectInput.readLong();
		table_name = objectInput.readUTF();
		table_type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(headID);

		if (table_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(table_name);
		}

		if (table_type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(table_type);
		}
	}

	public long headID;
	public String table_name;
	public String table_type;
}