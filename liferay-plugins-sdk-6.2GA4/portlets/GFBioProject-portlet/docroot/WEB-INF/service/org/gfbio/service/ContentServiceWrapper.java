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

package org.gfbio.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContentService}.
 *
 * @author Marcel Froemming
 * @see ContentService
 * @generated
 */
public class ContentServiceWrapper implements ContentService,
	ServiceWrapper<ContentService> {
	public ContentServiceWrapper(ContentService contentService) {
		_contentService = contentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String getContentIdsWithRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2) {
		return _contentService.getContentIdsWithRelationships(rowId,
			tableName1, tableName2);
	}

	@Override
	public java.lang.String getContentIdsWithNormalTableRelationships(
		long rowId, java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2) {
		return _contentService.getContentIdsWithNormalTableRelationships(rowId,
			tableName, columnName1, columnName2);
	}

	@Override
	public org.json.simple.JSONObject getRowInformationByContentId(
		long contentId) {
		return _contentService.getRowInformationByContentId(contentId);
	}

	@Override
	public org.json.simple.JSONArray getRowInformationOfRelationByContentId(
		long contentId, java.lang.String tableName1, java.lang.String tableName2) {
		return _contentService.getRowInformationOfRelationByContentId(contentId,
			tableName1, tableName2);
	}

	@Override
	public org.json.simple.JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(
		org.json.simple.JSONObject requestJson) {
		return _contentService.getRowInformationsOfRelationshipsOfSpecificCellContent(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentService getWrappedContentService() {
		return _contentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentService(ContentService contentService) {
		_contentService = contentService;
	}

	@Override
	public ContentService getWrappedService() {
		return _contentService;
	}

	@Override
	public void setWrappedService(ContentService contentService) {
		_contentService = contentService;
	}

	private ContentService _contentService;
}