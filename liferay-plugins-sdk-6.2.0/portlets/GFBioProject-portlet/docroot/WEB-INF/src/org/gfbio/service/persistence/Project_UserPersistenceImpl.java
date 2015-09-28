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

import org.gfbio.NoSuchProject_UserException;

import org.gfbio.model.Project_User;
import org.gfbio.model.impl.Project_UserImpl;
import org.gfbio.model.impl.Project_UserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the project_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_UserPersistence
 * @see Project_UserUtil
 * @generated
 */
public class Project_UserPersistenceImpl extends BasePersistenceImpl<Project_User>
	implements Project_UserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Project_UserUtil} to access the project_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Project_UserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectID",
			new String[] { Long.class.getName() },
			Project_UserModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ users where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByProjectID(long projectID)
		throws SystemException {
		return findByProjectID(projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project_ users where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @return the range of matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByProjectID(long projectID, int start, int end)
		throws SystemException {
		return findByProjectID(projectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ users where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByProjectID(long projectID, int start,
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

		List<Project_User> list = (List<Project_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_User project_User : list) {
				if ((projectID != project_User.getProjectID())) {
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

			query.append(_SQL_SELECT_PROJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_UserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				if (!pagination) {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User>(list);
				}
				else {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project_ user in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByProjectID_First(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByProjectID_First(projectID,
				orderByComparator);

		if (project_User != null) {
			return project_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_UserException(msg.toString());
	}

	/**
	 * Returns the first project_ user in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByProjectID_First(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_User> list = findByProjectID(projectID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ user in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByProjectID_Last(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByProjectID_Last(projectID,
				orderByComparator);

		if (project_User != null) {
			return project_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_UserException(msg.toString());
	}

	/**
	 * Returns the last project_ user in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByProjectID_Last(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectID(projectID);

		if (count == 0) {
			return null;
		}

		List<Project_User> list = findByProjectID(projectID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ users before and after the current project_ user in the ordered set where projectID = &#63;.
	 *
	 * @param project_UserPK the primary key of the current project_ user
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User[] findByProjectID_PrevAndNext(
		Project_UserPK project_UserPK, long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = findByPrimaryKey(project_UserPK);

		Session session = null;

		try {
			session = openSession();

			Project_User[] array = new Project_UserImpl[3];

			array[0] = getByProjectID_PrevAndNext(session, project_User,
					projectID, orderByComparator, true);

			array[1] = project_User;

			array[2] = getByProjectID_PrevAndNext(session, project_User,
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

	protected Project_User getByProjectID_PrevAndNext(Session session,
		Project_User project_User, long projectID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_USER_WHERE);

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
			query.append(Project_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ users where projectID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectID(long projectID) throws SystemException {
		for (Project_User project_User : findByProjectID(projectID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_User);
		}
	}

	/**
	 * Returns the number of project_ users where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the number of matching project_ users
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

			query.append(_SQL_COUNT_PROJECT_USER_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "project_User.id.projectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
			new String[] { Long.class.getName() },
			Project_UserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByUserID(long userID)
		throws SystemException {
		return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @return the range of matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByUserID(long userID, int start, int end)
		throws SystemException {
		return findByUserID(userID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ users where userID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userID the user i d
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findByUserID(long userID, int start, int end,
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

		List<Project_User> list = (List<Project_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_User project_User : list) {
				if ((userID != project_User.getUserID())) {
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

			query.append(_SQL_SELECT_PROJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_UserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				if (!pagination) {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User>(list);
				}
				else {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first project_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByUserID_First(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByUserID_First(userID,
				orderByComparator);

		if (project_User != null) {
			return project_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_UserException(msg.toString());
	}

	/**
	 * Returns the first project_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByUserID_First(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_User> list = findByUserID(userID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByUserID_Last(long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByUserID_Last(userID, orderByComparator);

		if (project_User != null) {
			return project_User;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userID=");
		msg.append(userID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_UserException(msg.toString());
	}

	/**
	 * Returns the last project_ user in the ordered set where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByUserID_Last(long userID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserID(userID);

		if (count == 0) {
			return null;
		}

		List<Project_User> list = findByUserID(userID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ users before and after the current project_ user in the ordered set where userID = &#63;.
	 *
	 * @param project_UserPK the primary key of the current project_ user
	 * @param userID the user i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User[] findByUserID_PrevAndNext(
		Project_UserPK project_UserPK, long userID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = findByPrimaryKey(project_UserPK);

		Session session = null;

		try {
			session = openSession();

			Project_User[] array = new Project_UserImpl[3];

			array[0] = getByUserID_PrevAndNext(session, project_User, userID,
					orderByComparator, true);

			array[1] = project_User;

			array[2] = getByUserID_PrevAndNext(session, project_User, userID,
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

	protected Project_User getByUserID_PrevAndNext(Session session,
		Project_User project_User, long userID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_USER_WHERE);

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
			query.append(Project_UserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_User);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_User> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ users where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserID(long userID) throws SystemException {
		for (Project_User project_User : findByUserID(userID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_User);
		}
	}

	/**
	 * Returns the number of project_ users where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching project_ users
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

			query.append(_SQL_COUNT_PROJECT_USER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "project_User.id.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Project_UserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() },
			Project_UserModelImpl.PROJECTID_COLUMN_BITMASK |
			Project_UserModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY = new FinderPath(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfindByPrimaryKey",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the project_ user where projectID = &#63; and userID = &#63; or throws a {@link org.gfbio.NoSuchProject_UserException} if it could not be found.
	 *
	 * @param projectID the project i d
	 * @param userID the user i d
	 * @return the matching project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByfindByPrimaryKey(long projectID, long userID)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByfindByPrimaryKey(projectID, userID);

		if (project_User == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("projectID=");
			msg.append(projectID);

			msg.append(", userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProject_UserException(msg.toString());
		}

		return project_User;
	}

	/**
	 * Returns the project_ user where projectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param projectID the project i d
	 * @param userID the user i d
	 * @return the matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByfindByPrimaryKey(long projectID, long userID)
		throws SystemException {
		return fetchByfindByPrimaryKey(projectID, userID, true);
	}

	/**
	 * Returns the project_ user where projectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param projectID the project i d
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching project_ user, or <code>null</code> if a matching project_ user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByfindByPrimaryKey(long projectID, long userID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { projectID, userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					finderArgs, this);
		}

		if (result instanceof Project_User) {
			Project_User project_User = (Project_User)result;

			if ((projectID != project_User.getProjectID()) ||
					(userID != project_User.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_PROJECTID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				qPos.add(userID);

				List<Project_User> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Project_UserPersistenceImpl.fetchByfindByPrimaryKey(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Project_User project_User = list.get(0);

					result = project_User;

					cacheResult(project_User);

					if ((project_User.getProjectID() != projectID) ||
							(project_User.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
							finderArgs, project_User);
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
			return (Project_User)result;
		}
	}

	/**
	 * Removes the project_ user where projectID = &#63; and userID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @param userID the user i d
	 * @return the project_ user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User removeByfindByPrimaryKey(long projectID, long userID)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = findByfindByPrimaryKey(projectID, userID);

		return remove(project_User);
	}

	/**
	 * Returns the number of project_ users where projectID = &#63; and userID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param userID the user i d
	 * @return the number of matching project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfindByPrimaryKey(long projectID, long userID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY;

		Object[] finderArgs = new Object[] { projectID, userID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECT_USER_WHERE);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_PROJECTID_2);

			query.append(_FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

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

	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_PROJECTID_2 = "project_User.id.projectID = ? AND ";
	private static final String _FINDER_COLUMN_FINDBYPRIMARYKEY_USERID_2 = "project_User.id.userID = ?";

	public Project_UserPersistenceImpl() {
		setModelClass(Project_User.class);
	}

	/**
	 * Caches the project_ user in the entity cache if it is enabled.
	 *
	 * @param project_User the project_ user
	 */
	@Override
	public void cacheResult(Project_User project_User) {
		EntityCacheUtil.putResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserImpl.class, project_User.getPrimaryKey(), project_User);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
			new Object[] { project_User.getProjectID(), project_User.getUserID() },
			project_User);

		project_User.resetOriginalValues();
	}

	/**
	 * Caches the project_ users in the entity cache if it is enabled.
	 *
	 * @param project_Users the project_ users
	 */
	@Override
	public void cacheResult(List<Project_User> project_Users) {
		for (Project_User project_User : project_Users) {
			if (EntityCacheUtil.getResult(
						Project_UserModelImpl.ENTITY_CACHE_ENABLED,
						Project_UserImpl.class, project_User.getPrimaryKey()) == null) {
				cacheResult(project_User);
			}
			else {
				project_User.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project_ users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Project_UserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Project_UserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project_ user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Project_User project_User) {
		EntityCacheUtil.removeResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserImpl.class, project_User.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(project_User);
	}

	@Override
	public void clearCache(List<Project_User> project_Users) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Project_User project_User : project_Users) {
			EntityCacheUtil.removeResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
				Project_UserImpl.class, project_User.getPrimaryKey());

			clearUniqueFindersCache(project_User);
		}
	}

	protected void cacheUniqueFindersCache(Project_User project_User) {
		if (project_User.isNew()) {
			Object[] args = new Object[] {
					project_User.getProjectID(), project_User.getUserID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args, project_User);
		}
		else {
			Project_UserModelImpl project_UserModelImpl = (Project_UserModelImpl)project_User;

			if ((project_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_User.getProjectID(), project_User.getUserID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
					args, project_User);
			}
		}
	}

	protected void clearUniqueFindersCache(Project_User project_User) {
		Project_UserModelImpl project_UserModelImpl = (Project_UserModelImpl)project_User;

		Object[] args = new Object[] {
				project_User.getProjectID(), project_User.getUserID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY, args);

		if ((project_UserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					project_UserModelImpl.getOriginalProjectID(),
					project_UserModelImpl.getOriginalUserID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FINDBYPRIMARYKEY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FINDBYPRIMARYKEY,
				args);
		}
	}

	/**
	 * Creates a new project_ user with the primary key. Does not add the project_ user to the database.
	 *
	 * @param project_UserPK the primary key for the new project_ user
	 * @return the new project_ user
	 */
	@Override
	public Project_User create(Project_UserPK project_UserPK) {
		Project_User project_User = new Project_UserImpl();

		project_User.setNew(true);
		project_User.setPrimaryKey(project_UserPK);

		return project_User;
	}

	/**
	 * Removes the project_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project_UserPK the primary key of the project_ user
	 * @return the project_ user that was removed
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User remove(Project_UserPK project_UserPK)
		throws NoSuchProject_UserException, SystemException {
		return remove((Serializable)project_UserPK);
	}

	/**
	 * Removes the project_ user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project_ user
	 * @return the project_ user that was removed
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User remove(Serializable primaryKey)
		throws NoSuchProject_UserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Project_User project_User = (Project_User)session.get(Project_UserImpl.class,
					primaryKey);

			if (project_User == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProject_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(project_User);
		}
		catch (NoSuchProject_UserException nsee) {
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
	protected Project_User removeImpl(Project_User project_User)
		throws SystemException {
		project_User = toUnwrappedModel(project_User);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(project_User)) {
				project_User = (Project_User)session.get(Project_UserImpl.class,
						project_User.getPrimaryKeyObj());
			}

			if (project_User != null) {
				session.delete(project_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (project_User != null) {
			clearCache(project_User);
		}

		return project_User;
	}

	@Override
	public Project_User updateImpl(org.gfbio.model.Project_User project_User)
		throws SystemException {
		project_User = toUnwrappedModel(project_User);

		boolean isNew = project_User.isNew();

		Project_UserModelImpl project_UserModelImpl = (Project_UserModelImpl)project_User;

		Session session = null;

		try {
			session = openSession();

			if (project_User.isNew()) {
				session.save(project_User);

				project_User.setNew(false);
			}
			else {
				session.merge(project_User);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Project_UserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((project_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_UserModelImpl.getOriginalProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] { project_UserModelImpl.getProjectID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((project_UserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_UserModelImpl.getOriginalUserID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { project_UserModelImpl.getUserID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
			Project_UserImpl.class, project_User.getPrimaryKey(), project_User);

		clearUniqueFindersCache(project_User);
		cacheUniqueFindersCache(project_User);

		return project_User;
	}

	protected Project_User toUnwrappedModel(Project_User project_User) {
		if (project_User instanceof Project_UserImpl) {
			return project_User;
		}

		Project_UserImpl project_UserImpl = new Project_UserImpl();

		project_UserImpl.setNew(project_User.isNew());
		project_UserImpl.setPrimaryKey(project_User.getPrimaryKey());

		project_UserImpl.setProjectID(project_User.getProjectID());
		project_UserImpl.setUserID(project_User.getUserID());
		project_UserImpl.setStartDate(project_User.getStartDate());
		project_UserImpl.setEndDate(project_User.getEndDate());

		return project_UserImpl;
	}

	/**
	 * Returns the project_ user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ user
	 * @return the project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProject_UserException, SystemException {
		Project_User project_User = fetchByPrimaryKey(primaryKey);

		if (project_User == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProject_UserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return project_User;
	}

	/**
	 * Returns the project_ user with the primary key or throws a {@link org.gfbio.NoSuchProject_UserException} if it could not be found.
	 *
	 * @param project_UserPK the primary key of the project_ user
	 * @return the project_ user
	 * @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User findByPrimaryKey(Project_UserPK project_UserPK)
		throws NoSuchProject_UserException, SystemException {
		return findByPrimaryKey((Serializable)project_UserPK);
	}

	/**
	 * Returns the project_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ user
	 * @return the project_ user, or <code>null</code> if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Project_User project_User = (Project_User)EntityCacheUtil.getResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
				Project_UserImpl.class, primaryKey);

		if (project_User == _nullProject_User) {
			return null;
		}

		if (project_User == null) {
			Session session = null;

			try {
				session = openSession();

				project_User = (Project_User)session.get(Project_UserImpl.class,
						primaryKey);

				if (project_User != null) {
					cacheResult(project_User);
				}
				else {
					EntityCacheUtil.putResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
						Project_UserImpl.class, primaryKey, _nullProject_User);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Project_UserModelImpl.ENTITY_CACHE_ENABLED,
					Project_UserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return project_User;
	}

	/**
	 * Returns the project_ user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param project_UserPK the primary key of the project_ user
	 * @return the project_ user, or <code>null</code> if a project_ user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_User fetchByPrimaryKey(Project_UserPK project_UserPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)project_UserPK);
	}

	/**
	 * Returns all the project_ users.
	 *
	 * @return the project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @return the range of project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ users
	 * @param end the upper bound of the range of project_ users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project_ users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_User> findAll(int start, int end,
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

		List<Project_User> list = (List<Project_User>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECT_USER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECT_USER;

				if (pagination) {
					sql = sql.concat(Project_UserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_User>(list);
				}
				else {
					list = (List<Project_User>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the project_ users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Project_User project_User : findAll()) {
			remove(project_User);
		}
	}

	/**
	 * Returns the number of project_ users.
	 *
	 * @return the number of project_ users
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

				Query q = session.createQuery(_SQL_COUNT_PROJECT_USER);

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
	 * Initializes the project_ user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Project_User")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Project_User>> listenersList = new ArrayList<ModelListener<Project_User>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Project_User>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Project_UserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECT_USER = "SELECT project_User FROM Project_User project_User";
	private static final String _SQL_SELECT_PROJECT_USER_WHERE = "SELECT project_User FROM Project_User project_User WHERE ";
	private static final String _SQL_COUNT_PROJECT_USER = "SELECT COUNT(project_User) FROM Project_User project_User";
	private static final String _SQL_COUNT_PROJECT_USER_WHERE = "SELECT COUNT(project_User) FROM Project_User project_User WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "project_User.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project_User exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project_User exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Project_UserPersistenceImpl.class);
	private static Project_User _nullProject_User = new Project_UserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Project_User> toCacheModel() {
				return _nullProject_UserCacheModel;
			}
		};

	private static CacheModel<Project_User> _nullProject_UserCacheModel = new CacheModel<Project_User>() {
			@Override
			public Project_User toEntityModel() {
				return _nullProject_User;
			}
		};
}