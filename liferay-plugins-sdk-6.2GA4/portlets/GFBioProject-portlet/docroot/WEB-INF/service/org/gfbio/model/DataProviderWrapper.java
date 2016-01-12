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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataProvider}.
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProvider
 * @generated
 */
public class DataProviderWrapper implements DataProvider,
	ModelWrapper<DataProvider> {
	public DataProviderWrapper(DataProvider dataProvider) {
		_dataProvider = dataProvider;
	}

	@Override
	public Class<?> getModelClass() {
		return DataProvider.class;
	}

	@Override
	public String getModelClassName() {
		return DataProvider.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataProviderID", getDataProviderID());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("description", getDescription());
		attributes.put("address", getAddress());
		attributes.put("website", getWebsite());
		attributes.put("training", getTraining());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataProviderID = (Long)attributes.get("dataProviderID");

		if (dataProviderID != null) {
			setDataProviderID(dataProviderID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String training = (String)attributes.get("training");

		if (training != null) {
			setTraining(training);
		}
	}

	/**
	* Returns the primary key of this data provider.
	*
	* @return the primary key of this data provider
	*/
	@Override
	public long getPrimaryKey() {
		return _dataProvider.getPrimaryKey();
	}

	/**
	* Sets the primary key of this data provider.
	*
	* @param primaryKey the primary key of this data provider
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dataProvider.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the data provider i d of this data provider.
	*
	* @return the data provider i d of this data provider
	*/
	@Override
	public long getDataProviderID() {
		return _dataProvider.getDataProviderID();
	}

	/**
	* Sets the data provider i d of this data provider.
	*
	* @param dataProviderID the data provider i d of this data provider
	*/
	@Override
	public void setDataProviderID(long dataProviderID) {
		_dataProvider.setDataProviderID(dataProviderID);
	}

	/**
	* Returns the name of this data provider.
	*
	* @return the name of this data provider
	*/
	@Override
	public java.lang.String getName() {
		return _dataProvider.getName();
	}

	/**
	* Sets the name of this data provider.
	*
	* @param name the name of this data provider
	*/
	@Override
	public void setName(java.lang.String name) {
		_dataProvider.setName(name);
	}

	/**
	* Returns the label of this data provider.
	*
	* @return the label of this data provider
	*/
	@Override
	public java.lang.String getLabel() {
		return _dataProvider.getLabel();
	}

	/**
	* Sets the label of this data provider.
	*
	* @param label the label of this data provider
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_dataProvider.setLabel(label);
	}

	/**
	* Returns the description of this data provider.
	*
	* @return the description of this data provider
	*/
	@Override
	public java.lang.String getDescription() {
		return _dataProvider.getDescription();
	}

	/**
	* Sets the description of this data provider.
	*
	* @param description the description of this data provider
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dataProvider.setDescription(description);
	}

	/**
	* Returns the address of this data provider.
	*
	* @return the address of this data provider
	*/
	@Override
	public java.lang.String getAddress() {
		return _dataProvider.getAddress();
	}

	/**
	* Sets the address of this data provider.
	*
	* @param address the address of this data provider
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_dataProvider.setAddress(address);
	}

	/**
	* Returns the website of this data provider.
	*
	* @return the website of this data provider
	*/
	@Override
	public java.lang.String getWebsite() {
		return _dataProvider.getWebsite();
	}

	/**
	* Sets the website of this data provider.
	*
	* @param website the website of this data provider
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_dataProvider.setWebsite(website);
	}

	/**
	* Returns the training of this data provider.
	*
	* @return the training of this data provider
	*/
	@Override
	public java.lang.String getTraining() {
		return _dataProvider.getTraining();
	}

	/**
	* Sets the training of this data provider.
	*
	* @param training the training of this data provider
	*/
	@Override
	public void setTraining(java.lang.String training) {
		_dataProvider.setTraining(training);
	}

	@Override
	public boolean isNew() {
		return _dataProvider.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dataProvider.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dataProvider.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dataProvider.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dataProvider.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dataProvider.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dataProvider.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dataProvider.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dataProvider.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dataProvider.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dataProvider.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DataProviderWrapper((DataProvider)_dataProvider.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.DataProvider dataProvider) {
		return _dataProvider.compareTo(dataProvider);
	}

	@Override
	public int hashCode() {
		return _dataProvider.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.DataProvider> toCacheModel() {
		return _dataProvider.toCacheModel();
	}

	@Override
	public org.gfbio.model.DataProvider toEscapedModel() {
		return new DataProviderWrapper(_dataProvider.toEscapedModel());
	}

	@Override
	public org.gfbio.model.DataProvider toUnescapedModel() {
		return new DataProviderWrapper(_dataProvider.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dataProvider.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dataProvider.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dataProvider.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataProviderWrapper)) {
			return false;
		}

		DataProviderWrapper dataProviderWrapper = (DataProviderWrapper)obj;

		if (Validator.equals(_dataProvider, dataProviderWrapper._dataProvider)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DataProvider getWrappedDataProvider() {
		return _dataProvider;
	}

	@Override
	public DataProvider getWrappedModel() {
		return _dataProvider;
	}

	@Override
	public void resetOriginalValues() {
		_dataProvider.resetOriginalValues();
	}

	private DataProvider _dataProvider;
}