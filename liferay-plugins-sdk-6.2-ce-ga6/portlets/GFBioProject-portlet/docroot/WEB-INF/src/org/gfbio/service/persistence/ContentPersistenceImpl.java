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

import org.gfbio.NoSuchContentException;

import org.gfbio.model.Content;
import org.gfbio.model.impl.ContentImpl;
import org.gfbio.model.impl.ContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ContentPersistence
 * @see ContentUtil
 * @generated
 */
public class ContentPersistenceImpl extends BasePersistenceImpl<Content>
	implements ContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContentUtil} to access the content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTENTID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByContentId",
			new String[] { Long.class.getName() },
			ContentModelImpl.CONTENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the content where contentID = &#63; or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	 *
	 * @param contentID the content i d
	 * @return the matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByContentId(long contentID)
		throws NoSuchContentException, SystemException {
		Content content = fetchByContentId(contentID);

		if (content == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contentID=");
			msg.append(contentID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContentException(msg.toString());
		}

		return content;
	}

	/**
	 * Returns the content where contentID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contentID the content i d
	 * @return the matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByContentId(long contentID) throws SystemException {
		return fetchByContentId(contentID, true);
	}

	/**
	 * Returns the content where contentID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contentID the content i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByContentId(long contentID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { contentID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTENTID,
					finderArgs, this);
		}

		if (result instanceof Content) {
			Content content = (Content)result;

			if ((contentID != content.getContentID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contentID);

				List<Content> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENTID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ContentPersistenceImpl.fetchByContentId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Content content = list.get(0);

					result = content;

					cacheResult(content);

					if ((content.getContentID() != contentID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENTID,
							finderArgs, content);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENTID,
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
			return (Content)result;
		}
	}

	/**
	 * Removes the content where contentID = &#63; from the database.
	 *
	 * @param contentID the content i d
	 * @return the content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content removeByContentId(long contentID)
		throws NoSuchContentException, SystemException {
		Content content = findByContentId(contentID);

		return remove(content);
	}

	/**
	 * Returns the number of contents where contentID = &#63;.
	 *
	 * @param contentID the content i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContentId(long contentID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTID;

		Object[] finderArgs = new Object[] { contentID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTID_CONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contentID);

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

	private static final String _FINDER_COLUMN_CONTENTID_CONTENTID_2 = "content.contentID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TABLEIDS = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTableIds",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContentModelImpl.COLUMNID_COLUMN_BITMASK |
			ContentModelImpl.ROWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TABLEIDS = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTableIds",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the content where columnID = &#63; and rowID = &#63; or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByTableIds(long columnID, long rowID)
		throws NoSuchContentException, SystemException {
		Content content = fetchByTableIds(columnID, rowID);

		if (content == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnID=");
			msg.append(columnID);

			msg.append(", rowID=");
			msg.append(rowID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContentException(msg.toString());
		}

		return content;
	}

	/**
	 * Returns the content where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByTableIds(long columnID, long rowID)
		throws SystemException {
		return fetchByTableIds(columnID, rowID, true);
	}

	/**
	 * Returns the content where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByTableIds(long columnID, long rowID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { columnID, rowID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TABLEIDS,
					finderArgs, this);
		}

		if (result instanceof Content) {
			Content content = (Content)result;

			if ((columnID != content.getColumnID()) ||
					(rowID != content.getRowID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_TABLEIDS_COLUMNID_2);

			query.append(_FINDER_COLUMN_TABLEIDS_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				qPos.add(rowID);

				List<Content> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ContentPersistenceImpl.fetchByTableIds(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Content content = list.get(0);

					result = content;

					cacheResult(content);

					if ((content.getColumnID() != columnID) ||
							(content.getRowID() != rowID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
							finderArgs, content);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS,
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
			return (Content)result;
		}
	}

	/**
	 * Removes the content where columnID = &#63; and rowID = &#63; from the database.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content removeByTableIds(long columnID, long rowID)
		throws NoSuchContentException, SystemException {
		Content content = findByTableIds(columnID, rowID);

		return remove(content);
	}

	/**
	 * Returns the number of contents where columnID = &#63; and rowID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param rowID the row i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTableIds(long columnID, long rowID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TABLEIDS;

		Object[] finderArgs = new Object[] { columnID, rowID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_TABLEIDS_COLUMNID_2);

			query.append(_FINDER_COLUMN_TABLEIDS_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				qPos.add(rowID);

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

	private static final String _FINDER_COLUMN_TABLEIDS_COLUMNID_2 = "content.columnID = ? AND ";
	private static final String _FINDER_COLUMN_TABLEIDS_ROWID_2 = "content.rowID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHeadId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHeadId",
			new String[] { Long.class.getName() },
			ContentModelImpl.HEADID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HEADID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHeadId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contents where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByHeadId(long headID) throws SystemException {
		return findByHeadId(headID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByHeadId(long headID, int start, int end)
		throws SystemException {
		return findByHeadId(headID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where headID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param headID the head i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByHeadId(long headID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID;
			finderArgs = new Object[] { headID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HEADID;
			finderArgs = new Object[] { headID, start, end, orderByComparator };
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((headID != content.getHeadID())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByHeadId_First(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByHeadId_First(headID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByHeadId_First(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByHeadId(headID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByHeadId_Last(long headID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByHeadId_Last(headID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("headID=");
		msg.append(headID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByHeadId_Last(long headID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByHeadId(headID);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByHeadId(headID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where headID = &#63;.
	 *
	 * @param contentID the primary key of the current content
	 * @param headID the head i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByHeadId_PrevAndNext(long contentID, long headID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(contentID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByHeadId_PrevAndNext(session, content, headID,
					orderByComparator, true);

			array[1] = content;

			array[2] = getByHeadId_PrevAndNext(session, content, headID,
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

	protected Content getByHeadId_PrevAndNext(Session session, Content content,
		long headID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_HEADID_HEADID_2);

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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(headID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where headID = &#63; from the database.
	 *
	 * @param headID the head i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHeadId(long headID) throws SystemException {
		for (Content content : findByHeadId(headID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where headID = &#63;.
	 *
	 * @param headID the head i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHeadId(long headID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HEADID;

		Object[] finderArgs = new Object[] { headID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_HEADID_HEADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(headID);

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

	private static final String _FINDER_COLUMN_HEADID_HEADID_2 = "content.headID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMNID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByColumnId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByColumnId",
			new String[] { Long.class.getName() },
			ContentModelImpl.COLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMNID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByColumnId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contents where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByColumnId(long columnID)
		throws SystemException {
		return findByColumnId(columnID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contents where columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param columnID the column i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByColumnId(long columnID, int start, int end)
		throws SystemException {
		return findByColumnId(columnID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param columnID the column i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByColumnId(long columnID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID;
			finderArgs = new Object[] { columnID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLUMNID;
			finderArgs = new Object[] { columnID, start, end, orderByComparator };
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((columnID != content.getColumnID())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByColumnId_First(long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByColumnId_First(columnID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByColumnId_First(long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByColumnId(columnID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByColumnId_Last(long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByColumnId_Last(columnID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByColumnId_Last(long columnID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByColumnId(columnID);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByColumnId(columnID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where columnID = &#63;.
	 *
	 * @param contentID the primary key of the current content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByColumnId_PrevAndNext(long contentID, long columnID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(contentID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByColumnId_PrevAndNext(session, content, columnID,
					orderByComparator, true);

			array[1] = content;

			array[2] = getByColumnId_PrevAndNext(session, content, columnID,
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

	protected Content getByColumnId_PrevAndNext(Session session,
		Content content, long columnID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(columnID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where columnID = &#63; from the database.
	 *
	 * @param columnID the column i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByColumnId(long columnID) throws SystemException {
		for (Content content : findByColumnId(columnID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where columnID = &#63;.
	 *
	 * @param columnID the column i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByColumnId(long columnID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COLUMNID;

		Object[] finderArgs = new Object[] { columnID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnID);

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

	private static final String _FINDER_COLUMN_COLUMNID_COLUMNID_2 = "content.columnID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROWID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRowId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRowId",
			new String[] { Long.class.getName() },
			ContentModelImpl.ROWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROWID = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRowId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contents where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByRowId(long rowID) throws SystemException {
		return findByRowId(rowID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where rowID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rowID the row i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByRowId(long rowID, int start, int end)
		throws SystemException {
		return findByRowId(rowID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where rowID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param rowID the row i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByRowId(long rowID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID;
			finderArgs = new Object[] { rowID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROWID;
			finderArgs = new Object[] { rowID, start, end, orderByComparator };
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if ((rowID != content.getRowID())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_ROWID_ROWID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowID);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByRowId_First(long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByRowId_First(rowID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rowID=");
		msg.append(rowID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByRowId_First(long rowID,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByRowId(rowID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByRowId_Last(long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByRowId_Last(rowID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rowID=");
		msg.append(rowID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByRowId_Last(long rowID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRowId(rowID);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByRowId(rowID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where rowID = &#63;.
	 *
	 * @param contentID the primary key of the current content
	 * @param rowID the row i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByRowId_PrevAndNext(long contentID, long rowID,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(contentID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByRowId_PrevAndNext(session, content, rowID,
					orderByComparator, true);

			array[1] = content;

			array[2] = getByRowId_PrevAndNext(session, content, rowID,
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

	protected Content getByRowId_PrevAndNext(Session session, Content content,
		long rowID, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		query.append(_FINDER_COLUMN_ROWID_ROWID_2);

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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rowID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where rowID = &#63; from the database.
	 *
	 * @param rowID the row i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRowId(long rowID) throws SystemException {
		for (Content content : findByRowId(rowID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where rowID = &#63;.
	 *
	 * @param rowID the row i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRowId(long rowID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROWID;

		Object[] finderArgs = new Object[] { rowID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			query.append(_FINDER_COLUMN_ROWID_ROWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowID);

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

	private static final String _FINDER_COLUMN_ROWID_ROWID_2 = "content.rowID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLCONTENT =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCellContent",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENT =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCellContent",
			new String[] { String.class.getName() },
			ContentModelImpl.CELLCONTENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CELLCONTENT = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCellContent",
			new String[] { String.class.getName() });

	/**
	 * Returns all the contents where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContent(String cellContent)
		throws SystemException {
		return findByCellContent(cellContent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where cellContent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellContent the cell content
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContent(String cellContent, int start,
		int end) throws SystemException {
		return findByCellContent(cellContent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where cellContent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellContent the cell content
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContent(String cellContent, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENT;
			finderArgs = new Object[] { cellContent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLCONTENT;
			finderArgs = new Object[] { cellContent, start, end, orderByComparator };
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if (!Validator.equals(cellContent, content.getCellContent())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			boolean bindCellContent = false;

			if (cellContent == null) {
				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_1);
			}
			else if (cellContent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_3);
			}
			else {
				bindCellContent = true;

				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCellContent) {
					qPos.add(cellContent);
				}

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByCellContent_First(String cellContent,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByCellContent_First(cellContent,
				orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellContent=");
		msg.append(cellContent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByCellContent_First(String cellContent,
		OrderByComparator orderByComparator) throws SystemException {
		List<Content> list = findByCellContent(cellContent, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByCellContent_Last(String cellContent,
		OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByCellContent_Last(cellContent, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellContent=");
		msg.append(cellContent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByCellContent_Last(String cellContent,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCellContent(cellContent);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByCellContent(cellContent, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where cellContent = &#63;.
	 *
	 * @param contentID the primary key of the current content
	 * @param cellContent the cell content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByCellContent_PrevAndNext(long contentID,
		String cellContent, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(contentID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByCellContent_PrevAndNext(session, content,
					cellContent, orderByComparator, true);

			array[1] = content;

			array[2] = getByCellContent_PrevAndNext(session, content,
					cellContent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByCellContent_PrevAndNext(Session session,
		Content content, String cellContent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		boolean bindCellContent = false;

		if (cellContent == null) {
			query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_1);
		}
		else if (cellContent.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_3);
		}
		else {
			bindCellContent = true;

			query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_2);
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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCellContent) {
			qPos.add(cellContent);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where cellContent = &#63; from the database.
	 *
	 * @param cellContent the cell content
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCellContent(String cellContent)
		throws SystemException {
		for (Content content : findByCellContent(cellContent,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where cellContent = &#63;.
	 *
	 * @param cellContent the cell content
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCellContent(String cellContent) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CELLCONTENT;

		Object[] finderArgs = new Object[] { cellContent };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			boolean bindCellContent = false;

			if (cellContent == null) {
				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_1);
			}
			else if (cellContent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_3);
			}
			else {
				bindCellContent = true;

				query.append(_FINDER_COLUMN_CELLCONTENT_CELLCONTENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCellContent) {
					qPos.add(cellContent);
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

	private static final String _FINDER_COLUMN_CELLCONTENT_CELLCONTENT_1 = "content.cellContent IS NULL";
	private static final String _FINDER_COLUMN_CELLCONTENT_CELLCONTENT_2 = "content.cellContent = ?";
	private static final String _FINDER_COLUMN_CELLCONTENT_CELLCONTENT_3 = "(content.cellContent IS NULL OR content.cellContent = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCellContentOfColumn",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN =
		new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, ContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCellContentOfColumn",
			new String[] { String.class.getName(), Long.class.getName() },
			ContentModelImpl.CELLCONTENT_COLUMN_BITMASK |
			ContentModelImpl.COLUMNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CELLCONTENTOFCOLUMN = new FinderPath(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCellContentOfColumn",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contents where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @return the matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContentOfColumn(String cellContent,
		long columnID) throws SystemException {
		return findByCellContentOfColumn(cellContent, columnID,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents where cellContent = &#63; and columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContentOfColumn(String cellContent,
		long columnID, int start, int end) throws SystemException {
		return findByCellContentOfColumn(cellContent, columnID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents where cellContent = &#63; and columnID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findByCellContentOfColumn(String cellContent,
		long columnID, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN;
			finderArgs = new Object[] { cellContent, columnID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN;
			finderArgs = new Object[] {
					cellContent, columnID,
					
					start, end, orderByComparator
				};
		}

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Content content : list) {
				if (!Validator.equals(cellContent, content.getCellContent()) ||
						(columnID != content.getColumnID())) {
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

			query.append(_SQL_SELECT_CONTENT_WHERE);

			boolean bindCellContent = false;

			if (cellContent == null) {
				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_1);
			}
			else if (cellContent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_3);
			}
			else {
				bindCellContent = true;

				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_2);
			}

			query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_COLUMNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCellContent) {
					qPos.add(cellContent);
				}

				qPos.add(columnID);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first content in the ordered set where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByCellContentOfColumn_First(String cellContent,
		long columnID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByCellContentOfColumn_First(cellContent,
				columnID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellContent=");
		msg.append(cellContent);

		msg.append(", columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the first content in the ordered set where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByCellContentOfColumn_First(String cellContent,
		long columnID, OrderByComparator orderByComparator)
		throws SystemException {
		List<Content> list = findByCellContentOfColumn(cellContent, columnID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last content in the ordered set where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content
	 * @throws org.gfbio.NoSuchContentException if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByCellContentOfColumn_Last(String cellContent,
		long columnID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = fetchByCellContentOfColumn_Last(cellContent,
				columnID, orderByComparator);

		if (content != null) {
			return content;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cellContent=");
		msg.append(cellContent);

		msg.append(", columnID=");
		msg.append(columnID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContentException(msg.toString());
	}

	/**
	 * Returns the last content in the ordered set where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching content, or <code>null</code> if a matching content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByCellContentOfColumn_Last(String cellContent,
		long columnID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCellContentOfColumn(cellContent, columnID);

		if (count == 0) {
			return null;
		}

		List<Content> list = findByCellContentOfColumn(cellContent, columnID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contents before and after the current content in the ordered set where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param contentID the primary key of the current content
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content[] findByCellContentOfColumn_PrevAndNext(long contentID,
		String cellContent, long columnID, OrderByComparator orderByComparator)
		throws NoSuchContentException, SystemException {
		Content content = findByPrimaryKey(contentID);

		Session session = null;

		try {
			session = openSession();

			Content[] array = new ContentImpl[3];

			array[0] = getByCellContentOfColumn_PrevAndNext(session, content,
					cellContent, columnID, orderByComparator, true);

			array[1] = content;

			array[2] = getByCellContentOfColumn_PrevAndNext(session, content,
					cellContent, columnID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Content getByCellContentOfColumn_PrevAndNext(Session session,
		Content content, String cellContent, long columnID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTENT_WHERE);

		boolean bindCellContent = false;

		if (cellContent == null) {
			query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_1);
		}
		else if (cellContent.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_3);
		}
		else {
			bindCellContent = true;

			query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_2);
		}

		query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_COLUMNID_2);

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
			query.append(ContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCellContent) {
			qPos.add(cellContent);
		}

		qPos.add(columnID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(content);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Content> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contents where cellContent = &#63; and columnID = &#63; from the database.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCellContentOfColumn(String cellContent, long columnID)
		throws SystemException {
		for (Content content : findByCellContentOfColumn(cellContent, columnID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents where cellContent = &#63; and columnID = &#63;.
	 *
	 * @param cellContent the cell content
	 * @param columnID the column i d
	 * @return the number of matching contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCellContentOfColumn(String cellContent, long columnID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CELLCONTENTOFCOLUMN;

		Object[] finderArgs = new Object[] { cellContent, columnID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTENT_WHERE);

			boolean bindCellContent = false;

			if (cellContent == null) {
				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_1);
			}
			else if (cellContent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_3);
			}
			else {
				bindCellContent = true;

				query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_2);
			}

			query.append(_FINDER_COLUMN_CELLCONTENTOFCOLUMN_COLUMNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCellContent) {
					qPos.add(cellContent);
				}

				qPos.add(columnID);

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

	private static final String _FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_1 =
		"content.cellContent IS NULL AND ";
	private static final String _FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_2 =
		"content.cellContent = ? AND ";
	private static final String _FINDER_COLUMN_CELLCONTENTOFCOLUMN_CELLCONTENT_3 =
		"(content.cellContent IS NULL OR content.cellContent = '') AND ";
	private static final String _FINDER_COLUMN_CELLCONTENTOFCOLUMN_COLUMNID_2 = "content.columnID = ?";

	public ContentPersistenceImpl() {
		setModelClass(Content.class);
	}

	/**
	 * Caches the content in the entity cache if it is enabled.
	 *
	 * @param content the content
	 */
	@Override
	public void cacheResult(Content content) {
		EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey(), content);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENTID,
			new Object[] { content.getContentID() }, content);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS,
			new Object[] { content.getColumnID(), content.getRowID() }, content);

		content.resetOriginalValues();
	}

	/**
	 * Caches the contents in the entity cache if it is enabled.
	 *
	 * @param contents the contents
	 */
	@Override
	public void cacheResult(List<Content> contents) {
		for (Content content : contents) {
			if (EntityCacheUtil.getResult(
						ContentModelImpl.ENTITY_CACHE_ENABLED,
						ContentImpl.class, content.getPrimaryKey()) == null) {
				cacheResult(content);
			}
			else {
				content.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Content content) {
		EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(content);
	}

	@Override
	public void clearCache(List<Content> contents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Content content : contents) {
			EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
				ContentImpl.class, content.getPrimaryKey());

			clearUniqueFindersCache(content);
		}
	}

	protected void cacheUniqueFindersCache(Content content) {
		if (content.isNew()) {
			Object[] args = new Object[] { content.getContentID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENTID, args,
				content);

			args = new Object[] { content.getColumnID(), content.getRowID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TABLEIDS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS, args,
				content);
		}
		else {
			ContentModelImpl contentModelImpl = (ContentModelImpl)content;

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { content.getContentID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTENTID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTENTID, args,
					content);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TABLEIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						content.getColumnID(), content.getRowID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TABLEIDS, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TABLEIDS, args,
					content);
			}
		}
	}

	protected void clearUniqueFindersCache(Content content) {
		ContentModelImpl contentModelImpl = (ContentModelImpl)content;

		Object[] args = new Object[] { content.getContentID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENTID, args);

		if ((contentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTENTID.getColumnBitmask()) != 0) {
			args = new Object[] { contentModelImpl.getOriginalContentID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTENTID, args);
		}

		args = new Object[] { content.getColumnID(), content.getRowID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TABLEIDS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS, args);

		if ((contentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TABLEIDS.getColumnBitmask()) != 0) {
			args = new Object[] {
					contentModelImpl.getOriginalColumnID(),
					contentModelImpl.getOriginalRowID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TABLEIDS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TABLEIDS, args);
		}
	}

	/**
	 * Creates a new content with the primary key. Does not add the content to the database.
	 *
	 * @param contentID the primary key for the new content
	 * @return the new content
	 */
	@Override
	public Content create(long contentID) {
		Content content = new ContentImpl();

		content.setNew(true);
		content.setPrimaryKey(contentID);

		return content;
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentID the primary key of the content
	 * @return the content that was removed
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content remove(long contentID)
		throws NoSuchContentException, SystemException {
		return remove((Serializable)contentID);
	}

	/**
	 * Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content that was removed
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content remove(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Content content = (Content)session.get(ContentImpl.class, primaryKey);

			if (content == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(content);
		}
		catch (NoSuchContentException nsee) {
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
	protected Content removeImpl(Content content) throws SystemException {
		content = toUnwrappedModel(content);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(content)) {
				content = (Content)session.get(ContentImpl.class,
						content.getPrimaryKeyObj());
			}

			if (content != null) {
				session.delete(content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (content != null) {
			clearCache(content);
		}

		return content;
	}

	@Override
	public Content updateImpl(org.gfbio.model.Content content)
		throws SystemException {
		content = toUnwrappedModel(content);

		boolean isNew = content.isNew();

		ContentModelImpl contentModelImpl = (ContentModelImpl)content;

		Session session = null;

		try {
			session = openSession();

			if (content.isNew()) {
				session.save(content);

				content.setNew(false);
			}
			else {
				session.merge(content);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalHeadID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);

				args = new Object[] { contentModelImpl.getHeadID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HEADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HEADID,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID,
					args);

				args = new Object[] { contentModelImpl.getColumnID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COLUMNID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COLUMNID,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { contentModelImpl.getOriginalRowID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROWID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID,
					args);

				args = new Object[] { contentModelImpl.getRowID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROWID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROWID,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalCellContent()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLCONTENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENT,
					args);

				args = new Object[] { contentModelImpl.getCellContent() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLCONTENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENT,
					args);
			}

			if ((contentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contentModelImpl.getOriginalCellContent(),
						contentModelImpl.getOriginalColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLCONTENTOFCOLUMN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN,
					args);

				args = new Object[] {
						contentModelImpl.getCellContent(),
						contentModelImpl.getColumnID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CELLCONTENTOFCOLUMN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CELLCONTENTOFCOLUMN,
					args);
			}
		}

		EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
			ContentImpl.class, content.getPrimaryKey(), content);

		clearUniqueFindersCache(content);
		cacheUniqueFindersCache(content);

		return content;
	}

	protected Content toUnwrappedModel(Content content) {
		if (content instanceof ContentImpl) {
			return content;
		}

		ContentImpl contentImpl = new ContentImpl();

		contentImpl.setNew(content.isNew());
		contentImpl.setPrimaryKey(content.getPrimaryKey());

		contentImpl.setContentID(content.getContentID());
		contentImpl.setHeadID(content.getHeadID());
		contentImpl.setColumnID(content.getColumnID());
		contentImpl.setRowID(content.getRowID());
		contentImpl.setCellContent(content.getCellContent());
		contentImpl.setLastModifiedDate(content.getLastModifiedDate());

		return contentImpl;
	}

	/**
	 * Returns the content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentException, SystemException {
		Content content = fetchByPrimaryKey(primaryKey);

		if (content == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return content;
	}

	/**
	 * Returns the content with the primary key or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	 *
	 * @param contentID the primary key of the content
	 * @return the content
	 * @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content findByPrimaryKey(long contentID)
		throws NoSuchContentException, SystemException {
		return findByPrimaryKey((Serializable)contentID);
	}

	/**
	 * Returns the content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content
	 * @return the content, or <code>null</code> if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Content content = (Content)EntityCacheUtil.getResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
				ContentImpl.class, primaryKey);

		if (content == _nullContent) {
			return null;
		}

		if (content == null) {
			Session session = null;

			try {
				session = openSession();

				content = (Content)session.get(ContentImpl.class, primaryKey);

				if (content != null) {
					cacheResult(content);
				}
				else {
					EntityCacheUtil.putResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
						ContentImpl.class, primaryKey, _nullContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContentModelImpl.ENTITY_CACHE_ENABLED,
					ContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return content;
	}

	/**
	 * Returns the content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contentID the primary key of the content
	 * @return the content, or <code>null</code> if a content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Content fetchByPrimaryKey(long contentID) throws SystemException {
		return fetchByPrimaryKey((Serializable)contentID);
	}

	/**
	 * Returns all the contents.
	 *
	 * @return the contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @return the range of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contents
	 * @param end the upper bound of the range of contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Content> findAll(int start, int end,
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

		List<Content> list = (List<Content>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENT;

				if (pagination) {
					sql = sql.concat(ContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Content>(list);
				}
				else {
					list = (List<Content>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Content content : findAll()) {
			remove(content);
		}
	}

	/**
	 * Returns the number of contents.
	 *
	 * @return the number of contents
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

				Query q = session.createQuery(_SQL_COUNT_CONTENT);

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
	 * Initializes the content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.Content")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Content>> listenersList = new ArrayList<ModelListener<Content>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Content>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTENT = "SELECT content FROM Content content";
	private static final String _SQL_SELECT_CONTENT_WHERE = "SELECT content FROM Content content WHERE ";
	private static final String _SQL_COUNT_CONTENT = "SELECT COUNT(content) FROM Content content";
	private static final String _SQL_COUNT_CONTENT_WHERE = "SELECT COUNT(content) FROM Content content WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "content.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Content exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Content exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static Content _nullContent = new ContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Content> toCacheModel() {
				return _nullContentCacheModel;
			}
		};

	private static CacheModel<Content> _nullContentCacheModel = new CacheModel<Content>() {
			@Override
			public Content toEntityModel() {
				return _nullContent;
			}
		};
}