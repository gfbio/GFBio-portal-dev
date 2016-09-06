/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchResearchObject_UserException;
import org.gfbio.model.ResearchObject;
import org.gfbio.model.ResearchObject_User;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.ResearchObject_UserLocalServiceBaseImpl;
import org.gfbio.service.persistence.ResearchObject_UserFinderUtil;
import org.gfbio.service.persistence.ResearchObject_UserPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the research object_ user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ResearchObject_UserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ResearchObject_UserLocalServiceBaseImpl
 * @see org.gfbio.service.ResearchObject_UserLocalServiceUtil
 */
public class ResearchObject_UserLocalServiceImpl	extends ResearchObject_UserLocalServiceBaseImpl {
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
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
	public JSONArray getOwnerAndPiByResearchObjectId(long researchObjectId){
		JSONArray responseJson = new JSONArray();
		List <Long> userIdList = getOwnerIdsByResearchObjectIds(researchObjectId);
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
	public List <Long> getOwnerIdsByResearchObjectIds(long researchObjectId){
		List <Long> userList = null;
		userList = getOwnerIdsByResearchObjectIds(researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId));
		return userList;
	}
	
	//
	public List <Long> getOwnerIdsByResearchObjectIds(long researchObjectId, int researchObjectVersion){
		List <Long> userList = null;
		userList = ResearchObject_UserFinderUtil.getOwnerIdsByResearchObjectIds(researchObjectId, researchObjectVersion);
		return userList;
	}
	
	
	//
	public List <ResearchObject> getResearchObjectsByUserId (long userId){
		return ResearchObject_UserFinderUtil.getResearchObjectsByUserId(userId);
	}
	
	@Override
	public List<ResearchObject_User> getResearchObjectIdList(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////	
	

	//
	public Boolean updateResearchObjectUser(long researchObjectId,  long userId, String userType) {
		Boolean check = false;
		check = updateResearchObjectUser(researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId), userId, userType);
		return check;
	}
	
	
	//update or create a Project and set the relationship to User
	public Boolean updateResearchObjectUser(long researchObjectId, int researchObjectVersion, long userId, String userType) {

		Boolean check = false;
		ResearchObject_User relation = null;
		ResearchObject_UserPK pk = new ResearchObject_UserPK(researchObjectId, researchObjectVersion, userId);

		try {relation = researchObject_UserPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchResearchObject_UserException | SystemException e) {System.out.println("Entry in ResearchObject does not exist with 'projectId' "+researchObjectId+ " and 'userid' " + userId + " and will be create now");}

		if (relation == null) 
			relation = researchObject_UserPersistence.create(pk);
		
		relation.setUserType(userType);

		try {
			super.updateResearchObject_User(relation);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//update or create a Project and set the relationship to User
	public Boolean updateResearchObjectUser(long researchObjectId, int researchObjectVersion, long userId, Date startDate, Date endDate, String userType) {

		Boolean check = false;
		ResearchObject_User relation = null;
		ResearchObject_UserPK pk = new ResearchObject_UserPK(researchObjectId, researchObjectVersion, userId);

		try {relation = researchObject_UserPersistence.findByPrimaryKey(pk);}
		catch (NoSuchResearchObject_UserException | SystemException e) {System.out.println("Entry in ResearchObject does not exist with 'projectId' "+researchObjectId+ " and 'userid' " + userId + " and will be create now");}

		if (relation == null) 
			relation = researchObject_UserPersistence.create(pk);
		
		relation.setStartDate(startDate);
		relation.setEndDate(endDate);
		relation.setUserType(userType);

		try {
			super.updateResearchObject_User(relation);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}




}