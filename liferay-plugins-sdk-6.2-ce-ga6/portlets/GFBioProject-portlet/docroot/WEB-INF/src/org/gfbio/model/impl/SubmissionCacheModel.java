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
		StringBundler sb = new StringBundler(29);

		sb.append("{submissionID=");
		sb.append(submissionID);
		sb.append(", isPublic=");
		sb.append(isPublic);
		sb.append(", lastChanged=");
		sb.append(lastChanged);
		sb.append(", publicAfter=");
		sb.append(publicAfter);
		sb.append(", researchObjectVersion=");
		sb.append(researchObjectVersion);
		sb.append(", archivePIDType=");
		sb.append(archivePIDType);
		sb.append(", researchObjectID=");
		sb.append(researchObjectID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", archivePID=");
		sb.append(archivePID);
		sb.append(", brokerSubmissionID=");
		sb.append(brokerSubmissionID);
		sb.append(", jiraID=");
		sb.append(jiraID);
		sb.append(", jiraKey=");
		sb.append(jiraKey);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Submission toEntityModel() {
		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setSubmissionID(submissionID);
		submissionImpl.setIsPublic(isPublic);

		if (lastChanged == Long.MIN_VALUE) {
			submissionImpl.setLastChanged(null);
		}
		else {
			submissionImpl.setLastChanged(new Date(lastChanged));
		}

		if (publicAfter == Long.MIN_VALUE) {
			submissionImpl.setPublicAfter(null);
		}
		else {
			submissionImpl.setPublicAfter(new Date(publicAfter));
		}

		submissionImpl.setResearchObjectVersion(researchObjectVersion);
		submissionImpl.setArchivePIDType(archivePIDType);
		submissionImpl.setResearchObjectID(researchObjectID);
		submissionImpl.setUserID(userID);

		if (archive == null) {
			submissionImpl.setArchive(StringPool.BLANK);
		}
		else {
			submissionImpl.setArchive(archive);
		}

		if (archivePID == null) {
			submissionImpl.setArchivePID(StringPool.BLANK);
		}
		else {
			submissionImpl.setArchivePID(archivePID);
		}

		if (brokerSubmissionID == null) {
			submissionImpl.setBrokerSubmissionID(StringPool.BLANK);
		}
		else {
			submissionImpl.setBrokerSubmissionID(brokerSubmissionID);
		}

		if (jiraID == null) {
			submissionImpl.setJiraID(StringPool.BLANK);
		}
		else {
			submissionImpl.setJiraID(jiraID);
		}

		if (jiraKey == null) {
			submissionImpl.setJiraKey(StringPool.BLANK);
		}
		else {
			submissionImpl.setJiraKey(jiraKey);
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
		isPublic = objectInput.readBoolean();
		lastChanged = objectInput.readLong();
		publicAfter = objectInput.readLong();
		researchObjectVersion = objectInput.readInt();
		archivePIDType = objectInput.readLong();
		researchObjectID = objectInput.readLong();
		userID = objectInput.readLong();
		archive = objectInput.readUTF();
		archivePID = objectInput.readUTF();
		brokerSubmissionID = objectInput.readUTF();
		jiraID = objectInput.readUTF();
		jiraKey = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(submissionID);
		objectOutput.writeBoolean(isPublic);
		objectOutput.writeLong(lastChanged);
		objectOutput.writeLong(publicAfter);
		objectOutput.writeInt(researchObjectVersion);
		objectOutput.writeLong(archivePIDType);
		objectOutput.writeLong(researchObjectID);
		objectOutput.writeLong(userID);

		if (archive == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(archive);
		}

		if (archivePID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(archivePID);
		}

		if (brokerSubmissionID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(brokerSubmissionID);
		}

		if (jiraID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jiraID);
		}

		if (jiraKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jiraKey);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long submissionID;
	public boolean isPublic;
	public long lastChanged;
	public long publicAfter;
	public int researchObjectVersion;
	public long archivePIDType;
	public long researchObjectID;
	public long userID;
	public String archive;
	public String archivePID;
	public String brokerSubmissionID;
	public String jiraID;
	public String jiraKey;
	public String status;
}