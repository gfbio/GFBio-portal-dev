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
public class ResearchObject_UserPK implements Comparable<ResearchObject_UserPK>,
	Serializable {
	public long researchObjectID;
	public int researchObjectVersion;
	public long userID;

	public ResearchObject_UserPK() {
	}

	public ResearchObject_UserPK(long researchObjectID,
		int researchObjectVersion, long userID) {
		this.researchObjectID = researchObjectID;
		this.researchObjectVersion = researchObjectVersion;
		this.userID = userID;
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

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	@Override
	public int compareTo(ResearchObject_UserPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

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

		if (!(obj instanceof ResearchObject_UserPK)) {
			return false;
		}

		ResearchObject_UserPK pk = (ResearchObject_UserPK)obj;

		if ((researchObjectID == pk.researchObjectID) &&
				(researchObjectVersion == pk.researchObjectVersion) &&
				(userID == pk.userID)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(researchObjectID) +
		String.valueOf(researchObjectVersion) + String.valueOf(userID)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("researchObjectID");
		sb.append(StringPool.EQUAL);
		sb.append(researchObjectID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("researchObjectVersion");
		sb.append(StringPool.EQUAL);
		sb.append(researchObjectVersion);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userID");
		sb.append(StringPool.EQUAL);
		sb.append(userID);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}