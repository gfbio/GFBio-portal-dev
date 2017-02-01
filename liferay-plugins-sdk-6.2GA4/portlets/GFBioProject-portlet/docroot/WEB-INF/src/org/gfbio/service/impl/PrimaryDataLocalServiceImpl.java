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

package org.gfbio.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.gfbio.NoSuchPrimaryDataException;
import org.gfbio.model.PrimaryData;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.PrimaryDataLocalServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the primary data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.PrimaryDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.PrimaryDataLocalServiceBaseImpl
 * @see org.gfbio.service.PrimaryDataLocalServiceUtil
 */
public class PrimaryDataLocalServiceImpl extends PrimaryDataLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getPrimaryDataById(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("primarydataid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("primarydataid"))
			try {responseJson = constructPrimaryDataJsonById(primaryDataPersistence.findByPrimaryKey((long)requestJson.get("primarydataid")));} 
			catch (NoSuchUserException | NoSuchPrimaryDataException| SystemException e) {e.printStackTrace();	}
		else
			responseJson.put("ERROR", "No key 'primarydataid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);
		
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	

	
		
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	private String checkForIgnoredParameter (Object[] objects, Set<String> keyList){

		String ignoredParameter = "WARNING:";
		Boolean check = false;
		for (int i =0; i < objects.length;i++)
			if (!keyList.contains((objects[i]))){
				ignoredParameter = ignoredParameter.concat(" ").concat(objects[i].toString()).concat(",");
				check = true;
			}
		if (check == true)
			ignoredParameter = ignoredParameter.substring(0, ignoredParameter.length()-1).concat(" are not parameters of this method.");
		else
			ignoredParameter ="";
		return ignoredParameter;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	private  JSONObject constructPrimaryDataJsonById (PrimaryData primaryData) throws NoSuchUserException, SystemException {
		JSONObject json = new JSONObject();
		json.put("primarydataid", primaryData.getPrimaryDataID());
		json.put("name", primaryData.getName());
		json.put("path", primaryData.getPath());
		return json;
	}
	
		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createPrimaryData (JSONArray requestJson){
		JSONArray responseJson = new JSONArray();
		
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(createPrimaryData((JSONObject) requestJson.get(i)));

		return responseJson;
	}

	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createPrimaryData (JSONObject requestJson){
		
		System.out.println(requestJson);
			
		Boolean check = false;	
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"name", "path", "researchobjectid", "researchobjectversion"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		
		if (requestJson.containsKey("name") && requestJson.containsKey("path")){
			
			long primaryDataId = createKernelPrimaryData(((String)requestJson.get("name")).trim(), ((String)requestJson.get("path")).trim());
			if (primaryDataId !=0)
				check = true;
			
			if (check && requestJson.containsKey("researchobjectid"))
				if (requestJson.containsKey("researchobjectversion")){
					int researchObjectVersion = ResearchObjectLocalServiceUtil.getResearchObjectVersionFromJson(requestJson);
					check = PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(primaryDataId, (long)requestJson.get("researchobjectid"), researchObjectVersion);
				}else
					check = PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(primaryDataId, (long)requestJson.get("researchobjectid"));
			
			if (check)
				responseJson.put("primarydataid", primaryDataId);
			else
				responseJson.put("ERROR:", "ERROR: create primarydata entry is failed.");

		}else{
			String errorString = "ERROR: Mandatory attribut";
			if (!requestJson.containsKey("name"))
				errorString = errorString.concat(" 'name',");
			if (!requestJson.containsKey("path"))
				errorString = errorString.concat(" 'path',");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
			responseJson.put("ERROR", errorString);
		}
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
	
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions --------------------------------------------------//
	
	
	//
	private long createKernelPrimaryData (String name, String path){
		return updateKernelPrimaryData (0, name, path);
	}
	
	
	//
	private long updateKernelPrimaryData (long primaryDataId, String name, String path){

		long check =0;
		PrimaryData primaryData = null;
		
		try {primaryData = primaryDataPersistence.findByPrimaryKey(primaryDataId);} 
		catch (NoSuchPrimaryDataException | SystemException e1) {System.out.println("Entry in Project does not exist with pk "+primaryDataId+ " and  will be create now");}

		if (primaryData == null)
			try {
				primaryDataId = CounterLocalServiceUtil.increment(getModelClassName());
				primaryData = primaryDataPersistence.create(primaryDataId);
			} catch (SystemException e) {System.out.println("no enitity with pk: "+primaryDataId+" is found");}
		primaryData.setName(name);
		primaryData.setPath(path);

		try {
			super.updatePrimaryData(primaryData);
			check = primaryData.getPrimaryDataID();
		} catch (SystemException e) {e.printStackTrace();}
			
		return check;
	}
		

}