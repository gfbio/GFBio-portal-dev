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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import org.gfbio.model.Basket;
import org.gfbio.service.BasketLocalServiceUtil;
import org.gfbio.service.base.BasketServiceBaseImpl;

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
	public JSONObject getBasketById(long basketId, boolean isMinimal) throws SystemException {
		try {
			if (isMinimal){ 
				System.out.println(":: getBasketById :: minimal Basket.");
			}
			return BasketLocalServiceUtil.getBasketById(basketId, isMinimal);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getBasketsByIds(long[] basketIds, boolean isMinimal) throws SystemException {
		try {
			if (isMinimal){ 
				System.out.println(":: getBasketsByIds :: minimal Baskets.");
			}
			return BasketLocalServiceUtil.getBasketsByIds(basketIds, isMinimal);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONObject getBasketsByUserAndPeriod(long userId, int period, boolean isMinimal, int from, int count) throws SystemException {
		try {
			if (isMinimal){ 
				System.out.println(":: getBasketsByUserAndPeriod :: minimal Baskets start from index: "+from+" for:"+count+" items.");
			}
			else{
				System.out.println(":: getBasketsByUserAndPeriod :: full Baskets start from index: "+from+" for:"+count+" items.");
			}
			return BasketLocalServiceUtil.getBasketsByUserAndPeriod(userId, period, isMinimal, from, count);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONObject getBasketsByUserId(long userId, boolean isMinimal, int from, int count) throws SystemException {
		try {
			if (isMinimal){ 
				System.out.println(":: getBasketsByUserId :: minimal Baskets start from index: "+from+" for:"+count+" items.");
			}
			else{
				System.out.println(":: getBasketsByUserId :: full Baskets start from index: "+from+" for:"+count+" items.");
				
			}
			return BasketLocalServiceUtil.getBasketsByUserId(userId, isMinimal, from, count);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public JSONArray getBasketIdsByUserAndPeriod(long userId, int period) throws SystemException {
		try {
			return BasketLocalServiceUtil.getBasketIdsByUserAndPeriod(userId, period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public JSONObject getBasketsByGoesternId(String goesternId, boolean isMinimal, int from, int count) throws SystemException {
		try {
			if (isMinimal){ 
				System.out.println(":: getBasketsByUserId :: minimal Baskets start from index: "+from+" for:"+count+" items.");
			}
			else{
				System.out.println(":: getBasketsByUserId :: full Baskets start from index: "+from+" for:"+count+" items.");
				
			}
			return BasketLocalServiceUtil.getBasketsByGoesternId(goesternId, isMinimal, from, count);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getBasketIdsByUserId(long userId) throws SystemException {
		
		try {
			return BasketLocalServiceUtil.getBasketIdsByUserId(userId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	
public JSONArray getBasketIdsByGoesternId(String goesternId) throws SystemException {
		
		try {
			return BasketLocalServiceUtil.getBasketIdsByGoesternId(goesternId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public long updateBasket(long basketId, long userId, String name, 
			String basketContent, String queryJSON,
			String queryKeyword, String queryFilter) throws SystemException {
		return BasketLocalServiceUtil.updateBasket(basketId, userId, name, 
				basketContent, queryJSON, queryKeyword, queryFilter);
	}

	public Basket removeBasket(long basketId)
			throws NoSuchModelException, SystemException {
		return BasketLocalServiceUtil.removeBasket(basketId);
	}
	
	public Map<Long,String> getBasketUsersIds(long userId) throws Exception{
		return BasketLocalServiceUtil.getBasketUsersIds(userId);
	}
	public JSONArray getUserDetail(long userId) throws PortalException, SystemException{
		return BasketLocalServiceUtil.getUserDetail(userId);
	}

	public JSONArray authenticate(String token) throws Exception{
		return BasketLocalServiceUtil.authenticate(token);
	}

	public String getToken() throws Exception{
		return BasketLocalServiceUtil.getToken();
	}
	public long getLoggedInUserId() throws Exception{
		return BasketLocalServiceUtil.getLoggedInUserId();
	}
}