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
 * This class is a wrapper for {@link DataProvider_PersistentIdentifier}.
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifier
 * @generated
 */
public class DataProvider_PersistentIdentifierWrapper
	implements DataProvider_PersistentIdentifier,
		ModelWrapper<DataProvider_PersistentIdentifier> {
	public DataProvider_PersistentIdentifierWrapper(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		_dataProvider_PersistentIdentifier = dataProvider_PersistentIdentifier;
	}

	@Override
	public Class<?> getModelClass() {
		return DataProvider_PersistentIdentifier.class;
	}

	@Override
	public String getModelClassName() {
		return DataProvider_PersistentIdentifier.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gfbioDataProvider", getGfbioDataProvider());
		attributes.put("gfbioPersistentIdentifier",
			getGfbioPersistentIdentifier());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gfbioDataProvider = (Long)attributes.get("gfbioDataProvider");

		if (gfbioDataProvider != null) {
			setGfbioDataProvider(gfbioDataProvider);
		}

		Long gfbioPersistentIdentifier = (Long)attributes.get(
				"gfbioPersistentIdentifier");

		if (gfbioPersistentIdentifier != null) {
			setGfbioPersistentIdentifier(gfbioPersistentIdentifier);
		}
	}

	/**
	* Returns the primary key of this data provider_ persistent identifier.
	*
	* @return the primary key of this data provider_ persistent identifier
	*/
	@Override
	public org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK getPrimaryKey() {
		return _dataProvider_PersistentIdentifier.getPrimaryKey();
	}

	/**
	* Sets the primary key of this data provider_ persistent identifier.
	*
	* @param primaryKey the primary key of this data provider_ persistent identifier
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK primaryKey) {
		_dataProvider_PersistentIdentifier.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gfbio data provider of this data provider_ persistent identifier.
	*
	* @return the gfbio data provider of this data provider_ persistent identifier
	*/
	@Override
	public long getGfbioDataProvider() {
		return _dataProvider_PersistentIdentifier.getGfbioDataProvider();
	}

	/**
	* Sets the gfbio data provider of this data provider_ persistent identifier.
	*
	* @param gfbioDataProvider the gfbio data provider of this data provider_ persistent identifier
	*/
	@Override
	public void setGfbioDataProvider(long gfbioDataProvider) {
		_dataProvider_PersistentIdentifier.setGfbioDataProvider(gfbioDataProvider);
	}

	/**
	* Returns the gfbio persistent identifier of this data provider_ persistent identifier.
	*
	* @return the gfbio persistent identifier of this data provider_ persistent identifier
	*/
	@Override
	public long getGfbioPersistentIdentifier() {
		return _dataProvider_PersistentIdentifier.getGfbioPersistentIdentifier();
	}

	/**
	* Sets the gfbio persistent identifier of this data provider_ persistent identifier.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier of this data provider_ persistent identifier
	*/
	@Override
	public void setGfbioPersistentIdentifier(long gfbioPersistentIdentifier) {
		_dataProvider_PersistentIdentifier.setGfbioPersistentIdentifier(gfbioPersistentIdentifier);
	}

	@Override
	public boolean isNew() {
		return _dataProvider_PersistentIdentifier.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dataProvider_PersistentIdentifier.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dataProvider_PersistentIdentifier.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dataProvider_PersistentIdentifier.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dataProvider_PersistentIdentifier.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dataProvider_PersistentIdentifier.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dataProvider_PersistentIdentifier.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dataProvider_PersistentIdentifier.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dataProvider_PersistentIdentifier.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dataProvider_PersistentIdentifier.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dataProvider_PersistentIdentifier.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DataProvider_PersistentIdentifierWrapper((DataProvider_PersistentIdentifier)_dataProvider_PersistentIdentifier.clone());
	}

	@Override
	public int compareTo(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		return _dataProvider_PersistentIdentifier.compareTo(dataProvider_PersistentIdentifier);
	}

	@Override
	public int hashCode() {
		return _dataProvider_PersistentIdentifier.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.DataProvider_PersistentIdentifier> toCacheModel() {
		return _dataProvider_PersistentIdentifier.toCacheModel();
	}

	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier toEscapedModel() {
		return new DataProvider_PersistentIdentifierWrapper(_dataProvider_PersistentIdentifier.toEscapedModel());
	}

	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier toUnescapedModel() {
		return new DataProvider_PersistentIdentifierWrapper(_dataProvider_PersistentIdentifier.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dataProvider_PersistentIdentifier.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dataProvider_PersistentIdentifier.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dataProvider_PersistentIdentifier.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataProvider_PersistentIdentifierWrapper)) {
			return false;
		}

		DataProvider_PersistentIdentifierWrapper dataProvider_PersistentIdentifierWrapper =
			(DataProvider_PersistentIdentifierWrapper)obj;

		if (Validator.equals(_dataProvider_PersistentIdentifier,
					dataProvider_PersistentIdentifierWrapper._dataProvider_PersistentIdentifier)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DataProvider_PersistentIdentifier getWrappedDataProvider_PersistentIdentifier() {
		return _dataProvider_PersistentIdentifier;
	}

	@Override
	public DataProvider_PersistentIdentifier getWrappedModel() {
		return _dataProvider_PersistentIdentifier;
	}

	@Override
	public void resetOriginalValues() {
		_dataProvider_PersistentIdentifier.resetOriginalValues();
	}

	private DataProvider_PersistentIdentifier _dataProvider_PersistentIdentifier;
}