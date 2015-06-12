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

import org.gfbio.model.Cell;

import java.util.List;

/**
 * The persistence utility for the cell service. This utility wraps {@link CellPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see CellPersistence
 * @see CellPersistenceImpl
 * @generated
 */
public class CellUtil {
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
	public static void clearCache(Cell cell) {
		getPersistence().clearCache(cell);
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
	public static List<Cell> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cell> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cell> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Cell update(Cell cell) throws SystemException {
		return getPersistence().update(cell);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Cell update(Cell cell, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(cell, serviceContext);
	}

	/**
	* Returns the cell where cellID = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param cellID the cell i d
	* @return the matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell findByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().findByCellId(cellID);
	}

	/**
	* Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param cellID the cell i d
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId(cellID);
	}

	/**
	* Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param cellID the cell i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByCellId(long cellID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCellId(cellID, retrieveFromCache);
	}

	/**
	* Removes the cell where cellID = &#63; from the database.
	*
	* @param cellID the cell i d
	* @return the cell that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell removeByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().removeByCellId(cellID);
	}

	/**
	* Returns the number of cells where cellID = &#63;.
	*
	* @param cellID the cell i d
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCellId(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCellId(cellID);
	}

	/**
	* Returns the cell where content = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param content the content
	* @return the matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell findByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().findByContent(content);
	}

	/**
	* Returns the cell where content = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param content the content
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContent(content);
	}

	/**
	* Returns the cell where content = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param content the content
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByContent(
		java.lang.String content, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByContent(content, retrieveFromCache);
	}

	/**
	* Removes the cell where content = &#63; from the database.
	*
	* @param content the content
	* @return the cell that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell removeByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().removeByContent(content);
	}

	/**
	* Returns the number of cells where content = &#63;.
	*
	* @param content the content
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContent(java.lang.String content)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContent(content);
	}

	/**
	* Returns all the cells where task = &#63;.
	*
	* @param task the task
	* @return the matching cells
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task);
	}

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
	public static java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Cell> findByTask(
		java.lang.String task, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task, start, end, orderByComparator);
	}

	/**
	* Returns the first cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell findByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().findByTask_First(task, orderByComparator);
	}

	/**
	* Returns the first cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByTask_First(
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTask_First(task, orderByComparator);
	}

	/**
	* Returns the last cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell
	* @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell findByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().findByTask_Last(task, orderByComparator);
	}

	/**
	* Returns the last cell in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cell, or <code>null</code> if a matching cell could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTask_Last(task, orderByComparator);
	}

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
	public static org.gfbio.model.Cell[] findByTask_PrevAndNext(long cellID,
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence()
				   .findByTask_PrevAndNext(cellID, task, orderByComparator);
	}

	/**
	* Removes all the cells where task = &#63; from the database.
	*
	* @param task the task
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTask(task);
	}

	/**
	* Returns the number of cells where task = &#63;.
	*
	* @param task the task
	* @return the number of matching cells
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTask(task);
	}

	/**
	* Caches the cell in the entity cache if it is enabled.
	*
	* @param cell the cell
	*/
	public static void cacheResult(org.gfbio.model.Cell cell) {
		getPersistence().cacheResult(cell);
	}

	/**
	* Caches the cells in the entity cache if it is enabled.
	*
	* @param cells the cells
	*/
	public static void cacheResult(java.util.List<org.gfbio.model.Cell> cells) {
		getPersistence().cacheResult(cells);
	}

	/**
	* Creates a new cell with the primary key. Does not add the cell to the database.
	*
	* @param cellID the primary key for the new cell
	* @return the new cell
	*/
	public static org.gfbio.model.Cell create(long cellID) {
		return getPersistence().create(cellID);
	}

	/**
	* Removes the cell with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cellID the primary key of the cell
	* @return the cell that was removed
	* @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell remove(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().remove(cellID);
	}

	public static org.gfbio.model.Cell updateImpl(org.gfbio.model.Cell cell)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cell);
	}

	/**
	* Returns the cell with the primary key or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	*
	* @param cellID the primary key of the cell
	* @return the cell
	* @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell findByPrimaryKey(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchCellException {
		return getPersistence().findByPrimaryKey(cellID);
	}

	/**
	* Returns the cell with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cellID the primary key of the cell
	* @return the cell, or <code>null</code> if a cell with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Cell fetchByPrimaryKey(long cellID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cellID);
	}

	/**
	* Returns all the cells.
	*
	* @return the cells
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Cell> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gfbio.model.Cell> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gfbio.model.Cell> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cells from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cells.
	*
	* @return the number of cells
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CellPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CellPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					CellPersistence.class.getName());

			ReferenceRegistry.registerReference(CellUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CellPersistence persistence) {
	}

	private static CellPersistence _persistence;
}