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
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.DataProvider_PersistentIdentifier;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataProvider_PersistentIdentifier in entity cache.
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifier
 * @generated
 */
public class DataProvider_PersistentIdentifierCacheModel implements CacheModel<DataProvider_PersistentIdentifier>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{gfbioDataProvider=");
		sb.append(gfbioDataProvider);
		sb.append(", gfbioPersistentIdentifier=");
		sb.append(gfbioPersistentIdentifier);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataProvider_PersistentIdentifier toEntityModel() {
		DataProvider_PersistentIdentifierImpl dataProvider_PersistentIdentifierImpl =
			new DataProvider_PersistentIdentifierImpl();

		dataProvider_PersistentIdentifierImpl.setGfbioDataProvider(gfbioDataProvider);
		dataProvider_PersistentIdentifierImpl.setGfbioPersistentIdentifier(gfbioPersistentIdentifier);

		dataProvider_PersistentIdentifierImpl.resetOriginalValues();

		return dataProvider_PersistentIdentifierImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gfbioDataProvider = objectInput.readLong();
		gfbioPersistentIdentifier = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(gfbioDataProvider);
		objectOutput.writeLong(gfbioPersistentIdentifier);
	}

	public long gfbioDataProvider;
	public long gfbioPersistentIdentifier;
}