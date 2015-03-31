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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.Basket;

/**
 * The persistence interface for the basket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see BasketPersistenceImpl
 * @see BasketUtil
 * @generated
 */
public interface BasketPersistence extends BasePersistence<Basket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BasketUtil} to access the basket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the baskets where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Basket> findByUserId(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByUserId(long userID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByUserId(long userID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByUserId_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the first basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByUserId_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByUserId_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the last basket in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByUserId_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Basket[] findByUserId_PrevAndNext(long basketID,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Removes all the baskets where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baskets where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByUserIdSince(
		long userID, java.util.Date lastModifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Basket findByUserIdSince_First(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the first basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByUserIdSince_First(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Basket findByUserIdSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the last basket in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByUserIdSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Basket[] findByUserIdSince_PrevAndNext(
		long basketID, long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Removes all the baskets where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdSince(long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baskets where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdSince(long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the basket where basketID = &#63; or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	*
	* @param basketID the basket i d
	* @return the matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param basketID the basket i d
	* @return the matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param basketID the basket i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByBasketId(long basketID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the basket where basketID = &#63; from the database.
	*
	* @param basketID the basket i d
	* @return the basket that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket removeByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the number of baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countByBasketId(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long basketID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long basketID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByBasketIds_First(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the first basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByBasketIds_First(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket
	* @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByBasketIds_Last(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the last basket in the ordered set where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching basket, or <code>null</code> if a matching basket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByBasketIds_Last(long basketID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findByBasketIds(
		long[] basketIDs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the baskets where basketID = &#63; from the database.
	*
	* @param basketID the basket i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBasketIds(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baskets where basketID = &#63;.
	*
	* @param basketID the basket i d
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countByBasketIds(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baskets where basketID = any &#63;.
	*
	* @param basketIDs the basket i ds
	* @return the number of matching baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countByBasketIds(long[] basketIDs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the basket in the entity cache if it is enabled.
	*
	* @param basket the basket
	*/
	public void cacheResult(org.gfbio.model.Basket basket);

	/**
	* Caches the baskets in the entity cache if it is enabled.
	*
	* @param baskets the baskets
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Basket> baskets);

	/**
	* Creates a new basket with the primary key. Does not add the basket to the database.
	*
	* @param basketID the primary key for the new basket
	* @return the new basket
	*/
	public org.gfbio.model.Basket create(long basketID);

	/**
	* Removes the basket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param basketID the primary key of the basket
	* @return the basket that was removed
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket remove(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	public org.gfbio.model.Basket updateImpl(org.gfbio.model.Basket basket)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the basket with the primary key or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	*
	* @param basketID the primary key of the basket
	* @return the basket
	* @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket findByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchBasketException;

	/**
	* Returns the basket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param basketID the primary key of the basket
	* @return the basket, or <code>null</code> if a basket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Basket fetchByPrimaryKey(long basketID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the baskets.
	*
	* @return the baskets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Basket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Basket> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the baskets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of baskets.
	*
	* @return the number of baskets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}