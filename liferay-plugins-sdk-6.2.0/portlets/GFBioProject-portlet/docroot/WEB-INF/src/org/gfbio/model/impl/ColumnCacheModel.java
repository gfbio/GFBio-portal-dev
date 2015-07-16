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

import org.gfbio.model.Column;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Column in entity cache.
 *
 * @author Marcel Froemming
 * @see Column
 * @generated
 */
public class ColumnCacheModel implements CacheModel<Column>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{columnID=");
		sb.append(columnID);
		sb.append(", headID=");
		sb.append(headID);
		sb.append(", column_name=");
		sb.append(column_name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Column toEntityModel() {
		ColumnImpl columnImpl = new ColumnImpl();

		columnImpl.setColumnID(columnID);
		columnImpl.setHeadID(headID);

		if (column_name == null) {
			columnImpl.setColumn_name(StringPool.BLANK);
		}
		else {
			columnImpl.setColumn_name(column_name);
		}

		columnImpl.resetOriginalValues();

		return columnImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		columnID = objectInput.readLong();
		headID = objectInput.readLong();
		column_name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(columnID);
		objectOutput.writeLong(headID);

		if (column_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column_name);
		}
	}

	public long columnID;
	public long headID;
	public String column_name;
}