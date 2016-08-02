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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchSearchHistoryException;

import org.gfbio.model.SearchHistory;
import org.gfbio.model.impl.SearchHistoryImpl;
import org.gfbio.model.impl.SearchHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the search history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SearchHistoryPersistence
 * @see SearchHistoryUtil
 * @generated
 */
public class SearchHistoryPersistenceImpl extends BasePersistenceImpl<SearchHistory>
	implements SearchHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchHistoryUtil} to access the search history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHHISTORYID = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySearchHistoryID", new String[] { Long.class.getName() },
			SearchHistoryModelImpl.SEARCHHISTORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHHISTORYID = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchHistoryID", new String[] { Long.class.getName() });

	/**
	 * Returns the search history where searchHistoryID = &#63; or throws a {@link org.gfbio.NoSuchSearchHistoryException} if it could not be found.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search history
	 * @throws org.gfbio.NoSuchSearchHistoryException if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory findBySearchHistoryID(long searchHistoryID)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchBySearchHistoryID(searchHistoryID);

		if (searchHistory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("searchHistoryID=");
			msg.append(searchHistoryID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSearchHistoryException(msg.toString());
		}

		return searchHistory;
	}

	/**
	 * Returns the search history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchBySearchHistoryID(long searchHistoryID)
		throws SystemException {
		return fetchBySearchHistoryID(searchHistoryID, true);
	}

	/**
	 * Returns the search history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchHistoryID the search history i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchBySearchHistoryID(long searchHistoryID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { searchHistoryID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
					finderArgs, this);
		}

		if (result instanceof SearchHistory) {
			SearchHistory searchHistory = (SearchHistory)result;

			if ((searchHistoryID != searchHistory.getSearchHistoryID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYID_SEARCHHISTORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				List<SearchHistory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SearchHistoryPersistenceImpl.fetchBySearchHistoryID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SearchHistory searchHistory = list.get(0);

					result = searchHistory;

					cacheResult(searchHistory);

					if ((searchHistory.getSearchHistoryID() != searchHistoryID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
							finderArgs, searchHistory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SearchHistory)result;
		}
	}

	/**
	 * Removes the search history where searchHistoryID = &#63; from the database.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the search history that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory removeBySearchHistoryID(long searchHistoryID)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = findBySearchHistoryID(searchHistoryID);

		return remove(searchHistory);
	}

	/**
	 * Returns the number of search histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchHistoryID(long searchHistoryID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHHISTORYID;

		Object[] finderArgs = new Object[] { searchHistoryID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYID_SEARCHHISTORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEARCHHISTORYID_SEARCHHISTORYID_2 =
		"searchHistory.searchHistoryID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySearchHistoryIDs",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySearchHistoryIDs", new String[] { Long.class.getName() },
			SearchHistoryModelImpl.SEARCHHISTORYID_COLUMN_BITMASK |
			SearchHistoryModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchHistoryIDs", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHHISTORYIDS =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySearchHistoryIDs",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long searchHistoryID)
		throws SystemException {
		return findBySearchHistoryIDs(searchHistoryID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long searchHistoryID,
		int start, int end) throws SystemException {
		return findBySearchHistoryIDs(searchHistoryID, start, end, null);
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
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long searchHistoryID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS;
			finderArgs = new Object[] { searchHistoryID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS;
			finderArgs = new Object[] {
					searchHistoryID,
					
					start, end, orderByComparator
				};
		}

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if ((searchHistoryID != searchHistory.getSearchHistoryID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SearchHistory findBySearchHistoryIDs_First(long searchHistoryID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchBySearchHistoryIDs_First(searchHistoryID,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchHistoryID=");
		msg.append(searchHistoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the first search history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchBySearchHistoryIDs_First(long searchHistoryID,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchHistory> list = findBySearchHistoryIDs(searchHistoryID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory findBySearchHistoryIDs_Last(long searchHistoryID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchBySearchHistoryIDs_Last(searchHistoryID,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchHistoryID=");
		msg.append(searchHistoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the last search history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchBySearchHistoryIDs_Last(long searchHistoryID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySearchHistoryIDs(searchHistoryID);

		if (count == 0) {
			return null;
		}

		List<SearchHistory> list = findBySearchHistoryIDs(searchHistoryID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long[] searchHistoryIDs)
		throws SystemException {
		return findBySearchHistoryIDs(searchHistoryIDs, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long[] searchHistoryIDs,
		int start, int end) throws SystemException {
		return findBySearchHistoryIDs(searchHistoryIDs, start, end, null);
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
	@Override
	public List<SearchHistory> findBySearchHistoryIDs(long[] searchHistoryIDs,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((searchHistoryIDs != null) && (searchHistoryIDs.length == 1)) {
			return findBySearchHistoryIDs(searchHistoryIDs[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(searchHistoryIDs) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(searchHistoryIDs),
					
					start, end, orderByComparator
				};
		}

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if (!ArrayUtil.contains(searchHistoryIDs,
							searchHistory.getSearchHistoryID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			boolean conjunctionable = false;

			if ((searchHistoryIDs == null) || (searchHistoryIDs.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < searchHistoryIDs.length; i++) {
					query.append(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_5);

					if ((i + 1) < searchHistoryIDs.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (searchHistoryIDs != null) {
					qPos.add(searchHistoryIDs);
				}

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the search histories where searchHistoryID = &#63; from the database.
	 *
	 * @param searchHistoryID the search history i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySearchHistoryIDs(long searchHistoryID)
		throws SystemException {
		for (SearchHistory searchHistory : findBySearchHistoryIDs(
				searchHistoryID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchHistoryIDs(long searchHistoryID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS;

		Object[] finderArgs = new Object[] { searchHistoryID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of search histories where searchHistoryID = any &#63;.
	 *
	 * @param searchHistoryIDs the search history i ds
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchHistoryIDs(long[] searchHistoryIDs)
		throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(searchHistoryIDs) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHHISTORYIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			boolean conjunctionable = false;

			if ((searchHistoryIDs == null) || (searchHistoryIDs.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < searchHistoryIDs.length; i++) {
					query.append(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_5);

					if ((i + 1) < searchHistoryIDs.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (searchHistoryIDs != null) {
					qPos.add(searchHistoryIDs);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHHISTORYIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHHISTORYIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2 =
		"searchHistory.searchHistoryID = ?";
	private static final String _FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserID", new String[] { Long.class.getName() },
			SearchHistoryModelImpl.USERID_COLUMN_BITMASK |
			SearchHistoryModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search histories where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
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
	@Override
	public List<SearchHistory> findByUserID(long userID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userID, start, end, orderByComparator };
		}

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if ((userID != searchHistory.getUserID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SearchHistory findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByUserID_First(userID,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the first search history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchHistory> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByUserID_Last(userID,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the last search history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<SearchHistory> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory[] findByUserID_PrevAndNext(long searchHistoryID,
		long userID, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			SearchHistory[] array = new SearchHistoryImpl[3];

			array[0] = getByUserID_PrevAndNext(session, searchHistory, userID,
					orderByComparator, true);

			array[1] = searchHistory;

			array[2] = getByUserID_PrevAndNext(session, searchHistory, userID,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchHistory getByUserID_PrevAndNext(Session session,
		SearchHistory searchHistory, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search histories where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (SearchHistory searchHistory : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserID(long userID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "searchHistory.userID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSINCE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIDSince",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDSINCE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIDSince",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findByUserIDSince(long userID,
		Date lastModifiedDate) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findByUserIDSince(long userID,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, start, end, null);
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
	@Override
	public List<SearchHistory> findByUserIDSince(long userID,
		Date lastModifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSINCE;
		finderArgs = new Object[] {
				userID, lastModifiedDate,
				
				start, end, orderByComparator
			};

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if ((userID != searchHistory.getUserID()) ||
						(lastModifiedDate.getTime() >= searchHistory.getLastModifiedDate()
																		.getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_USERIDSINCE_USERID_2);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SearchHistory findByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByUserIDSince_First(userID,
				lastModifiedDate, orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
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
	@Override
	public SearchHistory fetchByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchHistory> list = findByUserIDSince(userID, lastModifiedDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory findByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByUserIDSince_Last(userID,
				lastModifiedDate, orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
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
	@Override
	public SearchHistory fetchByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIDSince(userID, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchHistory> list = findByUserIDSince(userID, lastModifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory[] findByUserIDSince_PrevAndNext(long searchHistoryID,
		long userID, Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			SearchHistory[] array = new SearchHistoryImpl[3];

			array[0] = getByUserIDSince_PrevAndNext(session, searchHistory,
					userID, lastModifiedDate, orderByComparator, true);

			array[1] = searchHistory;

			array[2] = getByUserIDSince_PrevAndNext(session, searchHistory,
					userID, lastModifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchHistory getByUserIDSince_PrevAndNext(Session session,
		SearchHistory searchHistory, long userID, Date lastModifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

		query.append(_FINDER_COLUMN_USERIDSINCE_USERID_2);

		boolean bindLastModifiedDate = false;

		if (lastModifiedDate == null) {
			query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1);
		}
		else {
			bindLastModifiedDate = true;

			query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (bindLastModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search histories where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIDSince(long userID, Date lastModifiedDate)
		throws SystemException {
		for (SearchHistory searchHistory : findByUserIDSince(userID,
				lastModifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIDSince(long userID, Date lastModifiedDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDSINCE;

		Object[] finderArgs = new Object[] { userID, lastModifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			query.append(_FINDER_COLUMN_USERIDSINCE_USERID_2);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDSINCE_USERID_2 = "searchHistory.userID = ? AND ";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1 = "searchHistory.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2 = "searchHistory.lastModifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search histories where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findByQueryMessage(String queryString)
		throws SystemException {
		return findByQueryMessage(queryString, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findByQueryMessage(String queryString,
		int start, int end) throws SystemException {
		return findByQueryMessage(queryString, start, end, null);
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
	@Override
	public List<SearchHistory> findByQueryMessage(String queryString,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE;
		finderArgs = new Object[] { queryString, start, end, orderByComparator };

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if (!StringUtil.wildcardMatches(
							searchHistory.getQueryString(), queryString,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			boolean bindQueryString = false;

			if (queryString == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1);
			}
			else if (queryString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3);
			}
			else {
				bindQueryString = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueryString) {
					qPos.add(queryString);
				}

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SearchHistory findByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByQueryMessage_First(queryString,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the first search history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchHistory> list = findByQueryMessage(queryString, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory findByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByQueryMessage_Last(queryString,
				orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
	}

	/**
	 * Returns the last search history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search history, or <code>null</code> if a matching search history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQueryMessage(queryString);

		if (count == 0) {
			return null;
		}

		List<SearchHistory> list = findByQueryMessage(queryString, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory[] findByQueryMessage_PrevAndNext(
		long searchHistoryID, String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			SearchHistory[] array = new SearchHistoryImpl[3];

			array[0] = getByQueryMessage_PrevAndNext(session, searchHistory,
					queryString, orderByComparator, true);

			array[1] = searchHistory;

			array[2] = getByQueryMessage_PrevAndNext(session, searchHistory,
					queryString, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchHistory getByQueryMessage_PrevAndNext(Session session,
		SearchHistory searchHistory, String queryString,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

		boolean bindQueryString = false;

		if (queryString == null) {
			query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1);
		}
		else if (queryString.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3);
		}
		else {
			bindQueryString = true;

			query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindQueryString) {
			qPos.add(queryString);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search histories where queryString LIKE &#63; from the database.
	 *
	 * @param queryString the query string
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessage(String queryString)
		throws SystemException {
		for (SearchHistory searchHistory : findByQueryMessage(queryString,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQueryMessage(String queryString)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGE;

		Object[] finderArgs = new Object[] { queryString };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			boolean bindQueryString = false;

			if (queryString == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1);
			}
			else if (queryString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3);
			}
			else {
				bindQueryString = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueryString) {
					qPos.add(queryString);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1 = "searchHistory.queryString LIKE NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2 = "searchHistory.queryString LIKE ?";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3 = "(searchHistory.queryString IS NULL OR searchHistory.queryString LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGESINCE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED,
			SearchHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessageSince",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGESINCE =
		new FinderPath(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessageSince",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findByQueryMessageSince(String queryString,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate, start,
			end, null);
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
	@Override
	public List<SearchHistory> findByQueryMessageSince(String queryString,
		Date lastModifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGESINCE;
		finderArgs = new Object[] {
				queryString, lastModifiedDate,
				
				start, end, orderByComparator
			};

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchHistory searchHistory : list) {
				if (!StringUtil.wildcardMatches(
							searchHistory.getQueryString(), queryString,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(lastModifiedDate.getTime() >= searchHistory.getLastModifiedDate()
																		.getTime())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

			boolean bindQueryString = false;

			if (queryString == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1);
			}
			else if (queryString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3);
			}
			else {
				bindQueryString = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2);
			}

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueryString) {
					qPos.add(queryString);
				}

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SearchHistory findByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByQueryMessageSince_First(queryString,
				lastModifiedDate, orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
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
	@Override
	public SearchHistory fetchByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchHistory> list = findByQueryMessageSince(queryString,
				lastModifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory findByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByQueryMessageSince_Last(queryString,
				lastModifiedDate, orderByComparator);

		if (searchHistory != null) {
			return searchHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchHistoryException(msg.toString());
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
	@Override
	public SearchHistory fetchByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByQueryMessageSince(queryString, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchHistory> list = findByQueryMessageSince(queryString,
				lastModifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SearchHistory[] findByQueryMessageSince_PrevAndNext(
		long searchHistoryID, String queryString, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			SearchHistory[] array = new SearchHistoryImpl[3];

			array[0] = getByQueryMessageSince_PrevAndNext(session,
					searchHistory, queryString, lastModifiedDate,
					orderByComparator, true);

			array[1] = searchHistory;

			array[2] = getByQueryMessageSince_PrevAndNext(session,
					searchHistory, queryString, lastModifiedDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchHistory getByQueryMessageSince_PrevAndNext(
		Session session, SearchHistory searchHistory, String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHHISTORY_WHERE);

		boolean bindQueryString = false;

		if (queryString == null) {
			query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1);
		}
		else if (queryString.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3);
		}
		else {
			bindQueryString = true;

			query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2);
		}

		boolean bindLastModifiedDate = false;

		if (lastModifiedDate == null) {
			query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1);
		}
		else {
			bindLastModifiedDate = true;

			query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SearchHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindQueryString) {
			qPos.add(queryString);
		}

		if (bindLastModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		for (SearchHistory searchHistory : findByQueryMessageSince(
				queryString, lastModifiedDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGESINCE;

		Object[] finderArgs = new Object[] { queryString, lastModifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHHISTORY_WHERE);

			boolean bindQueryString = false;

			if (queryString == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1);
			}
			else if (queryString.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3);
			}
			else {
				bindQueryString = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2);
			}

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueryString) {
					qPos.add(queryString);
				}

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1 = "searchHistory.queryString LIKE NULL AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2 = "searchHistory.queryString LIKE ? AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3 = "(searchHistory.queryString IS NULL OR searchHistory.queryString LIKE '') AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1 =
		"searchHistory.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2 =
		"searchHistory.lastModifiedDate > ?";

	public SearchHistoryPersistenceImpl() {
		setModelClass(SearchHistory.class);
	}

	/**
	 * Caches the search history in the entity cache if it is enabled.
	 *
	 * @param searchHistory the search history
	 */
	@Override
	public void cacheResult(SearchHistory searchHistory) {
		EntityCacheUtil.putResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryImpl.class, searchHistory.getPrimaryKey(),
			searchHistory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
			new Object[] { searchHistory.getSearchHistoryID() }, searchHistory);

		searchHistory.resetOriginalValues();
	}

	/**
	 * Caches the search histories in the entity cache if it is enabled.
	 *
	 * @param searchHistories the search histories
	 */
	@Override
	public void cacheResult(List<SearchHistory> searchHistories) {
		for (SearchHistory searchHistory : searchHistories) {
			if (EntityCacheUtil.getResult(
						SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
						SearchHistoryImpl.class, searchHistory.getPrimaryKey()) == null) {
				cacheResult(searchHistory);
			}
			else {
				searchHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SearchHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SearchHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchHistory searchHistory) {
		EntityCacheUtil.removeResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryImpl.class, searchHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(searchHistory);
	}

	@Override
	public void clearCache(List<SearchHistory> searchHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchHistory searchHistory : searchHistories) {
			EntityCacheUtil.removeResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
				SearchHistoryImpl.class, searchHistory.getPrimaryKey());

			clearUniqueFindersCache(searchHistory);
		}
	}

	protected void cacheUniqueFindersCache(SearchHistory searchHistory) {
		if (searchHistory.isNew()) {
			Object[] args = new Object[] { searchHistory.getSearchHistoryID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
				args, searchHistory);
		}
		else {
			SearchHistoryModelImpl searchHistoryModelImpl = (SearchHistoryModelImpl)searchHistory;

			if ((searchHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHHISTORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { searchHistory.getSearchHistoryID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
					args, searchHistory);
			}
		}
	}

	protected void clearUniqueFindersCache(SearchHistory searchHistory) {
		SearchHistoryModelImpl searchHistoryModelImpl = (SearchHistoryModelImpl)searchHistory;

		Object[] args = new Object[] { searchHistory.getSearchHistoryID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID, args);

		if ((searchHistoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHHISTORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					searchHistoryModelImpl.getOriginalSearchHistoryID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
				args);
		}
	}

	/**
	 * Creates a new search history with the primary key. Does not add the search history to the database.
	 *
	 * @param searchHistoryID the primary key for the new search history
	 * @return the new search history
	 */
	@Override
	public SearchHistory create(long searchHistoryID) {
		SearchHistory searchHistory = new SearchHistoryImpl();

		searchHistory.setNew(true);
		searchHistory.setPrimaryKey(searchHistoryID);

		return searchHistory;
	}

	/**
	 * Removes the search history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchHistoryID the primary key of the search history
	 * @return the search history that was removed
	 * @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory remove(long searchHistoryID)
		throws NoSuchSearchHistoryException, SystemException {
		return remove((Serializable)searchHistoryID);
	}

	/**
	 * Removes the search history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search history
	 * @return the search history that was removed
	 * @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory remove(Serializable primaryKey)
		throws NoSuchSearchHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SearchHistory searchHistory = (SearchHistory)session.get(SearchHistoryImpl.class,
					primaryKey);

			if (searchHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchHistory);
		}
		catch (NoSuchSearchHistoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SearchHistory removeImpl(SearchHistory searchHistory)
		throws SystemException {
		searchHistory = toUnwrappedModel(searchHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(searchHistory)) {
				searchHistory = (SearchHistory)session.get(SearchHistoryImpl.class,
						searchHistory.getPrimaryKeyObj());
			}

			if (searchHistory != null) {
				session.delete(searchHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (searchHistory != null) {
			clearCache(searchHistory);
		}

		return searchHistory;
	}

	@Override
	public SearchHistory updateImpl(org.gfbio.model.SearchHistory searchHistory)
		throws SystemException {
		searchHistory = toUnwrappedModel(searchHistory);

		boolean isNew = searchHistory.isNew();

		SearchHistoryModelImpl searchHistoryModelImpl = (SearchHistoryModelImpl)searchHistory;

		Session session = null;

		try {
			session = openSession();

			if (searchHistory.isNew()) {
				session.save(searchHistory);

				searchHistory.setNew(false);
			}
			else {
				session.merge(searchHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchHistoryModelImpl.getOriginalSearchHistoryID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					args);

				args = new Object[] { searchHistoryModelImpl.getSearchHistoryID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					args);
			}

			if ((searchHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchHistoryModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { searchHistoryModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
			SearchHistoryImpl.class, searchHistory.getPrimaryKey(),
			searchHistory);

		clearUniqueFindersCache(searchHistory);
		cacheUniqueFindersCache(searchHistory);

		return searchHistory;
	}

	protected SearchHistory toUnwrappedModel(SearchHistory searchHistory) {
		if (searchHistory instanceof SearchHistoryImpl) {
			return searchHistory;
		}

		SearchHistoryImpl searchHistoryImpl = new SearchHistoryImpl();

		searchHistoryImpl.setNew(searchHistory.isNew());
		searchHistoryImpl.setPrimaryKey(searchHistory.getPrimaryKey());

		searchHistoryImpl.setSearchHistoryID(searchHistory.getSearchHistoryID());
		searchHistoryImpl.setUserID(searchHistory.getUserID());
		searchHistoryImpl.setQueryString(searchHistory.getQueryString());
		searchHistoryImpl.setLastModifiedDate(searchHistory.getLastModifiedDate());

		return searchHistoryImpl;
	}

	/**
	 * Returns the search history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search history
	 * @return the search history
	 * @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSearchHistoryException, SystemException {
		SearchHistory searchHistory = fetchByPrimaryKey(primaryKey);

		if (searchHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSearchHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return searchHistory;
	}

	/**
	 * Returns the search history with the primary key or throws a {@link org.gfbio.NoSuchSearchHistoryException} if it could not be found.
	 *
	 * @param searchHistoryID the primary key of the search history
	 * @return the search history
	 * @throws org.gfbio.NoSuchSearchHistoryException if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory findByPrimaryKey(long searchHistoryID)
		throws NoSuchSearchHistoryException, SystemException {
		return findByPrimaryKey((Serializable)searchHistoryID);
	}

	/**
	 * Returns the search history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search history
	 * @return the search history, or <code>null</code> if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SearchHistory searchHistory = (SearchHistory)EntityCacheUtil.getResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
				SearchHistoryImpl.class, primaryKey);

		if (searchHistory == _nullSearchHistory) {
			return null;
		}

		if (searchHistory == null) {
			Session session = null;

			try {
				session = openSession();

				searchHistory = (SearchHistory)session.get(SearchHistoryImpl.class,
						primaryKey);

				if (searchHistory != null) {
					cacheResult(searchHistory);
				}
				else {
					EntityCacheUtil.putResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
						SearchHistoryImpl.class, primaryKey, _nullSearchHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SearchHistoryModelImpl.ENTITY_CACHE_ENABLED,
					SearchHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return searchHistory;
	}

	/**
	 * Returns the search history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchHistoryID the primary key of the search history
	 * @return the search history, or <code>null</code> if a search history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchHistory fetchByPrimaryKey(long searchHistoryID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)searchHistoryID);
	}

	/**
	 * Returns all the search histories.
	 *
	 * @return the search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SearchHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SearchHistory> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SearchHistory> list = (List<SearchHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCHHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHHISTORY;

				if (pagination) {
					sql = sql.concat(SearchHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchHistory>(list);
				}
				else {
					list = (List<SearchHistory>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the search histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SearchHistory searchHistory : findAll()) {
			remove(searchHistory);
		}
	}

	/**
	 * Returns the number of search histories.
	 *
	 * @return the number of search histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEARCHHISTORY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the search history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.SearchHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SearchHistory>> listenersList = new ArrayList<ModelListener<SearchHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SearchHistory>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SearchHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEARCHHISTORY = "SELECT searchHistory FROM SearchHistory searchHistory";
	private static final String _SQL_SELECT_SEARCHHISTORY_WHERE = "SELECT searchHistory FROM SearchHistory searchHistory WHERE ";
	private static final String _SQL_COUNT_SEARCHHISTORY = "SELECT COUNT(searchHistory) FROM SearchHistory searchHistory";
	private static final String _SQL_COUNT_SEARCHHISTORY_WHERE = "SELECT COUNT(searchHistory) FROM SearchHistory searchHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SearchHistoryPersistenceImpl.class);
	private static SearchHistory _nullSearchHistory = new SearchHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SearchHistory> toCacheModel() {
				return _nullSearchHistoryCacheModel;
			}
		};

	private static CacheModel<SearchHistory> _nullSearchHistoryCacheModel = new CacheModel<SearchHistory>() {
			@Override
			public SearchHistory toEntityModel() {
				return _nullSearchHistory;
			}
		};
}