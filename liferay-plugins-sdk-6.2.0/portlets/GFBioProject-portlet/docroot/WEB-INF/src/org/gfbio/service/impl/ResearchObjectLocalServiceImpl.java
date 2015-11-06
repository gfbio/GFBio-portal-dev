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


import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.NoSuchProject_UserException;
import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.ResearchObjectFinderUtil;
import org.gfbio.service.persistence.ResearchObjectPK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * The implementation of the research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.ResearchObjectLocalServiceUtil
 */
public class ResearchObjectLocalServiceImpl extends ResearchObjectLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getResearchObjectASJsonById(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			
			JSONObject json = (JSONObject) requestJson.get(i);
			if (json.containsKey("researchobjectid") && json.containsKey("researchobjectversion"))
				responseJson.add(getResearchObjectASJsonById((long) json.get("researchobjectid"), (int) json.get("researchobjectversion")));
		}
		return responseJson;
	}

	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getResearchObjectAbsolutParent (JSONArray requestJson){

		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			
			JSONObject json = (JSONObject) requestJson.get(i);
			if (json.containsKey("researchobjectid")){
				responseJson.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getTopParent((long)json.get("researchobjectid"))));
				if (responseJson.toString().equals("{}"))
					responseJson.add("ERROR: Faile by find absolut parent");
			}
			else
				responseJson.add("ERROR: No key 'researchobjectid' exist.");
		}
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getResearchObjectParent (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			
			JSONObject json = (JSONObject) requestJson.get(i);
			if (json.containsKey("researchobjectid")){
				responseJson.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getDirectParent((long)json.get("researchobjectid"))));
				if (responseJson.toString().equals("{}"))
					responseJson.add("ERROR: Faile by find parent");
			}
			else
				responseJson.add("ERROR: No key 'researchobjectid' exist.");
		}
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getResearchObjectsByParent (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			
			JSONObject json = (JSONObject) requestJson.get(i);
			if (json.containsKey("researchobjectid")){
				responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectsJson(ResearchObjectLocalServiceUtil.getDirectChildren((long)json.get("researchobjectid")));
				if (responseJson.toString().equals("{}"))
					responseJson.add("ERROR: Faile by find research objects by parent");
			}
			else
				responseJson.add("ERROR: No key 'researchobjectid' exist.");
		}
		return responseJson;
	}
	
		
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//
	@SuppressWarnings("null")
	public List <ResearchObject> getAllChildren (long researchObjectId){
		List <ResearchObject> researchObjectList = null;
		List <ResearchObject> secondList = null;
		ResearchObject researchObject = null;
		researchObjectList = ResearchObjectLocalServiceUtil.getDirectChildren(researchObjectId);
		researchObject = researchObjectList.get(0);

		secondList.add(researchObject);
		while (researchObjectList.size () >0){
			secondList.add(researchObjectList.get(0));
			//researchObjectList.addAll( ResearchObjectLocalServiceUtil.getDirectChildren(researchObjectList.get(0).getResearchObjectID()));
			researchObjectList = researchObjectList.subList(1, researchObjectList.size());
		}
		return secondList;
	}
	
	
	//
	public List <ResearchObject> getDirectChildren (long researchObjectId){
		List <ResearchObject> researchObjectList = null;
		try {
			researchObjectList = researchObjectPersistence.findByParentID(researchObjectId);
		} catch (SystemException e) {e.printStackTrace();}
		return researchObjectList;
	}
	
	
	//
	public ResearchObject getDirectParent(long researchObjectId) {
		
		ResearchObject researchObject = null;
		if (ResearchObjectLocalServiceUtil.checkParentAttributById(researchObjectId))
			researchObject = (ResearchObject) ResearchObjectFinderUtil.getDirectParent(researchObjectId).get(0) ;
		return researchObject;
	}

	
	//
	public ResearchObject getTopParent(long researchObjectId) {
		ResearchObject researchobject = null;
		researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchObjectId);
		while (researchobject != null && researchobject.getParentResearchObjectID()!=0)
			researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchobject.getResearchObjectID());
		return researchobject;
	}
	
	
	//
	public ResearchObject IdAndVersion(long researchObjectId, int researchObjectVersion) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByIDAndVersion(researchObjectId, researchObjectVersion);
	}
	
	//
	public List<ResearchObject> getResearchObjectById(long researchObjectId) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByResearchObjectID(researchObjectId);
	}
	
	
	//
	public JSONObject getResearchObjectASJsonById(long researchObjectId, int researchObjectVersion) {
		JSONObject json = new JSONObject();
		json = null;
		try {
			json =  ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectPersistence.findByIDAndVersion(researchObjectId, researchObjectVersion));
		} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}
		return json;
	}
	
	
	////////////////////////////////////// Helper Functions ////////////////////////////////////////////////////
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructResearchObjectJson (ResearchObject researchObject){

		JSONObject json = new JSONObject();
		if (researchObject != null){
			json.put("researchobjectid", researchObject.getResearchObjectID());
			json.put("researchobjectversion", researchObject.getResearchObjectVersion());		
			json.put("name", researchObject.getName());
			json.put("label", researchObject.getLabel());
			json.put("metadata", researchObject.getMetadata());
			json.put("parentresearchobjectid", researchObject.getParentResearchObjectID());
			json.put("researchobjecttype", researchObject.getResearchObjectType());	
		}
		return json;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray constructResearchObjectsJson (List <ResearchObject> researchObjectList){

		JSONArray json = new JSONArray();
		if (researchObjectList.size()>0)
			for (int i =0; i < researchObjectList.size();i++)
				json.add(ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectList.get(i)));
		return json;
	}
	
	
	//
	public String constructFormatMetadata(String metadata){
		return (metadata);
	}
	
	
	//
	public Boolean checkParentAttributById(long researchObjectId){
		return ResearchObjectFinderUtil.getCheckOfDirectParent(researchObjectId).get(0);
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createResearchObjectByJson(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add((JSONObject) requestJson.get(i));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createResearchObjectByJson(JSONObject requestJson){
		
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		JSONObject keyJson = new JSONObject();
		
		if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("metadata") && requestJson.containsKey("researchobjecttype")){

			String name = ((String) requestJson.get("name")).trim();
			String label = ((String) requestJson.get("label")).trim();
			String metadata = requestJson.get("metadata").toString();
			String researchObjectType = ((String) requestJson.get("researchobjecttype")).trim();
			
			try {
				researchObjectId = ResearchObjectLocalServiceUtil.createResearchObject(name, label, metadata, researchObjectType);
			} catch (SystemException e) {e.printStackTrace();}
			
			
			if (requestJson.containsKey("projectid"))
				try {
					researchObjectId = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) requestJson.get("projectid"), researchObjectId, researchObjectVersion) - (long) requestJson.get("projectid");
				} catch (NoSuchProject_UserException | SystemException e) {e.printStackTrace();}
			
			
			if (requestJson.containsKey("parentresearchobjectid"))
				researchObjectId = ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, (long) requestJson.get("parentresearchobjectid"));
			
			keyJson.put("researchobjectid", researchObjectId);
			keyJson.put("researchobjectversion", researchObjectVersion);
		}else
			keyJson.put("EROOR:", "ERROR: The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings");
		
		return keyJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateResearchObjectByJson(JSONArray requestJson){

		JSONObject keyJson = new JSONObject();
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++){
			
			JSONObject json = (JSONObject) requestJson.get(i);
			if (json.containsKey("researchobjectid") && json.containsKey("researchobjectversion")){
				long researchObjectId = (long) json.get("researchobjectid");
				int researchObjectVersion = (int) json.get("researchobjectversion");
				if (json.containsKey("name") && json.containsKey("label") && json.containsKey("metadata") && json.containsKey("researchobjecttype")){
					String name = ((String) json.get("name")).trim();
					String label = ((String) json.get("label")).trim();
					String metadata = json.get("metadata").toString();
					String researchObjectType = ((String) json.get("researchobjecttype")).trim();
					String formatmetadata = ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
					researchObjectId = updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType);
					
					if (json.containsKey("projectid"))
						try {
							researchObjectId = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) json.get("projectid"), researchObjectId, researchObjectVersion) - (long) json.get("projectid");
						} catch (NoSuchProject_UserException | SystemException e) {e.printStackTrace();}
					
					if (json.containsKey("parentresearchobjectid"))
						researchObjectId = ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, (long) json.get("parentresearchobjectid"));
					
					keyJson.put("researchobjectid", researchObjectId);
					keyJson.put("researchobjectversion", researchObjectVersion);
					responseJson.add(keyJson);
				}else
					responseJson.add("ERROR: The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings");
			}
			else
				responseJson.add(ResearchObjectLocalServiceUtil.createResearchObjectByJson(json));
		}
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//

	
	//
	public long createResearchObject (String name, String label, String metadata, String researchObjectType) throws SystemException{
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		String formatmetadata =	ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
		return ResearchObjectLocalServiceUtil.updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType) ;
	}
	
	
	//
	public long createResearchObjectWithProject (long projectId, String name, String label, String metadata, String researchObjectType) throws SystemException{
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		String formatmetadata =	ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
		return ResearchObjectLocalServiceUtil.updateResearchObjectWithProject(projectId, researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType) ;
	}
		
	
	//
	public long updateParentResearchObjectIdByIds(long researchObjectId, int researchObjectVersion, long parentResearchObjectId){

		long check =0;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(pk);
		} catch (SystemException | NoSuchModelException e) {e.printStackTrace();}

		if (researchObject != null){
			researchObject.setParentResearchObjectID(parentResearchObjectId);
			try {
				super.updateResearchObject(researchObject);
				check = researchObject.getResearchObjectID();
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public long updateResearchObject(long researchObjectId, int researchObjectVersion, String name, String label, String metadata, String formatmetadata, String researchObjectType)  {

		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		long check =0;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(pk);
		} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}

		if (researchObject == null)
			try {
				pk = new ResearchObjectPK(CounterLocalServiceUtil.increment(getModelClassName()), 1);
				researchObject = researchObjectPersistence.create(pk);
			} catch (SystemException e) {e.printStackTrace();}
		researchObject.setName(name);
		researchObject.setLabel(label);
		researchObject.setMetadata(metadata);
		researchObject.setFormatmetadata(formatmetadata);
		researchObject.setResearchObjectType(researchObjectType);
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public int updateResearchObjectVersion (long researchObjectId, int researchObjectVersion){
		
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		researchObject = researchObjectPersistence.create(pk);
		
		if(researchObject != null){
			
			researchObjectVersion = researchObjectVersion+1;
			
			pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
			ResearchObject newResearchObject = researchObjectPersistence.create(pk);
			newResearchObject.setName(researchObject.getName());
			newResearchObject.setLabel(researchObject.getLabel());
			newResearchObject.setMetadata(researchObject.getMetadata());
			newResearchObject.setFormatmetadata(researchObject.getFormatmetadata());
			newResearchObject.setResearchObjectType(researchObject.getFormatmetadata());
			
			
		}

		return researchObjectVersion;
	}
	
	//
	public long updateResearchObjectWithProject(long projectId, long researchObjectId, int researchObjectVersion, String name, String label, String metadata, String formatmetadata, String researchObjectType)  {

		long check =0;
		try {
			check = ResearchObjectLocalServiceUtil.updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType);
			check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, check, researchObjectVersion) - projectId;
		} catch (SystemException | NoSuchProject_UserException e1) {e1.printStackTrace();	}
		return check;
	}

}