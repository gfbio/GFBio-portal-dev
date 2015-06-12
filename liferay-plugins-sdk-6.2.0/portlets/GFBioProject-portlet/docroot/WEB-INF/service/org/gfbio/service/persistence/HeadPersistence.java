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
 * @author Marcel Froemming
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
	public org.gfbio.model.Head findByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head fetchByHeadId(long headID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the head where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Head removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException;

	/**
	* Returns the number of heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadId(long headID)
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