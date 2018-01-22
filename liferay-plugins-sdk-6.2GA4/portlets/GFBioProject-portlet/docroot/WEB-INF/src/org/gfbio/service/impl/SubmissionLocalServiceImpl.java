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



import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.gfbio.helper.ContactJira;
import org.gfbio.helper.Helper;
import org.gfbio.helper.RuntimeExec;
import org.gfbio.helper.StreamWrapper;
import org.gfbio.idmg.jiraclient.model.Project;
import org.gfbio.model.Submission;
import org.gfbio.service.DataProviderLocalServiceUtil;
import org.gfbio.service.PrimaryDataLocalServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionLocalServiceUtil;
import org.gfbio.service.base.SubmissionLocalServiceBaseImpl;
import org.gfbio.service.persistence.SubmissionFinderUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The implementation of the submission local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.SubmissionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.SubmissionLocalServiceBaseImpl
 * @see org.gfbio.service.SubmissionLocalServiceUtil
 */
public class SubmissionLocalServiceImpl extends SubmissionLocalServiceBaseImpl {

	

	private static Log _log = LogFactoryUtil.getLog(SubmissionLocalServiceImpl.class);
	
	/////////////////////////////////// Delete Functions /////////////////////////////////////////////////

	
	//------------------------------ Manage Delete Functions --------------------------------------------//
	
	
	@SuppressWarnings("unchecked")
	public JSONObject deleteSubmission (JSONObject requestJson){
		JSONObject responseJson = new JSONObject();
		Boolean check = false;

		if (requestJson.containsKey("submissionid"))
			check = deleteSubmissionBySubmissionId(Helper.getLongFromJson(requestJson, "submissionid"));
		else
			if (requestJson.containsKey("brokersubmissionid"))
				check = deleteSubmissionByBrokerSubmissionId((String)requestJson.get("brokersubmissionid"));
			else
				if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion") &&requestJson.containsKey("archive"))
					check = deleteSubmissionByIds(Helper.getLongFromJson(requestJson, "researchobjectid"), Helper.getIntFromJson(requestJson, "researchobjectversion"), Helper.getStringFromJson(requestJson, "archive"));
				else
					if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("researchobjectversion"))
						check = deleteSubmissionByResearchObjectIdAndVersion(Helper.getLongFromJson(requestJson, "researchobjectid"), Helper.getIntFromJson(requestJson, "researchobjectversion"));
		
		responseJson.put("check", check);
		return responseJson;
	}
	
	
	//--------------------------------- Delete Functions ------------------------------------------------//
	
	
	//
	private Boolean deleteSubmissionBySubmissionId(long submissionId){
		
		if (checkOfSubmissionId(submissionId) != null)
			try {deleteSubmission(submissionId);}
			catch (PortalException | SystemException e) {e.printStackTrace();}

		return !checkOfSubmissionId(submissionId);
	}

	
	//
	private Boolean deleteSubmissionByBrokerSubmissionId(String  brokerSubmissionId){
		
		if (checkOfBrokerSubmissionId(brokerSubmissionId)){
			JSONArray submissionIdArray = getSubmissionIdsByBrokerSubmissionId(brokerSubmissionId);
			for (int i =0; i < submissionIdArray.size();i++)
				try {deleteSubmission((long) submissionIdArray.get(i));}
				catch (PortalException | SystemException e) {e.printStackTrace();}	
		}
		
		return !checkOfBrokerSubmissionId(brokerSubmissionId);
	}
	
	
	//
	private Boolean deleteSubmissionByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion){
		
		if (checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
			JSONArray submissionIdArray = getSubmissionIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
			for (int i =0; i < submissionIdArray.size();i++)
				try {deleteSubmission((long) submissionIdArray.get(i));}
				catch (PortalException | SystemException e) {e.printStackTrace();}	
		}
		
		return !checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	//
	private Boolean deleteSubmissionByIds(long researchObjectId, int researchObjectVersion, String archive){
		
		if (checkOfIds(researchObjectId, researchObjectVersion, archive))
			try {deleteSubmission(getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive));}
			catch (PortalException | SystemException e) {e.printStackTrace();}
		
		
		return !checkOfIds(researchObjectId, researchObjectVersion, archive);
	}
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
		
	
	//
	@SuppressWarnings("unchecked")
	public JSONObject getBrokerSubmissionId (JSONObject requestJson){
		
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"archive","researchobjectid","researchobjectversion"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("archive")&&requestJson.containsKey("researchobjectid")&&requestJson.containsKey("researchobjectversion")){
			
			long researchObjectId =(long)requestJson.get("researchobjectid");
			int researchObjectVersion = (int)((long) requestJson.get("researchobjectversion"));
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = getBrokerSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
			
			responseJson.put("brokersubmissionid", brokerSubmissionId);

			if (responseJson.toString().equals("[]"))
				responseJson.put("error","ERROR: Failed by response submission registry");
		}
		else
			responseJson.put("error","ERROR: No key 'latestx' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("warning",ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getLatestXPublicSubmissionsByX (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("latestx");
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("latestx")){
			if (requestJson.get("latestx").getClass().toString().equals("class java.lang.Long"))
				responseJson = constructSubmissionsJson(getLatestXPublicSubmissionsByX((int)((long)requestJson.get("latestx"))));
			else
				responseJson = constructSubmissionsJson(getLatestXPublicSubmissionsByX((int)requestJson.get("latestx")));
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
	@SuppressWarnings("unchecked")
	public JSONArray getStatusByResearchObjectId(JSONObject requestJson){
		JSONArray responseJson = new JSONArray ();
		
		if (requestJson.containsKey("researchobjectid")){
			
			long researchObjectId = (long)requestJson.get("researchobjectid");
			
			if (ResearchObjectLocalServiceUtil.checkResearchObjectId(researchObjectId)){
				
				
				List <Integer> researchObjectVersionList = null;
				researchObjectVersionList = ResearchObjectLocalServiceUtil.getResearchObjectVersionsById(researchObjectId);
				
				for (int j = 0; j < researchObjectVersionList.size();j++){
					
					int researchObjectVersion = researchObjectVersionList.get(j);
					
					if(checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
						JSONArray submissionIdJson = new JSONArray();
						
						submissionIdJson = getSubmissionIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
						for (int i =0;i<submissionIdJson.size();i++){
							JSONObject responseElementJson = new JSONObject();
							responseElementJson.put("researchobjectid", researchObjectId);
							responseElementJson.put("researchobjectversion", researchObjectVersion);
							responseElementJson.put("archive", getArchiveById((long) submissionIdJson.get(i)));
							responseElementJson.put("status", getStatusById((long) submissionIdJson.get(i)));
							responseJson.add(responseElementJson);
						}
					}else{
						JSONObject responseElementJson = new JSONObject();
						responseElementJson.put("researchobjectid", researchObjectId);
						responseElementJson.put("researchobjectversion", researchObjectVersion);
						responseElementJson.put("status", "is created");
						responseJson.add(responseElementJson);
					}
				}
				

			}else{
				JSONObject responseElementJson = new JSONObject();
				responseElementJson.put("researchobjectid", researchObjectId);
				responseElementJson.put("status", "is not created");
				responseJson.add(responseElementJson);
			}
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid' as long. ");		
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray getStatusByResearchObjectIdAndVersion(JSONObject requestJson){
		JSONArray responseJson = new JSONArray ();
		
		if (requestJson.containsKey("researchobjectid")){
			
			long researchObjectId = (long)requestJson.get("researchobjectid");
			
			if (ResearchObjectLocalServiceUtil.checkResearchObjectId(researchObjectId)){
				
				int researchObjectVersion = getResearchObjectVersionFromJson(requestJson);
				
				if(checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion)){
					JSONArray submissionIdJson = new JSONArray();
					submissionIdJson = getSubmissionIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
					for (int i =0;i<submissionIdJson.size();i++){
						JSONObject responseElementJson = new JSONObject();
						responseElementJson.put("researchobjectid", researchObjectId);
						responseElementJson.put("researchobjectversion", researchObjectVersion);
						responseElementJson.put("archive", getArchiveById((long) submissionIdJson.get(i)));
						responseElementJson.put("status", getStatusById((long) submissionIdJson.get(i)));
						responseJson.add(responseElementJson);
					}
				}else{
					JSONObject responseElementJson = new JSONObject();
					responseElementJson.put("researchobjectid", researchObjectId);
					responseElementJson.put("researchobjectversion", researchObjectVersion);
					if (ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))
						responseElementJson.put("status", "is created");
					else
						responseElementJson.put("status", "is created, with other version");
					responseJson.add(responseElementJson);
				}
			}else{
				JSONObject responseElementJson = new JSONObject();
				responseElementJson.put("researchobjectid", researchObjectId);
				responseElementJson.put("status", "is not created");
				responseJson.add(responseElementJson);
			}
		}else
			responseJson.add("ERROR: The json need minimal 'researchobjectid' as long. ");		
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionsByBrokerSubmissionId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("brokersubmissionid");
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("brokersubmissionid")){
			try {responseJson = constructSubmissionsJson(getSubmissionsByBrokerSubmissionId((String)requestJson.get("brokersubmissionid")));}
			catch (SystemException e) {e.printStackTrace();}
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
	public JSONArray getSubmissionsByResearchObjectId (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		set.add("researchobjectid");
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		if (requestJson.containsKey("researchobjectid"))
			try {responseJson = constructSubmissionsJson(getSubmissionsByResearchObjectId((long)requestJson.get("researchobjectid")));} 
			catch (SystemException e) {	e.printStackTrace();responseJson.add("ERROR: Build Array is failed.");}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionsByResearchObjectIdAndVersion (JSONObject requestJson){
		
		JSONArray responseJson = new JSONArray();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"researchobjectid","researchobjectversion"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);

		
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("researchobjectid")){
			
			long researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			int researchObjectVersion = getResearchObjectVersionFromJson(requestJson);
			
			
			if (checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion))
				try {responseJson = constructSubmissionsJson(getSubmissionsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion));}
				catch (SystemException e1) {e1.printStackTrace();responseJson.add("ERROR: Build Array is failed.");}
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to primary data");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.add(ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONArray getSubmissionIdsByResearchObjectIdAndVersion (JSONObject requestJson){
		
		_log.info("start get submission "+requestJson);
		
		JSONArray responseJson = new JSONArray();
		
		if (requestJson.containsKey("researchobjectid")){
			
			long researchObjectId = Helper.getLongFromJson(requestJson, "researchobjectid");
			int researchObjectVersion = 0;
			
			if (requestJson.containsKey("researchobjectversion"))
				researchObjectVersion = Helper.getIntFromJson(requestJson, "researchobjectversion");
			else
				researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId);		
			
			_log.info("start get submission "+researchObjectId + " | "+researchObjectVersion);
			
			if (checkResearchObjectIdAndVersion(researchObjectId,researchObjectVersion)){
				_log.info("check");
				responseJson = getSubmissionIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
				_log.info(responseJson);
			}
			else
				responseJson.add("ERROR: Research object with ID "+ researchObjectId +" and version "+ researchObjectVersion+" has no relation to primary data");
		}
		else
			responseJson.add("ERROR: No key 'researchobjectid' exist.");
		
		return responseJson;
	}

	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//get archive of an existing submission
	@SuppressWarnings({"unchecked" })
	private String getArchiveById(long submissionId){
		List <String> archiveList = null;
		String archive = "";
		archiveList = SubmissionFinderUtil.getArchiveById(submissionId);
		if (archiveList.size()>0)
			archive = archiveList.get(0);
		return 	archive;
	}
	
		
	//
	@SuppressWarnings({ "unchecked", "null" })
	public List<String> getArchivePIdsOfENA (String archivePId){
		
		List <String> list = null;
		list = SubmissionFinderUtil.getArchivePIdsOfENA(archivePId);
		if (list == null)
			list.add("null");
		
		return list;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "null" })
	public List<String> getArchivePIdsWithTypeOfENA (String archivePId, String researchObjectType){
		
		List <String> list = null;
		list = SubmissionFinderUtil.getArchivePIdsWithTypeOfENA(archivePId, researchObjectType);
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
	
	
	//
	public String getBrokerSubmissionIdByIds(long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionFinderUtil.getBrokerSubmissionIdByIds(researchObjectId, researchObjectVersion, archive).get(0);
	}
	
	
	// get the latest Versions of a specific Submission
	public Submission getLatestSubmissionByIds (long researchObjectId, String archive ){
		return SubmissionFinderUtil.getLatestSubmissionByIds(researchObjectId, archive).get(0);
	}
	
	
	// get the latest Versions of a specific ResearchObject
	public List<Submission> getLatestSubmissionsByArchive (String archive){
		return SubmissionFinderUtil.getLatestSubmissionsByArchive(archive);
	}
	
	
	
	// get the latest Versions of a specific ResearchObject
	public List<Submission> getLatestSubmissionsByResearchObjectId (long researchObjectId){
		return SubmissionFinderUtil.getLatestSubmissionsByResearchObjectId(researchObjectId);
	}
	
		
	// get the latest Versions of all Submissions
	public List<Submission> getLatestSubmissions (){
		return SubmissionFinderUtil.getLatestSubmissions();
	}
	
	
	// get the latest X public Entries of all Submissions
	public List<Submission> getLatestXPublicSubmissionsByX (int latestX){
		return SubmissionFinderUtil.getLatestXPublicSubmissionsByX(latestX);
	}

	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = SubmissionFinderUtil.getMaxId();
		if (idList.size()>0)
		id = (long) idList.get(0);
		return id;
	}
	
		
	//
	public String getStatus(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		
		String status ="sent";
		
		if (archivePId != null && !(archivePId.equals("")))
			status = "archived";
		else
			status = getStatusByIds(researchObjectId, researchObjectVersion, archive);
		
		return status;
	}

	
	//get the latest research object version in the submission table, that is part of a specific submission
	@SuppressWarnings("rawtypes")
	public int getResearchObjectVersion ( long researchObjectId, String archive, String brokerSubmissionId) {
		
		int researchObjectVersion = 0;
		List versionList  = SubmissionFinderUtil.getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId);
		if (versionList.size() >0)
			researchObjectVersion = (int) SubmissionFinderUtil.getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId).get(0);
		
		return researchObjectVersion;
	}
	
	
	
	//get the research object version of the requestJson, or the latest version of the research object
	private int getResearchObjectVersionFromJson(JSONObject requestJson){
		int researchObjectVersion = 0;
		
		if (requestJson.containsKey("researchobjectversion"))
			if ((((requestJson.get("researchobjectversion")).getClass()).toString()).equals("class java.lang.Long"))
				researchObjectVersion = (int) ((long) requestJson.get("researchobjectversion"));
			else
				researchObjectVersion = (int) requestJson.get("researchobjectversion");
		else
			researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById((long)requestJson.get("researchobjectid"));	
		
		return researchObjectVersion;
	}
	
	
	//get status of an existing submission
	private String getStatusById(long submissionId){
		String status ="";
		Submission submission = null;
		try {submission = getSubmission(submissionId);}
		catch (PortalException | SystemException e) {e.printStackTrace();}
		
		if(submission != null)
			status = getStatusByIds(submission.getResearchObjectID(), submission.getResearchObjectVersion(), submission.getArchive());
			
		return status;
		
	}
	
	
	//get status of an existing submission
	public String getStatusByIds(long researchObjectId, int ResearchObjectVersion, String archive) {
		return (String) SubmissionFinderUtil.getStatusByIds(researchObjectId, ResearchObjectVersion, archive).get(0);
	}
	
	
	//get submission by research object id, research object version and archive <- the combination is unique
	public Submission getSubmission (long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionFinderUtil.getSubmission(researchObjectId, researchObjectVersion, archive).get(0);
	}

	
	//get all submissions of one specific research object with one specific version and different archives
	@SuppressWarnings("rawtypes")
	private JSONArray getSubmissionIdsByBrokerSubmissionId(String brokerSubmissionId){
		JSONArray responseJson = new JSONArray();
		List submissionIdList = SubmissionFinderUtil.getSubmissionIdsByBrokerSubmissionId(brokerSubmissionId);
		if (submissionIdList.size()>0){
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(submissionIdList.toString());}
			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
		}
		return responseJson;
	}
	
	
	//get all submissions of one specific research object with one specific version and different archives
	@SuppressWarnings("rawtypes")
	private JSONArray getSubmissionIdsByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion){
		JSONArray responseJson = new JSONArray();
		List submissionIdList = SubmissionFinderUtil.getSubmissionIdsByResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		_log.info(submissionIdList);
		if (submissionIdList.size()>0){
			_log.info("check");
			JSONParser parser = new JSONParser();
			try {responseJson = (JSONArray) parser.parse(submissionIdList.toString());}
			catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
		}
		return responseJson;
	}
		
	
	//get all submissions with a specific broker submission id, over all research objects and archives in this one submission run. 
	public List<Submission> getSubmissionsByBrokerSubmissionId (String brokerSubmissionId) throws SystemException{
		return submissionPersistence.findByBrokerSubmissionID(brokerSubmissionId);
	}
	
	
	//get all submissions of one specific research object with over all versions and different archives
	public List<Submission> getSubmissionsByResearchObjectId (long researchObjectId) throws SystemException{
		return submissionPersistence.findByResearchObjectID(researchObjectId);
	}
	
	
	//
	private List<Submission> getSubmissionsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion) throws SystemException{
		return submissionPersistence.findByResearchObjectIDAndVersion(researchObjectId, researchObjectVersion);
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public long getSubmissionIdByIds(long researchObjectId, int researchObjectVersion, String archive) {
		long submissionId =0;
		List submissionIdList = SubmissionFinderUtil.getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
		if (submissionIdList.size()>0)
			submissionId = (long) submissionIdList.get(0);
		return submissionId;
	}
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	


	

	//
	public Boolean checkOfIds (long researchObjectId, int researchObjectVersion, String archive){
		Boolean check =false;
		check = SubmissionFinderUtil.getCheckOfIds(researchObjectId, researchObjectVersion, archive).get(0);
		return check;
	}
	
	
	//
	public Boolean checkOfSubmissionId (long submissionId){
		Boolean check =false;
		check = SubmissionFinderUtil.getCheckOfSubmissionId(submissionId).get(0);
		return check;
	}
	
	
	//
	public Boolean checkOfBrokerSubmissionId(String brokersubmissionid) {
		
		Boolean check = false;
		List <Boolean> checkList =  SubmissionFinderUtil.getCheckOfBrokerSubmissionId(brokersubmissionid);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public Boolean checkResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Boolean check = false;
		List <Boolean> checkList =  SubmissionFinderUtil.getCheckOfResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	
	//
	public long constructNewId(){
		long id = 0;
		try {
			if (CounterLocalServiceUtil.increment(getModelClassName())<getMaxId())
				CounterLocalServiceUtil.reset(getModelClassName(), getMaxId());
			id = CounterLocalServiceUtil.increment(getModelClassName());
		} 
		catch (SystemException e) {e.printStackTrace();}
		return id;
	}
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray constructSubmissionsJson (List <Submission> submissionList){
		
		JSONArray responseJson = new JSONArray();
		
		for (int i =0; i < submissionList.size();i++)
			responseJson.add(constructSubmissionJson(submissionList.get(i)));
		
		return responseJson;
	}
	
		
	//
	@SuppressWarnings("unchecked")
	public JSONObject constructSubmissionJson (Submission submission){
		
		JSONObject json = new JSONObject();
		
		json.put("researchobjectid", submission.getResearchObjectID());
		json.put("researchobjectversion", submission.getResearchObjectVersion());	
		json.put("archive", (submission.getArchive()).trim());
		json.put("archivepid", (submission.getArchivePID()).trim());
		json.put("archivepidtype", submission.getArchivePIDType());
		json.put("brokersubmissionid", (submission.getBrokerSubmissionID()).trim());
		json.put("userid", submission.getUserID());
		json.put("lastchanged", (submission.getLastChanged().toString()).trim());
		json.put("lastmodifieddate", (submission.getLastChanged().toString()).trim());
		json.put("ispublic", submission.getIsPublic());
		json.put("jiraid", submission.getJiraID().trim());
		json.put("jirakey", submission.getJiraKey().trim());
		if (submission.getPublicAfter() != null)
			json.put("publicafter", (submission.getPublicAfter().toString()).trim());
		else
			json.put("publicafter", "");
		json.put("status", submission.getStatus());
		
		return json;
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//------------------------------- Manage Update Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray createSubmission (JSONArray requestJson){
		JSONArray responseJson = new JSONArray();
		
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(createSubmission((JSONObject) requestJson.get(i)));

		return responseJson;
	}

	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createSubmission (JSONObject requestJson){
		
		Boolean check = false;
		JSONObject keyJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"archive", "archivepidtype", "archivepid", "brokersubmissionid", "dbrocheck", "ispublic", "jiraid","jirakey", "publicafter", "researchobjectid", "researchobjectversion", "status", "userid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		int researchObjectVersion =0;
		if (requestJson.containsKey("researchobjectversion"))
			researchObjectVersion = (int) Helper.getIntFromJson(requestJson, "researchobjectversion");
		else
			if (requestJson.containsKey("researchobjectid"))
				researchObjectVersion = ResearchObjectLocalServiceUtil.getLatestVersionById(Helper.getLongFromJson(requestJson, "researchobjectid"));
		
		
		if (requestJson.containsKey("researchobjectid") && researchObjectVersion != 0 && requestJson.containsKey("archive") && requestJson.containsKey("userid")){

			long researchObjectId =Helper.getLongFromJson(requestJson, "researchobjectid");
			String archive = (Helper.getStringFromJson(requestJson, "archive")).trim();
			String brokerSubmissionId ="";
			long userId = Helper.getLongFromJson(requestJson, "userid");
			Submission submission = null;
			Boolean dbrocheck = false;
			
			if (requestJson.containsKey("dbrocheck"))
				dbrocheck = Helper.getBooleanFromJson(requestJson, "dbrocheck"); 
			
			if (requestJson.containsKey("brokersubmissionid"))
				brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			else
				brokerSubmissionId = (createBrokerSubmissionId()).trim();
			
			if (dbrocheck ||(ResearchObjectLocalServiceUtil.checkResearchObjectIdAndVersion(researchObjectId, researchObjectVersion))){
				
				if (DataProviderLocalServiceUtil.checkDataProviderLabel(archive)){
				
					long submissionId = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive);
					
					if (submissionId !=0)
						try {submission = submissionPersistence.findByPrimaryKey(submissionId);} 
						catch (SystemException | NoSuchModelException e) {System.out.println("Entry in Submission does not exist with pk: "+submissionId+ " and will be create now");}

					if (submission==null){

						check = updateKernelSubmission (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);

						if (check){
							if (requestJson.containsKey("status"))
								check = updateStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("status"));
							else if (!(requestJson.containsKey("status")) && requestJson.containsKey("archivepidtype"))	
								check = updateStatus(researchObjectId, researchObjectVersion, archive, getStatus(researchObjectId, researchObjectVersion, archive, (String) requestJson.get("archivepidtype")));
							else if(!requestJson.containsKey("status"))
								check = updateStatus(researchObjectId, researchObjectVersion, archive, "sent");
							
							if (requestJson.containsKey("archivepidtype"))
								check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, (long) requestJson.get("archivepidtype") );
							else if (getArchivePIdType(archive) !=0)
								check = updateArchivePIdType(researchObjectId, researchObjectVersion, archive, getArchivePIdType(archive));
							
							if (requestJson.containsKey("archivepid"))
								check = updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("archivepid")).trim());
							
							if (requestJson.containsKey("ispublic"))
								check = updateIsPublic(researchObjectId, researchObjectVersion, archive, (Boolean) requestJson.get("ispublic"));
							else
								check = updateIsPublic(researchObjectId, researchObjectVersion, archive, false);
							
							if (requestJson.containsKey("jiraid"))
								check = updateJiraId(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("jiraid")).trim());
							
							if (requestJson.containsKey("jirakey"))
								check = updateJiraKey(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("jirakey")).trim());
							
							if (requestJson.containsKey("publicafter"))
								if (requestJson.get("publicafter").getClass().toString().equals("class java.lang.String"))
									try {
										DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
										check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, dateFormat.parse((String) requestJson.get("publicafter")));	
									} catch (ParseException e) {e.printStackTrace();}
								else
									check = updatePublicAfter(researchObjectId, researchObjectVersion, archive, new Date ((long) requestJson.get("publicafter")));
							
							if (check){
								keyJson.put("researchobjectid", researchObjectId);
								keyJson.put("researchobjectversion", researchObjectVersion);
								keyJson.put("archive", archive);
							}
						}
						else
							keyJson.put("ERROR","ERROR: Faile by create submission registry entry.");
					}
					else
						keyJson.put("ERROR","ERROR: A entry already exists to this ResearchObject with this Version to this Archive.");
				}
				else
					keyJson.put("ERROR","ERROR: A Archive with this label is not in the database.");
			}
			else{
				if (DataProviderLocalServiceUtil.checkDataProviderLabel(archive))
					keyJson.put("ERROR","ERROR: A ResearchObject with this ID and Version are not in the database.");
				else
					keyJson.put("ERROR","ERROR: A ResearchObject with this ID and Version and a Archive with this label are not in the database.");
			}
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
	
	public JSONObject startSubmission (JSONObject requestJson){
		JSONObject responseJson = new JSONObject();
		
		JSONObject checkJson = transferSubmissionInformationToDb(requestJson);
		if (!checkJson.containsKey("Error")){
			responseJson = checkJson;
			
			JSONObject submissionJson = new JSONObject();
			JSONObject mrrJson = new JSONObject();
			mrrJson = (JSONObject) ((JSONObject) checkJson.get("all")).get("researchobject");
			mrrJson.put("userid", (long) ((JSONArray) ((JSONObject) mrrJson.get("userids")).get("direct")).get(0));
			submissionJson.put("mrr", (mrrJson));
			submissionJson.put("path","C:\\Users\\froemm\\GFBio\\GFBio-portal-dev\\liferay-portal-6.2-ce-ga4\\tomcat-7.0.42\\temp\\11-GFBioProject-portlet\\");
			System.out.println("check"+checkJson);
			System.out.println("submi"+submissionJson);
			
			JSONObject jiraResponseJson = ContactJira.startSubmission(submissionJson);
			
			System.out.println(" jira"+jiraResponseJson);
		}
		
		//System.out.println(checkJson);
		
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject transferSubmissionInformationToDb(JSONObject requestJson){
		
		// information to Portal
		

        JSONObject jiraJson = new JSONObject();
        
        try {
        	Runtime rt = Runtime.getRuntime();
            RuntimeExec rte = new RuntimeExec();
            StreamWrapper error, output;
            String userpass = PropsUtil.get("jira.gfbio.submission.userpass");

        	        	
        	String curl ="";
        	curl = "curl -D- -u "+userpass+" -X GET -H \"Content-Type: application/json\" --url \" "+PropsUtil.get("jira.gfbio.submission.urlissue")+" \" " ;

        	Process proc = rt.exec(curl);
        	error  = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
        	output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
        	int exitVal = 0;
            error.start();
            output.start();
            error.join(3000);
            output.join(3000);
            exitVal = proc.waitFor();

            _log.info(output.getMessage());
            
            String[] SSubAOutput = (output.getMessage()).split("chunked");
            String subSOutput = SSubAOutput[SSubAOutput.length-1];
            JSONParser parser = new JSONParser();
    		try {jiraJson = (JSONObject) parser.parse(subSOutput);}
    		catch (org.json.simple.parser.ParseException e) {e.printStackTrace();}
    		
    		_log.info(jiraJson);
    		
        } catch (IOException e) {e.printStackTrace();
        } catch (InterruptedException e) {e.printStackTrace();}
    
		
		// change information syntax
		
        
        _log.info(jiraJson);
        requestJson = ContactJira.jiraJsonToPortalJson(jiraJson);
        _log.info(requestJson);
		
		
		
		// information to DB
		
		JSONObject responseJson = new JSONObject();
		
		_log.info("transfer request:" + requestJson);
		
		if (requestJson.containsKey("researchobject")){
			
			JSONObject researchObjectJson = null;
			
			researchObjectJson = Helper.getJsonObjectFromJson(requestJson, "researchobject");
			
			_log.info("transfer researchObjectJson:" + researchObjectJson);
			
			if (researchObjectJson.containsKey("researchobjectid")){
				_log.info("update RO");
				researchObjectJson = ResearchObjectLocalServiceUtil.updateResearchObjectByJson(researchObjectJson);
			}else{
				_log.info("create RO");
				researchObjectJson = ResearchObjectLocalServiceUtil.createResearchObjectByJson(researchObjectJson);
			}
			_log.info("after change: "+researchObjectJson);
			responseJson.put("researchobject", researchObjectJson);
			
			_log.info("transfer responseJson:" + responseJson);
						
			if (researchObjectJson.containsKey("researchobjectid")){
				
				long researchObjectId = Helper.getLongFromJson(researchObjectJson, "researchobjectid");
				int researchObjectVersion = Helper.getIntFromJson(researchObjectJson, "researchobjectversion");

				//submission
				if (requestJson.containsKey("submission")){
					
					JSONObject submissionJson = Helper.getJsonObjectFromJson(requestJson, "submission");
					
					_log.info(submissionJson);
					
					if (submissionJson.containsKey("archive")){
						
						submissionJson.put("researchobjectid", researchObjectId);
						submissionJson.put("researchobjectversion", researchObjectVersion);
						submissionJson.put("dbrocheck", true);
						
						_log.info(submissionJson);

						if (SubmissionLocalServiceUtil.checkOfIds(researchObjectId, researchObjectVersion, (Helper.getStringFromJson(submissionJson, "archive")).trim())){
							_log.info("update Sub");
							submissionJson = SubmissionLocalServiceUtil.updateSubmission(submissionJson);
						}else{
							_log.info("create Sub");
							submissionJson = SubmissionLocalServiceUtil.createSubmission(submissionJson);
						}
						
						responseJson.put("submission", submissionJson);
					}
				}
				
				//project
				if (requestJson.containsKey("project")){
					
					JSONObject projectJson = Helper.getJsonObjectFromJson(requestJson, "project");
					
					_log.info(projectJson);
									

					if (projectJson.containsKey("projectid")){
						_log.info("update Pro");
						projectJson = ProjectLocalServiceUtil.updateProjectByJson(projectJson);
					}else{
						_log.info("create Pro");
						projectJson = ProjectLocalServiceUtil.createProjectByJson(projectJson);
					}
					
					Boolean check = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(Helper.getLongFromJson(projectJson, "projectid"), researchObjectId, researchObjectVersion);
					
					if (check)
						responseJson.put("project", projectJson);
				}
				
/*				//primarydata
				if (requestJson.containsKey("primarydata")){
					JSONObject primarydataJson = Helper.getJsonObjectFromJson(requestJson, "primarydata");
					
					primarydataJson.put("researchobjectid", researchObjectId);
					primarydataJson.put("researchobjectversion", researchObjectVersion);
					
					if (primarydataJson.containsKey("primarydataid")){
						_log.info("update Pri");
						primarydataJson = PrimaryDataLocalServiceUtil.updatePrimaryData(primarydataJson);
					}else{
						_log.info("create Pri");
						primarydataJson = PrimaryDataLocalServiceUtil.createPrimaryData(primarydataJson);
					}
					responseJson.put("primarydata", primarydataJson);
					
				}*/
				
				//answer
				JSONObject questionJson = new JSONObject ();
				questionJson.put("kindofresponse","extraextended");
				questionJson.put("researchobjectid",researchObjectId);
				JSONObject answerJson = ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(questionJson);
				responseJson.put("all", answerJson);
				
				
			}
		}
		else{
			responseJson.put("Error", "ERROR: You have to sent the researchobjectinformation to use this service." );
		}
		
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public JSONArray updateSubmission (JSONArray requestJson){
		
		JSONArray responseJson = new JSONArray();
		
		for (int i =0; i <requestJson.size();i++)
			responseJson.add(updateSubmission((JSONObject) requestJson.get(i)));
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject updateSubmission (JSONObject requestJson){
		
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		Submission submission = null;
		Set<String> set = new HashSet<String>();
		String [] keySet = {"archive", "archivepidtype", "archivepid", "brokersubmissionid", "ispublic", "jiraid", "jirakey", "publicafter", "researchobjectid", "status", "userid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = Helper.checkForIgnoredParameter(requestJson.keySet().toArray(), set);
			
		if (requestJson.containsKey("researchobjectid") && requestJson.containsKey("archive") && requestJson.containsKey("archivepid") && requestJson.containsKey("brokersubmissionid")&& requestJson.containsKey("userid") ){
	
			
			String archive = ((String)requestJson.get("archive")).trim();
			String brokerSubmissionId = ((String)requestJson.get("brokersubmissionid")).trim();
			long userId = (long)requestJson.get("userid");
			long researchObjectId =(long)requestJson.get("researchobjectid");
			int  researchObjectVersion = getResearchObjectVersion(researchObjectId, archive, brokerSubmissionId);

			submission = getSubmission(researchObjectId, researchObjectVersion, archive);
			
			if (submission != null){
				
				check = updateKernelSubmission (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, userId);
				check = updateArchivePId(researchObjectId, researchObjectVersion, archive, ((String) requestJson.get("archivepid")).trim());
				
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
	
				if (requestJson.containsKey("jiraid"))
					check = updateJiraId(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("jiraid")).trim());
				
				if (requestJson.containsKey("jirakey"))
					check = updateJiraKey(researchObjectId, researchObjectVersion, archive, ((String)requestJson.get("jirakey")).trim());
				
				
				if (requestJson.containsKey("publicafter"))
					if (requestJson.get("publicafter").getClass().toString().equals("class java.lang.String"))
						try {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
				responseJson = createSubmission(requestJson);
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
	private String createBrokerSubmissionId(){	
		//(new PublicIdentifier("submission")).getIdentifier();
		return (new UUID(System.currentTimeMillis(),System.currentTimeMillis())).toString();
	}
	
	
	//
	public Boolean updateKernelSubmission (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, long userId){
		
		Boolean check = false;
		long submissionId = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive.trim());
		Submission submission = null;
		if (submissionId !=0)
			try {submission = getSubmission(submissionId);}
			catch (PortalException | SystemException e1) {System.out.println("Entry in Submission does not exist with pk: "+submissionId+ " and will be create now");}

		if (submission == null){
			submission = submissionPersistence.create(constructNewId());
			submission.setResearchObjectID(researchObjectId);
			submission.setResearchObjectVersion(researchObjectVersion);
			submission.setArchive(archive.trim());
		}
		submission.setBrokerSubmissionID(brokerSubmissionId.trim());
		submission.setUserID(userId);
		submission.setLastChanged(new Timestamp(new Date().getTime()));

		try {
			super.updateSubmission(submission);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}
	
		
	//
	public Boolean updateSubmission (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId, String status){
		
		Boolean check = false;
		long submissionId = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive.trim());
		Submission submission = null;
		if (submissionId !=0)
			try {submission = getSubmission(submissionId);}
			catch (PortalException | SystemException e1) {System.out.println("Entry in Submission does not exist with pk: "+submissionId+ " and will be create now");}

		if (submission == null){
			submission = submissionPersistence.create(constructNewId());
			submission.setResearchObjectID(researchObjectId);
			submission.setResearchObjectVersion(researchObjectVersion);
			submission.setArchive(archive.trim());
		} 
		submission.setBrokerSubmissionID(brokerSubmissionId.trim());
		submission.setArchivePID(archivePId.trim());
		submission.setArchivePIDType(archivePIdType);
		submission.setLastChanged(lastChanged);
		submission.setUserID(userId);
		submission.setStatus(status.trim());

		try {
			super.updateSubmission(submission);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	

	//
	public Boolean updateSubmission (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userId, String status, Boolean isPublic, Date publicAfter){

		Boolean check = false;
		
		check = updateSubmission (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, archivePIdType, lastChanged, userId, status);
		check = updateIsPublic(researchObjectId, researchObjectVersion, archivePId, isPublic);
		check = updatePublicAfter(researchObjectId, researchObjectVersion, archivePId, publicAfter);
		
		return check;
	}

	
	//
	public Boolean updateSubmissionWithoutPId (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, Date lastChanged, long userID, String status){
		
		Boolean check = false;
		long submissionId = getSubmissionIdByIds(researchObjectId, researchObjectVersion, archive.trim());
		Submission submission = null;
		if (submissionId !=0)
			try {submission = getSubmission(submissionId);}
			catch (PortalException | SystemException e1) {System.out.println("Entry in Submission does not exist with pk: "+submissionId+ " and will be create now");}

		if (submission == null){
			submission = submissionPersistence.create(constructNewId());
			submission.setResearchObjectID(researchObjectId);
			submission.setResearchObjectVersion(researchObjectVersion);
			submission.setArchive(archive.trim());
		}
		submission.setBrokerSubmissionID(brokerSubmissionId.trim());
		submission.setLastChanged(lastChanged);
		submission.setUserID(userID);
		submission.setStatus(status.trim());
		
		try {
			super.updateSubmission(submission);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}

		
	//-------------------------------  Update Attribute Functions ----------------------------------------------//

	
	//
	public Boolean updateArchivePId(long researchObjectId, int researchObjectVersion, String archive, String archivePId){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());

		if (submission != null)
			try {
				submission.setArchivePID(archivePId.trim());
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	
	
	//
	public Boolean updateArchivePIdType(long researchObjectId, int researchObjectVersion, String archive, long archivePIdType){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setArchivePIDType(archivePIdType);
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	

	//
	public Boolean updateBrokerSubmissionId(long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setBrokerSubmissionID(brokerSubmissionId.trim());
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateIsPublic(long researchObjectId, int researchObjectVersion, String archive, Boolean isPublic){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setIsPublic(isPublic);
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateJiraId(long researchObjectId, int researchObjectVersion, String archive, String jiraId){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setJiraID(jiraId.trim());
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateJiraKey(long researchObjectId, int researchObjectVersion, String archive, String jiraKey){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setJiraKey(jiraKey.trim());
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updateLastChanged(long researchObjectId, int researchObjectVersion, String archive, Date lastChanged){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());

		if (submission != null)
			try {
				submission.setLastChanged(lastChanged);
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
	
	//
	public Boolean updatePublicAfter(long researchObjectId, int researchObjectVersion, String archive, Date publicAfter){
		
		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setPublicAfter(publicAfter);
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		return check;
	}
	
	
	//
	public Boolean updateStatus (long researchObjectId, int researchObjectVersion, String archive, String status){

		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());

		if (submission != null)
			try {
				submission.setStatus(status.trim());
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}

	
	//
	public Boolean updateUserId (long researchObjectId, int researchObjectVersion, String archive, long userId){

		Boolean check = false;
		Submission submission = null;
		submission = getSubmission(researchObjectId, researchObjectVersion, archive.trim());
		
		if (submission != null)
			try {
				submission.setUserID(userId);
				submission.setLastChanged(new Timestamp(new Date().getTime()));
				super.updateSubmission(submission);
				check = true;
			} catch (SystemException e) {e.printStackTrace();}
		
		return check;
	}
	
}