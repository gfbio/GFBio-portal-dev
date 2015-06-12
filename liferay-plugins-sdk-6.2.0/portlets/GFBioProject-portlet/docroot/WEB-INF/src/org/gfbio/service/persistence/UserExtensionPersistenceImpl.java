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

import org.gfbio.NoSuchUserExtensionException;

import org.gfbio.model.UserExtension;
import org.gfbio.model.impl.UserExtensionImpl;
import org.gfbio.model.impl.UserExtensionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user extension service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see UserExtensionPersistence
 * @see UserExtensionUtil
 * @generated
 */
public class UserExtensionPersistenceImpl extends BasePersistenceImpl<UserExtension>
	implements UserExtensionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserExtensionUtil} to access the user extension persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserExtensionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionModelImpl.FINDER_CACHE_ENABLED,
			UserExtensionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionModelImpl.FINDER_CACHE_ENABLED,
			UserExtensionImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionModelImpl.FINDER_CACHE_ENABLED,
			UserExtensionImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUserID",
			new String[] { Long.class.getName() },
			UserExtensionModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user extension where userID = &#63; or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	 *
	 * @param userID the user i d
	 * @return the matching user extension
	 * @throws org.gfbio.NoSuchUserExtensionException if a matching user extension could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension findByUserID(long userID)
		throws NoSuchUserExtensionException, SystemException {
		UserExtension userExtension = fetchByUserID(userID);

		if (userExtension == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userID=");
			msg.append(userID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserExtensionException(msg.toString());
		}

		return userExtension;
	}

	/**
	 * Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userID the user i d
	 * @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension fetchByUserID(long userID) throws SystemException {
		return fetchByUserID(userID, true);
	}

	/**
	 * Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userID the user i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension fetchByUserID(long userID, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof UserExtension) {
			UserExtension userExtension = (UserExtension)result;

			if ((userID != userExtension.getUserID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USEREXTENSION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userID);

				List<UserExtension> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserExtensionPersistenceImpl.fetchByUserID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserExtension userExtension = list.get(0);

					result = userExtension;

					cacheResult(userExtension);

					if ((userExtension.getUserID() != userID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userExtension);
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
			return (UserExtension)result;
		}
	}

	/**
	 * Removes the user extension where userID = &#63; from the database.
	 *
	 * @param userID the user i d
	 * @return the user extension that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension removeByUserID(long userID)
		throws NoSuchUserExtensionException, SystemException {
		UserExtension userExtension = findByUserID(userID);

		return remove(userExtension);
	}

	/**
	 * Returns the number of user extensions where userID = &#63;.
	 *
	 * @param userID the user i d
	 * @return the number of matching user extensions
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

			query.append(_SQL_COUNT_USEREXTENSION_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userExtension.userID = ?";

	public UserExtensionPersistenceImpl() {
		setModelClass(UserExtension.class);
	}

	/**
	 * Caches the user extension in the entity cache if it is enabled.
	 *
	 * @param userExtension the user extension
	 */
	@Override
	public void cacheResult(UserExtension userExtension) {
		EntityCacheUtil.putResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionImpl.class, userExtension.getPrimaryKey(),
			userExtension);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { userExtension.getUserID() }, userExtension);

		userExtension.resetOriginalValues();
	}

	/**
	 * Caches the user extensions in the entity cache if it is enabled.
	 *
	 * @param userExtensions the user extensions
	 */
	@Override
	public void cacheResult(List<UserExtension> userExtensions) {
		for (UserExtension userExtension : userExtensions) {
			if (EntityCacheUtil.getResult(
						UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
						UserExtensionImpl.class, userExtension.getPrimaryKey()) == null) {
				cacheResult(userExtension);
			}
			else {
				userExtension.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user extensions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserExtensionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserExtensionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user extension.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserExtension userExtension) {
		EntityCacheUtil.removeResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionImpl.class, userExtension.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userExtension);
	}

	@Override
	public void clearCache(List<UserExtension> userExtensions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserExtension userExtension : userExtensions) {
			EntityCacheUtil.removeResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
				UserExtensionImpl.class, userExtension.getPrimaryKey());

			clearUniqueFindersCache(userExtension);
		}
	}

	protected void cacheUniqueFindersCache(UserExtension userExtension) {
		if (userExtension.isNew()) {
			Object[] args = new Object[] { userExtension.getUserID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				userExtension);
		}
		else {
			UserExtensionModelImpl userExtensionModelImpl = (UserExtensionModelImpl)userExtension;

			if ((userExtensionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userExtension.getUserID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					userExtension);
			}
		}
	}

	protected void clearUniqueFindersCache(UserExtension userExtension) {
		UserExtensionModelImpl userExtensionModelImpl = (UserExtensionModelImpl)userExtension;

		Object[] args = new Object[] { userExtension.getUserID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((userExtensionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { userExtensionModelImpl.getOriginalUserID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new user extension with the primary key. Does not add the user extension to the database.
	 *
	 * @param userID the primary key for the new user extension
	 * @return the new user extension
	 */
	@Override
	public UserExtension create(long userID) {
		UserExtension userExtension = new UserExtensionImpl();

		userExtension.setNew(true);
		userExtension.setPrimaryKey(userID);

		return userExtension;
	}

	/**
	 * Removes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userID the primary key of the user extension
	 * @return the user extension that was removed
	 * @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension remove(long userID)
		throws NoSuchUserExtensionException, SystemException {
		return remove((Serializable)userID);
	}

	/**
	 * Removes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user extension
	 * @return the user extension that was removed
	 * @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension remove(Serializable primaryKey)
		throws NoSuchUserExtensionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserExtension userExtension = (UserExtension)session.get(UserExtensionImpl.class,
					primaryKey);

			if (userExtension == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserExtensionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userExtension);
		}
		catch (NoSuchUserExtensionException nsee) {
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
	protected UserExtension removeImpl(UserExtension userExtension)
		throws SystemException {
		userExtension = toUnwrappedModel(userExtension);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userExtension)) {
				userExtension = (UserExtension)session.get(UserExtensionImpl.class,
						userExtension.getPrimaryKeyObj());
			}

			if (userExtension != null) {
				session.delete(userExtension);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userExtension != null) {
			clearCache(userExtension);
		}

		return userExtension;
	}

	@Override
	public UserExtension updateImpl(org.gfbio.model.UserExtension userExtension)
		throws SystemException {
		userExtension = toUnwrappedModel(userExtension);

		boolean isNew = userExtension.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userExtension.isNew()) {
				session.save(userExtension);

				userExtension.setNew(false);
			}
			else {
				session.merge(userExtension);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserExtensionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
			UserExtensionImpl.class, userExtension.getPrimaryKey(),
			userExtension);

		clearUniqueFindersCache(userExtension);
		cacheUniqueFindersCache(userExtension);

		return userExtension;
	}

	protected UserExtension toUnwrappedModel(UserExtension userExtension) {
		if (userExtension instanceof UserExtensionImpl) {
			return userExtension;
		}

		UserExtensionImpl userExtensionImpl = new UserExtensionImpl();

		userExtensionImpl.setNew(userExtension.isNew());
		userExtensionImpl.setPrimaryKey(userExtension.getPrimaryKey());

		userExtensionImpl.setUserID(userExtension.getUserID());

		return userExtensionImpl;
	}

	/**
	 * Returns the user extension with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user extension
	 * @return the user extension
	 * @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserExtensionException, SystemException {
		UserExtension userExtension = fetchByPrimaryKey(primaryKey);

		if (userExtension == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserExtensionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userExtension;
	}

	/**
	 * Returns the user extension with the primary key or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	 *
	 * @param userID the primary key of the user extension
	 * @return the user extension
	 * @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension findByPrimaryKey(long userID)
		throws NoSuchUserExtensionException, SystemException {
		return findByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns the user extension with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user extension
	 * @return the user extension, or <code>null</code> if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserExtension userExtension = (UserExtension)EntityCacheUtil.getResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
				UserExtensionImpl.class, primaryKey);

		if (userExtension == _nullUserExtension) {
			return null;
		}

		if (userExtension == null) {
			Session session = null;

			try {
				session = openSession();

				userExtension = (UserExtension)session.get(UserExtensionImpl.class,
						primaryKey);

				if (userExtension != null) {
					cacheResult(userExtension);
				}
				else {
					EntityCacheUtil.putResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
						UserExtensionImpl.class, primaryKey, _nullUserExtension);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserExtensionModelImpl.ENTITY_CACHE_ENABLED,
					UserExtensionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userExtension;
	}

	/**
	 * Returns the user extension with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userID the primary key of the user extension
	 * @return the user extension, or <code>null</code> if a user extension with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserExtension fetchByPrimaryKey(long userID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userID);
	}

	/**
	 * Returns all the user extensions.
	 *
	 * @return the user extensions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserExtension> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user extensions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user extensions
	 * @param end the upper bound of the range of user extensions (not inclusive)
	 * @return the range of user extensions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserExtension> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user extensions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user extensions
	 * @param end the upper bound of the range of user extensions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user extensions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserExtension> findAll(int start, int end,
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

		List<UserExtension> list = (List<UserExtension>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USEREXTENSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USEREXTENSION;

				if (pagination) {
					sql = sql.concat(UserExtensionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserExtension>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserExtension>(list);
				}
				else {
					list = (List<UserExtension>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user extensions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserExtension userExtension : findAll()) {
			remove(userExtension);
		}
	}

	/**
	 * Returns the number of user extensions.
	 *
	 * @return the number of user extensions
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

				Query q = session.createQuery(_SQL_COUNT_USEREXTENSION);

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
	 * Initializes the user extension persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.UserExtension")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserExtension>> listenersList = new ArrayList<ModelListener<UserExtension>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserExtension>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserExtensionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USEREXTENSION = "SELECT userExtension FROM UserExtension userExtension";
	private static final String _SQL_SELECT_USEREXTENSION_WHERE = "SELECT userExtension FROM UserExtension userExtension WHERE ";
	private static final String _SQL_COUNT_USEREXTENSION = "SELECT COUNT(userExtension) FROM UserExtension userExtension";
	private static final String _SQL_COUNT_USEREXTENSION_WHERE = "SELECT COUNT(userExtension) FROM UserExtension userExtension WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userExtension.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserExtension exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserExtension exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserExtensionPersistenceImpl.class);
	private static UserExtension _nullUserExtension = new UserExtensionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserExtension> toCacheModel() {
				return _nullUserExtensionCacheModel;
			}
		};

	private static CacheModel<UserExtension> _nullUserExtensionCacheModel = new CacheModel<UserExtension>() {
			@Override
			public UserExtension toEntityModel() {
				return _nullUserExtension;
			}
		};
}