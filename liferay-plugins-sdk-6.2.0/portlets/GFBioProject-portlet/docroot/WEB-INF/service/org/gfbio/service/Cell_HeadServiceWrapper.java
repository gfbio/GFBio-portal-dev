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
 * Provides a wrapper for {@link Cell_HeadService}.
 *
 * @author Marcel Froemming
 * @see Cell_HeadService
 * @generated
 */
public class Cell_HeadServiceWrapper implements Cell_HeadService,
	ServiceWrapper<Cell_HeadService> {
	public Cell_HeadServiceWrapper(Cell_HeadService cell_HeadService) {
		_cell_HeadService = cell_HeadService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cell_HeadService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cell_HeadService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cell_HeadService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Cell_HeadService getWrappedCell_HeadService() {
		return _cell_HeadService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCell_HeadService(Cell_HeadService cell_HeadService) {
		_cell_HeadService = cell_HeadService;
	}

	@Override
	public Cell_HeadService getWrappedService() {
		return _cell_HeadService;
	}

	@Override
	public void setWrappedService(Cell_HeadService cell_HeadService) {
		_cell_HeadService = cell_HeadService;
	}

	private Cell_HeadService _cell_HeadService;
}