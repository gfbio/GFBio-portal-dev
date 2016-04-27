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
public class Funding_PersonProjectPK implements Comparable<Funding_PersonProjectPK>,
	Serializable {
	public long projectID;
	public long fundingAgencyID;
	public long fundingProgramID;
	public long personID;
	public String personType;

	public Funding_PersonProjectPK() {
	}

	public Funding_PersonProjectPK(long projectID, long fundingAgencyID,
		long fundingProgramID, long personID, String personType) {
		this.projectID = projectID;
		this.fundingAgencyID = fundingAgencyID;
		this.fundingProgramID = fundingProgramID;
		this.personID = personID;
		this.personType = personType;
	}

	public long getProjectID() {
		return projectID;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}

	public long getFundingAgencyID() {
		return fundingAgencyID;
	}

	public void setFundingAgencyID(long fundingAgencyID) {
		this.fundingAgencyID = fundingAgencyID;
	}

	public long getFundingProgramID() {
		return fundingProgramID;
	}

	public void setFundingProgramID(long fundingProgramID) {
		this.fundingProgramID = fundingProgramID;
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	@Override
	public int compareTo(Funding_PersonProjectPK pk) {
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

		if (fundingAgencyID < pk.fundingAgencyID) {
			value = -1;
		}
		else if (fundingAgencyID > pk.fundingAgencyID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (fundingProgramID < pk.fundingProgramID) {
			value = -1;
		}
		else if (fundingProgramID > pk.fundingProgramID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (personID < pk.personID) {
			value = -1;
		}
		else if (personID > pk.personID) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = personType.compareTo(pk.personType);

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

		if (!(obj instanceof Funding_PersonProjectPK)) {
			return false;
		}

		Funding_PersonProjectPK pk = (Funding_PersonProjectPK)obj;

		if ((projectID == pk.projectID) &&
				(fundingAgencyID == pk.fundingAgencyID) &&
				(fundingProgramID == pk.fundingProgramID) &&
				(personID == pk.personID) &&
				(personType.equals(pk.personType))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(projectID) + String.valueOf(fundingAgencyID) +
		String.valueOf(fundingProgramID) + String.valueOf(personID) +
		String.valueOf(personType)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("projectID");
		sb.append(StringPool.EQUAL);
		sb.append(projectID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("fundingAgencyID");
		sb.append(StringPool.EQUAL);
		sb.append(fundingAgencyID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("fundingProgramID");
		sb.append(StringPool.EQUAL);
		sb.append(fundingProgramID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("personID");
		sb.append(StringPool.EQUAL);
		sb.append(personID);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("personType");
		sb.append(StringPool.EQUAL);
		sb.append(personType);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}