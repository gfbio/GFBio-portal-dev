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
 * This class is a wrapper for {@link Position}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Position
 * @generated
 */
public class PositionWrapper implements Position, ModelWrapper<Position> {
	public PositionWrapper(Position position) {
		_position = position;
	}

	@Override
	public Class<?> getModelClass() {
		return Position.class;
	}

	@Override
	public String getModelClassName() {
		return Position.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("positionID", getPositionID());
		attributes.put("headID", getHeadID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}
	}

	/**
	* Returns the primary key of this position.
	*
	* @return the primary key of this position
	*/
	@Override
	public long getPrimaryKey() {
		return _position.getPrimaryKey();
	}

	/**
	* Sets the primary key of this position.
	*
	* @param primaryKey the primary key of this position
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_position.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the position i d of this position.
	*
	* @return the position i d of this position
	*/
	@Override
	public long getPositionID() {
		return _position.getPositionID();
	}

	/**
	* Sets the position i d of this position.
	*
	* @param positionID the position i d of this position
	*/
	@Override
	public void setPositionID(long positionID) {
		_position.setPositionID(positionID);
	}

	/**
	* Returns the head i d of this position.
	*
	* @return the head i d of this position
	*/
	@Override
	public long getHeadID() {
		return _position.getHeadID();
	}

	/**
	* Sets the head i d of this position.
	*
	* @param headID the head i d of this position
	*/
	@Override
	public void setHeadID(long headID) {
		_position.setHeadID(headID);
	}

	@Override
	public boolean isNew() {
		return _position.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_position.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _position.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_position.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _position.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _position.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_position.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _position.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_position.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_position.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_position.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PositionWrapper((Position)_position.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Position position) {
		return _position.compareTo(position);
	}

	@Override
	public int hashCode() {
		return _position.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Position> toCacheModel() {
		return _position.toCacheModel();
	}

	@Override
	public org.gfbio.model.Position toEscapedModel() {
		return new PositionWrapper(_position.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Position toUnescapedModel() {
		return new PositionWrapper(_position.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _position.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _position.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_position.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PositionWrapper)) {
			return false;
		}

		PositionWrapper positionWrapper = (PositionWrapper)obj;

		if (Validator.equals(_position, positionWrapper._position)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Position getWrappedPosition() {
		return _position;
	}

	@Override
	public Position getWrappedModel() {
		return _position;
	}

	@Override
	public void resetOriginalValues() {
		_position.resetOriginalValues();
	}

	private Position _position;
}