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
 * Provides the remote service utility for Basket_User. This utility wraps
 * {@link org.gfbio.service.impl.Basket_UserServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Felicitas Loeffler
 * @see Basket_UserService
 * @see org.gfbio.service.base.Basket_UserServiceBaseImpl
 * @see org.gfbio.service.impl.Basket_UserServiceImpl
 * @generated
 */
public class Basket_UserServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.Basket_UserServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<org.gfbio.model.Basket_User> getBasket_UserList(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasket_UserList(userID);
	}

	public static long updateBasket(long basketID, long userID,
		java.lang.String name, java.lang.String basketJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBasket(basketID, userID, name, basketJSON);
	}

	public static void clearService() {
		_service = null;
	}

	public static Basket_UserService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Basket_UserService.class.getName());

			if (invokableService instanceof Basket_UserService) {
				_service = (Basket_UserService)invokableService;
			}
			else {
				_service = new Basket_UserServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(Basket_UserServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Basket_UserService service) {
	}

	private static Basket_UserService _service;
}