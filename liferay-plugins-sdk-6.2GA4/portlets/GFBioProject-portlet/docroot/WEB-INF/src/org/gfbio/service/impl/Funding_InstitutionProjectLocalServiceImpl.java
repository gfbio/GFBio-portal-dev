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

import java.util.HashSet;
import java.util.Set;

import org.gfbio.NoSuchFunding_InstitutionProjectException;
import org.gfbio.model.Funding_InstitutionProject;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.base.Funding_InstitutionProjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Funding_InstitutionProjectPK;

import org.json.simple.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the funding_ institution project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Funding_InstitutionProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.Funding_InstitutionProjectLocalServiceBaseImpl
 * @see org.gfbio.service.Funding_InstitutionProjectLocalServiceUtil
 */
public class Funding_InstitutionProjectLocalServiceImpl	extends Funding_InstitutionProjectLocalServiceBaseImpl {

	
	///////////////////////////////////// Get Functions //////////////////////////////////////////////////////
	
	
	
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
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	//--------------------------------- Manage Get Functions -----------------------------------------------//

	
	//
	@SuppressWarnings("unchecked")
	public JSONObject createFunding_InstitutionProject(JSONObject requestJson){
		
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"projectid", "fundingagencyid", "fundingprogramid", "institutionid"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("projectid") && requestJson.containsKey("fundingagencyid") && requestJson.containsKey("fundingprogramid")&& requestJson.containsKey("institutionid"))
			check = saveUpdateFunding_InstitutionProject((long) requestJson.get("projectid"), (long) requestJson.get("fundingagencyid"), (long) requestJson.get("fundingprogramid"), (long) requestJson.get("institutionid"));
		
		if (check){
			responseJson.put("projectid", (long) requestJson.get("projectid"));
			responseJson.put("fundingagencyid", (long)  requestJson.get("fundingagencyid"));
			responseJson.put("fundingprogramid", (long) requestJson.get("fundingprogramid"));
			responseJson.put("institutionid", (long) requestJson.get("institutionid"));
		}else
			responseJson.put("ERROR:", "ERROR: The create of relationship between project, funding and person is not fully completed");

		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//update or create a new Relationship between a Project and a Research Object
	public Boolean saveUpdateFunding_InstitutionProject(long projectId, long fundingAgencyId, long fundingProgramId, long institutionId) {

		Boolean check = false;
		check = ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_fundingagency", fundingAgencyId);
		
		if(check){
			ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_fundingprogram", fundingProgramId);
			if (check){
				check = ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_institution", institutionId);
				if (check)
					check = updateFunding_InstitutionProject(projectId, fundingAgencyId, fundingProgramId, institutionId);
			}
		}
		return check;
	}
		
		
	//update or create a new Relationship between a Project and a Research Object
	public Boolean updateFunding_InstitutionProject(long projectId, long fundingAgencyId, long fundingProgramId, long institutionId) {

		Boolean check = false;
		Funding_InstitutionProject relation = null;
		Funding_InstitutionProjectPK pk = new Funding_InstitutionProjectPK(projectId, fundingAgencyId, fundingProgramId, institutionId);
					
		try {relation = funding_InstitutionProjectPersistence.findByPrimaryKey(pk);	}
		catch (NoSuchFunding_InstitutionProjectException | SystemException e1) {System.out.println("no enitity with pk: "+pk+" is found");}

		if (relation == null) 
			relation = funding_InstitutionProjectPersistence.create(pk);

		try {
			super.updateFunding_InstitutionProject(relation);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}
}