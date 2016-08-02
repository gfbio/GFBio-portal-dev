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
 * Provides a wrapper for {@link ProjectService}.
 *
 * @author Marcel Froemming
 * @see ProjectService
 * @generated
 */
public class ProjectServiceWrapper implements ProjectService,
	ServiceWrapper<ProjectService> {
	public ProjectServiceWrapper(ProjectService projectService) {
		_projectService = projectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _projectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_projectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _projectService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONObject getProjectById(
		org.json.simple.JSONObject requestJson) {
		return _projectService.getProjectById(requestJson);
	}

	@Override
	public java.lang.Boolean checkProjectOnSubmissions(long projectId) {
		return _projectService.checkProjectOnSubmissions(projectId);
	}

	@Override
	public org.json.simple.JSONObject createProject(
		org.json.simple.JSONObject requestJson) {
		return _projectService.createProject(requestJson);
	}

	@Override
	public org.json.simple.JSONObject updateProject(
		org.json.simple.JSONObject requestJson) {
		return _projectService.updateProject(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProjectService getWrappedProjectService() {
		return _projectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProjectService(ProjectService projectService) {
		_projectService = projectService;
	}

	@Override
	public ProjectService getWrappedService() {
		return _projectService;
	}

	@Override
	public void setWrappedService(ProjectService projectService) {
		_projectService = projectService;
	}

	private ProjectService _projectService;
}