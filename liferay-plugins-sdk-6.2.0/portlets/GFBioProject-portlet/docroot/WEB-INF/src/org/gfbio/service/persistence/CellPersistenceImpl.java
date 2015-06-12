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

import org.gfbio.NoSuchCellException;

import org.gfbio.model.Cell;
import org.gfbio.model.impl.CellImpl;
import org.gfbio.model.impl.CellModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cell service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see CellPersistence
 * @see CellUtil
 * @generated
 */
public class CellPersistenceImpl extends BasePersistenceImpl<Cell>
	implements CellPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CellUtil} to access the cell persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CellImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CELLID = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCellId",
			new String[] { Long.class.getName() },
			CellModelImpl.CELLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CELLID = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCellId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the cell where cellID = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	 *
	 * @param cellID the cell i d
	 * @return the matching cell
	 * @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByCellId(long cellID)
		throws NoSuchCellException, SystemException {
		Cell cell = fetchByCellId(cellID);

		if (cell == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cellID=");
			msg.append(cellID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCellException(msg.toString());
		}

		return cell;
	}

	/**
	 * Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cellID the cell i d
	 * @return the matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByCellId(long cellID) throws SystemException {
		return fetchByCellId(cellID, true);
	}

	/**
	 * Returns the cell where cellID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cellID the cell i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByCellId(long cellID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { cellID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CELLID,
					finderArgs, this);
		}

		if (result instanceof Cell) {
			Cell cell = (Cell)result;

			if ((cellID != cell.getCellID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CELL_WHERE);

			query.append(_FINDER_COLUMN_CELLID_CELLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

				List<Cell> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CELLID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CellPersistenceImpl.fetchByCellId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell cell = list.get(0);

					result = cell;

					cacheResult(cell);

					if ((cell.getCellID() != cellID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CELLID,
							finderArgs, cell);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CELLID,
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
			return (Cell)result;
		}
	}

	/**
	 * Removes the cell where cellID = &#63; from the database.
	 *
	 * @param cellID the cell i d
	 * @return the cell that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell removeByCellId(long cellID)
		throws NoSuchCellException, SystemException {
		Cell cell = findByCellId(cellID);

		return remove(cell);
	}

	/**
	 * Returns the number of cells where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @return the number of matching cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCellId(long cellID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CELLID;

		Object[] finderArgs = new Object[] { cellID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CELL_WHERE);

			query.append(_FINDER_COLUMN_CELLID_CELLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

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

	private static final String _FINDER_COLUMN_CELLID_CELLID_2 = "cell.cellID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTENT = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByContent",
			new String[] { String.class.getName() },
			CellModelImpl.CONTENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENT = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContent",
			new String[] { String.class.getName() });

	/**
	 * Returns the cell where content = &#63; or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	 *
	 * @param content the content
	 * @return the matching cell
	 * @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByContent(String content)
		throws NoSuchCellException, SystemException {
		Cell cell = fetchByContent(content);

		if (cell == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("content=");
			msg.append(content);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCellException(msg.toString());
		}

		return cell;
	}

	/**
	 * Returns the cell where content = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param content the content
	 * @return the matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByContent(String content) throws SystemException {
		return fetchByContent(content, true);
	}

	/**
	 * Returns the cell where content = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param content the content
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByContent(String content, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { content };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTENT,
					finderArgs, this);
		}

		if (result instanceof Cell) {
			Cell cell = (Cell)result;

			if (!Validator.equals(content, cell.getContent())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CELL_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENT_CONTENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContent) {
					qPos.add(content);
				}

				List<Cell> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CellPersistenceImpl.fetchByContent(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell cell = list.get(0);

					result = cell;

					cacheResult(cell);

					if ((cell.getContent() == null) ||
							!cell.getContent().equals(content)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENT,
							finderArgs, cell);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENT,
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
			return (Cell)result;
		}
	}

	/**
	 * Removes the cell where content = &#63; from the database.
	 *
	 * @param content the content
	 * @return the cell that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell removeByContent(String content)
		throws NoSuchCellException, SystemException {
		Cell cell = findByContent(content);

		return remove(cell);
	}

	/**
	 * Returns the number of cells where content = &#63;.
	 *
	 * @param content the content
	 * @return the number of matching cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContent(String content) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENT;

		Object[] finderArgs = new Object[] { content };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CELL_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENT_CONTENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContent) {
					qPos.add(content);
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

	private static final String _FINDER_COLUMN_CONTENT_CONTENT_1 = "cell.content IS NULL";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_2 = "cell.content = ?";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_3 = "(cell.content IS NULL OR cell.content = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TASK = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTask",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, CellImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTask",
			new String[] { String.class.getName() },
			CellModelImpl.TASK_COLUMN_BITMASK |
			CellModelImpl.CONTENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASK = new FinderPath(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTask",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cells where task = &#63;.
	 *
	 * @param task the task
	 * @return the matching cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findByTask(String task) throws SystemException {
		return findByTask(task, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cells where task = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param task the task
	 * @param start the lower bound of the range of cells
	 * @param end the upper bound of the range of cells (not inclusive)
	 * @return the range of matching cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findByTask(String task, int start, int end)
		throws SystemException {
		return findByTask(task, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cells where task = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param task the task
	 * @param start the lower bound of the range of cells
	 * @param end the upper bound of the range of cells (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findByTask(String task, int start, int end,
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

		List<Cell> list = (List<Cell>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cell cell : list) {
				if (!Validator.equals(task, cell.getTask())) {
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

			query.append(_SQL_SELECT_CELL_WHERE);

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
				query.append(CellModelImpl.ORDER_BY_JPQL);
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
					list = (List<Cell>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell>(list);
				}
				else {
					list = (List<Cell>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first cell in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell
	 * @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByTask_First(String task,
		OrderByComparator orderByComparator)
		throws NoSuchCellException, SystemException {
		Cell cell = fetchByTask_First(task, orderByComparator);

		if (cell != null) {
			return cell;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("task=");
		msg.append(task);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCellException(msg.toString());
	}

	/**
	 * Returns the first cell in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByTask_First(String task,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cell> list = findByTask(task, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cell in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell
	 * @throws org.gfbio.NoSuchCellException if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByTask_Last(String task, OrderByComparator orderByComparator)
		throws NoSuchCellException, SystemException {
		Cell cell = fetchByTask_Last(task, orderByComparator);

		if (cell != null) {
			return cell;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("task=");
		msg.append(task);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCellException(msg.toString());
	}

	/**
	 * Returns the last cell in the ordered set where task = &#63;.
	 *
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell, or <code>null</code> if a matching cell could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByTask_Last(String task,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTask(task);

		if (count == 0) {
			return null;
		}

		List<Cell> list = findByTask(task, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cells before and after the current cell in the ordered set where task = &#63;.
	 *
	 * @param cellID the primary key of the current cell
	 * @param task the task
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cell
	 * @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell[] findByTask_PrevAndNext(long cellID, String task,
		OrderByComparator orderByComparator)
		throws NoSuchCellException, SystemException {
		Cell cell = findByPrimaryKey(cellID);

		Session session = null;

		try {
			session = openSession();

			Cell[] array = new CellImpl[3];

			array[0] = getByTask_PrevAndNext(session, cell, task,
					orderByComparator, true);

			array[1] = cell;

			array[2] = getByTask_PrevAndNext(session, cell, task,
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

	protected Cell getByTask_PrevAndNext(Session session, Cell cell,
		String task, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CELL_WHERE);

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
			query.append(CellModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(cell);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cell> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cells where task = &#63; from the database.
	 *
	 * @param task the task
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTask(String task) throws SystemException {
		for (Cell cell : findByTask(task, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(cell);
		}
	}

	/**
	 * Returns the number of cells where task = &#63;.
	 *
	 * @param task the task
	 * @return the number of matching cells
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

			query.append(_SQL_COUNT_CELL_WHERE);

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

	private static final String _FINDER_COLUMN_TASK_TASK_1 = "cell.task IS NULL";
	private static final String _FINDER_COLUMN_TASK_TASK_2 = "cell.task = ?";
	private static final String _FINDER_COLUMN_TASK_TASK_3 = "(cell.task IS NULL OR cell.task = '')";

	public CellPersistenceImpl() {
		setModelClass(Cell.class);
	}

	/**
	 * Caches the cell in the entity cache if it is enabled.
	 *
	 * @param cell the cell
	 */
	@Override
	public void cacheResult(Cell cell) {
		EntityCacheUtil.putResult(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellImpl.class, cell.getPrimaryKey(), cell);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CELLID,
			new Object[] { cell.getCellID() }, cell);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENT,
			new Object[] { cell.getContent() }, cell);

		cell.resetOriginalValues();
	}

	/**
	 * Caches the cells in the entity cache if it is enabled.
	 *
	 * @param cells the cells
	 */
	@Override
	public void cacheResult(List<Cell> cells) {
		for (Cell cell : cells) {
			if (EntityCacheUtil.getResult(CellModelImpl.ENTITY_CACHE_ENABLED,
						CellImpl.class, cell.getPrimaryKey()) == null) {
				cacheResult(cell);
			}
			else {
				cell.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cells.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CellImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CellImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cell.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cell cell) {
		EntityCacheUtil.removeResult(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellImpl.class, cell.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cell);
	}

	@Override
	public void clearCache(List<Cell> cells) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cell cell : cells) {
			EntityCacheUtil.removeResult(CellModelImpl.ENTITY_CACHE_ENABLED,
				CellImpl.class, cell.getPrimaryKey());

			clearUniqueFindersCache(cell);
		}
	}

	protected void cacheUniqueFindersCache(Cell cell) {
		if (cell.isNew()) {
			Object[] args = new Object[] { cell.getCellID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CELLID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CELLID, args, cell);

			args = new Object[] { cell.getContent() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTENT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENT, args, cell);
		}
		else {
			CellModelImpl cellModelImpl = (CellModelImpl)cell;

			if ((cellModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CELLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cell.getCellID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CELLID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CELLID, args,
					cell);
			}

			if ((cellModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cell.getContent() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTENT, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENT, args,
					cell);
			}
		}
	}

	protected void clearUniqueFindersCache(Cell cell) {
		CellModelImpl cellModelImpl = (CellModelImpl)cell;

		Object[] args = new Object[] { cell.getCellID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CELLID, args);

		if ((cellModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CELLID.getColumnBitmask()) != 0) {
			args = new Object[] { cellModelImpl.getOriginalCellID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CELLID, args);
		}

		args = new Object[] { cell.getContent() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENT, args);

		if ((cellModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTENT.getColumnBitmask()) != 0) {
			args = new Object[] { cellModelImpl.getOriginalContent() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENT, args);
		}
	}

	/**
	 * Creates a new cell with the primary key. Does not add the cell to the database.
	 *
	 * @param cellID the primary key for the new cell
	 * @return the new cell
	 */
	@Override
	public Cell create(long cellID) {
		Cell cell = new CellImpl();

		cell.setNew(true);
		cell.setPrimaryKey(cellID);

		return cell;
	}

	/**
	 * Removes the cell with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cellID the primary key of the cell
	 * @return the cell that was removed
	 * @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell remove(long cellID) throws NoSuchCellException, SystemException {
		return remove((Serializable)cellID);
	}

	/**
	 * Removes the cell with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cell
	 * @return the cell that was removed
	 * @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell remove(Serializable primaryKey)
		throws NoSuchCellException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cell cell = (Cell)session.get(CellImpl.class, primaryKey);

			if (cell == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCellException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cell);
		}
		catch (NoSuchCellException nsee) {
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
	protected Cell removeImpl(Cell cell) throws SystemException {
		cell = toUnwrappedModel(cell);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cell)) {
				cell = (Cell)session.get(CellImpl.class, cell.getPrimaryKeyObj());
			}

			if (cell != null) {
				session.delete(cell);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cell != null) {
			clearCache(cell);
		}

		return cell;
	}

	@Override
	public Cell updateImpl(org.gfbio.model.Cell cell) throws SystemException {
		cell = toUnwrappedModel(cell);

		boolean isNew = cell.isNew();

		CellModelImpl cellModelImpl = (CellModelImpl)cell;

		Session session = null;

		try {
			session = openSession();

			if (cell.isNew()) {
				session.save(cell);

				cell.setNew(false);
			}
			else {
				session.merge(cell);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CellModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cellModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cellModelImpl.getOriginalTask() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK,
					args);

				args = new Object[] { cellModelImpl.getTask() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASK, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASK,
					args);
			}
		}

		EntityCacheUtil.putResult(CellModelImpl.ENTITY_CACHE_ENABLED,
			CellImpl.class, cell.getPrimaryKey(), cell);

		clearUniqueFindersCache(cell);
		cacheUniqueFindersCache(cell);

		return cell;
	}

	protected Cell toUnwrappedModel(Cell cell) {
		if (cell instanceof CellImpl) {
			return cell;
		}

		CellImpl cellImpl = new CellImpl();

		cellImpl.setNew(cell.isNew());
		cellImpl.setPrimaryKey(cell.getPrimaryKey());

		cellImpl.setCellID(cell.getCellID());
		cellImpl.setContent(cell.getContent());
		cellImpl.setTask(cell.getTask());

		return cellImpl;
	}

	/**
	 * Returns the cell with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell
	 * @return the cell
	 * @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCellException, SystemException {
		Cell cell = fetchByPrimaryKey(primaryKey);

		if (cell == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCellException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cell;
	}

	/**
	 * Returns the cell with the primary key or throws a {@link org.gfbio.NoSuchCellException} if it could not be found.
	 *
	 * @param cellID the primary key of the cell
	 * @return the cell
	 * @throws org.gfbio.NoSuchCellException if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell findByPrimaryKey(long cellID)
		throws NoSuchCellException, SystemException {
		return findByPrimaryKey((Serializable)cellID);
	}

	/**
	 * Returns the cell with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell
	 * @return the cell, or <code>null</code> if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cell cell = (Cell)EntityCacheUtil.getResult(CellModelImpl.ENTITY_CACHE_ENABLED,
				CellImpl.class, primaryKey);

		if (cell == _nullCell) {
			return null;
		}

		if (cell == null) {
			Session session = null;

			try {
				session = openSession();

				cell = (Cell)session.get(CellImpl.class, primaryKey);

				if (cell != null) {
					cacheResult(cell);
				}
				else {
					EntityCacheUtil.putResult(CellModelImpl.ENTITY_CACHE_ENABLED,
						CellImpl.class, primaryKey, _nullCell);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CellModelImpl.ENTITY_CACHE_ENABLED,
					CellImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cell;
	}

	/**
	 * Returns the cell with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cellID the primary key of the cell
	 * @return the cell, or <code>null</code> if a cell with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell fetchByPrimaryKey(long cellID) throws SystemException {
		return fetchByPrimaryKey((Serializable)cellID);
	}

	/**
	 * Returns all the cells.
	 *
	 * @return the cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cells.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cells
	 * @param end the upper bound of the range of cells (not inclusive)
	 * @return the range of cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cells.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.CellModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cells
	 * @param end the upper bound of the range of cells (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cells
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell> findAll(int start, int end,
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

		List<Cell> list = (List<Cell>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CELL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CELL;

				if (pagination) {
					sql = sql.concat(CellModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cell>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell>(list);
				}
				else {
					list = (List<Cell>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the cells from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cell cell : findAll()) {
			remove(cell);
		}
	}

	/**
	 * Returns the number of cells.
	 *
	 * @return the number of cells
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

				Query q = session.createQuery(_SQL_COUNT_CELL);

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
	 * Initializes the cell persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Cell")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cell>> listenersList = new ArrayList<ModelListener<Cell>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cell>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CellImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CELL = "SELECT cell FROM Cell cell";
	private static final String _SQL_SELECT_CELL_WHERE = "SELECT cell FROM Cell cell WHERE ";
	private static final String _SQL_COUNT_CELL = "SELECT COUNT(cell) FROM Cell cell";
	private static final String _SQL_COUNT_CELL_WHERE = "SELECT COUNT(cell) FROM Cell cell WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cell.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cell exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cell exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CellPersistenceImpl.class);
	private static Cell _nullCell = new CellImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cell> toCacheModel() {
				return _nullCellCacheModel;
			}
		};

	private static CacheModel<Cell> _nullCellCacheModel = new CacheModel<Cell>() {
			@Override
			public Cell toEntityModel() {
				return _nullCell;
			}
		};
}