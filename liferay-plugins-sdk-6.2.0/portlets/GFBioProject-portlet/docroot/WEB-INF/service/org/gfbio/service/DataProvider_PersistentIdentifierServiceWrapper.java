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
 * Provides a wrapper for {@link DataProvider_PersistentIdentifierService}.
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifierService
 * @generated
 */
public class DataProvider_PersistentIdentifierServiceWrapper
	implements DataProvider_PersistentIdentifierService,
		ServiceWrapper<DataProvider_PersistentIdentifierService> {
	public DataProvider_PersistentIdentifierServiceWrapper(
		DataProvider_PersistentIdentifierService dataProvider_PersistentIdentifierService) {
		_dataProvider_PersistentIdentifierService = dataProvider_PersistentIdentifierService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dataProvider_PersistentIdentifierService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dataProvider_PersistentIdentifierService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dataProvider_PersistentIdentifierService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DataProvider_PersistentIdentifierService getWrappedDataProvider_PersistentIdentifierService() {
		return _dataProvider_PersistentIdentifierService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDataProvider_PersistentIdentifierService(
		DataProvider_PersistentIdentifierService dataProvider_PersistentIdentifierService) {
		_dataProvider_PersistentIdentifierService = dataProvider_PersistentIdentifierService;
	}

	@Override
	public DataProvider_PersistentIdentifierService getWrappedService() {
		return _dataProvider_PersistentIdentifierService;
	}

	@Override
	public void setWrappedService(
		DataProvider_PersistentIdentifierService dataProvider_PersistentIdentifierService) {
		_dataProvider_PersistentIdentifierService = dataProvider_PersistentIdentifierService;
	}

	private DataProvider_PersistentIdentifierService _dataProvider_PersistentIdentifierService;
}