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

import org.gfbio.model.SearchHistory;
import org.gfbio.service.SearchHistoryLocalServiceUtil;
import org.gfbio.service.base.SearchHistoryServiceBaseImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;

/**
 * The implementation of the search history remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.SearchHistoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see org.gfbio.service.base.SearchHistoryServiceBaseImpl
 * @see org.gfbio.service.SearchHistoryServiceUtil
 */
public class SearchHistoryServiceImpl extends SearchHistoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * org.gfbio.service.SearchHistoryServiceUtil} to access the search history
	 * remote service.
	 */
	public JSONArray getSearchHistoryById(long searchHistoryId) throws SystemException {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryById(searchHistoryId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public JSONArray getSearchHistoryByIds(long[] searchHistoryIDs) throws SystemException {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryByIds(searchHistoryIDs);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchHistoryIdByUserId(long userId) throws SystemException {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryIdByUserId(userId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchHistoryIdByUserAndPeriod(long userId, int period) throws SystemException {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryIdByUserAndPeriod(userId, period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public JSONArray getSearchHistoryIdByQueryString(String queryString) throws SystemException  {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryIdByQueryString(queryString);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public JSONArray getSearchHistoryIdByQueryStringAndPeriod(String queryString, int period) throws SystemException  {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryIdByQueryStringAndPeriod(queryString,period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public JSONArray getSearchHistoryIdByPeriod(int period) throws SystemException  {
		try {
			return SearchHistoryLocalServiceUtil.getSearchHistoryIdByPeriod(period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}
	public long updateSearchHistory(long searchHistoryId, long userId, String queryString, String queryFilter)
			throws NoSuchModelException, SystemException {
		return SearchHistoryLocalServiceUtil.updateSearchHistory(searchHistoryId, userId, queryString, queryFilter);
	}

	public SearchHistory removeSearchHistory(long searchHistoryId) throws NoSuchModelException, SystemException {
		return SearchHistoryLocalServiceUtil.removeSearchHistory(searchHistoryId);
	}
}