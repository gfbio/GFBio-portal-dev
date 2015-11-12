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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gfbio.model.UserExtension;
import org.gfbio.model.UserExtensionModel;
import org.gfbio.model.UserExtensionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserExtension service. Represents a row in the &quot;gfbio_UserExtension&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gfbio.model.UserExtensionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserExtensionImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserExtensionImpl
 * @see org.gfbio.model.UserExtension
 * @see org.gfbio.model.UserExtensionModel
 * @generated
 */
@JSON(strict = true)
public class UserExtensionModelImpl extends BaseModelImpl<UserExtension>
	implements UserExtensionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user extension model instance should use the {@link org.gfbio.model.UserExtension} interface instead.
	 */
	public static final String TABLE_NAME = "gfbio_UserExtension";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userID", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table gfbio_UserExtension (userID LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table gfbio_UserExtension";
	public static final String ORDER_BY_JPQL = " ORDER BY userExtension.userID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gfbio_UserExtension.userID ASC";
	public static final String DATA_SOURCE = "gfbioDataSource";
	public static final String SESSION_FACTORY = "gfbioSessionFactory";
	public static final String TX_MANAGER = "gfbioTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gfbio.model.UserExtension"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gfbio.model.UserExtension"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.gfbio.model.UserExtension"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserExtension toModel(UserExtensionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserExtension model = new UserExtensionImpl();

		model.setUserID(soapModel.getUserID());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserExtension> toModels(UserExtensionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserExtension> models = new ArrayList<UserExtension>(soapModels.length);

		for (UserExtensionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gfbio.model.UserExtension"));

	public UserExtensionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserExtension.class;
	}

	@Override
	public String getModelClassName() {
		return UserExtension.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userID", getUserID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}
	}

	@JSON
	@Override
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_columnBitmask = -1L;

		if (!_setOriginalUserID) {
			_setOriginalUserID = true;

			_originalUserID = _userID;
		}

		_userID = userID;
	}

	public long getOriginalUserID() {
		return _originalUserID;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserExtension.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserExtension toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserExtension)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserExtensionImpl userExtensionImpl = new UserExtensionImpl();

		userExtensionImpl.setUserID(getUserID());

		userExtensionImpl.resetOriginalValues();

		return userExtensionImpl;
	}

	@Override
	public int compareTo(UserExtension userExtension) {
		int value = 0;

		if (getUserID() < userExtension.getUserID()) {
			value = -1;
		}
		else if (getUserID() > userExtension.getUserID()) {
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

		if (!(obj instanceof UserExtension)) {
			return false;
		}

		UserExtension userExtension = (UserExtension)obj;

		long primaryKey = userExtension.getPrimaryKey();

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
		UserExtensionModelImpl userExtensionModelImpl = this;

		userExtensionModelImpl._originalUserID = userExtensionModelImpl._userID;

		userExtensionModelImpl._setOriginalUserID = false;

		userExtensionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserExtension> toCacheModel() {
		UserExtensionCacheModel userExtensionCacheModel = new UserExtensionCacheModel();

		userExtensionCacheModel.userID = getUserID();

		return userExtensionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{userID=");
		sb.append(getUserID());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("org.gfbio.model.UserExtension");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserExtension.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserExtension.class
		};
	private long _userID;
	private long _originalUserID;
	private boolean _setOriginalUserID;
	private long _columnBitmask;
	private UserExtension _escapedModel;
}