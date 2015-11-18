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

import org.gfbio.NoSuchColumnException;

import org.gfbio.model.Column;
import org.gfbio.model.impl.ColumnImpl;
import org.gfbio.model.impl.ColumnModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the column service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ColumnPersistence
 * @see ColumnUtil
 * @generated
 */
public class ColumnPersistenceImpl extends BasePersistenceImpl<Column>
	implements ColumnPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ColumnUtil} to access the column persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ColumnImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COLUMNID = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByColumnId",
			new String[] { Long.class.getName() },
			ColumnModelImpl.COLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMNID = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the column where columnID = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	 *
	 * @param columnID the column i d
	 * @return the matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByColumnId(long columnID)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByColumnId(columnID);

		if (column == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnID=");
			msg.append(columnID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchColumnException(msg.toString());
		}

		return column;
	}

	/**
	 * Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param columnID the column i d
	 * @return the matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByColumnId(long columnID) throws SystemException {
		return fetchByColumnId(columnID, true);
	}

	/**
	 * Returns the column where columnID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param columnID the column i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByColumnId(long columnID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { columnID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLUMNID,
					finderArgs, this);
		}

		if (result instanceof Column) {
			Column column = (Column)result;

			if ((columnID != column.getColumnID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COLUMN_WHERE);

			query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				List<Column> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ColumnPersistenceImpl.fetchByColumnId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Column column = list.get(0);

					result = column;

					cacheResult(column);

					if ((column.getColumnID() != columnID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNID,
							finderArgs, column);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNID,
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
			return (Column)result;
		}
	}

	/**
	 * Removes the column where columnID = &#63; from the database.
	 *
	 * @param columnID the column i d
	 * @return the column that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column removeByColumnId(long columnID)
		throws NoSuchColumnException, SystemException {
		Column column = findByColumnId(columnID);

		return remove(column);
	}

	/**
	 * Returns the number of columns where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @return the number of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumnId(long columnID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMNID;

		Object[] finderArgs = new Object[] { columnID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COLUMN_WHERE);

			query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

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

	private static final String _FINDER_COLUMN_COLUMNID_COLUMNID_2 = "column.columnID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COLUMNNAME = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByColumnName",
			new String[] { String.class.getName() },
			ColumnModelImpl.COLUMN_NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMNNAME = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnName",
			new String[] { String.class.getName() });

	/**
	 * Returns the column where column_name = &#63; or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	 *
	 * @param column_name the column_name
	 * @return the matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByColumnName(String column_name)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByColumnName(column_name);

		if (column == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("column_name=");
			msg.append(column_name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchColumnException(msg.toString());
		}

		return column;
	}

	/**
	 * Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param column_name the column_name
	 * @return the matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByColumnName(String column_name)
		throws SystemException {
		return fetchByColumnName(column_name, true);
	}

	/**
	 * Returns the column where column_name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param column_name the column_name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByColumnName(String column_name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { column_name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
					finderArgs, this);
		}

		if (result instanceof Column) {
			Column column = (Column)result;

			if (!Validator.equals(column_name, column.getColumn_name())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COLUMN_WHERE);

			boolean bindColumn_name = false;

			if (column_name == null) {
				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_1);
			}
			else if (column_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_3);
			}
			else {
				bindColumn_name = true;

				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn_name) {
					qPos.add(column_name);
				}

				List<Column> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ColumnPersistenceImpl.fetchByColumnName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Column column = list.get(0);

					result = column;

					cacheResult(column);

					if ((column.getColumn_name() == null) ||
							!column.getColumn_name().equals(column_name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
							finderArgs, column);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
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
			return (Column)result;
		}
	}

	/**
	 * Removes the column where column_name = &#63; from the database.
	 *
	 * @param column_name the column_name
	 * @return the column that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column removeByColumnName(String column_name)
		throws NoSuchColumnException, SystemException {
		Column column = findByColumnName(column_name);

		return remove(column);
	}

	/**
	 * Returns the number of columns where column_name = &#63;.
	 *
	 * @param column_name the column_name
	 * @return the number of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumnName(String column_name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMNNAME;

		Object[] finderArgs = new Object[] { column_name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COLUMN_WHERE);

			boolean bindColumn_name = false;

			if (column_name == null) {
				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_1);
			}
			else if (column_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_3);
			}
			else {
				bindColumn_name = true;

				query.append(_FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindColumn_name) {
					qPos.add(column_name);
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

	private static final String _FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_1 = "column.column_name IS NULL";
	private static final String _FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_2 = "column.column_name = ?";
	private static final String _FINDER_COLUMN_COLUMNNAME_COLUMN_NAME_3 = "(column.column_name IS NULL OR column.column_name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHeadId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID =
		new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHeadId",
			new String[] { Long.class.getName() },
			ColumnModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the columns where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadId(long headID) throws SystemException {
		return findByHeadId(headID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the columns where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @return the range of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadId(long headID, int start, int end)
		throws SystemException {
		return findByHeadId(headID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the columns where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadId(long headID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID;
			finderArgs = new Object[] { headID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID;
			finderArgs = new Object[] { headID, start, end, orderByComparator };
		}

		List<Column> list = (List<Column>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Column column : list) {
				if ((headID != column.getHeadID())) {
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

			query.append(_SQL_SELECT_COLUMN_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ColumnModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (!pagination) {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Column>(list);
				}
				else {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first column in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByHeadId_First(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByHeadId_First(headID, orderByComparator);

		if (column != null) {
			return column;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchColumnException(msg.toString());
	}

	/**
	 * Returns the first column in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByHeadId_First(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Column> list = findByHeadId(headID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByHeadId_Last(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByHeadId_Last(headID, orderByComparator);

		if (column != null) {
			return column;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchColumnException(msg.toString());
	}

	/**
	 * Returns the last column in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByHeadId_Last(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHeadId(headID);

		if (count == 0) {
			return null;
		}

		List<Column> list = findByHeadId(headID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the columns before and after the current column in the ordered set where headID = &#63;.
	 *
	 * @param columnID the primary key of the current column
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column[] findByHeadId_PrevAndNext(long columnID, long headID,
		OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = findByPrimaryKey(columnID);

		Session session = null;

		try {
			session = openSession();

			Column[] array = new ColumnImpl[3];

			array[0] = getByHeadId_PrevAndNext(session, column, headID,
					orderByComparator, true);

			array[1] = column;

			array[2] = getByHeadId_PrevAndNext(session, column, headID,
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

	protected Column getByHeadId_PrevAndNext(Session session, Column column,
		long headID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COLUMN_WHERE);

		query.append(_FINDER_COLUMN_HEADID_HEADID_2);

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
			query.append(ColumnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(headID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(column);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Column> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the columns where headID = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHeadId(long headID) throws SystemException {
		for (Column column : findByHeadId(headID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(column);
		}
	}

	/**
	 * Returns the number of columns where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the number of matching columns
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

			query.append(_SQL_COUNT_COLUMN_WHERE);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 = "column.headID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME =
		new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByHeadIdAndColumnName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME =
		new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, ColumnImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByHeadIdAndColumnName",
			new String[] { Long.class.getName(), String.class.getName() },
			ColumnModelImpl.HEADID_COLUMN_BITMASK |
			ColumnModelImpl.COLUMN_NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADIDANDCOLUMNNAME = new FinderPath(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByHeadIdAndColumnName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the columns where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @return the matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadIdAndColumnName(long headID,
		String column_name) throws SystemException {
		return findByHeadIdAndColumnName(headID, column_name,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the columns where headID = &#63; and column_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @return the range of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadIdAndColumnName(long headID,
		String column_name, int start, int end) throws SystemException {
		return findByHeadIdAndColumnName(headID, column_name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the columns where headID = &#63; and column_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findByHeadIdAndColumnName(long headID,
		String column_name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME;
			finderArgs = new Object[] { headID, column_name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME;
			finderArgs = new Object[] {
					headID, column_name,
					
					start, end, orderByComparator
				};
		}

		List<Column> list = (List<Column>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Column column : list) {
				if ((headID != column.getHeadID()) ||
						!Validator.equals(column_name, column.getColumn_name())) {
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

			query.append(_SQL_SELECT_COLUMN_WHERE);

			query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_HEADID_2);

			boolean bindColumn_name = false;

			if (column_name == null) {
				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_1);
			}
			else if (column_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_3);
			}
			else {
				bindColumn_name = true;

				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ColumnModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (bindColumn_name) {
					qPos.add(column_name);
				}

				if (!pagination) {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Column>(list);
				}
				else {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first column in the ordered set where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByHeadIdAndColumnName_First(long headID,
		String column_name, OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByHeadIdAndColumnName_First(headID, column_name,
				orderByComparator);

		if (column != null) {
			return column;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(", column_name=");
		msg.append(column_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchColumnException(msg.toString());
	}

	/**
	 * Returns the first column in the ordered set where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByHeadIdAndColumnName_First(long headID,
		String column_name, OrderByComparator orderByComparator)
		throws SystemException {
		List<Column> list = findByHeadIdAndColumnName(headID, column_name, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column in the ordered set where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column
	 * @throws org.gfbio.NoSuchColumnException if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByHeadIdAndColumnName_Last(long headID,
		String column_name, OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByHeadIdAndColumnName_Last(headID, column_name,
				orderByComparator);

		if (column != null) {
			return column;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(", column_name=");
		msg.append(column_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchColumnException(msg.toString());
	}

	/**
	 * Returns the last column in the ordered set where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column, or <code>null</code> if a matching column could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByHeadIdAndColumnName_Last(long headID,
		String column_name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByHeadIdAndColumnName(headID, column_name);

		if (count == 0) {
			return null;
		}

		List<Column> list = findByHeadIdAndColumnName(headID, column_name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the columns before and after the current column in the ordered set where headID = &#63; and column_name = &#63;.
	 *
	 * @param columnID the primary key of the current column
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column[] findByHeadIdAndColumnName_PrevAndNext(long columnID,
		long headID, String column_name, OrderByComparator orderByComparator)
		throws NoSuchColumnException, SystemException {
		Column column = findByPrimaryKey(columnID);

		Session session = null;

		try {
			session = openSession();

			Column[] array = new ColumnImpl[3];

			array[0] = getByHeadIdAndColumnName_PrevAndNext(session, column,
					headID, column_name, orderByComparator, true);

			array[1] = column;

			array[2] = getByHeadIdAndColumnName_PrevAndNext(session, column,
					headID, column_name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Column getByHeadIdAndColumnName_PrevAndNext(Session session,
		Column column, long headID, String column_name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COLUMN_WHERE);

		query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_HEADID_2);

		boolean bindColumn_name = false;

		if (column_name == null) {
			query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_1);
		}
		else if (column_name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_3);
		}
		else {
			bindColumn_name = true;

			query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_2);
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
			query.append(ColumnModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(headID);

		if (bindColumn_name) {
			qPos.add(column_name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(column);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Column> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the columns where headID = &#63; and column_name = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHeadIdAndColumnName(long headID, String column_name)
		throws SystemException {
		for (Column column : findByHeadIdAndColumnName(headID, column_name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(column);
		}
	}

	/**
	 * Returns the number of columns where headID = &#63; and column_name = &#63;.
	 *
	 * @param headID the head i d
	 * @param column_name the column_name
	 * @return the number of matching columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHeadIdAndColumnName(long headID, String column_name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HEADIDANDCOLUMNNAME;

		Object[] finderArgs = new Object[] { headID, column_name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COLUMN_WHERE);

			query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_HEADID_2);

			boolean bindColumn_name = false;

			if (column_name == null) {
				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_1);
			}
			else if (column_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_3);
			}
			else {
				bindColumn_name = true;

				query.append(_FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (bindColumn_name) {
					qPos.add(column_name);
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

	private static final String _FINDER_COLUMN_HEADIDANDCOLUMNNAME_HEADID_2 = "column.headID = ? AND ";
	private static final String _FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_1 =
		"column.column_name IS NULL";
	private static final String _FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_2 =
		"column.column_name = ?";
	private static final String _FINDER_COLUMN_HEADIDANDCOLUMNNAME_COLUMN_NAME_3 =
		"(column.column_name IS NULL OR column.column_name = '')";

	public ColumnPersistenceImpl() {
		setModelClass(Column.class);
	}

	/**
	 * Caches the column in the entity cache if it is enabled.
	 *
	 * @param column the column
	 */
	@Override
	public void cacheResult(Column column) {
		EntityCacheUtil.putResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnImpl.class, column.getPrimaryKey(), column);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNID,
			new Object[] { column.getColumnID() }, column);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
			new Object[] { column.getColumn_name() }, column);

		column.resetOriginalValues();
	}

	/**
	 * Caches the columns in the entity cache if it is enabled.
	 *
	 * @param columns the columns
	 */
	@Override
	public void cacheResult(List<Column> columns) {
		for (Column column : columns) {
			if (EntityCacheUtil.getResult(
						ColumnModelImpl.ENTITY_CACHE_ENABLED, ColumnImpl.class,
						column.getPrimaryKey()) == null) {
				cacheResult(column);
			}
			else {
				column.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all columns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ColumnImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ColumnImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the column.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Column column) {
		EntityCacheUtil.removeResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnImpl.class, column.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(column);
	}

	@Override
	public void clearCache(List<Column> columns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Column column : columns) {
			EntityCacheUtil.removeResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
				ColumnImpl.class, column.getPrimaryKey());

			clearUniqueFindersCache(column);
		}
	}

	protected void cacheUniqueFindersCache(Column column) {
		if (column.isNew()) {
			Object[] args = new Object[] { column.getColumnID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLUMNID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNID, args,
				column);

			args = new Object[] { column.getColumn_name() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLUMNNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNNAME, args,
				column);
		}
		else {
			ColumnModelImpl columnModelImpl = (ColumnModelImpl)column;

			if ((columnModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLUMNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { column.getColumnID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLUMNID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNID, args,
					column);
			}

			if ((columnModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COLUMNNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { column.getColumn_name() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLUMNNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COLUMNNAME,
					args, column);
			}
		}
	}

	protected void clearUniqueFindersCache(Column column) {
		ColumnModelImpl columnModelImpl = (ColumnModelImpl)column;

		Object[] args = new Object[] { column.getColumnID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNID, args);

		if ((columnModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLUMNID.getColumnBitmask()) != 0) {
			args = new Object[] { columnModelImpl.getOriginalColumnID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNID, args);
		}

		args = new Object[] { column.getColumn_name() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNNAME, args);

		if ((columnModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COLUMNNAME.getColumnBitmask()) != 0) {
			args = new Object[] { columnModelImpl.getOriginalColumn_name() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COLUMNNAME, args);
		}
	}

	/**
	 * Creates a new column with the primary key. Does not add the column to the database.
	 *
	 * @param columnID the primary key for the new column
	 * @return the new column
	 */
	@Override
	public Column create(long columnID) {
		Column column = new ColumnImpl();

		column.setNew(true);
		column.setPrimaryKey(columnID);

		return column;
	}

	/**
	 * Removes the column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnID the primary key of the column
	 * @return the column that was removed
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column remove(long columnID)
		throws NoSuchColumnException, SystemException {
		return remove((Serializable)columnID);
	}

	/**
	 * Removes the column with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the column
	 * @return the column that was removed
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column remove(Serializable primaryKey)
		throws NoSuchColumnException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Column column = (Column)session.get(ColumnImpl.class, primaryKey);

			if (column == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(column);
		}
		catch (NoSuchColumnException nsee) {
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
	protected Column removeImpl(Column column) throws SystemException {
		column = toUnwrappedModel(column);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(column)) {
				column = (Column)session.get(ColumnImpl.class,
						column.getPrimaryKeyObj());
			}

			if (column != null) {
				session.delete(column);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (column != null) {
			clearCache(column);
		}

		return column;
	}

	@Override
	public Column updateImpl(org.gfbio.model.Column column)
		throws SystemException {
		column = toUnwrappedModel(column);

		boolean isNew = column.isNew();

		ColumnModelImpl columnModelImpl = (ColumnModelImpl)column;

		Session session = null;

		try {
			session = openSession();

			if (column.isNew()) {
				session.save(column);

				column.setNew(false);
			}
			else {
				session.merge(column);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ColumnModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((columnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { columnModelImpl.getOriginalHeadID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);

				args = new Object[] { columnModelImpl.getHeadID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);
			}

			if ((columnModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						columnModelImpl.getOriginalHeadID(),
						columnModelImpl.getOriginalColumn_name()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADIDANDCOLUMNNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME,
					args);

				args = new Object[] {
						columnModelImpl.getHeadID(),
						columnModelImpl.getColumn_name()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADIDANDCOLUMNNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADIDANDCOLUMNNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
			ColumnImpl.class, column.getPrimaryKey(), column);

		clearUniqueFindersCache(column);
		cacheUniqueFindersCache(column);

		return column;
	}

	protected Column toUnwrappedModel(Column column) {
		if (column instanceof ColumnImpl) {
			return column;
		}

		ColumnImpl columnImpl = new ColumnImpl();

		columnImpl.setNew(column.isNew());
		columnImpl.setPrimaryKey(column.getPrimaryKey());

		columnImpl.setColumnID(column.getColumnID());
		columnImpl.setHeadID(column.getHeadID());
		columnImpl.setColumn_name(column.getColumn_name());

		return columnImpl;
	}

	/**
	 * Returns the column with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the column
	 * @return the column
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByPrimaryKey(Serializable primaryKey)
		throws NoSuchColumnException, SystemException {
		Column column = fetchByPrimaryKey(primaryKey);

		if (column == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchColumnException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return column;
	}

	/**
	 * Returns the column with the primary key or throws a {@link org.gfbio.NoSuchColumnException} if it could not be found.
	 *
	 * @param columnID the primary key of the column
	 * @return the column
	 * @throws org.gfbio.NoSuchColumnException if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column findByPrimaryKey(long columnID)
		throws NoSuchColumnException, SystemException {
		return findByPrimaryKey((Serializable)columnID);
	}

	/**
	 * Returns the column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the column
	 * @return the column, or <code>null</code> if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Column column = (Column)EntityCacheUtil.getResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
				ColumnImpl.class, primaryKey);

		if (column == _nullColumn) {
			return null;
		}

		if (column == null) {
			Session session = null;

			try {
				session = openSession();

				column = (Column)session.get(ColumnImpl.class, primaryKey);

				if (column != null) {
					cacheResult(column);
				}
				else {
					EntityCacheUtil.putResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
						ColumnImpl.class, primaryKey, _nullColumn);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ColumnModelImpl.ENTITY_CACHE_ENABLED,
					ColumnImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return column;
	}

	/**
	 * Returns the column with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnID the primary key of the column
	 * @return the column, or <code>null</code> if a column with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Column fetchByPrimaryKey(long columnID) throws SystemException {
		return fetchByPrimaryKey((Serializable)columnID);
	}

	/**
	 * Returns all the columns.
	 *
	 * @return the columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @return the range of columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the columns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ColumnModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of columns
	 * @param end the upper bound of the range of columns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of columns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Column> findAll(int start, int end,
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

		List<Column> list = (List<Column>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COLUMN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COLUMN;

				if (pagination) {
					sql = sql.concat(ColumnModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Column>(list);
				}
				else {
					list = (List<Column>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the columns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Column column : findAll()) {
			remove(column);
		}
	}

	/**
	 * Returns the number of columns.
	 *
	 * @return the number of columns
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

				Query q = session.createQuery(_SQL_COUNT_COLUMN);

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
	 * Initializes the column persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Column")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Column>> listenersList = new ArrayList<ModelListener<Column>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Column>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ColumnImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COLUMN = "SELECT column FROM Column column";
	private static final String _SQL_SELECT_COLUMN_WHERE = "SELECT column FROM Column column WHERE ";
	private static final String _SQL_COUNT_COLUMN = "SELECT COUNT(column) FROM Column column";
	private static final String _SQL_COUNT_COLUMN_WHERE = "SELECT COUNT(column) FROM Column column WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "column.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Column exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Column exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ColumnPersistenceImpl.class);
	private static Column _nullColumn = new ColumnImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Column> toCacheModel() {
				return _nullColumnCacheModel;
			}
		};

	private static CacheModel<Column> _nullColumnCacheModel = new CacheModel<Column>() {
			@Override
			public Column toEntityModel() {
				return _nullColumn;
			}
		};
}