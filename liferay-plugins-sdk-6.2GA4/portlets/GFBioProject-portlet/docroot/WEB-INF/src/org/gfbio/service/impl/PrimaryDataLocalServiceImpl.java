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

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gfbio.NoSuchPrimaryDataException;
import org.gfbio.helper.Helper;
import org.gfbio.model.PrimaryData;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.PrimaryDataLocalServiceBaseImpl;
import org.gfbio.service.persistence.PrimaryDataFinderUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
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
	
	//private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
	
	//////////////////////////////////// Delete Functions //////////////////////////////////////////////////
	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
	
	
	@SuppressWarnings("unchecked")
	public JSONObject deletePrimaryData (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
		
		if (requestJson.containsKey("primarydataid")){
			
			long primaryDataId = Helper.getLongFromJson(requestJson, "primarydataid");
			
			
			if (checkPrimaryDataById(primaryDataId)){
				Boolean optionalCheck = true;
				
				if (PrimaryData_ResearchObjectLocalServiceUtil.checkPrimaryDataId(primaryDataId)){
					JSONObject primaryDataJson = new JSONObject();
					primaryDataJson.put("primarydataid", primaryDataId);
					primaryDataJson = PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryDataResearchObject(primaryDataJson);
					if (primaryDataJson.containsKey("check"))
						optionalCheck = (Boolean) primaryDataJson.get("check");
				}
					
				if (optionalCheck)
					check = deletePrimaryDataById(primaryDataId);
			}
		}
		
		responseJson.put("check", check);
		return responseJson;
	}
	
	//---------------------------------- Delete Functions ------------------------------------------------//
	
	
	private Boolean deletePrimaryDataById (long primaryDataId){
		
		Boolean check = false;
		
		if (checkPrimaryDataById(primaryDataId)){
			
			
			PrimaryData primaryData = null;
			
			try {
				primaryData = primaryDataPersistence.findByPrimaryKey(primaryDataId);
				
				if (primaryData != null){
					String path = primaryData.getPath();
					File file = new File(path);
					if (file.delete())
						check = true;
					
					if (check)
						PrimaryDataLocalServiceUtil.deletePrimaryData(primaryData);
					
					if (!checkPrimaryDataById(primaryDataId) && check)
						check = true;
					else
						check = false;
				}
			}
			catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with id: "+primaryDataId+" is found");}
			
		}
			
		return check;
	}
	
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
	

	//
	public String getPathByPrimaryDataId (long primaryDataId){
		String  path = null;
		List <String> pathList = null;
		
		pathList = PrimaryDataFinderUtil.getPathByPrimaryDataId(primaryDataId);
		if (pathList.size()>0)
			path = (String) pathList.get(0);
		
		return path;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = PrimaryDataFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	
		
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
	
	private Boolean checkPrimaryDataById(long primaryDataId){
		Boolean check = false;
		
		List <Boolean> checkList =  PrimaryDataFinderUtil.getCheckPrimaryDataById(primaryDataId);
		
		if (checkList.size()>0)
			check = checkList.get(0);
		
		return check;
	}
	
	
	//
	public String checkPath (String name, String path){
		if (!path.matches(name))
			if (path.charAt(path.length()-1)=='\\')
				path = path.concat(name);
			else
				path = path.concat("\\").concat(name);
		
		return path;
	}
	
	
	//
	public Boolean checkPrimaryDataExists(String name, String path){
		Boolean check = false;

		check = PrimaryDataFinderUtil.getCheckPrimaryDataExists( name, path).get(0);
		
		return check;
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
	
	
	
	//
	@SuppressWarnings("unchecked")
	private  JSONObject constructPrimaryDataJsonById (PrimaryData primaryData) throws NoSuchUserException, SystemException {
		JSONObject json = new JSONObject();
		json.put("primarydataid", primaryData.getPrimaryDataID());
		json.put("name", (primaryData.getName()).trim());
		json.put("path", (primaryData.getPath()).trim());
		json.put("lastmodifieddate", primaryData.getLastModifiedDate().toString());
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
			
		Boolean check = false;	
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"name", "path", "researchobjectid", "researchobjectversion", "externallink"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		Boolean externalLink = false;
		String name = "";
		String path = "";
		
		if (requestJson.containsKey("externallink"))
				externalLink = Helper.getBooleanFromJson(requestJson, "externallink");
		
		
		if ((requestJson.containsKey("name") || externalLink) && requestJson.containsKey("path")){
			
			if (requestJson.containsKey("name"))
				name = Helper.getStringFromJson(requestJson, "name");
			
			if (!externalLink)
				path = checkPath(name, Helper.getStringFromJson(requestJson, "path"));
			else
				path = Helper.getStringFromJson(requestJson, "path");
			
			if (!checkPrimaryDataExists(name, path) || externalLink){

				long primaryDataId = createKernelPrimaryData(name, path);
				if (primaryDataId !=0)
					check = true;
				
				if (check && requestJson.containsKey("researchobjectid"))
					if (requestJson.containsKey("researchobjectversion")){
						int researchObjectVersion = ResearchObjectLocalServiceUtil.getResearchObjectVersionFromJson(requestJson);
						check = PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(primaryDataId, Helper.getLongFromJson(requestJson, "researchobjectid"), researchObjectVersion);
					}else
						check = PrimaryData_ResearchObjectLocalServiceUtil.updatePrimaryDataResearchObject(primaryDataId, Helper.getLongFromJson(requestJson, "researchobjectid"));
				
				if (check)
					responseJson.put("primarydataid", primaryDataId);
				else
					responseJson.put("ERROR:", "ERROR: create primarydata entry is failed.");
			}else
				responseJson.put("ERROR:", "ERROR: A File with this name is part of this research object.");

		}else{
			String errorString = "ERROR: Mandatory attribut";
			if (!requestJson.containsKey("name") && !requestJson.containsKey("externallink"))
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
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject updatePrimaryData (JSONObject requestJson){
			
		Boolean check = false;	
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"name", "path", "primarydataid","researchobjectid", "researchobjectversion", "externallink"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		Boolean externalLink = false;
		String name = "";
		String path = "";
		
		
		
		if (requestJson.containsKey("externallink"))
				externalLink = Helper.getBooleanFromJson(requestJson, "externallink");
		
		
		if (requestJson.containsKey("primarydataid")){
			
			responseJson = getPrimaryDataById(requestJson);
			
			if (responseJson.size()!=0){
			
				if (requestJson.containsKey("name"))
					name = Helper.getStringFromJson(requestJson, "name");
				else
					name = Helper.getStringFromJson(responseJson, "name");
			
			
				if (requestJson.containsKey("path"))
					if (!externalLink)
						path = checkPath(name, Helper.getStringFromJson(requestJson, "path"));
					else
						path = Helper.getStringFromJson(requestJson, "path");
				else
					path = Helper.getStringFromJson(responseJson, "path");
			}
			
			long primaryDataId = updateKernelPrimaryData(Helper.getLongFromJson(requestJson, "primarydataid"),name, path);
			if (primaryDataId !=0)
				check = true;
			
			if(!check)
				responseJson.put("ERROR", "ERROR: update primarydata entry is failed.");

		}else
			responseJson.put("ERROR", "ERROR: Mandatory attribut 'primarydataid' is not correct.");
		
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
			primaryDataId = constructNewId();
			primaryData = primaryDataPersistence.create(primaryDataId);
			
		primaryData.setName(name);
		primaryData.setPath(path);
		primaryData.setLastModifiedDate(new Timestamp(new Date().getTime()));

		try {
			super.updatePrimaryData(primaryData);
			check = primaryData.getPrimaryDataID();
		} catch (SystemException e) {e.printStackTrace();}
			
		return check;
	}
		

}