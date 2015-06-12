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
 * @author Felicitas Loeffler
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
			FINDER_CLASS_NAME_ENTITY, "fetchByPositionID",
			new String[] { Long.class.getName() },
			PositionModelImpl.POSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPositionID",
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
	public Position findByPositionID(long positionID)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByPositionID(positionID);

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
	public Position fetchByPositionID(long positionID)
		throws SystemException {
		return fetchByPositionID(positionID, true);
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
	public Position fetchByPositionID(long positionID, boolean retrieveFromCache)
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
							"PositionPersistenceImpl.fetchByPositionID(long, boolean) with parameters (" +
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
	public Position removeByPositionID(long positionID)
		throws NoSuchPositionException, SystemException {
		Position position = findByPositionID(positionID);

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
	public int countByPositionID(long positionID) throws SystemException {
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHeadID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHeadID",
			new String[] { Long.class.getName() },
			PositionModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the positions where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByHeadID(long headID) throws SystemException {
		return findByHeadID(headID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Position> findByHeadID(long headID, int start, int end)
		throws SystemException {
		return findByHeadID(headID, start, end, null);
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
	public List<Position> findByHeadID(long headID, int start, int end,
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
	public Position findByHeadID_First(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByHeadID_First(headID, orderByComparator);

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
	public Position fetchByHeadID_First(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByHeadID(headID, 0, 1, orderByComparator);

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
	public Position findByHeadID_Last(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByHeadID_Last(headID, orderByComparator);

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
	public Position fetchByHeadID_Last(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHeadID(headID);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByHeadID(headID, count - 1, count,
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
	public Position[] findByHeadID_PrevAndNext(long positionID, long headID,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByHeadID_PrevAndNext(session, position, headID,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByHeadID_PrevAndNext(session, position, headID,
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

	protected Position getByHeadID_PrevAndNext(Session session,
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
	public void removeByHeadID(long headID) throws SystemException {
		for (Position position : findByHeadID(headID, QueryUtil.ALL_POS,
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
	public int countByHeadID(long headID) throws SystemException {
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN01 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn01",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn01",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN01_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN01 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn01",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn01(String column01)
		throws SystemException {
		return findByColumn01(column01, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column01 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column01 the column01
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn01(String column01, int start, int end)
		throws SystemException {
		return findByColumn01(column01, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column01 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column01 the column01
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn01(String column01, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column01, position.getColumn01())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn01_First(String column01,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn01_First(column01, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column01=");
		msg.append(column01);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn01_First(String column01,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn01(column01, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn01_Last(String column01,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn01_Last(column01, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column01=");
		msg.append(column01);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn01_Last(String column01,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn01(column01);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn01(column01, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column01 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column01 the column01
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn01_PrevAndNext(long positionID,
		String column01, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn01_PrevAndNext(session, position, column01,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn01_PrevAndNext(session, position, column01,
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

	protected Position getByColumn01_PrevAndNext(Session session,
		Position position, String column01,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column01 = &#63; from the database.
	 *
	 * @param column01 the column01
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn01(String column01) throws SystemException {
		for (Position position : findByColumn01(column01, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column01 = &#63;.
	 *
	 * @param column01 the column01
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_1 = "position.column01 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_2 = "position.column01 = ?";
	private static final String _FINDER_COLUMN_COLUMN01_COLUMN01_3 = "(position.column01 IS NULL OR position.column01 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN02 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn02",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn02",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN02_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN02 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn02",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn02(String column02)
		throws SystemException {
		return findByColumn02(column02, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column02 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column02 the column02
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn02(String column02, int start, int end)
		throws SystemException {
		return findByColumn02(column02, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column02 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column02 the column02
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn02(String column02, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column02, position.getColumn02())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn02_First(String column02,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn02_First(column02, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column02=");
		msg.append(column02);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn02_First(String column02,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn02(column02, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn02_Last(String column02,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn02_Last(column02, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column02=");
		msg.append(column02);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn02_Last(String column02,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn02(column02);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn02(column02, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column02 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column02 the column02
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn02_PrevAndNext(long positionID,
		String column02, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn02_PrevAndNext(session, position, column02,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn02_PrevAndNext(session, position, column02,
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

	protected Position getByColumn02_PrevAndNext(Session session,
		Position position, String column02,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column02 = &#63; from the database.
	 *
	 * @param column02 the column02
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn02(String column02) throws SystemException {
		for (Position position : findByColumn02(column02, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column02 = &#63;.
	 *
	 * @param column02 the column02
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_1 = "position.column02 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_2 = "position.column02 = ?";
	private static final String _FINDER_COLUMN_COLUMN02_COLUMN02_3 = "(position.column02 IS NULL OR position.column02 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN03 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn03",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn03",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN03_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN03 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn03",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn03(String column03)
		throws SystemException {
		return findByColumn03(column03, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column03 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column03 the column03
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn03(String column03, int start, int end)
		throws SystemException {
		return findByColumn03(column03, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column03 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column03 the column03
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn03(String column03, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column03, position.getColumn03())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn03_First(String column03,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn03_First(column03, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column03=");
		msg.append(column03);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn03_First(String column03,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn03(column03, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn03_Last(String column03,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn03_Last(column03, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column03=");
		msg.append(column03);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn03_Last(String column03,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn03(column03);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn03(column03, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column03 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column03 the column03
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn03_PrevAndNext(long positionID,
		String column03, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn03_PrevAndNext(session, position, column03,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn03_PrevAndNext(session, position, column03,
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

	protected Position getByColumn03_PrevAndNext(Session session,
		Position position, String column03,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column03 = &#63; from the database.
	 *
	 * @param column03 the column03
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn03(String column03) throws SystemException {
		for (Position position : findByColumn03(column03, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column03 = &#63;.
	 *
	 * @param column03 the column03
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_1 = "position.column03 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_2 = "position.column03 = ?";
	private static final String _FINDER_COLUMN_COLUMN03_COLUMN03_3 = "(position.column03 IS NULL OR position.column03 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN04 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn04",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn04",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN04_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN04 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn04",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn04(String column04)
		throws SystemException {
		return findByColumn04(column04, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column04 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column04 the column04
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn04(String column04, int start, int end)
		throws SystemException {
		return findByColumn04(column04, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column04 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column04 the column04
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn04(String column04, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column04, position.getColumn04())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn04_First(String column04,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn04_First(column04, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column04=");
		msg.append(column04);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn04_First(String column04,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn04(column04, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn04_Last(String column04,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn04_Last(column04, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column04=");
		msg.append(column04);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn04_Last(String column04,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn04(column04);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn04(column04, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column04 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column04 the column04
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn04_PrevAndNext(long positionID,
		String column04, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn04_PrevAndNext(session, position, column04,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn04_PrevAndNext(session, position, column04,
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

	protected Position getByColumn04_PrevAndNext(Session session,
		Position position, String column04,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column04 = &#63; from the database.
	 *
	 * @param column04 the column04
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn04(String column04) throws SystemException {
		for (Position position : findByColumn04(column04, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column04 = &#63;.
	 *
	 * @param column04 the column04
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_1 = "position.column04 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_2 = "position.column04 = ?";
	private static final String _FINDER_COLUMN_COLUMN04_COLUMN04_3 = "(position.column04 IS NULL OR position.column04 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN05 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn05",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn05",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN05_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN05 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn05",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn05(String column05)
		throws SystemException {
		return findByColumn05(column05, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column05 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column05 the column05
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn05(String column05, int start, int end)
		throws SystemException {
		return findByColumn05(column05, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column05 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column05 the column05
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn05(String column05, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column05, position.getColumn05())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn05_First(String column05,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn05_First(column05, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column05=");
		msg.append(column05);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn05_First(String column05,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn05(column05, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn05_Last(String column05,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn05_Last(column05, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column05=");
		msg.append(column05);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn05_Last(String column05,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn05(column05);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn05(column05, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column05 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column05 the column05
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn05_PrevAndNext(long positionID,
		String column05, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn05_PrevAndNext(session, position, column05,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn05_PrevAndNext(session, position, column05,
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

	protected Position getByColumn05_PrevAndNext(Session session,
		Position position, String column05,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column05 = &#63; from the database.
	 *
	 * @param column05 the column05
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn05(String column05) throws SystemException {
		for (Position position : findByColumn05(column05, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column05 = &#63;.
	 *
	 * @param column05 the column05
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_1 = "position.column05 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_2 = "position.column05 = ?";
	private static final String _FINDER_COLUMN_COLUMN05_COLUMN05_3 = "(position.column05 IS NULL OR position.column05 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN06 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn06",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn06",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN06_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN06 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn06",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn06(String column06)
		throws SystemException {
		return findByColumn06(column06, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column06 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column06 the column06
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn06(String column06, int start, int end)
		throws SystemException {
		return findByColumn06(column06, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column06 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column06 the column06
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn06(String column06, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column06, position.getColumn06())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn06_First(String column06,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn06_First(column06, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column06=");
		msg.append(column06);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn06_First(String column06,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn06(column06, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn06_Last(String column06,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn06_Last(column06, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column06=");
		msg.append(column06);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn06_Last(String column06,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn06(column06);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn06(column06, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column06 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column06 the column06
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn06_PrevAndNext(long positionID,
		String column06, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn06_PrevAndNext(session, position, column06,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn06_PrevAndNext(session, position, column06,
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

	protected Position getByColumn06_PrevAndNext(Session session,
		Position position, String column06,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column06 = &#63; from the database.
	 *
	 * @param column06 the column06
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn06(String column06) throws SystemException {
		for (Position position : findByColumn06(column06, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column06 = &#63;.
	 *
	 * @param column06 the column06
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_1 = "position.column06 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_2 = "position.column06 = ?";
	private static final String _FINDER_COLUMN_COLUMN06_COLUMN06_3 = "(position.column06 IS NULL OR position.column06 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN07 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn07",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn07",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN07_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN07 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn07",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn07(String column07)
		throws SystemException {
		return findByColumn07(column07, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column07 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column07 the column07
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn07(String column07, int start, int end)
		throws SystemException {
		return findByColumn07(column07, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column07 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column07 the column07
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn07(String column07, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column07, position.getColumn07())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn07_First(String column07,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn07_First(column07, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column07=");
		msg.append(column07);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn07_First(String column07,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn07(column07, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn07_Last(String column07,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn07_Last(column07, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column07=");
		msg.append(column07);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn07_Last(String column07,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn07(column07);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn07(column07, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column07 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column07 the column07
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn07_PrevAndNext(long positionID,
		String column07, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn07_PrevAndNext(session, position, column07,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn07_PrevAndNext(session, position, column07,
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

	protected Position getByColumn07_PrevAndNext(Session session,
		Position position, String column07,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column07 = &#63; from the database.
	 *
	 * @param column07 the column07
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn07(String column07) throws SystemException {
		for (Position position : findByColumn07(column07, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column07 = &#63;.
	 *
	 * @param column07 the column07
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_1 = "position.column07 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_2 = "position.column07 = ?";
	private static final String _FINDER_COLUMN_COLUMN07_COLUMN07_3 = "(position.column07 IS NULL OR position.column07 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN08 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn08",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn08",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN08_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN08 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn08",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn08(String column08)
		throws SystemException {
		return findByColumn08(column08, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column08 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column08 the column08
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn08(String column08, int start, int end)
		throws SystemException {
		return findByColumn08(column08, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column08 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column08 the column08
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn08(String column08, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column08, position.getColumn08())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn08_First(String column08,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn08_First(column08, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column08=");
		msg.append(column08);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn08_First(String column08,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn08(column08, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn08_Last(String column08,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn08_Last(column08, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column08=");
		msg.append(column08);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn08_Last(String column08,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn08(column08);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn08(column08, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column08 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column08 the column08
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn08_PrevAndNext(long positionID,
		String column08, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn08_PrevAndNext(session, position, column08,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn08_PrevAndNext(session, position, column08,
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

	protected Position getByColumn08_PrevAndNext(Session session,
		Position position, String column08,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column08 = &#63; from the database.
	 *
	 * @param column08 the column08
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn08(String column08) throws SystemException {
		for (Position position : findByColumn08(column08, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column08 = &#63;.
	 *
	 * @param column08 the column08
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_1 = "position.column08 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_2 = "position.column08 = ?";
	private static final String _FINDER_COLUMN_COLUMN08_COLUMN08_3 = "(position.column08 IS NULL OR position.column08 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN09 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn09",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn09",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN09_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN09 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn09",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn09(String column09)
		throws SystemException {
		return findByColumn09(column09, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column09 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column09 the column09
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn09(String column09, int start, int end)
		throws SystemException {
		return findByColumn09(column09, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column09 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column09 the column09
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn09(String column09, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column09, position.getColumn09())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn09_First(String column09,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn09_First(column09, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column09=");
		msg.append(column09);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn09_First(String column09,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn09(column09, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn09_Last(String column09,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn09_Last(column09, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column09=");
		msg.append(column09);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn09_Last(String column09,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn09(column09);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn09(column09, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column09 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column09 the column09
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn09_PrevAndNext(long positionID,
		String column09, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn09_PrevAndNext(session, position, column09,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn09_PrevAndNext(session, position, column09,
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

	protected Position getByColumn09_PrevAndNext(Session session,
		Position position, String column09,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column09 = &#63; from the database.
	 *
	 * @param column09 the column09
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn09(String column09) throws SystemException {
		for (Position position : findByColumn09(column09, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column09 = &#63;.
	 *
	 * @param column09 the column09
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_1 = "position.column09 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_2 = "position.column09 = ?";
	private static final String _FINDER_COLUMN_COLUMN09_COLUMN09_3 = "(position.column09 IS NULL OR position.column09 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN10 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn10",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn10",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN10_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN10 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn10",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn10(String column10)
		throws SystemException {
		return findByColumn10(column10, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column10 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column10 the column10
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn10(String column10, int start, int end)
		throws SystemException {
		return findByColumn10(column10, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column10 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column10 the column10
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn10(String column10, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column10, position.getColumn10())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn10_First(String column10,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn10_First(column10, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column10=");
		msg.append(column10);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn10_First(String column10,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn10(column10, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn10_Last(String column10,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn10_Last(column10, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column10=");
		msg.append(column10);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn10_Last(String column10,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn10(column10);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn10(column10, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column10 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column10 the column10
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn10_PrevAndNext(long positionID,
		String column10, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn10_PrevAndNext(session, position, column10,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn10_PrevAndNext(session, position, column10,
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

	protected Position getByColumn10_PrevAndNext(Session session,
		Position position, String column10,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column10 = &#63; from the database.
	 *
	 * @param column10 the column10
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn10(String column10) throws SystemException {
		for (Position position : findByColumn10(column10, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column10 = &#63;.
	 *
	 * @param column10 the column10
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_1 = "position.column10 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_2 = "position.column10 = ?";
	private static final String _FINDER_COLUMN_COLUMN10_COLUMN10_3 = "(position.column10 IS NULL OR position.column10 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN11 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn11",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn11",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN11_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN11 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn11",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn11(String column11)
		throws SystemException {
		return findByColumn11(column11, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column11 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column11 the column11
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn11(String column11, int start, int end)
		throws SystemException {
		return findByColumn11(column11, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column11 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column11 the column11
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn11(String column11, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column11, position.getColumn11())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn11_First(String column11,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn11_First(column11, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column11=");
		msg.append(column11);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn11_First(String column11,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn11(column11, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn11_Last(String column11,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn11_Last(column11, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column11=");
		msg.append(column11);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn11_Last(String column11,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn11(column11);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn11(column11, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column11 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column11 the column11
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn11_PrevAndNext(long positionID,
		String column11, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn11_PrevAndNext(session, position, column11,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn11_PrevAndNext(session, position, column11,
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

	protected Position getByColumn11_PrevAndNext(Session session,
		Position position, String column11,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column11 = &#63; from the database.
	 *
	 * @param column11 the column11
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn11(String column11) throws SystemException {
		for (Position position : findByColumn11(column11, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column11 = &#63;.
	 *
	 * @param column11 the column11
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_1 = "position.column11 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_2 = "position.column11 = ?";
	private static final String _FINDER_COLUMN_COLUMN11_COLUMN11_3 = "(position.column11 IS NULL OR position.column11 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN12 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn12",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn12",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN12_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN12 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn12",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn12(String column12)
		throws SystemException {
		return findByColumn12(column12, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column12 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column12 the column12
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn12(String column12, int start, int end)
		throws SystemException {
		return findByColumn12(column12, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column12 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column12 the column12
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn12(String column12, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column12, position.getColumn12())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn12_First(String column12,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn12_First(column12, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column12=");
		msg.append(column12);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn12_First(String column12,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn12(column12, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn12_Last(String column12,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn12_Last(column12, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column12=");
		msg.append(column12);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn12_Last(String column12,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn12(column12);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn12(column12, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column12 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column12 the column12
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn12_PrevAndNext(long positionID,
		String column12, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn12_PrevAndNext(session, position, column12,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn12_PrevAndNext(session, position, column12,
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

	protected Position getByColumn12_PrevAndNext(Session session,
		Position position, String column12,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column12 = &#63; from the database.
	 *
	 * @param column12 the column12
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn12(String column12) throws SystemException {
		for (Position position : findByColumn12(column12, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column12 = &#63;.
	 *
	 * @param column12 the column12
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_1 = "position.column12 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_2 = "position.column12 = ?";
	private static final String _FINDER_COLUMN_COLUMN12_COLUMN12_3 = "(position.column12 IS NULL OR position.column12 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN13 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn13",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn13",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN13_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN13 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn13",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn13(String column13)
		throws SystemException {
		return findByColumn13(column13, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column13 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column13 the column13
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn13(String column13, int start, int end)
		throws SystemException {
		return findByColumn13(column13, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column13 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column13 the column13
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn13(String column13, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column13, position.getColumn13())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn13_First(String column13,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn13_First(column13, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column13=");
		msg.append(column13);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn13_First(String column13,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn13(column13, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn13_Last(String column13,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn13_Last(column13, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column13=");
		msg.append(column13);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn13_Last(String column13,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn13(column13);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn13(column13, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column13 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column13 the column13
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn13_PrevAndNext(long positionID,
		String column13, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn13_PrevAndNext(session, position, column13,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn13_PrevAndNext(session, position, column13,
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

	protected Position getByColumn13_PrevAndNext(Session session,
		Position position, String column13,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column13 = &#63; from the database.
	 *
	 * @param column13 the column13
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn13(String column13) throws SystemException {
		for (Position position : findByColumn13(column13, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column13 = &#63;.
	 *
	 * @param column13 the column13
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_1 = "position.column13 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_2 = "position.column13 = ?";
	private static final String _FINDER_COLUMN_COLUMN13_COLUMN13_3 = "(position.column13 IS NULL OR position.column13 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN14 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn14",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn14",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN14_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN14 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn14",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn14(String column14)
		throws SystemException {
		return findByColumn14(column14, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column14 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column14 the column14
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn14(String column14, int start, int end)
		throws SystemException {
		return findByColumn14(column14, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column14 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column14 the column14
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn14(String column14, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column14, position.getColumn14())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn14_First(String column14,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn14_First(column14, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column14=");
		msg.append(column14);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn14_First(String column14,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn14(column14, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn14_Last(String column14,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn14_Last(column14, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column14=");
		msg.append(column14);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn14_Last(String column14,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn14(column14);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn14(column14, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column14 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column14 the column14
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn14_PrevAndNext(long positionID,
		String column14, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn14_PrevAndNext(session, position, column14,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn14_PrevAndNext(session, position, column14,
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

	protected Position getByColumn14_PrevAndNext(Session session,
		Position position, String column14,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column14 = &#63; from the database.
	 *
	 * @param column14 the column14
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn14(String column14) throws SystemException {
		for (Position position : findByColumn14(column14, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column14 = &#63;.
	 *
	 * @param column14 the column14
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_1 = "position.column14 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_2 = "position.column14 = ?";
	private static final String _FINDER_COLUMN_COLUMN14_COLUMN14_3 = "(position.column14 IS NULL OR position.column14 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN15 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn15",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn15",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN15_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN15 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn15",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn15(String column15)
		throws SystemException {
		return findByColumn15(column15, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column15 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column15 the column15
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn15(String column15, int start, int end)
		throws SystemException {
		return findByColumn15(column15, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column15 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column15 the column15
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn15(String column15, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column15, position.getColumn15())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn15_First(String column15,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn15_First(column15, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column15=");
		msg.append(column15);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn15_First(String column15,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn15(column15, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn15_Last(String column15,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn15_Last(column15, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column15=");
		msg.append(column15);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn15_Last(String column15,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn15(column15);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn15(column15, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column15 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column15 the column15
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn15_PrevAndNext(long positionID,
		String column15, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn15_PrevAndNext(session, position, column15,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn15_PrevAndNext(session, position, column15,
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

	protected Position getByColumn15_PrevAndNext(Session session,
		Position position, String column15,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column15 = &#63; from the database.
	 *
	 * @param column15 the column15
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn15(String column15) throws SystemException {
		for (Position position : findByColumn15(column15, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column15 = &#63;.
	 *
	 * @param column15 the column15
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_1 = "position.column15 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_2 = "position.column15 = ?";
	private static final String _FINDER_COLUMN_COLUMN15_COLUMN15_3 = "(position.column15 IS NULL OR position.column15 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN16 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn16",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn16",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN16_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN16 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn16",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn16(String column16)
		throws SystemException {
		return findByColumn16(column16, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column16 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column16 the column16
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn16(String column16, int start, int end)
		throws SystemException {
		return findByColumn16(column16, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column16 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column16 the column16
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn16(String column16, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column16, position.getColumn16())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn16_First(String column16,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn16_First(column16, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column16=");
		msg.append(column16);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn16_First(String column16,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn16(column16, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn16_Last(String column16,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn16_Last(column16, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column16=");
		msg.append(column16);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn16_Last(String column16,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn16(column16);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn16(column16, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column16 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column16 the column16
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn16_PrevAndNext(long positionID,
		String column16, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn16_PrevAndNext(session, position, column16,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn16_PrevAndNext(session, position, column16,
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

	protected Position getByColumn16_PrevAndNext(Session session,
		Position position, String column16,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column16 = &#63; from the database.
	 *
	 * @param column16 the column16
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn16(String column16) throws SystemException {
		for (Position position : findByColumn16(column16, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column16 = &#63;.
	 *
	 * @param column16 the column16
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_1 = "position.column16 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_2 = "position.column16 = ?";
	private static final String _FINDER_COLUMN_COLUMN16_COLUMN16_3 = "(position.column16 IS NULL OR position.column16 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN17 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn17",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn17",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN17_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN17 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn17",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn17(String column17)
		throws SystemException {
		return findByColumn17(column17, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column17 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column17 the column17
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn17(String column17, int start, int end)
		throws SystemException {
		return findByColumn17(column17, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column17 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column17 the column17
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn17(String column17, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column17, position.getColumn17())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn17_First(String column17,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn17_First(column17, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column17=");
		msg.append(column17);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn17_First(String column17,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn17(column17, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn17_Last(String column17,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn17_Last(column17, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column17=");
		msg.append(column17);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn17_Last(String column17,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn17(column17);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn17(column17, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column17 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column17 the column17
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn17_PrevAndNext(long positionID,
		String column17, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn17_PrevAndNext(session, position, column17,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn17_PrevAndNext(session, position, column17,
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

	protected Position getByColumn17_PrevAndNext(Session session,
		Position position, String column17,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column17 = &#63; from the database.
	 *
	 * @param column17 the column17
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn17(String column17) throws SystemException {
		for (Position position : findByColumn17(column17, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column17 = &#63;.
	 *
	 * @param column17 the column17
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_1 = "position.column17 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_2 = "position.column17 = ?";
	private static final String _FINDER_COLUMN_COLUMN17_COLUMN17_3 = "(position.column17 IS NULL OR position.column17 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN18 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn18",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn18",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN18_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN18 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn18",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn18(String column18)
		throws SystemException {
		return findByColumn18(column18, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column18 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column18 the column18
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn18(String column18, int start, int end)
		throws SystemException {
		return findByColumn18(column18, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column18 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column18 the column18
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn18(String column18, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column18, position.getColumn18())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn18_First(String column18,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn18_First(column18, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column18=");
		msg.append(column18);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn18_First(String column18,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn18(column18, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn18_Last(String column18,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn18_Last(column18, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column18=");
		msg.append(column18);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn18_Last(String column18,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn18(column18);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn18(column18, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column18 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column18 the column18
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn18_PrevAndNext(long positionID,
		String column18, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn18_PrevAndNext(session, position, column18,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn18_PrevAndNext(session, position, column18,
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

	protected Position getByColumn18_PrevAndNext(Session session,
		Position position, String column18,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column18 = &#63; from the database.
	 *
	 * @param column18 the column18
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn18(String column18) throws SystemException {
		for (Position position : findByColumn18(column18, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column18 = &#63;.
	 *
	 * @param column18 the column18
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_1 = "position.column18 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_2 = "position.column18 = ?";
	private static final String _FINDER_COLUMN_COLUMN18_COLUMN18_3 = "(position.column18 IS NULL OR position.column18 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN19 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn19",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn19",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN19_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN19 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn19",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn19(String column19)
		throws SystemException {
		return findByColumn19(column19, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column19 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column19 the column19
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn19(String column19, int start, int end)
		throws SystemException {
		return findByColumn19(column19, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column19 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column19 the column19
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn19(String column19, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column19, position.getColumn19())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn19_First(String column19,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn19_First(column19, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column19=");
		msg.append(column19);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn19_First(String column19,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn19(column19, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn19_Last(String column19,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn19_Last(column19, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column19=");
		msg.append(column19);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn19_Last(String column19,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn19(column19);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn19(column19, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column19 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column19 the column19
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn19_PrevAndNext(long positionID,
		String column19, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn19_PrevAndNext(session, position, column19,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn19_PrevAndNext(session, position, column19,
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

	protected Position getByColumn19_PrevAndNext(Session session,
		Position position, String column19,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column19 = &#63; from the database.
	 *
	 * @param column19 the column19
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn19(String column19) throws SystemException {
		for (Position position : findByColumn19(column19, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column19 = &#63;.
	 *
	 * @param column19 the column19
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_1 = "position.column19 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_2 = "position.column19 = ?";
	private static final String _FINDER_COLUMN_COLUMN19_COLUMN19_3 = "(position.column19 IS NULL OR position.column19 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMN20 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumn20",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20 =
		new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, PositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumn20",
			new String[] { String.class.getName() },
			PositionModelImpl.COLUMN20_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMN20 = new FinderPath(PositionModelImpl.ENTITY_CACHE_ENABLED,
			PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumn20",
			new String[] { String.class.getName() });

	/**
	 * Returns all the positions where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @return the matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn20(String column20)
		throws SystemException {
		return findByColumn20(column20, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the positions where column20 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column20 the column20
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn20(String column20, int start, int end)
		throws SystemException {
		return findByColumn20(column20, start, end, null);
	}

	/**
	 * Returns an ordered range of all the positions where column20 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param column20 the column20
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Position> findByColumn20(String column20, int start, int end,
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

		List<Position> list = (List<Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Position position : list) {
				if (!Validator.equals(column20, position.getColumn20())) {
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
				query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Returns the first position in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn20_First(String column20,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn20_First(column20, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column20=");
		msg.append(column20);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the first position in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn20_First(String column20,
		OrderByComparator orderByComparator) throws SystemException {
		List<Position> list = findByColumn20(column20, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position findByColumn20_Last(String column20,
		OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = fetchByColumn20_Last(column20, orderByComparator);

		if (position != null) {
			return position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("column20=");
		msg.append(column20);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPositionException(msg.toString());
	}

	/**
	 * Returns the last position in the ordered set where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position fetchByColumn20_Last(String column20,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumn20(column20);

		if (count == 0) {
			return null;
		}

		List<Position> list = findByColumn20(column20, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the positions before and after the current position in the ordered set where column20 = &#63;.
	 *
	 * @param positionID the primary key of the current position
	 * @param column20 the column20
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Position[] findByColumn20_PrevAndNext(long positionID,
		String column20, OrderByComparator orderByComparator)
		throws NoSuchPositionException, SystemException {
		Position position = findByPrimaryKey(positionID);

		Session session = null;

		try {
			session = openSession();

			Position[] array = new PositionImpl[3];

			array[0] = getByColumn20_PrevAndNext(session, position, column20,
					orderByComparator, true);

			array[1] = position;

			array[2] = getByColumn20_PrevAndNext(session, position, column20,
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

	protected Position getByColumn20_PrevAndNext(Session session,
		Position position, String column20,
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
			query.append(PositionModelImpl.ORDER_BY_JPQL);
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
	 * Removes all the positions where column20 = &#63; from the database.
	 *
	 * @param column20 the column20
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumn20(String column20) throws SystemException {
		for (Position position : findByColumn20(column20, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(position);
		}
	}

	/**
	 * Returns the number of positions where column20 = &#63;.
	 *
	 * @param column20 the column20
	 * @return the number of matching positions
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

			query.append(_SQL_COUNT_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_1 = "position.column20 IS NULL";
	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_2 = "position.column20 = ?";
	private static final String _FINDER_COLUMN_COLUMN20_COLUMN20_3 = "(position.column20 IS NULL OR position.column20 = '')";

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
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn01()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN01, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01,
					args);

				args = new Object[] { positionModelImpl.getColumn01() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN01, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN01,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn02()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN02, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02,
					args);

				args = new Object[] { positionModelImpl.getColumn02() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN02, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN02,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn03()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN03, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03,
					args);

				args = new Object[] { positionModelImpl.getColumn03() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN03, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN03,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn04()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN04, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04,
					args);

				args = new Object[] { positionModelImpl.getColumn04() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN04, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN04,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn05()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN05, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05,
					args);

				args = new Object[] { positionModelImpl.getColumn05() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN05, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN05,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn06()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN06, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06,
					args);

				args = new Object[] { positionModelImpl.getColumn06() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN06, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN06,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn07()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN07, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07,
					args);

				args = new Object[] { positionModelImpl.getColumn07() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN07, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN07,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn08()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN08, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08,
					args);

				args = new Object[] { positionModelImpl.getColumn08() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN08, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN08,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn09()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN09, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09,
					args);

				args = new Object[] { positionModelImpl.getColumn09() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN09, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN09,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn10()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN10, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10,
					args);

				args = new Object[] { positionModelImpl.getColumn10() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN10, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN10,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn11()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN11, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11,
					args);

				args = new Object[] { positionModelImpl.getColumn11() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN11, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN11,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn12()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN12, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12,
					args);

				args = new Object[] { positionModelImpl.getColumn12() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN12, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN12,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn13()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN13, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13,
					args);

				args = new Object[] { positionModelImpl.getColumn13() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN13, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN13,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn14()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN14, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14,
					args);

				args = new Object[] { positionModelImpl.getColumn14() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN14, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN14,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn15()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN15, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15,
					args);

				args = new Object[] { positionModelImpl.getColumn15() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN15, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN15,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn16()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN16, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16,
					args);

				args = new Object[] { positionModelImpl.getColumn16() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN16, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN16,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn17()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN17, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17,
					args);

				args = new Object[] { positionModelImpl.getColumn17() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN17, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN17,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn18()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN18, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18,
					args);

				args = new Object[] { positionModelImpl.getColumn18() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN18, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN18,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn19()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN19, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19,
					args);

				args = new Object[] { positionModelImpl.getColumn19() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN19, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN19,
					args);
			}

			if ((positionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionModelImpl.getOriginalColumn20()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN20, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20,
					args);

				args = new Object[] { positionModelImpl.getColumn20() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMN20, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMN20,
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
		positionImpl.setColumn01(position.getColumn01());
		positionImpl.setColumn02(position.getColumn02());
		positionImpl.setColumn03(position.getColumn03());
		positionImpl.setColumn04(position.getColumn04());
		positionImpl.setColumn05(position.getColumn05());
		positionImpl.setColumn06(position.getColumn06());
		positionImpl.setColumn07(position.getColumn07());
		positionImpl.setColumn08(position.getColumn08());
		positionImpl.setColumn09(position.getColumn09());
		positionImpl.setColumn10(position.getColumn10());
		positionImpl.setColumn11(position.getColumn11());
		positionImpl.setColumn12(position.getColumn12());
		positionImpl.setColumn13(position.getColumn13());
		positionImpl.setColumn14(position.getColumn14());
		positionImpl.setColumn15(position.getColumn15());
		positionImpl.setColumn16(position.getColumn16());
		positionImpl.setColumn17(position.getColumn17());
		positionImpl.setColumn18(position.getColumn18());
		positionImpl.setColumn19(position.getColumn19());
		positionImpl.setColumn20(position.getColumn20());

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