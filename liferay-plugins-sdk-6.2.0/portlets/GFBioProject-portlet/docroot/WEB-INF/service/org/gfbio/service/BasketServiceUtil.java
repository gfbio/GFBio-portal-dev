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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Basket. This utility wraps
 * {@link org.gfbio.service.impl.BasketServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Felicitas Loeffler
 * @see BasketService
 * @see org.gfbio.service.base.BasketServiceBaseImpl
 * @see org.gfbio.service.impl.BasketServiceImpl
 * @generated
 */
public class BasketServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.BasketServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.gfbio.model.Basket getBasketById(long basketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketById(basketId);
	}

	public static java.util.List<org.gfbio.model.Basket> getBasketsByIds(
		long[] basketIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByIds(basketIds);
	}

	public static java.util.List<org.gfbio.model.Basket> getBasketsByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByUserAndPeriod(userId, period);
	}

	public static java.util.List<org.gfbio.model.Basket> getBasketsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByUserId(userId);
	}

	public static java.util.List<java.lang.Long> getBasketsIdByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsIdByUserAndPeriod(userId, period);
	}

	public static java.util.List<java.lang.Long> getBasketsIdByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsIdByUserId(userId);
	}

	public static long updateBasket(long basketId, long userId,
		java.lang.String name, java.lang.String basketJSON,
		java.lang.String queryJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBasket(basketId, userId, name, basketJSON, queryJSON);
	}

	public static org.gfbio.model.Basket removeBasket(long basketId, long userId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeBasket(basketId, userId);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getBasketUsersIds(
		long userId) throws java.lang.Exception {
		return getService().getBasketUsersIds(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BasketService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BasketService.class.getName());

			if (invokableService instanceof BasketService) {
				_service = (BasketService)invokableService;
			}
			else {
				_service = new BasketServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(BasketServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BasketService service) {
	}

	private static BasketService _service;
}