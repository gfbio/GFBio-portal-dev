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

import org.gfbio.NoSuchBasket_UserException;

import org.gfbio.model.Basket_User;
import org.gfbio.model.impl.Basket_UserImpl;
import org.gfbio.model.impl.Basket_UserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the basket_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Basket_UserPersistence
 * @see Basket_UserUtil
 * @generated
 */
public class Basket_UserPersistenceImpl extends BasePersistenceImpl<Basket_User>
	implements Basket_UserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Basket_UserUtil} to access the basket_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Basket_UserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Basket_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Basket_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Basket_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Basket_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			Basket_UserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the basket_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the basket_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of basket_ users
	 * @param end the upper bound of the range of basket_ users (not inclusive)
	 * @return the range of matching basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the basket_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of basket_ users
	 * @param end the upper bound of the range of basket_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findByUserID(long userID, int start, int end,
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

		List<Basket_User> list = (List<Basket_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Basket_User basket_User : list) {
				if ((userID != basket_User.getUserID())) {
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

			query.append(_SQL_SELECT_BASKET_USER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Basket_UserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Basket_User>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Basket_User>(list);
				}
				else {
					list = (List<Basket_User>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first basket_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = fetchByUserID_First(userID, orderByComparator);

		if (basket_User != null) {
			return basket_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBasket_UserException(msg.toString());
	}

	/**
	 * Returns the first basket_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Basket_User> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last basket_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = fetchByUserID_Last(userID, orderByComparator);

		if (basket_User != null) {
			return basket_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBasket_UserException(msg.toString());
	}

	/**
	 * Returns the last basket_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Basket_User> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the basket_ users before and after the current basket_ user in the ordered set where userID = &#63;.
	 *
	 * @param basketID the primary key of the current basket_ user
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User[] findByUserID_PrevAndNext(long basketID, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = findByPrimaryKey(basketID);

		Session session = null;

		try {
			session = openSession();

			Basket_User[] array = new Basket_UserImpl[3];

			array[0] = getByUserID_PrevAndNext(session, basket_User, userID,
					orderByComparator, true);

			array[1] = basket_User;

			array[2] = getByUserID_PrevAndNext(session, basket_User, userID,
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

	protected Basket_User getByUserID_PrevAndNext(Session session,
		Basket_User basket_User, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BASKET_USER_WHERE);

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
			query.append(Basket_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(basket_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Basket_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the basket_ users where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Basket_User basket_User : findByUserID(userID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(basket_User);
		}
	}

	/**
	 * Returns the number of basket_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching basket_ users
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

			query.append(_SQL_COUNT_BASKET_USER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "basket_User.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BASKETID = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Basket_UserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBasketID",
			new String[] { Long.class.getName() },
			Basket_UserModelImpl.BASKETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BASKETID = new FinderPath(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBasketID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the basket_ user where basketID = &#63; or throws a {@link org.gfbio.NoSuchBasket_UserException} if it could not be found.
	 *
	 * @param basketID the basket i d
	 * @return the matching basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User findByBasketID(long basketID)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = fetchByBasketID(basketID);

		if (basket_User == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("basketID=");
			msg.append(basketID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBasket_UserException(msg.toString());
		}

		return basket_User;
	}

	/**
	 * Returns the basket_ user where basketID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param basketID the basket i d
	 * @return the matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByBasketID(long basketID) throws SystemException {
		return fetchByBasketID(basketID, true);
	}

	/**
	 * Returns the basket_ user where basketID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param basketID the basket i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching basket_ user, or <code>null</code> if a matching basket_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByBasketID(long basketID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { basketID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BASKETID,
					finderArgs, this);
		}

		if (result instanceof Basket_User) {
			Basket_User basket_User = (Basket_User)result;

			if ((basketID != basket_User.getBasketID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BASKET_USER_WHERE);

			query.append(_FINDER_COLUMN_BASKETID_BASKETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(basketID);

				List<Basket_User> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Basket_UserPersistenceImpl.fetchByBasketID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Basket_User basket_User = list.get(0);

					result = basket_User;

					cacheResult(basket_User);

					if ((basket_User.getBasketID() != basketID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
							finderArgs, basket_User);
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
			return (Basket_User)result;
		}
	}

	/**
	 * Removes the basket_ user where basketID = &#63; from the database.
	 *
	 * @param basketID the basket i d
	 * @return the basket_ user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User removeByBasketID(long basketID)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = findByBasketID(basketID);

		return remove(basket_User);
	}

	/**
	 * Returns the number of basket_ users where basketID = &#63;.
	 *
	 * @param basketID the basket i d
	 * @return the number of matching basket_ users
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

			query.append(_SQL_COUNT_BASKET_USER_WHERE);

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

	private static final String _FINDER_COLUMN_BASKETID_BASKETID_2 = "basket_User.basketID = ?";

	public Basket_UserPersistenceImpl() {
		setModelClass(Basket_User.class);
	}

	/**
	 * Caches the basket_ user in the entity cache if it is enabled.
	 *
	 * @param basket_User the basket_ user
	 */
	@Override
	public void cacheResult(Basket_User basket_User) {
		EntityCacheUtil.putResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserImpl.class, basket_User.getPrimaryKey(), basket_User);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID,
			new Object[] { basket_User.getBasketID() }, basket_User);

		basket_User.resetOriginalValues();
	}

	/**
	 * Caches the basket_ users in the entity cache if it is enabled.
	 *
	 * @param basket_Users the basket_ users
	 */
	@Override
	public void cacheResult(List<Basket_User> basket_Users) {
		for (Basket_User basket_User : basket_Users) {
			if (EntityCacheUtil.getResult(
						Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
						Basket_UserImpl.class, basket_User.getPrimaryKey()) == null) {
				cacheResult(basket_User);
			}
			else {
				basket_User.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all basket_ users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Basket_UserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Basket_UserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the basket_ user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Basket_User basket_User) {
		EntityCacheUtil.removeResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserImpl.class, basket_User.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(basket_User);
	}

	@Override
	public void clearCache(List<Basket_User> basket_Users) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Basket_User basket_User : basket_Users) {
			EntityCacheUtil.removeResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
				Basket_UserImpl.class, basket_User.getPrimaryKey());

			clearUniqueFindersCache(basket_User);
		}
	}

	protected void cacheUniqueFindersCache(Basket_User basket_User) {
		if (basket_User.isNew()) {
			Object[] args = new Object[] { basket_User.getBasketID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BASKETID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID, args,
				basket_User);
		}
		else {
			Basket_UserModelImpl basket_UserModelImpl = (Basket_UserModelImpl)basket_User;

			if ((basket_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BASKETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { basket_User.getBasketID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BASKETID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BASKETID, args,
					basket_User);
			}
		}
	}

	protected void clearUniqueFindersCache(Basket_User basket_User) {
		Basket_UserModelImpl basket_UserModelImpl = (Basket_UserModelImpl)basket_User;

		Object[] args = new Object[] { basket_User.getBasketID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASKETID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BASKETID, args);

		if ((basket_UserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BASKETID.getColumnBitmask()) != 0) {
			args = new Object[] { basket_UserModelImpl.getOriginalBasketID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASKETID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BASKETID, args);
		}
	}

	/**
	 * Creates a new basket_ user with the primary key. Does not add the basket_ user to the database.
	 *
	 * @param basketID the primary key for the new basket_ user
	 * @return the new basket_ user
	 */
	@Override
	public Basket_User create(long basketID) {
		Basket_User basket_User = new Basket_UserImpl();

		basket_User.setNew(true);
		basket_User.setPrimaryKey(basketID);

		return basket_User;
	}

	/**
	 * Removes the basket_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param basketID the primary key of the basket_ user
	 * @return the basket_ user that was removed
	 * @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User remove(long basketID)
		throws NoSuchBasket_UserException, SystemException {
		return remove((Serializable)basketID);
	}

	/**
	 * Removes the basket_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the basket_ user
	 * @return the basket_ user that was removed
	 * @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User remove(Serializable primaryKey)
		throws NoSuchBasket_UserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Basket_User basket_User = (Basket_User)session.get(Basket_UserImpl.class,
					primaryKey);

			if (basket_User == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBasket_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(basket_User);
		}
		catch (NoSuchBasket_UserException nsee) {
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
	protected Basket_User removeImpl(Basket_User basket_User)
		throws SystemException {
		basket_User = toUnwrappedModel(basket_User);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(basket_User)) {
				basket_User = (Basket_User)session.get(Basket_UserImpl.class,
						basket_User.getPrimaryKeyObj());
			}

			if (basket_User != null) {
				session.delete(basket_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (basket_User != null) {
			clearCache(basket_User);
		}

		return basket_User;
	}

	@Override
	public Basket_User updateImpl(org.gfbio.model.Basket_User basket_User)
		throws SystemException {
		basket_User = toUnwrappedModel(basket_User);

		boolean isNew = basket_User.isNew();

		Basket_UserModelImpl basket_UserModelImpl = (Basket_UserModelImpl)basket_User;

		Session session = null;

		try {
			session = openSession();

			if (basket_User.isNew()) {
				session.save(basket_User);

				basket_User.setNew(false);
			}
			else {
				session.merge(basket_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Basket_UserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((basket_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						basket_UserModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { basket_UserModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
			Basket_UserImpl.class, basket_User.getPrimaryKey(), basket_User);

		clearUniqueFindersCache(basket_User);
		cacheUniqueFindersCache(basket_User);

		return basket_User;
	}

	protected Basket_User toUnwrappedModel(Basket_User basket_User) {
		if (basket_User instanceof Basket_UserImpl) {
			return basket_User;
		}

		Basket_UserImpl basket_UserImpl = new Basket_UserImpl();

		basket_UserImpl.setNew(basket_User.isNew());
		basket_UserImpl.setPrimaryKey(basket_User.getPrimaryKey());

		basket_UserImpl.setBasketID(basket_User.getBasketID());
		basket_UserImpl.setUserID(basket_User.getUserID());
		basket_UserImpl.setName(basket_User.getName());
		basket_UserImpl.setBasketJSON(basket_User.getBasketJSON());
		basket_UserImpl.setQueryJSON(basket_User.getQueryJSON());

		return basket_UserImpl;
	}

	/**
	 * Returns the basket_ user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the basket_ user
	 * @return the basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBasket_UserException, SystemException {
		Basket_User basket_User = fetchByPrimaryKey(primaryKey);

		if (basket_User == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBasket_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return basket_User;
	}

	/**
	 * Returns the basket_ user with the primary key or throws a {@link org.gfbio.NoSuchBasket_UserException} if it could not be found.
	 *
	 * @param basketID the primary key of the basket_ user
	 * @return the basket_ user
	 * @throws org.gfbio.NoSuchBasket_UserException if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User findByPrimaryKey(long basketID)
		throws NoSuchBasket_UserException, SystemException {
		return findByPrimaryKey((Serializable)basketID);
	}

	/**
	 * Returns the basket_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the basket_ user
	 * @return the basket_ user, or <code>null</code> if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Basket_User basket_User = (Basket_User)EntityCacheUtil.getResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
				Basket_UserImpl.class, primaryKey);

		if (basket_User == _nullBasket_User) {
			return null;
		}

		if (basket_User == null) {
			Session session = null;

			try {
				session = openSession();

				basket_User = (Basket_User)session.get(Basket_UserImpl.class,
						primaryKey);

				if (basket_User != null) {
					cacheResult(basket_User);
				}
				else {
					EntityCacheUtil.putResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
						Basket_UserImpl.class, primaryKey, _nullBasket_User);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Basket_UserModelImpl.ENTITY_CACHE_ENABLED,
					Basket_UserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return basket_User;
	}

	/**
	 * Returns the basket_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param basketID the primary key of the basket_ user
	 * @return the basket_ user, or <code>null</code> if a basket_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Basket_User fetchByPrimaryKey(long basketID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)basketID);
	}

	/**
	 * Returns all the basket_ users.
	 *
	 * @return the basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the basket_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of basket_ users
	 * @param end the upper bound of the range of basket_ users (not inclusive)
	 * @return the range of basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the basket_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Basket_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of basket_ users
	 * @param end the upper bound of the range of basket_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of basket_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Basket_User> findAll(int start, int end,
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

		List<Basket_User> list = (List<Basket_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BASKET_USER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BASKET_USER;

				if (pagination) {
					sql = sql.concat(Basket_UserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Basket_User>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Basket_User>(list);
				}
				else {
					list = (List<Basket_User>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the basket_ users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Basket_User basket_User : findAll()) {
			remove(basket_User);
		}
	}

	/**
	 * Returns the number of basket_ users.
	 *
	 * @return the number of basket_ users
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

				Query q = session.createQuery(_SQL_COUNT_BASKET_USER);

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
	 * Initializes the basket_ user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Basket_User")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Basket_User>> listenersList = new ArrayList<ModelListener<Basket_User>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Basket_User>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Basket_UserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BASKET_USER = "SELECT basket_User FROM Basket_User basket_User";
	private static final String _SQL_SELECT_BASKET_USER_WHERE = "SELECT basket_User FROM Basket_User basket_User WHERE ";
	private static final String _SQL_COUNT_BASKET_USER = "SELECT COUNT(basket_User) FROM Basket_User basket_User";
	private static final String _SQL_COUNT_BASKET_USER_WHERE = "SELECT COUNT(basket_User) FROM Basket_User basket_User WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "basket_User.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Basket_User exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Basket_User exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Basket_UserPersistenceImpl.class);
	private static Basket_User _nullBasket_User = new Basket_UserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Basket_User> toCacheModel() {
				return _nullBasket_UserCacheModel;
			}
		};

	private static CacheModel<Basket_User> _nullBasket_UserCacheModel = new CacheModel<Basket_User>() {
			@Override
			public Basket_User toEntityModel() {
				return _nullBasket_User;
			}
		};
}