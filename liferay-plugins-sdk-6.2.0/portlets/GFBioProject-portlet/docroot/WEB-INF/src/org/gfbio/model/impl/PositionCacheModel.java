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

import org.gfbio.model.Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Position in entity cache.
 *
 * @author Felicitas Loeffler
 * @see Position
 * @generated
 */
public class PositionCacheModel implements CacheModel<Position>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{positionID=");
		sb.append(positionID);
		sb.append(", headID=");
		sb.append(headID);
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
	public Position toEntityModel() {
		PositionImpl positionImpl = new PositionImpl();

		positionImpl.setPositionID(positionID);
		positionImpl.setHeadID(headID);

		if (column01 == null) {
			positionImpl.setColumn01(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn01(column01);
		}

		if (column02 == null) {
			positionImpl.setColumn02(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn02(column02);
		}

		if (column03 == null) {
			positionImpl.setColumn03(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn03(column03);
		}

		if (column04 == null) {
			positionImpl.setColumn04(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn04(column04);
		}

		if (column05 == null) {
			positionImpl.setColumn05(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn05(column05);
		}

		if (column06 == null) {
			positionImpl.setColumn06(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn06(column06);
		}

		if (column07 == null) {
			positionImpl.setColumn07(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn07(column07);
		}

		if (column08 == null) {
			positionImpl.setColumn08(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn08(column08);
		}

		if (column09 == null) {
			positionImpl.setColumn09(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn09(column09);
		}

		if (column10 == null) {
			positionImpl.setColumn10(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn10(column10);
		}

		if (column11 == null) {
			positionImpl.setColumn11(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn11(column11);
		}

		if (column12 == null) {
			positionImpl.setColumn12(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn12(column12);
		}

		if (column13 == null) {
			positionImpl.setColumn13(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn13(column13);
		}

		if (column14 == null) {
			positionImpl.setColumn14(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn14(column14);
		}

		if (column15 == null) {
			positionImpl.setColumn15(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn15(column15);
		}

		if (column16 == null) {
			positionImpl.setColumn16(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn16(column16);
		}

		if (column17 == null) {
			positionImpl.setColumn17(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn17(column17);
		}

		if (column18 == null) {
			positionImpl.setColumn18(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn18(column18);
		}

		if (column19 == null) {
			positionImpl.setColumn19(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn19(column19);
		}

		if (column20 == null) {
			positionImpl.setColumn20(StringPool.BLANK);
		}
		else {
			positionImpl.setColumn20(column20);
		}

		positionImpl.resetOriginalValues();

		return positionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		positionID = objectInput.readLong();
		headID = objectInput.readLong();
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
		objectOutput.writeLong(positionID);
		objectOutput.writeLong(headID);

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

	public long positionID;
	public long headID;
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