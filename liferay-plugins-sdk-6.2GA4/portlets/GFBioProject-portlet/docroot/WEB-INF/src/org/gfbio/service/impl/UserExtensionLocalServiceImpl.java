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
import java.util.List;
import java.util.Set;

import org.gfbio.helper.Helper;
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
		
		if (requestJson.containsKey("userid")){
	
			long userId =0;
			if ((((requestJson.get("userid")).getClass()).toString()).equals("class java.lang.Integer"))
				userId = (long)(int)requestJson.get("userid");
			else
				userId = (long)requestJson.get("userid");
			if (checkExistenceOfUserId(userId))
				try {responseJson = constructUserExtentionJsonById(userPersistence.findByPrimaryKey(userId));}
				catch (NoSuchUserException | SystemException e) {e.printStackTrace();}
			else
				responseJson.put("ERROR", "No 'userid' with "+userId+" exist.");
		}
		
		else
			responseJson.put("ERROR", "No key 'userid' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);
		
		return responseJson;
	}
	
	
	//
	@SuppressWarnings({ "unchecked"})
	public JSONObject getUserExtentionByEmailAddress(JSONObject requestJson){

		JSONObject responseJson = new JSONObject();
		Set<String> set = new HashSet<String>();
		set.add("emailaddress");
		String ignoreParameter = checkForIgnoredParameter(requestJson.keySet().toArray(), set);

		if (requestJson.containsKey("emailaddress")){

			User user = getUserExtentionByEmailAddress(Helper.getStringFromJson(requestJson, "emailaddress"));
			
			if (user != null)
				try {responseJson =constructUserExtentionJsonById(user);}
				catch (NoSuchUserException | SystemException e) {e.printStackTrace();}
			else
				responseJson.put("ERROR", "Loading user information is faild.");
		}else
			responseJson.put("ERROR", "No parameter 'emailaddress' exist.");
		
		if (!ignoreParameter.equals(""))
			responseJson.put("WARNING",ignoreParameter);
		
		return responseJson;
	}
	
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//
	public User getUserExtentionByEmailAddress(String emailAddress){

			User user = null;
			try {
				List <User> userList = null;
				userList = userPersistence.findByEmailAddress(emailAddress.trim());
				if (userList.size()>0 )
					user =	userList.get(0);
			} 
			catch (SystemException e) {e.printStackTrace();}

		return user;
	}
	
	
		
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
	//Is  user id a id of a user, then the Boolean is true
	public Boolean checkExistenceOfUserId (long userId){
		
		Boolean check =false;
		User user = null;
		
		try {user = userPersistence.findByPrimaryKey(userId);} 
		catch (NoSuchUserException | SystemException e) {System.out.println("No user exists with the primary key "+userId);}
		
		if (user !=null)
			check = true;
		
		return check;
	}
	
	
	//Is  user mail a mail of a user, then the Boolean is true
	public Boolean checkExistenceOfUserMail (String eMailAddress){
		
		Boolean check =false;
		List <User> user = null;
		
		try {user = userPersistence.findByEmailAddress(eMailAddress);}
		catch (SystemException e) {e.printStackTrace();System.out.println("No user exists with the primary key "+eMailAddress);}
		
		if (user !=null)
			check = true;
		
		return check;
	}

	
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