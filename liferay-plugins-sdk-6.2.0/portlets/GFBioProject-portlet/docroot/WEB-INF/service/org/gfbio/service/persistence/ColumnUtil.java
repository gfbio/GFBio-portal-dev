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

import org.gfbio.model.Column;

import java.util.List;

/**
 * The persistence utility for the column service. This utility wraps {@link ColumnPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ColumnPersistence
 * @see ColumnPersistenceImpl
 * @generated
 */
public class ColumnUtil {
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
	public static void clearCache(Column column) {
		getPersistence().clearCache(column);
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
	public static List<Column> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Column> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Column> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Column update(Column column) throws SystemException {
		return getPersistence().update(column);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Column update(Column column, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(column, serviceContext);
	}

	/**
	* Returns the column where columnID = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param columnID the column i d
	* @return the matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column findByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().findByColumnId(columnID);
	}

	/**
	* Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param columnID the column i d
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumnId(columnID);
	}

	/**
	* Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param columnID the column i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByColumnId(long columnID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumnId(columnID, retrieveFromCache);
	}

	/**
	* Removes the column where columnID = &#63; from the database.
	*
	* @param columnID the column i d
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column removeByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().removeByColumnId(columnID);
	}

	/**
	* Returns the number of columns where columnID = &#63;.
	*
	* @param columnID the column i d
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumnId(columnID);
	}

	/**
	* Returns the column where column_name = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param column_name the column_name
	* @return the matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column findByColumnName(
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().findByColumnName(column_name);
	}

	/**
	* Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param column_name the column_name
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByColumnName(
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumnName(column_name);
	}

	/**
	* Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param column_name the column_name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByColumnName(
		java.lang.String column_name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumnName(column_name, retrieveFromCache);
	}

	/**
	* Removes the column where column_name = &#63; from the database.
	*
	* @param column_name the column_name
	* @return the column that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column removeByColumnName(
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().removeByColumnName(column_name);
	}

	/**
	* Returns the number of columns where column_name = &#63;.
	*
	* @param column_name the column_name
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumnName(java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumnName(column_name);
	}

	/**
	* Returns all the columns where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Column> findByHeadId(
		long headID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID);
	}

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
	public static java.util.List<org.gfbio.model.Column> findByHeadId(
		long headID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadId(headID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Column> findByHeadId(
		long headID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHeadId(headID, start, end, orderByComparator);
	}

	/**
	* Returns the first column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().findByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the first column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_First(headID, orderByComparator);
	}

	/**
	* Returns the last column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column
	* @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().findByHeadId_Last(headID, orderByComparator);
	}

	/**
	* Returns the last column in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId_Last(headID, orderByComparator);
	}

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
	public static org.gfbio.model.Column[] findByHeadId_PrevAndNext(
		long columnID, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence()
				   .findByHeadId_PrevAndNext(columnID, headID, orderByComparator);
	}

	/**
	* Removes all the columns where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHeadId(headID);
	}

	/**
	* Returns the number of columns where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadId(headID);
	}

	/**
	* Returns all the columns where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @return the matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHeadIdAndColumnName(headID, column_name);
	}

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
	public static java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHeadIdAndColumnName(headID, column_name, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Column> findByHeadIdAndColumnName(
		long headID, java.lang.String column_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHeadIdAndColumnName(headID, column_name, start, end,
			orderByComparator);
	}

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
	public static org.gfbio.model.Column findByHeadIdAndColumnName_First(
		long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence()
				   .findByHeadIdAndColumnName_First(headID, column_name,
			orderByComparator);
	}

	/**
	* Returns the first column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByHeadIdAndColumnName_First(
		long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHeadIdAndColumnName_First(headID, column_name,
			orderByComparator);
	}

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
	public static org.gfbio.model.Column findByHeadIdAndColumnName_Last(
		long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence()
				   .findByHeadIdAndColumnName_Last(headID, column_name,
			orderByComparator);
	}

	/**
	* Returns the last column in the ordered set where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching column, or <code>null</code> if a matching column could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByHeadIdAndColumnName_Last(
		long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHeadIdAndColumnName_Last(headID, column_name,
			orderByComparator);
	}

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
	public static org.gfbio.model.Column[] findByHeadIdAndColumnName_PrevAndNext(
		long columnID, long headID, java.lang.String column_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence()
				   .findByHeadIdAndColumnName_PrevAndNext(columnID, headID,
			column_name, orderByComparator);
	}

	/**
	* Removes all the columns where headID = &#63; and column_name = &#63; from the database.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHeadIdAndColumnName(long headID,
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHeadIdAndColumnName(headID, column_name);
	}

	/**
	* Returns the number of columns where headID = &#63; and column_name = &#63;.
	*
	* @param headID the head i d
	* @param column_name the column_name
	* @return the number of matching columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadIdAndColumnName(long headID,
		java.lang.String column_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadIdAndColumnName(headID, column_name);
	}

	/**
	* Caches the column in the entity cache if it is enabled.
	*
	* @param column the column
	*/
	public static void cacheResult(org.gfbio.model.Column column) {
		getPersistence().cacheResult(column);
	}

	/**
	* Caches the columns in the entity cache if it is enabled.
	*
	* @param columns the columns
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Column> columns) {
		getPersistence().cacheResult(columns);
	}

	/**
	* Creates a new column with the primary key. Does not add the column to the database.
	*
	* @param columnID the primary key for the new column
	* @return the new column
	*/
	public static org.gfbio.model.Column create(long columnID) {
		return getPersistence().create(columnID);
	}

	/**
	* Removes the column with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param columnID the primary key of the column
	* @return the column that was removed
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column remove(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().remove(columnID);
	}

	public static org.gfbio.model.Column updateImpl(
		org.gfbio.model.Column column)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(column);
	}

	/**
	* Returns the column with the primary key or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	*
	* @param columnID the primary key of the column
	* @return the column
	* @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column findByPrimaryKey(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchColumnException {
		return getPersistence().findByPrimaryKey(columnID);
	}

	/**
	* Returns the column with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param columnID the primary key of the column
	* @return the column, or <code>null</code> if a column with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Column fetchByPrimaryKey(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(columnID);
	}

	/**
	* Returns all the columns.
	*
	* @return the columns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Column> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gfbio.model.Column> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gfbio.model.Column> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the columns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of columns.
	*
	* @return the number of columns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ColumnPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ColumnPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ColumnPersistence.class.getName());

			ReferenceRegistry.registerReference(ColumnUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ColumnPersistence persistence) {
	}

	private static ColumnPersistence _persistence;
}