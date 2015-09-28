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

import org.gfbio.model.Cell;

/**
 * The persistence interface for the cell service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see CellPersistenceImpl
 * @see CellUtil
 * @generated
 */
public interface CellPersistence extends BasePersistence<Cell> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CellUtil} to access the cell persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the cell where cellID = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param cellID the cell i d
	* @return the matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell findByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByCellId(long cellID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @return the cell that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the number of cells where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell where content = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param content the content
	* @return the matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell findByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the cell where content = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param content the content
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell where content = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param content the content
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByContent(java.lang.String content,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cell where content = &#63; from the database.
	*
	* @param content the content
	* @return the cell that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell removeByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the number of cells where content = &#63;.
	*
	* @param content the content
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public int countByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cells where task = &#63;.
	*
	* @param task the task
	* @return the matching cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cells where task = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param task the task
	* @param start the lower bound of the range of cells
	* @param end the upper bound of the range of cells (not inclusive)
	* @return the range of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cells where task = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param task the task
	* @param start the lower bound of the range of cells
	* @param end the upper bound of the range of cells (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell findByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the first cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell findByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the last cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cells before and after the current cell in the ordered set where task = &#63;.
	*
	* @param cellID the primary key of the current cell
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cell
	* @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell[] findByTask_PrevAndNext(long cellID,
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Removes all the cells where task = &#63; from the database.
	*
	* @param task the task
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cells where task = &#63;.
	*
	* @param task the task
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public int countByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the cell in the entity cache if it is enabled.
	*
	* @param cell the cell
	*/
	public void cacheResult(org.gfbio.model.Cell cell);

	/**
	* Caches the cells in the entity cache if it is enabled.
	*
	* @param cells the cells
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Cell> cells);

	/**
	* Creates a new cell with the primary key. Does not add the cell to the database.
	*
	* @param cellID the primary key for the new cell
	* @return the new cell
	*/
	public org.gfbio.model.Cell create(long cellID);

	/**
	* Removes the cell with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cellID the primary key of the cell
	* @return the cell that was removed
	* @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell remove(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	public org.gfbio.model.Cell updateImpl(org.gfbio.model.Cell cell)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cell with the primary key or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param cellID the primary key of the cell
	* @return the cell
	* @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell findByPrimaryKey(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException;

	/**
	* Returns the cell with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cellID the primary key of the cell
	* @return the cell, or <code>null</code> if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Cell fetchByPrimaryKey(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cells.
	*
	* @return the cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cells.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cells
	* @param end the upper bound of the range of cells (not inclusive)
	* @return the range of cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cells.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cells
	* @param end the upper bound of the range of cells (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cells
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Cell> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cells from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cells.
	*
	* @return the number of cells
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}