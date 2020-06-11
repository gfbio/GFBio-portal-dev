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

import org.gfbio.model.UserGoesternID;
import org.gfbio.model.UserGoesternIDModel;
import org.gfbio.model.UserGoesternIDSoap;

import org.gfbio.service.persistence.UserGoesternIDPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserGoesternID service. Represents a row in the &quot;gfbio_UserGoesternID&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.UserGoesternIDModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserGoesternIDImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserGoesternIDImpl
 * @see org.gfbio.model.UserGoesternID
 * @see org.gfbio.model.UserGoesternIDModel
 * @generated
 */
@JSON(strict = true)
public class UserGoesternIDModelImpl extends BaseModelImpl<UserGoesternID>
	implements UserGoesternIDModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user goestern i d model instance should use the {@link org.gfbio.model.UserGoesternID} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_UserGoesternID";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userID", Types.BIGINT },
			{ "goeSternID", Types.VARCHAR },
			{ "lastmodifieddate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_UserGoesternID (userID LONG not null,goeSternID VARCHAR(75) not null,lastmodifieddate DATE null,primary key (userID, goeSternID))";
	public static final String TABLE_SQL_DROP = "drop table gfbio_UserGoesternID";
	public static final String ORDER_BY_JPQL = " ORDER BY userGoesternID.id.userID ASC, userGoesternID.id.goeSternID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_UserGoesternID.userID ASC, gfbio_UserGoesternID.goeSternID ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.UserGoesternID"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.UserGoesternID"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.UserGoesternID"),
			true);
	public static long GOESTERNID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserGoesternID toModel(UserGoesternIDSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserGoesternID model = new UserGoesternIDImpl();

		model.setUserID(soapModel.getUserID());
		model.setGoeSternID(soapModel.getGoeSternID());
		model.setLastModifiedDate(soapModel.getLastModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserGoesternID> toModels(UserGoesternIDSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserGoesternID> models = new ArrayList<UserGoesternID>(soapModels.length);

		for (UserGoesternIDSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.UserGoesternID"));

	public UserGoesternIDModelImpl() {
	}

	@Override
	public UserGoesternIDPK getPrimaryKey() {
		return new UserGoesternIDPK(_userID, _goeSternID);
	}

	@Override
	public void setPrimaryKey(UserGoesternIDPK primaryKey) {
		setUserID(primaryKey.userID);
		setGoeSternID(primaryKey.goeSternID);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserGoesternIDPK(_userID, _goeSternID);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserGoesternIDPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserGoesternID.class;
	}

	@Override
	public String getModelClassName() {
		return UserGoesternID.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userID", getUserID());
		attributes.put("goeSternID", getGoeSternID());
		attributes.put("lastModifiedDate", getLastModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String goeSternID = (String)attributes.get("goeSternID");

		if (goeSternID != null) {
			setGoeSternID(goeSternID);
		}

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
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
	public String getGoeSternID() {
		if (_goeSternID == null) {
			return StringPool.BLANK;
		}
		else {
			return _goeSternID;
		}
	}

	@Override
	public void setGoeSternID(String goeSternID) {
		_columnBitmask |= GOESTERNID_COLUMN_BITMASK;

		if (_originalGoeSternID == null) {
			_originalGoeSternID = _goeSternID;
		}

		_goeSternID = goeSternID;
	}

	public String getOriginalGoeSternID() {
		return GetterUtil.getString(_originalGoeSternID);
	}

	@JSON
	@Override
	public Date getLastModifiedDate() {
		return _lastModifiedDate;
	}

	@Override
	public void setLastModifiedDate(Date lastModifiedDate) {
		_lastModifiedDate = lastModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserGoesternID toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserGoesternID)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserGoesternIDImpl userGoesternIDImpl = new UserGoesternIDImpl();

		userGoesternIDImpl.setUserID(getUserID());
		userGoesternIDImpl.setGoeSternID(getGoeSternID());
		userGoesternIDImpl.setLastModifiedDate(getLastModifiedDate());

		userGoesternIDImpl.resetOriginalValues();

		return userGoesternIDImpl;
	}

	@Override
	public int compareTo(UserGoesternID userGoesternID) {
		UserGoesternIDPK primaryKey = userGoesternID.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGoesternID)) {
			return false;
		}

		UserGoesternID userGoesternID = (UserGoesternID)obj;

		UserGoesternIDPK primaryKey = userGoesternID.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		UserGoesternIDModelImpl userGoesternIDModelImpl = this;

		userGoesternIDModelImpl._originalUserID = userGoesternIDModelImpl._userID;

		userGoesternIDModelImpl._setOriginalUserID = false;

		userGoesternIDModelImpl._originalGoeSternID = userGoesternIDModelImpl._goeSternID;

		userGoesternIDModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserGoesternID> toCacheModel() {
		UserGoesternIDCacheModel userGoesternIDCacheModel = new UserGoesternIDCacheModel();

		userGoesternIDCacheModel.userID = getUserID();

		userGoesternIDCacheModel.goeSternID = getGoeSternID();

		String goeSternID = userGoesternIDCacheModel.goeSternID;

		if ((goeSternID != null) && (goeSternID.length() == 0)) {
			userGoesternIDCacheModel.goeSternID = null;
		}

		Date lastModifiedDate = getLastModifiedDate();

		if (lastModifiedDate != null) {
			userGoesternIDCacheModel.lastModifiedDate = lastModifiedDate.getTime();
		}
		else {
			userGoesternIDCacheModel.lastModifiedDate = Long.MIN_VALUE;
		}

		return userGoesternIDCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userID=");
		sb.append(getUserID());
		sb.append(", goeSternID=");
		sb.append(getGoeSternID());
		sb.append(", lastModifiedDate=");
		sb.append(getLastModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.UserGoesternID");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goeSternID</column-name><column-value><![CDATA[");
		sb.append(getGoeSternID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getLastModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserGoesternID.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserGoesternID.class
		};
	private long _userID;
	private long _originalUserID;
	private boolean _setOriginalUserID;
	private String _goeSternID;
	private String _originalGoeSternID;
	private Date _lastModifiedDate;
	private long _columnBitmask;
	private UserGoesternID _escapedModel;
}