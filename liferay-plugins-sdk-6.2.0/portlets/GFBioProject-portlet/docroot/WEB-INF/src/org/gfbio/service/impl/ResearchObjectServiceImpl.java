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

import org.gfbio.model.ResearchObject;
import org.gfbio.service.ResearchObjectLocalServiceUtil;
import org.gfbio.service.SubmissionRegistryLocalServiceUtil;
import org.gfbio.service.base.ResearchObjectServiceBaseImpl;
import org.json.simple.JSONObject;



/**
 * The implementation of the research object remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ResearchObjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.ResearchObjectServiceBaseImpl
 * @see org.gfbio.service.ResearchObjectServiceUtil
 */
public class ResearchObjectServiceImpl extends ResearchObjectServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////


/*	//
	public List <ResearchObject> getAllChildren (long researchObjectId){
		return ResearchObjectLocalServiceUtil.getAllChildren(researchObjectId);
	}*/
	
	
	//
	public JSONObject getResearchObjectAbsolutParent (JSONObject json){
		return ResearchObjectLocalServiceUtil.getResearchObjectAbsolutParent(json);
	}
	
	
	//
	public JSONObject getResearchObjectsByParent (JSONObject json){
		return ResearchObjectLocalServiceUtil.getResearchObjectsByParent(json);
	}
	
	
	//
	public JSONObject getResearchObjectById (long researchObjectId){
		return ResearchObjectLocalServiceUtil.getResearchObjectASJsonById(researchObjectId);
	}
	
	
	//
	public JSONObject getResearchObjectParent (JSONObject json){
		return ResearchObjectLocalServiceUtil.getResearchObjectParent(json);
	}
	
		
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//
	public JSONObject createResearchObject(JSONObject json){
		return ResearchObjectLocalServiceUtil.createResearchObjectByJson(json);
	}
	
	
	//
	public JSONObject updateResearchObject(JSONObject json){
		return ResearchObjectLocalServiceUtil.updateResearchObjectByJson(json);
	}
	
}