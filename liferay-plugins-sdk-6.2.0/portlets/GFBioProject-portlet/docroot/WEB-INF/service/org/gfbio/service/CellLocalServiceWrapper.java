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
 * Provides a wrapper for {@link CellLocalService}.
 *
 * @author Marcel Froemming
 * @see CellLocalService
 * @generated
 */
public class CellLocalServiceWrapper implements CellLocalService,
	ServiceWrapper<CellLocalService> {
	public CellLocalServiceWrapper(CellLocalService cellLocalService) {
		_cellLocalService = cellLocalService;
	}

	/**
	* Adds the cell to the database. Also notifies the appropriate model listeners.
	*
	* @param cell the cell
	* @return the cell that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell addCell(org.gfbio.model.Cell cell)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.addCell(cell);
	}

	/**
	* Creates a new cell with the primary key. Does not add the cell to the database.
	*
	* @param cellID the primary key for the new cell
	* @return the new cell
	*/
	@Override
	public org.gfbio.model.Cell createCell(long cellID) {
		return _cellLocalService.createCell(cellID);
	}

	/**
	* Deletes the cell with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cellID the primary key of the cell
	* @return the cell that was removed
	* @throws PortalException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell deleteCell(long cellID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.deleteCell(cellID);
	}

	/**
	* Deletes the cell from the database. Also notifies the appropriate model listeners.
	*
	* @param cell the cell
	* @return the cell that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell deleteCell(org.gfbio.model.Cell cell)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.deleteCell(cell);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cellLocalService.dynamicQuery();
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
		return _cellLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cellLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cellLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cellLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cellLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Cell fetchCell(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.fetchCell(cellID);
	}

	/**
	* Returns the cell with the primary key.
	*
	* @param cellID the primary key of the cell
	* @return the cell
	* @throws PortalException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell getCell(long cellID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.getCell(cellID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cells.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cells
	* @param end the upper bound of the range of cells (not inclusive)
	* @return the range of cells
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Cell> getCells(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.getCells(start, end);
	}

	/**
	* Returns the number of cells.
	*
	* @return the number of cells
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCellsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.getCellsCount();
	}

	/**
	* Updates the cell in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cell the cell
	* @return the cell that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell updateCell(org.gfbio.model.Cell cell)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.updateCell(cell);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cellLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cellLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cellLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.gfbio.model.Cell> getCellsByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cellLocalService.getCellsByTask(task);
	}

	@Override
	public org.gfbio.model.Cell getCellById(long cellId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return _cellLocalService.getCellById(cellId);
	}

	@Override
	public org.gfbio.model.Cell getCellByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return _cellLocalService.getCellByContent(content);
	}

	@Override
	public java.lang.String getContent(long cellId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return _cellLocalService.getContent(cellId);
	}

	@Override
	public java.lang.Boolean updateCell(long cellId, java.lang.String task,
		java.lang.String content) {
		return _cellLocalService.updateCell(cellId, task, content);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CellLocalService getWrappedCellLocalService() {
		return _cellLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCellLocalService(CellLocalService cellLocalService) {
		_cellLocalService = cellLocalService;
	}

	@Override
	public CellLocalService getWrappedService() {
		return _cellLocalService;
	}

	@Override
	public void setWrappedService(CellLocalService cellLocalService) {
		_cellLocalService = cellLocalService;
	}

	private CellLocalService _cellLocalService;
}