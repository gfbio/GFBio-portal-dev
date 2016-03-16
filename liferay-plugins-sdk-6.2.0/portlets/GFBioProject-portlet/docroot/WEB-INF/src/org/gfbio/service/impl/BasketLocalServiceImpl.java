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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
// important!! JSONArray and JSONObject must be from liferay lib
// if using org.json, the response message in liferay webservice will be incomplete 
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

	public JSONArray getBasketById(long basketId) throws SystemException,
			NoSuchModelException {
		JSONArray jBasket = JSONFactoryUtil.createJSONArray();
		try {

			Basket basket = this.basketPersistence.findByBasketId(basketId);
			JSONObject jObj = convertBasketToJSONObject(basket);
			jBasket.put(jObj);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jBasket;
	}

	// get baskets from baskets' Ids

	public JSONArray getBasketsByIds(long[] basketIds)
			throws NoSuchModelException, SystemException {
		JSONArray jBasketList = JSONFactoryUtil.createJSONArray();
		try {
			;
			List<Basket> basketList = this.basketPersistence
					.findByBasketIds(basketIds);
			jBasketList = convertBasketListToJSONArray(basketList);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jBasketList;
	}

	// get list of all baskets of a specific user updated within a specific
	// period

	public JSONArray getBasketsByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jBasketList = JSONFactoryUtil.createJSONArray();
		try {
			List<Basket> basketList = null;
			if (period == 0)
				basketList = basketPersistence.findByUserId(userId);
			else {
				Date startDate = getStartDateFromPeriod(period);
				basketList = basketPersistence.findByUserIdSince(userId,
						startDate);
			}
			jBasketList = convertBasketListToJSONArray(basketList);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jBasketList;
	}

	// get list of all baskets of a specific user

	public JSONArray getBasketsByUserId(long userId) throws SystemException,
			NoSuchModelException {

		JSONArray jBasketList = JSONFactoryUtil.createJSONArray();
		try {
			List<Basket> basketList = basketPersistence.findByUserId(userId);
			jBasketList = convertBasketListToJSONArray(basketList);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jBasketList;
	}

	// get list of all baskets' Ids of a specific user updated within a specific
	// period

	public JSONArray getBasketsIdByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jBasketIdList = JSONFactoryUtil.createJSONArray();
		try {
			List<Basket> basketList = new ArrayList<Basket>();
			if (period == 0)
				basketList = basketPersistence.findByUserId(userId);
			else {
				Date startDate = getStartDateFromPeriod(period);
				basketList = basketPersistence.findByUserIdSince(userId,
						startDate);
			}

			for (int i = 0; i < basketList.size(); i++) {
				long basketID = ((Basket) basketList.get(i)).getBasketID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(basketID));
				jBasketIdList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jBasketIdList;
	}

	// get list of all baskets' Id of a specific user

	public JSONArray getBasketsIdByUserId(long userId) throws SystemException,
			NoSuchModelException {

		JSONArray jBasketIdList = JSONFactoryUtil.createJSONArray();
		try {
			List<Basket> basketList = basketPersistence.findByUserId(userId);

			for (int i = 0; i < basketList.size(); i++) {
				long basketID = ((Basket) basketList.get(i)).getBasketID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(basketID));
				jBasketIdList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jBasketIdList;
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

	public Map<Long, String> getBasketUsersIds(long userId) throws Exception {
		Map<Long, String> users = new HashMap<Long, String>();
		if (isUserAdmin(userId)) {
			List<User> user_list = UserLocalServiceUtil.getUsers(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (User user : user_list) {
				long uId = user.getUserId();
				String uName = user.getFullName();
				// check if this user has basket
				// if (getBasketsByUserId(uId).size() > 0) {
				users.put(uId, uName);
				// }
			}
		} else {
			System.out.println("No admin rights. Operation aborted.");
		}
		return users;
	}

	private JSONObject convertBasketToJSONObject(Basket basket) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		try {
			if (basket != null) {
				jObj.put("basketID", Long.valueOf(basket.getBasketID()));
				jObj.put("userID", Long.valueOf(basket.getUserID()));
				jObj.put("name", basket.getName());
				jObj.put("lastModifiedDate", basket.getLastModifiedDate());
				
				String strBasket = basket.getBasketJSON();
				JSONObject jBasket = JSONFactoryUtil.createJSONObject(strBasket);
				jObj.put("basketJSON", jBasket);
				JSONObject jQuery = JSONFactoryUtil.createJSONObject(basket.getQueryJSON());
				jObj.put("queryJSON", jQuery);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	private JSONArray convertBasketListToJSONArray(List<Basket> basketList) {
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		for (int iBasket = 0; iBasket < basketList.size(); iBasket++) {
			Basket basket = (Basket) basketList.get(iBasket);
			JSONObject jBasket = convertBasketToJSONObject(basket);
			jArr.put(jBasket);
		}
		return jArr;
	}
}