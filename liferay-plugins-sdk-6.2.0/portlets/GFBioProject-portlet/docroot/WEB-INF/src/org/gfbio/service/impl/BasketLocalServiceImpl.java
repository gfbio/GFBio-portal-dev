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

import org.gfbio.NoSuchBasketException;
import org.gfbio.model.Basket;
import org.gfbio.service.base.BasketLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the basket local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.BasketLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.BasketLocalServiceBaseImpl
 * @see org.gfbio.service.BasketLocalServiceUtil
 */
public class BasketLocalServiceImpl extends BasketLocalServiceBaseImpl {
	// get list of all baskets of a specific user 
	public List<Basket> getBasket_UserList(long userID)
			throws SystemException, NoSuchModelException {

		List<Basket> basketList = null;
		try {
			basketList = basketPersistence.findByUserID(userID);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return basketList;
	}

	// update or create a new project
	public long updateBasket(long basketID, long userID, String name,
			String basketJSON, String queryJSON) throws SystemException {

		Basket basket = null;
		try {
			// update basket
			basket = basketPersistence.findByPrimaryKey(basketID);
			basket.setUserID(userID);
			basket.setName(name);
			basket.setBasketJSON(basketJSON);
			basket.setQueryJSON(queryJSON);
			super.updateBasket(basket);
		} catch (NoSuchBasketException e) {
			// create new basket
			basket = basketPersistence.create(CounterLocalServiceUtil
					.increment(getModelClassName()));
			basket.setUserID(userID);
			basket.setName(name);
			basket.setBasketJSON(basketJSON);
			basket.setQueryJSON(queryJSON);
			super.updateBasket(basket);
			e.printStackTrace();
		}

		return basket.getBasketID();
	}
	
	public Basket removeBasket_User(long basketID)
			throws SystemException, NoSuchModelException {
		Basket basket = null;
		try {
			basket = basketPersistence.remove(basketID);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return basket;
	}
}