/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import org.gfbio.NoSuchPrimaryData_ResearchObjectException;
import org.gfbio.model.PrimaryData_ResearchObject;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.PrimaryData_ResearchObjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.PrimaryData_ResearchObjectPK;
import org.gfbio.service.persistence.Project_ResearchObjectFinderUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the primary data_ research object local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.PrimaryData_ResearchObjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.PrimaryData_ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.PrimaryData_ResearchObjectLocalServiceUtil
 */
public class PrimaryData_ResearchObjectLocalServiceImpl	extends PrimaryData_ResearchObjectLocalServiceBaseImpl {
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//get a ID-List (Project_ResearchObject-Object) of all Research Objects of a specific Project
	public List<PrimaryData_ResearchObject> getRelationsByPrimaryDataId(long primaryDataId) {
		List<PrimaryData_ResearchObject> idList = null;
		try {idList = primaryData_ResearchObjectPersistence.findByPrimaryDataID(primaryDataId);}
		catch (SystemException e) {e.printStackTrace();}
		return idList;
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


	//update or create a new Relationship between a Primary Data and a Research Object
	public Boolean updatePrimaryDataResearchObject(long primaryDataId, long researchObjectId) {
		return updatePrimaryDataResearchObject(primaryDataId, researchObjectId, ResearchObjectLocalServiceUtil.getLatestVersionById(researchObjectId));
	}
	
	
	//update or create a new Relationship between a Primary Data and a Research Object
	public Boolean updatePrimaryDataResearchObject(long primaryDataId, long researchObjectId, int researchObjectVersion) {

		Boolean check = false;

		System.out.println("5 "+check);
		
		PrimaryData_ResearchObject relation = null;
		PrimaryData_ResearchObjectPK pk = new PrimaryData_ResearchObjectPK(primaryDataId, researchObjectId, researchObjectVersion);

		try {relation = primaryData_ResearchObjectPersistence.findByPrimaryKey(pk);	}
		catch (NoSuchPrimaryData_ResearchObjectException | SystemException e1) {System.out.println("no enitity with pk: "+pk+" is found");}
		
		if (relation == null) 
			relation = primaryData_ResearchObjectPersistence.create(pk);

		System.out.println("6 "+check);
		
		try {
			super.updatePrimaryData_ResearchObject(relation);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		System.out.println("7 "+check);
		
		return check;
	}
}