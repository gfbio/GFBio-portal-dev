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

package org.gfbio.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Basket_User}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Basket_User
 * @generated
 */
public class Basket_UserWrapper implements Basket_User,
	ModelWrapper<Basket_User> {
	public Basket_UserWrapper(Basket_User basket_User) {
		_basket_User = basket_User;
	}

	@Override
	public Class<?> getModelClass() {
		return Basket_User.class;
	}

	@Override
	public String getModelClassName() {
		return Basket_User.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("basketID", getBasketID());
		attributes.put("userID", getUserID());
		attributes.put("name", getName());
		attributes.put("basketJSON", getBasketJSON());
		attributes.put("queryJSON", getQueryJSON());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long basketID = (Long)attributes.get("basketID");

		if (basketID != null) {
			setBasketID(basketID);
		}

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String basketJSON = (String)attributes.get("basketJSON");

		if (basketJSON != null) {
			setBasketJSON(basketJSON);
		}

		String queryJSON = (String)attributes.get("queryJSON");

		if (queryJSON != null) {
			setQueryJSON(queryJSON);
		}
	}

	/**
	* Returns the primary key of this basket_ user.
	*
	* @return the primary key of this basket_ user
	*/
	@Override
	public long getPrimaryKey() {
		return _basket_User.getPrimaryKey();
	}

	/**
	* Sets the primary key of this basket_ user.
	*
	* @param primaryKey the primary key of this basket_ user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_basket_User.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the basket i d of this basket_ user.
	*
	* @return the basket i d of this basket_ user
	*/
	@Override
	public long getBasketID() {
		return _basket_User.getBasketID();
	}

	/**
	* Sets the basket i d of this basket_ user.
	*
	* @param basketID the basket i d of this basket_ user
	*/
	@Override
	public void setBasketID(long basketID) {
		_basket_User.setBasketID(basketID);
	}

	/**
	* Returns the user i d of this basket_ user.
	*
	* @return the user i d of this basket_ user
	*/
	@Override
	public long getUserID() {
		return _basket_User.getUserID();
	}

	/**
	* Sets the user i d of this basket_ user.
	*
	* @param userID the user i d of this basket_ user
	*/
	@Override
	public void setUserID(long userID) {
		_basket_User.setUserID(userID);
	}

	/**
	* Returns the name of this basket_ user.
	*
	* @return the name of this basket_ user
	*/
	@Override
	public java.lang.String getName() {
		return _basket_User.getName();
	}

	/**
	* Sets the name of this basket_ user.
	*
	* @param name the name of this basket_ user
	*/
	@Override
	public void setName(java.lang.String name) {
		_basket_User.setName(name);
	}

	/**
	* Returns the basket j s o n of this basket_ user.
	*
	* @return the basket j s o n of this basket_ user
	*/
	@Override
	public java.lang.String getBasketJSON() {
		return _basket_User.getBasketJSON();
	}

	/**
	* Sets the basket j s o n of this basket_ user.
	*
	* @param basketJSON the basket j s o n of this basket_ user
	*/
	@Override
	public void setBasketJSON(java.lang.String basketJSON) {
		_basket_User.setBasketJSON(basketJSON);
	}

	/**
	* Returns the query j s o n of this basket_ user.
	*
	* @return the query j s o n of this basket_ user
	*/
	@Override
	public java.lang.String getQueryJSON() {
		return _basket_User.getQueryJSON();
	}

	/**
	* Sets the query j s o n of this basket_ user.
	*
	* @param queryJSON the query j s o n of this basket_ user
	*/
	@Override
	public void setQueryJSON(java.lang.String queryJSON) {
		_basket_User.setQueryJSON(queryJSON);
	}

	@Override
	public boolean isNew() {
		return _basket_User.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_basket_User.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _basket_User.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_basket_User.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _basket_User.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _basket_User.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_basket_User.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _basket_User.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_basket_User.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_basket_User.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_basket_User.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Basket_UserWrapper((Basket_User)_basket_User.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Basket_User basket_User) {
		return _basket_User.compareTo(basket_User);
	}

	@Override
	public int hashCode() {
		return _basket_User.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Basket_User> toCacheModel() {
		return _basket_User.toCacheModel();
	}

	@Override
	public org.gfbio.model.Basket_User toEscapedModel() {
		return new Basket_UserWrapper(_basket_User.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Basket_User toUnescapedModel() {
		return new Basket_UserWrapper(_basket_User.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _basket_User.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _basket_User.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_basket_User.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Basket_UserWrapper)) {
			return false;
		}

		Basket_UserWrapper basket_UserWrapper = (Basket_UserWrapper)obj;

		if (Validator.equals(_basket_User, basket_UserWrapper._basket_User)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Basket_User getWrappedBasket_User() {
		return _basket_User;
	}

	@Override
	public Basket_User getWrappedModel() {
		return _basket_User;
	}

	@Override
	public void resetOriginalValues() {
		_basket_User.resetOriginalValues();
	}

	private Basket_User _basket_User;
}