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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gfbio.NoSuchBasketException;
import org.gfbio.model.Basket;
import org.gfbio.service.base.BasketLocalServiceBaseImpl;

/**
 * The implementation of the basket local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.BasketLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.BasketLocalServiceBaseImpl
 * @see org.gfbio.service.BasketLocalServiceUtil
 */
public class BasketLocalServiceImpl extends BasketLocalServiceBaseImpl {

	// get a basket from basket's Id

	public Basket getBasketById(long basketId) throws SystemException,
			NoSuchModelException {
		Basket basket = null;
		try {
			basket = basketPersistence.findByBasketId(basketId);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basket;
	}

	// get baskets from baskets' Ids

	public List<Basket> getBasketsByIds(long[] basketIds)
			throws NoSuchModelException, SystemException {
		List<Basket> basketList = null;
		try {
			basketList = basketPersistence.findByBasketIds(basketIds);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basketList;
	}

	// get list of all baskets of a specific user updated within a specific
	// period

	public List<Basket> getBasketsByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		List<Basket> basketList = null;
		try {
			if (period == 0)
				basketList = basketPersistence.findByUserId(userId);
			else {
				Date startDate = getStartDateFromPeriod(period);
				basketList = basketPersistence.findByUserIdSince(userId,
						startDate);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basketList;
	}

	// get list of all baskets of a specific user

	public List<Basket> getBasketsByUserId(long userId) throws SystemException,
			NoSuchModelException {

		List<Basket> basketList = null;
		try {
			basketList = basketPersistence.findByUserId(userId);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basketList;
	}

	// get list of all baskets' Ids of a specific user updated within a specific
	// period

	public List<Long> getBasketsIdByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		List<Basket> basketList = new ArrayList<Basket>();
		List<Long> basketIdList = new ArrayList<Long>();
		try {
			if (period == 0)
				basketList = basketPersistence.findByUserId(userId);
			else {
				Date startDate = getStartDateFromPeriod(period);
				basketList = basketPersistence.findByUserIdSince(userId,
						startDate);
			}

			for (int i = 0; i < basketList.size(); i++) {
				basketIdList.add(basketList.get(i).getBasketID());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basketIdList;
	}

	// get list of all baskets' Id of a specific user

	public List<Long> getBasketsIdByUserId(long userId) throws SystemException,
			NoSuchModelException {

		List<Long> basketIdList = new ArrayList<Long>();
		try {
			List<Basket> basketList = basketPersistence.findByUserId(userId);

			for (int i = 0; i < basketList.size(); i++) {
				basketIdList.add(basketList.get(i).getBasketID());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basketIdList;
	}

	// update or create a new project

	public long updateBasket(long basketId, long userId, String name,
			String basketJSON, String queryJSON) throws SystemException {

		Basket basket = null;
		try {

			// update basket

			basket = basketPersistence.findByPrimaryKey(basketId);
			if (isUserAdmin(userId)) {
				basket.setUserID(userId);
				basket.setName(name);
				Date now = new java.util.Date();
				basket.setLastModifiedDate(now);
				basket.setBasketJSON(basketJSON);
				basket.setQueryJSON(queryJSON);
				super.updateBasket(basket);
			} else {
				System.out.println("No admin rights. Operation aborted.");
			}

		} catch (NoSuchBasketException e) {

			// create new basket

			basket = basketPersistence.create(CounterLocalServiceUtil
					.increment(getModelClassName()));
			basket.setUserID(userId);
			basket.setName(name);
			Date now = new java.util.Date();
			basket.setLastModifiedDate(now);
			basket.setBasketJSON(basketJSON);
			basket.setQueryJSON(queryJSON);
			super.updateBasket(basket);
			e.printStackTrace();
		}

		return basket.getBasketID();
	}

	public Basket removeBasket(long basketId, long userId)
			throws SystemException, NoSuchModelException {
		Basket basket = null;
		try {
			if (isUserAdmin(userId)) {
				basket = basketPersistence.remove(basketId);
			} else {
				System.out.println("No admin rights. Operation aborted.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return basket;
	}

	// ////////////////////////////////////////////////////////////////////////////

	// period = 0 : all time period = 1 : 1 day period = 2 : 2 days period = 10
	// : 1 week period = 20 : 2 weeks period = 100 : 1 month period = 200 : 2
	// months period = 300 : 3 months period = 600 : 6 months period = 1000 : 1
	// year period = 2000 : 2 years period = 3000 : 3 years

	// ////////////////////////////////////////////////////////////////////////////
	public Date getStartDateFromPeriod(int period) {
		Date date = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (period) {
		case 1:
			cal.add(Calendar.DATE, -1);
			break;
		case 2:
			cal.add(Calendar.DATE, -2);
			break;
		case 10:
			cal.add(Calendar.DATE, -7);
			break;
		case 20:
			cal.add(Calendar.DATE, -14);
			break;
		case 100:
			cal.add(Calendar.MONTH, -1);
			break;
		case 200:
			cal.add(Calendar.MONTH, -2);
			break;
		case 300:
			cal.add(Calendar.MONTH, -3);
			break;
		case 600:
			cal.add(Calendar.MONTH, -6);
			break;
		case 1000:
			cal.add(Calendar.YEAR, -1);
			break;
		case 2000:
			cal.add(Calendar.YEAR, -2);
			break;
		case 3000:
			cal.add(Calendar.YEAR, -3);
			break;
		default:
			cal.add(Calendar.YEAR, -1000);
			break;
		}

		Date startDate = cal.getTime();
		return startDate;
	}

	private boolean isUserAdmin(long userId) {
		boolean isAdmin = false;
		try {
			List<Role> roles;
			roles = RoleLocalServiceUtil.getUserRoles(userId);
			for (Role role : roles) {
				// System.out.println(role.getName());
				if (role.getName().indexOf("Administrator") > -1) {
					isAdmin = true;
					break;
				}
			}
		} catch (SystemException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return isAdmin;
	}

	public Map<Long,String> getBasketUsersIds(long userId) throws Exception {
		Map<Long,String> users = new HashMap<Long,String>();
		if (isUserAdmin(userId)) {
			List<User> user_list = UserLocalServiceUtil.getUsers(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (User user : user_list) {
				long uId = user.getUserId();
				String uName = user.getFullName(); 
				// check if this user has basket 
				//if (getBasketsByUserId(uId).size() > 0) {
				users.put(uId,uName);
				//}
			}
		} else {
			System.out.println("No admin rights. Operation aborted.");
		}
		return users;
	}
}