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
 * Provides the local service utility for Project. This utility wraps
 * {@link org.gfbio.service.impl.ProjectLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see ProjectLocalService
 * @see org.gfbio.service.base.ProjectLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ProjectLocalServiceImpl
 * @generated
 */
public class ProjectLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ProjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project to the database. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project addProject(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProject(project);
	}

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectID the primary key for the new project
	* @return the new project
	*/
	public static org.gfbio.model.Project createProject(long projectID) {
		return getService().createProject(projectID);
	}

	/**
	* Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectID the primary key of the project
	* @return the project that was removed
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project deleteProject(long projectID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject(projectID);
	}

	/**
	* Deletes the project from the database. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project deleteProject(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject(project);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Project fetchProject(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProject(projectID);
	}

	/**
	* Returns the project with the primary key.
	*
	* @param projectID the primary key of the project
	* @return the project
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project getProject(long projectID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject(projectID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @return the range of projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> getProjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjects(start, end);
	}

	/**
	* Returns the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	public static int getProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectsCount();
	}

	/**
	* Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project updateProject(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProject(project);
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

	public static org.json.simple.JSONArray getCompleteProjectById(
		org.json.simple.JSONArray requestJson) {
		return getService().getCompleteProjectById(requestJson);
	}

	public static org.json.simple.JSONObject getCompleteProjectById(
		org.json.simple.JSONObject requestJson) {
		return getService().getCompleteProjectById(requestJson);
	}

	public static org.json.simple.JSONObject getProjectById(
		org.json.simple.JSONObject requestJson) {
		return getService().getProjectById(requestJson);
	}

	public static java.util.List<org.gfbio.model.Project> getProjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjects();
	}

	public static java.util.List<org.gfbio.model.Project> getProjectList(
		long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProjectList(userID);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjectList(
		long projectID, long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObjectList(projectID, userID);
	}

	public static java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return getService().checkForIgnoredParameter(objects, keyList);
	}

	public static org.json.simple.JSONObject constructProjectAsJson(
		org.gfbio.model.Project project) {
		return getService().constructProjectAsJson(project);
	}

	public static org.json.simple.JSONArray constructProjectAsJsonArray(
		org.gfbio.model.Project project) {
		return getService().constructProjectAsJsonArray(project);
	}

	public static org.json.simple.JSONArray constructProjectsAsJson(
		java.util.List<org.gfbio.model.Project> projectList) {
		return getService().constructProjectsAsJson(projectList);
	}

	public static long updateProject(long projectID, long userID,
		java.lang.String name, java.lang.String label,
		java.lang.String description, java.lang.String extendedData,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateProject(projectID, userID, name, label, description,
			extendedData, startDate, endDate, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProjectLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProjectLocalService.class.getName());

			if (invokableLocalService instanceof ProjectLocalService) {
				_service = (ProjectLocalService)invokableLocalService;
			}
			else {
				_service = new ProjectLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProjectLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ProjectLocalService service) {
	}

	private static ProjectLocalService _service;
}