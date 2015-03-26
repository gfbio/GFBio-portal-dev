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
 * Provides a wrapper for {@link Basket_UserService}.
 *
 * @author Felicitas Loeffler
 * @see Basket_UserService
 * @generated
 */
public class Basket_UserServiceWrapper implements Basket_UserService,
	ServiceWrapper<Basket_UserService> {
	public Basket_UserServiceWrapper(Basket_UserService basket_UserService) {
		_basket_UserService = basket_UserService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _basket_UserService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_basket_UserService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _basket_UserService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.gfbio.model.Basket_User> getBasketList(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserService.getBasketList(userID);
	}

	@Override
	public long updateBasket(long basketID, long userID, java.lang.String name,
		java.lang.String basketJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserService.updateBasket(basketID, userID, name,
			basketJSON);
	}

	@Override
	public org.gfbio.model.Basket_User removeBasket(long basketID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserService.removeBasket(basketID);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Basket_UserService getWrappedBasket_UserService() {
		return _basket_UserService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBasket_UserService(
		Basket_UserService basket_UserService) {
		_basket_UserService = basket_UserService;
	}

	@Override
	public Basket_UserService getWrappedService() {
		return _basket_UserService;
	}

	@Override
	public void setWrappedService(Basket_UserService basket_UserService) {
		_basket_UserService = basket_UserService;
	}

	private Basket_UserService _basket_UserService;
}