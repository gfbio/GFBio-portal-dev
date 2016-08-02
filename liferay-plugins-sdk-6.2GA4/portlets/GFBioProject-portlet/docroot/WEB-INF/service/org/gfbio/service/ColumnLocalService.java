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
 * Provides the local service interface for Column. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcel Froemming
 * @see ColumnLocalServiceUtil
 * @see org.gfbio.service.base.ColumnLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ColumnLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ColumnLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColumnLocalServiceUtil} to access the column local service. Add custom service methods to {@link org.gfbio.service.impl.ColumnLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the column to the database. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Column addColumn(org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new column with the primary key. Does not add the column to the database.
	*
	* @param columnID the primary key for the new column
	* @return the new column
	*/
	public org.gfbio.model.Column createColumn(long columnID);

	/**
	* Deletes the column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param columnID the primary key of the column
	* @return the column that was removed
	* @throws PortalException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Column deleteColumn(long columnID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the column from the database. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Column deleteColumn(org.gfbio.model.Column column)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public org.gfbio.model.Column fetchColumn(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the column with the primary key.
	*
	* @param columnID the primary key of the column
	* @return the column
	* @throws PortalException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Column getColumn(long columnID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @return the range of columns
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Column> getColumns(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of columns.
	*
	* @return the number of columns
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getColumnsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the column in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Column updateColumn(org.gfbio.model.Column column)
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

	/**
	* Delete all column entries of a specific head.
	*
	* @param headId        from type long, is the PK of entity gfbio_head
	*/
	public void deleteColumnsByHeadId(long headId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getColumnIdByNames(java.lang.String tableName,
		java.lang.String columnName);

	/**
	* Returns the name of a column entry.
	*
	* @param columnId    from type long, is the PK of entity gfbio_column
	* @returns name        from type String, is the content of attribute 'column_name' of entity gfbio_column
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getColumnNameById(long columnId);

	/**
	* Returns all column entries, that have a specific content of attribute 'headid' of entity gfbio_column
	*
	* @param headId    from type long, is a foreign key of entity gfbio_column to entity gfbio_head
	* @return List from type Column, consists of all column entries with a specific HeadID
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Column> getColumnsByHeadId(
		long headId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all column entries, that have table type 'relationship' (table type is a attribute in entity gfbio_head) and a specific content of attribute 'column_name' of entity gfbio_column. This method was written to find specific columns per 'table_names' (attribute in gfbio_head, that is the column name in relationship tables)
	*
	* @param columnName    from type String, is a specific content of attribute 'column_name' of entity content
	* @return List from type Column, consists of all columns, that have table type 'relationship' and the parameter columnName are equal to the content of attribute 'column_name' of entity gfbio_column
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Column> getColumnsWithRelation(
		java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountofColumns(long headId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getHeadIdById(long columnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getHeadIdsByColumnName(java.lang.String columnName);

	/**
	* Returns all head id's of entries of entity gfbio_head, that have no table type 'relationship' (table type is a attribute in entity gfbio_head) and have a column with a specific name
	*
	* @param columnName    from type String, is a specific content of attribute 'column_name' of entity gfbio_content
	* @return List from type long, consists of head id's
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getHeadIdsWithoutRelationshipsByColumnName(
		java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMaxCountofColumns(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Boolean checkHaveTableRelationsById(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	public java.lang.Boolean checkHaveTableRelationsByName(
		java.lang.String tableName);

	public org.json.simple.JSONObject constructColumnJson(long columnId,
		long headId, java.lang.String columnName);

	public java.lang.Boolean updateColumn(long columnId, long headId,
		java.lang.String content);

	public java.lang.Boolean updateColumn(org.json.simple.JSONObject json);

	public java.lang.Boolean updateColumnWithContents(
		org.json.simple.JSONObject json);

	public java.lang.Boolean updateColumnWithContents2(
		org.json.simple.JSONObject json);
}