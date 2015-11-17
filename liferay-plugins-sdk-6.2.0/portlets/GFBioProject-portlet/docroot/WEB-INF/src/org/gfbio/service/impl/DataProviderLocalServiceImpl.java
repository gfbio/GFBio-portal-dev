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

package org.gfbio.service.impl;

import java.util.List;

import org.gfbio.NoSuchDataProviderException;
import org.gfbio.model.DataProvider;
import org.gfbio.service.base.DataProviderLocalServiceBaseImpl;
import org.gfbio.service.persistence.DataProviderFinderUtil;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierFinderUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the data provider local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.DataProviderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.DataProviderLocalServiceBaseImpl
 * @see org.gfbio.service.DataProviderLocalServiceUtil
 */
public class DataProviderLocalServiceImpl	extends DataProviderLocalServiceBaseImpl {
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
		
	//
	public long getDataProviderIdByLabel (String label){
		return (long) DataProviderFinderUtil.getDataProviderIdByLabel(label).get(0);
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getDataProviderIds (long persistentIdentiferId){
		return DataProvider_PersistentIdentifierFinderUtil.getDataProviderIds(persistentIdentiferId);
	}
	
	
	//
	public String getLabelById (long dataProviderId){
		return (String) DataProviderFinderUtil.getLabelById(dataProviderId).get(0);
	}

	
	//
	@SuppressWarnings("rawtypes")
	public List getPersistentIdentiferIds (long dataProviderId){
		return DataProvider_PersistentIdentifierFinderUtil.getPersistentIdentiferIds(dataProviderId);
	}
	

	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////

	
	public Boolean updateDataProvider (long dataProviderId, String name, String label, String description, String address, String website, String training){
		
		Boolean check = false;
		
		DataProvider dataProvider = null;
		try {dataProvider = dataProviderPersistence.findByPrimaryKey(dataProviderId);}
		catch (NoSuchDataProviderException | SystemException e1) {e1.printStackTrace();}

		if (dataProvider == null) {
			try {dataProvider = dataProviderPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));}
			catch (SystemException e) {e.printStackTrace();}
			dataProviderId = dataProvider.getDataProviderID();
		}
		
		dataProvider.setDataProviderID(dataProviderId);
		dataProvider.setName(name);
		dataProvider.setLabel(label);
		dataProvider.setDescription(description);
		dataProvider.setAddress(address);
		dataProvider.setWebsite(website);
		dataProvider.setTraining(training);
		
		try {
			super.updateDataProvider(dataProvider);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
}