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

import org.gfbio.model.Cell;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Cell in entity cache.
 *
 * @author Marcel Froemming
 * @see Cell
 * @generated
 */
public class CellCacheModel implements CacheModel<Cell>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cellID=");
		sb.append(cellID);
		sb.append(", content=");
		sb.append(content);
		sb.append(", task=");
		sb.append(task);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cell toEntityModel() {
		CellImpl cellImpl = new CellImpl();

		cellImpl.setCellID(cellID);

		if (content == null) {
			cellImpl.setContent(StringPool.BLANK);
		}
		else {
			cellImpl.setContent(content);
		}

		if (task == null) {
			cellImpl.setTask(StringPool.BLANK);
		}
		else {
			cellImpl.setTask(task);
		}

		cellImpl.resetOriginalValues();

		return cellImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cellID = objectInput.readLong();
		content = objectInput.readUTF();
		task = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cellID);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (task == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(task);
		}
	}

	public long cellID;
	public String content;
	public String task;
}