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

import org.gfbio.model.Basket;
import org.gfbio.service.BasketLocalServiceUtil;
import org.gfbio.service.base.BasketServiceBaseImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the basket remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.BasketService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.BasketServiceBaseImpl
 * @see org.gfbio.service.BasketServiceUtil
 */
public class BasketServiceImpl extends BasketServiceBaseImpl {
	public List<Basket> getBasketList(long userID) throws SystemException{
		try {
			return BasketLocalServiceUtil.getBasket_UserList(userID);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public long updateBasket(long basketID, long userID, String name, String basketJSON, String queryJSON) throws SystemException{
		return BasketLocalServiceUtil.updateBasket(basketID, userID, name, basketJSON, queryJSON);
	}

	public Basket removeBasket(long basketID)
			throws SystemException, NoSuchModelException {
		return BasketLocalServiceUtil.removeBasket_User(basketID);
	}
}