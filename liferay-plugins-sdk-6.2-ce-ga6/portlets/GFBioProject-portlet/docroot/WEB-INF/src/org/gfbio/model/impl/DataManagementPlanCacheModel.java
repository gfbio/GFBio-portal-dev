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

import org.gfbio.model.DataManagementPlan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataManagementPlan in entity cache.
 *
 * @author Marcel Froemming
 * @see DataManagementPlan
 * @generated
 */
public class DataManagementPlanCacheModel implements CacheModel<DataManagementPlan>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{dmpID=");
		sb.append(dmpID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", dmpTInput=");
		sb.append(dmpTInput);
		sb.append(", ticketID=");
		sb.append(ticketID);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataManagementPlan toEntityModel() {
		DataManagementPlanImpl dataManagementPlanImpl = new DataManagementPlanImpl();

		dataManagementPlanImpl.setDmpID(dmpID);

		if (name == null) {
			dataManagementPlanImpl.setName(StringPool.BLANK);
		}
		else {
			dataManagementPlanImpl.setName(name);
		}

		dataManagementPlanImpl.setUserID(userID);

		if (dmpTInput == null) {
			dataManagementPlanImpl.setDmpTInput(StringPool.BLANK);
		}
		else {
			dataManagementPlanImpl.setDmpTInput(dmpTInput);
		}

		dataManagementPlanImpl.setTicketID(ticketID);

		if (lastModifiedDate == Long.MIN_VALUE) {
			dataManagementPlanImpl.setLastModifiedDate(null);
		}
		else {
			dataManagementPlanImpl.setLastModifiedDate(new Date(
					lastModifiedDate));
		}

		dataManagementPlanImpl.resetOriginalValues();

		return dataManagementPlanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dmpID = objectInput.readLong();
		name = objectInput.readUTF();
		userID = objectInput.readLong();
		dmpTInput = objectInput.readUTF();
		ticketID = objectInput.readLong();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dmpID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(userID);

		if (dmpTInput == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dmpTInput);
		}

		objectOutput.writeLong(ticketID);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long dmpID;
	public String name;
	public long userID;
	public String dmpTInput;
	public long ticketID;
	public long lastModifiedDate;
}