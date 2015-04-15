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

package org.gfbio.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.gfbio.service.http.HeadServiceSoap}.
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.http.HeadServiceSoap
 * @generated
 */
public class HeadSoap implements Serializable {
	public static HeadSoap toSoapModel(Head model) {
		HeadSoap soapModel = new HeadSoap();

		soapModel.setHeadID(model.getHeadID());
		soapModel.setName(model.getName());
		soapModel.setColumn01(model.getColumn01());
		soapModel.setColumn02(model.getColumn02());
		soapModel.setColumn03(model.getColumn03());
		soapModel.setColumn04(model.getColumn04());
		soapModel.setColumn05(model.getColumn05());
		soapModel.setColumn06(model.getColumn06());
		soapModel.setColumn07(model.getColumn07());
		soapModel.setColumn08(model.getColumn08());
		soapModel.setColumn09(model.getColumn09());
		soapModel.setColumn10(model.getColumn10());
		soapModel.setColumn11(model.getColumn11());
		soapModel.setColumn12(model.getColumn12());
		soapModel.setColumn13(model.getColumn13());
		soapModel.setColumn14(model.getColumn14());
		soapModel.setColumn15(model.getColumn15());
		soapModel.setColumn16(model.getColumn16());
		soapModel.setColumn17(model.getColumn17());
		soapModel.setColumn18(model.getColumn18());
		soapModel.setColumn19(model.getColumn19());
		soapModel.setColumn20(model.getColumn20());

		return soapModel;
	}

	public static HeadSoap[] toSoapModels(Head[] models) {
		HeadSoap[] soapModels = new HeadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeadSoap[][] toSoapModels(Head[][] models) {
		HeadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeadSoap[] toSoapModels(List<Head> models) {
		List<HeadSoap> soapModels = new ArrayList<HeadSoap>(models.size());

		for (Head model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeadSoap[soapModels.size()]);
	}

	public HeadSoap() {
	}

	public long getPrimaryKey() {
		return _headID;
	}

	public void setPrimaryKey(long pk) {
		setHeadID(pk);
	}

	public long getHeadID() {
		return _headID;
	}

	public void setHeadID(long headID) {
		_headID = headID;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getColumn01() {
		return _column01;
	}

	public void setColumn01(String column01) {
		_column01 = column01;
	}

	public String getColumn02() {
		return _column02;
	}

	public void setColumn02(String column02) {
		_column02 = column02;
	}

	public String getColumn03() {
		return _column03;
	}

	public void setColumn03(String column03) {
		_column03 = column03;
	}

	public String getColumn04() {
		return _column04;
	}

	public void setColumn04(String column04) {
		_column04 = column04;
	}

	public String getColumn05() {
		return _column05;
	}

	public void setColumn05(String column05) {
		_column05 = column05;
	}

	public String getColumn06() {
		return _column06;
	}

	public void setColumn06(String column06) {
		_column06 = column06;
	}

	public String getColumn07() {
		return _column07;
	}

	public void setColumn07(String column07) {
		_column07 = column07;
	}

	public String getColumn08() {
		return _column08;
	}

	public void setColumn08(String column08) {
		_column08 = column08;
	}

	public String getColumn09() {
		return _column09;
	}

	public void setColumn09(String column09) {
		_column09 = column09;
	}

	public String getColumn10() {
		return _column10;
	}

	public void setColumn10(String column10) {
		_column10 = column10;
	}

	public String getColumn11() {
		return _column11;
	}

	public void setColumn11(String column11) {
		_column11 = column11;
	}

	public String getColumn12() {
		return _column12;
	}

	public void setColumn12(String column12) {
		_column12 = column12;
	}

	public String getColumn13() {
		return _column13;
	}

	public void setColumn13(String column13) {
		_column13 = column13;
	}

	public String getColumn14() {
		return _column14;
	}

	public void setColumn14(String column14) {
		_column14 = column14;
	}

	public String getColumn15() {
		return _column15;
	}

	public void setColumn15(String column15) {
		_column15 = column15;
	}

	public String getColumn16() {
		return _column16;
	}

	public void setColumn16(String column16) {
		_column16 = column16;
	}

	public String getColumn17() {
		return _column17;
	}

	public void setColumn17(String column17) {
		_column17 = column17;
	}

	public String getColumn18() {
		return _column18;
	}

	public void setColumn18(String column18) {
		_column18 = column18;
	}

	public String getColumn19() {
		return _column19;
	}

	public void setColumn19(String column19) {
		_column19 = column19;
	}

	public String getColumn20() {
		return _column20;
	}

	public void setColumn20(String column20) {
		_column20 = column20;
	}

	private long _headID;
	private String _name;
	private String _column01;
	private String _column02;
	private String _column03;
	private String _column04;
	private String _column05;
	private String _column06;
	private String _column07;
	private String _column08;
	private String _column09;
	private String _column10;
	private String _column11;
	private String _column12;
	private String _column13;
	private String _column14;
	private String _column15;
	private String _column16;
	private String _column17;
	private String _column18;
	private String _column19;
	private String _column20;
}