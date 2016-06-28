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

/**
 * The base model interface for the DataProvider service. Represents a row in the &quot;gfbio_DataProvider&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.DataProviderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.DataProviderImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProvider
 * @see org.gfbio.model.impl.DataProviderImpl
 * @see org.gfbio.model.impl.DataProviderModelImpl
 * @generated
 */
public interface DataProviderModel extends BaseModel<DataProvider> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data provider model instance should use the {@link DataProvider} interface instead.
	 */

	/**
	 * Returns the primary key of this data provider.
	 *
	 * @return the primary key of this data provider
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this data provider.
	 *
	 * @param primaryKey the primary key of this data provider
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the data provider i d of this data provider.
	 *
	 * @return the data provider i d of this data provider
	 */
	public long getDataProviderID();

	/**
	 * Sets the data provider i d of this data provider.
	 *
	 * @param dataProviderID the data provider i d of this data provider
	 */
	public void setDataProviderID(long dataProviderID);

	/**
	 * Returns the name of this data provider.
	 *
	 * @return the name of this data provider
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this data provider.
	 *
	 * @param name the name of this data provider
	 */
	public void setName(String name);

	/**
	 * Returns the label of this data provider.
	 *
	 * @return the label of this data provider
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this data provider.
	 *
	 * @param label the label of this data provider
	 */
	public void setLabel(String label);

	/**
	 * Returns the description of this data provider.
	 *
	 * @return the description of this data provider
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this data provider.
	 *
	 * @param description the description of this data provider
	 */
	public void setDescription(String description);

	/**
	 * Returns the address of this data provider.
	 *
	 * @return the address of this data provider
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this data provider.
	 *
	 * @param address the address of this data provider
	 */
	public void setAddress(String address);

	/**
	 * Returns the website of this data provider.
	 *
	 * @return the website of this data provider
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this data provider.
	 *
	 * @param website the website of this data provider
	 */
	public void setWebsite(String website);

	/**
	 * Returns the training of this data provider.
	 *
	 * @return the training of this data provider
	 */
	@AutoEscape
	public String getTraining();

	/**
	 * Sets the training of this data provider.
	 *
	 * @param training the training of this data provider
	 */
	public void setTraining(String training);

	/**
	 * Returns the physicalobjects of this data provider.
	 *
	 * @return the physicalobjects of this data provider
	 */
	public boolean getPhysicalobjects();

	/**
	 * Returns <code>true</code> if this data provider is physicalobjects.
	 *
	 * @return <code>true</code> if this data provider is physicalobjects; <code>false</code> otherwise
	 */
	public boolean isPhysicalobjects();

	/**
	 * Sets whether this data provider is physicalobjects.
	 *
	 * @param physicalobjects the physicalobjects of this data provider
	 */
	public void setPhysicalobjects(boolean physicalobjects);

	/**
	 * Returns the taxonbased of this data provider.
	 *
	 * @return the taxonbased of this data provider
	 */
	public boolean getTaxonbased();

	/**
	 * Returns <code>true</code> if this data provider is taxonbased.
	 *
	 * @return <code>true</code> if this data provider is taxonbased; <code>false</code> otherwise
	 */
	public boolean isTaxonbased();

	/**
	 * Sets whether this data provider is taxonbased.
	 *
	 * @param taxonbased the taxonbased of this data provider
	 */
	public void setTaxonbased(boolean taxonbased);

	/**
	 * Returns the notaxonbased of this data provider.
	 *
	 * @return the notaxonbased of this data provider
	 */
	public boolean getNotaxonbased();

	/**
	 * Returns <code>true</code> if this data provider is notaxonbased.
	 *
	 * @return <code>true</code> if this data provider is notaxonbased; <code>false</code> otherwise
	 */
	public boolean isNotaxonbased();

	/**
	 * Sets whether this data provider is notaxonbased.
	 *
	 * @param notaxonbased the notaxonbased of this data provider
	 */
	public void setNotaxonbased(boolean notaxonbased);

	/**
	 * Returns the livingobjects of this data provider.
	 *
	 * @return the livingobjects of this data provider
	 */
	public boolean getLivingobjects();

	/**
	 * Returns <code>true</code> if this data provider is livingobjects.
	 *
	 * @return <code>true</code> if this data provider is livingobjects; <code>false</code> otherwise
	 */
	public boolean isLivingobjects();

	/**
	 * Sets whether this data provider is livingobjects.
	 *
	 * @param livingobjects the livingobjects of this data provider
	 */
	public void setLivingobjects(boolean livingobjects);

	/**
	 * Returns the deadobjects of this data provider.
	 *
	 * @return the deadobjects of this data provider
	 */
	public boolean getDeadobjects();

	/**
	 * Returns <code>true</code> if this data provider is deadobjects.
	 *
	 * @return <code>true</code> if this data provider is deadobjects; <code>false</code> otherwise
	 */
	public boolean isDeadobjects();

	/**
	 * Sets whether this data provider is deadobjects.
	 *
	 * @param deadobjects the deadobjects of this data provider
	 */
	public void setDeadobjects(boolean deadobjects);

	/**
	 * Returns the sequencedata of this data provider.
	 *
	 * @return the sequencedata of this data provider
	 */
	public boolean getSequencedata();

	/**
	 * Returns <code>true</code> if this data provider is sequencedata.
	 *
	 * @return <code>true</code> if this data provider is sequencedata; <code>false</code> otherwise
	 */
	public boolean isSequencedata();

	/**
	 * Sets whether this data provider is sequencedata.
	 *
	 * @param sequencedata the sequencedata of this data provider
	 */
	public void setSequencedata(boolean sequencedata);

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
	public int compareTo(org.gfbio.model.DataProvider dataProvider);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.gfbio.model.DataProvider> toCacheModel();

	@Override
	public org.gfbio.model.DataProvider toEscapedModel();

	@Override
	public org.gfbio.model.DataProvider toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}