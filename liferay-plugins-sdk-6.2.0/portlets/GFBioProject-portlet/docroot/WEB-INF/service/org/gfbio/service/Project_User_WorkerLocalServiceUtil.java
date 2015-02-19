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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Project_User_Worker. This utility wraps
 * {@link org.gfbio.service.impl.Project_User_WorkerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author froemm
 * @see Project_User_WorkerLocalService
 * @see org.gfbio.service.base.Project_User_WorkerLocalServiceBaseImpl
 * @see org.gfbio.service.impl.Project_User_WorkerLocalServiceImpl
 * @generated
 */
public class Project_User_WorkerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.Project_User_WorkerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project_ user_ worker to the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_Worker the project_ user_ worker
	* @return the project_ user_ worker that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker addProject_User_Worker(
		org.gfbio.model.Project_User_Worker project_User_Worker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProject_User_Worker(project_User_Worker);
	}

	/**
	* Creates a new project_ user_ worker with the primary key. Does not add the project_ user_ worker to the database.
	*
	* @param project_User_WorkerPK the primary key for the new project_ user_ worker
	* @return the new project_ user_ worker
	*/
	public static org.gfbio.model.Project_User_Worker createProject_User_Worker(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK) {
		return getService().createProject_User_Worker(project_User_WorkerPK);
	}

	/**
	* Deletes the project_ user_ worker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker that was removed
	* @throws PortalException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker deleteProject_User_Worker(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject_User_Worker(project_User_WorkerPK);
	}

	/**
	* Deletes the project_ user_ worker from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_Worker the project_ user_ worker
	* @return the project_ user_ worker that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker deleteProject_User_Worker(
		org.gfbio.model.Project_User_Worker project_User_Worker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject_User_Worker(project_User_Worker);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Project_User_Worker fetchProject_User_Worker(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProject_User_Worker(project_User_WorkerPK);
	}

	/**
	* Returns the project_ user_ worker with the primary key.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker
	* @throws PortalException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker getProject_User_Worker(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_User_Worker(project_User_WorkerPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the project_ user_ workers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @return the range of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> getProject_User_Workers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_User_Workers(start, end);
	}

	/**
	* Returns the number of project_ user_ workers.
	*
	* @return the number of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static int getProject_User_WorkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_User_WorkersCount();
	}

	/**
	* Updates the project_ user_ worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param project_User_Worker the project_ user_ worker
	* @return the project_ user_ worker that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker updateProject_User_Worker(
		org.gfbio.model.Project_User_Worker project_User_Worker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProject_User_Worker(project_User_Worker);
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

	public static void clearService() {
		_service = null;
	}

	public static Project_User_WorkerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Project_User_WorkerLocalService.class.getName());

			if (invokableLocalService instanceof Project_User_WorkerLocalService) {
				_service = (Project_User_WorkerLocalService)invokableLocalService;
			}
			else {
				_service = new Project_User_WorkerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Project_User_WorkerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Project_User_WorkerLocalService service) {
	}

	private static Project_User_WorkerLocalService _service;
}