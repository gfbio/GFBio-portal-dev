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
 * Provides the local service utility for Column. This utility wraps
 * {@link org.gfbio.service.impl.ColumnLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see ColumnLocalService
 * @see org.gfbio.service.base.ColumnLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ColumnLocalServiceImpl
 * @generated
 */
public class ColumnLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ColumnLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the column to the database. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column addColumn(
		org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addColumn(column);
	}

	/**
	* Creates a new column with the primary key. Does not add the column to the database.
	*
	* @param columnID the primary key for the new column
	* @return the new column
	*/
	public static org.gfbio.model.Column createColumn(long columnID) {
		return getService().createColumn(columnID);
	}

	/**
	* Deletes the column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param columnID the primary key of the column
	* @return the column that was removed
	* @throws PortalException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column deleteColumn(long columnID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteColumn(columnID);
	}

	/**
	* Deletes the column from the database. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column deleteColumn(
		org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteColumn(column);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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

	public static org.gfbio.model.Column fetchColumn(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchColumn(columnID);
	}

	/**
	* Returns the column with the primary key.
	*
	* @param columnID the primary key of the column
	* @return the column
	* @throws PortalException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column getColumn(long columnID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumn(columnID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<org.gfbio.model.Column> getColumns(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumns(start, end);
	}

	/**
	* Returns the number of columns.
	*
	* @return the number of columns
	* @throws SystemException if a system exception occurred
	*/
	public static int getColumnsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumnsCount();
	}

	/**
	* Updates the column in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param column the column
	* @return the column that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column updateColumn(
		org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateColumn(column);
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

	/**
	* Delete all column entries of a specific head.
	*
	* @param headId        from type long, is the PK of entity gfbio_head
	*/
	public static void deleteColumnsByHeadId(long headId) {
		getService().deleteColumnsByHeadId(headId);
	}

	public static long getColumnIdByNames(java.lang.String tableName,
		java.lang.String columnName) {
		return getService().getColumnIdByNames(tableName, columnName);
	}

	/**
	* Returns the name of a column entry.
	*
	* @param columnId    from type long, is the PK of entity gfbio_column
	* @returns name        from type String, is the content of attribute 'column_name' of entity gfbio_column
	*/
	public static java.lang.String getColumnNameById(long columnId) {
		return getService().getColumnNameById(columnId);
	}

	/**
	* Returns all column entries, that have a specific content of attribute 'headid' of entity gfbio_column
	*
	* @param headId    from type long, is a foreign key of entity gfbio_column to entity gfbio_head
	* @return List from type Column, consists of all column entries with a specific HeadID
	*/
	public static java.util.List<org.gfbio.model.Column> getColumnsByHeadId(
		long headId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumnsByHeadId(headId);
	}

	/**
	* Returns all column entries, that have table type 'relationship' (table type is a attribute in entity gfbio_head) and a specific content of attribute 'column_name' of entity gfbio_column. This method was written to find specific columns per 'table_names' (attribute in gfbio_head, that is the column name in relationship tables)
	*
	* @param columnName    from type String, is a specific content of attribute 'column_name' of entity content
	* @return List from type Column, consists of all columns, that have table type 'relationship' and the parameter columnName are equal to the content of attribute 'column_name' of entity gfbio_column
	*/
	public static java.util.List<org.gfbio.model.Column> getColumnsWithRelation(
		java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumnsWithRelation(columnName);
	}

	public static int getCountofColumns(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountofColumns(headId);
	}

	public static long getHeadIdById(long columnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeadIdById(columnId);
	}

	public static java.util.List getHeadIdsByColumnName(
		java.lang.String columnName) {
		return getService().getHeadIdsByColumnName(columnName);
	}

	/**
	* Returns all head id's of entries of entity gfbio_head, that have no table type 'relationship' (table type is a attribute in entity gfbio_head) and have a column with a specific name
	*
	* @param columnName    from type String, is a specific content of attribute 'column_name' of entity gfbio_content
	* @return List from type long, consists of head id's
	*/
	public static java.util.List getHeadIdsWithoutRelationshipsByColumnName(
		java.lang.String columnName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getHeadIdsWithoutRelationshipsByColumnName(columnName);
	}

	public static int getMaxCountofColumns(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaxCountofColumns(headList);
	}

	public static java.lang.Boolean checkExistenceOfColumn(
		java.lang.String tableName, java.lang.String columnName) {
		return getService().checkExistenceOfColumn(tableName, columnName);
	}

	public static java.lang.Boolean checkExistenceOfColumn(long headId,
		java.lang.String columnName) {
		return getService().checkExistenceOfColumn(headId, columnName);
	}

	public static java.lang.Boolean checkHaveTableRelationsById(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().checkHaveTableRelationsById(headId);
	}

	public static java.lang.Boolean checkHaveTableRelationsByName(
		java.lang.String tableName) {
		return getService().checkHaveTableRelationsByName(tableName);
	}

	public static org.json.simple.JSONObject constructColumnJson(
		org.gfbio.model.Column column) {
		return getService().constructColumnJson(column);
	}

	public static org.json.simple.JSONObject constructColumnJson(
		long columnId, long headId, java.lang.String columnName,
		java.util.Date lastModifiedDate) {
		return getService()
				   .constructColumnJson(columnId, headId, columnName,
			lastModifiedDate);
	}

	public static long constructNewId() {
		return getService().constructNewId();
	}

	public static java.lang.Boolean updateColumn(long columnId, long headId,
		java.lang.String content) {
		return getService().updateColumn(columnId, headId, content);
	}

	public static java.lang.Boolean updateColumn(
		org.json.simple.JSONObject json) {
		return getService().updateColumn(json);
	}

	public static org.json.simple.JSONArray updateColumnWithContents(
		org.json.simple.JSONObject json) {
		return getService().updateColumnWithContents(json);
	}

	public static org.json.simple.JSONArray updateColumnWithContents2(
		org.json.simple.JSONObject json) {
		return getService().updateColumnWithContents2(json);
	}

	public static void clearService() {
		_service = null;
	}

	public static ColumnLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ColumnLocalService.class.getName());

			if (invokableLocalService instanceof ColumnLocalService) {
				_service = (ColumnLocalService)invokableLocalService;
			}
			else {
				_service = new ColumnLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ColumnLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ColumnLocalService service) {
	}

	private static ColumnLocalService _service;
}