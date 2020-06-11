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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchDataProviderException;

import org.gfbio.model.DataProvider;
import org.gfbio.model.impl.DataProviderImpl;
import org.gfbio.model.impl.DataProviderModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the data provider service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProviderPersistence
 * @see DataProviderUtil
 * @generated
 */
public class DataProviderPersistenceImpl extends BasePersistenceImpl<DataProvider>
	implements DataProviderPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DataProviderUtil} to access the data provider persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DataProviderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			DataProviderModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the data providers where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data providers where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @return the range of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data providers where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<DataProvider> list = (List<DataProvider>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataProvider dataProvider : list) {
				if (!Validator.equals(name, dataProvider.getName())) {
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

			query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DataProviderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider>(list);
				}
				else {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first data provider in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByName_First(name, orderByComparator);

		if (dataProvider != null) {
			return dataProvider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProviderException(msg.toString());
	}

	/**
	 * Returns the first data provider in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<DataProvider> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data provider in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByName_Last(name, orderByComparator);

		if (dataProvider != null) {
			return dataProvider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProviderException(msg.toString());
	}

	/**
	 * Returns the last data provider in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<DataProvider> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data providers before and after the current data provider in the ordered set where name = &#63;.
	 *
	 * @param dataProviderID the primary key of the current data provider
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider[] findByName_PrevAndNext(long dataProviderID,
		String name, OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = findByPrimaryKey(dataProviderID);

		Session session = null;

		try {
			session = openSession();

			DataProvider[] array = new DataProviderImpl[3];

			array[0] = getByName_PrevAndNext(session, dataProvider, name,
					orderByComparator, true);

			array[1] = dataProvider;

			array[2] = getByName_PrevAndNext(session, dataProvider, name,
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

	protected DataProvider getByName_PrevAndNext(Session session,
		DataProvider dataProvider, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(DataProviderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dataProvider);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DataProvider> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data providers where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (DataProvider dataProvider : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dataProvider);
		}
	}

	/**
	 * Returns the number of data providers where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "dataProvider.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "dataProvider.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(dataProvider.name IS NULL OR dataProvider.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LABEL = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLabel",
			new String[] { String.class.getName() },
			DataProviderModelImpl.LABEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABEL = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLabel",
			new String[] { String.class.getName() });

	/**
	 * Returns the data provider where label = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	 *
	 * @param label the label
	 * @return the matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByLabel(String label)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByLabel(label);

		if (dataProvider == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("label=");
			msg.append(label);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDataProviderException(msg.toString());
		}

		return dataProvider;
	}

	/**
	 * Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param label the label
	 * @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByLabel(String label) throws SystemException {
		return fetchByLabel(label, true);
	}

	/**
	 * Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param label the label
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByLabel(String label, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { label };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LABEL,
					finderArgs, this);
		}

		if (result instanceof DataProvider) {
			DataProvider dataProvider = (DataProvider)result;

			if (!Validator.equals(label, dataProvider.getLabel())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_LABEL_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
				}

				List<DataProvider> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DataProviderPersistenceImpl.fetchByLabel(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DataProvider dataProvider = list.get(0);

					result = dataProvider;

					cacheResult(dataProvider);

					if ((dataProvider.getLabel() == null) ||
							!dataProvider.getLabel().equals(label)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
							finderArgs, dataProvider);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL,
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
			return (DataProvider)result;
		}
	}

	/**
	 * Removes the data provider where label = &#63; from the database.
	 *
	 * @param label the label
	 * @return the data provider that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider removeByLabel(String label)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = findByLabel(label);

		return remove(dataProvider);
	}

	/**
	 * Returns the number of data providers where label = &#63;.
	 *
	 * @param label the label
	 * @return the number of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLabel(String label) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABEL;

		Object[] finderArgs = new Object[] { label };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_LABEL_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
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

	private static final String _FINDER_COLUMN_LABEL_LABEL_1 = "dataProvider.label IS NULL";
	private static final String _FINDER_COLUMN_LABEL_LABEL_2 = "dataProvider.label = ?";
	private static final String _FINDER_COLUMN_LABEL_LABEL_3 = "(dataProvider.label IS NULL OR dataProvider.label = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DATAPROVIDERID = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDataProviderID",
			new String[] { Long.class.getName() },
			DataProviderModelImpl.DATAPROVIDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATAPROVIDERID = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataProviderID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the data provider where dataProviderID = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	 *
	 * @param dataProviderID the data provider i d
	 * @return the matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByDataProviderID(long dataProviderID)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByDataProviderID(dataProviderID);

		if (dataProvider == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dataProviderID=");
			msg.append(dataProviderID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDataProviderException(msg.toString());
		}

		return dataProvider;
	}

	/**
	 * Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataProviderID the data provider i d
	 * @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByDataProviderID(long dataProviderID)
		throws SystemException {
		return fetchByDataProviderID(dataProviderID, true);
	}

	/**
	 * Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataProviderID the data provider i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByDataProviderID(long dataProviderID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dataProviderID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
					finderArgs, this);
		}

		if (result instanceof DataProvider) {
			DataProvider dataProvider = (DataProvider)result;

			if ((dataProviderID != dataProvider.getDataProviderID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

			query.append(_FINDER_COLUMN_DATAPROVIDERID_DATAPROVIDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataProviderID);

				List<DataProvider> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DataProviderPersistenceImpl.fetchByDataProviderID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DataProvider dataProvider = list.get(0);

					result = dataProvider;

					cacheResult(dataProvider);

					if ((dataProvider.getDataProviderID() != dataProviderID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
							finderArgs, dataProvider);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
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
			return (DataProvider)result;
		}
	}

	/**
	 * Removes the data provider where dataProviderID = &#63; from the database.
	 *
	 * @param dataProviderID the data provider i d
	 * @return the data provider that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider removeByDataProviderID(long dataProviderID)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = findByDataProviderID(dataProviderID);

		return remove(dataProvider);
	}

	/**
	 * Returns the number of data providers where dataProviderID = &#63;.
	 *
	 * @param dataProviderID the data provider i d
	 * @return the number of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDataProviderID(long dataProviderID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATAPROVIDERID;

		Object[] finderArgs = new Object[] { dataProviderID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_WHERE);

			query.append(_FINDER_COLUMN_DATAPROVIDERID_DATAPROVIDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dataProviderID);

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

	private static final String _FINDER_COLUMN_DATAPROVIDERID_DATAPROVIDERID_2 = "dataProvider.dataProviderID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVIDERTYPE =
		new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProviderType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVIDERTYPE =
		new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, DataProviderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProviderType",
			new String[] { String.class.getName() },
			DataProviderModelImpl.PROVIDERTYPE_COLUMN_BITMASK |
			DataProviderModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROVIDERTYPE = new FinderPath(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProviderType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the data providers where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @return the matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByProviderType(String providerType)
		throws SystemException {
		return findByProviderType(providerType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data providers where providerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param providerType the provider type
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @return the range of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByProviderType(String providerType,
		int start, int end) throws SystemException {
		return findByProviderType(providerType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data providers where providerType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param providerType the provider type
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findByProviderType(String providerType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVIDERTYPE;
			finderArgs = new Object[] { providerType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROVIDERTYPE;
			finderArgs = new Object[] {
					providerType,
					
					start, end, orderByComparator
				};
		}

		List<DataProvider> list = (List<DataProvider>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataProvider dataProvider : list) {
				if (!Validator.equals(providerType,
							dataProvider.getProviderType())) {
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

			query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

			boolean bindProviderType = false;

			if (providerType == null) {
				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_1);
			}
			else if (providerType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_3);
			}
			else {
				bindProviderType = true;

				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DataProviderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProviderType) {
					qPos.add(providerType);
				}

				if (!pagination) {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider>(list);
				}
				else {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first data provider in the ordered set where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByProviderType_First(String providerType,
		OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByProviderType_First(providerType,
				orderByComparator);

		if (dataProvider != null) {
			return dataProvider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("providerType=");
		msg.append(providerType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProviderException(msg.toString());
	}

	/**
	 * Returns the first data provider in the ordered set where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByProviderType_First(String providerType,
		OrderByComparator orderByComparator) throws SystemException {
		List<DataProvider> list = findByProviderType(providerType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data provider in the ordered set where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByProviderType_Last(String providerType,
		OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByProviderType_Last(providerType,
				orderByComparator);

		if (dataProvider != null) {
			return dataProvider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("providerType=");
		msg.append(providerType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProviderException(msg.toString());
	}

	/**
	 * Returns the last data provider in the ordered set where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider, or <code>null</code> if a matching data provider could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByProviderType_Last(String providerType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProviderType(providerType);

		if (count == 0) {
			return null;
		}

		List<DataProvider> list = findByProviderType(providerType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data providers before and after the current data provider in the ordered set where providerType = &#63;.
	 *
	 * @param dataProviderID the primary key of the current data provider
	 * @param providerType the provider type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider[] findByProviderType_PrevAndNext(long dataProviderID,
		String providerType, OrderByComparator orderByComparator)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = findByPrimaryKey(dataProviderID);

		Session session = null;

		try {
			session = openSession();

			DataProvider[] array = new DataProviderImpl[3];

			array[0] = getByProviderType_PrevAndNext(session, dataProvider,
					providerType, orderByComparator, true);

			array[1] = dataProvider;

			array[2] = getByProviderType_PrevAndNext(session, dataProvider,
					providerType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataProvider getByProviderType_PrevAndNext(Session session,
		DataProvider dataProvider, String providerType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAPROVIDER_WHERE);

		boolean bindProviderType = false;

		if (providerType == null) {
			query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_1);
		}
		else if (providerType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_3);
		}
		else {
			bindProviderType = true;

			query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_2);
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
			query.append(DataProviderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindProviderType) {
			qPos.add(providerType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dataProvider);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DataProvider> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data providers where providerType = &#63; from the database.
	 *
	 * @param providerType the provider type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProviderType(String providerType)
		throws SystemException {
		for (DataProvider dataProvider : findByProviderType(providerType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dataProvider);
		}
	}

	/**
	 * Returns the number of data providers where providerType = &#63;.
	 *
	 * @param providerType the provider type
	 * @return the number of matching data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProviderType(String providerType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROVIDERTYPE;

		Object[] finderArgs = new Object[] { providerType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_WHERE);

			boolean bindProviderType = false;

			if (providerType == null) {
				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_1);
			}
			else if (providerType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_3);
			}
			else {
				bindProviderType = true;

				query.append(_FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProviderType) {
					qPos.add(providerType);
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

	private static final String _FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_1 = "dataProvider.providerType IS NULL";
	private static final String _FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_2 = "dataProvider.providerType = ?";
	private static final String _FINDER_COLUMN_PROVIDERTYPE_PROVIDERTYPE_3 = "(dataProvider.providerType IS NULL OR dataProvider.providerType = '')";

	public DataProviderPersistenceImpl() {
		setModelClass(DataProvider.class);
	}

	/**
	 * Caches the data provider in the entity cache if it is enabled.
	 *
	 * @param dataProvider the data provider
	 */
	@Override
	public void cacheResult(DataProvider dataProvider) {
		EntityCacheUtil.putResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderImpl.class, dataProvider.getPrimaryKey(), dataProvider);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL,
			new Object[] { dataProvider.getLabel() }, dataProvider);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
			new Object[] { dataProvider.getDataProviderID() }, dataProvider);

		dataProvider.resetOriginalValues();
	}

	/**
	 * Caches the data providers in the entity cache if it is enabled.
	 *
	 * @param dataProviders the data providers
	 */
	@Override
	public void cacheResult(List<DataProvider> dataProviders) {
		for (DataProvider dataProvider : dataProviders) {
			if (EntityCacheUtil.getResult(
						DataProviderModelImpl.ENTITY_CACHE_ENABLED,
						DataProviderImpl.class, dataProvider.getPrimaryKey()) == null) {
				cacheResult(dataProvider);
			}
			else {
				dataProvider.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data providers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DataProviderImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DataProviderImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data provider.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataProvider dataProvider) {
		EntityCacheUtil.removeResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderImpl.class, dataProvider.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dataProvider);
	}

	@Override
	public void clearCache(List<DataProvider> dataProviders) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataProvider dataProvider : dataProviders) {
			EntityCacheUtil.removeResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
				DataProviderImpl.class, dataProvider.getPrimaryKey());

			clearUniqueFindersCache(dataProvider);
		}
	}

	protected void cacheUniqueFindersCache(DataProvider dataProvider) {
		if (dataProvider.isNew()) {
			Object[] args = new Object[] { dataProvider.getLabel() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LABEL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL, args,
				dataProvider);

			args = new Object[] { dataProvider.getDataProviderID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATAPROVIDERID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
				args, dataProvider);
		}
		else {
			DataProviderModelImpl dataProviderModelImpl = (DataProviderModelImpl)dataProvider;

			if ((dataProviderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LABEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dataProvider.getLabel() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LABEL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LABEL, args,
					dataProvider);
			}

			if ((dataProviderModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DATAPROVIDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dataProvider.getDataProviderID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATAPROVIDERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
					args, dataProvider);
			}
		}
	}

	protected void clearUniqueFindersCache(DataProvider dataProvider) {
		DataProviderModelImpl dataProviderModelImpl = (DataProviderModelImpl)dataProvider;

		Object[] args = new Object[] { dataProvider.getLabel() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL, args);

		if ((dataProviderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LABEL.getColumnBitmask()) != 0) {
			args = new Object[] { dataProviderModelImpl.getOriginalLabel() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LABEL, args);
		}

		args = new Object[] { dataProvider.getDataProviderID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAPROVIDERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID, args);

		if ((dataProviderModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DATAPROVIDERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					dataProviderModelImpl.getOriginalDataProviderID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAPROVIDERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DATAPROVIDERID,
				args);
		}
	}

	/**
	 * Creates a new data provider with the primary key. Does not add the data provider to the database.
	 *
	 * @param dataProviderID the primary key for the new data provider
	 * @return the new data provider
	 */
	@Override
	public DataProvider create(long dataProviderID) {
		DataProvider dataProvider = new DataProviderImpl();

		dataProvider.setNew(true);
		dataProvider.setPrimaryKey(dataProviderID);

		return dataProvider;
	}

	/**
	 * Removes the data provider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataProviderID the primary key of the data provider
	 * @return the data provider that was removed
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider remove(long dataProviderID)
		throws NoSuchDataProviderException, SystemException {
		return remove((Serializable)dataProviderID);
	}

	/**
	 * Removes the data provider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data provider
	 * @return the data provider that was removed
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider remove(Serializable primaryKey)
		throws NoSuchDataProviderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DataProvider dataProvider = (DataProvider)session.get(DataProviderImpl.class,
					primaryKey);

			if (dataProvider == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataProviderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dataProvider);
		}
		catch (NoSuchDataProviderException nsee) {
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
	protected DataProvider removeImpl(DataProvider dataProvider)
		throws SystemException {
		dataProvider = toUnwrappedModel(dataProvider);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataProvider)) {
				dataProvider = (DataProvider)session.get(DataProviderImpl.class,
						dataProvider.getPrimaryKeyObj());
			}

			if (dataProvider != null) {
				session.delete(dataProvider);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataProvider != null) {
			clearCache(dataProvider);
		}

		return dataProvider;
	}

	@Override
	public DataProvider updateImpl(org.gfbio.model.DataProvider dataProvider)
		throws SystemException {
		dataProvider = toUnwrappedModel(dataProvider);

		boolean isNew = dataProvider.isNew();

		DataProviderModelImpl dataProviderModelImpl = (DataProviderModelImpl)dataProvider;

		Session session = null;

		try {
			session = openSession();

			if (dataProvider.isNew()) {
				session.save(dataProvider);

				dataProvider.setNew(false);
			}
			else {
				session.merge(dataProvider);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DataProviderModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dataProviderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dataProviderModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { dataProviderModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((dataProviderModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVIDERTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dataProviderModelImpl.getOriginalProviderType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVIDERTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVIDERTYPE,
					args);

				args = new Object[] { dataProviderModelImpl.getProviderType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROVIDERTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROVIDERTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
			DataProviderImpl.class, dataProvider.getPrimaryKey(), dataProvider);

		clearUniqueFindersCache(dataProvider);
		cacheUniqueFindersCache(dataProvider);

		return dataProvider;
	}

	protected DataProvider toUnwrappedModel(DataProvider dataProvider) {
		if (dataProvider instanceof DataProviderImpl) {
			return dataProvider;
		}

		DataProviderImpl dataProviderImpl = new DataProviderImpl();

		dataProviderImpl.setNew(dataProvider.isNew());
		dataProviderImpl.setPrimaryKey(dataProvider.getPrimaryKey());

		dataProviderImpl.setDataProviderID(dataProvider.getDataProviderID());
		dataProviderImpl.setName(dataProvider.getName());
		dataProviderImpl.setLabel(dataProvider.getLabel());
		dataProviderImpl.setDescription(dataProvider.getDescription());
		dataProviderImpl.setAddress(dataProvider.getAddress());
		dataProviderImpl.setWebsite(dataProvider.getWebsite());
		dataProviderImpl.setTraining(dataProvider.getTraining());
		dataProviderImpl.setPhysicalobjectpossible(dataProvider.isPhysicalobjectpossible());
		dataProviderImpl.setNophysicalobject(dataProvider.isNophysicalobject());
		dataProviderImpl.setTaxonbased(dataProvider.isTaxonbased());
		dataProviderImpl.setNotaxonbased(dataProvider.isNotaxonbased());
		dataProviderImpl.setLivingobjects(dataProvider.isLivingobjects());
		dataProviderImpl.setDeadobjects(dataProvider.isDeadobjects());
		dataProviderImpl.setSequencedata(dataProvider.isSequencedata());
		dataProviderImpl.setProviderType(dataProvider.getProviderType());
		dataProviderImpl.setLastModifiedDate(dataProvider.getLastModifiedDate());

		return dataProviderImpl;
	}

	/**
	 * Returns the data provider with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the data provider
	 * @return the data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataProviderException, SystemException {
		DataProvider dataProvider = fetchByPrimaryKey(primaryKey);

		if (dataProvider == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataProviderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dataProvider;
	}

	/**
	 * Returns the data provider with the primary key or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	 *
	 * @param dataProviderID the primary key of the data provider
	 * @return the data provider
	 * @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider findByPrimaryKey(long dataProviderID)
		throws NoSuchDataProviderException, SystemException {
		return findByPrimaryKey((Serializable)dataProviderID);
	}

	/**
	 * Returns the data provider with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data provider
	 * @return the data provider, or <code>null</code> if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DataProvider dataProvider = (DataProvider)EntityCacheUtil.getResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
				DataProviderImpl.class, primaryKey);

		if (dataProvider == _nullDataProvider) {
			return null;
		}

		if (dataProvider == null) {
			Session session = null;

			try {
				session = openSession();

				dataProvider = (DataProvider)session.get(DataProviderImpl.class,
						primaryKey);

				if (dataProvider != null) {
					cacheResult(dataProvider);
				}
				else {
					EntityCacheUtil.putResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
						DataProviderImpl.class, primaryKey, _nullDataProvider);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DataProviderModelImpl.ENTITY_CACHE_ENABLED,
					DataProviderImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dataProvider;
	}

	/**
	 * Returns the data provider with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataProviderID the primary key of the data provider
	 * @return the data provider, or <code>null</code> if a data provider with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider fetchByPrimaryKey(long dataProviderID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dataProviderID);
	}

	/**
	 * Returns all the data providers.
	 *
	 * @return the data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data providers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @return the range of data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data providers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data providers
	 * @param end the upper bound of the range of data providers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data providers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider> findAll(int start, int end,
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

		List<DataProvider> list = (List<DataProvider>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DATAPROVIDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAPROVIDER;

				if (pagination) {
					sql = sql.concat(DataProviderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider>(list);
				}
				else {
					list = (List<DataProvider>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the data providers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DataProvider dataProvider : findAll()) {
			remove(dataProvider);
		}
	}

	/**
	 * Returns the number of data providers.
	 *
	 * @return the number of data providers
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

				Query q = session.createQuery(_SQL_COUNT_DATAPROVIDER);

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
	 * Initializes the data provider persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.DataProvider")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DataProvider>> listenersList = new ArrayList<ModelListener<DataProvider>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DataProvider>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DataProviderImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DATAPROVIDER = "SELECT dataProvider FROM DataProvider dataProvider";
	private static final String _SQL_SELECT_DATAPROVIDER_WHERE = "SELECT dataProvider FROM DataProvider dataProvider WHERE ";
	private static final String _SQL_COUNT_DATAPROVIDER = "SELECT COUNT(dataProvider) FROM DataProvider dataProvider";
	private static final String _SQL_COUNT_DATAPROVIDER_WHERE = "SELECT COUNT(dataProvider) FROM DataProvider dataProvider WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dataProvider.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataProvider exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataProvider exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DataProviderPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static DataProvider _nullDataProvider = new DataProviderImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DataProvider> toCacheModel() {
				return _nullDataProviderCacheModel;
			}
		};

	private static CacheModel<DataProvider> _nullDataProviderCacheModel = new CacheModel<DataProvider>() {
			@Override
			public DataProvider toEntityModel() {
				return _nullDataProvider;
			}
		};
}