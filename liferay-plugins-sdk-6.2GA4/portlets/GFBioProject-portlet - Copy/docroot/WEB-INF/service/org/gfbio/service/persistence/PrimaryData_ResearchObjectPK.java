/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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
public class PrimaryData_ResearchObjectPK implements Comparable<PrimaryData_ResearchObjectPK>,
	Serializable {
	public long primaryDataID;
	public long researchObjectID;
	public int researchObjectVersion;

	public PrimaryData_ResearchObjectPK() {
	}

	public PrimaryData_ResearchObjectPK(long primaryDataID,
		long researchObjectID, int researchObjectVersion) {
		this.primaryDataID = primaryDataID;
		this.researchObjectID = researchObjectID;
		this.researchObjectVersion = researchObjectVersion;
	}

	public long getPrimaryDataID() {
		return primaryDataID;
	}

	public void setPrimaryDataID(long primaryDataID) {
		this.primaryDataID = primaryDataID;
	}

	public long getResearchObjectID() {
		return researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		this.researchObjectID = researchObjectID;
	}

	public int getResearchObjectVersion() {
		return researchObjectVersion;
	}

	public void setResearchObjectVersion(int researchObjectVersion) {
		this.researchObjectVersion = researchObjectVersion;
	}

	@Override
	public int compareTo(PrimaryData_ResearchObjectPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (primaryDataID < pk.primaryDataID) {
			value = -1;
		}
		else if (primaryDataID > pk.primaryDataID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (researchObjectID < pk.researchObjectID) {
			value = -1;
		}
		else if (researchObjectID > pk.researchObjectID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (researchObjectVersion < pk.researchObjectVersion) {
			value = -1;
		}
		else if (researchObjectVersion > pk.researchObjectVersion) {
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

		if (!(obj instanceof PrimaryData_ResearchObjectPK)) {
			return false;
		}

		PrimaryData_ResearchObjectPK pk = (PrimaryData_ResearchObjectPK)obj;

		if ((primaryDataID == pk.primaryDataID) &&
				(researchObjectID == pk.researchObjectID) &&
				(researchObjectVersion == pk.researchObjectVersion)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(primaryDataID) +
		String.valueOf(researchObjectID) +
		String.valueOf(researchObjectVersion)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("primaryDataID");
		sb.append(StringPool.EQUAL);
		sb.append(primaryDataID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("researchObjectID");
		sb.append(StringPool.EQUAL);
		sb.append(researchObjectID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("researchObjectVersion");
		sb.append(StringPool.EQUAL);
		sb.append(researchObjectVersion);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}