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
 * Provides a wrapper for {@link Funding_PersonProjectService}.
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectService
 * @generated
 */
public class Funding_PersonProjectServiceWrapper
	implements Funding_PersonProjectService,
		ServiceWrapper<Funding_PersonProjectService> {
	public Funding_PersonProjectServiceWrapper(
		Funding_PersonProjectService funding_PersonProjectService) {
		_funding_PersonProjectService = funding_PersonProjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funding_PersonProjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funding_PersonProjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funding_PersonProjectService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Funding_PersonProjectService getWrappedFunding_PersonProjectService() {
		return _funding_PersonProjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFunding_PersonProjectService(
		Funding_PersonProjectService funding_PersonProjectService) {
		_funding_PersonProjectService = funding_PersonProjectService;
	}

	@Override
	public Funding_PersonProjectService getWrappedService() {
		return _funding_PersonProjectService;
	}

	@Override
	public void setWrappedService(
		Funding_PersonProjectService funding_PersonProjectService) {
		_funding_PersonProjectService = funding_PersonProjectService;
	}

	private Funding_PersonProjectService _funding_PersonProjectService;
}