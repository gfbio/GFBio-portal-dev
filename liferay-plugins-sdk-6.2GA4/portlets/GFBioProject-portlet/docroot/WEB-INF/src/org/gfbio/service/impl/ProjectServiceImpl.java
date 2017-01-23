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
	
	
	//
	public JSONObject getCheckProjectOnSubmissions(JSONObject requestJson){

		JSONObject responseJson = new JSONObject();
		responseJson = ProjectLocalServiceUtil.checkProjectOnSubmissions(requestJson);
		return responseJson;
	}
	
	
	//
	public JSONObject getProjectById (JSONObject requestJson){

		JSONObject responseJson = new JSONObject();
		responseJson = ProjectLocalServiceUtil.getCompleteProjectById(requestJson);
		return responseJson;
	}
	
	
	public JSONArray getProjectByUser(JSONObject requstJson){
		JSONArray responseJson = new JSONArray();
		responseJson = ProjectLocalServiceUtil.getProjectByUser(requstJson);
		return responseJson;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	public JSONObject createProject(JSONObject requestJson) {

		JSONObject responseJson = new JSONObject();
		responseJson = ProjectLocalServiceUtil.createProjectByJson(requestJson);
		return responseJson;
	}
	
	
	//
	public JSONObject updateProject(JSONObject requestJson) {

		JSONObject responseJson = new JSONObject();
		responseJson = ProjectLocalServiceUtil.updateProjectByJson(requestJson);
		return responseJson;
	}

}