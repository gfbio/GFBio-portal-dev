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

import org.gfbio.model.ResearchObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResearchObject in entity cache.
 *
 * @author Marcel Froemming
 * @see ResearchObject
 * @generated
 */
public class ResearchObjectCacheModel implements CacheModel<ResearchObject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{researchObjectID=");
		sb.append(researchObjectID);
		sb.append(", researchObjectVersion=");
		sb.append(researchObjectVersion);
		sb.append(", parentResearchObjectID=");
		sb.append(parentResearchObjectID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", label=");
		sb.append(label);
		sb.append(", description=");
		sb.append(description);
		sb.append(", extendeddata=");
		sb.append(extendeddata);
		sb.append(", metadataID=");
		sb.append(metadataID);
		sb.append(", licenseID=");
		sb.append(licenseID);
		sb.append(", researchObjectType=");
		sb.append(researchObjectType);
		sb.append(", publications=");
		sb.append(publications);
		sb.append(", dataCollectionTime=");
		sb.append(dataCollectionTime);
		sb.append(", embargo=");
		sb.append(embargo);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResearchObject toEntityModel() {
		ResearchObjectImpl researchObjectImpl = new ResearchObjectImpl();

		researchObjectImpl.setResearchObjectID(researchObjectID);
		researchObjectImpl.setResearchObjectVersion(researchObjectVersion);
		researchObjectImpl.setParentResearchObjectID(parentResearchObjectID);

		if (name == null) {
			researchObjectImpl.setName(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setName(name);
		}

		if (label == null) {
			researchObjectImpl.setLabel(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setLabel(label);
		}

		if (description == null) {
			researchObjectImpl.setDescription(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setDescription(description);
		}

		if (extendeddata == null) {
			researchObjectImpl.setExtendeddata(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setExtendeddata(extendeddata);
		}

		researchObjectImpl.setMetadataID(metadataID);
		researchObjectImpl.setLicenseID(licenseID);

		if (researchObjectType == null) {
			researchObjectImpl.setResearchObjectType(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setResearchObjectType(researchObjectType);
		}

		if (publications == null) {
			researchObjectImpl.setPublications(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setPublications(publications);
		}

		if (dataCollectionTime == null) {
			researchObjectImpl.setDataCollectionTime(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setDataCollectionTime(dataCollectionTime);
		}

		if (embargo == Long.MIN_VALUE) {
			researchObjectImpl.setEmbargo(null);
		}
		else {
			researchObjectImpl.setEmbargo(new Date(embargo));
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			researchObjectImpl.setLastModifiedDate(null);
		}
		else {
			researchObjectImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		researchObjectImpl.resetOriginalValues();

		return researchObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		researchObjectID = objectInput.readLong();
		researchObjectVersion = objectInput.readInt();
		parentResearchObjectID = objectInput.readLong();
		name = objectInput.readUTF();
		label = objectInput.readUTF();
		description = objectInput.readUTF();
		extendeddata = objectInput.readUTF();
		metadataID = objectInput.readLong();
		licenseID = objectInput.readLong();
		researchObjectType = objectInput.readUTF();
		publications = objectInput.readUTF();
		dataCollectionTime = objectInput.readUTF();
		embargo = objectInput.readLong();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeInt(researchObjectVersion);
		objectOutput.writeLong(parentResearchObjectID);

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

		if (extendeddata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extendeddata);
		}

		objectOutput.writeLong(metadataID);
		objectOutput.writeLong(licenseID);

		if (researchObjectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(researchObjectType);
		}

		if (publications == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publications);
		}

		if (dataCollectionTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataCollectionTime);
		}

		objectOutput.writeLong(embargo);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long researchObjectID;
	public int researchObjectVersion;
	public long parentResearchObjectID;
	public String name;
	public String label;
	public String description;
	public String extendeddata;
	public long metadataID;
	public long licenseID;
	public String researchObjectType;
	public String publications;
	public String dataCollectionTime;
	public long embargo;
	public long lastModifiedDate;
}