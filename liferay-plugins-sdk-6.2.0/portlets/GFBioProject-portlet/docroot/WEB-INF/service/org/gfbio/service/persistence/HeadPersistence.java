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

import org.gfbio.model.Head;

/**
 * The persistence interface for the head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see HeadPersistenceImpl
 * @see HeadUtil
 * @generated
 */
public interface HeadPersistence extends BasePersistence<Head> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HeadUtil} to access the head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the head where headID = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param headID the head i d
	* @return the matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByHeadID(long headID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the head where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head removeByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the number of heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the head where name = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param name the name
	* @return the matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the head where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the head where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByName(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the head where name = &#63; from the database.
	*
	* @param name the name
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the number of heads where name = &#63;.
	*
	* @param name the name
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where task = &#63;.
	*
	* @param task the task
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByTask(
		java.lang.String task, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByTask_First(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where task = &#63;.
	*
	* @param task the task
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByTask_Last(java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByTask_PrevAndNext(long headID,
		java.lang.String task,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where task = &#63; from the database.
	*
	* @param task the task
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where task = &#63;.
	*
	* @param task the task
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByTask(java.lang.String task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn01(
		java.lang.String column01, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn01_Last(java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn01_Last(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn01_PrevAndNext(long headID,
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column01 = &#63; from the database.
	*
	* @param column01 the column01
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn02(
		java.lang.String column02, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn02_Last(java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn02_Last(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn02_PrevAndNext(long headID,
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column02 = &#63; from the database.
	*
	* @param column02 the column02
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn03(
		java.lang.String column03, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn03_Last(java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn03_Last(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn03_PrevAndNext(long headID,
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column03 = &#63; from the database.
	*
	* @param column03 the column03
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn04(
		java.lang.String column04, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn04_Last(java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn04_Last(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn04_PrevAndNext(long headID,
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column04 = &#63; from the database.
	*
	* @param column04 the column04
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn05(
		java.lang.String column05, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn05_Last(java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn05_Last(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn05_PrevAndNext(long headID,
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column05 = &#63; from the database.
	*
	* @param column05 the column05
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn06(
		java.lang.String column06, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn06_Last(java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn06_Last(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn06_PrevAndNext(long headID,
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column06 = &#63; from the database.
	*
	* @param column06 the column06
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn07(
		java.lang.String column07, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn07_Last(java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn07_Last(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn07_PrevAndNext(long headID,
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column07 = &#63; from the database.
	*
	* @param column07 the column07
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn08(
		java.lang.String column08, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn08_Last(java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn08_Last(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn08_PrevAndNext(long headID,
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column08 = &#63; from the database.
	*
	* @param column08 the column08
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn09(
		java.lang.String column09, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn09_Last(java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn09_Last(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn09_PrevAndNext(long headID,
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column09 = &#63; from the database.
	*
	* @param column09 the column09
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn10(
		java.lang.String column10, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn10_Last(java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn10_Last(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn10_PrevAndNext(long headID,
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column10 = &#63; from the database.
	*
	* @param column10 the column10
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn11(
		java.lang.String column11, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn11_Last(java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn11_Last(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn11_PrevAndNext(long headID,
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column11 = &#63; from the database.
	*
	* @param column11 the column11
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn12(
		java.lang.String column12, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn12_Last(java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn12_Last(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn12_PrevAndNext(long headID,
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column12 = &#63; from the database.
	*
	* @param column12 the column12
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn13(
		java.lang.String column13, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn13_Last(java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn13_Last(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn13_PrevAndNext(long headID,
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column13 = &#63; from the database.
	*
	* @param column13 the column13
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn14(
		java.lang.String column14, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn14_Last(java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn14_Last(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn14_PrevAndNext(long headID,
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column14 = &#63; from the database.
	*
	* @param column14 the column14
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn15(
		java.lang.String column15, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn15_Last(java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn15_Last(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn15_PrevAndNext(long headID,
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column15 = &#63; from the database.
	*
	* @param column15 the column15
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn16(
		java.lang.String column16, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn16_Last(java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn16_Last(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn16_PrevAndNext(long headID,
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column16 = &#63; from the database.
	*
	* @param column16 the column16
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn17(
		java.lang.String column17, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn17_Last(java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn17_Last(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn17_PrevAndNext(long headID,
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column17 = &#63; from the database.
	*
	* @param column17 the column17
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn18(
		java.lang.String column18, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn18_Last(java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn18_Last(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn18_PrevAndNext(long headID,
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column18 = &#63; from the database.
	*
	* @param column18 the column18
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn19(
		java.lang.String column19, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn19_Last(java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn19_Last(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn19_PrevAndNext(long headID,
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column19 = &#63; from the database.
	*
	* @param column19 the column19
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findByColumn20(
		java.lang.String column20, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the first head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByColumn20_Last(java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the last head in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByColumn20_Last(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Head[] findByColumn20_PrevAndNext(long headID,
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Removes all the heads where column20 = &#63; from the database.
	*
	* @param column20 the column20
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the head in the entity cache if it is enabled.
	*
	* @param head the head
	*/
	public void cacheResult(org.gfbio.model.Head head);

	/**
	* Caches the heads in the entity cache if it is enabled.
	*
	* @param heads the heads
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Head> heads);

	/**
	* Creates a new head with the primary key. Does not add the head to the database.
	*
	* @param headID the primary key for the new head
	* @return the new head
	*/
	public org.gfbio.model.Head create(long headID);

	/**
	* Removes the head with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param headID the primary key of the head
	* @return the head that was removed
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head remove(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	public org.gfbio.model.Head updateImpl(org.gfbio.model.Head head)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the head with the primary key or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param headID the primary key of the head
	* @return the head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head findByPrimaryKey(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the head with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param headID the primary key of the head
	* @return the head, or <code>null</code> if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByPrimaryKey(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the heads.
	*
	* @return the heads
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Head> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Head> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the heads from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of heads.
	*
	* @return the number of heads
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}