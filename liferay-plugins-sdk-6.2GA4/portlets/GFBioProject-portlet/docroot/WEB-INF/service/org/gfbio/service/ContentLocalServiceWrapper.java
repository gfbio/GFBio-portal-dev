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
 * Provides a wrapper for {@link ContentLocalService}.
 *
 * @author Marcel Froemming
 * @see ContentLocalService
 * @generated
 */
public class ContentLocalServiceWrapper implements ContentLocalService,
	ServiceWrapper<ContentLocalService> {
	public ContentLocalServiceWrapper(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Content addContent(org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.addContent(content);
	}

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentID the primary key for the new content
	* @return the new content
	*/
	@Override
	public org.gfbio.model.Content createContent(long contentID) {
		return _contentLocalService.createContent(contentID);
	}

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentID the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Content deleteContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(contentID);
	}

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Content deleteContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.deleteContent(content);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Content fetchContent(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.fetchContent(contentID);
	}

	/**
	* Returns the content with the primary key.
	*
	* @param contentID the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Content getContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContent(contentID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Content> getContents(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContents(start, end);
	}

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getContentsCount();
	}

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Content updateContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.updateContent(content);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contentLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void deleteContentsByColumnId(long columnId) {
		_contentLocalService.deleteContentsByColumnId(columnId);
	}

	@Override
	public void deleteContentsByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentLocalService.deleteContentsByHeadId(headId);
	}

	@Override
	public void deleteContentsByRowId(long rowId) {
		_contentLocalService.deleteContentsByRowId(rowId);
	}

	@Override
	public java.util.List getCellContentByContentId(long contentId) {
		return _contentLocalService.getCellContentByContentId(contentId);
	}

	@Override
	public org.gfbio.model.Content getContentByTableIds(long rowId,
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException {
		return _contentLocalService.getContentByTableIds(rowId, columnId);
	}

	@Override
	public long getContentIdByTableIds(long rowId, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException {
		return _contentLocalService.getContentIdByTableIds(rowId, columnId);
	}

	@Override
	public java.util.List getContentIdsByRowId(long rowId) {
		return _contentLocalService.getContentIdsByRowId(rowId);
	}

	@Override
	public java.util.List getContentIdsWithoutRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2) {
		return _contentLocalService.getContentIdsWithoutRelationships(rowId,
			tableName1, tableName2);
	}

	@Override
	public java.util.List getContentIdsWithRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2) {
		return _contentLocalService.getContentIdsWithRelationships(rowId,
			tableName1, tableName2);
	}

	@Override
	public org.json.simple.JSONObject getContentInformationAsJSONByContentId(
		long contentId) {
		return _contentLocalService.getContentInformationAsJSONByContentId(contentId);
	}

	@Override
	public org.json.simple.JSONObject getContentInformationAsJSONByRowId(
		long rowId) {
		return _contentLocalService.getContentInformationAsJSONByRowId(rowId);
	}

	@Override
	public long getFirstContentIdByRowId(long rowId) {
		return _contentLocalService.getFirstContentIdByRowId(rowId);
	}

	@Override
	public long getHeadIdById(long contentId) {
		return _contentLocalService.getHeadIdById(contentId);
	}

	@Override
	public long getRowIdByCellContent(long headId, java.lang.String columnName,
		java.lang.String cellContent) {
		return _contentLocalService.getRowIdByCellContent(headId, columnName,
			cellContent);
	}

	@Override
	public org.json.simple.JSONObject getContentsAsJSONByRowId(long rowId) {
		return _contentLocalService.getContentsAsJSONByRowId(rowId);
	}

	@Override
	public int getCountOfColumns(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getCountOfColumns(rowId);
	}

	@Override
	public int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getCountOfRows(headId);
	}

	@Override
	public java.util.List getRowIds(long headId) {
		return _contentLocalService.getRowIds(headId);
	}

	@Override
	public long getColumnIdById(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.getColumnIdById(contentId);
	}

	@Override
	public long getRowIdById(long contentId) {
		return _contentLocalService.getRowIdById(contentId);
	}

	@Override
	public long getRowIdOfRelation(java.lang.String cellContent1,
		java.lang.String cellContent2) {
		return _contentLocalService.getRowIdOfRelation(cellContent1,
			cellContent2);
	}

	@Override
	public org.json.simple.JSONObject constructContentJson(long contentId,
		long headId, long columnId, long rowId, java.lang.String cellContent) {
		return _contentLocalService.constructContentJson(contentId, headId,
			columnId, rowId, cellContent);
	}

	@Override
	public long constructNewId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentLocalService.constructNewId();
	}

	@Override
	public java.lang.Boolean updateContent(long contentId, long headId,
		long columnId, long rowId, java.lang.String cellContent) {
		return _contentLocalService.updateContent(contentId, headId, columnId,
			rowId, cellContent);
	}

	@Override
	public java.lang.Boolean updateContent(org.json.simple.JSONObject json) {
		return _contentLocalService.updateContent(json);
	}

	@Override
	public java.lang.Boolean updateContent2(org.json.simple.JSONObject json) {
		return _contentLocalService.updateContent2(json);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContentLocalService getWrappedContentLocalService() {
		return _contentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContentLocalService(
		ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	@Override
	public ContentLocalService getWrappedService() {
		return _contentLocalService;
	}

	@Override
	public void setWrappedService(ContentLocalService contentLocalService) {
		_contentLocalService = contentLocalService;
	}

	private ContentLocalService _contentLocalService;
}