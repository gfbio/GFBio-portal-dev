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
 * Provides a wrapper for {@link tab_ResearchObjectService}.
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObjectService
 * @generated
 */
public class tab_ResearchObjectServiceWrapper
	implements tab_ResearchObjectService,
		ServiceWrapper<tab_ResearchObjectService> {
	public tab_ResearchObjectServiceWrapper(
		tab_ResearchObjectService tab_ResearchObjectService) {
		_tab_ResearchObjectService = tab_ResearchObjectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tab_ResearchObjectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tab_ResearchObjectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tab_ResearchObjectService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public tab_ResearchObjectService getWrappedtab_ResearchObjectService() {
		return _tab_ResearchObjectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedtab_ResearchObjectService(
		tab_ResearchObjectService tab_ResearchObjectService) {
		_tab_ResearchObjectService = tab_ResearchObjectService;
	}

	@Override
	public tab_ResearchObjectService getWrappedService() {
		return _tab_ResearchObjectService;
	}

	@Override
	public void setWrappedService(
		tab_ResearchObjectService tab_ResearchObjectService) {
		_tab_ResearchObjectService = tab_ResearchObjectService;
	}

	private tab_ResearchObjectService _tab_ResearchObjectService;
}