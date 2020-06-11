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

import org.gfbio.NoSuchDataManagementPlanException;

import org.gfbio.model.DataManagementPlan;
import org.gfbio.model.impl.DataManagementPlanImpl;
import org.gfbio.model.impl.DataManagementPlanModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the data management plan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataManagementPlanPersistence
 * @see DataManagementPlanUtil
 * @generated
 */
public class DataManagementPlanPersistenceImpl extends BasePersistenceImpl<DataManagementPlan>
	implements DataManagementPlanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DataManagementPlanUtil} to access the data management plan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DataManagementPlanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED,
			DataManagementPlanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED,
			DataManagementPlanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DMPID = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED,
			DataManagementPlanImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDmpID", new String[] { Long.class.getName() },
			DataManagementPlanModelImpl.DMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DMPID = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDmpID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the data management plan where dmpID = &#63; or throws a {@link org.gfbio.NoSuchDataManagementPlanException} if it could not be found.
	 *
	 * @param dmpID the dmp i d
	 * @return the matching data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan findByDmpID(long dmpID)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = fetchByDmpID(dmpID);

		if (dataManagementPlan == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dmpID=");
			msg.append(dmpID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDataManagementPlanException(msg.toString());
		}

		return dataManagementPlan;
	}

	/**
	 * Returns the data management plan where dmpID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dmpID the dmp i d
	 * @return the matching data management plan, or <code>null</code> if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByDmpID(long dmpID)
		throws SystemException {
		return fetchByDmpID(dmpID, true);
	}

	/**
	 * Returns the data management plan where dmpID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dmpID the dmp i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching data management plan, or <code>null</code> if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByDmpID(long dmpID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { dmpID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DMPID,
					finderArgs, this);
		}

		if (result instanceof DataManagementPlan) {
			DataManagementPlan dataManagementPlan = (DataManagementPlan)result;

			if ((dmpID != dataManagementPlan.getDmpID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DATAMANAGEMENTPLAN_WHERE);

			query.append(_FINDER_COLUMN_DMPID_DMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dmpID);

				List<DataManagementPlan> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DMPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DataManagementPlanPersistenceImpl.fetchByDmpID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DataManagementPlan dataManagementPlan = list.get(0);

					result = dataManagementPlan;

					cacheResult(dataManagementPlan);

					if ((dataManagementPlan.getDmpID() != dmpID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DMPID,
							finderArgs, dataManagementPlan);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DMPID,
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
			return (DataManagementPlan)result;
		}
	}

	/**
	 * Removes the data management plan where dmpID = &#63; from the database.
	 *
	 * @param dmpID the dmp i d
	 * @return the data management plan that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan removeByDmpID(long dmpID)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = findByDmpID(dmpID);

		return remove(dataManagementPlan);
	}

	/**
	 * Returns the number of data management plans where dmpID = &#63;.
	 *
	 * @param dmpID the dmp i d
	 * @return the number of matching data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDmpID(long dmpID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DMPID;

		Object[] finderArgs = new Object[] { dmpID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAMANAGEMENTPLAN_WHERE);

			query.append(_FINDER_COLUMN_DMPID_DMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dmpID);

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

	private static final String _FINDER_COLUMN_DMPID_DMPID_2 = "dataManagementPlan.dmpID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED,
			DataManagementPlanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED,
			DataManagementPlanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			DataManagementPlanModelImpl.USERID_COLUMN_BITMASK |
			DataManagementPlanModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the data management plans where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data management plans where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataManagementPlanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of data management plans
	 * @param end the upper bound of the range of data management plans (not inclusive)
	 * @return the range of matching data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data management plans where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataManagementPlanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of data management plans
	 * @param end the upper bound of the range of data management plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findByUserID(long userID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<DataManagementPlan> list = (List<DataManagementPlan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataManagementPlan dataManagementPlan : list) {
				if ((userID != dataManagementPlan.getUserID())) {
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

			query.append(_SQL_SELECT_DATAMANAGEMENTPLAN_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DataManagementPlanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<DataManagementPlan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataManagementPlan>(list);
				}
				else {
					list = (List<DataManagementPlan>)QueryUtil.list(q,
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
	 * Returns the first data management plan in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = fetchByUserID_First(userID,
				orderByComparator);

		if (dataManagementPlan != null) {
			return dataManagementPlan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataManagementPlanException(msg.toString());
	}

	/**
	 * Returns the first data management plan in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data management plan, or <code>null</code> if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<DataManagementPlan> list = findByUserID(userID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data management plan in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = fetchByUserID_Last(userID,
				orderByComparator);

		if (dataManagementPlan != null) {
			return dataManagementPlan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataManagementPlanException(msg.toString());
	}

	/**
	 * Returns the last data management plan in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data management plan, or <code>null</code> if a matching data management plan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<DataManagementPlan> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data management plans before and after the current data management plan in the ordered set where userID = &#63;.
	 *
	 * @param dmpID the primary key of the current data management plan
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan[] findByUserID_PrevAndNext(long dmpID,
		long userID, OrderByComparator orderByComparator)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = findByPrimaryKey(dmpID);

		Session session = null;

		try {
			session = openSession();

			DataManagementPlan[] array = new DataManagementPlanImpl[3];

			array[0] = getByUserID_PrevAndNext(session, dataManagementPlan,
					userID, orderByComparator, true);

			array[1] = dataManagementPlan;

			array[2] = getByUserID_PrevAndNext(session, dataManagementPlan,
					userID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataManagementPlan getByUserID_PrevAndNext(Session session,
		DataManagementPlan dataManagementPlan, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAMANAGEMENTPLAN_WHERE);

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
			query.append(DataManagementPlanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dataManagementPlan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DataManagementPlan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data management plans where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (DataManagementPlan dataManagementPlan : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dataManagementPlan);
		}
	}

	/**
	 * Returns the number of data management plans where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching data management plans
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

			query.append(_SQL_COUNT_DATAMANAGEMENTPLAN_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "dataManagementPlan.userID = ?";

	public DataManagementPlanPersistenceImpl() {
		setModelClass(DataManagementPlan.class);
	}

	/**
	 * Caches the data management plan in the entity cache if it is enabled.
	 *
	 * @param dataManagementPlan the data management plan
	 */
	@Override
	public void cacheResult(DataManagementPlan dataManagementPlan) {
		EntityCacheUtil.putResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanImpl.class, dataManagementPlan.getPrimaryKey(),
			dataManagementPlan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DMPID,
			new Object[] { dataManagementPlan.getDmpID() }, dataManagementPlan);

		dataManagementPlan.resetOriginalValues();
	}

	/**
	 * Caches the data management plans in the entity cache if it is enabled.
	 *
	 * @param dataManagementPlans the data management plans
	 */
	@Override
	public void cacheResult(List<DataManagementPlan> dataManagementPlans) {
		for (DataManagementPlan dataManagementPlan : dataManagementPlans) {
			if (EntityCacheUtil.getResult(
						DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
						DataManagementPlanImpl.class,
						dataManagementPlan.getPrimaryKey()) == null) {
				cacheResult(dataManagementPlan);
			}
			else {
				dataManagementPlan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data management plans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DataManagementPlanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DataManagementPlanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data management plan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataManagementPlan dataManagementPlan) {
		EntityCacheUtil.removeResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanImpl.class, dataManagementPlan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dataManagementPlan);
	}

	@Override
	public void clearCache(List<DataManagementPlan> dataManagementPlans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataManagementPlan dataManagementPlan : dataManagementPlans) {
			EntityCacheUtil.removeResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
				DataManagementPlanImpl.class, dataManagementPlan.getPrimaryKey());

			clearUniqueFindersCache(dataManagementPlan);
		}
	}

	protected void cacheUniqueFindersCache(
		DataManagementPlan dataManagementPlan) {
		if (dataManagementPlan.isNew()) {
			Object[] args = new Object[] { dataManagementPlan.getDmpID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DMPID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DMPID, args,
				dataManagementPlan);
		}
		else {
			DataManagementPlanModelImpl dataManagementPlanModelImpl = (DataManagementPlanModelImpl)dataManagementPlan;

			if ((dataManagementPlanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dataManagementPlan.getDmpID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DMPID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DMPID, args,
					dataManagementPlan);
			}
		}
	}

	protected void clearUniqueFindersCache(
		DataManagementPlan dataManagementPlan) {
		DataManagementPlanModelImpl dataManagementPlanModelImpl = (DataManagementPlanModelImpl)dataManagementPlan;

		Object[] args = new Object[] { dataManagementPlan.getDmpID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DMPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DMPID, args);

		if ((dataManagementPlanModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DMPID.getColumnBitmask()) != 0) {
			args = new Object[] { dataManagementPlanModelImpl.getOriginalDmpID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DMPID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DMPID, args);
		}
	}

	/**
	 * Creates a new data management plan with the primary key. Does not add the data management plan to the database.
	 *
	 * @param dmpID the primary key for the new data management plan
	 * @return the new data management plan
	 */
	@Override
	public DataManagementPlan create(long dmpID) {
		DataManagementPlan dataManagementPlan = new DataManagementPlanImpl();

		dataManagementPlan.setNew(true);
		dataManagementPlan.setPrimaryKey(dmpID);

		return dataManagementPlan;
	}

	/**
	 * Removes the data management plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dmpID the primary key of the data management plan
	 * @return the data management plan that was removed
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan remove(long dmpID)
		throws NoSuchDataManagementPlanException, SystemException {
		return remove((Serializable)dmpID);
	}

	/**
	 * Removes the data management plan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data management plan
	 * @return the data management plan that was removed
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan remove(Serializable primaryKey)
		throws NoSuchDataManagementPlanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DataManagementPlan dataManagementPlan = (DataManagementPlan)session.get(DataManagementPlanImpl.class,
					primaryKey);

			if (dataManagementPlan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataManagementPlanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dataManagementPlan);
		}
		catch (NoSuchDataManagementPlanException nsee) {
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
	protected DataManagementPlan removeImpl(
		DataManagementPlan dataManagementPlan) throws SystemException {
		dataManagementPlan = toUnwrappedModel(dataManagementPlan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataManagementPlan)) {
				dataManagementPlan = (DataManagementPlan)session.get(DataManagementPlanImpl.class,
						dataManagementPlan.getPrimaryKeyObj());
			}

			if (dataManagementPlan != null) {
				session.delete(dataManagementPlan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataManagementPlan != null) {
			clearCache(dataManagementPlan);
		}

		return dataManagementPlan;
	}

	@Override
	public DataManagementPlan updateImpl(
		org.gfbio.model.DataManagementPlan dataManagementPlan)
		throws SystemException {
		dataManagementPlan = toUnwrappedModel(dataManagementPlan);

		boolean isNew = dataManagementPlan.isNew();

		DataManagementPlanModelImpl dataManagementPlanModelImpl = (DataManagementPlanModelImpl)dataManagementPlan;

		Session session = null;

		try {
			session = openSession();

			if (dataManagementPlan.isNew()) {
				session.save(dataManagementPlan);

				dataManagementPlan.setNew(false);
			}
			else {
				session.merge(dataManagementPlan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DataManagementPlanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dataManagementPlanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dataManagementPlanModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { dataManagementPlanModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
			DataManagementPlanImpl.class, dataManagementPlan.getPrimaryKey(),
			dataManagementPlan);

		clearUniqueFindersCache(dataManagementPlan);
		cacheUniqueFindersCache(dataManagementPlan);

		return dataManagementPlan;
	}

	protected DataManagementPlan toUnwrappedModel(
		DataManagementPlan dataManagementPlan) {
		if (dataManagementPlan instanceof DataManagementPlanImpl) {
			return dataManagementPlan;
		}

		DataManagementPlanImpl dataManagementPlanImpl = new DataManagementPlanImpl();

		dataManagementPlanImpl.setNew(dataManagementPlan.isNew());
		dataManagementPlanImpl.setPrimaryKey(dataManagementPlan.getPrimaryKey());

		dataManagementPlanImpl.setDmpID(dataManagementPlan.getDmpID());
		dataManagementPlanImpl.setName(dataManagementPlan.getName());
		dataManagementPlanImpl.setUserID(dataManagementPlan.getUserID());
		dataManagementPlanImpl.setDmpTInput(dataManagementPlan.getDmpTInput());
		dataManagementPlanImpl.setTicketID(dataManagementPlan.getTicketID());
		dataManagementPlanImpl.setLastModifiedDate(dataManagementPlan.getLastModifiedDate());

		return dataManagementPlanImpl;
	}

	/**
	 * Returns the data management plan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the data management plan
	 * @return the data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataManagementPlanException, SystemException {
		DataManagementPlan dataManagementPlan = fetchByPrimaryKey(primaryKey);

		if (dataManagementPlan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataManagementPlanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dataManagementPlan;
	}

	/**
	 * Returns the data management plan with the primary key or throws a {@link org.gfbio.NoSuchDataManagementPlanException} if it could not be found.
	 *
	 * @param dmpID the primary key of the data management plan
	 * @return the data management plan
	 * @throws org.gfbio.NoSuchDataManagementPlanException if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan findByPrimaryKey(long dmpID)
		throws NoSuchDataManagementPlanException, SystemException {
		return findByPrimaryKey((Serializable)dmpID);
	}

	/**
	 * Returns the data management plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data management plan
	 * @return the data management plan, or <code>null</code> if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DataManagementPlan dataManagementPlan = (DataManagementPlan)EntityCacheUtil.getResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
				DataManagementPlanImpl.class, primaryKey);

		if (dataManagementPlan == _nullDataManagementPlan) {
			return null;
		}

		if (dataManagementPlan == null) {
			Session session = null;

			try {
				session = openSession();

				dataManagementPlan = (DataManagementPlan)session.get(DataManagementPlanImpl.class,
						primaryKey);

				if (dataManagementPlan != null) {
					cacheResult(dataManagementPlan);
				}
				else {
					EntityCacheUtil.putResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
						DataManagementPlanImpl.class, primaryKey,
						_nullDataManagementPlan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DataManagementPlanModelImpl.ENTITY_CACHE_ENABLED,
					DataManagementPlanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dataManagementPlan;
	}

	/**
	 * Returns the data management plan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dmpID the primary key of the data management plan
	 * @return the data management plan, or <code>null</code> if a data management plan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataManagementPlan fetchByPrimaryKey(long dmpID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dmpID);
	}

	/**
	 * Returns all the data management plans.
	 *
	 * @return the data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data management plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataManagementPlanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data management plans
	 * @param end the upper bound of the range of data management plans (not inclusive)
	 * @return the range of data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data management plans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataManagementPlanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data management plans
	 * @param end the upper bound of the range of data management plans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data management plans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataManagementPlan> findAll(int start, int end,
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

		List<DataManagementPlan> list = (List<DataManagementPlan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DATAMANAGEMENTPLAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAMANAGEMENTPLAN;

				if (pagination) {
					sql = sql.concat(DataManagementPlanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataManagementPlan>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataManagementPlan>(list);
				}
				else {
					list = (List<DataManagementPlan>)QueryUtil.list(q,
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
	 * Removes all the data management plans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DataManagementPlan dataManagementPlan : findAll()) {
			remove(dataManagementPlan);
		}
	}

	/**
	 * Returns the number of data management plans.
	 *
	 * @return the number of data management plans
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

				Query q = session.createQuery(_SQL_COUNT_DATAMANAGEMENTPLAN);

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
	 * Initializes the data management plan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.DataManagementPlan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DataManagementPlan>> listenersList = new ArrayList<ModelListener<DataManagementPlan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DataManagementPlan>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DataManagementPlanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DATAMANAGEMENTPLAN = "SELECT dataManagementPlan FROM DataManagementPlan dataManagementPlan";
	private static final String _SQL_SELECT_DATAMANAGEMENTPLAN_WHERE = "SELECT dataManagementPlan FROM DataManagementPlan dataManagementPlan WHERE ";
	private static final String _SQL_COUNT_DATAMANAGEMENTPLAN = "SELECT COUNT(dataManagementPlan) FROM DataManagementPlan dataManagementPlan";
	private static final String _SQL_COUNT_DATAMANAGEMENTPLAN_WHERE = "SELECT COUNT(dataManagementPlan) FROM DataManagementPlan dataManagementPlan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dataManagementPlan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataManagementPlan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataManagementPlan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DataManagementPlanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"dmpID", "userID", "dmpTInput", "ticketID", "lastModifiedDate"
			});
	private static DataManagementPlan _nullDataManagementPlan = new DataManagementPlanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DataManagementPlan> toCacheModel() {
				return _nullDataManagementPlanCacheModel;
			}
		};

	private static CacheModel<DataManagementPlan> _nullDataManagementPlanCacheModel =
		new CacheModel<DataManagementPlan>() {
			@Override
			public DataManagementPlan toEntityModel() {
				return _nullDataManagementPlan;
			}
		};
}