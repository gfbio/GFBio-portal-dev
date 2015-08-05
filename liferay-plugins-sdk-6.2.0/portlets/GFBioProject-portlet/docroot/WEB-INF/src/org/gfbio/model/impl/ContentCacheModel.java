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

import org.gfbio.model.Content;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Content in entity cache.
 *
 * @author Marcel Froemming
 * @see Content
 * @generated
 */
public class ContentCacheModel implements CacheModel<Content>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{contentID=");
		sb.append(contentID);
		sb.append(", headID=");
		sb.append(headID);
		sb.append(", columnID=");
		sb.append(columnID);
		sb.append(", rowID=");
		sb.append(rowID);
		sb.append(", cellContent=");
		sb.append(cellContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Content toEntityModel() {
		ContentImpl contentImpl = new ContentImpl();

		contentImpl.setContentID(contentID);
		contentImpl.setHeadID(headID);
		contentImpl.setColumnID(columnID);
		contentImpl.setRowID(rowID);

		if (cellContent == null) {
			contentImpl.setCellContent(StringPool.BLANK);
		}
		else {
			contentImpl.setCellContent(cellContent);
		}

		contentImpl.resetOriginalValues();

		return contentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentID = objectInput.readLong();
		headID = objectInput.readLong();
		columnID = objectInput.readLong();
		rowID = objectInput.readLong();
		cellContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contentID);
		objectOutput.writeLong(headID);
		objectOutput.writeLong(columnID);
		objectOutput.writeLong(rowID);

		if (cellContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cellContent);
		}
	}

	public long contentID;
	public long headID;
	public long columnID;
	public long rowID;
	public String cellContent;
}