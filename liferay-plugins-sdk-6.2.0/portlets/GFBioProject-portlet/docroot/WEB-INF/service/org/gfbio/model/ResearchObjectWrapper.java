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
 * This class is a wrapper for {@link ResearchObject}.
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObject
 * @generated
 */
public class ResearchObjectWrapper implements ResearchObject,
	ModelWrapper<ResearchObject> {
	public ResearchObjectWrapper(ResearchObject researchObject) {
		_researchObject = researchObject;
	}

	@Override
	public Class<?> getModelClass() {
		return ResearchObject.class;
	}

	@Override
	public String getModelClassName() {
		return ResearchObject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("researchObjectID", getResearchObjectID());
		attributes.put("researchObjectVersion", getResearchObjectVersion());
		attributes.put("parentResearchObjectID", getParentResearchObjectID());
		attributes.put("name", getName());
		attributes.put("label", getLabel());
		attributes.put("metadata", getMetadata());
		attributes.put("formatmetadata", getFormatmetadata());
		attributes.put("researchObjectType", getResearchObjectType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long researchObjectID = (Long)attributes.get("researchObjectID");

		if (researchObjectID != null) {
			setResearchObjectID(researchObjectID);
		}

		Integer researchObjectVersion = (Integer)attributes.get(
				"researchObjectVersion");

		if (researchObjectVersion != null) {
			setResearchObjectVersion(researchObjectVersion);
		}

		Long parentResearchObjectID = (Long)attributes.get(
				"parentResearchObjectID");

		if (parentResearchObjectID != null) {
			setParentResearchObjectID(parentResearchObjectID);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		String formatmetadata = (String)attributes.get("formatmetadata");

		if (formatmetadata != null) {
			setFormatmetadata(formatmetadata);
		}

		String researchObjectType = (String)attributes.get("researchObjectType");

		if (researchObjectType != null) {
			setResearchObjectType(researchObjectType);
		}
	}

	/**
	* Returns the primary key of this research object.
	*
	* @return the primary key of this research object
	*/
	@Override
	public org.gfbio.service.persistence.ResearchObjectPK getPrimaryKey() {
		return _researchObject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this research object.
	*
	* @param primaryKey the primary key of this research object
	*/
	@Override
	public void setPrimaryKey(
		org.gfbio.service.persistence.ResearchObjectPK primaryKey) {
		_researchObject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the research object i d of this research object.
	*
	* @return the research object i d of this research object
	*/
	@Override
	public long getResearchObjectID() {
		return _researchObject.getResearchObjectID();
	}

	/**
	* Sets the research object i d of this research object.
	*
	* @param researchObjectID the research object i d of this research object
	*/
	@Override
	public void setResearchObjectID(long researchObjectID) {
		_researchObject.setResearchObjectID(researchObjectID);
	}

	/**
	* Returns the research object version of this research object.
	*
	* @return the research object version of this research object
	*/
	@Override
	public int getResearchObjectVersion() {
		return _researchObject.getResearchObjectVersion();
	}

	/**
	* Sets the research object version of this research object.
	*
	* @param researchObjectVersion the research object version of this research object
	*/
	@Override
	public void setResearchObjectVersion(int researchObjectVersion) {
		_researchObject.setResearchObjectVersion(researchObjectVersion);
	}

	/**
	* Returns the parent research object i d of this research object.
	*
	* @return the parent research object i d of this research object
	*/
	@Override
	public long getParentResearchObjectID() {
		return _researchObject.getParentResearchObjectID();
	}

	/**
	* Sets the parent research object i d of this research object.
	*
	* @param parentResearchObjectID the parent research object i d of this research object
	*/
	@Override
	public void setParentResearchObjectID(long parentResearchObjectID) {
		_researchObject.setParentResearchObjectID(parentResearchObjectID);
	}

	/**
	* Returns the name of this research object.
	*
	* @return the name of this research object
	*/
	@Override
	public java.lang.String getName() {
		return _researchObject.getName();
	}

	/**
	* Sets the name of this research object.
	*
	* @param name the name of this research object
	*/
	@Override
	public void setName(java.lang.String name) {
		_researchObject.setName(name);
	}

	/**
	* Returns the label of this research object.
	*
	* @return the label of this research object
	*/
	@Override
	public java.lang.String getLabel() {
		return _researchObject.getLabel();
	}

	/**
	* Sets the label of this research object.
	*
	* @param label the label of this research object
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_researchObject.setLabel(label);
	}

	/**
	* Returns the metadata of this research object.
	*
	* @return the metadata of this research object
	*/
	@Override
	public java.lang.String getMetadata() {
		return _researchObject.getMetadata();
	}

	/**
	* Sets the metadata of this research object.
	*
	* @param metadata the metadata of this research object
	*/
	@Override
	public void setMetadata(java.lang.String metadata) {
		_researchObject.setMetadata(metadata);
	}

	/**
	* Returns the formatmetadata of this research object.
	*
	* @return the formatmetadata of this research object
	*/
	@Override
	public java.lang.String getFormatmetadata() {
		return _researchObject.getFormatmetadata();
	}

	/**
	* Sets the formatmetadata of this research object.
	*
	* @param formatmetadata the formatmetadata of this research object
	*/
	@Override
	public void setFormatmetadata(java.lang.String formatmetadata) {
		_researchObject.setFormatmetadata(formatmetadata);
	}

	/**
	* Returns the research object type of this research object.
	*
	* @return the research object type of this research object
	*/
	@Override
	public java.lang.String getResearchObjectType() {
		return _researchObject.getResearchObjectType();
	}

	/**
	* Sets the research object type of this research object.
	*
	* @param researchObjectType the research object type of this research object
	*/
	@Override
	public void setResearchObjectType(java.lang.String researchObjectType) {
		_researchObject.setResearchObjectType(researchObjectType);
	}

	@Override
	public boolean isNew() {
		return _researchObject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_researchObject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _researchObject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_researchObject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _researchObject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _researchObject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_researchObject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _researchObject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_researchObject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_researchObject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_researchObject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResearchObjectWrapper((ResearchObject)_researchObject.clone());
	}

	@Override
	public int compareTo(org.gfbio.model.ResearchObject researchObject) {
		return _researchObject.compareTo(researchObject);
	}

	@Override
	public int hashCode() {
		return _researchObject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.gfbio.model.ResearchObject> toCacheModel() {
		return _researchObject.toCacheModel();
	}

	@Override
	public org.gfbio.model.ResearchObject toEscapedModel() {
		return new ResearchObjectWrapper(_researchObject.toEscapedModel());
	}

	@Override
	public org.gfbio.model.ResearchObject toUnescapedModel() {
		return new ResearchObjectWrapper(_researchObject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _researchObject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _researchObject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_researchObject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResearchObjectWrapper)) {
			return false;
		}

		ResearchObjectWrapper researchObjectWrapper = (ResearchObjectWrapper)obj;

		if (Validator.equals(_researchObject,
					researchObjectWrapper._researchObject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ResearchObject getWrappedResearchObject() {
		return _researchObject;
	}

	@Override
	public ResearchObject getWrappedModel() {
		return _researchObject;
	}

	@Override
	public void resetOriginalValues() {
		_researchObject.resetOriginalValues();
	}

	private ResearchObject _researchObject;
}