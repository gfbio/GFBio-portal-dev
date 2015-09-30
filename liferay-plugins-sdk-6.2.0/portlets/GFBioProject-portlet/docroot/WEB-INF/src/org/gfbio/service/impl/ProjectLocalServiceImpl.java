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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchProjectException;
import org.gfbio.NoSuchProject_UserException;
import org.gfbio.model.Project;
import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.Project_User;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.base.ProjectLocalServiceBaseImpl;
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
	public JSONObject getProjectById (JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		
		if (json.containsKey("projectid")){
			responseJson = ProjectLocalServiceUtil.constructProjectJson(ProjectLocalServiceUtil.getProjectById((long)json.get("projectid")));
			if (responseJson == null)
				responseJson.put("ERROR", "Failed by response project");
		}
		else
			responseJson.put("ERROR", "No key 'projectid' exist.");
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//
	public Project getProjectById (long projectId) throws NoSuchProjectException, SystemException{
		return projectPersistence.findByPrimaryKey(projectId);
	}
	
	
	// get list of all projects of a specific user - if we have a access to the user table, than this method goes to the UserLocalServiceImpl
	public List<Project> getProjectList(long userID) throws NoSuchModelException, SystemException {

		List<Project_User> idList = Project_UserLocalServiceUtil.getProjectIDList(userID);
		List<Project> projectList = new ArrayList<Project>();

		for (int i = 0; i<idList.size(); i++) {
			projectList.add(projectPersistence.findByPrimaryKey(idList.get(i).getProjectID()));
		}

		return projectList;
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
	@SuppressWarnings("unchecked")
	public JSONObject constructProjectAsJson (Project project){
		JSONObject json = new JSONObject();
		json.put("projectid", project.getProjectID());
		json.put("parentprojectid", project.getParentProjectID());
		json.put("name", project.getName());
		json.put("label", project.getLabel());
		json.put("description", project.getDescription());
		json.put("startdate", project.getStartDate());	
		json.put("endDate", project.getEndDate());
		json.put("status", project.getStatus());
		return json;
	}
	

	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	public long updateProject(long projectID, long userID, String name, String label, String description, Date startDate, Date endDate, String status) throws SystemException {

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
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setStatus(status);
			super.updateProject(project);
			try {
				@SuppressWarnings("unused")
				Long foobar = Project_UserLocalServiceUtil.updateProjectUser(project.getProjectID(), userID, startDate, endDate);
			} catch (NoSuchProject_UserException e) {e.printStackTrace();}
		}
		
		//update project
		else {
			project.setName(name);
			project.setLabel(label);
			project.setDescription(description);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setStatus(status);
			super.updateProject(project);
		}
		return project.getProjectID();
	}
	

	@Override
	//
	public long updateProject(long projectID, String name, String description)
			throws SystemException {

		// TODO Auto-generated method stub

		return 0;
	}


}