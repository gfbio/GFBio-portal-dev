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
 * Provides a wrapper for {@link PrimaryDataLocalService}.
 *
 * @author Marcel Froemming
 * @see PrimaryDataLocalService
 * @generated
 */
public class PrimaryDataLocalServiceWrapper implements PrimaryDataLocalService,
	ServiceWrapper<PrimaryDataLocalService> {
	public PrimaryDataLocalServiceWrapper(
		PrimaryDataLocalService primaryDataLocalService) {
		_primaryDataLocalService = primaryDataLocalService;
	}

	/**
	* Adds the primary data to the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData the primary data
	* @return the primary data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData addPrimaryData(
		org.gfbio.model.PrimaryData primaryData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.addPrimaryData(primaryData);
	}

	/**
	* Creates a new primary data with the primary key. Does not add the primary data to the database.
	*
	* @param primaryDataID the primary key for the new primary data
	* @return the new primary data
	*/
	@Override
	public org.gfbio.model.PrimaryData createPrimaryData(long primaryDataID) {
		return _primaryDataLocalService.createPrimaryData(primaryDataID);
	}

	/**
	* Deletes the primary data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryDataID the primary key of the primary data
	* @return the primary data that was removed
	* @throws PortalException if a primary data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData deletePrimaryData(long primaryDataID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.deletePrimaryData(primaryDataID);
	}

	/**
	* Deletes the primary data from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData the primary data
	* @return the primary data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData deletePrimaryData(
		org.gfbio.model.PrimaryData primaryData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.deletePrimaryData(primaryData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _primaryDataLocalService.dynamicQuery();
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
		return _primaryDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _primaryDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _primaryDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _primaryDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _primaryDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.PrimaryData fetchPrimaryData(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.fetchPrimaryData(primaryDataID);
	}

	/**
	* Returns the primary data with the primary key.
	*
	* @param primaryDataID the primary key of the primary data
	* @return the primary data
	* @throws PortalException if a primary data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData getPrimaryData(long primaryDataID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.getPrimaryData(primaryDataID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of primary datas
	* @param end the upper bound of the range of primary datas (not inclusive)
	* @return the range of primary datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.PrimaryData> getPrimaryDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.getPrimaryDatas(start, end);
	}

	/**
	* Returns the number of primary datas.
	*
	* @return the number of primary datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPrimaryDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.getPrimaryDatasCount();
	}

	/**
	* Updates the primary data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primaryData the primary data
	* @return the primary data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData updatePrimaryData(
		org.gfbio.model.PrimaryData primaryData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryDataLocalService.updatePrimaryData(primaryData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _primaryDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primaryDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primaryDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONObject getPrimaryDataById(
		org.json.simple.JSONObject requestJson) {
		return _primaryDataLocalService.getPrimaryDataById(requestJson);
	}

	@Override
	public java.lang.String getPathByPrimaryDataId(long primaryDataId) {
		return _primaryDataLocalService.getPathByPrimaryDataId(primaryDataId);
	}

	@Override
	public java.lang.String checkPath(java.lang.String name,
		java.lang.String path) {
		return _primaryDataLocalService.checkPath(name, path);
	}

	@Override
	public java.lang.Boolean checkPrimaryDataExists(java.lang.String name,
		java.lang.String path) {
		return _primaryDataLocalService.checkPrimaryDataExists(name, path);
	}

	@Override
	public long constructNewId() {
		return _primaryDataLocalService.constructNewId();
	}

	@Override
	public org.json.simple.JSONArray createPrimaryData(
		org.json.simple.JSONArray requestJson) {
		return _primaryDataLocalService.createPrimaryData(requestJson);
	}

	@Override
	public org.json.simple.JSONObject createPrimaryData(
		org.json.simple.JSONObject requestJson) {
		return _primaryDataLocalService.createPrimaryData(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PrimaryDataLocalService getWrappedPrimaryDataLocalService() {
		return _primaryDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPrimaryDataLocalService(
		PrimaryDataLocalService primaryDataLocalService) {
		_primaryDataLocalService = primaryDataLocalService;
	}

	@Override
	public PrimaryDataLocalService getWrappedService() {
		return _primaryDataLocalService;
	}

	@Override
	public void setWrappedService(
		PrimaryDataLocalService primaryDataLocalService) {
		_primaryDataLocalService = primaryDataLocalService;
	}

	private PrimaryDataLocalService _primaryDataLocalService;
}