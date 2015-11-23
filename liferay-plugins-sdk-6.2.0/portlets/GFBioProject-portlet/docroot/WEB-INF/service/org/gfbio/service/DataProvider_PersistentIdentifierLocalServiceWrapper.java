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
 * Provides a wrapper for {@link DataProvider_PersistentIdentifierLocalService}.
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifierLocalService
 * @generated
 */
public class DataProvider_PersistentIdentifierLocalServiceWrapper
	implements DataProvider_PersistentIdentifierLocalService,
		ServiceWrapper<DataProvider_PersistentIdentifierLocalService> {
	public DataProvider_PersistentIdentifierLocalServiceWrapper(
		DataProvider_PersistentIdentifierLocalService dataProvider_PersistentIdentifierLocalService) {
		_dataProvider_PersistentIdentifierLocalService = dataProvider_PersistentIdentifierLocalService;
	}

	/**
	* Adds the data provider_ persistent identifier to the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider_PersistentIdentifier the data provider_ persistent identifier
	* @return the data provider_ persistent identifier that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier addDataProvider_PersistentIdentifier(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.addDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifier);
	}

	/**
	* Creates a new data provider_ persistent identifier with the primary key. Does not add the data provider_ persistent identifier to the database.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key for the new data provider_ persistent identifier
	* @return the new data provider_ persistent identifier
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier createDataProvider_PersistentIdentifier(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK) {
		return _dataProvider_PersistentIdentifierLocalService.createDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifierPK);
	}

	/**
	* Deletes the data provider_ persistent identifier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	* @return the data provider_ persistent identifier that was removed
	* @throws PortalException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier deleteDataProvider_PersistentIdentifier(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.deleteDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifierPK);
	}

	/**
	* Deletes the data provider_ persistent identifier from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider_PersistentIdentifier the data provider_ persistent identifier
	* @return the data provider_ persistent identifier that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier deleteDataProvider_PersistentIdentifier(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.deleteDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifier);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataProvider_PersistentIdentifierLocalService.dynamicQuery();
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
		return _dataProvider_PersistentIdentifierLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataProvider_PersistentIdentifierLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dataProvider_PersistentIdentifierLocalService.dynamicQuery(dynamicQuery,
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
		return _dataProvider_PersistentIdentifierLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dataProvider_PersistentIdentifierLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchDataProvider_PersistentIdentifier(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.fetchDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifierPK);
	}

	/**
	* Returns the data provider_ persistent identifier with the primary key.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	* @return the data provider_ persistent identifier
	* @throws PortalException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier getDataProvider_PersistentIdentifier(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.getDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifierPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the data provider_ persistent identifiers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @return the range of data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> getDataProvider_PersistentIdentifiers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.getDataProvider_PersistentIdentifiers(start,
			end);
	}

	/**
	* Returns the number of data provider_ persistent identifiers.
	*
	* @return the number of data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDataProvider_PersistentIdentifiersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.getDataProvider_PersistentIdentifiersCount();
	}

	/**
	* Updates the data provider_ persistent identifier in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dataProvider_PersistentIdentifier the data provider_ persistent identifier
	* @return the data provider_ persistent identifier that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.DataProvider_PersistentIdentifier updateDataProvider_PersistentIdentifier(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dataProvider_PersistentIdentifierLocalService.updateDataProvider_PersistentIdentifier(dataProvider_PersistentIdentifier);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dataProvider_PersistentIdentifierLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dataProvider_PersistentIdentifierLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dataProvider_PersistentIdentifierLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List getDataProviderIds(long persistentIdentiferId) {
		return _dataProvider_PersistentIdentifierLocalService.getDataProviderIds(persistentIdentiferId);
	}

	@Override
	public java.util.List getPersistentIdentiferIds(long dataProviderId) {
		return _dataProvider_PersistentIdentifierLocalService.getPersistentIdentiferIds(dataProviderId);
	}

	@Override
	public java.lang.Boolean updateDataProvider_PersistentIdentifier(
		long dataProviderId, long persistentIdentifierId) {
		return _dataProvider_PersistentIdentifierLocalService.updateDataProvider_PersistentIdentifier(dataProviderId,
			persistentIdentifierId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DataProvider_PersistentIdentifierLocalService getWrappedDataProvider_PersistentIdentifierLocalService() {
		return _dataProvider_PersistentIdentifierLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDataProvider_PersistentIdentifierLocalService(
		DataProvider_PersistentIdentifierLocalService dataProvider_PersistentIdentifierLocalService) {
		_dataProvider_PersistentIdentifierLocalService = dataProvider_PersistentIdentifierLocalService;
	}

	@Override
	public DataProvider_PersistentIdentifierLocalService getWrappedService() {
		return _dataProvider_PersistentIdentifierLocalService;
	}

	@Override
	public void setWrappedService(
		DataProvider_PersistentIdentifierLocalService dataProvider_PersistentIdentifierLocalService) {
		_dataProvider_PersistentIdentifierLocalService = dataProvider_PersistentIdentifierLocalService;
	}

	private DataProvider_PersistentIdentifierLocalService _dataProvider_PersistentIdentifierLocalService;
}