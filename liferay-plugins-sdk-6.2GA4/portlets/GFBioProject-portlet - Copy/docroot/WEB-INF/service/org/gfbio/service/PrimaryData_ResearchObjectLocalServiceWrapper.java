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
 * Provides a wrapper for {@link PrimaryData_ResearchObjectLocalService}.
 *
 * @author Marcel Froemming
 * @see PrimaryData_ResearchObjectLocalService
 * @generated
 */
public class PrimaryData_ResearchObjectLocalServiceWrapper
	implements PrimaryData_ResearchObjectLocalService,
		ServiceWrapper<PrimaryData_ResearchObjectLocalService> {
	public PrimaryData_ResearchObjectLocalServiceWrapper(
		PrimaryData_ResearchObjectLocalService primaryData_ResearchObjectLocalService) {
		_primaryData_ResearchObjectLocalService = primaryData_ResearchObjectLocalService;
	}

	/**
	* Adds the primary data_ research object to the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData_ResearchObject the primary data_ research object
	* @return the primary data_ research object that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject addPrimaryData_ResearchObject(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.addPrimaryData_ResearchObject(primaryData_ResearchObject);
	}

	/**
	* Creates a new primary data_ research object with the primary key. Does not add the primary data_ research object to the database.
	*
	* @param primaryData_ResearchObjectPK the primary key for the new primary data_ research object
	* @return the new primary data_ research object
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject createPrimaryData_ResearchObject(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK) {
		return _primaryData_ResearchObjectLocalService.createPrimaryData_ResearchObject(primaryData_ResearchObjectPK);
	}

	/**
	* Deletes the primary data_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	* @return the primary data_ research object that was removed
	* @throws PortalException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject deletePrimaryData_ResearchObject(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.deletePrimaryData_ResearchObject(primaryData_ResearchObjectPK);
	}

	/**
	* Deletes the primary data_ research object from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData_ResearchObject the primary data_ research object
	* @return the primary data_ research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject deletePrimaryData_ResearchObject(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.deletePrimaryData_ResearchObject(primaryData_ResearchObject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _primaryData_ResearchObjectLocalService.dynamicQuery();
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
		return _primaryData_ResearchObjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _primaryData_ResearchObjectLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _primaryData_ResearchObjectLocalService.dynamicQuery(dynamicQuery,
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
		return _primaryData_ResearchObjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _primaryData_ResearchObjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.PrimaryData_ResearchObject fetchPrimaryData_ResearchObject(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.fetchPrimaryData_ResearchObject(primaryData_ResearchObjectPK);
	}

	/**
	* Returns the primary data_ research object with the primary key.
	*
	* @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	* @return the primary data_ research object
	* @throws PortalException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject getPrimaryData_ResearchObject(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.getPrimaryData_ResearchObject(primaryData_ResearchObjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary data_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @return the range of primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.PrimaryData_ResearchObject> getPrimaryData_ResearchObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.getPrimaryData_ResearchObjects(start,
			end);
	}

	/**
	* Returns the number of primary data_ research objects.
	*
	* @return the number of primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPrimaryData_ResearchObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.getPrimaryData_ResearchObjectsCount();
	}

	/**
	* Updates the primary data_ research object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primaryData_ResearchObject the primary data_ research object
	* @return the primary data_ research object that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.PrimaryData_ResearchObject updatePrimaryData_ResearchObject(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primaryData_ResearchObjectLocalService.updatePrimaryData_ResearchObject(primaryData_ResearchObject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _primaryData_ResearchObjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primaryData_ResearchObjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primaryData_ResearchObjectLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getPrimaryDatasIdsByResearchObject(
		org.json.simple.JSONObject requestJson) {
		return _primaryData_ResearchObjectLocalService.getPrimaryDatasIdsByResearchObject(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getResearchObjectsByPrimaryDataId(
		org.json.simple.JSONObject requestJson) {
		return _primaryData_ResearchObjectLocalService.getResearchObjectsByPrimaryDataId(requestJson);
	}

	@Override
	public java.util.List<java.lang.Long> getPrimaryDataIdsByResearchObjectId(
		long researchObjectId) {
		return _primaryData_ResearchObjectLocalService.getPrimaryDataIdsByResearchObjectId(researchObjectId);
	}

	@Override
	public java.util.List<java.lang.Long> getPrimaryDataIdsByResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return _primaryData_ResearchObjectLocalService.getPrimaryDataIdsByResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return _primaryData_ResearchObjectLocalService.checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public java.lang.Boolean updatePrimaryDataResearchObject(
		long primaryDataId, long researchObjectId) {
		return _primaryData_ResearchObjectLocalService.updatePrimaryDataResearchObject(primaryDataId,
			researchObjectId);
	}

	@Override
	public java.lang.Boolean updatePrimaryDataResearchObject(
		long primaryDataId, long researchObjectId, int researchObjectVersion) {
		return _primaryData_ResearchObjectLocalService.updatePrimaryDataResearchObject(primaryDataId,
			researchObjectId, researchObjectVersion);
	}

	@Override
	public java.lang.Boolean updateResearchObjectVersion(long primaryDataId,
		long researchObjectId, int oldResearchObjectVersion,
		int newResearchObjectVersion) {
		return _primaryData_ResearchObjectLocalService.updateResearchObjectVersion(primaryDataId,
			researchObjectId, oldResearchObjectVersion, newResearchObjectVersion);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PrimaryData_ResearchObjectLocalService getWrappedPrimaryData_ResearchObjectLocalService() {
		return _primaryData_ResearchObjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPrimaryData_ResearchObjectLocalService(
		PrimaryData_ResearchObjectLocalService primaryData_ResearchObjectLocalService) {
		_primaryData_ResearchObjectLocalService = primaryData_ResearchObjectLocalService;
	}

	@Override
	public PrimaryData_ResearchObjectLocalService getWrappedService() {
		return _primaryData_ResearchObjectLocalService;
	}

	@Override
	public void setWrappedService(
		PrimaryData_ResearchObjectLocalService primaryData_ResearchObjectLocalService) {
		_primaryData_ResearchObjectLocalService = primaryData_ResearchObjectLocalService;
	}

	private PrimaryData_ResearchObjectLocalService _primaryData_ResearchObjectLocalService;
}