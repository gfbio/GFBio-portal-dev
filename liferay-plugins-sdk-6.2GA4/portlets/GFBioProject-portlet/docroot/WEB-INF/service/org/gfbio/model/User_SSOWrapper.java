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
 * This class is a wrapper for {@link User_SSO}.
 * </p>
 *
 * @author Marcel Froemming
 * @see User_SSO
 * @generated
 */
public class User_SSOWrapper implements User_SSO, ModelWrapper<User_SSO> {
	public User_SSOWrapper(User_SSO user_SSO) {
		_user_SSO = user_SSO;
	}

	@Override
	public Class<?> getModelClass() {
		return User_SSO.class;
	}

	@Override
	public String getModelClassName() {
		return User_SSO.class.getName();
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
	* Returns the primary key of this user_ s s o.
	*
	* @return the primary key of this user_ s s o
	*/
	@Override
	public long getPrimaryKey() {
		return _user_SSO.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user_ s s o.
	*
	* @param primaryKey the primary key of this user_ s s o
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_user_SSO.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user i d of this user_ s s o.
	*
	* @return the user i d of this user_ s s o
	*/
	@Override
	public long getUserID() {
		return _user_SSO.getUserID();
	}

	/**
	* Sets the user i d of this user_ s s o.
	*
	* @param userID the user i d of this user_ s s o
	*/
	@Override
	public void setUserID(long userID) {
		_user_SSO.setUserID(userID);
	}

	/**
	* Returns the token of this user_ s s o.
	*
	* @return the token of this user_ s s o
	*/
	@Override
	public java.lang.String getToken() {
		return _user_SSO.getToken();
	}

	/**
	* Sets the token of this user_ s s o.
	*
	* @param token the token of this user_ s s o
	*/
	@Override
	public void setToken(java.lang.String token) {
		_user_SSO.setToken(token);
	}

	/**
	* Returns the last modified date of this user_ s s o.
	*
	* @return the last modified date of this user_ s s o
	*/
	@Override
	public java.util.Date getLastModifiedDate() {
		return _user_SSO.getLastModifiedDate();
	}

	/**
	* Sets the last modified date of this user_ s s o.
	*
	* @param lastModifiedDate the last modified date of this user_ s s o
	*/
	@Override
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		_user_SSO.setLastModifiedDate(lastModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _user_SSO.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_user_SSO.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _user_SSO.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_user_SSO.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _user_SSO.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _user_SSO.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_user_SSO.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _user_SSO.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_user_SSO.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_user_SSO.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_user_SSO.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new User_SSOWrapper((User_SSO)_user_SSO.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.User_SSO user_SSO) {
		return _user_SSO.compareTo(user_SSO);
	}

	@Override
	public int hashCode() {
		return _user_SSO.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.User_SSO> toCacheModel() {
		return _user_SSO.toCacheModel();
	}

	@Override
	public org.gfbio.model.User_SSO toEscapedModel() {
		return new User_SSOWrapper(_user_SSO.toEscapedModel());
	}

	@Override
	public org.gfbio.model.User_SSO toUnescapedModel() {
		return new User_SSOWrapper(_user_SSO.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _user_SSO.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _user_SSO.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_user_SSO.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof User_SSOWrapper)) {
			return false;
		}

		User_SSOWrapper user_SSOWrapper = (User_SSOWrapper)obj;

		if (Validator.equals(_user_SSO, user_SSOWrapper._user_SSO)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public User_SSO getWrappedUser_SSO() {
		return _user_SSO;
	}

	@Override
	public User_SSO getWrappedModel() {
		return _user_SSO;
	}

	@Override
	public void resetOriginalValues() {
		_user_SSO.resetOriginalValues();
	}

	private User_SSO _user_SSO;
}