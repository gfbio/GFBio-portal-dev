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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserSSO}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserSSO
 * @generated
 */
public class UserSSOWrapper implements UserSSO, ModelWrapper<UserSSO> {
	public UserSSOWrapper(UserSSO userSSO) {
		_userSSO = userSSO;
	}

	@Override
	public Class<?> getModelClass() {
		return UserSSO.class;
	}

	@Override
	public String getModelClassName() {
		return UserSSO.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userID", getUserID());
		attributes.put("token", getToken());
		attributes.put("lastModifiedDate", getLastModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
		}
	}

	/**
	* Returns the primary key of this user s s o.
	*
	* @return the primary key of this user s s o
	*/
	@Override
	public long getPrimaryKey() {
		return _userSSO.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user s s o.
	*
	* @param primaryKey the primary key of this user s s o
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userSSO.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user i d of this user s s o.
	*
	* @return the user i d of this user s s o
	*/
	@Override
	public long getUserID() {
		return _userSSO.getUserID();
	}

	/**
	* Sets the user i d of this user s s o.
	*
	* @param userID the user i d of this user s s o
	*/
	@Override
	public void setUserID(long userID) {
		_userSSO.setUserID(userID);
	}

	/**
	* Returns the token of this user s s o.
	*
	* @return the token of this user s s o
	*/
	@Override
	public java.lang.String getToken() {
		return _userSSO.getToken();
	}

	/**
	* Sets the token of this user s s o.
	*
	* @param token the token of this user s s o
	*/
	@Override
	public void setToken(java.lang.String token) {
		_userSSO.setToken(token);
	}

	/**
	* Returns the last modified date of this user s s o.
	*
	* @return the last modified date of this user s s o
	*/
	@Override
	public java.util.Date getLastModifiedDate() {
		return _userSSO.getLastModifiedDate();
	}

	/**
	* Sets the last modified date of this user s s o.
	*
	* @param lastModifiedDate the last modified date of this user s s o
	*/
	@Override
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		_userSSO.setLastModifiedDate(lastModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _userSSO.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userSSO.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userSSO.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userSSO.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userSSO.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userSSO.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userSSO.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userSSO.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userSSO.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userSSO.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userSSO.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserSSOWrapper((UserSSO)_userSSO.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.UserSSO userSSO) {
		return _userSSO.compareTo(userSSO);
	}

	@Override
	public int hashCode() {
		return _userSSO.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.UserSSO> toCacheModel() {
		return _userSSO.toCacheModel();
	}

	@Override
	public org.gfbio.model.UserSSO toEscapedModel() {
		return new UserSSOWrapper(_userSSO.toEscapedModel());
	}

	@Override
	public org.gfbio.model.UserSSO toUnescapedModel() {
		return new UserSSOWrapper(_userSSO.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSSO.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userSSO.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSSO.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserSSOWrapper)) {
			return false;
		}

		UserSSOWrapper userSSOWrapper = (UserSSOWrapper)obj;

		if (Validator.equals(_userSSO, userSSOWrapper._userSSO)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserSSO getWrappedUserSSO() {
		return _userSSO;
	}

	@Override
	public UserSSO getWrappedModel() {
		return _userSSO;
	}

	@Override
	public void resetOriginalValues() {
		_userSSO.resetOriginalValues();
	}

	private UserSSO _userSSO;
}