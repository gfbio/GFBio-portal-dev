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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Basket. This utility wraps
 * {@link org.gfbio.service.impl.BasketLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see BasketLocalService
 * @see org.gfbio.service.base.BasketLocalServiceBaseImpl
 * @see org.gfbio.service.impl.BasketLocalServiceImpl
 * @generated
 */
public class BasketLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.BasketLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the basket to the database. Also notifies the appropriate model listeners.
	*
	* @param basket the basket
	* @return the basket that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket addBasket(
		org.gfbio.model.Basket basket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBasket(basket);
	}

	/**
	* Creates a new basket with the primary key. Does not add the basket to the database.
	*
	* @param basketID the primary key for the new basket
	* @return the new basket
	*/
	public static org.gfbio.model.Basket createBasket(long basketID) {
		return getService().createBasket(basketID);
	}

	/**
	* Deletes the basket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param basketID the primary key of the basket
	* @return the basket that was removed
	* @throws PortalException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket deleteBasket(long basketID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBasket(basketID);
	}

	/**
	* Deletes the basket from the database. Also notifies the appropriate model listeners.
	*
	* @param basket the basket
	* @return the basket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket deleteBasket(
		org.gfbio.model.Basket basket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBasket(basket);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.gfbio.model.Basket fetchBasket(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBasket(basketID);
	}

	/**
	* Returns the basket with the primary key.
	*
	* @param basketID the primary key of the basket
	* @return the basket
	* @throws PortalException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket getBasket(long basketID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasket(basketID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the baskets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @return the range of baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> getBaskets(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBaskets(start, end);
	}

	/**
	* Returns the number of baskets.
	*
	* @return the number of baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int getBasketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsCount();
	}

	/**
	* Updates the basket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param basket the basket
	* @return the basket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket updateBasket(
		org.gfbio.model.Basket basket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBasket(basket);
	}

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

	public static com.liferay.portal.kernel.json.JSONArray getBasketById(
		long basketId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketById(basketId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBasketsByIds(
		long[] basketIds)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByIds(basketIds);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBasketsByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByUserAndPeriod(userId, period);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBasketsByUserId(
		long userId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsByUserId(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBasketsIdByUserAndPeriod(
		long userId, int period)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsIdByUserAndPeriod(userId, period);
	}

	public static com.liferay.portal.kernel.json.JSONArray getBasketsIdByUserId(
		long userId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBasketsIdByUserId(userId);
	}

	public static long updateBasket(long basketId, long userId,
		java.lang.String name, java.lang.String basketContent,
		java.lang.String queryJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBasket(basketId, userId, name, basketContent,
			queryJSON);
	}

	public static org.gfbio.model.Basket removeBasket(long basketId, long userId)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeBasket(basketId, userId);
	}

	public static java.util.Date getStartDateFromPeriod(int period) {
		return getService().getStartDateFromPeriod(period);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getBasketUsersIds(
		long userId) throws java.lang.Exception {
		return getService().getBasketUsersIds(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getUserDetail(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserDetail(userId);
	}

	public static com.liferay.portal.kernel.json.JSONArray authenticate(
		java.lang.String token) throws java.lang.Exception {
		return getService().authenticate(token);
	}

	public static java.lang.String getToken() {
		return getService().getToken();
	}

	public static void clearService() {
		_service = null;
	}

	public static BasketLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BasketLocalService.class.getName());

			if (invokableLocalService instanceof BasketLocalService) {
				_service = (BasketLocalService)invokableLocalService;
			}
			else {
				_service = new BasketLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BasketLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BasketLocalService service) {
	}

	private static BasketLocalService _service;
}