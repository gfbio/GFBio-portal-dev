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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gfbio.NoSuchProjectException;
import org.gfbio.model.Project;
import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.Project_User;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ProjectLocalServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ProjectLocalServiceBaseImpl
 * @see org.gfbio.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getCompleteProjectById (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(getCompleteProjectById((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "null" })
	public JSONObject getCompleteProjectById (JSONObject requestJson){

		JSONObject responseJson = null;
		List <ResearchObject> researchObjectList = null;
		Set<String> set = new HashSet<String>();
		set.add("projectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("projectid")){
			try {
				responseJson = constructProjectAsJson(projectPersistence.findByPrimaryKey((long) requestJson.get("projectid")));
			} catch (NoSuchProjectException | SystemException e) {
				responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");
			}
			if (responseJson != null){
				researchObjectList = Project_ResearchObjectLocalServiceUtil.getResearchObjectsByProjectId((long) requestJson.get("projectid"));
				if (researchObjectList.size() >0){
					JSONArray researchObjectJSON = new JSONArray();
					for (int i =0; i< researchObjectList.size();i++)
						researchObjectJSON.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectList.get(i)));
					responseJson.put("researchobjects", researchObjectJSON);
				}
			}
		}
		else{
			responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");
		}
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getProjectById (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		if (requestJson.containsKey("projectid"))
			try {
				responseJson = constructProjectAsJson(projectPersistence.findByPrimaryKey((long)requestJson.get("projectid")));
			} catch (NoSuchProjectException | SystemException e) {
				e.printStackTrace();
				responseJson.put("ERROR", "ERROR: Fail by getProjectById");}
		else
			responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");
		
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	// get list of all projects of a specific user - if we have a access to the user table, than this method goes to the UserLocalServiceImpl
	public List<Project> getProjectList(long userID) throws NoSuchModelException, SystemException {

		List<Project_User> idList = Project_UserLocalServiceUtil.getProjectIDList(userID);
		List<Project> projectList = new ArrayList<Project>();
		for (int i = 0; i<idList.size(); i++) 
			projectList.add(projectPersistence.findByPrimaryKey(idList.get(i).getProjectID()));
		return projectList;
	}
	
	
	//
	public List<Project> getProjects() throws SystemException {
		return projectPersistence.findAll();
	}

	
	// get list of all Research Objects of a specific project
	public List<ResearchObject> getResearchObjectList(long projectID, long userID) throws NoSuchModelException, SystemException {

		List<Project_ResearchObject> idList = project_ResearchObjectPersistence.findByProjectID(projectID);
		List<ResearchObject> researchObjectList = new ArrayList<ResearchObject>();
		for (int i = 0; i<idList.size(); i++)
			researchObjectList.add(researchObjectPersistence.findByPrimaryKey(idList.get(i).getResearchObjectID()));
		return researchObjectList;
	}

	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
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
	public JSONObject constructProjectAsJson (Project project){

		JSONObject json = new JSONObject();
		json.put("projectid", project.getProjectID());
		json.put("parentprojectid", project.getParentProjectID());
		json.put("name", project.getName());
		json.put("label", project.getLabel());
		json.put("description", project.getDescription());
		json.put("extendeddata", project.getExtendeddata());
		if (project.getStartDate() != null)
			json.put("startdate", project.getStartDate().toString());
		else
			json.put("startdate", "");
		if (project.getEndDate() != null)
			json.put("enddate", project.getEndDate().toString());
		else
			json.put("enddate", "");			
		json.put("status", project.getStatus());
		return json;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray constructProjectAsJsonArray (Project project){
		
		JSONArray jsonArray = new JSONArray ();
		jsonArray.add(constructProjectAsJson(project));
		return jsonArray;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray constructProjectsAsJson (List <Project> projectList){
		
		JSONArray json = new JSONArray();
		for (int i =0; i < projectList.size();i++)
			json.add(constructProjectAsJson(projectList.get(i)));
		return json;
	}
	

	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createProjectByJson(JSONObject requestJson){
		
		Boolean check = false;
		long projectId = 0;
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"name", "label", "extendeddata", "description", "parentprojectid", "userid", "startdate", "enddate", "status"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if ((requestJson.containsKey("name") || requestJson.containsKey("label")) && requestJson.containsKey("description")&& requestJson.containsKey("userid")){

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
			String description =((String)  requestJson.get("description")).trim();
			long userid = (long) requestJson.get("userid");
			
			try {
				projectId = createProject(userid, name, label,description );
				if (projectId !=0)
					check = true;
			} catch (SystemException e) {e.printStackTrace();}

			if (check)
				check = Project_UserLocalServiceUtil.updateProjectUser(projectId, (long) requestJson.get("userid"), "owner");
	
			if (requestJson.containsKey("parentprojectid") && check)
				check = updateParentProjectByIds(projectId, (long) requestJson.get("parentprojectid"));
			
			if (requestJson.containsKey("extendeddata") && check)
				check = updateExtendedData(projectId, (String) requestJson.get("extendeddata"));
			
			if (requestJson.containsKey("startdate") && check){
				if (requestJson.get("startdate").getClass().toString().equals("class java.lang.String"))
					try {
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mmZ");
						check = updateStartDate(projectId, dateFormat.parse((String) requestJson.get("startdate")));	
					} catch (ParseException e) {e.printStackTrace();}
				else
					check = updateStartDate(projectId, new Date ((long) requestJson.get("startdate")));
			}
			
			if (requestJson.containsKey("enddate") && check){
				if (requestJson.get("enddate").getClass().toString().equals("class java.lang.String"))
					try {
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mmZ");
						check = updateEndDate(projectId, dateFormat.parse((String) requestJson.get("enddate")));	
					} catch (ParseException e) {e.printStackTrace();}
				else
					check = updateStartDate(projectId, new Date ((long) requestJson.get("enddate")));
			}
			
			if (requestJson.containsKey("status") && check)
				check = updateStatus(projectId, (String) requestJson.get("status"));
		
			if (check){
				responseJson.put("projectId", projectId);
			}else
				responseJson.put("ERROR:", "ERROR: create project is failed.");
		}else{
			String errorString = "ERROR: To create a project, the json need minimal 'userid', 'description' and 'name' or 'label'  as Strings. ";
			if (!requestJson.containsKey("name"))
				errorString = errorString.concat(" 'name',");
			if (!requestJson.containsKey("label"))
				errorString = errorString.concat(" 'label',");
			if (!requestJson.containsKey("description"))
				errorString = errorString.concat(" 'description',");
			if (!requestJson.containsKey("userid"))
				errorString = errorString.concat(" 'userid',");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
			responseJson.put("ERROR", errorString);
		}
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//-------------------------------- Update Functions ----------------------------------------------//
	
	
	//
	public long createProject (long userId, String name, String label, String description) throws SystemException{
		long projectId = 0;
		projectId =  updateProject(projectId, name, label, description) ;
		return projectId;
	}
	
	
	//
	public long  updateProject(long projectId, String name,String label,String description){
		
		Project project = null;
		long check =0;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchProjectException e) {System.out.println("Entry in Project does not exist with pk "+projectId+ " and  will be create now");}

		if (project == null)
			try {
				project = projectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
		project.setName(name);
		project.setLabel(label);
		project.setDescription(description);
		try {
			super.updateProject(project);
			check = project.getProjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
	
		return check;
		
		
	}
	

	
	//
	public long updateProject(long projectID, long userID, String name, String label, String description, String extendedData, Date startDate, Date endDate, String status) throws SystemException {

		Project project = null;
		try {
			project = projectPersistence.findByPrimaryKey(projectID);
		} catch (NoSuchProjectException e) {e.printStackTrace();}

		//create new project
		if (project == null) {
			project = projectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			project.setName(name);
			project.setLabel(label);
			project.setDescription(description);
			project.setExtendeddata(extendedData);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setStatus(status);
			super.updateProject(project);
			Project_UserLocalServiceUtil.updateProjectUser(project.getProjectID(), userID, startDate, endDate, "owner");
		}
		
		//update project
		else {
			project.setName(name);
			project.setLabel(label);
			project.setDescription(description);
			project.setExtendeddata(extendedData);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setStatus(status);
			super.updateProject(project);
		}
		return project.getProjectID();
	}
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
	
	
	//
	public Boolean updateEndDate(long projectId, Date endDate){
	
		Project project = null;
		Boolean check = false;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
		if (project != null){
			project.setEndDate(endDate);
			try {
				super.updateProject(project);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateExtendedData(long projectId, String extendedData){
	
		Project project = null;
		Boolean check = false;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
		if (project != null){
			project.setExtendeddata(extendedData);
			try {
				super.updateProject(project);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateParentProjectByIds(long projectId, long parentProjectId){
	
		Project project = null;
		Boolean check = false;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
		if (project != null){
			project.setParentProjectID(parentProjectId);
			try {
				super.updateProject(project);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateStartDate(long projectId, Date startDate){
	
		Project project = null;
		Boolean check = false;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
		if (project != null){
			project.setStartDate(startDate);
			try {
				super.updateProject(project);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	

	
	//
	public Boolean updateStatus(long projectId, String status){
	
		Project project = null;
		Boolean check = false;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
		if (project != null){
			project.setStatus(status);
			try {
				super.updateProject(project);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}

}