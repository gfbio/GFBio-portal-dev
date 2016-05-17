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
 * Provides a wrapper for {@link HeadService}.
 *
 * @author Marcel Froemming
 * @see HeadService
 * @generated
 */
public class HeadServiceWrapper implements HeadService,
	ServiceWrapper<HeadService> {
	public HeadServiceWrapper(HeadService headService) {
		_headService = headService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _headService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_headService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _headService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getTableAsJSONArrayByName(
		org.json.simple.JSONObject requestJson) {
		return _headService.getTableAsJSONArrayByName(requestJson);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HeadService getWrappedHeadService() {
		return _headService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHeadService(HeadService headService) {
		_headService = headService;
	}

	@Override
	public HeadService getWrappedService() {
		return _headService;
	}

	@Override
	public void setWrappedService(HeadService headService) {
		_headService = headService;
	}

	private HeadService _headService;
}