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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_ResearchObjectFinderUtil;
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
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(getResearchObjectASJsonById((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject getResearchObjectASJsonById(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();

		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion")){
			ResearchObject researchObject = null;
			try {
				researchObject = researchObjectPersistence.findByIDAndVersion((long) requestJson.get("researchobjectid"), (int) ((long) requestJson.get("researchobjectversion")));
			} catch (NoSuchResearchObjectException | SystemException e1) {
				responseJson.put("ERROR", "ERROR: This 'researchobjectid' with this 'researchobjectversion' don't exist.");	
			}
			if (researchObject != null)
				responseJson = constructResearchObjectJson(researchObject);
		}else{
			if (requestJson.containsKey("researchobjectid")){
				ResearchObject researchObject = null;
				researchObject = getLatestResearchObjectById((long) requestJson.get("researchobjectid"));
				if (researchObject != null)
					responseJson = constructResearchObjectJson(researchObject);
				else
					responseJson.put("ERROR", "ERROR: This 'researchobjectid' don't exist.");
			}else
				responseJson.put("ERROR", "ERROR: No key 'researchobjectid' exist.");
		}
		return responseJson;
	}

	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectAbsolutParent (JSONObject requestJson){

		JSONObject responseJson = new JSONObject();

		if (requestJson.containsKey("researchobjectid")){
			responseJson=ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getTopParent((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR","ERROR: Faile by find absolut parent");
		}
		else
			responseJson.put("ERROR","ERROR: No key 'researchobjectid' exist.");
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getResearchObjectsByParent (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
			
		if (requestJson.containsKey("researchobjectid")){
			responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectsJson(ResearchObjectLocalServiceUtil.getDirectChildren((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("[]"))
				responseJson.add("ERROR: Faile by find research objects by parent");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectParent (JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();

		if (requestJson.containsKey("researchobjectid")){
			responseJson=ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getDirectParent((long)requestJson.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR","ERROR: Faile by find parent");
		}
		else
			responseJson.put("ERROR","ERROR: No key 'researchobjectid' exist.");
		
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
	public ResearchObject getLatestResearchObjectById(long researchObjectId) {
		ResearchObject researchObject = null;
		if (ResearchObjectLocalServiceUtil.checkResearchObjectId(researchObjectId))
			researchObject = (ResearchObject) ResearchObjectFinderUtil.getLatestResearchObjectById(researchObjectId).get(0) ;
		return researchObject;
	}
	
	
	//
	public int getLatestVersionById (long researchObjectId){
		int researvchObjectVersion =0;
		if (ResearchObjectLocalServiceUtil.checkResearchObjectId(researchObjectId))
			researvchObjectVersion = (int) ResearchObjectFinderUtil.getLatestVersionById(researchObjectId).get(0);
		return researvchObjectVersion;
	}
	
	
	//
	public long getProjectIdByIds (long researchObjectId, int researchObjectVersion){
		long projectId =0;
		if (ResearchObjectLocalServiceUtil.checkResearchObjectId(researchObjectId))
			projectId = (long) Project_ResearchObjectFinderUtil.getProjectIdByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion).get(0);
		return projectId;
	}
	
	
	//
	public List<ResearchObject> getResearchObjectById(long researchObjectId) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByResearchObjectID(researchObjectId);
	}
	

	//
	public ResearchObject getTopParent(long researchObjectId) {
		ResearchObject researchobject = null;
		researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchObjectId);
		while (researchobject != null && researchobject.getParentResearchObjectID()!=0)
			researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchobject.getResearchObjectID());
		return researchobject;
	}
	
		
	////////////////////////////////////// Helper Functions ////////////////////////////////////////////////////
	
	
	//
	public Boolean checkParentAttributById(long researchObjectId){
		Boolean check = false;
		List <Boolean> checkList =  ResearchObjectFinderUtil.getCheckOfDirectParent(researchObjectId);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectId(long researchObjectId) {
		Boolean check = false;
		List <Boolean> checkList =  ResearchObjectFinderUtil.getCheckOfId(researchObjectId);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
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
		
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createResearchObjectByJson(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(createResearchObjectByJson((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createResearchObjectByJson(JSONObject requestJson){
		
		Boolean check = false;
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		JSONObject responseJson = new JSONObject();
		
		if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("metadata") && requestJson.containsKey("researchobjecttype")){

			String name = ((String) requestJson.get("name")).trim();
			String label = ((String) requestJson.get("label")).trim();
			String metadata = requestJson.get("metadata").toString();
			String researchObjectType = ((String) requestJson.get("researchobjecttype")).trim();
			
			try {
				researchObjectId = ResearchObjectLocalServiceUtil.createResearchObject(name, label, metadata, researchObjectType);
				if (researchObjectId !=0)
					check = true;
			} catch (SystemException e) {e.printStackTrace();}
			
			if (requestJson.containsKey("projectid") && check)
				check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) requestJson.get("projectid"), researchObjectId, researchObjectVersion);
	
			if (requestJson.containsKey("parentresearchobjectid") && check)
				check = ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(researchObjectId, researchObjectVersion, (long) requestJson.get("parentresearchobjectid"));
				
			if (check){
				responseJson.put("researchobjectid", researchObjectId);
				responseJson.put("researchobjectversion", researchObjectVersion);
			}else
				responseJson.put("ERROR:", "ERROR: create research object is failed.");
		}else
			responseJson.put("ERROR:", "ERROR: The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings.");
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateResearchObjectByJson(JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(updateResearchObjectByJson((JSONObject) requestJson.get(i)));
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "unused" })
	public JSONObject updateResearchObjectByJson(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();

		if (requestJson.containsKey("researchobjectid")){
	
			Boolean check = false;
			Boolean changeCheck = false;
			long researchObjectId = (long) requestJson.get("researchobjectid");
			int researchObjectVersion = getLatestVersionById(researchObjectId);
			
			if (requestJson.containsKey("name") && requestJson.containsKey("label") && requestJson.containsKey("metadata")){
				
				ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
				ResearchObject researchObject = null;
				try {
					researchObject = researchObjectPersistence.findByPrimaryKey(pk);
				} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}
				
				if (researchObject!= null){
					String name = ((String) requestJson.get("name")).trim();
					String label = ((String) requestJson.get("label")).trim();
					String metadata = requestJson.get("metadata").toString();
					String formatmetadata = ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
					
					if (!(name.equals(researchObject.getName()) && label.equals(researchObject.getLabel()) && metadata.equals(researchObject.getMetadata()))){
						researchObjectVersion = ResearchObjectLocalServiceUtil.updateResearchObjectVersion(researchObjectId, researchObjectVersion);
						researchObjectId = updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata);
					}
					
					responseJson.put("researchobjectid", researchObjectId);
					responseJson.put("researchobjectversion", researchObjectVersion);
					
				}else
					responseJson.put("ERROR:", "ERROR: Research Object ID "+ researchObjectId +" has no entry in the database");
			}else
				responseJson.put("ERROR:", "ERROR: The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings");
		} else
			responseJson = ResearchObjectLocalServiceUtil.createResearchObjectByJson(requestJson);
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//

	
	//
	public long createResearchObject (String name, String label, String metadata, String researchObjectType) throws SystemException{
		long researchObjectId = 0;
		int researchObjectVersion = 1;
		String formatmetadata =	constructFormatMetadata(metadata);
		researchObjectId =  updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata) ;
		ResearchObjectLocalServiceUtil.updateResearchObjectType(researchObjectId, researchObjectVersion, researchObjectType);
		return researchObjectId;
	}
	
	
	//
	public long updateResearchObject(long researchObjectId, int researchObjectVersion, String name, String label, String metadata, String formatmetadata)  {

		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		long check =0;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(pk);
		} catch (NoSuchResearchObjectException | SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");}

		if (researchObject == null)
			try {
				pk = new ResearchObjectPK(CounterLocalServiceUtil.increment(getModelClassName()), 1);
				researchObject = researchObjectPersistence.create(pk);
			} catch (SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");}
		researchObject.setName(name);
		researchObject.setLabel(label);
		researchObject.setMetadata(metadata);
		researchObject.setFormatmetadata(formatmetadata);
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

	
	//
	public long updateResearchObjectWithProject(long projectId, long researchObjectId, int researchObjectVersion, String name, String label, String metadata, String formatmetadata, String researchObjectType)  {

		long checkId = 0;
		Boolean check2 =false;

		checkId = updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata);
			if (checkId !=0) 
				check2=true;
			if (check2)
				check2 = ResearchObjectLocalServiceUtil.updateResearchObjectType(researchObjectId, researchObjectVersion, researchObjectType);
			if (check2)
				check2 = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, checkId, researchObjectVersion);
		return checkId;
	}
	
	
	
	//-------------------------------  Update Attribute Functions ----------------------------------------------//
	
	
	//
	public Boolean updateParentResearchObjectIdByIds(long researchObjectId, int researchObjectVersion, long parentResearchObjectId){
	
		Boolean check = false;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		ResearchObject researchObject = null;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(pk);
		} catch (SystemException | NoSuchModelException e) {System.out.println("no enitity with pk: "+pk+" is found");}
	
		if (researchObject != null){
			researchObject.setParentResearchObjectID(parentResearchObjectId);
			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateResearchObjectType (long researchObjectId, int researchObjectVersion, String researchObjectType){
		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);

		try {
			researchObject = ResearchObjectLocalServiceUtil.getResearchObject(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (researchObject!=null){
			researchObject.setResearchObjectType(researchObjectType);
			try {
				super.updateResearchObject(researchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	@SuppressWarnings("unused")
	public int updateResearchObjectVersion (long researchObjectId, int researchObjectVersion){

		Boolean check = false;
		ResearchObject researchObject = null;
		ResearchObjectPK pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
		researchObject = researchObjectPersistence.create(pk);
		long projectId = getProjectIdByIds(researchObjectId, researchObjectVersion);
	
		if(researchObject != null){

			researchObjectVersion = researchObjectVersion+1;
			pk = new ResearchObjectPK(researchObjectId, researchObjectVersion);
			ResearchObject newResearchObject = researchObjectPersistence.create(pk);
			newResearchObject.setName(researchObject.getName());
			newResearchObject.setLabel(researchObject.getLabel());
			newResearchObject.setMetadata(researchObject.getMetadata());
			newResearchObject.setFormatmetadata(researchObject.getFormatmetadata());
			newResearchObject.setResearchObjectType(researchObject.getFormatmetadata());
			
			try {
				super.updateResearchObject(newResearchObject);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
			
			if (projectId !=0)
				check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, researchObjectId, researchObjectVersion);
		}
		return researchObjectVersion;
	}
	

}




