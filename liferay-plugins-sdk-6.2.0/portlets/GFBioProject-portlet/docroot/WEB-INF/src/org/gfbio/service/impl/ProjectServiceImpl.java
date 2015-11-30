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


import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.base.ProjectServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The implementation of the project remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ProjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.ProjectServiceBaseImpl
 * @see org.gfbio.service.ProjectServiceUtil
 */

public class ProjectServiceImpl extends ProjectServiceBaseImpl {
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
/*	//
	public JSONArray getProjectById (String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		
		JSONArray responseJson = new JSONArray();
		responseJson = ProjectLocalServiceUtil.getCompleteProjectById(parseJson);
		return responseJson;
	}*/
	
	
	//
	public JSONArray getProjectById (JSONObject requestJson){

		JSONArray responseJson = new JSONArray();
		responseJson = ProjectLocalServiceUtil.getCompleteProjectById(requestJson);
		return responseJson;
	}
	
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getProjectById1 (){

		JSONObject requestJson = new JSONObject();
		long a = 1;
		requestJson.put("projectid", a);
		System.out.println(requestJson);
		JSONArray responseJson = new JSONArray();
		responseJson = ProjectLocalServiceUtil.getCompleteProjectById(requestJson);
		return responseJson;
	}
	
	
	
	
/*	//
	public List<Project> getProjectListByUserId(long userID) throws NoSuchModelException, SystemException {
		return ProjectLocalServiceUtil.getProjectList(userID);
	}*/
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	

	//
/*	public long updateProject(long projectID, long userID, String name, String label, String description, Date startDate, Date endDate, String status) throws SystemException {
		return ProjectLocalServiceUtil.updateProject(projectID, userID, name, label, description, startDate, endDate, status);
	}*/
	

}