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
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.Funding_InstitutionProject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Funding_InstitutionProject in entity cache.
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProject
 * @generated
 */
public class Funding_InstitutionProjectCacheModel implements CacheModel<Funding_InstitutionProject>,
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
		sb.append(", institutionID=");
		sb.append(institutionID);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funding_InstitutionProject toEntityModel() {
		Funding_InstitutionProjectImpl funding_InstitutionProjectImpl = new Funding_InstitutionProjectImpl();

		funding_InstitutionProjectImpl.setProjectID(projectID);
		funding_InstitutionProjectImpl.setFundingAgencyID(fundingAgencyID);
		funding_InstitutionProjectImpl.setFundingProgramID(fundingProgramID);
		funding_InstitutionProjectImpl.setInstitutionID(institutionID);

		if (lastModifiedDate == Long.MIN_VALUE) {
			funding_InstitutionProjectImpl.setLastModifiedDate(null);
		}
		else {
			funding_InstitutionProjectImpl.setLastModifiedDate(new Date(
					lastModifiedDate));
		}

		funding_InstitutionProjectImpl.resetOriginalValues();

		return funding_InstitutionProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectID = objectInput.readLong();
		fundingAgencyID = objectInput.readLong();
		fundingProgramID = objectInput.readLong();
		institutionID = objectInput.readLong();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectID);
		objectOutput.writeLong(fundingAgencyID);
		objectOutput.writeLong(fundingProgramID);
		objectOutput.writeLong(institutionID);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long projectID;
	public long fundingAgencyID;
	public long fundingProgramID;
	public long institutionID;
	public long lastModifiedDate;
}