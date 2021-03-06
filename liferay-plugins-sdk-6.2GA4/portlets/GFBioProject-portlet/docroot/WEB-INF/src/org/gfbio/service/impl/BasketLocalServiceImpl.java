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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gfbio.NoSuchBasketException;
import org.gfbio.model.Basket;
import org.gfbio.model.UserSSO;
import org.gfbio.service.UserSSOServiceUtil;
import org.gfbio.service.base.BasketLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
// to create the right JSONArray from string in DB,
// we must use com.liferay.portal.kernel.json
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
// json.simple works for returning JSONObject in web service
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
// important!! JSONArray and JSONObject must be from liferay lib
// if using org.json, the response message in liferay webservice will be incomplete 
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

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
	private static Log log = LogFactoryUtil
			.getLog(BasketLocalServiceImpl.class);

	// get a basket from basket's Id

	public JSONObject getBasketById(long basketId, boolean isMinimal)
			throws SystemException, NoSuchModelException {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		try {

			Basket basket = this.basketPersistence.findByBasketId(basketId);
			if (isMinimal) {
				jObj = convertMiniBasketToJSONObject(basket);
			} else {
				jObj = convertBasketToJSONObject(basket);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	// get baskets from baskets' Ids

	public JSONArray getBasketsByIds(long[] basketIds, boolean isMinimal)
			throws NoSuchModelException, SystemException {
		JSONArray jBasketList = JSONFactoryUtil.createJSONArray();
		try {
			List<Basket> basketList = this.basketPersistence
					.findByBasketIds(basketIds);
			if (isMinimal) {
				jBasketList = convertMiniBasketListToJSONArray(basketList, 0, 0);
			} else {
				jBasketList = convertBasketListToJSONArray(basketList);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return jBasketList;
	}

	// get list of all baskets of a specific user updated
	// within a specific period
	public com.liferay.portal.kernel.json.JSONObject getBasketsByUserAndPeriod(
			long userId, int period, boolean isMinimal, int from, int count)
			throws NoSuchModelException, SystemException {
		com.liferay.portal.kernel.json.JSONObject jBasketList = JSONFactoryUtil
				.createJSONObject();
		try {
			List<Basket> basketList = null;
			if (period == 0)
				basketList = basketPersistence.findByUserId(userId);
			else {
				Date startDate = getStartDateFromPeriod(period);
				basketList = basketPersistence.findByUserIdSince(userId,
						startDate);
			}
			if (isMinimal) {
				jBasketList = convertMiniBasketListToJSONObject(basketList,
						from, count);
			} else {
				jBasketList = convertBasketListToJSONObject(basketList, from,
						count);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return jBasketList;
	}

	// get list of all baskets of a specific user

	public com.liferay.portal.kernel.json.JSONObject getBasketsByUserId(
			long userId, boolean isMinimal, int from, int count)
			throws SystemException, NoSuchModelException {

		JSONObject jBasketList = JSONFactoryUtil.createJSONObject();
		try {
			List<Basket> basketList = basketPersistence.findByUserId(userId);
			if (isMinimal) {
				jBasketList = convertMiniBasketListToJSONObject(basketList,
						from, count);
			} else {
				jBasketList = convertBasketListToJSONObject(basketList, from,
						count);
			}
		} catch (Exception e) {
			log.error(e.toString());
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
				long basketID = basketList.get(i).getBasketID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(basketID));
				jBasketIdList.put(jObj);
			}
		} catch (Exception e) {
			log.error(e.toString());
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
				long basketID = basketList.get(i).getBasketID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(basketID));
				jBasketIdList.put(jObj);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return jBasketIdList;
	}

	// update or create a new basket

	public long updateBasket(long basketId, long userId, String name,
			String basketContent, String queryJSON, String queryKeyword,
			String queryFilter) throws SystemException {

		Basket basket = null;
		try {

			// update basket
			basket = basketPersistence.findByPrimaryKey(basketId);
			long ownerId = basket.getUserID();
			long currentUser = getLoggedInUserId();
			if (isUserAdmin(currentUser) || ownerId == currentUser) {
				basket.setUserID(userId);
				basket.setName(name);
				Date now = new java.util.Date();
				basket.setLastModifiedDate(now);
				basket.setBasketContent(basketContent);
				basket.setQueryJSON(queryJSON);
				basket.setQueryKeyword(queryKeyword);
				basket.setQueryFilter(queryFilter);
				super.updateBasket(basket);
			} else {
				System.out
						.println("This user has no rights. Operation aborted.");
			}

		} catch (NoSuchBasketException e) {

			// create new basket

			basket = basketPersistence.create(CounterLocalServiceUtil
					.increment(getModelClassName()));
			basket.setUserID(userId);
			basket.setName(name);
			Date now = new java.util.Date();
			basket.setLastModifiedDate(now);
			basket.setBasketContent(basketContent);
			basket.setQueryJSON(queryJSON);
			basket.setQueryKeyword(queryKeyword);
			basket.setQueryFilter(queryFilter);
			super.updateBasket(basket);
			e.printStackTrace();
		}

		return basket.getBasketID();
	}

	public Basket removeBasket(long basketId) throws SystemException,
			NoSuchModelException {
		Basket basket = null;
		try {
			basket = basketPersistence.findByPrimaryKey(basketId);
			long ownerId = basket.getUserID();
			long userId = getLoggedInUserId();
			if (isUserAdmin(userId) || ownerId == userId) {
				basket = basketPersistence.remove(basketId);
			} else {
				System.out
						.println("This user has no rights. Operation aborted.");
			}

		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}

		return basket;
	}

	// ////////////////////////////////////////////////////////////////////////////

	// period = 0 : all time, period = 1 : 1 day, period = 2 : 2 days,
	// period = 10 : 1 week, period = 20 : 2 weeks, period = 100 : 1 month,
	// period = 200 : 2 months, period = 300 : 3 months, period = 600 : 6
	// months,
	// period = 1000 : 1 year, period = 2000 : 2 years, period = 3000 : 3 years

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
				// log.error(role.getName());
				if (role.getName().indexOf("Administrator") > -1) {
					isAdmin = true;
					break;
				}
			}
		} catch (SystemException e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return isAdmin;
	}

	public long getLoggedInUserId() {
		try {
			ServiceContext serviceContext = ServiceContextThreadLocal
					.getServiceContext();
			if (null == serviceContext) {
				System.out
						.println("ServiceContext is unavailable, returning default user");
				long companyId = PortalUtil.getDefaultCompanyId();
				long defaultUserId = UserLocalServiceUtil
						.getDefaultUserId(companyId);
				return defaultUserId;
			}

			return serviceContext.getUserId();
		} catch (Exception e) {
			log.error(e);
			return 0;
		}
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
		// JSONParser jParser = new JSONParser();
		try {
			if (basket != null) {
				jObj.put("basketID", Long.valueOf(basket.getBasketID()));
				jObj.put("userID", Long.valueOf(basket.getUserID()));
				jObj.put("name", basket.getName());
				jObj.put("lastModifiedDate", basket.getLastModifiedDate());
				String queryKeyword = basket.getQueryKeyword();
				jObj.put("queryKeyword", queryKeyword);

				String strBasket = basket.getBasketContent();
				// to convert string from DB, simple.json doesn't work
				JSONObject jBasket = JSONFactoryUtil
						.createJSONObject(strBasket);
				jObj.put("basketContent", jBasket);

				String strQuery = basket.getQueryJSON();
				JSONObject jQuery = JSONFactoryUtil.createJSONObject(strQuery);
				jObj.put("queryJSON", jQuery);

				String strQueryFilter = basket.getQueryFilter();
				JSONArray jaFilter = JSONFactoryUtil
						.createJSONArray(strQueryFilter);
				jObj.put("queryFilter", jaFilter);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	private JSONObject convertMiniBasketToJSONObject(Basket basket) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		try {
			if (basket != null) {
				jObj.put("basketID", Long.valueOf(basket.getBasketID()));
				jObj.put("userID", Long.valueOf(basket.getUserID()));
				jObj.put("name", basket.getName());
				jObj.put("lastModifiedDate", basket.getLastModifiedDate());

				String strBasket = basket.getBasketContent();
				JSONObject jBasket = JSONFactoryUtil
						.createJSONObject(strBasket);
				JSONObject jMiniBasket = JSONFactoryUtil.createJSONObject();
				JSONArray jaMiniItems = JSONFactoryUtil.createJSONArray();
				JSONArray selected = jBasket.getJSONArray("selected");
				for (int i = 0; i < selected.length(); i++) {
					JSONObject jSelectedItem = selected.getJSONObject(i);
					JSONObject jMiniItem = JSONFactoryUtil.createJSONObject();
					jMiniItem.put("title", jSelectedItem.getString("title"));
					jMiniItem
							.put("authors", jSelectedItem.getString("authors"));
					jMiniItem.put("metadatalink",
							jSelectedItem.getString("metadatalink"));
					jMiniItem.put("dcType", jSelectedItem.getString("dcType"));
					jMiniItem.put("parentIdentifier",
							jSelectedItem.getString("parentIdentifier"));
					jMiniItem.put("unitType",
							jSelectedItem.getString("unitType"));
					jMiniItem.put("dcIdentifier",
							jSelectedItem.getString("dcIdentifier"));
					jMiniItem.put("vatVisualizable",
							jSelectedItem.getBoolean("vatVisualizable"));
					jaMiniItems.put(jMiniItem);
				}
				jMiniBasket.put("selected", jaMiniItems);
				jObj.put("basketContent", jMiniBasket);

				String queryKeyword = basket.getQueryKeyword();
				jObj.put("queryKeyword", queryKeyword);
			}
		} catch (Exception e) {
			log.error(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	private JSONArray convertBasketListToJSONArray(List<Basket> basketList) {
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		for (int iBasket = 0; iBasket < basketList.size(); iBasket++) {
			Basket basket = basketList.get(iBasket);
			JSONObject jBasket = convertBasketToJSONObject(basket);
			jArr.put(jBasket);
		}
		return jArr;
	}

	private JSONObject convertBasketListToJSONObject(List<Basket> basketList,
			int fromInd, int count) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		int startInd = 0;
		int stopInd = basketList.size();
		if (fromInd > 0)
			startInd = fromInd - 1;
		if (count > 0 && startInd + count < stopInd)
			stopInd = startInd + count;

		for (int iBasket = startInd; iBasket < stopInd; iBasket++) {
			Basket basket = basketList.get(iBasket);
			JSONObject jBasket = convertBasketToJSONObject(basket);
			jArr.put(jBasket);
		}
		jObj.put("totalNumberOfBaskets", basketList.size());
		jObj.put("results", jArr);
		return jObj;
	}

	private JSONArray convertMiniBasketListToJSONArray(List<Basket> basketList,
			int fromInd, int count) {
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		int startInd = 0;
		int stopInd = basketList.size();
		if (fromInd > 0)
			startInd = fromInd - 1;
		if (count > 0 && startInd + count < stopInd)
			stopInd = startInd + count;

		for (int iBasket = startInd; iBasket < stopInd; iBasket++) {
			Basket basket = basketList.get(iBasket);

			JSONObject jBasket = convertMiniBasketToJSONObject(basket);
			jArr.put(jBasket);
		}
		return jArr;
	}

	private JSONObject convertMiniBasketListToJSONObject(
			List<Basket> basketList, int fromInd, int count) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		int startInd = 0;
		int stopInd = basketList.size();
		if (fromInd > 0)
			startInd = fromInd - 1;
		if (count > 0 && startInd + count < stopInd)
			stopInd = startInd + count;

		for (int iBasket = startInd; iBasket < stopInd; iBasket++) {
			Basket basket = basketList.get(iBasket);

			JSONObject jBasket = convertMiniBasketToJSONObject(basket);
			jArr.put(jBasket);
		}
		jObj.put("totalNumberOfBaskets", basketList.size());
		jObj.put("results", jArr);
		return jObj;
	}

	public JSONArray getUserDetail(long userId) throws PortalException,
			SystemException {

		JSONArray res = JSONFactoryUtil.createJSONArray();
		long currentUserId = PrincipalThreadLocal.getUserId();
		boolean adminRole = isUserAdmin(currentUserId);
		if (adminRole)
			System.out.println("This user is admin");
		if (adminRole || (currentUserId == userId)) {
			System.out.println("authen success");
			User user = UserLocalServiceUtil.getUser(userId);
			JSONObject juser = JSONFactoryUtil.createJSONObject();
			juser.put("createDate", user.getCreateDate());
			juser.put("emailAddress", user.getEmailAddress());
			juser.put("firstName", user.getFirstName());
			juser.put("lastName", user.getLastName());
			juser.put("screenName", user.getScreenName());
			juser.put("jobTitle", user.getJobTitle());
			juser.put("lastLoginDate", user.getLastLoginDate());
			juser.put("userId", user.getUserId());
			res.put(juser);
			return res;
		} else
			return null;
	}

	public JSONArray authenticate(String token) throws Exception {
		JSONArray res = JSONFactoryUtil.createJSONArray();
		long userID = PrincipalThreadLocal.getUserId();

		// return 0 : success, 1 : token expired,
		// 2 : no record found, 3 non-admin user,
		// 4 : unknown error ;
		int auth = UserSSOServiceUtil.authenticateToken(token, userID);
		System.out.println("This user is admin");
		// User user = UserLocalServiceUtil.getUser(userID);
		// PermissionChecker checker =
		// PermissionCheckerFactoryUtil.create(user);
		// boolean isSigned = checker.isSignedIn();
		JSONObject jres = JSONFactoryUtil.createJSONObject();
		jres.put("success", auth);
		if (auth == 0) {
			UserSSO sso = userSSOPersistence.findByToken(token);
			long tokenOwner = sso.getUserID();
			jres.put("userid", tokenOwner);
		} else {
			jres.put("userid", 0);
		}
		res.put(jres);

		return res;
	}

	public String getToken() {
		long userID = PrincipalThreadLocal.getUserId();
		String token = UserSSOServiceUtil.getToken(userID);
		return token;
	}

	// private static String byteToHex(final byte[] hash) {
	// Formatter formatter = new Formatter();
	// for (byte b : hash) {
	// formatter.format("%02x", b);
	// }
	// String result = formatter.toString();
	// formatter.close();
	// return result;
	// }
}