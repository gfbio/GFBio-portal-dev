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

import org.gfbio.NoSuchProject_UserException;
import org.gfbio.model.Project_User;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.Project_UserLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_UserFinderUtil;
import org.gfbio.service.persistence.Project_UserPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The implementation of the project_ user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Project_UserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.Project_UserLocalServiceBaseImpl
 * @see org.gfbio.service.Project_UserLocalServiceUtil
 */
public class Project_UserLocalServiceImpl extends Project_UserLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getProjectIdsByUserId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		if (requestJson.containsKey("userid"))
			responseJson.addAll(getProjectIdIdsByUserId((long) requestJson.get("userid")));
		else
			responseJson.add("ERROR: No keys 'userid' exist.");	
		
		return(responseJson);
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	//
	public String getFullNamesAsString(JSONArray requestJson){
		String response ="";
		for (int i =0; i < requestJson.size();i++)
			if (( (JSONObject) requestJson.get(i)).containsKey("fullname"))
				response = response.concat((String) ((JSONObject) requestJson.get(i)).get("fullname")).concat(", ");
		if (response.length()>0)	
			response = response.substring(0, response.length()-2);
		return response;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getOwnerAndPiByProjectId(long projectId){
		JSONArray responseJson = new JSONArray();
		List <Long> userIdList = getOwnerAndPiIdByProjectId(projectId);
		for (int i= 0; i< userIdList.size();i++ ){
			JSONObject userJson = new JSONObject();
			JSONObject idJson = new JSONObject();
			idJson.put("userid", userIdList.get(i));
			userJson = UserExtensionLocalServiceUtil.getUserExtentionById(idJson);
			responseJson.add(userJson);
		}
		
		return responseJson;
	}
	
	
	//
	public List <Long> getOwnerAndPiIdByProjectId(long projectId){
		List <Long> userList = null;
		userList = Project_UserFinderUtil.getOwnerAndPiByProjectId(projectId);
		return userList;
	}
	
	
	//get a ID-List (Project_User-Object) of all project of a specific user
	public List<Project_User> getProjectIdList(long userID) {
		List<Project_User> idList = null;
		try {idList = project_UserPersistence.findByUserID(userID);} 
		catch (SystemException e) {e.printStackTrace();}
		return idList;
	}
	
	
	//
	private List<Long> getProjectIdIdsByUserId (long userId){
		List <Long> projectList = null;
		projectList = Project_UserFinderUtil.getProjectIdsByUserId(userId);
		return projectList;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////	
	

	
	//update or create a Project and set the relationship to User
	public Boolean updateProjectUser(long projectId, long userId, String userType) {

		Boolean check = false;
		Project_User relationship = null;
		Project_UserPK pk = new Project_UserPK(projectId, userId);

		try {relationship = project_UserPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchProject_UserException | SystemException e) {System.out.println("Entry in Project does not exist with 'projectId' "+projectId+ " and 'userid' " + userId + " and will be create now");}

		if (relationship == null) 
			relationship = project_UserPersistence.create(pk);
		relationship.setUserType(userType);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));

		try {
			super.updateProject_User(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//update or create a Project and set the relationship to User
	public Boolean updateProjectUser(long projectID, long userID, Date startDate, Date endDate, String userType) {

		Boolean check = false;
		Project_User relationship = null;
		Project_UserPK pk = new Project_UserPK(projectID, userID);

		try {relationship = project_UserPersistence.findByPrimaryKey(pk);}
		catch (NoSuchProject_UserException | SystemException e) {e.printStackTrace();}

		if (relationship == null) 
			relationship = project_UserPersistence.create(pk);
		
		relationship.setStartDate(startDate);
		relationship.setEndDate(endDate);
		relationship.setUserType(userType);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));

		try {
			super.updateProject_User(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}


	@Override
	public List<Project_User> getProjectIDList(long userID) {
		// TODO Auto-generated method stub
		return null;
	}

}