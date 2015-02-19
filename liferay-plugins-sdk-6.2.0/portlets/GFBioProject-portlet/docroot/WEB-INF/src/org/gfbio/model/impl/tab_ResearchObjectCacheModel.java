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

package org.gfbio.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.gfbio.model.tab_ResearchObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing tab_ResearchObject in entity cache.
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObject
 * @generated
 */
public class tab_ResearchObjectCacheModel implements CacheModel<tab_ResearchObject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ro_ID=");
		sb.append(ro_ID);
		sb.append(", ro_name=");
		sb.append(ro_name);
		sb.append(", ro_meta=");
		sb.append(ro_meta);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public tab_ResearchObject toEntityModel() {
		tab_ResearchObjectImpl tab_ResearchObjectImpl = new tab_ResearchObjectImpl();

		tab_ResearchObjectImpl.setRo_ID(ro_ID);

		if (ro_name == null) {
			tab_ResearchObjectImpl.setRo_name(StringPool.BLANK);
		}
		else {
			tab_ResearchObjectImpl.setRo_name(ro_name);
		}

		if (ro_meta == null) {
			tab_ResearchObjectImpl.setRo_meta(StringPool.BLANK);
		}
		else {
			tab_ResearchObjectImpl.setRo_meta(ro_meta);
		}

		tab_ResearchObjectImpl.resetOriginalValues();

		return tab_ResearchObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ro_ID = objectInput.readLong();
		ro_name = objectInput.readUTF();
		ro_meta = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ro_ID);

		if (ro_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ro_name);
		}

		if (ro_meta == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ro_meta);
		}
	}

	public long ro_ID;
	public String ro_name;
	public String ro_meta;
}