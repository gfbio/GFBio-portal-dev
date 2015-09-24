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
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.base.SubmissionRegistryServiceBaseImpl;




/**
 * The implementation of the submission registry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.SubmissionRegistryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.SubmissionRegistryServiceBaseImpl
 * @see org.gfbio.service.SubmissionRegistryServiceUtil
 */
public class SubmissionRegistryServiceImpl	extends SubmissionRegistryServiceBaseImpl {

		
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//
	public List<String> getArchivepidsOfENA (String archivePId){
		return SubmissionRegistryLocalServiceUtil.getArchivePIdsOfENA(archivePId);
	}
	
	
	//
	public List <String>getArchivepidsWithTypeSampleOfENA (String archivePId){
		return SubmissionRegistryLocalServiceUtil.getArchivePIdsWithTypeSampleOfENA(archivePId);
	}
	
	
	//
	public String getArchivepidWithTypeStudyOfENA (String archivePId){
		return SubmissionRegistryLocalServiceUtil.getArchivePIdWithTypeStudyOfENA(archivePId);
	}
	
	
	// get the latest Versions of a specific Submission
	public SubmissionRegistry getLatestSubmissionByIds (long researchObjectId, String archive ){
		return SubmissionRegistryLocalServiceUtil.getLatestSubmissionByIds(researchObjectId, archive);
	}
	
	
	// get the latest Versions of a specific ResearchObject
	public List<SubmissionRegistry> getLatestSubmissionsByArchive (String archive){
		return SubmissionRegistryLocalServiceUtil.getLatestSubmissionsByArchive(archive);
	}
	
	
	
	// get the latest Versions of a specific ResearchObject
	public List<SubmissionRegistry> getLatestSubmissionsByResearchobjectid (long researchObjectId){
		return SubmissionRegistryLocalServiceUtil.getLatestSubmissionsByResearchObjectId(researchObjectId);
	}
	
		
	// get the latest Versions of all Submissions
	public List<SubmissionRegistry> getLatestSubmissions (){
		return SubmissionRegistryLocalServiceUtil.getLatestSubmissions();
	}
	

	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	public Boolean updateStatus (long researchObjectId, int researchObjectVersion, String archive, String status){
		return SubmissionRegistryLocalServiceUtil.updateStatus (researchObjectId, researchObjectVersion, archive, status);
	}
	

	//
	public Boolean updateSubmissionregistry (long researchObjectId, int researchObjectVersion, String archive, String brockerSubmissionId, String archivePId, Date lastChanged, long userID, Boolean isPublic, Date publicAfter){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brockerSubmissionId, archivePId, lastChanged, userID, isPublic, publicAfter);
	}
	
	
	//
	public Boolean updateSubmissionregistry (long researchObjectId, int researchObjectVersion, String archive, String brockerSubmissionId, String archivePId, Date lastChanged, long userID, Boolean isPublic, Date publicAfter, String status){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brockerSubmissionId, archivePId, lastChanged, userID, isPublic, publicAfter,  status);
	}
	
	
	//
	public Boolean updateSubmissionregistry (long researchObjectId, int researchObjectVersion, String archive, String brockerSubmissionId, String archivePId, long archivePIdType, Date lastChanged, long userID, Boolean isPublic, Date publicAfter, String status){
		return SubmissionRegistryLocalServiceUtil.updateSubmissionRegistry (researchObjectId, researchObjectVersion, archive, brockerSubmissionId, archivePId, archivePIdType, lastChanged, userID, isPublic, publicAfter, status);
	}
	
		
}