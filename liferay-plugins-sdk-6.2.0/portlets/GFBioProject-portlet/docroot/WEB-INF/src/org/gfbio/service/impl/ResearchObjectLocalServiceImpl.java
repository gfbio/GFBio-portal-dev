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



import org.gfbio.NoSuchProject_UserException;
import org.gfbio.NoSuchResearchObjectException;
import org.gfbio.model.ResearchObject;
import org.gfbio.service.Project_ResearchObjectLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

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
 * @author froemm
 * @see org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.ResearchObjectLocalServiceUtil
 */
public class ResearchObjectLocalServiceImpl	extends ResearchObjectLocalServiceBaseImpl {
	
	public long updateResearchObject(long projectID, long researchObjectID, String name, String label, String metadata, String formatmetadata) throws SystemException{

		ResearchObject researchObject=null;
		try {
			researchObject = researchObjectPersistence.findByPrimaryKey(researchObjectID);
		} catch (NoSuchResearchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create new ResearchObject
		if(researchObject==null){
			researchObject = researchObjectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			researchObject.setName(name);
			researchObject.setLabel(label);
			researchObject.setMetadata(metadata);
			researchObject.setFormatmetadata(formatmetadata);
			super.updateResearchObject(researchObject);
			
			try {
				Long foobar = Project_ResearchObjectLocalServiceUtil.updateProjectResearchObject(projectID, researchObject.getResearchObjectID());
			} catch (NoSuchProject_UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//update ResearchObject
		else{
			researchObject.setName(name);
			researchObject.setLabel(label);
			researchObject.setMetadata(metadata);
			researchObject.setFormatmetadata(formatmetadata);
			super.updateResearchObject(researchObject);
		}
				
		return researchObject.getResearchObjectID();
	}

}