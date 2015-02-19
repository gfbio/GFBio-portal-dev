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

import org.gfbio.NoSuchProject_ResearchObjectException;
import org.gfbio.NoSuchProject_UserException;

import org.gfbio.model.Project_ResearchObject;
import org.gfbio.service.base.Project_ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_ResearchObjectPK;

import com.liferay.portal.kernel.exception.SystemException;

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
public class Project_ResearchObjectLocalServiceImpl	extends Project_ResearchObjectLocalServiceBaseImpl {

	 
	
	//get a ID-List (Project_ResearchObject-Object) of all Research Objects of a specific Project
	public List<Project_ResearchObject> getProjectIDList(long projectID){
		List<Project_ResearchObject> idList=null;
		try {
			idList = project_ResearchObjectPersistence.findByProjectID(projectID);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idList;
	}
	
	
	//update or create a new Relationship between a Project and a Research Object
	public long updateProjectResearchObject(long projectID, long researchObjectID) throws SystemException, NoSuchProject_UserException{
		
		Project_ResearchObject relation=null;
		Project_ResearchObjectPK pk = new Project_ResearchObjectPK(projectID, researchObjectID);
		
		try {
			relation = project_ResearchObjectPersistence.findByPrimaryKey(pk);
		} catch (NoSuchProject_ResearchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create new project
		if(relation==null){
			relation = project_ResearchObjectPersistence.create(pk);
		}
		//update project
		else{
			//exception-option or for mar relation-Attributs
		}
			
		super.updateProject_ResearchObject(relation);
		return relation.getProjectID() + relation.getResearchObjectID();
	}
	

	
}