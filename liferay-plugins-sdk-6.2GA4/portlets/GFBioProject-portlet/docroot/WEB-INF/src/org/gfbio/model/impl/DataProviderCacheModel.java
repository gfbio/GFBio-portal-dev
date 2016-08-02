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

import org.gfbio.model.DataProvider;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataProvider in entity cache.
 *
 * @author Marcel Froemming
 * @see DataProvider
 * @generated
 */
public class DataProviderCacheModel implements CacheModel<DataProvider>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{dataProviderID=");
		sb.append(dataProviderID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", description=");
		sb.append(description);
		sb.append(", address=");
		sb.append(address);
		sb.append(", website=");
		sb.append(website);
		sb.append(", training=");
		sb.append(training);
		sb.append(", physicalobjects=");
		sb.append(physicalobjects);
		sb.append(", taxonbased=");
		sb.append(taxonbased);
		sb.append(", notaxonbased=");
		sb.append(notaxonbased);
		sb.append(", livingobjects=");
		sb.append(livingobjects);
		sb.append(", deadobjects=");
		sb.append(deadobjects);
		sb.append(", sequencedata=");
		sb.append(sequencedata);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataProvider toEntityModel() {
		DataProviderImpl dataProviderImpl = new DataProviderImpl();

		dataProviderImpl.setDataProviderID(dataProviderID);

		if (name == null) {
			dataProviderImpl.setName(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setName(name);
		}

		if (label == null) {
			dataProviderImpl.setLabel(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setLabel(label);
		}

		if (description == null) {
			dataProviderImpl.setDescription(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setDescription(description);
		}

		if (address == null) {
			dataProviderImpl.setAddress(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setAddress(address);
		}

		if (website == null) {
			dataProviderImpl.setWebsite(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setWebsite(website);
		}

		if (training == null) {
			dataProviderImpl.setTraining(StringPool.BLANK);
		}
		else {
			dataProviderImpl.setTraining(training);
		}

		dataProviderImpl.setPhysicalobjects(physicalobjects);
		dataProviderImpl.setTaxonbased(taxonbased);
		dataProviderImpl.setNotaxonbased(notaxonbased);
		dataProviderImpl.setLivingobjects(livingobjects);
		dataProviderImpl.setDeadobjects(deadobjects);
		dataProviderImpl.setSequencedata(sequencedata);

		dataProviderImpl.resetOriginalValues();

		return dataProviderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataProviderID = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		description = objectInput.readUTF();
		address = objectInput.readUTF();
		website = objectInput.readUTF();
		training = objectInput.readUTF();
		physicalobjects = objectInput.readBoolean();
		taxonbased = objectInput.readBoolean();
		notaxonbased = objectInput.readBoolean();
		livingobjects = objectInput.readBoolean();
		deadobjects = objectInput.readBoolean();
		sequencedata = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dataProviderID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		if (training == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(training);
		}

		objectOutput.writeBoolean(physicalobjects);
		objectOutput.writeBoolean(taxonbased);
		objectOutput.writeBoolean(notaxonbased);
		objectOutput.writeBoolean(livingobjects);
		objectOutput.writeBoolean(deadobjects);
		objectOutput.writeBoolean(sequencedata);
	}

	public long dataProviderID;
	public String name;
	public String label;
	public String description;
	public String address;
	public String website;
	public String training;
	public boolean physicalobjects;
	public boolean taxonbased;
	public boolean notaxonbased;
	public boolean livingobjects;
	public boolean deadobjects;
	public boolean sequencedata;
}