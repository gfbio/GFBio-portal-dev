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

import org.gfbio.model.Cell_Position;

import java.util.List;

/**
 * The persistence utility for the cell_ position service. This utility wraps {@link Cell_PositionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_PositionPersistence
 * @see Cell_PositionPersistenceImpl
 * @generated
 */
public class Cell_PositionUtil {
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
	public static void clearCache(Cell_Position cell_Position) {
		getPersistence().clearCache(cell_Position);
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
	public static List<Cell_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cell_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cell_Position> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Cell_Position update(Cell_Position cell_Position)
		throws SystemException {
		return getPersistence().update(cell_Position);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Cell_Position update(Cell_Position cell_Position,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cell_Position, serviceContext);
	}

	/**
	* Returns all the cell_ positions where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCellId(cellID);
	}

	/**
	* Returns a range of all the cell_ positions where cellID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellID the cell i d
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @return the range of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCellId(cellID, start, end);
	}

	/**
	* Returns an ordered range of all the cell_ positions where cellID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellID the cell i d
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCellId(cellID, start, end, orderByComparator);
	}

	/**
	* Returns the first cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByCellId_First(
		long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().findByCellId_First(cellID, orderByComparator);
	}

	/**
	* Returns the first cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByCellId_First(
		long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId_First(cellID, orderByComparator);
	}

	/**
	* Returns the last cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().findByCellId_Last(cellID, orderByComparator);
	}

	/**
	* Returns the last cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByCellId_Last(
		long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId_Last(cellID, orderByComparator);
	}

	/**
	* Returns the cell_ positions before and after the current cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cell_PositionPK the primary key of the current cell_ position
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position[] findByCellId_PrevAndNext(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK,
		long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence()
				   .findByCellId_PrevAndNext(cell_PositionPK, cellID,
			orderByComparator);
	}

	/**
	* Removes all the cell_ positions where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCellId(cellID);
	}

	/**
	* Returns the number of cell_ positions where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCellId(cellID);
	}

	/**
	* Returns all the cell_ positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPositionId(positionID);
	}

	/**
	* Returns a range of all the cell_ positions where positionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param positionID the position i d
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @return the range of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPositionId(positionID, start, end);
	}

	/**
	* Returns an ordered range of all the cell_ positions where positionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param positionID the position i d
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPositionId(positionID, start, end, orderByComparator);
	}

	/**
	* Returns the first cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByPositionId_First(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence()
				   .findByPositionId_First(positionID, orderByComparator);
	}

	/**
	* Returns the first cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByPositionId_First(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPositionId_First(positionID, orderByComparator);
	}

	/**
	* Returns the last cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByPositionId_Last(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence()
				   .findByPositionId_Last(positionID, orderByComparator);
	}

	/**
	* Returns the last cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByPositionId_Last(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPositionId_Last(positionID, orderByComparator);
	}

	/**
	* Returns the cell_ positions before and after the current cell_ position in the ordered set where positionID = &#63;.
	*
	* @param cell_PositionPK the primary key of the current cell_ position
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position[] findByPositionId_PrevAndNext(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK,
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence()
				   .findByPositionId_PrevAndNext(cell_PositionPK, positionID,
			orderByComparator);
	}

	/**
	* Removes all the cell_ positions where positionID = &#63; from the database.
	*
	* @param positionID the position i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPositionId(positionID);
	}

	/**
	* Returns the number of cell_ positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPositionId(positionID);
	}

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByfindByPrimaryKey(
		long cellID, long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().findByfindByPrimaryKey(cellID, positionID);
	}

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByfindByPrimaryKey(
		long cellID, long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfindByPrimaryKey(cellID, positionID);
	}

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByfindByPrimaryKey(
		long cellID, long positionID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByPrimaryKey(cellID, positionID,
			retrieveFromCache);
	}

	/**
	* Removes the cell_ position where cellID = &#63; and positionID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the cell_ position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position removeByfindByPrimaryKey(
		long cellID, long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().removeByfindByPrimaryKey(cellID, positionID);
	}

	/**
	* Returns the number of cell_ positions where cellID = &#63; and positionID = &#63;.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByPrimaryKey(long cellID, long positionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfindByPrimaryKey(cellID, positionID);
	}

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().findByPositionIdWithColumn(positionID, column);
	}

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPositionIdWithColumn(positionID, column);
	}

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param positionID the position i d
	* @param column the column
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByPositionIdWithColumn(
		long positionID, int column, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPositionIdWithColumn(positionID, column,
			retrieveFromCache);
	}

	/**
	* Removes the cell_ position where positionID = &#63; and column = &#63; from the database.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the cell_ position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position removeByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().removeByPositionIdWithColumn(positionID, column);
	}

	/**
	* Returns the number of cell_ positions where positionID = &#63; and column = &#63;.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPositionIdWithColumn(long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPositionIdWithColumn(positionID, column);
	}

	/**
	* Caches the cell_ position in the entity cache if it is enabled.
	*
	* @param cell_Position the cell_ position
	*/
	public static void cacheResult(org.gfbio.model.Cell_Position cell_Position) {
		getPersistence().cacheResult(cell_Position);
	}

	/**
	* Caches the cell_ positions in the entity cache if it is enabled.
	*
	* @param cell_Positions the cell_ positions
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Cell_Position> cell_Positions) {
		getPersistence().cacheResult(cell_Positions);
	}

	/**
	* Creates a new cell_ position with the primary key. Does not add the cell_ position to the database.
	*
	* @param cell_PositionPK the primary key for the new cell_ position
	* @return the new cell_ position
	*/
	public static org.gfbio.model.Cell_Position create(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK) {
		return getPersistence().create(cell_PositionPK);
	}

	/**
	* Removes the cell_ position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position that was removed
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position remove(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().remove(cell_PositionPK);
	}

	public static org.gfbio.model.Cell_Position updateImpl(
		org.gfbio.model.Cell_Position cell_Position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cell_Position);
	}

	/**
	* Returns the cell_ position with the primary key or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position findByPrimaryKey(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException {
		return getPersistence().findByPrimaryKey(cell_PositionPK);
	}

	/**
	* Returns the cell_ position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position, or <code>null</code> if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell_Position fetchByPrimaryKey(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cell_PositionPK);
	}

	/**
	* Returns all the cell_ positions.
	*
	* @return the cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cell_ positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @return the range of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cell_ positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cell_ positions
	* @param end the upper bound of the range of cell_ positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell_Position> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cell_ positions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cell_ positions.
	*
	* @return the number of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Cell_PositionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Cell_PositionPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Cell_PositionPersistence.class.getName());

			ReferenceRegistry.registerReference(Cell_PositionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Cell_PositionPersistence persistence) {
	}

	private static Cell_PositionPersistence _persistence;
}