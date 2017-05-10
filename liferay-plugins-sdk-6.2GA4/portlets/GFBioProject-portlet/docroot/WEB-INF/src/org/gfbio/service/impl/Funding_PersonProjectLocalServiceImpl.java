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

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.gfbio.NoSuchFunding_PersonProjectException;
import org.gfbio.model.Funding_PersonProject;
import org.gfbio.service.ContentLocalServiceUtil;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.Funding_PersonProjectLocalServiceBaseImpl;
import org.gfbio.service.persistence.Funding_PersonProjectPK;
import org.json.simple.JSONObject;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the funding_ person project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Funding_PersonProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.Funding_PersonProjectLocalServiceBaseImpl
 * @see org.gfbio.service.Funding_PersonProjectLocalServiceUtil
 */
public class Funding_PersonProjectLocalServiceImpl	extends Funding_PersonProjectLocalServiceBaseImpl {

	
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
	public JSONObject createFundingPersonProject(JSONObject requestJson){
		
		Boolean check = false;
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		String [] keySet = {"projectid", "fundingagencyid", "fundingprogramid", "personid", "persontype"};
		for (int i = 0; i< keySet.length;i++)
			set.add(keySet[i]);
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("projectid") && requestJson.containsKey("fundingagencyid") && requestJson.containsKey("fundingprogramid")&& requestJson.containsKey("personid")&& requestJson.containsKey("persontype"))
			check = saveUpdateFundingPersonProject((long) requestJson.get("projectid"), (long) requestJson.get("fundingagencyid"), (long) requestJson.get("fundingprogramid"), (long) requestJson.get("personid"), (String) requestJson.get("persontype"));
		
		
		if (check){
			responseJson.put("projectid", (long) requestJson.get("projectid"));
			responseJson.put("fundingagencyid", (long)  requestJson.get("fundingagencyid"));
			responseJson.put("fundingprogramid", (long) requestJson.get("fundingprogramid"));
			responseJson.put("personid", (long) requestJson.get("personid"));
			responseJson.put("persontype", (String)  requestJson.get("persontype"));
		}else
			responseJson.put("ERROR:", "ERROR: The create of relationship between project, funding and person is not fully completed");

		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING", ignoreParameter);
		
		return responseJson;
	}
	
	
	//----------------------------------- Update Functions -------------------------------------------------//
	
	
	//update or create a new Relationship between a Project and a Research Object
	public Boolean saveUpdateFundingPersonProject(long projectId, long fundingAgencyId, long fundingProgramId, long personId, String personType) {

		Boolean check = false;
		check = ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_fundingagency", fundingAgencyId);
		
		if(check){
			ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_fundingprogram", fundingProgramId);
			
			if (check && (personType.trim()).equals("externalperson"))
				check = ContentLocalServiceUtil.checkExistenceOfKeyId("gfbio_externalperson", personId);
			else{
				if(check && (personType.trim()).equals("user"))
					check = UserExtensionLocalServiceUtil.checkExistenceOfUserId(personId);
				else
					check = false;
			}
				
			if (check)
				check = updateFundingPersonProject(projectId, fundingAgencyId, fundingProgramId, personId, personType);
		}
		return check;
	}
		
		
	//update or create a new Relationship between a Project and a Research Object
	public Boolean updateFundingPersonProject(long projectId, long fundingAgencyId, long fundingProgramId, long personId, String personType) {

		Boolean check = false;
		Funding_PersonProject relationship = null;
		Funding_PersonProjectPK pk = new Funding_PersonProjectPK(projectId, fundingAgencyId, fundingProgramId, personId, personType);
					
		try {relationship = funding_PersonProjectPersistence.findByPrimaryKey(pk);} 
		catch (NoSuchFunding_PersonProjectException | SystemException e1) {System.out.println("no enitity with pk: "+pk+" is found");	}
						
		if (relationship == null) 
			relationship = funding_PersonProjectPersistence.create(pk);
		relationship.setLastModifiedDate(new Timestamp(new Date().getTime()));
		try {
			super.updateFunding_PersonProject(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}
	
}