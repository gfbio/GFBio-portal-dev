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

import org.gfbio.NoSuchFunding_PersonProjectException;

import org.gfbio.model.Funding_PersonProject;
import org.gfbio.model.impl.Funding_PersonProjectImpl;
import org.gfbio.model.impl.Funding_PersonProjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the funding_ person project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectPersistence
 * @see Funding_PersonProjectUtil
 * @generated
 */
public class Funding_PersonProjectPersistenceImpl extends BasePersistenceImpl<Funding_PersonProject>
	implements Funding_PersonProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Funding_PersonProjectUtil} to access the funding_ person project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Funding_PersonProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDINGAGENCYID =
		new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFundingAgencyID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID =
		new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFundingAgencyID",
			new String[] { Long.class.getName() },
			Funding_PersonProjectModelImpl.FUNDINGAGENCYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNDINGAGENCYID = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFundingAgencyID", new String[] { Long.class.getName() });

	/**
	 * Returns all the funding_ person projects where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @return the matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID) throws SystemException {
		return findByFundingAgencyID(fundingAgencyID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ person projects where fundingAgencyID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @return the range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end) throws SystemException {
		return findByFundingAgencyID(fundingAgencyID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ person projects where fundingAgencyID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByFundingAgencyID(
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

		List<Funding_PersonProject> list = (List<Funding_PersonProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_PersonProject funding_PersonProject : list) {
				if ((fundingAgencyID != funding_PersonProject.getFundingAgencyID())) {
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

			query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_FUNDINGAGENCYID_FUNDINGAGENCYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundingAgencyID);

				if (!pagination) {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_PersonProject>(list);
				}
				else {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByFundingAgencyID_First(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByFundingAgencyID_First(fundingAgencyID,
				orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundingAgencyID=");
		msg.append(fundingAgencyID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByFundingAgencyID_First(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding_PersonProject> list = findByFundingAgencyID(fundingAgencyID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByFundingAgencyID_Last(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByFundingAgencyID_Last(fundingAgencyID,
				orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundingAgencyID=");
		msg.append(fundingAgencyID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByFundingAgencyID_Last(
		long fundingAgencyID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFundingAgencyID(fundingAgencyID);

		if (count == 0) {
			return null;
		}

		List<Funding_PersonProject> list = findByFundingAgencyID(fundingAgencyID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ person projects before and after the current funding_ person project in the ordered set where fundingAgencyID = &#63;.
	 *
	 * @param funding_PersonProjectPK the primary key of the current funding_ person project
	 * @param fundingAgencyID the funding agency i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject[] findByFundingAgencyID_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long fundingAgencyID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = findByPrimaryKey(funding_PersonProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_PersonProject[] array = new Funding_PersonProjectImpl[3];

			array[0] = getByFundingAgencyID_PrevAndNext(session,
					funding_PersonProject, fundingAgencyID, orderByComparator,
					true);

			array[1] = funding_PersonProject;

			array[2] = getByFundingAgencyID_PrevAndNext(session,
					funding_PersonProject, fundingAgencyID, orderByComparator,
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

	protected Funding_PersonProject getByFundingAgencyID_PrevAndNext(
		Session session, Funding_PersonProject funding_PersonProject,
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

		query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

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
			query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fundingAgencyID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_PersonProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_PersonProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ person projects where fundingAgencyID = &#63; from the database.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFundingAgencyID(long fundingAgencyID)
		throws SystemException {
		for (Funding_PersonProject funding_PersonProject : findByFundingAgencyID(
				fundingAgencyID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_PersonProject);
		}
	}

	/**
	 * Returns the number of funding_ person projects where fundingAgencyID = &#63;.
	 *
	 * @param fundingAgencyID the funding agency i d
	 * @return the number of matching funding_ person projects
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

			query.append(_SQL_COUNT_FUNDING_PERSONPROJECT_WHERE);

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
		"funding_PersonProject.id.fundingAgencyID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSON = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPerson",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON =
		new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPerson",
			new String[] { Long.class.getName(), String.class.getName() },
			Funding_PersonProjectModelImpl.PERSONID_COLUMN_BITMASK |
			Funding_PersonProjectModelImpl.PERSONTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSON = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPerson",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the funding_ person projects where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @return the matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByPerson(long personID,
		String personType) throws SystemException {
		return findByPerson(personID, personType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ person projects where personID = &#63; and personType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @return the range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByPerson(long personID,
		String personType, int start, int end) throws SystemException {
		return findByPerson(personID, personType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ person projects where personID = &#63; and personType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByPerson(long personID,
		String personType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON;
			finderArgs = new Object[] { personID, personType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSON;
			finderArgs = new Object[] {
					personID, personType,
					
					start, end, orderByComparator
				};
		}

		List<Funding_PersonProject> list = (List<Funding_PersonProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_PersonProject funding_PersonProject : list) {
				if ((personID != funding_PersonProject.getPersonID()) ||
						!Validator.equals(personType,
							funding_PersonProject.getPersonType())) {
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

			query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PERSON_PERSONID_2);

			boolean bindPersonType = false;

			if (personType == null) {
				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_1);
			}
			else if (personType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_3);
			}
			else {
				bindPersonType = true;

				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personID);

				if (bindPersonType) {
					qPos.add(personType);
				}

				if (!pagination) {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_PersonProject>(list);
				}
				else {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByPerson_First(long personID,
		String personType, OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByPerson_First(personID,
				personType, orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personID=");
		msg.append(personID);

		msg.append(", personType=");
		msg.append(personType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByPerson_First(long personID,
		String personType, OrderByComparator orderByComparator)
		throws SystemException {
		List<Funding_PersonProject> list = findByPerson(personID, personType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByPerson_Last(long personID,
		String personType, OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByPerson_Last(personID,
				personType, orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("personID=");
		msg.append(personID);

		msg.append(", personType=");
		msg.append(personType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByPerson_Last(long personID,
		String personType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPerson(personID, personType);

		if (count == 0) {
			return null;
		}

		List<Funding_PersonProject> list = findByPerson(personID, personType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ person projects before and after the current funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	 *
	 * @param funding_PersonProjectPK the primary key of the current funding_ person project
	 * @param personID the person i d
	 * @param personType the person type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject[] findByPerson_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long personID,
		String personType, OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = findByPrimaryKey(funding_PersonProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_PersonProject[] array = new Funding_PersonProjectImpl[3];

			array[0] = getByPerson_PrevAndNext(session, funding_PersonProject,
					personID, personType, orderByComparator, true);

			array[1] = funding_PersonProject;

			array[2] = getByPerson_PrevAndNext(session, funding_PersonProject,
					personID, personType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funding_PersonProject getByPerson_PrevAndNext(Session session,
		Funding_PersonProject funding_PersonProject, long personID,
		String personType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

		query.append(_FINDER_COLUMN_PERSON_PERSONID_2);

		boolean bindPersonType = false;

		if (personType == null) {
			query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_1);
		}
		else if (personType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_3);
		}
		else {
			bindPersonType = true;

			query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_2);
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
			query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(personID);

		if (bindPersonType) {
			qPos.add(personType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_PersonProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_PersonProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ person projects where personID = &#63; and personType = &#63; from the database.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPerson(long personID, String personType)
		throws SystemException {
		for (Funding_PersonProject funding_PersonProject : findByPerson(
				personID, personType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_PersonProject);
		}
	}

	/**
	 * Returns the number of funding_ person projects where personID = &#63; and personType = &#63;.
	 *
	 * @param personID the person i d
	 * @param personType the person type
	 * @return the number of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPerson(long personID, String personType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERSON;

		Object[] finderArgs = new Object[] { personID, personType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUNDING_PERSONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PERSON_PERSONID_2);

			boolean bindPersonType = false;

			if (personType == null) {
				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_1);
			}
			else if (personType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_3);
			}
			else {
				bindPersonType = true;

				query.append(_FINDER_COLUMN_PERSON_PERSONTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(personID);

				if (bindPersonType) {
					qPos.add(personType);
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

	private static final String _FINDER_COLUMN_PERSON_PERSONID_2 = "funding_PersonProject.id.personID = ? AND ";
	private static final String _FINDER_COLUMN_PERSON_PERSONTYPE_1 = "funding_PersonProject.id.personType IS NULL";
	private static final String _FINDER_COLUMN_PERSON_PERSONTYPE_2 = "funding_PersonProject.id.personType = ?";
	private static final String _FINDER_COLUMN_PERSON_PERSONTYPE_3 = "(funding_PersonProject.id.personType IS NULL OR funding_PersonProject.id.personType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectID",
			new String[] { Long.class.getName() },
			Funding_PersonProjectModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the funding_ person projects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByProjectID(long projectID)
		throws SystemException {
		return findByProjectID(projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the funding_ person projects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @return the range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByProjectID(long projectID,
		int start, int end) throws SystemException {
		return findByProjectID(projectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ person projects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findByProjectID(long projectID,
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

		List<Funding_PersonProject> list = (List<Funding_PersonProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Funding_PersonProject funding_PersonProject : list) {
				if ((projectID != funding_PersonProject.getProjectID())) {
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

			query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				if (!pagination) {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_PersonProject>(list);
				}
				else {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
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
	 * Returns the first funding_ person project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByProjectID_First(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByProjectID_First(projectID,
				orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the first funding_ person project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByProjectID_First(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Funding_PersonProject> list = findByProjectID(projectID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last funding_ person project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByProjectID_Last(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByProjectID_Last(projectID,
				orderByComparator);

		if (funding_PersonProject != null) {
			return funding_PersonProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFunding_PersonProjectException(msg.toString());
	}

	/**
	 * Returns the last funding_ person project in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByProjectID_Last(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectID(projectID);

		if (count == 0) {
			return null;
		}

		List<Funding_PersonProject> list = findByProjectID(projectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the funding_ person projects before and after the current funding_ person project in the ordered set where projectID = &#63;.
	 *
	 * @param funding_PersonProjectPK the primary key of the current funding_ person project
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject[] findByProjectID_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = findByPrimaryKey(funding_PersonProjectPK);

		Session session = null;

		try {
			session = openSession();

			Funding_PersonProject[] array = new Funding_PersonProjectImpl[3];

			array[0] = getByProjectID_PrevAndNext(session,
					funding_PersonProject, projectID, orderByComparator, true);

			array[1] = funding_PersonProject;

			array[2] = getByProjectID_PrevAndNext(session,
					funding_PersonProject, projectID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Funding_PersonProject getByProjectID_PrevAndNext(
		Session session, Funding_PersonProject funding_PersonProject,
		long projectID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDING_PERSONPROJECT_WHERE);

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
			query.append(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(funding_PersonProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Funding_PersonProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the funding_ person projects where projectID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectID(long projectID) throws SystemException {
		for (Funding_PersonProject funding_PersonProject : findByProjectID(
				projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(funding_PersonProject);
		}
	}

	/**
	 * Returns the number of funding_ person projects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the number of matching funding_ person projects
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

			query.append(_SQL_COUNT_FUNDING_PERSONPROJECT_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "funding_PersonProject.id.projectID = ?";

	public Funding_PersonProjectPersistenceImpl() {
		setModelClass(Funding_PersonProject.class);
	}

	/**
	 * Caches the funding_ person project in the entity cache if it is enabled.
	 *
	 * @param funding_PersonProject the funding_ person project
	 */
	@Override
	public void cacheResult(Funding_PersonProject funding_PersonProject) {
		EntityCacheUtil.putResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			funding_PersonProject.getPrimaryKey(), funding_PersonProject);

		funding_PersonProject.resetOriginalValues();
	}

	/**
	 * Caches the funding_ person projects in the entity cache if it is enabled.
	 *
	 * @param funding_PersonProjects the funding_ person projects
	 */
	@Override
	public void cacheResult(List<Funding_PersonProject> funding_PersonProjects) {
		for (Funding_PersonProject funding_PersonProject : funding_PersonProjects) {
			if (EntityCacheUtil.getResult(
						Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
						Funding_PersonProjectImpl.class,
						funding_PersonProject.getPrimaryKey()) == null) {
				cacheResult(funding_PersonProject);
			}
			else {
				funding_PersonProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all funding_ person projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Funding_PersonProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Funding_PersonProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the funding_ person project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Funding_PersonProject funding_PersonProject) {
		EntityCacheUtil.removeResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			funding_PersonProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Funding_PersonProject> funding_PersonProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Funding_PersonProject funding_PersonProject : funding_PersonProjects) {
			EntityCacheUtil.removeResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
				Funding_PersonProjectImpl.class,
				funding_PersonProject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new funding_ person project with the primary key. Does not add the funding_ person project to the database.
	 *
	 * @param funding_PersonProjectPK the primary key for the new funding_ person project
	 * @return the new funding_ person project
	 */
	@Override
	public Funding_PersonProject create(
		Funding_PersonProjectPK funding_PersonProjectPK) {
		Funding_PersonProject funding_PersonProject = new Funding_PersonProjectImpl();

		funding_PersonProject.setNew(true);
		funding_PersonProject.setPrimaryKey(funding_PersonProjectPK);

		return funding_PersonProject;
	}

	/**
	 * Removes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param funding_PersonProjectPK the primary key of the funding_ person project
	 * @return the funding_ person project that was removed
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject remove(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws NoSuchFunding_PersonProjectException, SystemException {
		return remove((Serializable)funding_PersonProjectPK);
	}

	/**
	 * Removes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the funding_ person project
	 * @return the funding_ person project that was removed
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject remove(Serializable primaryKey)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Funding_PersonProject funding_PersonProject = (Funding_PersonProject)session.get(Funding_PersonProjectImpl.class,
					primaryKey);

			if (funding_PersonProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFunding_PersonProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(funding_PersonProject);
		}
		catch (NoSuchFunding_PersonProjectException nsee) {
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
	protected Funding_PersonProject removeImpl(
		Funding_PersonProject funding_PersonProject) throws SystemException {
		funding_PersonProject = toUnwrappedModel(funding_PersonProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(funding_PersonProject)) {
				funding_PersonProject = (Funding_PersonProject)session.get(Funding_PersonProjectImpl.class,
						funding_PersonProject.getPrimaryKeyObj());
			}

			if (funding_PersonProject != null) {
				session.delete(funding_PersonProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (funding_PersonProject != null) {
			clearCache(funding_PersonProject);
		}

		return funding_PersonProject;
	}

	@Override
	public Funding_PersonProject updateImpl(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws SystemException {
		funding_PersonProject = toUnwrappedModel(funding_PersonProject);

		boolean isNew = funding_PersonProject.isNew();

		Funding_PersonProjectModelImpl funding_PersonProjectModelImpl = (Funding_PersonProjectModelImpl)funding_PersonProject;

		Session session = null;

		try {
			session = openSession();

			if (funding_PersonProject.isNew()) {
				session.save(funding_PersonProject);

				funding_PersonProject.setNew(false);
			}
			else {
				session.merge(funding_PersonProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Funding_PersonProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((funding_PersonProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_PersonProjectModelImpl.getOriginalFundingAgencyID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDINGAGENCYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID,
					args);

				args = new Object[] {
						funding_PersonProjectModelImpl.getFundingAgencyID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDINGAGENCYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDINGAGENCYID,
					args);
			}

			if ((funding_PersonProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_PersonProjectModelImpl.getOriginalPersonID(),
						funding_PersonProjectModelImpl.getOriginalPersonType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON,
					args);

				args = new Object[] {
						funding_PersonProjectModelImpl.getPersonID(),
						funding_PersonProjectModelImpl.getPersonType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON,
					args);
			}

			if ((funding_PersonProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						funding_PersonProjectModelImpl.getOriginalProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] {
						funding_PersonProjectModelImpl.getProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}
		}

		EntityCacheUtil.putResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
			Funding_PersonProjectImpl.class,
			funding_PersonProject.getPrimaryKey(), funding_PersonProject);

		return funding_PersonProject;
	}

	protected Funding_PersonProject toUnwrappedModel(
		Funding_PersonProject funding_PersonProject) {
		if (funding_PersonProject instanceof Funding_PersonProjectImpl) {
			return funding_PersonProject;
		}

		Funding_PersonProjectImpl funding_PersonProjectImpl = new Funding_PersonProjectImpl();

		funding_PersonProjectImpl.setNew(funding_PersonProject.isNew());
		funding_PersonProjectImpl.setPrimaryKey(funding_PersonProject.getPrimaryKey());

		funding_PersonProjectImpl.setProjectID(funding_PersonProject.getProjectID());
		funding_PersonProjectImpl.setFundingAgencyID(funding_PersonProject.getFundingAgencyID());
		funding_PersonProjectImpl.setFundingProgramID(funding_PersonProject.getFundingProgramID());
		funding_PersonProjectImpl.setPersonID(funding_PersonProject.getPersonID());
		funding_PersonProjectImpl.setPersonType(funding_PersonProject.getPersonType());
		funding_PersonProjectImpl.setLastModifiedDate(funding_PersonProject.getLastModifiedDate());

		return funding_PersonProjectImpl;
	}

	/**
	 * Returns the funding_ person project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding_ person project
	 * @return the funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFunding_PersonProjectException, SystemException {
		Funding_PersonProject funding_PersonProject = fetchByPrimaryKey(primaryKey);

		if (funding_PersonProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFunding_PersonProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return funding_PersonProject;
	}

	/**
	 * Returns the funding_ person project with the primary key or throws a {@link org.gfbio.NoSuchFunding_PersonProjectException} if it could not be found.
	 *
	 * @param funding_PersonProjectPK the primary key of the funding_ person project
	 * @return the funding_ person project
	 * @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject findByPrimaryKey(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws NoSuchFunding_PersonProjectException, SystemException {
		return findByPrimaryKey((Serializable)funding_PersonProjectPK);
	}

	/**
	 * Returns the funding_ person project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the funding_ person project
	 * @return the funding_ person project, or <code>null</code> if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Funding_PersonProject funding_PersonProject = (Funding_PersonProject)EntityCacheUtil.getResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
				Funding_PersonProjectImpl.class, primaryKey);

		if (funding_PersonProject == _nullFunding_PersonProject) {
			return null;
		}

		if (funding_PersonProject == null) {
			Session session = null;

			try {
				session = openSession();

				funding_PersonProject = (Funding_PersonProject)session.get(Funding_PersonProjectImpl.class,
						primaryKey);

				if (funding_PersonProject != null) {
					cacheResult(funding_PersonProject);
				}
				else {
					EntityCacheUtil.putResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
						Funding_PersonProjectImpl.class, primaryKey,
						_nullFunding_PersonProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Funding_PersonProjectModelImpl.ENTITY_CACHE_ENABLED,
					Funding_PersonProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return funding_PersonProject;
	}

	/**
	 * Returns the funding_ person project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param funding_PersonProjectPK the primary key of the funding_ person project
	 * @return the funding_ person project, or <code>null</code> if a funding_ person project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Funding_PersonProject fetchByPrimaryKey(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)funding_PersonProjectPK);
	}

	/**
	 * Returns all the funding_ person projects.
	 *
	 * @return the funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the funding_ person projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @return the range of funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the funding_ person projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of funding_ person projects
	 * @param end the upper bound of the range of funding_ person projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of funding_ person projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Funding_PersonProject> findAll(int start, int end,
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

		List<Funding_PersonProject> list = (List<Funding_PersonProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FUNDING_PERSONPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDING_PERSONPROJECT;

				if (pagination) {
					sql = sql.concat(Funding_PersonProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Funding_PersonProject>(list);
				}
				else {
					list = (List<Funding_PersonProject>)QueryUtil.list(q,
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
	 * Removes all the funding_ person projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Funding_PersonProject funding_PersonProject : findAll()) {
			remove(funding_PersonProject);
		}
	}

	/**
	 * Returns the number of funding_ person projects.
	 *
	 * @return the number of funding_ person projects
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

				Query q = session.createQuery(_SQL_COUNT_FUNDING_PERSONPROJECT);

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
	 * Initializes the funding_ person project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Funding_PersonProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Funding_PersonProject>> listenersList = new ArrayList<ModelListener<Funding_PersonProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Funding_PersonProject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Funding_PersonProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FUNDING_PERSONPROJECT = "SELECT funding_PersonProject FROM Funding_PersonProject funding_PersonProject";
	private static final String _SQL_SELECT_FUNDING_PERSONPROJECT_WHERE = "SELECT funding_PersonProject FROM Funding_PersonProject funding_PersonProject WHERE ";
	private static final String _SQL_COUNT_FUNDING_PERSONPROJECT = "SELECT COUNT(funding_PersonProject) FROM Funding_PersonProject funding_PersonProject";
	private static final String _SQL_COUNT_FUNDING_PERSONPROJECT_WHERE = "SELECT COUNT(funding_PersonProject) FROM Funding_PersonProject funding_PersonProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "funding_PersonProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Funding_PersonProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Funding_PersonProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Funding_PersonProjectPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static Funding_PersonProject _nullFunding_PersonProject = new Funding_PersonProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Funding_PersonProject> toCacheModel() {
				return _nullFunding_PersonProjectCacheModel;
			}
		};

	private static CacheModel<Funding_PersonProject> _nullFunding_PersonProjectCacheModel =
		new CacheModel<Funding_PersonProject>() {
			@Override
			public Funding_PersonProject toEntityModel() {
				return _nullFunding_PersonProject;
			}
		};
}