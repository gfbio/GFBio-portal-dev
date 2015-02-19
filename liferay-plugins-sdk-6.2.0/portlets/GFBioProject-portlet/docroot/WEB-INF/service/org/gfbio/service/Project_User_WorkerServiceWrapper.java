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
 * Provides a wrapper for {@link Project_User_WorkerService}.
 *
 * @author froemm
 * @see Project_User_WorkerService
 * @generated
 */
public class Project_User_WorkerServiceWrapper
	implements Project_User_WorkerService,
		ServiceWrapper<Project_User_WorkerService> {
	public Project_User_WorkerServiceWrapper(
		Project_User_WorkerService project_User_WorkerService) {
		_project_User_WorkerService = project_User_WorkerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _project_User_WorkerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_project_User_WorkerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _project_User_WorkerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Project_User_WorkerService getWrappedProject_User_WorkerService() {
		return _project_User_WorkerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProject_User_WorkerService(
		Project_User_WorkerService project_User_WorkerService) {
		_project_User_WorkerService = project_User_WorkerService;
	}

	@Override
	public Project_User_WorkerService getWrappedService() {
		return _project_User_WorkerService;
	}

	@Override
	public void setWrappedService(
		Project_User_WorkerService project_User_WorkerService) {
		_project_User_WorkerService = project_User_WorkerService;
	}

	private Project_User_WorkerService _project_User_WorkerService;
}