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


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.NoSuchContentException;
import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ColumnLocalServiceUtil;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObject_UserLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
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
				researchObject = getLatestResearchObjectById((long) requestJson.get("researchobjectid"));

			if (researchObject != null)
				if (requestJson.containsKey("kindofresponse"))
					if((((String)requestJson.get("kindofresponse")).trim()).equals("extended"))
						responseJson = constructExtendedResearchObjectJson(researchObject);
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
				
		return checkNullParent(responseJson);
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
			
			responseJson=getResearchObjectInformationByUserId((long) requestJson.get("userid"));
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
						try {rowId= ContentLocalServiceUtil.constructNewId();
						} catch (SystemException e) {e.printStackTrace();}
						check = ContentLocalServiceUtil.updateContent (0, headId, columnId, rowId, label);
						
						//id
						columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "id");
						if (columnId != 0)
							check = ContentLocalServiceUtil.updateContent (0, headId, columnId, rowId, "");
						
						//mail
						columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "mail");
						if (columnId != 0)
							check = ContentLocalServiceUtil.updateContent (0, headId, columnId, rowId, "");
						
						//orcid
						columnId = ColumnLocalServiceUtil.getColumnIdByNames(tableName, "orcid");
						if (columnId != 0)
							check = ContentLocalServiceUtil.updateContent (0, headId, columnId, rowId, "");
					}
				}
			}
		}
		else{
			check = true;
		}
		
		if (check){
			long contentId =0;
			try {contentId = ContentLocalServiceUtil.getContentIdByTableIds(rowId, ColumnLocalServiceUtil.getColumnIdByNames(tableName, "id"));
			} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}
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
	@SuppressWarnings("unchecked")
	public JSONObject constructResearchObjectJson (ResearchObject researchObject){
		JSONObject responseJson = new JSONObject();
		if (researchObject != null){
			responseJson.put("description", researchObject.getDescription());
			responseJson.put("extendeddata", researchObject.getExtendeddata());
			responseJson.put("label", researchObject.getLabel());
			responseJson.put("licenseid", researchObject.getLicenseID());	
			responseJson.put("metadataid", researchObject.getMetadataID());	
			responseJson.put("name", researchObject.getName());
			responseJson.put("parentresearchobjectid", researchObject.getParentResearchObjectID());
			responseJson.put("researchobjectid", researchObject.getResearchObjectID());
			responseJson.put("researchobjecttype", researchObject.getResearchObjectType());
			responseJson.put("researchobjectversion", researchObject.getResearchObjectVersion());		
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
		if (PrimaryData_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
			responseJson.put("primarydataids", PrimaryData_ResearchObjectLocalServiceUtil.getPrimaryDatasIdsByResearchObject(responseJson));
		
		//projects
		if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
			responseJson.put("projectids",Project_ResearchObjectLocalServiceUtil.getProjectIdsByResearchObject(responseJson));
		
		//submission
		if (SubmissionLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
			responseJson.put("submissionids", SubmissionLocalServiceUtil.getSubmissionIdsByResearchObjectIdAndVersion(responseJson));
		
		//user
		if (ResearchObject_UserLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion) || true)
			responseJson.put("userids", getAllUserIdsByResearchObject(responseJson));
		
		return checkNullParent(responseJson);
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
			
			try {
				researchObjectId = createResearchObject(name, label, description);
				if (researchObjectId !=0)
					check = true;
			} catch (SystemException e) {e.printStackTrace();}
			
			
			if(requestJson.containsKey("researchobjecttype") && check){
				check = updateResearchObjectType(researchObjectId, researchObjectVersion, ((String) requestJson.get("researchobjecttype")).trim());
			}

			
			// optional
						
			if ((requestJson.containsKey("authormail") || requestJson.containsKey("authorid") || requestJson.containsKey("authornames")) && check){
			
				if ((requestJson.containsKey("authormail")))
						check = updateAuthorId(researchObjectId, researchObjectVersion, (long) requestJson.get("authorid"));
				
				if(requestJson.containsKey("authormail") && check)
					check = updateAuthorId(researchObjectId, researchObjectVersion, ((String) requestJson.get("authormail")).trim());
						
				if(requestJson.containsKey("authornames") && check)
					if (((requestJson.get("authornames").getClass()).toString()).equals("class java.lang.String")){
						System.out.println(requestJson.get("authornames"));
						JSONParser parser = new JSONParser();
						JSONArray parseJson = new JSONArray();
						try {parseJson = (JSONArray) parser.parse((String) requestJson.get("authornames"));}
						catch (ParseException e) {e.printStackTrace();}
						System.out.println(parseJson);
						updateAuthorIds(researchObjectId, researchObjectVersion, parseJson);
					}else
						updateAuthorIds(researchObjectId, researchObjectVersion, ((JSONArray) requestJson.get("authornames")));
			}				
			else if (requestJson.containsKey("userid") && check)
				check = updateAuthorId(researchObjectId, researchObjectVersion, (long) requestJson.get("userid"));
			
			if(requestJson.containsKey("categoryids") && check)
				if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
					updateCategoryIds(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categoryids"));
				else{
					if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class java.lang.String")){
						JSONParser parser = new JSONParser();
						JSONArray parseJson = new JSONArray();
						try {parseJson = (JSONArray) parser.parse((String) requestJson.get("categoryids"));}
						catch (ParseException e) {e.printStackTrace();}
						updateCategoryIds(researchObjectId, researchObjectVersion, parseJson);
					}
				}
			else
				if (requestJson.containsKey("categoryid") && check)
					updateCategoryId(researchObjectId, researchObjectVersion, (long) requestJson.get("categoryid"));
				else
					if (requestJson.containsKey("categorynames") && check)
						if ((((requestJson.get("categorynames")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
							updateCategoryNames(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categorynames"));
						else
							if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class java.lang.String")){
								JSONParser parser = new JSONParser();
								JSONArray parseJson = new JSONArray();
								try {parseJson = (JSONArray) parser.parse((String) requestJson.get("categorynames"));}
								catch (ParseException e) {e.printStackTrace();}
								updateCategoryNames(researchObjectId, researchObjectVersion, parseJson);
							}
			
						
			
			if(requestJson.containsKey("extendeddata") && check)
				if (((requestJson.get("extendeddata")).getClass()).equals("String"))
					updateExtendedData(researchObjectId, researchObjectVersion, ((String) requestJson.get("extendeddata")).trim());
				else
					updateExtendedData(researchObjectId, researchObjectVersion, ((((JSONObject) requestJson.get("extendeddata"))).toJSONString()).trim());
			
			if(requestJson.containsKey("licenselabel") && check)
				check = updateLicenseId(researchObjectId,  researchObjectVersion, ((String) requestJson.get("licenselabel")).trim());
			
			if (requestJson.containsKey("licenseid") && check)
				check = updateLicenseId(researchObjectId, researchObjectVersion, (long) requestJson.get("licenseid"));
			
			if (requestJson.containsKey("metadataid") && check)
				check = updateMetadataId(researchObjectId, researchObjectVersion, (long) requestJson.get("metadataid"));
			
			if (requestJson.containsKey("metadatalabel") && check)
				check = updateMetadataId(researchObjectId, researchObjectVersion, (String) requestJson.get("metadatalabel"));
			
			if (requestJson.containsKey("parentresearchobjectid") && check)
				check = updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, (long) requestJson.get("parentresearchobjectid"));

			if (requestJson.containsKey("projectid") && check)
				check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) requestJson.get("projectid"), researchObjectId, researchObjectVersion);

			if (requestJson.containsKey("userid") && check)
				check = ResearchObject_UserLocalServiceUtil.updateResearchObjectUser(researchObjectId, researchObjectVersion, (long) requestJson.get("userid"), "owner");
			

	
			if (check){
				responseJson.put("researchobjectid", researchObjectId);
				responseJson.put("researchobjectversion", researchObjectVersion);
				if (requestJson.containsKey("brokerobjectid")) 
					responseJson.put("brokerobjectid", requestJson.get("brokerobjectid"));
			}else
				responseJson.put("ERROR:", "ERROR: create research object is failed.");
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
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
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
		String [] keySet = {"authormail","authornames","authorid", "brokerobjectid","categoryid", "categoryids", "categorynames", "description","extendeddata", "label","licenseid","licenselabel", "name", "researchobjectid", "userid", "submittertype"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("researchobjectid")){
	
			if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("extendeddata")){
				
				long researchObjectId = (long) requestJson.get("researchobjectid");
				int researchObjectVersion = getLatestVersionById(researchObjectId);
				
				if (ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
					
					Boolean check = false;
					Boolean changeCheck = false;
					ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
					ResearchObject researchObject = null;

					try {
						researchObject = researchObjectPersistence.findByPrimaryKey(pk);
					} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}
					
					String name = ((String) requestJson.get("name")).trim();
					String label = ((String) requestJson.get("label")).trim();
					String extendedData = requestJson.get("extendeddata").toString();
						
					if ((!((((String) requestJson.get("description")).trim()).equals(researchObject.getDescription())) || name.equals(researchObject.getName())) || !(label.equals(researchObject.getLabel())) || !(extendedData.equals(researchObject.getExtendeddata()))){
						researchObjectVersion = updateResearchObjectVersion(researchObjectId, researchObjectVersion);
					}
					
					researchObjectId = updateKernelResearchObject(researchObjectId, researchObjectVersion, name, label, extendedData);
					
					if (researchObjectId>0){
						
						check = updateResearchObjectType(researchObjectId, researchObjectVersion,ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById(researchObject.getMetadataID()), "label"));
						
						if (check)
							check = updateParentResearchObjectIdByIds (researchObjectId, researchObjectVersion,researchObject.getParentResearchObjectID());

						if(requestJson.containsKey("description") && check)
							updateDescription(researchObjectId, researchObjectVersion, ((String) requestJson.get("description")).trim());
					
						//no check request, because: if exists a license-ro-relation, than check is false 
						if(requestJson.containsKey("licenselabel") && check)
							updateLicenseId(researchObjectId,  researchObjectVersion, ((String) requestJson.get("licenselabel")).trim());
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if (requestJson.containsKey("licenseid") && check)
							updateLicenseId(researchObjectId, researchObjectVersion, (long) requestJson.get("licenseid"));
								
						//no check request, because: if exists a license-ro-relation, than check is false 
						if(requestJson.containsKey("authornames") && check)
							if (((requestJson.get("authornames").getClass()).toString()).equals("class java.lang.String")){
								JSONParser parser = new JSONParser();
								JSONArray parseJson = new JSONArray();
								try {parseJson = (JSONArray) parser.parse((String) requestJson.get("authornames"));}
								catch (ParseException e) {e.printStackTrace();}
								updateAuthorIds(researchObjectId, researchObjectVersion, parseJson);
							}else
								updateAuthorIds(researchObjectId, researchObjectVersion, ((JSONArray) requestJson.get("authornames")));
							
						//no check request, because: if exists a license-ro-relation, than check is false 
						if(requestJson.containsKey("authormail") && check)
							updateAuthorId(researchObjectId, researchObjectVersion, ((String) requestJson.get("authormail")).trim());
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if (requestJson.containsKey("authorid") && check)
							updateAuthorId(researchObjectId, researchObjectVersion, (long) requestJson.get("authorid"));
						
						
						if(requestJson.containsKey("categoryids") && check)
							if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
								updateCategoryIds(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categoryids"));
							else{
								if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class java.lang.String")){
									JSONParser parser = new JSONParser();
									JSONArray parseJson = new JSONArray();
									try {parseJson = (JSONArray) parser.parse((String) requestJson.get("categoryids"));}
									catch (ParseException e) {e.printStackTrace();}
									updateCategoryIds(researchObjectId, researchObjectVersion, parseJson);
								}
							}
						else
							if (requestJson.containsKey("categoryid") && check)
								updateCategoryId(researchObjectId, researchObjectVersion, (long) requestJson.get("categoryid"));
							else
								if (requestJson.containsKey("categorynames") && check)
									if ((((requestJson.get("categorynames")).getClass()).toString()).equals("class org.json.simple.JSONArray"))
										updateCategoryNames(researchObjectId, researchObjectVersion, (JSONArray) requestJson.get("categorynames"));
									else
										if ((((requestJson.get("categoryids")).getClass()).toString()).equals("class java.lang.String")){
											JSONParser parser = new JSONParser();
											JSONArray parseJson = new JSONArray();
											try {parseJson = (JSONArray) parser.parse((String) requestJson.get("categorynames"));}
											catch (ParseException e) {e.printStackTrace();}
											updateCategoryNames(researchObjectId, researchObjectVersion, parseJson);
										}
						
						if (check){
							responseJson.put("researchobjectid", researchObjectId);
							responseJson.put("researchobjectversion", researchObjectVersion);
						}else
							responseJson.put("ERROR:", "ERROR: The update Research Object with ID "+ researchObjectId +" is not fully completed");
					}else
						responseJson.put("ERROR:", "ERROR: The update Research Object with ID "+ researchObjectId +" failed");
				}else
					responseJson.put("ERROR:", "ERROR: Research Object ID "+ researchObjectId +" has no entry in the database");
			}else{
				String errorString = "ERROR: The json need minimal 'name', 'label' and 'extendeddata' as Strings. ";
				if (!requestJson.containsKey("name"))
					errorString = errorString.concat(" 'name',");
				if (!requestJson.containsKey("label"))
					errorString = errorString.concat(" 'label',");
				if (!requestJson.containsKey("extendeddata"))
					errorString = errorString.concat(" 'extendeddata',");
				errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
				responseJson.put("ERROR", errorString);
			}
		} else
			if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("extendeddata") && requestJson.containsKey("researchobjecttype"))
				responseJson = createResearchObjectByJson(requestJson);
			else{
				String errorString = "ERROR: The json need minimal 'name', 'label', 'extendeddata' and 'researchobjectid' as Strings. ";
				if (!requestJson.containsKey("label"))
					errorString = errorString.concat(" 'label',");
				if (!requestJson.containsKey("extendeddata"))
					errorString = errorString.concat(" 'extendeddata',");
				if (!requestJson.containsKey("name"))
					errorString = errorString.concat(" 'name',");
				if (!requestJson.containsKey("researchobjectid"))
					errorString = errorString.concat(" 'researchobjectid',");
				errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
				responseJson.put("ERROR", errorString);
			}
				
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

		if (researchObject == null)
			try {
				pk = new ResearchObjectPK(CounterLocalServiceUtil.increment(getModelClassName()), 1);
				researchObject = researchObjectPersistence.create(pk);
			} catch (SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");}
		researchObject.setName(name);
		researchObject.setLabel(label);
		researchObject.setDescription(description);
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
		
	
	//
	private Boolean AddAuthorId (long researchObjectId, int researchObjectVersion, long authorId){
		
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
	private Boolean updateAuthorId (long researchObjectId, int researchObjectVersion, String authorMail){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_externalperson", "mail", authorMail);
		if ((boolean) hccJson.get("check"))
			check =  updateAuthorId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	private Boolean updateAuthorId (long researchObjectId, int researchObjectVersion, long authorId){
		
		ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_externalperson_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
		return AddAuthorId (researchObjectId, researchObjectVersion, authorId);
	}
	
	
	//
	private Boolean updateAuthorIds (long researchObjectId, int researchObjectVersion, JSONArray authorNames){
		System.out.println(authorNames);
		Boolean check = false;
		ContentLocalServiceUtil.deleteRelationContentsByCellContent("gfbio_externalperson_researchobject", "gfbio_researchobject", Long.toString(researchObjectId));
		for (int i=0; i < authorNames.size();i++){
			System.out.println(i +": "+(String) authorNames.get(i));
			JSONObject hccJson= new JSONObject();
			hccJson = checkHCCBackground("gfbio_externalperson", "name", ((String) authorNames.get(i)).trim());
			if ((boolean) hccJson.get("check"))
				check =  AddAuthorId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));
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
			try {super.updateResearchObject(researchObject); check = true;}
			catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	@SuppressWarnings("unused")
	private int updateResearchObjectVersion (long researchObjectId, int researchObjectVersion){

		if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
		
			Boolean check = false;
			ResearchObject researchObject = null;
			ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
			researchObject = researchObjectPersistence.create(pk);
			
			long projectId =0;
			if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
				projectId = getProjectIdByIds(researchObjectId, researchObjectVersion);
			
			if(researchObject != null){
	
				researchObjectVersion = researchObjectVersion+1;
				pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
				ResearchObject newResearchObject = researchObjectPersistence.create(pk);
				newResearchObject.setName(researchObject.getName());
				newResearchObject.setLabel(researchObject.getLabel());
				newResearchObject.setExtendeddata(researchObject.getExtendeddata());
				
				try {
					super.updateResearchObject(newResearchObject);
					check = true;
				} catch (SystemException e) {e.printStackTrace();}
				
				if (projectId !=0)
					check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, researchObjectId, researchObjectVersion);
			}
		}
		return researchObjectVersion;
	}
	

}




