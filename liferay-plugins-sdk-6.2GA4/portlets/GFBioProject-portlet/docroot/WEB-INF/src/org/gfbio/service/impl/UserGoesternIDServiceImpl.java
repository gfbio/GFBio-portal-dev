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

import org.gfbio.service.UserGoesternIDLocalServiceUtil;
import org.gfbio.service.base.UserGoesternIDServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the user goestern i d remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.UserGoesternIDService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Felicitas Löffler
 * @see org.gfbio.service.base.UserGoesternIDServiceBaseImpl
 * @see org.gfbio.service.UserGoesternIDServiceUtil
 */
public class UserGoesternIDServiceImpl extends UserGoesternIDServiceBaseImpl {
	

	/**
	* returns the userID of a user being identified by goesternID
	*
	* @param goesternID
	* @return userID
	 *@JSONWebService 
	 */
	public long getUserByGoeSternID(long goesternID) {
		return UserGoesternIDLocalServiceUtil.getUserIdByGoesternID(goesternID);
		
	}

	
	/**
	 * returns the goesternID of a user being identified by userID
	 * @param userID
	 * @return goesternID
	 *@JSONWebService 
	 */
	public long getGoesternIdByUserID(long userID) {
		return UserGoesternIDLocalServiceUtil.getGoesternIDByUserID(userID);
		
	}
	
	
	/**
	 * 
	 * returns the goesternID of a user being identified by userID
	 * 
	 *@param userID
	 *@return the number of user goestern ids
	 *@JSONWebService 
	 */
	public int getUserGoesternIDsCount() {
		int count = 0;
		try {
			count = UserGoesternIDLocalServiceUtil.getUserGoesternIDsCount();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}