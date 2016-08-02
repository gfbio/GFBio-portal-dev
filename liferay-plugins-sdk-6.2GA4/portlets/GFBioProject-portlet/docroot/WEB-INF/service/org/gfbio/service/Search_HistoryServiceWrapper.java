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
 * Provides a wrapper for {@link Search_HistoryService}.
 *
 * @author Marcel Froemming
 * @see Search_HistoryService
 * @generated
 */
public class Search_HistoryServiceWrapper implements Search_HistoryService,
	ServiceWrapper<Search_HistoryService> {
	public Search_HistoryServiceWrapper(
		Search_HistoryService search_HistoryService) {
		_search_HistoryService = search_HistoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _search_HistoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_search_HistoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _search_HistoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Search_HistoryService getWrappedSearch_HistoryService() {
		return _search_HistoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSearch_HistoryService(
		Search_HistoryService search_HistoryService) {
		_search_HistoryService = search_HistoryService;
	}

	@Override
	public Search_HistoryService getWrappedService() {
		return _search_HistoryService;
	}

	@Override
	public void setWrappedService(Search_HistoryService search_HistoryService) {
		_search_HistoryService = search_HistoryService;
	}

	private Search_HistoryService _search_HistoryService;
}