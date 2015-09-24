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
	
	
/*	//
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
	}*/
	
	
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
		return (ResearchObject) ResearchObjectFinderUtil.getDirectParent(researchObjectId).get(0) ;
	}

	
	//
	public ResearchObject getTopParent(long researchObjectId) {
		ResearchObject researchobject = null;
		researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchObjectId);
		while (researchobject != null && researchobject.getParentResearchObjectID()!=0)
			researchobject = ResearchObjectLocalServiceUtil.getDirectParent(researchobject.getResearchObjectID());
		return researchobject;
	}

	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	//
	@SuppressWarnings("unused")
	public long updateResearchObject(long projectID, long researchObjectID, String name, String label, String metadata, String formatmetadata) throws SystemException {

		ResearchObject researchObject = null;
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(researchObjectID);
		} catch (NoSuchResearchObjectException e) {e.printStackTrace();}

		//create new ResearchObject

		if (researchObject == null) {
			researchObject = researchObjectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			researchObject.setName(name);
			researchObject.setLabel(label);
			researchObject.setMetadata(metadata);
			researchObject.setFormatmetadata(formatmetadata);
			super.updateResearchObject(researchObject);

			try {
				Long foobar = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectID, researchObject.getResearchObjectID());
			} catch (NoSuchProject_UserException e) {e.printStackTrace();}
		}
		//update ResearchObject
		else {
			researchObject.setName(name);
			researchObject.setLabel(label);
			researchObject.setMetadata(metadata);
			researchObject.setFormatmetadata(formatmetadata);
			super.updateResearchObject(researchObject);
		}
		return researchObject.getResearchObjectID();
	}

}