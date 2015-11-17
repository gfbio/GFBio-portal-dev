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
public class SubmissionRegistryPK implements Comparable<SubmissionRegistryPK>,
	Serializable {
	public long researchObjectID;
	public long researchObjectVersion;
	public String archive;

	public SubmissionRegistryPK() {
	}

	public SubmissionRegistryPK(long researchObjectID,
		long researchObjectVersion, String archive) {
		this.researchObjectID = researchObjectID;
		this.researchObjectVersion = researchObjectVersion;
		this.archive = archive;
	}

	public long getResearchObjectID() {
		return researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		this.researchObjectID = researchObjectID;
	}

	public long getResearchObjectVersion() {
		return researchObjectVersion;
	}

	public void setResearchObjectVersion(long researchObjectVersion) {
		this.researchObjectVersion = researchObjectVersion;
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	@Override
	public int compareTo(SubmissionRegistryPK pk) {
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

		value = archive.compareTo(pk.archive);

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

		if (!(obj instanceof SubmissionRegistryPK)) {
			return false;
		}

		SubmissionRegistryPK pk = (SubmissionRegistryPK)obj;

		if ((researchObjectID == pk.researchObjectID) &&
				(researchObjectVersion == pk.researchObjectVersion) &&
				(archive.equals(pk.archive))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(researchObjectID) +
		String.valueOf(researchObjectVersion) + String.valueOf(archive)).hashCode();
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
		sb.append("archive");
		sb.append(StringPool.EQUAL);
		sb.append(archive);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}