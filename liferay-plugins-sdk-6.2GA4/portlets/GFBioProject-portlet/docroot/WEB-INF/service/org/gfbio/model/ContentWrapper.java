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

package org.gfbio.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Content}.
 * </p>
 *
 * @author Marcel Froemming
 * @see Content
 * @generated
 */
public class ContentWrapper implements Content, ModelWrapper<Content> {
	public ContentWrapper(Content content) {
		_content = content;
	}

	@Override
	public Class<?> getModelClass() {
		return Content.class;
	}

	@Override
	public String getModelClassName() {
		return Content.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentID", getContentID());
		attributes.put("headID", getHeadID());
		attributes.put("columnID", getColumnID());
		attributes.put("rowID", getRowID());
		attributes.put("cellContent", getCellContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentID = (Long)attributes.get("contentID");

		if (contentID != null) {
			setContentID(contentID);
		}

		Long headID = (Long)attributes.get("headID");

		if (headID != null) {
			setHeadID(headID);
		}

		Long columnID = (Long)attributes.get("columnID");

		if (columnID != null) {
			setColumnID(columnID);
		}

		Long rowID = (Long)attributes.get("rowID");

		if (rowID != null) {
			setRowID(rowID);
		}

		String cellContent = (String)attributes.get("cellContent");

		if (cellContent != null) {
			setCellContent(cellContent);
		}
	}

	/**
	* Returns the primary key of this content.
	*
	* @return the primary key of this content
	*/
	@Override
	public long getPrimaryKey() {
		return _content.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content.
	*
	* @param primaryKey the primary key of this content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_content.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content i d of this content.
	*
	* @return the content i d of this content
	*/
	@Override
	public long getContentID() {
		return _content.getContentID();
	}

	/**
	* Sets the content i d of this content.
	*
	* @param contentID the content i d of this content
	*/
	@Override
	public void setContentID(long contentID) {
		_content.setContentID(contentID);
	}

	/**
	* Returns the head i d of this content.
	*
	* @return the head i d of this content
	*/
	@Override
	public long getHeadID() {
		return _content.getHeadID();
	}

	/**
	* Sets the head i d of this content.
	*
	* @param headID the head i d of this content
	*/
	@Override
	public void setHeadID(long headID) {
		_content.setHeadID(headID);
	}

	/**
	* Returns the column i d of this content.
	*
	* @return the column i d of this content
	*/
	@Override
	public long getColumnID() {
		return _content.getColumnID();
	}

	/**
	* Sets the column i d of this content.
	*
	* @param columnID the column i d of this content
	*/
	@Override
	public void setColumnID(long columnID) {
		_content.setColumnID(columnID);
	}

	/**
	* Returns the row i d of this content.
	*
	* @return the row i d of this content
	*/
	@Override
	public long getRowID() {
		return _content.getRowID();
	}

	/**
	* Sets the row i d of this content.
	*
	* @param rowID the row i d of this content
	*/
	@Override
	public void setRowID(long rowID) {
		_content.setRowID(rowID);
	}

	/**
	* Returns the cell content of this content.
	*
	* @return the cell content of this content
	*/
	@Override
	public java.lang.String getCellContent() {
		return _content.getCellContent();
	}

	/**
	* Sets the cell content of this content.
	*
	* @param cellContent the cell content of this content
	*/
	@Override
	public void setCellContent(java.lang.String cellContent) {
		_content.setCellContent(cellContent);
	}

	@Override
	public boolean isNew() {
		return _content.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_content.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _content.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_content.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _content.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _content.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_content.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _content.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_content.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_content.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_content.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentWrapper((Content)_content.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.Content content) {
		return _content.compareTo(content);
	}

	@Override
	public int hashCode() {
		return _content.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.Content> toCacheModel() {
		return _content.toCacheModel();
	}

	@Override
	public org.gfbio.model.Content toEscapedModel() {
		return new ContentWrapper(_content.toEscapedModel());
	}

	@Override
	public org.gfbio.model.Content toUnescapedModel() {
		return new ContentWrapper(_content.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _content.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _content.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_content.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentWrapper)) {
			return false;
		}

		ContentWrapper contentWrapper = (ContentWrapper)obj;

		if (Validator.equals(_content, contentWrapper._content)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Content getWrappedContent() {
		return _content;
	}

	@Override
	public Content getWrappedModel() {
		return _content;
	}

	@Override
	public void resetOriginalValues() {
		_content.resetOriginalValues();
	}

	private Content _content;
}