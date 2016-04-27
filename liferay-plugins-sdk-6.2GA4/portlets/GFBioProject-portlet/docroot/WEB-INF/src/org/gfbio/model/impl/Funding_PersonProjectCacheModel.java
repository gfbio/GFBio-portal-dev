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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.Funding_PersonProject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Funding_PersonProject in entity cache.
 *
 * @author Marcel Froemming
 * @see Funding_PersonProject
 * @generated
 */
public class Funding_PersonProjectCacheModel implements CacheModel<Funding_PersonProject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{projectID=");
		sb.append(projectID);
		sb.append(", fundingAgencyID=");
		sb.append(fundingAgencyID);
		sb.append(", fundingProgramID=");
		sb.append(fundingProgramID);
		sb.append(", personID=");
		sb.append(personID);
		sb.append(", personType=");
		sb.append(personType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funding_PersonProject toEntityModel() {
		Funding_PersonProjectImpl funding_PersonProjectImpl = new Funding_PersonProjectImpl();

		funding_PersonProjectImpl.setProjectID(projectID);
		funding_PersonProjectImpl.setFundingAgencyID(fundingAgencyID);
		funding_PersonProjectImpl.setFundingProgramID(fundingProgramID);
		funding_PersonProjectImpl.setPersonID(personID);

		if (personType == null) {
			funding_PersonProjectImpl.setPersonType(StringPool.BLANK);
		}
		else {
			funding_PersonProjectImpl.setPersonType(personType);
		}

		funding_PersonProjectImpl.resetOriginalValues();

		return funding_PersonProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		fundingAgencyID = objectInput.readLong();
		fundingProgramID = objectInput.readLong();
		personID = objectInput.readLong();
		personType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(fundingAgencyID);
		objectOutput.writeLong(fundingProgramID);
		objectOutput.writeLong(personID);

		if (personType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personType);
		}
	}

	public long projectID;
	public long fundingAgencyID;
	public long fundingProgramID;
	public long personID;
	public String personType;
}