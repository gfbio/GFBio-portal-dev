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

import org.gfbio.NoSuchSearchFeedbackException;
import org.gfbio.Util;
import org.gfbio.model.SearchFeedback;
import org.gfbio.service.base.SearchFeedbackLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The implementation of the search feedback local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.SearchFeedbackLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see org.gfbio.service.base.SearchFeedbackLocalServiceBaseImpl
 * @see org.gfbio.service.SearchFeedbackLocalServiceUtil
 */
public class SearchFeedbackLocalServiceImpl
	extends SearchFeedbackLocalServiceBaseImpl {

	public JSONArray getSearchFeedbackById(long searchFeedbackId) throws SystemException, NoSuchModelException {
		JSONArray jArray = JSONFactoryUtil.createJSONArray();
		try {

			SearchFeedback record = searchFeedbackPersistence.findBySearchFeedbackID(searchFeedbackId);
			JSONObject jObj = convertRecordToJSONObject(record);
			jArray.put(jObj);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jArray;
	}

	public JSONArray getSearchFeedbackByIds(long[] searchFeedbackIDs) throws SystemException, NoSuchModelException {
		JSONArray jArray = JSONFactoryUtil.createJSONArray();
		try {
			
			List<SearchFeedback> records = searchFeedbackPersistence.findBySearchFeedbackIDs(searchFeedbackIDs);
			jArray = convertListToJSONArray(records);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jArray;
	}

	public JSONArray getSearchFeedbackIdByUserId(long userId) throws SystemException, NoSuchModelException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {

			List<SearchFeedback> list = searchFeedbackPersistence.findByUserID(userId);
			
			for (int i = 0; i < list.size(); i++) {
				long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchFeedbackID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jList;
	}
	
	public JSONArray getSearchFeedbackIdByUserAndPeriod(long userId, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchFeedback> list = new ArrayList<SearchFeedback>();
			if (period == 0)
				list = searchFeedbackPersistence.findByUserID(userId);
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchFeedbackPersistence.findByUserIDSince(userId, startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchFeedbackID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jList;
	}
	
	public JSONArray getSearchFeedbackIdByRating(int[] ratings) throws SystemException, NoSuchModelException {
	JSONArray jList = JSONFactoryUtil.createJSONArray();
	try {

		List<SearchFeedback> list = searchFeedbackPersistence.findByRating(ratings);
		
		for (int i = 0; i < list.size(); i++) {
			long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
			JSONObject jObj = JSONFactoryUtil.createJSONObject();
			jObj.put("id", Long.valueOf(searchFeedbackID));
			jList.put(jObj);
		}
	} catch (Exception e) {
		System.out.println(e.toString());
		e.printStackTrace();
	}
	return jList;
}

public JSONArray getSearchFeedbackIdByRatingsAndPeriod(int[] ratings, int period)
		throws NoSuchModelException, SystemException {
	JSONArray jList = JSONFactoryUtil.createJSONArray();
	try {
		List<SearchFeedback> list = new ArrayList<SearchFeedback>();
		if (period == 0)
			list = searchFeedbackPersistence.findByRating(ratings);
		else {
			Date startDate = Util.getStartDateFromPeriod(period);
			list = searchFeedbackPersistence.findByRatingSince(ratings, startDate);
		}

		for (int i = 0; i < list.size(); i++) {
			long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
			JSONObject jObj = JSONFactoryUtil.createJSONObject();
			jObj.put("id", Long.valueOf(searchFeedbackID));
			jList.put(jObj);
		}
	} catch (Exception e) {
		System.out.println(e.toString());
		e.printStackTrace();
	}

	return jList;
}
	public JSONArray getSearchFeedbackIdByQueryString(String queryString) throws SystemException, NoSuchModelException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {

			List<SearchFeedback> list = searchFeedbackPersistence.findByQueryMessage(queryString);
			
			for (int i = 0; i < list.size(); i++) {
				long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchFeedbackID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jList;
	}
	
	public JSONArray getSearchFeedbackIdByQueryStringAndPeriod(String queryString, int period)
			throws NoSuchModelException, SystemException {
		JSONArray jList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchFeedback> list = new ArrayList<SearchFeedback>();
			if (period == 0)
				list = searchFeedbackPersistence.findByQueryMessage(queryString);
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchFeedbackPersistence.findByQueryMessageSince(queryString,startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchFeedbackID));
				jList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jList;
	}
	
	public JSONArray getSearchFeedbackIdByPeriod(int period) throws NoSuchModelException, SystemException {
		JSONArray jIdList = JSONFactoryUtil.createJSONArray();
		try {
			List<SearchFeedback> list = new ArrayList<SearchFeedback>();
			if (period == 0)
				list = searchFeedbackPersistence.findAll();
			else {
				Date startDate = Util.getStartDateFromPeriod(period);
				list = searchFeedbackPersistence.findBySince(startDate);
			}

			for (int i = 0; i < list.size(); i++) {
				long searchFeedbackID = ((SearchFeedback) list.get(i)).getSearchFeedbackID();
				JSONObject jObj = JSONFactoryUtil.createJSONObject();
				jObj.put("id", Long.valueOf(searchFeedbackID));
				jIdList.put(jObj);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return jIdList;
	}
	
	public long updateSearchFeedback(long searchFeedbackId, long userId, 
			String queryString, String queryFilter, 
			String datasetDetail, long datasetRank, int rating)
			throws SystemException {

		SearchFeedback record = null;
		try {

			record = searchFeedbackPersistence.findByPrimaryKey(searchFeedbackId);
			long ownerId = record.getUserID();
			long currentUser = Util.getLoggedInUserId();
			if (Util.isUserAdmin(currentUser) || ownerId == currentUser) {
				record.setUserID(userId);
				record.setQueryString(queryString);
				record.setQueryFilter(queryFilter);
				record.setDatasetDetail(datasetDetail);
				record.setDatasetRank(datasetRank);
				record.setRating(rating);
				Date now = new java.util.Date();
				record.setLastModifiedDate(now);
				super.updateSearchFeedback(record);
			} else {
				System.out.println("This user has no rights. Operation aborted.");
			}

		} catch (NoSuchSearchFeedbackException e) {
			record = searchFeedbackPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			record.setUserID(userId);
			record.setQueryString(queryString);
			record.setQueryFilter(queryFilter);
			Date now = new java.util.Date();
			record.setLastModifiedDate(now);
			super.updateSearchFeedback(record);
			e.printStackTrace();
		}

		return record.getSearchFeedbackID();
	}

	public SearchFeedback removeSearchFeedback(long searchFeedbackId) throws SystemException, NoSuchModelException {
		SearchFeedback record = null;
		try {
			record = searchFeedbackPersistence.findByPrimaryKey(searchFeedbackId);
			long ownerId = record.getUserID();
			long userId = Util.getLoggedInUserId();
			if (Util.isUserAdmin(userId) || ownerId == userId) {
				record = searchFeedbackPersistence.remove(searchFeedbackId);
			} else {
				System.out.println("This user has no rights. Operation aborted.");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

		return record;
	}
	
	private JSONObject convertRecordToJSONObject(SearchFeedback record) {
		JSONObject jObj = JSONFactoryUtil.createJSONObject();
		try {
			if (record != null) {
				jObj.put("searchHistoryID", Long.valueOf(record.getSearchFeedbackID()));
				jObj.put("userID", Long.valueOf(record.getUserID()));
				jObj.put("queryString", record.getQueryString());
				jObj.put("queryFilter", record.getQueryFilter());
				jObj.put("datasetDetail", record.getDatasetDetail());
				jObj.put("datasetRank", record.getDatasetRank());
				jObj.put("rating", record.getRating());
				jObj.put("lastModifiedDate", record.getLastModifiedDate());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return jObj;
	}

	private JSONArray convertListToJSONArray(List<SearchFeedback> list) {
		JSONArray jArr = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < list.size(); i++) {
			SearchFeedback item = list.get(i);
			JSONObject jObj = convertRecordToJSONObject(item);
			jArr.put(jObj);
		}
		return jArr;
	}
}