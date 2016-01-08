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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gfbio.model.SubmissionRegistry;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.base.SubmissionRegistryLocalServiceBaseImpl;
import org.gfbio.service.persistence.SubmissionRegistryFinderUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
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
	@SuppressWarnings("unchecked")
	public JSONArray getLatestXPublicSubmissionsByX (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("latestx");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("latestx")){
			if (requestJson.get("latestx").getClass().toString().equals("class java.lang.Long"))
				responseJson = constructSubmissionRegistriesJson(getLatestXPublicSubmissionsByX((int)((long)requestJson.get("latestx"))));
			else
				responseJson = constructSubmissionRegistriesJson(getLatestXPublicSubmissionsByX((int)requestJson.get("latestx")));
			if (responseJson.toString().equals("[]"))
				responseJson.add("ERROR: Failed by response submission registry");
		}
		else
			responseJson.add("ERROR: No key 'latestx' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionRegistriesByBrokerSubmissionId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("brokersubmissionid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("brokersubmissionid")){
			try {
				responseJson = constructSubmissionRegistriesJson(getSubmissionRegistriesByBrokerSubmissionId((String)requestJson.get("brokersubmissionid")));
			} catch (SystemException e) {e.printStackTrace();}
			if (responseJson.toString().equals("[]"))
				responseJson.add("ERROR: Failed by response submission registry");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionRegistriesByResearchObjectId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("researchobjectid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("researchobjectid")){
			try {
				responseJson = constructSubmissionRegistriesJson(getSubmissionRegistriesByResearchObjectId((long)requestJson.get("researchobjectid")));
			} catch (SystemException e) {
				e.printStackTrace();
				responseJson.add("ERROR: Build Array is failed.");}
			}
			else
				responseJson.add("ERROR: No key 'researchobjectid' exist.");
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
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
		return getArchivePIdsWithTypeOfENA(archivePId, "sample");
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
		return (String) getArchivePIdsWithTypeOfENA(archivePId, "study").get(0);
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
	
	
	// get the latest X public Entries of all Submissions
	public List<SubmissionRegistry> getLatestXPublicSubmissionsByX (int latestX){
		return SubmissionRegistryFinderUtil.getLatestXPublicSubmissionsByX(latestX);
	}

		
	//
	public String getStatus(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		
		String status ="sent";
		
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
	@SuppressWarnings("rawtypes")
	public long getSubmissionIdByIds(long researchObjectId, int ResearchObjectVersion, String archive) {
		long submissionid =0;
		List submissionIdList = SubmissionRegistryFinderUtil.getSubmissionIdByIds(researchObjectId, ResearchObjectVersion, archive);
		if (submissionIdList.size()>0)
			submissionid = (long) submissionIdList.get(0);
		return submissionid;
	}
	
	
	//
	public SubmissionRegistry getSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionRegistryFinderUtil.getSubmissionRegistry(researchObjectId, researchObjectVersion, archive).get(0);
	}
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	

	//
	public String checkForIgnoredParameter (Object[] objects, Set<String> keyList){

		String ignoredParameter = "WARNING:";
		Boolean check = false;
		
		for (int i =0; i < objects.length;i++)
			if (!keyList.contains((objects[i]))){
				ignoredParameter = ignoredParameter.concat(" ").concat(objects[i].toString()).concat(",");
				check = true;
			}
		if (check == true)
			ignoredParameter = ignoredParameter.substring(0, ignoredParameter.length()-1).concat(" are not parameters of this method.");
		else
			ignoredParameter ="";
		
		return ignoredParameter;
	}
	
	
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
		json.put("lastchanged", submissionRegistry.getLastChanged().toString());
		json.put("ispublic", submissionRegistry.getIsPublic());
		if (submissionRegistry.getPublicAfter() != null)
			json.put("publicafter", submissionRegistry.getPublicAfter().toString());
		else
			json.put("publicafter", "");
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
		Set<String> set = new HashSet<String>();
		String [] keySet = {"archive", "archivepidtype", "archivepid", "brokersubmissionid", "ispublic", "publicafter", "researchobjectid", "researchobjectversion", "status", "userid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion") && requestJson.containsKey("archive") && requestJson.containsKey("brokersubmissionid") && requestJson.containsKey("userid")){

			long researchObjectId =(long)requestJson.get("researchobjectid");
			int researchObjectVersion = (int)((long) requestJson.get("researchobjectversion"));
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			long userId = (long)requestJson.get("userid");
			SubmissionRegistry submissionRegistry = null;
			long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
			if (submissionid !=0)
				try {
					submissionRegistry = submissionRegistryPersistence.findByPrimaryKey(submissionid);
				} catch (SystemException | NoSuchModelException e) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+submissionid+ " and will be create now");}
			
			if (submissionRegistry==null){
				
				check = updateKernelSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);
				
				if (check){

					if (requestJson.containsKey("status"))
						check = updateStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("status"));
					else if (!(requestJson.containsKey("status")) && requestJson.containsKey("archivepidtype"))	
						check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("archivepidtype")));
					else if(!requestJson.containsKey("status"))
						check = updateStatus(researchObjectId, researchObjectVersion, archive, "sent");
					
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
					
					if (requestJson.containsKey("publicafter")){
						if (((String) requestJson.get("publicafter")).substring(4, 4).equals("-"))
							try {
								DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
								check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, dateFormat.parse((String) requestJson.get("publicafter")));	
							} catch (ParseException e) {e.printStackTrace();}
						else
							check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) requestJson.get("publicafter")));
					}
					
					if (check){
						keyJson.put("researchobjectid", researchObjectId);
						keyJson.put("researchobjectversion", researchObjectVersion);
						keyJson.put("archive", archive);
					}
				}
				else
					keyJson.put("ERROR","ERROR: Faile by create submission registry entry");
			}
			else
				keyJson.put("ERROR","ERROR: A entry already exists to this ResearchObject with this Version to this Archive.");
		}
		else{
			String errorString = "ERROR: Mandatory attribut";
			if (!requestJson.containsKey("archive"))
				errorString = errorString.concat(" 'archive',");
			if (!requestJson.containsKey("brokersubmissionid"))
				errorString = errorString.concat(" 'brokersubmissionid',");
			if (!requestJson.containsKey("researchobjectid"))
				errorString = errorString.concat(" 'researchobjectid',");
			if (!requestJson.containsKey("researchobjectversion"))
				errorString = errorString.concat(" 'researchobjectversion',");
			if (!requestJson.containsKey("userid"))
				errorString = errorString.concat(" 'userid',");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
			keyJson.put("ERROR", errorString);
		}
		if (!ignoreParameter.equals(""))
			keyJson.put("WARNING", ignoreParameter);
			
		return keyJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateSubmissionRegistry (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(updateSubmissionRegistry((JSONObject) requestJson.get(i)));
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject updateSubmissionRegistry (JSONObject requestJson){
		
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		SubmissionRegistry submissionRegistry = null;
		Set<String> set = new HashSet<String>();
		String [] keySet = {"archive", "archivepidtype", "archivepid", "brokersubmissionid", "ispublic", "publicafter", "researchobjectid", "status", "userid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
			
		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("archive") && requestJson.containsKey("archivepid") && requestJson.containsKey("brokersubmissionid")&& requestJson.containsKey("userid") ){
	
			long researchObjectId =(long)requestJson.get("researchobjectid");
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			long userId = (long)requestJson.get("userid");
			int researchObjectVersion = getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId);

			long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
			if (submissionid !=0)
				try {
					submissionRegistry = submissionRegistryPersistence.findByPrimaryKey(submissionid);
				} catch (SystemException | NoSuchModelException e) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+submissionid+ " and will be create now");}
		
			if (submissionRegistry != null){
				
				check = updateKernelSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);
				check = SubmissionRegistryLocalServiceUtil.updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String) requestJson.get("archivepid")).trim());
				
				if (requestJson.containsKey("status"))
					check = updateStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("status"));
				else if (!(requestJson.containsKey("status")) && requestJson.containsKey("archivepidtype"))
					if (requestJson.get("archivepidtype").getClass().toString().equals("class java.lang.String"))
						check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("archivepidtype")));
					else
						check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, ((Long) requestJson.get("archivepidtype")).toString()));
				
				if (requestJson.containsKey("archivepidtype"))
					check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, (long) requestJson.get("archivepidtype") );

				if (requestJson.containsKey("ispublic"))
					check = updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) requestJson.get("ispublic"));
	
				if (requestJson.containsKey("publicafter"))
					if (requestJson.get("publicafter").getClass().toString().equals("class java.lang.String"))
						try {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mmZ");
							check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, dateFormat.parse((String) requestJson.get("publicafter")));	
						} catch (ParseException e) {e.printStackTrace();}
					else
						check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) requestJson.get("publicafter")));
				
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
		else{
			String errorString = "ERROR: Mandatory attribut";
			if (!requestJson.containsKey("archive"))
				errorString = errorString.concat(" 'archive',");
			if (!requestJson.containsKey("archiveid"))
				errorString = errorString.concat(" 'archiveid',");
			if (!requestJson.containsKey("brokersubmissionid"))
				errorString = errorString.concat(" 'brokersubmissionid',");
			if (!requestJson.containsKey("researchobjectid"))
				errorString = errorString.concat(" 'researchobjectid',");
			if (!requestJson.containsKey("userid"))
				errorString = errorString.concat(" 'userid',");
			errorString = errorString.substring(0, errorString.length()-1).concat(" are not correct");
			responseJson.put("ERROR", errorString);
		}
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);

		return responseJson;
	}
	
		
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//
	public Boolean updateKernelSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, long userId){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = SubmissionRegistryLocalServiceUtil.getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+submissionid+ " and will be create now");}

		if (submissionRegistry == null)
			try {
				submissionRegistry = submissionRegistryPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				submissionRegistry.setResearchObjectID(researchObjectId);
				submissionRegistry.setResearchObjectVersion(researchObjectVersion);
				submissionRegistry.setArchive(archive);
			}catch (SystemException e) {e.printStackTrace();}
		submissionRegistry.setBrokerSubmissionID(brokerSubmissionId);
		submissionRegistry.setUserID(userId);
		submissionRegistry.setLastChanged(new Timestamp(new Date().getTime()));
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
		
	//
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId, String status){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+submissionid+ " and will be create now");}

		if (submissionRegistry == null)
			try {
				submissionRegistry = submissionRegistryPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				submissionRegistry.setResearchObjectID(researchObjectId);
				submissionRegistry.setResearchObjectVersion(researchObjectVersion);
				submissionRegistry.setArchive(archive);
			} catch (SystemException e) {e.printStackTrace();}
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
		
		check = updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, archivePIdType, lastChanged, userId, status);
		check = updateIsPublic(researchObjectId, researchObjectVersion, archivePId, isPublic);
		check = updatePublicAfter(researchObjectId, researchObjectVersion, archivePId, publicAfter);
		
		return check;
	}

	
	//
	public Boolean updateSubmissionRegistryWithoutPId (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, Date lastChanged, long userID, String status){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {System.out.println("Entry in SubmissionRegistry does not exist with pk: "+submissionid+ " and will be create now");}

		if (submissionRegistry == null)
			try {
				submissionRegistry = submissionRegistryPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				submissionRegistry.setResearchObjectID(researchObjectId);
				submissionRegistry.setResearchObjectVersion(researchObjectVersion);
				submissionRegistry.setArchive(archive);
			} catch (SystemException e) {e.printStackTrace();}
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
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (submissionRegistry != null)
			try {
				submissionRegistry.setArchivePID(archivePId.trim());
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	
	
	//
	public Boolean updateArchivePIdType(long researchObjectId, int researchObjectVersion, String archive, long archivePIdType){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null)
			try {
				submissionRegistry.setArchivePIDType(archivePIdType);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	

	//
	public Boolean updateBrokerSubmissionId(long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null)
			try {
				submissionRegistry.setBrokerSubmissionID(brokerSubmissionId.trim());
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateIsPublic(long researchObjectId, int researchObjectVersion, String archive, Boolean isPublic){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null)
			try {
				submissionRegistry.setIsPublic(isPublic);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateLastChanged(long researchObjectId, int researchObjectVersion, String archive, Date lastChanged){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (submissionRegistry != null)
			try {
				submissionRegistry.setLastChanged(lastChanged);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updatePublicAfter(long researchObjectId, int researchObjectVersion, String archive, Date publicAfter){
		
		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null)
			try {
				submissionRegistry.setPublicAfter(publicAfter);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateStatus (long researchObjectId, int researchObjectVersion, String archive, String status){

		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}

		if (submissionRegistry != null)
			try {
				submissionRegistry.setStatus(status);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

	
	//
	public Boolean updateUserId (long researchObjectId, int researchObjectVersion, String archive, long userId){

		Boolean check = false;
		long submissionid = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		SubmissionRegistry submissionRegistry = null;
		if (submissionid !=0)
			try {
				submissionRegistry = getSubmissionRegistry(submissionid);
			} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if (submissionRegistry != null)
			try {
				submissionRegistry.setUserID(userId);
				super.updateSubmissionRegistry(submissionRegistry);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

}