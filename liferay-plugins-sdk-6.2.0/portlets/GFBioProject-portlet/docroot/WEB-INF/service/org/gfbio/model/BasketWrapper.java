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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Basket}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Basket
 * @generated
 */
public class BasketWrapper implements Basket, ModelWrapper<Basket> {
	public BasketWrapper(Basket basket) {
		_basket = basket;
	}

	@Override
	public Class<?> getModelClass() {
		return Basket.class;
	}

	@Override
	public String getModelClassName() {
		return Basket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("basketID", getBasketID());
		attributes.put("userID", getUserID());
		attributes.put("name", getName());
		attributes.put("lastModifiedDate", getLastModifiedDate());
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

		Date lastModifiedDate = (Date)attributes.get("lastModifiedDate");

		if (lastModifiedDate != null) {
			setLastModifiedDate(lastModifiedDate);
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
	* Returns the primary key of this basket.
	*
	* @return the primary key of this basket
	*/
	@Override
	public long getPrimaryKey() {
		return _basket.getPrimaryKey();
	}

	/**
	* Sets the primary key of this basket.
	*
	* @param primaryKey the primary key of this basket
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_basket.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the basket i d of this basket.
	*
	* @return the basket i d of this basket
	*/
	@Override
	public long getBasketID() {
		return _basket.getBasketID();
	}

	/**
	* Sets the basket i d of this basket.
	*
	* @param basketID the basket i d of this basket
	*/
	@Override
	public void setBasketID(long basketID) {
		_basket.setBasketID(basketID);
	}

	/**
	* Returns the user i d of this basket.
	*
	* @return the user i d of this basket
	*/
	@Override
	public long getUserID() {
		return _basket.getUserID();
	}

	/**
	* Sets the user i d of this basket.
	*
	* @param userID the user i d of this basket
	*/
	@Override
	public void setUserID(long userID) {
		_basket.setUserID(userID);
	}

	/**
	* Returns the name of this basket.
	*
	* @return the name of this basket
	*/
	@Override
	public java.lang.String getName() {
		return _basket.getName();
	}

	/**
	* Sets the name of this basket.
	*
	* @param name the name of this basket
	*/
	@Override
	public void setName(java.lang.String name) {
		_basket.setName(name);
	}

	/**
	* Returns the last modified date of this basket.
	*
	* @return the last modified date of this basket
	*/
	@Override
	public java.util.Date getLastModifiedDate() {
		return _basket.getLastModifiedDate();
	}

	/**
	* Sets the last modified date of this basket.
	*
	* @param lastModifiedDate the last modified date of this basket
	*/
	@Override
	public void setLastModifiedDate(java.util.Date lastModifiedDate) {
		_basket.setLastModifiedDate(lastModifiedDate);
	}

	/**
	* Returns the basket j s o n of this basket.
	*
	* @return the basket j s o n of this basket
	*/
	@Override
	public java.lang.String getBasketJSON() {
		return _basket.getBasketJSON();
	}

	/**
	* Sets the basket j s o n of this basket.
	*
	* @param basketJSON the basket j s o n of this basket
	*/
	@Override
	public void setBasketJSON(java.lang.String basketJSON) {
		_basket.setBasketJSON(basketJSON);
	}

	/**
	* Returns the query j s o n of this basket.
	*
	* @return the query j s o n of this basket
	*/
	@Override
	public java.lang.String getQueryJSON() {
		return _basket.getQueryJSON();
	}

	/**
	* Sets the query j s o n of this basket.
	*
	* @param queryJSON the query j s o n of this basket
	*/
	@Override
	public void setQueryJSON(java.lang.String queryJSON) {
		_basket.setQueryJSON(queryJSON);
	}

	@Override
	public boolean isNew() {
		return _basket.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_basket.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _basket.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_basket.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _basket.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _basket.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_basket.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _basket.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_basket.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_basket.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_basket.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BasketWrapper((Basket)_basket.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Basket basket) {
		return _basket.compareTo(basket);
	}

	@Override
	public int hashCode() {
		return _basket.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Basket> toCacheModel() {
		return _basket.toCacheModel();
	}

	@Override
	public org.gfbio.model.Basket toEscapedModel() {
		return new BasketWrapper(_basket.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Basket toUnescapedModel() {
		return new BasketWrapper(_basket.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _basket.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _basket.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_basket.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BasketWrapper)) {
			return false;
		}

		BasketWrapper basketWrapper = (BasketWrapper)obj;

		if (Validator.equals(_basket, basketWrapper._basket)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Basket getWrappedBasket() {
		return _basket;
	}

	@Override
	public Basket getWrappedModel() {
		return _basket;
	}

	@Override
	public void resetOriginalValues() {
		_basket.resetOriginalValues();
	}

	private Basket _basket;
}