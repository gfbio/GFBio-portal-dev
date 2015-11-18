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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.ResearchObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
		StringBundler sb = new StringBundler(17);

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
		sb.append(", metadata=");
		sb.append(metadata);
		sb.append(", formatmetadata=");
		sb.append(formatmetadata);
		sb.append(", researchObjectType=");
		sb.append(researchObjectType);
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

		if (metadata == null) {
			researchObjectImpl.setMetadata(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setMetadata(metadata);
		}

		if (formatmetadata == null) {
			researchObjectImpl.setFormatmetadata(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setFormatmetadata(formatmetadata);
		}

		if (researchObjectType == null) {
			researchObjectImpl.setResearchObjectType(StringPool.BLANK);
		}
		else {
			researchObjectImpl.setResearchObjectType(researchObjectType);
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
		metadata = objectInput.readUTF();
		formatmetadata = objectInput.readUTF();
		researchObjectType = objectInput.readUTF();
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

		if (metadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadata);
		}

		if (formatmetadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formatmetadata);
		}

		if (researchObjectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(researchObjectType);
		}
	}

	public long researchObjectID;
	public int researchObjectVersion;
	public long parentResearchObjectID;
	public String name;
	public String label;
	public String metadata;
	public String formatmetadata;
	public String researchObjectType;
}