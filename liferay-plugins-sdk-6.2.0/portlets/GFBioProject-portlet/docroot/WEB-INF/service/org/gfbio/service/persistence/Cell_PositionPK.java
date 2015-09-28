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
 * @author Marcel Froemming
 * @generated
 */
public class Cell_PositionPK implements Comparable<Cell_PositionPK>,
	Serializable {
	public long cellID;
	public long positionID;

	public Cell_PositionPK() {
	}

	public Cell_PositionPK(long cellID, long positionID) {
		this.cellID = cellID;
		this.positionID = positionID;
	}

	public long getCellID() {
		return cellID;
	}

	public void setCellID(long cellID) {
		this.cellID = cellID;
	}

	public long getPositionID() {
		return positionID;
	}

	public void setPositionID(long positionID) {
		this.positionID = positionID;
	}

	@Override
	public int compareTo(Cell_PositionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (cellID < pk.cellID) {
			value = -1;
		}
		else if (cellID > pk.cellID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (positionID < pk.positionID) {
			value = -1;
		}
		else if (positionID > pk.positionID) {
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

		if (!(obj instanceof Cell_PositionPK)) {
			return false;
		}

		Cell_PositionPK pk = (Cell_PositionPK)obj;

		if ((cellID == pk.cellID) && (positionID == pk.positionID)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(cellID) + String.valueOf(positionID)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("cellID");
		sb.append(StringPool.EQUAL);
		sb.append(cellID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("positionID");
		sb.append(StringPool.EQUAL);
		sb.append(positionID);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}