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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchSubmissionRegistryException;
import org.gfbio.model.SubmissionRegistry;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.base.SubmissionRegistryLocalServiceBaseImpl;
import org.gfbio.service.persistence.SubmissionRegistryFinderUtil;
import org.gfbio.service.persistence.SubmissionRegistryPK;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import org.json.simple.JSONArray;
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
	public JSONArray getSubmissionRegistriesByBrokerSubmissionId (JSONObject requestJson) throws SystemException{
		
		JSONArray responseJson = new JSONArray();

		if (requestJson.containsKey("brokersubmissionid")){
			responseJson = SubmissionRegistryLocalServiceUtil.constructSubmissionRegistriesJson(SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByBrokerSubmissionId((String)requestJson.get("brokersubmissionid")));
			if (responseJson.toString().equals("[]"))
				responseJson.add("ERROR: Failed by response submission registry");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionRegistriesByResearchObjectId (JSONObject requestJson){

		JSONArray responseJson = new JSONArray();

		if (requestJson.containsKey("researchobjectid")){
			try {
				responseJson = SubmissionRegistryLocalServiceUtil.constructSubmissionRegistriesJson(SubmissionRegistryLocalServiceUtil.getSubmissionRegistriesByResearchObjectId((long)requestJson.get("researchobjectid")));
			} catch (SystemException e) {
				e.printStackTrace();
				responseJson.add("ERROR: Build Array is failed.");}
			}
			else
				responseJson.add("ERROR: No key 'researchobjectid' exist.");
		
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

	
	//update without archivePIdType
	@SuppressWarnings("rawtypes")
	public long getArchivePIdType (String archive){
		
		long pId = 0;
		List  pIdList = DataProviderLocalServiceUtil.getPersistentIdentiferIds(DataProviderLocalServiceUtil.getDataProviderIdByLabel(archive));
		if (pIdList.size()==1) 
			pId = (long) pIdList.get(0);
		return pId;
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
	public String getStatus(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		String status ="";
		
		if (archivePId != null && !(archivePId.equals("")))
			status = "archived";
		else
			status = SubmissionRegistryLocalServiceUtil.GetStatusByIds(researchObjectId, researchObjectVersion, archive);
		return status;
	}

	
	//
	@SuppressWarnings("rawtypes")
	public int getResearchObjectVersion ( long researchObjectId, String archive, String brokerSubmissionId) {
		int researchObjectVersion = 0;
		List versionList  = SubmissionRegistryFinderUtil.getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId);
		if (versionList.size() >0)
			researchObjectVersion = (int) SubmissionRegistryFinderUtil.getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId).get(0);
		return researchObjectVersion;
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
	public JSONArray constructSubmissionRegistriesJson (List <SubmissionRegistry> submissionRegistryList){
		JSONArray responseJson = new JSONArray();
		for (int i =0; i < submissionRegistryList.size();i++)
			responseJson.add(SubmissionRegistryLocalServiceUtil.constructSubmissionRegistryJson(submissionRegistryList.get(i)));
		return responseJson;
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
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createSubmissionRegistry (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(createSubmissionRegistry((JSONObject) requestJson.get(i)));
		return responseJson;
	}

	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createSubmissionRegistry (JSONObject requestJson){
		
		Boolean check = false;
		JSONObject keyJson = new JSONObject();

		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion") && requestJson.containsKey("archive") && requestJson.containsKey("brokersubmissionid") && requestJson.containsKey("userid")){

			long researchObjectId =(long)requestJson.get("researchobjectid");
			int researchObjectVersion = (int)((long) requestJson.get("researchobjectversion"));
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			long userId = (long)requestJson.get("userid");
			
			SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
			SubmissionRegistry submissionRegistry = null;
			try {
				submissionRegistry = submissionRegistryPersistence.findByPrimaryKey(pk);
			} catch (NoSuchSubmissionRegistryException | SystemException e) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+pk+ " and will be create now");}
			
			if (submissionRegistry==null){

				check = updateKernelSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);

				if (check){

					if (requestJson.containsKey("status"))
						check = updateStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("status"));
					else if (!(requestJson.containsKey("status")) && requestJson.containsKey("archivepidtype"))	
						check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("archivepidtype")));
					else if(!requestJson.containsKey("status"))
						check = updateStatus(researchObjectId, researchObjectVersion, archive, "send");
					
					if (requestJson.containsKey("archivepidtype"))
						check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, (long) requestJson.get("archivepidtype") );
					else if (SubmissionRegistryLocalServiceUtil.getArchivePIdType(archive) !=0)
						check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, SubmissionRegistryLocalServiceUtil.getArchivePIdType(archive));
						
					if (requestJson.containsKey("archivepid"))
						check = SubmissionRegistryLocalServiceUtil.updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("archivepid")).trim());
							
					if (requestJson.containsKey("ispublic"))
						check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) requestJson.get("ispublic"));
					else
						check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archive, false);
					
					if (requestJson.containsKey("publicafter"))
						check = SubmissionRegistryLocalServiceUtil.updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) requestJson.get("publicafter")));
					
					if (check){
						keyJson.put("researchobjectid", researchObjectId);
						keyJson.put("researchobjectversion", researchObjectVersion);
						keyJson.put("archive", archive);
				}	}
				else
					keyJson.put("ERROR","ERROR: Faile by create submission registry entry");
			}
			else
				keyJson.put("ERROR","ERROR: A entry already exists to this ResearchObject with this Version to this Archive.");
		}
		else
			keyJson.put("ERROR","ERROR: One or more basic attributs are not correct");

		return keyJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateSubmissionRegistry (JSONArray requestJson){
		
		System.out.println(requestJson);
		JSONArray responseJson = new JSONArray();
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(updateSubmissionRegistry((JSONObject) requestJson.get(i)));
		System.out.println(responseJson);
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject updateSubmissionRegistry (JSONObject requestJson){
		
		System.out.println(requestJson);
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		SubmissionRegistry submissionRegistry = null;
			
		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("archive") && requestJson.containsKey("archivepid") && requestJson.containsKey("brokersubmissionid")&& requestJson.containsKey("userid") ){
	
			long researchObjectId =(long)requestJson.get("researchobjectid");
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			long userId = (long)requestJson.get("userid");

			int researchObjectVersion = getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId);
			SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
						
			try {
				submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}		
	
			if (submissionRegistry != null){
					
				check = updateKernelSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);			
				check = SubmissionRegistryLocalServiceUtil.updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String) requestJson.get("archivepid")).trim());
				
				if (requestJson.containsKey("status"))
					check = updateStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("status"));
				else if (!(requestJson.containsKey("status")) && requestJson.containsKey("archivepidtype"))	
					check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("archivepidtype")));
	
				if (requestJson.containsKey("archivepidtype"))
					check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, (long) requestJson.get("archivepidtype") );

				if (requestJson.containsKey("ispublic"))
					check = SubmissionRegistryLocalServiceUtil.updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) requestJson.get("ispublic"));
	
				if (requestJson.containsKey("publicafter"))
					check = SubmissionRegistryLocalServiceUtil.updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) requestJson.get("publicafter")));
					
				if (check == true){
					responseJson.put("researchobjectid", researchObjectId);
					responseJson.put("researchobjectversion", researchObjectVersion);
					responseJson.put("archive", archive);
				}
				else
					responseJson.put("ERROR","ERROR: Faile by update submission registry entry");				
			}
			else
				responseJson = SubmissionRegistryLocalServiceUtil.createSubmissionRegistry(requestJson);
		}
		else
			responseJson.put("ERROR","ERROR: One or more mandatory attributes are not in the input");	

		System.out.println(responseJson);
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//
	public Boolean updateKernelSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, long userId){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		SubmissionRegistryPK pk = new SubmissionRegistryPK(researchObjectId, researchObjectVersion, archive);
		try {
			submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(pk);
		} catch (PortalException | SystemException e1) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+pk+ " and will be create now");}

		if (submissionRegistry == null){
			submissionRegistry = submissionRegistryPersistence.create(pk);
			submissionRegistry.setResearchObjectID(researchObjectId);
			submissionRegistry.setResearchObjectVersion(researchObjectVersion);
			submissionRegistry.setArchive(archive);
		}
		submissionRegistry.setBrokerSubmissionID(brokerSubmissionId);
		submissionRegistry.setUserID(userId);
		submissionRegistry.setLastChanged(new Timestamp(new Date().getTime()));
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		return check;
	}
	
		
	//update without status
/*	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, lastChanged, userId, SubmissionRegistryLocalServiceUtil.constructStatus(researchObjectId, researchObjectVersion, archive));
	}*/
	
	
/*	//update without status and archivepidtype: 
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, long archivePIdType, Date lastChanged, long userId){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePIdType, lastChanged, userId, SubmissionRegistryLocalServiceUtil.constructStatus(researchObjectId, researchObjectVersion, archive, archivePId));
	}*/
	
	
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