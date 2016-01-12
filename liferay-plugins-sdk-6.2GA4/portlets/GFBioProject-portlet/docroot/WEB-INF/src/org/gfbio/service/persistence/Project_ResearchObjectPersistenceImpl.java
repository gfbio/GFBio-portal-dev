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

import org.gfbio.NoSuchProject_ResearchObjectException;

import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.impl.Project_ResearchObjectImpl;
import org.gfbio.model.impl.Project_ResearchObjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the project_ research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_ResearchObjectPersistence
 * @see Project_ResearchObjectUtil
 * @generated
 */
public class Project_ResearchObjectPersistenceImpl extends BasePersistenceImpl<Project_ResearchObject>
	implements Project_ResearchObjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Project_ResearchObjectUtil} to access the project_ research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Project_ResearchObjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectID",
			new String[] { Long.class.getName() },
			Project_ResearchObjectModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ research objects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByProjectID(long projectID)
		throws SystemException {
		return findByProjectID(projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project_ research objects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @return the range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByProjectID(long projectID,
		int start, int end) throws SystemException {
		return findByProjectID(projectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ research objects where projectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectID the project i d
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByProjectID(long projectID,
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

		List<Project_ResearchObject> list = (List<Project_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_ResearchObject project_ResearchObject : list) {
				if ((projectID != project_ResearchObject.getProjectID())) {
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

			query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectID);

				if (!pagination) {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_ResearchObject>(list);
				}
				else {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first project_ research object in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByProjectID_First(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByProjectID_First(projectID,
				orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first project_ research object in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByProjectID_First(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_ResearchObject> list = findByProjectID(projectID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ research object in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByProjectID_Last(long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByProjectID_Last(projectID,
				orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectID=");
		msg.append(projectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last project_ research object in the ordered set where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByProjectID_Last(long projectID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectID(projectID);

		if (count == 0) {
			return null;
		}

		List<Project_ResearchObject> list = findByProjectID(projectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ research objects before and after the current project_ research object in the ordered set where projectID = &#63;.
	 *
	 * @param project_ResearchObjectPK the primary key of the current project_ research object
	 * @param projectID the project i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject[] findByProjectID_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK, long projectID,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = findByPrimaryKey(project_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			Project_ResearchObject[] array = new Project_ResearchObjectImpl[3];

			array[0] = getByProjectID_PrevAndNext(session,
					project_ResearchObject, projectID, orderByComparator, true);

			array[1] = project_ResearchObject;

			array[2] = getByProjectID_PrevAndNext(session,
					project_ResearchObject, projectID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Project_ResearchObject getByProjectID_PrevAndNext(
		Session session, Project_ResearchObject project_ResearchObject,
		long projectID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

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
			query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ research objects where projectID = &#63; from the database.
	 *
	 * @param projectID the project i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectID(long projectID) throws SystemException {
		for (Project_ResearchObject project_ResearchObject : findByProjectID(
				projectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_ResearchObject);
		}
	}

	/**
	 * Returns the number of project_ research objects where projectID = &#63;.
	 *
	 * @param projectID the project i d
	 * @return the number of matching project_ research objects
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

			query.append(_SQL_COUNT_PROJECT_RESEARCHOBJECT_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "project_ResearchObject.id.projectID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchObjectID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectID",
			new String[] { Long.class.getName(), Integer.class.getName() },
			Project_ResearchObjectModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK |
			Project_ResearchObjectModelImpl.RESEARCHOBJECTVERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion)
		throws SystemException {
		return findByResearchObjectID(researchObjectID, researchObjectVersion,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @return the range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws SystemException {
		return findByResearchObjectID(researchObjectID, researchObjectVersion,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID;
			finderArgs = new Object[] { researchObjectID, researchObjectVersion };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID;
			finderArgs = new Object[] {
					researchObjectID, researchObjectVersion,
					
					start, end, orderByComparator
				};
		}

		List<Project_ResearchObject> list = (List<Project_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_ResearchObject project_ResearchObject : list) {
				if ((researchObjectID != project_ResearchObject.getResearchObjectID()) ||
						(researchObjectVersion != project_ResearchObject.getResearchObjectVersion())) {
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

			query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTVERSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
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
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_ResearchObject>(list);
				}
				else {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByResearchObjectID_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByResearchObjectID_First(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByResearchObjectID_First(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		List<Project_ResearchObject> list = findByResearchObjectID(researchObjectID,
				researchObjectVersion, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByResearchObjectID_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByResearchObjectID_Last(researchObjectID,
				researchObjectVersion, orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(", researchObjectVersion=");
		msg.append(researchObjectVersion);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByResearchObjectID(researchObjectID,
				researchObjectVersion);

		if (count == 0) {
			return null;
		}

		List<Project_ResearchObject> list = findByResearchObjectID(researchObjectID,
				researchObjectVersion, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ research objects before and after the current project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param project_ResearchObjectPK the primary key of the current project_ research object
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject[] findByResearchObjectID_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK,
		long researchObjectID, int researchObjectVersion,
		OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = findByPrimaryKey(project_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			Project_ResearchObject[] array = new Project_ResearchObjectImpl[3];

			array[0] = getByResearchObjectID_PrevAndNext(session,
					project_ResearchObject, researchObjectID,
					researchObjectVersion, orderByComparator, true);

			array[1] = project_ResearchObject;

			array[2] = getByResearchObjectID_PrevAndNext(session,
					project_ResearchObject, researchObjectID,
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

	protected Project_ResearchObject getByResearchObjectID_PrevAndNext(
		Session session, Project_ResearchObject project_ResearchObject,
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

		query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTVERSION_2);

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
			query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		qPos.add(researchObjectVersion);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectID(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		for (Project_ResearchObject project_ResearchObject : findByResearchObjectID(
				researchObjectID, researchObjectVersion, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(project_ResearchObject);
		}
	}

	/**
	 * Returns the number of project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param researchObjectVersion the research object version
	 * @return the number of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectID(long researchObjectID,
		int researchObjectVersion) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTID;

		Object[] finderArgs = new Object[] {
				researchObjectID, researchObjectVersion
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTVERSION_2);

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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2 =
		"project_ResearchObject.id.researchObjectID = ? AND ";
	private static final String _FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTVERSION_2 =
		"project_ResearchObject.id.researchObjectVersion = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID2 =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResearchObjectID2",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID2 =
		new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResearchObjectID2", new String[] { Long.class.getName() },
			Project_ResearchObjectModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID2 = new FinderPath(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID2", new String[] { Long.class.getName() });

	/**
	 * Returns all the project_ research objects where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID) throws SystemException {
		return findByResearchObjectID2(researchObjectID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ research objects where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @return the range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID, int start, int end) throws SystemException {
		return findByResearchObjectID2(researchObjectID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ research objects where researchObjectID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param researchObjectID the research object i d
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID2;
			finderArgs = new Object[] { researchObjectID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESEARCHOBJECTID2;
			finderArgs = new Object[] {
					researchObjectID,
					
					start, end, orderByComparator
				};
		}

		List<Project_ResearchObject> list = (List<Project_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Project_ResearchObject project_ResearchObject : list) {
				if ((researchObjectID != project_ResearchObject.getResearchObjectID())) {
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

			query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID2_RESEARCHOBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				if (!pagination) {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_ResearchObject>(list);
				}
				else {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByResearchObjectID2_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByResearchObjectID2_First(researchObjectID,
				orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByResearchObjectID2_First(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Project_ResearchObject> list = findByResearchObjectID2(researchObjectID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByResearchObjectID2_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByResearchObjectID2_Last(researchObjectID,
				orderByComparator);

		if (project_ResearchObject != null) {
			return project_ResearchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("researchObjectID=");
		msg.append(researchObjectID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProject_ResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByResearchObjectID2_Last(
		long researchObjectID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByResearchObjectID2(researchObjectID);

		if (count == 0) {
			return null;
		}

		List<Project_ResearchObject> list = findByResearchObjectID2(researchObjectID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project_ research objects before and after the current project_ research object in the ordered set where researchObjectID = &#63;.
	 *
	 * @param project_ResearchObjectPK the primary key of the current project_ research object
	 * @param researchObjectID the research object i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject[] findByResearchObjectID2_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK,
		long researchObjectID, OrderByComparator orderByComparator)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = findByPrimaryKey(project_ResearchObjectPK);

		Session session = null;

		try {
			session = openSession();

			Project_ResearchObject[] array = new Project_ResearchObjectImpl[3];

			array[0] = getByResearchObjectID2_PrevAndNext(session,
					project_ResearchObject, researchObjectID,
					orderByComparator, true);

			array[1] = project_ResearchObject;

			array[2] = getByResearchObjectID2_PrevAndNext(session,
					project_ResearchObject, researchObjectID,
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

	protected Project_ResearchObject getByResearchObjectID2_PrevAndNext(
		Session session, Project_ResearchObject project_ResearchObject,
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

		query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE);

		query.append(_FINDER_COLUMN_RESEARCHOBJECTID2_RESEARCHOBJECTID_2);

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
			query.append(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(researchObjectID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(project_ResearchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Project_ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project_ research objects where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByResearchObjectID2(long researchObjectID)
		throws SystemException {
		for (Project_ResearchObject project_ResearchObject : findByResearchObjectID2(
				researchObjectID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(project_ResearchObject);
		}
	}

	/**
	 * Returns the number of project_ research objects where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByResearchObjectID2(long researchObjectID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESEARCHOBJECTID2;

		Object[] finderArgs = new Object[] { researchObjectID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID2_RESEARCHOBJECTID_2);

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

	private static final String _FINDER_COLUMN_RESEARCHOBJECTID2_RESEARCHOBJECTID_2 =
		"project_ResearchObject.id.researchObjectID = ?";

	public Project_ResearchObjectPersistenceImpl() {
		setModelClass(Project_ResearchObject.class);
	}

	/**
	 * Caches the project_ research object in the entity cache if it is enabled.
	 *
	 * @param project_ResearchObject the project_ research object
	 */
	@Override
	public void cacheResult(Project_ResearchObject project_ResearchObject) {
		EntityCacheUtil.putResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			project_ResearchObject.getPrimaryKey(), project_ResearchObject);

		project_ResearchObject.resetOriginalValues();
	}

	/**
	 * Caches the project_ research objects in the entity cache if it is enabled.
	 *
	 * @param project_ResearchObjects the project_ research objects
	 */
	@Override
	public void cacheResult(
		List<Project_ResearchObject> project_ResearchObjects) {
		for (Project_ResearchObject project_ResearchObject : project_ResearchObjects) {
			if (EntityCacheUtil.getResult(
						Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						Project_ResearchObjectImpl.class,
						project_ResearchObject.getPrimaryKey()) == null) {
				cacheResult(project_ResearchObject);
			}
			else {
				project_ResearchObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project_ research objects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(Project_ResearchObjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(Project_ResearchObjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project_ research object.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Project_ResearchObject project_ResearchObject) {
		EntityCacheUtil.removeResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			project_ResearchObject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Project_ResearchObject> project_ResearchObjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Project_ResearchObject project_ResearchObject : project_ResearchObjects) {
			EntityCacheUtil.removeResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				Project_ResearchObjectImpl.class,
				project_ResearchObject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project_ research object with the primary key. Does not add the project_ research object to the database.
	 *
	 * @param project_ResearchObjectPK the primary key for the new project_ research object
	 * @return the new project_ research object
	 */
	@Override
	public Project_ResearchObject create(
		Project_ResearchObjectPK project_ResearchObjectPK) {
		Project_ResearchObject project_ResearchObject = new Project_ResearchObjectImpl();

		project_ResearchObject.setNew(true);
		project_ResearchObject.setPrimaryKey(project_ResearchObjectPK);

		return project_ResearchObject;
	}

	/**
	 * Removes the project_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project_ResearchObjectPK the primary key of the project_ research object
	 * @return the project_ research object that was removed
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject remove(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws NoSuchProject_ResearchObjectException, SystemException {
		return remove((Serializable)project_ResearchObjectPK);
	}

	/**
	 * Removes the project_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project_ research object
	 * @return the project_ research object that was removed
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject remove(Serializable primaryKey)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Project_ResearchObject project_ResearchObject = (Project_ResearchObject)session.get(Project_ResearchObjectImpl.class,
					primaryKey);

			if (project_ResearchObject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProject_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(project_ResearchObject);
		}
		catch (NoSuchProject_ResearchObjectException nsee) {
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
	protected Project_ResearchObject removeImpl(
		Project_ResearchObject project_ResearchObject)
		throws SystemException {
		project_ResearchObject = toUnwrappedModel(project_ResearchObject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(project_ResearchObject)) {
				project_ResearchObject = (Project_ResearchObject)session.get(Project_ResearchObjectImpl.class,
						project_ResearchObject.getPrimaryKeyObj());
			}

			if (project_ResearchObject != null) {
				session.delete(project_ResearchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (project_ResearchObject != null) {
			clearCache(project_ResearchObject);
		}

		return project_ResearchObject;
	}

	@Override
	public Project_ResearchObject updateImpl(
		org.gfbio.model.Project_ResearchObject project_ResearchObject)
		throws SystemException {
		project_ResearchObject = toUnwrappedModel(project_ResearchObject);

		boolean isNew = project_ResearchObject.isNew();

		Project_ResearchObjectModelImpl project_ResearchObjectModelImpl = (Project_ResearchObjectModelImpl)project_ResearchObject;

		Session session = null;

		try {
			session = openSession();

			if (project_ResearchObject.isNew()) {
				session.save(project_ResearchObject);

				project_ResearchObject.setNew(false);
			}
			else {
				session.merge(project_ResearchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Project_ResearchObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((project_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_ResearchObjectModelImpl.getOriginalProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] {
						project_ResearchObjectModelImpl.getProjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((project_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_ResearchObjectModelImpl.getOriginalResearchObjectID(),
						project_ResearchObjectModelImpl.getOriginalResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);

				args = new Object[] {
						project_ResearchObjectModelImpl.getResearchObjectID(),
						project_ResearchObjectModelImpl.getResearchObjectVersion()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID,
					args);
			}

			if ((project_ResearchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						project_ResearchObjectModelImpl.getOriginalResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID2,
					args);

				args = new Object[] {
						project_ResearchObjectModelImpl.getResearchObjectID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESEARCHOBJECTID2,
					args);
			}
		}

		EntityCacheUtil.putResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			Project_ResearchObjectImpl.class,
			project_ResearchObject.getPrimaryKey(), project_ResearchObject);

		return project_ResearchObject;
	}

	protected Project_ResearchObject toUnwrappedModel(
		Project_ResearchObject project_ResearchObject) {
		if (project_ResearchObject instanceof Project_ResearchObjectImpl) {
			return project_ResearchObject;
		}

		Project_ResearchObjectImpl project_ResearchObjectImpl = new Project_ResearchObjectImpl();

		project_ResearchObjectImpl.setNew(project_ResearchObject.isNew());
		project_ResearchObjectImpl.setPrimaryKey(project_ResearchObject.getPrimaryKey());

		project_ResearchObjectImpl.setProjectID(project_ResearchObject.getProjectID());
		project_ResearchObjectImpl.setResearchObjectID(project_ResearchObject.getResearchObjectID());
		project_ResearchObjectImpl.setResearchObjectVersion(project_ResearchObject.getResearchObjectVersion());

		return project_ResearchObjectImpl;
	}

	/**
	 * Returns the project_ research object with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ research object
	 * @return the project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProject_ResearchObjectException, SystemException {
		Project_ResearchObject project_ResearchObject = fetchByPrimaryKey(primaryKey);

		if (project_ResearchObject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProject_ResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return project_ResearchObject;
	}

	/**
	 * Returns the project_ research object with the primary key or throws a {@link org.gfbio.NoSuchProject_ResearchObjectException} if it could not be found.
	 *
	 * @param project_ResearchObjectPK the primary key of the project_ research object
	 * @return the project_ research object
	 * @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject findByPrimaryKey(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws NoSuchProject_ResearchObjectException, SystemException {
		return findByPrimaryKey((Serializable)project_ResearchObjectPK);
	}

	/**
	 * Returns the project_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project_ research object
	 * @return the project_ research object, or <code>null</code> if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Project_ResearchObject project_ResearchObject = (Project_ResearchObject)EntityCacheUtil.getResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				Project_ResearchObjectImpl.class, primaryKey);

		if (project_ResearchObject == _nullProject_ResearchObject) {
			return null;
		}

		if (project_ResearchObject == null) {
			Session session = null;

			try {
				session = openSession();

				project_ResearchObject = (Project_ResearchObject)session.get(Project_ResearchObjectImpl.class,
						primaryKey);

				if (project_ResearchObject != null) {
					cacheResult(project_ResearchObject);
				}
				else {
					EntityCacheUtil.putResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						Project_ResearchObjectImpl.class, primaryKey,
						_nullProject_ResearchObject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(Project_ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
					Project_ResearchObjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return project_ResearchObject;
	}

	/**
	 * Returns the project_ research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param project_ResearchObjectPK the primary key of the project_ research object
	 * @return the project_ research object, or <code>null</code> if a project_ research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Project_ResearchObject fetchByPrimaryKey(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)project_ResearchObjectPK);
	}

	/**
	 * Returns all the project_ research objects.
	 *
	 * @return the project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @return the range of project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project_ research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project_ research objects
	 * @param end the upper bound of the range of project_ research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project_ research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Project_ResearchObject> findAll(int start, int end,
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

		List<Project_ResearchObject> list = (List<Project_ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECT_RESEARCHOBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECT_RESEARCHOBJECT;

				if (pagination) {
					sql = sql.concat(Project_ResearchObjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Project_ResearchObject>(list);
				}
				else {
					list = (List<Project_ResearchObject>)QueryUtil.list(q,
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
	 * Removes all the project_ research objects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Project_ResearchObject project_ResearchObject : findAll()) {
			remove(project_ResearchObject);
		}
	}

	/**
	 * Returns the number of project_ research objects.
	 *
	 * @return the number of project_ research objects
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

				Query q = session.createQuery(_SQL_COUNT_PROJECT_RESEARCHOBJECT);

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
	 * Initializes the project_ research object persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Project_ResearchObject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Project_ResearchObject>> listenersList = new ArrayList<ModelListener<Project_ResearchObject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Project_ResearchObject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(Project_ResearchObjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECT_RESEARCHOBJECT = "SELECT project_ResearchObject FROM Project_ResearchObject project_ResearchObject";
	private static final String _SQL_SELECT_PROJECT_RESEARCHOBJECT_WHERE = "SELECT project_ResearchObject FROM Project_ResearchObject project_ResearchObject WHERE ";
	private static final String _SQL_COUNT_PROJECT_RESEARCHOBJECT = "SELECT COUNT(project_ResearchObject) FROM Project_ResearchObject project_ResearchObject";
	private static final String _SQL_COUNT_PROJECT_RESEARCHOBJECT_WHERE = "SELECT COUNT(project_ResearchObject) FROM Project_ResearchObject project_ResearchObject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "project_ResearchObject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Project_ResearchObject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Project_ResearchObject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(Project_ResearchObjectPersistenceImpl.class);
	private static Project_ResearchObject _nullProject_ResearchObject = new Project_ResearchObjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Project_ResearchObject> toCacheModel() {
				return _nullProject_ResearchObjectCacheModel;
			}
		};

	private static CacheModel<Project_ResearchObject> _nullProject_ResearchObjectCacheModel =
		new CacheModel<Project_ResearchObject>() {
			@Override
			public Project_ResearchObject toEntityModel() {
				return _nullProject_ResearchObject;
			}
		};
}