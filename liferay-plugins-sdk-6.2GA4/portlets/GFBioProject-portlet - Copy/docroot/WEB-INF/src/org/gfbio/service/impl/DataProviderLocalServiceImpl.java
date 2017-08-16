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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchDataProviderException;
import org.gfbio.model.DataProvider;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.base.DataProviderLocalServiceBaseImpl;
import org.gfbio.service.persistence.DataProviderFinderUtil;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierFinderUtil;
import org.json.simple.JSONObject;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
	
	
	public JSONObject getDataProviderById (long dataProviderId){
		JSONObject responseJson = new JSONObject();
		try {responseJson = constructDataProviderAsJson(DataProviderLocalServiceUtil.getDataProvider(dataProviderId));}
		catch (PortalException | SystemException e) {e.printStackTrace();}
		return responseJson;
	}
	
	
	public JSONObject getDataProviderByLabel (String label){
		JSONObject responseJson = new JSONObject();
		responseJson = getDataProviderById(getDataProviderIdByLabel(label));
		return responseJson;
	}
	
	public List<DataProvider> getDataProviderByProviderType(String providerType){
		List<DataProvider> dataProvider = null;
		try {dataProvider = dataProviderPersistence.findByProviderType(providerType);}
		catch (SystemException e) {e.printStackTrace();}
		return dataProvider;
	}
	
	
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
	@SuppressWarnings("rawtypes")
	public List getLabels (){
		return DataProviderFinderUtil.getLabels();
	}
	
	//
	public String getLabelById (long dataProviderId){
		return (String) DataProviderFinderUtil.getLabelById(dataProviderId).get(0);
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = DataProviderFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	
	//
	public String getNameById (long dataProviderId){
		return (String) DataProviderFinderUtil.getNameById(dataProviderId).get(0);
	}

	
	//
	@SuppressWarnings("rawtypes")
	public List getPersistentIdentiferIds (long dataProviderId){
		return DataProvider_PersistentIdentifierFinderUtil.getPersistentIdentiferIds(dataProviderId);
	}
	

	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	public Boolean checkDataProviderLabel(String archive) {
		
		Boolean check = false;
		List <Boolean> checkList =  DataProviderFinderUtil.getCheckOfLabel(archive);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructDataProviderAsJson (DataProvider dataProvider){

		JSONObject json = new JSONObject();
		json.put("dataproviderid", dataProvider.getDataProviderID());
		json.put("name", (dataProvider.getName()).trim());
		json.put("label", (dataProvider.getLabel()).trim());
		json.put("description", (dataProvider.getDescription()).trim());
		json.put("adress", (dataProvider.getAddress()).trim());
		json.put("website", (dataProvider.getWebsite()).trim());
		json.put("training", (dataProvider.getTraining()).trim());
		
		json.put("physicalobjectpossible", dataProvider.getPhysicalobjectpossible());
		json.put("nophysicalobject", dataProvider.getNophysicalobject());
		json.put("taxonbased", dataProvider.getTaxonbased());
		json.put("notaxonbased", dataProvider.getNotaxonbased());
		json.put("livingobjects", dataProvider.getLivingobjects());
		json.put("deadobjects", dataProvider.getDeadobjects());
		json.put("sequencedata", dataProvider.getSequencedata());
		json.put("lastmodifieddate", dataProvider.getLastModifiedDate());
		
		return json;
	}
	
	
	//
	public long constructNewId(){
		long id = 0;
		try {
			if (CounterLocalServiceUtil.increment(getModelClassName())<getMaxId())
				CounterLocalServiceUtil.reset(getModelClassName(), getMaxId());
			id = CounterLocalServiceUtil.increment(getModelClassName());
		} 
		catch (SystemException e) {e.printStackTrace();}
		return id;
	}
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////

	
	//
	public Boolean updateDataProvider (long dataProviderId, String name, String label, String description, String address, String website, String training){
		
		Boolean check = false;
		
		DataProvider dataProvider = null;
		try {dataProvider = dataProviderPersistence.findByPrimaryKey(dataProviderId);}
		catch (NoSuchDataProviderException | SystemException e1) {e1.printStackTrace();}

		if (dataProvider == null) {
			dataProvider = dataProviderPersistence.create(constructNewId());
			dataProviderId = dataProvider.getDataProviderID();
		}
		
		dataProvider.setDataProviderID(dataProviderId);
		dataProvider.setName(name);
		dataProvider.setLabel(label);
		dataProvider.setDescription(description);
		dataProvider.setAddress(address);
		dataProvider.setWebsite(website);
		dataProvider.setTraining(training);
		dataProvider.setLastModifiedDate(new Timestamp(new Date().getTime()));
		
		try {
			super.updateDataProvider(dataProvider);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateDataProvider (long dataProviderId, String name, String label, String description, String address, String website, String training,
			Boolean physicalObjectPossible, Boolean noPhysicalObject,
			Boolean taxonBased, Boolean noTaxonBased,
			Boolean livingObjects, Boolean deadObjects,
			Boolean sequenceData){
		
		Boolean check = false;
		
		DataProvider dataProvider = null;
		try {dataProvider = dataProviderPersistence.findByPrimaryKey(dataProviderId);}
		catch (NoSuchDataProviderException | SystemException e1) {e1.printStackTrace();}

		if (dataProvider == null) {
			dataProvider = dataProviderPersistence.create(constructNewId());
			dataProviderId = dataProvider.getDataProviderID();
		}
		
		dataProvider.setDataProviderID(dataProviderId);
		dataProvider.setName(name);
		dataProvider.setLabel(label);
		dataProvider.setDescription(description);
		dataProvider.setAddress(address);
		dataProvider.setWebsite(website);
		dataProvider.setTraining(training);
		dataProvider.setPhysicalobjectpossible(physicalObjectPossible);
		dataProvider.setNophysicalobject(noPhysicalObject);
		dataProvider.setTaxonbased(taxonBased);
		dataProvider.setNotaxonbased(noTaxonBased);
		dataProvider.setLivingobjects(livingObjects);
		dataProvider.setDeadobjects(deadObjects);
		dataProvider.setSequencedata(sequenceData);
		dataProvider.setLastModifiedDate(new Timestamp(new Date().getTime()));
	
		return check;
	}
}