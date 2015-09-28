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
 * @author Marcel Froemming
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
			FINDER_CLASS_NAME_ENTITY, "fetchByHeadId",
			new String[] { Long.class.getName() },
			HeadModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(HeadModelImpl.ENTITY_CACHE_ENABLED,
			HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
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
	public Head findByHeadId(long headID)
		throws NoSuchHeadException, SystemException {
		Head head = fetchByHeadId(headID);

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
	public Head fetchByHeadId(long headID) throws SystemException {
		return fetchByHeadId(headID, true);
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
	public Head fetchByHeadId(long headID, boolean retrieveFromCache)
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
							"HeadPersistenceImpl.fetchByHeadId(long, boolean) with parameters (" +
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
	public Head removeByHeadId(long headID)
		throws NoSuchHeadException, SystemException {
		Head head = findByHeadId(headID);

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
	public int countByHeadId(long headID) throws SystemException {
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