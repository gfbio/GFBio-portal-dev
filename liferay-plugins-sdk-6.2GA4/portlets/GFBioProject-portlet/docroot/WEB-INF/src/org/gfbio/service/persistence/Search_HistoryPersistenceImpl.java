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

import org.gfbio.NoSuchSearch_HistoryException;

import org.gfbio.model.Search_History;
import org.gfbio.model.impl.Search_HistoryImpl;
import org.gfbio.model.impl.Search_HistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the search_ history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Search_HistoryPersistence
 * @see Search_HistoryUtil
 * @generated
 */
public class Search_HistoryPersistenceImpl extends BasePersistenceImpl<Search_History>
	implements Search_HistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Search_HistoryUtil} to access the search_ history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Search_HistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHHISTORYID = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySearchHistoryID", new String[] { Long.class.getName() },
			Search_HistoryModelImpl.SEARCHHISTORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHHISTORYID = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchHistoryID", new String[] { Long.class.getName() });

	/**
	 * Returns the search_ history where searchHistoryID = &#63; or throws a {@link org.gfbio.NoSuchSearch_HistoryException} if it could not be found.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findBySearchHistoryID(long searchHistoryID)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchBySearchHistoryID(searchHistoryID);

		if (search_History == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("searchHistoryID=");
			msg.append(searchHistoryID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSearch_HistoryException(msg.toString());
		}

		return search_History;
	}

	/**
	 * Returns the search_ history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchBySearchHistoryID(long searchHistoryID)
		throws SystemException {
		return fetchBySearchHistoryID(searchHistoryID, true);
	}

	/**
	 * Returns the search_ history where searchHistoryID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchHistoryID the search history i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchBySearchHistoryID(long searchHistoryID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { searchHistoryID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
					finderArgs, this);
		}

		if (result instanceof Search_History) {
			Search_History search_History = (Search_History)result;

			if ((searchHistoryID != search_History.getSearchHistoryID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYID_SEARCHHISTORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				List<Search_History> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Search_HistoryPersistenceImpl.fetchBySearchHistoryID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Search_History search_History = list.get(0);

					result = search_History;

					cacheResult(search_History);

					if ((search_History.getSearchHistoryID() != searchHistoryID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
							finderArgs, search_History);
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
			return (Search_History)result;
		}
	}

	/**
	 * Removes the search_ history where searchHistoryID = &#63; from the database.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the search_ history that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History removeBySearchHistoryID(long searchHistoryID)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = findBySearchHistoryID(searchHistoryID);

		return remove(search_History);
	}

	/**
	 * Returns the number of search_ histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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
		"search_History.searchHistoryID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySearchHistoryIDs",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySearchHistoryIDs", new String[] { Long.class.getName() },
			Search_HistoryModelImpl.SEARCHHISTORYID_COLUMN_BITMASK |
			Search_HistoryModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchHistoryIDs", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHHISTORYIDS =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySearchHistoryIDs",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search_ histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the matching search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findBySearchHistoryIDs(long searchHistoryID)
		throws SystemException {
		return findBySearchHistoryIDs(searchHistoryID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findBySearchHistoryIDs(long searchHistoryID,
		int start, int end) throws SystemException {
		return findBySearchHistoryIDs(searchHistoryID, start, end, null);
	}

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
	@Override
	public List<Search_History> findBySearchHistoryIDs(long searchHistoryID,
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if ((searchHistoryID != search_History.getSearchHistoryID())) {
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

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

			query.append(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchHistoryID);

				if (!pagination) {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first search_ history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findBySearchHistoryIDs_First(long searchHistoryID,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchBySearchHistoryIDs_First(searchHistoryID,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchHistoryID=");
		msg.append(searchHistoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the first search_ history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchBySearchHistoryIDs_First(long searchHistoryID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Search_History> list = findBySearchHistoryIDs(searchHistoryID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search_ history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findBySearchHistoryIDs_Last(long searchHistoryID,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchBySearchHistoryIDs_Last(searchHistoryID,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchHistoryID=");
		msg.append(searchHistoryID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the last search_ history in the ordered set where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchBySearchHistoryIDs_Last(long searchHistoryID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySearchHistoryIDs(searchHistoryID);

		if (count == 0) {
			return null;
		}

		List<Search_History> list = findBySearchHistoryIDs(searchHistoryID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public List<Search_History> findBySearchHistoryIDs(long[] searchHistoryIDs)
		throws SystemException {
		return findBySearchHistoryIDs(searchHistoryIDs, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end) throws SystemException {
		return findBySearchHistoryIDs(searchHistoryIDs, start, end, null);
	}

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
	@Override
	public List<Search_History> findBySearchHistoryIDs(
		long[] searchHistoryIDs, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if (!ArrayUtil.contains(searchHistoryIDs,
							search_History.getSearchHistoryID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the search_ histories where searchHistoryID = &#63; from the database.
	 *
	 * @param searchHistoryID the search history i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySearchHistoryIDs(long searchHistoryID)
		throws SystemException {
		for (Search_History search_History : findBySearchHistoryIDs(
				searchHistoryID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories where searchHistoryID = &#63;.
	 *
	 * @param searchHistoryID the search history i d
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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
	 * Returns the number of search_ histories where searchHistoryID = any &#63;.
	 *
	 * @param searchHistoryIDs the search history i ds
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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
		"search_History.searchHistoryID = ?";
	private static final String _FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SEARCHHISTORYIDS_SEARCHHISTORYID_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			Search_HistoryModelImpl.USERID_COLUMN_BITMASK |
			Search_HistoryModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search_ histories where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

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
	@Override
	public List<Search_History> findByUserID(long userID, int start, int end,
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if ((userID != search_History.getUserID())) {
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

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first search_ history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByUserID_First(userID,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the first search_ history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Search_History> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search_ history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByUserID_Last(userID,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the last search_ history in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Search_History> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History[] findByUserID_PrevAndNext(long searchHistoryID,
		long userID, OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			Search_History[] array = new Search_HistoryImpl[3];

			array[0] = getByUserID_PrevAndNext(session, search_History, userID,
					orderByComparator, true);

			array[1] = search_History;

			array[2] = getByUserID_PrevAndNext(session, search_History, userID,
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

	protected Search_History getByUserID_PrevAndNext(Session session,
		Search_History search_History, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
			query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(search_History);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Search_History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search_ histories where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Search_History search_History : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "search_History.userID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSINCE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIDSince",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDSINCE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIDSince",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the matching search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findByUserIDSince(long userID,
		Date lastModifiedDate) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findByUserIDSince(long userID,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, start, end, null);
	}

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
	@Override
	public List<Search_History> findByUserIDSince(long userID,
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if ((userID != search_History.getUserID()) ||
						(lastModifiedDate.getTime() >= search_History.getLastModifiedDate()
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

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByUserIDSince_First(userID,
				lastModifiedDate, orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the first search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<Search_History> list = findByUserIDSince(userID, lastModifiedDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History findByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByUserIDSince_Last(userID,
				lastModifiedDate, orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the last search_ history in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIDSince(userID, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<Search_History> list = findByUserIDSince(userID, lastModifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History[] findByUserIDSince_PrevAndNext(
		long searchHistoryID, long userID, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			Search_History[] array = new Search_HistoryImpl[3];

			array[0] = getByUserIDSince_PrevAndNext(session, search_History,
					userID, lastModifiedDate, orderByComparator, true);

			array[1] = search_History;

			array[2] = getByUserIDSince_PrevAndNext(session, search_History,
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

	protected Search_History getByUserIDSince_PrevAndNext(Session session,
		Search_History search_History, long userID, Date lastModifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
			query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(search_History);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Search_History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search_ histories where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIDSince(long userID, Date lastModifiedDate)
		throws SystemException {
		for (Search_History search_History : findByUserIDSince(userID,
				lastModifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_USERIDSINCE_USERID_2 = "search_History.userID = ? AND ";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1 = "search_History.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2 = "search_History.lastModifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search_ histories where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the matching search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findByQueryMessage(String queryString)
		throws SystemException {
		return findByQueryMessage(queryString, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findByQueryMessage(String queryString,
		int start, int end) throws SystemException {
		return findByQueryMessage(queryString, start, end, null);
	}

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
	@Override
	public List<Search_History> findByQueryMessage(String queryString,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE;
		finderArgs = new Object[] { queryString, start, end, orderByComparator };

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if (!StringUtil.wildcardMatches(
							search_History.getQueryString(), queryString,
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

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first search_ history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByQueryMessage_First(queryString,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the first search_ history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		List<Search_History> list = findByQueryMessage(queryString, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search_ history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByQueryMessage_Last(queryString,
				orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the last search_ history in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQueryMessage(queryString);

		if (count == 0) {
			return null;
		}

		List<Search_History> list = findByQueryMessage(queryString, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History[] findByQueryMessage_PrevAndNext(
		long searchHistoryID, String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			Search_History[] array = new Search_HistoryImpl[3];

			array[0] = getByQueryMessage_PrevAndNext(session, search_History,
					queryString, orderByComparator, true);

			array[1] = search_History;

			array[2] = getByQueryMessage_PrevAndNext(session, search_History,
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

	protected Search_History getByQueryMessage_PrevAndNext(Session session,
		Search_History search_History, String queryString,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
			query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(search_History);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Search_History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search_ histories where queryString LIKE &#63; from the database.
	 *
	 * @param queryString the query string
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessage(String queryString)
		throws SystemException {
		for (Search_History search_History : findByQueryMessage(queryString,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1 = "search_History.queryString LIKE NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2 = "search_History.queryString LIKE ?";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3 = "(search_History.queryString IS NULL OR search_History.queryString LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGESINCE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED,
			Search_HistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessageSince",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGESINCE =
		new FinderPath(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessageSince",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the matching search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findByQueryMessageSince(String queryString,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate, start,
			end, null);
	}

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
	@Override
	public List<Search_History> findByQueryMessageSince(String queryString,
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Search_History search_History : list) {
				if (!StringUtil.wildcardMatches(
							search_History.getQueryString(), queryString,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(lastModifiedDate.getTime() >= search_History.getLastModifiedDate()
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

			query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
				query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByQueryMessageSince_First(queryString,
				lastModifiedDate, orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the first search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<Search_History> list = findByQueryMessageSince(queryString,
				lastModifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History findByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByQueryMessageSince_Last(queryString,
				lastModifiedDate, orderByComparator);

		if (search_History != null) {
			return search_History;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearch_HistoryException(msg.toString());
	}

	/**
	 * Returns the last search_ history in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search_ history, or <code>null</code> if a matching search_ history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByQueryMessageSince(queryString, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<Search_History> list = findByQueryMessageSince(queryString,
				lastModifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Search_History[] findByQueryMessageSince_PrevAndNext(
		long searchHistoryID, String queryString, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = findByPrimaryKey(searchHistoryID);

		Session session = null;

		try {
			session = openSession();

			Search_History[] array = new Search_HistoryImpl[3];

			array[0] = getByQueryMessageSince_PrevAndNext(session,
					search_History, queryString, lastModifiedDate,
					orderByComparator, true);

			array[1] = search_History;

			array[2] = getByQueryMessageSince_PrevAndNext(session,
					search_History, queryString, lastModifiedDate,
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

	protected Search_History getByQueryMessageSince_PrevAndNext(
		Session session, Search_History search_History, String queryString,
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

		query.append(_SQL_SELECT_SEARCH_HISTORY_WHERE);

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
			query.append(Search_HistoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(search_History);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Search_History> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		for (Search_History search_History : findByQueryMessageSince(
				queryString, lastModifiedDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search_ histories
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

			query.append(_SQL_COUNT_SEARCH_HISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1 = "search_History.queryString LIKE NULL AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2 = "search_History.queryString LIKE ? AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3 = "(search_History.queryString IS NULL OR search_History.queryString LIKE '') AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1 =
		"search_History.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2 =
		"search_History.lastModifiedDate > ?";

	public Search_HistoryPersistenceImpl() {
		setModelClass(Search_History.class);
	}

	/**
	 * Caches the search_ history in the entity cache if it is enabled.
	 *
	 * @param search_History the search_ history
	 */
	@Override
	public void cacheResult(Search_History search_History) {
		EntityCacheUtil.putResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryImpl.class, search_History.getPrimaryKey(),
			search_History);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
			new Object[] { search_History.getSearchHistoryID() }, search_History);

		search_History.resetOriginalValues();
	}

	/**
	 * Caches the search_ histories in the entity cache if it is enabled.
	 *
	 * @param search_Histories the search_ histories
	 */
	@Override
	public void cacheResult(List<Search_History> search_Histories) {
		for (Search_History search_History : search_Histories) {
			if (EntityCacheUtil.getResult(
						Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
						Search_HistoryImpl.class, search_History.getPrimaryKey()) == null) {
				cacheResult(search_History);
			}
			else {
				search_History.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search_ histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Search_HistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Search_HistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search_ history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Search_History search_History) {
		EntityCacheUtil.removeResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryImpl.class, search_History.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(search_History);
	}

	@Override
	public void clearCache(List<Search_History> search_Histories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Search_History search_History : search_Histories) {
			EntityCacheUtil.removeResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
				Search_HistoryImpl.class, search_History.getPrimaryKey());

			clearUniqueFindersCache(search_History);
		}
	}

	protected void cacheUniqueFindersCache(Search_History search_History) {
		if (search_History.isNew()) {
			Object[] args = new Object[] { search_History.getSearchHistoryID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
				args, search_History);
		}
		else {
			Search_HistoryModelImpl search_HistoryModelImpl = (Search_HistoryModelImpl)search_History;

			if ((search_HistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHHISTORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { search_History.getSearchHistoryID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
					args, search_History);
			}
		}
	}

	protected void clearUniqueFindersCache(Search_History search_History) {
		Search_HistoryModelImpl search_HistoryModelImpl = (Search_HistoryModelImpl)search_History;

		Object[] args = new Object[] { search_History.getSearchHistoryID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID, args);

		if ((search_HistoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHHISTORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					search_HistoryModelImpl.getOriginalSearchHistoryID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHHISTORYID,
				args);
		}
	}

	/**
	 * Creates a new search_ history with the primary key. Does not add the search_ history to the database.
	 *
	 * @param searchHistoryID the primary key for the new search_ history
	 * @return the new search_ history
	 */
	@Override
	public Search_History create(long searchHistoryID) {
		Search_History search_History = new Search_HistoryImpl();

		search_History.setNew(true);
		search_History.setPrimaryKey(searchHistoryID);

		return search_History;
	}

	/**
	 * Removes the search_ history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchHistoryID the primary key of the search_ history
	 * @return the search_ history that was removed
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History remove(long searchHistoryID)
		throws NoSuchSearch_HistoryException, SystemException {
		return remove((Serializable)searchHistoryID);
	}

	/**
	 * Removes the search_ history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search_ history
	 * @return the search_ history that was removed
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History remove(Serializable primaryKey)
		throws NoSuchSearch_HistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Search_History search_History = (Search_History)session.get(Search_HistoryImpl.class,
					primaryKey);

			if (search_History == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearch_HistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(search_History);
		}
		catch (NoSuchSearch_HistoryException nsee) {
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
	protected Search_History removeImpl(Search_History search_History)
		throws SystemException {
		search_History = toUnwrappedModel(search_History);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(search_History)) {
				search_History = (Search_History)session.get(Search_HistoryImpl.class,
						search_History.getPrimaryKeyObj());
			}

			if (search_History != null) {
				session.delete(search_History);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (search_History != null) {
			clearCache(search_History);
		}

		return search_History;
	}

	@Override
	public Search_History updateImpl(
		org.gfbio.model.Search_History search_History)
		throws SystemException {
		search_History = toUnwrappedModel(search_History);

		boolean isNew = search_History.isNew();

		Search_HistoryModelImpl search_HistoryModelImpl = (Search_HistoryModelImpl)search_History;

		Session session = null;

		try {
			session = openSession();

			if (search_History.isNew()) {
				session.save(search_History);

				search_History.setNew(false);
			}
			else {
				session.merge(search_History);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Search_HistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((search_HistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						search_HistoryModelImpl.getOriginalSearchHistoryID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					args);

				args = new Object[] { search_HistoryModelImpl.getSearchHistoryID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHHISTORYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHHISTORYIDS,
					args);
			}

			if ((search_HistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						search_HistoryModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { search_HistoryModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
			Search_HistoryImpl.class, search_History.getPrimaryKey(),
			search_History);

		clearUniqueFindersCache(search_History);
		cacheUniqueFindersCache(search_History);

		return search_History;
	}

	protected Search_History toUnwrappedModel(Search_History search_History) {
		if (search_History instanceof Search_HistoryImpl) {
			return search_History;
		}

		Search_HistoryImpl search_HistoryImpl = new Search_HistoryImpl();

		search_HistoryImpl.setNew(search_History.isNew());
		search_HistoryImpl.setPrimaryKey(search_History.getPrimaryKey());

		search_HistoryImpl.setSearchHistoryID(search_History.getSearchHistoryID());
		search_HistoryImpl.setUserID(search_History.getUserID());
		search_HistoryImpl.setQueryString(search_History.getQueryString());
		search_HistoryImpl.setLastModifiedDate(search_History.getLastModifiedDate());

		return search_HistoryImpl;
	}

	/**
	 * Returns the search_ history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search_ history
	 * @return the search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSearch_HistoryException, SystemException {
		Search_History search_History = fetchByPrimaryKey(primaryKey);

		if (search_History == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSearch_HistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return search_History;
	}

	/**
	 * Returns the search_ history with the primary key or throws a {@link org.gfbio.NoSuchSearch_HistoryException} if it could not be found.
	 *
	 * @param searchHistoryID the primary key of the search_ history
	 * @return the search_ history
	 * @throws org.gfbio.NoSuchSearch_HistoryException if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History findByPrimaryKey(long searchHistoryID)
		throws NoSuchSearch_HistoryException, SystemException {
		return findByPrimaryKey((Serializable)searchHistoryID);
	}

	/**
	 * Returns the search_ history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search_ history
	 * @return the search_ history, or <code>null</code> if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Search_History search_History = (Search_History)EntityCacheUtil.getResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
				Search_HistoryImpl.class, primaryKey);

		if (search_History == _nullSearch_History) {
			return null;
		}

		if (search_History == null) {
			Session session = null;

			try {
				session = openSession();

				search_History = (Search_History)session.get(Search_HistoryImpl.class,
						primaryKey);

				if (search_History != null) {
					cacheResult(search_History);
				}
				else {
					EntityCacheUtil.putResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
						Search_HistoryImpl.class, primaryKey,
						_nullSearch_History);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Search_HistoryModelImpl.ENTITY_CACHE_ENABLED,
					Search_HistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return search_History;
	}

	/**
	 * Returns the search_ history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchHistoryID the primary key of the search_ history
	 * @return the search_ history, or <code>null</code> if a search_ history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Search_History fetchByPrimaryKey(long searchHistoryID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)searchHistoryID);
	}

	/**
	 * Returns all the search_ histories.
	 *
	 * @return the search_ histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Search_History> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Search_History> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Search_History> findAll(int start, int end,
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

		List<Search_History> list = (List<Search_History>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCH_HISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCH_HISTORY;

				if (pagination) {
					sql = sql.concat(Search_HistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Search_History>(list);
				}
				else {
					list = (List<Search_History>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the search_ histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Search_History search_History : findAll()) {
			remove(search_History);
		}
	}

	/**
	 * Returns the number of search_ histories.
	 *
	 * @return the number of search_ histories
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

				Query q = session.createQuery(_SQL_COUNT_SEARCH_HISTORY);

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
	 * Initializes the search_ history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Search_History")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Search_History>> listenersList = new ArrayList<ModelListener<Search_History>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Search_History>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Search_HistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEARCH_HISTORY = "SELECT search_History FROM Search_History search_History";
	private static final String _SQL_SELECT_SEARCH_HISTORY_WHERE = "SELECT search_History FROM Search_History search_History WHERE ";
	private static final String _SQL_COUNT_SEARCH_HISTORY = "SELECT COUNT(search_History) FROM Search_History search_History";
	private static final String _SQL_COUNT_SEARCH_HISTORY_WHERE = "SELECT COUNT(search_History) FROM Search_History search_History WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "search_History.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Search_History exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Search_History exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Search_HistoryPersistenceImpl.class);
	private static Search_History _nullSearch_History = new Search_HistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Search_History> toCacheModel() {
				return _nullSearch_HistoryCacheModel;
			}
		};

	private static CacheModel<Search_History> _nullSearch_HistoryCacheModel = new CacheModel<Search_History>() {
			@Override
			public Search_History toEntityModel() {
				return _nullSearch_History;
			}
		};
}