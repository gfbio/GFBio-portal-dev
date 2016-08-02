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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.SearchHistory;

import java.util.List;

/**
 * The persistence utility for the search history service. This utility wraps {@link SearchHistoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SearchHistoryPersistence
 * @see SearchHistoryPersistenceImpl
 * @generated
 */
public class SearchHistoryUtil {
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
	public static void clearCache(SearchHistory searchHistory) {
		getPersistence().clearCache(searchHistory);
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
	public static List<SearchHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SearchHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SearchHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SearchHistory update(SearchHistory searchHistory)
		throws SystemException {
		return getPersistence().update(searchHistory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SearchHistory update(SearchHistory searchHistory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(searchHistory, serviceContext);
	}

	/**
	* Returns the search history where searchHistoryID = &#63; or throws a {@link org.gfbio.NoSuchSearchHistoryException} if it could not be found.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().findBySearchHistoryID(searchHistoryID);
	}

	/**
	* Returns the search history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySearchHistoryID(searchHistoryID);
	}

	/**
	* Returns the search history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param searchHistoryID the search history i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchBySearchHistoryID(
		long searchHistoryID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchHistoryID(searchHistoryID, retrieveFromCache);
	}

	/**
	* Removes the search history where searchHistoryID = &#63; from the database.
	*
	* @param searchHistoryID the search history i d
	* @return the search history that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory removeBySearchHistoryID(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().removeBySearchHistoryID(searchHistoryID);
	}

	/**
	* Returns the number of search histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearchHistoryID(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySearchHistoryID(searchHistoryID);
	}

	/**
	* Returns all the search histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearchHistoryIDs(searchHistoryID);
	}

	/**
	* Returns a range of all the search histories where searchHistoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryID the search history i d
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long searchHistoryID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchHistoryIDs(searchHistoryID, start, end);
	}

	/**
	* Returns an ordered range of all the search histories where searchHistoryID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryID the search history i d
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long searchHistoryID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchHistoryIDs(searchHistoryID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findBySearchHistoryIDs_First(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findBySearchHistoryIDs_First(searchHistoryID,
			orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchBySearchHistoryIDs_First(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchHistoryIDs_First(searchHistoryID,
			orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findBySearchHistoryIDs_Last(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findBySearchHistoryIDs_Last(searchHistoryID,
			orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchBySearchHistoryIDs_Last(
		long searchHistoryID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchHistoryIDs_Last(searchHistoryID,
			orderByComparator);
	}

	/**
	* Returns all the search histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long[] searchHistoryIDs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearchHistoryIDs(searchHistoryIDs);
	}

	/**
	* Returns a range of all the search histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchHistoryIDs(searchHistoryIDs, start, end);
	}

	/**
	* Returns an ordered range of all the search histories where searchHistoryID = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchHistoryIDs the search history i ds
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchHistoryIDs(searchHistoryIDs, start, end,
			orderByComparator);
	}

	/**
	* Removes all the search histories where searchHistoryID = &#63; from the database.
	*
	* @param searchHistoryID the search history i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySearchHistoryIDs(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySearchHistoryIDs(searchHistoryID);
	}

	/**
	* Returns the number of search histories where searchHistoryID = &#63;.
	*
	* @param searchHistoryID the search history i d
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearchHistoryIDs(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySearchHistoryIDs(searchHistoryID);
	}

	/**
	* Returns the number of search histories where searchHistoryID = any &#63;.
	*
	* @param searchHistoryIDs the search history i ds
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearchHistoryIDs(long[] searchHistoryIDs)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySearchHistoryIDs(searchHistoryIDs);
	}

	/**
	* Returns all the search histories where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the search histories where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the search histories where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the search histories before and after the current search history in the ordered set where userID = &#63;.
	*
	* @param searchHistoryID the primary key of the current search history
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory[] findByUserID_PrevAndNext(
		long searchHistoryID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByUserID_PrevAndNext(searchHistoryID, userID,
			orderByComparator);
	}

	/**
	* Removes all the search histories where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of search histories where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Returns all the search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIDSince(userID, lastModifiedDate);
	}

	/**
	* Returns a range of all the search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIDSince(userID, lastModifiedDate, start, end);
	}

	/**
	* Returns an ordered range of all the search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByUserIDSince(
		long userID, java.util.Date lastModifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIDSince(userID, lastModifiedDate, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByUserIDSince_First(
		long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByUserIDSince_First(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByUserIDSince_First(
		long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIDSince_First(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByUserIDSince_Last(
		long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByUserIDSince_Last(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByUserIDSince_Last(
		long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIDSince_Last(userID, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the search histories before and after the current search history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param searchHistoryID the primary key of the current search history
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory[] findByUserIDSince_PrevAndNext(
		long searchHistoryID, long userID, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByUserIDSince_PrevAndNext(searchHistoryID, userID,
			lastModifiedDate, orderByComparator);
	}

	/**
	* Removes all the search histories where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIDSince(long userID,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIDSince(userID, lastModifiedDate);
	}

	/**
	* Returns the number of search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param userID the user i d
	* @param lastModifiedDate the last modified date
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIDSince(long userID,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIDSince(userID, lastModifiedDate);
	}

	/**
	* Returns all the search histories where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessage(
		java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQueryMessage(queryString);
	}

	/**
	* Returns a range of all the search histories where queryString LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessage(
		java.lang.String queryString, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQueryMessage(queryString, start, end);
	}

	/**
	* Returns an ordered range of all the search histories where queryString LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessage(
		java.lang.String queryString, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQueryMessage(queryString, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByQueryMessage_First(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessage_First(queryString, orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByQueryMessage_First(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQueryMessage_First(queryString, orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByQueryMessage_Last(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessage_Last(queryString, orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByQueryMessage_Last(
		java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQueryMessage_Last(queryString, orderByComparator);
	}

	/**
	* Returns the search histories before and after the current search history in the ordered set where queryString LIKE &#63;.
	*
	* @param searchHistoryID the primary key of the current search history
	* @param queryString the query string
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory[] findByQueryMessage_PrevAndNext(
		long searchHistoryID, java.lang.String queryString,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessage_PrevAndNext(searchHistoryID,
			queryString, orderByComparator);
	}

	/**
	* Removes all the search histories where queryString LIKE &#63; from the database.
	*
	* @param queryString the query string
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQueryMessage(java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQueryMessage(queryString);
	}

	/**
	* Returns the number of search histories where queryString LIKE &#63;.
	*
	* @param queryString the query string
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQueryMessage(java.lang.String queryString)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQueryMessage(queryString);
	}

	/**
	* Returns all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @return the matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQueryMessageSince(queryString, lastModifiedDate);
	}

	/**
	* Returns a range of all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQueryMessageSince(queryString, lastModifiedDate,
			start, end);
	}

	/**
	* Returns an ordered range of all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findByQueryMessageSince(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQueryMessageSince(queryString, lastModifiedDate,
			start, end, orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByQueryMessageSince_First(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessageSince_First(queryString,
			lastModifiedDate, orderByComparator);
	}

	/**
	* Returns the first search history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByQueryMessageSince_First(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQueryMessageSince_First(queryString,
			lastModifiedDate, orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByQueryMessageSince_Last(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessageSince_Last(queryString, lastModifiedDate,
			orderByComparator);
	}

	/**
	* Returns the last search history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search history, or <code>null</code> if a matching search history could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByQueryMessageSince_Last(
		java.lang.String queryString, java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByQueryMessageSince_Last(queryString,
			lastModifiedDate, orderByComparator);
	}

	/**
	* Returns the search histories before and after the current search history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param searchHistoryID the primary key of the current search history
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory[] findByQueryMessageSince_PrevAndNext(
		long searchHistoryID, java.lang.String queryString,
		java.util.Date lastModifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence()
				   .findByQueryMessageSince_PrevAndNext(searchHistoryID,
			queryString, lastModifiedDate, orderByComparator);
	}

	/**
	* Removes all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63; from the database.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQueryMessageSince(java.lang.String queryString,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQueryMessageSince(queryString, lastModifiedDate);
	}

	/**
	* Returns the number of search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	*
	* @param queryString the query string
	* @param lastModifiedDate the last modified date
	* @return the number of matching search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQueryMessageSince(java.lang.String queryString,
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByQueryMessageSince(queryString, lastModifiedDate);
	}

	/**
	* Caches the search history in the entity cache if it is enabled.
	*
	* @param searchHistory the search history
	*/
	public static void cacheResult(org.gfbio.model.SearchHistory searchHistory) {
		getPersistence().cacheResult(searchHistory);
	}

	/**
	* Caches the search histories in the entity cache if it is enabled.
	*
	* @param searchHistories the search histories
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.SearchHistory> searchHistories) {
		getPersistence().cacheResult(searchHistories);
	}

	/**
	* Creates a new search history with the primary key. Does not add the search history to the database.
	*
	* @param searchHistoryID the primary key for the new search history
	* @return the new search history
	*/
	public static org.gfbio.model.SearchHistory create(long searchHistoryID) {
		return getPersistence().create(searchHistoryID);
	}

	/**
	* Removes the search history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchHistoryID the primary key of the search history
	* @return the search history that was removed
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory remove(long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().remove(searchHistoryID);
	}

	public static org.gfbio.model.SearchHistory updateImpl(
		org.gfbio.model.SearchHistory searchHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(searchHistory);
	}

	/**
	* Returns the search history with the primary key or throws a {@link org.gfbio.NoSuchSearchHistoryException} if it could not be found.
	*
	* @param searchHistoryID the primary key of the search history
	* @return the search history
	* @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory findByPrimaryKey(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSearchHistoryException {
		return getPersistence().findByPrimaryKey(searchHistoryID);
	}

	/**
	* Returns the search history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchHistoryID the primary key of the search history
	* @return the search history, or <code>null</code> if a search history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SearchHistory fetchByPrimaryKey(
		long searchHistoryID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(searchHistoryID);
	}

	/**
	* Returns all the search histories.
	*
	* @return the search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the search histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @return the range of search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the search histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search histories
	* @param end the upper bound of the range of search histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search histories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SearchHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the search histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of search histories.
	*
	* @return the number of search histories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SearchHistoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SearchHistoryPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					SearchHistoryPersistence.class.getName());

			ReferenceRegistry.registerReference(SearchHistoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SearchHistoryPersistence persistence) {
	}

	private static SearchHistoryPersistence _persistence;
}