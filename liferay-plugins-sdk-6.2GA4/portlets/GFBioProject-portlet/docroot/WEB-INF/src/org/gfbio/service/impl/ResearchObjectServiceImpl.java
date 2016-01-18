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


import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectServiceBaseImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




/**
 * The implementation of the research object remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ResearchObjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ResearchObjectServiceBaseImpl
 * @see org.gfbio.service.ResearchObjectServiceUtil
 */
public class ResearchObjectServiceImpl extends ResearchObjectServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////


	//
/*	public List <ResearchObject> getAllChildren (long researchObjectId){
		return ResearchObjectLocalServiceUtil.getAllChildren(researchObjectId);
	}*/
	
	
	//
	public JSONObject getResearchObjectAbsolutParent (JSONObject requestJson){
		return ResearchObjectLocalServiceUtil.getResearchObjectAbsolutParent(requestJson);
	}
	

	//
	public JSONArray getResearchObjectById (String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		return ResearchObjectLocalServiceUtil.getResearchObjectASJsonById(parseJson);
	}
	
	
	//
	public JSONObject getResearchObjectParent (JSONObject requestJson){
		return ResearchObjectLocalServiceUtil.getResearchObjectParent(requestJson);
	}
	
	
	//get all Child ResearchObjects of a ResearchObject by the ID of this. 
	public JSONArray getResearchObjectsByParent (JSONObject requestJson){
		return ResearchObjectLocalServiceUtil.getResearchObjectsByParent(requestJson);
	}
	
	
		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	public JSONArray createResearchObject(String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		return ResearchObjectLocalServiceUtil.createResearchObjectByJson(parseJson);
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public String getTest(String requestJson){
		String requestString = "test: ".concat(requestJson);
		JSONArray requestArray = new JSONArray();
		requestArray.add(requestString);
		System.out.println("foo".concat(requestJson.toString()));
		return requestString;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public String createTest(JSONObject requestJson){
		String requestString = "test: ".concat(requestJson.toString());
		JSONArray requestArray = new JSONArray();
		requestArray.add(requestString);
		System.out.println("foo");
		return requestString;
	}
	
	
	//
	public JSONArray updateResearchObject(String requestJson){
		JSONParser parser = new JSONParser();
		JSONArray parseJson = new JSONArray();
		try {
			parseJson = (JSONArray) parser.parse(requestJson);
		} catch (ParseException e) {e.printStackTrace();}
		return ResearchObjectLocalServiceUtil.updateResearchObjectByJson(parseJson);
	}
	
}