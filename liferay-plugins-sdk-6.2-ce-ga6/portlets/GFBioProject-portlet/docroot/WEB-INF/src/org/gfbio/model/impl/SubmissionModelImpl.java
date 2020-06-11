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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gfbio.model.Submission;
import org.gfbio.model.SubmissionModel;
import org.gfbio.model.SubmissionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Submission service. Represents a row in the &quot;gfbio_Submission&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.SubmissionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SubmissionImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionImpl
 * @see org.gfbio.model.Submission
 * @see org.gfbio.model.SubmissionModel
 * @generated
 */
@JSON(strict = true)
public class SubmissionModelImpl extends BaseModelImpl<Submission>
	implements SubmissionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a submission model instance should use the {@link org.gfbio.model.Submission} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_Submission";
	public static final Object[][] TABLE_COLUMNS = {
			{ "submissionid", Types.BIGINT },
			{ "is_public", Types.BOOLEAN },
			{ "last_changed", Types.TIMESTAMP },
			{ "public_after", Types.TIMESTAMP },
			{ "researchobjectversion", Types.INTEGER },
			{ "archive_pid_type", Types.BIGINT },
			{ "researchobjectid", Types.BIGINT },
			{ "userid", Types.BIGINT },
			{ "archive", Types.VARCHAR },
			{ "archive_pid", Types.VARCHAR },
			{ "brokersubmissionid", Types.VARCHAR },
			{ "jiraid", Types.VARCHAR },
			{ "jirakey", Types.VARCHAR },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_Submission (submissionid LONG not null primary key,is_public BOOLEAN,last_changed DATE null,public_after DATE null,researchobjectversion INTEGER,archive_pid_type LONG,researchobjectid LONG,userid LONG,archive VARCHAR(75) null,archive_pid VARCHAR(75) null,brokersubmissionid VARCHAR(75) null,jiraid VARCHAR(75) null,jirakey VARCHAR(75) null,status VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_Submission";
	public static final String ORDER_BY_JPQL = " ORDER BY submission.researchObjectID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_Submission.researchobjectid ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.Submission"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.Submission"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.Submission"),
			true);
	public static long ARCHIVE_COLUMN_BITMASK = 1L;
	public static long ARCHIVEPID_COLUMN_BITMASK = 2L;
	public static long ARCHIVEPIDTYPE_COLUMN_BITMASK = 4L;
	public static long BROKERSUBMISSIONID_COLUMN_BITMASK = 8L;
	public static long ISPUBLIC_COLUMN_BITMASK = 16L;
	public static long LASTCHANGED_COLUMN_BITMASK = 32L;
	public static long RESEARCHOBJECTID_COLUMN_BITMASK = 64L;
	public static long RESEARCHOBJECTVERSION_COLUMN_BITMASK = 128L;
	public static long STATUS_COLUMN_BITMASK = 256L;
	public static long USERID_COLUMN_BITMASK = 512L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Submission toModel(SubmissionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Submission model = new SubmissionImpl();

		model.setSubmissionID(soapModel.getSubmissionID());
		model.setIsPublic(soapModel.getIsPublic());
		model.setLastChanged(soapModel.getLastChanged());
		model.setPublicAfter(soapModel.getPublicAfter());
		model.setResearchObjectVersion(soapModel.getResearchObjectVersion());
		model.setArchivePIDType(soapModel.getArchivePIDType());
		model.setResearchObjectID(soapModel.getResearchObjectID());
		model.setUserID(soapModel.getUserID());
		model.setArchive(soapModel.getArchive());
		model.setArchivePID(soapModel.getArchivePID());
		model.setBrokerSubmissionID(soapModel.getBrokerSubmissionID());
		model.setJiraID(soapModel.getJiraID());
		model.setJiraKey(soapModel.getJiraKey());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Submission> toModels(SubmissionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Submission> models = new ArrayList<Submission>(soapModels.length);

		for (SubmissionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.Submission"));

	public SubmissionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _submissionID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubmissionID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _submissionID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Submission.class;
	}

	@Override
	public String getModelClassName() {
		return Submission.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("submissionID", getSubmissionID());
		attributes.put("isPublic", getIsPublic());
		attributes.put("lastChanged", getLastChanged());
		attributes.put("publicAfter", getPublicAfter());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("archivePIDType", getArchivePIDType());
		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("userID", getUserID());
		attributes.put("archive", getArchive());
		attributes.put("archivePID", getArchivePID());
		attributes.put("brokerSubmissionID", getBrokerSubmissionID());
		attributes.put("jiraID", getJiraID());
		attributes.put("jiraKey", getJiraKey());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long submissionID = (Long)attributes.get("submissionID");

		if (submissionID != null) {
			setSubmissionID(submissionID);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Date lastChanged = (Date)attributes.get("lastChanged");

		if (lastChanged != null) {
			setLastChanged(lastChanged);
		}

		Date publicAfter = (Date)attributes.get("publicAfter");

		if (publicAfter != null) {
			setPublicAfter(publicAfter);
		}

		Integer researchObjectVersion = (Integer)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}

		Long archivePIDType = (Long)attributes.get("archivePIDType");

		if (archivePIDType != null) {
			setArchivePIDType(archivePIDType);
		}

		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String archive = (String)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		String archivePID = (String)attributes.get("archivePID");

		if (archivePID != null) {
			setArchivePID(archivePID);
		}

		String brokerSubmissionID = (String)attributes.get("brokerSubmissionID");

		if (brokerSubmissionID != null) {
			setBrokerSubmissionID(brokerSubmissionID);
		}

		String jiraID = (String)attributes.get("jiraID");

		if (jiraID != null) {
			setJiraID(jiraID);
		}

		String jiraKey = (String)attributes.get("jiraKey");

		if (jiraKey != null) {
			setJiraKey(jiraKey);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getSubmissionID() {
		return _submissionID;
	}

	@Override
	public void setSubmissionID(long submissionID) {
		_submissionID = submissionID;
	}

	@JSON
	@Override
	public boolean getIsPublic() {
		return _isPublic;
	}

	@Override
	public boolean isIsPublic() {
		return _isPublic;
	}

	@Override
	public void setIsPublic(boolean isPublic) {
		_columnBitmask |= ISPUBLIC_COLUMN_BITMASK;

		if (!_setOriginalIsPublic) {
			_setOriginalIsPublic = true;

			_originalIsPublic = _isPublic;
		}

		_isPublic = isPublic;
	}

	public boolean getOriginalIsPublic() {
		return _originalIsPublic;
	}

	@JSON
	@Override
	public Date getLastChanged() {
		return _lastChanged;
	}

	@Override
	public void setLastChanged(Date lastChanged) {
		_columnBitmask |= LASTCHANGED_COLUMN_BITMASK;

		if (_originalLastChanged == null) {
			_originalLastChanged = _lastChanged;
		}

		_lastChanged = lastChanged;
	}

	public Date getOriginalLastChanged() {
		return _originalLastChanged;
	}

	@JSON
	@Override
	public Date getPublicAfter() {
		return _publicAfter;
	}

	@Override
	public void setPublicAfter(Date publicAfter) {
		_publicAfter = publicAfter;
	}

	@JSON
	@Override
	public int getResearchObjectVersion() {
		return _researchObjectVersion;
	}

	@Override
	public void setResearchObjectVersion(int researchObjectVersion) {
		_columnBitmask |= RESEARCHOBJECTVERSION_COLUMN_BITMASK;

		if (!_setOriginalResearchObjectVersion) {
			_setOriginalResearchObjectVersion = true;

			_originalResearchObjectVersion = _researchObjectVersion;
		}

		_researchObjectVersion = researchObjectVersion;
	}

	public int getOriginalResearchObjectVersion() {
		return _originalResearchObjectVersion;
	}

	@JSON
	@Override
	public long getArchivePIDType() {
		return _archivePIDType;
	}

	@Override
	public void setArchivePIDType(long archivePIDType) {
		_columnBitmask |= ARCHIVEPIDTYPE_COLUMN_BITMASK;

		if (!_setOriginalArchivePIDType) {
			_setOriginalArchivePIDType = true;

			_originalArchivePIDType = _archivePIDType;
		}

		_archivePIDType = archivePIDType;
	}

	public long getOriginalArchivePIDType() {
		return _originalArchivePIDType;
	}

	@JSON
	@Override
	public long getResearchObjectID() {
		return _researchObjectID;
	}

	@Override
	public void setResearchObjectID(long researchObjectID) {
		_columnBitmask = -1L;

		if (!_setOriginalResearchObjectID) {
			_setOriginalResearchObjectID = true;

			_originalResearchObjectID = _researchObjectID;
		}

		_researchObjectID = researchObjectID;
	}

	public long getOriginalResearchObjectID() {
		return _originalResearchObjectID;
	}

	@JSON
	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserID) {
			_setOriginalUserID = true;

			_originalUserID = _userID;
		}

		_userID = userID;
	}

	public long getOriginalUserID() {
		return _originalUserID;
	}

	@JSON
	@Override
	public String getArchive() {
		if (_archive == null) {
			return StringPool.BLANK;
		}
		else {
			return _archive;
		}
	}

	@Override
	public void setArchive(String archive) {
		_columnBitmask |= ARCHIVE_COLUMN_BITMASK;

		if (_originalArchive == null) {
			_originalArchive = _archive;
		}

		_archive = archive;
	}

	public String getOriginalArchive() {
		return GetterUtil.getString(_originalArchive);
	}

	@JSON
	@Override
	public String getArchivePID() {
		if (_archivePID == null) {
			return StringPool.BLANK;
		}
		else {
			return _archivePID;
		}
	}

	@Override
	public void setArchivePID(String archivePID) {
		_columnBitmask |= ARCHIVEPID_COLUMN_BITMASK;

		if (_originalArchivePID == null) {
			_originalArchivePID = _archivePID;
		}

		_archivePID = archivePID;
	}

	public String getOriginalArchivePID() {
		return GetterUtil.getString(_originalArchivePID);
	}

	@JSON
	@Override
	public String getBrokerSubmissionID() {
		if (_brokerSubmissionID == null) {
			return StringPool.BLANK;
		}
		else {
			return _brokerSubmissionID;
		}
	}

	@Override
	public void setBrokerSubmissionID(String brokerSubmissionID) {
		_columnBitmask |= BROKERSUBMISSIONID_COLUMN_BITMASK;

		if (_originalBrokerSubmissionID == null) {
			_originalBrokerSubmissionID = _brokerSubmissionID;
		}

		_brokerSubmissionID = brokerSubmissionID;
	}

	public String getOriginalBrokerSubmissionID() {
		return GetterUtil.getString(_originalBrokerSubmissionID);
	}

	@JSON
	@Override
	public String getJiraID() {
		if (_jiraID == null) {
			return StringPool.BLANK;
		}
		else {
			return _jiraID;
		}
	}

	@Override
	public void setJiraID(String jiraID) {
		_jiraID = jiraID;
	}

	@JSON
	@Override
	public String getJiraKey() {
		if (_jiraKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _jiraKey;
		}
	}

	@Override
	public void setJiraKey(String jiraKey) {
		_jiraKey = jiraKey;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Submission.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Submission toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Submission)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setSubmissionID(getSubmissionID());
		submissionImpl.setIsPublic(getIsPublic());
		submissionImpl.setLastChanged(getLastChanged());
		submissionImpl.setPublicAfter(getPublicAfter());
		submissionImpl.setResearchObjectVersion(getResearchObjectVersion());
		submissionImpl.setArchivePIDType(getArchivePIDType());
		submissionImpl.setResearchObjectID(getResearchObjectID());
		submissionImpl.setUserID(getUserID());
		submissionImpl.setArchive(getArchive());
		submissionImpl.setArchivePID(getArchivePID());
		submissionImpl.setBrokerSubmissionID(getBrokerSubmissionID());
		submissionImpl.setJiraID(getJiraID());
		submissionImpl.setJiraKey(getJiraKey());
		submissionImpl.setStatus(getStatus());

		submissionImpl.resetOriginalValues();

		return submissionImpl;
	}

	@Override
	public int compareTo(Submission submission) {
		int value = 0;

		if (getResearchObjectID() < submission.getResearchObjectID()) {
			value = -1;
		}
		else if (getResearchObjectID() > submission.getResearchObjectID()) {
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

		if (!(obj instanceof Submission)) {
			return false;
		}

		Submission submission = (Submission)obj;

		long primaryKey = submission.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SubmissionModelImpl submissionModelImpl = this;

		submissionModelImpl._originalIsPublic = submissionModelImpl._isPublic;

		submissionModelImpl._setOriginalIsPublic = false;

		submissionModelImpl._originalLastChanged = submissionModelImpl._lastChanged;

		submissionModelImpl._originalResearchObjectVersion = submissionModelImpl._researchObjectVersion;

		submissionModelImpl._setOriginalResearchObjectVersion = false;

		submissionModelImpl._originalArchivePIDType = submissionModelImpl._archivePIDType;

		submissionModelImpl._setOriginalArchivePIDType = false;

		submissionModelImpl._originalResearchObjectID = submissionModelImpl._researchObjectID;

		submissionModelImpl._setOriginalResearchObjectID = false;

		submissionModelImpl._originalUserID = submissionModelImpl._userID;

		submissionModelImpl._setOriginalUserID = false;

		submissionModelImpl._originalArchive = submissionModelImpl._archive;

		submissionModelImpl._originalArchivePID = submissionModelImpl._archivePID;

		submissionModelImpl._originalBrokerSubmissionID = submissionModelImpl._brokerSubmissionID;

		submissionModelImpl._originalStatus = submissionModelImpl._status;

		submissionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Submission> toCacheModel() {
		SubmissionCacheModel submissionCacheModel = new SubmissionCacheModel();

		submissionCacheModel.submissionID = getSubmissionID();

		submissionCacheModel.isPublic = getIsPublic();

		Date lastChanged = getLastChanged();

		if (lastChanged != null) {
			submissionCacheModel.lastChanged = lastChanged.getTime();
		}
		else {
			submissionCacheModel.lastChanged = Long.MIN_VALUE;
		}

		Date publicAfter = getPublicAfter();

		if (publicAfter != null) {
			submissionCacheModel.publicAfter = publicAfter.getTime();
		}
		else {
			submissionCacheModel.publicAfter = Long.MIN_VALUE;
		}

		submissionCacheModel.researchObjectVersion = getResearchObjectVersion();

		submissionCacheModel.archivePIDType = getArchivePIDType();

		submissionCacheModel.researchObjectID = getResearchObjectID();

		submissionCacheModel.userID = getUserID();

		submissionCacheModel.archive = getArchive();

		String archive = submissionCacheModel.archive;

		if ((archive != null) && (archive.length() == 0)) {
			submissionCacheModel.archive = null;
		}

		submissionCacheModel.archivePID = getArchivePID();

		String archivePID = submissionCacheModel.archivePID;

		if ((archivePID != null) && (archivePID.length() == 0)) {
			submissionCacheModel.archivePID = null;
		}

		submissionCacheModel.brokerSubmissionID = getBrokerSubmissionID();

		String brokerSubmissionID = submissionCacheModel.brokerSubmissionID;

		if ((brokerSubmissionID != null) && (brokerSubmissionID.length() == 0)) {
			submissionCacheModel.brokerSubmissionID = null;
		}

		submissionCacheModel.jiraID = getJiraID();

		String jiraID = submissionCacheModel.jiraID;

		if ((jiraID != null) && (jiraID.length() == 0)) {
			submissionCacheModel.jiraID = null;
		}

		submissionCacheModel.jiraKey = getJiraKey();

		String jiraKey = submissionCacheModel.jiraKey;

		if ((jiraKey != null) && (jiraKey.length() == 0)) {
			submissionCacheModel.jiraKey = null;
		}

		submissionCacheModel.status = getStatus();

		String status = submissionCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			submissionCacheModel.status = null;
		}

		return submissionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{submissionID=");
		sb.append(getSubmissionID());
		sb.append(", isPublic=");
		sb.append(getIsPublic());
		sb.append(", lastChanged=");
		sb.append(getLastChanged());
		sb.append(", publicAfter=");
		sb.append(getPublicAfter());
		sb.append(", researchObjectVersion=");
		sb.append(getResearchObjectVersion());
		sb.append(", archivePIDType=");
		sb.append(getArchivePIDType());
		sb.append(", researchObjectID=");
		sb.append(getResearchObjectID());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", archive=");
		sb.append(getArchive());
		sb.append(", archivePID=");
		sb.append(getArchivePID());
		sb.append(", brokerSubmissionID=");
		sb.append(getBrokerSubmissionID());
		sb.append(", jiraID=");
		sb.append(getJiraID());
		sb.append(", jiraKey=");
		sb.append(getJiraKey());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.Submission");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>submissionID</column-name><column-value><![CDATA[");
		sb.append(getSubmissionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPublic</column-name><column-value><![CDATA[");
		sb.append(getIsPublic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastChanged</column-name><column-value><![CDATA[");
		sb.append(getLastChanged());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicAfter</column-name><column-value><![CDATA[");
		sb.append(getPublicAfter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchObjectVersion</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivePIDType</column-name><column-value><![CDATA[");
		sb.append(getArchivePIDType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>researchObjectID</column-name><column-value><![CDATA[");
		sb.append(getResearchObjectID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archive</column-name><column-value><![CDATA[");
		sb.append(getArchive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>archivePID</column-name><column-value><![CDATA[");
		sb.append(getArchivePID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>brokerSubmissionID</column-name><column-value><![CDATA[");
		sb.append(getBrokerSubmissionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraID</column-name><column-value><![CDATA[");
		sb.append(getJiraID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jiraKey</column-name><column-value><![CDATA[");
		sb.append(getJiraKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Submission.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Submission.class
		};
	private long _submissionID;
	private boolean _isPublic;
	private boolean _originalIsPublic;
	private boolean _setOriginalIsPublic;
	private Date _lastChanged;
	private Date _originalLastChanged;
	private Date _publicAfter;
	private int _researchObjectVersion;
	private int _originalResearchObjectVersion;
	private boolean _setOriginalResearchObjectVersion;
	private long _archivePIDType;
	private long _originalArchivePIDType;
	private boolean _setOriginalArchivePIDType;
	private long _researchObjectID;
	private long _originalResearchObjectID;
	private boolean _setOriginalResearchObjectID;
	private long _userID;
	private long _originalUserID;
	private boolean _setOriginalUserID;
	private String _archive;
	private String _originalArchive;
	private String _archivePID;
	private String _originalArchivePID;
	private String _brokerSubmissionID;
	private String _originalBrokerSubmissionID;
	private String _jiraID;
	private String _jiraKey;
	private String _status;
	private String _originalStatus;
	private long _columnBitmask;
	private Submission _escapedModel;
}