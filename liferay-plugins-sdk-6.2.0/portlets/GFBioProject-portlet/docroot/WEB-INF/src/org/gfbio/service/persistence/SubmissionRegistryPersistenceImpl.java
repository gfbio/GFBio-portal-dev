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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import org.gfbio.NoSuchSubmissionRegistryException;

import org.gfbio.model.SubmissionRegistry;
import org.gfbio.model.impl.SubmissionRegistryImpl;
import org.gfbio.model.impl.SubmissionRegistryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the submission registry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryPersistence
 * @see SubmissionRegistryUtil
 * @generated
 */
public class SubmissionRegistryPersistenceImpl extends BasePersistenceImpl<SubmissionRegistry>
	implements SubmissionRegistryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmissionRegistryUtil} to access the submission registry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmissionRegistryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchObjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectID", new String[] { Long.class.getName() },
			SubmissionRegistryModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID", new String[] { Long.class.getName() });

	/**
	 * Returns all the submission registries where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectID(
		long researchObjectID) throws SystemException {
		return findByResearchObjectID(researchObjectID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectID(
		long researchObjectID, int start, int end) throws SystemException {
		return findByResearchObjectID(researchObjectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectID(
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

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if ((researchObjectID != submissionRegistry.getResearchObjectID())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByResearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByResearchObjectID_First(researchObjectID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		List<SubmissionRegistry> list = findByResearchObjectID(researchObjectID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByResearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByResearchObjectID_Last(researchObjectID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResearchObjectID(researchObjectID);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByResearchObjectID(researchObjectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where researchObjectID = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByResearchObjectID_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, long researchObjectID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByResearchObjectID_PrevAndNext(session,
					submissionRegistry, researchObjectID, orderByComparator,
					true);

			array[1] = submissionRegistry;

			array[2] = getByResearchObjectID_PrevAndNext(session,
					submissionRegistry, researchObjectID, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByResearchObjectID_PrevAndNext(
		Session session, SubmissionRegistry submissionRegistry,
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

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectID(long researchObjectID)
		throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByResearchObjectID(
				researchObjectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching submission registries
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

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

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
		"submissionRegistry.id.researchObjectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResearchObjectIDWithVersion",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectIDWithVersion",
			new String[] { Long.class.getName(), Long.class.getName() },
			SubmissionRegistryModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			SubmissionRegistryModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectIDWithVersion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion)
		throws SystemException {
		return findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion, int start, int end)
		throws SystemException {
		return findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION;
			finderArgs = new Object[] { researchObjectID, researchObjectVersion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION;
			finderArgs = new Object[] {
					researchObjectID, researchObjectVersion,
					
					start, end, orderByComparator
				};
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if ((researchObjectID != submissionRegistry.getResearchObjectID()) ||
						(researchObjectVersion != submissionRegistry.getResearchObjectVersion())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
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
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByResearchObjectIDWithVersion_First(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubmissionRegistry> list = findByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByResearchObjectIDWithVersion_Last(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByResearchObjectIDWithVersion_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, long researchObjectID,
		long researchObjectVersion, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByResearchObjectIDWithVersion_PrevAndNext(session,
					submissionRegistry, researchObjectID,
					researchObjectVersion, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByResearchObjectIDWithVersion_PrevAndNext(session,
					submissionRegistry, researchObjectID,
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

	protected SubmissionRegistry getByResearchObjectIDWithVersion_PrevAndNext(
		Session session, SubmissionRegistry submissionRegistry,
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTID_2);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2);

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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		qPos.add(researchObjectVersion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectIDWithVersion(long researchObjectID,
		long researchObjectVersion) throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByResearchObjectIDWithVersion(
				researchObjectID, researchObjectVersion, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectIDWithVersion(long researchObjectID,
		long researchObjectVersion) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION;

		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2);

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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTID_2 =
		"submissionRegistry.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2 =
		"submissionRegistry.id.researchObjectVersion = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByResearchObjectIDWithLastChanges",
			new String[] { Long.class.getName(), Date.class.getName() },
			SubmissionRegistryModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			SubmissionRegistryModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectIDWithLastChanges",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByResearchObjectIDWithLastChanges(researchObjectID,
				lastChanged);

		if (submissionRegistry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("researchObjectID=");
			msg.append(researchObjectID);

			msg.append(", lastChanged=");
			msg.append(lastChanged);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSubmissionRegistryException(msg.toString());
		}

		return submissionRegistry;
	}

	/**
	 * Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged) throws SystemException {
		return fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged, true);
	}

	/**
	 * Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { researchObjectID, lastChanged };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					finderArgs, this);
		}

		if (result instanceof SubmissionRegistry) {
			SubmissionRegistry submissionRegistry = (SubmissionRegistry)result;

			if ((researchObjectID != submissionRegistry.getResearchObjectID()) ||
					!Validator.equals(lastChanged,
						submissionRegistry.getLastChanged())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_RESEARCHOBJECTID_2);

			boolean bindLastChanged = false;

			if (lastChanged == null) {
				query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_1);
			}
			else {
				bindLastChanged = true;

				query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (bindLastChanged) {
					qPos.add(CalendarUtil.getTimestamp(lastChanged));
				}

				List<SubmissionRegistry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SubmissionRegistryPersistenceImpl.fetchByResearchObjectIDWithLastChanges(long, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SubmissionRegistry submissionRegistry = list.get(0);

					result = submissionRegistry;

					cacheResult(submissionRegistry);

					if ((submissionRegistry.getResearchObjectID() != researchObjectID) ||
							(submissionRegistry.getLastChanged() == null) ||
							!submissionRegistry.getLastChanged()
												   .equals(lastChanged)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
							finderArgs, submissionRegistry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
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
			return (SubmissionRegistry)result;
		}
	}

	/**
	 * Removes the submission registry where researchObjectID = &#63; and lastChanged = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the submission registry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry removeByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByResearchObjectIDWithLastChanges(researchObjectID,
				lastChanged);

		return remove(submissionRegistry);
	}

	/**
	 * Returns the number of submission registries where researchObjectID = &#63; and lastChanged = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectIDWithLastChanges(long researchObjectID,
		Date lastChanged) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES;

		Object[] finderArgs = new Object[] { researchObjectID, lastChanged };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_RESEARCHOBJECTID_2);

			boolean bindLastChanged = false;

			if (lastChanged == null) {
				query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_1);
			}
			else {
				bindLastChanged = true;

				query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (bindLastChanged) {
					qPos.add(CalendarUtil.getTimestamp(lastChanged));
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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_RESEARCHOBJECTID_2 =
		"submissionRegistry.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_1 =
		"submissionRegistry.lastChanged IS NULL";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_2 =
		"submissionRegistry.lastChanged = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARCHIVE = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArchive",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArchive",
			new String[] { String.class.getName() },
			SubmissionRegistryModelImpl.ARCHIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARCHIVE = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArchive",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submission registries where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByArchive(String archive)
		throws SystemException {
		return findByArchive(archive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByArchive(String archive, int start,
		int end) throws SystemException {
		return findByArchive(archive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByArchive(String archive, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE;
			finderArgs = new Object[] { archive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARCHIVE;
			finderArgs = new Object[] { archive, start, end, orderByComparator };
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if (!Validator.equals(archive, submissionRegistry.getArchive())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			boolean bindArchive = false;

			if (archive == null) {
				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_1);
			}
			else if (archive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_3);
			}
			else {
				bindArchive = true;

				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArchive) {
					qPos.add(archive);
				}

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByArchive_First(String archive,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByArchive_First(archive,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByArchive_First(String archive,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubmissionRegistry> list = findByArchive(archive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByArchive_Last(String archive,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByArchive_Last(archive,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByArchive_Last(String archive,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArchive(archive);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByArchive(archive, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where archive = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByArchive_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, String archive,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByArchive_PrevAndNext(session, submissionRegistry,
					archive, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByArchive_PrevAndNext(session, submissionRegistry,
					archive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByArchive_PrevAndNext(Session session,
		SubmissionRegistry submissionRegistry, String archive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		boolean bindArchive = false;

		if (archive == null) {
			query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_1);
		}
		else if (archive.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_3);
		}
		else {
			bindArchive = true;

			query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);
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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArchive) {
			qPos.add(archive);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where archive = &#63; from the database.
	 *
	 * @param archive the archive
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArchive(String archive) throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByArchive(archive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArchive(String archive) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARCHIVE;

		Object[] finderArgs = new Object[] { archive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			boolean bindArchive = false;

			if (archive == null) {
				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_1);
			}
			else if (archive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_3);
			}
			else {
				bindArchive = true;

				query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArchive) {
					qPos.add(archive);
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

	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_1 = "submissionRegistry.id.archive IS NULL";
	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_2 = "submissionRegistry.id.archive = ?";
	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_3 = "(submissionRegistry.id.archive IS NULL OR submissionRegistry.id.archive = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERSUBMISSIONID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrokerSubmissionID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBrokerSubmissionID",
			new String[] { String.class.getName() },
			SubmissionRegistryModelImpl.BROKERSUBMISSIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBrokerSubmissionID", new String[] { String.class.getName() });

	/**
	 * Returns all the submission registries where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByBrokerSubmissionID(
		String brokerSubmissionID) throws SystemException {
		return findByBrokerSubmissionID(brokerSubmissionID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where brokerSubmissionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByBrokerSubmissionID(
		String brokerSubmissionID, int start, int end)
		throws SystemException {
		return findByBrokerSubmissionID(brokerSubmissionID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where brokerSubmissionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByBrokerSubmissionID(
		String brokerSubmissionID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID;
			finderArgs = new Object[] { brokerSubmissionID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERSUBMISSIONID;
			finderArgs = new Object[] {
					brokerSubmissionID,
					
					start, end, orderByComparator
				};
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if (!Validator.equals(brokerSubmissionID,
							submissionRegistry.getBrokerSubmissionID())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			boolean bindBrokerSubmissionID = false;

			if (brokerSubmissionID == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_1);
			}
			else if (brokerSubmissionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_3);
			}
			else {
				bindBrokerSubmissionID = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrokerSubmissionID) {
					qPos.add(brokerSubmissionID);
				}

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByBrokerSubmissionID_First(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByBrokerSubmissionID_First(brokerSubmissionID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brokerSubmissionID=");
		msg.append(brokerSubmissionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByBrokerSubmissionID_First(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws SystemException {
		List<SubmissionRegistry> list = findByBrokerSubmissionID(brokerSubmissionID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByBrokerSubmissionID_Last(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByBrokerSubmissionID_Last(brokerSubmissionID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brokerSubmissionID=");
		msg.append(brokerSubmissionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByBrokerSubmissionID_Last(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBrokerSubmissionID(brokerSubmissionID);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByBrokerSubmissionID(brokerSubmissionID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByBrokerSubmissionID_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, String brokerSubmissionID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByBrokerSubmissionID_PrevAndNext(session,
					submissionRegistry, brokerSubmissionID, orderByComparator,
					true);

			array[1] = submissionRegistry;

			array[2] = getByBrokerSubmissionID_PrevAndNext(session,
					submissionRegistry, brokerSubmissionID, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByBrokerSubmissionID_PrevAndNext(
		Session session, SubmissionRegistry submissionRegistry,
		String brokerSubmissionID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		boolean bindBrokerSubmissionID = false;

		if (brokerSubmissionID == null) {
			query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_1);
		}
		else if (brokerSubmissionID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_3);
		}
		else {
			bindBrokerSubmissionID = true;

			query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_2);
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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBrokerSubmissionID) {
			qPos.add(brokerSubmissionID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where brokerSubmissionID = &#63; from the database.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrokerSubmissionID(String brokerSubmissionID)
		throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByBrokerSubmissionID(
				brokerSubmissionID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrokerSubmissionID(String brokerSubmissionID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID;

		Object[] finderArgs = new Object[] { brokerSubmissionID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			boolean bindBrokerSubmissionID = false;

			if (brokerSubmissionID == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_1);
			}
			else if (brokerSubmissionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_3);
			}
			else {
				bindBrokerSubmissionID = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrokerSubmissionID) {
					qPos.add(brokerSubmissionID);
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

	private static final String _FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_1 =
		"submissionRegistry.brokerSubmissionID IS NULL";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_2 =
		"submissionRegistry.brokerSubmissionID = ?";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_3 =
		"(submissionRegistry.brokerSubmissionID IS NULL OR submissionRegistry.brokerSubmissionID = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBrokerSubmissionIDWithLastChanges",
			new String[] { String.class.getName(), Date.class.getName() },
			SubmissionRegistryModelImpl.BROKERSUBMISSIONID_COLUMN_BITMASK |
			SubmissionRegistryModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBrokerSubmissionIDWithLastChanges",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
				lastChanged);

		if (submissionRegistry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("brokerSubmissionID=");
			msg.append(brokerSubmissionID);

			msg.append(", lastChanged=");
			msg.append(lastChanged);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSubmissionRegistryException(msg.toString());
		}

		return submissionRegistry;
	}

	/**
	 * Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged) throws SystemException {
		return fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged, true);
	}

	/**
	 * Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { brokerSubmissionID, lastChanged };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					finderArgs, this);
		}

		if (result instanceof SubmissionRegistry) {
			SubmissionRegistry submissionRegistry = (SubmissionRegistry)result;

			if (!Validator.equals(brokerSubmissionID,
						submissionRegistry.getBrokerSubmissionID()) ||
					!Validator.equals(lastChanged,
						submissionRegistry.getLastChanged())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			boolean bindBrokerSubmissionID = false;

			if (brokerSubmissionID == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_1);
			}
			else if (brokerSubmissionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_3);
			}
			else {
				bindBrokerSubmissionID = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_2);
			}

			boolean bindLastChanged = false;

			if (lastChanged == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_1);
			}
			else {
				bindLastChanged = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrokerSubmissionID) {
					qPos.add(brokerSubmissionID);
				}

				if (bindLastChanged) {
					qPos.add(CalendarUtil.getTimestamp(lastChanged));
				}

				List<SubmissionRegistry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SubmissionRegistryPersistenceImpl.fetchByBrokerSubmissionIDWithLastChanges(String, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SubmissionRegistry submissionRegistry = list.get(0);

					result = submissionRegistry;

					cacheResult(submissionRegistry);

					if ((submissionRegistry.getBrokerSubmissionID() == null) ||
							!submissionRegistry.getBrokerSubmissionID()
												   .equals(brokerSubmissionID) ||
							(submissionRegistry.getLastChanged() == null) ||
							!submissionRegistry.getLastChanged()
												   .equals(lastChanged)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
							finderArgs, submissionRegistry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
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
			return (SubmissionRegistry)result;
		}
	}

	/**
	 * Removes the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; from the database.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the submission registry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry removeByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
				lastChanged);

		return remove(submissionRegistry);
	}

	/**
	 * Returns the number of submission registries where brokerSubmissionID = &#63; and lastChanged = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES;

		Object[] finderArgs = new Object[] { brokerSubmissionID, lastChanged };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			boolean bindBrokerSubmissionID = false;

			if (brokerSubmissionID == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_1);
			}
			else if (brokerSubmissionID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_3);
			}
			else {
				bindBrokerSubmissionID = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_2);
			}

			boolean bindLastChanged = false;

			if (lastChanged == null) {
				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_1);
			}
			else {
				bindLastChanged = true;

				query.append(_FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBrokerSubmissionID) {
					qPos.add(brokerSubmissionID);
				}

				if (bindLastChanged) {
					qPos.add(CalendarUtil.getTimestamp(lastChanged));
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

	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_1 =
		"submissionRegistry.brokerSubmissionID IS NULL AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_2 =
		"submissionRegistry.brokerSubmissionID = ? AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_3 =
		"(submissionRegistry.brokerSubmissionID IS NULL OR submissionRegistry.brokerSubmissionID = '') AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_1 =
		"submissionRegistry.lastChanged IS NULL";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_2 =
		"submissionRegistry.lastChanged = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistentIdentifierID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistentIdentifierID",
			new String[] { String.class.getName() },
			SubmissionRegistryModelImpl.ARCHIVEPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistentIdentifierID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submission registries where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierID(
		String archivePID) throws SystemException {
		return findByPersistentIdentifierID(archivePID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where archivePID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePID the archive p i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierID(
		String archivePID, int start, int end) throws SystemException {
		return findByPersistentIdentifierID(archivePID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where archivePID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePID the archive p i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierID(
		String archivePID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID;
			finderArgs = new Object[] { archivePID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID;
			finderArgs = new Object[] { archivePID, start, end, orderByComparator };
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if (!Validator.equals(archivePID,
							submissionRegistry.getArchivePID())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			boolean bindArchivePID = false;

			if (archivePID == null) {
				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_1);
			}
			else if (archivePID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_3);
			}
			else {
				bindArchivePID = true;

				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArchivePID) {
					qPos.add(archivePID);
				}

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPersistentIdentifierID_First(
		String archivePID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByPersistentIdentifierID_First(archivePID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePID=");
		msg.append(archivePID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPersistentIdentifierID_First(
		String archivePID, OrderByComparator orderByComparator)
		throws SystemException {
		List<SubmissionRegistry> list = findByPersistentIdentifierID(archivePID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPersistentIdentifierID_Last(
		String archivePID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByPersistentIdentifierID_Last(archivePID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePID=");
		msg.append(archivePID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPersistentIdentifierID_Last(
		String archivePID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPersistentIdentifierID(archivePID);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByPersistentIdentifierID(archivePID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where archivePID = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByPersistentIdentifierID_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, String archivePID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByPersistentIdentifierID_PrevAndNext(session,
					submissionRegistry, archivePID, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByPersistentIdentifierID_PrevAndNext(session,
					submissionRegistry, archivePID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByPersistentIdentifierID_PrevAndNext(
		Session session, SubmissionRegistry submissionRegistry,
		String archivePID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		boolean bindArchivePID = false;

		if (archivePID == null) {
			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_1);
		}
		else if (archivePID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_3);
		}
		else {
			bindArchivePID = true;

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_2);
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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArchivePID) {
			qPos.add(archivePID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where archivePID = &#63; from the database.
	 *
	 * @param archivePID the archive p i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersistentIdentifierID(String archivePID)
		throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByPersistentIdentifierID(
				archivePID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPersistentIdentifierID(String archivePID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID;

		Object[] finderArgs = new Object[] { archivePID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			boolean bindArchivePID = false;

			if (archivePID == null) {
				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_1);
			}
			else if (archivePID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_3);
			}
			else {
				bindArchivePID = true;

				query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArchivePID) {
					qPos.add(archivePID);
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

	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_1 =
		"submissionRegistry.archivePID IS NULL";
	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_2 =
		"submissionRegistry.archivePID = ?";
	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_3 =
		"(submissionRegistry.archivePID IS NULL OR submissionRegistry.archivePID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistentIdentifierTypeID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistentIdentifierTypeID",
			new String[] { Long.class.getName() },
			SubmissionRegistryModelImpl.ARCHIVEPIDTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistentIdentifierTypeID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submission registries where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType) throws SystemException {
		return findByPersistentIdentifierTypeID(archivePIDType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where archivePIDType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePIDType the archive p i d type
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end) throws SystemException {
		return findByPersistentIdentifierTypeID(archivePIDType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where archivePIDType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePIDType the archive p i d type
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID;
			finderArgs = new Object[] { archivePIDType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID;
			finderArgs = new Object[] {
					archivePIDType,
					
					start, end, orderByComparator
				};
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if ((archivePIDType != submissionRegistry.getArchivePIDType())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERTYPEID_ARCHIVEPIDTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(archivePIDType);

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPersistentIdentifierTypeID_First(
		long archivePIDType, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByPersistentIdentifierTypeID_First(archivePIDType,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePIDType=");
		msg.append(archivePIDType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPersistentIdentifierTypeID_First(
		long archivePIDType, OrderByComparator orderByComparator)
		throws SystemException {
		List<SubmissionRegistry> list = findByPersistentIdentifierTypeID(archivePIDType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPersistentIdentifierTypeID_Last(
		long archivePIDType, OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByPersistentIdentifierTypeID_Last(archivePIDType,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePIDType=");
		msg.append(archivePIDType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPersistentIdentifierTypeID_Last(
		long archivePIDType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPersistentIdentifierTypeID(archivePIDType);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByPersistentIdentifierTypeID(archivePIDType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where archivePIDType = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByPersistentIdentifierTypeID_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, long archivePIDType,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByPersistentIdentifierTypeID_PrevAndNext(session,
					submissionRegistry, archivePIDType, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByPersistentIdentifierTypeID_PrevAndNext(session,
					submissionRegistry, archivePIDType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByPersistentIdentifierTypeID_PrevAndNext(
		Session session, SubmissionRegistry submissionRegistry,
		long archivePIDType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERTYPEID_ARCHIVEPIDTYPE_2);

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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(archivePIDType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where archivePIDType = &#63; from the database.
	 *
	 * @param archivePIDType the archive p i d type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersistentIdentifierTypeID(long archivePIDType)
		throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByPersistentIdentifierTypeID(
				archivePIDType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPersistentIdentifierTypeID(long archivePIDType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID;

		Object[] finderArgs = new Object[] { archivePIDType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERTYPEID_ARCHIVEPIDTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(archivePIDType);

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

	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERTYPEID_ARCHIVEPIDTYPE_2 =
		"submissionRegistry.archivePIDType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			SubmissionRegistryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submission registries where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByUserID(long userID, int start,
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

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if ((userID != submissionRegistry.getUserID())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByUserID_First(userID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubmissionRegistry> list = findByUserID(userID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByUserID_Last(userID,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where userID = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByUserID_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByUserID_PrevAndNext(session, submissionRegistry,
					userID, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByUserID_PrevAndNext(session, submissionRegistry,
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

	protected SubmissionRegistry getByUserID_PrevAndNext(Session session,
		SubmissionRegistry submissionRegistry, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching submission registries
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

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "submissionRegistry.userID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPUBLIC = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPublic",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPublic",
			new String[] { Boolean.class.getName() },
			SubmissionRegistryModelImpl.ISPUBLIC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPUBLIC = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPublic",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the submission registries where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByIsPublic(boolean isPublic)
		throws SystemException {
		return findByIsPublic(isPublic, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the submission registries where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByIsPublic(boolean isPublic, int start,
		int end) throws SystemException {
		return findByIsPublic(isPublic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByIsPublic(boolean isPublic, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC;
			finderArgs = new Object[] { isPublic };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPUBLIC;
			finderArgs = new Object[] { isPublic, start, end, orderByComparator };
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if ((isPublic != submissionRegistry.getIsPublic())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByIsPublic_First(isPublic,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubmissionRegistry> list = findByIsPublic(isPublic, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByIsPublic_Last(isPublic,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsPublic(isPublic);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByIsPublic(isPublic, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where isPublic = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByIsPublic_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByIsPublic_PrevAndNext(session, submissionRegistry,
					isPublic, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByIsPublic_PrevAndNext(session, submissionRegistry,
					isPublic, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByIsPublic_PrevAndNext(Session session,
		SubmissionRegistry submissionRegistry, boolean isPublic,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isPublic);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where isPublic = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsPublic(boolean isPublic) throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByIsPublic(isPublic,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsPublic(boolean isPublic) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISPUBLIC;

		Object[] finderArgs = new Object[] { isPublic };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

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

	private static final String _FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2 = "submissionRegistry.isPublic = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED,
			SubmissionRegistryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			SubmissionRegistryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submission registries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByStatus(String status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByStatus(String status, int start,
		int end) throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findByStatus(String status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SubmissionRegistry submissionRegistry : list) {
				if (!Validator.equals(status, submissionRegistry.getStatus())) {
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

			query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Returns the first submission registry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByStatus_First(status,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the first submission registry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SubmissionRegistry> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission registry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByStatus_Last(status,
				orderByComparator);

		if (submissionRegistry != null) {
			return submissionRegistry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionRegistryException(msg.toString());
	}

	/**
	 * Returns the last submission registry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<SubmissionRegistry> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submission registries before and after the current submission registry in the ordered set where status = &#63;.
	 *
	 * @param submissionRegistryPK the primary key of the current submission registry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry[] findByStatus_PrevAndNext(
		SubmissionRegistryPK submissionRegistryPK, String status,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = findByPrimaryKey(submissionRegistryPK);

		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry[] array = new SubmissionRegistryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, submissionRegistry,
					status, orderByComparator, true);

			array[1] = submissionRegistry;

			array[2] = getByStatus_PrevAndNext(session, submissionRegistry,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubmissionRegistry getByStatus_PrevAndNext(Session session,
		SubmissionRegistry submissionRegistry, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSIONREGISTRY_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			query.append(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submissionRegistry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubmissionRegistry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submission registries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(String status) throws SystemException {
		for (SubmissionRegistry submissionRegistry : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBMISSIONREGISTRY_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "submissionRegistry.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "submissionRegistry.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(submissionRegistry.status IS NULL OR submissionRegistry.status = '')";

	public SubmissionRegistryPersistenceImpl() {
		setModelClass(SubmissionRegistry.class);
	}

	/**
	 * Caches the submission registry in the entity cache if it is enabled.
	 *
	 * @param submissionRegistry the submission registry
	 */
	@Override
	public void cacheResult(SubmissionRegistry submissionRegistry) {
		EntityCacheUtil.putResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryImpl.class, submissionRegistry.getPrimaryKey(),
			submissionRegistry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			new Object[] {
				submissionRegistry.getResearchObjectID(),
				submissionRegistry.getLastChanged()
			}, submissionRegistry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			new Object[] {
				submissionRegistry.getBrokerSubmissionID(),
				submissionRegistry.getLastChanged()
			}, submissionRegistry);

		submissionRegistry.resetOriginalValues();
	}

	/**
	 * Caches the submission registries in the entity cache if it is enabled.
	 *
	 * @param submissionRegistries the submission registries
	 */
	@Override
	public void cacheResult(List<SubmissionRegistry> submissionRegistries) {
		for (SubmissionRegistry submissionRegistry : submissionRegistries) {
			if (EntityCacheUtil.getResult(
						SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionRegistryImpl.class,
						submissionRegistry.getPrimaryKey()) == null) {
				cacheResult(submissionRegistry);
			}
			else {
				submissionRegistry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submission registries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubmissionRegistryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubmissionRegistryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submission registry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubmissionRegistry submissionRegistry) {
		EntityCacheUtil.removeResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryImpl.class, submissionRegistry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(submissionRegistry);
	}

	@Override
	public void clearCache(List<SubmissionRegistry> submissionRegistries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubmissionRegistry submissionRegistry : submissionRegistries) {
			EntityCacheUtil.removeResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionRegistryImpl.class, submissionRegistry.getPrimaryKey());

			clearUniqueFindersCache(submissionRegistry);
		}
	}

	protected void cacheUniqueFindersCache(
		SubmissionRegistry submissionRegistry) {
		if (submissionRegistry.isNew()) {
			Object[] args = new Object[] {
					submissionRegistry.getResearchObjectID(),
					submissionRegistry.getLastChanged()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args, submissionRegistry);

			args = new Object[] {
					submissionRegistry.getBrokerSubmissionID(),
					submissionRegistry.getLastChanged()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args, submissionRegistry);
		}
		else {
			SubmissionRegistryModelImpl submissionRegistryModelImpl = (SubmissionRegistryModelImpl)submissionRegistry;

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistry.getResearchObjectID(),
						submissionRegistry.getLastChanged()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					args, submissionRegistry);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistry.getBrokerSubmissionID(),
						submissionRegistry.getLastChanged()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					args, submissionRegistry);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SubmissionRegistry submissionRegistry) {
		SubmissionRegistryModelImpl submissionRegistryModelImpl = (SubmissionRegistryModelImpl)submissionRegistry;

		Object[] args = new Object[] {
				submissionRegistry.getResearchObjectID(),
				submissionRegistry.getLastChanged()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			args);

		if ((submissionRegistryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
			args = new Object[] {
					submissionRegistryModelImpl.getOriginalResearchObjectID(),
					submissionRegistryModelImpl.getOriginalLastChanged()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args);
		}

		args = new Object[] {
				submissionRegistry.getBrokerSubmissionID(),
				submissionRegistry.getLastChanged()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			args);

		if ((submissionRegistryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
			args = new Object[] {
					submissionRegistryModelImpl.getOriginalBrokerSubmissionID(),
					submissionRegistryModelImpl.getOriginalLastChanged()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args);
		}
	}

	/**
	 * Creates a new submission registry with the primary key. Does not add the submission registry to the database.
	 *
	 * @param submissionRegistryPK the primary key for the new submission registry
	 * @return the new submission registry
	 */
	@Override
	public SubmissionRegistry create(SubmissionRegistryPK submissionRegistryPK) {
		SubmissionRegistry submissionRegistry = new SubmissionRegistryImpl();

		submissionRegistry.setNew(true);
		submissionRegistry.setPrimaryKey(submissionRegistryPK);

		return submissionRegistry;
	}

	/**
	 * Removes the submission registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionRegistryPK the primary key of the submission registry
	 * @return the submission registry that was removed
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry remove(SubmissionRegistryPK submissionRegistryPK)
		throws NoSuchSubmissionRegistryException, SystemException {
		return remove((Serializable)submissionRegistryPK);
	}

	/**
	 * Removes the submission registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submission registry
	 * @return the submission registry that was removed
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry remove(Serializable primaryKey)
		throws NoSuchSubmissionRegistryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubmissionRegistry submissionRegistry = (SubmissionRegistry)session.get(SubmissionRegistryImpl.class,
					primaryKey);

			if (submissionRegistry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmissionRegistryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submissionRegistry);
		}
		catch (NoSuchSubmissionRegistryException nsee) {
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
	protected SubmissionRegistry removeImpl(
		SubmissionRegistry submissionRegistry) throws SystemException {
		submissionRegistry = toUnwrappedModel(submissionRegistry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submissionRegistry)) {
				submissionRegistry = (SubmissionRegistry)session.get(SubmissionRegistryImpl.class,
						submissionRegistry.getPrimaryKeyObj());
			}

			if (submissionRegistry != null) {
				session.delete(submissionRegistry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submissionRegistry != null) {
			clearCache(submissionRegistry);
		}

		return submissionRegistry;
	}

	@Override
	public SubmissionRegistry updateImpl(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws SystemException {
		submissionRegistry = toUnwrappedModel(submissionRegistry);

		boolean isNew = submissionRegistry.isNew();

		SubmissionRegistryModelImpl submissionRegistryModelImpl = (SubmissionRegistryModelImpl)submissionRegistry;

		Session session = null;

		try {
			session = openSession();

			if (submissionRegistry.isNew()) {
				session.save(submissionRegistry);

				submissionRegistry.setNew(false);
			}
			else {
				session.merge(submissionRegistry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubmissionRegistryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);

				args = new Object[] {
						submissionRegistryModelImpl.getResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalResearchObjectID(),
						submissionRegistryModelImpl.getOriginalResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION,
					args);

				args = new Object[] {
						submissionRegistryModelImpl.getResearchObjectID(),
						submissionRegistryModelImpl.getResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalArchive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);

				args = new Object[] { submissionRegistryModelImpl.getArchive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalBrokerSubmissionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID,
					args);

				args = new Object[] {
						submissionRegistryModelImpl.getBrokerSubmissionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalArchivePID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID,
					args);

				args = new Object[] { submissionRegistryModelImpl.getArchivePID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalArchivePIDType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID,
					args);

				args = new Object[] {
						submissionRegistryModelImpl.getArchivePIDType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { submissionRegistryModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalIsPublic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);

				args = new Object[] { submissionRegistryModelImpl.getIsPublic() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);
			}

			if ((submissionRegistryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionRegistryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { submissionRegistryModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionRegistryImpl.class, submissionRegistry.getPrimaryKey(),
			submissionRegistry);

		clearUniqueFindersCache(submissionRegistry);
		cacheUniqueFindersCache(submissionRegistry);

		return submissionRegistry;
	}

	protected SubmissionRegistry toUnwrappedModel(
		SubmissionRegistry submissionRegistry) {
		if (submissionRegistry instanceof SubmissionRegistryImpl) {
			return submissionRegistry;
		}

		SubmissionRegistryImpl submissionRegistryImpl = new SubmissionRegistryImpl();

		submissionRegistryImpl.setNew(submissionRegistry.isNew());
		submissionRegistryImpl.setPrimaryKey(submissionRegistry.getPrimaryKey());

		submissionRegistryImpl.setResearchObjectID(submissionRegistry.getResearchObjectID());
		submissionRegistryImpl.setResearchObjectVersion(submissionRegistry.getResearchObjectVersion());
		submissionRegistryImpl.setArchive(submissionRegistry.getArchive());
		submissionRegistryImpl.setBrokerSubmissionID(submissionRegistry.getBrokerSubmissionID());
		submissionRegistryImpl.setArchivePID(submissionRegistry.getArchivePID());
		submissionRegistryImpl.setArchivePIDType(submissionRegistry.getArchivePIDType());
		submissionRegistryImpl.setLastChanged(submissionRegistry.getLastChanged());
		submissionRegistryImpl.setUserID(submissionRegistry.getUserID());
		submissionRegistryImpl.setIsPublic(submissionRegistry.isIsPublic());
		submissionRegistryImpl.setPublicAfter(submissionRegistry.getPublicAfter());
		submissionRegistryImpl.setStatus(submissionRegistry.getStatus());

		return submissionRegistryImpl;
	}

	/**
	 * Returns the submission registry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission registry
	 * @return the submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmissionRegistryException, SystemException {
		SubmissionRegistry submissionRegistry = fetchByPrimaryKey(primaryKey);

		if (submissionRegistry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmissionRegistryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submissionRegistry;
	}

	/**
	 * Returns the submission registry with the primary key or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	 *
	 * @param submissionRegistryPK the primary key of the submission registry
	 * @return the submission registry
	 * @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry findByPrimaryKey(
		SubmissionRegistryPK submissionRegistryPK)
		throws NoSuchSubmissionRegistryException, SystemException {
		return findByPrimaryKey((Serializable)submissionRegistryPK);
	}

	/**
	 * Returns the submission registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission registry
	 * @return the submission registry, or <code>null</code> if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SubmissionRegistry submissionRegistry = (SubmissionRegistry)EntityCacheUtil.getResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionRegistryImpl.class, primaryKey);

		if (submissionRegistry == _nullSubmissionRegistry) {
			return null;
		}

		if (submissionRegistry == null) {
			Session session = null;

			try {
				session = openSession();

				submissionRegistry = (SubmissionRegistry)session.get(SubmissionRegistryImpl.class,
						primaryKey);

				if (submissionRegistry != null) {
					cacheResult(submissionRegistry);
				}
				else {
					EntityCacheUtil.putResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionRegistryImpl.class, primaryKey,
						_nullSubmissionRegistry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubmissionRegistryModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionRegistryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submissionRegistry;
	}

	/**
	 * Returns the submission registry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionRegistryPK the primary key of the submission registry
	 * @return the submission registry, or <code>null</code> if a submission registry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SubmissionRegistry fetchByPrimaryKey(
		SubmissionRegistryPK submissionRegistryPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)submissionRegistryPK);
	}

	/**
	 * Returns all the submission registries.
	 *
	 * @return the submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submission registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @return the range of submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the submission registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submission registries
	 * @param end the upper bound of the range of submission registries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of submission registries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SubmissionRegistry> findAll(int start, int end,
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

		List<SubmissionRegistry> list = (List<SubmissionRegistry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBMISSIONREGISTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMISSIONREGISTRY;

				if (pagination) {
					sql = sql.concat(SubmissionRegistryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SubmissionRegistry>(list);
				}
				else {
					list = (List<SubmissionRegistry>)QueryUtil.list(q,
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
	 * Removes all the submission registries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SubmissionRegistry submissionRegistry : findAll()) {
			remove(submissionRegistry);
		}
	}

	/**
	 * Returns the number of submission registries.
	 *
	 * @return the number of submission registries
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

				Query q = session.createQuery(_SQL_COUNT_SUBMISSIONREGISTRY);

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
	 * Initializes the submission registry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.SubmissionRegistry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubmissionRegistry>> listenersList = new ArrayList<ModelListener<SubmissionRegistry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubmissionRegistry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubmissionRegistryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBMISSIONREGISTRY = "SELECT submissionRegistry FROM SubmissionRegistry submissionRegistry";
	private static final String _SQL_SELECT_SUBMISSIONREGISTRY_WHERE = "SELECT submissionRegistry FROM SubmissionRegistry submissionRegistry WHERE ";
	private static final String _SQL_COUNT_SUBMISSIONREGISTRY = "SELECT COUNT(submissionRegistry) FROM SubmissionRegistry submissionRegistry";
	private static final String _SQL_COUNT_SUBMISSIONREGISTRY_WHERE = "SELECT COUNT(submissionRegistry) FROM SubmissionRegistry submissionRegistry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submissionRegistry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubmissionRegistry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubmissionRegistry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubmissionRegistryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"archivePID", "archivePIDType", "lastChanged", "isPublic",
				"publicAfter"
			});
	private static SubmissionRegistry _nullSubmissionRegistry = new SubmissionRegistryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SubmissionRegistry> toCacheModel() {
				return _nullSubmissionRegistryCacheModel;
			}
		};

	private static CacheModel<SubmissionRegistry> _nullSubmissionRegistryCacheModel =
		new CacheModel<SubmissionRegistry>() {
			@Override
			public SubmissionRegistry toEntityModel() {
				return _nullSubmissionRegistry;
			}
		};
}