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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Head. This utility wraps
 * {@link org.gfbio.service.impl.HeadLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see HeadLocalService
 * @see org.gfbio.service.base.HeadLocalServiceBaseImpl
 * @see org.gfbio.service.impl.HeadLocalServiceImpl
 * @generated
 */
public class HeadLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.HeadLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the head to the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head addHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHead(head);
	}

	/**
	* Creates a new head with the primary key. Does not add the head to the database.
	*
	* @param headID the primary key for the new head
	* @return the new head
	*/
	public static org.gfbio.model.Head createHead(long headID) {
		return getService().createHead(headID);
	}

	/**
	* Deletes the head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param headID the primary key of the head
	* @return the head that was removed
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head deleteHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHead(headID);
	}

	/**
	* Deletes the head from the database. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head deleteHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteHead(head);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Head fetchHead(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHead(headID);
	}

	/**
	* Returns the head with the primary key.
	*
	* @param headID the primary key of the head
	* @return the head
	* @throws PortalException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head getHead(long headID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHead(headID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.Head> getHeads(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeads(start, end);
	}

	/**
	* Returns the number of heads.
	*
	* @return the number of heads
	* @throws SystemException if a system exception occurred
	*/
	public static int getHeadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeadsCount();
	}

	/**
	* Updates the head in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param head the head
	* @return the head that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head updateHead(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHead(head);
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

	public static void deleteHeadByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHeadByHeadId(headId);
	}

	public static void deleteTableByHeadId(long headId) {
		getService().deleteTableByHeadId(headId);
	}

	public static void deleteTableByHeadIdWithoutCheck(long headId) {
		getService().deleteTableByHeadIdWithoutCheck(headId);
	}

	public static java.lang.String[] getArrayOfTableNames(
		java.lang.String tableType) {
		return getService().getArrayOfTableNames(tableType);
	}

	public static int getCountOfColumns(long headId) {
		return getService().getCountOfColumns(headId);
	}

	public static int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountOfRows(headId);
	}

	public static java.util.List getEntitiesByHeadId(long headId) {
		return getService().getEntitiesByHeadId(headId);
	}

	public static java.util.List<org.gfbio.model.Head> getHeadBetweenHeadId(
		int start, int end) {
		return getService().getHeadBetweenHeadId(start, end);
	}

	public static org.gfbio.model.Head getHeadById(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadById(headId);
	}

	public static org.gfbio.model.Head getHeadByTableName(
		java.lang.String tableName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadByTableName(tableName);
	}

	public static java.lang.Long getHeadIdByTableName(
		java.lang.String tableName)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getHeadIdByTableName(tableName);
	}

	public static java.util.List<org.gfbio.model.Head> getHeads()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeads();
	}

	public static java.util.List<org.gfbio.model.Head> getHeadsByTableType(
		java.lang.String tableType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeadsByTableType(tableType);
	}

	public static long[][] getIdTableAsArray(long headId) {
		return getService().getIdTableAsArray(headId);
	}

	public static java.lang.String[][] getTableAsArray(long headId) {
		return getService().getTableAsArray(headId);
	}

	public static java.lang.String getTableName(long headId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getService().getTableName(headId);
	}

	public static java.lang.String[] getTableNameArray(
		java.lang.String tableType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTableNameArray(tableType);
	}

	public static java.lang.String[] getTableNameArray(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTableNameArray(headList);
	}

	public static org.json.simple.JSONObject constructHeadJson(long headId,
		java.lang.String tableName, java.lang.String tableType) {
		return getService().constructHeadJson(headId, tableName, tableType);
	}

	public static java.lang.String constructRelationName(
		java.lang.String mtable, java.lang.String ntable) {
		return getService().constructRelationName(mtable, ntable);
	}

	public static java.lang.Boolean updateHead(long headId,
		java.lang.String tableName, java.lang.String tableType) {
		return getService().updateHead(headId, tableName, tableType);
	}

	public static java.lang.Boolean updateHead(org.json.simple.JSONObject json) {
		return getService().updateHead(json);
	}

	public static long updateHeadWithLongRequest(
		org.json.simple.JSONObject json) {
		return getService().updateHeadWithLongRequest(json);
	}

	public static long updateHeadWithLongRequest(long headId,
		java.lang.String tableName, java.lang.String tableType) {
		return getService()
				   .updateHeadWithLongRequest(headId, tableName, tableType);
	}

	public static java.lang.Boolean updateHeadWithColumns(
		org.json.simple.JSONObject json) {
		return getService().updateHeadWithColumns(json);
	}

	public static java.lang.Boolean updateHeadWithColumns2(
		org.json.simple.JSONObject json) {
		return getService().updateHeadWithColumns2(json);
	}

	public static java.lang.Boolean updateRelationTable(long headId,
		java.lang.String mtable, java.lang.String ntable) {
		return getService().updateRelationTable(headId, mtable, ntable);
	}

	public static java.lang.Boolean updateRelationTableWithContent(
		long headId1, long headId2, long contentId1, long contentId2) {
		return getService()
				   .updateRelationTableWithContent(headId1, headId2,
			contentId1, contentId2);
	}

	public static java.lang.Boolean updateTable(org.json.simple.JSONObject json) {
		return getService().updateTable(json);
	}

	public static void clearService() {
		_service = null;
	}

	public static HeadLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HeadLocalService.class.getName());

			if (invokableLocalService instanceof HeadLocalService) {
				_service = (HeadLocalService)invokableLocalService;
			}
			else {
				_service = new HeadLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(HeadLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(HeadLocalService service) {
	}

	private static HeadLocalService _service;
}