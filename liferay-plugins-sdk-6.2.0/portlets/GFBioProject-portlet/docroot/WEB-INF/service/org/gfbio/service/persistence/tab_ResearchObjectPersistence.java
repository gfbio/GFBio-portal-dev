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

import org.gfbio.model.tab_ResearchObject;

/**
 * The persistence interface for the tab_ research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObjectPersistenceImpl
 * @see tab_ResearchObjectUtil
 * @generated
 */
public interface tab_ResearchObjectPersistence extends BasePersistence<tab_ResearchObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link tab_ResearchObjectUtil} to access the tab_ research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tab_ research objects where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @return the matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tab_ research objects where ro_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ro_name the ro_name
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @return the range of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tab_ research objects where ro_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ro_name the ro_name
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject findByName_First(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException;

	/**
	* Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject fetchByName_First(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject findByName_Last(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException;

	/**
	* Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject fetchByName_Last(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tab_ research objects before and after the current tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_ID the primary key of the current tab_ research object
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject[] findByName_PrevAndNext(
		long ro_ID, java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException;

	/**
	* Removes all the tab_ research objects where ro_name = &#63; from the database.
	*
	* @param ro_name the ro_name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tab_ research objects where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @return the number of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tab_ research object in the entity cache if it is enabled.
	*
	* @param tab_ResearchObject the tab_ research object
	*/
	public void cacheResult(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject);

	/**
	* Caches the tab_ research objects in the entity cache if it is enabled.
	*
	* @param tab_ResearchObjects the tab_ research objects
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.tab_ResearchObject> tab_ResearchObjects);

	/**
	* Creates a new tab_ research object with the primary key. Does not add the tab_ research object to the database.
	*
	* @param ro_ID the primary key for the new tab_ research object
	* @return the new tab_ research object
	*/
	public org.gfbio.model.tab_ResearchObject create(long ro_ID);

	/**
	* Removes the tab_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object that was removed
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject remove(long ro_ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException;

	public org.gfbio.model.tab_ResearchObject updateImpl(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tab_ research object with the primary key or throws a {@link org.gfbio.NoSuchtab_ResearchObjectException} if it could not be found.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject findByPrimaryKey(long ro_ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException;

	/**
	* Returns the tab_ research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object, or <code>null</code> if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.tab_ResearchObject fetchByPrimaryKey(long ro_ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tab_ research objects.
	*
	* @return the tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tab_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @return the range of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tab_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.tab_ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tab_ research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tab_ research objects.
	*
	* @return the number of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}