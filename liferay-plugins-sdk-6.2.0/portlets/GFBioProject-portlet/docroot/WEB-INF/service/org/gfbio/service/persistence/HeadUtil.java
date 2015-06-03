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

import org.gfbio.model.Head;

import java.util.List;

/**
 * The persistence utility for the head service. This utility wraps {@link HeadPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see HeadPersistence
 * @see HeadPersistenceImpl
 * @generated
 */
public class HeadUtil {
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
	public static void clearCache(Head head) {
		getPersistence().clearCache(head);
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
	public static List<Head> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Head> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Head> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Head update(Head head) throws SystemException {
		return getPersistence().update(head);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Head update(Head head, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(head, serviceContext);
	}

	/**
	* Returns the head where headID = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param headID the head i d
	* @return the matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByHeadID(headID);
	}

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadID(headID);
	}

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByHeadID(long headID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadID(headID, retrieveFromCache);
	}

	/**
	* Removes the head where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head removeByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().removeByHeadID(headID);
	}

	/**
	* Returns the number of heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadID(headID);
	}

	/**
	* Returns the head where name = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param name the name
	* @return the matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the head where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the head where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByName(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the head where name = &#63; from the database.
	*
	* @param name the name
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of heads where name = &#63;.
	*
	* @param name the name
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the heads where task = &#63;.
	*
	* @param task the task
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task);
	}

	/**
	* Returns a range of all the heads where task = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param task the task
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task, start, end);
	}

	/**
	* Returns an ordered range of all the heads where task = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param task the task
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTask(task, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByTask_First(task, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTask_First(
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTask_First(task, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByTask_Last(task, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTask_Last(task, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where task = &#63;.
	*
	* @param headID the primary key of the current head
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByTask_PrevAndNext(long headID,
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByTask_PrevAndNext(headID, task, orderByComparator);
	}

	/**
	* Removes all the heads where task = &#63; from the database.
	*
	* @param task the task
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTask(task);
	}

	/**
	* Returns the number of heads where task = &#63;.
	*
	* @param task the task
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTask(task);
	}

	/**
	* Returns all the heads where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn01(column01);
	}

	/**
	* Returns a range of all the heads where column01 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column01 the column01
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn01(column01, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column01 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column01 the column01
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn01(column01, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn01_First(column01, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn01_First(column01, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn01_Last(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn01_Last(column01, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn01_Last(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn01_Last(column01, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column01 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn01_PrevAndNext(
		long headID, java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn01_PrevAndNext(headID, column01,
			orderByComparator);
	}

	/**
	* Removes all the heads where column01 = &#63; from the database.
	*
	* @param column01 the column01
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn01(column01);
	}

	/**
	* Returns the number of heads where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn01(column01);
	}

	/**
	* Returns all the heads where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn02(column02);
	}

	/**
	* Returns a range of all the heads where column02 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column02 the column02
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn02(column02, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column02 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column02 the column02
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn02(column02, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn02_First(column02, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn02_First(column02, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn02_Last(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn02_Last(column02, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn02_Last(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn02_Last(column02, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column02 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn02_PrevAndNext(
		long headID, java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn02_PrevAndNext(headID, column02,
			orderByComparator);
	}

	/**
	* Removes all the heads where column02 = &#63; from the database.
	*
	* @param column02 the column02
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn02(column02);
	}

	/**
	* Returns the number of heads where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn02(column02);
	}

	/**
	* Returns all the heads where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn03(column03);
	}

	/**
	* Returns a range of all the heads where column03 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column03 the column03
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn03(column03, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column03 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column03 the column03
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn03(column03, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn03_First(column03, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn03_First(column03, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn03_Last(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn03_Last(column03, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn03_Last(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn03_Last(column03, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column03 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn03_PrevAndNext(
		long headID, java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn03_PrevAndNext(headID, column03,
			orderByComparator);
	}

	/**
	* Removes all the heads where column03 = &#63; from the database.
	*
	* @param column03 the column03
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn03(column03);
	}

	/**
	* Returns the number of heads where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn03(column03);
	}

	/**
	* Returns all the heads where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn04(column04);
	}

	/**
	* Returns a range of all the heads where column04 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column04 the column04
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn04(column04, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column04 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column04 the column04
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn04(column04, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn04_First(column04, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn04_First(column04, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn04_Last(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn04_Last(column04, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn04_Last(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn04_Last(column04, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column04 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn04_PrevAndNext(
		long headID, java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn04_PrevAndNext(headID, column04,
			orderByComparator);
	}

	/**
	* Removes all the heads where column04 = &#63; from the database.
	*
	* @param column04 the column04
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn04(column04);
	}

	/**
	* Returns the number of heads where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn04(column04);
	}

	/**
	* Returns all the heads where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn05(column05);
	}

	/**
	* Returns a range of all the heads where column05 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column05 the column05
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn05(column05, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column05 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column05 the column05
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn05(column05, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn05_First(column05, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn05_First(column05, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn05_Last(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn05_Last(column05, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn05_Last(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn05_Last(column05, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column05 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn05_PrevAndNext(
		long headID, java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn05_PrevAndNext(headID, column05,
			orderByComparator);
	}

	/**
	* Removes all the heads where column05 = &#63; from the database.
	*
	* @param column05 the column05
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn05(column05);
	}

	/**
	* Returns the number of heads where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn05(column05);
	}

	/**
	* Returns all the heads where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn06(column06);
	}

	/**
	* Returns a range of all the heads where column06 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column06 the column06
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn06(column06, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column06 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column06 the column06
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn06(column06, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn06_First(column06, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn06_First(column06, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn06_Last(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn06_Last(column06, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn06_Last(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn06_Last(column06, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column06 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn06_PrevAndNext(
		long headID, java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn06_PrevAndNext(headID, column06,
			orderByComparator);
	}

	/**
	* Removes all the heads where column06 = &#63; from the database.
	*
	* @param column06 the column06
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn06(column06);
	}

	/**
	* Returns the number of heads where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn06(column06);
	}

	/**
	* Returns all the heads where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn07(column07);
	}

	/**
	* Returns a range of all the heads where column07 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column07 the column07
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn07(column07, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column07 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column07 the column07
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn07(column07, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn07_First(column07, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn07_First(column07, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn07_Last(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn07_Last(column07, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn07_Last(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn07_Last(column07, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column07 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn07_PrevAndNext(
		long headID, java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn07_PrevAndNext(headID, column07,
			orderByComparator);
	}

	/**
	* Removes all the heads where column07 = &#63; from the database.
	*
	* @param column07 the column07
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn07(column07);
	}

	/**
	* Returns the number of heads where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn07(column07);
	}

	/**
	* Returns all the heads where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn08(column08);
	}

	/**
	* Returns a range of all the heads where column08 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column08 the column08
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn08(column08, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column08 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column08 the column08
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn08(column08, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn08_First(column08, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn08_First(column08, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn08_Last(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn08_Last(column08, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn08_Last(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn08_Last(column08, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column08 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn08_PrevAndNext(
		long headID, java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn08_PrevAndNext(headID, column08,
			orderByComparator);
	}

	/**
	* Removes all the heads where column08 = &#63; from the database.
	*
	* @param column08 the column08
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn08(column08);
	}

	/**
	* Returns the number of heads where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn08(column08);
	}

	/**
	* Returns all the heads where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn09(column09);
	}

	/**
	* Returns a range of all the heads where column09 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column09 the column09
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn09(column09, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column09 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column09 the column09
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn09(column09, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn09_First(column09, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn09_First(column09, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn09_Last(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn09_Last(column09, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn09_Last(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn09_Last(column09, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column09 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn09_PrevAndNext(
		long headID, java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn09_PrevAndNext(headID, column09,
			orderByComparator);
	}

	/**
	* Removes all the heads where column09 = &#63; from the database.
	*
	* @param column09 the column09
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn09(column09);
	}

	/**
	* Returns the number of heads where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn09(column09);
	}

	/**
	* Returns all the heads where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn10(column10);
	}

	/**
	* Returns a range of all the heads where column10 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column10 the column10
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn10(column10, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column10 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column10 the column10
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn10(column10, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn10_First(column10, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn10_First(column10, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn10_Last(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn10_Last(column10, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn10_Last(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn10_Last(column10, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column10 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn10_PrevAndNext(
		long headID, java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn10_PrevAndNext(headID, column10,
			orderByComparator);
	}

	/**
	* Removes all the heads where column10 = &#63; from the database.
	*
	* @param column10 the column10
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn10(column10);
	}

	/**
	* Returns the number of heads where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn10(column10);
	}

	/**
	* Returns all the heads where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn11(column11);
	}

	/**
	* Returns a range of all the heads where column11 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column11 the column11
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn11(column11, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column11 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column11 the column11
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn11(column11, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn11_First(column11, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn11_First(column11, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn11_Last(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn11_Last(column11, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn11_Last(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn11_Last(column11, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column11 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn11_PrevAndNext(
		long headID, java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn11_PrevAndNext(headID, column11,
			orderByComparator);
	}

	/**
	* Removes all the heads where column11 = &#63; from the database.
	*
	* @param column11 the column11
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn11(column11);
	}

	/**
	* Returns the number of heads where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn11(column11);
	}

	/**
	* Returns all the heads where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn12(column12);
	}

	/**
	* Returns a range of all the heads where column12 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column12 the column12
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn12(column12, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column12 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column12 the column12
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn12(column12, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn12_First(column12, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn12_First(column12, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn12_Last(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn12_Last(column12, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn12_Last(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn12_Last(column12, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column12 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn12_PrevAndNext(
		long headID, java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn12_PrevAndNext(headID, column12,
			orderByComparator);
	}

	/**
	* Removes all the heads where column12 = &#63; from the database.
	*
	* @param column12 the column12
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn12(column12);
	}

	/**
	* Returns the number of heads where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn12(column12);
	}

	/**
	* Returns all the heads where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn13(column13);
	}

	/**
	* Returns a range of all the heads where column13 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column13 the column13
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn13(column13, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column13 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column13 the column13
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn13(column13, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn13_First(column13, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn13_First(column13, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn13_Last(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn13_Last(column13, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn13_Last(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn13_Last(column13, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column13 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn13_PrevAndNext(
		long headID, java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn13_PrevAndNext(headID, column13,
			orderByComparator);
	}

	/**
	* Removes all the heads where column13 = &#63; from the database.
	*
	* @param column13 the column13
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn13(column13);
	}

	/**
	* Returns the number of heads where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn13(column13);
	}

	/**
	* Returns all the heads where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn14(column14);
	}

	/**
	* Returns a range of all the heads where column14 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column14 the column14
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn14(column14, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column14 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column14 the column14
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn14(column14, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn14_First(column14, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn14_First(column14, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn14_Last(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn14_Last(column14, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn14_Last(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn14_Last(column14, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column14 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn14_PrevAndNext(
		long headID, java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn14_PrevAndNext(headID, column14,
			orderByComparator);
	}

	/**
	* Removes all the heads where column14 = &#63; from the database.
	*
	* @param column14 the column14
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn14(column14);
	}

	/**
	* Returns the number of heads where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn14(column14);
	}

	/**
	* Returns all the heads where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn15(column15);
	}

	/**
	* Returns a range of all the heads where column15 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column15 the column15
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn15(column15, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column15 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column15 the column15
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn15(column15, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn15_First(column15, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn15_First(column15, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn15_Last(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn15_Last(column15, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn15_Last(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn15_Last(column15, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column15 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn15_PrevAndNext(
		long headID, java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn15_PrevAndNext(headID, column15,
			orderByComparator);
	}

	/**
	* Removes all the heads where column15 = &#63; from the database.
	*
	* @param column15 the column15
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn15(column15);
	}

	/**
	* Returns the number of heads where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn15(column15);
	}

	/**
	* Returns all the heads where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn16(column16);
	}

	/**
	* Returns a range of all the heads where column16 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column16 the column16
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn16(column16, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column16 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column16 the column16
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn16(column16, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn16_First(column16, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn16_First(column16, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn16_Last(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn16_Last(column16, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn16_Last(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn16_Last(column16, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column16 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn16_PrevAndNext(
		long headID, java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn16_PrevAndNext(headID, column16,
			orderByComparator);
	}

	/**
	* Removes all the heads where column16 = &#63; from the database.
	*
	* @param column16 the column16
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn16(column16);
	}

	/**
	* Returns the number of heads where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn16(column16);
	}

	/**
	* Returns all the heads where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn17(column17);
	}

	/**
	* Returns a range of all the heads where column17 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column17 the column17
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn17(column17, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column17 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column17 the column17
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn17(column17, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn17_First(column17, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn17_First(column17, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn17_Last(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn17_Last(column17, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn17_Last(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn17_Last(column17, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column17 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn17_PrevAndNext(
		long headID, java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn17_PrevAndNext(headID, column17,
			orderByComparator);
	}

	/**
	* Removes all the heads where column17 = &#63; from the database.
	*
	* @param column17 the column17
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn17(column17);
	}

	/**
	* Returns the number of heads where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn17(column17);
	}

	/**
	* Returns all the heads where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn18(column18);
	}

	/**
	* Returns a range of all the heads where column18 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column18 the column18
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn18(column18, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column18 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column18 the column18
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn18(column18, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn18_First(column18, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn18_First(column18, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn18_Last(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn18_Last(column18, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn18_Last(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn18_Last(column18, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column18 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn18_PrevAndNext(
		long headID, java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn18_PrevAndNext(headID, column18,
			orderByComparator);
	}

	/**
	* Removes all the heads where column18 = &#63; from the database.
	*
	* @param column18 the column18
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn18(column18);
	}

	/**
	* Returns the number of heads where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn18(column18);
	}

	/**
	* Returns all the heads where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn19(column19);
	}

	/**
	* Returns a range of all the heads where column19 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column19 the column19
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn19(column19, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column19 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column19 the column19
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn19(column19, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn19_First(column19, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn19_First(column19, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn19_Last(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn19_Last(column19, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn19_Last(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn19_Last(column19, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column19 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn19_PrevAndNext(
		long headID, java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn19_PrevAndNext(headID, column19,
			orderByComparator);
	}

	/**
	* Removes all the heads where column19 = &#63; from the database.
	*
	* @param column19 the column19
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn19(column19);
	}

	/**
	* Returns the number of heads where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn19(column19);
	}

	/**
	* Returns all the heads where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn20(column20);
	}

	/**
	* Returns a range of all the heads where column20 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column20 the column20
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByColumn20(column20, start, end);
	}

	/**
	* Returns an ordered range of all the heads where column20 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column20 the column20
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByColumn20(column20, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn20_First(column20, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByColumn20_First(column20, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByColumn20_Last(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByColumn20_Last(column20, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByColumn20_Last(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByColumn20_Last(column20, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where column20 = &#63;.
	*
	* @param headID the primary key of the current head
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByColumn20_PrevAndNext(
		long headID, java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByColumn20_PrevAndNext(headID, column20,
			orderByComparator);
	}

	/**
	* Removes all the heads where column20 = &#63; from the database.
	*
	* @param column20 the column20
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByColumn20(column20);
	}

	/**
	* Returns the number of heads where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByColumn20(column20);
	}

	/**
	* Caches the head in the entity cache if it is enabled.
	*
	* @param head the head
	*/
	public static void cacheResult(org.gfbio.model.Head head) {
		getPersistence().cacheResult(head);
	}

	/**
	* Caches the heads in the entity cache if it is enabled.
	*
	* @param heads the heads
	*/
	public static void cacheResult(java.util.List<org.gfbio.model.Head> heads) {
		getPersistence().cacheResult(heads);
	}

	/**
	* Creates a new head with the primary key. Does not add the head to the database.
	*
	* @param headID the primary key for the new head
	* @return the new head
	*/
	public static org.gfbio.model.Head create(long headID) {
		return getPersistence().create(headID);
	}

	/**
	* Removes the head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param headID the primary key of the head
	* @return the head that was removed
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head remove(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().remove(headID);
	}

	public static org.gfbio.model.Head updateImpl(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(head);
	}

	/**
	* Returns the head with the primary key or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param headID the primary key of the head
	* @return the head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByPrimaryKey(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByPrimaryKey(headID);
	}

	/**
	* Returns the head with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param headID the primary key of the head
	* @return the head, or <code>null</code> if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByPrimaryKey(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(headID);
	}

	/**
	* Returns all the heads.
	*
	* @return the heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the heads.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the heads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of heads.
	*
	* @return the number of heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HeadPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HeadPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					HeadPersistence.class.getName());

			ReferenceRegistry.registerReference(HeadUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HeadPersistence persistence) {
	}

	private static HeadPersistence _persistence;
}