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
 * This class is a wrapper for {@link tab_ResearchObject}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObject
 * @generated
 */
public class tab_ResearchObjectWrapper implements tab_ResearchObject,
	ModelWrapper<tab_ResearchObject> {
	public tab_ResearchObjectWrapper(tab_ResearchObject tab_ResearchObject) {
		_tab_ResearchObject = tab_ResearchObject;
	}

	@Override
	public Class<?> getModelClass() {
		return tab_ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return tab_ResearchObject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ro_ID", getRo_ID());
		attributes.put("ro_name", getRo_name());
		attributes.put("ro_meta", getRo_meta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ro_ID = (Long)attributes.get("ro_ID");

		if (ro_ID != null) {
			setRo_ID(ro_ID);
		}

		String ro_name = (String)attributes.get("ro_name");

		if (ro_name != null) {
			setRo_name(ro_name);
		}

		String ro_meta = (String)attributes.get("ro_meta");

		if (ro_meta != null) {
			setRo_meta(ro_meta);
		}
	}

	/**
	* Returns the primary key of this tab_ research object.
	*
	* @return the primary key of this tab_ research object
	*/
	@Override
	public long getPrimaryKey() {
		return _tab_ResearchObject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tab_ research object.
	*
	* @param primaryKey the primary key of this tab_ research object
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tab_ResearchObject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ro_ i d of this tab_ research object.
	*
	* @return the ro_ i d of this tab_ research object
	*/
	@Override
	public long getRo_ID() {
		return _tab_ResearchObject.getRo_ID();
	}

	/**
	* Sets the ro_ i d of this tab_ research object.
	*
	* @param ro_ID the ro_ i d of this tab_ research object
	*/
	@Override
	public void setRo_ID(long ro_ID) {
		_tab_ResearchObject.setRo_ID(ro_ID);
	}

	/**
	* Returns the ro_name of this tab_ research object.
	*
	* @return the ro_name of this tab_ research object
	*/
	@Override
	public java.lang.String getRo_name() {
		return _tab_ResearchObject.getRo_name();
	}

	/**
	* Sets the ro_name of this tab_ research object.
	*
	* @param ro_name the ro_name of this tab_ research object
	*/
	@Override
	public void setRo_name(java.lang.String ro_name) {
		_tab_ResearchObject.setRo_name(ro_name);
	}

	/**
	* Returns the ro_meta of this tab_ research object.
	*
	* @return the ro_meta of this tab_ research object
	*/
	@Override
	public java.lang.String getRo_meta() {
		return _tab_ResearchObject.getRo_meta();
	}

	/**
	* Sets the ro_meta of this tab_ research object.
	*
	* @param ro_meta the ro_meta of this tab_ research object
	*/
	@Override
	public void setRo_meta(java.lang.String ro_meta) {
		_tab_ResearchObject.setRo_meta(ro_meta);
	}

	@Override
	public boolean isNew() {
		return _tab_ResearchObject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tab_ResearchObject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tab_ResearchObject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tab_ResearchObject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tab_ResearchObject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tab_ResearchObject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tab_ResearchObject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tab_ResearchObject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tab_ResearchObject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tab_ResearchObject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tab_ResearchObject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new tab_ResearchObjectWrapper((tab_ResearchObject)_tab_ResearchObject.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.tab_ResearchObject tab_ResearchObject) {
		return _tab_ResearchObject.compareTo(tab_ResearchObject);
	}

	@Override
	public int hashCode() {
		return _tab_ResearchObject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.tab_ResearchObject> toCacheModel() {
		return _tab_ResearchObject.toCacheModel();
	}

	@Override
	public org.gfbio.model.tab_ResearchObject toEscapedModel() {
		return new tab_ResearchObjectWrapper(_tab_ResearchObject.toEscapedModel());
	}

	@Override
	public org.gfbio.model.tab_ResearchObject toUnescapedModel() {
		return new tab_ResearchObjectWrapper(_tab_ResearchObject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tab_ResearchObject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tab_ResearchObject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tab_ResearchObject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof tab_ResearchObjectWrapper)) {
			return false;
		}

		tab_ResearchObjectWrapper tab_ResearchObjectWrapper = (tab_ResearchObjectWrapper)obj;

		if (Validator.equals(_tab_ResearchObject,
					tab_ResearchObjectWrapper._tab_ResearchObject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public tab_ResearchObject getWrappedtab_ResearchObject() {
		return _tab_ResearchObject;
	}

	@Override
	public tab_ResearchObject getWrappedModel() {
		return _tab_ResearchObject;
	}

	@Override
	public void resetOriginalValues() {
		_tab_ResearchObject.resetOriginalValues();
	}

	private tab_ResearchObject _tab_ResearchObject;
}