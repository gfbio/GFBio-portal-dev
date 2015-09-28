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

import org.gfbio.model.Cell_Position;

/**
 * The persistence interface for the cell_ position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_PositionPersistenceImpl
 * @see Cell_PositionUtil
 * @generated
 */
public interface Cell_PositionPersistence extends BasePersistence<Cell_Position> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Cell_PositionUtil} to access the cell_ position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cell_ positions where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findByCellId(
		long cellID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the first cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the last cell_ position in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Cell_Position[] findByCellId_PrevAndNext(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK,
		long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Removes all the cell_ positions where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ positions where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cell_ positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findByPositionId(
		long positionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByPositionId_First(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the first cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByPositionId_First(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByPositionId_Last(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the last cell_ position in the ordered set where positionID = &#63;.
	*
	* @param positionID the position i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByPositionId_Last(
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Cell_Position[] findByPositionId_PrevAndNext(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK,
		long positionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Removes all the cell_ positions where positionID = &#63; from the database.
	*
	* @param positionID the position i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPositionId(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByfindByPrimaryKey(long cellID,
		long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByfindByPrimaryKey(long cellID,
		long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByfindByPrimaryKey(long cellID,
		long positionID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell_ position where cellID = &#63; and positionID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the cell_ position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position removeByfindByPrimaryKey(long cellID,
		long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the number of cell_ positions where cellID = &#63; and positionID = &#63;.
	*
	* @param cellID the cell i d
	* @param positionID the position i d
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByPrimaryKey(long cellID, long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the matching cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param positionID the position i d
	* @param column the column
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByPositionIdWithColumn(
		long positionID, int column, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell_ position where positionID = &#63; and column = &#63; from the database.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the cell_ position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position removeByPositionIdWithColumn(
		long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the number of cell_ positions where positionID = &#63; and column = &#63;.
	*
	* @param positionID the position i d
	* @param column the column
	* @return the number of matching cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPositionIdWithColumn(long positionID, int column)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cell_ position in the entity cache if it is enabled.
	*
	* @param cell_Position the cell_ position
	*/
	public void cacheResult(org.gfbio.model.Cell_Position cell_Position);

	/**
	* Caches the cell_ positions in the entity cache if it is enabled.
	*
	* @param cell_Positions the cell_ positions
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Cell_Position> cell_Positions);

	/**
	* Creates a new cell_ position with the primary key. Does not add the cell_ position to the database.
	*
	* @param cell_PositionPK the primary key for the new cell_ position
	* @return the new cell_ position
	*/
	public org.gfbio.model.Cell_Position create(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK);

	/**
	* Removes the cell_ position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position that was removed
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position remove(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	public org.gfbio.model.Cell_Position updateImpl(
		org.gfbio.model.Cell_Position cell_Position)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ position with the primary key or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position
	* @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position findByPrimaryKey(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_PositionException;

	/**
	* Returns the cell_ position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cell_PositionPK the primary key of the cell_ position
	* @return the cell_ position, or <code>null</code> if a cell_ position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Position fetchByPrimaryKey(
		org.gfbio.service.persistence.Cell_PositionPK cell_PositionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cell_ positions.
	*
	* @return the cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Position> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Position> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cell_ positions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ positions.
	*
	* @return the number of cell_ positions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}