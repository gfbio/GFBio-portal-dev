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
 * Provides a wrapper for {@link tab_ResearchObjectLocalService}.
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObjectLocalService
 * @generated
 */
public class tab_ResearchObjectLocalServiceWrapper
	implements tab_ResearchObjectLocalService,
		ServiceWrapper<tab_ResearchObjectLocalService> {
	public tab_ResearchObjectLocalServiceWrapper(
		tab_ResearchObjectLocalService tab_ResearchObjectLocalService) {
		_tab_ResearchObjectLocalService = tab_ResearchObjectLocalService;
	}

	/**
	* Adds the tab_ research object to the database. Also notifies the appropriate model listeners.
	*
	* @param tab_ResearchObject the tab_ research object
	* @return the tab_ research object that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject addtab_ResearchObject(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.addtab_ResearchObject(tab_ResearchObject);
	}

	/**
	* Creates a new tab_ research object with the primary key. Does not add the tab_ research object to the database.
	*
	* @param ro_ID the primary key for the new tab_ research object
	* @return the new tab_ research object
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject createtab_ResearchObject(
		long ro_ID) {
		return _tab_ResearchObjectLocalService.createtab_ResearchObject(ro_ID);
	}

	/**
	* Deletes the tab_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object that was removed
	* @throws PortalException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject deletetab_ResearchObject(
		long ro_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.deletetab_ResearchObject(ro_ID);
	}

	/**
	* Deletes the tab_ research object from the database. Also notifies the appropriate model listeners.
	*
	* @param tab_ResearchObject the tab_ research object
	* @return the tab_ research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject deletetab_ResearchObject(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.deletetab_ResearchObject(tab_ResearchObject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tab_ResearchObjectLocalService.dynamicQuery();
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
		return _tab_ResearchObjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tab_ResearchObjectLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tab_ResearchObjectLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tab_ResearchObjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tab_ResearchObjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.tab_ResearchObject fetchtab_ResearchObject(
		long ro_ID) throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.fetchtab_ResearchObject(ro_ID);
	}

	/**
	* Returns the tab_ research object with the primary key.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object
	* @throws PortalException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject gettab_ResearchObject(long ro_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.gettab_ResearchObject(ro_ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tab_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @return the range of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.tab_ResearchObject> gettab_ResearchObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.gettab_ResearchObjects(start, end);
	}

	/**
	* Returns the number of tab_ research objects.
	*
	* @return the number of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int gettab_ResearchObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.gettab_ResearchObjectsCount();
	}

	/**
	* Updates the tab_ research object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tab_ResearchObject the tab_ research object
	* @return the tab_ research object that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.tab_ResearchObject updatetab_ResearchObject(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tab_ResearchObjectLocalService.updatetab_ResearchObject(tab_ResearchObject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tab_ResearchObjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tab_ResearchObjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tab_ResearchObjectLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public tab_ResearchObjectLocalService getWrappedtab_ResearchObjectLocalService() {
		return _tab_ResearchObjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedtab_ResearchObjectLocalService(
		tab_ResearchObjectLocalService tab_ResearchObjectLocalService) {
		_tab_ResearchObjectLocalService = tab_ResearchObjectLocalService;
	}

	@Override
	public tab_ResearchObjectLocalService getWrappedService() {
		return _tab_ResearchObjectLocalService;
	}

	@Override
	public void setWrappedService(
		tab_ResearchObjectLocalService tab_ResearchObjectLocalService) {
		_tab_ResearchObjectLocalService = tab_ResearchObjectLocalService;
	}

	private tab_ResearchObjectLocalService _tab_ResearchObjectLocalService;
}