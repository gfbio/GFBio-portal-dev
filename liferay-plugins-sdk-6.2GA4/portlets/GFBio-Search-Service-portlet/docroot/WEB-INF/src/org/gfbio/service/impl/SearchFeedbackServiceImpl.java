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

import org.gfbio.model.SearchFeedback;
import org.gfbio.service.SearchFeedbackLocalServiceUtil;
import org.gfbio.service.base.SearchFeedbackServiceBaseImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;

/**
 * The implementation of the search feedback remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gfbio.service.SearchFeedbackService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see org.gfbio.service.base.SearchFeedbackServiceBaseImpl
 * @see org.gfbio.service.SearchFeedbackServiceUtil
 */
public class SearchFeedbackServiceImpl extends SearchFeedbackServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * org.gfbio.service.SearchFeedbackServiceUtil} to access the search
	 * feedback remote service.
	 */
	public JSONArray getSearchFeedbackById(long searchFeedbackId) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackById(searchFeedbackId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackByIds(long[] searchFeedbackIDs) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackByIds(searchFeedbackIDs);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIDByUserId(long userId) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByUserId(userId);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIdByUserAndPeriod(long userId, int period) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByUserAndPeriod(userId,period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIdByRating(int[] ratings) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByRating(ratings);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIdByRatingsAndPeriod(int[] ratings, int period) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByRatingsAndPeriod(ratings,period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}


	public JSONArray getSearchFeedbackIdByQueryString(String queryString) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByQueryString(queryString);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIdByQueryStringAndPeriod(String queryString, int period) throws SystemException {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByQueryStringAndPeriod(queryString,period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JSONArray getSearchFeedbackIdByPeriod(int period) throws SystemException  {
		try {
			return SearchFeedbackLocalServiceUtil.getSearchFeedbackIdByPeriod(period);
		} catch (NoSuchModelException e) {
			e.printStackTrace();
		}

		return null;
	}

	public long updateSearchFeedback(long searchFeedbackId, long userId, String queryString, String queryFilter,
			String datasetDetail, long datasetRank, int rating) throws NoSuchModelException, SystemException {
		return SearchFeedbackLocalServiceUtil.updateSearchFeedback(searchFeedbackId, userId, queryString, queryFilter,
				datasetDetail, datasetRank, rating);
	}

	public SearchFeedback removeSearchFeedback(long searchFeedbackId) throws NoSuchModelException, SystemException {
		return SearchFeedbackLocalServiceUtil.removeSearchFeedback(searchFeedbackId);
	}
}