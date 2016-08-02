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

import org.gfbio.model.Search_History;

/**
 * The persistence interface for the search_ history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Search_HistoryPersistenceImpl
 * @see Search_HistoryUtil
 * @generated
 */
public interface Search_HistoryPersistence extends BasePersistence<Search_History> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Search_HistoryUtil} to access the search_ history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the search_ history where searchHistoryID = &#63; or throws a {@link org.gfbio.NoSuchSearch_HistoryException} if it could not be found.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the search_ history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param searchHistoryID the search history i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchBySearchHistoryID(
		long searchHistoryID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the search_ history where searchHistoryID = &#63; from the database.
	*
	* @param searchHistoryID the search history i d
	* @return the search_ history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History removeBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the number of search_ histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countBySearchHistoryID(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where searchHistoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryID the search history i d
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long searchHistoryID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where searchHistoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryID the search history i d
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long searchHistoryID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search_ history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findBySearchHistoryIDs_First(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the first search_ history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchBySearchHistoryIDs_First(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search_ history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findBySearchHistoryIDs_Last(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the last search_ history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchBySearchHistoryIDs_Last(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long[] searchHistoryIDs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search_ histories where searchHistoryID = &#63; from the database.
	*
	* @param searchHistoryID the search history i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySearchHistoryIDs(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countBySearchHistoryIDs(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where searchHistoryID = any &#63;.
	*
	* @param searchHistoryIDs the search history i ds
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countBySearchHistoryIDs(long[] searchHistoryIDs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search_ history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the first search_ history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search_ history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the last search_ history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ histories before and after the current search_ history in the ordered set where userID = &#63;.
	*
	* @param searchHistoryID the primary key of the current search_ history
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History[] findByUserID_PrevAndNext(
		long searchHistoryID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Removes all the search_ histories where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByUserIDSince_First(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the first search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByUserIDSince_First(
		long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByUserIDSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the last search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByUserIDSince_Last(long userID,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ histories before and after the current search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param searchHistoryID the primary key of the current search_ history
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History[] findByUserIDSince_PrevAndNext(
		long searchHistoryID, long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Removes all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIDSince(long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIDSince(long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessage(
		java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where queryString LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessage(
		java.lang.String queryString, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where queryString LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessage(
		java.lang.String queryString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search_ history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByQueryMessage_First(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the first search_ history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByQueryMessage_First(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search_ history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByQueryMessage_Last(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the last search_ history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByQueryMessage_Last(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ histories before and after the current search_ history in the ordered set where queryString LIKE &#63;.
	*
	* @param searchHistoryID the primary key of the current search_ history
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History[] findByQueryMessage_PrevAndNext(
		long searchHistoryID, java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Removes all the search_ histories where queryString LIKE &#63; from the database.
	*
	* @param queryString the query string
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQueryMessage(java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByQueryMessage(java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @return the matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByQueryMessageSince_First(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the first search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByQueryMessageSince_First(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByQueryMessageSince_Last(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the last search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByQueryMessageSince_Last(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ histories before and after the current search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param searchHistoryID the primary key of the current search_ history
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History[] findByQueryMessageSince_PrevAndNext(
		long searchHistoryID, java.lang.String queryString,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Removes all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQueryMessageSince(java.lang.String queryString,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @return the number of matching search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countByQueryMessageSince(java.lang.String queryString,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the search_ history in the entity cache if it is enabled.
	*
	* @param search_History the search_ history
	*/
	public void cacheResult(org.gfbio.model.Search_History search_History);

	/**
	* Caches the search_ histories in the entity cache if it is enabled.
	*
	* @param search_Histories the search_ histories
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Search_History> search_Histories);

	/**
	* Creates a new search_ history with the primary key. Does not add the search_ history to the database.
	*
	* @param searchHistoryID the primary key for the new search_ history
	* @return the new search_ history
	*/
	public org.gfbio.model.Search_History create(long searchHistoryID);

	/**
	* Removes the search_ history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchHistoryID the primary key of the search_ history
	* @return the search_ history that was removed
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History remove(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	public org.gfbio.model.Search_History updateImpl(
		org.gfbio.model.Search_History search_History)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the search_ history with the primary key or throws a {@link org.gfbio.NoSuchSearch_HistoryException} if it could not be found.
	*
	* @param searchHistoryID the primary key of the search_ history
	* @return the search_ history
	* @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History findByPrimaryKey(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearch_HistoryException;

	/**
	* Returns the search_ history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchHistoryID the primary key of the search_ history
	* @return the search_ history, or <code>null</code> if a search_ history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Search_History fetchByPrimaryKey(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the search_ histories.
	*
	* @return the search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the search_ histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @return the range of search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the search_ histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Search_HistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search_ histories
	* @param end the upper bound of the range of search_ histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Search_History> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the search_ histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of search_ histories.
	*
	* @return the number of search_ histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}