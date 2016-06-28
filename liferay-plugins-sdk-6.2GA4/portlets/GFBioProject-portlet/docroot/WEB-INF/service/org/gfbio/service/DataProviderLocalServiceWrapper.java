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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DataProviderLocalService}.
 *
 * @author Marcel Froemming
 * @see DataProviderLocalService
 * @generated
 */
public class DataProviderLocalServiceWrapper implements DataProviderLocalService,
	ServiceWrapper<DataProviderLocalService> {
	public DataProviderLocalServiceWrapper(
		DataProviderLocalService dataProviderLocalService) {
		_dataProviderLocalService = dataProviderLocalService;
	}

	/**
	* Adds the data provider to the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider the data provider
	* @return the data provider that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider addDataProvider(
		org.gfbio.model.DataProvider dataProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.addDataProvider(dataProvider);
	}

	/**
	* Creates a new data provider with the primary key. Does not add the data provider to the database.
	*
	* @param dataProviderID the primary key for the new data provider
	* @return the new data provider
	*/
	@Override
	public org.gfbio.model.DataProvider createDataProvider(long dataProviderID) {
		return _dataProviderLocalService.createDataProvider(dataProviderID);
	}

	/**
	* Deletes the data provider with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider that was removed
	* @throws PortalException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider deleteDataProvider(long dataProviderID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.deleteDataProvider(dataProviderID);
	}

	/**
	* Deletes the data provider from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider the data provider
	* @return the data provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider deleteDataProvider(
		org.gfbio.model.DataProvider dataProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.deleteDataProvider(dataProvider);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataProviderLocalService.dynamicQuery();
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
		return _dataProviderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataProviderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataProviderLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dataProviderLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dataProviderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.DataProvider fetchDataProvider(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.fetchDataProvider(dataProviderID);
	}

	/**
	* Returns the data provider with the primary key.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider
	* @throws PortalException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider getDataProvider(long dataProviderID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.getDataProvider(dataProviderID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the data providers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @return the range of data providers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.DataProvider> getDataProviders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.getDataProviders(start, end);
	}

	/**
	* Returns the number of data providers.
	*
	* @return the number of data providers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDataProvidersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.getDataProvidersCount();
	}

	/**
	* Updates the data provider in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dataProvider the data provider
	* @return the data provider that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider updateDataProvider(
		org.gfbio.model.DataProvider dataProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProviderLocalService.updateDataProvider(dataProvider);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dataProviderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dataProviderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dataProviderLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONObject getDataProviderById(long dataProviderId) {
		return _dataProviderLocalService.getDataProviderById(dataProviderId);
	}

	@Override
	public org.json.simple.JSONObject getDataProviderByLabel(
		java.lang.String label) {
		return _dataProviderLocalService.getDataProviderByLabel(label);
	}

	@Override
	public long getDataProviderIdByLabel(java.lang.String label) {
		return _dataProviderLocalService.getDataProviderIdByLabel(label);
	}

	@Override
	public java.util.List getDataProviderIds(long persistentIdentiferId) {
		return _dataProviderLocalService.getDataProviderIds(persistentIdentiferId);
	}

	@Override
	public java.util.List getLabels() {
		return _dataProviderLocalService.getLabels();
	}

	@Override
	public java.lang.String getLabelById(long dataProviderId) {
		return _dataProviderLocalService.getLabelById(dataProviderId);
	}

	@Override
	public java.lang.String getNameById(long dataProviderId) {
		return _dataProviderLocalService.getNameById(dataProviderId);
	}

	@Override
	public java.util.List getPersistentIdentiferIds(long dataProviderId) {
		return _dataProviderLocalService.getPersistentIdentiferIds(dataProviderId);
	}

	@Override
	public java.lang.Boolean checkDataProviderLabel(java.lang.String archive) {
		return _dataProviderLocalService.checkDataProviderLabel(archive);
	}

	@Override
	public org.json.simple.JSONObject constructDataProviderAsJson(
		org.gfbio.model.DataProvider dataProvider) {
		return _dataProviderLocalService.constructDataProviderAsJson(dataProvider);
	}

	@Override
	public java.lang.Boolean updateDataProvider(long dataProviderId,
		java.lang.String name, java.lang.String label,
		java.lang.String description, java.lang.String address,
		java.lang.String website, java.lang.String training) {
		return _dataProviderLocalService.updateDataProvider(dataProviderId,
			name, label, description, address, website, training);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DataProviderLocalService getWrappedDataProviderLocalService() {
		return _dataProviderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDataProviderLocalService(
		DataProviderLocalService dataProviderLocalService) {
		_dataProviderLocalService = dataProviderLocalService;
	}

	@Override
	public DataProviderLocalService getWrappedService() {
		return _dataProviderLocalService;
	}

	@Override
	public void setWrappedService(
		DataProviderLocalService dataProviderLocalService) {
		_dataProviderLocalService = dataProviderLocalService;
	}

	private DataProviderLocalService _dataProviderLocalService;
}