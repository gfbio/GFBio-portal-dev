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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchResearchObjectException;

import org.gfbio.model.ResearchObject;
import org.gfbio.model.impl.ResearchObjectImpl;
import org.gfbio.model.impl.ResearchObjectModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see ResearchObjectPersistence
 * @see ResearchObjectUtil
 * @generated
 */
public class ResearchObjectPersistenceImpl extends BasePersistenceImpl<ResearchObject>
	implements ResearchObjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResearchObjectUtil} to access the research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResearchObjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ResearchObjectModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the research objects where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByName(String name)
		throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research objects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @return the range of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the research objects where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ResearchObject> list = (List<ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchObject researchObject : list) {
				if (!Validator.equals(name, researchObject.getName())) {
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

			query.append(_SQL_SELECT_RESEARCHOBJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject>(list);
				}
				else {
					list = (List<ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first research object in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByName_First(name,
				orderByComparator);

		if (researchObject != null) {
			return researchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first research object in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResearchObject> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research object in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByName_Last(name, orderByComparator);

		if (researchObject != null) {
			return researchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last research object in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ResearchObject> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the research objects before and after the current research object in the ordered set where name = &#63;.
	 *
	 * @param researchObjectID the primary key of the current research object
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject[] findByName_PrevAndNext(long researchObjectID,
		String name, OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = findByPrimaryKey(researchObjectID);

		Session session = null;

		try {
			session = openSession();

			ResearchObject[] array = new ResearchObjectImpl[3];

			array[0] = getByName_PrevAndNext(session, researchObject, name,
					orderByComparator, true);

			array[1] = researchObject;

			array[2] = getByName_PrevAndNext(session, researchObject, name,
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

	protected ResearchObject getByName_PrevAndNext(Session session,
		ResearchObject researchObject, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESEARCHOBJECT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research objects where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ResearchObject researchObject : findByName(name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(researchObject);
		}
	}

	/**
	 * Returns the number of research objects where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESEARCHOBJECT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "researchObject.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "researchObject.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(researchObject.name IS NULL OR researchObject.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLabel",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLabel",
			new String[] { String.class.getName() },
			ResearchObjectModelImpl.LABEL_COLUMN_BITMASK |
			ResearchObjectModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABEL = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLabel",
			new String[] { String.class.getName() });

	/**
	 * Returns all the research objects where label = &#63;.
	 *
	 * @param label the label
	 * @return the matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByLabel(String label)
		throws SystemException {
		return findByLabel(label, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research objects where label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label the label
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @return the range of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByLabel(String label, int start, int end)
		throws SystemException {
		return findByLabel(label, start, end, null);
	}

	/**
	 * Returns an ordered range of all the research objects where label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param label the label
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findByLabel(String label, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL;
			finderArgs = new Object[] { label };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL;
			finderArgs = new Object[] { label, start, end, orderByComparator };
		}

		List<ResearchObject> list = (List<ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResearchObject researchObject : list) {
				if (!Validator.equals(label, researchObject.getLabel())) {
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

			query.append(_SQL_SELECT_RESEARCHOBJECT_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_LABEL_LABEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResearchObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
				}

				if (!pagination) {
					list = (List<ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject>(list);
				}
				else {
					list = (List<ResearchObject>)QueryUtil.list(q,
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
	 * Returns the first research object in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByLabel_First(String label,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByLabel_First(label,
				orderByComparator);

		if (researchObject != null) {
			return researchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label=");
		msg.append(label);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObjectException(msg.toString());
	}

	/**
	 * Returns the first research object in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByLabel_First(String label,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResearchObject> list = findByLabel(label, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last research object in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByLabel_Last(String label,
		OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByLabel_Last(label,
				orderByComparator);

		if (researchObject != null) {
			return researchObject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label=");
		msg.append(label);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResearchObjectException(msg.toString());
	}

	/**
	 * Returns the last research object in the ordered set where label = &#63;.
	 *
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByLabel_Last(String label,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLabel(label);

		if (count == 0) {
			return null;
		}

		List<ResearchObject> list = findByLabel(label, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the research objects before and after the current research object in the ordered set where label = &#63;.
	 *
	 * @param researchObjectID the primary key of the current research object
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject[] findByLabel_PrevAndNext(long researchObjectID,
		String label, OrderByComparator orderByComparator)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = findByPrimaryKey(researchObjectID);

		Session session = null;

		try {
			session = openSession();

			ResearchObject[] array = new ResearchObjectImpl[3];

			array[0] = getByLabel_PrevAndNext(session, researchObject, label,
					orderByComparator, true);

			array[1] = researchObject;

			array[2] = getByLabel_PrevAndNext(session, researchObject, label,
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

	protected ResearchObject getByLabel_PrevAndNext(Session session,
		ResearchObject researchObject, String label,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESEARCHOBJECT_WHERE);

		boolean bindLabel = false;

		if (label == null) {
			query.append(_FINDER_COLUMN_LABEL_LABEL_1);
		}
		else if (label.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LABEL_LABEL_3);
		}
		else {
			bindLabel = true;

			query.append(_FINDER_COLUMN_LABEL_LABEL_2);
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
			query.append(ResearchObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLabel) {
			qPos.add(label);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(researchObject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResearchObject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the research objects where label = &#63; from the database.
	 *
	 * @param label the label
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLabel(String label) throws SystemException {
		for (ResearchObject researchObject : findByLabel(label,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(researchObject);
		}
	}

	/**
	 * Returns the number of research objects where label = &#63;.
	 *
	 * @param label the label
	 * @return the number of matching research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLabel(String label) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABEL;

		Object[] finderArgs = new Object[] { label };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESEARCHOBJECT_WHERE);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LABEL_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_LABEL_LABEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel) {
					qPos.add(label);
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

	private static final String _FINDER_COLUMN_LABEL_LABEL_1 = "researchObject.label IS NULL";
	private static final String _FINDER_COLUMN_LABEL_LABEL_2 = "researchObject.label = ?";
	private static final String _FINDER_COLUMN_LABEL_LABEL_3 = "(researchObject.label IS NULL OR researchObject.label = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RESEARCHOBJECTID = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED,
			ResearchObjectImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByResearchObjectID", new String[] { Long.class.getName() },
			ResearchObjectModelImpl.RESEARCHOBJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESEARCHOBJECTID = new FinderPath(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResearchObjectID", new String[] { Long.class.getName() });

	/**
	 * Returns the research object where researchObjectID = &#63; or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByResearchObjectID(long researchObjectID)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByResearchObjectID(researchObjectID);

		if (researchObject == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("researchObjectID=");
			msg.append(researchObjectID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchResearchObjectException(msg.toString());
		}

		return researchObject;
	}

	/**
	 * Returns the research object where researchObjectID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @return the matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByResearchObjectID(long researchObjectID)
		throws SystemException {
		return fetchByResearchObjectID(researchObjectID, true);
	}

	/**
	 * Returns the research object where researchObjectID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param researchObjectID the research object i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching research object, or <code>null</code> if a matching research object could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByResearchObjectID(long researchObjectID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { researchObjectID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
					finderArgs, this);
		}

		if (result instanceof ResearchObject) {
			ResearchObject researchObject = (ResearchObject)result;

			if ((researchObjectID != researchObject.getResearchObjectID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RESEARCHOBJECT_WHERE);

			query.append(_FINDER_COLUMN_RESEARCHOBJECTID_RESEARCHOBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(researchObjectID);

				List<ResearchObject> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ResearchObjectPersistenceImpl.fetchByResearchObjectID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ResearchObject researchObject = list.get(0);

					result = researchObject;

					cacheResult(researchObject);

					if ((researchObject.getResearchObjectID() != researchObjectID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
							finderArgs, researchObject);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
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
			return (ResearchObject)result;
		}
	}

	/**
	 * Removes the research object where researchObjectID = &#63; from the database.
	 *
	 * @param researchObjectID the research object i d
	 * @return the research object that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject removeByResearchObjectID(long researchObjectID)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = findByResearchObjectID(researchObjectID);

		return remove(researchObject);
	}

	/**
	 * Returns the number of research objects where researchObjectID = &#63;.
	 *
	 * @param researchObjectID the research object i d
	 * @return the number of matching research objects
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

			query.append(_SQL_COUNT_RESEARCHOBJECT_WHERE);

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
		"researchObject.researchObjectID = ?";

	public ResearchObjectPersistenceImpl() {
		setModelClass(ResearchObject.class);
	}

	/**
	 * Caches the research object in the entity cache if it is enabled.
	 *
	 * @param researchObject the research object
	 */
	@Override
	public void cacheResult(ResearchObject researchObject) {
		EntityCacheUtil.putResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectImpl.class, researchObject.getPrimaryKey(),
			researchObject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
			new Object[] { researchObject.getResearchObjectID() },
			researchObject);

		researchObject.resetOriginalValues();
	}

	/**
	 * Caches the research objects in the entity cache if it is enabled.
	 *
	 * @param researchObjects the research objects
	 */
	@Override
	public void cacheResult(List<ResearchObject> researchObjects) {
		for (ResearchObject researchObject : researchObjects) {
			if (EntityCacheUtil.getResult(
						ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						ResearchObjectImpl.class, researchObject.getPrimaryKey()) == null) {
				cacheResult(researchObject);
			}
			else {
				researchObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all research objects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResearchObjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResearchObjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the research object.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResearchObject researchObject) {
		EntityCacheUtil.removeResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectImpl.class, researchObject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(researchObject);
	}

	@Override
	public void clearCache(List<ResearchObject> researchObjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResearchObject researchObject : researchObjects) {
			EntityCacheUtil.removeResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				ResearchObjectImpl.class, researchObject.getPrimaryKey());

			clearUniqueFindersCache(researchObject);
		}
	}

	protected void cacheUniqueFindersCache(ResearchObject researchObject) {
		if (researchObject.isNew()) {
			Object[] args = new Object[] { researchObject.getResearchObjectID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
				args, researchObject);
		}
		else {
			ResearchObjectModelImpl researchObjectModelImpl = (ResearchObjectModelImpl)researchObject;

			if ((researchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObject.getResearchObjectID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
					args, researchObject);
			}
		}
	}

	protected void clearUniqueFindersCache(ResearchObject researchObject) {
		ResearchObjectModelImpl researchObjectModelImpl = (ResearchObjectModelImpl)researchObject;

		Object[] args = new Object[] { researchObject.getResearchObjectID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID, args);

		if ((researchObjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RESEARCHOBJECTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					researchObjectModelImpl.getOriginalResearchObjectID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RESEARCHOBJECTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESEARCHOBJECTID,
				args);
		}
	}

	/**
	 * Creates a new research object with the primary key. Does not add the research object to the database.
	 *
	 * @param researchObjectID the primary key for the new research object
	 * @return the new research object
	 */
	@Override
	public ResearchObject create(long researchObjectID) {
		ResearchObject researchObject = new ResearchObjectImpl();

		researchObject.setNew(true);
		researchObject.setPrimaryKey(researchObjectID);

		return researchObject;
	}

	/**
	 * Removes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param researchObjectID the primary key of the research object
	 * @return the research object that was removed
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject remove(long researchObjectID)
		throws NoSuchResearchObjectException, SystemException {
		return remove((Serializable)researchObjectID);
	}

	/**
	 * Removes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the research object
	 * @return the research object that was removed
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject remove(Serializable primaryKey)
		throws NoSuchResearchObjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResearchObject researchObject = (ResearchObject)session.get(ResearchObjectImpl.class,
					primaryKey);

			if (researchObject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(researchObject);
		}
		catch (NoSuchResearchObjectException nsee) {
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
	protected ResearchObject removeImpl(ResearchObject researchObject)
		throws SystemException {
		researchObject = toUnwrappedModel(researchObject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(researchObject)) {
				researchObject = (ResearchObject)session.get(ResearchObjectImpl.class,
						researchObject.getPrimaryKeyObj());
			}

			if (researchObject != null) {
				session.delete(researchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (researchObject != null) {
			clearCache(researchObject);
		}

		return researchObject;
	}

	@Override
	public ResearchObject updateImpl(
		org.gfbio.model.ResearchObject researchObject)
		throws SystemException {
		researchObject = toUnwrappedModel(researchObject);

		boolean isNew = researchObject.isNew();

		ResearchObjectModelImpl researchObjectModelImpl = (ResearchObjectModelImpl)researchObject;

		Session session = null;

		try {
			session = openSession();

			if (researchObject.isNew()) {
				session.save(researchObject);

				researchObject.setNew(false);
			}
			else {
				session.merge(researchObject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResearchObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((researchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObjectModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { researchObjectModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((researchObjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						researchObjectModelImpl.getOriginalLabel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL,
					args);

				args = new Object[] { researchObjectModelImpl.getLabel() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LABEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL,
					args);
			}
		}

		EntityCacheUtil.putResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
			ResearchObjectImpl.class, researchObject.getPrimaryKey(),
			researchObject);

		clearUniqueFindersCache(researchObject);
		cacheUniqueFindersCache(researchObject);

		return researchObject;
	}

	protected ResearchObject toUnwrappedModel(ResearchObject researchObject) {
		if (researchObject instanceof ResearchObjectImpl) {
			return researchObject;
		}

		ResearchObjectImpl researchObjectImpl = new ResearchObjectImpl();

		researchObjectImpl.setNew(researchObject.isNew());
		researchObjectImpl.setPrimaryKey(researchObject.getPrimaryKey());

		researchObjectImpl.setResearchObjectID(researchObject.getResearchObjectID());
		researchObjectImpl.setName(researchObject.getName());
		researchObjectImpl.setLabel(researchObject.getLabel());
		researchObjectImpl.setMetadata(researchObject.getMetadata());
		researchObjectImpl.setFormatmetadata(researchObject.getFormatmetadata());

		return researchObjectImpl;
	}

	/**
	 * Returns the research object with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the research object
	 * @return the research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResearchObjectException, SystemException {
		ResearchObject researchObject = fetchByPrimaryKey(primaryKey);

		if (researchObject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResearchObjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return researchObject;
	}

	/**
	 * Returns the research object with the primary key or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	 *
	 * @param researchObjectID the primary key of the research object
	 * @return the research object
	 * @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject findByPrimaryKey(long researchObjectID)
		throws NoSuchResearchObjectException, SystemException {
		return findByPrimaryKey((Serializable)researchObjectID);
	}

	/**
	 * Returns the research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the research object
	 * @return the research object, or <code>null</code> if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ResearchObject researchObject = (ResearchObject)EntityCacheUtil.getResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
				ResearchObjectImpl.class, primaryKey);

		if (researchObject == _nullResearchObject) {
			return null;
		}

		if (researchObject == null) {
			Session session = null;

			try {
				session = openSession();

				researchObject = (ResearchObject)session.get(ResearchObjectImpl.class,
						primaryKey);

				if (researchObject != null) {
					cacheResult(researchObject);
				}
				else {
					EntityCacheUtil.putResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
						ResearchObjectImpl.class, primaryKey,
						_nullResearchObject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ResearchObjectModelImpl.ENTITY_CACHE_ENABLED,
					ResearchObjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return researchObject;
	}

	/**
	 * Returns the research object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param researchObjectID the primary key of the research object
	 * @return the research object, or <code>null</code> if a research object with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResearchObject fetchByPrimaryKey(long researchObjectID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)researchObjectID);
	}

	/**
	 * Returns all the research objects.
	 *
	 * @return the research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @return the range of research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the research objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of research objects
	 * @param end the upper bound of the range of research objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of research objects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResearchObject> findAll(int start, int end,
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

		List<ResearchObject> list = (List<ResearchObject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESEARCHOBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESEARCHOBJECT;

				if (pagination) {
					sql = sql.concat(ResearchObjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ResearchObject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResearchObject>(list);
				}
				else {
					list = (List<ResearchObject>)QueryUtil.list(q,
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
	 * Removes all the research objects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ResearchObject researchObject : findAll()) {
			remove(researchObject);
		}
	}

	/**
	 * Returns the number of research objects.
	 *
	 * @return the number of research objects
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

				Query q = session.createQuery(_SQL_COUNT_RESEARCHOBJECT);

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
	 * Initializes the research object persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.ResearchObject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResearchObject>> listenersList = new ArrayList<ModelListener<ResearchObject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResearchObject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResearchObjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RESEARCHOBJECT = "SELECT researchObject FROM ResearchObject researchObject";
	private static final String _SQL_SELECT_RESEARCHOBJECT_WHERE = "SELECT researchObject FROM ResearchObject researchObject WHERE ";
	private static final String _SQL_COUNT_RESEARCHOBJECT = "SELECT COUNT(researchObject) FROM ResearchObject researchObject";
	private static final String _SQL_COUNT_RESEARCHOBJECT_WHERE = "SELECT COUNT(researchObject) FROM ResearchObject researchObject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "researchObject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResearchObject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResearchObject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResearchObjectPersistenceImpl.class);
	private static ResearchObject _nullResearchObject = new ResearchObjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResearchObject> toCacheModel() {
				return _nullResearchObjectCacheModel;
			}
		};

	private static CacheModel<ResearchObject> _nullResearchObjectCacheModel = new CacheModel<ResearchObject>() {
			@Override
			public ResearchObject toEntityModel() {
				return _nullResearchObject;
			}
		};
}