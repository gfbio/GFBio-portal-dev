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

import org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

import org.gfbio.model.DataProvider_PersistentIdentifier;
import org.gfbio.model.impl.DataProvider_PersistentIdentifierImpl;
import org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the data provider_ persistent identifier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifierPersistence
 * @see DataProvider_PersistentIdentifierUtil
 * @generated
 */
public class DataProvider_PersistentIdentifierPersistenceImpl
	extends BasePersistenceImpl<DataProvider_PersistentIdentifier>
	implements DataProvider_PersistentIdentifierPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DataProvider_PersistentIdentifierUtil} to access the data provider_ persistent identifier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DataProvider_PersistentIdentifierImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATAPROVIDER =
		new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataProvider",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAPROVIDER =
		new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataProvider",
			new String[] { Long.class.getName() },
			DataProvider_PersistentIdentifierModelImpl.GFBIODATAPROVIDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATAPROVIDER = new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDataProvider", new String[] { Long.class.getName() });

	/**
	 * Returns all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @return the matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider) throws SystemException {
		return findByDataProvider(gfbioDataProvider, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @return the range of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider, int start, int end) throws SystemException {
		return findByDataProvider(gfbioDataProvider, start, end, null);
	}

	/**
	 * Returns an ordered range of all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAPROVIDER;
			finderArgs = new Object[] { gfbioDataProvider };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATAPROVIDER;
			finderArgs = new Object[] {
					gfbioDataProvider,
					
					start, end, orderByComparator
				};
		}

		List<DataProvider_PersistentIdentifier> list = (List<DataProvider_PersistentIdentifier>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : list) {
				if ((gfbioDataProvider != dataProvider_PersistentIdentifier.getGfbioDataProvider())) {
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

			query.append(_SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

			query.append(_FINDER_COLUMN_DATAPROVIDER_GFBIODATAPROVIDER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DataProvider_PersistentIdentifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gfbioDataProvider);

				if (!pagination) {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider_PersistentIdentifier>(list);
				}
				else {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
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
	 * Returns the first data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByDataProvider_First(
		long gfbioDataProvider, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = fetchByDataProvider_First(gfbioDataProvider,
				orderByComparator);

		if (dataProvider_PersistentIdentifier != null) {
			return dataProvider_PersistentIdentifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gfbioDataProvider=");
		msg.append(gfbioDataProvider);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProvider_PersistentIdentifierException(msg.toString());
	}

	/**
	 * Returns the first data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByDataProvider_First(
		long gfbioDataProvider, OrderByComparator orderByComparator)
		throws SystemException {
		List<DataProvider_PersistentIdentifier> list = findByDataProvider(gfbioDataProvider,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByDataProvider_Last(
		long gfbioDataProvider, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = fetchByDataProvider_Last(gfbioDataProvider,
				orderByComparator);

		if (dataProvider_PersistentIdentifier != null) {
			return dataProvider_PersistentIdentifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gfbioDataProvider=");
		msg.append(gfbioDataProvider);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProvider_PersistentIdentifierException(msg.toString());
	}

	/**
	 * Returns the last data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByDataProvider_Last(
		long gfbioDataProvider, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDataProvider(gfbioDataProvider);

		if (count == 0) {
			return null;
		}

		List<DataProvider_PersistentIdentifier> list = findByDataProvider(gfbioDataProvider,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data provider_ persistent identifiers before and after the current data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key of the current data provider_ persistent identifier
	 * @param gfbioDataProvider the gfbio data provider
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier[] findByDataProvider_PrevAndNext(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK,
		long gfbioDataProvider, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = findByPrimaryKey(dataProvider_PersistentIdentifierPK);

		Session session = null;

		try {
			session = openSession();

			DataProvider_PersistentIdentifier[] array = new DataProvider_PersistentIdentifierImpl[3];

			array[0] = getByDataProvider_PrevAndNext(session,
					dataProvider_PersistentIdentifier, gfbioDataProvider,
					orderByComparator, true);

			array[1] = dataProvider_PersistentIdentifier;

			array[2] = getByDataProvider_PrevAndNext(session,
					dataProvider_PersistentIdentifier, gfbioDataProvider,
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

	protected DataProvider_PersistentIdentifier getByDataProvider_PrevAndNext(
		Session session,
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier,
		long gfbioDataProvider, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

		query.append(_FINDER_COLUMN_DATAPROVIDER_GFBIODATAPROVIDER_2);

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
			query.append(DataProvider_PersistentIdentifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(gfbioDataProvider);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dataProvider_PersistentIdentifier);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DataProvider_PersistentIdentifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data provider_ persistent identifiers where gfbioDataProvider = &#63; from the database.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDataProvider(long gfbioDataProvider)
		throws SystemException {
		for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : findByDataProvider(
				gfbioDataProvider, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dataProvider_PersistentIdentifier);
		}
	}

	/**
	 * Returns the number of data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	 *
	 * @param gfbioDataProvider the gfbio data provider
	 * @return the number of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDataProvider(long gfbioDataProvider)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATAPROVIDER;

		Object[] finderArgs = new Object[] { gfbioDataProvider };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

			query.append(_FINDER_COLUMN_DATAPROVIDER_GFBIODATAPROVIDER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gfbioDataProvider);

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

	private static final String _FINDER_COLUMN_DATAPROVIDER_GFBIODATAPROVIDER_2 = "dataProvider_PersistentIdentifier.id.gfbioDataProvider = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER =
		new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistentIdentifier",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER =
		new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistentIdentifier",
			new String[] { Long.class.getName() },
			DataProvider_PersistentIdentifierModelImpl.GFBIOPERSISTENTIDENTIFIER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIER = new FinderPath(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistentIdentifier", new String[] { Long.class.getName() });

	/**
	 * Returns all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @return the matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier) throws SystemException {
		return findByPersistentIdentifier(gfbioPersistentIdentifier,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @return the range of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier, int start, int end)
		throws SystemException {
		return findByPersistentIdentifier(gfbioPersistentIdentifier, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER;
			finderArgs = new Object[] { gfbioPersistentIdentifier };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER;
			finderArgs = new Object[] {
					gfbioPersistentIdentifier,
					
					start, end, orderByComparator
				};
		}

		List<DataProvider_PersistentIdentifier> list = (List<DataProvider_PersistentIdentifier>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : list) {
				if ((gfbioPersistentIdentifier != dataProvider_PersistentIdentifier.getGfbioPersistentIdentifier())) {
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

			query.append(_SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIER_GFBIOPERSISTENTIDENTIFIER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DataProvider_PersistentIdentifierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gfbioPersistentIdentifier);

				if (!pagination) {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider_PersistentIdentifier>(list);
				}
				else {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
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
	 * Returns the first data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByPersistentIdentifier_First(
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = fetchByPersistentIdentifier_First(gfbioPersistentIdentifier,
				orderByComparator);

		if (dataProvider_PersistentIdentifier != null) {
			return dataProvider_PersistentIdentifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gfbioPersistentIdentifier=");
		msg.append(gfbioPersistentIdentifier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProvider_PersistentIdentifierException(msg.toString());
	}

	/**
	 * Returns the first data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByPersistentIdentifier_First(
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator)
		throws SystemException {
		List<DataProvider_PersistentIdentifier> list = findByPersistentIdentifier(gfbioPersistentIdentifier,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByPersistentIdentifier_Last(
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = fetchByPersistentIdentifier_Last(gfbioPersistentIdentifier,
				orderByComparator);

		if (dataProvider_PersistentIdentifier != null) {
			return dataProvider_PersistentIdentifier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("gfbioPersistentIdentifier=");
		msg.append(gfbioPersistentIdentifier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDataProvider_PersistentIdentifierException(msg.toString());
	}

	/**
	 * Returns the last data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByPersistentIdentifier_Last(
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPersistentIdentifier(gfbioPersistentIdentifier);

		if (count == 0) {
			return null;
		}

		List<DataProvider_PersistentIdentifier> list = findByPersistentIdentifier(gfbioPersistentIdentifier,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the data provider_ persistent identifiers before and after the current data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key of the current data provider_ persistent identifier
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier[] findByPersistentIdentifier_PrevAndNext(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK,
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = findByPrimaryKey(dataProvider_PersistentIdentifierPK);

		Session session = null;

		try {
			session = openSession();

			DataProvider_PersistentIdentifier[] array = new DataProvider_PersistentIdentifierImpl[3];

			array[0] = getByPersistentIdentifier_PrevAndNext(session,
					dataProvider_PersistentIdentifier,
					gfbioPersistentIdentifier, orderByComparator, true);

			array[1] = dataProvider_PersistentIdentifier;

			array[2] = getByPersistentIdentifier_PrevAndNext(session,
					dataProvider_PersistentIdentifier,
					gfbioPersistentIdentifier, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DataProvider_PersistentIdentifier getByPersistentIdentifier_PrevAndNext(
		Session session,
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier,
		long gfbioPersistentIdentifier, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

		query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIER_GFBIOPERSISTENTIDENTIFIER_2);

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
			query.append(DataProvider_PersistentIdentifierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(gfbioPersistentIdentifier);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dataProvider_PersistentIdentifier);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DataProvider_PersistentIdentifier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63; from the database.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersistentIdentifier(long gfbioPersistentIdentifier)
		throws SystemException {
		for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : findByPersistentIdentifier(
				gfbioPersistentIdentifier, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dataProvider_PersistentIdentifier);
		}
	}

	/**
	 * Returns the number of data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	 *
	 * @param gfbioPersistentIdentifier the gfbio persistent identifier
	 * @return the number of matching data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPersistentIdentifier(long gfbioPersistentIdentifier)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIER;

		Object[] finderArgs = new Object[] { gfbioPersistentIdentifier };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE);

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIER_GFBIOPERSISTENTIDENTIFIER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(gfbioPersistentIdentifier);

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

	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIER_GFBIOPERSISTENTIDENTIFIER_2 =
		"dataProvider_PersistentIdentifier.id.gfbioPersistentIdentifier = ?";

	public DataProvider_PersistentIdentifierPersistenceImpl() {
		setModelClass(DataProvider_PersistentIdentifier.class);
	}

	/**
	 * Caches the data provider_ persistent identifier in the entity cache if it is enabled.
	 *
	 * @param dataProvider_PersistentIdentifier the data provider_ persistent identifier
	 */
	@Override
	public void cacheResult(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		EntityCacheUtil.putResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			dataProvider_PersistentIdentifier.getPrimaryKey(),
			dataProvider_PersistentIdentifier);

		dataProvider_PersistentIdentifier.resetOriginalValues();
	}

	/**
	 * Caches the data provider_ persistent identifiers in the entity cache if it is enabled.
	 *
	 * @param dataProvider_PersistentIdentifiers the data provider_ persistent identifiers
	 */
	@Override
	public void cacheResult(
		List<DataProvider_PersistentIdentifier> dataProvider_PersistentIdentifiers) {
		for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : dataProvider_PersistentIdentifiers) {
			if (EntityCacheUtil.getResult(
						DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
						DataProvider_PersistentIdentifierImpl.class,
						dataProvider_PersistentIdentifier.getPrimaryKey()) == null) {
				cacheResult(dataProvider_PersistentIdentifier);
			}
			else {
				dataProvider_PersistentIdentifier.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data provider_ persistent identifiers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DataProvider_PersistentIdentifierImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DataProvider_PersistentIdentifierImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data provider_ persistent identifier.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		EntityCacheUtil.removeResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			dataProvider_PersistentIdentifier.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<DataProvider_PersistentIdentifier> dataProvider_PersistentIdentifiers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : dataProvider_PersistentIdentifiers) {
			EntityCacheUtil.removeResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
				DataProvider_PersistentIdentifierImpl.class,
				dataProvider_PersistentIdentifier.getPrimaryKey());
		}
	}

	/**
	 * Creates a new data provider_ persistent identifier with the primary key. Does not add the data provider_ persistent identifier to the database.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key for the new data provider_ persistent identifier
	 * @return the new data provider_ persistent identifier
	 */
	@Override
	public DataProvider_PersistentIdentifier create(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK) {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = new DataProvider_PersistentIdentifierImpl();

		dataProvider_PersistentIdentifier.setNew(true);
		dataProvider_PersistentIdentifier.setPrimaryKey(dataProvider_PersistentIdentifierPK);

		return dataProvider_PersistentIdentifier;
	}

	/**
	 * Removes the data provider_ persistent identifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier that was removed
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier remove(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		return remove((Serializable)dataProvider_PersistentIdentifierPK);
	}

	/**
	 * Removes the data provider_ persistent identifier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier that was removed
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier remove(Serializable primaryKey)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = (DataProvider_PersistentIdentifier)session.get(DataProvider_PersistentIdentifierImpl.class,
					primaryKey);

			if (dataProvider_PersistentIdentifier == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataProvider_PersistentIdentifierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dataProvider_PersistentIdentifier);
		}
		catch (NoSuchDataProvider_PersistentIdentifierException nsee) {
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
	protected DataProvider_PersistentIdentifier removeImpl(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws SystemException {
		dataProvider_PersistentIdentifier = toUnwrappedModel(dataProvider_PersistentIdentifier);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataProvider_PersistentIdentifier)) {
				dataProvider_PersistentIdentifier = (DataProvider_PersistentIdentifier)session.get(DataProvider_PersistentIdentifierImpl.class,
						dataProvider_PersistentIdentifier.getPrimaryKeyObj());
			}

			if (dataProvider_PersistentIdentifier != null) {
				session.delete(dataProvider_PersistentIdentifier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dataProvider_PersistentIdentifier != null) {
			clearCache(dataProvider_PersistentIdentifier);
		}

		return dataProvider_PersistentIdentifier;
	}

	@Override
	public DataProvider_PersistentIdentifier updateImpl(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws SystemException {
		dataProvider_PersistentIdentifier = toUnwrappedModel(dataProvider_PersistentIdentifier);

		boolean isNew = dataProvider_PersistentIdentifier.isNew();

		DataProvider_PersistentIdentifierModelImpl dataProvider_PersistentIdentifierModelImpl =
			(DataProvider_PersistentIdentifierModelImpl)dataProvider_PersistentIdentifier;

		Session session = null;

		try {
			session = openSession();

			if (dataProvider_PersistentIdentifier.isNew()) {
				session.save(dataProvider_PersistentIdentifier);

				dataProvider_PersistentIdentifier.setNew(false);
			}
			else {
				session.merge(dataProvider_PersistentIdentifier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!DataProvider_PersistentIdentifierModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dataProvider_PersistentIdentifierModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAPROVIDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dataProvider_PersistentIdentifierModelImpl.getOriginalGfbioDataProvider()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAPROVIDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAPROVIDER,
					args);

				args = new Object[] {
						dataProvider_PersistentIdentifierModelImpl.getGfbioDataProvider()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAPROVIDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAPROVIDER,
					args);
			}

			if ((dataProvider_PersistentIdentifierModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dataProvider_PersistentIdentifierModelImpl.getOriginalGfbioPersistentIdentifier()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER,
					args);

				args = new Object[] {
						dataProvider_PersistentIdentifierModelImpl.getGfbioPersistentIdentifier()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIER,
					args);
			}
		}

		EntityCacheUtil.putResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
			DataProvider_PersistentIdentifierImpl.class,
			dataProvider_PersistentIdentifier.getPrimaryKey(),
			dataProvider_PersistentIdentifier);

		return dataProvider_PersistentIdentifier;
	}

	protected DataProvider_PersistentIdentifier toUnwrappedModel(
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier) {
		if (dataProvider_PersistentIdentifier instanceof DataProvider_PersistentIdentifierImpl) {
			return dataProvider_PersistentIdentifier;
		}

		DataProvider_PersistentIdentifierImpl dataProvider_PersistentIdentifierImpl =
			new DataProvider_PersistentIdentifierImpl();

		dataProvider_PersistentIdentifierImpl.setNew(dataProvider_PersistentIdentifier.isNew());
		dataProvider_PersistentIdentifierImpl.setPrimaryKey(dataProvider_PersistentIdentifier.getPrimaryKey());

		dataProvider_PersistentIdentifierImpl.setGfbioDataProvider(dataProvider_PersistentIdentifier.getGfbioDataProvider());
		dataProvider_PersistentIdentifierImpl.setGfbioPersistentIdentifier(dataProvider_PersistentIdentifier.getGfbioPersistentIdentifier());

		return dataProvider_PersistentIdentifierImpl;
	}

	/**
	 * Returns the data provider_ persistent identifier with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = fetchByPrimaryKey(primaryKey);

		if (dataProvider_PersistentIdentifier == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataProvider_PersistentIdentifierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dataProvider_PersistentIdentifier;
	}

	/**
	 * Returns the data provider_ persistent identifier with the primary key or throws a {@link org.gfbio.NoSuchDataProvider_PersistentIdentifierException} if it could not be found.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier
	 * @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier findByPrimaryKey(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws NoSuchDataProvider_PersistentIdentifierException, SystemException {
		return findByPrimaryKey((Serializable)dataProvider_PersistentIdentifierPK);
	}

	/**
	 * Returns the data provider_ persistent identifier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier, or <code>null</code> if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier = (DataProvider_PersistentIdentifier)EntityCacheUtil.getResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
				DataProvider_PersistentIdentifierImpl.class, primaryKey);

		if (dataProvider_PersistentIdentifier == _nullDataProvider_PersistentIdentifier) {
			return null;
		}

		if (dataProvider_PersistentIdentifier == null) {
			Session session = null;

			try {
				session = openSession();

				dataProvider_PersistentIdentifier = (DataProvider_PersistentIdentifier)session.get(DataProvider_PersistentIdentifierImpl.class,
						primaryKey);

				if (dataProvider_PersistentIdentifier != null) {
					cacheResult(dataProvider_PersistentIdentifier);
				}
				else {
					EntityCacheUtil.putResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
						DataProvider_PersistentIdentifierImpl.class,
						primaryKey, _nullDataProvider_PersistentIdentifier);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DataProvider_PersistentIdentifierModelImpl.ENTITY_CACHE_ENABLED,
					DataProvider_PersistentIdentifierImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dataProvider_PersistentIdentifier;
	}

	/**
	 * Returns the data provider_ persistent identifier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	 * @return the data provider_ persistent identifier, or <code>null</code> if a data provider_ persistent identifier with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DataProvider_PersistentIdentifier fetchByPrimaryKey(
		DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dataProvider_PersistentIdentifierPK);
	}

	/**
	 * Returns all the data provider_ persistent identifiers.
	 *
	 * @return the data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data provider_ persistent identifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @return the range of data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data provider_ persistent identifiers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of data provider_ persistent identifiers
	 * @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data provider_ persistent identifiers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DataProvider_PersistentIdentifier> findAll(int start, int end,
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

		List<DataProvider_PersistentIdentifier> list = (List<DataProvider_PersistentIdentifier>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER;

				if (pagination) {
					sql = sql.concat(DataProvider_PersistentIdentifierModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DataProvider_PersistentIdentifier>(list);
				}
				else {
					list = (List<DataProvider_PersistentIdentifier>)QueryUtil.list(q,
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
	 * Removes all the data provider_ persistent identifiers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier : findAll()) {
			remove(dataProvider_PersistentIdentifier);
		}
	}

	/**
	 * Returns the number of data provider_ persistent identifiers.
	 *
	 * @return the number of data provider_ persistent identifiers
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

				Query q = session.createQuery(_SQL_COUNT_DATAPROVIDER_PERSISTENTIDENTIFIER);

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
	 * Initializes the data provider_ persistent identifier persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.DataProvider_PersistentIdentifier")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DataProvider_PersistentIdentifier>> listenersList =
					new ArrayList<ModelListener<DataProvider_PersistentIdentifier>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DataProvider_PersistentIdentifier>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DataProvider_PersistentIdentifierImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER = "SELECT dataProvider_PersistentIdentifier FROM DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier";
	private static final String _SQL_SELECT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE =
		"SELECT dataProvider_PersistentIdentifier FROM DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier WHERE ";
	private static final String _SQL_COUNT_DATAPROVIDER_PERSISTENTIDENTIFIER = "SELECT COUNT(dataProvider_PersistentIdentifier) FROM DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier";
	private static final String _SQL_COUNT_DATAPROVIDER_PERSISTENTIDENTIFIER_WHERE =
		"SELECT COUNT(dataProvider_PersistentIdentifier) FROM DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dataProvider_PersistentIdentifier.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DataProvider_PersistentIdentifier exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DataProvider_PersistentIdentifier exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DataProvider_PersistentIdentifierPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"gfbioDataProvider", "gfbioPersistentIdentifier"
			});
	private static DataProvider_PersistentIdentifier _nullDataProvider_PersistentIdentifier =
		new DataProvider_PersistentIdentifierImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DataProvider_PersistentIdentifier> toCacheModel() {
				return _nullDataProvider_PersistentIdentifierCacheModel;
			}
		};

	private static CacheModel<DataProvider_PersistentIdentifier> _nullDataProvider_PersistentIdentifierCacheModel =
		new CacheModel<DataProvider_PersistentIdentifier>() {
			@Override
			public DataProvider_PersistentIdentifier toEntityModel() {
				return _nullDataProvider_PersistentIdentifier;
			}
		};
}