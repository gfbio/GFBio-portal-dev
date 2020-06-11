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

import org.gfbio.NoSuchPrimaryData_ResearchObjectException;
import org.gfbio.helper.Helper;
import org.gfbio.model.PrimaryData_ResearchObject;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.PrimaryData_ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.PrimaryData_ResearchObjectFinderUtil;
import org.gfbio.service.persistence.PrimaryData_ResearchObjectPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the primary data_ research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.PrimaryData_ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.PrimaryData_ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil
 */
public class PrimaryData_ResearchObjectLocalServiceImpl	extends PrimaryData_ResearchObjectLocalServiceBaseImpl {
	
	//private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
	
	//////////////////////////////////// Delete Functions //////////////////////////////////////////////////
	
	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
		
	@SuppressWarnings("unchecked")
	public JSONObject deletePrimaryDataResearchObject (JSONObject requestJson){
				
		JSONObject responseJson = new JSONObject();
		Boolean check = false;
		Boolean researchObjectIdCheck = false;
		Boolean researchObjectVersionCeck = false;
		Boolean primarydDtaIdCheck = false;
		long researchObjectId =0;
		int researchObjectVersion =0;
		long primaryDataId = 0;
		
		if (requestJson.containsKey("researchobjectid")){
			researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			researchObjectIdCheck = true;
		}
		
		if (requestJson.containsKey("researchobjectversion")){
			researchObjectVersion = Helper.getIntFromJson(requestJson, "researchobjectversion");
			researchObjectVersionCeck = true;
		}
		
		if (requestJson.containsKey("primarydataid")){
			primaryDataId = Helper.getLongFromJson(requestJson, "primarydataid");
			primarydDtaIdCheck = true;	
		}
		
		if ((!researchObjectIdCheck && !researchObjectVersionCeck && primarydDtaIdCheck))	// 0 0 1 = 1
			check = deletePrimaryDataResearchObjectByPrimaryDataId(primaryDataId);

		if ((researchObjectIdCheck && !researchObjectVersionCeck && !primarydDtaIdCheck))	// 1 0 0 = 4
			check = deletePrimaryDataResearchObjectByResearchObjectId(researchObjectId);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && !primarydDtaIdCheck))	// 1 1 0 = 6
			check = deletePrimaryDataResearchObjectByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		
		if ((researchObjectIdCheck && researchObjectVersionCeck && primarydDtaIdCheck))		// 1 1 1 = 7 
			check = deletePrimaryDataResearchObjectByIds(researchObjectId, researchObjectVersion, primaryDataId);

		
		responseJson.put("check", check);
		return responseJson;
	}
	
	
		
	//---------------------------------- Delete Functions ------------------------------------------------//

	
	//
	private Boolean deletePrimaryDataResearchObjectByPrimaryDataId(long primaryDataId){
		Boolean check = false;
		
		try {
			List <PrimaryData_ResearchObject> primaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByPrimaryDataID(primaryDataId);
			if (primaryDataResearchObjectList.size() >0){
				for (int i =0; i< primaryDataResearchObjectList.size();i++)
					PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject(primaryDataResearchObjectList.get(i));
				List <PrimaryData_ResearchObject> checkPrimaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByPrimaryDataID(primaryDataId);
				if (checkPrimaryDataResearchObjectList.size() ==0)
					check = true;
			}else
				check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	private Boolean deletePrimaryDataResearchObjectByIds(long researchObjectId, int researchObjectVersion, long primaryDataId){
		Boolean check = false;
		
		try {
			PrimaryData_ResearchObjectPK pk = new PrimaryData_ResearchObjectPK(primaryDataId, researchObjectId, researchObjectVersion);
			PrimaryData_ResearchObject primaryDataResearchObject = primaryData_ResearchObjectPersistence.findByPrimaryKey(pk);
			if (primaryDataResearchObject != null){
				PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject(primaryDataResearchObject);
			
				PrimaryData_ResearchObject checkPrimaryDataResearchObject = primaryData_ResearchObjectPersistence.findByPrimaryKey(pk);
				if (checkPrimaryDataResearchObject == null){
					check = true;
					if (checkResearchObjectId(researchObjectId)){
						JSONObject primaryDataJson = new JSONObject();
						primaryDataJson.put("primarydataid", primaryDataId);
						PrimaryDataLocalServiceUtil.deletePrimaryData(primaryDataJson);
					}
				}
			}else
				check = true;
			
		} catch ( SystemException | NoSuchPrimaryData_ResearchObjectException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deletePrimaryDataResearchObjectByResearchObjectId(long primaryDataId){
		Boolean check = false;
		
		try {
			List <PrimaryData_ResearchObject> primaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByPrimaryDataID(primaryDataId);
			if (primaryDataResearchObjectList.size() >0){
				for (int i =0; i< primaryDataResearchObjectList.size();i++)
					PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject(primaryDataResearchObjectList.get(i));
				List <PrimaryData_ResearchObject> checkPrimaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByPrimaryDataID(primaryDataId);
				if (checkPrimaryDataResearchObjectList.size() ==0)
					check = true;
			}else
				check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	//
	private Boolean deletePrimaryDataResearchObjectByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion){
		Boolean check = false;
		
		try {
			List <PrimaryData_ResearchObject> primaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByResearchObjectIDAndVersion(researchObjectId, researchObjectVersion);
			if (primaryDataResearchObjectList.size() >0){
				for (int i =0; i< primaryDataResearchObjectList.size();i++)
					PrimaryData_ResearchObjectLocalServiceUtil.deletePrimaryData_ResearchObject(primaryDataResearchObjectList.get(i));
				List <PrimaryData_ResearchObject> checkPrimaryDataResearchObjectList = primaryData_ResearchObjectPersistence.findByResearchObjectIDAndVersion(researchObjectId, researchObjectVersion);
				if (checkPrimaryDataResearchObjectList.size() ==0)
					check = true;
			}else
				check = true;
		} catch ( SystemException e) {e.printStackTrace();}	
		return check;
		
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray  getPrimaryDatasIdsByResearchObject (JSONObject requestJson){
		
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
				responseList = getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to primary data");
			
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(responseList.toString());}
			catch (ParseException e) {e.printStackTrace();}
		
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid'as long.");
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectsByPrimaryDataId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		if (requestJson.containsKey("primarydataid")){
			List <ResearchObject> responseList = null;
			
			responseList = getResearchObjectsByPrimaryDataId((long)requestJson.get("primarydataid"));

			if (responseList.size()>0)
				responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectsJson(responseList);
			else
				responseJson.add("ERROR: primary data with ID "+ (long)requestJson.get("primarydataid") +" has no relation to a research object");
			
		}else
			responseJson.add("ERROR: The json need minimal 'primarydataid' as long.");

		
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//
	public List <Long> getPrimaryDataIdsByResearchObjectId (long researchObjectId){
		return getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId));
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public List <Long> getPrimaryDataIdsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		return PrimaryData_ResearchObjectFinderUtil.getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	//
	private List<ResearchObject> getResearchObjectsByPrimaryDataId (long primaryDataId){
		return PrimaryData_ResearchObjectFinderUtil.getResearchObjectsByPrimaryDataId(primaryDataId);
	}
	
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	public Boolean checkPrimaryDataId(long primaryDataId) {
		
		Boolean check = false;
		List <Boolean> checkList =  PrimaryData_ResearchObjectFinderUtil.getCheckOfPrimaryDataId(primaryDataId);
		
		if (checkList.size()>0)
			check = checkList.get(0);
		
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Boolean check = false;
		List <Boolean> checkList =  PrimaryData_ResearchObjectFinderUtil.getCheckOfResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		
		if (checkList.size()>0)
			check = checkList.get(0);
		
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectId(long researchObjectId) {
		
		Boolean check = false;
		List <Boolean> checkList =  PrimaryData_ResearchObjectFinderUtil.getCheckOfResearchObjectId(researchObjectId);
		
		if (checkList.size()>0)
			check = checkList.get(0);
		
		return check;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////


	//-------------------------------- Manage Update Functions ----------------------------------------------//

	
	//update or create a new Relationship between a Primary Data and a Research Object
	public Boolean updatePrimaryDataResearchObject(long primaryDataId, long researchObjectId) {
		return updatePrimaryDataResearchObject(primaryDataId, researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId));
	}

	
	//---------------------------------- Update Functions -------------------------------------------------//
	
	
	//update or create a new Relationship between a Primary Data and a Research Object
	public Boolean updatePrimaryDataResearchObject(long primaryDataId, long researchObjectId, int researchObjectVersion) {

		Boolean check = false;
		
		PrimaryData_ResearchObject relationship = null;
		PrimaryData_ResearchObjectPK pk = new PrimaryData_ResearchObjectPK(primaryDataId, researchObjectId, researchObjectVersion);

		try {relationship = primaryData_ResearchObjectPersistence.findByPrimaryKey(pk);	}
		catch (NoSuchPrimaryData_ResearchObjectException | SystemException e1) {System.out.println("no enitity with pk: "+pk+" is found");}
		
		if (relationship == null) 
			relationship = primaryData_ResearchObjectPersistence.create(pk);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));		
		try {
			super.updatePrimaryData_ResearchObject(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	

	//
	public Boolean updateResearchObjectVersion(long primaryDataId, long researchObjectId, int oldResearchObjectVersion, int newResearchObjectVersion) {
		Boolean check = false;
		
		PrimaryData_ResearchObject oldRelationship = null;
		PrimaryData_ResearchObjectPK pk = new PrimaryData_ResearchObjectPK(primaryDataId, researchObjectId, oldResearchObjectVersion);

		try {oldRelationship = primaryData_ResearchObjectPersistence.findByPrimaryKey(pk);}
		catch (NoSuchPrimaryData_ResearchObjectException | SystemException e) {e.printStackTrace();}
		
		if (oldRelationship !=null){
			PrimaryData_ResearchObject relationship = (PrimaryData_ResearchObject) oldRelationship.clone();
			relationship.setResearchObjectVersion(newResearchObjectVersion);
			relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));			
			try {
				super.updatePrimaryData_ResearchObject(relationship);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}

		return check;
	}
	
}