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
 * Provides a wrapper for {@link User_SSOService}.
 *
 * @author Marcel Froemming
 * @see User_SSOService
 * @generated
 */
public class User_SSOServiceWrapper implements User_SSOService,
	ServiceWrapper<User_SSOService> {
	public User_SSOServiceWrapper(User_SSOService user_SSOService) {
		_user_SSOService = user_SSOService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _user_SSOService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_user_SSOService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _user_SSOService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public User_SSOService getWrappedUser_SSOService() {
		return _user_SSOService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUser_SSOService(User_SSOService user_SSOService) {
		_user_SSOService = user_SSOService;
	}

	@Override
	public User_SSOService getWrappedService() {
		return _user_SSOService;
	}

	@Override
	public void setWrappedService(User_SSOService user_SSOService) {
		_user_SSOService = user_SSOService;
	}

	private User_SSOService _user_SSOService;
}