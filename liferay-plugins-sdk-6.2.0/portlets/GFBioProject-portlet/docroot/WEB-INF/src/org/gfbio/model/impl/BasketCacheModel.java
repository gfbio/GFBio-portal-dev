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

import org.gfbio.model.Basket;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Basket in entity cache.
 *
 * @author Felicitas Loeffler
 * @see Basket
 * @generated
 */
public class BasketCacheModel implements CacheModel<Basket>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{basketID=");
		sb.append(basketID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append(", basketJSON=");
		sb.append(basketJSON);
		sb.append(", queryJSON=");
		sb.append(queryJSON);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Basket toEntityModel() {
		BasketImpl basketImpl = new BasketImpl();

		basketImpl.setBasketID(basketID);
		basketImpl.setUserID(userID);

		if (name == null) {
			basketImpl.setName(StringPool.BLANK);
		}
		else {
			basketImpl.setName(name);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			basketImpl.setLastModifiedDate(null);
		}
		else {
			basketImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		if (basketJSON == null) {
			basketImpl.setBasketJSON(StringPool.BLANK);
		}
		else {
			basketImpl.setBasketJSON(basketJSON);
		}

		if (queryJSON == null) {
			basketImpl.setQueryJSON(StringPool.BLANK);
		}
		else {
			basketImpl.setQueryJSON(queryJSON);
		}

		basketImpl.resetOriginalValues();

		return basketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		basketID = objectInput.readLong();
		userID = objectInput.readLong();
		name = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
		basketJSON = objectInput.readUTF();
		queryJSON = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(basketID);
		objectOutput.writeLong(userID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(lastModifiedDate);

		if (basketJSON == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(basketJSON);
		}

		if (queryJSON == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(queryJSON);
		}
	}

	public long basketID;
	public long userID;
	public String name;
	public long lastModifiedDate;
	public String basketJSON;
	public String queryJSON;
}