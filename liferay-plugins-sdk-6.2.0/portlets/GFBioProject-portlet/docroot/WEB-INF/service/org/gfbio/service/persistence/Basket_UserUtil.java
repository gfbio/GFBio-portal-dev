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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.Basket_User;

import java.util.List;

/**
 * The persistence utility for the basket_ user service. This utility wraps {@link Basket_UserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Basket_UserPersistence
 * @see Basket_UserPersistenceImpl
 * @generated
 */
public class Basket_UserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Basket_User basket_User) {
		getPersistence().clearCache(basket_User);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Basket_User> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Basket_User> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Basket_User> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Basket_User update(Basket_User basket_User)
		throws SystemException {
		return getPersistence().update(basket_User);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Basket_User update(Basket_User basket_User,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(basket_User, serviceContext);
	}

	/**
	* Returns all the basket_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket_User> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the basket_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of basket_ users
	* @param end the upper bound of the range of basket_ users (not inclusive)
	* @return the range of matching basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket_User> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the basket_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of basket_ users
	* @param end the upper bound of the range of basket_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket_User> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first basket_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket_ user
	* @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first basket_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User fetchByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last basket_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket_ user
	* @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last basket_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the basket_ users before and after the current basket_ user in the ordered set where userID = &#63;.
	*
	* @param basketID the primary key of the current basket_ user
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next basket_ user
	* @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User[] findByUserID_PrevAndNext(
		long basketID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence()
				   .findByUserID_PrevAndNext(basketID, userID, orderByComparator);
	}

	/**
	* Removes all the basket_ users where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of basket_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Returns the basket_ user where basketID = &#63; or throws a {@link org.gfbio.NoSuchBasket_UserException} if it could not be found.
	*
	* @param basketID the basket i d
	* @return the matching basket_ user
	* @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User findByBasketID(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().findByBasketID(basketID);
	}

	/**
	* Returns the basket_ user where basketID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param basketID the basket i d
	* @return the matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User fetchByBasketID(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBasketID(basketID);
	}

	/**
	* Returns the basket_ user where basketID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param basketID the basket i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User fetchByBasketID(long basketID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBasketID(basketID, retrieveFromCache);
	}

	/**
	* Removes the basket_ user where basketID = &#63; from the database.
	*
	* @param basketID the basket i d
	* @return the basket_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User removeByBasketID(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().removeByBasketID(basketID);
	}

	/**
	* Returns the number of basket_ users where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the number of matching basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBasketID(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBasketID(basketID);
	}

	/**
	* Caches the basket_ user in the entity cache if it is enabled.
	*
	* @param basket_User the basket_ user
	*/
	public static void cacheResult(org.gfbio.model.Basket_User basket_User) {
		getPersistence().cacheResult(basket_User);
	}

	/**
	* Caches the basket_ users in the entity cache if it is enabled.
	*
	* @param basket_Users the basket_ users
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Basket_User> basket_Users) {
		getPersistence().cacheResult(basket_Users);
	}

	/**
	* Creates a new basket_ user with the primary key. Does not add the basket_ user to the database.
	*
	* @param basketID the primary key for the new basket_ user
	* @return the new basket_ user
	*/
	public static org.gfbio.model.Basket_User create(long basketID) {
		return getPersistence().create(basketID);
	}

	/**
	* Removes the basket_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param basketID the primary key of the basket_ user
	* @return the basket_ user that was removed
	* @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User remove(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().remove(basketID);
	}

	public static org.gfbio.model.Basket_User updateImpl(
		org.gfbio.model.Basket_User basket_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(basket_User);
	}

	/**
	* Returns the basket_ user with the primary key or throws a {@link org.gfbio.NoSuchBasket_UserException} if it could not be found.
	*
	* @param basketID the primary key of the basket_ user
	* @return the basket_ user
	* @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User findByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasket_UserException {
		return getPersistence().findByPrimaryKey(basketID);
	}

	/**
	* Returns the basket_ user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param basketID the primary key of the basket_ user
	* @return the basket_ user, or <code>null</code> if a basket_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket_User fetchByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(basketID);
	}

	/**
	* Returns all the basket_ users.
	*
	* @return the basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket_User> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gfbio.model.Basket_User> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the basket_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of basket_ users
	* @param end the upper bound of the range of basket_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket_User> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the basket_ users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of basket_ users.
	*
	* @return the number of basket_ users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Basket_UserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Basket_UserPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Basket_UserPersistence.class.getName());

			ReferenceRegistry.registerReference(Basket_UserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Basket_UserPersistence persistence) {
	}

	private static Basket_UserPersistence _persistence;
}