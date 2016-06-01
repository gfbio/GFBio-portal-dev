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
 * Provides a wrapper for {@link Funding_InstitutionProjectService}.
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProjectService
 * @generated
 */
public class Funding_InstitutionProjectServiceWrapper
	implements Funding_InstitutionProjectService,
		ServiceWrapper<Funding_InstitutionProjectService> {
	public Funding_InstitutionProjectServiceWrapper(
		Funding_InstitutionProjectService funding_InstitutionProjectService) {
		_funding_InstitutionProjectService = funding_InstitutionProjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _funding_InstitutionProjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_funding_InstitutionProjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _funding_InstitutionProjectService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONObject createFunding_InstitutionProject(
		org.json.simple.JSONObject requestJson) {
		return _funding_InstitutionProjectService.createFunding_InstitutionProject(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Funding_InstitutionProjectService getWrappedFunding_InstitutionProjectService() {
		return _funding_InstitutionProjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFunding_InstitutionProjectService(
		Funding_InstitutionProjectService funding_InstitutionProjectService) {
		_funding_InstitutionProjectService = funding_InstitutionProjectService;
	}

	@Override
	public Funding_InstitutionProjectService getWrappedService() {
		return _funding_InstitutionProjectService;
	}

	@Override
	public void setWrappedService(
		Funding_InstitutionProjectService funding_InstitutionProjectService) {
		_funding_InstitutionProjectService = funding_InstitutionProjectService;
	}

	private Funding_InstitutionProjectService _funding_InstitutionProjectService;
}