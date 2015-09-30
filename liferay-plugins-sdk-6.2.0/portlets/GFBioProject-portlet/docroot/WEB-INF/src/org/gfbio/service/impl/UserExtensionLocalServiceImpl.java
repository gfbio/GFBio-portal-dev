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

import org.gfbio.NoSuchUserExtensionException;
import org.gfbio.model.UserExtension;
import org.gfbio.service.ProjectLocalServiceUtil;
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
	public JSONObject getUserExtentionById(JSONObject json){
		
		JSONObject responseJson = new JSONObject();
		
		if (json.containsKey("userid")){
			responseJson = UserExtensionLocalServiceUtil.constructUserExtentionJsonById(UserExtensionLocalServiceUtil.getUserById((long)json.get("userid")));
			if (responseJson == null)
				responseJson.put("ERROR", "Failed by response user");
		}
		else
			responseJson.put("ERROR", "No key 'userid' exist.");

		
		return responseJson;
	}
	
	
	//----------------------------------- Get Functions --------------------------------------------------//
	
	
	//
	public User getUserById(long userId) throws NoSuchUserException, SystemException{
		return userPersistence.findByPrimaryKey(userId);
	}
	
		
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	
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