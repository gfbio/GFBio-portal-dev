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
 * Provides a wrapper for {@link Funding_InstitutionProjectLocalService}.
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProjectLocalService
 * @generated
 */
public class Funding_InstitutionProjectLocalServiceWrapper
	implements Funding_InstitutionProjectLocalService,
		ServiceWrapper<Funding_InstitutionProjectLocalService> {
	public Funding_InstitutionProjectLocalServiceWrapper(
		Funding_InstitutionProjectLocalService funding_InstitutionProjectLocalService) {
		_funding_InstitutionProjectLocalService = funding_InstitutionProjectLocalService;
	}

	/**
	* Adds the funding_ institution project to the database. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProject the funding_ institution project
	* @return the funding_ institution project that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject addFunding_InstitutionProject(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.addFunding_InstitutionProject(funding_InstitutionProject);
	}

	/**
	* Creates a new funding_ institution project with the primary key. Does not add the funding_ institution project to the database.
	*
	* @param funding_InstitutionProjectPK the primary key for the new funding_ institution project
	* @return the new funding_ institution project
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject createFunding_InstitutionProject(
		org.gfbio.service.persistence.Funding_InstitutionProjectPK funding_InstitutionProjectPK) {
		return _funding_InstitutionProjectLocalService.createFunding_InstitutionProject(funding_InstitutionProjectPK);
	}

	/**
	* Deletes the funding_ institution project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project that was removed
	* @throws PortalException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject deleteFunding_InstitutionProject(
		org.gfbio.service.persistence.Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.deleteFunding_InstitutionProject(funding_InstitutionProjectPK);
	}

	/**
	* Deletes the funding_ institution project from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProject the funding_ institution project
	* @return the funding_ institution project that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject deleteFunding_InstitutionProject(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.deleteFunding_InstitutionProject(funding_InstitutionProject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _funding_InstitutionProjectLocalService.dynamicQuery();
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
		return _funding_InstitutionProjectLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funding_InstitutionProjectLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _funding_InstitutionProjectLocalService.dynamicQuery(dynamicQuery,
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
		return _funding_InstitutionProjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _funding_InstitutionProjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.Funding_InstitutionProject fetchFunding_InstitutionProject(
		org.gfbio.service.persistence.Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.fetchFunding_InstitutionProject(funding_InstitutionProjectPK);
	}

	/**
	* Returns the funding_ institution project with the primary key.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project
	* @throws PortalException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject getFunding_InstitutionProject(
		org.gfbio.service.persistence.Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.getFunding_InstitutionProject(funding_InstitutionProjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the funding_ institution projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @return the range of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> getFunding_InstitutionProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.getFunding_InstitutionProjects(start,
			end);
	}

	/**
	* Returns the number of funding_ institution projects.
	*
	* @return the number of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFunding_InstitutionProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.getFunding_InstitutionProjectsCount();
	}

	/**
	* Updates the funding_ institution project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProject the funding_ institution project
	* @return the funding_ institution project that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Funding_InstitutionProject updateFunding_InstitutionProject(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _funding_InstitutionProjectLocalService.updateFunding_InstitutionProject(funding_InstitutionProject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funding_InstitutionProjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funding_InstitutionProjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funding_InstitutionProjectLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _funding_InstitutionProjectLocalService.checkForIgnoredParameter(objects,
			keyList);
	}

	@Override
	public org.json.simple.JSONObject createFundingInstitutionProject(
		org.json.simple.JSONObject requestJson) {
		return _funding_InstitutionProjectLocalService.createFundingInstitutionProject(requestJson);
	}

	@Override
	public java.lang.Boolean saveUpdateFundingInstitutionProject(
		long projectId, long fundingAgencyId, long fundingProgramId,
		long institutionId) {
		return _funding_InstitutionProjectLocalService.saveUpdateFundingInstitutionProject(projectId,
			fundingAgencyId, fundingProgramId, institutionId);
	}

	@Override
	public java.lang.Boolean updateFundingInstitutionProject(long projectId,
		long fundingAgencyId, long fundingProgramId, long institutionId) {
		return _funding_InstitutionProjectLocalService.updateFundingInstitutionProject(projectId,
			fundingAgencyId, fundingProgramId, institutionId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Funding_InstitutionProjectLocalService getWrappedFunding_InstitutionProjectLocalService() {
		return _funding_InstitutionProjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFunding_InstitutionProjectLocalService(
		Funding_InstitutionProjectLocalService funding_InstitutionProjectLocalService) {
		_funding_InstitutionProjectLocalService = funding_InstitutionProjectLocalService;
	}

	@Override
	public Funding_InstitutionProjectLocalService getWrappedService() {
		return _funding_InstitutionProjectLocalService;
	}

	@Override
	public void setWrappedService(
		Funding_InstitutionProjectLocalService funding_InstitutionProjectLocalService) {
		_funding_InstitutionProjectLocalService = funding_InstitutionProjectLocalService;
	}

	private Funding_InstitutionProjectLocalService _funding_InstitutionProjectLocalService;
}