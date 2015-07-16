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

import org.gfbio.NoSuchPositionException;

import org.gfbio.model.Position;
import org.gfbio.model.impl.PositionImpl;
import org.gfbio.model.impl.PositionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PositionPersistence
 * @see PositionUtil
 * @generated
 */
public class PositionPersistenceImpl extends BasePersistenceImpl<Position>
	implements PositionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PositionUtil} to access the position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PositionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITIONID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPositionId",
			new String[] { Long.class.getName() },
			PositionModelImpl.POSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPositionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the position where positionID = &#63; or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	 *
	 * @param positionID the position i d
	 * @return the matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByPositionId(long positionID)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByPositionId(positionID);

		if (position == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("positionID=");
			msg.append(positionID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPositionException(msg.toString());
		}

		return position;
	}

	/**
	 * Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param positionID the position i d
	 * @return the matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByPositionId(long positionID)
		throws SystemException {
		return fetchByPositionId(positionID, true);
	}

	/**
	 * Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param positionID the position i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByPositionId(long positionID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { positionID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_POSITIONID,
					finderArgs, this);
		}

		if (result instanceof Position) {
			Position position = (Position)result;

			if ((positionID != position.getPositionID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(positionID);

				List<Position> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PositionPersistenceImpl.fetchByPositionId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Position position = list.get(0);

					result = position;

					cacheResult(position);

					if ((position.getPositionID() != positionID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONID,
							finderArgs, position);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONID,
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
			return (Position)result;
		}
	}

	/**
	 * Removes the position where positionID = &#63; from the database.
	 *
	 * @param positionID the position i d
	 * @return the position that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position removeByPositionId(long positionID)
		throws NoSuchPositionException, SystemException {
		Position position = findByPositionId(positionID);

		return remove(position);
	}

	/**
	 * Returns the number of positions where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @return the number of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPositionId(long positionID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONID;

		Object[] finderArgs = new Object[] { positionID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(positionID);

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

	private static final String _FINDER_COLUMN_POSITIONID_POSITIONID_2 = "position.positionID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TABLEIDS = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTableIds",
			new String[] { Long.class.getName(), Long.class.getName() },
			PositionModelImpl.COLUMNID_COLUMN_BITMASK |
			PositionModelImpl.ROWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TABLEIDS = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableIds",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the position where columnID = &#63; and rowID = &#63; or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByTableIds(long columnID, long rowID)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByTableIds(columnID, rowID);

		if (position == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnID=");
			msg.append(columnID);

			msg.append(", rowID=");
			msg.append(rowID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPositionException(msg.toString());
		}

		return position;
	}

	/**
	 * Returns the position where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByTableIds(long columnID, long rowID)
		throws SystemException {
		return fetchByTableIds(columnID, rowID, true);
	}

	/**
	 * Returns the position where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByTableIds(long columnID, long rowID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { columnID, rowID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TABLEIDS,
					finderArgs, this);
		}

		if (result instanceof Position) {
			Position position = (Position)result;

			if ((columnID != position.getColumnID()) ||
					(rowID != position.getRowID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_TABLEIDS_COLUMNID_2);

			query.append(_FINDER_COLUMN_TABLEIDS_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				qPos.add(rowID);

				List<Position> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PositionPersistenceImpl.fetchByTableIds(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Position position = list.get(0);

					result = position;

					cacheResult(position);

					if ((position.getColumnID() != columnID) ||
							(position.getRowID() != rowID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
							finderArgs, position);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS,
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
			return (Position)result;
		}
	}

	/**
	 * Removes the position where columnID = &#63; and rowID = &#63; from the database.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the position that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position removeByTableIds(long columnID, long rowID)
		throws NoSuchPositionException, SystemException {
		Position position = findByTableIds(columnID, rowID);

		return remove(position);
	}

	/**
	 * Returns the number of positions where columnID = &#63; and rowID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the number of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTableIds(long columnID, long rowID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TABLEIDS;

		Object[] finderArgs = new Object[] { columnID, rowID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_TABLEIDS_COLUMNID_2);

			query.append(_FINDER_COLUMN_TABLEIDS_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				qPos.add(rowID);

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

	private static final String _FINDER_COLUMN_TABLEIDS_COLUMNID_2 = "position.columnID = ? AND ";
	private static final String _FINDER_COLUMN_TABLEIDS_ROWID_2 = "position.rowID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHeadId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHeadId",
			new String[] { Long.class.getName() },
			PositionModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the positions where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByHeadId(long headID) throws SystemException {
		return findByHeadId(headID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the positions where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByHeadId(long headID, int start, int end)
		throws SystemException {
		return findByHeadId(headID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByHeadId(long headID, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if ((headID != position.getHeadID())) {
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

			query.append(_SQL_SELECT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first position in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByHeadId_First(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByHeadId_First(headID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByHeadId_First(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByHeadId(headID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByHeadId_Last(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByHeadId_Last(headID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByHeadId_Last(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHeadId(headID);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByHeadId(headID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where headID = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByHeadId_PrevAndNext(long positionID, long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByHeadId_PrevAndNext(session, position, headID,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByHeadId_PrevAndNext(session, position, headID,
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

	protected Position getByHeadId_PrevAndNext(Session session,
		Position position, long headID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POSITION_WHERE);

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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(headID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the positions where headID = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHeadId(long headID) throws SystemException {
		for (Position position : findByHeadId(headID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 = "position.headID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMNID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnId",
			new String[] { Long.class.getName() },
			PositionModelImpl.COLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMNID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the positions where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumnId(long columnID)
		throws SystemException {
		return findByColumnId(columnID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param columnID the column i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumnId(long columnID, int start, int end)
		throws SystemException {
		return findByColumnId(columnID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param columnID the column i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumnId(long columnID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID;
			finderArgs = new Object[] { columnID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMNID;
			finderArgs = new Object[] { columnID, start, end, orderByComparator };
		}

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if ((columnID != position.getColumnID())) {
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

			query.append(_SQL_SELECT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first position in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumnId_First(long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumnId_First(columnID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumnId_First(long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumnId(columnID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumnId_Last(long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumnId_Last(columnID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumnId_Last(long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumnId(columnID);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumnId(columnID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where columnID = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumnId_PrevAndNext(long positionID,
		long columnID, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumnId_PrevAndNext(session, position, columnID,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumnId_PrevAndNext(session, position, columnID,
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

	protected Position getByColumnId_PrevAndNext(Session session,
		Position position, long columnID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POSITION_WHERE);

		query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(columnID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the positions where columnID = &#63; from the database.
	 *
	 * @param columnID the column i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumnId(long columnID) throws SystemException {
		for (Position position : findByColumnId(columnID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMNID_COLUMNID_2 = "position.columnID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROWID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRowId",
			new String[] { Long.class.getName() },
			PositionModelImpl.ROWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROWID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRowId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the positions where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByRowId(long rowID) throws SystemException {
		return findByRowId(rowID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the positions where rowID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rowID the row i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByRowId(long rowID, int start, int end)
		throws SystemException {
		return findByRowId(rowID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where rowID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rowID the row i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByRowId(long rowID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID;
			finderArgs = new Object[] { rowID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROWID;
			finderArgs = new Object[] { rowID, start, end, orderByComparator };
		}

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if ((rowID != position.getRowID())) {
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

			query.append(_SQL_SELECT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_ROWID_ROWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowID);

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first position in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByRowId_First(long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByRowId_First(rowID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rowID=");
		msg.append(rowID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByRowId_First(long rowID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByRowId(rowID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByRowId_Last(long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByRowId_Last(rowID, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rowID=");
		msg.append(rowID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByRowId_Last(long rowID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRowId(rowID);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByRowId(rowID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where rowID = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByRowId_PrevAndNext(long positionID, long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByRowId_PrevAndNext(session, position, rowID,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByRowId_PrevAndNext(session, position, rowID,
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

	protected Position getByRowId_PrevAndNext(Session session,
		Position position, long rowID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POSITION_WHERE);

		query.append(_FINDER_COLUMN_ROWID_ROWID_2);

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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rowID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the positions where rowID = &#63; from the database.
	 *
	 * @param rowID the row i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRowId(long rowID) throws SystemException {
		for (Position position : findByRowId(rowID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @return the number of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRowId(long rowID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROWID;

		Object[] finderArgs = new Object[] { rowID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSITION_WHERE);

			query.append(_FINDER_COLUMN_ROWID_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowID);

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

	private static final String _FINDER_COLUMN_ROWID_ROWID_2 = "position.rowID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContent",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContent",
			new String[] { String.class.getName() },
			PositionModelImpl.CONTENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENT = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContent",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where content = &#63;.
	 *
	 * @param content the content
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContent(String content)
		throws SystemException {
		return findByContent(content, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the positions where content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContent(String content, int start, int end)
		throws SystemException {
		return findByContent(content, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContent(String content, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT;
			finderArgs = new Object[] { content };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENT;
			finderArgs = new Object[] { content, start, end, orderByComparator };
		}

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(content, position.getContent())) {
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

			query.append(_SQL_SELECT_POSITION_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first position in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByContent_First(String content,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByContent_First(content, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByContent_First(String content,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByContent(content, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByContent_Last(String content,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByContent_Last(content, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where content = &#63;.
	 *
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByContent_Last(String content,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContent(content);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByContent(content, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where content = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByContent_PrevAndNext(long positionID,
		String content, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByContent_PrevAndNext(session, position, content,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByContent_PrevAndNext(session, position, content,
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

	protected Position getByContent_PrevAndNext(Session session,
		Position position, String content, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POSITION_WHERE);

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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindContent) {
			qPos.add(content);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the positions where content = &#63; from the database.
	 *
	 * @param content the content
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContent(String content) throws SystemException {
		for (Position position : findByContent(content, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where content = &#63;.
	 *
	 * @param content the content
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_CONTENT_CONTENT_1 = "position.content IS NULL";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_2 = "position.content = ?";
	private static final String _FINDER_COLUMN_CONTENT_CONTENT_3 = "(position.content IS NULL OR position.content = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTOFCOLUMN =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContentOfColumn",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTOFCOLUMN =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentOfColumn",
			new String[] { String.class.getName(), Long.class.getName() },
			PositionModelImpl.CONTENT_COLUMN_BITMASK |
			PositionModelImpl.COLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTOFCOLUMN = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContentOfColumn",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the positions where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContentOfColumn(String content, long columnID)
		throws SystemException {
		return findByContentOfColumn(content, columnID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the positions where content = &#63; and columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContentOfColumn(String content, long columnID,
		int start, int end) throws SystemException {
		return findByContentOfColumn(content, columnID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where content = &#63; and columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByContentOfColumn(String content, long columnID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTOFCOLUMN;
			finderArgs = new Object[] { content, columnID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTOFCOLUMN;
			finderArgs = new Object[] {
					content, columnID,
					
					start, end, orderByComparator
				};
		}

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(content, position.getContent()) ||
						(columnID != position.getColumnID())) {
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

			query.append(_SQL_SELECT_POSITION_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_2);
			}

			query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_COLUMNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(columnID);

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first position in the ordered set where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByContentOfColumn_First(String content, long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByContentOfColumn_First(content, columnID,
				orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(", columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByContentOfColumn_First(String content, long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByContentOfColumn(content, columnID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByContentOfColumn_Last(String content, long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByContentOfColumn_Last(content, columnID,
				orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("content=");
		msg.append(content);

		msg.append(", columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByContentOfColumn_Last(String content, long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContentOfColumn(content, columnID);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByContentOfColumn(content, columnID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where content = &#63; and columnID = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param content the content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByContentOfColumn_PrevAndNext(long positionID,
		String content, long columnID, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByContentOfColumn_PrevAndNext(session, position,
					content, columnID, orderByComparator, true);

			array[1] = position;

			array[2] = getByContentOfColumn_PrevAndNext(session, position,
					content, columnID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Position getByContentOfColumn_PrevAndNext(Session session,
		Position position, String content, long columnID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_POSITION_WHERE);

		boolean bindContent = false;

		if (content == null) {
			query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_1);
		}
		else if (content.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_3);
		}
		else {
			bindContent = true;

			query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_2);
		}

		query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_COLUMNID_2);

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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindContent) {
			qPos.add(content);
		}

		qPos.add(columnID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the positions where content = &#63; and columnID = &#63; from the database.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContentOfColumn(String content, long columnID)
		throws SystemException {
		for (Position position : findByContentOfColumn(content, columnID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where content = &#63; and columnID = &#63;.
	 *
	 * @param content the content
	 * @param columnID the column i d
	 * @return the number of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContentOfColumn(String content, long columnID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTOFCOLUMN;

		Object[] finderArgs = new Object[] { content, columnID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_POSITION_WHERE);

			boolean bindContent = false;

			if (content == null) {
				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_1);
			}
			else if (content.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_3);
			}
			else {
				bindContent = true;

				query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_2);
			}

			query.append(_FINDER_COLUMN_CONTENTOFCOLUMN_COLUMNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContent) {
					qPos.add(content);
				}

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

	private static final String _FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_1 = "position.content IS NULL AND ";
	private static final String _FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_2 = "position.content = ? AND ";
	private static final String _FINDER_COLUMN_CONTENTOFCOLUMN_CONTENT_3 = "(position.content IS NULL OR position.content = '') AND ";
	private static final String _FINDER_COLUMN_CONTENTOFCOLUMN_COLUMNID_2 = "position.columnID = ?";

	public PositionPersistenceImpl() {
		setModelClass(Position.class);
	}

	/**
	 * Caches the position in the entity cache if it is enabled.
	 *
	 * @param position the position
	 */
	@Override
	public void cacheResult(Position position) {
		EntityCacheUtil.putResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionImpl.class, position.getPrimaryKey(), position);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONID,
			new Object[] { position.getPositionID() }, position);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
			new Object[] { position.getColumnID(), position.getRowID() },
			position);

		position.resetOriginalValues();
	}

	/**
	 * Caches the positions in the entity cache if it is enabled.
	 *
	 * @param positions the positions
	 */
	@Override
	public void cacheResult(List<Position> positions) {
		for (Position position : positions) {
			if (EntityCacheUtil.getResult(
						PositionModelImpl.ENTITY_CACHE_ENABLED,
						PositionImpl.class, position.getPrimaryKey()) == null) {
				cacheResult(position);
			}
			else {
				position.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all positions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PositionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PositionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the position.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Position position) {
		EntityCacheUtil.removeResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionImpl.class, position.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(position);
	}

	@Override
	public void clearCache(List<Position> positions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Position position : positions) {
			EntityCacheUtil.removeResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
				PositionImpl.class, position.getPrimaryKey());

			clearUniqueFindersCache(position);
		}
	}

	protected void cacheUniqueFindersCache(Position position) {
		if (position.isNew()) {
			Object[] args = new Object[] { position.getPositionID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONID, args,
				position);

			args = new Object[] { position.getColumnID(), position.getRowID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TABLEIDS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS, args,
				position);
		}
		else {
			PositionModelImpl positionModelImpl = (PositionModelImpl)position;

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_POSITIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { position.getPositionID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONID,
					args, position);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TABLEIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						position.getColumnID(), position.getRowID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TABLEIDS, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS, args,
					position);
			}
		}
	}

	protected void clearUniqueFindersCache(Position position) {
		PositionModelImpl positionModelImpl = (PositionModelImpl)position;

		Object[] args = new Object[] { position.getPositionID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONID, args);

		if ((positionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITIONID.getColumnBitmask()) != 0) {
			args = new Object[] { positionModelImpl.getOriginalPositionID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONID, args);
		}

		args = new Object[] { position.getColumnID(), position.getRowID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TABLEIDS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS, args);

		if ((positionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TABLEIDS.getColumnBitmask()) != 0) {
			args = new Object[] {
					positionModelImpl.getOriginalColumnID(),
					positionModelImpl.getOriginalRowID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TABLEIDS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS, args);
		}
	}

	/**
	 * Creates a new position with the primary key. Does not add the position to the database.
	 *
	 * @param positionID the primary key for the new position
	 * @return the new position
	 */
	@Override
	public Position create(long positionID) {
		Position position = new PositionImpl();

		position.setNew(true);
		position.setPrimaryKey(positionID);

		return position;
	}

	/**
	 * Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param positionID the primary key of the position
	 * @return the position that was removed
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position remove(long positionID)
		throws NoSuchPositionException, SystemException {
		return remove((Serializable)positionID);
	}

	/**
	 * Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the position
	 * @return the position that was removed
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position remove(Serializable primaryKey)
		throws NoSuchPositionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Position position = (Position)session.get(PositionImpl.class,
					primaryKey);

			if (position == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(position);
		}
		catch (NoSuchPositionException nsee) {
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
	protected Position removeImpl(Position position) throws SystemException {
		position = toUnwrappedModel(position);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(position)) {
				position = (Position)session.get(PositionImpl.class,
						position.getPrimaryKeyObj());
			}

			if (position != null) {
				session.delete(position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (position != null) {
			clearCache(position);
		}

		return position;
	}

	@Override
	public Position updateImpl(org.gfbio.model.Position position)
		throws SystemException {
		position = toUnwrappedModel(position);

		boolean isNew = position.isNew();

		PositionModelImpl positionModelImpl = (PositionModelImpl)position;

		Session session = null;

		try {
			session = openSession();

			if (position.isNew()) {
				session.save(position);

				position.setNew(false);
			}
			else {
				session.merge(position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PositionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalHeadID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);

				args = new Object[] { positionModelImpl.getHeadID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID,
					args);

				args = new Object[] { positionModelImpl.getColumnID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalRowID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROWID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID,
					args);

				args = new Object[] { positionModelImpl.getRowID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROWID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalContent()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT,
					args);

				args = new Object[] { positionModelImpl.getContent() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENT,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTOFCOLUMN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalContent(),
						positionModelImpl.getOriginalColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTOFCOLUMN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTOFCOLUMN,
					args);

				args = new Object[] {
						positionModelImpl.getContent(),
						positionModelImpl.getColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTOFCOLUMN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTOFCOLUMN,
					args);
			}
		}

		EntityCacheUtil.putResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionImpl.class, position.getPrimaryKey(), position);

		clearUniqueFindersCache(position);
		cacheUniqueFindersCache(position);

		return position;
	}

	protected Position toUnwrappedModel(Position position) {
		if (position instanceof PositionImpl) {
			return position;
		}

		PositionImpl positionImpl = new PositionImpl();

		positionImpl.setNew(position.isNew());
		positionImpl.setPrimaryKey(position.getPrimaryKey());

		positionImpl.setPositionID(position.getPositionID());
		positionImpl.setHeadID(position.getHeadID());
		positionImpl.setColumnID(position.getColumnID());
		positionImpl.setRowID(position.getRowID());
		positionImpl.setContent(position.getContent());

		return positionImpl;
	}

	/**
	 * Returns the position with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the position
	 * @return the position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByPrimaryKey(primaryKey);

		if (position == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return position;
	}

	/**
	 * Returns the position with the primary key or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	 *
	 * @param positionID the primary key of the position
	 * @return the position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByPrimaryKey(long positionID)
		throws NoSuchPositionException, SystemException {
		return findByPrimaryKey((Serializable)positionID);
	}

	/**
	 * Returns the position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the position
	 * @return the position, or <code>null</code> if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Position position = (Position)EntityCacheUtil.getResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
				PositionImpl.class, primaryKey);

		if (position == _nullPosition) {
			return null;
		}

		if (position == null) {
			Session session = null;

			try {
				session = openSession();

				position = (Position)session.get(PositionImpl.class, primaryKey);

				if (position != null) {
					cacheResult(position);
				}
				else {
					EntityCacheUtil.putResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
						PositionImpl.class, primaryKey, _nullPosition);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PositionModelImpl.ENTITY_CACHE_ENABLED,
					PositionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return position;
	}

	/**
	 * Returns the position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param positionID the primary key of the position
	 * @return the position, or <code>null</code> if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByPrimaryKey(long positionID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)positionID);
	}

	/**
	 * Returns all the positions.
	 *
	 * @return the positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findAll(int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_POSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSITION;

				if (pagination) {
					sql = sql.concat(PositionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Position>(list);
				}
				else {
					list = (List<Position>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the positions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Position position : findAll()) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions.
	 *
	 * @return the number of positions
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

				Query q = session.createQuery(_SQL_COUNT_POSITION);

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
	 * Initializes the position persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Position")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Position>> listenersList = new ArrayList<ModelListener<Position>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Position>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PositionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_POSITION = "SELECT position FROM Position position";
	private static final String _SQL_SELECT_POSITION_WHERE = "SELECT position FROM Position position WHERE ";
	private static final String _SQL_COUNT_POSITION = "SELECT COUNT(position) FROM Position position";
	private static final String _SQL_COUNT_POSITION_WHERE = "SELECT COUNT(position) FROM Position position WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "position.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Position exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Position exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PositionPersistenceImpl.class);
	private static Position _nullPosition = new PositionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Position> toCacheModel() {
				return _nullPositionCacheModel;
			}
		};

	private static CacheModel<Position> _nullPositionCacheModel = new CacheModel<Position>() {
			@Override
			public Position toEntityModel() {
				return _nullPosition;
			}
		};
}