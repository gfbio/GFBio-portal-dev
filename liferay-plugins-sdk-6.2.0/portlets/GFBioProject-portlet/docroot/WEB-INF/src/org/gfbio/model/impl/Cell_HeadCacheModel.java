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

import org.gfbio.model.Cell_Head;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Cell_Head in entity cache.
 *
 * @author Marcel Froemming
 * @see Cell_Head
 * @generated
 */
public class Cell_HeadCacheModel implements CacheModel<Cell_Head>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cellID=");
		sb.append(cellID);
		sb.append(", headID=");
		sb.append(headID);
		sb.append(", column=");
		sb.append(column);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cell_Head toEntityModel() {
		Cell_HeadImpl cell_HeadImpl = new Cell_HeadImpl();

		cell_HeadImpl.setCellID(cellID);
		cell_HeadImpl.setHeadID(headID);
		cell_HeadImpl.setColumn(column);

		cell_HeadImpl.resetOriginalValues();

		return cell_HeadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cellID = objectInput.readLong();
		headID = objectInput.readLong();
		column = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cellID);
		objectOutput.writeLong(headID);
		objectOutput.writeInt(column);
	}

	public long cellID;
	public long headID;
	public int column;
}