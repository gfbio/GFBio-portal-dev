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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchResearchObject_UserException;
import org.gfbio.helper.Helper;
import org.gfbio.model.ResearchObject;
import org.gfbio.model.ResearchObject_User;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObject_UserLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.ResearchObject_UserLocalServiceBaseImpl;
import org.gfbio.service.persistence.ResearchObject_UserFinderUtil;
import org.gfbio.service.persistence.ResearchObject_UserPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

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
	
	private static Log _log = LogFactoryUtil.getLog(ResearchObject_UserLocalServiceImpl.class);
	
	//////////////////////////////////// Delete Functions //////////////////////////////////////////////////
	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
		
	
	@SuppressWarnings("unchecked")
	public JSONObject deleteResearchObjectUser (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
		Boolean researchObjectIdCheck = false;
		Boolean researchObjectVersionCeck = false;
		Boolean userIdCheck = false;
		long researchObjectId =0;
		int researchObjectVersion =0;
		long userId = 0;
		
		if (requestJson.containsKey("researchobjectid")){
			researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			researchObjectIdCheck = true;
		}
		
		if (requestJson.containsKey("researchobjectversion")){
			researchObjectVersion = Helper.getIntFromJson(requestJson, "researchobjectversion");
			researchObjectVersionCeck = true;
		}
		
		if (requestJson.containsKey("userid")){
			userId = Helper.getLongFromJson(requestJson, "userid");
			userIdCheck = true;	
		}

		if ((researchObjectIdCheck && !researchObjectVersionCeck && !userIdCheck))
			check = deleteResearchObjectUserByResearchObjectId(researchObjectId);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && !userIdCheck))
			check = deleteResearchObjectUserByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && userIdCheck))
			check = deleteResearchObjectUserByIds(researchObjectId, researchObjectVersion, userId);

		
		responseJson.put("check", check);
		return responseJson;
	}
	
	
		
	//---------------------------------- Delete Functions ------------------------------------------------//

	
	//
	private Boolean deleteResearchObjectUserByIds(long researchObjectId, int researchObjectVersion, long userId){
		Boolean check = false;
		
		try {
			ResearchObject_User researchObjectUser = researchObject_UserPersistence.findByfindByPrimaryKey(researchObjectId, researchObjectVersion, userId);
			if (researchObjectUser != null){
				ResearchObject_UserLocalServiceUtil.deleteResearchObject_User(researchObjectUser);
				ResearchObject_User checkResearchObjectUser = researchObject_UserPersistence.findByfindByPrimaryKey(researchObjectId, researchObjectVersion, userId);
				if (checkResearchObjectUser != null)
					check = true;
			}
		} catch ( SystemException | NoSuchResearchObject_UserException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deleteResearchObjectUserByResearchObjectId(long researchObjectId){
		Boolean check = false;
		
		try {
			List <ResearchObject_User> researchObjectUserList = researchObject_UserPersistence.findByresearchObjectID(researchObjectId);
			if (researchObjectUserList.size() >0)
				for (int i =0; i< researchObjectUserList.size();i++)
					ResearchObject_UserLocalServiceUtil.deleteResearchObject_User(researchObjectUserList.get(i));
				List <ResearchObject_User> checkResearchObjectUserList = researchObject_UserPersistence.findByresearchObjectID(researchObjectId);
				if (checkResearchObjectUserList.size() ==0)
					check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deleteResearchObjectUserByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion){
		Boolean check = false;
		
		try {
			List <ResearchObject_User> researchObjectUserList = researchObject_UserPersistence.findByresearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			if (researchObjectUserList.size() >0)
				for (int i =0; i< researchObjectUserList.size();i++)
					ResearchObject_UserLocalServiceUtil.deleteResearchObject_User(researchObjectUserList.get(i));
				List <ResearchObject_User> checkResearchObjectUserList = researchObject_UserPersistence.findByresearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
				if (checkResearchObjectUserList.size() ==0)
					check = true;
			
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
		
	}
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
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
			
			if (checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion))
				responseList = getUserIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to user");
			
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(responseList.toString());}
			catch (ParseException e) {e.printStackTrace();}
		
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid'as long.");
		
		return responseJson;
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
	@SuppressWarnings("unchecked")
	private List <Long> getUserIdsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		return ResearchObject_UserFinderUtil.getUserIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	
	//
	public List <ResearchObject> getResearchObjectsByUserId (long userId){
		return ResearchObject_UserFinderUtil.getResearchObjectsByUserId(userId);
	}
	
	
	//
	@Override
	public List<ResearchObject_User> getResearchObjectIdList(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////	
	
	
	//
	public Boolean checkResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		Boolean check = false;
		List <Boolean> checkList =  ResearchObject_UserFinderUtil.getCheckOfResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////	
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	

	
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//
	public Boolean updateResearchObjectUser(long researchObjectId,  long userId, String userType) {
		Boolean check = false;
		check = updateResearchObjectUser(researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId), userId, userType);
		return check;
	}
	
	
	//update or create a Project and set the relationship to User
	public Boolean updateResearchObjectUser(long researchObjectId, int researchObjectVersion, long userId, String userType) {

		Boolean check = false;
		ResearchObject_User relationship = null;
		ResearchObject_UserPK pk = new ResearchObject_UserPK(researchObjectId, researchObjectVersion, userId);

		try {relationship = researchObject_UserPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchResearchObject_UserException | SystemException e) {_log.info("Entry in ResearchObject does not exist with 'researchobjectid' "+researchObjectId+ " and 'userid' " + userId + " and will be create now");}

		if (relationship == null) 
			relationship = researchObject_UserPersistence.create(pk);
		
		relationship.setUserType(userType);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {
			super.updateResearchObject_User(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//update or create a Project and set the relationship to User
	public Boolean updateResearchObjectUser(long researchObjectId, int researchObjectVersion, long userId, Date startDate, Date endDate, String userType) {

		Boolean check = false;
		ResearchObject_User relationship = null;
		ResearchObject_UserPK pk = new ResearchObject_UserPK(researchObjectId, researchObjectVersion, userId);

		try {relationship = researchObject_UserPersistence.findByPrimaryKey(pk);}
		catch (NoSuchResearchObject_UserException | SystemException e) {_log.info("Entry in ResearchObject does not exist with 'researchobjectid' "+researchObjectId+ " and 'userid' " + userId + " and will be create now");}

		if (relationship == null) 
			relationship = researchObject_UserPersistence.create(pk);
		
		relationship.setStartDate(startDate);
		relationship.setEndDate(endDate);
		relationship.setUserType(userType);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {
			super.updateResearchObject_User(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

	
	//
	public Boolean updateResearchObjectVersion(long userId, long researchObjectId, int oldResearchObjectVersion, int newResearchObjectVersion) {
		Boolean check = false;
		
		ResearchObject_User oldRelationship = null;
		ResearchObject_UserPK pk = new ResearchObject_UserPK(researchObjectId, oldResearchObjectVersion, userId);

		try {oldRelationship = researchObject_UserPersistence.findByPrimaryKey(pk);}
		catch (NoSuchResearchObject_UserException | SystemException e) {e.printStackTrace();}
		
		if (oldRelationship !=null){
			ResearchObject_User newRelationship = (ResearchObject_User) oldRelationship.clone();
			newRelationship.setResearchObjectVersion(newResearchObjectVersion);
			newRelationship.setLastModifiedDate(new Timestamp(new Date().getTime()));
			try {
				super.updateResearchObject_User(newRelationship);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}

		return check;
	}



}