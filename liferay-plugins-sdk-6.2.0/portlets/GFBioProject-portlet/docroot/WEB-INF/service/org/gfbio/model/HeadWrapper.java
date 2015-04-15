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
 * This class is a wrapper for {@link Head}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Head
 * @generated
 */
public class HeadWrapper implements Head, ModelWrapper<Head> {
	public HeadWrapper(Head head) {
		_head = head;
	}

	@Override
	public Class<?> getModelClass() {
		return Head.class;
	}

	@Override
	public String getModelClassName() {
		return Head.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("headID", getHeadID());
		attributes.put("name", getName());
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
		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	* Returns the primary key of this head.
	*
	* @return the primary key of this head
	*/
	@Override
	public long getPrimaryKey() {
		return _head.getPrimaryKey();
	}

	/**
	* Sets the primary key of this head.
	*
	* @param primaryKey the primary key of this head
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_head.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the head i d of this head.
	*
	* @return the head i d of this head
	*/
	@Override
	public long getHeadID() {
		return _head.getHeadID();
	}

	/**
	* Sets the head i d of this head.
	*
	* @param headID the head i d of this head
	*/
	@Override
	public void setHeadID(long headID) {
		_head.setHeadID(headID);
	}

	/**
	* Returns the name of this head.
	*
	* @return the name of this head
	*/
	@Override
	public java.lang.String getName() {
		return _head.getName();
	}

	/**
	* Sets the name of this head.
	*
	* @param name the name of this head
	*/
	@Override
	public void setName(java.lang.String name) {
		_head.setName(name);
	}

	/**
	* Returns the column01 of this head.
	*
	* @return the column01 of this head
	*/
	@Override
	public java.lang.String getColumn01() {
		return _head.getColumn01();
	}

	/**
	* Sets the column01 of this head.
	*
	* @param column01 the column01 of this head
	*/
	@Override
	public void setColumn01(java.lang.String column01) {
		_head.setColumn01(column01);
	}

	/**
	* Returns the column02 of this head.
	*
	* @return the column02 of this head
	*/
	@Override
	public java.lang.String getColumn02() {
		return _head.getColumn02();
	}

	/**
	* Sets the column02 of this head.
	*
	* @param column02 the column02 of this head
	*/
	@Override
	public void setColumn02(java.lang.String column02) {
		_head.setColumn02(column02);
	}

	/**
	* Returns the column03 of this head.
	*
	* @return the column03 of this head
	*/
	@Override
	public java.lang.String getColumn03() {
		return _head.getColumn03();
	}

	/**
	* Sets the column03 of this head.
	*
	* @param column03 the column03 of this head
	*/
	@Override
	public void setColumn03(java.lang.String column03) {
		_head.setColumn03(column03);
	}

	/**
	* Returns the column04 of this head.
	*
	* @return the column04 of this head
	*/
	@Override
	public java.lang.String getColumn04() {
		return _head.getColumn04();
	}

	/**
	* Sets the column04 of this head.
	*
	* @param column04 the column04 of this head
	*/
	@Override
	public void setColumn04(java.lang.String column04) {
		_head.setColumn04(column04);
	}

	/**
	* Returns the column05 of this head.
	*
	* @return the column05 of this head
	*/
	@Override
	public java.lang.String getColumn05() {
		return _head.getColumn05();
	}

	/**
	* Sets the column05 of this head.
	*
	* @param column05 the column05 of this head
	*/
	@Override
	public void setColumn05(java.lang.String column05) {
		_head.setColumn05(column05);
	}

	/**
	* Returns the column06 of this head.
	*
	* @return the column06 of this head
	*/
	@Override
	public java.lang.String getColumn06() {
		return _head.getColumn06();
	}

	/**
	* Sets the column06 of this head.
	*
	* @param column06 the column06 of this head
	*/
	@Override
	public void setColumn06(java.lang.String column06) {
		_head.setColumn06(column06);
	}

	/**
	* Returns the column07 of this head.
	*
	* @return the column07 of this head
	*/
	@Override
	public java.lang.String getColumn07() {
		return _head.getColumn07();
	}

	/**
	* Sets the column07 of this head.
	*
	* @param column07 the column07 of this head
	*/
	@Override
	public void setColumn07(java.lang.String column07) {
		_head.setColumn07(column07);
	}

	/**
	* Returns the column08 of this head.
	*
	* @return the column08 of this head
	*/
	@Override
	public java.lang.String getColumn08() {
		return _head.getColumn08();
	}

	/**
	* Sets the column08 of this head.
	*
	* @param column08 the column08 of this head
	*/
	@Override
	public void setColumn08(java.lang.String column08) {
		_head.setColumn08(column08);
	}

	/**
	* Returns the column09 of this head.
	*
	* @return the column09 of this head
	*/
	@Override
	public java.lang.String getColumn09() {
		return _head.getColumn09();
	}

	/**
	* Sets the column09 of this head.
	*
	* @param column09 the column09 of this head
	*/
	@Override
	public void setColumn09(java.lang.String column09) {
		_head.setColumn09(column09);
	}

	/**
	* Returns the column10 of this head.
	*
	* @return the column10 of this head
	*/
	@Override
	public java.lang.String getColumn10() {
		return _head.getColumn10();
	}

	/**
	* Sets the column10 of this head.
	*
	* @param column10 the column10 of this head
	*/
	@Override
	public void setColumn10(java.lang.String column10) {
		_head.setColumn10(column10);
	}

	/**
	* Returns the column11 of this head.
	*
	* @return the column11 of this head
	*/
	@Override
	public java.lang.String getColumn11() {
		return _head.getColumn11();
	}

	/**
	* Sets the column11 of this head.
	*
	* @param column11 the column11 of this head
	*/
	@Override
	public void setColumn11(java.lang.String column11) {
		_head.setColumn11(column11);
	}

	/**
	* Returns the column12 of this head.
	*
	* @return the column12 of this head
	*/
	@Override
	public java.lang.String getColumn12() {
		return _head.getColumn12();
	}

	/**
	* Sets the column12 of this head.
	*
	* @param column12 the column12 of this head
	*/
	@Override
	public void setColumn12(java.lang.String column12) {
		_head.setColumn12(column12);
	}

	/**
	* Returns the column13 of this head.
	*
	* @return the column13 of this head
	*/
	@Override
	public java.lang.String getColumn13() {
		return _head.getColumn13();
	}

	/**
	* Sets the column13 of this head.
	*
	* @param column13 the column13 of this head
	*/
	@Override
	public void setColumn13(java.lang.String column13) {
		_head.setColumn13(column13);
	}

	/**
	* Returns the column14 of this head.
	*
	* @return the column14 of this head
	*/
	@Override
	public java.lang.String getColumn14() {
		return _head.getColumn14();
	}

	/**
	* Sets the column14 of this head.
	*
	* @param column14 the column14 of this head
	*/
	@Override
	public void setColumn14(java.lang.String column14) {
		_head.setColumn14(column14);
	}

	/**
	* Returns the column15 of this head.
	*
	* @return the column15 of this head
	*/
	@Override
	public java.lang.String getColumn15() {
		return _head.getColumn15();
	}

	/**
	* Sets the column15 of this head.
	*
	* @param column15 the column15 of this head
	*/
	@Override
	public void setColumn15(java.lang.String column15) {
		_head.setColumn15(column15);
	}

	/**
	* Returns the column16 of this head.
	*
	* @return the column16 of this head
	*/
	@Override
	public java.lang.String getColumn16() {
		return _head.getColumn16();
	}

	/**
	* Sets the column16 of this head.
	*
	* @param column16 the column16 of this head
	*/
	@Override
	public void setColumn16(java.lang.String column16) {
		_head.setColumn16(column16);
	}

	/**
	* Returns the column17 of this head.
	*
	* @return the column17 of this head
	*/
	@Override
	public java.lang.String getColumn17() {
		return _head.getColumn17();
	}

	/**
	* Sets the column17 of this head.
	*
	* @param column17 the column17 of this head
	*/
	@Override
	public void setColumn17(java.lang.String column17) {
		_head.setColumn17(column17);
	}

	/**
	* Returns the column18 of this head.
	*
	* @return the column18 of this head
	*/
	@Override
	public java.lang.String getColumn18() {
		return _head.getColumn18();
	}

	/**
	* Sets the column18 of this head.
	*
	* @param column18 the column18 of this head
	*/
	@Override
	public void setColumn18(java.lang.String column18) {
		_head.setColumn18(column18);
	}

	/**
	* Returns the column19 of this head.
	*
	* @return the column19 of this head
	*/
	@Override
	public java.lang.String getColumn19() {
		return _head.getColumn19();
	}

	/**
	* Sets the column19 of this head.
	*
	* @param column19 the column19 of this head
	*/
	@Override
	public void setColumn19(java.lang.String column19) {
		_head.setColumn19(column19);
	}

	/**
	* Returns the column20 of this head.
	*
	* @return the column20 of this head
	*/
	@Override
	public java.lang.String getColumn20() {
		return _head.getColumn20();
	}

	/**
	* Sets the column20 of this head.
	*
	* @param column20 the column20 of this head
	*/
	@Override
	public void setColumn20(java.lang.String column20) {
		_head.setColumn20(column20);
	}

	@Override
	public boolean isNew() {
		return _head.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_head.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _head.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_head.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _head.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _head.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_head.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _head.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_head.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_head.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_head.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeadWrapper((Head)_head.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Head head) {
		return _head.compareTo(head);
	}

	@Override
	public int hashCode() {
		return _head.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Head> toCacheModel() {
		return _head.toCacheModel();
	}

	@Override
	public org.gfbio.model.Head toEscapedModel() {
		return new HeadWrapper(_head.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Head toUnescapedModel() {
		return new HeadWrapper(_head.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _head.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _head.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_head.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HeadWrapper)) {
			return false;
		}

		HeadWrapper headWrapper = (HeadWrapper)obj;

		if (Validator.equals(_head, headWrapper._head)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Head getWrappedHead() {
		return _head;
	}

	@Override
	public Head getWrappedModel() {
		return _head;
	}

	@Override
	public void resetOriginalValues() {
		_head.resetOriginalValues();
	}

	private Head _head;
}