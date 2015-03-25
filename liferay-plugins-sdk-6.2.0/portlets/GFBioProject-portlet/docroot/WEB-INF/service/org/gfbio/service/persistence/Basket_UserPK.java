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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Felicitas Loeffler
 */
public class Basket_UserPK implements Comparable<Basket_UserPK>, Serializable {
	public long basketID;
	public long userID;

	public Basket_UserPK() {
	}

	public Basket_UserPK(long basketID, long userID) {
		this.basketID = basketID;
		this.userID = userID;
	}

	public long getBasketID() {
		return basketID;
	}

	public void setBasketID(long basketID) {
		this.basketID = basketID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	@Override
	public int compareTo(Basket_UserPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (basketID < pk.basketID) {
			value = -1;
		}
		else if (basketID > pk.basketID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userID < pk.userID) {
			value = -1;
		}
		else if (userID > pk.userID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Basket_UserPK)) {
			return false;
		}

		Basket_UserPK pk = (Basket_UserPK)obj;

		if ((basketID == pk.basketID) && (userID == pk.userID)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(basketID) + String.valueOf(userID)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("basketID");
		sb.append(StringPool.EQUAL);
		sb.append(basketID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userID");
		sb.append(StringPool.EQUAL);
		sb.append(userID);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}