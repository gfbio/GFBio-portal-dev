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

import org.gfbio.model.Cell_Head;

/**
 * The persistence interface for the cell_ head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_HeadPersistenceImpl
 * @see Cell_HeadUtil
 * @generated
 */
public interface Cell_HeadPersistence extends BasePersistence<Cell_Head> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Cell_HeadUtil} to access the cell_ head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cell_ heads where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Head> findByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findByCellId(long cellID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findByCellId(long cellID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the first cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByCellId_First(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the last cell_ head in the ordered set where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByCellId_Last(long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Cell_Head[] findByCellId_PrevAndNext(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK, long cellID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Removes all the cell_ heads where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ heads where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cell_ heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Head> findByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findByHeadId(long headID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findByHeadId(long headID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the first cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the last cell_ head in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Cell_Head[] findByHeadId_PrevAndNext(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Removes all the cell_ heads where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByfindByPrimaryKey(long cellID,
		long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByfindByPrimaryKey(long cellID,
		long headID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByfindByPrimaryKey(long cellID,
		long headID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell_ head where cellID = &#63; and headID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the cell_ head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head removeByfindByPrimaryKey(long cellID,
		long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the number of cell_ heads where cellID = &#63; and headID = &#63;.
	*
	* @param cellID the cell i d
	* @param headID the head i d
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByPrimaryKey(long cellID, long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param headID the head i d
	* @param column the column
	* @return the matching cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByHeadIdWithColumn(long headID,
		int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @param column the column
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByHeadIdWithColumn(long headID,
		int column) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param column the column
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByHeadIdWithColumn(long headID,
		int column, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell_ head where headID = &#63; and column = &#63; from the database.
	*
	* @param headID the head i d
	* @param column the column
	* @return the cell_ head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head removeByHeadIdWithColumn(long headID,
		int column)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the number of cell_ heads where headID = &#63; and column = &#63;.
	*
	* @param headID the head i d
	* @param column the column
	* @return the number of matching cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadIdWithColumn(long headID, int column)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cell_ head in the entity cache if it is enabled.
	*
	* @param cell_Head the cell_ head
	*/
	public void cacheResult(org.gfbio.model.Cell_Head cell_Head);

	/**
	* Caches the cell_ heads in the entity cache if it is enabled.
	*
	* @param cell_Heads the cell_ heads
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Cell_Head> cell_Heads);

	/**
	* Creates a new cell_ head with the primary key. Does not add the cell_ head to the database.
	*
	* @param cell_HeadPK the primary key for the new cell_ head
	* @return the new cell_ head
	*/
	public org.gfbio.model.Cell_Head create(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK);

	/**
	* Removes the cell_ head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head that was removed
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head remove(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	public org.gfbio.model.Cell_Head updateImpl(
		org.gfbio.model.Cell_Head cell_Head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell_ head with the primary key or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head
	* @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head findByPrimaryKey(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCell_HeadException;

	/**
	* Returns the cell_ head with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cell_HeadPK the primary key of the cell_ head
	* @return the cell_ head, or <code>null</code> if a cell_ head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell_Head fetchByPrimaryKey(
		org.gfbio.service.persistence.Cell_HeadPK cell_HeadPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cell_ heads.
	*
	* @return the cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell_Head> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Cell_Head> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cell_ heads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cell_ heads.
	*
	* @return the number of cell_ heads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}