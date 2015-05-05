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
 * @author Felicitas Loeffler
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
	public int getColumnCount(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getColumnCount(headID);
	}

	@Override
	public java.lang.String getColumnName(long headID, int i)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getColumnName(headID, i);
	}

	@Override
	public java.lang.Long getHeadID(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getHeadID(name);
	}

	@Override
	public java.util.List<org.gfbio.model.Head> getHeadList()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeadList();
	}

	@Override
	public java.util.List<org.gfbio.model.Head> getHeadList(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getHeadList(task);
	}

	@Override
	public java.lang.String getName(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getName(headID);
	}

	@Override
	public java.lang.String[] getNameArray(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getNameArray(task);
	}

	@Override
	public java.lang.String[] getNameArray(
		java.util.List<org.gfbio.model.Head> headList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.getNameArray(headList);
	}

	@Override
	public org.gfbio.model.Head getRow(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getRow(headID);
	}

	@Override
	public org.gfbio.model.Head getRow(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return _headLocalService.getRow(name);
	}

	@Override
	public java.lang.Boolean setStandard()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.setStandard();
	}

	@Override
	public java.lang.Boolean updateHead(long headID, java.lang.String name,
		java.lang.String task, java.lang.String column01,
		java.lang.String column02, java.lang.String column03,
		java.lang.String column04, java.lang.String column05,
		java.lang.String column06, java.lang.String column07,
		java.lang.String column08, java.lang.String column09,
		java.lang.String column10, java.lang.String column11,
		java.lang.String column12, java.lang.String column13,
		java.lang.String column14, java.lang.String column15,
		java.lang.String column16, java.lang.String column17,
		java.lang.String column18, java.lang.String column19,
		java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headLocalService.updateHead(headID, name, task, column01,
			column02, column03, column04, column05, column06, column07,
			column08, column09, column10, column11, column12, column13,
			column14, column15, column16, column17, column18, column19, column20);
	}

	@Override
	public java.lang.Boolean updateRelationTable(long headID,
		java.lang.String mtable, java.lang.String ntable)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException, org.gfbio.NoSuchPositionException {
		return _headLocalService.updateRelationTable(headID, mtable, ntable);
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