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

import org.gfbio.model.Cell_Head;

import java.util.List;

/**
 * The persistence utility for the cell_ head service. This utility wraps {@link Cell_HeadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_HeadPersistence
 * @see Cell_HeadPersistenceImpl
 * @generated
 */
public class Cell_HeadUtil {
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
	public static void clearCache(Cell_Head cell_Head) {
		getPersistence().clearCache(cell_Head);
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
	public static List<Cell_Head> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cell_Head> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cell_Head> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Cell_Head update(Cell_Head cell_Head)
		throws SystemException {
		return getPersistence().update(cell_Head);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Cell_Head update(Cell_Head cell_Head,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cell_Head, serviceContext);
	}

	/**
	* Returns all the cell_ heads where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByCellId(
		long cellID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCellId(cellID);
	}

	/**
	* Returns a range of all the cell_ heads where cellID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellID the cell i d
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @return the range of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByCellId(
		long cellID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCellId(cellID, start, end);
	}

	/**
	* Returns an ordered range of all the cell_ heads where cellID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellID the cell i d
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByCellId(
		long cellID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCellId(cellID, start, end, orderByComparator);
	}

	/**
	* Returns the first cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByCellId_First(cellID, orderByComparator);
	}

	/**
	* Returns the first cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId_First(cellID, orderByComparator);
	}

	/**
	* Returns the last cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByCellId_Last(cellID, orderByComparator);
	}

	/**
	* Returns the last cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId_Last(cellID, orderByComparator);
	}

	/**
	* Returns the cell_ heads before and after the current cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cell_HeadPK the primary key of the current cell_ head
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head[] findByCellId_PrevAndNext(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK, long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence()
				   .findByCellId_PrevAndNext(cell_HeadPK, cellID,
			orderByComparator);
	}

	/**
	* Removes all the cell_ heads where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCellId(cellID);
	}

	/**
	* Returns the number of cell_ heads where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCellId(cellID);
	}

	/**
	* Returns all the cell_ heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByHeadId(
		long headID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID);
	}

	/**
	* Returns a range of all the cell_ heads where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @return the range of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByHeadId(
		long headID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID, start, end);
	}

	/**
	* Returns an ordered range of all the cell_ heads where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findByHeadId(
		long headID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHeadId(headID, start, end, orderByComparator);
	}

	/**
	* Returns the first cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the first cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the last cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByHeadId_Last(headID, orderByComparator);
	}

	/**
	* Returns the last cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_Last(headID, orderByComparator);
	}

	/**
	* Returns the cell_ heads before and after the current cell_ head in the ordered set where headID = &#63;.
	*
	* @param cell_HeadPK the primary key of the current cell_ head
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head[] findByHeadId_PrevAndNext(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence()
				   .findByHeadId_PrevAndNext(cell_HeadPK, headID,
			orderByComparator);
	}

	/**
	* Removes all the cell_ heads where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHeadId(headID);
	}

	/**
	* Returns the number of cell_ heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadId(headID);
	}

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByfindByPrimaryKey(
		long cellID, long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByfindByPrimaryKey(cellID, headID);
	}

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByfindByPrimaryKey(
		long cellID, long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByPrimaryKey(cellID, headID);
	}

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByfindByPrimaryKey(
		long cellID, long headID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByPrimaryKey(cellID, headID, retrieveFromCache);
	}

	/**
	* Removes the cell_ head where cellID = &#63; and headID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the cell_ head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head removeByfindByPrimaryKey(
		long cellID, long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().removeByfindByPrimaryKey(cellID, headID);
	}

	/**
	* Returns the number of cell_ heads where cellID = &#63; and headID = &#63;.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByPrimaryKey(long cellID, long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByPrimaryKey(cellID, headID);
	}

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param headID the head i d
	* @param column the column
	* @return the matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByHeadIdWithColumn(
		long headID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByHeadIdWithColumn(headID, column);
	}

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @param column the column
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByHeadIdWithColumn(
		long headID, int column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadIdWithColumn(headID, column);
	}

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param column the column
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByHeadIdWithColumn(
		long headID, int column, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHeadIdWithColumn(headID, column, retrieveFromCache);
	}

	/**
	* Removes the cell_ head where headID = &#63; and column = &#63; from the database.
	*
	* @param headID the head i d
	* @param column the column
	* @return the cell_ head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head removeByHeadIdWithColumn(
		long headID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().removeByHeadIdWithColumn(headID, column);
	}

	/**
	* Returns the number of cell_ heads where headID = &#63; and column = &#63;.
	*
	* @param headID the head i d
	* @param column the column
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadIdWithColumn(long headID, int column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadIdWithColumn(headID, column);
	}

	/**
	* Caches the cell_ head in the entity cache if it is enabled.
	*
	* @param cell_Head the cell_ head
	*/
	public static void cacheResult(org.gfbio.model.Cell_Head cell_Head) {
		getPersistence().cacheResult(cell_Head);
	}

	/**
	* Caches the cell_ heads in the entity cache if it is enabled.
	*
	* @param cell_Heads the cell_ heads
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Cell_Head> cell_Heads) {
		getPersistence().cacheResult(cell_Heads);
	}

	/**
	* Creates a new cell_ head with the primary key. Does not add the cell_ head to the database.
	*
	* @param cell_HeadPK the primary key for the new cell_ head
	* @return the new cell_ head
	*/
	public static org.gfbio.model.Cell_Head create(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK) {
		return getPersistence().create(cell_HeadPK);
	}

	/**
	* Removes the cell_ head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head that was removed
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head remove(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().remove(cell_HeadPK);
	}

	public static org.gfbio.model.Cell_Head updateImpl(
		org.gfbio.model.Cell_Head cell_Head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cell_Head);
	}

	/**
	* Returns the cell_ head with the primary key or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head findByPrimaryKey(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException {
		return getPersistence().findByPrimaryKey(cell_HeadPK);
	}

	/**
	* Returns the cell_ head with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head, or <code>null</code> if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Head fetchByPrimaryKey(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cell_HeadPK);
	}

	/**
	* Returns all the cell_ heads.
	*
	* @return the cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cell_ heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @return the range of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cell_ heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ heads
	* @param end the upper bound of the range of cell_ heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Head> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cell_ heads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cell_ heads.
	*
	* @return the number of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Cell_HeadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Cell_HeadPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Cell_HeadPersistence.class.getName());

			ReferenceRegistry.registerReference(Cell_HeadUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Cell_HeadPersistence persistence) {
	}

	private static Cell_HeadPersistence _persistence;
}