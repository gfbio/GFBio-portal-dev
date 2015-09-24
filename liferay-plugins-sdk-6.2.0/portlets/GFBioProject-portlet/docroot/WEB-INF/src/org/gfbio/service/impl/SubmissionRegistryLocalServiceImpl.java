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
	public List<SubmissionRegistry> getSubmissionRegistryByResearchObjectId (long researchObjectId) throws SystemException{
		return submissionRegistryPersistence.findByResearchObjectID(researchObjectId);
	}
	
	public String GetStatusByIds(long researchObjectId, int ResearchObjectVersion, String archive) {
		return (String) SubmissionRegistryFinderUtil.getStatusByIds(researchObjectId, ResearchObjectVersion, archive).get(0);
	}
	
	
/*	//
	public SubmissionRegistry getSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive){
		return SubmissionRegistryFinderUtil.getSubmissionRegistry(researchObjectId, researchObjectVersion, archive).get(0);
	}*/
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	

	
	
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
		} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	
	
	
	//
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, Date lastChanged, long userID, Boolean isPublic, Date publicAfter){

		Boolean check = false;
		String status ="";
		System.out.println(archivePId);
		
		if (archivePId != null && !(archivePId.equals("")))
			status = "archived";
		else{
			status = SubmissionRegistryLocalServiceUtil.GetStatusByIds(researchObjectId, researchObjectVersion, archive);
		}
		System.out.println(status);
		check = updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, lastChanged, userID, isPublic, publicAfter, status);

		return check;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, Date lastChanged, long userID, Boolean isPublic, Date publicAfter, String status){
		
		Boolean check = false;
		List  pIdList = DataProviderLocalServiceUtil.getPersistentIdentiferIds(DataProviderLocalServiceUtil.getDataProviderIdByLabel(archive));
		if (pIdList.size()==1) 
			check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brokerSubmissionId, archivePId, (long) pIdList.get(0), lastChanged, userID, isPublic, publicAfter, status);
		else
			check = SubmissionRegistryLocalServiceUtil.updateSubmissionRegistryWithoutPId(researchObjectId, researchObjectVersion, archive, brokerSubmissionId, lastChanged, userID, isPublic, publicAfter, status);
		
		return check;
	}
	
	
	//
	@SuppressWarnings("null")
	public Boolean updateSubmissionRegistry (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userID, Boolean isPublic, Date publicAfter, String status){
		
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
		submissionRegistry.setArchivePID(archivePId);
		submissionRegistry.setArchivePIDType(archivePIdType);
		submissionRegistry.setLastChanged(lastChanged);
		submissionRegistry.setUserID(userID);
		submissionRegistry.setIsPublic(isPublic);
		submissionRegistry.setPublicAfter(publicAfter);
		submissionRegistry.setStatus(status);
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
	
		return check;
	}
	
	
	//
	@SuppressWarnings("null")
	public Boolean updateSubmissionRegistry (JSONObject json){
		
		Boolean check = false;
		SubmissionRegistry submissionRegistry = null;
		
		submissionRegistry.setResearchObjectID((long)json.get("researchObjectId"));
		submissionRegistry.setResearchObjectVersion((long)json.get("researchObjectVersion"));
		submissionRegistry.setArchive((String)json.get("archive"));
		submissionRegistry.setBrokerSubmissionID((String)json.get("brokerSubmissionId"));
		submissionRegistry.setArchivePID((String)json.get("archivePId"));
		submissionRegistry.setArchivePIDType((long)json.get("archivePIdType"));
		submissionRegistry.setLastChanged((Date)json.get("lastChanged"));
		submissionRegistry.setUserID((long)json.get("userId"));
		submissionRegistry.setIsPublic((Boolean)json.get("isPublic"));
		submissionRegistry.setPublicAfter((Date)json.get("publicAfter"));
		submissionRegistry.setStatus((String)json.get("status"));
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
		} catch (SystemException e) {e.printStackTrace();}
	
		
		return check;
	}
	
	
	//
	@SuppressWarnings("null")
	public Boolean updateSubmissionRegistryWithoutPId (long researchObjectId, int researchObjectVersion, String archive, String brokerSubmissionId, Date lastChanged, long userID, Boolean isPublic, Date publicAfter, String status){
		
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
		submissionRegistry.setIsPublic(isPublic);
		submissionRegistry.setPublicAfter(publicAfter);
		submissionRegistry.setStatus(status);
		
		try {
			super.updateSubmissionRegistry(submissionRegistry);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}
	
		
		return check;
	}
		
	


}