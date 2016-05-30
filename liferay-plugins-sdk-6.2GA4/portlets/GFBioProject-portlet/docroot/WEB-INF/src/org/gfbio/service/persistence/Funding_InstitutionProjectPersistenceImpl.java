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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchFunding_InstitutionProjectException;

import org.gfbio.model.Funding_InstitutionProject;
import org.gfbio.model.impl.Funding_InstitutionProjectImpl;
import org.gfbio.model.impl.Funding_InstitutionProjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the funding_ institution project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProjectPersistence
 * @see Funding_InstitutionProjectUtil
 * @generated
 */
public class Funding_InstitutionProjectPersistenceImpl
	extends BasePersistenceImpl<Funding_InstitutionProject>
	implements Funding_InstitutionProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Funding_InstitutionProjectUtil} to access the funding_ institution project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Funding_InstitutionProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDINGAGENCYID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFundingAgencyID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFundingAgencyID",
			new String[] { Long.class.getName() },
			Funding_InstitutionProjectModelImpl.FUNDINGAGENCYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNDINGAGENCYID = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFundingAgencyID", new String[] { Long.class.getName() });

	/**
	 * Returns all the funding_ institution projects where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @return the matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID) throws SystemException {
		return findByFundingAgencyID(fundingAgencyID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ institution projects where fundingAgencyID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @return the range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end) throws SystemException {
		return findByFundingAgencyID(fundingAgencyID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ institution projects where fundingAgencyID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID;
			finderArgs = new Object[] { fundingAgencyID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDINGAGENCYID;
			finderArgs = new Object[] {
					fundingAgencyID,
					
					start, end, orderByComparator
				};
		}

		List<Funding_InstitutionProject> list = (List<Funding_InstitutionProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_InstitutionProject funding_InstitutionProject : list) {
				if ((fundingAgencyID != funding_InstitutionProject.getFundingAgencyID())) {
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

			query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_FUNDINGAGENCYID_FUNDINGAGENCYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundingAgencyID);

				if (!pagination) {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_InstitutionProject>(list);
				}
				else {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByFundingAgencyID_First(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByFundingAgencyID_First(fundingAgencyID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundingAgencyID=");
		msg.append(fundingAgencyID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByFundingAgencyID_First(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding_InstitutionProject> list = findByFundingAgencyID(fundingAgencyID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByFundingAgencyID_Last(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByFundingAgencyID_Last(fundingAgencyID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundingAgencyID=");
		msg.append(fundingAgencyID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByFundingAgencyID_Last(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFundingAgencyID(fundingAgencyID);

		if (count == 0) {
			return null;
		}

		List<Funding_InstitutionProject> list = findByFundingAgencyID(fundingAgencyID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject[] findByFundingAgencyID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = findByPrimaryKey(funding_InstitutionProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_InstitutionProject[] array = new Funding_InstitutionProjectImpl[3];

			array[0] = getByFundingAgencyID_PrevAndNext(session,
					funding_InstitutionProject, fundingAgencyID,
					orderByComparator, true);

			array[1] = funding_InstitutionProject;

			array[2] = getByFundingAgencyID_PrevAndNext(session,
					funding_InstitutionProject, fundingAgencyID,
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

	protected Funding_InstitutionProject getByFundingAgencyID_PrevAndNext(
		Session session, Funding_InstitutionProject funding_InstitutionProject,
		long fundingAgencyID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

		query.append(_FINDER_COLUMN_FUNDINGAGENCYID_FUNDINGAGENCYID_2);

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
			query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fundingAgencyID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_InstitutionProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_InstitutionProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ institution projects where fundingAgencyID = &#63; from the database.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFundingAgencyID(long fundingAgencyID)
		throws SystemException {
		for (Funding_InstitutionProject funding_InstitutionProject : findByFundingAgencyID(
				fundingAgencyID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_InstitutionProject);
		}
	}

	/**
	 * Returns the number of funding_ institution projects where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @return the number of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFundingAgencyID(long fundingAgencyID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FUNDINGAGENCYID;

		Object[] finderArgs = new Object[] { fundingAgencyID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_FUNDINGAGENCYID_FUNDINGAGENCYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundingAgencyID);

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

	private static final String _FINDER_COLUMN_FUNDINGAGENCYID_FUNDINGAGENCYID_2 =
		"funding_InstitutionProject.id.fundingAgencyID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitutionID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitutionID",
			new String[] { Long.class.getName() },
			Funding_InstitutionProjectModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTIONID = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInstitutionID", new String[] { Long.class.getName() });

	/**
	 * Returns all the funding_ institution projects where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @return the matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByInstitutionID(
		long institutionID) throws SystemException {
		return findByInstitutionID(institutionID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ institution projects where institutionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionID the institution i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @return the range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end) throws SystemException {
		return findByInstitutionID(institutionID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ institution projects where institutionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionID the institution i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID;
			finderArgs = new Object[] { institutionID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONID;
			finderArgs = new Object[] {
					institutionID,
					
					start, end, orderByComparator
				};
		}

		List<Funding_InstitutionProject> list = (List<Funding_InstitutionProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_InstitutionProject funding_InstitutionProject : list) {
				if ((institutionID != funding_InstitutionProject.getInstitutionID())) {
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

			query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionID);

				if (!pagination) {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_InstitutionProject>(list);
				}
				else {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByInstitutionID_First(
		long institutionID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByInstitutionID_First(institutionID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionID=");
		msg.append(institutionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByInstitutionID_First(
		long institutionID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding_InstitutionProject> list = findByInstitutionID(institutionID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByInstitutionID_Last(
		long institutionID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByInstitutionID_Last(institutionID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionID=");
		msg.append(institutionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByInstitutionID_Last(
		long institutionID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByInstitutionID(institutionID);

		if (count == 0) {
			return null;
		}

		List<Funding_InstitutionProject> list = findByInstitutionID(institutionID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where institutionID = &#63;.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	 * @param institutionID the institution i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject[] findByInstitutionID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long institutionID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = findByPrimaryKey(funding_InstitutionProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_InstitutionProject[] array = new Funding_InstitutionProjectImpl[3];

			array[0] = getByInstitutionID_PrevAndNext(session,
					funding_InstitutionProject, institutionID,
					orderByComparator, true);

			array[1] = funding_InstitutionProject;

			array[2] = getByInstitutionID_PrevAndNext(session,
					funding_InstitutionProject, institutionID,
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

	protected Funding_InstitutionProject getByInstitutionID_PrevAndNext(
		Session session, Funding_InstitutionProject funding_InstitutionProject,
		long institutionID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

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
			query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_InstitutionProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_InstitutionProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ institution projects where institutionID = &#63; from the database.
	 *
	 * @param institutionID the institution i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInstitutionID(long institutionID)
		throws SystemException {
		for (Funding_InstitutionProject funding_InstitutionProject : findByInstitutionID(
				institutionID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_InstitutionProject);
		}
	}

	/**
	 * Returns the number of funding_ institution projects where institutionID = &#63;.
	 *
	 * @param institutionID the institution i d
	 * @return the number of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInstitutionID(long institutionID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTIONID;

		Object[] finderArgs = new Object[] { institutionID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionID);

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

	private static final String _FINDER_COLUMN_INSTITUTIONID_INSTITUTIONID_2 = "funding_InstitutionProject.id.institutionID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectID",
			new String[] { Long.class.getName() },
			Funding_InstitutionProjectModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectID", new String[] { Long.class.getName() });

	/**
	 * Returns all the funding_ institution projects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByProjectID(long projectID)
		throws SystemException {
		return findByProjectID(projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the funding_ institution projects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @return the range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByProjectID(long projectID,
		int start, int end) throws SystemException {
		return findByProjectID(projectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ institution projects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findByProjectID(long projectID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectID, start, end, orderByComparator };
		}

		List<Funding_InstitutionProject> list = (List<Funding_InstitutionProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_InstitutionProject funding_InstitutionProject : list) {
				if ((projectID != funding_InstitutionProject.getProjectID())) {
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

			query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				if (!pagination) {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_InstitutionProject>(list);
				}
				else {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByProjectID_First(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByProjectID_First(projectID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByProjectID_First(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funding_InstitutionProject> list = findByProjectID(projectID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByProjectID_Last(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByProjectID_Last(projectID,
				orderByComparator);

		if (funding_InstitutionProject != null) {
			return funding_InstitutionProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_InstitutionProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByProjectID_Last(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectID(projectID);

		if (count == 0) {
			return null;
		}

		List<Funding_InstitutionProject> list = findByProjectID(projectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where projectID = &#63;.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject[] findByProjectID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long projectID, OrderByComparator orderByComparator)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = findByPrimaryKey(funding_InstitutionProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_InstitutionProject[] array = new Funding_InstitutionProjectImpl[3];

			array[0] = getByProjectID_PrevAndNext(session,
					funding_InstitutionProject, projectID, orderByComparator,
					true);

			array[1] = funding_InstitutionProject;

			array[2] = getByProjectID_PrevAndNext(session,
					funding_InstitutionProject, projectID, orderByComparator,
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

	protected Funding_InstitutionProject getByProjectID_PrevAndNext(
		Session session, Funding_InstitutionProject funding_InstitutionProject,
		long projectID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE);

		query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

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
			query.append(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_InstitutionProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_InstitutionProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ institution projects where projectID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectID(long projectID) throws SystemException {
		for (Funding_InstitutionProject funding_InstitutionProject : findByProjectID(
				projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_InstitutionProject);
		}
	}

	/**
	 * Returns the number of funding_ institution projects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the number of matching funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProjectID(long projectID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTID;

		Object[] finderArgs = new Object[] { projectID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDING_INSTITUTIONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "funding_InstitutionProject.id.projectID = ?";

	public Funding_InstitutionProjectPersistenceImpl() {
		setModelClass(Funding_InstitutionProject.class);
	}

	/**
	 * Caches the funding_ institution project in the entity cache if it is enabled.
	 *
	 * @param funding_InstitutionProject the funding_ institution project
	 */
	@Override
	public void cacheResult(
		Funding_InstitutionProject funding_InstitutionProject) {
		EntityCacheUtil.putResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			funding_InstitutionProject.getPrimaryKey(),
			funding_InstitutionProject);

		funding_InstitutionProject.resetOriginalValues();
	}

	/**
	 * Caches the funding_ institution projects in the entity cache if it is enabled.
	 *
	 * @param funding_InstitutionProjects the funding_ institution projects
	 */
	@Override
	public void cacheResult(
		List<Funding_InstitutionProject> funding_InstitutionProjects) {
		for (Funding_InstitutionProject funding_InstitutionProject : funding_InstitutionProjects) {
			if (EntityCacheUtil.getResult(
						Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
						Funding_InstitutionProjectImpl.class,
						funding_InstitutionProject.getPrimaryKey()) == null) {
				cacheResult(funding_InstitutionProject);
			}
			else {
				funding_InstitutionProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all funding_ institution projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Funding_InstitutionProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Funding_InstitutionProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the funding_ institution project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		Funding_InstitutionProject funding_InstitutionProject) {
		EntityCacheUtil.removeResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			funding_InstitutionProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Funding_InstitutionProject> funding_InstitutionProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Funding_InstitutionProject funding_InstitutionProject : funding_InstitutionProjects) {
			EntityCacheUtil.removeResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
				Funding_InstitutionProjectImpl.class,
				funding_InstitutionProject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new funding_ institution project with the primary key. Does not add the funding_ institution project to the database.
	 *
	 * @param funding_InstitutionProjectPK the primary key for the new funding_ institution project
	 * @return the new funding_ institution project
	 */
	@Override
	public Funding_InstitutionProject create(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK) {
		Funding_InstitutionProject funding_InstitutionProject = new Funding_InstitutionProjectImpl();

		funding_InstitutionProject.setNew(true);
		funding_InstitutionProject.setPrimaryKey(funding_InstitutionProjectPK);

		return funding_InstitutionProject;
	}

	/**
	 * Removes the funding_ institution project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	 * @return the funding_ institution project that was removed
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject remove(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		return remove((Serializable)funding_InstitutionProjectPK);
	}

	/**
	 * Removes the funding_ institution project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the funding_ institution project
	 * @return the funding_ institution project that was removed
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject remove(Serializable primaryKey)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Funding_InstitutionProject funding_InstitutionProject = (Funding_InstitutionProject)session.get(Funding_InstitutionProjectImpl.class,
					primaryKey);

			if (funding_InstitutionProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFunding_InstitutionProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(funding_InstitutionProject);
		}
		catch (NoSuchFunding_InstitutionProjectException nsee) {
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
	protected Funding_InstitutionProject removeImpl(
		Funding_InstitutionProject funding_InstitutionProject)
		throws SystemException {
		funding_InstitutionProject = toUnwrappedModel(funding_InstitutionProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(funding_InstitutionProject)) {
				funding_InstitutionProject = (Funding_InstitutionProject)session.get(Funding_InstitutionProjectImpl.class,
						funding_InstitutionProject.getPrimaryKeyObj());
			}

			if (funding_InstitutionProject != null) {
				session.delete(funding_InstitutionProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (funding_InstitutionProject != null) {
			clearCache(funding_InstitutionProject);
		}

		return funding_InstitutionProject;
	}

	@Override
	public Funding_InstitutionProject updateImpl(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws SystemException {
		funding_InstitutionProject = toUnwrappedModel(funding_InstitutionProject);

		boolean isNew = funding_InstitutionProject.isNew();

		Funding_InstitutionProjectModelImpl funding_InstitutionProjectModelImpl = (Funding_InstitutionProjectModelImpl)funding_InstitutionProject;

		Session session = null;

		try {
			session = openSession();

			if (funding_InstitutionProject.isNew()) {
				session.save(funding_InstitutionProject);

				funding_InstitutionProject.setNew(false);
			}
			else {
				session.merge(funding_InstitutionProject);
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
				!Funding_InstitutionProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((funding_InstitutionProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_InstitutionProjectModelImpl.getOriginalFundingAgencyID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDINGAGENCYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID,
					args);

				args = new Object[] {
						funding_InstitutionProjectModelImpl.getFundingAgencyID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDINGAGENCYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID,
					args);
			}

			if ((funding_InstitutionProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_InstitutionProjectModelImpl.getOriginalInstitutionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);

				args = new Object[] {
						funding_InstitutionProjectModelImpl.getInstitutionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONID,
					args);
			}

			if ((funding_InstitutionProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_InstitutionProjectModelImpl.getOriginalProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] {
						funding_InstitutionProjectModelImpl.getProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}
		}

		EntityCacheUtil.putResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_InstitutionProjectImpl.class,
			funding_InstitutionProject.getPrimaryKey(),
			funding_InstitutionProject);

		return funding_InstitutionProject;
	}

	protected Funding_InstitutionProject toUnwrappedModel(
		Funding_InstitutionProject funding_InstitutionProject) {
		if (funding_InstitutionProject instanceof Funding_InstitutionProjectImpl) {
			return funding_InstitutionProject;
		}

		Funding_InstitutionProjectImpl funding_InstitutionProjectImpl = new Funding_InstitutionProjectImpl();

		funding_InstitutionProjectImpl.setNew(funding_InstitutionProject.isNew());
		funding_InstitutionProjectImpl.setPrimaryKey(funding_InstitutionProject.getPrimaryKey());

		funding_InstitutionProjectImpl.setProjectID(funding_InstitutionProject.getProjectID());
		funding_InstitutionProjectImpl.setFundingAgencyID(funding_InstitutionProject.getFundingAgencyID());
		funding_InstitutionProjectImpl.setFundingProgramID(funding_InstitutionProject.getFundingProgramID());
		funding_InstitutionProjectImpl.setInstitutionID(funding_InstitutionProject.getInstitutionID());

		return funding_InstitutionProjectImpl;
	}

	/**
	 * Returns the funding_ institution project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding_ institution project
	 * @return the funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		Funding_InstitutionProject funding_InstitutionProject = fetchByPrimaryKey(primaryKey);

		if (funding_InstitutionProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFunding_InstitutionProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return funding_InstitutionProject;
	}

	/**
	 * Returns the funding_ institution project with the primary key or throws a {@link org.gfbio.NoSuchFunding_InstitutionProjectException} if it could not be found.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	 * @return the funding_ institution project
	 * @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject findByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws NoSuchFunding_InstitutionProjectException, SystemException {
		return findByPrimaryKey((Serializable)funding_InstitutionProjectPK);
	}

	/**
	 * Returns the funding_ institution project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding_ institution project
	 * @return the funding_ institution project, or <code>null</code> if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Funding_InstitutionProject funding_InstitutionProject = (Funding_InstitutionProject)EntityCacheUtil.getResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
				Funding_InstitutionProjectImpl.class, primaryKey);

		if (funding_InstitutionProject == _nullFunding_InstitutionProject) {
			return null;
		}

		if (funding_InstitutionProject == null) {
			Session session = null;

			try {
				session = openSession();

				funding_InstitutionProject = (Funding_InstitutionProject)session.get(Funding_InstitutionProjectImpl.class,
						primaryKey);

				if (funding_InstitutionProject != null) {
					cacheResult(funding_InstitutionProject);
				}
				else {
					EntityCacheUtil.putResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
						Funding_InstitutionProjectImpl.class, primaryKey,
						_nullFunding_InstitutionProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Funding_InstitutionProjectModelImpl.ENTITY_CACHE_ENABLED,
					Funding_InstitutionProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return funding_InstitutionProject;
	}

	/**
	 * Returns the funding_ institution project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	 * @return the funding_ institution project, or <code>null</code> if a funding_ institution project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_InstitutionProject fetchByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)funding_InstitutionProjectPK);
	}

	/**
	 * Returns all the funding_ institution projects.
	 *
	 * @return the funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ institution projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @return the range of funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ institution projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funding_ institution projects
	 * @param end the upper bound of the range of funding_ institution projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of funding_ institution projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_InstitutionProject> findAll(int start, int end,
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

		List<Funding_InstitutionProject> list = (List<Funding_InstitutionProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUNDING_INSTITUTIONPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDING_INSTITUTIONPROJECT;

				if (pagination) {
					sql = sql.concat(Funding_InstitutionProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_InstitutionProject>(list);
				}
				else {
					list = (List<Funding_InstitutionProject>)QueryUtil.list(q,
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
	 * Removes all the funding_ institution projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Funding_InstitutionProject funding_InstitutionProject : findAll()) {
			remove(funding_InstitutionProject);
		}
	}

	/**
	 * Returns the number of funding_ institution projects.
	 *
	 * @return the number of funding_ institution projects
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

				Query q = session.createQuery(_SQL_COUNT_FUNDING_INSTITUTIONPROJECT);

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
	 * Initializes the funding_ institution project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Funding_InstitutionProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Funding_InstitutionProject>> listenersList = new ArrayList<ModelListener<Funding_InstitutionProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Funding_InstitutionProject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Funding_InstitutionProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUNDING_INSTITUTIONPROJECT = "SELECT funding_InstitutionProject FROM Funding_InstitutionProject funding_InstitutionProject";
	private static final String _SQL_SELECT_FUNDING_INSTITUTIONPROJECT_WHERE = "SELECT funding_InstitutionProject FROM Funding_InstitutionProject funding_InstitutionProject WHERE ";
	private static final String _SQL_COUNT_FUNDING_INSTITUTIONPROJECT = "SELECT COUNT(funding_InstitutionProject) FROM Funding_InstitutionProject funding_InstitutionProject";
	private static final String _SQL_COUNT_FUNDING_INSTITUTIONPROJECT_WHERE = "SELECT COUNT(funding_InstitutionProject) FROM Funding_InstitutionProject funding_InstitutionProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "funding_InstitutionProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Funding_InstitutionProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Funding_InstitutionProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Funding_InstitutionProjectPersistenceImpl.class);
	private static Funding_InstitutionProject _nullFunding_InstitutionProject = new Funding_InstitutionProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Funding_InstitutionProject> toCacheModel() {
				return _nullFunding_InstitutionProjectCacheModel;
			}
		};

	private static CacheModel<Funding_InstitutionProject> _nullFunding_InstitutionProjectCacheModel =
		new CacheModel<Funding_InstitutionProject>() {
			@Override
			public Funding_InstitutionProject toEntityModel() {
				return _nullFunding_InstitutionProject;
			}
		};
}