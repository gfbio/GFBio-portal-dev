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

import org.gfbio.model.SearchHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SearchHistory in entity cache.
 *
 * @author Marcel Froemming
 * @see SearchHistory
 * @generated
 */
public class SearchHistoryCacheModel implements CacheModel<SearchHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{searchHistoryID=");
		sb.append(searchHistoryID);
		sb.append(", userID=");
		sb.append(userID);
		sb.append(", queryString=");
		sb.append(queryString);
		sb.append(", lastModifiedDate=");
		sb.append(lastModifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SearchHistory toEntityModel() {
		SearchHistoryImpl searchHistoryImpl = new SearchHistoryImpl();

		searchHistoryImpl.setSearchHistoryID(searchHistoryID);
		searchHistoryImpl.setUserID(userID);

		if (queryString == null) {
			searchHistoryImpl.setQueryString(StringPool.BLANK);
		}
		else {
			searchHistoryImpl.setQueryString(queryString);
		}

		if (lastModifiedDate == Long.MIN_VALUE) {
			searchHistoryImpl.setLastModifiedDate(null);
		}
		else {
			searchHistoryImpl.setLastModifiedDate(new Date(lastModifiedDate));
		}

		searchHistoryImpl.resetOriginalValues();

		return searchHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		searchHistoryID = objectInput.readLong();
		userID = objectInput.readLong();
		queryString = objectInput.readUTF();
		lastModifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(searchHistoryID);
		objectOutput.writeLong(userID);

		if (queryString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(queryString);
		}

		objectOutput.writeLong(lastModifiedDate);
	}

	public long searchHistoryID;
	public long userID;
	public String queryString;
	public long lastModifiedDate;
}