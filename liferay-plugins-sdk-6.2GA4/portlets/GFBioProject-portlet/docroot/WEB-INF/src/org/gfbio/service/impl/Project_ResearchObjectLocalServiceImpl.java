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

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.gfbio.NoSuchProject_ResearchObjectException;
import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.base.Project_ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_ResearchObjectFinderUtil;
import org.gfbio.service.persistence.Project_ResearchObjectPK;


/**
 * The implementation of the project_ research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Project_ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author froemm
 * @see org.gfbio.service.base.Project_ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.Project_ResearchObjectLocalServiceUtil
 */
public class Project_ResearchObjectLocalServiceImpl extends Project_ResearchObjectLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//get a ID-List (Project_ResearchObject-Object) of all Research Objects of a specific Project
	public List<Project_ResearchObject> getProjectIDList(long projectID) {
		List<Project_ResearchObject> idList = null;
		try {
			idList = project_ResearchObjectPersistence.findByProjectID(projectID);
		} catch (SystemException e) {e.printStackTrace();}
		return idList;
	}
	
	
	//
	public List <ResearchObject> getResearchObjectsByProjectId (long projectId){
		return Project_ResearchObjectFinderUtil.getResearchObjectsByProjectId(projectId);
	}
	
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//
	public Boolean checkResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Boolean check = false;
		List <Boolean> checkList =  Project_ResearchObjectFinderUtil.getCheckOfResearchObjectIdAndVersion(researchObjectId, researchObjectVersion);
		if (checkList.size()>0)
			check = checkList.get(0);
		return check;
	}
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////

	
	//update or create a new Relationship between a Project and a Research Object
	public Boolean updateProjectResearchObject(long projectID, long researchObjectID, int researchObjectVersion) {

		Boolean check = false;
		Project_ResearchObject relation = null;
		Project_ResearchObjectPK pk = new Project_ResearchObjectPK(projectID, researchObjectID, researchObjectVersion);

		try {relation = project_ResearchObjectPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchProject_ResearchObjectException | SystemException e) {System.out.println("no enitity with pk: "+pk+" is found");	}

		if (relation == null) 
			relation = project_ResearchObjectPersistence.create(pk);

		try {
			super.updateProject_ResearchObject(relation);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}

}