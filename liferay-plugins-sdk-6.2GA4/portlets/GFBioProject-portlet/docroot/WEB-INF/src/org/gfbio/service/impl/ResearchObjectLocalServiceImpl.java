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
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
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
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectAsJsonById(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(getResearchObjectASJsonById((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public JSONObject getResearchObjectASJsonById(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"researchobjectid", "researchobjectversion"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion")){
			ResearchObject researchObject = null;
			try {
				researchObject = researchObjectPersistence.findByIDAndVersion((long) requestJson.get("researchobjectid"), (int) ((long) requestJson.get("researchobjectversion")));
			} catch (NoSuchResearchObjectException | SystemException e1) {
				responseJson.put("ERROR", "ERROR: This 'researchobjectid' with this 'researchobjectversion' don't exist.");	
			}
			if (researchObject != null)
				responseJson = constructResearchObjectJson(researchObject);
		}else{
			if (requestJson.containsKey("researchobjectid")){
				ResearchObject researchObject = null;
				researchObject = getLatestResearchObjectById((long) requestJson.get("researchobjectid"));
				if (researchObject != null)
					responseJson = constructResearchObjectJson(researchObject);
				else
					responseJson.put("ERROR", "ERROR: This 'researchobjectid' don't exist.");
			}else
				responseJson.put("ERROR", "ERROR: No key 'researchobjectid' exist.");
		}
		
		if (responseJson.containsKey("metadataid"))
			responseJson.put("metadatalabel",ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById( (long) responseJson.get("metadataid")),"label"));

		
		if (responseJson.containsKey("licenseid")){
			responseJson.put("licenselabel",ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById( (long) responseJson.get("licenseid")),"label"));
		}
		
		if (ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_externalperson_researchobject", (long) responseJson.get("researchobjectid")))
			try {responseJson.put("authorid", ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_externalperson_researchobject"), (Long.toString((long) responseJson.get("researchobjectid")))));}
			catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
		
		
		if (responseJson.containsKey("authorid")){
			JSONArray idArray = (JSONArray) responseJson.get("authorid");
			JSONArray labelArray = new JSONArray();
			for (int i =0; i <idArray.size();i++)
				labelArray.add(ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById((long) idArray.get(i) ),"name"));
			responseJson.put("authorname", labelArray.toString());
		}
		
		
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
			projectId = (long) Project_ResearchObjectFinderUtil.getProjectIdByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion).get(0);
		return projectId;
	}
	
	
	//
	public List<ResearchObject> getResearchObjectById(long researchObjectId) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByResearchObjectID(researchObjectId);
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
				}
			}
		}
		else{
			check = true;
		}
		
		long contentId =0;
		try {contentId = ContentLocalServiceUtil.getContentIdByTableIds(rowId, ColumnLocalServiceUtil.getColumnIdByNames(tableName, "id"));
		} catch (NoSuchContentException | SystemException e) {e.printStackTrace();}

		responseJson.put("check", check);
		responseJson.put("contentid", contentId);
		
		return responseJson;
	}
	
	
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
		JSONObject json = new JSONObject();
		if (researchObject != null){
			json.put("researchobjectid", researchObject.getResearchObjectID());
			json.put("researchobjectversion", researchObject.getResearchObjectVersion());		
			json.put("name", researchObject.getName());
			json.put("label", researchObject.getLabel());
			json.put("description", researchObject.getDescription());
			json.put("extendeddata", researchObject.getExtendeddata());
			json.put("parentresearchobjectid", researchObject.getParentResearchObjectID());
			json.put("researchobjecttype", ContentLocalServiceUtil.getCellContentByRowIdAndColumnName(ContentLocalServiceUtil.getRowIdById(researchObject.getMetadataID()), "label"));
			json.put("metadataid", researchObject.getMetadataID());	
			json.put("licenseid", researchObject.getLicenseID());
		}
		return checkNullParent(json);
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
		String [] keySet = {"authornames", "authormail","authorid", "brokerobjectid","description", "extendeddata", "label","licenseid","licenselabel", "metadataid", "name","parentresearchobjectid", "projectid", "researchobjecttype"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("extendeddata") && (requestJson.containsKey("researchobjecttype") || requestJson.containsKey("metadataid"))){

			String name = ((String) requestJson.get("name")).trim();
			String label = ((String) requestJson.get("label")).trim();
			String extendedData = requestJson.get("extendeddata").toString();
			
			try {
				researchObjectId = createResearchObject(name, label, extendedData);
				if (researchObjectId !=0)
					check = true;
			} catch (SystemException e) {e.printStackTrace();}

			if(requestJson.containsKey("description") && check)
				updateDescription(researchObjectId, researchObjectVersion, ((String) requestJson.get("description")).trim());
			
			if(requestJson.containsKey("researchobjecttype") && check)
				check = updateResearchObjectType(researchObjectId, researchObjectVersion, ((String) requestJson.get("researchobjecttype")).trim());
			
			if (requestJson.containsKey("metadataid") && check)
				check = updateMetadataId(researchObjectId, researchObjectVersion, (long) requestJson.get("metadataid"));

			
			if(requestJson.containsKey("licenselabel") && check)
				check = updateLicenseId(researchObjectId, researchObjectVersion, ((String) requestJson.get("licenselabel")).trim());
			
			if (requestJson.containsKey("licenseid") && check)
				check = updateLicenseId(researchObjectId, researchObjectVersion, (long) requestJson.get("licenseid"));
			
			
			if(requestJson.containsKey("authornames") && check)
				updateAuthorIds(researchObjectId, researchObjectVersion, ((String) requestJson.get("authornames")).trim());
			
			if(requestJson.containsKey("authormail") && check)
				check = updateAuthorId(researchObjectId, researchObjectVersion, ((String) requestJson.get("authormail")).trim());
			
			if (requestJson.containsKey("authorid") && check)
				check = updateAuthorId(researchObjectId, researchObjectVersion, (long) requestJson.get("authorid"));
			
			
			if (requestJson.containsKey("projectid") && check)
				check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) requestJson.get("projectid"), researchObjectId, researchObjectVersion);
	
			if (requestJson.containsKey("parentresearchobjectid") && check)
				check = updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, (long) requestJson.get("parentresearchobjectid"));
				
			if (check){
				responseJson.put("researchobjectid", researchObjectId);
				responseJson.put("researchobjectversion", researchObjectVersion);
				if (requestJson.containsKey("brokerobjectid")) 
					responseJson.put("brokerobjectid", requestJson.get("brokerobjectid"));
			}else
				responseJson.put("ERROR:", "ERROR: create research object is failed.");
		}else{
			String errorString = "ERROR: To create a Research Object, the json need minimal 'name', 'label', 'extendeddata' and 'researchobjecttype' as Strings. ";
			if (!requestJson.containsKey("name"))
				errorString = errorString.concat(" 'name',");
			if (!requestJson.containsKey("label"))
				errorString = errorString.concat(" 'label',");
			if (!requestJson.containsKey("extendeddata"))
				errorString = errorString.concat(" 'extendeddata',");
			if (!requestJson.containsKey("researchobjecttype"))
				errorString = errorString.concat(" 'researchobjecttype',");
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
		String [] keySet = {"authormail","authorid", "brokerobjectid", "description","extendeddata", "label","licenseid","licenselabel", "name", "researchobjectid"};
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
						
					if (!(name.equals(researchObject.getName())) || !(label.equals(researchObject.getLabel())) || !(extendedData.equals(researchObject.getExtendeddata()))){
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
							updateLicenseId(researchObjectId, researchObjectVersion, ((String) requestJson.get("licenselabel")).trim());
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if (requestJson.containsKey("licenseid") && check)
							updateLicenseId(researchObjectId, researchObjectVersion, (long) requestJson.get("licenseid"));
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if(requestJson.containsKey("authornames") && check)
							updateAuthorIds(researchObjectId, researchObjectVersion, ((String) requestJson.get("authornames")).trim());
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if(requestJson.containsKey("authormail") && check)
							updateAuthorId(researchObjectId, researchObjectVersion, ((String) requestJson.get("authormail")).trim());
						
						//no check request, because: if exists a license-ro-relation, than check is false 
						if (requestJson.containsKey("authorid") && check)
							updateAuthorId(researchObjectId, researchObjectVersion, (long) requestJson.get("authorid"));
						
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
	public long createResearchObject (String name, String label, String extendedData) throws SystemException{

		long researchObjectId = 0;
		int researchObjectVersion = 1;
		
		researchObjectId =  updateKernelResearchObject(researchObjectId, researchObjectVersion, name, label, extendedData) ;
		
		return researchObjectId;
	}
	
	
	//
	public long updateKernelResearchObject(long researchObjectId, int researchObjectVersion, String name, String label, String extendedData)  {

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
		researchObject.setExtendeddata(extendedData);
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

	
	//
	public long updateResearchObjectWithProject(long projectId, long researchObjectId, int researchObjectVersion, String name, String label, String extendedData, String researchObjectType)  {

		long checkId = 0;
		Boolean check2 =false;

		checkId = updateKernelResearchObject(researchObjectId, researchObjectVersion, name, label, extendedData);
			if (checkId !=0) 
				check2=true;
			if (check2)
				check2 = updateResearchObjectType(researchObjectId, researchObjectVersion, researchObjectType);
			if (check2)
				check2 = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, checkId, researchObjectVersion);
		return checkId;
	}
	
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
	
	
	
	//
	public Boolean updateAuthorIds (long researchObjectId, int researchObjectVersion, String authorNames){
		
		Boolean check = false;
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {parseJson = (JSONArray) parser.parse(authorNames);}
		catch (ParseException e) {e.printStackTrace();}
		
		for (int i=0; i < parseJson.size();i++){
			JSONObject hccJson= new JSONObject();
			hccJson = checkHCCBackground("gfbio_externalperson", "name", (String) parseJson.get(i));
			if ((boolean) hccJson.get("check"))
				check =  updateAuthorId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));
		}
		
		return check;
	}
	
	//
	public Boolean updateAuthorId (long researchObjectId, int researchObjectVersion, String authorMail){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_externalperson", "mail", authorMail);
		
		if ((boolean) hccJson.get("check"))
			check =  updateAuthorId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	public Boolean updateAuthorId (long researchObjectId, int researchObjectVersion, long authorId){
		return HeadLocalServiceUtil.updateInterfaceTableWithContent("gfbio_researchobject", researchObjectId, "gfbio_externalperson", authorId);
	}
	
	
	//
	public Boolean updateDescription (long researchObjectId, int researchObjectVersion, String description){
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setDescription(description);
			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	

	//
	public Boolean updateLicenseId (long researchObjectId, int researchObjectVersion, String licenseLabel){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_license", "label", licenseLabel);
		
		if ((boolean) hccJson.get("check"))
			check =  updateLicenseId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
		
	}
	
	
	//
	public Boolean updateLicenseId (long researchObjectId, int researchObjectVersion, long licenseId){
		
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setLicenseID(licenseId);;
			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		
		return check;
	}
	
	
	//
	public Boolean updateMetadataId (long researchObjectId, int researchObjectVersion, long metadataId){
		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		
		try {
			researchObject = getResearchObject(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (researchObject!=null){
			researchObject.setMetadataID(metadataId);

			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		
		return check;
	}
	
	
	//
	public Boolean updateParentResearchObjectIdByIds(long researchObjectId, int researchObjectVersion, long parentResearchObjectId){
	
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {researchObject = researchObjectPersistence.findByPrimaryKey(pk);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setParentResearchObjectID(parentResearchObjectId);
			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateResearchObjectType (long researchObjectId, int researchObjectVersion, String researchObjectType){
		Boolean check = false;
		JSONObject hccJson= new JSONObject();
		hccJson = checkHCCBackground("gfbio_metadata", "label", researchObjectType);
		
		if ((boolean) hccJson.get("check"))
			check =  updateMetadataId(researchObjectId, researchObjectVersion, (long) hccJson.get("contentid"));

		return check;
	}
	
	
	//
	@SuppressWarnings("unused")
	public int updateResearchObjectVersion (long researchObjectId, int researchObjectVersion){

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




