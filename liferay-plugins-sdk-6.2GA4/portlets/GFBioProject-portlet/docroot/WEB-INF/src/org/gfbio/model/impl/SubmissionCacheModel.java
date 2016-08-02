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

import org.gfbio.model.Submission;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Submission in entity cache.
 *
 * @author Marcel Froemming
 * @see Submission
 * @generated
 */
public class SubmissionCacheModel implements CacheModel<Submission>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{submissionID=");
		sb.append(submissionID);
		sb.append(", researchObjectID=");
		sb.append(researchObjectID);
		sb.append(", researchObjectVersion=");
		sb.append(researchObjectVersion);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", brokerSubmissionID=");
		sb.append(brokerSubmissionID);
		sb.append(", archivePID=");
		sb.append(archivePID);
		sb.append(", archivePIDType=");
		sb.append(archivePIDType);
		sb.append(", lastChanged=");
		sb.append(lastChanged);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", isPublic=");
		sb.append(isPublic);
		sb.append(", publicAfter=");
		sb.append(publicAfter);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Submission toEntityModel() {
		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setSubmissionID(submissionID);
		submissionImpl.setResearchObjectID(researchObjectID);
		submissionImpl.setResearchObjectVersion(researchObjectVersion);

		if (archive == null) {
			submissionImpl.setArchive(StringPool.BLANK);
		}
		else {
			submissionImpl.setArchive(archive);
		}

		if (brokerSubmissionID == null) {
			submissionImpl.setBrokerSubmissionID(StringPool.BLANK);
		}
		else {
			submissionImpl.setBrokerSubmissionID(brokerSubmissionID);
		}

		if (archivePID == null) {
			submissionImpl.setArchivePID(StringPool.BLANK);
		}
		else {
			submissionImpl.setArchivePID(archivePID);
		}

		submissionImpl.setArchivePIDType(archivePIDType);

		if (lastChanged == Long.MIN_VALUE) {
			submissionImpl.setLastChanged(null);
		}
		else {
			submissionImpl.setLastChanged(new Date(lastChanged));
		}

		submissionImpl.setUserID(userID);
		submissionImpl.setIsPublic(isPublic);

		if (publicAfter == Long.MIN_VALUE) {
			submissionImpl.setPublicAfter(null);
		}
		else {
			submissionImpl.setPublicAfter(new Date(publicAfter));
		}

		if (status == null) {
			submissionImpl.setStatus(StringPool.BLANK);
		}
		else {
			submissionImpl.setStatus(status);
		}

		submissionImpl.resetOriginalValues();

		return submissionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		submissionID = objectInput.readLong();
		researchObjectID = objectInput.readLong();
		researchObjectVersion = objectInput.readLong();
		archive = objectInput.readUTF();
		brokerSubmissionID = objectInput.readUTF();
		archivePID = objectInput.readUTF();
		archivePIDType = objectInput.readLong();
		lastChanged = objectInput.readLong();
		userID = objectInput.readLong();
		isPublic = objectInput.readBoolean();
		publicAfter = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submissionID);
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeLong(researchObjectVersion);

		if (archive == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(archive);
		}

		if (brokerSubmissionID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(brokerSubmissionID);
		}

		if (archivePID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(archivePID);
		}

		objectOutput.writeLong(archivePIDType);
		objectOutput.writeLong(lastChanged);
		objectOutput.writeLong(userID);
		objectOutput.writeBoolean(isPublic);
		objectOutput.writeLong(publicAfter);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long submissionID;
	public long researchObjectID;
	public long researchObjectVersion;
	public String archive;
	public String brokerSubmissionID;
	public String archivePID;
	public long archivePIDType;
	public long lastChanged;
	public long userID;
	public boolean isPublic;
	public long publicAfter;
	public String status;
}