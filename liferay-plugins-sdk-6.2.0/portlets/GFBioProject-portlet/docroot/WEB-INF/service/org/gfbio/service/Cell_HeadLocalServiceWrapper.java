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
 * Provides a wrapper for {@link Cell_HeadLocalService}.
 *
 * @author Marcel Froemming
 * @see Cell_HeadLocalService
 * @generated
 */
public class Cell_HeadLocalServiceWrapper implements Cell_HeadLocalService,
	ServiceWrapper<Cell_HeadLocalService> {
	public Cell_HeadLocalServiceWrapper(
		Cell_HeadLocalService cell_HeadLocalService) {
		_cell_HeadLocalService = cell_HeadLocalService;
	}

	/**
	* Adds the cell_ head to the database. Also notifies the appropriate model listeners.
	*
	* @param cell_Head the cell_ head
	* @return the cell_ head that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell_Head addCell_Head(
		org.gfbio.model.Cell_Head cell_Head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.addCell_Head(cell_Head);
	}

	/**
	* Creates a new cell_ head with the primary key. Does not add the cell_ head to the database.
	*
	* @param cell_HeadPK the primary key for the new cell_ head
	* @return the new cell_ head
	*/
	@Override
	public org.gfbio.model.Cell_Head createCell_Head(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK) {
		return _cell_HeadLocalService.createCell_Head(cell_HeadPK);
	}

	/**
	* Deletes the cell_ head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head that was removed
	* @throws PortalException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell_Head deleteCell_Head(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.deleteCell_Head(cell_HeadPK);
	}

	/**
	* Deletes the cell_ head from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_Head the cell_ head
	* @return the cell_ head that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell_Head deleteCell_Head(
		org.gfbio.model.Cell_Head cell_Head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.deleteCell_Head(cell_Head);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cell_HeadLocalService.dynamicQuery();
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
		return _cell_HeadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cell_HeadLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cell_HeadLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cell_HeadLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cell_HeadLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Cell_Head fetchCell_Head(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.fetchCell_Head(cell_HeadPK);
	}

	/**
	* Returns the cell_ head with the primary key.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head
	* @throws PortalException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell_Head getCell_Head(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.getCell_Head(cell_HeadPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cell_ heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @return the range of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Cell_Head> getCell_Heads(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.getCell_Heads(start, end);
	}

	/**
	* Returns the number of cell_ heads.
	*
	* @return the number of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCell_HeadsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.getCell_HeadsCount();
	}

	/**
	* Updates the cell_ head in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cell_Head the cell_ head
	* @return the cell_ head that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Cell_Head updateCell_Head(
		org.gfbio.model.Cell_Head cell_Head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cell_HeadLocalService.updateCell_Head(cell_Head);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cell_HeadLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cell_HeadLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cell_HeadLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Cell_HeadLocalService getWrappedCell_HeadLocalService() {
		return _cell_HeadLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCell_HeadLocalService(
		Cell_HeadLocalService cell_HeadLocalService) {
		_cell_HeadLocalService = cell_HeadLocalService;
	}

	@Override
	public Cell_HeadLocalService getWrappedService() {
		return _cell_HeadLocalService;
	}

	@Override
	public void setWrappedService(Cell_HeadLocalService cell_HeadLocalService) {
		_cell_HeadLocalService = cell_HeadLocalService;
	}

	private Cell_HeadLocalService _cell_HeadLocalService;
}