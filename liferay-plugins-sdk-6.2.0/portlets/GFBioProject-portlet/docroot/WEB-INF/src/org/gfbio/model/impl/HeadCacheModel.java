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

import org.gfbio.model.Head;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Head in entity cache.
 *
 * @author Felicitas Loeffler
 * @see Head
 * @generated
 */
public class HeadCacheModel implements CacheModel<Head>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{headID=");
		sb.append(headID);
		sb.append(", name=");
		sb.append(name);
		sb.append(", column01=");
		sb.append(column01);
		sb.append(", column02=");
		sb.append(column02);
		sb.append(", column03=");
		sb.append(column03);
		sb.append(", column04=");
		sb.append(column04);
		sb.append(", column05=");
		sb.append(column05);
		sb.append(", column06=");
		sb.append(column06);
		sb.append(", column07=");
		sb.append(column07);
		sb.append(", column08=");
		sb.append(column08);
		sb.append(", column09=");
		sb.append(column09);
		sb.append(", column10=");
		sb.append(column10);
		sb.append(", column11=");
		sb.append(column11);
		sb.append(", column12=");
		sb.append(column12);
		sb.append(", column13=");
		sb.append(column13);
		sb.append(", column14=");
		sb.append(column14);
		sb.append(", column15=");
		sb.append(column15);
		sb.append(", column16=");
		sb.append(column16);
		sb.append(", column17=");
		sb.append(column17);
		sb.append(", column18=");
		sb.append(column18);
		sb.append(", column19=");
		sb.append(column19);
		sb.append(", column20=");
		sb.append(column20);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Head toEntityModel() {
		HeadImpl headImpl = new HeadImpl();

		headImpl.setHeadID(headID);

		if (name == null) {
			headImpl.setName(StringPool.BLANK);
		}
		else {
			headImpl.setName(name);
		}

		if (column01 == null) {
			headImpl.setColumn01(StringPool.BLANK);
		}
		else {
			headImpl.setColumn01(column01);
		}

		if (column02 == null) {
			headImpl.setColumn02(StringPool.BLANK);
		}
		else {
			headImpl.setColumn02(column02);
		}

		if (column03 == null) {
			headImpl.setColumn03(StringPool.BLANK);
		}
		else {
			headImpl.setColumn03(column03);
		}

		if (column04 == null) {
			headImpl.setColumn04(StringPool.BLANK);
		}
		else {
			headImpl.setColumn04(column04);
		}

		if (column05 == null) {
			headImpl.setColumn05(StringPool.BLANK);
		}
		else {
			headImpl.setColumn05(column05);
		}

		if (column06 == null) {
			headImpl.setColumn06(StringPool.BLANK);
		}
		else {
			headImpl.setColumn06(column06);
		}

		if (column07 == null) {
			headImpl.setColumn07(StringPool.BLANK);
		}
		else {
			headImpl.setColumn07(column07);
		}

		if (column08 == null) {
			headImpl.setColumn08(StringPool.BLANK);
		}
		else {
			headImpl.setColumn08(column08);
		}

		if (column09 == null) {
			headImpl.setColumn09(StringPool.BLANK);
		}
		else {
			headImpl.setColumn09(column09);
		}

		if (column10 == null) {
			headImpl.setColumn10(StringPool.BLANK);
		}
		else {
			headImpl.setColumn10(column10);
		}

		if (column11 == null) {
			headImpl.setColumn11(StringPool.BLANK);
		}
		else {
			headImpl.setColumn11(column11);
		}

		if (column12 == null) {
			headImpl.setColumn12(StringPool.BLANK);
		}
		else {
			headImpl.setColumn12(column12);
		}

		if (column13 == null) {
			headImpl.setColumn13(StringPool.BLANK);
		}
		else {
			headImpl.setColumn13(column13);
		}

		if (column14 == null) {
			headImpl.setColumn14(StringPool.BLANK);
		}
		else {
			headImpl.setColumn14(column14);
		}

		if (column15 == null) {
			headImpl.setColumn15(StringPool.BLANK);
		}
		else {
			headImpl.setColumn15(column15);
		}

		if (column16 == null) {
			headImpl.setColumn16(StringPool.BLANK);
		}
		else {
			headImpl.setColumn16(column16);
		}

		if (column17 == null) {
			headImpl.setColumn17(StringPool.BLANK);
		}
		else {
			headImpl.setColumn17(column17);
		}

		if (column18 == null) {
			headImpl.setColumn18(StringPool.BLANK);
		}
		else {
			headImpl.setColumn18(column18);
		}

		if (column19 == null) {
			headImpl.setColumn19(StringPool.BLANK);
		}
		else {
			headImpl.setColumn19(column19);
		}

		if (column20 == null) {
			headImpl.setColumn20(StringPool.BLANK);
		}
		else {
			headImpl.setColumn20(column20);
		}

		headImpl.resetOriginalValues();

		return headImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		headID = objectInput.readLong();
		name = objectInput.readUTF();
		column01 = objectInput.readUTF();
		column02 = objectInput.readUTF();
		column03 = objectInput.readUTF();
		column04 = objectInput.readUTF();
		column05 = objectInput.readUTF();
		column06 = objectInput.readUTF();
		column07 = objectInput.readUTF();
		column08 = objectInput.readUTF();
		column09 = objectInput.readUTF();
		column10 = objectInput.readUTF();
		column11 = objectInput.readUTF();
		column12 = objectInput.readUTF();
		column13 = objectInput.readUTF();
		column14 = objectInput.readUTF();
		column15 = objectInput.readUTF();
		column16 = objectInput.readUTF();
		column17 = objectInput.readUTF();
		column18 = objectInput.readUTF();
		column19 = objectInput.readUTF();
		column20 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(headID);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (column01 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column01);
		}

		if (column02 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column02);
		}

		if (column03 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column03);
		}

		if (column04 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column04);
		}

		if (column05 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column05);
		}

		if (column06 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column06);
		}

		if (column07 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column07);
		}

		if (column08 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column08);
		}

		if (column09 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column09);
		}

		if (column10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column10);
		}

		if (column11 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column11);
		}

		if (column12 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column12);
		}

		if (column13 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column13);
		}

		if (column14 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column14);
		}

		if (column15 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column15);
		}

		if (column16 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column16);
		}

		if (column17 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column17);
		}

		if (column18 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column18);
		}

		if (column19 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column19);
		}

		if (column20 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(column20);
		}
	}

	public long headID;
	public String name;
	public String column01;
	public String column02;
	public String column03;
	public String column04;
	public String column05;
	public String column06;
	public String column07;
	public String column08;
	public String column09;
	public String column10;
	public String column11;
	public String column12;
	public String column13;
	public String column14;
	public String column15;
	public String column16;
	public String column17;
	public String column18;
	public String column19;
	public String column20;
}