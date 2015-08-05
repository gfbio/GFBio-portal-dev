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
 * Provides the local service utility for Position. This utility wraps
 * {@link org.gfbio.service.impl.PositionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see PositionLocalService
 * @see org.gfbio.service.base.PositionLocalServiceBaseImpl
 * @see org.gfbio.service.impl.PositionLocalServiceImpl
 * @generated
 */
public class PositionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.PositionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the position to the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position addPosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPosition(position);
	}

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	public static org.gfbio.model.Position createPosition(long positionID) {
		return getService().createPosition(positionID);
	}

	/**
	* Deletes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position deletePosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePosition(positionID);
	}

	/**
	* Deletes the position from the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position deletePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePosition(position);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Position fetchPosition(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPosition(positionID);
	}

	/**
	* Returns the position with the primary key.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position getPosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPosition(positionID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Position> getPositions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositions(start, end);
	}

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	public static int getPositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsCount();
	}

	/**
	* Updates the position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Position updatePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePosition(position);
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

	public static org.json.simple.JSONObject constructColumnJson(
		long positionId, long headId, long columnId, long rowId,
		java.lang.String content) {
		return getService()
				   .constructColumnJson(positionId, headId, columnId, rowId,
			content);
	}

	public static void deletePositionById(long positionId) {
		getService().deletePositionById(positionId);
	}

	public static void deletePositionsByColumnId(long columnId) {
		getService().deletePositionsByColumnId(columnId);
	}

	public static void deletePositionsByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deletePositionsByHeadId(headId);
	}

	public static void deletePositionsByRowId(long rowId) {
		getService().deletePositionsByRowId(rowId);
	}

	public static java.lang.String getContentByTableIds(long rowId,
		long columnId) {
		return getService().getContentByTableIds(rowId, columnId);
	}

	public static int getCountOfColumns(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountOfColumns(rowId);
	}

	public static int getCountOfRows(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountOfRows(headId);
	}

	public static org.gfbio.model.Position getPositionById(long positionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getService().getPositionById(positionId);
	}

	public static java.util.List<org.gfbio.model.Position> getPositionsByColumnId(
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsByColumnId(columnId);
	}

	public static java.util.List<org.gfbio.model.Position> getPositionsByHeadId(
		long headId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsByHeadId(headId);
	}

	public static long getPositionIdByTableIds(long rowId, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getService().getPositionIdByTableIds(rowId, columnId);
	}

	public static java.util.List<org.gfbio.model.Position> getPositionsByRowId(
		long rowId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsByRowId(rowId);
	}

	public static org.gfbio.model.Position getPositionByTableIds(long rowId,
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return getService().getPositionByTableIds(rowId, columnId);
	}

	public static org.json.simple.JSONObject getPositionInformationAsJSONByRowId(
		long rowId) {
		return getService().getPositionInformationAsJSONByRowId(rowId);
	}

	public static org.json.simple.JSONObject getPositionsAsJSONByRowId(
		long rowId) {
		return getService().getPositionsAsJSONByRowId(rowId);
	}

	public static java.util.List getRowIds(long headId) {
		return getService().getRowIds(headId);
	}

	public static long getColumnIdById(long positionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getColumnIdById(positionId);
	}

	public static java.util.List<org.gfbio.model.Position> getPositionsByContent(
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsByContent(content);
	}

	public static java.util.List<org.gfbio.model.Position> getPositionsByContentOfColumn(
		java.lang.String content, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPositionsByContentOfColumn(content, columnId);
	}

	public static long getRowIdById(long positionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRowIdById(positionId);
	}

	public static java.lang.Boolean updatePosition(long positionId,
		long headId, long columnId, long rowId, java.lang.String content) {
		return getService()
				   .updatePosition(positionId, headId, columnId, rowId, content);
	}

	public static java.lang.Boolean updatePosition(
		org.json.simple.JSONObject json) {
		return getService().updatePosition(json);
	}

	public static void clearService() {
		_service = null;
	}

	public static PositionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PositionLocalService.class.getName());

			if (invokableLocalService instanceof PositionLocalService) {
				_service = (PositionLocalService)invokableLocalService;
			}
			else {
				_service = new PositionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PositionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PositionLocalService service) {
	}

	private static PositionLocalService _service;
}