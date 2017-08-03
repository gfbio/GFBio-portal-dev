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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.gfbio.NoSuchContentException;
import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.helper.Helper;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObject_UserLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_ResearchObjectFinderUtil;
import org.gfbio.service.persistence.ResearchObjectFinderUtil;
import org.gfbio.service.persistence.ResearchObjectPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The implementation of the research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.ResearchObjectLocalServiceUtil
 */
public class ResearchObjectLocalServiceImpl extends ResearchObjectLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(ResearchObjectLocalServiceImpl.class);
	
	//////////////////////////////////// Delete Functions //////////////////////////////////////////////////
	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
	
	
	@SuppressWarnings("unchecked")
	public JSONObject deleteResearchObject (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
	
		
		if (requestJson.containsKey("researchobjectid")){
			
			long researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			if (checkResearchObjectId(researchObjectId)){
			
				if (requestJson.containsKey("researchobjectversion")){
					
					int researchObjectVersion = Helper.getIntFromJson(requestJson, "researchobjectversion");
					if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion) != null){
						
						responseJson = ResearchObject_UserLocalServiceUtil.deleteResearchObjectUser(requestJson);
						if (responseJson.containsKey("check"))
							if ((Boolean) responseJson.get("check")){
								responseJson = Project_ResearchObjectLocalServiceUtil.deleteProjectResearchObject(requestJson);
								if (responseJson.containsKey("check"))
									if ((Boolean) responseJson.get("check")){
										responseJson = PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryDataResearchObject(requestJson);
										if (responseJson.containsKey("check"))
											if ((Boolean) responseJson.get("check")){
												responseJson = SubmissionLocalServiceUtil.deleteSubmission(requestJson);
												if (responseJson.containsKey("check"))
													if ((Boolean) responseJson.get("check")){
														//ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_category_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
														//ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_externalperson_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
														//ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_legalrequirement_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
														check = (Boolean) responseJson.get("check");
													}
											}
									}
							}


						if (check)
							check = deleteResearchObject(researchObjectId, researchObjectVersion);
					}
				}
			}
		}
		
		responseJson.put("check", check);
		return responseJson;
	}
	
	//---------------------------------- Delete Functions ------------------------------------------------//
	
	
	private Boolean deleteResearchObject (long researchObjectId, int researchObjectVersion){
		
		if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion) != null){
			
			ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
			ResearchObject researchObject = null;
			
			try {
				researchObject = researchObjectPersistence.findByPrimaryKey(pk);				
				ResearchObjectLocalServiceUtil.deleteResearchObject(researchObject);
			}
			catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
			
		}
			
		return !checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	
	//get all user id's (direct and over the projects), that are related with  a research object. 
	@SuppressWarnings("unchecked")
	public JSONObject getAllUserIdsByResearchObject(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		
		if (requestJson.containsKey("researchobjectid")){

			long researchObjectId = (long)requestJson.get("researchobjectid");
			int researchObjectVersion = 0;
			
			if (requestJson.containsKey("researchobjectversion"))
				researchObjectVersion = (int) requestJson.get("researchobjectversion");
			else
				researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId);
					
			if (ResearchObject_UserLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
				responseJson.put("direct", ResearchObject_UserLocalServiceUtil.getUserIdsByResearchObject(requestJson));
			
			if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
				responseJson.put("partofprojects", ProjectLocalServiceUtil.getUserIdsByResearchObject(requestJson));
		}else
			responseJson.put("ERROR","ERROR: The json need minimal 'researchobjectid'as long.");
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectsAsJsonById(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(getResearchObjectAsJsonById((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public JSONObject getResearchObjectAsJsonById(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"researchobjectid", "researchobjectversion","kindofresponse"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("researchobjectid")){ 
			ResearchObject researchObject = null;
			
			if ( requestJson.containsKey("researchobjectversion"))
				try {researchObject = researchObjectPersistence.findByIDAndVersion((long) requestJson.get("researchobjectid"), (int) ((long) requestJson.get("researchobjectversion")));} 
				catch (NoSuchResearchObjectException | SystemException e1) {responseJson.put("ERROR", "ERROR: This 'researchobjectid' with this 'researchobjectversion' don't exist.");	}
			else
				researchObject = getLatestResearchObjectById(Helper.getLongFromJson(requestJson, "researchobjectid"));

			if (researchObject != null)
				if (requestJson.containsKey("kindofresponse"))
					if((((String)requestJson.get("kindofresponse")).trim()).equals("extended"))
						responseJson = constructExtendedResearchObjectJson(researchObject);
					else
						if((((String)requestJson.get("kindofresponse")).trim()).equals("extraextended"))
							responseJson = constructExtraExtendedResearchObjectJson(researchObject);
						else
							responseJson = constructResearchObjectJson(researchObject);
				else
					responseJson = constructResearchObjectJson(researchObject);
			else
				responseJson.put("ERROR", "ERROR: This 'researchobjectid' don't exist.");
		}else
			responseJson.put("ERROR", "ERROR: No key 'researchobjectid' exist.");
	
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);
		
		_log.info(responseJson);
		responseJson = 	checkNullParent(responseJson);
		_log.info(responseJson);
		return responseJson;
	}

	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectAbsolutParent (JSONObject requestJson){

		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("researchobjectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
			if (requestJson.containsKey("researchobjectid")){
		responseJson=constructResearchObjectJson(getTopParent((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR","ERROR: Faile by find absolut parent");
		}
		else
			responseJson.put("ERROR","ERROR: No key 'researchobjectid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return checkNullParent(responseJson);
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectInformationByUserId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("userid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
	
		if (requestJson.containsKey("userid")){
			
			responseJson=getResearchObjectInformationByUserId(Helper.getLongFromJson(requestJson, "userid") );
			if (responseJson.toString().equals("{}"))
				responseJson.add("ERROR: Faile by find researchobjects of this userid "+(long) requestJson.get("userid"));
		}
		else
			responseJson.add("ERROR: No key 'userid' exist.");
			
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	public JSONArray getResearchObjectsByProjectId (long projectId){
		return ProjectLocalServiceUtil.getResearchObjectsByProjectId(projectId);
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectsByUserId(long userId){
		JSONArray researchObjectJSON = new JSONArray();
		List <ResearchObject> researchObjectList = null;
		researchObjectList =  ResearchObject_UserLocalServiceUtil.getResearchObjectsByUserId(userId);
		if (researchObjectList.size() >0)
			for (int i =0; i< researchObjectList.size();i++)
				researchObjectJSON.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectList.get(i)));
		else
			researchObjectJSON = null;
		return researchObjectJSON;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getResearchObjectsByParent (JSONObject requestJson){
		
	
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("researchobjectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("researchobjectid")){
			responseJson = constructResearchObjectsJson(getAllChildren((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("[]"))
				responseJson.add("ERROR: Faile research objects is no parent");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectParent (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("researchobjectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("researchobjectid")){
			responseJson=constructResearchObjectJson(getDirectParent((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR","ERROR: Faile by find parent");
		}
		else
			responseJson.put("ERROR","ERROR: No key 'researchobjectid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return checkNullParent(responseJson);
	}
	
		
	//----------------------------------- Get Functions --------------------------------------------------//
	
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JSONArray getResearchObjectInformationByUserId (long userId){
		
		JSONArray responseJson = new JSONArray();
		List responseList = (ArrayList) ResearchObjectFinderUtil.getResearchObjectInformationByUserId(userId);
		
		for(Object object:responseList){
			JSONObject json = new JSONObject ();
			Object[] arrayobject=(Object[])object;
			json.put("researchobjectid", (long)arrayobject[0]);
			json.put("researchobjectversion", (int)arrayobject[1]);
			json.put("researchobjectname", (String)arrayobject[2]);
			json.put("projectname", (String)arrayobject[3]);
			if ((String)arrayobject[4] !=null)
				json.put("status", (String)arrayobject[4]);
			else
				json.put("status", "on gfbio");
			responseJson.add(json);
		}
		
		return responseJson;
	}
	
	//
	public List <ResearchObject> getAllChildren (long researchObjectId){
		
		List <ResearchObject> workingList = new ArrayList<ResearchObject>(); 
		List <ResearchObject> childrenList = new ArrayList<ResearchObject>();
		workingList.addAll( getDirectChildren(researchObjectId));
		
		while (workingList.size () >0){
			researchObjectId = workingList.get(0).getResearchObjectID();
			childrenList.add(workingList.get(0));
			workingList.remove(0);
			if (getDirectChildren(researchObjectId) != null)
				workingList.addAll(getDirectChildren(researchObjectId));
		}
		return childrenList;
	}
	
	
	
	//
	public List <ResearchObject> getDirectChildren (long researchObjectId){
		
		List <ResearchObject> researchObjectList = null;
		try {
			researchObjectList = researchObjectPersistence.findByParentID(researchObjectId);
		} catch (SystemException e) {e.printStackTrace();}
		return researchObjectList;
	}
	
	
	//
	public ResearchObject getDirectParent(long researchObjectId) {
		
		ResearchObject researchObject = null;
		if (checkParentAttributById(researchObjectId))
			researchObject = (ResearchObject) ResearchObjectFinderUtil.getDirectParent(researchObjectId).get(0) ;
		return researchObject;
	}
	
	
	//
	public ResearchObject getLatestResearchObjectById(long researchObjectId) {
		
		ResearchObject researchObject = null;
		if (checkResearchObjectId(researchObjectId))
			researchObject = (ResearchObject) ResearchObjectFinderUtil.getLatestResearchObjectById(researchObjectId).get(0) ;
		return researchObject;
	}
	
	
	//
	public int getLatestVersionById (long researchObjectId){
		
		int researvchObjectVersion =0;
		if (checkResearchObjectId(researchObjectId))
			researvchObjectVersion = (int) ResearchObjectFinderUtil.getLatestVersionById(researchObjectId).get(0);
		return researvchObjectVersion;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = ResearchObjectFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	
	
	//
	public long getProjectIdByIds (long researchObjectId, int researchObjectVersion){
		
		long projectId =0;
		if (checkResearchObjectId(researchObjectId))
			projectId = (long) Project_ResearchObjectFinderUtil.getProjectIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion).get(0);
		return projectId;
	}
	
	
	//
	public List<ResearchObject> getResearchObjectById(long researchObjectId) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByResearchObjectID(researchObjectId);
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public List<Integer> getResearchObjectVersionsById(long researchObjectId){
		List <Integer> versionList =null;
		versionList = ResearchObjectFinderUtil.getResearchObjectVersionsById(researchObjectId);
		return versionList;
	}
	
	
	//get the research object version of the requestJson, or the latest version of the research object
	public int getResearchObjectVersionFromJson(JSONObject requestJson){
		int researchObjectVersion = 0;
		
		if (requestJson.containsKey("researchobjectversion"))
			if ((((requestJson.get("researchobjectversion")).getClass()).toString()).equals("class java.lang.Long"))
				researchObjectVersion = (int) ((long) requestJson.get("researchobjectversion"));
			else
				researchObjectVersion = (int) requestJson.get("researchobjectversion");
		else
			researchObjectVersion = getLatestVersionById((long)requestJson.get("researchobjectid"));	
		
		return researchObjectVersion;
	}
	

	//
	public ResearchObject getTopParent(long researchObjectId) {
		
		ResearchObject researchobject = null;
		researchobject = getDirectParent(researchObjectId);
		while (researchobject != null && (researchobject.getParentResearchObjectID()!=0 ) )
			researchobject = getDirectParent(researchobject.getResearchObjectID());
		return researchobject;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getUserIdsByIds (long researchObjectId, int researchObjectVersion){
		
		JSONArray userIdJson = new JSONArray();
		JSONObject requestJson = new JSONObject();
		requestJson.put("researchobjectid", researchObjectId);
		requestJson.put("researchobjectversion", researchObjectVersion);
		if (checkResearchObjectId(researchObjectId))
			userIdJson = ResearchObject_UserLocalServiceUtil.getUserIdsByResearchObject(requestJson);
		return userIdJson;
	}
	
	

		
	////////////////////////////////////// Helper Functions ////////////////////////////////////////////////////
	
	
	//
	public String checkForIgnoredParameter (Object[] objects, Set<String> keyList){

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
	public JSONObject checkHCCBackground (String tableName, String columnName, String label) {

	
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
		long rowId = ContentLocalServiceUtil.getRowIdByCellContent(tableName, columnName,  label);

		// if rowid == 0 then researchObjectType isn't in gfbio_metadate and so build a new entry with researchObjectType as new label and id with a new id
		if (rowId ==0){
			
			if(columnName.equals("id"))
				check = false;
			else{
				
				long headId =0;
				try {headId = HeadLocalServiceUtil.getHeadIdByTableName(tableName);
				} catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
				
				if (headId !=0){
					
					//columnName column
					long columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, columnName);
					if (columnId != 0){
						
						long contentId =0;
						rowId= ContentLocalServiceUtil.constructNewId();
						JSONObject buildResponseJson = ContentLocalServiceUtil.updateContent ( headId, columnId, 0, rowId, label,0);

						if (buildResponseJson.size() > 0)
							check = true;
						
						if (check){

							long tsContentId = Helper.getLongFromJson(buildResponseJson, "tscontentid");
							contentId = Helper.getLongFromJson(buildResponseJson, "contentid");
							
							//id
							columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "id");
							if (columnId != 0){
								contentId = contentId+1;
								buildResponseJson = ContentLocalServiceUtil.updateContent ( headId, columnId, contentId,rowId, "",tsContentId);
								if (buildResponseJson.size()  == 0)
									check = false;
							}
								
							if (check){
								
								//mail
								columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "mail");
								if (columnId != 0){
									contentId = contentId+1;
									buildResponseJson = ContentLocalServiceUtil.updateContent ( headId, columnId, contentId,rowId, "",tsContentId);
									if (buildResponseJson.size()  == 0)
										check = false;	
								}
										
								if (check){
										
									//orcid
									columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "orcid");
									if (columnId != 0){
										contentId = contentId+1;
										buildResponseJson = ContentLocalServiceUtil.updateContent ( headId, columnId, contentId,rowId, "",tsContentId);
										if (buildResponseJson.size()  == 0)
											check = false;	
									}
								}
							}
						}
					}
				}
			}
		}
		else{
			check = true;
		}

		if (check){
			long contentId =0;
			try {contentId = ContentLocalServiceUtil.getContentIdByTableIds(rowId, ColumnLocalServiceUtil.getColumnIdByNames(tableName, "id"));} 
			catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
			responseJson.put("contentid", contentId);
		}
		responseJson.put("check", check);
		
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject checkNullParent(JSONObject json){
		
		if (json.containsKey("parentresearchobjectid"))
			if (json.get("parentresearchobjectid")!= null)
				if ((long) json.get("parentresearchobjectid") == 0){
					json.remove("parentresearchobjectid");
					json.put("parentresearchobjectid", null);
				}
		return json;
	}
	
	
	//
	public Boolean checkParentAttributById(long researchObjectId){
		
		Boolean check = false;
		List <Boolean> checkList =  ResearchObjectFinderUtil.getCheckOfDirectParent(researchObjectId);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectId(long researchObjectId) {
		
		Boolean check = false;
		List <Boolean> checkList =  ResearchObjectFinderUtil.getCheckOfId(researchObjectId);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Boolean check = false;
		List <Boolean> checkList =  ResearchObjectFinderUtil.getCheckOfIdAndVersion(researchObjectId, researchObjectVersion);
		if (checkList.size()>0)
			check = checkList.get(0);
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
	public JSONObject constructResearchObjectJson (ResearchObject researchObject){
		JSONObject responseJson = new JSONObject();
		if (researchObject != null){
			
			String extendedDataSting = researchObject.getExtendeddata();
			
			JSONParser parser = new JSONParser();
			JSONObject extendeddataJson = new JSONObject();
			try {extendeddataJson = (JSONObject) parser.parse(extendedDataSting);}
			catch (ParseException e) {e.printStackTrace();}
			
			responseJson.put("description", researchObject.getDescription());
			responseJson.put("extendeddata", extendeddataJson);
			responseJson.put("label", researchObject.getLabel());
			responseJson.put("licenseid", researchObject.getLicenseID());	
			responseJson.put("metadataid", researchObject.getMetadataID());	
			responseJson.put("name", researchObject.getName());
			responseJson.put("parentresearchobjectid", researchObject.getParentResearchObjectID());
			responseJson.put("researchobjectid", researchObject.getResearchObjectID());
			responseJson.put("researchobjecttype", researchObject.getResearchObjectType());
			responseJson.put("researchobjectversion", researchObject.getResearchObjectVersion());
			responseJson.put("lastmodifieddate", researchObject.getLastModifiedDate().toString());
		}
				
		return checkNullParent(responseJson);
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructExtendedResearchObjectJson (ResearchObject researchObject){

		//basic research object data
		JSONObject responseJson = new JSONObject();
		responseJson = constructResearchObjectJson (researchObject);
		long researchObjectId = (long) responseJson.get("researchobjectid");
		int researchObjectVersion = (int)responseJson.get("researchobjectversion");
		
		//author ids
		if (ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_externalperson_researchobject", researchObjectId))
			try {responseJson.put("authorids", ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_externalperson_researchobject"), (Long.toString(researchObjectId))));}
			catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}		
		
		//author names
		if (responseJson.containsKey("authorids")){
			JSONArray idArray = (JSONArray) responseJson.get("authorids");
			JSONArray labelArray = new JSONArray();
			for (int i =0; i <idArray.size();i++)
				labelArray.add(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById((long) idArray.get(i) ),"name"));
			responseJson.put("authorname", labelArray);
		}

		//categories
		if (ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_category_researchobject",researchObjectId))
			try {responseJson.put("categoryids",ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_researchobject"), (Long.toString(researchObjectId))));}
			catch (NoSuchHeadException | SystemException e) {e.printStackTrace();}
	
		//licenses
		if (responseJson.containsKey("licenseid"))
			responseJson.put("licenselabel",ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById( (long) responseJson.get("licenseid")),"label"));

		//metadata
		if (responseJson.containsKey("metadataid"))
			responseJson.put("metadatalabel",ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById( (long) responseJson.get("metadataid")),"label"));

		//primary data
		if (PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
			JSONArray primaryDataIdList =  PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDatasIdsByResearchObject(responseJson);
			responseJson.put("primarydataids", primaryDataIdList);
		}
			
		
		//projects
		if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
			responseJson.put("projectids",Project_ResearchObjectLocalServiceUtil.getProjectIdsByResearchObject(responseJson));
		
		//submission
		if (SubmissionLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
			_log.info("open get submission gate");
			responseJson.put("submissionids", SubmissionLocalServiceUtil.getSubmissionIdsByResearchObjectIdAndVersion(responseJson));
		}
		
		//user
		if (ResearchObject_UserLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion) || true)
			responseJson.put("userids", getAllUserIdsByResearchObject(responseJson));
		
		_log.info(responseJson);
		
		return checkNullParent(responseJson);
	}
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructExtraExtendedResearchObjectJson (ResearchObject researchObject){
		
		JSONObject responseJson = new JSONObject();
		JSONObject researchObjectJson = constructExtendedResearchObjectJson (researchObject);
		responseJson.put("researchobject",  researchObjectJson);
		
		//parental research object information
		if (researchObjectJson.containsKey("parentresearchobjectid"))
			if (researchObjectJson.get("parentresearchobjectid")!=null){
				JSONObject requestJson = new JSONObject();
				requestJson.put("researchobjectid", Helper.getLongFromJson(researchObjectJson, "parentresearchobjectid"));
				responseJson.put("parentresearchobject",  getResearchObjectAsJsonById(requestJson));
			}
		
	//submission information
		if (researchObjectJson.containsKey("submissionids")){
			JSONArray responseArray =  SubmissionLocalServiceUtil.getSubmissionsByResearchObjectIdAndVersion(researchObjectJson);
			List <JSONObject> responseList= new ArrayList<JSONObject>();
			for (int i =0; i < responseArray.size();i++)
				if (((responseArray.get(i).getClass()).toString()).equals("class org.json.simple.JSONObject"))
					responseList.add((JSONObject) responseArray.get(i));
			responseJson.put("submissions",  responseList);
		}

		
		//license information
		if (researchObjectJson.containsKey("licenseid"))
			responseJson.put("license",  ContentLocalServiceUtil.getRowInformationByContentId(Helper.getLongFromJson(researchObjectJson, "licenseid")));
	
				//metadata information
		if (researchObjectJson.containsKey("metadataid"))
			responseJson.put("metadata",  ContentLocalServiceUtil.getRowInformationByContentId(Helper.getLongFromJson(researchObjectJson, "metadataid")));
		
		//project information
		if (researchObjectJson.containsKey("projectids")){
			JSONArray responseArray = ProjectLocalServiceUtil.getProjectById(Helper.getJsonArrayFromJson(researchObjectJson, "projectids"));
			List <JSONObject> responseList= new ArrayList<JSONObject>();
			for (int i =0; i < responseArray.size();i++)
				if (((responseArray.get(i).getClass()).toString()).equals("class org.json.simple.JSONObject"))
					responseList.add((JSONObject) responseArray.get(i));
			_log.info("3.5: "+responseList);
			responseJson.put("projects", responseList );
		}
		
		//primarydata
		if (researchObjectJson.containsKey("primarydataids")){
			JSONArray primarydataIdsArray = Helper.getJsonArrayFromJson(researchObjectJson, "primarydataids");
			List <JSONObject> responseList= new ArrayList<JSONObject>();
			for (int i =0; i < primarydataIdsArray.size();i++){
				JSONObject primaryData = new JSONObject();
				primaryData.put("primarydataid", primarydataIdsArray.get(i));
				primaryData = PrimaryDataLocalServiceUtil.getPrimaryDataById(primaryData);
				responseList.add((JSONObject) primaryData);
			}
			_log.info("3.75: "+responseList);
			responseJson.put("primarydatas", responseList );
		}
		
/*		List <JSONObject> responseList= new ArrayList<JSONObject>();
		//JSONArray primaryDataList = new JSONArray();
		for (int i =0; i < primaryDataIdList.size();i++){
			JSONObject primaryDataId = new JSONObject();
			primaryDataId.put("primarydataid", primaryDataIdList.get(i));
			//JSONObject primaryData = PrimaryDataLocalServiceUtil.getPrimaryDataById(primaryDataId);
			//primaryDataList.add(primaryData);
			responseList.add((JSONObject) PrimaryDataLocalServiceUtil.getPrimaryDataById(primaryDataId));
		}
		responseJson.put("primarydata", responseList);*/
		
		_log.info("4: "+responseJson);
		
		return responseJson;
	}
	
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray constructResearchObjectsJson (List <ResearchObject> researchObjectList){

		JSONArray json = new JSONArray();
		if (researchObjectList.size()>0)
			for (int i =0; i < researchObjectList.size();i++)
				json.add(constructResearchObjectJson(researchObjectList.get(i)));
		return json;
	}
	
		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createResearchObjectByJson(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(createResearchObjectByJson((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createResearchObjectByJson(JSONObject requestJson){
		
		Boolean check = false;
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"authornames", "authormail","authorid", "brokerobjectid","categoryid", "categoryids", "categorynames","description", "extendeddata", "label","licenseid","licenselabel", "metadataid", "metadatalabel", "name","parentresearchobjectid", "projectid", "researchobjecttype", "userid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if ((requestJson.containsKey("name") || requestJson.containsKey("label")) && requestJson.containsKey("description") && requestJson.containsKey("researchobjecttype") && (requestJson.containsKey("userid") || requestJson.containsKey("projectid"))){

			// mandatory
			String name  = "";
			String label = "";
			if (!(requestJson.containsKey("name")))
				name = ((String) requestJson.get("label")).trim();
			else
				name = ((String) requestJson.get("name")).trim();
			if (!(requestJson.containsKey("label")))
				label = ((String) requestJson.get("name")).trim();
			else
				label = ((String) requestJson.get("label")).trim();
			
			String description = requestJson.get("description").toString();
			
			if (name.length() <=Helper.getJiraTextfieldLimit() && label.length()<=Helper.getJiraTextfieldLimit() && description.length() <=Helper.getJiraTextareaLimit()){
			
				try {
					researchObjectId = createResearchObject(name, label, description);
					if (researchObjectId !=0)
						check = true;
				} catch (SystemException e) {e.printStackTrace();}
	
				
				if(requestJson.containsKey("researchobjecttype") && check)
					if (Helper.getStringFromJson(requestJson, "researchobjecttype").length()<=Helper.getJiraTextfieldLimit())
						check = updateResearchObjectType(researchObjectId, researchObjectVersion, ((String) requestJson.get("researchobjecttype")).trim());
					else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'researchobjecttype' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
						
	
				// optional
										
				if ((requestJson.containsKey("authormail") || requestJson.containsKey("authorid") || requestJson.containsKey("authornames")) && check){
				
					if ((requestJson.containsKey("authormail")))
						if (Helper.getStringFromJson(requestJson, "authormail").length()<=Helper.getJiraTextareaSmallLimit())
							check = updateAuthorIdById(researchObjectId, researchObjectVersion, Helper.getLongFromJson(requestJson, "authorid"));
						else{
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authormail' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
							check=false;
						}

					
					if(requestJson.containsKey("authormail") && check)
						if (Helper.getStringFromJson(requestJson, "authormail").length()<=Helper.getJiraTextareaSmallLimit())
							check = updateAuthorIdByColumn(researchObjectId, researchObjectVersion, Helper.getStringFromJson(requestJson, "authormail"),"mail");
						else{
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authormail' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
							check=false;
						}

					//by the length check we have a special character problem, so we don't have exact 2000 character
					if(requestJson.containsKey("authornames") && check)
						if (((requestJson.get("authornames").getClass()).toString()).equals("class java.lang.String"))
							if (Helper.getStringFromJson(requestJson, "authornames").length() <=Helper.getJiraTextareaSmallLimit())
								updateAuthorIdsByColumn(researchObjectId, researchObjectVersion, Helper.getJsonArrayFromString(Helper.getStringFromJson(requestJson, "authornames")),"name");
							else{
								responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authornames' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
								check=false;
							}
						else
							if (((JSONArray) requestJson.get("authornames")).size() <=Helper.getJiraTextareaSmallLimit())
								updateAuthorIdsByColumn(researchObjectId, researchObjectVersion, ((JSONArray) requestJson.get("authornames")),"name");
							else{
								responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authornames' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
								check=false;
							}
				}			
				else if (requestJson.containsKey("userid") && check){
					JSONObject userExtension = UserExtensionLocalServiceUtil.getUserExtentionById(requestJson);
					
					if (userExtension.containsKey("fullname"))
						if (!(((String) userExtension.get("fullname")).equals(null)))
								check = updateAuthorIdByColumn(researchObjectId, researchObjectVersion, (String) userExtension.get("fullname"),"name" );
						else
							check = false;
					else{
						check = false;
						if (userExtension.containsKey("ERROR"))
							responseJson.put("ERROR", (String) userExtension.get("ERROR"));
					}
				}
	
				
				if(requestJson.containsKey("categoryids") && check)
					if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
						updateCategoryIds(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categoryids"));
					else{
						if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class java.lang.String"))
							updateCategoryIds(researchObjectId, researchObjectVersion, Helper.getJsonArrayFromString(Helper.getStringFromJson(requestJson, "categoryids")));
					}
				else
					if (requestJson.containsKey("categoryid") && check)
						updateCategoryId(researchObjectId, researchObjectVersion, (long) requestJson.get("categoryid"));
					else
						if (requestJson.containsKey("categorynames") && check)
							if ((((requestJson.get("categorynames")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
								if (Helper.getStringFromJson(requestJson, "categorynames").length() <=Helper.getJiraTextfieldLimit())
									updateCategoryNames(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categorynames"));
								else{
									responseJson.put("ERROR", "ERROR: To create a Research Object, because 'categorynames' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
									check=false;
								}
							else
								if ((((requestJson.get("categorynames")).getClass()).toString()).equals("class java.lang.String"))
									if (Helper.getStringFromJson(requestJson, "categorynames").length() <=Helper.getJiraTextfieldLimit())
										updateCategoryNames(researchObjectId, researchObjectVersion, Helper.getJsonArrayFromString(Helper.getStringFromJson(requestJson, "categorynames")));
									else{
										responseJson.put("ERROR", "ERROR: To create a Research Object, because 'categorynames' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
										check=false;
									}
			
				
						
				if(requestJson.containsKey("extendeddata") && check){
					JSONObject extendedDataJson = (JSONObject) requestJson.get("extendeddata");
					Boolean extendedDataCheck = true;
					if(extendedDataJson.containsKey("datacollectiontime") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "datacollectiontime")).length() >Helper.getJiraTextareaSmallLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'datacollectiontime' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}
					if(extendedDataJson.containsKey("publications") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "publications")).length() >Helper.getJiraTextareaSmallLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'publications' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}
					if(extendedDataJson.containsKey("embargo") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "embargo")).length() >Helper.getJiraTextfieldLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'embargo' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}
							
					if (extendedDataCheck)
						updateExtendedData(researchObjectId, researchObjectVersion, Helper.getStringFromJson(requestJson, "extendeddata"));
					else
						check = false;
				}
				
				if (requestJson.containsKey("licenseid") && check)
					check = updateLicenseId(researchObjectId, researchObjectVersion, Helper.getLongFromJson(requestJson, "licenseid"));

				
				if(requestJson.containsKey("licenselabel") && check)
					if ((Helper.getStringFromJson(requestJson, "licenselabel")).length() <=Helper.getJiraTextfieldLimit())
						check = updateLicenseId(researchObjectId,  researchObjectVersion, Helper.getStringFromJson(requestJson, "licenselabel"));
					else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'licenselabel' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
								
				if (requestJson.containsKey("metadataid") && check)
					check = updateMetadataId(researchObjectId, researchObjectVersion, Helper.getLongFromJson(requestJson, "metadataid"));
				
				if (requestJson.containsKey("metadatalabel") && check)
					if ((Helper.getStringFromJson(requestJson, "metadatalabel")).length() <=Helper.getJiraTextfieldLimit())
						check = updateMetadataId(researchObjectId, researchObjectVersion, Helper.getStringFromJson(requestJson, "metadatalabel"));
					else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'metadatalabel' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}

				if (requestJson.containsKey("parentresearchobjectid") && check)
					check = updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, Helper.getLongFromJson(requestJson, "parentresearchobjectid"));
				
				if (requestJson.containsKey("projectid") && check)
					check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(Helper.getLongFromJson(requestJson, "projectid"), researchObjectId, researchObjectVersion);
				
				if (requestJson.containsKey("userid") && check)
					check = ResearchObject_UserLocalServiceUtil.updateResearchObjectUser(researchObjectId, researchObjectVersion, Helper.getLongFromJson(requestJson, "userid"), "owner");
					
				if (check){
					responseJson.put("researchobjectid", researchObjectId);
					responseJson.put("researchobjectversion", researchObjectVersion);
					if (requestJson.containsKey("brokerobjectid")) 
						responseJson.put("brokerobjectid", requestJson.get("brokerobjectid"));
				}else{
					responseJson.put("ERROR:", "ERROR: create research object is failed.");
					check=false;
				}
			}else{
				String errorString = "ERROR: To create a Research Object, because " ;
				if (name.length() >Helper.getJiraTextfieldLimit())
					errorString = errorString.concat("'name' has more as ").concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character, ") ;
				if (label.length()>Helper.getJiraTextfieldLimit())
					errorString = errorString.concat("'label' has more as ").concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character, ") ;
				if (description.length() >Helper.getJiraTextareaLimit())
					errorString = errorString.concat("'description' has more as ").concat(String.valueOf(Helper.getJiraTextareaLimit())).concat(" character, ") ;
				errorString = errorString.substring(0, errorString.length()-2).concat(".");
				responseJson.put("ERROR", errorString);
			}
		}else{
			String errorString = "ERROR: To create a Research Object, the json need minimal 'name' or 'label' and 'description', 'researchobjecttype' as Strings and 'projectid' or 'userid' as long." ;
			if (!requestJson.containsKey("name"))
				if (!requestJson.containsKey("label"))
					errorString = errorString.concat(" 'label' or 'name,");
			if (!requestJson.containsKey("description"))
				errorString = errorString.concat(" 'description',");
			if (!requestJson.containsKey("researchobjecttype"))
				errorString = errorString.concat(" 'researchobjecttype',");
			if (!requestJson.containsKey("userid"))
				if (!requestJson.containsKey("projectid"))
					errorString = errorString.concat(" 'userid' or 'projectid,");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct.");
			responseJson.put("ERROR", errorString);
		}
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateResearchObjectByJson(JSONArray requestJson){

		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(updateResearchObjectByJson((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
		
	
	//
	@SuppressWarnings({ "unchecked", "unused" })
	public JSONObject updateResearchObjectByJson(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"authormail", "authornames", "authorid", "brokerobjectid", "categoryid", "categoryids", "categorynames", "description", "extendeddata", "label","licenseid", "licenselabel", "metadataid", "metadatalabel", "name", "researchobjectid","parentresearchobjectid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("researchobjectid")){
	
			long researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			int researchObjectVersion = getLatestVersionById(researchObjectId);
			int startVersion = researchObjectVersion;
				
			if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
					
				Boolean check = true;
				Boolean changeCheck = false;
				ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
				ResearchObject researchObject = null;
				try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
				catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}
				ResearchObject startResearchObject = researchObject;
						
				//optional parameter
				
				//author
				if(requestJson.containsKey("authornames") && check){
					if (Helper.getStringFromJson(requestJson, "authornames").length() <=Helper.getJiraTextareaSmallLimit()){
						researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
						check = updateAuthorIdsByColumn(researchObjectId, researchObjectVersion,  Helper.getJsonArrayFromJson(requestJson, "authornames"), "name");
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authornames' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						check=false;
					}
				}else
					if(requestJson.containsKey("authorid") && check){
						long authorId = Helper.getLongFromJson(requestJson, "authorid");
						researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
						check = updateAuthorIdById(researchObjectId, researchObjectVersion, authorId);
					}else
						if(requestJson.containsKey("authormail") && check){
							if (Helper.getStringFromJson(requestJson, "authormail").length()<=Helper.getJiraTextareaSmallLimit()){
								String authorMail = Helper.getStringFromJson(requestJson, "authormail");
								researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
								check = updateAuthorIdByColumn(researchObjectId, researchObjectVersion, authorMail, "mail");
							}else{
								responseJson.put("ERROR", "ERROR: To create a Research Object, because 'authormail' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
								check=false;
							}
						}

				//category
				if(requestJson.containsKey("categoryids") && check){
					researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
					check = updateCategoryIds(researchObjectId, researchObjectVersion, Helper.getJsonArrayFromJson(requestJson, "categoryids"));
				}else
					if(requestJson.containsKey("categoryid") && check){
						long categoryId = Helper.getLongFromJson(requestJson, "categoryid");
						researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
						check = updateCategoryId(researchObjectId, researchObjectVersion, categoryId);
					}else
						if (requestJson.containsKey("categorynames") && check){
							if (Helper.getStringFromJson(requestJson, "categorynames").length() <=Helper.getJiraTextfieldLimit()){
								JSONArray categoryIds = Helper.getJsonArrayFromJson(requestJson, "categorynames");
								researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
								check = updateCategoryNames(researchObjectId, researchObjectVersion, categoryIds);
							}else{
								responseJson.put("ERROR", "ERROR: To create a Research Object, because 'categorynames' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
								check=false;
							}
						}

				//description
				if(requestJson.containsKey("description") && check){
					String description = Helper.getStringFromJson(requestJson, "description");
					if (description.length()<=Helper.getJiraTextareaLimit()){
						if (!description.equals(researchObject.getDescription())){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateDescription(researchObjectId, researchObjectVersion, description);
						}
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'description' has more as ".concat("String.valueOf(Helper.getJiraTextareaLimit())").concat(" character. ") );
						check=false;
					}
				}

				//extendedData
				if(requestJson.containsKey("extendeddata") && check){
					String extendedData = Helper.getStringFromJson(requestJson, "extendeddata");
					JSONObject extendedDataJson = Helper.getJsonObjectFromJson(requestJson, "extendeddata");
					Boolean extendedDataCheck = true;
					if(extendedDataJson.containsKey("datacollectiontime") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "datacollectiontime")).length() >Helper.getJiraTextareaSmallLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'datacollectiontime' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}

					if(extendedDataJson.containsKey("publications") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "publications")).length() >Helper.getJiraTextareaSmallLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'publications' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}
					if(extendedDataJson.containsKey("embargo") && extendedDataCheck)
						if ((Helper.getStringFromJson(extendedDataJson, "embargo")).length() >Helper.getJiraTextfieldLimit()){
							extendedDataCheck = false;
							responseJson.put("ERROR", "ERROR: To create a Research Object, because 'embargo' has more as ".concat(String.valueOf(Helper.getJiraTextareaSmallLimit())).concat(" character. ") );
						}
							
					if (extendedDataCheck){
						if (!extendedData.equals(researchObject.getExtendeddata())){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateExtendedData(researchObjectId, researchObjectVersion, extendedData);
						}
					}else
						check = false;
				}

				//label
				if(requestJson.containsKey("label") && check){
					String label = Helper.getStringFromJson(requestJson, "label");
					if (label.length()<=Helper.getJiraTextfieldLimit()){
						if (!label.equals(researchObject.getLabel())){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateLabel(researchObjectId, researchObjectVersion, label);
						}
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'label' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
				}

				//license
				if(requestJson.containsKey("licenselabel") && check){
					String licenseLabel = Helper.getStringFromJson(requestJson, "licenselabel");
					if (licenseLabel.length() <=Helper.getJiraTextfieldLimit()){
						if ((ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_license", "label", licenseLabel), "id").trim()).equals(String.valueOf(researchObject.getLicenseID()))){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateLicenseId(researchObjectId,  researchObjectVersion, licenseLabel);
						}
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'licenselabel' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
				}else
					if(requestJson.containsKey("licenseid") && check){
						long licenseId = Helper.getLongFromJson(requestJson, "licenseid");
						if (licenseId !=researchObject.getLicenseID()){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateLicenseId(researchObjectId, researchObjectVersion, licenseId);
						}
					}

				//metadata
				if(requestJson.containsKey("metadatalabel") && check){
					String metadataeLabel = Helper.getStringFromJson(requestJson, "metadatalabel");

					if (metadataeLabel.length() <=Helper.getJiraTextfieldLimit()){
						if (!(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdByCellContent("gfbio_metadata", "label", metadataeLabel), "id").trim()).equals(String.valueOf(researchObject.getMetadataID()))){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateMetadataId(researchObjectId,  researchObjectVersion, metadataeLabel);
						}
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'metadatalabel' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
				}else
					if(requestJson.containsKey("metadataid") && check){
						long metadataId = Helper.getLongFromJson(requestJson, "metadataid");
						if (metadataId !=researchObject.getMetadataID()){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateMetadataId(researchObjectId, researchObjectVersion, metadataId);
						}
					}

				//name
				if(requestJson.containsKey("name") && check){
					String name = Helper.getStringFromJson(requestJson, "name");
					if (name.length() <=Helper.getJiraTextfieldLimit()){
						if (!name.equals(researchObject.getName())){
							researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
							check = updateName(researchObjectId, researchObjectVersion, name);
						}	
					}else{
						responseJson.put("ERROR", "ERROR: To create a Research Object, because 'name' has more as ".concat(String.valueOf(Helper.getJiraTextfieldLimit())).concat(" character. ") );
						check=false;
					}
				}

				//parent
				if(requestJson.containsKey("parentresearchobjectid") && check){
					long parentId = Helper.getLongFromJson(requestJson, "parentresearchobjectid");
					if (parentId !=researchObject.getParentResearchObjectID()){
						researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion, startVersion);
						check = updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, parentId);
					}
				}
			
				if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion) && !check && researchObjectVersion != startVersion){
					JSONObject deleteJson = new JSONObject();
					deleteJson.put("researchobjectid", researchObjectId);
					deleteJson.put("researchobjectversion", researchObjectVersion);
					deleteResearchObject (deleteJson);
				}
				
				if (check){
					responseJson.put("researchobjectid", researchObjectId);
					responseJson.put("researchobjectversion", researchObjectVersion);
					if (requestJson.containsKey("brokerobjectid")) 
						responseJson.put("brokerobjectid", requestJson.get("brokerobjectid"));
				}else
					responseJson.put("ERROR:", "ERROR: The update Research Object with ID "+ researchObjectId +" is not fully completed");
			}else
				responseJson.put("ERROR:", "ERROR: Research Object ID "+ researchObjectId +" has no entry in the database");
		} else
			if ((requestJson.containsKey("name") || requestJson.containsKey("label")) && requestJson.containsKey("description") && requestJson.containsKey("researchobjecttype") && (requestJson.containsKey("userid") || requestJson.containsKey("projectid")))
				responseJson = createResearchObjectByJson(requestJson);
			else
				responseJson.put("ERROR", "ERROR: The json need minimal a 'researchobjectid'.");
					
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//

	
	//
	private  long createResearchObject (String name, String label, String description) throws SystemException{

		long researchObjectId = 0;
		int researchObjectVersion = 1;
		
		researchObjectId =  updateKernelResearchObject(researchObjectId, researchObjectVersion, name, label, description) ;
		
		return researchObjectId;
	}
	
	//
	private long updateKernelResearchObject(long researchObjectId, int researchObjectVersion, String name, String label, String description)  {

		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		long check =0;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (NoSuchResearchObjectException | SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");}

		if (researchObject == null){
			pk = new ResearchObjectPK(constructNewId(), 1);
			researchObject = researchObjectPersistence.create(pk);
		}
		researchObject.setName(name);
		researchObject.setLabel(label);
		researchObject.setDescription(description);
		researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
		

	//
	private Boolean AddAuthorIdById (long researchObjectId, int researchObjectVersion, long authorId){
		
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_externalperson", "id", Long.toString(authorId));
		if ((boolean) hccJson.get("check"))
			check = HeadLocalServiceUtil.updateInterfaceTableWithContent("gfbio_researchobject", researchObjectId, "gfbio_externalperson", authorId);
		return check;
	}
	
	
	//
	private Boolean AddCategoryId (long researchObjectId, int researchObjectVersion, long categorieId){
		Boolean check = false;
		
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_category", "id", Long.toString(categorieId));
		if ((boolean) hccJson.get("check"))
			check = HeadLocalServiceUtil.updateInterfaceTableWithContent("gfbio_researchobject", researchObjectId, "gfbio_category", categorieId);
		return check;
	}

	
	//
	private Boolean updateAuthorIdByColumn (long researchObjectId, int researchObjectVersion, String authorColumn, String columnName){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_externalperson", columnName, authorColumn);
		if ((boolean) hccJson.get("check"))
			check =  updateAuthorIdById(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	private Boolean updateAuthorIdById (long researchObjectId, int researchObjectVersion, long authorId){
		
		ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_externalperson_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
		return AddAuthorIdById (researchObjectId, researchObjectVersion, authorId);
	}
	

	//
	private Boolean updateAuthorIdsByColumn (long researchObjectId, int researchObjectVersion, JSONArray authorColumns, String columnName){
		Boolean check = false;
		ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_externalperson_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
		if (authorColumns.size() ==0)
			check = true;
		else
			for (int i=0; i < authorColumns.size();i++){
				JSONObject hccJson= new JSONObject();
				hccJson = checkHCCBackground("gfbio_externalperson", columnName, ((String) authorColumns.get(i)).trim());
				if ((boolean) hccJson.get("check"))
					check =  AddAuthorIdById(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));
			}
		return check;
	}
	
	
	//				
	private Boolean updateCategoryId (long researchObjectId, int researchObjectVersion, long categorieId){
		ContentLocalServiceUtil.deleteRelationContentOfCategoryWithSpecificType("research field", researchObjectId, "gfbio_category_researchobject");
		return AddCategoryId(researchObjectId, researchObjectVersion, categorieId);
	}
	
	
	//
	private Boolean updateCategoryIds (long researchObjectId, int researchObjectVersion, JSONArray categorieIds){
		Boolean check = false;
		ContentLocalServiceUtil.deleteRelationContentOfCategoryWithSpecificType("research field", researchObjectId, "gfbio_category_researchobject");

		if (categorieIds.size() ==0)
			check = true;
		else
			for (int i=0; i < categorieIds.size();i++){
				JSONObject hccJson= new JSONObject();
				if (((categorieIds.get(i).getClass()).toString()).equals("class java.lang.String"))
					hccJson = checkHCCBackground("gfbio_category", "id", (String) categorieIds.get(i));
				else
					if (((categorieIds.get(i).getClass()).toString()).equals("class java.lang.Long"))
						hccJson = checkHCCBackground("gfbio_category", "id", Long.toString((long) categorieIds.get(i)));
	
				if ((boolean) hccJson.get("check"))
					check =  AddCategoryId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));
			}
		
		return check;
	}
	
	
	//
	private Boolean updateCategoryNames (long researchObjectId, int researchObjectVersion, JSONArray categorieNames){
		Boolean check = false;
		
		ContentLocalServiceUtil.deleteRelationContentOfCategoryWithSpecificType("research field", researchObjectId, "gfbio_category_researchobject");
		if (categorieNames.size() ==0)
			check = true;
		else
			for (int i=0; i < categorieNames.size();i++){
				JSONObject hccJson= new JSONObject();
				hccJson = checkHCCBackground("gfbio_category", "name", (String) categorieNames.get(i));
	
				if ((boolean) hccJson.get("check"))
					check =  AddCategoryId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));
			}
		return check;
	}
	
	//
	private Boolean updateExtendedData (long researchObjectId, int researchObjectVersion, String extendedData){
		
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setExtendeddata(extendedData);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	private Boolean updateDescription (long researchObjectId, int researchObjectVersion, String description){
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setDescription(description);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	private Boolean updateLabel (long researchObjectId, int researchObjectVersion, String label){
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setLabel(label);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}


	//
	private Boolean updateLicenseId (long researchObjectId, int researchObjectVersion, String licenseLabel){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_license", "label", licenseLabel);
		
		if ((boolean) hccJson.get("check"))
			check =  updateLicenseId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	private Boolean updateLicenseId (long researchObjectId, int researchObjectVersion, long licenseId){
		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		
		try {researchObject = getResearchObject(pk);}
		catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (researchObject!=null){
			researchObject.setLicenseID(licenseId);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));

			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		
		return check;
	}
	
		
	//
	private Boolean updateMetadataId (long researchObjectId, int researchObjectVersion, String metadataLabel){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_metadata", "label", metadataLabel);
		
		if ((boolean) hccJson.get("check"))
			check =  updateMetadataId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	private Boolean updateMetadataId (long researchObjectId, int researchObjectVersion, long metadataId){
		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		
		try {researchObject = getResearchObject(pk);}
		catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (researchObject!=null){
			researchObject.setMetadataID(metadataId);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		
		return check;
	}
	
	
	//
	private Boolean updateName (long researchObjectId, int researchObjectVersion, String name){
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setName(name);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	private Boolean updateParentResearchObjectIdByIds(long researchObjectId, int researchObjectVersion, long parentResearchObjectId){
	
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setParentResearchObjectID(parentResearchObjectId);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	private Boolean updateResearchObjectType (long researchObjectId, int researchObjectVersion, String researchObjectType){
		
		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		
		try {researchObject = getResearchObject(pk);}
		catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (researchObject!=null){
			researchObject.setResearchObjectType(researchObjectType);
			researchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	private int updateResearchObjectVersion (long researchObjectId){

		int oldResearchObjectVersion = getLatestVersionById(researchObjectId);
		int newResearchObjectVersion = oldResearchObjectVersion+1;
		JSONObject oldIdsJson = new JSONObject();
		oldIdsJson.put("researchobjectid",researchObjectId);
		oldIdsJson.put("researchobjectversion",oldResearchObjectVersion);
		
		
		if (checkResearchObjectIdAndVersion(researchObjectId, oldResearchObjectVersion)){
		
			Boolean check = false;
			ResearchObject researchObject = null;			
			ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, oldResearchObjectVersion);
			try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
			catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
			
			if(researchObject != null){
	
				pk = new ResearchObjectPK(researchObjectId, newResearchObjectVersion);
				ResearchObject newResearchObject = (ResearchObject) researchObject.clone();
				
				// table new values
				newResearchObject.setResearchObjectVersion(newResearchObjectVersion);
				newResearchObject.setLastModifiedDate(new Timestamp(new Date().getTime()));

				try {
					super.updateResearchObject(newResearchObject);
					check = true;
				} catch (SystemException e) {e.printStackTrace();}
				
				// project - research object
				if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, oldResearchObjectVersion) && check){
					long projectId =0;
					projectId = getProjectIdByIds(researchObjectId, oldResearchObjectVersion);
					
					if (projectId !=0)
						check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, researchObjectId, newResearchObjectVersion);
				}
					
				// research object - user
				if (ResearchObject_UserLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, oldResearchObjectVersion) && check){
					JSONArray userIdJson = getUserIdsByIds(researchObjectId, oldResearchObjectVersion);
					for(int i =0;i < userIdJson.size();i++)
						check = ResearchObject_UserLocalServiceUtil.updateResearchObjectVersion((long)userIdJson.get(i), researchObjectId,  oldResearchObjectVersion, newResearchObjectVersion);
				}
				
				
				// primary data - research object
				if (PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, oldResearchObjectVersion) && check){
					JSONArray primaryDataIdJson = PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDatasIdsByResearchObject(oldIdsJson);
					for(int i =0;i < primaryDataIdJson.size();i++)
						check = PrimaryData_ResearchObjectLocalServiceUtil.updateResearchObjectVersion((long)primaryDataIdJson.get(i), researchObjectId,  oldResearchObjectVersion, newResearchObjectVersion);
				}
	
				
			}
		}
		return newResearchObjectVersion;
	}
	
	
	//
	private int updateResearchObjectVersion (long researchObjectId, int researchObjectVersion, int oldResearchObjectVersion){

		if (researchObjectVersion ==oldResearchObjectVersion)
			researchObjectVersion = updateResearchObjectVersion (researchObjectId);

		return researchObjectVersion;
	}

}




