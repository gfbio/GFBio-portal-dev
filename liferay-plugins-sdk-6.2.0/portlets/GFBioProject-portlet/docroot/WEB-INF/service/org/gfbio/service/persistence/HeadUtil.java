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
 * @author Marcel Froemming
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
	public static org.gfbio.model.Head findByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByHeadId(headID);
	}

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headID the head i d
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId(headID);
	}

	/**
	* Returns the head where headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headID the head i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByHeadId(long headID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHeadId(headID, retrieveFromCache);
	}

	/**
	* Removes the head where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().removeByHeadId(headID);
	}

	/**
	* Returns the number of heads where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHeadId(headID);
	}

	/**
	* Returns the head where table_name = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	*
	* @param table_name the table_name
	* @return the matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByTableName(
		java.lang.String table_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().findByTableName(table_name);
	}

	/**
	* Returns the head where table_name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param table_name the table_name
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTableName(
		java.lang.String table_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTableName(table_name);
	}

	/**
	* Returns the head where table_name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param table_name the table_name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTableName(
		java.lang.String table_name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTableName(table_name, retrieveFromCache);
	}

	/**
	* Removes the head where table_name = &#63; from the database.
	*
	* @param table_name the table_name
	* @return the head that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head removeByTableName(
		java.lang.String table_name)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence().removeByTableName(table_name);
	}

	/**
	* Returns the number of heads where table_name = &#63;.
	*
	* @param table_name the table_name
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTableName(java.lang.String table_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTableName(table_name);
	}

	/**
	* Returns all the heads where table_type = &#63;.
	*
	* @param table_type the table_type
	* @return the matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTableType(
		java.lang.String table_type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTableType(table_type);
	}

	/**
	* Returns a range of all the heads where table_type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param table_type the table_type
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @return the range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTableType(
		java.lang.String table_type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTableType(table_type, start, end);
	}

	/**
	* Returns an ordered range of all the heads where table_type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param table_type the table_type
	* @param start the lower bound of the range of heads
	* @param end the upper bound of the range of heads (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Head> findByTableType(
		java.lang.String table_type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTableType(table_type, start, end, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where table_type = &#63;.
	*
	* @param table_type the table_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByTableType_First(
		java.lang.String table_type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByTableType_First(table_type, orderByComparator);
	}

	/**
	* Returns the first head in the ordered set where table_type = &#63;.
	*
	* @param table_type the table_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTableType_First(
		java.lang.String table_type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTableType_First(table_type, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where table_type = &#63;.
	*
	* @param table_type the table_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head
	* @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head findByTableType_Last(
		java.lang.String table_type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByTableType_Last(table_type, orderByComparator);
	}

	/**
	* Returns the last head in the ordered set where table_type = &#63;.
	*
	* @param table_type the table_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching head, or <code>null</code> if a matching head could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head fetchByTableType_Last(
		java.lang.String table_type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTableType_Last(table_type, orderByComparator);
	}

	/**
	* Returns the heads before and after the current head in the ordered set where table_type = &#63;.
	*
	* @param headID the primary key of the current head
	* @param table_type the table_type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next head
	* @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Head[] findByTableType_PrevAndNext(
		long headID, java.lang.String table_type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchHeadException {
		return getPersistence()
				   .findByTableType_PrevAndNext(headID, table_type,
			orderByComparator);
	}

	/**
	* Removes all the heads where table_type = &#63; from the database.
	*
	* @param table_type the table_type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTableType(java.lang.String table_type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTableType(table_type);
	}

	/**
	* Returns the number of heads where table_type = &#63;.
	*
	* @param table_type the table_type
	* @return the number of matching heads
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTableType(java.lang.String table_type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTableType(table_type);
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