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

import org.gfbio.NoSuchBasket_UserException;
import org.gfbio.model.Basket_User;
import org.gfbio.service.base.Basket_UserLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the basket_ user local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.Basket_UserLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.Basket_UserLocalServiceBaseImpl
 * @see org.gfbio.service.Basket_UserLocalServiceUtil
 */
public class Basket_UserLocalServiceImpl extends
		Basket_UserLocalServiceBaseImpl {

	// get list of all projects of a specific user - if we have a access to the
	// user table, than this method goes to the UserLocalServiceImpl
	public List<Basket_User> getBasket_UserList(long userID)
			throws SystemException, NoSuchModelException {

		List<Basket_User> basketList = null;
		try {
			System.out.println('1');
			basketList = basket_UserPersistence.findByUserID(userID);
//			Session session = null;
//			basketList = session.createSQLQuery("SELECT * FROM org.gfbio.model.Basket_User WHERE userid="+userID).list();
			System.out.println('2');
			System.out.println(basketList.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return basketList;
	}

	// update or create a new project
	public long updateBasket(long basketID, long userID, String name,
			String basketJSON) throws SystemException {

		Basket_User basket = null;
		try {
			// update basket
			basket = basket_UserPersistence.findByPrimaryKey(basketID);
			basket.setUserID(userID);
			basket.setName(name);
			basket.setBasketJSON(basketJSON);
			super.updateBasket_User(basket);
		} catch (NoSuchBasket_UserException e) {
			// create new basket
			basket = basket_UserPersistence.create(CounterLocalServiceUtil
					.increment(getModelClassName()));
			basket.setUserID(userID);
			basket.setName(name);
			basket.setBasketJSON(basketJSON);
			super.updateBasket_User(basket);
			e.printStackTrace();
		}

		return basket.getBasketID();
	}
}