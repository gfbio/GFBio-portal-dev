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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.Column;

/**
 * The persistence interface for the column service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ColumnPersistenceImpl
 * @see ColumnUtil
 * @generated
 */
public interface ColumnPersistence extends BasePersistence<Column> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColumnUtil} to access the column persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the column where columnID = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param columnID the column i d
	* @return the matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param columnID the column i d
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param columnID the column i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByColumnId(long columnID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the column where columnID = &#63; from the database.
	*
	* @param columnID the column i d
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column removeByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the number of columns where columnID = &#63;.
	*
	* @param columnID the column i d
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the column where column_name = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param column_name the column_name
	* @return the matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByColumnName(java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param column_name the column_name
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByColumnName(
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param column_name the column_name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByColumnName(
		java.lang.String column_name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the column where column_name = &#63; from the database.
	*
	* @param column_name the column_name
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column removeByColumnName(
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the number of columns where column_name = &#63;.
	*
	* @param column_name the column_name
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumnName(java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the columns where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the columns where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @return the range of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadId(long headID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the columns where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadId(long headID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the first column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the last column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the columns before and after the current column in the ordered set where headID = &#63;.
	*
	* @param columnID the primary key of the current column
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next column
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column[] findByHeadId_PrevAndNext(long columnID,
		long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Removes all the columns where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of columns where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the columns where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @return the matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the columns where headID = &#63; and column_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @return the range of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the columns where headID = &#63; and column_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByHeadIdAndColumnName_First(long headID,
		java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the first column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByHeadIdAndColumnName_First(
		long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByHeadIdAndColumnName_Last(long headID,
		java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the last column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByHeadIdAndColumnName_Last(long headID,
		java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the columns before and after the current column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param columnID the primary key of the current column
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next column
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column[] findByHeadIdAndColumnName_PrevAndNext(
		long columnID, long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Removes all the columns where headID = &#63; and column_name = &#63; from the database.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadIdAndColumnName(long headID,
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of columns where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadIdAndColumnName(long headID,
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the column in the entity cache if it is enabled.
	*
	* @param column the column
	*/
	public void cacheResult(org.gfbio.model.Column column);

	/**
	* Caches the columns in the entity cache if it is enabled.
	*
	* @param columns the columns
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Column> columns);

	/**
	* Creates a new column with the primary key. Does not add the column to the database.
	*
	* @param columnID the primary key for the new column
	* @return the new column
	*/
	public org.gfbio.model.Column create(long columnID);

	/**
	* Removes the column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param columnID the primary key of the column
	* @return the column that was removed
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column remove(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	public org.gfbio.model.Column updateImpl(org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the column with the primary key or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param columnID the primary key of the column
	* @return the column
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column findByPrimaryKey(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException;

	/**
	* Returns the column with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param columnID the primary key of the column
	* @return the column, or <code>null</code> if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Column fetchByPrimaryKey(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the columns.
	*
	* @return the columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @return the range of columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the columns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of columns
	* @param end the upper bound of the range of columns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of columns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Column> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the columns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of columns.
	*
	* @return the number of columns
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}