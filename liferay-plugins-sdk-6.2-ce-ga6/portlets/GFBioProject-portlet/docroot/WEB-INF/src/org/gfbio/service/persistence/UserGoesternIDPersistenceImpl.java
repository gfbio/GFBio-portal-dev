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

import org.gfbio.NoSuchUserGoesternIDException;

import org.gfbio.model.UserGoesternID;
import org.gfbio.model.impl.UserGoesternIDImpl;
import org.gfbio.model.impl.UserGoesternIDModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user goestern i d service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see UserGoesternIDPersistence
 * @see UserGoesternIDUtil
 * @generated
 */
public class UserGoesternIDPersistenceImpl extends BasePersistenceImpl<UserGoesternID>
	implements UserGoesternIDPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserGoesternIDUtil} to access the user goestern i d persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserGoesternIDImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED,
			UserGoesternIDImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED,
			UserGoesternIDImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED,
			UserGoesternIDImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserID", new String[] { Long.class.getName() },
			UserGoesternIDModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user goestern i d where userID = &#63; or throws a {@link org.gfbio.NoSuchUserGoesternIDException} if it could not be found.
	 *
	 * @param userID the user i d
	 * @return the matching user goestern i d
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID findByUserID(long userID)
		throws NoSuchUserGoesternIDException, SystemException {
		UserGoesternID userGoesternID = fetchByUserID(userID);

		if (userGoesternID == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserGoesternIDException(msg.toString());
		}

		return userGoesternID;
	}

	/**
	 * Returns the user goestern i d where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userID the user i d
	 * @return the matching user goestern i d, or <code>null</code> if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByUserID(long userID) throws SystemException {
		return fetchByUserID(userID, true);
	}

	/**
	 * Returns the user goestern i d where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user goestern i d, or <code>null</code> if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByUserID(long userID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserGoesternID) {
			UserGoesternID userGoesternID = (UserGoesternID)result;

			if ((userID != userGoesternID.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERGOESTERNID_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				List<UserGoesternID> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserGoesternIDPersistenceImpl.fetchByUserID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserGoesternID userGoesternID = list.get(0);

					result = userGoesternID;

					cacheResult(userGoesternID);

					if ((userGoesternID.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userGoesternID);
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
			return (UserGoesternID)result;
		}
	}

	/**
	 * Removes the user goestern i d where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @return the user goestern i d that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID removeByUserID(long userID)
		throws NoSuchUserGoesternIDException, SystemException {
		UserGoesternID userGoesternID = findByUserID(userID);

		return remove(userGoesternID);
	}

	/**
	 * Returns the number of user goestern i ds where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching user goestern i ds
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

			query.append(_SQL_COUNT_USERGOESTERNID_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userGoesternID.id.userID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GOESTERNID = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED,
			UserGoesternIDImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGoeSternID", new String[] { String.class.getName() },
			UserGoesternIDModelImpl.GOESTERNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GOESTERNID = new FinderPath(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGoeSternID",
			new String[] { String.class.getName() });

	/**
	 * Returns the user goestern i d where goeSternID = &#63; or throws a {@link org.gfbio.NoSuchUserGoesternIDException} if it could not be found.
	 *
	 * @param goeSternID the goe stern i d
	 * @return the matching user goestern i d
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID findByGoeSternID(String goeSternID)
		throws NoSuchUserGoesternIDException, SystemException {
		UserGoesternID userGoesternID = fetchByGoeSternID(goeSternID);

		if (userGoesternID == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("goeSternID=");
			msg.append(goeSternID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserGoesternIDException(msg.toString());
		}

		return userGoesternID;
	}

	/**
	 * Returns the user goestern i d where goeSternID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param goeSternID the goe stern i d
	 * @return the matching user goestern i d, or <code>null</code> if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByGoeSternID(String goeSternID)
		throws SystemException {
		return fetchByGoeSternID(goeSternID, true);
	}

	/**
	 * Returns the user goestern i d where goeSternID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param goeSternID the goe stern i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user goestern i d, or <code>null</code> if a matching user goestern i d could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByGoeSternID(String goeSternID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { goeSternID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GOESTERNID,
					finderArgs, this);
		}

		if (result instanceof UserGoesternID) {
			UserGoesternID userGoesternID = (UserGoesternID)result;

			if (!Validator.equals(goeSternID, userGoesternID.getGoeSternID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERGOESTERNID_WHERE);

			boolean bindGoeSternID = false;

			if (goeSternID == null) {
				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_1);
			}
			else if (goeSternID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_3);
			}
			else {
				bindGoeSternID = true;

				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGoeSternID) {
					qPos.add(goeSternID);
				}

				List<UserGoesternID> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOESTERNID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserGoesternIDPersistenceImpl.fetchByGoeSternID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserGoesternID userGoesternID = list.get(0);

					result = userGoesternID;

					cacheResult(userGoesternID);

					if ((userGoesternID.getGoeSternID() == null) ||
							!userGoesternID.getGoeSternID().equals(goeSternID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOESTERNID,
							finderArgs, userGoesternID);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOESTERNID,
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
			return (UserGoesternID)result;
		}
	}

	/**
	 * Removes the user goestern i d where goeSternID = &#63; from the database.
	 *
	 * @param goeSternID the goe stern i d
	 * @return the user goestern i d that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID removeByGoeSternID(String goeSternID)
		throws NoSuchUserGoesternIDException, SystemException {
		UserGoesternID userGoesternID = findByGoeSternID(goeSternID);

		return remove(userGoesternID);
	}

	/**
	 * Returns the number of user goestern i ds where goeSternID = &#63;.
	 *
	 * @param goeSternID the goe stern i d
	 * @return the number of matching user goestern i ds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGoeSternID(String goeSternID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GOESTERNID;

		Object[] finderArgs = new Object[] { goeSternID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERGOESTERNID_WHERE);

			boolean bindGoeSternID = false;

			if (goeSternID == null) {
				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_1);
			}
			else if (goeSternID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_3);
			}
			else {
				bindGoeSternID = true;

				query.append(_FINDER_COLUMN_GOESTERNID_GOESTERNID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGoeSternID) {
					qPos.add(goeSternID);
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

	private static final String _FINDER_COLUMN_GOESTERNID_GOESTERNID_1 = "userGoesternID.id.goeSternID IS NULL";
	private static final String _FINDER_COLUMN_GOESTERNID_GOESTERNID_2 = "userGoesternID.id.goeSternID = ?";
	private static final String _FINDER_COLUMN_GOESTERNID_GOESTERNID_3 = "(userGoesternID.id.goeSternID IS NULL OR userGoesternID.id.goeSternID = '')";

	public UserGoesternIDPersistenceImpl() {
		setModelClass(UserGoesternID.class);
	}

	/**
	 * Caches the user goestern i d in the entity cache if it is enabled.
	 *
	 * @param userGoesternID the user goestern i d
	 */
	@Override
	public void cacheResult(UserGoesternID userGoesternID) {
		EntityCacheUtil.putResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDImpl.class, userGoesternID.getPrimaryKey(),
			userGoesternID);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userGoesternID.getUserID() }, userGoesternID);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOESTERNID,
			new Object[] { userGoesternID.getGoeSternID() }, userGoesternID);

		userGoesternID.resetOriginalValues();
	}

	/**
	 * Caches the user goestern i ds in the entity cache if it is enabled.
	 *
	 * @param userGoesternIDs the user goestern i ds
	 */
	@Override
	public void cacheResult(List<UserGoesternID> userGoesternIDs) {
		for (UserGoesternID userGoesternID : userGoesternIDs) {
			if (EntityCacheUtil.getResult(
						UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
						UserGoesternIDImpl.class, userGoesternID.getPrimaryKey()) == null) {
				cacheResult(userGoesternID);
			}
			else {
				userGoesternID.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user goestern i ds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserGoesternIDImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserGoesternIDImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user goestern i d.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserGoesternID userGoesternID) {
		EntityCacheUtil.removeResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDImpl.class, userGoesternID.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userGoesternID);
	}

	@Override
	public void clearCache(List<UserGoesternID> userGoesternIDs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserGoesternID userGoesternID : userGoesternIDs) {
			EntityCacheUtil.removeResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
				UserGoesternIDImpl.class, userGoesternID.getPrimaryKey());

			clearUniqueFindersCache(userGoesternID);
		}
	}

	protected void cacheUniqueFindersCache(UserGoesternID userGoesternID) {
		if (userGoesternID.isNew()) {
			Object[] args = new Object[] { userGoesternID.getUserID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				userGoesternID);

			args = new Object[] { userGoesternID.getGoeSternID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GOESTERNID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOESTERNID, args,
				userGoesternID);
		}
		else {
			UserGoesternIDModelImpl userGoesternIDModelImpl = (UserGoesternIDModelImpl)userGoesternID;

			if ((userGoesternIDModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userGoesternID.getUserID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					userGoesternID);
			}

			if ((userGoesternIDModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GOESTERNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userGoesternID.getGoeSternID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GOESTERNID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOESTERNID,
					args, userGoesternID);
			}
		}
	}

	protected void clearUniqueFindersCache(UserGoesternID userGoesternID) {
		UserGoesternIDModelImpl userGoesternIDModelImpl = (UserGoesternIDModelImpl)userGoesternID;

		Object[] args = new Object[] { userGoesternID.getUserID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((userGoesternIDModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { userGoesternIDModelImpl.getOriginalUserID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}

		args = new Object[] { userGoesternID.getGoeSternID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GOESTERNID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOESTERNID, args);

		if ((userGoesternIDModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GOESTERNID.getColumnBitmask()) != 0) {
			args = new Object[] { userGoesternIDModelImpl.getOriginalGoeSternID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GOESTERNID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOESTERNID, args);
		}
	}

	/**
	 * Creates a new user goestern i d with the primary key. Does not add the user goestern i d to the database.
	 *
	 * @param userGoesternIDPK the primary key for the new user goestern i d
	 * @return the new user goestern i d
	 */
	@Override
	public UserGoesternID create(UserGoesternIDPK userGoesternIDPK) {
		UserGoesternID userGoesternID = new UserGoesternIDImpl();

		userGoesternID.setNew(true);
		userGoesternID.setPrimaryKey(userGoesternIDPK);

		return userGoesternID;
	}

	/**
	 * Removes the user goestern i d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGoesternIDPK the primary key of the user goestern i d
	 * @return the user goestern i d that was removed
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID remove(UserGoesternIDPK userGoesternIDPK)
		throws NoSuchUserGoesternIDException, SystemException {
		return remove((Serializable)userGoesternIDPK);
	}

	/**
	 * Removes the user goestern i d with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user goestern i d
	 * @return the user goestern i d that was removed
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID remove(Serializable primaryKey)
		throws NoSuchUserGoesternIDException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserGoesternID userGoesternID = (UserGoesternID)session.get(UserGoesternIDImpl.class,
					primaryKey);

			if (userGoesternID == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserGoesternIDException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userGoesternID);
		}
		catch (NoSuchUserGoesternIDException nsee) {
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
	protected UserGoesternID removeImpl(UserGoesternID userGoesternID)
		throws SystemException {
		userGoesternID = toUnwrappedModel(userGoesternID);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userGoesternID)) {
				userGoesternID = (UserGoesternID)session.get(UserGoesternIDImpl.class,
						userGoesternID.getPrimaryKeyObj());
			}

			if (userGoesternID != null) {
				session.delete(userGoesternID);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userGoesternID != null) {
			clearCache(userGoesternID);
		}

		return userGoesternID;
	}

	@Override
	public UserGoesternID updateImpl(
		org.gfbio.model.UserGoesternID userGoesternID)
		throws SystemException {
		userGoesternID = toUnwrappedModel(userGoesternID);

		boolean isNew = userGoesternID.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userGoesternID.isNew()) {
				session.save(userGoesternID);

				userGoesternID.setNew(false);
			}
			else {
				session.merge(userGoesternID);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserGoesternIDModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
			UserGoesternIDImpl.class, userGoesternID.getPrimaryKey(),
			userGoesternID);

		clearUniqueFindersCache(userGoesternID);
		cacheUniqueFindersCache(userGoesternID);

		return userGoesternID;
	}

	protected UserGoesternID toUnwrappedModel(UserGoesternID userGoesternID) {
		if (userGoesternID instanceof UserGoesternIDImpl) {
			return userGoesternID;
		}

		UserGoesternIDImpl userGoesternIDImpl = new UserGoesternIDImpl();

		userGoesternIDImpl.setNew(userGoesternID.isNew());
		userGoesternIDImpl.setPrimaryKey(userGoesternID.getPrimaryKey());

		userGoesternIDImpl.setUserID(userGoesternID.getUserID());
		userGoesternIDImpl.setGoeSternID(userGoesternID.getGoeSternID());
		userGoesternIDImpl.setLastModifiedDate(userGoesternID.getLastModifiedDate());

		return userGoesternIDImpl;
	}

	/**
	 * Returns the user goestern i d with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user goestern i d
	 * @return the user goestern i d
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserGoesternIDException, SystemException {
		UserGoesternID userGoesternID = fetchByPrimaryKey(primaryKey);

		if (userGoesternID == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserGoesternIDException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userGoesternID;
	}

	/**
	 * Returns the user goestern i d with the primary key or throws a {@link org.gfbio.NoSuchUserGoesternIDException} if it could not be found.
	 *
	 * @param userGoesternIDPK the primary key of the user goestern i d
	 * @return the user goestern i d
	 * @throws org.gfbio.NoSuchUserGoesternIDException if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID findByPrimaryKey(UserGoesternIDPK userGoesternIDPK)
		throws NoSuchUserGoesternIDException, SystemException {
		return findByPrimaryKey((Serializable)userGoesternIDPK);
	}

	/**
	 * Returns the user goestern i d with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user goestern i d
	 * @return the user goestern i d, or <code>null</code> if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserGoesternID userGoesternID = (UserGoesternID)EntityCacheUtil.getResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
				UserGoesternIDImpl.class, primaryKey);

		if (userGoesternID == _nullUserGoesternID) {
			return null;
		}

		if (userGoesternID == null) {
			Session session = null;

			try {
				session = openSession();

				userGoesternID = (UserGoesternID)session.get(UserGoesternIDImpl.class,
						primaryKey);

				if (userGoesternID != null) {
					cacheResult(userGoesternID);
				}
				else {
					EntityCacheUtil.putResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
						UserGoesternIDImpl.class, primaryKey,
						_nullUserGoesternID);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserGoesternIDModelImpl.ENTITY_CACHE_ENABLED,
					UserGoesternIDImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userGoesternID;
	}

	/**
	 * Returns the user goestern i d with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGoesternIDPK the primary key of the user goestern i d
	 * @return the user goestern i d, or <code>null</code> if a user goestern i d with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGoesternID fetchByPrimaryKey(UserGoesternIDPK userGoesternIDPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userGoesternIDPK);
	}

	/**
	 * Returns all the user goestern i ds.
	 *
	 * @return the user goestern i ds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGoesternID> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user goestern i ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserGoesternIDModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user goestern i ds
	 * @param end the upper bound of the range of user goestern i ds (not inclusive)
	 * @return the range of user goestern i ds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGoesternID> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user goestern i ds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserGoesternIDModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user goestern i ds
	 * @param end the upper bound of the range of user goestern i ds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user goestern i ds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGoesternID> findAll(int start, int end,
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

		List<UserGoesternID> list = (List<UserGoesternID>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERGOESTERNID);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERGOESTERNID;

				if (pagination) {
					sql = sql.concat(UserGoesternIDModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserGoesternID>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGoesternID>(list);
				}
				else {
					list = (List<UserGoesternID>)QueryUtil.list(q,
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
	 * Removes all the user goestern i ds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserGoesternID userGoesternID : findAll()) {
			remove(userGoesternID);
		}
	}

	/**
	 * Returns the number of user goestern i ds.
	 *
	 * @return the number of user goestern i ds
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

				Query q = session.createQuery(_SQL_COUNT_USERGOESTERNID);

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
	 * Initializes the user goestern i d persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.UserGoesternID")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserGoesternID>> listenersList = new ArrayList<ModelListener<UserGoesternID>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserGoesternID>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserGoesternIDImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERGOESTERNID = "SELECT userGoesternID FROM UserGoesternID userGoesternID";
	private static final String _SQL_SELECT_USERGOESTERNID_WHERE = "SELECT userGoesternID FROM UserGoesternID userGoesternID WHERE ";
	private static final String _SQL_COUNT_USERGOESTERNID = "SELECT COUNT(userGoesternID) FROM UserGoesternID userGoesternID";
	private static final String _SQL_COUNT_USERGOESTERNID_WHERE = "SELECT COUNT(userGoesternID) FROM UserGoesternID userGoesternID WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userGoesternID.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserGoesternID exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserGoesternID exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserGoesternIDPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"lastModifiedDate"
			});
	private static UserGoesternID _nullUserGoesternID = new UserGoesternIDImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserGoesternID> toCacheModel() {
				return _nullUserGoesternIDCacheModel;
			}
		};

	private static CacheModel<UserGoesternID> _nullUserGoesternIDCacheModel = new CacheModel<UserGoesternID>() {
			@Override
			public UserGoesternID toEntityModel() {
				return _nullUserGoesternID;
			}
		};
}