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
 * Provides a wrapper for {@link Basket_UserLocalService}.
 *
 * @author Felicitas Loeffler
 * @see Basket_UserLocalService
 * @generated
 */
public class Basket_UserLocalServiceWrapper implements Basket_UserLocalService,
	ServiceWrapper<Basket_UserLocalService> {
	public Basket_UserLocalServiceWrapper(
		Basket_UserLocalService basket_UserLocalService) {
		_basket_UserLocalService = basket_UserLocalService;
	}

	/**
	* Adds the basket_ user to the database. Also notifies the appropriate model listeners.
	*
	* @param basket_User the basket_ user
	* @return the basket_ user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Basket_User addBasket_User(
		org.gfbio.model.Basket_User basket_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.addBasket_User(basket_User);
	}

	/**
	* Creates a new basket_ user with the primary key. Does not add the basket_ user to the database.
	*
	* @param basketID the primary key for the new basket_ user
	* @return the new basket_ user
	*/
	@Override
	public org.gfbio.model.Basket_User createBasket_User(long basketID) {
		return _basket_UserLocalService.createBasket_User(basketID);
	}

	/**
	* Deletes the basket_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param basketID the primary key of the basket_ user
	* @return the basket_ user that was removed
	* @throws PortalException if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Basket_User deleteBasket_User(long basketID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.deleteBasket_User(basketID);
	}

	/**
	* Deletes the basket_ user from the database. Also notifies the appropriate model listeners.
	*
	* @param basket_User the basket_ user
	* @return the basket_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Basket_User deleteBasket_User(
		org.gfbio.model.Basket_User basket_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.deleteBasket_User(basket_User);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _basket_UserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.Basket_User fetchBasket_User(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.fetchBasket_User(basketID);
	}

	/**
	* Returns the basket_ user with the primary key.
	*
	* @param basketID the primary key of the basket_ user
	* @return the basket_ user
	* @throws PortalException if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Basket_User getBasket_User(long basketID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.getBasket_User(basketID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the basket_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of basket_ users
	* @param end the upper bound of the range of basket_ users (not inclusive)
	* @return the range of basket_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Basket_User> getBasket_Users(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.getBasket_Users(start, end);
	}

	/**
	* Returns the number of basket_ users.
	*
	* @return the number of basket_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBasket_UsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.getBasket_UsersCount();
	}

	/**
	* Updates the basket_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param basket_User the basket_ user
	* @return the basket_ user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Basket_User updateBasket_User(
		org.gfbio.model.Basket_User basket_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.updateBasket_User(basket_User);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _basket_UserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_basket_UserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _basket_UserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<org.gfbio.model.Basket_User> getBasket_UserList(
		long userID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.getBasket_UserList(userID);
	}

	@Override
	public long updateBasket(long basketID, long userID, java.lang.String name,
		java.lang.String basketJSON)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.updateBasket(basketID, userID, name,
			basketJSON);
	}

	@Override
	public org.gfbio.model.Basket_User removeBasket_User(long basketID)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _basket_UserLocalService.removeBasket_User(basketID);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Basket_UserLocalService getWrappedBasket_UserLocalService() {
		return _basket_UserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBasket_UserLocalService(
		Basket_UserLocalService basket_UserLocalService) {
		_basket_UserLocalService = basket_UserLocalService;
	}

	@Override
	public Basket_UserLocalService getWrappedService() {
		return _basket_UserLocalService;
	}

	@Override
	public void setWrappedService(
		Basket_UserLocalService basket_UserLocalService) {
		_basket_UserLocalService = basket_UserLocalService;
	}

	private Basket_UserLocalService _basket_UserLocalService;
}