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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gfbio.NoSuchUser_SSOException;

import org.gfbio.model.User_SSO;
import org.gfbio.model.impl.User_SSOImpl;
import org.gfbio.model.impl.User_SSOModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user_ s s o service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see User_SSOPersistence
 * @see User_SSOUtil
 * @generated
 */
public class User_SSOPersistenceImpl extends BasePersistenceImpl<User_SSO>
	implements User_SSOPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link User_SSOUtil} to access the user_ s s o persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = User_SSOImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, User_SSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, User_SSOImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, User_SSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserID",
			new String[] { String.class.getName() },
			User_SSOModelImpl.TOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { String.class.getName() });

	/**
	 * Returns the user_ s s o where token = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	 *
	 * @param token the token
	 * @return the matching user_ s s o
	 * @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO findByUserID(String token)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = fetchByUserID(token);

		if (user_SSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("token=");
			msg.append(token);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUser_SSOException(msg.toString());
		}

		return user_SSO;
	}

	/**
	 * Returns the user_ s s o where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByUserID(String token) throws SystemException {
		return fetchByUserID(token, true);
	}

	/**
	 * Returns the user_ s s o where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByUserID(String token, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { token };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof User_SSO) {
			User_SSO user_SSO = (User_SSO)result;

			if (!Validator.equals(token, user_SSO.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USER_SSO_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_USERID_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_USERID_TOKEN_2);
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

				List<User_SSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"User_SSOPersistenceImpl.fetchByUserID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					User_SSO user_SSO = list.get(0);

					result = user_SSO;

					cacheResult(user_SSO);

					if ((user_SSO.getToken() == null) ||
							!user_SSO.getToken().equals(token)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, user_SSO);
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
			return (User_SSO)result;
		}
	}

	/**
	 * Removes the user_ s s o where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the user_ s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO removeByUserID(String token)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = findByUserID(token);

		return remove(user_SSO);
	}

	/**
	 * Returns the number of user_ s s os where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserID(String token) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { token };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USER_SSO_WHERE);

			boolean bindToken = false;

			if (token == null) {
				query.append(_FINDER_COLUMN_USERID_TOKEN_1);
			}
			else if (token.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_TOKEN_3);
			}
			else {
				bindToken = true;

				query.append(_FINDER_COLUMN_USERID_TOKEN_2);
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

	private static final String _FINDER_COLUMN_USERID_TOKEN_1 = "user_SSO.token IS NULL";
	private static final String _FINDER_COLUMN_USERID_TOKEN_2 = "user_SSO.token = ?";
	private static final String _FINDER_COLUMN_USERID_TOKEN_3 = "(user_SSO.token IS NULL OR user_SSO.token = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TOKEN = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, User_SSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByToken",
			new String[] { Long.class.getName() },
			User_SSOModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TOKEN = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToken",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user_ s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	 *
	 * @param userID the user i d
	 * @return the matching user_ s s o
	 * @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO findByToken(long userID)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = fetchByToken(userID);

		if (user_SSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUser_SSOException(msg.toString());
		}

		return user_SSO;
	}

	/**
	 * Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userID the user i d
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByToken(long userID) throws SystemException {
		return fetchByToken(userID, true);
	}

	/**
	 * Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByToken(long userID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TOKEN,
					finderArgs, this);
		}

		if (result instanceof User_SSO) {
			User_SSO user_SSO = (User_SSO)result;

			if ((userID != user_SSO.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USER_SSO_WHERE);

			query.append(_FINDER_COLUMN_TOKEN_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				List<User_SSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"User_SSOPersistenceImpl.fetchByToken(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					User_SSO user_SSO = list.get(0);

					result = user_SSO;

					cacheResult(user_SSO);

					if ((user_SSO.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
							finderArgs, user_SSO);
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
			return (User_SSO)result;
		}
	}

	/**
	 * Removes the user_ s s o where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @return the user_ s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO removeByToken(long userID)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = findByToken(userID);

		return remove(user_SSO);
	}

	/**
	 * Returns the number of user_ s s os where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByToken(long userID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TOKEN;

		Object[] finderArgs = new Object[] { userID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USER_SSO_WHERE);

			query.append(_FINDER_COLUMN_TOKEN_USERID_2);

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

	private static final String _FINDER_COLUMN_TOKEN_USERID_2 = "user_SSO.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, User_SSOImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLastModifiedDate",
			new String[] { Long.class.getName() },
			User_SSOModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE = new FinderPath(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLastModifiedDate", new String[] { Long.class.getName() });

	/**
	 * Returns the user_ s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	 *
	 * @param userID the user i d
	 * @return the matching user_ s s o
	 * @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO findByLastModifiedDate(long userID)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = fetchByLastModifiedDate(userID);

		if (user_SSO == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUser_SSOException(msg.toString());
		}

		return user_SSO;
	}

	/**
	 * Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userID the user i d
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByLastModifiedDate(long userID)
		throws SystemException {
		return fetchByLastModifiedDate(userID, true);
	}

	/**
	 * Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByLastModifiedDate(long userID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
					finderArgs, this);
		}

		if (result instanceof User_SSO) {
			User_SSO user_SSO = (User_SSO)result;

			if ((userID != user_SSO.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USER_SSO_WHERE);

			query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				List<User_SSO> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"User_SSOPersistenceImpl.fetchByLastModifiedDate(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					User_SSO user_SSO = list.get(0);

					result = user_SSO;

					cacheResult(user_SSO);

					if ((user_SSO.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
							finderArgs, user_SSO);
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
			return (User_SSO)result;
		}
	}

	/**
	 * Removes the user_ s s o where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @return the user_ s s o that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO removeByLastModifiedDate(long userID)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = findByLastModifiedDate(userID);

		return remove(user_SSO);
	}

	/**
	 * Returns the number of user_ s s os where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLastModifiedDate(long userID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE;

		Object[] finderArgs = new Object[] { userID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USER_SSO_WHERE);

			query.append(_FINDER_COLUMN_LASTMODIFIEDDATE_USERID_2);

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

	private static final String _FINDER_COLUMN_LASTMODIFIEDDATE_USERID_2 = "user_SSO.userID = ?";

	public User_SSOPersistenceImpl() {
		setModelClass(User_SSO.class);
	}

	/**
	 * Caches the user_ s s o in the entity cache if it is enabled.
	 *
	 * @param user_SSO the user_ s s o
	 */
	@Override
	public void cacheResult(User_SSO user_SSO) {
		EntityCacheUtil.putResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOImpl.class, user_SSO.getPrimaryKey(), user_SSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { user_SSO.getToken() }, user_SSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN,
			new Object[] { user_SSO.getUserID() }, user_SSO);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
			new Object[] { user_SSO.getUserID() }, user_SSO);

		user_SSO.resetOriginalValues();
	}

	/**
	 * Caches the user_ s s os in the entity cache if it is enabled.
	 *
	 * @param user_SSOs the user_ s s os
	 */
	@Override
	public void cacheResult(List<User_SSO> user_SSOs) {
		for (User_SSO user_SSO : user_SSOs) {
			if (EntityCacheUtil.getResult(
						User_SSOModelImpl.ENTITY_CACHE_ENABLED,
						User_SSOImpl.class, user_SSO.getPrimaryKey()) == null) {
				cacheResult(user_SSO);
			}
			else {
				user_SSO.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user_ s s os.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(User_SSOImpl.class.getName());
		}

		EntityCacheUtil.clearCache(User_SSOImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user_ s s o.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(User_SSO user_SSO) {
		EntityCacheUtil.removeResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOImpl.class, user_SSO.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(user_SSO);
	}

	@Override
	public void clearCache(List<User_SSO> user_SSOs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (User_SSO user_SSO : user_SSOs) {
			EntityCacheUtil.removeResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
				User_SSOImpl.class, user_SSO.getPrimaryKey());

			clearUniqueFindersCache(user_SSO);
		}
	}

	protected void cacheUniqueFindersCache(User_SSO user_SSO) {
		if (user_SSO.isNew()) {
			Object[] args = new Object[] { user_SSO.getToken() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				user_SSO);

			args = new Object[] { user_SSO.getUserID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args, user_SSO);

			args = new Object[] { user_SSO.getUserID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
				args, user_SSO);
		}
		else {
			User_SSOModelImpl user_SSOModelImpl = (User_SSOModelImpl)user_SSO;

			if ((user_SSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { user_SSO.getToken() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					user_SSO);
			}

			if ((user_SSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { user_SSO.getUserID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TOKEN, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TOKEN, args,
					user_SSO);
			}

			if ((user_SSOModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { user_SSO.getUserID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
					args, user_SSO);
			}
		}
	}

	protected void clearUniqueFindersCache(User_SSO user_SSO) {
		User_SSOModelImpl user_SSOModelImpl = (User_SSOModelImpl)user_SSO;

		Object[] args = new Object[] { user_SSO.getToken() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((user_SSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { user_SSOModelImpl.getOriginalToken() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		args = new Object[] { user_SSO.getUserID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);

		if ((user_SSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TOKEN.getColumnBitmask()) != 0) {
			args = new Object[] { user_SSOModelImpl.getOriginalUserID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TOKEN, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TOKEN, args);
		}

		args = new Object[] { user_SSO.getUserID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE, args);

		if ((user_SSOModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE.getColumnBitmask()) != 0) {
			args = new Object[] { user_SSOModelImpl.getOriginalUserID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LASTMODIFIEDDATE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LASTMODIFIEDDATE,
				args);
		}
	}

	/**
	 * Creates a new user_ s s o with the primary key. Does not add the user_ s s o to the database.
	 *
	 * @param userID the primary key for the new user_ s s o
	 * @return the new user_ s s o
	 */
	@Override
	public User_SSO create(long userID) {
		User_SSO user_SSO = new User_SSOImpl();

		user_SSO.setNew(true);
		user_SSO.setPrimaryKey(userID);

		return user_SSO;
	}

	/**
	 * Removes the user_ s s o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userID the primary key of the user_ s s o
	 * @return the user_ s s o that was removed
	 * @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO remove(long userID)
		throws NoSuchUser_SSOException, SystemException {
		return remove((Serializable)userID);
	}

	/**
	 * Removes the user_ s s o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user_ s s o
	 * @return the user_ s s o that was removed
	 * @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO remove(Serializable primaryKey)
		throws NoSuchUser_SSOException, SystemException {
		Session session = null;

		try {
			session = openSession();

			User_SSO user_SSO = (User_SSO)session.get(User_SSOImpl.class,
					primaryKey);

			if (user_SSO == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUser_SSOException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(user_SSO);
		}
		catch (NoSuchUser_SSOException nsee) {
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
	protected User_SSO removeImpl(User_SSO user_SSO) throws SystemException {
		user_SSO = toUnwrappedModel(user_SSO);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(user_SSO)) {
				user_SSO = (User_SSO)session.get(User_SSOImpl.class,
						user_SSO.getPrimaryKeyObj());
			}

			if (user_SSO != null) {
				session.delete(user_SSO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (user_SSO != null) {
			clearCache(user_SSO);
		}

		return user_SSO;
	}

	@Override
	public User_SSO updateImpl(org.gfbio.model.User_SSO user_SSO)
		throws SystemException {
		user_SSO = toUnwrappedModel(user_SSO);

		boolean isNew = user_SSO.isNew();

		Session session = null;

		try {
			session = openSession();

			if (user_SSO.isNew()) {
				session.save(user_SSO);

				user_SSO.setNew(false);
			}
			else {
				session.merge(user_SSO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !User_SSOModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
			User_SSOImpl.class, user_SSO.getPrimaryKey(), user_SSO);

		clearUniqueFindersCache(user_SSO);
		cacheUniqueFindersCache(user_SSO);

		return user_SSO;
	}

	protected User_SSO toUnwrappedModel(User_SSO user_SSO) {
		if (user_SSO instanceof User_SSOImpl) {
			return user_SSO;
		}

		User_SSOImpl user_SSOImpl = new User_SSOImpl();

		user_SSOImpl.setNew(user_SSO.isNew());
		user_SSOImpl.setPrimaryKey(user_SSO.getPrimaryKey());

		user_SSOImpl.setUserID(user_SSO.getUserID());
		user_SSOImpl.setToken(user_SSO.getToken());
		user_SSOImpl.setLastModifiedDate(user_SSO.getLastModifiedDate());

		return user_SSOImpl;
	}

	/**
	 * Returns the user_ s s o with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_ s s o
	 * @return the user_ s s o
	 * @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUser_SSOException, SystemException {
		User_SSO user_SSO = fetchByPrimaryKey(primaryKey);

		if (user_SSO == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUser_SSOException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return user_SSO;
	}

	/**
	 * Returns the user_ s s o with the primary key or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	 *
	 * @param userID the primary key of the user_ s s o
	 * @return the user_ s s o
	 * @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO findByPrimaryKey(long userID)
		throws NoSuchUser_SSOException, SystemException {
		return findByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns the user_ s s o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_ s s o
	 * @return the user_ s s o, or <code>null</code> if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		User_SSO user_SSO = (User_SSO)EntityCacheUtil.getResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
				User_SSOImpl.class, primaryKey);

		if (user_SSO == _nullUser_SSO) {
			return null;
		}

		if (user_SSO == null) {
			Session session = null;

			try {
				session = openSession();

				user_SSO = (User_SSO)session.get(User_SSOImpl.class, primaryKey);

				if (user_SSO != null) {
					cacheResult(user_SSO);
				}
				else {
					EntityCacheUtil.putResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
						User_SSOImpl.class, primaryKey, _nullUser_SSO);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(User_SSOModelImpl.ENTITY_CACHE_ENABLED,
					User_SSOImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return user_SSO;
	}

	/**
	 * Returns the user_ s s o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userID the primary key of the user_ s s o
	 * @return the user_ s s o, or <code>null</code> if a user_ s s o with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public User_SSO fetchByPrimaryKey(long userID) throws SystemException {
		return fetchByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns all the user_ s s os.
	 *
	 * @return the user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_SSO> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user_ s s os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user_ s s os
	 * @param end the upper bound of the range of user_ s s os (not inclusive)
	 * @return the range of user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_SSO> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user_ s s os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user_ s s os
	 * @param end the upper bound of the range of user_ s s os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user_ s s os
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<User_SSO> findAll(int start, int end,
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

		List<User_SSO> list = (List<User_SSO>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USER_SSO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USER_SSO;

				if (pagination) {
					sql = sql.concat(User_SSOModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<User_SSO>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<User_SSO>(list);
				}
				else {
					list = (List<User_SSO>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user_ s s os from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (User_SSO user_SSO : findAll()) {
			remove(user_SSO);
		}
	}

	/**
	 * Returns the number of user_ s s os.
	 *
	 * @return the number of user_ s s os
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

				Query q = session.createQuery(_SQL_COUNT_USER_SSO);

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
	 * Initializes the user_ s s o persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.User_SSO")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<User_SSO>> listenersList = new ArrayList<ModelListener<User_SSO>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<User_SSO>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(User_SSOImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USER_SSO = "SELECT user_SSO FROM User_SSO user_SSO";
	private static final String _SQL_SELECT_USER_SSO_WHERE = "SELECT user_SSO FROM User_SSO user_SSO WHERE ";
	private static final String _SQL_COUNT_USER_SSO = "SELECT COUNT(user_SSO) FROM User_SSO user_SSO";
	private static final String _SQL_COUNT_USER_SSO_WHERE = "SELECT COUNT(user_SSO) FROM User_SSO user_SSO WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "user_SSO.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No User_SSO exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No User_SSO exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(User_SSOPersistenceImpl.class);
	private static User_SSO _nullUser_SSO = new User_SSOImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<User_SSO> toCacheModel() {
				return _nullUser_SSOCacheModel;
			}
		};

	private static CacheModel<User_SSO> _nullUser_SSOCacheModel = new CacheModel<User_SSO>() {
			@Override
			public User_SSO toEntityModel() {
				return _nullUser_SSO;
			}
		};
}