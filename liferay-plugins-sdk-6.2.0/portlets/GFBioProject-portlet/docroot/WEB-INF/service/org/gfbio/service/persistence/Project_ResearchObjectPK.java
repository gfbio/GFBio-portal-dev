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
public class Project_ResearchObjectPK implements Comparable<Project_ResearchObjectPK>,
	Serializable {
	public long projectID;
	public long researchObjectID;

	public Project_ResearchObjectPK() {
	}

	public Project_ResearchObjectPK(long projectID, long researchObjectID) {
		this.projectID = projectID;
		this.researchObjectID = researchObjectID;
	}

	public long getProjectID() {
		return projectID;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}

	public long getResearchObjectID() {
		return researchObjectID;
	}

	public void setResearchObjectID(long researchObjectID) {
		this.researchObjectID = researchObjectID;
	}

	@Override
	public int compareTo(Project_ResearchObjectPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (projectID < pk.projectID) {
			value = -1;
		}
		else if (projectID > pk.projectID) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Project_ResearchObjectPK)) {
			return false;
		}

		Project_ResearchObjectPK pk = (Project_ResearchObjectPK)obj;

		if ((projectID == pk.projectID) &&
				(researchObjectID == pk.researchObjectID)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(projectID) + String.valueOf(researchObjectID)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("projectID");
		sb.append(StringPool.EQUAL);
		sb.append(projectID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("researchObjectID");
		sb.append(StringPool.EQUAL);
		sb.append(researchObjectID);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}