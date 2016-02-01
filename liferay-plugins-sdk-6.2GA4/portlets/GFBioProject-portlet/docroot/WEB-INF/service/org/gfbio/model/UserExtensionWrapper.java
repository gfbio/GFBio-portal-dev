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

package org.gfbio.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserExtension}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserExtension
 * @generated
 */
public class UserExtensionWrapper implements UserExtension,
	ModelWrapper<UserExtension> {
	public UserExtensionWrapper(UserExtension userExtension) {
		_userExtension = userExtension;
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

	/**
	* Returns the primary key of this user extension.
	*
	* @return the primary key of this user extension
	*/
	@Override
	public long getPrimaryKey() {
		return _userExtension.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user extension.
	*
	* @param primaryKey the primary key of this user extension
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userExtension.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user i d of this user extension.
	*
	* @return the user i d of this user extension
	*/
	@Override
	public long getUserID() {
		return _userExtension.getUserID();
	}

	/**
	* Sets the user i d of this user extension.
	*
	* @param userID the user i d of this user extension
	*/
	@Override
	public void setUserID(long userID) {
		_userExtension.setUserID(userID);
	}

	@Override
	public boolean isNew() {
		return _userExtension.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userExtension.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userExtension.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userExtension.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userExtension.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userExtension.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userExtension.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userExtension.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userExtension.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userExtension.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userExtension.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserExtensionWrapper((UserExtension)_userExtension.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.UserExtension userExtension) {
		return _userExtension.compareTo(userExtension);
	}

	@Override
	public int hashCode() {
		return _userExtension.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.UserExtension> toCacheModel() {
		return _userExtension.toCacheModel();
	}

	@Override
	public org.gfbio.model.UserExtension toEscapedModel() {
		return new UserExtensionWrapper(_userExtension.toEscapedModel());
	}

	@Override
	public org.gfbio.model.UserExtension toUnescapedModel() {
		return new UserExtensionWrapper(_userExtension.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userExtension.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userExtension.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userExtension.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserExtensionWrapper)) {
			return false;
		}

		UserExtensionWrapper userExtensionWrapper = (UserExtensionWrapper)obj;

		if (Validator.equals(_userExtension, userExtensionWrapper._userExtension)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserExtension getWrappedUserExtension() {
		return _userExtension;
	}

	@Override
	public UserExtension getWrappedModel() {
		return _userExtension;
	}

	@Override
	public void resetOriginalValues() {
		_userExtension.resetOriginalValues();
	}

	private UserExtension _userExtension;
}