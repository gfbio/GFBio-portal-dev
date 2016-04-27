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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Marcel Froemming
 */
public class DataProvider_PersistentIdentifierPK implements Comparable<DataProvider_PersistentIdentifierPK>,
	Serializable {
	public long gfbioDataProvider;
	public long gfbioPersistentIdentifier;

	public DataProvider_PersistentIdentifierPK() {
	}

	public DataProvider_PersistentIdentifierPK(long gfbioDataProvider,
		long gfbioPersistentIdentifier) {
		this.gfbioDataProvider = gfbioDataProvider;
		this.gfbioPersistentIdentifier = gfbioPersistentIdentifier;
	}

	public long getGfbioDataProvider() {
		return gfbioDataProvider;
	}

	public void setGfbioDataProvider(long gfbioDataProvider) {
		this.gfbioDataProvider = gfbioDataProvider;
	}

	public long getGfbioPersistentIdentifier() {
		return gfbioPersistentIdentifier;
	}

	public void setGfbioPersistentIdentifier(long gfbioPersistentIdentifier) {
		this.gfbioPersistentIdentifier = gfbioPersistentIdentifier;
	}

	@Override
	public int compareTo(DataProvider_PersistentIdentifierPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (gfbioDataProvider < pk.gfbioDataProvider) {
			value = -1;
		}
		else if (gfbioDataProvider > pk.gfbioDataProvider) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (gfbioPersistentIdentifier < pk.gfbioPersistentIdentifier) {
			value = -1;
		}
		else if (gfbioPersistentIdentifier > pk.gfbioPersistentIdentifier) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DataProvider_PersistentIdentifierPK)) {
			return false;
		}

		DataProvider_PersistentIdentifierPK pk = (DataProvider_PersistentIdentifierPK)obj;

		if ((gfbioDataProvider == pk.gfbioDataProvider) &&
				(gfbioPersistentIdentifier == pk.gfbioPersistentIdentifier)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(gfbioDataProvider) +
		String.valueOf(gfbioPersistentIdentifier)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("gfbioDataProvider");
		sb.append(StringPool.EQUAL);
		sb.append(gfbioDataProvider);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("gfbioPersistentIdentifier");
		sb.append(StringPool.EQUAL);
		sb.append(gfbioPersistentIdentifier);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}