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

import java.util.HashSet;
import java.util.Set;

import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.UserExtensionLocalServiceBaseImpl;
import org.json.simple.JSONObject;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;


/**
 * The implementation of the user extension local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.UserExtensionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.UserExtensionLocalServiceBaseImpl
 * @see org.gfbio.service.UserExtensionLocalServiceUtil
 */
public class UserExtensionLocalServiceImpl	extends UserExtensionLocalServiceBaseImpl {
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//-------------------------------- Manage Get Functions ----------------------------------------------//
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getUserExtentionById(JSONObject requestJson){
		
		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("userid");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);
		
		if (requestJson.containsKey("userid"))
			try {
				responseJson = UserExtensionLocalServiceUtil.constructUserExtentionJsonById(userPersistence.findByPrimaryKey((long)requestJson.get("userid")));
			} catch (NoSuchUserException | SystemException e) {e.printStackTrace();	responseJson.put("ERROR", e);}
		else
			responseJson.put("ERROR", "No key 'userid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);
		
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
		
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
	
	
	//
	@SuppressWarnings("unchecked")
	public  JSONObject constructUserExtentionJsonById (User user) throws NoSuchUserException, SystemException {
		JSONObject json = new JSONObject();
		json.put("userid", user.getUserId());
		json.put("firstname", user.getFirstName());
		json.put("middlename", user.getMiddleName());
		json.put("lastname", user.getLastName());
		json.put("screenname", user.getScreenName());
		json.put("emailaddress", user.getEmailAddress());
		json.put("fullname", user.getFullName());
		return json;
	}
	
	
}