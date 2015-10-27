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


import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.UserExtensionServiceBaseImpl;
import org.json.simple.JSONObject;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the user extension remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.UserExtensionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.UserExtensionServiceBaseImpl
 * @see org.gfbio.service.UserExtensionServiceUtil
 */
public class UserExtensionServiceImpl extends UserExtensionServiceBaseImpl {

	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//
	/**
	 *@param test
	 *@JSONWebService tester
	 */
	public JSONObject getUserById(JSONObject json) throws NoSuchModelException, SystemException {
		return UserExtensionLocalServiceUtil.getUserExtentionById(json);
	}
	
	
}