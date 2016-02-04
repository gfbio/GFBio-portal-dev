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
 * Provides a wrapper for {@link ProjectLocalService}.
 *
 * @author Marcel Froemming
 * @see ProjectLocalService
 * @generated
 */
public class ProjectLocalServiceWrapper implements ProjectLocalService,
	ServiceWrapper<ProjectLocalService> {
	public ProjectLocalServiceWrapper(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	/**
	* Adds the project to the database. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project addProject(org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.addProject(project);
	}

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectID the primary key for the new project
	* @return the new project
	*/
	@Override
	public org.gfbio.model.Project createProject(long projectID) {
		return _projectLocalService.createProject(projectID);
	}

	/**
	* Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectID the primary key of the project
	* @return the project that was removed
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project deleteProject(long projectID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.deleteProject(projectID);
	}

	/**
	* Deletes the project from the database. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project deleteProject(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.deleteProject(project);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectLocalService.dynamicQuery();
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
		return _projectLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _projectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.Project fetchProject(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.fetchProject(projectID);
	}

	/**
	* Returns the project with the primary key.
	*
	* @param projectID the primary key of the project
	* @return the project
	* @throws PortalException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project getProject(long projectID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProject(projectID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.gfbio.model.Project> getProjects(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjects(start, end);
	}

	/**
	* Returns the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectsCount();
	}

	/**
	* Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param project the project
	* @return the project that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project updateProject(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.updateProject(project);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _projectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_projectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _projectLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getCompleteProjectById(
		org.json.simple.JSONArray requestJson) {
		return _projectLocalService.getCompleteProjectById(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getCompleteProjectById(
		org.json.simple.JSONObject requestJson) {
		return _projectLocalService.getCompleteProjectById(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getProjectById(
		org.json.simple.JSONObject requestJson) {
		return _projectLocalService.getProjectById(requestJson);
	}

	@Override
	public java.util.List<org.gfbio.model.Project> getProjectList(long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjectList(userID);
	}

	@Override
	public java.util.List<org.gfbio.model.Project> getProjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getProjects();
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjectList(
		long projectID, long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.getResearchObjectList(projectID, userID);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _projectLocalService.checkForIgnoredParameter(objects, keyList);
	}

	@Override
	public org.json.simple.JSONObject constructProjectAsJson(
		org.gfbio.model.Project project) {
		return _projectLocalService.constructProjectAsJson(project);
	}

	@Override
	public org.json.simple.JSONArray constructProjectAsJsonArray(
		org.gfbio.model.Project project) {
		return _projectLocalService.constructProjectAsJsonArray(project);
	}

	@Override
	public org.json.simple.JSONArray constructProjectsAsJson(
		java.util.List<org.gfbio.model.Project> projectList) {
		return _projectLocalService.constructProjectsAsJson(projectList);
	}

	@Override
	public org.json.simple.JSONObject createProjectByJson(
		org.json.simple.JSONObject requestJson) {
		return _projectLocalService.createProjectByJson(requestJson);
	}

	@Override
	public long createProject(long userId, java.lang.String name,
		java.lang.String label, java.lang.String description)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.createProject(userId, name, label,
			description);
	}

	@Override
	public long updateProject(long projectId, java.lang.String name,
		java.lang.String label, java.lang.String description) {
		return _projectLocalService.updateProject(projectId, name, label,
			description);
	}

	@Override
	public long updateProject(long projectID, long userID,
		java.lang.String name, java.lang.String label,
		java.lang.String description, java.lang.String extendedData,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectLocalService.updateProject(projectID, userID, name,
			label, description, extendedData, startDate, endDate, status);
	}

	@Override
	public java.lang.Boolean updateEndDate(long projectId,
		java.util.Date endDate) {
		return _projectLocalService.updateEndDate(projectId, endDate);
	}

	@Override
	public java.lang.Boolean updateExtendedData(long projectId,
		java.lang.String extendedData) {
		return _projectLocalService.updateExtendedData(projectId, extendedData);
	}

	@Override
	public java.lang.Boolean updateParentProjectByIds(long projectId,
		long parentProjectId) {
		return _projectLocalService.updateParentProjectByIds(projectId,
			parentProjectId);
	}

	@Override
	public java.lang.Boolean updateStartDate(long projectId,
		java.util.Date startDate) {
		return _projectLocalService.updateStartDate(projectId, startDate);
	}

	@Override
	public java.lang.Boolean updateStatus(long projectId,
		java.lang.String status) {
		return _projectLocalService.updateStatus(projectId, status);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProjectLocalService getWrappedProjectLocalService() {
		return _projectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProjectLocalService(
		ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	@Override
	public ProjectLocalService getWrappedService() {
		return _projectLocalService;
	}

	@Override
	public void setWrappedService(ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}

	private ProjectLocalService _projectLocalService;
}