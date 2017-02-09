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

import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchProjectException;
import org.gfbio.model.Project;
import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.Project_User;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.ProjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.ProjectFinderUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


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
	@SuppressWarnings({ "unchecked"})
	public JSONObject getCompleteProjectById (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("projectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("projectid")){

			long projectId = (long)requestJson.get("projectid");
			if (checkProjectOnId(projectId)){
				try {responseJson = constructProjectAsJson(projectPersistence.findByPrimaryKey((long) requestJson.get("projectid")));} 
				catch (NoSuchProjectException | SystemException e) {responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");	}
				if (responseJson != null){
					responseJson.put("researchobjects", getResearchObjectsByProjectId((long) requestJson.get("projectid")));
					
					if (ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_category_project", (long) responseJson.get("projectid")))
						try {responseJson.put("categoryid", (ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_project"), (Long.toString((long) responseJson.get("projectid"))))).toString());}
						catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}
				}
				
			}
			else
				responseJson.put("ERROR", "ERROR: projectid with value "+projectId+" don't exist in the database.");
		}
		else
			responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");

		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		return responseJson;
	}

	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getProjectById (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		if (requestJson.containsKey("projectid")){
			
			long projectId = (long)requestJson.get("projectid");
			if (checkProjectOnId(projectId)){
				
				Project project = null;
				try {project = projectPersistence.findByPrimaryKey(projectId);}
				catch (NoSuchProjectException | SystemException e) {e.printStackTrace();responseJson.put("ERROR", "ERROR: Failed by load project.");}
				
				if (project != null)
					
					if(requestJson.containsKey("kindofresponse"))
						
						if((((String)requestJson.get("kindofresponse")).trim()).equals("reduced"))
							responseJson = constructReducedProjectAsJson(project);
						else
							responseJson = constructProjectAsJson(project);
					else
						responseJson = constructProjectAsJson(project);
				else
					responseJson.put("ERROR", "ERROR: projectid with value "+projectId+" don't exist in the database.");
			}else
				responseJson.put("ERROR", "ERROR: projectid with value "+projectId+" don't exist in the database.");
		}else
			responseJson.put("ERROR", "ERROR: No key 'projectid' exist.");
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getProjectById (JSONArray requestJson){

		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			if (((requestJson.get(i).getClass()).toString()).equals("class java.lang.Long")){
				JSONObject json = new JSONObject();
				json.put("projectid", requestJson.get(i));
				requestJson.set(i, json);
			}
			responseJson.add(getProjectById((JSONObject) requestJson.get(i)));
		}
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getProjectsByUser(JSONObject requestJson){

		JSONArray responseJson = new JSONArray();
				
		if (requestJson.containsKey("userid") || requestJson.containsKey("emailaddress")){

			long userId =0;
			if (requestJson.containsKey("userid"))
				userId = (long)requestJson.get("userid");
			else
				if (UserExtensionLocalServiceUtil.checkExistenceOfUserMail(((String) requestJson.get("emailaddress")).trim())){				
					JSONObject json = new JSONObject();
					json = UserExtensionLocalServiceUtil.getUserExtentionByEmailAddress(requestJson);
					if (json.containsKey("userid"))
						userId = (long) json.get("userid");
				}

			if (userId !=0 && UserExtensionLocalServiceUtil.checkExistenceOfUserId(userId)){

				JSONObject idJson = new JSONObject();
				idJson.put("userid", userId);
				JSONArray projectIdArray = Project_UserLocalServiceUtil.getProjectIdsByUserId(idJson);


				if (requestJson.containsKey("kindofresponse"))
					for (int i =0; i < projectIdArray.size();i++){

						JSONObject json = new JSONObject();
						if (((projectIdArray.get(i).getClass()).toString()).equals("class java.lang.Long"))
							json.put("projectid", (long) projectIdArray.get(i));
						else
							json = (JSONObject) projectIdArray.get(i);
						json.put("kindofresponse", requestJson.get("kindofresponse"));
						projectIdArray.set(i, json);
					}
				responseJson = getProjectById(projectIdArray);
			}
			else
				responseJson.add("ERROR: userid and emailaddress don't exist in the database.");
		}
		else
			responseJson.add("ERROR: No keys 'userid' and 'emailaddress' exist.");		
		
		
		return responseJson;
	}
	

	//
	@SuppressWarnings("unchecked")
	public JSONArray  getUserIdsByResearchObject (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		if (requestJson.containsKey("researchobjectid")){
			List <Long> responseList = null;
			long researchObjectId = (long)requestJson.get("researchobjectid");
			int researchObjectVersion = 0;
			
			if (requestJson.containsKey("researchobjectversion"))
				researchObjectVersion = (int) requestJson.get("researchobjectversion");
			else
				researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId);
			
			if (Project_ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion))
				responseList = getUserIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to user");
			
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(responseList.toString());}
			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}

		
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid'as long.");
		
		return responseJson;
	}	
	
	
	//
	@SuppressWarnings("unchecked")
	private List <Long> getUserIdsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		return ProjectFinderUtil.getUserIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	// get list of all projects of a specific user - if we have a access to the user table, than this method goes to the UserLocalServiceImpl
	public List<Project> getProjectList(long userID) throws NoSuchModelException, SystemException {

		List<Project_User> idList = Project_UserLocalServiceUtil.getProjectIdList(userID);
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
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectsByProjectId (long projectId){
		JSONArray researchObjectJSON = new JSONArray();
		List <ResearchObject> researchObjectList = null;
		researchObjectList = Project_ResearchObjectLocalServiceUtil.getResearchObjectsByProjectId(projectId);
		if (researchObjectList.size() >0)
			for (int i =0; i< researchObjectList.size();i++)
				researchObjectJSON.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectList.get(i)));
		else
			researchObjectJSON = null;
		return researchObjectJSON;
	}

	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	

	//--------------------------------------------- Manage Helper Functions ---------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject checkProjectOnSubmissions(JSONObject idJson){
		JSONObject answerJson = new JSONObject();
		if (idJson.containsKey("projectid"))
			if (idJson.get("projectid").getClass().toString().equals("class java.lang.Long"))
				answerJson.put("check", (Boolean) ProjectFinderUtil.checkProjectOnSubmissions((long)idJson.get("projectid")).get(0));
			else
				answerJson.put("error", "The content of 'id' is not from class 'long'");
		else
			answerJson.put("error", "There is no 'id' in the request.");
		return answerJson;
	}
	
	
	//------------------------------------------------- Helper Functions ------------------------------------------------//	
	
	//
	public Boolean checkProjectOnId(long projectId) {
		
		Boolean check = false;
		List <Boolean> checkList =  ProjectFinderUtil.getCheckOnId(projectId);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public Boolean checkProjectOnSubmissions(long projectId){
		return (Boolean) ProjectFinderUtil.checkProjectOnSubmissions(projectId).get(0);
	}
	
	
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
	public JSONObject constructReducedProjectAsJson (Project project){

		JSONObject json = new JSONObject();
		json.put("projectid", project.getProjectID());
		json.put("name", project.getName());
		return json;
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
		String [] keySet = {"name", "label", "extendeddata", "description", "parentprojectid", "userid", "startdate", "enddate", "status"}; //currently no keys: "dcrtid", "dcrtids"
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
			
/*			if (requestJson.containsKey("dcrtids") && check){
				if (requestJson.get("dcrtids").getClass().toString().equals("class java.lang.String")){
					String dcrtidsString =  (String) requestJson.get("dcrtids");
					if (!((dcrtidsString.substring(0,0)).equals("[")))
						dcrtidsString = "[".concat(dcrtidsString).concat("]");
					JSONParser parser = new JSONParser();
					JSONArray parseJson = new JSONArray();
					try {parseJson = (JSONArray) parser.parse(dcrtidsString);} 
					catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
					check = updateCategories(projectId, parseJson);
				}else
					check = updateCategories(projectId, (JSONArray) requestJson.get("dcrtids"));
			}*/
			
/*			if (requestJson.containsKey("dcrtid") && check)
				check = updateCategory(projectId, (long) requestJson.get("dcrtid"));*/

			if (check){
				responseJson.put("projectid", projectId);
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
	
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject updateProjectByJson(JSONObject requestJson){
		
		Boolean check = false;
		long projectId = 0;
		JSONObject responseJson = new JSONObject();
			
		Set<String> set = new HashSet<String>();
		String [] keySet = {"projectid","name", "label", "extendeddata", "description", "parentprojectid", "startdate", "enddate", "status", }; //currently no keys: "dcrtid", "dcrtids"
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if ((requestJson.containsKey("name") || requestJson.containsKey("label")) && requestJson.containsKey("description")&& requestJson.containsKey("projectid")){

			if (checkProjectOnId((long) requestJson.get("projectid"))){
				
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
				
				projectId = updateProject((long) requestJson.get("projectid"), name, label, description);;
				if (projectId !=0)
					check = true;
				
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
				
	/*			if (requestJson.containsKey("dcrtids") && check){
					if (requestJson.get("dcrtids").getClass().toString().equals("class java.lang.String")){
						String dcrtidsString =  (String) requestJson.get("dcrtids");

						if (!((dcrtidsString.substring(0,0)).equals("[")))
							dcrtidsString = "[".concat(dcrtidsString).concat("]");
						JSONParser parser = new JSONParser();
						JSONArray parseJson = new JSONArray();
						try {parseJson = (JSONArray) parser.parse(dcrtidsString);} 
						catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}

						check = updateCategories(projectId, parseJson);
					}else
						check = updateCategories(projectId, (JSONArray) requestJson.get("dcrtids"));
				}*/
				
	/*			if (requestJson.containsKey("dcrtid") && check)
					check = updateCategory(projectId, (long) requestJson.get("dcrtid"));*/

				if (check){
					responseJson.put("projectid", projectId);
				}else
					responseJson.put("ERROR:", "ERROR: create project is failed.");
			}else
				responseJson.put("ERROR:", "ERROR: The id "+(long) requestJson.get("projectid")+" is not a 'projectid' in our database");
			
		}else{
			String errorString = "ERROR: To update a project, the json need minimal 'projectid', 'description' and 'name' or 'label'  as Strings. ";
			if (!requestJson.containsKey("name"))
				errorString = errorString.concat(" 'name',");
			if (!requestJson.containsKey("label"))
				errorString = errorString.concat(" 'label',");
			if (!requestJson.containsKey("description"))
				errorString = errorString.concat(" 'description',");
			if (!requestJson.containsKey("projectid"))
				errorString = errorString.concat(" 'projectid',");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
			responseJson.put("ERROR", errorString);
		}
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	//-------------------------------- Update Functions ----------------------------------------------//
	
	
	//
	private long createProject (long userId, String name, String label, String description) throws SystemException{
		long projectId = 0;
		projectId =  updateProject(projectId, name, label, description) ;
		return projectId;
	}
	
	
	//
	private long  updateProject(long projectId, String name,String label,String description){
		
		Project project = null;
		long check =0;
		
		try {
			project = projectPersistence.findByPrimaryKey(projectId);
		} catch (SystemException | NoSuchProjectException e) {System.out.println("Entry in Project does not exist with pk "+projectId+ " and  will be create now");}

		if (project == null)
			try {project = projectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
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
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
	
	
	//
/*	private Boolean updateCategories (long projectId, JSONArray requestJson){

		Boolean check = false;
		JSONArray responseJson = new JSONArray();
		
		if (ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_category_project", projectId))
			try {responseJson = ContentLocalServiceUtil.getOppositeCellContentsOfRelationsByCellContent(HeadLocalServiceUtil.getHeadIdByTableName("gfbio_category_project"), Long.toString(projectId));} 
			catch (NoSuchHeadException | SystemException e) {e.printStackTrace();	}

		if (responseJson.size()>0)
			for (int i =0; i < responseJson.size();i++)
				ContentLocalServiceUtil.deleteRelationContentByCellContent(Long.toString(projectId), Long.toString((Long) responseJson.get(i)) );
		
		//wait(1000);
		try {
			TimeUnit.MILLISECONDS.sleep( 2000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i =0; i <requestJson.size();i++)
			check = updateCategory( projectId, (long) requestJson.get(i));

		return check;
	}	*/
	
	
	//
/*	private Boolean updateCategory (long projectId, long categoryId){
		return HeadLocalServiceUtil.updateInterfaceTableWithContent("gfbio_project", projectId, "gfbio_category", categoryId);
	}*/
	
	
	//
	private Boolean updateEndDate(long projectId, Date endDate){
	
		Project project = null;
		Boolean check = false;
		
		try {project = projectPersistence.findByPrimaryKey(projectId);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
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
	private Boolean updateExtendedData(long projectId, String extendedData){
	
		Project project = null;
		Boolean check = false;
		
		try {project = projectPersistence.findByPrimaryKey(projectId);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
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
	private Boolean updateParentProjectByIds(long projectId, long parentProjectId){
	
		Project project = null;
		Boolean check = false;
		
		try {project = projectPersistence.findByPrimaryKey(projectId);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
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
	private Boolean updateStartDate(long projectId, Date startDate){
	
		Project project = null;
		Boolean check = false;
		
		try {project = projectPersistence.findByPrimaryKey(projectId);}
		catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+projectId+" is found");}
	
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
	private Boolean updateStatus(long projectId, String status){
	
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