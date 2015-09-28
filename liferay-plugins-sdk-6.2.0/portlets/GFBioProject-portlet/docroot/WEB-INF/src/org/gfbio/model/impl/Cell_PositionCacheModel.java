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

import org.gfbio.model.Cell_Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Cell_Position in entity cache.
 *
 * @author Marcel Froemming
 * @see Cell_Position
 * @generated
 */
public class Cell_PositionCacheModel implements CacheModel<Cell_Position>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cellID=");
		sb.append(cellID);
		sb.append(", positionID=");
		sb.append(positionID);
		sb.append(", column=");
		sb.append(column);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cell_Position toEntityModel() {
		Cell_PositionImpl cell_PositionImpl = new Cell_PositionImpl();

		cell_PositionImpl.setCellID(cellID);
		cell_PositionImpl.setPositionID(positionID);
		cell_PositionImpl.setColumn(column);

		cell_PositionImpl.resetOriginalValues();

		return cell_PositionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cellID = objectInput.readLong();
		positionID = objectInput.readLong();
		column = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cellID);
		objectOutput.writeLong(positionID);
		objectOutput.writeInt(column);
	}

	public long cellID;
	public long positionID;
	public int column;
}