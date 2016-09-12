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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchUserSSOException;

import org.gfbio.model.UserSSO;
import org.gfbio.model.impl.UserSSOImpl;
import org.gfbio.model.impl.UserSSOModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the user s s o service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see UserSSOPersistence
 * @see UserSSOUtil
 * @generated
 */
public class UserSSOPersistenceImpl extends BasePersistenceImpl<UserSSO>
	implements UserSSOPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserSSOUtil} to access the user s s o persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserSSOImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, UserSSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, UserSSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, UserSSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserID",
			new String[] { Long.class.getName() },
			UserSSOModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	 *
	 * @param userID the user i d
	 * @return the matching user s s o
	 * @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO findByUserID(long userID)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = fetchByUserID(userID);

		if (userSSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSSOException(msg.toString());
		}

		return userSSO;
	}

	/**
	 * Returns the user s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userID the user i d
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByUserID(long userID) throws SystemException {
		return fetchByUserID(userID, true);
	}

	/**
	 * Returns the user s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByUserID(long userID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserSSO) {
			UserSSO userSSO = (UserSSO)result;

			if ((userID != userSSO.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERSSO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				List<UserSSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSSOPersistenceImpl.fetchByUserID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSSO userSSO = list.get(0);

					result = userSSO;

					cacheResult(userSSO);

					if ((userSSO.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userSSO);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
			return (UserSSO)result;
		}
	}

	/**
	 * Removes the user s s o where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @return the user s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO removeByUserID(long userID)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = findByUserID(userID);

		return remove(userSSO);
	}

	/**
	 * Returns the number of user s s os where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching user s s os
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

			query.append(_SQL_COUNT_USERSSO_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userSSO.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, UserSSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByToken",
			new String[] { String.class.getName() },
			UserSSOModelImpl.TOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
			new String[] { String.class.getName() });

	/**
	 * Returns the user s s o where token = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	 *
	 * @param token the token
	 * @return the matching user s s o
	 * @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO findByToken(String token)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = fetchByToken(token);

		if (userSSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("token=");
			msg.append(token);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSSOException(msg.toString());
		}

		return userSSO;
	}

	/**
	 * Returns the user s s o where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByToken(String token) throws SystemException {
		return fetchByToken(token, true);
	}

	/**
	 * Returns the user s s o where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByToken(String token, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { token };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
					finderArgs, this);
		}

		if (result instanceof UserSSO) {
			UserSSO userSSO = (UserSSO)result;

			if (!Validator.equals(token, userSSO.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERSSO_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToken) {
					qPos.add(token);
				}

				List<UserSSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSSOPersistenceImpl.fetchByToken(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSSO userSSO = list.get(0);

					result = userSSO;

					cacheResult(userSSO);

					if ((userSSO.getToken() == null) ||
							!userSSO.getToken().equals(token)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
							finderArgs, userSSO);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN,
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
			return (UserSSO)result;
		}
	}

	/**
	 * Removes the user s s o where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the user s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO removeByToken(String token)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = findByToken(token);

		return remove(userSSO);
	}

	/**
	 * Returns the number of user s s os where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching user s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByToken(String token) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOKEN;

		Object[] finderArgs = new Object[] { token };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSSO_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TOKEN_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_TOKEN_TOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToken) {
					qPos.add(token);
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

	private static final String _FINDER_COLUMN_TOKEN_TOKEN_1 = "userSSO.token IS NULL";
	private static final String _FINDER_COLUMN_TOKEN_TOKEN_2 = "userSSO.token = ?";
	private static final String _FINDER_COLUMN_TOKEN_TOKEN_3 = "(userSSO.token IS NULL OR userSSO.token = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, UserSSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLastModifiedDate",
			new String[] { Date.class.getName() },
			UserSSOModelImpl.LASTMODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE = new FinderPath(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLastModifiedDate", new String[] { Date.class.getName() });

	/**
	 * Returns the user s s o where lastModifiedDate = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the matching user s s o
	 * @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO findByLastModifiedDate(Date lastModifiedDate)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = fetchByLastModifiedDate(lastModifiedDate);

		if (userSSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lastModifiedDate=");
			msg.append(lastModifiedDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserSSOException(msg.toString());
		}

		return userSSO;
	}

	/**
	 * Returns the user s s o where lastModifiedDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByLastModifiedDate(Date lastModifiedDate)
		throws SystemException {
		return fetchByLastModifiedDate(lastModifiedDate, true);
	}

	/**
	 * Returns the user s s o where lastModifiedDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lastModifiedDate the last modified date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByLastModifiedDate(Date lastModifiedDate,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { lastModifiedDate };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
					finderArgs, this);
		}

		if (result instanceof UserSSO) {
			UserSSO userSSO = (UserSSO)result;

			if (!Validator.equals(lastModifiedDate,
						userSSO.getLastModifiedDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERSSO_WHERE);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
				}

				List<UserSSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserSSOPersistenceImpl.fetchByLastModifiedDate(Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserSSO userSSO = list.get(0);

					result = userSSO;

					cacheResult(userSSO);

					if ((userSSO.getLastModifiedDate() == null) ||
							!userSSO.getLastModifiedDate()
										.equals(lastModifiedDate)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
							finderArgs, userSSO);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
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
			return (UserSSO)result;
		}
	}

	/**
	 * Removes the user s s o where lastModifiedDate = &#63; from the database.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the user s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO removeByLastModifiedDate(Date lastModifiedDate)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = findByLastModifiedDate(lastModifiedDate);

		return remove(userSSO);
	}

	/**
	 * Returns the number of user s s os where lastModifiedDate = &#63;.
	 *
	 * @param lastModifiedDate the last modified date
	 * @return the number of matching user s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLastModifiedDate(Date lastModifiedDate)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE;

		Object[] finderArgs = new Object[] { lastModifiedDate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERSSO_WHERE);

			boolean bindLastModifiedDate = false;

			if (lastModifiedDate == null) {
				query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_1);
			}
			else {
				bindLastModifiedDate = true;

				query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastModifiedDate) {
					qPos.add(CalendarUtil.getTimestamp(lastModifiedDate));
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

	private static final String _FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_1 =
		"userSSO.lastModifiedDate IS NULL";
	private static final String _FINDER_COLUMN_LASTMODIFIEDDATE_LASTMODIFIEDDATE_2 =
		"userSSO.lastModifiedDate = ?";

	public UserSSOPersistenceImpl() {
		setModelClass(UserSSO.class);
	}

	/**
	 * Caches the user s s o in the entity cache if it is enabled.
	 *
	 * @param userSSO the user s s o
	 */
	@Override
	public void cacheResult(UserSSO userSSO) {
		EntityCacheUtil.putResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOImpl.class, userSSO.getPrimaryKey(), userSSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userSSO.getUserID() }, userSSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
			new Object[] { userSSO.getToken() }, userSSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
			new Object[] { userSSO.getLastModifiedDate() }, userSSO);

		userSSO.resetOriginalValues();
	}

	/**
	 * Caches the user s s os in the entity cache if it is enabled.
	 *
	 * @param userSSOs the user s s os
	 */
	@Override
	public void cacheResult(List<UserSSO> userSSOs) {
		for (UserSSO userSSO : userSSOs) {
			if (EntityCacheUtil.getResult(
						UserSSOModelImpl.ENTITY_CACHE_ENABLED,
						UserSSOImpl.class, userSSO.getPrimaryKey()) == null) {
				cacheResult(userSSO);
			}
			else {
				userSSO.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user s s os.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserSSOImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserSSOImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user s s o.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSSO userSSO) {
		EntityCacheUtil.removeResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOImpl.class, userSSO.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userSSO);
	}

	@Override
	public void clearCache(List<UserSSO> userSSOs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSSO userSSO : userSSOs) {
			EntityCacheUtil.removeResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
				UserSSOImpl.class, userSSO.getPrimaryKey());

			clearUniqueFindersCache(userSSO);
		}
	}

	protected void cacheUniqueFindersCache(UserSSO userSSO) {
		if (userSSO.isNew()) {
			Object[] args = new Object[] { userSSO.getUserID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args, userSSO);

			args = new Object[] { userSSO.getToken() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args, userSSO);

			args = new Object[] { userSSO.getLastModifiedDate() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
				args, userSSO);
		}
		else {
			UserSSOModelImpl userSSOModelImpl = (UserSSOModelImpl)userSSO;

			if ((userSSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userSSO.getUserID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					userSSO);
			}

			if ((userSSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userSSO.getToken() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
					userSSO);
			}

			if ((userSSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userSSO.getLastModifiedDate() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
					args, userSSO);
			}
		}
	}

	protected void clearUniqueFindersCache(UserSSO userSSO) {
		UserSSOModelImpl userSSOModelImpl = (UserSSOModelImpl)userSSO;

		Object[] args = new Object[] { userSSO.getUserID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((userSSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { userSSOModelImpl.getOriginalUserID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		args = new Object[] { userSSO.getToken() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

		if ((userSSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
			args = new Object[] { userSSOModelImpl.getOriginalToken() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
		}

		args = new Object[] { userSSO.getLastModifiedDate() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE, args);

		if ((userSSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE.getColumnBitmask()) != 0) {
			args = new Object[] { userSSOModelImpl.getOriginalLastModifiedDate() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
				args);
		}
	}

	/**
	 * Creates a new user s s o with the primary key. Does not add the user s s o to the database.
	 *
	 * @param userID the primary key for the new user s s o
	 * @return the new user s s o
	 */
	@Override
	public UserSSO create(long userID) {
		UserSSO userSSO = new UserSSOImpl();

		userSSO.setNew(true);
		userSSO.setPrimaryKey(userID);

		return userSSO;
	}

	/**
	 * Removes the user s s o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userID the primary key of the user s s o
	 * @return the user s s o that was removed
	 * @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO remove(long userID)
		throws NoSuchUserSSOException, SystemException {
		return remove((Serializable)userID);
	}

	/**
	 * Removes the user s s o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user s s o
	 * @return the user s s o that was removed
	 * @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO remove(Serializable primaryKey)
		throws NoSuchUserSSOException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserSSO userSSO = (UserSSO)session.get(UserSSOImpl.class, primaryKey);

			if (userSSO == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserSSOException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSSO);
		}
		catch (NoSuchUserSSOException nsee) {
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
	protected UserSSO removeImpl(UserSSO userSSO) throws SystemException {
		userSSO = toUnwrappedModel(userSSO);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userSSO)) {
				userSSO = (UserSSO)session.get(UserSSOImpl.class,
						userSSO.getPrimaryKeyObj());
			}

			if (userSSO != null) {
				session.delete(userSSO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userSSO != null) {
			clearCache(userSSO);
		}

		return userSSO;
	}

	@Override
	public UserSSO updateImpl(org.gfbio.model.UserSSO userSSO)
		throws SystemException {
		userSSO = toUnwrappedModel(userSSO);

		boolean isNew = userSSO.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userSSO.isNew()) {
				session.save(userSSO);

				userSSO.setNew(false);
			}
			else {
				session.merge(userSSO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserSSOModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
			UserSSOImpl.class, userSSO.getPrimaryKey(), userSSO);

		clearUniqueFindersCache(userSSO);
		cacheUniqueFindersCache(userSSO);

		return userSSO;
	}

	protected UserSSO toUnwrappedModel(UserSSO userSSO) {
		if (userSSO instanceof UserSSOImpl) {
			return userSSO;
		}

		UserSSOImpl userSSOImpl = new UserSSOImpl();

		userSSOImpl.setNew(userSSO.isNew());
		userSSOImpl.setPrimaryKey(userSSO.getPrimaryKey());

		userSSOImpl.setUserID(userSSO.getUserID());
		userSSOImpl.setToken(userSSO.getToken());
		userSSOImpl.setLastModifiedDate(userSSO.getLastModifiedDate());

		return userSSOImpl;
	}

	/**
	 * Returns the user s s o with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user s s o
	 * @return the user s s o
	 * @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserSSOException, SystemException {
		UserSSO userSSO = fetchByPrimaryKey(primaryKey);

		if (userSSO == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserSSOException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userSSO;
	}

	/**
	 * Returns the user s s o with the primary key or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	 *
	 * @param userID the primary key of the user s s o
	 * @return the user s s o
	 * @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO findByPrimaryKey(long userID)
		throws NoSuchUserSSOException, SystemException {
		return findByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns the user s s o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user s s o
	 * @return the user s s o, or <code>null</code> if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserSSO userSSO = (UserSSO)EntityCacheUtil.getResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
				UserSSOImpl.class, primaryKey);

		if (userSSO == _nullUserSSO) {
			return null;
		}

		if (userSSO == null) {
			Session session = null;

			try {
				session = openSession();

				userSSO = (UserSSO)session.get(UserSSOImpl.class, primaryKey);

				if (userSSO != null) {
					cacheResult(userSSO);
				}
				else {
					EntityCacheUtil.putResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
						UserSSOImpl.class, primaryKey, _nullUserSSO);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserSSOModelImpl.ENTITY_CACHE_ENABLED,
					UserSSOImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userSSO;
	}

	/**
	 * Returns the user s s o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userID the primary key of the user s s o
	 * @return the user s s o, or <code>null</code> if a user s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSSO fetchByPrimaryKey(long userID) throws SystemException {
		return fetchByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns all the user s s os.
	 *
	 * @return the user s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSSO> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user s s os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user s s os
	 * @param end the upper bound of the range of user s s os (not inclusive)
	 * @return the range of user s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSSO> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user s s os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user s s os
	 * @param end the upper bound of the range of user s s os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserSSO> findAll(int start, int end,
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

		List<UserSSO> list = (List<UserSSO>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSSO;

				if (pagination) {
					sql = sql.concat(UserSSOModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserSSO>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserSSO>(list);
				}
				else {
					list = (List<UserSSO>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user s s os from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserSSO userSSO : findAll()) {
			remove(userSSO);
		}
	}

	/**
	 * Returns the number of user s s os.
	 *
	 * @return the number of user s s os
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

				Query q = session.createQuery(_SQL_COUNT_USERSSO);

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
	 * Initializes the user s s o persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.UserSSO")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserSSO>> listenersList = new ArrayList<ModelListener<UserSSO>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserSSO>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserSSOImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERSSO = "SELECT userSSO FROM UserSSO userSSO";
	private static final String _SQL_SELECT_USERSSO_WHERE = "SELECT userSSO FROM UserSSO userSSO WHERE ";
	private static final String _SQL_COUNT_USERSSO = "SELECT COUNT(userSSO) FROM UserSSO userSSO";
	private static final String _SQL_COUNT_USERSSO_WHERE = "SELECT COUNT(userSSO) FROM UserSSO userSSO WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSSO.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSSO exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserSSO exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserSSOPersistenceImpl.class);
	private static UserSSO _nullUserSSO = new UserSSOImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSSO> toCacheModel() {
				return _nullUserSSOCacheModel;
			}
		};

	private static CacheModel<UserSSO> _nullUserSSOCacheModel = new CacheModel<UserSSO>() {
			@Override
			public UserSSO toEntityModel() {
				return _nullUserSSO;
			}
		};
}