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

import org.gfbio.NoSuchtab_ResearchObjectException;

import org.gfbio.model.impl.tab_ResearchObjectImpl;
import org.gfbio.model.impl.tab_ResearchObjectModelImpl;
import org.gfbio.model.tab_ResearchObject;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tab_ research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObjectPersistence
 * @see tab_ResearchObjectUtil
 * @generated
 */
public class tab_ResearchObjectPersistenceImpl extends BasePersistenceImpl<tab_ResearchObject>
	implements tab_ResearchObjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link tab_ResearchObjectUtil} to access the tab_ research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = tab_ResearchObjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			tab_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			tab_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			tab_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			tab_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			tab_ResearchObjectModelImpl.RO_NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tab_ research objects where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @return the matching tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findByName(String ro_name)
		throws SystemException {
		return findByName(ro_name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tab_ research objects where ro_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ro_name the ro_name
	 * @param start the lower bound of the range of tab_ research objects
	 * @param end the upper bound of the range of tab_ research objects (not inclusive)
	 * @return the range of matching tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findByName(String ro_name, int start,
		int end) throws SystemException {
		return findByName(ro_name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tab_ research objects where ro_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ro_name the ro_name
	 * @param start the lower bound of the range of tab_ research objects
	 * @param end the upper bound of the range of tab_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findByName(String ro_name, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { ro_name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { ro_name, start, end, orderByComparator };
		}

		List<tab_ResearchObject> list = (List<tab_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (tab_ResearchObject tab_ResearchObject : list) {
				if (!Validator.equals(ro_name, tab_ResearchObject.getRo_name())) {
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

			query.append(_SQL_SELECT_TAB_RESEARCHOBJECT_WHERE);

			boolean bindRo_name = false;

			if (ro_name == null) {
				query.append(_FINDER_COLUMN_NAME_RO_NAME_1);
			}
			else if (ro_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_RO_NAME_3);
			}
			else {
				bindRo_name = true;

				query.append(_FINDER_COLUMN_NAME_RO_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(tab_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRo_name) {
					qPos.add(ro_name);
				}

				if (!pagination) {
					list = (List<tab_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<tab_ResearchObject>(list);
				}
				else {
					list = (List<tab_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tab_ research object
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject findByName_First(String ro_name,
		OrderByComparator orderByComparator)
		throws NoSuchtab_ResearchObjectException, SystemException {
		tab_ResearchObject tab_ResearchObject = fetchByName_First(ro_name,
				orderByComparator);

		if (tab_ResearchObject != null) {
			return tab_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ro_name=");
		msg.append(ro_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtab_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject fetchByName_First(String ro_name,
		OrderByComparator orderByComparator) throws SystemException {
		List<tab_ResearchObject> list = findByName(ro_name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tab_ research object
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject findByName_Last(String ro_name,
		OrderByComparator orderByComparator)
		throws NoSuchtab_ResearchObjectException, SystemException {
		tab_ResearchObject tab_ResearchObject = fetchByName_Last(ro_name,
				orderByComparator);

		if (tab_ResearchObject != null) {
			return tab_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ro_name=");
		msg.append(ro_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchtab_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject fetchByName_Last(String ro_name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(ro_name);

		if (count == 0) {
			return null;
		}

		List<tab_ResearchObject> list = findByName(ro_name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tab_ research objects before and after the current tab_ research object in the ordered set where ro_name = &#63;.
	 *
	 * @param ro_ID the primary key of the current tab_ research object
	 * @param ro_name the ro_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tab_ research object
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject[] findByName_PrevAndNext(long ro_ID,
		String ro_name, OrderByComparator orderByComparator)
		throws NoSuchtab_ResearchObjectException, SystemException {
		tab_ResearchObject tab_ResearchObject = findByPrimaryKey(ro_ID);

		Session session = null;

		try {
			session = openSession();

			tab_ResearchObject[] array = new tab_ResearchObjectImpl[3];

			array[0] = getByName_PrevAndNext(session, tab_ResearchObject,
					ro_name, orderByComparator, true);

			array[1] = tab_ResearchObject;

			array[2] = getByName_PrevAndNext(session, tab_ResearchObject,
					ro_name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected tab_ResearchObject getByName_PrevAndNext(Session session,
		tab_ResearchObject tab_ResearchObject, String ro_name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAB_RESEARCHOBJECT_WHERE);

		boolean bindRo_name = false;

		if (ro_name == null) {
			query.append(_FINDER_COLUMN_NAME_RO_NAME_1);
		}
		else if (ro_name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_RO_NAME_3);
		}
		else {
			bindRo_name = true;

			query.append(_FINDER_COLUMN_NAME_RO_NAME_2);
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
			query.append(tab_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRo_name) {
			qPos.add(ro_name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tab_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<tab_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tab_ research objects where ro_name = &#63; from the database.
	 *
	 * @param ro_name the ro_name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String ro_name) throws SystemException {
		for (tab_ResearchObject tab_ResearchObject : findByName(ro_name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tab_ResearchObject);
		}
	}

	/**
	 * Returns the number of tab_ research objects where ro_name = &#63;.
	 *
	 * @param ro_name the ro_name
	 * @return the number of matching tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String ro_name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { ro_name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAB_RESEARCHOBJECT_WHERE);

			boolean bindRo_name = false;

			if (ro_name == null) {
				query.append(_FINDER_COLUMN_NAME_RO_NAME_1);
			}
			else if (ro_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_RO_NAME_3);
			}
			else {
				bindRo_name = true;

				query.append(_FINDER_COLUMN_NAME_RO_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRo_name) {
					qPos.add(ro_name);
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

	private static final String _FINDER_COLUMN_NAME_RO_NAME_1 = "tab_ResearchObject.ro_name IS NULL";
	private static final String _FINDER_COLUMN_NAME_RO_NAME_2 = "tab_ResearchObject.ro_name = ?";
	private static final String _FINDER_COLUMN_NAME_RO_NAME_3 = "(tab_ResearchObject.ro_name IS NULL OR tab_ResearchObject.ro_name = '')";

	public tab_ResearchObjectPersistenceImpl() {
		setModelClass(tab_ResearchObject.class);
	}

	/**
	 * Caches the tab_ research object in the entity cache if it is enabled.
	 *
	 * @param tab_ResearchObject the tab_ research object
	 */
	@Override
	public void cacheResult(tab_ResearchObject tab_ResearchObject) {
		EntityCacheUtil.putResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectImpl.class, tab_ResearchObject.getPrimaryKey(),
			tab_ResearchObject);

		tab_ResearchObject.resetOriginalValues();
	}

	/**
	 * Caches the tab_ research objects in the entity cache if it is enabled.
	 *
	 * @param tab_ResearchObjects the tab_ research objects
	 */
	@Override
	public void cacheResult(List<tab_ResearchObject> tab_ResearchObjects) {
		for (tab_ResearchObject tab_ResearchObject : tab_ResearchObjects) {
			if (EntityCacheUtil.getResult(
						tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						tab_ResearchObjectImpl.class,
						tab_ResearchObject.getPrimaryKey()) == null) {
				cacheResult(tab_ResearchObject);
			}
			else {
				tab_ResearchObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tab_ research objects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(tab_ResearchObjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(tab_ResearchObjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tab_ research object.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(tab_ResearchObject tab_ResearchObject) {
		EntityCacheUtil.removeResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectImpl.class, tab_ResearchObject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<tab_ResearchObject> tab_ResearchObjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (tab_ResearchObject tab_ResearchObject : tab_ResearchObjects) {
			EntityCacheUtil.removeResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				tab_ResearchObjectImpl.class, tab_ResearchObject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tab_ research object with the primary key. Does not add the tab_ research object to the database.
	 *
	 * @param ro_ID the primary key for the new tab_ research object
	 * @return the new tab_ research object
	 */
	@Override
	public tab_ResearchObject create(long ro_ID) {
		tab_ResearchObject tab_ResearchObject = new tab_ResearchObjectImpl();

		tab_ResearchObject.setNew(true);
		tab_ResearchObject.setPrimaryKey(ro_ID);

		return tab_ResearchObject;
	}

	/**
	 * Removes the tab_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ro_ID the primary key of the tab_ research object
	 * @return the tab_ research object that was removed
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject remove(long ro_ID)
		throws NoSuchtab_ResearchObjectException, SystemException {
		return remove((Serializable)ro_ID);
	}

	/**
	 * Removes the tab_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tab_ research object
	 * @return the tab_ research object that was removed
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject remove(Serializable primaryKey)
		throws NoSuchtab_ResearchObjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			tab_ResearchObject tab_ResearchObject = (tab_ResearchObject)session.get(tab_ResearchObjectImpl.class,
					primaryKey);

			if (tab_ResearchObject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtab_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tab_ResearchObject);
		}
		catch (NoSuchtab_ResearchObjectException nsee) {
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
	protected tab_ResearchObject removeImpl(
		tab_ResearchObject tab_ResearchObject) throws SystemException {
		tab_ResearchObject = toUnwrappedModel(tab_ResearchObject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tab_ResearchObject)) {
				tab_ResearchObject = (tab_ResearchObject)session.get(tab_ResearchObjectImpl.class,
						tab_ResearchObject.getPrimaryKeyObj());
			}

			if (tab_ResearchObject != null) {
				session.delete(tab_ResearchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tab_ResearchObject != null) {
			clearCache(tab_ResearchObject);
		}

		return tab_ResearchObject;
	}

	@Override
	public tab_ResearchObject updateImpl(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws SystemException {
		tab_ResearchObject = toUnwrappedModel(tab_ResearchObject);

		boolean isNew = tab_ResearchObject.isNew();

		tab_ResearchObjectModelImpl tab_ResearchObjectModelImpl = (tab_ResearchObjectModelImpl)tab_ResearchObject;

		Session session = null;

		try {
			session = openSession();

			if (tab_ResearchObject.isNew()) {
				session.save(tab_ResearchObject);

				tab_ResearchObject.setNew(false);
			}
			else {
				session.merge(tab_ResearchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !tab_ResearchObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tab_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tab_ResearchObjectModelImpl.getOriginalRo_name()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { tab_ResearchObjectModelImpl.getRo_name() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			tab_ResearchObjectImpl.class, tab_ResearchObject.getPrimaryKey(),
			tab_ResearchObject);

		return tab_ResearchObject;
	}

	protected tab_ResearchObject toUnwrappedModel(
		tab_ResearchObject tab_ResearchObject) {
		if (tab_ResearchObject instanceof tab_ResearchObjectImpl) {
			return tab_ResearchObject;
		}

		tab_ResearchObjectImpl tab_ResearchObjectImpl = new tab_ResearchObjectImpl();

		tab_ResearchObjectImpl.setNew(tab_ResearchObject.isNew());
		tab_ResearchObjectImpl.setPrimaryKey(tab_ResearchObject.getPrimaryKey());

		tab_ResearchObjectImpl.setRo_ID(tab_ResearchObject.getRo_ID());
		tab_ResearchObjectImpl.setRo_name(tab_ResearchObject.getRo_name());
		tab_ResearchObjectImpl.setRo_meta(tab_ResearchObject.getRo_meta());

		return tab_ResearchObjectImpl;
	}

	/**
	 * Returns the tab_ research object with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tab_ research object
	 * @return the tab_ research object
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchtab_ResearchObjectException, SystemException {
		tab_ResearchObject tab_ResearchObject = fetchByPrimaryKey(primaryKey);

		if (tab_ResearchObject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchtab_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tab_ResearchObject;
	}

	/**
	 * Returns the tab_ research object with the primary key or throws a {@link org.gfbio.NoSuchtab_ResearchObjectException} if it could not be found.
	 *
	 * @param ro_ID the primary key of the tab_ research object
	 * @return the tab_ research object
	 * @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject findByPrimaryKey(long ro_ID)
		throws NoSuchtab_ResearchObjectException, SystemException {
		return findByPrimaryKey((Serializable)ro_ID);
	}

	/**
	 * Returns the tab_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tab_ research object
	 * @return the tab_ research object, or <code>null</code> if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		tab_ResearchObject tab_ResearchObject = (tab_ResearchObject)EntityCacheUtil.getResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				tab_ResearchObjectImpl.class, primaryKey);

		if (tab_ResearchObject == _nulltab_ResearchObject) {
			return null;
		}

		if (tab_ResearchObject == null) {
			Session session = null;

			try {
				session = openSession();

				tab_ResearchObject = (tab_ResearchObject)session.get(tab_ResearchObjectImpl.class,
						primaryKey);

				if (tab_ResearchObject != null) {
					cacheResult(tab_ResearchObject);
				}
				else {
					EntityCacheUtil.putResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						tab_ResearchObjectImpl.class, primaryKey,
						_nulltab_ResearchObject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(tab_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
					tab_ResearchObjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tab_ResearchObject;
	}

	/**
	 * Returns the tab_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ro_ID the primary key of the tab_ research object
	 * @return the tab_ research object, or <code>null</code> if a tab_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tab_ResearchObject fetchByPrimaryKey(long ro_ID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ro_ID);
	}

	/**
	 * Returns all the tab_ research objects.
	 *
	 * @return the tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tab_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tab_ research objects
	 * @param end the upper bound of the range of tab_ research objects (not inclusive)
	 * @return the range of tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tab_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tab_ research objects
	 * @param end the upper bound of the range of tab_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tab_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<tab_ResearchObject> findAll(int start, int end,
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

		List<tab_ResearchObject> list = (List<tab_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAB_RESEARCHOBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAB_RESEARCHOBJECT;

				if (pagination) {
					sql = sql.concat(tab_ResearchObjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<tab_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<tab_ResearchObject>(list);
				}
				else {
					list = (List<tab_ResearchObject>)QueryUtil.list(q,
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
	 * Removes all the tab_ research objects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (tab_ResearchObject tab_ResearchObject : findAll()) {
			remove(tab_ResearchObject);
		}
	}

	/**
	 * Returns the number of tab_ research objects.
	 *
	 * @return the number of tab_ research objects
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

				Query q = session.createQuery(_SQL_COUNT_TAB_RESEARCHOBJECT);

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
	 * Initializes the tab_ research object persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.tab_ResearchObject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<tab_ResearchObject>> listenersList = new ArrayList<ModelListener<tab_ResearchObject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<tab_ResearchObject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(tab_ResearchObjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAB_RESEARCHOBJECT = "SELECT tab_ResearchObject FROM tab_ResearchObject tab_ResearchObject";
	private static final String _SQL_SELECT_TAB_RESEARCHOBJECT_WHERE = "SELECT tab_ResearchObject FROM tab_ResearchObject tab_ResearchObject WHERE ";
	private static final String _SQL_COUNT_TAB_RESEARCHOBJECT = "SELECT COUNT(tab_ResearchObject) FROM tab_ResearchObject tab_ResearchObject";
	private static final String _SQL_COUNT_TAB_RESEARCHOBJECT_WHERE = "SELECT COUNT(tab_ResearchObject) FROM tab_ResearchObject tab_ResearchObject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tab_ResearchObject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No tab_ResearchObject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No tab_ResearchObject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(tab_ResearchObjectPersistenceImpl.class);
	private static tab_ResearchObject _nulltab_ResearchObject = new tab_ResearchObjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<tab_ResearchObject> toCacheModel() {
				return _nulltab_ResearchObjectCacheModel;
			}
		};

	private static CacheModel<tab_ResearchObject> _nulltab_ResearchObjectCacheModel =
		new CacheModel<tab_ResearchObject>() {
			@Override
			public tab_ResearchObject toEntityModel() {
				return _nulltab_ResearchObject;
			}
		};
}