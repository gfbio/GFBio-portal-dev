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

import org.gfbio.model.Basket_User;
import org.gfbio.model.Project;
import org.gfbio.service.Basket_UserLocalServiceUtil;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.base.Basket_UserServiceBaseImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the basket_ user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Basket_UserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.Basket_UserServiceBaseImpl
 * @see org.gfbio.service.Basket_UserServiceUtil
 */
public class Basket_UserServiceImpl extends Basket_UserServiceBaseImpl {
	public List<Basket_User> getBasket_UserList(long userID) throws SystemException{
		try {
			return Basket_UserLocalServiceUtil.getBasket_UserList(userID);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public long updateBasket(long basketID, long userID, String name, String basketJSON) throws SystemException{
		return Basket_UserLocalServiceUtil.updateBasket(basketID, userID, name, basketJSON);
	}
}