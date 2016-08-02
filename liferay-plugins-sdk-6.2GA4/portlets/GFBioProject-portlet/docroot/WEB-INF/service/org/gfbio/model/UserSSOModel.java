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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserSSO service. Represents a row in the &quot;gfbio_UserSSO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.UserSSOModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.UserSSOImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see UserSSO
 * @see org.gfbio.model.impl.UserSSOImpl
 * @see org.gfbio.model.impl.UserSSOModelImpl
 * @generated
 */
public interface UserSSOModel extends BaseModel<UserSSO> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user s s o model instance should use the {@link UserSSO} interface instead.
	 */

	/**
	 * Returns the primary key of this user s s o.
	 *
	 * @return the primary key of this user s s o
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user s s o.
	 *
	 * @param primaryKey the primary key of this user s s o
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user i d of this user s s o.
	 *
	 * @return the user i d of this user s s o
	 */
	public long getUserID();

	/**
	 * Sets the user i d of this user s s o.
	 *
	 * @param userID the user i d of this user s s o
	 */
	public void setUserID(long userID);

	/**
	 * Returns the token of this user s s o.
	 *
	 * @return the token of this user s s o
	 */
	@AutoEscape
	public String getToken();

	/**
	 * Sets the token of this user s s o.
	 *
	 * @param token the token of this user s s o
	 */
	public void setToken(String token);

	/**
	 * Returns the last modified date of this user s s o.
	 *
	 * @return the last modified date of this user s s o
	 */
	public Date getLastModifiedDate();

	/**
	 * Sets the last modified date of this user s s o.
	 *
	 * @param lastModifiedDate the last modified date of this user s s o
	 */
	public void setLastModifiedDate(Date lastModifiedDate);

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
	public int compareTo(org.gfbio.model.UserSSO userSSO);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.gfbio.model.UserSSO> toCacheModel();

	@Override
	public org.gfbio.model.UserSSO toEscapedModel();

	@Override
	public org.gfbio.model.UserSSO toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}