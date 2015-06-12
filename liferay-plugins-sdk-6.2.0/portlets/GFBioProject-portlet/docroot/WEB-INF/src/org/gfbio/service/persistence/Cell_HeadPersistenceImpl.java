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

import org.gfbio.NoSuchCell_HeadException;

import org.gfbio.model.Cell_Head;
import org.gfbio.model.impl.Cell_HeadImpl;
import org.gfbio.model.impl.Cell_HeadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the cell_ head service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Cell_HeadPersistence
 * @see Cell_HeadUtil
 * @generated
 */
public class Cell_HeadPersistenceImpl extends BasePersistenceImpl<Cell_Head>
	implements Cell_HeadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Cell_HeadUtil} to access the cell_ head persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Cell_HeadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLID = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCellId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID =
		new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCellId",
			new String[] { Long.class.getName() },
			Cell_HeadModelImpl.CELLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CELLID = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCellId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cell_ heads where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @return the matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByCellId(long cellID) throws SystemException {
		return findByCellId(cellID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ heads where cellID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellID the cell i d
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @return the range of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByCellId(long cellID, int start, int end)
		throws SystemException {
		return findByCellId(cellID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ heads where cellID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellID the cell i d
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByCellId(long cellID, int start, int end,
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

		List<Cell_Head> list = (List<Cell_Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cell_Head cell_Head : list) {
				if ((cellID != cell_Head.getCellID())) {
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

			query.append(_SQL_SELECT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_CELLID_CELLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Cell_HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

				if (!pagination) {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Head>(list);
				}
				else {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cell_ head in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByCellId_First(long cellID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByCellId_First(cellID, orderByComparator);

		if (cell_Head != null) {
			return cell_Head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellID=");
		msg.append(cellID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_HeadException(msg.toString());
	}

	/**
	 * Returns the first cell_ head in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByCellId_First(long cellID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cell_Head> list = findByCellId(cellID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cell_ head in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByCellId_Last(long cellID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByCellId_Last(cellID, orderByComparator);

		if (cell_Head != null) {
			return cell_Head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellID=");
		msg.append(cellID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_HeadException(msg.toString());
	}

	/**
	 * Returns the last cell_ head in the ordered set where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByCellId_Last(long cellID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCellId(cellID);

		if (count == 0) {
			return null;
		}

		List<Cell_Head> list = findByCellId(cellID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cell_ heads before and after the current cell_ head in the ordered set where cellID = &#63;.
	 *
	 * @param cell_HeadPK the primary key of the current cell_ head
	 * @param cellID the cell i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head[] findByCellId_PrevAndNext(Cell_HeadPK cell_HeadPK,
		long cellID, OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = findByPrimaryKey(cell_HeadPK);

		Session session = null;

		try {
			session = openSession();

			Cell_Head[] array = new Cell_HeadImpl[3];

			array[0] = getByCellId_PrevAndNext(session, cell_Head, cellID,
					orderByComparator, true);

			array[1] = cell_Head;

			array[2] = getByCellId_PrevAndNext(session, cell_Head, cellID,
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

	protected Cell_Head getByCellId_PrevAndNext(Session session,
		Cell_Head cell_Head, long cellID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CELL_HEAD_WHERE);

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
			query.append(Cell_HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cellID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cell_Head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cell_Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cell_ heads where cellID = &#63; from the database.
	 *
	 * @param cellID the cell i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCellId(long cellID) throws SystemException {
		for (Cell_Head cell_Head : findByCellId(cellID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cell_Head);
		}
	}

	/**
	 * Returns the number of cell_ heads where cellID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @return the number of matching cell_ heads
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

			query.append(_SQL_COUNT_CELL_HEAD_WHERE);

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

	private static final String _FINDER_COLUMN_CELLID_CELLID_2 = "cell_Head.id.cellID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHeadId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID =
		new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHeadId",
			new String[] { Long.class.getName() },
			Cell_HeadModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cell_ heads where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByHeadId(long headID) throws SystemException {
		return findByHeadId(headID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ heads where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @return the range of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByHeadId(long headID, int start, int end)
		throws SystemException {
		return findByHeadId(headID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ heads where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findByHeadId(long headID, int start, int end,
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

		List<Cell_Head> list = (List<Cell_Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Cell_Head cell_Head : list) {
				if ((headID != cell_Head.getHeadID())) {
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

			query.append(_SQL_SELECT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Cell_HeadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (!pagination) {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Head>(list);
				}
				else {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cell_ head in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByHeadId_First(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByHeadId_First(headID, orderByComparator);

		if (cell_Head != null) {
			return cell_Head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_HeadException(msg.toString());
	}

	/**
	 * Returns the first cell_ head in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByHeadId_First(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Cell_Head> list = findByHeadId(headID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cell_ head in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByHeadId_Last(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByHeadId_Last(headID, orderByComparator);

		if (cell_Head != null) {
			return cell_Head;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCell_HeadException(msg.toString());
	}

	/**
	 * Returns the last cell_ head in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByHeadId_Last(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHeadId(headID);

		if (count == 0) {
			return null;
		}

		List<Cell_Head> list = findByHeadId(headID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cell_ heads before and after the current cell_ head in the ordered set where headID = &#63;.
	 *
	 * @param cell_HeadPK the primary key of the current cell_ head
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head[] findByHeadId_PrevAndNext(Cell_HeadPK cell_HeadPK,
		long headID, OrderByComparator orderByComparator)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = findByPrimaryKey(cell_HeadPK);

		Session session = null;

		try {
			session = openSession();

			Cell_Head[] array = new Cell_HeadImpl[3];

			array[0] = getByHeadId_PrevAndNext(session, cell_Head, headID,
					orderByComparator, true);

			array[1] = cell_Head;

			array[2] = getByHeadId_PrevAndNext(session, cell_Head, headID,
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

	protected Cell_Head getByHeadId_PrevAndNext(Session session,
		Cell_Head cell_Head, long headID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CELL_HEAD_WHERE);

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
			query.append(Cell_HeadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(headID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cell_Head);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Cell_Head> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cell_ heads where headID = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHeadId(long headID) throws SystemException {
		for (Cell_Head cell_Head : findByHeadId(headID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cell_Head);
		}
	}

	/**
	 * Returns the number of cell_ heads where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the number of matching cell_ heads
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

			query.append(_SQL_COUNT_CELL_HEAD_WHERE);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 = "cell_Head.id.headID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() },
			Cell_HeadModelImpl.CELLID_COLUMN_BITMASK |
			Cell_HeadModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the cell_ head where cellID = &#63; and headID = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	 *
	 * @param cellID the cell i d
	 * @param headID the head i d
	 * @return the matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByfindByPrimaryKey(long cellID, long headID)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByfindByPrimaryKey(cellID, headID);

		if (cell_Head == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cellID=");
			msg.append(cellID);

			msg.append(", headID=");
			msg.append(headID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCell_HeadException(msg.toString());
		}

		return cell_Head;
	}

	/**
	 * Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cellID the cell i d
	 * @param headID the head i d
	 * @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByfindByPrimaryKey(long cellID, long headID)
		throws SystemException {
		return fetchByfindByPrimaryKey(cellID, headID, true);
	}

	/**
	 * Returns the cell_ head where cellID = &#63; and headID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cellID the cell i d
	 * @param headID the head i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByfindByPrimaryKey(long cellID, long headID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { cellID, headID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					finderArgs, this);
		}

		if (result instanceof Cell_Head) {
			Cell_Head cell_Head = (Cell_Head)result;

			if ((cellID != cell_Head.getCellID()) ||
					(headID != cell_Head.getHeadID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_HEADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

				qPos.add(headID);

				List<Cell_Head> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Cell_HeadPersistenceImpl.fetchByfindByPrimaryKey(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell_Head cell_Head = list.get(0);

					result = cell_Head;

					cacheResult(cell_Head);

					if ((cell_Head.getCellID() != cellID) ||
							(cell_Head.getHeadID() != headID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
							finderArgs, cell_Head);
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
			return (Cell_Head)result;
		}
	}

	/**
	 * Removes the cell_ head where cellID = &#63; and headID = &#63; from the database.
	 *
	 * @param cellID the cell i d
	 * @param headID the head i d
	 * @return the cell_ head that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head removeByfindByPrimaryKey(long cellID, long headID)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = findByfindByPrimaryKey(cellID, headID);

		return remove(cell_Head);
	}

	/**
	 * Returns the number of cell_ heads where cellID = &#63; and headID = &#63;.
	 *
	 * @param cellID the cell i d
	 * @param headID the head i d
	 * @return the number of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByPrimaryKey(long cellID, long headID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY;

		Object[] finderArgs = new Object[] { cellID, headID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_HEADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cellID);

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

	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_CELLID_2 = "cell_Head.id.cellID = ? AND ";
	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_HEADID_2 = "cell_Head.id.headID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Cell_HeadImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByHeadIdWithColumn",
			new String[] { Long.class.getName(), Integer.class.getName() },
			Cell_HeadModelImpl.HEADID_COLUMN_BITMASK |
			Cell_HeadModelImpl.COLUMN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN = new FinderPath(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByHeadIdWithColumn",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the cell_ head where headID = &#63; and column = &#63; or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	 *
	 * @param headID the head i d
	 * @param column the column
	 * @return the matching cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByHeadIdWithColumn(long headID, int column)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByHeadIdWithColumn(headID, column);

		if (cell_Head == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("headID=");
			msg.append(headID);

			msg.append(", column=");
			msg.append(column);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCell_HeadException(msg.toString());
		}

		return cell_Head;
	}

	/**
	 * Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param headID the head i d
	 * @param column the column
	 * @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByHeadIdWithColumn(long headID, int column)
		throws SystemException {
		return fetchByHeadIdWithColumn(headID, column, true);
	}

	/**
	 * Returns the cell_ head where headID = &#63; and column = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param headID the head i d
	 * @param column the column
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cell_ head, or <code>null</code> if a matching cell_ head could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByHeadIdWithColumn(long headID, int column,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { headID, column };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
					finderArgs, this);
		}

		if (result instanceof Cell_Head) {
			Cell_Head cell_Head = (Cell_Head)result;

			if ((headID != cell_Head.getHeadID()) ||
					(column != cell_Head.getColumn())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_HEADIDWITHCOLUMN_HEADID_2);

			query.append(_FINDER_COLUMN_HEADIDWITHCOLUMN_COLUMN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				qPos.add(column);

				List<Cell_Head> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Cell_HeadPersistenceImpl.fetchByHeadIdWithColumn(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Cell_Head cell_Head = list.get(0);

					result = cell_Head;

					cacheResult(cell_Head);

					if ((cell_Head.getHeadID() != headID) ||
							(cell_Head.getColumn() != column)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
							finderArgs, cell_Head);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
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
			return (Cell_Head)result;
		}
	}

	/**
	 * Removes the cell_ head where headID = &#63; and column = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @param column the column
	 * @return the cell_ head that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head removeByHeadIdWithColumn(long headID, int column)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = findByHeadIdWithColumn(headID, column);

		return remove(cell_Head);
	}

	/**
	 * Returns the number of cell_ heads where headID = &#63; and column = &#63;.
	 *
	 * @param headID the head i d
	 * @param column the column
	 * @return the number of matching cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHeadIdWithColumn(long headID, int column)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN;

		Object[] finderArgs = new Object[] { headID, column };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CELL_HEAD_WHERE);

			query.append(_FINDER_COLUMN_HEADIDWITHCOLUMN_HEADID_2);

			query.append(_FINDER_COLUMN_HEADIDWITHCOLUMN_COLUMN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

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

	private static final String _FINDER_COLUMN_HEADIDWITHCOLUMN_HEADID_2 = "cell_Head.id.headID = ? AND ";
	private static final String _FINDER_COLUMN_HEADIDWITHCOLUMN_COLUMN_2 = "cell_Head.column = ?";

	public Cell_HeadPersistenceImpl() {
		setModelClass(Cell_Head.class);
	}

	/**
	 * Caches the cell_ head in the entity cache if it is enabled.
	 *
	 * @param cell_Head the cell_ head
	 */
	@Override
	public void cacheResult(Cell_Head cell_Head) {
		EntityCacheUtil.putResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadImpl.class, cell_Head.getPrimaryKey(), cell_Head);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
			new Object[] { cell_Head.getCellID(), cell_Head.getHeadID() },
			cell_Head);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
			new Object[] { cell_Head.getHeadID(), cell_Head.getColumn() },
			cell_Head);

		cell_Head.resetOriginalValues();
	}

	/**
	 * Caches the cell_ heads in the entity cache if it is enabled.
	 *
	 * @param cell_Heads the cell_ heads
	 */
	@Override
	public void cacheResult(List<Cell_Head> cell_Heads) {
		for (Cell_Head cell_Head : cell_Heads) {
			if (EntityCacheUtil.getResult(
						Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
						Cell_HeadImpl.class, cell_Head.getPrimaryKey()) == null) {
				cacheResult(cell_Head);
			}
			else {
				cell_Head.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cell_ heads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Cell_HeadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Cell_HeadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cell_ head.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cell_Head cell_Head) {
		EntityCacheUtil.removeResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadImpl.class, cell_Head.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(cell_Head);
	}

	@Override
	public void clearCache(List<Cell_Head> cell_Heads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cell_Head cell_Head : cell_Heads) {
			EntityCacheUtil.removeResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
				Cell_HeadImpl.class, cell_Head.getPrimaryKey());

			clearUniqueFindersCache(cell_Head);
		}
	}

	protected void cacheUniqueFindersCache(Cell_Head cell_Head) {
		if (cell_Head.isNew()) {
			Object[] args = new Object[] {
					cell_Head.getCellID(), cell_Head.getHeadID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args, cell_Head);

			args = new Object[] { cell_Head.getHeadID(), cell_Head.getColumn() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
				args, cell_Head);
		}
		else {
			Cell_HeadModelImpl cell_HeadModelImpl = (Cell_HeadModelImpl)cell_Head;

			if ((cell_HeadModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_Head.getCellID(), cell_Head.getHeadID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					args, cell_Head);
			}

			if ((cell_HeadModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_Head.getHeadID(), cell_Head.getColumn()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
					args, cell_Head);
			}
		}
	}

	protected void clearUniqueFindersCache(Cell_Head cell_Head) {
		Cell_HeadModelImpl cell_HeadModelImpl = (Cell_HeadModelImpl)cell_Head;

		Object[] args = new Object[] {
				cell_Head.getCellID(), cell_Head.getHeadID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY, args);

		if ((cell_HeadModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					cell_HeadModelImpl.getOriginalCellID(),
					cell_HeadModelImpl.getOriginalHeadID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args);
		}

		args = new Object[] { cell_Head.getHeadID(), cell_Head.getColumn() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN, args);

		if ((cell_HeadModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN.getColumnBitmask()) != 0) {
			args = new Object[] {
					cell_HeadModelImpl.getOriginalHeadID(),
					cell_HeadModelImpl.getOriginalColumn()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADIDWITHCOLUMN,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_HEADIDWITHCOLUMN,
				args);
		}
	}

	/**
	 * Creates a new cell_ head with the primary key. Does not add the cell_ head to the database.
	 *
	 * @param cell_HeadPK the primary key for the new cell_ head
	 * @return the new cell_ head
	 */
	@Override
	public Cell_Head create(Cell_HeadPK cell_HeadPK) {
		Cell_Head cell_Head = new Cell_HeadImpl();

		cell_Head.setNew(true);
		cell_Head.setPrimaryKey(cell_HeadPK);

		return cell_Head;
	}

	/**
	 * Removes the cell_ head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cell_HeadPK the primary key of the cell_ head
	 * @return the cell_ head that was removed
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head remove(Cell_HeadPK cell_HeadPK)
		throws NoSuchCell_HeadException, SystemException {
		return remove((Serializable)cell_HeadPK);
	}

	/**
	 * Removes the cell_ head with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cell_ head
	 * @return the cell_ head that was removed
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head remove(Serializable primaryKey)
		throws NoSuchCell_HeadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Cell_Head cell_Head = (Cell_Head)session.get(Cell_HeadImpl.class,
					primaryKey);

			if (cell_Head == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCell_HeadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cell_Head);
		}
		catch (NoSuchCell_HeadException nsee) {
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
	protected Cell_Head removeImpl(Cell_Head cell_Head)
		throws SystemException {
		cell_Head = toUnwrappedModel(cell_Head);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cell_Head)) {
				cell_Head = (Cell_Head)session.get(Cell_HeadImpl.class,
						cell_Head.getPrimaryKeyObj());
			}

			if (cell_Head != null) {
				session.delete(cell_Head);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cell_Head != null) {
			clearCache(cell_Head);
		}

		return cell_Head;
	}

	@Override
	public Cell_Head updateImpl(org.gfbio.model.Cell_Head cell_Head)
		throws SystemException {
		cell_Head = toUnwrappedModel(cell_Head);

		boolean isNew = cell_Head.isNew();

		Cell_HeadModelImpl cell_HeadModelImpl = (Cell_HeadModelImpl)cell_Head;

		Session session = null;

		try {
			session = openSession();

			if (cell_Head.isNew()) {
				session.save(cell_Head);

				cell_Head.setNew(false);
			}
			else {
				session.merge(cell_Head);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Cell_HeadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cell_HeadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_HeadModelImpl.getOriginalCellID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID,
					args);

				args = new Object[] { cell_HeadModelImpl.getCellID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLID,
					args);
			}

			if ((cell_HeadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cell_HeadModelImpl.getOriginalHeadID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);

				args = new Object[] { cell_HeadModelImpl.getHeadID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);
			}
		}

		EntityCacheUtil.putResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
			Cell_HeadImpl.class, cell_Head.getPrimaryKey(), cell_Head);

		clearUniqueFindersCache(cell_Head);
		cacheUniqueFindersCache(cell_Head);

		return cell_Head;
	}

	protected Cell_Head toUnwrappedModel(Cell_Head cell_Head) {
		if (cell_Head instanceof Cell_HeadImpl) {
			return cell_Head;
		}

		Cell_HeadImpl cell_HeadImpl = new Cell_HeadImpl();

		cell_HeadImpl.setNew(cell_Head.isNew());
		cell_HeadImpl.setPrimaryKey(cell_Head.getPrimaryKey());

		cell_HeadImpl.setCellID(cell_Head.getCellID());
		cell_HeadImpl.setHeadID(cell_Head.getHeadID());
		cell_HeadImpl.setColumn(cell_Head.getColumn());

		return cell_HeadImpl;
	}

	/**
	 * Returns the cell_ head with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell_ head
	 * @return the cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCell_HeadException, SystemException {
		Cell_Head cell_Head = fetchByPrimaryKey(primaryKey);

		if (cell_Head == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCell_HeadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cell_Head;
	}

	/**
	 * Returns the cell_ head with the primary key or throws a {@link org.gfbio.NoSuchCell_HeadException} if it could not be found.
	 *
	 * @param cell_HeadPK the primary key of the cell_ head
	 * @return the cell_ head
	 * @throws org.gfbio.NoSuchCell_HeadException if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head findByPrimaryKey(Cell_HeadPK cell_HeadPK)
		throws NoSuchCell_HeadException, SystemException {
		return findByPrimaryKey((Serializable)cell_HeadPK);
	}

	/**
	 * Returns the cell_ head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cell_ head
	 * @return the cell_ head, or <code>null</code> if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Cell_Head cell_Head = (Cell_Head)EntityCacheUtil.getResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
				Cell_HeadImpl.class, primaryKey);

		if (cell_Head == _nullCell_Head) {
			return null;
		}

		if (cell_Head == null) {
			Session session = null;

			try {
				session = openSession();

				cell_Head = (Cell_Head)session.get(Cell_HeadImpl.class,
						primaryKey);

				if (cell_Head != null) {
					cacheResult(cell_Head);
				}
				else {
					EntityCacheUtil.putResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
						Cell_HeadImpl.class, primaryKey, _nullCell_Head);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Cell_HeadModelImpl.ENTITY_CACHE_ENABLED,
					Cell_HeadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cell_Head;
	}

	/**
	 * Returns the cell_ head with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cell_HeadPK the primary key of the cell_ head
	 * @return the cell_ head, or <code>null</code> if a cell_ head with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Cell_Head fetchByPrimaryKey(Cell_HeadPK cell_HeadPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)cell_HeadPK);
	}

	/**
	 * Returns all the cell_ heads.
	 *
	 * @return the cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cell_ heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @return the range of cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cell_ heads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Cell_HeadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cell_ heads
	 * @param end the upper bound of the range of cell_ heads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cell_ heads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Cell_Head> findAll(int start, int end,
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

		List<Cell_Head> list = (List<Cell_Head>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CELL_HEAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CELL_HEAD;

				if (pagination) {
					sql = sql.concat(Cell_HeadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Cell_Head>(list);
				}
				else {
					list = (List<Cell_Head>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the cell_ heads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Cell_Head cell_Head : findAll()) {
			remove(cell_Head);
		}
	}

	/**
	 * Returns the number of cell_ heads.
	 *
	 * @return the number of cell_ heads
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

				Query q = session.createQuery(_SQL_COUNT_CELL_HEAD);

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
	 * Initializes the cell_ head persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Cell_Head")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Cell_Head>> listenersList = new ArrayList<ModelListener<Cell_Head>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Cell_Head>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Cell_HeadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CELL_HEAD = "SELECT cell_Head FROM Cell_Head cell_Head";
	private static final String _SQL_SELECT_CELL_HEAD_WHERE = "SELECT cell_Head FROM Cell_Head cell_Head WHERE ";
	private static final String _SQL_COUNT_CELL_HEAD = "SELECT COUNT(cell_Head) FROM Cell_Head cell_Head";
	private static final String _SQL_COUNT_CELL_HEAD_WHERE = "SELECT COUNT(cell_Head) FROM Cell_Head cell_Head WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cell_Head.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Cell_Head exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Cell_Head exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Cell_HeadPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"column"
			});
	private static Cell_Head _nullCell_Head = new Cell_HeadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Cell_Head> toCacheModel() {
				return _nullCell_HeadCacheModel;
			}
		};

	private static CacheModel<Cell_Head> _nullCell_HeadCacheModel = new CacheModel<Cell_Head>() {
			@Override
			public Cell_Head toEntityModel() {
				return _nullCell_Head;
			}
		};
}