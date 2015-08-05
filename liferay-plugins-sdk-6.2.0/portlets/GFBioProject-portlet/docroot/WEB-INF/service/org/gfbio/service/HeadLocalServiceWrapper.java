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

package org.gfbio.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HeadLocalService}.
 *
 * @author Marcel Froemming
 * @see HeadLocalService
 * @generated
 */
public class HeadLocalServiceWrapper implements HeadLocalService,
	ServiceWrapper<HeadLocalService> {
	public HeadLocalServiceWrapper(HeadLocalService headLocalService) {
		_headLocalService = headLocalService;
	}

	/**
	* Adds the head to the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Head addHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.addHead(head);
	}

	/**
	* Creates a new head with the primary key. Does not add the head to the database.
	*
	* @param headID the primary key for the new head
	* @return the new head
	*/
	@Override
	public org.gfbio.model.Head createHead(long headID) {
		return _headLocalService.createHead(headID);
	}

	/**
	* Deletes the head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param headID the primary key of the head
	* @return the head that was removed
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Head deleteHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.deleteHead(headID);
	}

	/**
	* Deletes the head from the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Head deleteHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.deleteHead(head);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _headLocalService.dynamicQuery();
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
		return _headLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _headLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _headLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _headLocalService.dynamicQueryCount(dynamicQuery);
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
		return _headLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Head fetchHead(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.fetchHead(headID);
	}

	/**
	* Returns the head with the primary key.
	*
	* @param headID the primary key of the head
	* @return the head
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Head getHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHead(headID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of heads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Head> getHeads(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeads(start, end);
	}

	/**
	* Returns the number of heads.
	*
	* @return the number of heads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHeadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeadsCount();
	}

	/**
	* Updates the head in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Head updateHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.updateHead(head);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _headLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_headLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _headLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONObject constructHeadJson(long headId,
		java.lang.String tableName, java.lang.String tableType) {
		return _headLocalService.constructHeadJson(headId, tableName, tableType);
	}

	@Override
	public void deleteHeadByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_headLocalService.deleteHeadByHeadId(headId);
	}

	@Override
	public void deleteTableByHeadId(long headId) {
		_headLocalService.deleteTableByHeadId(headId);
	}

	@Override
	public java.lang.String[] getArrayOfTableNames(java.lang.String tybleType) {
		return _headLocalService.getArrayOfTableNames(tybleType);
	}

	@Override
	public int getCountOfColumns(long headId) {
		return _headLocalService.getCountOfColumns(headId);
	}

	@Override
	public int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getCountOfRows(headId);
	}

	@Override
	public java.util.List getEntitiesByHeadId(long headId) {
		return _headLocalService.getEntitiesByHeadId(headId);
	}

	@Override
	public java.util.List<org.gfbio.model.Head> getHeadBetweenHeadId(
		int start, int end) {
		return _headLocalService.getHeadBetweenHeadId(start, end);
	}

	@Override
	public org.gfbio.model.Head getHeadById(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getHeadById(headId);
	}

	@Override
	public org.gfbio.model.Head getHeadByTableName(java.lang.String tableName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getHeadByTableName(tableName);
	}

	@Override
	public java.lang.Long getHeadIdByTableName(java.lang.String tableName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getHeadIdByTableName(tableName);
	}

	@Override
	public java.util.List<org.gfbio.model.Head> getHeads()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeads();
	}

	@Override
	public java.util.List<org.gfbio.model.Head> getHeadsByTableType(
		java.lang.String tableType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeadsByTableType(tableType);
	}

	@Override
	public long[][] getTableAsArray(long headId) {
		return _headLocalService.getTableAsArray(headId);
	}

	@Override
	public java.lang.String getTableName(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getTableName(headId);
	}

	@Override
	public java.lang.String[] getTableNameArray(java.lang.String tableType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getTableNameArray(tableType);
	}

	@Override
	public java.lang.String[] getTableNameArray(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getTableNameArray(headList);
	}

	@Override
	public java.lang.Boolean updateHead(long headId,
		java.lang.String tableName, java.lang.String tableType) {
		return _headLocalService.updateHead(headId, tableName, tableType);
	}

	@Override
	public java.lang.Boolean updateHead(org.json.simple.JSONObject json) {
		return _headLocalService.updateHead(json);
	}

	@Override
	public java.lang.Boolean updateHeadWithColumns(
		org.json.simple.JSONObject json) {
		return _headLocalService.updateHeadWithColumns(json);
	}

	@Override
	public java.lang.Boolean updateTable(org.json.simple.JSONObject json) {
		return _headLocalService.updateTable(json);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HeadLocalService getWrappedHeadLocalService() {
		return _headLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHeadLocalService(HeadLocalService headLocalService) {
		_headLocalService = headLocalService;
	}

	@Override
	public HeadLocalService getWrappedService() {
		return _headLocalService;
	}

	@Override
	public void setWrappedService(HeadLocalService headLocalService) {
		_headLocalService = headLocalService;
	}

	private HeadLocalService _headLocalService;
}