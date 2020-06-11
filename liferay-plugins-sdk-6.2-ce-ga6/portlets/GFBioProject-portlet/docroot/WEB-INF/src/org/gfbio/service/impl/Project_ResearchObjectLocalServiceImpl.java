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

import com.liferay.portal.kernel.exception.SystemException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchProject_ResearchObjectException;
import org.gfbio.helper.Helper;
import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.Project_ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_ResearchObjectFinderUtil;
import org.gfbio.service.persistence.Project_ResearchObjectPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 * The implementation of the project_ research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Project_ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author froemm
 * @see org.gfbio.service.base.Project_ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.Project_ResearchObjectLocalServiceUtil
 */
public class Project_ResearchObjectLocalServiceImpl extends Project_ResearchObjectLocalServiceBaseImpl {

	//private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
	
	//////////////////////////////////// Delete Functions //////////////////////////////////////////////////
	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
		
	
	@SuppressWarnings("unchecked")
	public JSONObject deleteProjectResearchObject (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
		Boolean researchObjectIdCheck = false;
		Boolean researchObjectVersionCeck = false;
		Boolean projectIdCheck = false;
		long researchObjectId =0;
		int researchObjectVersion =0;
		long projectId = 0;
		
		if (requestJson.containsKey("researchobjectid")){
			researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			researchObjectIdCheck = true;
		}
		
		if (requestJson.containsKey("researchobjectversion")){
			researchObjectVersion = Helper.getIntFromJson(requestJson, "researchobjectversion");
			researchObjectVersionCeck = true;
		}
		
		if (requestJson.containsKey("projectid")){
			projectId = Helper.getLongFromJson(requestJson, "projectid");
			projectIdCheck = true;	
		}

		if ((researchObjectIdCheck && !researchObjectVersionCeck && !projectIdCheck))
			check = deleteProjectResearchObjectByResearchObjectId(researchObjectId);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && !projectIdCheck))
			check = deleteProjectResearchObjectByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && projectIdCheck))
			check = deleteProjectResearchObjectByIds(researchObjectId, researchObjectVersion, projectId);
		
		responseJson.put("check", check);
		return responseJson;
	}
	
	
		
	//---------------------------------- Delete Functions ------------------------------------------------//

	
	//
	private Boolean deleteProjectResearchObjectByIds(long researchObjectId, int researchObjectVersion, long projectId){
		Boolean check = false;
		
		try {
			Project_ResearchObjectPK pk = new Project_ResearchObjectPK(projectId, researchObjectId, researchObjectVersion);
			Project_ResearchObject projectResearchObject = project_ResearchObjectPersistence.findByPrimaryKey(pk);
			if (projectResearchObject != null){
				Project_ResearchObjectLocalServiceUtil.deleteProject_ResearchObject(projectResearchObject);
			
				Project_ResearchObject checkProjectResearchObject = project_ResearchObjectPersistence.findByPrimaryKey(pk);
				if (checkProjectResearchObject == null)
					check = true;
			}else
				check = true;
			
		} catch ( SystemException | NoSuchProject_ResearchObjectException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deleteProjectResearchObjectByResearchObjectId(long researchObjectId){
		Boolean check = false;
		
		try {
			List <Project_ResearchObject> projectResearchObjectList = project_ResearchObjectPersistence.findByResearchObjectID2(researchObjectId);
			if (projectResearchObjectList.size() >0){
				for (int i =0; i< projectResearchObjectList.size();i++)
					Project_ResearchObjectLocalServiceUtil.deleteProject_ResearchObject(projectResearchObjectList.get(i));
				List <Project_ResearchObject> checkProjectResearchObjectList = project_ResearchObjectPersistence.findByResearchObjectID2(researchObjectId);
				if (checkProjectResearchObjectList.size() ==0)
					check = true;
			}else
				check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deleteProjectResearchObjectByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion){
		Boolean check = false;
		
		try {
			List <Project_ResearchObject> projectResearchObjectList = project_ResearchObjectPersistence.findByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			if (projectResearchObjectList.size() >0){
				for (int i =0; i< projectResearchObjectList.size();i++)
					Project_ResearchObjectLocalServiceUtil.deleteProject_ResearchObject(projectResearchObjectList.get(i));
				List <Project_ResearchObject> checkProjectResearchObjectList = project_ResearchObjectPersistence.findByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
				if (checkProjectResearchObjectList.size() ==0)
					check = true;
			}
			else
				check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		
		return check;
		
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray  getProjectIdsByResearchObject (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		if (requestJson.containsKey("researchobjectid")){
			List <Long> responseList = null;
			long researchObjectId = (long)requestJson.get("researchobjectid");
			int researchObjectVersion = 0;
			
			if (requestJson.containsKey("researchobjectversion"))
				researchObjectVersion = (int) requestJson.get("researchobjectversion");
			else
				researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId);
			
			if (checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion))
				responseList = getProjectIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to project");
			
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(responseList.toString());}
			catch (ParseException e) {e.printStackTrace();}
		
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid'as long.");
		
		return responseJson;
	}

	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	
	//get a ID-List (Project_ResearchObject-Object) of all Research Objects of a specific Project
	public List<Project_ResearchObject> getProjectIDList(long projectID) {
		List<Project_ResearchObject> idList = null;
		try {idList = project_ResearchObjectPersistence.findByProjectID(projectID);}
		catch (SystemException e) {e.printStackTrace();}
		return idList;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	private List <Long> getProjectIdsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		return Project_ResearchObjectFinderUtil.getProjectIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	//
	public List <ResearchObject> getResearchObjectsByProjectId (long projectId){
		return Project_ResearchObjectFinderUtil.getResearchObjectsByProjectId(projectId);
	}
	
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	public Boolean checkResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Boolean check = false;
		List <Boolean> checkList =  Project_ResearchObjectFinderUtil.getCheckOfResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////

	
	//update or create a new Relationship between a Project and a Research Object
	public Boolean updateProjectResearchObject(long projectID, long researchObjectID, int researchObjectVersion) {

		Boolean check = false;
		Project_ResearchObject relationship = null;
		Project_ResearchObjectPK pk = new Project_ResearchObjectPK(projectID, researchObjectID, researchObjectVersion);

		try {relationship = project_ResearchObjectPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchProject_ResearchObjectException | SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");	}

		if (relationship == null) 
			relationship = project_ResearchObjectPersistence.create(pk);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {
			super.updateProject_ResearchObject(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}

}