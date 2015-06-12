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
 * Provides a wrapper for {@link Cell_PositionService}.
 *
 * @author Marcel Froemming
 * @see Cell_PositionService
 * @generated
 */
public class Cell_PositionServiceWrapper implements Cell_PositionService,
	ServiceWrapper<Cell_PositionService> {
	public Cell_PositionServiceWrapper(
		Cell_PositionService cell_PositionService) {
		_cell_PositionService = cell_PositionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cell_PositionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cell_PositionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cell_PositionService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Cell_PositionService getWrappedCell_PositionService() {
		return _cell_PositionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCell_PositionService(
		Cell_PositionService cell_PositionService) {
		_cell_PositionService = cell_PositionService;
	}

	@Override
	public Cell_PositionService getWrappedService() {
		return _cell_PositionService;
	}

	@Override
	public void setWrappedService(Cell_PositionService cell_PositionService) {
		_cell_PositionService = cell_PositionService;
	}

	private Cell_PositionService _cell_PositionService;
}