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
 * The base model interface for the ResearchObject service. Represents a row in the &quot;gfbio_ResearchObject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gfbio.model.impl.ResearchObjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gfbio.model.impl.ResearchObjectImpl}.
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObject
 * @see org.gfbio.model.impl.ResearchObjectImpl
 * @see org.gfbio.model.impl.ResearchObjectModelImpl
 * @generated
 */
public interface ResearchObjectModel extends BaseModel<ResearchObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a research object model instance should use the {@link ResearchObject} interface instead.
	 */

	/**
	 * Returns the primary key of this research object.
	 *
	 * @return the primary key of this research object
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this research object.
	 *
	 * @param primaryKey the primary key of this research object
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the research object i d of this research object.
	 *
	 * @return the research object i d of this research object
	 */
	public long getResearchObjectID();

	/**
	 * Sets the research object i d of this research object.
	 *
	 * @param researchObjectID the research object i d of this research object
	 */
	public void setResearchObjectID(long researchObjectID);

	/**
	 * Returns the version of this research object.
	 *
	 * @return the version of this research object
	 */
	public int getVersion();

	/**
	 * Sets the version of this research object.
	 *
	 * @param version the version of this research object
	 */
	public void setVersion(int version);

	/**
	 * Returns the parent research object i d of this research object.
	 *
	 * @return the parent research object i d of this research object
	 */
	public long getParentResearchObjectID();

	/**
	 * Sets the parent research object i d of this research object.
	 *
	 * @param parentResearchObjectID the parent research object i d of this research object
	 */
	public void setParentResearchObjectID(long parentResearchObjectID);

	/**
	 * Returns the name of this research object.
	 *
	 * @return the name of this research object
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this research object.
	 *
	 * @param name the name of this research object
	 */
	public void setName(String name);

	/**
	 * Returns the label of this research object.
	 *
	 * @return the label of this research object
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this research object.
	 *
	 * @param label the label of this research object
	 */
	public void setLabel(String label);

	/**
	 * Returns the metadata of this research object.
	 *
	 * @return the metadata of this research object
	 */
	@AutoEscape
	public String getMetadata();

	/**
	 * Sets the metadata of this research object.
	 *
	 * @param metadata the metadata of this research object
	 */
	public void setMetadata(String metadata);

	/**
	 * Returns the formatmetadata of this research object.
	 *
	 * @return the formatmetadata of this research object
	 */
	@AutoEscape
	public String getFormatmetadata();

	/**
	 * Sets the formatmetadata of this research object.
	 *
	 * @param formatmetadata the formatmetadata of this research object
	 */
	public void setFormatmetadata(String formatmetadata);

	/**
	 * Returns the research object type of this research object.
	 *
	 * @return the research object type of this research object
	 */
	@AutoEscape
	public String getResearchObjectType();

	/**
	 * Sets the research object type of this research object.
	 *
	 * @param researchObjectType the research object type of this research object
	 */
	public void setResearchObjectType(String researchObjectType);

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
	public int compareTo(ResearchObject researchObject);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ResearchObject> toCacheModel();

	@Override
	public ResearchObject toEscapedModel();

	@Override
	public ResearchObject toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}