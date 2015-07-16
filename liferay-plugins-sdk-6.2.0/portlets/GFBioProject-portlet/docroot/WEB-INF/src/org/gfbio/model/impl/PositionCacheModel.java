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

import org.gfbio.model.Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Position in entity cache.
 *
 * @author Marcel Froemming
 * @see Position
 * @generated
 */
public class PositionCacheModel implements CacheModel<Position>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{positionID=");
		sb.append(positionID);
		sb.append(", headID=");
		sb.append(headID);
		sb.append(", columnID=");
		sb.append(columnID);
		sb.append(", rowID=");
		sb.append(rowID);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Position toEntityModel() {
		PositionImpl positionImpl = new PositionImpl();

		positionImpl.setPositionID(positionID);
		positionImpl.setHeadID(headID);
		positionImpl.setColumnID(columnID);
		positionImpl.setRowID(rowID);

		if (content == null) {
			positionImpl.setContent(StringPool.BLANK);
		}
		else {
			positionImpl.setContent(content);
		}

		positionImpl.resetOriginalValues();

		return positionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		positionID = objectInput.readLong();
		headID = objectInput.readLong();
		columnID = objectInput.readLong();
		rowID = objectInput.readLong();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(positionID);
		objectOutput.writeLong(headID);
		objectOutput.writeLong(columnID);
		objectOutput.writeLong(rowID);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long positionID;
	public long headID;
	public long columnID;
	public long rowID;
	public String content;
}