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
 * Provides a wrapper for {@link UserExtensionService}.
 *
 * @author Marcel Froemming
 * @see UserExtensionService
 * @generated
 */
public class UserExtensionServiceWrapper implements UserExtensionService,
	ServiceWrapper<UserExtensionService> {
	public UserExtensionServiceWrapper(
		UserExtensionService userExtensionService) {
		_userExtensionService = userExtensionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userExtensionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userExtensionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userExtensionService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.model.User getUserById(long userId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionService.getUserById(userId);
	}

	@Override
	public org.json.simple.JSONObject getUserAsJsonById(long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionService.getUserAsJsonById(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserExtensionService getWrappedUserExtensionService() {
		return _userExtensionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserExtensionService(
		UserExtensionService userExtensionService) {
		_userExtensionService = userExtensionService;
	}

	@Override
	public UserExtensionService getWrappedService() {
		return _userExtensionService;
	}

	@Override
	public void setWrappedService(UserExtensionService userExtensionService) {
		_userExtensionService = userExtensionService;
	}

	private UserExtensionService _userExtensionService;
}