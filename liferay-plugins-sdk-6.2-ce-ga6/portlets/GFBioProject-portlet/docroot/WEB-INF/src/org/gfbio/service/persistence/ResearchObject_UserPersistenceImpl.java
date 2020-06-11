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

import org.gfbio.NoSuchResearchObject_UserException;

import org.gfbio.model.ResearchObject_User;
import org.gfbio.model.impl.ResearchObject_UserImpl;
import org.gfbio.model.impl.ResearchObject_UserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the research object_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObject_UserPersistence
 * @see ResearchObject_UserUtil
 * @generated
 */
public class ResearchObject_UserPersistenceImpl extends BasePersistenceImpl<ResearchObject_User>
	implements ResearchObject_UserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResearchObject_UserUtil} to access the research object_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResearchObject_UserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByresearchObjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByresearchObjectID", new String[] { Long.class.getName() },
			ResearchObject_UserModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByresearchObjectID", new String[] { Long.class.getName() });

	/**
	 * Returns all the research object_ users where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectID(
		long researchObjectID) throws SystemException {
		return findByresearchObjectID(researchObjectID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research object_ users where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @return the range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectID(
		long researchObjectID, int start, int end) throws SystemException {
		return findByresearchObjectID(researchObjectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the research object_ users where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectID(
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

		List<ResearchObject_User> list = (List<ResearchObject_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchObject_User researchObject_User : list) {
				if ((researchObjectID != researchObject_User.getResearchObjectID())) {
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

			query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (!pagination) {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject_User>(list);
				}
				else {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
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
	 * Returns the first research object_ user in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByresearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByresearchObjectID_First(researchObjectID,
				orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the first research object_ user in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByresearchObjectID_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		List<ResearchObject_User> list = findByresearchObjectID(researchObjectID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research object_ user in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByresearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByresearchObjectID_Last(researchObjectID,
				orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the last research object_ user in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByresearchObjectID_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByresearchObjectID(researchObjectID);

		if (count == 0) {
			return null;
		}

		List<ResearchObject_User> list = findByresearchObjectID(researchObjectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the research object_ users before and after the current research object_ user in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObject_UserPK the primary key of the current research object_ user
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User[] findByresearchObjectID_PrevAndNext(
		ResearchObject_UserPK researchObject_UserPK, long researchObjectID,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = findByPrimaryKey(researchObject_UserPK);

		Session session = null;

		try {
			session = openSession();

			ResearchObject_User[] array = new ResearchObject_UserImpl[3];

			array[0] = getByresearchObjectID_PrevAndNext(session,
					researchObject_User, researchObjectID, orderByComparator,
					true);

			array[1] = researchObject_User;

			array[2] = getByresearchObjectID_PrevAndNext(session,
					researchObject_User, researchObjectID, orderByComparator,
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

	protected ResearchObject_User getByresearchObjectID_PrevAndNext(
		Session session, ResearchObject_User researchObject_User,
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

		query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

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
			query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchObject_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchObject_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research object_ users where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByresearchObjectID(long researchObjectID)
		throws SystemException {
		for (ResearchObject_User researchObject_User : findByresearchObjectID(
				researchObjectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(researchObject_User);
		}
	}

	/**
	 * Returns the number of research object_ users where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByresearchObjectID(long researchObjectID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTID;

		Object[] finderArgs = new Object[] { researchObjectID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESEARCHOBJECT_USER_WHERE);

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
		"researchObject_User.id.researchObjectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByresearchObjectIdAndVersion",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByresearchObjectIdAndVersion",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ResearchObject_UserModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			ResearchObject_UserModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByresearchObjectIdAndVersion",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectIdAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws SystemException {
		return findByresearchObjectIdAndVersion(researchObjectID,
			researchObjectVersion, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @return the range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectIdAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws SystemException {
		return findByresearchObjectIdAndVersion(researchObjectID,
			researchObjectVersion, start, end, null);
	}

	/**
	 * Returns an ordered range of all the research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByresearchObjectIdAndVersion(
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

		List<ResearchObject_User> list = (List<ResearchObject_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchObject_User researchObject_User : list) {
				if ((researchObjectID != researchObject_User.getResearchObjectID()) ||
						(researchObjectVersion != researchObject_User.getResearchObjectVersion())) {
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

			query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
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
					list = (List<ResearchObject_User>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject_User>(list);
				}
				else {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
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
	 * Returns the first research object_ user in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByresearchObjectIdAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByresearchObjectIdAndVersion_First(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the first research object_ user in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByresearchObjectIdAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResearchObject_User> list = findByresearchObjectIdAndVersion(researchObjectID,
				researchObjectVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research object_ user in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByresearchObjectIdAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByresearchObjectIdAndVersion_Last(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the last research object_ user in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByresearchObjectIdAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByresearchObjectIdAndVersion(researchObjectID,
				researchObjectVersion);

		if (count == 0) {
			return null;
		}

		List<ResearchObject_User> list = findByresearchObjectIdAndVersion(researchObjectID,
				researchObjectVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the research object_ users before and after the current research object_ user in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObject_UserPK the primary key of the current research object_ user
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User[] findByresearchObjectIdAndVersion_PrevAndNext(
		ResearchObject_UserPK researchObject_UserPK, long researchObjectID,
		int researchObjectVersion, OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = findByPrimaryKey(researchObject_UserPK);

		Session session = null;

		try {
			session = openSession();

			ResearchObject_User[] array = new ResearchObject_UserImpl[3];

			array[0] = getByresearchObjectIdAndVersion_PrevAndNext(session,
					researchObject_User, researchObjectID,
					researchObjectVersion, orderByComparator, true);

			array[1] = researchObject_User;

			array[2] = getByresearchObjectIdAndVersion_PrevAndNext(session,
					researchObject_User, researchObjectID,
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

	protected ResearchObject_User getByresearchObjectIdAndVersion_PrevAndNext(
		Session session, ResearchObject_User researchObject_User,
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

		query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

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
			query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		qPos.add(researchObjectVersion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchObject_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchObject_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByresearchObjectIdAndVersion(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		for (ResearchObject_User researchObject_User : findByresearchObjectIdAndVersion(
				researchObjectID, researchObjectVersion, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(researchObject_User);
		}
	}

	/**
	 * Returns the number of research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the number of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByresearchObjectIdAndVersion(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION;

		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RESEARCHOBJECT_USER_WHERE);

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
		"researchObject_User.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTIDANDVERSION_RESEARCHOBJECTVERSION_2 =
		"researchObject_User.id.researchObjectVersion = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			ResearchObject_UserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the research object_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research object_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @return the range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByUserID(long userID, int start,
		int end) throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the research object_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findByUserID(long userID, int start,
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

		List<ResearchObject_User> list = (List<ResearchObject_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchObject_User researchObject_User : list) {
				if ((userID != researchObject_User.getUserID())) {
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

			query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject_User>(list);
				}
				else {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
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
	 * Returns the first research object_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByUserID_First(userID,
				orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the first research object_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResearchObject_User> list = findByUserID(userID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research object_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByUserID_Last(userID,
				orderByComparator);

		if (researchObject_User != null) {
			return researchObject_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObject_UserException(msg.toString());
	}

	/**
	 * Returns the last research object_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<ResearchObject_User> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the research object_ users before and after the current research object_ user in the ordered set where userID = &#63;.
	 *
	 * @param researchObject_UserPK the primary key of the current research object_ user
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User[] findByUserID_PrevAndNext(
		ResearchObject_UserPK researchObject_UserPK, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = findByPrimaryKey(researchObject_UserPK);

		Session session = null;

		try {
			session = openSession();

			ResearchObject_User[] array = new ResearchObject_UserImpl[3];

			array[0] = getByUserID_PrevAndNext(session, researchObject_User,
					userID, orderByComparator, true);

			array[1] = researchObject_User;

			array[2] = getByUserID_PrevAndNext(session, researchObject_User,
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

	protected ResearchObject_User getByUserID_PrevAndNext(Session session,
		ResearchObject_User researchObject_User, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

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
			query.append(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchObject_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchObject_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research object_ users where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (ResearchObject_User researchObject_User : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(researchObject_User);
		}
	}

	/**
	 * Returns the number of research object_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching research object_ users
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

			query.append(_SQL_COUNT_RESEARCHOBJECT_USER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "researchObject_User.id.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED,
			ResearchObject_UserImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByfindByPrimaryKey",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			ResearchObject_UserModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			ResearchObject_UserModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK |
			ResearchObject_UserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY = new FinderPath(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByPrimaryKey",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the research object_ user where researchObjectID = &#63; and researchObjectVersion = &#63; and userID = &#63; or throws a {@link org.gfbio.NoSuchResearchObject_UserException} if it could not be found.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param userID the user i d
	 * @return the matching research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByfindByPrimaryKey(long researchObjectID,
		int researchObjectVersion, long userID)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByfindByPrimaryKey(researchObjectID,
				researchObjectVersion, userID);

		if (researchObject_User == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("researchObjectID=");
			msg.append(researchObjectID);

			msg.append(", researchObjectVersion=");
			msg.append(researchObjectVersion);

			msg.append(", userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchResearchObject_UserException(msg.toString());
		}

		return researchObject_User;
	}

	/**
	 * Returns the research object_ user where researchObjectID = &#63; and researchObjectVersion = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param userID the user i d
	 * @return the matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByfindByPrimaryKey(long researchObjectID,
		int researchObjectVersion, long userID) throws SystemException {
		return fetchByfindByPrimaryKey(researchObjectID, researchObjectVersion,
			userID, true);
	}

	/**
	 * Returns the research object_ user where researchObjectID = &#63; and researchObjectVersion = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByfindByPrimaryKey(long researchObjectID,
		int researchObjectVersion, long userID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion, userID
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					finderArgs, this);
		}

		if (result instanceof ResearchObject_User) {
			ResearchObject_User researchObject_User = (ResearchObject_User)result;

			if ((researchObjectID != researchObject_User.getResearchObjectID()) ||
					(researchObjectVersion != researchObject_User.getResearchObjectVersion()) ||
					(userID != researchObject_User.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_RESEARCHOBJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTVERSION_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				qPos.add(researchObjectVersion);

				qPos.add(userID);

				List<ResearchObject_User> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ResearchObject_UserPersistenceImpl.fetchByfindByPrimaryKey(long, int, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ResearchObject_User researchObject_User = list.get(0);

					result = researchObject_User;

					cacheResult(researchObject_User);

					if ((researchObject_User.getResearchObjectID() != researchObjectID) ||
							(researchObject_User.getResearchObjectVersion() != researchObjectVersion) ||
							(researchObject_User.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
							finderArgs, researchObject_User);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
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
			return (ResearchObject_User)result;
		}
	}

	/**
	 * Removes the research object_ user where researchObjectID = &#63; and researchObjectVersion = &#63; and userID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param userID the user i d
	 * @return the research object_ user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User removeByfindByPrimaryKey(long researchObjectID,
		int researchObjectVersion, long userID)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = findByfindByPrimaryKey(researchObjectID,
				researchObjectVersion, userID);

		return remove(researchObject_User);
	}

	/**
	 * Returns the number of research object_ users where researchObjectID = &#63; and researchObjectVersion = &#63; and userID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param userID the user i d
	 * @return the number of matching research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByPrimaryKey(long researchObjectID,
		int researchObjectVersion, long userID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY;

		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion, userID
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RESEARCHOBJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTVERSION_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				qPos.add(researchObjectVersion);

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

	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTID_2 =
		"researchObject_User.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_RESEARCHOBJECTVERSION_2 =
		"researchObject_User.id.researchObjectVersion = ? AND ";
	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2 = "researchObject_User.id.userID = ?";

	public ResearchObject_UserPersistenceImpl() {
		setModelClass(ResearchObject_User.class);
	}

	/**
	 * Caches the research object_ user in the entity cache if it is enabled.
	 *
	 * @param researchObject_User the research object_ user
	 */
	@Override
	public void cacheResult(ResearchObject_User researchObject_User) {
		EntityCacheUtil.putResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserImpl.class, researchObject_User.getPrimaryKey(),
			researchObject_User);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
			new Object[] {
				researchObject_User.getResearchObjectID(),
				researchObject_User.getResearchObjectVersion(),
				researchObject_User.getUserID()
			}, researchObject_User);

		researchObject_User.resetOriginalValues();
	}

	/**
	 * Caches the research object_ users in the entity cache if it is enabled.
	 *
	 * @param researchObject_Users the research object_ users
	 */
	@Override
	public void cacheResult(List<ResearchObject_User> researchObject_Users) {
		for (ResearchObject_User researchObject_User : researchObject_Users) {
			if (EntityCacheUtil.getResult(
						ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
						ResearchObject_UserImpl.class,
						researchObject_User.getPrimaryKey()) == null) {
				cacheResult(researchObject_User);
			}
			else {
				researchObject_User.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all research object_ users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResearchObject_UserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResearchObject_UserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the research object_ user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResearchObject_User researchObject_User) {
		EntityCacheUtil.removeResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserImpl.class, researchObject_User.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(researchObject_User);
	}

	@Override
	public void clearCache(List<ResearchObject_User> researchObject_Users) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResearchObject_User researchObject_User : researchObject_Users) {
			EntityCacheUtil.removeResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
				ResearchObject_UserImpl.class,
				researchObject_User.getPrimaryKey());

			clearUniqueFindersCache(researchObject_User);
		}
	}

	protected void cacheUniqueFindersCache(
		ResearchObject_User researchObject_User) {
		if (researchObject_User.isNew()) {
			Object[] args = new Object[] {
					researchObject_User.getResearchObjectID(),
					researchObject_User.getResearchObjectVersion(),
					researchObject_User.getUserID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args, researchObject_User);
		}
		else {
			ResearchObject_UserModelImpl researchObject_UserModelImpl = (ResearchObject_UserModelImpl)researchObject_User;

			if ((researchObject_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObject_User.getResearchObjectID(),
						researchObject_User.getResearchObjectVersion(),
						researchObject_User.getUserID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					args, researchObject_User);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ResearchObject_User researchObject_User) {
		ResearchObject_UserModelImpl researchObject_UserModelImpl = (ResearchObject_UserModelImpl)researchObject_User;

		Object[] args = new Object[] {
				researchObject_User.getResearchObjectID(),
				researchObject_User.getResearchObjectVersion(),
				researchObject_User.getUserID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY, args);

		if ((researchObject_UserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					researchObject_UserModelImpl.getOriginalResearchObjectID(),
					researchObject_UserModelImpl.getOriginalResearchObjectVersion(),
					researchObject_UserModelImpl.getOriginalUserID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args);
		}
	}

	/**
	 * Creates a new research object_ user with the primary key. Does not add the research object_ user to the database.
	 *
	 * @param researchObject_UserPK the primary key for the new research object_ user
	 * @return the new research object_ user
	 */
	@Override
	public ResearchObject_User create(
		ResearchObject_UserPK researchObject_UserPK) {
		ResearchObject_User researchObject_User = new ResearchObject_UserImpl();

		researchObject_User.setNew(true);
		researchObject_User.setPrimaryKey(researchObject_UserPK);

		return researchObject_User;
	}

	/**
	 * Removes the research object_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param researchObject_UserPK the primary key of the research object_ user
	 * @return the research object_ user that was removed
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User remove(
		ResearchObject_UserPK researchObject_UserPK)
		throws NoSuchResearchObject_UserException, SystemException {
		return remove((Serializable)researchObject_UserPK);
	}

	/**
	 * Removes the research object_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the research object_ user
	 * @return the research object_ user that was removed
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User remove(Serializable primaryKey)
		throws NoSuchResearchObject_UserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResearchObject_User researchObject_User = (ResearchObject_User)session.get(ResearchObject_UserImpl.class,
					primaryKey);

			if (researchObject_User == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResearchObject_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(researchObject_User);
		}
		catch (NoSuchResearchObject_UserException nsee) {
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
	protected ResearchObject_User removeImpl(
		ResearchObject_User researchObject_User) throws SystemException {
		researchObject_User = toUnwrappedModel(researchObject_User);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(researchObject_User)) {
				researchObject_User = (ResearchObject_User)session.get(ResearchObject_UserImpl.class,
						researchObject_User.getPrimaryKeyObj());
			}

			if (researchObject_User != null) {
				session.delete(researchObject_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (researchObject_User != null) {
			clearCache(researchObject_User);
		}

		return researchObject_User;
	}

	@Override
	public ResearchObject_User updateImpl(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws SystemException {
		researchObject_User = toUnwrappedModel(researchObject_User);

		boolean isNew = researchObject_User.isNew();

		ResearchObject_UserModelImpl researchObject_UserModelImpl = (ResearchObject_UserModelImpl)researchObject_User;

		Session session = null;

		try {
			session = openSession();

			if (researchObject_User.isNew()) {
				session.save(researchObject_User);

				researchObject_User.setNew(false);
			}
			else {
				session.merge(researchObject_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResearchObject_UserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((researchObject_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObject_UserModelImpl.getOriginalResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);

				args = new Object[] {
						researchObject_UserModelImpl.getResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);
			}

			if ((researchObject_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObject_UserModelImpl.getOriginalResearchObjectID(),
						researchObject_UserModelImpl.getOriginalResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION,
					args);

				args = new Object[] {
						researchObject_UserModelImpl.getResearchObjectID(),
						researchObject_UserModelImpl.getResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTIDANDVERSION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTIDANDVERSION,
					args);
			}

			if ((researchObject_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObject_UserModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { researchObject_UserModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObject_UserImpl.class, researchObject_User.getPrimaryKey(),
			researchObject_User);

		clearUniqueFindersCache(researchObject_User);
		cacheUniqueFindersCache(researchObject_User);

		return researchObject_User;
	}

	protected ResearchObject_User toUnwrappedModel(
		ResearchObject_User researchObject_User) {
		if (researchObject_User instanceof ResearchObject_UserImpl) {
			return researchObject_User;
		}

		ResearchObject_UserImpl researchObject_UserImpl = new ResearchObject_UserImpl();

		researchObject_UserImpl.setNew(researchObject_User.isNew());
		researchObject_UserImpl.setPrimaryKey(researchObject_User.getPrimaryKey());

		researchObject_UserImpl.setResearchObjectID(researchObject_User.getResearchObjectID());
		researchObject_UserImpl.setResearchObjectVersion(researchObject_User.getResearchObjectVersion());
		researchObject_UserImpl.setUserID(researchObject_User.getUserID());
		researchObject_UserImpl.setStartDate(researchObject_User.getStartDate());
		researchObject_UserImpl.setEndDate(researchObject_User.getEndDate());
		researchObject_UserImpl.setUserType(researchObject_User.getUserType());
		researchObject_UserImpl.setLastModifiedDate(researchObject_User.getLastModifiedDate());

		return researchObject_UserImpl;
	}

	/**
	 * Returns the research object_ user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the research object_ user
	 * @return the research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResearchObject_UserException, SystemException {
		ResearchObject_User researchObject_User = fetchByPrimaryKey(primaryKey);

		if (researchObject_User == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResearchObject_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return researchObject_User;
	}

	/**
	 * Returns the research object_ user with the primary key or throws a {@link org.gfbio.NoSuchResearchObject_UserException} if it could not be found.
	 *
	 * @param researchObject_UserPK the primary key of the research object_ user
	 * @return the research object_ user
	 * @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User findByPrimaryKey(
		ResearchObject_UserPK researchObject_UserPK)
		throws NoSuchResearchObject_UserException, SystemException {
		return findByPrimaryKey((Serializable)researchObject_UserPK);
	}

	/**
	 * Returns the research object_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the research object_ user
	 * @return the research object_ user, or <code>null</code> if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ResearchObject_User researchObject_User = (ResearchObject_User)EntityCacheUtil.getResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
				ResearchObject_UserImpl.class, primaryKey);

		if (researchObject_User == _nullResearchObject_User) {
			return null;
		}

		if (researchObject_User == null) {
			Session session = null;

			try {
				session = openSession();

				researchObject_User = (ResearchObject_User)session.get(ResearchObject_UserImpl.class,
						primaryKey);

				if (researchObject_User != null) {
					cacheResult(researchObject_User);
				}
				else {
					EntityCacheUtil.putResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
						ResearchObject_UserImpl.class, primaryKey,
						_nullResearchObject_User);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ResearchObject_UserModelImpl.ENTITY_CACHE_ENABLED,
					ResearchObject_UserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return researchObject_User;
	}

	/**
	 * Returns the research object_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param researchObject_UserPK the primary key of the research object_ user
	 * @return the research object_ user, or <code>null</code> if a research object_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject_User fetchByPrimaryKey(
		ResearchObject_UserPK researchObject_UserPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)researchObject_UserPK);
	}

	/**
	 * Returns all the research object_ users.
	 *
	 * @return the research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research object_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @return the range of research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the research object_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of research object_ users
	 * @param end the upper bound of the range of research object_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of research object_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject_User> findAll(int start, int end,
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

		List<ResearchObject_User> list = (List<ResearchObject_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESEARCHOBJECT_USER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESEARCHOBJECT_USER;

				if (pagination) {
					sql = sql.concat(ResearchObject_UserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject_User>(list);
				}
				else {
					list = (List<ResearchObject_User>)QueryUtil.list(q,
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
	 * Removes all the research object_ users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ResearchObject_User researchObject_User : findAll()) {
			remove(researchObject_User);
		}
	}

	/**
	 * Returns the number of research object_ users.
	 *
	 * @return the number of research object_ users
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

				Query q = session.createQuery(_SQL_COUNT_RESEARCHOBJECT_USER);

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
	 * Initializes the research object_ user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.ResearchObject_User")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResearchObject_User>> listenersList = new ArrayList<ModelListener<ResearchObject_User>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResearchObject_User>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResearchObject_UserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RESEARCHOBJECT_USER = "SELECT researchObject_User FROM ResearchObject_User researchObject_User";
	private static final String _SQL_SELECT_RESEARCHOBJECT_USER_WHERE = "SELECT researchObject_User FROM ResearchObject_User researchObject_User WHERE ";
	private static final String _SQL_COUNT_RESEARCHOBJECT_USER = "SELECT COUNT(researchObject_User) FROM ResearchObject_User researchObject_User";
	private static final String _SQL_COUNT_RESEARCHOBJECT_USER_WHERE = "SELECT COUNT(researchObject_User) FROM ResearchObject_User researchObject_User WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "researchObject_User.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResearchObject_User exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResearchObject_User exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResearchObject_UserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static ResearchObject_User _nullResearchObject_User = new ResearchObject_UserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResearchObject_User> toCacheModel() {
				return _nullResearchObject_UserCacheModel;
			}
		};

	private static CacheModel<ResearchObject_User> _nullResearchObject_UserCacheModel =
		new CacheModel<ResearchObject_User>() {
			@Override
			public ResearchObject_User toEntityModel() {
				return _nullResearchObject_User;
			}
		};
}