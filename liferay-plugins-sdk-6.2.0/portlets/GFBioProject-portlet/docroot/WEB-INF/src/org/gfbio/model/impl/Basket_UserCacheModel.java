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

import org.gfbio.model.Basket_User;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Basket_User in entity cache.
 *
 * @author Felicitas Loeffler
 * @see Basket_User
 * @generated
 */
public class Basket_UserCacheModel implements CacheModel<Basket_User>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{basketID=");
		sb.append(basketID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", basketJSON=");
		sb.append(basketJSON);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Basket_User toEntityModel() {
		Basket_UserImpl basket_UserImpl = new Basket_UserImpl();

		basket_UserImpl.setBasketID(basketID);
		basket_UserImpl.setUserID(userID);

		if (name == null) {
			basket_UserImpl.setName(StringPool.BLANK);
		}
		else {
			basket_UserImpl.setName(name);
		}

		if (basketJSON == null) {
			basket_UserImpl.setBasketJSON(StringPool.BLANK);
		}
		else {
			basket_UserImpl.setBasketJSON(basketJSON);
		}

		basket_UserImpl.resetOriginalValues();

		return basket_UserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		basketID = objectInput.readLong();
		userID = objectInput.readLong();
		name = objectInput.readUTF();
		basketJSON = objectInput.readUTF();
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

		if (basketJSON == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(basketJSON);
		}
	}

	public long basketID;
	public long userID;
	public String name;
	public String basketJSON;
}