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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Position}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Position
 * @generated
 */
public class PositionWrapper implements Position, ModelWrapper<Position> {
	public PositionWrapper(Position position) {
		_position = position;
	}

	@Override
	public Class<?> getModelClass() {
		return Position.class;
	}

	@Override
	public String getModelClassName() {
		return Position.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("positionID", getPositionID());
		attributes.put("headID", getHeadID());
		attributes.put("column01", getColumn01());
		attributes.put("column02", getColumn02());
		attributes.put("column03", getColumn03());
		attributes.put("column04", getColumn04());
		attributes.put("column05", getColumn05());
		attributes.put("column06", getColumn06());
		attributes.put("column07", getColumn07());
		attributes.put("column08", getColumn08());
		attributes.put("column09", getColumn09());
		attributes.put("column10", getColumn10());
		attributes.put("column11", getColumn11());
		attributes.put("column12", getColumn12());
		attributes.put("column13", getColumn13());
		attributes.put("column14", getColumn14());
		attributes.put("column15", getColumn15());
		attributes.put("column16", getColumn16());
		attributes.put("column17", getColumn17());
		attributes.put("column18", getColumn18());
		attributes.put("column19", getColumn19());
		attributes.put("column20", getColumn20());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long positionID = (Long)attributes.get("positionID");

		if (positionID != null) {
			setPositionID(positionID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String column01 = (String)attributes.get("column01");

		if (column01 != null) {
			setColumn01(column01);
		}

		String column02 = (String)attributes.get("column02");

		if (column02 != null) {
			setColumn02(column02);
		}

		String column03 = (String)attributes.get("column03");

		if (column03 != null) {
			setColumn03(column03);
		}

		String column04 = (String)attributes.get("column04");

		if (column04 != null) {
			setColumn04(column04);
		}

		String column05 = (String)attributes.get("column05");

		if (column05 != null) {
			setColumn05(column05);
		}

		String column06 = (String)attributes.get("column06");

		if (column06 != null) {
			setColumn06(column06);
		}

		String column07 = (String)attributes.get("column07");

		if (column07 != null) {
			setColumn07(column07);
		}

		String column08 = (String)attributes.get("column08");

		if (column08 != null) {
			setColumn08(column08);
		}

		String column09 = (String)attributes.get("column09");

		if (column09 != null) {
			setColumn09(column09);
		}

		String column10 = (String)attributes.get("column10");

		if (column10 != null) {
			setColumn10(column10);
		}

		String column11 = (String)attributes.get("column11");

		if (column11 != null) {
			setColumn11(column11);
		}

		String column12 = (String)attributes.get("column12");

		if (column12 != null) {
			setColumn12(column12);
		}

		String column13 = (String)attributes.get("column13");

		if (column13 != null) {
			setColumn13(column13);
		}

		String column14 = (String)attributes.get("column14");

		if (column14 != null) {
			setColumn14(column14);
		}

		String column15 = (String)attributes.get("column15");

		if (column15 != null) {
			setColumn15(column15);
		}

		String column16 = (String)attributes.get("column16");

		if (column16 != null) {
			setColumn16(column16);
		}

		String column17 = (String)attributes.get("column17");

		if (column17 != null) {
			setColumn17(column17);
		}

		String column18 = (String)attributes.get("column18");

		if (column18 != null) {
			setColumn18(column18);
		}

		String column19 = (String)attributes.get("column19");

		if (column19 != null) {
			setColumn19(column19);
		}

		String column20 = (String)attributes.get("column20");

		if (column20 != null) {
			setColumn20(column20);
		}
	}

	/**
	* Returns the primary key of this position.
	*
	* @return the primary key of this position
	*/
	@Override
	public long getPrimaryKey() {
		return _position.getPrimaryKey();
	}

	/**
	* Sets the primary key of this position.
	*
	* @param primaryKey the primary key of this position
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_position.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the position i d of this position.
	*
	* @return the position i d of this position
	*/
	@Override
	public long getPositionID() {
		return _position.getPositionID();
	}

	/**
	* Sets the position i d of this position.
	*
	* @param positionID the position i d of this position
	*/
	@Override
	public void setPositionID(long positionID) {
		_position.setPositionID(positionID);
	}

	/**
	* Returns the head i d of this position.
	*
	* @return the head i d of this position
	*/
	@Override
	public long getHeadID() {
		return _position.getHeadID();
	}

	/**
	* Sets the head i d of this position.
	*
	* @param headID the head i d of this position
	*/
	@Override
	public void setHeadID(long headID) {
		_position.setHeadID(headID);
	}

	/**
	* Returns the column01 of this position.
	*
	* @return the column01 of this position
	*/
	@Override
	public java.lang.String getColumn01() {
		return _position.getColumn01();
	}

	/**
	* Sets the column01 of this position.
	*
	* @param column01 the column01 of this position
	*/
	@Override
	public void setColumn01(java.lang.String column01) {
		_position.setColumn01(column01);
	}

	/**
	* Returns the column02 of this position.
	*
	* @return the column02 of this position
	*/
	@Override
	public java.lang.String getColumn02() {
		return _position.getColumn02();
	}

	/**
	* Sets the column02 of this position.
	*
	* @param column02 the column02 of this position
	*/
	@Override
	public void setColumn02(java.lang.String column02) {
		_position.setColumn02(column02);
	}

	/**
	* Returns the column03 of this position.
	*
	* @return the column03 of this position
	*/
	@Override
	public java.lang.String getColumn03() {
		return _position.getColumn03();
	}

	/**
	* Sets the column03 of this position.
	*
	* @param column03 the column03 of this position
	*/
	@Override
	public void setColumn03(java.lang.String column03) {
		_position.setColumn03(column03);
	}

	/**
	* Returns the column04 of this position.
	*
	* @return the column04 of this position
	*/
	@Override
	public java.lang.String getColumn04() {
		return _position.getColumn04();
	}

	/**
	* Sets the column04 of this position.
	*
	* @param column04 the column04 of this position
	*/
	@Override
	public void setColumn04(java.lang.String column04) {
		_position.setColumn04(column04);
	}

	/**
	* Returns the column05 of this position.
	*
	* @return the column05 of this position
	*/
	@Override
	public java.lang.String getColumn05() {
		return _position.getColumn05();
	}

	/**
	* Sets the column05 of this position.
	*
	* @param column05 the column05 of this position
	*/
	@Override
	public void setColumn05(java.lang.String column05) {
		_position.setColumn05(column05);
	}

	/**
	* Returns the column06 of this position.
	*
	* @return the column06 of this position
	*/
	@Override
	public java.lang.String getColumn06() {
		return _position.getColumn06();
	}

	/**
	* Sets the column06 of this position.
	*
	* @param column06 the column06 of this position
	*/
	@Override
	public void setColumn06(java.lang.String column06) {
		_position.setColumn06(column06);
	}

	/**
	* Returns the column07 of this position.
	*
	* @return the column07 of this position
	*/
	@Override
	public java.lang.String getColumn07() {
		return _position.getColumn07();
	}

	/**
	* Sets the column07 of this position.
	*
	* @param column07 the column07 of this position
	*/
	@Override
	public void setColumn07(java.lang.String column07) {
		_position.setColumn07(column07);
	}

	/**
	* Returns the column08 of this position.
	*
	* @return the column08 of this position
	*/
	@Override
	public java.lang.String getColumn08() {
		return _position.getColumn08();
	}

	/**
	* Sets the column08 of this position.
	*
	* @param column08 the column08 of this position
	*/
	@Override
	public void setColumn08(java.lang.String column08) {
		_position.setColumn08(column08);
	}

	/**
	* Returns the column09 of this position.
	*
	* @return the column09 of this position
	*/
	@Override
	public java.lang.String getColumn09() {
		return _position.getColumn09();
	}

	/**
	* Sets the column09 of this position.
	*
	* @param column09 the column09 of this position
	*/
	@Override
	public void setColumn09(java.lang.String column09) {
		_position.setColumn09(column09);
	}

	/**
	* Returns the column10 of this position.
	*
	* @return the column10 of this position
	*/
	@Override
	public java.lang.String getColumn10() {
		return _position.getColumn10();
	}

	/**
	* Sets the column10 of this position.
	*
	* @param column10 the column10 of this position
	*/
	@Override
	public void setColumn10(java.lang.String column10) {
		_position.setColumn10(column10);
	}

	/**
	* Returns the column11 of this position.
	*
	* @return the column11 of this position
	*/
	@Override
	public java.lang.String getColumn11() {
		return _position.getColumn11();
	}

	/**
	* Sets the column11 of this position.
	*
	* @param column11 the column11 of this position
	*/
	@Override
	public void setColumn11(java.lang.String column11) {
		_position.setColumn11(column11);
	}

	/**
	* Returns the column12 of this position.
	*
	* @return the column12 of this position
	*/
	@Override
	public java.lang.String getColumn12() {
		return _position.getColumn12();
	}

	/**
	* Sets the column12 of this position.
	*
	* @param column12 the column12 of this position
	*/
	@Override
	public void setColumn12(java.lang.String column12) {
		_position.setColumn12(column12);
	}

	/**
	* Returns the column13 of this position.
	*
	* @return the column13 of this position
	*/
	@Override
	public java.lang.String getColumn13() {
		return _position.getColumn13();
	}

	/**
	* Sets the column13 of this position.
	*
	* @param column13 the column13 of this position
	*/
	@Override
	public void setColumn13(java.lang.String column13) {
		_position.setColumn13(column13);
	}

	/**
	* Returns the column14 of this position.
	*
	* @return the column14 of this position
	*/
	@Override
	public java.lang.String getColumn14() {
		return _position.getColumn14();
	}

	/**
	* Sets the column14 of this position.
	*
	* @param column14 the column14 of this position
	*/
	@Override
	public void setColumn14(java.lang.String column14) {
		_position.setColumn14(column14);
	}

	/**
	* Returns the column15 of this position.
	*
	* @return the column15 of this position
	*/
	@Override
	public java.lang.String getColumn15() {
		return _position.getColumn15();
	}

	/**
	* Sets the column15 of this position.
	*
	* @param column15 the column15 of this position
	*/
	@Override
	public void setColumn15(java.lang.String column15) {
		_position.setColumn15(column15);
	}

	/**
	* Returns the column16 of this position.
	*
	* @return the column16 of this position
	*/
	@Override
	public java.lang.String getColumn16() {
		return _position.getColumn16();
	}

	/**
	* Sets the column16 of this position.
	*
	* @param column16 the column16 of this position
	*/
	@Override
	public void setColumn16(java.lang.String column16) {
		_position.setColumn16(column16);
	}

	/**
	* Returns the column17 of this position.
	*
	* @return the column17 of this position
	*/
	@Override
	public java.lang.String getColumn17() {
		return _position.getColumn17();
	}

	/**
	* Sets the column17 of this position.
	*
	* @param column17 the column17 of this position
	*/
	@Override
	public void setColumn17(java.lang.String column17) {
		_position.setColumn17(column17);
	}

	/**
	* Returns the column18 of this position.
	*
	* @return the column18 of this position
	*/
	@Override
	public java.lang.String getColumn18() {
		return _position.getColumn18();
	}

	/**
	* Sets the column18 of this position.
	*
	* @param column18 the column18 of this position
	*/
	@Override
	public void setColumn18(java.lang.String column18) {
		_position.setColumn18(column18);
	}

	/**
	* Returns the column19 of this position.
	*
	* @return the column19 of this position
	*/
	@Override
	public java.lang.String getColumn19() {
		return _position.getColumn19();
	}

	/**
	* Sets the column19 of this position.
	*
	* @param column19 the column19 of this position
	*/
	@Override
	public void setColumn19(java.lang.String column19) {
		_position.setColumn19(column19);
	}

	/**
	* Returns the column20 of this position.
	*
	* @return the column20 of this position
	*/
	@Override
	public java.lang.String getColumn20() {
		return _position.getColumn20();
	}

	/**
	* Sets the column20 of this position.
	*
	* @param column20 the column20 of this position
	*/
	@Override
	public void setColumn20(java.lang.String column20) {
		_position.setColumn20(column20);
	}

	@Override
	public boolean isNew() {
		return _position.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_position.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _position.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_position.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _position.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _position.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_position.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _position.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_position.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_position.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_position.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PositionWrapper((Position)_position.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Position position) {
		return _position.compareTo(position);
	}

	@Override
	public int hashCode() {
		return _position.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Position> toCacheModel() {
		return _position.toCacheModel();
	}

	@Override
	public org.gfbio.model.Position toEscapedModel() {
		return new PositionWrapper(_position.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Position toUnescapedModel() {
		return new PositionWrapper(_position.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _position.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _position.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_position.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PositionWrapper)) {
			return false;
		}

		PositionWrapper positionWrapper = (PositionWrapper)obj;

		if (Validator.equals(_position, positionWrapper._position)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Position getWrappedPosition() {
		return _position;
	}

	@Override
	public Position getWrappedModel() {
		return _position;
	}

	@Override
	public void resetOriginalValues() {
		_position.resetOriginalValues();
	}

	private Position _position;
}