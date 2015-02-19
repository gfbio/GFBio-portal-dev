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

import org.gfbio.NoSuchProject_User_PIException;

import org.gfbio.model.Project_User_PI;
import org.gfbio.model.impl.Project_User_PIImpl;
import org.gfbio.model.impl.Project_User_PIModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the project_ user_ p i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see Project_User_PIPersistence
 * @see Project_User_PIUtil
 * @generated
 */
public class Project_User_PIPersistenceImpl extends BasePersistenceImpl<Project_User_PI>
	implements Project_User_PIPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Project_User_PIUtil} to access the project_ user_ p i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Project_User_PIImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectID",
			new String[] { Long.class.getName() },
			Project_User_PIModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ user_ p is where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByProjectID(long projectID)
		throws SystemException {
		return findByProjectID(projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project_ user_ p is where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @return the range of matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByProjectID(long projectID, int start,
		int end) throws SystemException {
		return findByProjectID(projectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ user_ p is where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByProjectID(long projectID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<Project_User_PI> list = (List<Project_User_PI>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_User_PI project_User_PI : list) {
				if ((projectID != project_User_PI.getProjectID())) {
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

			query.append(_SQL_SELECT_PROJECT_USER_PI_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_User_PIModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				if (!pagination) {
					list = (List<Project_User_PI>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User_PI>(list);
				}
				else {
					list = (List<Project_User_PI>)QueryUtil.list(q,
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
	 * Returns the first project_ user_ p i in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByProjectID_First(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = fetchByProjectID_First(projectID,
				orderByComparator);

		if (project_User_PI != null) {
			return project_User_PI;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_User_PIException(msg.toString());
	}

	/**
	 * Returns the first project_ user_ p i in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByProjectID_First(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_User_PI> list = findByProjectID(projectID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ user_ p i in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByProjectID_Last(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = fetchByProjectID_Last(projectID,
				orderByComparator);

		if (project_User_PI != null) {
			return project_User_PI;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_User_PIException(msg.toString());
	}

	/**
	 * Returns the last project_ user_ p i in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByProjectID_Last(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectID(projectID);

		if (count == 0) {
			return null;
		}

		List<Project_User_PI> list = findByProjectID(projectID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ user_ p is before and after the current project_ user_ p i in the ordered set where projectID = &#63;.
	 *
	 * @param project_User_PIPK the primary key of the current project_ user_ p i
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI[] findByProjectID_PrevAndNext(
		Project_User_PIPK project_User_PIPK, long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = findByPrimaryKey(project_User_PIPK);

		Session session = null;

		try {
			session = openSession();

			Project_User_PI[] array = new Project_User_PIImpl[3];

			array[0] = getByProjectID_PrevAndNext(session, project_User_PI,
					projectID, orderByComparator, true);

			array[1] = project_User_PI;

			array[2] = getByProjectID_PrevAndNext(session, project_User_PI,
					projectID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Project_User_PI getByProjectID_PrevAndNext(Session session,
		Project_User_PI project_User_PI, long projectID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_USER_PI_WHERE);

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
			query.append(Project_User_PIModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_User_PI);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_User_PI> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ user_ p is where projectID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectID(long projectID) throws SystemException {
		for (Project_User_PI project_User_PI : findByProjectID(projectID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_User_PI);
		}
	}

	/**
	 * Returns the number of project_ user_ p is where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the number of matching project_ user_ p is
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

			query.append(_SQL_COUNT_PROJECT_USER_PI_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "project_User_PI.id.projectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED,
			Project_User_PIImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			Project_User_PIModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ user_ p is where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ user_ p is where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @return the range of matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ user_ p is where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findByUserID(long userID, int start, int end,
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

		List<Project_User_PI> list = (List<Project_User_PI>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_User_PI project_User_PI : list) {
				if ((userID != project_User_PI.getUserID())) {
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

			query.append(_SQL_SELECT_PROJECT_USER_PI_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_User_PIModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Project_User_PI>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User_PI>(list);
				}
				else {
					list = (List<Project_User_PI>)QueryUtil.list(q,
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
	 * Returns the first project_ user_ p i in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = fetchByUserID_First(userID,
				orderByComparator);

		if (project_User_PI != null) {
			return project_User_PI;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_User_PIException(msg.toString());
	}

	/**
	 * Returns the first project_ user_ p i in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_User_PI> list = findByUserID(userID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ user_ p i in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = fetchByUserID_Last(userID,
				orderByComparator);

		if (project_User_PI != null) {
			return project_User_PI;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_User_PIException(msg.toString());
	}

	/**
	 * Returns the last project_ user_ p i in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Project_User_PI> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ user_ p is before and after the current project_ user_ p i in the ordered set where userID = &#63;.
	 *
	 * @param project_User_PIPK the primary key of the current project_ user_ p i
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI[] findByUserID_PrevAndNext(
		Project_User_PIPK project_User_PIPK, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = findByPrimaryKey(project_User_PIPK);

		Session session = null;

		try {
			session = openSession();

			Project_User_PI[] array = new Project_User_PIImpl[3];

			array[0] = getByUserID_PrevAndNext(session, project_User_PI,
					userID, orderByComparator, true);

			array[1] = project_User_PI;

			array[2] = getByUserID_PrevAndNext(session, project_User_PI,
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

	protected Project_User_PI getByUserID_PrevAndNext(Session session,
		Project_User_PI project_User_PI, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_USER_PI_WHERE);

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
			query.append(Project_User_PIModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_User_PI);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_User_PI> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ user_ p is where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Project_User_PI project_User_PI : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_User_PI);
		}
	}

	/**
	 * Returns the number of project_ user_ p is where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching project_ user_ p is
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

			query.append(_SQL_COUNT_PROJECT_USER_PI_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "project_User_PI.id.userID = ?";

	public Project_User_PIPersistenceImpl() {
		setModelClass(Project_User_PI.class);
	}

	/**
	 * Caches the project_ user_ p i in the entity cache if it is enabled.
	 *
	 * @param project_User_PI the project_ user_ p i
	 */
	@Override
	public void cacheResult(Project_User_PI project_User_PI) {
		EntityCacheUtil.putResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIImpl.class, project_User_PI.getPrimaryKey(),
			project_User_PI);

		project_User_PI.resetOriginalValues();
	}

	/**
	 * Caches the project_ user_ p is in the entity cache if it is enabled.
	 *
	 * @param project_User_PIs the project_ user_ p is
	 */
	@Override
	public void cacheResult(List<Project_User_PI> project_User_PIs) {
		for (Project_User_PI project_User_PI : project_User_PIs) {
			if (EntityCacheUtil.getResult(
						Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
						Project_User_PIImpl.class,
						project_User_PI.getPrimaryKey()) == null) {
				cacheResult(project_User_PI);
			}
			else {
				project_User_PI.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project_ user_ p is.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Project_User_PIImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Project_User_PIImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project_ user_ p i.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Project_User_PI project_User_PI) {
		EntityCacheUtil.removeResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIImpl.class, project_User_PI.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Project_User_PI> project_User_PIs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Project_User_PI project_User_PI : project_User_PIs) {
			EntityCacheUtil.removeResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
				Project_User_PIImpl.class, project_User_PI.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project_ user_ p i with the primary key. Does not add the project_ user_ p i to the database.
	 *
	 * @param project_User_PIPK the primary key for the new project_ user_ p i
	 * @return the new project_ user_ p i
	 */
	@Override
	public Project_User_PI create(Project_User_PIPK project_User_PIPK) {
		Project_User_PI project_User_PI = new Project_User_PIImpl();

		project_User_PI.setNew(true);
		project_User_PI.setPrimaryKey(project_User_PIPK);

		return project_User_PI;
	}

	/**
	 * Removes the project_ user_ p i with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project_User_PIPK the primary key of the project_ user_ p i
	 * @return the project_ user_ p i that was removed
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI remove(Project_User_PIPK project_User_PIPK)
		throws NoSuchProject_User_PIException, SystemException {
		return remove((Serializable)project_User_PIPK);
	}

	/**
	 * Removes the project_ user_ p i with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project_ user_ p i
	 * @return the project_ user_ p i that was removed
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI remove(Serializable primaryKey)
		throws NoSuchProject_User_PIException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Project_User_PI project_User_PI = (Project_User_PI)session.get(Project_User_PIImpl.class,
					primaryKey);

			if (project_User_PI == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProject_User_PIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(project_User_PI);
		}
		catch (NoSuchProject_User_PIException nsee) {
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
	protected Project_User_PI removeImpl(Project_User_PI project_User_PI)
		throws SystemException {
		project_User_PI = toUnwrappedModel(project_User_PI);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(project_User_PI)) {
				project_User_PI = (Project_User_PI)session.get(Project_User_PIImpl.class,
						project_User_PI.getPrimaryKeyObj());
			}

			if (project_User_PI != null) {
				session.delete(project_User_PI);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (project_User_PI != null) {
			clearCache(project_User_PI);
		}

		return project_User_PI;
	}

	@Override
	public Project_User_PI updateImpl(
		org.gfbio.model.Project_User_PI project_User_PI)
		throws SystemException {
		project_User_PI = toUnwrappedModel(project_User_PI);

		boolean isNew = project_User_PI.isNew();

		Project_User_PIModelImpl project_User_PIModelImpl = (Project_User_PIModelImpl)project_User_PI;

		Session session = null;

		try {
			session = openSession();

			if (project_User_PI.isNew()) {
				session.save(project_User_PI);

				project_User_PI.setNew(false);
			}
			else {
				session.merge(project_User_PI);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Project_User_PIModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((project_User_PIModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_User_PIModelImpl.getOriginalProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] { project_User_PIModelImpl.getProjectID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((project_User_PIModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_User_PIModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { project_User_PIModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
			Project_User_PIImpl.class, project_User_PI.getPrimaryKey(),
			project_User_PI);

		return project_User_PI;
	}

	protected Project_User_PI toUnwrappedModel(Project_User_PI project_User_PI) {
		if (project_User_PI instanceof Project_User_PIImpl) {
			return project_User_PI;
		}

		Project_User_PIImpl project_User_PIImpl = new Project_User_PIImpl();

		project_User_PIImpl.setNew(project_User_PI.isNew());
		project_User_PIImpl.setPrimaryKey(project_User_PI.getPrimaryKey());

		project_User_PIImpl.setProjectID(project_User_PI.getProjectID());
		project_User_PIImpl.setUserID(project_User_PI.getUserID());
		project_User_PIImpl.setStartDate(project_User_PI.getStartDate());
		project_User_PIImpl.setEndDate(project_User_PI.getEndDate());

		return project_User_PIImpl;
	}

	/**
	 * Returns the project_ user_ p i with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ user_ p i
	 * @return the project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProject_User_PIException, SystemException {
		Project_User_PI project_User_PI = fetchByPrimaryKey(primaryKey);

		if (project_User_PI == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProject_User_PIException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return project_User_PI;
	}

	/**
	 * Returns the project_ user_ p i with the primary key or throws a {@link org.gfbio.NoSuchProject_User_PIException} if it could not be found.
	 *
	 * @param project_User_PIPK the primary key of the project_ user_ p i
	 * @return the project_ user_ p i
	 * @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI findByPrimaryKey(Project_User_PIPK project_User_PIPK)
		throws NoSuchProject_User_PIException, SystemException {
		return findByPrimaryKey((Serializable)project_User_PIPK);
	}

	/**
	 * Returns the project_ user_ p i with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ user_ p i
	 * @return the project_ user_ p i, or <code>null</code> if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Project_User_PI project_User_PI = (Project_User_PI)EntityCacheUtil.getResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
				Project_User_PIImpl.class, primaryKey);

		if (project_User_PI == _nullProject_User_PI) {
			return null;
		}

		if (project_User_PI == null) {
			Session session = null;

			try {
				session = openSession();

				project_User_PI = (Project_User_PI)session.get(Project_User_PIImpl.class,
						primaryKey);

				if (project_User_PI != null) {
					cacheResult(project_User_PI);
				}
				else {
					EntityCacheUtil.putResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
						Project_User_PIImpl.class, primaryKey,
						_nullProject_User_PI);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Project_User_PIModelImpl.ENTITY_CACHE_ENABLED,
					Project_User_PIImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return project_User_PI;
	}

	/**
	 * Returns the project_ user_ p i with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param project_User_PIPK the primary key of the project_ user_ p i
	 * @return the project_ user_ p i, or <code>null</code> if a project_ user_ p i with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User_PI fetchByPrimaryKey(
		Project_User_PIPK project_User_PIPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)project_User_PIPK);
	}

	/**
	 * Returns all the project_ user_ p is.
	 *
	 * @return the project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ user_ p is.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @return the range of project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ user_ p is.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ user_ p is
	 * @param end the upper bound of the range of project_ user_ p is (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project_ user_ p is
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User_PI> findAll(int start, int end,
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

		List<Project_User_PI> list = (List<Project_User_PI>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECT_USER_PI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECT_USER_PI;

				if (pagination) {
					sql = sql.concat(Project_User_PIModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Project_User_PI>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User_PI>(list);
				}
				else {
					list = (List<Project_User_PI>)QueryUtil.list(q,
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
	 * Removes all the project_ user_ p is from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Project_User_PI project_User_PI : findAll()) {
			remove(project_User_PI);
		}
	}

	/**
	 * Returns the number of project_ user_ p is.
	 *
	 * @return the number of project_ user_ p is
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

				Query q = session.createQuery(_SQL_COUNT_PROJECT_USER_PI);

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
	 * Initializes the project_ user_ p i persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Project_User_PI")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Project_User_PI>> listenersList = new ArrayList<ModelListener<Project_User_PI>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Project_User_PI>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Project_User_PIImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECT_USER_PI = "SELECT project_User_PI FROM Project_User_PI project_User_PI";
	private static final String _SQL_SELECT_PROJECT_USER_PI_WHERE = "SELECT project_User_PI FROM Project_User_PI project_User_PI WHERE ";
	private static final String _SQL_COUNT_PROJECT_USER_PI = "SELECT COUNT(project_User_PI) FROM Project_User_PI project_User_PI";
	private static final String _SQL_COUNT_PROJECT_USER_PI_WHERE = "SELECT COUNT(project_User_PI) FROM Project_User_PI project_User_PI WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "project_User_PI.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project_User_PI exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project_User_PI exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Project_User_PIPersistenceImpl.class);
	private static Project_User_PI _nullProject_User_PI = new Project_User_PIImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Project_User_PI> toCacheModel() {
				return _nullProject_User_PICacheModel;
			}
		};

	private static CacheModel<Project_User_PI> _nullProject_User_PICacheModel = new CacheModel<Project_User_PI>() {
			@Override
			public Project_User_PI toEntityModel() {
				return _nullProject_User_PI;
			}
		};
}