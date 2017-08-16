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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Content. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcel Froemming
 * @see ContentLocalServiceUtil
 * @see org.gfbio.service.base.ContentLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ContentLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ContentLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentLocalServiceUtil} to access the content local service. Add custom service methods to {@link org.gfbio.service.impl.ContentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the content to the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Content addContent(org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentID the primary key for the new content
	* @return the new content
	*/
	public org.gfbio.model.Content createContent(long contentID);

	/**
	* Deletes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentID the primary key of the content
	* @return the content that was removed
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Content deleteContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the content from the database. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Content deleteContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Content fetchContent(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content with the primary key.
	*
	* @param contentID the primary key of the content
	* @return the content
	* @throws PortalException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Content getContent(long contentID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Content> getContents(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param content the content
	* @return the content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Content updateContent(
		org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void deleteContentsByColumnId(long columnId);

	public void deleteContentsByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteContentsByRowId(long rowId);

	public void deleteRelationContentByCellContent(
		java.lang.String cellcontent1, java.lang.String cellcontent2);

	public void deleteRelationContentsByCellContent(
		java.lang.String relationTable, java.lang.String columnName,
		java.lang.String cellContent);

	public void deleteRelationContentOfCategoryWithSpecificType(
		java.lang.String typeName, long relatedId,
		java.lang.String relationTable);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getCellContentByContentId(long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCellContentByRowIdAndColumnName(long rowId,
		java.lang.String columnName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getColumnIdById(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getContentIdByRowIdAndColumnName(long rowId,
		java.lang.String columnName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Content getContentByTableIds(long rowId,
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getContentIdByTableIds(long rowId, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsByRowId(long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsOfRelationshipsOfSpecificCellContent(
		java.lang.String relationTableName, java.lang.String entitiyTableName,
		java.lang.String entityTableCellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsOfRelationshipsOfSpecificCellContent(
		long relationTableHeadId, long entitiyTableHeadId,
		java.lang.String entityTableCellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsWithoutRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsWithRelationships(long rowId,
		java.lang.String tableName1, java.lang.String tableName2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getContentIdsWithNormalTableRelationships(
		long rowId, java.lang.String tableName, java.lang.String columnName1,
		java.lang.String columnName2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getContentInformationAsJSONByContentId(
		long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getContentInformationAsJSONByRowId(
		long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getContentsAsJSONByRowId(long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountOfColumns(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getFirstContentIdByRowId(long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getHeadIdById(long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getHeadIdByRowId(long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getOppositeCellContentsOfRelationsByCellContent(
		long headId, java.lang.String cellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getOppositeCellContentsOfRelationsByCellContent(
		long headId, long columnId, java.lang.String cellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRowIdByCellContent(long headId, java.lang.String columnName,
		java.lang.String cellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRowIdByCellContent(java.lang.String tableName,
		java.lang.String columnName, java.lang.String cellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRowIdById(long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRowIdOfRelation(java.lang.String cellContent1,
		java.lang.String cellContent2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getRowIds(long headId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getRowInformationByContentId(
		long contentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONObject getRowInformationById(long rowId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getRowInformationOfRelationByContentId(
		long contentId, java.lang.String tableName1, java.lang.String tableName2);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getRowInformationsOfRelationshipsOfSpecificCellContent(
		java.lang.String relationTableName, java.lang.String entitiyTableName,
		java.lang.String entityTableCellContent);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getRowInformationOfRelationshipsOfSpecificCellContent(
		long relationTableHeadId, long entitiyTableHeadId,
		java.lang.String entityTableCellContent);

	public java.lang.Boolean checkExistenceOfKeyId(java.lang.String tableName,
		long pk);

	public java.lang.Boolean checkExistenceOfKeyId(java.lang.String tableName,
		java.lang.String pk);

	public java.lang.Boolean checkExistenceOfKeyId(long headId,
		java.lang.String pk);

	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList);

	public java.lang.Boolean checkKeyPairInRelationship(long headId,
		java.lang.String pk1, java.lang.String pk2);

	public org.json.simple.JSONObject constructContentJson(
		org.gfbio.model.Content content);

	public org.json.simple.JSONObject constructContentJson(long contentId,
		long headId, long columnId, long rowId, java.lang.String cellContent,
		java.util.Date lastModifiedDate);

	public org.json.simple.JSONArray constructContenRowInputJson(
		java.lang.String tableName, long contentId, long rowId,
		org.json.simple.JSONObject rowInformationJson);

	public long constructNewId();

	public org.json.simple.JSONArray createContent(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray createContentWithTS(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray createContentRow(
		org.json.simple.JSONArray requestJson);

	public org.json.simple.JSONArray updateContent(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray updateContentWithTS(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray updateContentRow(
		org.json.simple.JSONArray requestJson);

	public long updateKernalContent(long headId, long columnId, long contentId,
		java.lang.String cellContent);

	public long updateKernelContent(long headId, long columnId, long contentId,
		long rowId, java.lang.String cellContent);

	public long updateRowTimeStamp(long headId, long rowId, long contentId);

	public org.json.simple.JSONObject updateContent(long headId, long columnId,
		long contentId, long rowId, java.lang.String cellContent,
		long tsContentId);

	public long updateContent2(org.json.simple.JSONObject json);
}