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
 * Provides a wrapper for {@link PositionLocalService}.
 *
 * @author Marcel Froemming
 * @see PositionLocalService
 * @generated
 */
public class PositionLocalServiceWrapper implements PositionLocalService,
	ServiceWrapper<PositionLocalService> {
	public PositionLocalServiceWrapper(
		PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	/**
	* Adds the position to the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position addPosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.addPosition(position);
	}

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	@Override
	public org.gfbio.model.Position createPosition(long positionID) {
		return _positionLocalService.createPosition(positionID);
	}

	/**
	* Deletes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position deletePosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.deletePosition(positionID);
	}

	/**
	* Deletes the position from the database. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position deletePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.deletePosition(position);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _positionLocalService.dynamicQuery();
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
		return _positionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _positionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _positionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Position fetchPosition(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.fetchPosition(positionID);
	}

	/**
	* Returns the position with the primary key.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws PortalException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position getPosition(long positionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPosition(positionID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.gfbio.model.Position> getPositions(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositions(start, end);
	}

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPositionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsCount();
	}

	/**
	* Updates the position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param position the position
	* @return the position that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Position updatePosition(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.updatePosition(position);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _positionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_positionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _positionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void deletePositionById(long positionId) {
		_positionLocalService.deletePositionById(positionId);
	}

	@Override
	public void deletePositionsByColumnId(long columnId) {
		_positionLocalService.deletePositionsByColumnId(columnId);
	}

	@Override
	public void deleteCompletePositionsByHeadId(long headId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_positionLocalService.deleteCompletePositionsByHeadId(headId);
	}

	@Override
	public void deletePositionsByRowId(long rowId) {
		_positionLocalService.deletePositionsByRowId(rowId);
	}

	@Override
	public int getCountOfColumns(long rowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getCountOfColumns(rowId);
	}

	@Override
	public int getCountOfRows(long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getCountOfRows(columnId);
	}

	@Override
	public org.gfbio.model.Position getPositionById(long positionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException {
		return _positionLocalService.getPositionById(positionId);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsByColumnId(
		long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsByColumnId(columnId);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsByHeadId(
		long headId) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsByHeadId(headId);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsByRowId(
		long rowId) throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsByRowId(rowId);
	}

	@Override
	public org.json.simple.JSONObject getPositionInformationAsJSONByRowId(
		long rowId) {
		return _positionLocalService.getPositionInformationAsJSONByRowId(rowId);
	}

	@Override
	public org.json.simple.JSONObject getPositionsAsJSONByRowId(long rowId) {
		return _positionLocalService.getPositionsAsJSONByRowId(rowId);
	}

	@Override
	public long getColumnIdById(long positionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getColumnIdById(positionId);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsByContent(
		java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsByContent(content);
	}

	@Override
	public java.util.List<org.gfbio.model.Position> getPositionsByContentOfColumn(
		java.lang.String content, long columnId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getPositionsByContentOfColumn(content,
			columnId);
	}

	@Override
	public long getRowIdById(long positionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _positionLocalService.getRowIdById(positionId);
	}

	@Override
	public java.lang.String getContentByTableIds(long columnId, int rowId) {
		return _positionLocalService.getContentByTableIds(columnId, rowId);
	}

	@Override
	public java.lang.Boolean updatePosition(long positionId, long headId,
		long columnId, long rowId, java.lang.String content) {
		return _positionLocalService.updatePosition(positionId, headId,
			columnId, rowId, content);
	}

	@Override
	public java.lang.Boolean updatePosition(org.json.simple.JSONObject json) {
		return _positionLocalService.updatePosition(json);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PositionLocalService getWrappedPositionLocalService() {
		return _positionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPositionLocalService(
		PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	@Override
	public PositionLocalService getWrappedService() {
		return _positionLocalService;
	}

	@Override
	public void setWrappedService(PositionLocalService positionLocalService) {
		_positionLocalService = positionLocalService;
	}

	private PositionLocalService _positionLocalService;
}