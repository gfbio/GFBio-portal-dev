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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchCell_PositionException;

import org.gfbio.model.Cell_Position;
import org.gfbio.model.impl.Cell_PositionImpl;
import org.gfbio.model.impl.Cell_PositionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cell_ position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_PositionPersistence
 * @see Cell_PositionUtil
 * @generated
 */
public class Cell_PositionPersistenceImpl extends BasePersistenceImpl<Cell_Position>
	implements Cell_PositionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Cell_PositionUtil} to access the cell_ position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Cell_PositionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLID = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCellId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID =
		new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCellId", new String[] { Long.class.getName() },
			Cell_PositionModelImpl.CELLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CELLID = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCellId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cell_ positions where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @return the matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByCellId(long cellID)
		throws SystemException {
		return findByCellId(cellID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ positions where cellID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellID the cell i d
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @return the range of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByCellId(long cellID, int start, int end)
		throws SystemException {
		return findByCellId(cellID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ positions where cellID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellID the cell i d
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByCellId(long cellID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID;
			finderArgs = new Object[] { cellID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLID;
			finderArgs = new Object[] { cellID, start, end, orderByComparator };
		}

		List<Cell_Position> list = (List<Cell_Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cell_Position cell_Position : list) {
				if ((cellID != cell_Position.getCellID())) {
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

			query.append(_SQL_SELECT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_CELLID_CELLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Cell_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

				if (!pagination) {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Position>(list);
				}
				else {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cell_ position in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByCellId_First(long cellID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByCellId_First(cellID,
				orderByComparator);

		if (cell_Position != null) {
			return cell_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellID=");
		msg.append(cellID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_PositionException(msg.toString());
	}

	/**
	 * Returns the first cell_ position in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByCellId_First(long cellID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cell_Position> list = findByCellId(cellID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cell_ position in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByCellId_Last(long cellID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByCellId_Last(cellID,
				orderByComparator);

		if (cell_Position != null) {
			return cell_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellID=");
		msg.append(cellID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_PositionException(msg.toString());
	}

	/**
	 * Returns the last cell_ position in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByCellId_Last(long cellID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCellId(cellID);

		if (count == 0) {
			return null;
		}

		List<Cell_Position> list = findByCellId(cellID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cell_ positions before and after the current cell_ position in the ordered set where cellID = &#63;.
	 *
	 * @param cell_PositionPK the primary key of the current cell_ position
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position[] findByCellId_PrevAndNext(
		Cell_PositionPK cell_PositionPK, long cellID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = findByPrimaryKey(cell_PositionPK);

		Session session = null;

		try {
			session = openSession();

			Cell_Position[] array = new Cell_PositionImpl[3];

			array[0] = getByCellId_PrevAndNext(session, cell_Position, cellID,
					orderByComparator, true);

			array[1] = cell_Position;

			array[2] = getByCellId_PrevAndNext(session, cell_Position, cellID,
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

	protected Cell_Position getByCellId_PrevAndNext(Session session,
		Cell_Position cell_Position, long cellID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CELL_POSITION_WHERE);

		query.append(_FINDER_COLUMN_CELLID_CELLID_2);

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
			query.append(Cell_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cellID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cell_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cell_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cell_ positions where cellID = &#63; from the database.
	 *
	 * @param cellID the cell i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCellId(long cellID) throws SystemException {
		for (Cell_Position cell_Position : findByCellId(cellID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cell_Position);
		}
	}

	/**
	 * Returns the number of cell_ positions where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @return the number of matching cell_ positions
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

			query.append(_SQL_COUNT_CELL_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_CELLID_CELLID_2 = "cell_Position.id.cellID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID =
		new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPositionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID =
		new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPositionId", new String[] { Long.class.getName() },
			Cell_PositionModelImpl.POSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPositionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cell_ positions where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @return the matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByPositionId(long positionID)
		throws SystemException {
		return findByPositionId(positionID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ positions where positionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param positionID the position i d
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @return the range of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByPositionId(long positionID, int start,
		int end) throws SystemException {
		return findByPositionId(positionID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ positions where positionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param positionID the position i d
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findByPositionId(long positionID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID;
			finderArgs = new Object[] { positionID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITIONID;
			finderArgs = new Object[] { positionID, start, end, orderByComparator };
		}

		List<Cell_Position> list = (List<Cell_Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cell_Position cell_Position : list) {
				if ((positionID != cell_Position.getPositionID())) {
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

			query.append(_SQL_SELECT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Cell_PositionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(positionID);

				if (!pagination) {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Position>(list);
				}
				else {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cell_ position in the ordered set where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByPositionId_First(long positionID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByPositionId_First(positionID,
				orderByComparator);

		if (cell_Position != null) {
			return cell_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("positionID=");
		msg.append(positionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_PositionException(msg.toString());
	}

	/**
	 * Returns the first cell_ position in the ordered set where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPositionId_First(long positionID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cell_Position> list = findByPositionId(positionID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cell_ position in the ordered set where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByPositionId_Last(long positionID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByPositionId_Last(positionID,
				orderByComparator);

		if (cell_Position != null) {
			return cell_Position;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("positionID=");
		msg.append(positionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_PositionException(msg.toString());
	}

	/**
	 * Returns the last cell_ position in the ordered set where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPositionId_Last(long positionID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPositionId(positionID);

		if (count == 0) {
			return null;
		}

		List<Cell_Position> list = findByPositionId(positionID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cell_ positions before and after the current cell_ position in the ordered set where positionID = &#63;.
	 *
	 * @param cell_PositionPK the primary key of the current cell_ position
	 * @param positionID the position i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position[] findByPositionId_PrevAndNext(
		Cell_PositionPK cell_PositionPK, long positionID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = findByPrimaryKey(cell_PositionPK);

		Session session = null;

		try {
			session = openSession();

			Cell_Position[] array = new Cell_PositionImpl[3];

			array[0] = getByPositionId_PrevAndNext(session, cell_Position,
					positionID, orderByComparator, true);

			array[1] = cell_Position;

			array[2] = getByPositionId_PrevAndNext(session, cell_Position,
					positionID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cell_Position getByPositionId_PrevAndNext(Session session,
		Cell_Position cell_Position, long positionID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CELL_POSITION_WHERE);

		query.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

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
			query.append(Cell_PositionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(positionID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cell_Position);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cell_Position> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cell_ positions where positionID = &#63; from the database.
	 *
	 * @param positionID the position i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPositionId(long positionID) throws SystemException {
		for (Cell_Position cell_Position : findByPositionId(positionID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cell_Position);
		}
	}

	/**
	 * Returns the number of cell_ positions where positionID = &#63;.
	 *
	 * @param positionID the position i d
	 * @return the number of matching cell_ positions
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

			query.append(_SQL_COUNT_CELL_POSITION_WHERE);

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

	private static final String _FINDER_COLUMN_POSITIONID_POSITIONID_2 = "cell_Position.id.positionID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() },
			Cell_PositionModelImpl.CELLID_COLUMN_BITMASK |
			Cell_PositionModelImpl.POSITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the cell_ position where cellID = &#63; and positionID = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	 *
	 * @param cellID the cell i d
	 * @param positionID the position i d
	 * @return the matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByfindByPrimaryKey(long cellID, long positionID)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByfindByPrimaryKey(cellID, positionID);

		if (cell_Position == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cellID=");
			msg.append(cellID);

			msg.append(", positionID=");
			msg.append(positionID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCell_PositionException(msg.toString());
		}

		return cell_Position;
	}

	/**
	 * Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cellID the cell i d
	 * @param positionID the position i d
	 * @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByfindByPrimaryKey(long cellID, long positionID)
		throws SystemException {
		return fetchByfindByPrimaryKey(cellID, positionID, true);
	}

	/**
	 * Returns the cell_ position where cellID = &#63; and positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cellID the cell i d
	 * @param positionID the position i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByfindByPrimaryKey(long cellID, long positionID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cellID, positionID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					finderArgs, this);
		}

		if (result instanceof Cell_Position) {
			Cell_Position cell_Position = (Cell_Position)result;

			if ((cellID != cell_Position.getCellID()) ||
					(positionID != cell_Position.getPositionID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_POSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

				qPos.add(positionID);

				List<Cell_Position> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Cell_PositionPersistenceImpl.fetchByfindByPrimaryKey(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell_Position cell_Position = list.get(0);

					result = cell_Position;

					cacheResult(cell_Position);

					if ((cell_Position.getCellID() != cellID) ||
							(cell_Position.getPositionID() != positionID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
							finderArgs, cell_Position);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
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
			return (Cell_Position)result;
		}
	}

	/**
	 * Removes the cell_ position where cellID = &#63; and positionID = &#63; from the database.
	 *
	 * @param cellID the cell i d
	 * @param positionID the position i d
	 * @return the cell_ position that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position removeByfindByPrimaryKey(long cellID, long positionID)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = findByfindByPrimaryKey(cellID, positionID);

		return remove(cell_Position);
	}

	/**
	 * Returns the number of cell_ positions where cellID = &#63; and positionID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param positionID the position i d
	 * @return the number of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByPrimaryKey(long cellID, long positionID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY;

		Object[] finderArgs = new Object[] { cellID, positionID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_POSITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

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

	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2 = "cell_Position.id.cellID = ? AND ";
	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_POSITIONID_2 = "cell_Position.id.positionID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED,
			Cell_PositionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPositionIdWithColumn",
			new String[] { Long.class.getName(), Integer.class.getName() },
			Cell_PositionModelImpl.POSITIONID_COLUMN_BITMASK |
			Cell_PositionModelImpl.COLUMN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN = new FinderPath(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPositionIdWithColumn",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the cell_ position where positionID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	 *
	 * @param positionID the position i d
	 * @param column the column
	 * @return the matching cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByPositionIdWithColumn(long positionID, int column)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByPositionIdWithColumn(positionID,
				column);

		if (cell_Position == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("positionID=");
			msg.append(positionID);

			msg.append(", column=");
			msg.append(column);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCell_PositionException(msg.toString());
		}

		return cell_Position;
	}

	/**
	 * Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param positionID the position i d
	 * @param column the column
	 * @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPositionIdWithColumn(long positionID, int column)
		throws SystemException {
		return fetchByPositionIdWithColumn(positionID, column, true);
	}

	/**
	 * Returns the cell_ position where positionID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param positionID the position i d
	 * @param column the column
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell_ position, or <code>null</code> if a matching cell_ position could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPositionIdWithColumn(long positionID,
		int column, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { positionID, column };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
					finderArgs, this);
		}

		if (result instanceof Cell_Position) {
			Cell_Position cell_Position = (Cell_Position)result;

			if ((positionID != cell_Position.getPositionID()) ||
					(column != cell_Position.getColumn())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_POSITIONIDWITHCOLUMN_POSITIONID_2);

			query.append(_FINDER_COLUMN_POSITIONIDWITHCOLUMN_COLUMN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(positionID);

				qPos.add(column);

				List<Cell_Position> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Cell_PositionPersistenceImpl.fetchByPositionIdWithColumn(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell_Position cell_Position = list.get(0);

					result = cell_Position;

					cacheResult(cell_Position);

					if ((cell_Position.getPositionID() != positionID) ||
							(cell_Position.getColumn() != column)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
							finderArgs, cell_Position);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
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
			return (Cell_Position)result;
		}
	}

	/**
	 * Removes the cell_ position where positionID = &#63; and column = &#63; from the database.
	 *
	 * @param positionID the position i d
	 * @param column the column
	 * @return the cell_ position that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position removeByPositionIdWithColumn(long positionID,
		int column) throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = findByPositionIdWithColumn(positionID,
				column);

		return remove(cell_Position);
	}

	/**
	 * Returns the number of cell_ positions where positionID = &#63; and column = &#63;.
	 *
	 * @param positionID the position i d
	 * @param column the column
	 * @return the number of matching cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPositionIdWithColumn(long positionID, int column)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN;

		Object[] finderArgs = new Object[] { positionID, column };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CELL_POSITION_WHERE);

			query.append(_FINDER_COLUMN_POSITIONIDWITHCOLUMN_POSITIONID_2);

			query.append(_FINDER_COLUMN_POSITIONIDWITHCOLUMN_COLUMN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(positionID);

				qPos.add(column);

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

	private static final String _FINDER_COLUMN_POSITIONIDWITHCOLUMN_POSITIONID_2 =
		"cell_Position.id.positionID = ? AND ";
	private static final String _FINDER_COLUMN_POSITIONIDWITHCOLUMN_COLUMN_2 = "cell_Position.column = ?";

	public Cell_PositionPersistenceImpl() {
		setModelClass(Cell_Position.class);
	}

	/**
	 * Caches the cell_ position in the entity cache if it is enabled.
	 *
	 * @param cell_Position the cell_ position
	 */
	@Override
	public void cacheResult(Cell_Position cell_Position) {
		EntityCacheUtil.putResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionImpl.class, cell_Position.getPrimaryKey(),
			cell_Position);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
			new Object[] {
				cell_Position.getCellID(), cell_Position.getPositionID()
			}, cell_Position);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
			new Object[] {
				cell_Position.getPositionID(), cell_Position.getColumn()
			}, cell_Position);

		cell_Position.resetOriginalValues();
	}

	/**
	 * Caches the cell_ positions in the entity cache if it is enabled.
	 *
	 * @param cell_Positions the cell_ positions
	 */
	@Override
	public void cacheResult(List<Cell_Position> cell_Positions) {
		for (Cell_Position cell_Position : cell_Positions) {
			if (EntityCacheUtil.getResult(
						Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
						Cell_PositionImpl.class, cell_Position.getPrimaryKey()) == null) {
				cacheResult(cell_Position);
			}
			else {
				cell_Position.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cell_ positions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Cell_PositionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Cell_PositionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cell_ position.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cell_Position cell_Position) {
		EntityCacheUtil.removeResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionImpl.class, cell_Position.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cell_Position);
	}

	@Override
	public void clearCache(List<Cell_Position> cell_Positions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cell_Position cell_Position : cell_Positions) {
			EntityCacheUtil.removeResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
				Cell_PositionImpl.class, cell_Position.getPrimaryKey());

			clearUniqueFindersCache(cell_Position);
		}
	}

	protected void cacheUniqueFindersCache(Cell_Position cell_Position) {
		if (cell_Position.isNew()) {
			Object[] args = new Object[] {
					cell_Position.getCellID(), cell_Position.getPositionID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args, cell_Position);

			args = new Object[] {
					cell_Position.getPositionID(), cell_Position.getColumn()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
				args, cell_Position);
		}
		else {
			Cell_PositionModelImpl cell_PositionModelImpl = (Cell_PositionModelImpl)cell_Position;

			if ((cell_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_Position.getCellID(), cell_Position.getPositionID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					args, cell_Position);
			}

			if ((cell_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_Position.getPositionID(), cell_Position.getColumn()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
					args, cell_Position);
			}
		}
	}

	protected void clearUniqueFindersCache(Cell_Position cell_Position) {
		Cell_PositionModelImpl cell_PositionModelImpl = (Cell_PositionModelImpl)cell_Position;

		Object[] args = new Object[] {
				cell_Position.getCellID(), cell_Position.getPositionID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY, args);

		if ((cell_PositionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					cell_PositionModelImpl.getOriginalCellID(),
					cell_PositionModelImpl.getOriginalPositionID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args);
		}

		args = new Object[] {
				cell_Position.getPositionID(), cell_Position.getColumn()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
			args);

		if ((cell_PositionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN.getColumnBitmask()) != 0) {
			args = new Object[] {
					cell_PositionModelImpl.getOriginalPositionID(),
					cell_PositionModelImpl.getOriginalColumn()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONIDWITHCOLUMN,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITIONIDWITHCOLUMN,
				args);
		}
	}

	/**
	 * Creates a new cell_ position with the primary key. Does not add the cell_ position to the database.
	 *
	 * @param cell_PositionPK the primary key for the new cell_ position
	 * @return the new cell_ position
	 */
	@Override
	public Cell_Position create(Cell_PositionPK cell_PositionPK) {
		Cell_Position cell_Position = new Cell_PositionImpl();

		cell_Position.setNew(true);
		cell_Position.setPrimaryKey(cell_PositionPK);

		return cell_Position;
	}

	/**
	 * Removes the cell_ position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cell_PositionPK the primary key of the cell_ position
	 * @return the cell_ position that was removed
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position remove(Cell_PositionPK cell_PositionPK)
		throws NoSuchCell_PositionException, SystemException {
		return remove((Serializable)cell_PositionPK);
	}

	/**
	 * Removes the cell_ position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cell_ position
	 * @return the cell_ position that was removed
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position remove(Serializable primaryKey)
		throws NoSuchCell_PositionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cell_Position cell_Position = (Cell_Position)session.get(Cell_PositionImpl.class,
					primaryKey);

			if (cell_Position == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCell_PositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cell_Position);
		}
		catch (NoSuchCell_PositionException nsee) {
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
	protected Cell_Position removeImpl(Cell_Position cell_Position)
		throws SystemException {
		cell_Position = toUnwrappedModel(cell_Position);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cell_Position)) {
				cell_Position = (Cell_Position)session.get(Cell_PositionImpl.class,
						cell_Position.getPrimaryKeyObj());
			}

			if (cell_Position != null) {
				session.delete(cell_Position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cell_Position != null) {
			clearCache(cell_Position);
		}

		return cell_Position;
	}

	@Override
	public Cell_Position updateImpl(org.gfbio.model.Cell_Position cell_Position)
		throws SystemException {
		cell_Position = toUnwrappedModel(cell_Position);

		boolean isNew = cell_Position.isNew();

		Cell_PositionModelImpl cell_PositionModelImpl = (Cell_PositionModelImpl)cell_Position;

		Session session = null;

		try {
			session = openSession();

			if (cell_Position.isNew()) {
				session.save(cell_Position);

				cell_Position.setNew(false);
			}
			else {
				session.merge(cell_Position);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Cell_PositionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cell_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_PositionModelImpl.getOriginalCellID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID,
					args);

				args = new Object[] { cell_PositionModelImpl.getCellID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID,
					args);
			}

			if ((cell_PositionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_PositionModelImpl.getOriginalPositionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
					args);

				args = new Object[] { cell_PositionModelImpl.getPositionID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POSITIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
			Cell_PositionImpl.class, cell_Position.getPrimaryKey(),
			cell_Position);

		clearUniqueFindersCache(cell_Position);
		cacheUniqueFindersCache(cell_Position);

		return cell_Position;
	}

	protected Cell_Position toUnwrappedModel(Cell_Position cell_Position) {
		if (cell_Position instanceof Cell_PositionImpl) {
			return cell_Position;
		}

		Cell_PositionImpl cell_PositionImpl = new Cell_PositionImpl();

		cell_PositionImpl.setNew(cell_Position.isNew());
		cell_PositionImpl.setPrimaryKey(cell_Position.getPrimaryKey());

		cell_PositionImpl.setCellID(cell_Position.getCellID());
		cell_PositionImpl.setPositionID(cell_Position.getPositionID());
		cell_PositionImpl.setColumn(cell_Position.getColumn());

		return cell_PositionImpl;
	}

	/**
	 * Returns the cell_ position with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell_ position
	 * @return the cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCell_PositionException, SystemException {
		Cell_Position cell_Position = fetchByPrimaryKey(primaryKey);

		if (cell_Position == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCell_PositionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cell_Position;
	}

	/**
	 * Returns the cell_ position with the primary key or throws a {@link org.gfbio.NoSuchCell_PositionException} if it could not be found.
	 *
	 * @param cell_PositionPK the primary key of the cell_ position
	 * @return the cell_ position
	 * @throws org.gfbio.NoSuchCell_PositionException if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position findByPrimaryKey(Cell_PositionPK cell_PositionPK)
		throws NoSuchCell_PositionException, SystemException {
		return findByPrimaryKey((Serializable)cell_PositionPK);
	}

	/**
	 * Returns the cell_ position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell_ position
	 * @return the cell_ position, or <code>null</code> if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cell_Position cell_Position = (Cell_Position)EntityCacheUtil.getResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
				Cell_PositionImpl.class, primaryKey);

		if (cell_Position == _nullCell_Position) {
			return null;
		}

		if (cell_Position == null) {
			Session session = null;

			try {
				session = openSession();

				cell_Position = (Cell_Position)session.get(Cell_PositionImpl.class,
						primaryKey);

				if (cell_Position != null) {
					cacheResult(cell_Position);
				}
				else {
					EntityCacheUtil.putResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
						Cell_PositionImpl.class, primaryKey, _nullCell_Position);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Cell_PositionModelImpl.ENTITY_CACHE_ENABLED,
					Cell_PositionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cell_Position;
	}

	/**
	 * Returns the cell_ position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cell_PositionPK the primary key of the cell_ position
	 * @return the cell_ position, or <code>null</code> if a cell_ position with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Position fetchByPrimaryKey(Cell_PositionPK cell_PositionPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)cell_PositionPK);
	}

	/**
	 * Returns all the cell_ positions.
	 *
	 * @return the cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @return the range of cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cell_ positions
	 * @param end the upper bound of the range of cell_ positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cell_ positions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Position> findAll(int start, int end,
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

		List<Cell_Position> list = (List<Cell_Position>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CELL_POSITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CELL_POSITION;

				if (pagination) {
					sql = sql.concat(Cell_PositionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Position>(list);
				}
				else {
					list = (List<Cell_Position>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cell_ positions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cell_Position cell_Position : findAll()) {
			remove(cell_Position);
		}
	}

	/**
	 * Returns the number of cell_ positions.
	 *
	 * @return the number of cell_ positions
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

				Query q = session.createQuery(_SQL_COUNT_CELL_POSITION);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the cell_ position persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Cell_Position")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cell_Position>> listenersList = new ArrayList<ModelListener<Cell_Position>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cell_Position>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Cell_PositionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CELL_POSITION = "SELECT cell_Position FROM Cell_Position cell_Position";
	private static final String _SQL_SELECT_CELL_POSITION_WHERE = "SELECT cell_Position FROM Cell_Position cell_Position WHERE ";
	private static final String _SQL_COUNT_CELL_POSITION = "SELECT COUNT(cell_Position) FROM Cell_Position cell_Position";
	private static final String _SQL_COUNT_CELL_POSITION_WHERE = "SELECT COUNT(cell_Position) FROM Cell_Position cell_Position WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cell_Position.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cell_Position exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cell_Position exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Cell_PositionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"column"
			});
	private static Cell_Position _nullCell_Position = new Cell_PositionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cell_Position> toCacheModel() {
				return _nullCell_PositionCacheModel;
			}
		};

	private static CacheModel<Cell_Position> _nullCell_PositionCacheModel = new CacheModel<Cell_Position>() {
			@Override
			public Cell_Position toEntityModel() {
				return _nullCell_Position;
			}
		};
}