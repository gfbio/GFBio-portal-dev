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
 * Provides a wrapper for {@link Project_User_PIService}.
 *
 * @author Marcel Froemming
 * @see Project_User_PIService
 * @generated
 */
public class Project_User_PIServiceWrapper implements Project_User_PIService,
	ServiceWrapper<Project_User_PIService> {
	public Project_User_PIServiceWrapper(
		Project_User_PIService project_User_PIService) {
		_project_User_PIService = project_User_PIService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _project_User_PIService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_project_User_PIService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _project_User_PIService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Project_User_PIService getWrappedProject_User_PIService() {
		return _project_User_PIService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProject_User_PIService(
		Project_User_PIService project_User_PIService) {
		_project_User_PIService = project_User_PIService;
	}

	@Override
	public Project_User_PIService getWrappedService() {
		return _project_User_PIService;
	}

	@Override
	public void setWrappedService(Project_User_PIService project_User_PIService) {
		_project_User_PIService = project_User_PIService;
	}

	private Project_User_PIService _project_User_PIService;
}