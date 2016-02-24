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

import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.base.SubmissionServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The implementation of the submission remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.SubmissionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.SubmissionServiceBaseImpl
 * @see org.gfbio.service.SubmissionServiceUtil
 */
public class SubmissionServiceImpl extends SubmissionServiceBaseImpl {


	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	

	//
	public JSONArray getLatestPublicSubmissions  (JSONObject requestJson){
		return SubmissionLocalServiceUtil.getLatestXPublicSubmissionsByX(requestJson);
	}
	
	
	//
	public JSONArray getSubmisionsByBrokerSubmissionId (JSONObject requestJson){
		JSONArray responseJson = new JSONArray();
		responseJson =SubmissionLocalServiceUtil.getSubmissionsByBrokerSubmissionId(requestJson);
		return responseJson;
	}
	
	
	//
	public JSONArray getSubmisionsByResearchObjectId (JSONObject requestJson){
		return SubmissionLocalServiceUtil.getSubmissionsByResearchObjectId(requestJson);
	}
	

	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	

	//
	public JSONArray createSubmision (String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		System.out.println(parseJson.toString());
		return SubmissionLocalServiceUtil.createSubmission (parseJson);
	}
	
	
	//
	public JSONArray updateSubmision (String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		return SubmissionLocalServiceUtil.updateSubmission (parseJson);
	}
	
}