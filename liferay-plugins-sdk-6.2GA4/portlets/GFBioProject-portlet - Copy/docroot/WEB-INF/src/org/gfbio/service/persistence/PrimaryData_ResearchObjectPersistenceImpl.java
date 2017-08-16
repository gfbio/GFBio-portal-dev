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

import org.gfbio.NoSuchPrimaryData_ResearchObjectException;

import org.gfbio.model.PrimaryData_ResearchObject;
import org.gfbio.model.impl.PrimaryData_ResearchObjectImpl;
import org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the primary data_ research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PrimaryData_ResearchObjectPersistence
 * @see PrimaryData_ResearchObjectUtil
 * @generated
 */
public class PrimaryData_ResearchObjectPersistenceImpl
	extends BasePersistenceImpl<PrimaryData_ResearchObject>
	implements PrimaryData_ResearchObjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrimaryData_ResearchObjectUtil} to access the primary data_ research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrimaryData_ResearchObjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYDATAID =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrimaryDataID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYDATAID =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrimaryDataID",
			new String[] { Long.class.getName() },
			PrimaryData_ResearchObjectModelImpl.PRIMARYDATAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIMARYDATAID = new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPrimaryDataID", new String[] { Long.class.getName() });

	/**
	 * Returns all the primary data_ research objects where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID) throws SystemException {
		return findByPrimaryDataID(primaryDataID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary data_ research objects where primaryDataID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param primaryDataID the primary data i d
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @return the range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID, int start, int end) throws SystemException {
		return findByPrimaryDataID(primaryDataID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary data_ research objects where primaryDataID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param primaryDataID the primary data i d
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYDATAID;
			finderArgs = new Object[] { primaryDataID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYDATAID;
			finderArgs = new Object[] {
					primaryDataID,
					
					start, end, orderByComparator
				};
		}

		List<PrimaryData_ResearchObject> list = (List<PrimaryData_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PrimaryData_ResearchObject primaryData_ResearchObject : list) {
				if ((primaryDataID != primaryData_ResearchObject.getPrimaryDataID())) {
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

			query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(primaryDataID);

				if (!pagination) {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrimaryData_ResearchObject>(list);
				}
				else {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first primary data_ research object in the ordered set where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByPrimaryDataID_First(
		long primaryDataID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByPrimaryDataID_First(primaryDataID,
				orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("primaryDataID=");
		msg.append(primaryDataID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first primary data_ research object in the ordered set where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByPrimaryDataID_First(
		long primaryDataID, OrderByComparator orderByComparator)
		throws SystemException {
		List<PrimaryData_ResearchObject> list = findByPrimaryDataID(primaryDataID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByPrimaryDataID_Last(
		long primaryDataID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByPrimaryDataID_Last(primaryDataID,
				orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("primaryDataID=");
		msg.append(primaryDataID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByPrimaryDataID_Last(
		long primaryDataID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPrimaryDataID(primaryDataID);

		if (count == 0) {
			return null;
		}

		List<PrimaryData_ResearchObject> list = findByPrimaryDataID(primaryDataID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where primaryDataID = &#63;.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	 * @param primaryDataID the primary data i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject[] findByPrimaryDataID_PrevAndNext(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long primaryDataID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = findByPrimaryKey(primaryData_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			PrimaryData_ResearchObject[] array = new PrimaryData_ResearchObjectImpl[3];

			array[0] = getByPrimaryDataID_PrevAndNext(session,
					primaryData_ResearchObject, primaryDataID,
					orderByComparator, true);

			array[1] = primaryData_ResearchObject;

			array[2] = getByPrimaryDataID_PrevAndNext(session,
					primaryData_ResearchObject, primaryDataID,
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

	protected PrimaryData_ResearchObject getByPrimaryDataID_PrevAndNext(
		Session session, PrimaryData_ResearchObject primaryData_ResearchObject,
		long primaryDataID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

		query.append(_FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2);

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
			query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(primaryDataID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(primaryData_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PrimaryData_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the primary data_ research objects where primaryDataID = &#63; from the database.
	 *
	 * @param primaryDataID the primary data i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrimaryDataID(long primaryDataID)
		throws SystemException {
		for (PrimaryData_ResearchObject primaryData_ResearchObject : findByPrimaryDataID(
				primaryDataID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(primaryData_ResearchObject);
		}
	}

	/**
	 * Returns the number of primary data_ research objects where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the number of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrimaryDataID(long primaryDataID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIMARYDATAID;

		Object[] finderArgs = new Object[] { primaryDataID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(primaryDataID);

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

	private static final String _FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2 = "primaryData_ResearchObject.id.primaryDataID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchObjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectID", new String[] { Long.class.getName() },
			PrimaryData_ResearchObjectModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID", new String[] { Long.class.getName() });

	/**
	 * Returns all the primary data_ research objects where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID) throws SystemException {
		return findByResearchObjectID(researchObjectID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary data_ research objects where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @return the range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end) throws SystemException {
		return findByResearchObjectID(researchObjectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary data_ research objects where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID;
			finderArgs = new Object[] { researchObjectID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID;
			finderArgs = new Object[] {
					researchObjectID,
					
					start, end, orderByComparator
				};
		}

		List<PrimaryData_ResearchObject> list = (List<PrimaryData_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PrimaryData_ResearchObject primaryData_ResearchObject : list) {
				if ((researchObjectID != primaryData_ResearchObject.getResearchObjectID())) {
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

			query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (!pagination) {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrimaryData_ResearchObject>(list);
				}
				else {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first primary data_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByResearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByResearchObjectID_First(researchObjectID,
				orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first primary data_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByResearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		List<PrimaryData_ResearchObject> list = findByResearchObjectID(researchObjectID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByResearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByResearchObjectID_Last(researchObjectID,
				orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResearchObjectID(researchObjectID);

		if (count == 0) {
			return null;
		}

		List<PrimaryData_ResearchObject> list = findByResearchObjectID(researchObjectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject[] findByResearchObjectID_PrevAndNext(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = findByPrimaryKey(primaryData_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			PrimaryData_ResearchObject[] array = new PrimaryData_ResearchObjectImpl[3];

			array[0] = getByResearchObjectID_PrevAndNext(session,
					primaryData_ResearchObject, researchObjectID,
					orderByComparator, true);

			array[1] = primaryData_ResearchObject;

			array[2] = getByResearchObjectID_PrevAndNext(session,
					primaryData_ResearchObject, researchObjectID,
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

	protected PrimaryData_ResearchObject getByResearchObjectID_PrevAndNext(
		Session session, PrimaryData_ResearchObject primaryData_ResearchObject,
		long researchObjectID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

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
			query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(primaryData_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PrimaryData_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the primary data_ research objects where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectID(long researchObjectID)
		throws SystemException {
		for (PrimaryData_ResearchObject primaryData_ResearchObject : findByResearchObjectID(
				researchObjectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(primaryData_ResearchObject);
		}
	}

	/**
	 * Returns the number of primary data_ research objects where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectID(long researchObjectID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTID;

		Object[] finderArgs = new Object[] { researchObjectID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2 =
		"primaryData_ResearchObject.id.researchObjectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResearchObjectIDAndVersion",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectIDAndVersion",
			new String[] { Long.class.getName(), Integer.class.getName() },
			PrimaryData_ResearchObjectModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			PrimaryData_ResearchObjectModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectIDAndVersion",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws SystemException {
		return findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @return the range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws SystemException {
		return findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION;
			finderArgs = new Object[] { researchObjectID, researchObjectVersion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION;
			finderArgs = new Object[] {
					researchObjectID, researchObjectVersion,
					
					start, end, orderByComparator
				};
		}

		List<PrimaryData_ResearchObject> list = (List<PrimaryData_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PrimaryData_ResearchObject primaryData_ResearchObject : list) {
				if ((researchObjectID != primaryData_ResearchObject.getResearchObjectID()) ||
						(researchObjectVersion != primaryData_ResearchObject.getResearchObjectVersion())) {
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

			query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				qPos.add(researchObjectVersion);

				if (!pagination) {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrimaryData_ResearchObject>(list);
				}
				else {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByResearchObjectIDAndVersion_First(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		List<PrimaryData_ResearchObject> list = findByResearchObjectIDAndVersion(researchObjectID,
				researchObjectVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByResearchObjectIDAndVersion_Last(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (primaryData_ResearchObject != null) {
			return primaryData_ResearchObject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrimaryData_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResearchObjectIDAndVersion(researchObjectID,
				researchObjectVersion);

		if (count == 0) {
			return null;
		}

		List<PrimaryData_ResearchObject> list = findByResearchObjectIDAndVersion(researchObjectID,
				researchObjectVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject[] findByResearchObjectIDAndVersion_PrevAndNext(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = findByPrimaryKey(primaryData_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			PrimaryData_ResearchObject[] array = new PrimaryData_ResearchObjectImpl[3];

			array[0] = getByResearchObjectIDAndVersion_PrevAndNext(session,
					primaryData_ResearchObject, researchObjectID,
					researchObjectVersion, orderByComparator, true);

			array[1] = primaryData_ResearchObject;

			array[2] = getByResearchObjectIDAndVersion_PrevAndNext(session,
					primaryData_ResearchObject, researchObjectID,
					researchObjectVersion, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrimaryData_ResearchObject getByResearchObjectIDAndVersion_PrevAndNext(
		Session session, PrimaryData_ResearchObject primaryData_ResearchObject,
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTID_2);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2);

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
			query.append(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		qPos.add(researchObjectVersion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(primaryData_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PrimaryData_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		for (PrimaryData_ResearchObject primaryData_ResearchObject : findByResearchObjectIDAndVersion(
				researchObjectID, researchObjectVersion, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(primaryData_ResearchObject);
		}
	}

	/**
	 * Returns the number of primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the number of matching primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION;

		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				qPos.add(researchObjectVersion);

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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTID_2 =
		"primaryData_ResearchObject.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2 =
		"primaryData_ResearchObject.id.researchObjectVersion = ?";

	public PrimaryData_ResearchObjectPersistenceImpl() {
		setModelClass(PrimaryData_ResearchObject.class);
	}

	/**
	 * Caches the primary data_ research object in the entity cache if it is enabled.
	 *
	 * @param primaryData_ResearchObject the primary data_ research object
	 */
	@Override
	public void cacheResult(
		PrimaryData_ResearchObject primaryData_ResearchObject) {
		EntityCacheUtil.putResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			primaryData_ResearchObject.getPrimaryKey(),
			primaryData_ResearchObject);

		primaryData_ResearchObject.resetOriginalValues();
	}

	/**
	 * Caches the primary data_ research objects in the entity cache if it is enabled.
	 *
	 * @param primaryData_ResearchObjects the primary data_ research objects
	 */
	@Override
	public void cacheResult(
		List<PrimaryData_ResearchObject> primaryData_ResearchObjects) {
		for (PrimaryData_ResearchObject primaryData_ResearchObject : primaryData_ResearchObjects) {
			if (EntityCacheUtil.getResult(
						PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						PrimaryData_ResearchObjectImpl.class,
						primaryData_ResearchObject.getPrimaryKey()) == null) {
				cacheResult(primaryData_ResearchObject);
			}
			else {
				primaryData_ResearchObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all primary data_ research objects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrimaryData_ResearchObjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrimaryData_ResearchObjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the primary data_ research object.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		PrimaryData_ResearchObject primaryData_ResearchObject) {
		EntityCacheUtil.removeResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			primaryData_ResearchObject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<PrimaryData_ResearchObject> primaryData_ResearchObjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrimaryData_ResearchObject primaryData_ResearchObject : primaryData_ResearchObjects) {
			EntityCacheUtil.removeResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				PrimaryData_ResearchObjectImpl.class,
				primaryData_ResearchObject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new primary data_ research object with the primary key. Does not add the primary data_ research object to the database.
	 *
	 * @param primaryData_ResearchObjectPK the primary key for the new primary data_ research object
	 * @return the new primary data_ research object
	 */
	@Override
	public PrimaryData_ResearchObject create(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK) {
		PrimaryData_ResearchObject primaryData_ResearchObject = new PrimaryData_ResearchObjectImpl();

		primaryData_ResearchObject.setNew(true);
		primaryData_ResearchObject.setPrimaryKey(primaryData_ResearchObjectPK);

		return primaryData_ResearchObject;
	}

	/**
	 * Removes the primary data_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	 * @return the primary data_ research object that was removed
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject remove(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		return remove((Serializable)primaryData_ResearchObjectPK);
	}

	/**
	 * Removes the primary data_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the primary data_ research object
	 * @return the primary data_ research object that was removed
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject remove(Serializable primaryKey)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrimaryData_ResearchObject primaryData_ResearchObject = (PrimaryData_ResearchObject)session.get(PrimaryData_ResearchObjectImpl.class,
					primaryKey);

			if (primaryData_ResearchObject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrimaryData_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(primaryData_ResearchObject);
		}
		catch (NoSuchPrimaryData_ResearchObjectException nsee) {
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
	protected PrimaryData_ResearchObject removeImpl(
		PrimaryData_ResearchObject primaryData_ResearchObject)
		throws SystemException {
		primaryData_ResearchObject = toUnwrappedModel(primaryData_ResearchObject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(primaryData_ResearchObject)) {
				primaryData_ResearchObject = (PrimaryData_ResearchObject)session.get(PrimaryData_ResearchObjectImpl.class,
						primaryData_ResearchObject.getPrimaryKeyObj());
			}

			if (primaryData_ResearchObject != null) {
				session.delete(primaryData_ResearchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (primaryData_ResearchObject != null) {
			clearCache(primaryData_ResearchObject);
		}

		return primaryData_ResearchObject;
	}

	@Override
	public PrimaryData_ResearchObject updateImpl(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject)
		throws SystemException {
		primaryData_ResearchObject = toUnwrappedModel(primaryData_ResearchObject);

		boolean isNew = primaryData_ResearchObject.isNew();

		PrimaryData_ResearchObjectModelImpl primaryData_ResearchObjectModelImpl = (PrimaryData_ResearchObjectModelImpl)primaryData_ResearchObject;

		Session session = null;

		try {
			session = openSession();

			if (primaryData_ResearchObject.isNew()) {
				session.save(primaryData_ResearchObject);

				primaryData_ResearchObject.setNew(false);
			}
			else {
				session.merge(primaryData_ResearchObject);
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
				!PrimaryData_ResearchObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((primaryData_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYDATAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						primaryData_ResearchObjectModelImpl.getOriginalPrimaryDataID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYDATAID,
					args);

				args = new Object[] {
						primaryData_ResearchObjectModelImpl.getPrimaryDataID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYDATAID,
					args);
			}

			if ((primaryData_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						primaryData_ResearchObjectModelImpl.getOriginalResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);

				args = new Object[] {
						primaryData_ResearchObjectModelImpl.getResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);
			}

			if ((primaryData_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						primaryData_ResearchObjectModelImpl.getOriginalResearchObjectID(),
						primaryData_ResearchObjectModelImpl.getOriginalResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION,
					args);

				args = new Object[] {
						primaryData_ResearchObjectModelImpl.getResearchObjectID(),
						primaryData_ResearchObjectModelImpl.getResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION,
					args);
			}
		}

		EntityCacheUtil.putResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryData_ResearchObjectImpl.class,
			primaryData_ResearchObject.getPrimaryKey(),
			primaryData_ResearchObject);

		return primaryData_ResearchObject;
	}

	protected PrimaryData_ResearchObject toUnwrappedModel(
		PrimaryData_ResearchObject primaryData_ResearchObject) {
		if (primaryData_ResearchObject instanceof PrimaryData_ResearchObjectImpl) {
			return primaryData_ResearchObject;
		}

		PrimaryData_ResearchObjectImpl primaryData_ResearchObjectImpl = new PrimaryData_ResearchObjectImpl();

		primaryData_ResearchObjectImpl.setNew(primaryData_ResearchObject.isNew());
		primaryData_ResearchObjectImpl.setPrimaryKey(primaryData_ResearchObject.getPrimaryKey());

		primaryData_ResearchObjectImpl.setPrimaryDataID(primaryData_ResearchObject.getPrimaryDataID());
		primaryData_ResearchObjectImpl.setResearchObjectID(primaryData_ResearchObject.getResearchObjectID());
		primaryData_ResearchObjectImpl.setResearchObjectVersion(primaryData_ResearchObject.getResearchObjectVersion());
		primaryData_ResearchObjectImpl.setLastModifiedDate(primaryData_ResearchObject.getLastModifiedDate());

		return primaryData_ResearchObjectImpl;
	}

	/**
	 * Returns the primary data_ research object with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary data_ research object
	 * @return the primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = fetchByPrimaryKey(primaryKey);

		if (primaryData_ResearchObject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrimaryData_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return primaryData_ResearchObject;
	}

	/**
	 * Returns the primary data_ research object with the primary key or throws a {@link org.gfbio.NoSuchPrimaryData_ResearchObjectException} if it could not be found.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	 * @return the primary data_ research object
	 * @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject findByPrimaryKey(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws NoSuchPrimaryData_ResearchObjectException, SystemException {
		return findByPrimaryKey((Serializable)primaryData_ResearchObjectPK);
	}

	/**
	 * Returns the primary data_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary data_ research object
	 * @return the primary data_ research object, or <code>null</code> if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PrimaryData_ResearchObject primaryData_ResearchObject = (PrimaryData_ResearchObject)EntityCacheUtil.getResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				PrimaryData_ResearchObjectImpl.class, primaryKey);

		if (primaryData_ResearchObject == _nullPrimaryData_ResearchObject) {
			return null;
		}

		if (primaryData_ResearchObject == null) {
			Session session = null;

			try {
				session = openSession();

				primaryData_ResearchObject = (PrimaryData_ResearchObject)session.get(PrimaryData_ResearchObjectImpl.class,
						primaryKey);

				if (primaryData_ResearchObject != null) {
					cacheResult(primaryData_ResearchObject);
				}
				else {
					EntityCacheUtil.putResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						PrimaryData_ResearchObjectImpl.class, primaryKey,
						_nullPrimaryData_ResearchObject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PrimaryData_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
					PrimaryData_ResearchObjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return primaryData_ResearchObject;
	}

	/**
	 * Returns the primary data_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	 * @return the primary data_ research object, or <code>null</code> if a primary data_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData_ResearchObject fetchByPrimaryKey(
		PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)primaryData_ResearchObjectPK);
	}

	/**
	 * Returns all the primary data_ research objects.
	 *
	 * @return the primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary data_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @return the range of primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary data_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary data_ research objects
	 * @param end the upper bound of the range of primary data_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of primary data_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData_ResearchObject> findAll(int start, int end,
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

		List<PrimaryData_ResearchObject> list = (List<PrimaryData_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT;

				if (pagination) {
					sql = sql.concat(PrimaryData_ResearchObjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrimaryData_ResearchObject>(list);
				}
				else {
					list = (List<PrimaryData_ResearchObject>)QueryUtil.list(q,
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
	 * Removes all the primary data_ research objects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PrimaryData_ResearchObject primaryData_ResearchObject : findAll()) {
			remove(primaryData_ResearchObject);
		}
	}

	/**
	 * Returns the number of primary data_ research objects.
	 *
	 * @return the number of primary data_ research objects
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

				Query q = session.createQuery(_SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT);

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
	 * Initializes the primary data_ research object persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.PrimaryData_ResearchObject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrimaryData_ResearchObject>> listenersList = new ArrayList<ModelListener<PrimaryData_ResearchObject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrimaryData_ResearchObject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrimaryData_ResearchObjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT = "SELECT primaryData_ResearchObject FROM PrimaryData_ResearchObject primaryData_ResearchObject";
	private static final String _SQL_SELECT_PRIMARYDATA_RESEARCHOBJECT_WHERE = "SELECT primaryData_ResearchObject FROM PrimaryData_ResearchObject primaryData_ResearchObject WHERE ";
	private static final String _SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT = "SELECT COUNT(primaryData_ResearchObject) FROM PrimaryData_ResearchObject primaryData_ResearchObject";
	private static final String _SQL_COUNT_PRIMARYDATA_RESEARCHOBJECT_WHERE = "SELECT COUNT(primaryData_ResearchObject) FROM PrimaryData_ResearchObject primaryData_ResearchObject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "primaryData_ResearchObject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrimaryData_ResearchObject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PrimaryData_ResearchObject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrimaryData_ResearchObjectPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static PrimaryData_ResearchObject _nullPrimaryData_ResearchObject = new PrimaryData_ResearchObjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrimaryData_ResearchObject> toCacheModel() {
				return _nullPrimaryData_ResearchObjectCacheModel;
			}
		};

	private static CacheModel<PrimaryData_ResearchObject> _nullPrimaryData_ResearchObjectCacheModel =
		new CacheModel<PrimaryData_ResearchObject>() {
			@Override
			public PrimaryData_ResearchObject toEntityModel() {
				return _nullPrimaryData_ResearchObject;
			}
		};
}