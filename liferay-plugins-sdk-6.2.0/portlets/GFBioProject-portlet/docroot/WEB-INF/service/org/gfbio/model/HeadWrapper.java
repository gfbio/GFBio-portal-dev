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
 * This class is a wrapper for {@link Head}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Head
 * @generated
 */
public class HeadWrapper implements Head, ModelWrapper<Head> {
	public HeadWrapper(Head head) {
		_head = head;
	}

	@Override
	public Class<?> getModelClass() {
		return Head.class;
	}

	@Override
	public String getModelClassName() {
		return Head.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("headID", getHeadID());
		attributes.put("name", getName());
		attributes.put("task", getTask());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String task = (String)attributes.get("task");

		if (task != null) {
			setTask(task);
		}
	}

	/**
	* Returns the primary key of this head.
	*
	* @return the primary key of this head
	*/
	@Override
	public long getPrimaryKey() {
		return _head.getPrimaryKey();
	}

	/**
	* Sets the primary key of this head.
	*
	* @param primaryKey the primary key of this head
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_head.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the head i d of this head.
	*
	* @return the head i d of this head
	*/
	@Override
	public long getHeadID() {
		return _head.getHeadID();
	}

	/**
	* Sets the head i d of this head.
	*
	* @param headID the head i d of this head
	*/
	@Override
	public void setHeadID(long headID) {
		_head.setHeadID(headID);
	}

	/**
	* Returns the name of this head.
	*
	* @return the name of this head
	*/
	@Override
	public java.lang.String getName() {
		return _head.getName();
	}

	/**
	* Sets the name of this head.
	*
	* @param name the name of this head
	*/
	@Override
	public void setName(java.lang.String name) {
		_head.setName(name);
	}

	/**
	* Returns the task of this head.
	*
	* @return the task of this head
	*/
	@Override
	public java.lang.String getTask() {
		return _head.getTask();
	}

	/**
	* Sets the task of this head.
	*
	* @param task the task of this head
	*/
	@Override
	public void setTask(java.lang.String task) {
		_head.setTask(task);
	}

	@Override
	public boolean isNew() {
		return _head.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_head.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _head.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_head.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _head.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _head.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_head.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _head.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_head.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_head.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_head.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeadWrapper((Head)_head.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Head head) {
		return _head.compareTo(head);
	}

	@Override
	public int hashCode() {
		return _head.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Head> toCacheModel() {
		return _head.toCacheModel();
	}

	@Override
	public org.gfbio.model.Head toEscapedModel() {
		return new HeadWrapper(_head.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Head toUnescapedModel() {
		return new HeadWrapper(_head.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _head.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _head.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_head.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HeadWrapper)) {
			return false;
		}

		HeadWrapper headWrapper = (HeadWrapper)obj;

		if (Validator.equals(_head, headWrapper._head)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Head getWrappedHead() {
		return _head;
	}

	@Override
	public Head getWrappedModel() {
		return _head;
	}

	@Override
	public void resetOriginalValues() {
		_head.resetOriginalValues();
	}

	private Head _head;
}