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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Head service. Represents a row in the &quot;gfbio_Head&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.HeadModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.HeadImpl}.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Head
 * @see org.gfbio.model.impl.HeadImpl
 * @see org.gfbio.model.impl.HeadModelImpl
 * @generated
 */
public interface HeadModel extends BaseModel<Head> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a head model instance should use the {@link Head} interface instead.
	 */

	/**
	 * Returns the primary key of this head.
	 *
	 * @return the primary key of this head
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this head.
	 *
	 * @param primaryKey the primary key of this head
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the head i d of this head.
	 *
	 * @return the head i d of this head
	 */
	public long getHeadID();

	/**
	 * Sets the head i d of this head.
	 *
	 * @param headID the head i d of this head
	 */
	public void setHeadID(long headID);

	/**
	 * Returns the name of this head.
	 *
	 * @return the name of this head
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this head.
	 *
	 * @param name the name of this head
	 */
	public void setName(String name);

	/**
	 * Returns the task of this head.
	 *
	 * @return the task of this head
	 */
	@AutoEscape
	public String getTask();

	/**
	 * Sets the task of this head.
	 *
	 * @param task the task of this head
	 */
	public void setTask(String task);

	/**
	 * Returns the column01 of this head.
	 *
	 * @return the column01 of this head
	 */
	@AutoEscape
	public String getColumn01();

	/**
	 * Sets the column01 of this head.
	 *
	 * @param column01 the column01 of this head
	 */
	public void setColumn01(String column01);

	/**
	 * Returns the column02 of this head.
	 *
	 * @return the column02 of this head
	 */
	@AutoEscape
	public String getColumn02();

	/**
	 * Sets the column02 of this head.
	 *
	 * @param column02 the column02 of this head
	 */
	public void setColumn02(String column02);

	/**
	 * Returns the column03 of this head.
	 *
	 * @return the column03 of this head
	 */
	@AutoEscape
	public String getColumn03();

	/**
	 * Sets the column03 of this head.
	 *
	 * @param column03 the column03 of this head
	 */
	public void setColumn03(String column03);

	/**
	 * Returns the column04 of this head.
	 *
	 * @return the column04 of this head
	 */
	@AutoEscape
	public String getColumn04();

	/**
	 * Sets the column04 of this head.
	 *
	 * @param column04 the column04 of this head
	 */
	public void setColumn04(String column04);

	/**
	 * Returns the column05 of this head.
	 *
	 * @return the column05 of this head
	 */
	@AutoEscape
	public String getColumn05();

	/**
	 * Sets the column05 of this head.
	 *
	 * @param column05 the column05 of this head
	 */
	public void setColumn05(String column05);

	/**
	 * Returns the column06 of this head.
	 *
	 * @return the column06 of this head
	 */
	@AutoEscape
	public String getColumn06();

	/**
	 * Sets the column06 of this head.
	 *
	 * @param column06 the column06 of this head
	 */
	public void setColumn06(String column06);

	/**
	 * Returns the column07 of this head.
	 *
	 * @return the column07 of this head
	 */
	@AutoEscape
	public String getColumn07();

	/**
	 * Sets the column07 of this head.
	 *
	 * @param column07 the column07 of this head
	 */
	public void setColumn07(String column07);

	/**
	 * Returns the column08 of this head.
	 *
	 * @return the column08 of this head
	 */
	@AutoEscape
	public String getColumn08();

	/**
	 * Sets the column08 of this head.
	 *
	 * @param column08 the column08 of this head
	 */
	public void setColumn08(String column08);

	/**
	 * Returns the column09 of this head.
	 *
	 * @return the column09 of this head
	 */
	@AutoEscape
	public String getColumn09();

	/**
	 * Sets the column09 of this head.
	 *
	 * @param column09 the column09 of this head
	 */
	public void setColumn09(String column09);

	/**
	 * Returns the column10 of this head.
	 *
	 * @return the column10 of this head
	 */
	@AutoEscape
	public String getColumn10();

	/**
	 * Sets the column10 of this head.
	 *
	 * @param column10 the column10 of this head
	 */
	public void setColumn10(String column10);

	/**
	 * Returns the column11 of this head.
	 *
	 * @return the column11 of this head
	 */
	@AutoEscape
	public String getColumn11();

	/**
	 * Sets the column11 of this head.
	 *
	 * @param column11 the column11 of this head
	 */
	public void setColumn11(String column11);

	/**
	 * Returns the column12 of this head.
	 *
	 * @return the column12 of this head
	 */
	@AutoEscape
	public String getColumn12();

	/**
	 * Sets the column12 of this head.
	 *
	 * @param column12 the column12 of this head
	 */
	public void setColumn12(String column12);

	/**
	 * Returns the column13 of this head.
	 *
	 * @return the column13 of this head
	 */
	@AutoEscape
	public String getColumn13();

	/**
	 * Sets the column13 of this head.
	 *
	 * @param column13 the column13 of this head
	 */
	public void setColumn13(String column13);

	/**
	 * Returns the column14 of this head.
	 *
	 * @return the column14 of this head
	 */
	@AutoEscape
	public String getColumn14();

	/**
	 * Sets the column14 of this head.
	 *
	 * @param column14 the column14 of this head
	 */
	public void setColumn14(String column14);

	/**
	 * Returns the column15 of this head.
	 *
	 * @return the column15 of this head
	 */
	@AutoEscape
	public String getColumn15();

	/**
	 * Sets the column15 of this head.
	 *
	 * @param column15 the column15 of this head
	 */
	public void setColumn15(String column15);

	/**
	 * Returns the column16 of this head.
	 *
	 * @return the column16 of this head
	 */
	@AutoEscape
	public String getColumn16();

	/**
	 * Sets the column16 of this head.
	 *
	 * @param column16 the column16 of this head
	 */
	public void setColumn16(String column16);

	/**
	 * Returns the column17 of this head.
	 *
	 * @return the column17 of this head
	 */
	@AutoEscape
	public String getColumn17();

	/**
	 * Sets the column17 of this head.
	 *
	 * @param column17 the column17 of this head
	 */
	public void setColumn17(String column17);

	/**
	 * Returns the column18 of this head.
	 *
	 * @return the column18 of this head
	 */
	@AutoEscape
	public String getColumn18();

	/**
	 * Sets the column18 of this head.
	 *
	 * @param column18 the column18 of this head
	 */
	public void setColumn18(String column18);

	/**
	 * Returns the column19 of this head.
	 *
	 * @return the column19 of this head
	 */
	@AutoEscape
	public String getColumn19();

	/**
	 * Sets the column19 of this head.
	 *
	 * @param column19 the column19 of this head
	 */
	public void setColumn19(String column19);

	/**
	 * Returns the column20 of this head.
	 *
	 * @return the column20 of this head
	 */
	@AutoEscape
	public String getColumn20();

	/**
	 * Sets the column20 of this head.
	 *
	 * @param column20 the column20 of this head
	 */
	public void setColumn20(String column20);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Head head);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Head> toCacheModel();

	@Override
	public Head toEscapedModel();

	@Override
	public Head toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}