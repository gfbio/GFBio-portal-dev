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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.SearchFeedback;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SearchFeedback in entity cache.
 *
 * @author Kobkaew Opasjumruskit
 * @see SearchFeedback
 * @generated
 */
public class SearchFeedbackCacheModel implements CacheModel<SearchFeedback>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{searchFeedbackID=");
		sb.append(searchFeedbackID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", queryString=");
		sb.append(queryString);
		sb.append(", queryFilter=");
		sb.append(queryFilter);
		sb.append(", datasetDetail=");
		sb.append(datasetDetail);
		sb.append(", datasetRank=");
		sb.append(datasetRank);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SearchFeedback toEntityModel() {
		SearchFeedbackImpl searchFeedbackImpl = new SearchFeedbackImpl();

		searchFeedbackImpl.setSearchFeedbackID(searchFeedbackID);
		searchFeedbackImpl.setUserID(userID);

		if (queryString == null) {
			searchFeedbackImpl.setQueryString(StringPool.BLANK);
		}
		else {
			searchFeedbackImpl.setQueryString(queryString);
		}

		if (queryFilter == null) {
			searchFeedbackImpl.setQueryFilter(StringPool.BLANK);
		}
		else {
			searchFeedbackImpl.setQueryFilter(queryFilter);
		}

		if (datasetDetail == null) {
			searchFeedbackImpl.setDatasetDetail(StringPool.BLANK);
		}
		else {
			searchFeedbackImpl.setDatasetDetail(datasetDetail);
		}

		searchFeedbackImpl.setDatasetRank(datasetRank);
		searchFeedbackImpl.setRating(rating);

		if (lastModifiedDate == Long.MIN_VALUE) {
			searchFeedbackImpl.setLastModifiedDate(null);
		}
		else {
			searchFeedbackImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		searchFeedbackImpl.resetOriginalValues();

		return searchFeedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		searchFeedbackID = objectInput.readLong();
		userID = objectInput.readLong();
		queryString = objectInput.readUTF();
		queryFilter = objectInput.readUTF();
		datasetDetail = objectInput.readUTF();
		datasetRank = objectInput.readLong();
		rating = objectInput.readInt();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(searchFeedbackID);
		objectOutput.writeLong(userID);

		if (queryString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(queryString);
		}

		if (queryFilter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(queryFilter);
		}

		if (datasetDetail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(datasetDetail);
		}

		objectOutput.writeLong(datasetRank);
		objectOutput.writeInt(rating);
		objectOutput.writeLong(lastModifiedDate);
	}

	public long searchFeedbackID;
	public long userID;
	public String queryString;
	public String queryFilter;
	public String datasetDetail;
	public long datasetRank;
	public int rating;
	public long lastModifiedDate;
}