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

import java.util.Date;
import java.util.List;

import org.gfbio.model.SubmissionRegistry;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.base.SubmissionRegistryLocalServiceBaseImpl;
import org.gfbio.service.persistence.SubmissionRegistryFinderUtil;
import org.gfbio.service.persistence.SubmissionRegistryPK;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.json.simple.JSONObject;

/**
 * The implementation of the submission registry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.SubmissionRegistryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.SubmissionRegistryLocalServiceBaseImpl
 * @see org.gfbio.service.SubmissionRegistryLocalServiceUtil
 */
public class SubmissionRegistryLocalServiceImpl	extends SubmissionRegistryLocalServiceBaseImpl {
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getSubmissionRegistriesByBrokerSubmissionId (JSONObject json) throws SystemException{
		
		JSONObject responseJson = new JSONObject();
		if (json.containsKey("brokersubmissionid")){
			responseJson = SubmissionRegistryLocalServiceUtil.constructSubmissionRegistriesJson(SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByBrokerSubmissionId((String)json.get("brokersubmissionid")));
			if (responseJson.toString().equals("{}"))
				responseJson.put("ERROR", "Failed by response submission registry");
		}
		else
			responseJson.put("ERROR", "No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getSubmissionRegistriesByResearchObjectId (JSONObject json){

		JSONObject responseJson = new JSONObject();
		if (json.containsKey("researchobjectid")){
			try {
				responseJson = SubmissionRegistryLocalServiceUtil.constructSubmissionRegistriesJson(SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByResearchObjectId((long)json.get("researchobjectid")));
			} catch (SystemException e) {
				e.printStackTrace();
				responseJson.put("ERROR", e);}
		}
		else
			responseJson.put("ERROR", "No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
		
	//
	@SuppressWarnings({ "unchecked", "null" })
	public List<String> getArchivePIdsOfENA (String archivePId){
		List <String> list = null;
		list = SubmissionRegistryFinderUtil.getArchivePIdsOfENA(archivePId);
		if (list == null)
			list.add("null");
		return list;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "null" })
	public List<String> getArchivePIdsWithTypeOfENA (String archivePId, String researchObjectType){
		List <String> list = null;
		list = SubmissionRegistryFinderUtil.getArchivePIdsWithTypeOfENA(archivePId, researchObjectType);
		if (list == null)
			list.add("null");
		return list;
	}
	
	
	//
	public List<String>  getArchivePIdsWithTypeSampleOfENA (String archivePId){
		return SubmissionRegistryLocalServiceUtil.getArchivePIdsWithTypeOfENA(archivePId, "sample");
	}
	
	
	//
	public String getArchivePIdWithTypeStudyOfENA (String archivePId){
		return (String) SubmissionRegistryLocalServiceUtil.getArchivePIdsWithTypeOfENA(archivePId, "study").get(0);
	}
	
	
	// get the latest Versions of a specific Submission
	public SubmissionRegistry getLatestSubmissionByIds (long researchObjectId, String archive ){
		return SubmissionRegistryFinderUtil.getLatestSubmissionByIds(researchObjectId, archive).get(0);
	}
	
	
	// get the latest Versions of a specific ResearchObject
	public List<SubmissionRegistry> getLatestSubmissionsByArchive (String archive){
		return SubmissionRegistryFinderUtil.getLatestSubmissionsByArchive(archive);
	}
	
	
	
	// get the latest Versions of a specific ResearchObject
	public List<SubmissionRegistry> getLatestSubmissionsByResearchObjectId (long researchObjectId){
		return SubmissionRegistryFinderUtil.getLatestSubmissionsByResearchObjectId(researchObjectId);
	}
	
		
	// get the latest Versions of all Submissions
	public List<SubmissionRegistry> getLatestSubmissions (){
		return SubmissionRegistryFinderUtil.getLatestSubmissions();
	}

		
	//
	public List<SubmissionRegistry> getSubmissionRegistriesByBrokerSubmissionId (String brokerSubmissionId) throws SystemException{
		return submissionRegistryPersistence.findByBrokerSubmissionID(brokerSubmissionId);
	}
	
	
	//
	public List<SubmissionRegistry> getSubmissionRegistriesByResearchObjectId (long researchObjectId) throws SystemException{
		return submissionRegistryPersistence.findByResearchObjectID(researchObjectId);
	}
	
	
	//
	public String GetStatusByIds(long researchObjectId, int ResearchObjectVersion, String archive) {
		return (String) SubmissionRegistryFinderUtil.getStatusByIds(researchObjectId, ResearchObjectVersion, archive).get(0);
	}
	
	
	//
	public SubmissionRegistry getSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionRegistryFinderUtil.getSubmissionRegistry(researchObjectId, researchObjectVersion, archive).get(0);
	}
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructSubmissionRegistriesJson (List <SubmissionRegistry> submissionRegistryList){
		JSONObject json = new JSONObject();
		for (int i =0; i < submissionRegistryList.size();i++)
			json.put((new Integer(i)).toString(), SubmissionRegistryLocalServiceUtil.constructSubmissionRegistryJson(submissionRegistryList.get(i)));
		return json;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructSubmissionRegistryJson (SubmissionRegistry submissionRegistry){
		JSONObject json = new JSONObject();
		json.put("researchobjectid", submissionRegistry.getResearchObjectID());
		json.put("researchobjectversion", submissionRegistry.getResearchObjectVersion());	
		json.put("archive", submissionRegistry.getArchive());
		json.put("archivepid", submissionRegistry.getArchivePID());
		json.put("archivepidtype", submissionRegistry.getArchivePIDType());
		json.put("brokersubmissionid", submissionRegistry.getBrokerSubmissionID());
		json.put("userid", submissionRegistry.getUserID());
		json.put("lastchanged", submissionRegistry.getLastChanged());
		json.put("ispublic", submissionRegistry.getIsPublic());
		json.put("publicafter", submissionRegistry.getPublicAfter());
		json.put("status", submissionRegistry.getStatus());
		return json;
	}
	
	
	//
	public String constructStatus(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		String status ="";
		
		if (archivePId != null && !(archivePId.equals("")))
			status = "archived";
		else
			status = SubmissionRegistryLocalServiceUtil.GetStatusByIds(researchObjectId, researchObjectVersion, archive);
		return status;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createSubmissionRegistry (JSONObject json){
		
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		if (json.containsKey("researchobjectid") && json.containsKey("researchobjectversion") && json.containsKey("archive") && json.containsKey("brokersubmissionid") && json.containsKey("archivepid")&& json.containsKey("lastchanged")&& json.containsKey("userid")){

			long researchObjectId =(long)json.get("researchobjectid");
			int researchObjectVersion = (int)((long) json.get("researchobjectversion"));
			String archive = ((String)json.get("archive")).trim();
			String brokerSubmissionId = ((String)json.get("brokersubmissionid")).trim();
			String archivePId =((String)json.get("archivepid")).trim();
			Date lastChanged = new Date ((long)json.get("lastchanged"));
			long userId = (long)json.get("userid");

			if (!(json.containsKey("status")) && json.containsKey("archivepidtype"))
				check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, (long) json.get("archivepidtype"),lastChanged, userId);

			if (!(json.containsKey("status") && json.containsKey("archivepidtype")))
				check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, lastChanged, userId);
	
			if (check && json.containsKey("status") && !(json.containsKey("archivepidtype")))
				check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, lastChanged, userId, ((String) json.get("status")).trim());

			if (json.containsKey("status") && json.containsKey("archivepidtype"))
				check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry( researchObjectId,  researchObjectVersion,  archive,  brokerSubmissionId, archivePId, (long) json.get("archivepidtype"), lastChanged,  userId,  ((String) json.get("status")).trim());
			
			if (json.containsKey("ispublic"))
				check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) json.get("ispublic"));
			
			if (json.containsKey("publicafter"))
				check = SubmissionRegistryLocalServiceUtil.updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) json.get("publicafter")));
			

			if (check == true){
				responseJson.put("researchobjectid", researchObjectId);
				responseJson.put("researchobjectversion", researchObjectVersion);
				responseJson.put("archive", archive);
			}
			else
				responseJson.put("ERROR", "Faile by create submission registry entry");
		}
		else
			responseJson.put("ERROR", "One or more basic attributs are not correct");
		
		return responseJson;
	}

	
	//
	@SuppressWarnings("unchecked")
	public JSONObject updateSubmissionRegistry (JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		SubmissionRegistry submissionRegistry = null;
		
		if (json.containsKey("researchobjectid") && json.containsKey("researchobjectversion") && json.containsKey("archive")&& json.containsKey("userid")){

			long researchObjectId =(long)json.get("researchobjectid");
			int researchObjectVersion = (int)((long) json.get("researchobjectversion"));
			String archive = ((String)json.get("archive")).trim();
			SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
			try {
				submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}		

			if (submissionRegistry != null){
				
				Boolean check = false;
			
				check = SubmissionRegistryLocalServiceUtil.updateUserId(researchObjectId, researchObjectVersion, archive, (long) json.get("userid"));
			
				if (json.containsKey("brokersubmissionid"))
					check = SubmissionRegistryLocalServiceUtil.updateBrokerSubmissionId(researchObjectId, researchObjectVersion, archive, ((String) json.get("brokersubmissionid")).trim());

				if (json.containsKey("archivepid"))
					check = SubmissionRegistryLocalServiceUtil.updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String) json.get("archivepid")).trim());

				if (json.containsKey("lastchanged"))
					check = SubmissionRegistryLocalServiceUtil.updateLastChanged(researchObjectId, researchObjectVersion, archive, new Date ((long) json.get("lastchanged")));

				if (json.containsKey("archivepidtype"))
					check = SubmissionRegistryLocalServiceUtil.updateArchivePIdType(researchObjectId, researchObjectVersion, archive, (long) json.get("archivepidtype"));

				if (json.containsKey("status"))
					check = SubmissionRegistryLocalServiceUtil.updateStatus(researchObjectId, researchObjectVersion, archive, ((String) json.get("status")).trim());

				if (json.containsKey("ispublic"))
					check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) json.get("ispublic"));

				if (json.containsKey("publicafter"))
					check = SubmissionRegistryLocalServiceUtil.updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) json.get("publicafter")));
				

				if (check == true){
					responseJson.put("researchobjectid", researchObjectId);
					responseJson.put("researchobjectversion", researchObjectVersion);
					responseJson.put("archive", archive);
				}
				else
					responseJson.put("ERROR", "Faile by create submission registry entry");				
			
				
			}else
				responseJson = SubmissionRegistryLocalServiceUtil.createSubmissionRegistry(json);
			
		}
		else
			responseJson.put("ERROR", "A entry with this PK don't exist in SubmissionRegistry");	
		
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//
	

	
	//update without status
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, Date lastChanged, long userId){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, lastChanged, userId, SubmissionRegistryLocalServiceUtil.constructStatus(researchObjectId, researchObjectVersion, archive, archivePId));
	}
	
	
	//update without status and archivepidtype: 
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, archivePIdType, lastChanged, userId, SubmissionRegistryLocalServiceUtil.constructStatus(researchObjectId, researchObjectVersion, archive, archivePId));
	}
	
	
	//update without archivePIdType
	@SuppressWarnings("rawtypes")
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, Date lastChanged, long userId, String status){
		
		Boolean check = false;
		List  pIdList = DataProviderLocalServiceUtil.getPersistentIdentiferIds(DataProviderLocalServiceUtil.getDataProviderIdByLabel(archive));
		if (pIdList.size()==1) 
			check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, (long) pIdList.get(0), lastChanged, userId, status);
		else
			check = false;
		return check;
	}
	
	
	//
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId, String status){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);

		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (submissionRegistry == null){
			submissionRegistry = submissionRegistryPersistence.create(pk);
			submissionRegistry.setResearchObjectID(researchObjectId);
			submissionRegistry.setResearchObjectVersion(researchObjectVersion);
			submissionRegistry.setArchive(archive);
		}
		submissionRegistry.setBrokerSubmissionID(brokerSubmissionId);
		submissionRegistry.setArchivePID(archivePId);
		submissionRegistry.setArchivePIDType(archivePIdType);
		submissionRegistry.setLastChanged(lastChanged);
		submissionRegistry.setUserID(userId);
		submissionRegistry.setStatus(status);

		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		return check;
	}
	

	//
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId, String status, Boolean isPublic, Date publicAfter){

		Boolean check = false;
		check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, archivePIdType, lastChanged, userId, status);
		check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archivePId, isPublic);
		check = SubmissionRegistryLocalServiceUtil.updatePublicAfter(researchObjectId, researchObjectVersion, archivePId, publicAfter);
		return check;
	}

	
	//
	@SuppressWarnings("null")
	public Boolean updateSubmissionRegistryWithoutPId (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, Date lastChanged, long userID, String status){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		
		if (submissionRegistry == null){
			submissionRegistry.setResearchObjectID(researchObjectId);
			submissionRegistry.setResearchObjectVersion(researchObjectVersion);
			submissionRegistry.setArchive(archive);
		}
		submissionRegistry.setBrokerSubmissionID(brokerSubmissionId);
		submissionRegistry.setLastChanged(lastChanged);
		submissionRegistry.setUserID(userID);
		submissionRegistry.setStatus(status);
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
	
		
		return check;
	}

		
	//-------------------------------  Update Attribute Functions ----------------------------------------------//

	
	//
	public Boolean updateArchivePId(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		

		if (submissionRegistry != null){
			submissionRegistry.setArchivePID(archivePId.trim());
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
	
		return check;
	}
	
	
	//
	public Boolean updateArchivePIdType(long researchObjectId, int researchObjectVersion, String archive, long archivePIdType){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		

		if (submissionRegistry != null){
			submissionRegistry.setArchivePIDType(archivePIdType);;
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
	
		return check;
	}
	

	//
	public Boolean updateBrokerSubmissionId(long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null){
			submissionRegistry.setBrokerSubmissionID(brokerSubmissionId.trim());
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateIsPublic(long researchObjectId, int researchObjectVersion, String archive, Boolean isPublic){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null){
			submissionRegistry.setIsPublic(isPublic);
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateLastChanged(long researchObjectId, int researchObjectVersion, String archive, Date lastChanged){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		

		if (submissionRegistry != null){
			submissionRegistry.setLastChanged(lastChanged);
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updatePublicAfter(long researchObjectId, int researchObjectVersion, String archive, Date publicAfter){
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		

		if (submissionRegistry != null){
			submissionRegistry.setPublicAfter(publicAfter);
			try {
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		}
		return check;
	}
	
	
	//
	public Boolean updateStatus (long researchObjectId, int researchObjectVersion, String archive, String status){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		submissionRegistry.setStatus(status);
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		return check;
	}

	
	//
	public Boolean updateUserId (long researchObjectId, int researchObjectVersion, String archive, long userId){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		submissionRegistry.setUserID(userId);
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		return check;
	}

}