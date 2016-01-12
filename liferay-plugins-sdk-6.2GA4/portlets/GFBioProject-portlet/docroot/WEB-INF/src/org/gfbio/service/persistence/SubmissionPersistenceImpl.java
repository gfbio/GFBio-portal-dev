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

import org.gfbio.NoSuchSubmissionException;

import org.gfbio.model.Submission;
import org.gfbio.model.impl.SubmissionImpl;
import org.gfbio.model.impl.SubmissionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionPersistence
 * @see SubmissionUtil
 * @generated
 */
public class SubmissionPersistenceImpl extends BasePersistenceImpl<Submission>
	implements SubmissionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubmissionUtil} to access the submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubmissionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchObjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectID", new String[] { Long.class.getName() },
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID", new String[] { Long.class.getName() });

	/**
	 * Returns all the submissions where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectID(long researchObjectID)
		throws SystemException {
		return findByResearchObjectID(researchObjectID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectID(long researchObjectID,
		int start, int end) throws SystemException {
		return findByResearchObjectID(researchObjectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectID(long researchObjectID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if ((researchObjectID != submission.getResearchObjectID())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByResearchObjectID_First(long researchObjectID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByResearchObjectID_First(researchObjectID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectID_First(long researchObjectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByResearchObjectID(researchObjectID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByResearchObjectID_Last(long researchObjectID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByResearchObjectID_Last(researchObjectID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectID_Last(long researchObjectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResearchObjectID(researchObjectID);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByResearchObjectID(researchObjectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where researchObjectID = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByResearchObjectID_PrevAndNext(long submissionID,
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByResearchObjectID_PrevAndNext(session, submission,
					researchObjectID, orderByComparator, true);

			array[1] = submission;

			array[2] = getByResearchObjectID_PrevAndNext(session, submission,
					researchObjectID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByResearchObjectID_PrevAndNext(Session session,
		Submission submission, long researchObjectID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectID(long researchObjectID)
		throws SystemException {
		for (Submission submission : findByResearchObjectID(researchObjectID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.researchObjectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResearchObjectIDWithVersion",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectIDWithVersion",
			new String[] { Long.class.getName(), Long.class.getName() },
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectIDWithVersion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion)
		throws SystemException {
		return findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion, int start, int end)
		throws SystemException {
		return findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByResearchObjectIDWithVersion(
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if ((researchObjectID != submission.getResearchObjectID()) ||
						(researchObjectVersion != submission.getResearchObjectVersion())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByResearchObjectIDWithVersion_First(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByResearchObjectIDWithVersion_Last(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByResearchObjectIDWithVersion(researchObjectID,
				researchObjectVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByResearchObjectIDWithVersion_PrevAndNext(
		long submissionID, long researchObjectID, long researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByResearchObjectIDWithVersion_PrevAndNext(session,
					submission, researchObjectID, researchObjectVersion,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByResearchObjectIDWithVersion_PrevAndNext(session,
					submission, researchObjectID, researchObjectVersion,
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

	protected Submission getByResearchObjectIDWithVersion_PrevAndNext(
		Session session, Submission submission, long researchObjectID,
		long researchObjectVersion, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		qPos.add(researchObjectVersion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectIDWithVersion(long researchObjectID,
		long researchObjectVersion) throws SystemException {
		for (Submission submission : findByResearchObjectIDWithVersion(
				researchObjectID, researchObjectVersion, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHVERSION_RESEARCHOBJECTVERSION_2 =
		"submission.researchObjectVersion = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByResearchObjectIDWithLastChanges",
			new String[] { Long.class.getName(), Date.class.getName() },
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			SubmissionModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectIDWithLastChanges",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByResearchObjectIDWithLastChanges(researchObjectID,
				lastChanged);

		if (submission == null) {
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

			throw new NoSuchSubmissionException(msg.toString());
		}

		return submission;
	}

	/**
	 * Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged) throws SystemException {
		return fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged, true);
	}

	/**
	 * Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { researchObjectID, lastChanged };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					finderArgs, this);
		}

		if (result instanceof Submission) {
			Submission submission = (Submission)result;

			if ((researchObjectID != submission.getResearchObjectID()) ||
					!Validator.equals(lastChanged, submission.getLastChanged())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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

				List<Submission> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SubmissionPersistenceImpl.fetchByResearchObjectIDWithLastChanges(long, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Submission submission = list.get(0);

					result = submission;

					cacheResult(submission);

					if ((submission.getResearchObjectID() != researchObjectID) ||
							(submission.getLastChanged() == null) ||
							!submission.getLastChanged().equals(lastChanged)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
							finderArgs, submission);
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
			return (Submission)result;
		}
	}

	/**
	 * Removes the submission where researchObjectID = &#63; and lastChanged = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the submission that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission removeByResearchObjectIDWithLastChanges(
		long researchObjectID, Date lastChanged)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByResearchObjectIDWithLastChanges(researchObjectID,
				lastChanged);

		return remove(submission);
	}

	/**
	 * Returns the number of submissions where researchObjectID = &#63; and lastChanged = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param lastChanged the last changed
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_1 =
		"submission.lastChanged IS NULL";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDWITHLASTCHANGES_LASTCHANGED_2 =
		"submission.lastChanged = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARCHIVE = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArchive",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArchive",
			new String[] { String.class.getName() },
			SubmissionModelImpl.ARCHIVE_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARCHIVE = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArchive",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submissions where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByArchive(String archive)
		throws SystemException {
		return findByArchive(archive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByArchive(String archive, int start, int end)
		throws SystemException {
		return findByArchive(archive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByArchive(String archive, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if (!Validator.equals(archive, submission.getArchive())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByArchive_First(String archive,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByArchive_First(archive, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByArchive_First(String archive,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByArchive(archive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByArchive_Last(String archive,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByArchive_Last(archive, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByArchive_Last(String archive,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArchive(archive);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByArchive(archive, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where archive = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByArchive_PrevAndNext(long submissionID,
		String archive, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByArchive_PrevAndNext(session, submission, archive,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByArchive_PrevAndNext(session, submission, archive,
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

	protected Submission getByArchive_PrevAndNext(Session session,
		Submission submission, String archive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where archive = &#63; from the database.
	 *
	 * @param archive the archive
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArchive(String archive) throws SystemException {
		for (Submission submission : findByArchive(archive, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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

	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_1 = "submission.archive IS NULL";
	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_2 = "submission.archive = ?";
	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_3 = "(submission.archive IS NULL OR submission.archive = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BROKERSUBMISSIONID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBrokerSubmissionID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBrokerSubmissionID",
			new String[] { String.class.getName() },
			SubmissionModelImpl.BROKERSUBMISSIONID_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBrokerSubmissionID", new String[] { String.class.getName() });

	/**
	 * Returns all the submissions where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByBrokerSubmissionID(String brokerSubmissionID)
		throws SystemException {
		return findByBrokerSubmissionID(brokerSubmissionID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where brokerSubmissionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByBrokerSubmissionID(
		String brokerSubmissionID, int start, int end)
		throws SystemException {
		return findByBrokerSubmissionID(brokerSubmissionID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where brokerSubmissionID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByBrokerSubmissionID(
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if (!Validator.equals(brokerSubmissionID,
							submission.getBrokerSubmissionID())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByBrokerSubmissionID_First(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByBrokerSubmissionID_First(brokerSubmissionID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brokerSubmissionID=");
		msg.append(brokerSubmissionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByBrokerSubmissionID_First(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Submission> list = findByBrokerSubmissionID(brokerSubmissionID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByBrokerSubmissionID_Last(String brokerSubmissionID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByBrokerSubmissionID_Last(brokerSubmissionID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("brokerSubmissionID=");
		msg.append(brokerSubmissionID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByBrokerSubmissionID_Last(
		String brokerSubmissionID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBrokerSubmissionID(brokerSubmissionID);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByBrokerSubmissionID(brokerSubmissionID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where brokerSubmissionID = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param brokerSubmissionID the broker submission i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByBrokerSubmissionID_PrevAndNext(
		long submissionID, String brokerSubmissionID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByBrokerSubmissionID_PrevAndNext(session, submission,
					brokerSubmissionID, orderByComparator, true);

			array[1] = submission;

			array[2] = getByBrokerSubmissionID_PrevAndNext(session, submission,
					brokerSubmissionID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByBrokerSubmissionID_PrevAndNext(Session session,
		Submission submission, String brokerSubmissionID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where brokerSubmissionID = &#63; from the database.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBrokerSubmissionID(String brokerSubmissionID)
		throws SystemException {
		for (Submission submission : findByBrokerSubmissionID(
				brokerSubmissionID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where brokerSubmissionID = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.brokerSubmissionID IS NULL";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_2 =
		"submission.brokerSubmissionID = ?";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONID_BROKERSUBMISSIONID_3 =
		"(submission.brokerSubmissionID IS NULL OR submission.brokerSubmissionID = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByBrokerSubmissionIDWithLastChanges",
			new String[] { String.class.getName(), Date.class.getName() },
			SubmissionModelImpl.BROKERSUBMISSIONID_COLUMN_BITMASK |
			SubmissionModelImpl.LASTCHANGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBrokerSubmissionIDWithLastChanges",
			new String[] { String.class.getName(), Date.class.getName() });

	/**
	 * Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
				lastChanged);

		if (submission == null) {
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

			throw new NoSuchSubmissionException(msg.toString());
		}

		return submission;
	}

	/**
	 * Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged) throws SystemException {
		return fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged, true);
	}

	/**
	 * Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { brokerSubmissionID, lastChanged };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					finderArgs, this);
		}

		if (result instanceof Submission) {
			Submission submission = (Submission)result;

			if (!Validator.equals(brokerSubmissionID,
						submission.getBrokerSubmissionID()) ||
					!Validator.equals(lastChanged, submission.getLastChanged())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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

				List<Submission> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SubmissionPersistenceImpl.fetchByBrokerSubmissionIDWithLastChanges(String, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Submission submission = list.get(0);

					result = submission;

					cacheResult(submission);

					if ((submission.getBrokerSubmissionID() == null) ||
							!submission.getBrokerSubmissionID()
										   .equals(brokerSubmissionID) ||
							(submission.getLastChanged() == null) ||
							!submission.getLastChanged().equals(lastChanged)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
							finderArgs, submission);
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
			return (Submission)result;
		}
	}

	/**
	 * Removes the submission where brokerSubmissionID = &#63; and lastChanged = &#63; from the database.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the submission that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission removeByBrokerSubmissionIDWithLastChanges(
		String brokerSubmissionID, Date lastChanged)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
				lastChanged);

		return remove(submission);
	}

	/**
	 * Returns the number of submissions where brokerSubmissionID = &#63; and lastChanged = &#63;.
	 *
	 * @param brokerSubmissionID the broker submission i d
	 * @param lastChanged the last changed
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.brokerSubmissionID IS NULL AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_2 =
		"submission.brokerSubmissionID = ? AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_BROKERSUBMISSIONID_3 =
		"(submission.brokerSubmissionID IS NULL OR submission.brokerSubmissionID = '') AND ";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_1 =
		"submission.lastChanged IS NULL";
	private static final String _FINDER_COLUMN_BROKERSUBMISSIONIDWITHLASTCHANGES_LASTCHANGED_2 =
		"submission.lastChanged = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistentIdentifierID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistentIdentifierID",
			new String[] { String.class.getName() },
			SubmissionModelImpl.ARCHIVEPID_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistentIdentifierID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submissions where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierID(String archivePID)
		throws SystemException {
		return findByPersistentIdentifierID(archivePID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where archivePID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePID the archive p i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierID(String archivePID,
		int start, int end) throws SystemException {
		return findByPersistentIdentifierID(archivePID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where archivePID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePID the archive p i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierID(String archivePID,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if (!Validator.equals(archivePID, submission.getArchivePID())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPersistentIdentifierID_First(String archivePID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPersistentIdentifierID_First(archivePID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePID=");
		msg.append(archivePID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPersistentIdentifierID_First(String archivePID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByPersistentIdentifierID(archivePID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPersistentIdentifierID_Last(String archivePID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPersistentIdentifierID_Last(archivePID,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePID=");
		msg.append(archivePID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPersistentIdentifierID_Last(String archivePID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPersistentIdentifierID(archivePID);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByPersistentIdentifierID(archivePID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where archivePID = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param archivePID the archive p i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByPersistentIdentifierID_PrevAndNext(
		long submissionID, String archivePID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByPersistentIdentifierID_PrevAndNext(session,
					submission, archivePID, orderByComparator, true);

			array[1] = submission;

			array[2] = getByPersistentIdentifierID_PrevAndNext(session,
					submission, archivePID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByPersistentIdentifierID_PrevAndNext(
		Session session, Submission submission, String archivePID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where archivePID = &#63; from the database.
	 *
	 * @param archivePID the archive p i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersistentIdentifierID(String archivePID)
		throws SystemException {
		for (Submission submission : findByPersistentIdentifierID(archivePID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where archivePID = &#63;.
	 *
	 * @param archivePID the archive p i d
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.archivePID IS NULL";
	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_2 =
		"submission.archivePID = ?";
	private static final String _FINDER_COLUMN_PERSISTENTIDENTIFIERID_ARCHIVEPID_3 =
		"(submission.archivePID IS NULL OR submission.archivePID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPersistentIdentifierTypeID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPersistentIdentifierTypeID",
			new String[] { Long.class.getName() },
			SubmissionModelImpl.ARCHIVEPIDTYPE_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPersistentIdentifierTypeID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submissions where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierTypeID(
		long archivePIDType) throws SystemException {
		return findByPersistentIdentifierTypeID(archivePIDType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where archivePIDType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePIDType the archive p i d type
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end) throws SystemException {
		return findByPersistentIdentifierTypeID(archivePIDType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where archivePIDType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archivePIDType the archive p i d type
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByPersistentIdentifierTypeID(
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if ((archivePIDType != submission.getArchivePIDType())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_PERSISTENTIDENTIFIERTYPEID_ARCHIVEPIDTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(archivePIDType);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPersistentIdentifierTypeID_First(
		long archivePIDType, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPersistentIdentifierTypeID_First(archivePIDType,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePIDType=");
		msg.append(archivePIDType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPersistentIdentifierTypeID_First(
		long archivePIDType, OrderByComparator orderByComparator)
		throws SystemException {
		List<Submission> list = findByPersistentIdentifierTypeID(archivePIDType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPersistentIdentifierTypeID_Last(
		long archivePIDType, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPersistentIdentifierTypeID_Last(archivePIDType,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archivePIDType=");
		msg.append(archivePIDType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPersistentIdentifierTypeID_Last(
		long archivePIDType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPersistentIdentifierTypeID(archivePIDType);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByPersistentIdentifierTypeID(archivePIDType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where archivePIDType = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param archivePIDType the archive p i d type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByPersistentIdentifierTypeID_PrevAndNext(
		long submissionID, long archivePIDType,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByPersistentIdentifierTypeID_PrevAndNext(session,
					submission, archivePIDType, orderByComparator, true);

			array[1] = submission;

			array[2] = getByPersistentIdentifierTypeID_PrevAndNext(session,
					submission, archivePIDType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Submission getByPersistentIdentifierTypeID_PrevAndNext(
		Session session, Submission submission, long archivePIDType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(archivePIDType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where archivePIDType = &#63; from the database.
	 *
	 * @param archivePIDType the archive p i d type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPersistentIdentifierTypeID(long archivePIDType)
		throws SystemException {
		for (Submission submission : findByPersistentIdentifierTypeID(
				archivePIDType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where archivePIDType = &#63;.
	 *
	 * @param archivePIDType the archive p i d type
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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
		"submission.archivePIDType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			SubmissionModelImpl.USERID_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the submissions where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByUserID(long userID) throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByUserID(long userID, int start, int end,
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if ((userID != submission.getUserID())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByUserID_First(userID, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByUserID_Last(userID, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where userID = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByUserID_PrevAndNext(long submissionID,
		long userID, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByUserID_PrevAndNext(session, submission, userID,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByUserID_PrevAndNext(session, submission, userID,
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

	protected Submission getByUserID_PrevAndNext(Session session,
		Submission submission, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Submission submission : findByUserID(userID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "submission.userID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPUBLIC = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPublic",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPublic",
			new String[] { Boolean.class.getName() },
			SubmissionModelImpl.ISPUBLIC_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPUBLIC = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPublic",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the submissions where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByIsPublic(boolean isPublic)
		throws SystemException {
		return findByIsPublic(isPublic, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the submissions where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByIsPublic(boolean isPublic, int start, int end)
		throws SystemException {
		return findByIsPublic(isPublic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByIsPublic(boolean isPublic, int start,
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if ((isPublic != submission.getIsPublic())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByIsPublic_First(isPublic,
				orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByIsPublic(isPublic, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByIsPublic_Last(isPublic, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsPublic(isPublic);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByIsPublic(isPublic, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where isPublic = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByIsPublic_PrevAndNext(long submissionID,
		boolean isPublic, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByIsPublic_PrevAndNext(session, submission, isPublic,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByIsPublic_PrevAndNext(session, submission, isPublic,
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

	protected Submission getByIsPublic_PrevAndNext(Session session,
		Submission submission, boolean isPublic,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isPublic);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where isPublic = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsPublic(boolean isPublic) throws SystemException {
		for (Submission submission : findByIsPublic(isPublic,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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

	private static final String _FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2 = "submission.isPublic = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, SubmissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			SubmissionModelImpl.STATUS_COLUMN_BITMASK |
			SubmissionModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the submissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByStatus(String status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByStatus(String status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findByStatus(String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Submission submission : list) {
				if (!Validator.equals(status, submission.getStatus())) {
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

			query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
				query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first submission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByStatus_First(status, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the first submission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Submission> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last submission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission
	 * @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByStatus_Last(status, orderByComparator);

		if (submission != null) {
			return submission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubmissionException(msg.toString());
	}

	/**
	 * Returns the last submission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching submission, or <code>null</code> if a matching submission could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Submission> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the submissions before and after the current submission in the ordered set where status = &#63;.
	 *
	 * @param submissionID the primary key of the current submission
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission[] findByStatus_PrevAndNext(long submissionID,
		String status, OrderByComparator orderByComparator)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = findByPrimaryKey(submissionID);

		Session session = null;

		try {
			session = openSession();

			Submission[] array = new SubmissionImpl[3];

			array[0] = getByStatus_PrevAndNext(session, submission, status,
					orderByComparator, true);

			array[1] = submission;

			array[2] = getByStatus_PrevAndNext(session, submission, status,
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

	protected Submission getByStatus_PrevAndNext(Session session,
		Submission submission, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBMISSION_WHERE);

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
			query.append(SubmissionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(submission);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Submission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the submissions where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(String status) throws SystemException {
		for (Submission submission : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching submissions
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

			query.append(_SQL_COUNT_SUBMISSION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "submission.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "submission.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(submission.status IS NULL OR submission.status = '')";

	public SubmissionPersistenceImpl() {
		setModelClass(Submission.class);
	}

	/**
	 * Caches the submission in the entity cache if it is enabled.
	 *
	 * @param submission the submission
	 */
	@Override
	public void cacheResult(Submission submission) {
		EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			new Object[] {
				submission.getResearchObjectID(), submission.getLastChanged()
			}, submission);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			new Object[] {
				submission.getBrokerSubmissionID(), submission.getLastChanged()
			}, submission);

		submission.resetOriginalValues();
	}

	/**
	 * Caches the submissions in the entity cache if it is enabled.
	 *
	 * @param submissions the submissions
	 */
	@Override
	public void cacheResult(List<Submission> submissions) {
		for (Submission submission : submissions) {
			if (EntityCacheUtil.getResult(
						SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, submission.getPrimaryKey()) == null) {
				cacheResult(submission);
			}
			else {
				submission.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all submissions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SubmissionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SubmissionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the submission.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Submission submission) {
		EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(submission);
	}

	@Override
	public void clearCache(List<Submission> submissions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Submission submission : submissions) {
			EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, submission.getPrimaryKey());

			clearUniqueFindersCache(submission);
		}
	}

	protected void cacheUniqueFindersCache(Submission submission) {
		if (submission.isNew()) {
			Object[] args = new Object[] {
					submission.getResearchObjectID(),
					submission.getLastChanged()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args, submission);

			args = new Object[] {
					submission.getBrokerSubmissionID(),
					submission.getLastChanged()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args, submission);
		}
		else {
			SubmissionModelImpl submissionModelImpl = (SubmissionModelImpl)submission;

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submission.getResearchObjectID(),
						submission.getLastChanged()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
					args, submission);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submission.getBrokerSubmissionID(),
						submission.getLastChanged()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
					args, submission);
			}
		}
	}

	protected void clearUniqueFindersCache(Submission submission) {
		SubmissionModelImpl submissionModelImpl = (SubmissionModelImpl)submission;

		Object[] args = new Object[] {
				submission.getResearchObjectID(), submission.getLastChanged()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
			args);

		if ((submissionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
			args = new Object[] {
					submissionModelImpl.getOriginalResearchObjectID(),
					submissionModelImpl.getOriginalLastChanged()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTIDWITHLASTCHANGES,
				args);
		}

		args = new Object[] {
				submission.getBrokerSubmissionID(), submission.getLastChanged()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
			args);

		if ((submissionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES.getColumnBitmask()) != 0) {
			args = new Object[] {
					submissionModelImpl.getOriginalBrokerSubmissionID(),
					submissionModelImpl.getOriginalLastChanged()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BROKERSUBMISSIONIDWITHLASTCHANGES,
				args);
		}
	}

	/**
	 * Creates a new submission with the primary key. Does not add the submission to the database.
	 *
	 * @param submissionID the primary key for the new submission
	 * @return the new submission
	 */
	@Override
	public Submission create(long submissionID) {
		Submission submission = new SubmissionImpl();

		submission.setNew(true);
		submission.setPrimaryKey(submissionID);

		return submission;
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param submissionID the primary key of the submission
	 * @return the submission that was removed
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission remove(long submissionID)
		throws NoSuchSubmissionException, SystemException {
		return remove((Serializable)submissionID);
	}

	/**
	 * Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission that was removed
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission remove(Serializable primaryKey)
		throws NoSuchSubmissionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Submission submission = (Submission)session.get(SubmissionImpl.class,
					primaryKey);

			if (submission == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(submission);
		}
		catch (NoSuchSubmissionException nsee) {
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
	protected Submission removeImpl(Submission submission)
		throws SystemException {
		submission = toUnwrappedModel(submission);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(submission)) {
				submission = (Submission)session.get(SubmissionImpl.class,
						submission.getPrimaryKeyObj());
			}

			if (submission != null) {
				session.delete(submission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (submission != null) {
			clearCache(submission);
		}

		return submission;
	}

	@Override
	public Submission updateImpl(org.gfbio.model.Submission submission)
		throws SystemException {
		submission = toUnwrappedModel(submission);

		boolean isNew = submission.isNew();

		SubmissionModelImpl submissionModelImpl = (SubmissionModelImpl)submission;

		Session session = null;

		try {
			session = openSession();

			if (submission.isNew()) {
				session.save(submission);

				submission.setNew(false);
			}
			else {
				session.merge(submission);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubmissionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);

				args = new Object[] { submissionModelImpl.getResearchObjectID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalResearchObjectID(),
						submissionModelImpl.getOriginalResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION,
					args);

				args = new Object[] {
						submissionModelImpl.getResearchObjectID(),
						submissionModelImpl.getResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDWITHVERSION,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalArchive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);

				args = new Object[] { submissionModelImpl.getArchive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalBrokerSubmissionID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID,
					args);

				args = new Object[] { submissionModelImpl.getBrokerSubmissionID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BROKERSUBMISSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BROKERSUBMISSIONID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalArchivePID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID,
					args);

				args = new Object[] { submissionModelImpl.getArchivePID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalArchivePIDType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID,
					args);

				args = new Object[] { submissionModelImpl.getArchivePIDType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSISTENTIDENTIFIERTYPEID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { submissionModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalIsPublic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);

				args = new Object[] { submissionModelImpl.getIsPublic() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);
			}

			if ((submissionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						submissionModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { submissionModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
			SubmissionImpl.class, submission.getPrimaryKey(), submission);

		clearUniqueFindersCache(submission);
		cacheUniqueFindersCache(submission);

		return submission;
	}

	protected Submission toUnwrappedModel(Submission submission) {
		if (submission instanceof SubmissionImpl) {
			return submission;
		}

		SubmissionImpl submissionImpl = new SubmissionImpl();

		submissionImpl.setNew(submission.isNew());
		submissionImpl.setPrimaryKey(submission.getPrimaryKey());

		submissionImpl.setSubmissionID(submission.getSubmissionID());
		submissionImpl.setResearchObjectID(submission.getResearchObjectID());
		submissionImpl.setResearchObjectVersion(submission.getResearchObjectVersion());
		submissionImpl.setArchive(submission.getArchive());
		submissionImpl.setBrokerSubmissionID(submission.getBrokerSubmissionID());
		submissionImpl.setArchivePID(submission.getArchivePID());
		submissionImpl.setArchivePIDType(submission.getArchivePIDType());
		submissionImpl.setLastChanged(submission.getLastChanged());
		submissionImpl.setUserID(submission.getUserID());
		submissionImpl.setIsPublic(submission.isIsPublic());
		submissionImpl.setPublicAfter(submission.getPublicAfter());
		submissionImpl.setStatus(submission.getStatus());

		return submissionImpl;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubmissionException, SystemException {
		Submission submission = fetchByPrimaryKey(primaryKey);

		if (submission == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubmissionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	 *
	 * @param submissionID the primary key of the submission
	 * @return the submission
	 * @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission findByPrimaryKey(long submissionID)
		throws NoSuchSubmissionException, SystemException {
		return findByPrimaryKey((Serializable)submissionID);
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Submission submission = (Submission)EntityCacheUtil.getResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
				SubmissionImpl.class, primaryKey);

		if (submission == _nullSubmission) {
			return null;
		}

		if (submission == null) {
			Session session = null;

			try {
				session = openSession();

				submission = (Submission)session.get(SubmissionImpl.class,
						primaryKey);

				if (submission != null) {
					cacheResult(submission);
				}
				else {
					EntityCacheUtil.putResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
						SubmissionImpl.class, primaryKey, _nullSubmission);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SubmissionModelImpl.ENTITY_CACHE_ENABLED,
					SubmissionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return submission;
	}

	/**
	 * Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param submissionID the primary key of the submission
	 * @return the submission, or <code>null</code> if a submission with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Submission fetchByPrimaryKey(long submissionID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)submissionID);
	}

	/**
	 * Returns all the submissions.
	 *
	 * @return the submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @return the range of submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the submissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of submissions
	 * @param end the upper bound of the range of submissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of submissions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Submission> findAll(int start, int end,
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

		List<Submission> list = (List<Submission>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBMISSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBMISSION;

				if (pagination) {
					sql = sql.concat(SubmissionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Submission>(list);
				}
				else {
					list = (List<Submission>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the submissions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Submission submission : findAll()) {
			remove(submission);
		}
	}

	/**
	 * Returns the number of submissions.
	 *
	 * @return the number of submissions
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

				Query q = session.createQuery(_SQL_COUNT_SUBMISSION);

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
	 * Initializes the submission persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Submission")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Submission>> listenersList = new ArrayList<ModelListener<Submission>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Submission>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubmissionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUBMISSION = "SELECT submission FROM Submission submission";
	private static final String _SQL_SELECT_SUBMISSION_WHERE = "SELECT submission FROM Submission submission WHERE ";
	private static final String _SQL_COUNT_SUBMISSION = "SELECT COUNT(submission) FROM Submission submission";
	private static final String _SQL_COUNT_SUBMISSION_WHERE = "SELECT COUNT(submission) FROM Submission submission WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "submission.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Submission exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Submission exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SubmissionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"archivePID", "archivePIDType", "lastChanged", "isPublic",
				"publicAfter"
			});
	private static Submission _nullSubmission = new SubmissionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Submission> toCacheModel() {
				return _nullSubmissionCacheModel;
			}
		};

	private static CacheModel<Submission> _nullSubmissionCacheModel = new CacheModel<Submission>() {
			@Override
			public Submission toEntityModel() {
				return _nullSubmission;
			}
		};
}