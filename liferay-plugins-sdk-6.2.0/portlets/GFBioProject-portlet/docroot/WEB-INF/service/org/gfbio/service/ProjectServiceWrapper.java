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

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.sample.service.ProjectServiceUtil} to access the project remote service.
	*/
	@Override
	public java.util.List<org.gfbio.model.Project> getProjectList(long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectService.getProjectList(userID);
	}

	@Override
	public long updateProject(long projectID, long userID,
		java.lang.String name, java.lang.String label,
		java.lang.String description, java.util.Date startDate,
		java.util.Date endDate, java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectService.updateProject(projectID, userID, name, label,
			description, startDate, endDate, status);
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