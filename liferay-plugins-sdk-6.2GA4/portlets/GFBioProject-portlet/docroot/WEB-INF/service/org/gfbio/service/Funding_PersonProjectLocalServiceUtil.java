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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Funding_PersonProject. This utility wraps
 * {@link org.gfbio.service.impl.Funding_PersonProjectLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectLocalService
 * @see org.gfbio.service.base.Funding_PersonProjectLocalServiceBaseImpl
 * @see org.gfbio.service.impl.Funding_PersonProjectLocalServiceImpl
 * @generated
 */
public class Funding_PersonProjectLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.Funding_PersonProjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the funding_ person project to the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject addFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFunding_PersonProject(funding_PersonProject);
	}

	/**
	* Creates a new funding_ person project with the primary key. Does not add the funding_ person project to the database.
	*
	* @param funding_PersonProjectPK the primary key for the new funding_ person project
	* @return the new funding_ person project
	*/
	public static org.gfbio.model.Funding_PersonProject createFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK) {
		return getService().createFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Deletes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project that was removed
	* @throws PortalException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject deleteFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Deletes the funding_ person project from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject deleteFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFunding_PersonProject(funding_PersonProject);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.gfbio.model.Funding_PersonProject fetchFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFunding_PersonProject(funding_PersonProjectPK);
	}

	/**
	* Returns the funding_ person project with the primary key.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project
	* @throws PortalException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject getFunding_PersonProject(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFunding_PersonProject(funding_PersonProjectPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> getFunding_PersonProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFunding_PersonProjects(start, end);
	}

	/**
	* Returns the number of funding_ person projects.
	*
	* @return the number of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static int getFunding_PersonProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFunding_PersonProjectsCount();
	}

	/**
	* Updates the funding_ person project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProject the funding_ person project
	* @return the funding_ person project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject updateFunding_PersonProject(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFunding_PersonProject(funding_PersonProject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return getService().checkForIgnoredParameter(objects, keyList);
	}

	public static org.json.simple.JSONObject createFunding_PersonProject(
		org.json.simple.JSONObject requestJson) {
		return getService().createFunding_PersonProject(requestJson);
	}

	public static java.lang.Boolean saveUpdateFunding_PersonProject(
		long projectId, long fundingAgencyId, long fundingProgramId,
		long personId, java.lang.String personType) {
		return getService()
				   .saveUpdateFunding_PersonProject(projectId, fundingAgencyId,
			fundingProgramId, personId, personType);
	}

	public static java.lang.Boolean updateFunding_PersonProject(
		long projectId, long fundingAgencyId, long fundingProgramId,
		long personId, java.lang.String personType) {
		return getService()
				   .updateFunding_PersonProject(projectId, fundingAgencyId,
			fundingProgramId, personId, personType);
	}

	public static void clearService() {
		_service = null;
	}

	public static Funding_PersonProjectLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Funding_PersonProjectLocalService.class.getName());

			if (invokableLocalService instanceof Funding_PersonProjectLocalService) {
				_service = (Funding_PersonProjectLocalService)invokableLocalService;
			}
			else {
				_service = new Funding_PersonProjectLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Funding_PersonProjectLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Funding_PersonProjectLocalService service) {
	}

	private static Funding_PersonProjectLocalService _service;
}