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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchSearchFeedbackException;

import org.gfbio.model.SearchFeedback;
import org.gfbio.model.impl.SearchFeedbackImpl;
import org.gfbio.model.impl.SearchFeedbackModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the search feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Kobkaew Opasjumruskit
 * @see SearchFeedbackPersistence
 * @see SearchFeedbackUtil
 * @generated
 */
public class SearchFeedbackPersistenceImpl extends BasePersistenceImpl<SearchFeedback>
	implements SearchFeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SearchFeedbackUtil} to access the search feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SearchFeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySearchFeedbackID", new String[] { Long.class.getName() },
			SearchFeedbackModelImpl.SEARCHFEEDBACKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchFeedbackID", new String[] { Long.class.getName() });

	/**
	 * Returns the search feedback where searchFeedbackID = &#63; or throws a {@link org.gfbio.NoSuchSearchFeedbackException} if it could not be found.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findBySearchFeedbackID(long searchFeedbackID)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchBySearchFeedbackID(searchFeedbackID);

		if (searchFeedback == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("searchFeedbackID=");
			msg.append(searchFeedbackID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSearchFeedbackException(msg.toString());
		}

		return searchFeedback;
	}

	/**
	 * Returns the search feedback where searchFeedbackID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySearchFeedbackID(long searchFeedbackID)
		throws SystemException {
		return fetchBySearchFeedbackID(searchFeedbackID, true);
	}

	/**
	 * Returns the search feedback where searchFeedbackID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySearchFeedbackID(long searchFeedbackID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { searchFeedbackID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
					finderArgs, this);
		}

		if (result instanceof SearchFeedback) {
			SearchFeedback searchFeedback = (SearchFeedback)result;

			if ((searchFeedbackID != searchFeedback.getSearchFeedbackID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_SEARCHFEEDBACKID_SEARCHFEEDBACKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchFeedbackID);

				List<SearchFeedback> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SearchFeedbackPersistenceImpl.fetchBySearchFeedbackID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SearchFeedback searchFeedback = list.get(0);

					result = searchFeedback;

					cacheResult(searchFeedback);

					if ((searchFeedback.getSearchFeedbackID() != searchFeedbackID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
							finderArgs, searchFeedback);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
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
			return (SearchFeedback)result;
		}
	}

	/**
	 * Removes the search feedback where searchFeedbackID = &#63; from the database.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the search feedback that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback removeBySearchFeedbackID(long searchFeedbackID)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findBySearchFeedbackID(searchFeedbackID);

		return remove(searchFeedback);
	}

	/**
	 * Returns the number of search feedbacks where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchFeedbackID(long searchFeedbackID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID;

		Object[] finderArgs = new Object[] { searchFeedbackID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_SEARCHFEEDBACKID_SEARCHFEEDBACKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchFeedbackID);

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

	private static final String _FINDER_COLUMN_SEARCHFEEDBACKID_SEARCHFEEDBACKID_2 =
		"searchFeedback.searchFeedbackID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySearchFeedbackIDs",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySearchFeedbackIDs", new String[] { Long.class.getName() },
			SearchFeedbackModelImpl.SEARCHFEEDBACKID_COLUMN_BITMASK |
			SearchFeedbackModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEARCHFEEDBACKIDS = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySearchFeedbackIDs", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHFEEDBACKIDS =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySearchFeedbackIDs",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search feedbacks where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(long searchFeedbackID)
		throws SystemException {
		return findBySearchFeedbackIDs(searchFeedbackID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where searchFeedbackID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(long searchFeedbackID,
		int start, int end) throws SystemException {
		return findBySearchFeedbackIDs(searchFeedbackID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where searchFeedbackID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(long searchFeedbackID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS;
			finderArgs = new Object[] { searchFeedbackID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS;
			finderArgs = new Object[] {
					searchFeedbackID,
					
					start, end, orderByComparator
				};
		}

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((searchFeedbackID != searchFeedback.getSearchFeedbackID())) {
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchFeedbackID);

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findBySearchFeedbackIDs_First(long searchFeedbackID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchBySearchFeedbackIDs_First(searchFeedbackID,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchFeedbackID=");
		msg.append(searchFeedbackID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySearchFeedbackIDs_First(
		long searchFeedbackID, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchFeedback> list = findBySearchFeedbackIDs(searchFeedbackID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findBySearchFeedbackIDs_Last(long searchFeedbackID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchBySearchFeedbackIDs_Last(searchFeedbackID,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("searchFeedbackID=");
		msg.append(searchFeedbackID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySearchFeedbackIDs_Last(long searchFeedbackID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySearchFeedbackIDs(searchFeedbackID);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findBySearchFeedbackIDs(searchFeedbackID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the search feedbacks where searchFeedbackID = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchFeedbackIDs the search feedback i ds
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(
		long[] searchFeedbackIDs) throws SystemException {
		return findBySearchFeedbackIDs(searchFeedbackIDs, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where searchFeedbackID = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchFeedbackIDs the search feedback i ds
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(
		long[] searchFeedbackIDs, int start, int end) throws SystemException {
		return findBySearchFeedbackIDs(searchFeedbackIDs, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where searchFeedbackID = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param searchFeedbackIDs the search feedback i ds
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySearchFeedbackIDs(
		long[] searchFeedbackIDs, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((searchFeedbackIDs != null) && (searchFeedbackIDs.length == 1)) {
			return findBySearchFeedbackIDs(searchFeedbackIDs[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(searchFeedbackIDs) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(searchFeedbackIDs),
					
					start, end, orderByComparator
				};
		}

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if (!ArrayUtil.contains(searchFeedbackIDs,
							searchFeedback.getSearchFeedbackID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((searchFeedbackIDs == null) || (searchFeedbackIDs.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < searchFeedbackIDs.length; i++) {
					query.append(_FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_5);

					if ((i + 1) < searchFeedbackIDs.length) {
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
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (searchFeedbackIDs != null) {
					qPos.add(searchFeedbackIDs);
				}

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS,
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
	 * Removes all the search feedbacks where searchFeedbackID = &#63; from the database.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySearchFeedbackIDs(long searchFeedbackID)
		throws SystemException {
		for (SearchFeedback searchFeedback : findBySearchFeedbackIDs(
				searchFeedbackID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where searchFeedbackID = &#63;.
	 *
	 * @param searchFeedbackID the search feedback i d
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchFeedbackIDs(long searchFeedbackID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEARCHFEEDBACKIDS;

		Object[] finderArgs = new Object[] { searchFeedbackID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(searchFeedbackID);

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
	 * Returns the number of search feedbacks where searchFeedbackID = any &#63;.
	 *
	 * @param searchFeedbackIDs the search feedback i ds
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySearchFeedbackIDs(long[] searchFeedbackIDs)
		throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(searchFeedbackIDs) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHFEEDBACKIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((searchFeedbackIDs == null) || (searchFeedbackIDs.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < searchFeedbackIDs.length; i++) {
					query.append(_FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_5);

					if ((i + 1) < searchFeedbackIDs.length) {
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

				if (searchFeedbackIDs != null) {
					qPos.add(searchFeedbackIDs);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHFEEDBACKIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SEARCHFEEDBACKIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_2 =
		"searchFeedback.searchFeedbackID = ?";
	private static final String _FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_SEARCHFEEDBACKIDS_SEARCHFEEDBACKID_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			SearchFeedbackModelImpl.USERID_COLUMN_BITMASK |
			SearchFeedbackModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the search feedbacks where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserID(long userID, int start, int end,
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

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((userID != searchFeedback.getUserID())) {
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByUserID_First(userID,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchFeedback> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByUserID_Last(userID,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where userID = &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByUserID_PrevAndNext(long searchFeedbackID,
		long userID, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByUserID_PrevAndNext(session, searchFeedback, userID,
					orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByUserID_PrevAndNext(session, searchFeedback, userID,
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

	protected SearchFeedback getByUserID_PrevAndNext(Session session,
		SearchFeedback searchFeedback, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search feedbacks where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (SearchFeedback searchFeedback : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching search feedbacks
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

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "searchFeedback.userID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIDSince",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDSINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIDSince",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search feedbacks where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserIDSince(long userID,
		Date lastModifiedDate) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserIDSince(long userID,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByUserIDSince(userID, lastModifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByUserIDSince(long userID,
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

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((userID != searchFeedback.getUserID()) ||
						(lastModifiedDate.getTime() >= searchFeedback.getLastModifiedDate()
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByUserIDSince_First(userID,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByUserIDSince_First(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchFeedback> list = findByUserIDSince(userID, lastModifiedDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByUserIDSince_Last(userID,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByUserIDSince_Last(long userID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIDSince(userID, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByUserIDSince(userID, lastModifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByUserIDSince_PrevAndNext(
		long searchFeedbackID, long userID, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByUserIDSince_PrevAndNext(session, searchFeedback,
					userID, lastModifiedDate, orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByUserIDSince_PrevAndNext(session, searchFeedback,
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

	protected SearchFeedback getByUserIDSince_PrevAndNext(Session session,
		SearchFeedback searchFeedback, long userID, Date lastModifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search feedbacks where userID = &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIDSince(long userID, Date lastModifiedDate)
		throws SystemException {
		for (SearchFeedback searchFeedback : findByUserIDSince(userID,
				lastModifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where userID = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param userID the user i d
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search feedbacks
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

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_USERIDSINCE_USERID_2 = "searchFeedback.userID = ? AND ";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_1 = "searchFeedback.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_USERIDSINCE_LASTMODIFIEDDATE_2 = "searchFeedback.lastModifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRating",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRating",
			new String[] { Integer.class.getName() },
			SearchFeedbackModelImpl.RATING_COLUMN_BITMASK |
			SearchFeedbackModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATING = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRating",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATING = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRating",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the search feedbacks where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int rating)
		throws SystemException {
		return findByRating(rating, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where rating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rating the rating
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int rating, int start, int end)
		throws SystemException {
		return findByRating(rating, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where rating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rating the rating
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int rating, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING;
			finderArgs = new Object[] { rating };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING;
			finderArgs = new Object[] { rating, start, end, orderByComparator };
		}

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((rating != searchFeedback.getRating())) {
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_RATING_RATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByRating_First(int rating,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByRating_First(rating,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByRating_First(int rating,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchFeedback> list = findByRating(rating, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByRating_Last(int rating,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByRating_Last(rating,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where rating = &#63;.
	 *
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByRating_Last(int rating,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRating(rating);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByRating(rating, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where rating = &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByRating_PrevAndNext(long searchFeedbackID,
		int rating, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByRating_PrevAndNext(session, searchFeedback, rating,
					orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByRating_PrevAndNext(session, searchFeedback, rating,
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

	protected SearchFeedback getByRating_PrevAndNext(Session session,
		SearchFeedback searchFeedback, int rating,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_RATING_RATING_2);

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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rating);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search feedbacks where rating = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int[] ratings)
		throws SystemException {
		return findByRating(ratings, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where rating = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int[] ratings, int start, int end)
		throws SystemException {
		return findByRating(ratings, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where rating = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRating(int[] ratings, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((ratings != null) && (ratings.length == 1)) {
			return findByRating(ratings[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(ratings) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(ratings),
					
					start, end, orderByComparator
				};
		}

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if (!ArrayUtil.contains(ratings, searchFeedback.getRating())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((ratings == null) || (ratings.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < ratings.length; i++) {
					query.append(_FINDER_COLUMN_RATING_RATING_5);

					if ((i + 1) < ratings.length) {
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
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ratings != null) {
					qPos.add(ratings);
				}

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATING,
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
	 * Removes all the search feedbacks where rating = &#63; from the database.
	 *
	 * @param rating the rating
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRating(int rating) throws SystemException {
		for (SearchFeedback searchFeedback : findByRating(rating,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where rating = &#63;.
	 *
	 * @param rating the rating
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRating(int rating) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATING;

		Object[] finderArgs = new Object[] { rating };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_RATING_RATING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

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
	 * Returns the number of search feedbacks where rating = any &#63;.
	 *
	 * @param ratings the ratings
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRating(int[] ratings) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(ratings) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATING,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((ratings == null) || (ratings.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < ratings.length; i++) {
					query.append(_FINDER_COLUMN_RATING_RATING_5);

					if ((i + 1) < ratings.length) {
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

				if (ratings != null) {
					qPos.add(ratings);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATING,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATING,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RATING_RATING_2 = "searchFeedback.rating = ?";
	private static final String _FINDER_COLUMN_RATING_RATING_5 = "(" +
		removeConjunction(_FINDER_COLUMN_RATING_RATING_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGSINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRatingSince",
			new String[] {
				Integer.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATINGSINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByRatingSince",
			new String[] { Integer.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search feedbacks where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int rating,
		Date lastModifiedDate) throws SystemException {
		return findByRatingSince(rating, lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int rating,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByRatingSince(rating, lastModifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int rating,
		Date lastModifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGSINCE;
		finderArgs = new Object[] {
				rating, lastModifiedDate,
				
				start, end, orderByComparator
			};

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((rating != searchFeedback.getRating()) ||
						(lastModifiedDate.getTime() >= searchFeedback.getLastModifiedDate()
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_RATINGSINCE_RATING_2);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByRatingSince_First(int rating,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByRatingSince_First(rating,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByRatingSince_First(int rating,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchFeedback> list = findByRatingSince(rating, lastModifiedDate,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByRatingSince_Last(int rating,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByRatingSince_Last(rating,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rating=");
		msg.append(rating);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByRatingSince_Last(int rating,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByRatingSince(rating, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByRatingSince(rating, lastModifiedDate,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByRatingSince_PrevAndNext(
		long searchFeedbackID, int rating, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByRatingSince_PrevAndNext(session, searchFeedback,
					rating, lastModifiedDate, orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByRatingSince_PrevAndNext(session, searchFeedback,
					rating, lastModifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchFeedback getByRatingSince_PrevAndNext(Session session,
		SearchFeedback searchFeedback, int rating, Date lastModifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

		query.append(_FINDER_COLUMN_RATINGSINCE_RATING_2);

		boolean bindLastModifiedDate = false;

		if (lastModifiedDate == null) {
			query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_1);
		}
		else {
			bindLastModifiedDate = true;

			query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_2);
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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rating);

		if (bindLastModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the search feedbacks where rating = any &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @param lastModifiedDate the last modified date
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int[] ratings,
		Date lastModifiedDate) throws SystemException {
		return findByRatingSince(ratings, lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where rating = any &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int[] ratings,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByRatingSince(ratings, lastModifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where rating = any &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ratings the ratings
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByRatingSince(int[] ratings,
		Date lastModifiedDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((ratings != null) && (ratings.length == 1)) {
			return findByRatingSince(ratings[0], lastModifiedDate, start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(ratings), lastModifiedDate
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(ratings), lastModifiedDate,
					
					start, end, orderByComparator
				};
		}

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGSINCE,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if (!ArrayUtil.contains(ratings, searchFeedback.getRating()) ||
						!Validator.equals(lastModifiedDate,
							searchFeedback.getLastModifiedDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((ratings == null) || (ratings.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < ratings.length; i++) {
					query.append(_FINDER_COLUMN_RATINGSINCE_RATING_5);

					if ((i + 1) < ratings.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_4);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_5);
			}

			conjunctionable = true;

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ratings != null) {
					qPos.add(ratings);
				}

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGSINCE,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGSINCE,
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
	 * Removes all the search feedbacks where rating = &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRatingSince(int rating, Date lastModifiedDate)
		throws SystemException {
		for (SearchFeedback searchFeedback : findByRatingSince(rating,
				lastModifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where rating = &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param rating the rating
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRatingSince(int rating, Date lastModifiedDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATINGSINCE;

		Object[] finderArgs = new Object[] { rating, lastModifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			query.append(_FINDER_COLUMN_RATINGSINCE_RATING_2);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rating);

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

	/**
	 * Returns the number of search feedbacks where rating = any &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param ratings the ratings
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRatingSince(int[] ratings, Date lastModifiedDate)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(ratings), lastModifiedDate
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATINGSINCE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			boolean conjunctionable = false;

			if ((ratings == null) || (ratings.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < ratings.length; i++) {
					query.append(_FINDER_COLUMN_RATINGSINCE_RATING_5);

					if ((i + 1) < ratings.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_4);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_5);
			}

			conjunctionable = true;

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ratings != null) {
					qPos.add(ratings);
				}

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATINGSINCE,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_RATINGSINCE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RATINGSINCE_RATING_2 = "searchFeedback.rating = ? AND ";
	private static final String _FINDER_COLUMN_RATINGSINCE_RATING_5 = "(" +
		removeConjunction(_FINDER_COLUMN_RATINGSINCE_RATING_2) + ")";
	private static final String _FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_1 = "searchFeedback.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_2 = "searchFeedback.lastModifiedDate > ?";
	private static final String _FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_4 = "(" +
		removeConjunction(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_1) + ")";
	private static final String _FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_RATINGSINCE_LASTMODIFIEDDATE_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the search feedbacks where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessage(String queryString)
		throws SystemException {
		return findByQueryMessage(queryString, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where queryString LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queryString the query string
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessage(String queryString,
		int start, int end) throws SystemException {
		return findByQueryMessage(queryString, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where queryString LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queryString the query string
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessage(String queryString,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGE;
		finderArgs = new Object[] { queryString, start, end, orderByComparator };

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if (!StringUtil.wildcardMatches(
							searchFeedback.getQueryString(), queryString,
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByQueryMessage_First(queryString,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByQueryMessage_First(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchFeedback> list = findByQueryMessage(queryString, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByQueryMessage_Last(queryString,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByQueryMessage_Last(String queryString,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByQueryMessage(queryString);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByQueryMessage(queryString, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where queryString LIKE &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param queryString the query string
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByQueryMessage_PrevAndNext(
		long searchFeedbackID, String queryString,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByQueryMessage_PrevAndNext(session, searchFeedback,
					queryString, orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByQueryMessage_PrevAndNext(session, searchFeedback,
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

	protected SearchFeedback getByQueryMessage_PrevAndNext(Session session,
		SearchFeedback searchFeedback, String queryString,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search feedbacks where queryString LIKE &#63; from the database.
	 *
	 * @param queryString the query string
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessage(String queryString)
		throws SystemException {
		for (SearchFeedback searchFeedback : findByQueryMessage(queryString,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where queryString LIKE &#63;.
	 *
	 * @param queryString the query string
	 * @return the number of matching search feedbacks
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

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_1 = "searchFeedback.queryString LIKE NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_2 = "searchFeedback.queryString LIKE ?";
	private static final String _FINDER_COLUMN_QUERYMESSAGE_QUERYSTRING_3 = "(searchFeedback.queryString IS NULL OR searchFeedback.queryString LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUERYMESSAGESINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByQueryMessageSince",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_QUERYMESSAGESINCE =
		new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByQueryMessageSince",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns all the search feedbacks where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessageSince(String queryString,
		Date lastModifiedDate, int start, int end) throws SystemException {
		return findByQueryMessageSince(queryString, lastModifiedDate, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findByQueryMessageSince(String queryString,
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

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if (!StringUtil.wildcardMatches(
							searchFeedback.getQueryString(), queryString,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						(lastModifiedDate.getTime() >= searchFeedback.getLastModifiedDate()
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByQueryMessageSince_First(queryString,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByQueryMessageSince_First(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		List<SearchFeedback> list = findByQueryMessageSince(queryString,
				lastModifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByQueryMessageSince_Last(queryString,
				lastModifiedDate, orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queryString=");
		msg.append(queryString);

		msg.append(", lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByQueryMessageSince_Last(String queryString,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByQueryMessageSince(queryString, lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findByQueryMessageSince(queryString,
				lastModifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findByQueryMessageSince_PrevAndNext(
		long searchFeedbackID, String queryString, Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getByQueryMessageSince_PrevAndNext(session,
					searchFeedback, queryString, lastModifiedDate,
					orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getByQueryMessageSince_PrevAndNext(session,
					searchFeedback, queryString, lastModifiedDate,
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

	protected SearchFeedback getByQueryMessageSince_PrevAndNext(
		Session session, SearchFeedback searchFeedback, String queryString,
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

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search feedbacks where queryString LIKE &#63; and lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByQueryMessageSince(String queryString,
		Date lastModifiedDate) throws SystemException {
		for (SearchFeedback searchFeedback : findByQueryMessageSince(
				queryString, lastModifiedDate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where queryString LIKE &#63; and lastModifiedDate &gt; &#63;.
	 *
	 * @param queryString the query string
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search feedbacks
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

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_1 = "searchFeedback.queryString LIKE NULL AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_2 = "searchFeedback.queryString LIKE ? AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_QUERYSTRING_3 = "(searchFeedback.queryString IS NULL OR searchFeedback.queryString LIKE '') AND ";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_1 =
		"searchFeedback.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_QUERYMESSAGESINCE_LASTMODIFIEDDATE_2 =
		"searchFeedback.lastModifiedDate > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SINCE = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED,
			SearchFeedbackImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySince",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SINCE = new FinderPath(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySince",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the search feedbacks where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySince(Date lastModifiedDate)
		throws SystemException {
		return findBySince(lastModifiedDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks where lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySince(Date lastModifiedDate, int start,
		int end) throws SystemException {
		return findBySince(lastModifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks where lastModifiedDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastModifiedDate the last modified date
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findBySince(Date lastModifiedDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SINCE;
		finderArgs = new Object[] {
				lastModifiedDate,
				
				start, end, orderByComparator
			};

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SearchFeedback searchFeedback : list) {
				if ((lastModifiedDate.getTime() >= searchFeedback.getLastModifiedDate()
																	 .getTime())) {
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

			query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Returns the first search feedback in the ordered set where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findBySince_First(Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchBySince_First(lastModifiedDate,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first search feedback in the ordered set where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySince_First(Date lastModifiedDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<SearchFeedback> list = findBySince(lastModifiedDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last search feedback in the ordered set where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findBySince_Last(Date lastModifiedDate,
		OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchBySince_Last(lastModifiedDate,
				orderByComparator);

		if (searchFeedback != null) {
			return searchFeedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastModifiedDate=");
		msg.append(lastModifiedDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSearchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last search feedback in the ordered set where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching search feedback, or <code>null</code> if a matching search feedback could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchBySince_Last(Date lastModifiedDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySince(lastModifiedDate);

		if (count == 0) {
			return null;
		}

		List<SearchFeedback> list = findBySince(lastModifiedDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the search feedbacks before and after the current search feedback in the ordered set where lastModifiedDate &gt; &#63;.
	 *
	 * @param searchFeedbackID the primary key of the current search feedback
	 * @param lastModifiedDate the last modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback[] findBySince_PrevAndNext(long searchFeedbackID,
		Date lastModifiedDate, OrderByComparator orderByComparator)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = findByPrimaryKey(searchFeedbackID);

		Session session = null;

		try {
			session = openSession();

			SearchFeedback[] array = new SearchFeedbackImpl[3];

			array[0] = getBySince_PrevAndNext(session, searchFeedback,
					lastModifiedDate, orderByComparator, true);

			array[1] = searchFeedback;

			array[2] = getBySince_PrevAndNext(session, searchFeedback,
					lastModifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SearchFeedback getBySince_PrevAndNext(Session session,
		SearchFeedback searchFeedback, Date lastModifiedDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEARCHFEEDBACK_WHERE);

		boolean bindLastModifiedDate = false;

		if (lastModifiedDate == null) {
			query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_1);
		}
		else {
			bindLastModifiedDate = true;

			query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_2);
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
			query.append(SearchFeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastModifiedDate) {
			qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(searchFeedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SearchFeedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the search feedbacks where lastModifiedDate &gt; &#63; from the database.
	 *
	 * @param lastModifiedDate the last modified date
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySince(Date lastModifiedDate) throws SystemException {
		for (SearchFeedback searchFeedback : findBySince(lastModifiedDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks where lastModifiedDate &gt; &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySince(Date lastModifiedDate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_SINCE;

		Object[] finderArgs = new Object[] { lastModifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SEARCHFEEDBACK_WHERE);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_1 = "searchFeedback.lastModifiedDate > NULL";
	private static final String _FINDER_COLUMN_SINCE_LASTMODIFIEDDATE_2 = "searchFeedback.lastModifiedDate > ?";

	public SearchFeedbackPersistenceImpl() {
		setModelClass(SearchFeedback.class);
	}

	/**
	 * Caches the search feedback in the entity cache if it is enabled.
	 *
	 * @param searchFeedback the search feedback
	 */
	@Override
	public void cacheResult(SearchFeedback searchFeedback) {
		EntityCacheUtil.putResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackImpl.class, searchFeedback.getPrimaryKey(),
			searchFeedback);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
			new Object[] { searchFeedback.getSearchFeedbackID() },
			searchFeedback);

		searchFeedback.resetOriginalValues();
	}

	/**
	 * Caches the search feedbacks in the entity cache if it is enabled.
	 *
	 * @param searchFeedbacks the search feedbacks
	 */
	@Override
	public void cacheResult(List<SearchFeedback> searchFeedbacks) {
		for (SearchFeedback searchFeedback : searchFeedbacks) {
			if (EntityCacheUtil.getResult(
						SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						SearchFeedbackImpl.class, searchFeedback.getPrimaryKey()) == null) {
				cacheResult(searchFeedback);
			}
			else {
				searchFeedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all search feedbacks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SearchFeedbackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SearchFeedbackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the search feedback.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SearchFeedback searchFeedback) {
		EntityCacheUtil.removeResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackImpl.class, searchFeedback.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(searchFeedback);
	}

	@Override
	public void clearCache(List<SearchFeedback> searchFeedbacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SearchFeedback searchFeedback : searchFeedbacks) {
			EntityCacheUtil.removeResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				SearchFeedbackImpl.class, searchFeedback.getPrimaryKey());

			clearUniqueFindersCache(searchFeedback);
		}
	}

	protected void cacheUniqueFindersCache(SearchFeedback searchFeedback) {
		if (searchFeedback.isNew()) {
			Object[] args = new Object[] { searchFeedback.getSearchFeedbackID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
				args, searchFeedback);
		}
		else {
			SearchFeedbackModelImpl searchFeedbackModelImpl = (SearchFeedbackModelImpl)searchFeedback;

			if ((searchFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchFeedback.getSearchFeedbackID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
					args, searchFeedback);
			}
		}
	}

	protected void clearUniqueFindersCache(SearchFeedback searchFeedback) {
		SearchFeedbackModelImpl searchFeedbackModelImpl = (SearchFeedbackModelImpl)searchFeedback;

		Object[] args = new Object[] { searchFeedback.getSearchFeedbackID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID, args);

		if ((searchFeedbackModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID.getColumnBitmask()) != 0) {
			args = new Object[] {
					searchFeedbackModelImpl.getOriginalSearchFeedbackID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEARCHFEEDBACKID,
				args);
		}
	}

	/**
	 * Creates a new search feedback with the primary key. Does not add the search feedback to the database.
	 *
	 * @param searchFeedbackID the primary key for the new search feedback
	 * @return the new search feedback
	 */
	@Override
	public SearchFeedback create(long searchFeedbackID) {
		SearchFeedback searchFeedback = new SearchFeedbackImpl();

		searchFeedback.setNew(true);
		searchFeedback.setPrimaryKey(searchFeedbackID);

		return searchFeedback;
	}

	/**
	 * Removes the search feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchFeedbackID the primary key of the search feedback
	 * @return the search feedback that was removed
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback remove(long searchFeedbackID)
		throws NoSuchSearchFeedbackException, SystemException {
		return remove((Serializable)searchFeedbackID);
	}

	/**
	 * Removes the search feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the search feedback
	 * @return the search feedback that was removed
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback remove(Serializable primaryKey)
		throws NoSuchSearchFeedbackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SearchFeedback searchFeedback = (SearchFeedback)session.get(SearchFeedbackImpl.class,
					primaryKey);

			if (searchFeedback == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSearchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(searchFeedback);
		}
		catch (NoSuchSearchFeedbackException nsee) {
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
	protected SearchFeedback removeImpl(SearchFeedback searchFeedback)
		throws SystemException {
		searchFeedback = toUnwrappedModel(searchFeedback);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(searchFeedback)) {
				searchFeedback = (SearchFeedback)session.get(SearchFeedbackImpl.class,
						searchFeedback.getPrimaryKeyObj());
			}

			if (searchFeedback != null) {
				session.delete(searchFeedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (searchFeedback != null) {
			clearCache(searchFeedback);
		}

		return searchFeedback;
	}

	@Override
	public SearchFeedback updateImpl(
		org.gfbio.model.SearchFeedback searchFeedback)
		throws SystemException {
		searchFeedback = toUnwrappedModel(searchFeedback);

		boolean isNew = searchFeedback.isNew();

		SearchFeedbackModelImpl searchFeedbackModelImpl = (SearchFeedbackModelImpl)searchFeedback;

		Session session = null;

		try {
			session = openSession();

			if (searchFeedback.isNew()) {
				session.save(searchFeedback);

				searchFeedback.setNew(false);
			}
			else {
				session.merge(searchFeedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SearchFeedbackModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((searchFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchFeedbackModelImpl.getOriginalSearchFeedbackID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS,
					args);

				args = new Object[] {
						searchFeedbackModelImpl.getSearchFeedbackID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEARCHFEEDBACKIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEARCHFEEDBACKIDS,
					args);
			}

			if ((searchFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchFeedbackModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { searchFeedbackModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((searchFeedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						searchFeedbackModelImpl.getOriginalRating()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATING, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING,
					args);

				args = new Object[] { searchFeedbackModelImpl.getRating() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATING, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATING,
					args);
			}
		}

		EntityCacheUtil.putResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
			SearchFeedbackImpl.class, searchFeedback.getPrimaryKey(),
			searchFeedback);

		clearUniqueFindersCache(searchFeedback);
		cacheUniqueFindersCache(searchFeedback);

		return searchFeedback;
	}

	protected SearchFeedback toUnwrappedModel(SearchFeedback searchFeedback) {
		if (searchFeedback instanceof SearchFeedbackImpl) {
			return searchFeedback;
		}

		SearchFeedbackImpl searchFeedbackImpl = new SearchFeedbackImpl();

		searchFeedbackImpl.setNew(searchFeedback.isNew());
		searchFeedbackImpl.setPrimaryKey(searchFeedback.getPrimaryKey());

		searchFeedbackImpl.setSearchFeedbackID(searchFeedback.getSearchFeedbackID());
		searchFeedbackImpl.setUserID(searchFeedback.getUserID());
		searchFeedbackImpl.setQueryString(searchFeedback.getQueryString());
		searchFeedbackImpl.setQueryFilter(searchFeedback.getQueryFilter());
		searchFeedbackImpl.setDatasetDetail(searchFeedback.getDatasetDetail());
		searchFeedbackImpl.setDatasetRank(searchFeedback.getDatasetRank());
		searchFeedbackImpl.setRating(searchFeedback.getRating());
		searchFeedbackImpl.setLastModifiedDate(searchFeedback.getLastModifiedDate());

		return searchFeedbackImpl;
	}

	/**
	 * Returns the search feedback with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the search feedback
	 * @return the search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSearchFeedbackException, SystemException {
		SearchFeedback searchFeedback = fetchByPrimaryKey(primaryKey);

		if (searchFeedback == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSearchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return searchFeedback;
	}

	/**
	 * Returns the search feedback with the primary key or throws a {@link org.gfbio.NoSuchSearchFeedbackException} if it could not be found.
	 *
	 * @param searchFeedbackID the primary key of the search feedback
	 * @return the search feedback
	 * @throws org.gfbio.NoSuchSearchFeedbackException if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback findByPrimaryKey(long searchFeedbackID)
		throws NoSuchSearchFeedbackException, SystemException {
		return findByPrimaryKey((Serializable)searchFeedbackID);
	}

	/**
	 * Returns the search feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the search feedback
	 * @return the search feedback, or <code>null</code> if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SearchFeedback searchFeedback = (SearchFeedback)EntityCacheUtil.getResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
				SearchFeedbackImpl.class, primaryKey);

		if (searchFeedback == _nullSearchFeedback) {
			return null;
		}

		if (searchFeedback == null) {
			Session session = null;

			try {
				session = openSession();

				searchFeedback = (SearchFeedback)session.get(SearchFeedbackImpl.class,
						primaryKey);

				if (searchFeedback != null) {
					cacheResult(searchFeedback);
				}
				else {
					EntityCacheUtil.putResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
						SearchFeedbackImpl.class, primaryKey,
						_nullSearchFeedback);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SearchFeedbackModelImpl.ENTITY_CACHE_ENABLED,
					SearchFeedbackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return searchFeedback;
	}

	/**
	 * Returns the search feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param searchFeedbackID the primary key of the search feedback
	 * @return the search feedback, or <code>null</code> if a search feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchFeedback fetchByPrimaryKey(long searchFeedbackID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)searchFeedbackID);
	}

	/**
	 * Returns all the search feedbacks.
	 *
	 * @return the search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the search feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @return the range of search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the search feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SearchFeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search feedbacks
	 * @param end the upper bound of the range of search feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of search feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchFeedback> findAll(int start, int end,
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

		List<SearchFeedback> list = (List<SearchFeedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEARCHFEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEARCHFEEDBACK;

				if (pagination) {
					sql = sql.concat(SearchFeedbackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SearchFeedback>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SearchFeedback>(list);
				}
				else {
					list = (List<SearchFeedback>)QueryUtil.list(q,
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
	 * Removes all the search feedbacks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SearchFeedback searchFeedback : findAll()) {
			remove(searchFeedback);
		}
	}

	/**
	 * Returns the number of search feedbacks.
	 *
	 * @return the number of search feedbacks
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

				Query q = session.createQuery(_SQL_COUNT_SEARCHFEEDBACK);

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
	 * Initializes the search feedback persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.SearchFeedback")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SearchFeedback>> listenersList = new ArrayList<ModelListener<SearchFeedback>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SearchFeedback>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SearchFeedbackImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEARCHFEEDBACK = "SELECT searchFeedback FROM SearchFeedback searchFeedback";
	private static final String _SQL_SELECT_SEARCHFEEDBACK_WHERE = "SELECT searchFeedback FROM SearchFeedback searchFeedback WHERE ";
	private static final String _SQL_COUNT_SEARCHFEEDBACK = "SELECT COUNT(searchFeedback) FROM SearchFeedback searchFeedback";
	private static final String _SQL_COUNT_SEARCHFEEDBACK_WHERE = "SELECT COUNT(searchFeedback) FROM SearchFeedback searchFeedback WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "searchFeedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SearchFeedback exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SearchFeedback exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SearchFeedbackPersistenceImpl.class);
	private static SearchFeedback _nullSearchFeedback = new SearchFeedbackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SearchFeedback> toCacheModel() {
				return _nullSearchFeedbackCacheModel;
			}
		};

	private static CacheModel<SearchFeedback> _nullSearchFeedbackCacheModel = new CacheModel<SearchFeedback>() {
			@Override
			public SearchFeedback toEntityModel() {
				return _nullSearchFeedback;
			}
		};
}