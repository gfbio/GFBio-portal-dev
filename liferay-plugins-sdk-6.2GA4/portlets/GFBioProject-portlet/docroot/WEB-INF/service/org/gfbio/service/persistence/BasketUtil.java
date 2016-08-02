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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.Basket;

import java.util.List;

/**
 * The persistence utility for the basket service. This utility wraps {@link BasketPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see BasketPersistence
 * @see BasketPersistenceImpl
 * @generated
 */
public class BasketUtil {
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
	public static void clearCache(Basket basket) {
		getPersistence().clearCache(basket);
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
	public static List<Basket> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Basket> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Basket> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Basket update(Basket basket) throws SystemException {
		return getPersistence().update(basket);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Basket update(Basket basket, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(basket, serviceContext);
	}

	/**
	* Returns all the baskets where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserId(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userID);
	}

	/**
	* Returns a range of all the baskets where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @return the range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserId(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userID, start, end);
	}

	/**
	* Returns an ordered range of all the baskets where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserId(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByUserId_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().findByUserId_First(userID, orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByUserId_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userID, orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByUserId_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().findByUserId_Last(userID, orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByUserId_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userID, orderByComparator);
	}

	/**
	* Returns the baskets before and after the current basket in the ordered set where userID = &#63;.
	*
	* @param basketID the primary key of the current basket
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next basket
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket[] findByUserId_PrevAndNext(
		long basketID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence()
				   .findByUserId_PrevAndNext(basketID, userID, orderByComparator);
	}

	/**
	* Removes all the baskets where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userID);
	}

	/**
	* Returns the number of baskets where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userID);
	}

	/**
	* Returns all the baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdSince(userID, lastModifiedDate);
	}

	/**
	* Returns a range of all the baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @return the range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdSince(userID, lastModifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdSince(userID, lastModifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByUserIdSince_First(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence()
				   .findByUserIdSince_First(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByUserIdSince_First(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdSince_First(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByUserIdSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence()
				   .findByUserIdSince_Last(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByUserIdSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdSince_Last(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the baskets before and after the current basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param basketID the primary key of the current basket
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next basket
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket[] findByUserIdSince_PrevAndNext(
		long basketID, long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence()
				   .findByUserIdSince_PrevAndNext(basketID, userID,
			lastModifiedDate, orderByComparator);
	}

	/**
	* Removes all the baskets where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdSince(long userID,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdSince(userID, lastModifiedDate);
	}

	/**
	* Returns the number of baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdSince(long userID,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdSince(userID, lastModifiedDate);
	}

	/**
	* Returns the basket where basketID = &#63; or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	*
	* @param basketID the basket i d
	* @return the matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().findByBasketId(basketID);
	}

	/**
	* Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param basketID the basket i d
	* @return the matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBasketId(basketID);
	}

	/**
	* Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param basketID the basket i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByBasketId(long basketID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBasketId(basketID, retrieveFromCache);
	}

	/**
	* Removes the basket where basketID = &#63; from the database.
	*
	* @param basketID the basket i d
	* @return the basket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket removeByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().removeByBasketId(basketID);
	}

	/**
	* Returns the number of baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBasketId(basketID);
	}

	/**
	* Returns all the baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBasketIds(basketID);
	}

	/**
	* Returns a range of all the baskets where basketID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param basketID the basket i d
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @return the range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long basketID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBasketIds(basketID, start, end);
	}

	/**
	* Returns an ordered range of all the baskets where basketID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param basketID the basket i d
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long basketID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBasketIds(basketID, start, end, orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByBasketIds_First(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence()
				   .findByBasketIds_First(basketID, orderByComparator);
	}

	/**
	* Returns the first basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByBasketIds_First(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBasketIds_First(basketID, orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByBasketIds_Last(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().findByBasketIds_Last(basketID, orderByComparator);
	}

	/**
	* Returns the last basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByBasketIds_Last(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBasketIds_Last(basketID, orderByComparator);
	}

	/**
	* Returns all the baskets where basketID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param basketIDs the basket i ds
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBasketIds(basketIDs);
	}

	/**
	* Returns a range of all the baskets where basketID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param basketIDs the basket i ds
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @return the range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBasketIds(basketIDs, start, end);
	}

	/**
	* Returns an ordered range of all the baskets where basketID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param basketIDs the basket i ds
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBasketIds(basketIDs, start, end, orderByComparator);
	}

	/**
	* Removes all the baskets where basketID = &#63; from the database.
	*
	* @param basketID the basket i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBasketIds(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBasketIds(basketID);
	}

	/**
	* Returns the number of baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBasketIds(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBasketIds(basketID);
	}

	/**
	* Returns the number of baskets where basketID = any &#63;.
	*
	* @param basketIDs the basket i ds
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBasketIds(long[] basketIDs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBasketIds(basketIDs);
	}

	/**
	* Caches the basket in the entity cache if it is enabled.
	*
	* @param basket the basket
	*/
	public static void cacheResult(org.gfbio.model.Basket basket) {
		getPersistence().cacheResult(basket);
	}

	/**
	* Caches the baskets in the entity cache if it is enabled.
	*
	* @param baskets the baskets
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Basket> baskets) {
		getPersistence().cacheResult(baskets);
	}

	/**
	* Creates a new basket with the primary key. Does not add the basket to the database.
	*
	* @param basketID the primary key for the new basket
	* @return the new basket
	*/
	public static org.gfbio.model.Basket create(long basketID) {
		return getPersistence().create(basketID);
	}

	/**
	* Removes the basket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param basketID the primary key of the basket
	* @return the basket that was removed
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket remove(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().remove(basketID);
	}

	public static org.gfbio.model.Basket updateImpl(
		org.gfbio.model.Basket basket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(basket);
	}

	/**
	* Returns the basket with the primary key or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	*
	* @param basketID the primary key of the basket
	* @return the basket
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket findByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException {
		return getPersistence().findByPrimaryKey(basketID);
	}

	/**
	* Returns the basket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param basketID the primary key of the basket
	* @return the basket, or <code>null</code> if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Basket fetchByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(basketID);
	}

	/**
	* Returns all the baskets.
	*
	* @return the baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gfbio.model.Basket> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the baskets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of baskets
	* @param end the upper bound of the range of baskets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of baskets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Basket> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the baskets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of baskets.
	*
	* @return the number of baskets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BasketPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BasketPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					BasketPersistence.class.getName());

			ReferenceRegistry.registerReference(BasketUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BasketPersistence persistence) {
	}

	private static BasketPersistence _persistence;
}