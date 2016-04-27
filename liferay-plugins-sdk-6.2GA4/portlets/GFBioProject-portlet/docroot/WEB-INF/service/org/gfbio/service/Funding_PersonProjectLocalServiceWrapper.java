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
 * Provides a wrapper for {@link Funding_PersonProjectLocalService}.
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectLocalService
 * @generated
 */
public class Funding_PersonProjectLocalServiceWrapper
	implements Funding_PersonProjectLocalService,
		ServiceWrapper<Funding_PersonProjectLocalService> {
	public Funding_PersonProjectLocalServiceWrapper(
		Funding_PersonProjectLocalService funding_PersonProjectLocalService) {
		_funding_PersonProjectLocalService = funding_PersonProjectLocalService;
	}

	/**
	* Adds the funding_ person project to the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject addFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.addFunding_PersonProject(funding_PersonProject);
	}

	/**
	* Creates a new funding_ person project with the primary key. Does not add the funding_ person project to the database.
	*
	* @param funding_PersonProjectPK the primary key for the new funding_ person project
	* @return the new funding_ person project
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject createFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK) {
		return _funding_PersonProjectLocalService.createFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Deletes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project that was removed
	* @throws PortalException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject deleteFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.deleteFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Deletes the funding_ person project from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject deleteFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.deleteFunding_PersonProject(funding_PersonProject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _funding_PersonProjectLocalService.dynamicQuery();
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
		return _funding_PersonProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funding_PersonProjectLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funding_PersonProjectLocalService.dynamicQuery(dynamicQuery,
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
		return _funding_PersonProjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _funding_PersonProjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.Funding_PersonProject fetchFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.fetchFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Returns the funding_ person project with the primary key.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project
	* @throws PortalException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject getFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.getFunding_PersonProject(funding_PersonProjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the funding_ person projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @return the range of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Funding_PersonProject> getFunding_PersonProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.getFunding_PersonProjects(start,
			end);
	}

	/**
	* Returns the number of funding_ person projects.
	*
	* @return the number of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFunding_PersonProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.getFunding_PersonProjectsCount();
	}

	/**
	* Updates the funding_ person project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_PersonProject updateFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_PersonProjectLocalService.updateFunding_PersonProject(funding_PersonProject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funding_PersonProjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funding_PersonProjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funding_PersonProjectLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _funding_PersonProjectLocalService.checkForIgnoredParameter(objects,
			keyList);
	}

	@Override
	public org.json.simple.JSONObject createFunding_PersonProject(
		org.json.simple.JSONObject requestJson) {
		return _funding_PersonProjectLocalService.createFunding_PersonProject(requestJson);
	}

	@Override
	public java.lang.Boolean saveUpdateFunding_PersonProject(long projectId,
		long fundingAgencyId, long fundingProgramId, long personId,
		java.lang.String personType) {
		return _funding_PersonProjectLocalService.saveUpdateFunding_PersonProject(projectId,
			fundingAgencyId, fundingProgramId, personId, personType);
	}

	@Override
	public java.lang.Boolean updateFunding_PersonProject(long projectId,
		long fundingAgencyId, long fundingProgramId, long personId,
		java.lang.String personType) {
		return _funding_PersonProjectLocalService.updateFunding_PersonProject(projectId,
			fundingAgencyId, fundingProgramId, personId, personType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Funding_PersonProjectLocalService getWrappedFunding_PersonProjectLocalService() {
		return _funding_PersonProjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFunding_PersonProjectLocalService(
		Funding_PersonProjectLocalService funding_PersonProjectLocalService) {
		_funding_PersonProjectLocalService = funding_PersonProjectLocalService;
	}

	@Override
	public Funding_PersonProjectLocalService getWrappedService() {
		return _funding_PersonProjectLocalService;
	}

	@Override
	public void setWrappedService(
		Funding_PersonProjectLocalService funding_PersonProjectLocalService) {
		_funding_PersonProjectLocalService = funding_PersonProjectLocalService;
	}

	private Funding_PersonProjectLocalService _funding_PersonProjectLocalService;
}