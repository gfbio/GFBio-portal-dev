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
import com.liferay.portal.kernel.exception.SystemException;

import org.gfbio.NoSuchProject_UserException;
import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.ResearchObjectFinderUtil;
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
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectAbsolutParent (JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		if (json.containsKey("researchobjectid")){
			responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getTopParent((long)json.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR", "Faile by find absolut parent");
		}
		else
			responseJson.put("ERROR", "No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectParent (JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		if (json.containsKey("researchobjectid")){
			responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getDirectParent((long)json.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR", "Faile by find parent");
		}
		else
			responseJson.put("ERROR", "No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getResearchObjectsByParent (JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		if (json.containsKey("researchobjectid")){
			responseJson = ResearchObjectLocalServiceUtil.constructResearchObjectsJson(ResearchObjectLocalServiceUtil.getDirectChildren((long)json.get("researchobjectid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR", "Faile by find research objects by parent");
		}
		else
			responseJson.put("ERROR", "No key 'researchobjectid' exist.");
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
		System.out.println(researchObjectList.size());
	
		researchObject = researchObjectList.get(0);
		System.out.println(researchObject);

		secondList.add(researchObject);
		System.out.println(researchObjectList.size());
		while (researchObjectList.size () >0){
			System.out.println("----");
			secondList.add(researchObjectList.get(0));
			System.out.println(researchObjectList.get(0).getResearchObjectID());
			//researchObjectList.addAll( ResearchObjectLocalServiceUtil.getDirectChildren(researchObjectList.get(0).getResearchObjectID()));
			System.out.println("|||||");			
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
	public ResearchObject getResearchObjectById(long researchObjectId) throws NoSuchResearchObjectException, SystemException{
		return researchObjectPersistence.findByResearchObjectID(researchObjectId);
	}
	
	
	//
	public JSONObject getResearchObjectASJsonById(long researchObjectId) {
		JSONObject json = new JSONObject();
		json = null;
		try {
			json =  ResearchObjectLocalServiceUtil.constructResearchObjectJson(ResearchObjectLocalServiceUtil.getResearchObjectById(researchObjectId));
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
			json.put("researchobjectversion", researchObject.getVersion());		
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
	public JSONObject constructResearchObjectsJson (List <ResearchObject> researchObjectList){

		JSONObject json = new JSONObject();
		if (researchObjectList.size()>0)
			for (int i =0; i < researchObjectList.size();i++)
				json.put((new Integer(i)).toString(), ResearchObjectLocalServiceUtil.constructResearchObjectJson(researchObjectList.get(i)));
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
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createResearchObjectByJson(JSONObject json){

		long researchObjectId = 0;
		JSONObject responeJson = new JSONObject();
		
		if (json.containsKey("name") && json.containsKey("label") && json.containsKey("metadata") && json.containsKey("researchobjecttype")){

			String name = ((String) json.get("name")).trim();
			String label = ((String) json.get("label")).trim();
			String metadata = json.get("metadata").toString();
			String researchObjectType = ((String) json.get("researchobjecttype")).trim();
			
			try {
				researchObjectId = ResearchObjectLocalServiceUtil.createResearchObject(name, label, metadata, researchObjectType);
			} catch (SystemException e) {e.printStackTrace();}
			
			
			if (json.containsKey("projectid"))
				try {
					researchObjectId = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) json.get("projectid"), researchObjectId) - (long) json.get("projectid");
				} catch (NoSuchProject_UserException | SystemException e) {e.printStackTrace();}
			
			
			if (json.containsKey("parentresearchobjectid"))
				researchObjectId = ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(researchObjectId, (long) json.get("parentresearchobjectid"));
			
			
			responeJson.put("researchobjectid", researchObjectId);

		}else
			responeJson.put("ERROR", "The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings");
		return responeJson;
	}

	
	//
	public long createResearchObject (String name, String label, String metadata, String researchObjectType) throws SystemException{
		long researchObjectId = 0;
		int researchObjectVersion = 0;
		String formatmetadata =	ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
		return ResearchObjectLocalServiceUtil.updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType) ;
	}
	
	
	//
	public long createResearchObjectWithProject (long projectId, String name, String label, String metadata, String researchObjectType) throws SystemException{
		long researchObjectId = 0;
		int researchObjectVersion = 0;
		String formatmetadata =	ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
		return ResearchObjectLocalServiceUtil.updateResearchObjectWithProject(projectId, researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType) ;
	}
		
	
	//
	public long updateParentResearchObjectIdByIds(long researchObjectId, long parentResearchObjectId){

		long check =0;
		ResearchObject researchObject = null;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(researchObjectId);
		} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}

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

		researchObjectVersion = researchObjectVersion+1;
		ResearchObject researchObject = null;
		long check =0;
		
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(researchObjectId);
		} catch (NoSuchResearchObjectException | SystemException e) {e.printStackTrace();}

		if (researchObject == null)
			try {
				researchObject = researchObjectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {e.printStackTrace();}
		researchObject.setName(name);
		researchObject.setLabel(label);
		researchObject.setMetadata(metadata);
		researchObject.setFormatmetadata(formatmetadata);
		researchObject.setVersion(researchObjectVersion);
		researchObject.setResearchObjectType(researchObjectType);
		try {
			super.updateResearchObject(researchObject);
			check = researchObject.getResearchObjectID();
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject updateResearchObjectByJson(JSONObject json){

		JSONObject responeJson = new JSONObject();
		
		if (json.containsKey("researchobjectid")){
			long researchObjectId = (long) json.get("researchobjectid");
			if (json.containsKey("researchobjectversion") && json.containsKey("name") && json.containsKey("label") && json.containsKey("metadata") && json.containsKey("researchobjecttype")){
				int researchObjectVersion = (int)((long) json.get("researchobjectversion"));
				String name = ((String) json.get("name")).trim();
				String label = ((String) json.get("label")).trim();
				String metadata = json.get("metadata").toString();
				String researchObjectType = ((String) json.get("researchobjecttype")).trim();
				String formatmetadata = ResearchObjectLocalServiceUtil.constructFormatMetadata(metadata);
				researchObjectId = updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType);
				
				if (json.containsKey("projectid"))
					try {
						researchObjectId = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject((long) json.get("projectid"), researchObjectId) - (long) json.get("projectid");
					} catch (NoSuchProject_UserException | SystemException e) {e.printStackTrace();}
				
				if (json.containsKey("parentresearchobjectid"))
					researchObjectId = ResearchObjectLocalServiceUtil.updateParentResearchObjectIdByIds(researchObjectId, (long) json.get("parentresearchobjectid"));
				
				responeJson.put("researchobjectid", researchObjectId);
			}else
				responeJson.put("ERROR", "The json need minimal 'name', 'label', 'metadata' and 'researchobjecttype' as Strings");
		}
		else{
			responeJson = ResearchObjectLocalServiceUtil.createResearchObjectByJson(json);
		}
		
		return responeJson;
	}
	
	
	//
	public long updateResearchObjectWithProject(long projectId, long researchObjectId, int researchObjectVersion, String name, String label, String metadata, String formatmetadata, String researchObjectType)  {

		long check =0;
		try {
			check = ResearchObjectLocalServiceUtil.updateResearchObject(researchObjectId, researchObjectVersion, name, label, metadata, formatmetadata, researchObjectType);
			check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectId, check) - projectId;
		} catch (SystemException | NoSuchProject_UserException e1) {e1.printStackTrace();	}
		return check;
	}

}