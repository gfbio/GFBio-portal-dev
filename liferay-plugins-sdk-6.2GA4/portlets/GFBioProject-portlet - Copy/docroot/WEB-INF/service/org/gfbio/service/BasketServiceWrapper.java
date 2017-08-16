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
 * Provides a wrapper for {@link BasketService}.
 *
 * @author Marcel Froemming
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
	public com.liferay.portal.kernel.json.JSONArray getBasketById(long basketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketById(basketId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBasketsByIds(
		long[] basketIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketsByIds(basketIds);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBasketsByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketsByUserAndPeriod(userId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBasketsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketsByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBasketsIdByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketsIdByUserAndPeriod(userId, period);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getBasketsIdByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getBasketsIdByUserId(userId);
	}

	@Override
	public long updateBasket(long basketId, long userId, java.lang.String name,
		java.lang.String basketContent, java.lang.String queryJSON,
		java.lang.String queryKeyword, java.lang.String queryFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basketService.updateBasket(basketId, userId, name,
			basketContent, queryJSON, queryKeyword, queryFilter);
	}

	@Override
	public org.gfbio.model.Basket removeBasket(long basketId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basketService.removeBasket(basketId);
	}

	@Override
	public java.util.Map<java.lang.Long, java.lang.String> getBasketUsersIds(
		long userId) throws java.lang.Exception {
		return _basketService.getBasketUsersIds(userId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getUserDetail(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basketService.getUserDetail(userId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray authenticate(
		java.lang.String token) throws java.lang.Exception {
		return _basketService.authenticate(token);
	}

	@Override
	public java.lang.String getToken() throws java.lang.Exception {
		return _basketService.getToken();
	}

	@Override
	public long getLoggedInUserId() throws java.lang.Exception {
		return _basketService.getLoggedInUserId();
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