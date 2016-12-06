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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchSearchHistoryException;
import org.gfbio.Util;
import org.gfbio.model.SearchHistory;
import org.gfbio.service.base.SearchHistoryLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the search history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.SearchHistoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see org.gfbio.service.base.SearchHistoryLocalServiceBaseImpl
 * @see org.gfbio.service.SearchHistoryLocalServiceUtil
 */
public class SearchHistoryLocalServiceImpl extends SearchHistoryLocalServiceBaseImpl {

	public JSONArray getSearchHistoryById(long searchHistoryId) throws SystemException, NoSuchModelException {
		JSONArray jArray = JSONFactoryUtil.createJSONArray();
		try {

			SearchHistory record = searchHistoryPersistence.findBySearchHistoryID(searchHistoryId);
			JSONObject jObj = convertRecordToJSONObject(record);
			jArray.put(jObj);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jArray;
	}

	public JSONArray getSearchHistoryByIds(long[] searchHistoryIDs) throws SystemException, NoSuchModelException {
		JSONArray jArray = JSONFactoryUtil.createJSONArray();
		try {
			
			List<SearchHistory> records = searchHistoryPersistence.findBySearchHistoryIDs(searchHistoryIDs);
			jArray = convertListToJSONArray(records);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jArray;
	}

	public JSONArray getSearchHistoryIdByUserId(long userId) throws SystemException, NoSuchModelException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {

			List<SearchHistory> list = searchHistoryPersistence.findByUserID(userId);
			
			for (int i = 0; i < list.size(); i++) {
				long searchHistoryID = ((SearchHistory) list.get(i)).getSearchHistoryID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchHistoryID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jList;
	}

	// get list of all SearchHistory' Ids of a specific user
	// updated within a specific period
	public JSONArray getSearchHistoryIdByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchHistory> list = new ArrayList<SearchHistory>();
			if (period == 0)
				list = searchHistoryPersistence.findByUserID(userId);
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchHistoryPersistence.findByUserIDSince(userId, startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchHistoryID = ((SearchHistory) list.get(i)).getSearchHistoryID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchHistoryID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jList;
	}

	public JSONArray getSearchHistoryIdByQueryString(String queryString) throws SystemException, NoSuchModelException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {

			List<SearchHistory> list = searchHistoryPersistence.findByQueryMessage(queryString);
			
			for (int i = 0; i < list.size(); i++) {
				long searchHistoryID = ((SearchHistory) list.get(i)).getSearchHistoryID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchHistoryID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jList;
	}
	
	public JSONArray getSearchHistoryIdByQueryStringAndPeriod(String queryString, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchHistory> list = new ArrayList<SearchHistory>();
			if (period == 0)
				list = searchHistoryPersistence.findByQueryMessage(queryString);
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchHistoryPersistence.findByQueryMessageSince(queryString,startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchHistoryID = ((SearchHistory) list.get(i)).getSearchHistoryID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchHistoryID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jList;
	}

	public JSONArray getSearchHistoryIdByPeriod(int period) throws NoSuchModelException, SystemException {
		JSONArray jIdList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchHistory> list = new ArrayList<SearchHistory>();
			if (period == 0)
				list = searchHistoryPersistence.findAll();
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchHistoryPersistence.findBySince(startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchHistoryID = ((SearchHistory) list.get(i)).getSearchHistoryID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchHistoryID));
				jIdList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jIdList;
	}

	// update or create a new search history record

	public long updateSearchHistory(long searchHistoryId, long userId, String queryString, String queryFilter)
			throws SystemException {

		SearchHistory record = null;
		try {

			record = searchHistoryPersistence.findByPrimaryKey(searchHistoryId);
			long ownerId = record.getUserID();
			long currentUser = Util.getLoggedInUserId();
			if (Util.isUserAdmin(currentUser) || ownerId == currentUser) {
				record.setUserID(userId);
				record.setQueryString(queryString);
				record.setQueryFilter(queryFilter);
				Date now = new java.util.Date();
				record.setLastModifiedDate(now);
				super.updateSearchHistory(record);
			} else {
				System.out.println("This user has no rights. Operation aborted.");
			}

		} catch (NoSuchSearchHistoryException e) {
			record = searchHistoryPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			record.setUserID(userId);
			record.setQueryString(queryString);
			record.setQueryFilter(queryFilter);
			Date now = new java.util.Date();
			record.setLastModifiedDate(now);
			super.updateSearchHistory(record);
			e.printStackTrace();
		}

		return record.getSearchHistoryID();
	}

	public SearchHistory removeSearchHistory(long searchHistoryId) throws SystemException, NoSuchModelException {
		SearchHistory record = null;
		try {
			record = searchHistoryPersistence.findByPrimaryKey(searchHistoryId);
			long ownerId = record.getUserID();
			long userId = Util.getLoggedInUserId();
			if (Util.isUserAdmin(userId) || ownerId == userId) {
				record = searchHistoryPersistence.remove(searchHistoryId);
			} else {
				System.out.println("This user has no rights. Operation aborted.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return record;
	}
	private JSONObject convertRecordToJSONObject(SearchHistory hist) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		try {
			if (hist != null) {
				jObj.put("searchHistoryID", Long.valueOf(hist.getSearchHistoryID()));
				jObj.put("userID", Long.valueOf(hist.getUserID()));
				jObj.put("queryString", hist.getQueryString());
				jObj.put("queryFilter", hist.getQueryFilter());
				jObj.put("lastModifiedDate", hist.getLastModifiedDate());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	private JSONArray convertListToJSONArray(List<SearchHistory> list) {
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < list.size(); i++) {
			SearchHistory item = list.get(i);
			JSONObject jObj = convertRecordToJSONObject(item);
			jArr.put(jObj);
		}
		return jArr;
	}
}