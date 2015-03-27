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
 * Provides a wrapper for {@link BasketService}.
 *
 * @author Felicitas Loeffler
 * @see BasketService
 * @generated
 */
public class BasketServiceWrapper implements BasketService,
	ServiceWrapper<BasketService> {
	public BasketServiceWrapper(BasketService basketService) {
		_basketService = basketService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _basketService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_basketService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _basketService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<org.gfbio.model.Basket> getBasketList(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketList(userID);
	}

	@Override
	public long updateBasket(long basketID, long userID, java.lang.String name,
		java.lang.String basketJSON, java.lang.String queryJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.updateBasket(basketID, userID, name, basketJSON,
			queryJSON);
	}

	@Override
	public org.gfbio.model.Basket removeBasket(long basketID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basketService.removeBasket(basketID);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BasketService getWrappedBasketService() {
		return _basketService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBasketService(BasketService basketService) {
		_basketService = basketService;
	}

	@Override
	public BasketService getWrappedService() {
		return _basketService;
	}

	@Override
	public void setWrappedService(BasketService basketService) {
		_basketService = basketService;
	}

	private BasketService _basketService;
}