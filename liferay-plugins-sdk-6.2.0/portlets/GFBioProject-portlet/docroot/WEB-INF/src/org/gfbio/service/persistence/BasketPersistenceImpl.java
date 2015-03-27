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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchBasketException;

import org.gfbio.model.Basket;
import org.gfbio.model.impl.BasketImpl;
import org.gfbio.model.impl.BasketModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the basket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see BasketPersistence
 * @see BasketUtil
 * @generated
 */
public class BasketPersistenceImpl extends BasePersistenceImpl<Basket>
	implements BasketPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BasketUtil} to access the basket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BasketImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, BasketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, BasketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, BasketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, BasketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			BasketModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the baskets where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findByUserID(long userID) throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the baskets where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of baskets
	 * @param end the upper bound of the range of baskets (not inclusive)
	 * @return the range of matching baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the baskets where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of baskets
	 * @param end the upper bound of the range of baskets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findByUserID(long userID, int start, int end,
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

		List<Basket> list = (List<Basket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Basket basket : list) {
				if ((userID != basket.getUserID())) {
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

			query.append(_SQL_SELECT_BASKET_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BasketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Basket>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Basket>(list);
				}
				else {
					list = (List<Basket>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first basket in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching basket
	 * @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasketException, SystemException {
		Basket basket = fetchByUserID_First(userID, orderByComparator);

		if (basket != null) {
			return basket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBasketException(msg.toString());
	}

	/**
	 * Returns the first basket in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching basket, or <code>null</code> if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Basket> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last basket in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching basket
	 * @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasketException, SystemException {
		Basket basket = fetchByUserID_Last(userID, orderByComparator);

		if (basket != null) {
			return basket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBasketException(msg.toString());
	}

	/**
	 * Returns the last basket in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching basket, or <code>null</code> if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Basket> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the baskets before and after the current basket in the ordered set where userID = &#63;.
	 *
	 * @param basketID the primary key of the current basket
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next basket
	 * @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket[] findByUserID_PrevAndNext(long basketID, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasketException, SystemException {
		Basket basket = findByPrimaryKey(basketID);

		Session session = null;

		try {
			session = openSession();

			Basket[] array = new BasketImpl[3];

			array[0] = getByUserID_PrevAndNext(session, basket, userID,
					orderByComparator, true);

			array[1] = basket;

			array[2] = getByUserID_PrevAndNext(session, basket, userID,
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

	protected Basket getByUserID_PrevAndNext(Session session, Basket basket,
		long userID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BASKET_WHERE);

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
			query.append(BasketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(basket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Basket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the baskets where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Basket basket : findByUserID(userID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(basket);
		}
	}

	/**
	 * Returns the number of baskets where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching baskets
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

			query.append(_SQL_COUNT_BASKET_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "basket.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BASKETID = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, BasketImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBasketID",
			new String[] { Long.class.getName() },
			BasketModelImpl.BASKETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BASKETID = new FinderPath(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBasketID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the basket where basketID = &#63; or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	 *
	 * @param basketID the basket i d
	 * @return the matching basket
	 * @throws org.gfbio.NoSuchBasketException if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket findByBasketID(long basketID)
		throws NoSuchBasketException, SystemException {
		Basket basket = fetchByBasketID(basketID);

		if (basket == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("basketID=");
			msg.append(basketID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBasketException(msg.toString());
		}

		return basket;
	}

	/**
	 * Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param basketID the basket i d
	 * @return the matching basket, or <code>null</code> if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByBasketID(long basketID) throws SystemException {
		return fetchByBasketID(basketID, true);
	}

	/**
	 * Returns the basket where basketID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param basketID the basket i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching basket, or <code>null</code> if a matching basket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByBasketID(long basketID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { basketID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BASKETID,
					finderArgs, this);
		}

		if (result instanceof Basket) {
			Basket basket = (Basket)result;

			if ((basketID != basket.getBasketID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BASKET_WHERE);

			query.append(_FINDER_COLUMN_BASKETID_BASKETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(basketID);

				List<Basket> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BasketPersistenceImpl.fetchByBasketID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Basket basket = list.get(0);

					result = basket;

					cacheResult(basket);

					if ((basket.getBasketID() != basketID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
							finderArgs, basket);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BASKETID,
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
			return (Basket)result;
		}
	}

	/**
	 * Removes the basket where basketID = &#63; from the database.
	 *
	 * @param basketID the basket i d
	 * @return the basket that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket removeByBasketID(long basketID)
		throws NoSuchBasketException, SystemException {
		Basket basket = findByBasketID(basketID);

		return remove(basket);
	}

	/**
	 * Returns the number of baskets where basketID = &#63;.
	 *
	 * @param basketID the basket i d
	 * @return the number of matching baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBasketID(long basketID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BASKETID;

		Object[] finderArgs = new Object[] { basketID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BASKET_WHERE);

			query.append(_FINDER_COLUMN_BASKETID_BASKETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(basketID);

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

	private static final String _FINDER_COLUMN_BASKETID_BASKETID_2 = "basket.basketID = ?";

	public BasketPersistenceImpl() {
		setModelClass(Basket.class);
	}

	/**
	 * Caches the basket in the entity cache if it is enabled.
	 *
	 * @param basket the basket
	 */
	@Override
	public void cacheResult(Basket basket) {
		EntityCacheUtil.putResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketImpl.class, basket.getPrimaryKey(), basket);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
			new Object[] { basket.getBasketID() }, basket);

		basket.resetOriginalValues();
	}

	/**
	 * Caches the baskets in the entity cache if it is enabled.
	 *
	 * @param baskets the baskets
	 */
	@Override
	public void cacheResult(List<Basket> baskets) {
		for (Basket basket : baskets) {
			if (EntityCacheUtil.getResult(
						BasketModelImpl.ENTITY_CACHE_ENABLED, BasketImpl.class,
						basket.getPrimaryKey()) == null) {
				cacheResult(basket);
			}
			else {
				basket.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all baskets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BasketImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BasketImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the basket.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Basket basket) {
		EntityCacheUtil.removeResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketImpl.class, basket.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(basket);
	}

	@Override
	public void clearCache(List<Basket> baskets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Basket basket : baskets) {
			EntityCacheUtil.removeResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
				BasketImpl.class, basket.getPrimaryKey());

			clearUniqueFindersCache(basket);
		}
	}

	protected void cacheUniqueFindersCache(Basket basket) {
		if (basket.isNew()) {
			Object[] args = new Object[] { basket.getBasketID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BASKETID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID, args,
				basket);
		}
		else {
			BasketModelImpl basketModelImpl = (BasketModelImpl)basket;

			if ((basketModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BASKETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { basket.getBasketID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BASKETID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID, args,
					basket);
			}
		}
	}

	protected void clearUniqueFindersCache(Basket basket) {
		BasketModelImpl basketModelImpl = (BasketModelImpl)basket;

		Object[] args = new Object[] { basket.getBasketID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASKETID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BASKETID, args);

		if ((basketModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BASKETID.getColumnBitmask()) != 0) {
			args = new Object[] { basketModelImpl.getOriginalBasketID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASKETID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BASKETID, args);
		}
	}

	/**
	 * Creates a new basket with the primary key. Does not add the basket to the database.
	 *
	 * @param basketID the primary key for the new basket
	 * @return the new basket
	 */
	@Override
	public Basket create(long basketID) {
		Basket basket = new BasketImpl();

		basket.setNew(true);
		basket.setPrimaryKey(basketID);

		return basket;
	}

	/**
	 * Removes the basket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param basketID the primary key of the basket
	 * @return the basket that was removed
	 * @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket remove(long basketID)
		throws NoSuchBasketException, SystemException {
		return remove((Serializable)basketID);
	}

	/**
	 * Removes the basket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the basket
	 * @return the basket that was removed
	 * @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket remove(Serializable primaryKey)
		throws NoSuchBasketException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Basket basket = (Basket)session.get(BasketImpl.class, primaryKey);

			if (basket == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBasketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(basket);
		}
		catch (NoSuchBasketException nsee) {
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
	protected Basket removeImpl(Basket basket) throws SystemException {
		basket = toUnwrappedModel(basket);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(basket)) {
				basket = (Basket)session.get(BasketImpl.class,
						basket.getPrimaryKeyObj());
			}

			if (basket != null) {
				session.delete(basket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (basket != null) {
			clearCache(basket);
		}

		return basket;
	}

	@Override
	public Basket updateImpl(org.gfbio.model.Basket basket)
		throws SystemException {
		basket = toUnwrappedModel(basket);

		boolean isNew = basket.isNew();

		BasketModelImpl basketModelImpl = (BasketModelImpl)basket;

		Session session = null;

		try {
			session = openSession();

			if (basket.isNew()) {
				session.save(basket);

				basket.setNew(false);
			}
			else {
				session.merge(basket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BasketModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((basketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { basketModelImpl.getOriginalUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { basketModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
			BasketImpl.class, basket.getPrimaryKey(), basket);

		clearUniqueFindersCache(basket);
		cacheUniqueFindersCache(basket);

		return basket;
	}

	protected Basket toUnwrappedModel(Basket basket) {
		if (basket instanceof BasketImpl) {
			return basket;
		}

		BasketImpl basketImpl = new BasketImpl();

		basketImpl.setNew(basket.isNew());
		basketImpl.setPrimaryKey(basket.getPrimaryKey());

		basketImpl.setBasketID(basket.getBasketID());
		basketImpl.setUserID(basket.getUserID());
		basketImpl.setName(basket.getName());
		basketImpl.setBasketJSON(basket.getBasketJSON());
		basketImpl.setQueryJSON(basket.getQueryJSON());

		return basketImpl;
	}

	/**
	 * Returns the basket with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the basket
	 * @return the basket
	 * @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBasketException, SystemException {
		Basket basket = fetchByPrimaryKey(primaryKey);

		if (basket == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBasketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return basket;
	}

	/**
	 * Returns the basket with the primary key or throws a {@link org.gfbio.NoSuchBasketException} if it could not be found.
	 *
	 * @param basketID the primary key of the basket
	 * @return the basket
	 * @throws org.gfbio.NoSuchBasketException if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket findByPrimaryKey(long basketID)
		throws NoSuchBasketException, SystemException {
		return findByPrimaryKey((Serializable)basketID);
	}

	/**
	 * Returns the basket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the basket
	 * @return the basket, or <code>null</code> if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Basket basket = (Basket)EntityCacheUtil.getResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
				BasketImpl.class, primaryKey);

		if (basket == _nullBasket) {
			return null;
		}

		if (basket == null) {
			Session session = null;

			try {
				session = openSession();

				basket = (Basket)session.get(BasketImpl.class, primaryKey);

				if (basket != null) {
					cacheResult(basket);
				}
				else {
					EntityCacheUtil.putResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
						BasketImpl.class, primaryKey, _nullBasket);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BasketModelImpl.ENTITY_CACHE_ENABLED,
					BasketImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return basket;
	}

	/**
	 * Returns the basket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param basketID the primary key of the basket
	 * @return the basket, or <code>null</code> if a basket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket fetchByPrimaryKey(long basketID) throws SystemException {
		return fetchByPrimaryKey((Serializable)basketID);
	}

	/**
	 * Returns all the baskets.
	 *
	 * @return the baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the baskets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of baskets
	 * @param end the upper bound of the range of baskets (not inclusive)
	 * @return the range of baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the baskets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.BasketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of baskets
	 * @param end the upper bound of the range of baskets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of baskets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket> findAll(int start, int end,
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

		List<Basket> list = (List<Basket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BASKET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BASKET;

				if (pagination) {
					sql = sql.concat(BasketModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Basket>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Basket>(list);
				}
				else {
					list = (List<Basket>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the baskets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Basket basket : findAll()) {
			remove(basket);
		}
	}

	/**
	 * Returns the number of baskets.
	 *
	 * @return the number of baskets
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

				Query q = session.createQuery(_SQL_COUNT_BASKET);

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
	 * Initializes the basket persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Basket")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Basket>> listenersList = new ArrayList<ModelListener<Basket>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Basket>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BasketImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BASKET = "SELECT basket FROM Basket basket";
	private static final String _SQL_SELECT_BASKET_WHERE = "SELECT basket FROM Basket basket WHERE ";
	private static final String _SQL_COUNT_BASKET = "SELECT COUNT(basket) FROM Basket basket";
	private static final String _SQL_COUNT_BASKET_WHERE = "SELECT COUNT(basket) FROM Basket basket WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "basket.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Basket exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Basket exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BasketPersistenceImpl.class);
	private static Basket _nullBasket = new BasketImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Basket> toCacheModel() {
				return _nullBasketCacheModel;
			}
		};

	private static CacheModel<Basket> _nullBasketCacheModel = new CacheModel<Basket>() {
			@Override
			public Basket toEntityModel() {
				return _nullBasket;
			}
		};
}