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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Content. This utility wraps
 * {@link org.gfbio.service.impl.ContentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see ContentLocalService
 * @see org.gfbio.service.base.ContentLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ContentLocalServiceImpl
 * @generated
 */
public class ContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Content addContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContent(content);
	}

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentID the primary key for the new content
	* @return the new content
	*/
	public static org.gfbio.model.Content createContent(long contentID) {
		return getService().createContent(contentID);
	}

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentID the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Content deleteContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContent(contentID);
	}

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Content deleteContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteContent(content);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.gfbio.model.Content fetchContent(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContent(contentID);
	}

	/**
	* Returns the content with the primary key.
	*
	* @param contentID the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Content getContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContent(contentID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.Content> getContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContents(start, end);
	}

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContentsCount();
	}

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Content updateContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContent(content);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void deleteContentsByColumnId(long columnId) {
		getService().deleteContentsByColumnId(columnId);
	}

	public static void deleteContentsByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContentsByHeadId(headId);
	}

	public static void deleteContentsByRowId(long rowId) {
		getService().deleteContentsByRowId(rowId);
	}

	public static java.util.List getCellContentByContentId(long contentId) {
		return getService().getCellContentByContentId(contentId);
	}

	public static java.lang.String getCellContentByRowIdAndColumnName(
		long rowId, java.lang.String columnName) {
		return getService().getCellContentByRowIdAndColumnName(rowId, columnName);
	}

	public static long getColumnIdById(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumnIdById(contentId);
	}

	public static org.gfbio.model.Content getContentByTableIds(long rowId,
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException {
		return getService().getContentByTableIds(rowId, columnId);
	}

	public static long getContentIdByTableIds(long rowId, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException {
		return getService().getContentIdByTableIds(rowId, columnId);
	}

	public static java.util.List getContentIdsByRowId(long rowId) {
		return getService().getContentIdsByRowId(rowId);
	}

	public static java.util.List getContentIdsWithoutRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2) {
		return getService()
				   .getContentIdsWithoutRelationships(rowId, tableName1,
			tableName2);
	}

	public static java.util.List getContentIdsWithRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2) {
		return getService()
				   .getContentIdsWithRelationships(rowId, tableName1, tableName2);
	}

	public static java.util.List getContentIdsWithNormalTableRelationships(
		long rowId, java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2) {
		return getService()
				   .getContentIdsWithNormalTableRelationships(rowId, tableName,
			columnName1, columnName2);
	}

	public static org.json.simple.JSONObject getContentInformationAsJSONByContentId(
		long contentId) {
		return getService().getContentInformationAsJSONByContentId(contentId);
	}

	public static org.json.simple.JSONObject getContentInformationAsJSONByRowId(
		long rowId) {
		return getService().getContentInformationAsJSONByRowId(rowId);
	}

	public static org.json.simple.JSONObject getContentsAsJSONByRowId(
		long rowId) {
		return getService().getContentsAsJSONByRowId(rowId);
	}

	public static int getCountOfColumns(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountOfColumns(rowId);
	}

	public static int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountOfRows(headId);
	}

	public static long getFirstContentIdByRowId(long rowId) {
		return getService().getFirstContentIdByRowId(rowId);
	}

	public static long getHeadIdById(long contentId) {
		return getService().getHeadIdById(contentId);
	}

	public static long getRowIdByCellContent(long headId,
		java.lang.String columnName, java.lang.String cellContent) {
		return getService()
				   .getRowIdByCellContent(headId, columnName, cellContent);
	}

	public static long getRowIdByCellContent(java.lang.String tableName,
		java.lang.String columnName, java.lang.String cellContent) {
		return getService()
				   .getRowIdByCellContent(tableName, columnName, cellContent);
	}

	public static long getRowIdById(long contentId) {
		return getService().getRowIdById(contentId);
	}

	public static long getRowIdOfRelation(java.lang.String cellContent1,
		java.lang.String cellContent2) {
		return getService().getRowIdOfRelation(cellContent1, cellContent2);
	}

	public static java.util.List getRowIds(long headId) {
		return getService().getRowIds(headId);
	}

	public static org.json.simple.JSONObject getRowInformationByContentId(
		long contentId) {
		return getService().getRowInformationByContentId(contentId);
	}

	public static org.json.simple.JSONArray getRowInformationOfRelationByContentId(
		long contentId, java.lang.String tableName1, java.lang.String tableName2) {
		return getService()
				   .getRowInformationOfRelationByContentId(contentId,
			tableName1, tableName2);
	}

	public static org.json.simple.JSONObject constructContentJson(
		long contentId, long headId, long columnId, long rowId,
		java.lang.String cellContent) {
		return getService()
				   .constructContentJson(contentId, headId, columnId, rowId,
			cellContent);
	}

	public static long constructNewId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().constructNewId();
	}

	public static java.lang.Boolean updateContent(long contentId, long headId,
		long columnId, long rowId, java.lang.String cellContent) {
		return getService()
				   .updateContent(contentId, headId, columnId, rowId,
			cellContent);
	}

	public static java.lang.Boolean updateContent(
		org.json.simple.JSONObject json) {
		return getService().updateContent(json);
	}

	public static java.lang.Boolean updateContent2(
		org.json.simple.JSONObject json) {
		return getService().updateContent2(json);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContentLocalService.class.getName());

			if (invokableLocalService instanceof ContentLocalService) {
				_service = (ContentLocalService)invokableLocalService;
			}
			else {
				_service = new ContentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ContentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ContentLocalService service) {
	}

	private static ContentLocalService _service;
}