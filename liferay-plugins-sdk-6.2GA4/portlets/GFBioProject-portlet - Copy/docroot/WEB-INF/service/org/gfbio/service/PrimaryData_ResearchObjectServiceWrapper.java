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
 * Provides a wrapper for {@link PrimaryData_ResearchObjectService}.
 *
 * @author Marcel Froemming
 * @see PrimaryData_ResearchObjectService
 * @generated
 */
public class PrimaryData_ResearchObjectServiceWrapper
	implements PrimaryData_ResearchObjectService,
		ServiceWrapper<PrimaryData_ResearchObjectService> {
	public PrimaryData_ResearchObjectServiceWrapper(
		PrimaryData_ResearchObjectService primaryData_ResearchObjectService) {
		_primaryData_ResearchObjectService = primaryData_ResearchObjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _primaryData_ResearchObjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primaryData_ResearchObjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primaryData_ResearchObjectService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PrimaryData_ResearchObjectService getWrappedPrimaryData_ResearchObjectService() {
		return _primaryData_ResearchObjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPrimaryData_ResearchObjectService(
		PrimaryData_ResearchObjectService primaryData_ResearchObjectService) {
		_primaryData_ResearchObjectService = primaryData_ResearchObjectService;
	}

	@Override
	public PrimaryData_ResearchObjectService getWrappedService() {
		return _primaryData_ResearchObjectService;
	}

	@Override
	public void setWrappedService(
		PrimaryData_ResearchObjectService primaryData_ResearchObjectService) {
		_primaryData_ResearchObjectService = primaryData_ResearchObjectService;
	}

	private PrimaryData_ResearchObjectService _primaryData_ResearchObjectService;
}