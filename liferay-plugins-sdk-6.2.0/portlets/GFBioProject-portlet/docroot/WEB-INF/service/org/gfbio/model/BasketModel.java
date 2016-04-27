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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Basket service. Represents a row in the &quot;gfbio_Basket&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.BasketModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.BasketImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Basket
 * @see org.gfbio.model.impl.BasketImpl
 * @see org.gfbio.model.impl.BasketModelImpl
 * @generated
 */
public interface BasketModel extends BaseModel<Basket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a basket model instance should use the {@link Basket} interface instead.
	 */

	/**
	 * Returns the primary key of this basket.
	 *
	 * @return the primary key of this basket
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this basket.
	 *
	 * @param primaryKey the primary key of this basket
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the basket i d of this basket.
	 *
	 * @return the basket i d of this basket
	 */
	public long getBasketID();

	/**
	 * Sets the basket i d of this basket.
	 *
	 * @param basketID the basket i d of this basket
	 */
	public void setBasketID(long basketID);

	/**
	 * Returns the user i d of this basket.
	 *
	 * @return the user i d of this basket
	 */
	public long getUserID();

	/**
	 * Sets the user i d of this basket.
	 *
	 * @param userID the user i d of this basket
	 */
	public void setUserID(long userID);

	/**
	 * Returns the name of this basket.
	 *
	 * @return the name of this basket
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this basket.
	 *
	 * @param name the name of this basket
	 */
	public void setName(String name);

	/**
	 * Returns the last modified date of this basket.
	 *
	 * @return the last modified date of this basket
	 */
	public Date getLastModifiedDate();

	/**
	 * Sets the last modified date of this basket.
	 *
	 * @param lastModifiedDate the last modified date of this basket
	 */
	public void setLastModifiedDate(Date lastModifiedDate);

	/**
	 * Returns the basket content of this basket.
	 *
	 * @return the basket content of this basket
	 */
	@AutoEscape
	public String getBasketContent();

	/**
	 * Sets the basket content of this basket.
	 *
	 * @param basketContent the basket content of this basket
	 */
	public void setBasketContent(String basketContent);

	/**
	 * Returns the query j s o n of this basket.
	 *
	 * @return the query j s o n of this basket
	 */
	@AutoEscape
	public String getQueryJSON();

	/**
	 * Sets the query j s o n of this basket.
	 *
	 * @param queryJSON the query j s o n of this basket
	 */
	public void setQueryJSON(String queryJSON);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Basket basket);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Basket> toCacheModel();

	@Override
	public Basket toEscapedModel();

	@Override
	public Basket toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}