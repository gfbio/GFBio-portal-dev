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

import org.gfbio.NoSuchHeadException;

import org.gfbio.model.Head;
import org.gfbio.model.impl.HeadImpl;
import org.gfbio.model.impl.HeadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see HeadPersistence
 * @see HeadUtil
 * @generated
 */
public class HeadPersistenceImpl extends BasePersistenceImpl<Head>
	implements HeadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HeadUtil} to access the head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HeadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_HEADID = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByHeadID",
			new String[] { Long.class.getName() },
			HeadModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the head where headID = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	 *
	 * @param headID the head i d
	 * @return the matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByHeadID(long headID)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByHeadID(headID);

		if (head == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("headID=");
			msg.append(headID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHeadException(msg.toString());
		}

		return head;
	}

	/**
	 * Returns the head where headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headID the head i d
	 * @return the matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByHeadID(long headID) throws SystemException {
		return fetchByHeadID(headID, true);
	}

	/**
	 * Returns the head where headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headID the head i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByHeadID(long headID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { headID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HEADID,
					finderArgs, this);
		}

		if (result instanceof Head) {
			Head head = (Head)result;

			if ((headID != head.getHeadID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HEAD_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				List<Head> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"HeadPersistenceImpl.fetchByHeadID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Head head = list.get(0);

					result = head;

					cacheResult(head);

					if ((head.getHeadID() != headID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADID,
							finderArgs, head);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADID,
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
			return (Head)result;
		}
	}

	/**
	 * Removes the head where headID = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @return the head that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head removeByHeadID(long headID)
		throws NoSuchHeadException, SystemException {
		Head head = findByHeadID(headID);

		return remove(head);
	}

	/**
	 * Returns the number of heads where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHeadID(long headID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HEADID;

		Object[] finderArgs = new Object[] { headID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 = "head.headID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the head where name = &#63; or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByName(String name)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByName(name);

		if (head == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHeadException(msg.toString());
		}

		return head;
	}

	/**
	 * Returns the head where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the head where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Head) {
			Head head = (Head)result;

			if (!Validator.equals(name, head.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Head> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"HeadPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Head head = list.get(0);

					result = head;

					cacheResult(head);

					if ((head.getName() == null) ||
							!head.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, head);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (Head)result;
		}
	}

	/**
	 * Removes the head where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the head that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head removeByName(String name)
		throws NoSuchHeadException, SystemException {
		Head head = findByName(name);

		return remove(head);
	}

	/**
	 * Returns the number of heads where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "head.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "head.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(head.name IS NULL OR head.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TASK = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTask",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTask",
			new String[] { String.class.getName() },
			HeadModelImpl.TASK_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASK = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTask",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where task = &#63;.
	 *
	 * @param task the task
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByTask(String task) throws SystemException {
		return findByTask(task, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Head> findByTask(String task, int start, int end)
		throws SystemException {
		return findByTask(task, start, end, null);
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
	@Override
	public List<Head> findByTask(String task, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK;
			finderArgs = new Object[] { task };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TASK;
			finderArgs = new Object[] { task, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(task, head.getTask())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindTask = false;

			if (task == null) {
				query.append(_FINDER_COLUMN_TASK_TASK_1);
			}
			else if (task.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TASK_TASK_3);
			}
			else {
				bindTask = true;

				query.append(_FINDER_COLUMN_TASK_TASK_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTask) {
					qPos.add(task);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByTask_First(String task,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByTask_First(task, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("task=");
		msg.append(task);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByTask_First(String task,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByTask(task, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByTask_Last(String task, OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByTask_Last(task, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("task=");
		msg.append(task);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByTask_Last(String task,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTask(task);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByTask(task, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByTask_PrevAndNext(long headID, String task,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByTask_PrevAndNext(session, head, task,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByTask_PrevAndNext(session, head, task,
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

	protected Head getByTask_PrevAndNext(Session session, Head head,
		String task, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindTask = false;

		if (task == null) {
			query.append(_FINDER_COLUMN_TASK_TASK_1);
		}
		else if (task.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TASK_TASK_3);
		}
		else {
			bindTask = true;

			query.append(_FINDER_COLUMN_TASK_TASK_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTask) {
			qPos.add(task);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where task = &#63; from the database.
	 *
	 * @param task the task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTask(String task) throws SystemException {
		for (Head head : findByTask(task, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where task = &#63;.
	 *
	 * @param task the task
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTask(String task) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TASK;

		Object[] finderArgs = new Object[] { task };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindTask = false;

			if (task == null) {
				query.append(_FINDER_COLUMN_TASK_TASK_1);
			}
			else if (task.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TASK_TASK_3);
			}
			else {
				bindTask = true;

				query.append(_FINDER_COLUMN_TASK_TASK_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTask) {
					qPos.add(task);
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

	private static final String _FINDER_COLUMN_TASK_TASK_1 = "head.task IS NULL";
	private static final String _FINDER_COLUMN_TASK_TASK_2 = "head.task = ?";
	private static final String _FINDER_COLUMN_TASK_TASK_3 = "(head.task IS NULL OR head.task = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN01 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn01",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn01",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN01_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN01 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn01",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn01(String column01) throws SystemException {
		return findByColumn01(column01, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn01(String column01, int start, int end)
		throws SystemException {
		return findByColumn01(column01, start, end, null);
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
	@Override
	public List<Head> findByColumn01(String column01, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01;
			finderArgs = new Object[] { column01 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN01;
			finderArgs = new Object[] { column01, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column01, head.getColumn01())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn01 = false;

			if (column01 == null) {
				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_1);
			}
			else if (column01.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_3);
			}
			else {
				bindColumn01 = true;

				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn01) {
					qPos.add(column01);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn01_First(String column01,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn01_First(column01, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column01=");
		msg.append(column01);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn01_First(String column01,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn01(column01, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn01_Last(String column01,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn01_Last(column01, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column01=");
		msg.append(column01);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn01_Last(String column01,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn01(column01);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn01(column01, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn01_PrevAndNext(long headID, String column01,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn01_PrevAndNext(session, head, column01,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn01_PrevAndNext(session, head, column01,
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

	protected Head getByColumn01_PrevAndNext(Session session, Head head,
		String column01, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn01 = false;

		if (column01 == null) {
			query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_1);
		}
		else if (column01.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_3);
		}
		else {
			bindColumn01 = true;

			query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn01) {
			qPos.add(column01);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column01 = &#63; from the database.
	 *
	 * @param column01 the column01
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn01(String column01) throws SystemException {
		for (Head head : findByColumn01(column01, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn01(String column01) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN01;

		Object[] finderArgs = new Object[] { column01 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn01 = false;

			if (column01 == null) {
				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_1);
			}
			else if (column01.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_3);
			}
			else {
				bindColumn01 = true;

				query.append(_FINDER_COLUMN_COLUMN01_COLUMN01_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn01) {
					qPos.add(column01);
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

	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_1 = "head.column01 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_2 = "head.column01 = ?";
	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_3 = "(head.column01 IS NULL OR head.column01 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN02 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn02",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn02",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN02_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN02 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn02",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn02(String column02) throws SystemException {
		return findByColumn02(column02, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn02(String column02, int start, int end)
		throws SystemException {
		return findByColumn02(column02, start, end, null);
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
	@Override
	public List<Head> findByColumn02(String column02, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02;
			finderArgs = new Object[] { column02 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN02;
			finderArgs = new Object[] { column02, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column02, head.getColumn02())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn02 = false;

			if (column02 == null) {
				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_1);
			}
			else if (column02.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_3);
			}
			else {
				bindColumn02 = true;

				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn02) {
					qPos.add(column02);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn02_First(String column02,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn02_First(column02, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column02=");
		msg.append(column02);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn02_First(String column02,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn02(column02, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn02_Last(String column02,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn02_Last(column02, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column02=");
		msg.append(column02);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn02_Last(String column02,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn02(column02);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn02(column02, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn02_PrevAndNext(long headID, String column02,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn02_PrevAndNext(session, head, column02,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn02_PrevAndNext(session, head, column02,
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

	protected Head getByColumn02_PrevAndNext(Session session, Head head,
		String column02, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn02 = false;

		if (column02 == null) {
			query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_1);
		}
		else if (column02.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_3);
		}
		else {
			bindColumn02 = true;

			query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn02) {
			qPos.add(column02);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column02 = &#63; from the database.
	 *
	 * @param column02 the column02
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn02(String column02) throws SystemException {
		for (Head head : findByColumn02(column02, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn02(String column02) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN02;

		Object[] finderArgs = new Object[] { column02 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn02 = false;

			if (column02 == null) {
				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_1);
			}
			else if (column02.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_3);
			}
			else {
				bindColumn02 = true;

				query.append(_FINDER_COLUMN_COLUMN02_COLUMN02_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn02) {
					qPos.add(column02);
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

	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_1 = "head.column02 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_2 = "head.column02 = ?";
	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_3 = "(head.column02 IS NULL OR head.column02 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN03 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn03",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn03",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN03_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN03 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn03",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn03(String column03) throws SystemException {
		return findByColumn03(column03, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn03(String column03, int start, int end)
		throws SystemException {
		return findByColumn03(column03, start, end, null);
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
	@Override
	public List<Head> findByColumn03(String column03, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03;
			finderArgs = new Object[] { column03 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN03;
			finderArgs = new Object[] { column03, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column03, head.getColumn03())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn03 = false;

			if (column03 == null) {
				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_1);
			}
			else if (column03.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_3);
			}
			else {
				bindColumn03 = true;

				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn03) {
					qPos.add(column03);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn03_First(String column03,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn03_First(column03, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column03=");
		msg.append(column03);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn03_First(String column03,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn03(column03, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn03_Last(String column03,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn03_Last(column03, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column03=");
		msg.append(column03);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn03_Last(String column03,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn03(column03);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn03(column03, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn03_PrevAndNext(long headID, String column03,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn03_PrevAndNext(session, head, column03,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn03_PrevAndNext(session, head, column03,
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

	protected Head getByColumn03_PrevAndNext(Session session, Head head,
		String column03, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn03 = false;

		if (column03 == null) {
			query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_1);
		}
		else if (column03.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_3);
		}
		else {
			bindColumn03 = true;

			query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn03) {
			qPos.add(column03);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column03 = &#63; from the database.
	 *
	 * @param column03 the column03
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn03(String column03) throws SystemException {
		for (Head head : findByColumn03(column03, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn03(String column03) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN03;

		Object[] finderArgs = new Object[] { column03 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn03 = false;

			if (column03 == null) {
				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_1);
			}
			else if (column03.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_3);
			}
			else {
				bindColumn03 = true;

				query.append(_FINDER_COLUMN_COLUMN03_COLUMN03_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn03) {
					qPos.add(column03);
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

	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_1 = "head.column03 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_2 = "head.column03 = ?";
	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_3 = "(head.column03 IS NULL OR head.column03 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN04 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn04",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn04",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN04_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN04 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn04",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn04(String column04) throws SystemException {
		return findByColumn04(column04, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn04(String column04, int start, int end)
		throws SystemException {
		return findByColumn04(column04, start, end, null);
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
	@Override
	public List<Head> findByColumn04(String column04, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04;
			finderArgs = new Object[] { column04 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN04;
			finderArgs = new Object[] { column04, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column04, head.getColumn04())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn04 = false;

			if (column04 == null) {
				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_1);
			}
			else if (column04.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_3);
			}
			else {
				bindColumn04 = true;

				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn04) {
					qPos.add(column04);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn04_First(String column04,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn04_First(column04, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column04=");
		msg.append(column04);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn04_First(String column04,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn04(column04, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn04_Last(String column04,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn04_Last(column04, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column04=");
		msg.append(column04);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn04_Last(String column04,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn04(column04);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn04(column04, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn04_PrevAndNext(long headID, String column04,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn04_PrevAndNext(session, head, column04,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn04_PrevAndNext(session, head, column04,
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

	protected Head getByColumn04_PrevAndNext(Session session, Head head,
		String column04, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn04 = false;

		if (column04 == null) {
			query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_1);
		}
		else if (column04.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_3);
		}
		else {
			bindColumn04 = true;

			query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn04) {
			qPos.add(column04);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column04 = &#63; from the database.
	 *
	 * @param column04 the column04
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn04(String column04) throws SystemException {
		for (Head head : findByColumn04(column04, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn04(String column04) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN04;

		Object[] finderArgs = new Object[] { column04 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn04 = false;

			if (column04 == null) {
				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_1);
			}
			else if (column04.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_3);
			}
			else {
				bindColumn04 = true;

				query.append(_FINDER_COLUMN_COLUMN04_COLUMN04_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn04) {
					qPos.add(column04);
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

	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_1 = "head.column04 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_2 = "head.column04 = ?";
	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_3 = "(head.column04 IS NULL OR head.column04 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN05 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn05",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn05",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN05_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN05 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn05",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn05(String column05) throws SystemException {
		return findByColumn05(column05, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn05(String column05, int start, int end)
		throws SystemException {
		return findByColumn05(column05, start, end, null);
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
	@Override
	public List<Head> findByColumn05(String column05, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05;
			finderArgs = new Object[] { column05 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN05;
			finderArgs = new Object[] { column05, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column05, head.getColumn05())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn05 = false;

			if (column05 == null) {
				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_1);
			}
			else if (column05.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_3);
			}
			else {
				bindColumn05 = true;

				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn05) {
					qPos.add(column05);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn05_First(String column05,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn05_First(column05, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column05=");
		msg.append(column05);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn05_First(String column05,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn05(column05, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn05_Last(String column05,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn05_Last(column05, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column05=");
		msg.append(column05);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn05_Last(String column05,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn05(column05);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn05(column05, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn05_PrevAndNext(long headID, String column05,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn05_PrevAndNext(session, head, column05,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn05_PrevAndNext(session, head, column05,
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

	protected Head getByColumn05_PrevAndNext(Session session, Head head,
		String column05, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn05 = false;

		if (column05 == null) {
			query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_1);
		}
		else if (column05.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_3);
		}
		else {
			bindColumn05 = true;

			query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn05) {
			qPos.add(column05);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column05 = &#63; from the database.
	 *
	 * @param column05 the column05
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn05(String column05) throws SystemException {
		for (Head head : findByColumn05(column05, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn05(String column05) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN05;

		Object[] finderArgs = new Object[] { column05 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn05 = false;

			if (column05 == null) {
				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_1);
			}
			else if (column05.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_3);
			}
			else {
				bindColumn05 = true;

				query.append(_FINDER_COLUMN_COLUMN05_COLUMN05_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn05) {
					qPos.add(column05);
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

	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_1 = "head.column05 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_2 = "head.column05 = ?";
	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_3 = "(head.column05 IS NULL OR head.column05 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN06 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn06",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn06",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN06_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN06 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn06",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn06(String column06) throws SystemException {
		return findByColumn06(column06, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn06(String column06, int start, int end)
		throws SystemException {
		return findByColumn06(column06, start, end, null);
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
	@Override
	public List<Head> findByColumn06(String column06, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06;
			finderArgs = new Object[] { column06 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN06;
			finderArgs = new Object[] { column06, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column06, head.getColumn06())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn06 = false;

			if (column06 == null) {
				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_1);
			}
			else if (column06.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_3);
			}
			else {
				bindColumn06 = true;

				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn06) {
					qPos.add(column06);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn06_First(String column06,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn06_First(column06, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column06=");
		msg.append(column06);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn06_First(String column06,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn06(column06, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn06_Last(String column06,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn06_Last(column06, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column06=");
		msg.append(column06);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn06_Last(String column06,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn06(column06);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn06(column06, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn06_PrevAndNext(long headID, String column06,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn06_PrevAndNext(session, head, column06,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn06_PrevAndNext(session, head, column06,
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

	protected Head getByColumn06_PrevAndNext(Session session, Head head,
		String column06, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn06 = false;

		if (column06 == null) {
			query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_1);
		}
		else if (column06.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_3);
		}
		else {
			bindColumn06 = true;

			query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn06) {
			qPos.add(column06);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column06 = &#63; from the database.
	 *
	 * @param column06 the column06
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn06(String column06) throws SystemException {
		for (Head head : findByColumn06(column06, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn06(String column06) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN06;

		Object[] finderArgs = new Object[] { column06 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn06 = false;

			if (column06 == null) {
				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_1);
			}
			else if (column06.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_3);
			}
			else {
				bindColumn06 = true;

				query.append(_FINDER_COLUMN_COLUMN06_COLUMN06_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn06) {
					qPos.add(column06);
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

	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_1 = "head.column06 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_2 = "head.column06 = ?";
	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_3 = "(head.column06 IS NULL OR head.column06 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN07 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn07",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn07",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN07_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN07 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn07",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn07(String column07) throws SystemException {
		return findByColumn07(column07, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn07(String column07, int start, int end)
		throws SystemException {
		return findByColumn07(column07, start, end, null);
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
	@Override
	public List<Head> findByColumn07(String column07, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07;
			finderArgs = new Object[] { column07 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN07;
			finderArgs = new Object[] { column07, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column07, head.getColumn07())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn07 = false;

			if (column07 == null) {
				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_1);
			}
			else if (column07.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_3);
			}
			else {
				bindColumn07 = true;

				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn07) {
					qPos.add(column07);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn07_First(String column07,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn07_First(column07, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column07=");
		msg.append(column07);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn07_First(String column07,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn07(column07, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn07_Last(String column07,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn07_Last(column07, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column07=");
		msg.append(column07);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn07_Last(String column07,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn07(column07);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn07(column07, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn07_PrevAndNext(long headID, String column07,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn07_PrevAndNext(session, head, column07,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn07_PrevAndNext(session, head, column07,
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

	protected Head getByColumn07_PrevAndNext(Session session, Head head,
		String column07, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn07 = false;

		if (column07 == null) {
			query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_1);
		}
		else if (column07.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_3);
		}
		else {
			bindColumn07 = true;

			query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn07) {
			qPos.add(column07);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column07 = &#63; from the database.
	 *
	 * @param column07 the column07
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn07(String column07) throws SystemException {
		for (Head head : findByColumn07(column07, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn07(String column07) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN07;

		Object[] finderArgs = new Object[] { column07 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn07 = false;

			if (column07 == null) {
				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_1);
			}
			else if (column07.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_3);
			}
			else {
				bindColumn07 = true;

				query.append(_FINDER_COLUMN_COLUMN07_COLUMN07_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn07) {
					qPos.add(column07);
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

	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_1 = "head.column07 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_2 = "head.column07 = ?";
	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_3 = "(head.column07 IS NULL OR head.column07 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN08 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn08",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn08",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN08_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN08 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn08",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn08(String column08) throws SystemException {
		return findByColumn08(column08, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn08(String column08, int start, int end)
		throws SystemException {
		return findByColumn08(column08, start, end, null);
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
	@Override
	public List<Head> findByColumn08(String column08, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08;
			finderArgs = new Object[] { column08 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN08;
			finderArgs = new Object[] { column08, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column08, head.getColumn08())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn08 = false;

			if (column08 == null) {
				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_1);
			}
			else if (column08.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_3);
			}
			else {
				bindColumn08 = true;

				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn08) {
					qPos.add(column08);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn08_First(String column08,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn08_First(column08, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column08=");
		msg.append(column08);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn08_First(String column08,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn08(column08, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn08_Last(String column08,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn08_Last(column08, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column08=");
		msg.append(column08);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn08_Last(String column08,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn08(column08);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn08(column08, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn08_PrevAndNext(long headID, String column08,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn08_PrevAndNext(session, head, column08,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn08_PrevAndNext(session, head, column08,
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

	protected Head getByColumn08_PrevAndNext(Session session, Head head,
		String column08, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn08 = false;

		if (column08 == null) {
			query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_1);
		}
		else if (column08.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_3);
		}
		else {
			bindColumn08 = true;

			query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn08) {
			qPos.add(column08);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column08 = &#63; from the database.
	 *
	 * @param column08 the column08
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn08(String column08) throws SystemException {
		for (Head head : findByColumn08(column08, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn08(String column08) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN08;

		Object[] finderArgs = new Object[] { column08 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn08 = false;

			if (column08 == null) {
				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_1);
			}
			else if (column08.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_3);
			}
			else {
				bindColumn08 = true;

				query.append(_FINDER_COLUMN_COLUMN08_COLUMN08_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn08) {
					qPos.add(column08);
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

	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_1 = "head.column08 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_2 = "head.column08 = ?";
	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_3 = "(head.column08 IS NULL OR head.column08 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN09 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn09",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn09",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN09_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN09 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn09",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn09(String column09) throws SystemException {
		return findByColumn09(column09, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn09(String column09, int start, int end)
		throws SystemException {
		return findByColumn09(column09, start, end, null);
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
	@Override
	public List<Head> findByColumn09(String column09, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09;
			finderArgs = new Object[] { column09 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN09;
			finderArgs = new Object[] { column09, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column09, head.getColumn09())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn09 = false;

			if (column09 == null) {
				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_1);
			}
			else if (column09.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_3);
			}
			else {
				bindColumn09 = true;

				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn09) {
					qPos.add(column09);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn09_First(String column09,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn09_First(column09, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column09=");
		msg.append(column09);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn09_First(String column09,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn09(column09, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn09_Last(String column09,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn09_Last(column09, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column09=");
		msg.append(column09);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn09_Last(String column09,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn09(column09);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn09(column09, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn09_PrevAndNext(long headID, String column09,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn09_PrevAndNext(session, head, column09,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn09_PrevAndNext(session, head, column09,
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

	protected Head getByColumn09_PrevAndNext(Session session, Head head,
		String column09, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn09 = false;

		if (column09 == null) {
			query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_1);
		}
		else if (column09.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_3);
		}
		else {
			bindColumn09 = true;

			query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn09) {
			qPos.add(column09);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column09 = &#63; from the database.
	 *
	 * @param column09 the column09
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn09(String column09) throws SystemException {
		for (Head head : findByColumn09(column09, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn09(String column09) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN09;

		Object[] finderArgs = new Object[] { column09 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn09 = false;

			if (column09 == null) {
				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_1);
			}
			else if (column09.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_3);
			}
			else {
				bindColumn09 = true;

				query.append(_FINDER_COLUMN_COLUMN09_COLUMN09_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn09) {
					qPos.add(column09);
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

	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_1 = "head.column09 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_2 = "head.column09 = ?";
	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_3 = "(head.column09 IS NULL OR head.column09 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN10 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn10",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn10",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN10_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN10 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn10",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn10(String column10) throws SystemException {
		return findByColumn10(column10, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn10(String column10, int start, int end)
		throws SystemException {
		return findByColumn10(column10, start, end, null);
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
	@Override
	public List<Head> findByColumn10(String column10, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10;
			finderArgs = new Object[] { column10 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN10;
			finderArgs = new Object[] { column10, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column10, head.getColumn10())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn10 = false;

			if (column10 == null) {
				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_1);
			}
			else if (column10.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_3);
			}
			else {
				bindColumn10 = true;

				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn10) {
					qPos.add(column10);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn10_First(String column10,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn10_First(column10, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column10=");
		msg.append(column10);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn10_First(String column10,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn10(column10, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn10_Last(String column10,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn10_Last(column10, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column10=");
		msg.append(column10);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn10_Last(String column10,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn10(column10);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn10(column10, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn10_PrevAndNext(long headID, String column10,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn10_PrevAndNext(session, head, column10,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn10_PrevAndNext(session, head, column10,
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

	protected Head getByColumn10_PrevAndNext(Session session, Head head,
		String column10, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn10 = false;

		if (column10 == null) {
			query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_1);
		}
		else if (column10.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_3);
		}
		else {
			bindColumn10 = true;

			query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn10) {
			qPos.add(column10);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column10 = &#63; from the database.
	 *
	 * @param column10 the column10
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn10(String column10) throws SystemException {
		for (Head head : findByColumn10(column10, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn10(String column10) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN10;

		Object[] finderArgs = new Object[] { column10 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn10 = false;

			if (column10 == null) {
				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_1);
			}
			else if (column10.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_3);
			}
			else {
				bindColumn10 = true;

				query.append(_FINDER_COLUMN_COLUMN10_COLUMN10_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn10) {
					qPos.add(column10);
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

	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_1 = "head.column10 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_2 = "head.column10 = ?";
	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_3 = "(head.column10 IS NULL OR head.column10 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN11 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn11",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn11",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN11_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN11 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn11",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn11(String column11) throws SystemException {
		return findByColumn11(column11, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn11(String column11, int start, int end)
		throws SystemException {
		return findByColumn11(column11, start, end, null);
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
	@Override
	public List<Head> findByColumn11(String column11, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11;
			finderArgs = new Object[] { column11 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN11;
			finderArgs = new Object[] { column11, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column11, head.getColumn11())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn11 = false;

			if (column11 == null) {
				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_1);
			}
			else if (column11.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_3);
			}
			else {
				bindColumn11 = true;

				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn11) {
					qPos.add(column11);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn11_First(String column11,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn11_First(column11, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column11=");
		msg.append(column11);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn11_First(String column11,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn11(column11, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn11_Last(String column11,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn11_Last(column11, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column11=");
		msg.append(column11);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn11_Last(String column11,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn11(column11);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn11(column11, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn11_PrevAndNext(long headID, String column11,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn11_PrevAndNext(session, head, column11,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn11_PrevAndNext(session, head, column11,
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

	protected Head getByColumn11_PrevAndNext(Session session, Head head,
		String column11, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn11 = false;

		if (column11 == null) {
			query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_1);
		}
		else if (column11.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_3);
		}
		else {
			bindColumn11 = true;

			query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn11) {
			qPos.add(column11);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column11 = &#63; from the database.
	 *
	 * @param column11 the column11
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn11(String column11) throws SystemException {
		for (Head head : findByColumn11(column11, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn11(String column11) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN11;

		Object[] finderArgs = new Object[] { column11 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn11 = false;

			if (column11 == null) {
				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_1);
			}
			else if (column11.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_3);
			}
			else {
				bindColumn11 = true;

				query.append(_FINDER_COLUMN_COLUMN11_COLUMN11_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn11) {
					qPos.add(column11);
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

	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_1 = "head.column11 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_2 = "head.column11 = ?";
	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_3 = "(head.column11 IS NULL OR head.column11 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN12 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn12",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn12",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN12_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN12 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn12",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn12(String column12) throws SystemException {
		return findByColumn12(column12, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn12(String column12, int start, int end)
		throws SystemException {
		return findByColumn12(column12, start, end, null);
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
	@Override
	public List<Head> findByColumn12(String column12, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12;
			finderArgs = new Object[] { column12 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN12;
			finderArgs = new Object[] { column12, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column12, head.getColumn12())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn12 = false;

			if (column12 == null) {
				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_1);
			}
			else if (column12.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_3);
			}
			else {
				bindColumn12 = true;

				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn12) {
					qPos.add(column12);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn12_First(String column12,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn12_First(column12, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column12=");
		msg.append(column12);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn12_First(String column12,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn12(column12, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn12_Last(String column12,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn12_Last(column12, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column12=");
		msg.append(column12);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn12_Last(String column12,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn12(column12);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn12(column12, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn12_PrevAndNext(long headID, String column12,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn12_PrevAndNext(session, head, column12,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn12_PrevAndNext(session, head, column12,
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

	protected Head getByColumn12_PrevAndNext(Session session, Head head,
		String column12, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn12 = false;

		if (column12 == null) {
			query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_1);
		}
		else if (column12.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_3);
		}
		else {
			bindColumn12 = true;

			query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn12) {
			qPos.add(column12);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column12 = &#63; from the database.
	 *
	 * @param column12 the column12
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn12(String column12) throws SystemException {
		for (Head head : findByColumn12(column12, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn12(String column12) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN12;

		Object[] finderArgs = new Object[] { column12 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn12 = false;

			if (column12 == null) {
				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_1);
			}
			else if (column12.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_3);
			}
			else {
				bindColumn12 = true;

				query.append(_FINDER_COLUMN_COLUMN12_COLUMN12_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn12) {
					qPos.add(column12);
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

	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_1 = "head.column12 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_2 = "head.column12 = ?";
	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_3 = "(head.column12 IS NULL OR head.column12 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN13 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn13",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn13",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN13_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN13 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn13",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn13(String column13) throws SystemException {
		return findByColumn13(column13, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn13(String column13, int start, int end)
		throws SystemException {
		return findByColumn13(column13, start, end, null);
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
	@Override
	public List<Head> findByColumn13(String column13, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13;
			finderArgs = new Object[] { column13 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN13;
			finderArgs = new Object[] { column13, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column13, head.getColumn13())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn13 = false;

			if (column13 == null) {
				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_1);
			}
			else if (column13.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_3);
			}
			else {
				bindColumn13 = true;

				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn13) {
					qPos.add(column13);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn13_First(String column13,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn13_First(column13, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column13=");
		msg.append(column13);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn13_First(String column13,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn13(column13, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn13_Last(String column13,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn13_Last(column13, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column13=");
		msg.append(column13);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn13_Last(String column13,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn13(column13);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn13(column13, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn13_PrevAndNext(long headID, String column13,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn13_PrevAndNext(session, head, column13,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn13_PrevAndNext(session, head, column13,
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

	protected Head getByColumn13_PrevAndNext(Session session, Head head,
		String column13, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn13 = false;

		if (column13 == null) {
			query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_1);
		}
		else if (column13.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_3);
		}
		else {
			bindColumn13 = true;

			query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn13) {
			qPos.add(column13);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column13 = &#63; from the database.
	 *
	 * @param column13 the column13
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn13(String column13) throws SystemException {
		for (Head head : findByColumn13(column13, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn13(String column13) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN13;

		Object[] finderArgs = new Object[] { column13 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn13 = false;

			if (column13 == null) {
				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_1);
			}
			else if (column13.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_3);
			}
			else {
				bindColumn13 = true;

				query.append(_FINDER_COLUMN_COLUMN13_COLUMN13_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn13) {
					qPos.add(column13);
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

	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_1 = "head.column13 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_2 = "head.column13 = ?";
	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_3 = "(head.column13 IS NULL OR head.column13 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN14 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn14",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn14",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN14_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN14 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn14",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn14(String column14) throws SystemException {
		return findByColumn14(column14, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn14(String column14, int start, int end)
		throws SystemException {
		return findByColumn14(column14, start, end, null);
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
	@Override
	public List<Head> findByColumn14(String column14, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14;
			finderArgs = new Object[] { column14 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN14;
			finderArgs = new Object[] { column14, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column14, head.getColumn14())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn14 = false;

			if (column14 == null) {
				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_1);
			}
			else if (column14.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_3);
			}
			else {
				bindColumn14 = true;

				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn14) {
					qPos.add(column14);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn14_First(String column14,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn14_First(column14, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column14=");
		msg.append(column14);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn14_First(String column14,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn14(column14, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn14_Last(String column14,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn14_Last(column14, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column14=");
		msg.append(column14);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn14_Last(String column14,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn14(column14);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn14(column14, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn14_PrevAndNext(long headID, String column14,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn14_PrevAndNext(session, head, column14,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn14_PrevAndNext(session, head, column14,
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

	protected Head getByColumn14_PrevAndNext(Session session, Head head,
		String column14, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn14 = false;

		if (column14 == null) {
			query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_1);
		}
		else if (column14.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_3);
		}
		else {
			bindColumn14 = true;

			query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn14) {
			qPos.add(column14);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column14 = &#63; from the database.
	 *
	 * @param column14 the column14
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn14(String column14) throws SystemException {
		for (Head head : findByColumn14(column14, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn14(String column14) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN14;

		Object[] finderArgs = new Object[] { column14 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn14 = false;

			if (column14 == null) {
				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_1);
			}
			else if (column14.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_3);
			}
			else {
				bindColumn14 = true;

				query.append(_FINDER_COLUMN_COLUMN14_COLUMN14_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn14) {
					qPos.add(column14);
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

	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_1 = "head.column14 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_2 = "head.column14 = ?";
	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_3 = "(head.column14 IS NULL OR head.column14 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN15 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn15",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn15",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN15_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN15 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn15",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn15(String column15) throws SystemException {
		return findByColumn15(column15, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn15(String column15, int start, int end)
		throws SystemException {
		return findByColumn15(column15, start, end, null);
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
	@Override
	public List<Head> findByColumn15(String column15, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15;
			finderArgs = new Object[] { column15 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN15;
			finderArgs = new Object[] { column15, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column15, head.getColumn15())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn15 = false;

			if (column15 == null) {
				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_1);
			}
			else if (column15.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_3);
			}
			else {
				bindColumn15 = true;

				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn15) {
					qPos.add(column15);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn15_First(String column15,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn15_First(column15, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column15=");
		msg.append(column15);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn15_First(String column15,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn15(column15, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn15_Last(String column15,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn15_Last(column15, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column15=");
		msg.append(column15);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn15_Last(String column15,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn15(column15);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn15(column15, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn15_PrevAndNext(long headID, String column15,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn15_PrevAndNext(session, head, column15,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn15_PrevAndNext(session, head, column15,
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

	protected Head getByColumn15_PrevAndNext(Session session, Head head,
		String column15, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn15 = false;

		if (column15 == null) {
			query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_1);
		}
		else if (column15.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_3);
		}
		else {
			bindColumn15 = true;

			query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn15) {
			qPos.add(column15);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column15 = &#63; from the database.
	 *
	 * @param column15 the column15
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn15(String column15) throws SystemException {
		for (Head head : findByColumn15(column15, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn15(String column15) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN15;

		Object[] finderArgs = new Object[] { column15 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn15 = false;

			if (column15 == null) {
				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_1);
			}
			else if (column15.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_3);
			}
			else {
				bindColumn15 = true;

				query.append(_FINDER_COLUMN_COLUMN15_COLUMN15_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn15) {
					qPos.add(column15);
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

	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_1 = "head.column15 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_2 = "head.column15 = ?";
	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_3 = "(head.column15 IS NULL OR head.column15 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN16 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn16",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn16",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN16_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN16 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn16",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn16(String column16) throws SystemException {
		return findByColumn16(column16, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn16(String column16, int start, int end)
		throws SystemException {
		return findByColumn16(column16, start, end, null);
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
	@Override
	public List<Head> findByColumn16(String column16, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16;
			finderArgs = new Object[] { column16 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN16;
			finderArgs = new Object[] { column16, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column16, head.getColumn16())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn16 = false;

			if (column16 == null) {
				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_1);
			}
			else if (column16.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_3);
			}
			else {
				bindColumn16 = true;

				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn16) {
					qPos.add(column16);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn16_First(String column16,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn16_First(column16, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column16=");
		msg.append(column16);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn16_First(String column16,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn16(column16, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn16_Last(String column16,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn16_Last(column16, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column16=");
		msg.append(column16);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn16_Last(String column16,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn16(column16);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn16(column16, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn16_PrevAndNext(long headID, String column16,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn16_PrevAndNext(session, head, column16,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn16_PrevAndNext(session, head, column16,
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

	protected Head getByColumn16_PrevAndNext(Session session, Head head,
		String column16, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn16 = false;

		if (column16 == null) {
			query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_1);
		}
		else if (column16.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_3);
		}
		else {
			bindColumn16 = true;

			query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn16) {
			qPos.add(column16);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column16 = &#63; from the database.
	 *
	 * @param column16 the column16
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn16(String column16) throws SystemException {
		for (Head head : findByColumn16(column16, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn16(String column16) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN16;

		Object[] finderArgs = new Object[] { column16 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn16 = false;

			if (column16 == null) {
				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_1);
			}
			else if (column16.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_3);
			}
			else {
				bindColumn16 = true;

				query.append(_FINDER_COLUMN_COLUMN16_COLUMN16_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn16) {
					qPos.add(column16);
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

	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_1 = "head.column16 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_2 = "head.column16 = ?";
	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_3 = "(head.column16 IS NULL OR head.column16 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN17 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn17",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn17",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN17_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN17 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn17",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn17(String column17) throws SystemException {
		return findByColumn17(column17, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn17(String column17, int start, int end)
		throws SystemException {
		return findByColumn17(column17, start, end, null);
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
	@Override
	public List<Head> findByColumn17(String column17, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17;
			finderArgs = new Object[] { column17 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN17;
			finderArgs = new Object[] { column17, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column17, head.getColumn17())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn17 = false;

			if (column17 == null) {
				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_1);
			}
			else if (column17.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_3);
			}
			else {
				bindColumn17 = true;

				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn17) {
					qPos.add(column17);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn17_First(String column17,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn17_First(column17, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column17=");
		msg.append(column17);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn17_First(String column17,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn17(column17, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn17_Last(String column17,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn17_Last(column17, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column17=");
		msg.append(column17);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn17_Last(String column17,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn17(column17);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn17(column17, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn17_PrevAndNext(long headID, String column17,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn17_PrevAndNext(session, head, column17,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn17_PrevAndNext(session, head, column17,
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

	protected Head getByColumn17_PrevAndNext(Session session, Head head,
		String column17, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn17 = false;

		if (column17 == null) {
			query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_1);
		}
		else if (column17.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_3);
		}
		else {
			bindColumn17 = true;

			query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn17) {
			qPos.add(column17);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column17 = &#63; from the database.
	 *
	 * @param column17 the column17
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn17(String column17) throws SystemException {
		for (Head head : findByColumn17(column17, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn17(String column17) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN17;

		Object[] finderArgs = new Object[] { column17 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn17 = false;

			if (column17 == null) {
				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_1);
			}
			else if (column17.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_3);
			}
			else {
				bindColumn17 = true;

				query.append(_FINDER_COLUMN_COLUMN17_COLUMN17_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn17) {
					qPos.add(column17);
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

	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_1 = "head.column17 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_2 = "head.column17 = ?";
	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_3 = "(head.column17 IS NULL OR head.column17 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN18 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn18",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn18",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN18_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN18 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn18",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn18(String column18) throws SystemException {
		return findByColumn18(column18, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn18(String column18, int start, int end)
		throws SystemException {
		return findByColumn18(column18, start, end, null);
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
	@Override
	public List<Head> findByColumn18(String column18, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18;
			finderArgs = new Object[] { column18 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN18;
			finderArgs = new Object[] { column18, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column18, head.getColumn18())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn18 = false;

			if (column18 == null) {
				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_1);
			}
			else if (column18.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_3);
			}
			else {
				bindColumn18 = true;

				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn18) {
					qPos.add(column18);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn18_First(String column18,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn18_First(column18, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column18=");
		msg.append(column18);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn18_First(String column18,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn18(column18, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn18_Last(String column18,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn18_Last(column18, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column18=");
		msg.append(column18);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn18_Last(String column18,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn18(column18);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn18(column18, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn18_PrevAndNext(long headID, String column18,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn18_PrevAndNext(session, head, column18,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn18_PrevAndNext(session, head, column18,
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

	protected Head getByColumn18_PrevAndNext(Session session, Head head,
		String column18, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn18 = false;

		if (column18 == null) {
			query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_1);
		}
		else if (column18.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_3);
		}
		else {
			bindColumn18 = true;

			query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn18) {
			qPos.add(column18);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column18 = &#63; from the database.
	 *
	 * @param column18 the column18
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn18(String column18) throws SystemException {
		for (Head head : findByColumn18(column18, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn18(String column18) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN18;

		Object[] finderArgs = new Object[] { column18 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn18 = false;

			if (column18 == null) {
				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_1);
			}
			else if (column18.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_3);
			}
			else {
				bindColumn18 = true;

				query.append(_FINDER_COLUMN_COLUMN18_COLUMN18_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn18) {
					qPos.add(column18);
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

	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_1 = "head.column18 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_2 = "head.column18 = ?";
	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_3 = "(head.column18 IS NULL OR head.column18 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN19 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn19",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn19",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN19_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN19 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn19",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn19(String column19) throws SystemException {
		return findByColumn19(column19, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn19(String column19, int start, int end)
		throws SystemException {
		return findByColumn19(column19, start, end, null);
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
	@Override
	public List<Head> findByColumn19(String column19, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19;
			finderArgs = new Object[] { column19 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN19;
			finderArgs = new Object[] { column19, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column19, head.getColumn19())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn19 = false;

			if (column19 == null) {
				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_1);
			}
			else if (column19.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_3);
			}
			else {
				bindColumn19 = true;

				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn19) {
					qPos.add(column19);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn19_First(String column19,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn19_First(column19, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column19=");
		msg.append(column19);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn19_First(String column19,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn19(column19, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn19_Last(String column19,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn19_Last(column19, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column19=");
		msg.append(column19);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn19_Last(String column19,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn19(column19);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn19(column19, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn19_PrevAndNext(long headID, String column19,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn19_PrevAndNext(session, head, column19,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn19_PrevAndNext(session, head, column19,
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

	protected Head getByColumn19_PrevAndNext(Session session, Head head,
		String column19, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn19 = false;

		if (column19 == null) {
			query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_1);
		}
		else if (column19.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_3);
		}
		else {
			bindColumn19 = true;

			query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn19) {
			qPos.add(column19);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column19 = &#63; from the database.
	 *
	 * @param column19 the column19
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn19(String column19) throws SystemException {
		for (Head head : findByColumn19(column19, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn19(String column19) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN19;

		Object[] finderArgs = new Object[] { column19 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn19 = false;

			if (column19 == null) {
				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_1);
			}
			else if (column19.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_3);
			}
			else {
				bindColumn19 = true;

				query.append(_FINDER_COLUMN_COLUMN19_COLUMN19_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn19) {
					qPos.add(column19);
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

	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_1 = "head.column19 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_2 = "head.column19 = ?";
	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_3 = "(head.column19 IS NULL OR head.column19 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN20 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn20",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20 =
		new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn20",
			new String[] { String.class.getName() },
			HeadModelImpl.COLUMN20_COLUMN_BITMASK |
			HeadModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN20 = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn20",
			new String[] { String.class.getName() });

	/**
	 * Returns all the heads where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @return the matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findByColumn20(String column20) throws SystemException {
		return findByColumn20(column20, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Head> findByColumn20(String column20, int start, int end)
		throws SystemException {
		return findByColumn20(column20, start, end, null);
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
	@Override
	public List<Head> findByColumn20(String column20, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20;
			finderArgs = new Object[] { column20 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN20;
			finderArgs = new Object[] { column20, start, end, orderByComparator };
		}

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Head head : list) {
				if (!Validator.equals(column20, head.getColumn20())) {
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

			query.append(_SQL_SELECT_HEAD_WHERE);

			boolean bindColumn20 = false;

			if (column20 == null) {
				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_1);
			}
			else if (column20.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_3);
			}
			else {
				bindColumn20 = true;

				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn20) {
					qPos.add(column20);
				}

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first head in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head
	 * @throws org.gfbio.NoSuchHeadException if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByColumn20_First(String column20,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn20_First(column20, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column20=");
		msg.append(column20);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the first head in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn20_First(String column20,
		OrderByComparator orderByComparator) throws SystemException {
		List<Head> list = findByColumn20(column20, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head findByColumn20_Last(String column20,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByColumn20_Last(column20, orderByComparator);

		if (head != null) {
			return head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column20=");
		msg.append(column20);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHeadException(msg.toString());
	}

	/**
	 * Returns the last head in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching head, or <code>null</code> if a matching head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByColumn20_Last(String column20,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn20(column20);

		if (count == 0) {
			return null;
		}

		List<Head> list = findByColumn20(column20, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Head[] findByColumn20_PrevAndNext(long headID, String column20,
		OrderByComparator orderByComparator)
		throws NoSuchHeadException, SystemException {
		Head head = findByPrimaryKey(headID);

		Session session = null;

		try {
			session = openSession();

			Head[] array = new HeadImpl[3];

			array[0] = getByColumn20_PrevAndNext(session, head, column20,
					orderByComparator, true);

			array[1] = head;

			array[2] = getByColumn20_PrevAndNext(session, head, column20,
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

	protected Head getByColumn20_PrevAndNext(Session session, Head head,
		String column20, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEAD_WHERE);

		boolean bindColumn20 = false;

		if (column20 == null) {
			query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_1);
		}
		else if (column20.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_3);
		}
		else {
			bindColumn20 = true;

			query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_2);
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
			query.append(HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindColumn20) {
			qPos.add(column20);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the heads where column20 = &#63; from the database.
	 *
	 * @param column20 the column20
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn20(String column20) throws SystemException {
		for (Head head : findByColumn20(column20, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @return the number of matching heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumn20(String column20) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMN20;

		Object[] finderArgs = new Object[] { column20 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEAD_WHERE);

			boolean bindColumn20 = false;

			if (column20 == null) {
				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_1);
			}
			else if (column20.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_3);
			}
			else {
				bindColumn20 = true;

				query.append(_FINDER_COLUMN_COLUMN20_COLUMN20_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn20) {
					qPos.add(column20);
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

	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_1 = "head.column20 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_2 = "head.column20 = ?";
	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_3 = "(head.column20 IS NULL OR head.column20 = '')";

	public HeadPersistenceImpl() {
		setModelClass(Head.class);
	}

	/**
	 * Caches the head in the entity cache if it is enabled.
	 *
	 * @param head the head
	 */
	@Override
	public void cacheResult(Head head) {
		EntityCacheUtil.putResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadImpl.class, head.getPrimaryKey(), head);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADID,
			new Object[] { head.getHeadID() }, head);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { head.getName() }, head);

		head.resetOriginalValues();
	}

	/**
	 * Caches the heads in the entity cache if it is enabled.
	 *
	 * @param heads the heads
	 */
	@Override
	public void cacheResult(List<Head> heads) {
		for (Head head : heads) {
			if (EntityCacheUtil.getResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
						HeadImpl.class, head.getPrimaryKey()) == null) {
				cacheResult(head);
			}
			else {
				head.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all heads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HeadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HeadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the head.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Head head) {
		EntityCacheUtil.removeResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadImpl.class, head.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(head);
	}

	@Override
	public void clearCache(List<Head> heads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Head head : heads) {
			EntityCacheUtil.removeResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
				HeadImpl.class, head.getPrimaryKey());

			clearUniqueFindersCache(head);
		}
	}

	protected void cacheUniqueFindersCache(Head head) {
		if (head.isNew()) {
			Object[] args = new Object[] { head.getHeadID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HEADID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADID, args, head);

			args = new Object[] { head.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, head);
		}
		else {
			HeadModelImpl headModelImpl = (HeadModelImpl)head;

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_HEADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { head.getHeadID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HEADID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADID, args,
					head);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { head.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, head);
			}
		}
	}

	protected void clearUniqueFindersCache(Head head) {
		HeadModelImpl headModelImpl = (HeadModelImpl)head;

		Object[] args = new Object[] { head.getHeadID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADID, args);

		if ((headModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_HEADID.getColumnBitmask()) != 0) {
			args = new Object[] { headModelImpl.getOriginalHeadID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADID, args);
		}

		args = new Object[] { head.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((headModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { headModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new head with the primary key. Does not add the head to the database.
	 *
	 * @param headID the primary key for the new head
	 * @return the new head
	 */
	@Override
	public Head create(long headID) {
		Head head = new HeadImpl();

		head.setNew(true);
		head.setPrimaryKey(headID);

		return head;
	}

	/**
	 * Removes the head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param headID the primary key of the head
	 * @return the head that was removed
	 * @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head remove(long headID) throws NoSuchHeadException, SystemException {
		return remove((Serializable)headID);
	}

	/**
	 * Removes the head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the head
	 * @return the head that was removed
	 * @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head remove(Serializable primaryKey)
		throws NoSuchHeadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Head head = (Head)session.get(HeadImpl.class, primaryKey);

			if (head == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(head);
		}
		catch (NoSuchHeadException nsee) {
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
	protected Head removeImpl(Head head) throws SystemException {
		head = toUnwrappedModel(head);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(head)) {
				head = (Head)session.get(HeadImpl.class, head.getPrimaryKeyObj());
			}

			if (head != null) {
				session.delete(head);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (head != null) {
			clearCache(head);
		}

		return head;
	}

	@Override
	public Head updateImpl(org.gfbio.model.Head head) throws SystemException {
		head = toUnwrappedModel(head);

		boolean isNew = head.isNew();

		HeadModelImpl headModelImpl = (HeadModelImpl)head;

		Session session = null;

		try {
			session = openSession();

			if (head.isNew()) {
				session.save(head);

				head.setNew(false);
			}
			else {
				session.merge(head);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HeadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalTask() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK,
					args);

				args = new Object[] { headModelImpl.getTask() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn01() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN01, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01,
					args);

				args = new Object[] { headModelImpl.getColumn01() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN01, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn02() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN02, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02,
					args);

				args = new Object[] { headModelImpl.getColumn02() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN02, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn03() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN03, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03,
					args);

				args = new Object[] { headModelImpl.getColumn03() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN03, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn04() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN04, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04,
					args);

				args = new Object[] { headModelImpl.getColumn04() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN04, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn05() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN05, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05,
					args);

				args = new Object[] { headModelImpl.getColumn05() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN05, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn06() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN06, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06,
					args);

				args = new Object[] { headModelImpl.getColumn06() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN06, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn07() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN07, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07,
					args);

				args = new Object[] { headModelImpl.getColumn07() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN07, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn08() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN08, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08,
					args);

				args = new Object[] { headModelImpl.getColumn08() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN08, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn09() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN09, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09,
					args);

				args = new Object[] { headModelImpl.getColumn09() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN09, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn10() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN10, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10,
					args);

				args = new Object[] { headModelImpl.getColumn10() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN10, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn11() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN11, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11,
					args);

				args = new Object[] { headModelImpl.getColumn11() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN11, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn12() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN12, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12,
					args);

				args = new Object[] { headModelImpl.getColumn12() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN12, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn13() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN13, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13,
					args);

				args = new Object[] { headModelImpl.getColumn13() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN13, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn14() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN14, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14,
					args);

				args = new Object[] { headModelImpl.getColumn14() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN14, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn15() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN15, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15,
					args);

				args = new Object[] { headModelImpl.getColumn15() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN15, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn16() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN16, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16,
					args);

				args = new Object[] { headModelImpl.getColumn16() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN16, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn17() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN17, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17,
					args);

				args = new Object[] { headModelImpl.getColumn17() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN17, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn18() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN18, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18,
					args);

				args = new Object[] { headModelImpl.getColumn18() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN18, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn19() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN19, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19,
					args);

				args = new Object[] { headModelImpl.getColumn19() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN19, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19,
					args);
			}

			if ((headModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { headModelImpl.getOriginalColumn20() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN20, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20,
					args);

				args = new Object[] { headModelImpl.getColumn20() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN20, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20,
					args);
			}
		}

		EntityCacheUtil.putResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadImpl.class, head.getPrimaryKey(), head);

		clearUniqueFindersCache(head);
		cacheUniqueFindersCache(head);

		return head;
	}

	protected Head toUnwrappedModel(Head head) {
		if (head instanceof HeadImpl) {
			return head;
		}

		HeadImpl headImpl = new HeadImpl();

		headImpl.setNew(head.isNew());
		headImpl.setPrimaryKey(head.getPrimaryKey());

		headImpl.setHeadID(head.getHeadID());
		headImpl.setName(head.getName());
		headImpl.setTask(head.getTask());
		headImpl.setColumn01(head.getColumn01());
		headImpl.setColumn02(head.getColumn02());
		headImpl.setColumn03(head.getColumn03());
		headImpl.setColumn04(head.getColumn04());
		headImpl.setColumn05(head.getColumn05());
		headImpl.setColumn06(head.getColumn06());
		headImpl.setColumn07(head.getColumn07());
		headImpl.setColumn08(head.getColumn08());
		headImpl.setColumn09(head.getColumn09());
		headImpl.setColumn10(head.getColumn10());
		headImpl.setColumn11(head.getColumn11());
		headImpl.setColumn12(head.getColumn12());
		headImpl.setColumn13(head.getColumn13());
		headImpl.setColumn14(head.getColumn14());
		headImpl.setColumn15(head.getColumn15());
		headImpl.setColumn16(head.getColumn16());
		headImpl.setColumn17(head.getColumn17());
		headImpl.setColumn18(head.getColumn18());
		headImpl.setColumn19(head.getColumn19());
		headImpl.setColumn20(head.getColumn20());

		return headImpl;
	}

	/**
	 * Returns the head with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the head
	 * @return the head
	 * @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByPrimaryKey(primaryKey);

		if (head == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHeadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return head;
	}

	/**
	 * Returns the head with the primary key or throws a {@link org.gfbio.NoSuchHeadException} if it could not be found.
	 *
	 * @param headID the primary key of the head
	 * @return the head
	 * @throws org.gfbio.NoSuchHeadException if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head findByPrimaryKey(long headID)
		throws NoSuchHeadException, SystemException {
		return findByPrimaryKey((Serializable)headID);
	}

	/**
	 * Returns the head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the head
	 * @return the head, or <code>null</code> if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Head head = (Head)EntityCacheUtil.getResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
				HeadImpl.class, primaryKey);

		if (head == _nullHead) {
			return null;
		}

		if (head == null) {
			Session session = null;

			try {
				session = openSession();

				head = (Head)session.get(HeadImpl.class, primaryKey);

				if (head != null) {
					cacheResult(head);
				}
				else {
					EntityCacheUtil.putResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
						HeadImpl.class, primaryKey, _nullHead);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HeadModelImpl.ENTITY_CACHE_ENABLED,
					HeadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return head;
	}

	/**
	 * Returns the head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param headID the primary key of the head
	 * @return the head, or <code>null</code> if a head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Head fetchByPrimaryKey(long headID) throws SystemException {
		return fetchByPrimaryKey((Serializable)headID);
	}

	/**
	 * Returns all the heads.
	 *
	 * @return the heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Head> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Head> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Head> findAll(int start, int end,
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

		List<Head> list = (List<Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HEAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HEAD;

				if (pagination) {
					sql = sql.concat(HeadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Head>(list);
				}
				else {
					list = (List<Head>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the heads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Head head : findAll()) {
			remove(head);
		}
	}

	/**
	 * Returns the number of heads.
	 *
	 * @return the number of heads
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

				Query q = session.createQuery(_SQL_COUNT_HEAD);

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
	 * Initializes the head persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Head")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Head>> listenersList = new ArrayList<ModelListener<Head>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Head>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HeadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HEAD = "SELECT head FROM Head head";
	private static final String _SQL_SELECT_HEAD_WHERE = "SELECT head FROM Head head WHERE ";
	private static final String _SQL_COUNT_HEAD = "SELECT COUNT(head) FROM Head head";
	private static final String _SQL_COUNT_HEAD_WHERE = "SELECT COUNT(head) FROM Head head WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "head.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Head exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Head exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HeadPersistenceImpl.class);
	private static Head _nullHead = new HeadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Head> toCacheModel() {
				return _nullHeadCacheModel;
			}
		};

	private static CacheModel<Head> _nullHeadCacheModel = new CacheModel<Head>() {
			@Override
			public Head toEntityModel() {
				return _nullHead;
			}
		};
}