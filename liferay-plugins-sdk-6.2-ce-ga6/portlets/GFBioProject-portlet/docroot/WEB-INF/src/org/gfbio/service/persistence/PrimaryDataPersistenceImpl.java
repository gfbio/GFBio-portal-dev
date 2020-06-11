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

import org.gfbio.NoSuchPrimaryDataException;

import org.gfbio.model.PrimaryData;
import org.gfbio.model.impl.PrimaryDataImpl;
import org.gfbio.model.impl.PrimaryDataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the primary data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PrimaryDataPersistence
 * @see PrimaryDataUtil
 * @generated
 */
public class PrimaryDataPersistenceImpl extends BasePersistenceImpl<PrimaryData>
	implements PrimaryDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrimaryDataUtil} to access the primary data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrimaryDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataModelImpl.FINDER_CACHE_ENABLED, PrimaryDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataModelImpl.FINDER_CACHE_ENABLED, PrimaryDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PRIMARYDATAID = new FinderPath(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataModelImpl.FINDER_CACHE_ENABLED, PrimaryDataImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPrimaryDataID",
			new String[] { Long.class.getName() },
			PrimaryDataModelImpl.PRIMARYDATAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIMARYDATAID = new FinderPath(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrimaryDataID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the primary data where primaryDataID = &#63; or throws a {@link org.gfbio.NoSuchPrimaryDataException} if it could not be found.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the matching primary data
	 * @throws org.gfbio.NoSuchPrimaryDataException if a matching primary data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData findByPrimaryDataID(long primaryDataID)
		throws NoSuchPrimaryDataException, SystemException {
		PrimaryData primaryData = fetchByPrimaryDataID(primaryDataID);

		if (primaryData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("primaryDataID=");
			msg.append(primaryDataID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPrimaryDataException(msg.toString());
		}

		return primaryData;
	}

	/**
	 * Returns the primary data where primaryDataID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the matching primary data, or <code>null</code> if a matching primary data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData fetchByPrimaryDataID(long primaryDataID)
		throws SystemException {
		return fetchByPrimaryDataID(primaryDataID, true);
	}

	/**
	 * Returns the primary data where primaryDataID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param primaryDataID the primary data i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching primary data, or <code>null</code> if a matching primary data could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData fetchByPrimaryDataID(long primaryDataID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { primaryDataID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
					finderArgs, this);
		}

		if (result instanceof PrimaryData) {
			PrimaryData primaryData = (PrimaryData)result;

			if ((primaryDataID != primaryData.getPrimaryDataID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PRIMARYDATA_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(primaryDataID);

				List<PrimaryData> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PrimaryDataPersistenceImpl.fetchByPrimaryDataID(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PrimaryData primaryData = list.get(0);

					result = primaryData;

					cacheResult(primaryData);

					if ((primaryData.getPrimaryDataID() != primaryDataID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
							finderArgs, primaryData);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
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
			return (PrimaryData)result;
		}
	}

	/**
	 * Removes the primary data where primaryDataID = &#63; from the database.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the primary data that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData removeByPrimaryDataID(long primaryDataID)
		throws NoSuchPrimaryDataException, SystemException {
		PrimaryData primaryData = findByPrimaryDataID(primaryDataID);

		return remove(primaryData);
	}

	/**
	 * Returns the number of primary datas where primaryDataID = &#63;.
	 *
	 * @param primaryDataID the primary data i d
	 * @return the number of matching primary datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrimaryDataID(long primaryDataID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIMARYDATAID;

		Object[] finderArgs = new Object[] { primaryDataID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRIMARYDATA_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(primaryDataID);

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

	private static final String _FINDER_COLUMN_PRIMARYDATAID_PRIMARYDATAID_2 = "primaryData.primaryDataID = ?";

	public PrimaryDataPersistenceImpl() {
		setModelClass(PrimaryData.class);
	}

	/**
	 * Caches the primary data in the entity cache if it is enabled.
	 *
	 * @param primaryData the primary data
	 */
	@Override
	public void cacheResult(PrimaryData primaryData) {
		EntityCacheUtil.putResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataImpl.class, primaryData.getPrimaryKey(), primaryData);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
			new Object[] { primaryData.getPrimaryDataID() }, primaryData);

		primaryData.resetOriginalValues();
	}

	/**
	 * Caches the primary datas in the entity cache if it is enabled.
	 *
	 * @param primaryDatas the primary datas
	 */
	@Override
	public void cacheResult(List<PrimaryData> primaryDatas) {
		for (PrimaryData primaryData : primaryDatas) {
			if (EntityCacheUtil.getResult(
						PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
						PrimaryDataImpl.class, primaryData.getPrimaryKey()) == null) {
				cacheResult(primaryData);
			}
			else {
				primaryData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all primary datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrimaryDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrimaryDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the primary data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrimaryData primaryData) {
		EntityCacheUtil.removeResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataImpl.class, primaryData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(primaryData);
	}

	@Override
	public void clearCache(List<PrimaryData> primaryDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrimaryData primaryData : primaryDatas) {
			EntityCacheUtil.removeResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
				PrimaryDataImpl.class, primaryData.getPrimaryKey());

			clearUniqueFindersCache(primaryData);
		}
	}

	protected void cacheUniqueFindersCache(PrimaryData primaryData) {
		if (primaryData.isNew()) {
			Object[] args = new Object[] { primaryData.getPrimaryDataID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID, args,
				primaryData);
		}
		else {
			PrimaryDataModelImpl primaryDataModelImpl = (PrimaryDataModelImpl)primaryData;

			if ((primaryDataModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PRIMARYDATAID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { primaryData.getPrimaryDataID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
					args, primaryData);
			}
		}
	}

	protected void clearUniqueFindersCache(PrimaryData primaryData) {
		PrimaryDataModelImpl primaryDataModelImpl = (PrimaryDataModelImpl)primaryData;

		Object[] args = new Object[] { primaryData.getPrimaryDataID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID, args);

		if ((primaryDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRIMARYDATAID.getColumnBitmask()) != 0) {
			args = new Object[] { primaryDataModelImpl.getOriginalPrimaryDataID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIMARYDATAID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRIMARYDATAID,
				args);
		}
	}

	/**
	 * Creates a new primary data with the primary key. Does not add the primary data to the database.
	 *
	 * @param primaryDataID the primary key for the new primary data
	 * @return the new primary data
	 */
	@Override
	public PrimaryData create(long primaryDataID) {
		PrimaryData primaryData = new PrimaryDataImpl();

		primaryData.setNew(true);
		primaryData.setPrimaryKey(primaryDataID);

		return primaryData;
	}

	/**
	 * Removes the primary data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryDataID the primary key of the primary data
	 * @return the primary data that was removed
	 * @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData remove(long primaryDataID)
		throws NoSuchPrimaryDataException, SystemException {
		return remove((Serializable)primaryDataID);
	}

	/**
	 * Removes the primary data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the primary data
	 * @return the primary data that was removed
	 * @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData remove(Serializable primaryKey)
		throws NoSuchPrimaryDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrimaryData primaryData = (PrimaryData)session.get(PrimaryDataImpl.class,
					primaryKey);

			if (primaryData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrimaryDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(primaryData);
		}
		catch (NoSuchPrimaryDataException nsee) {
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
	protected PrimaryData removeImpl(PrimaryData primaryData)
		throws SystemException {
		primaryData = toUnwrappedModel(primaryData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(primaryData)) {
				primaryData = (PrimaryData)session.get(PrimaryDataImpl.class,
						primaryData.getPrimaryKeyObj());
			}

			if (primaryData != null) {
				session.delete(primaryData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (primaryData != null) {
			clearCache(primaryData);
		}

		return primaryData;
	}

	@Override
	public PrimaryData updateImpl(org.gfbio.model.PrimaryData primaryData)
		throws SystemException {
		primaryData = toUnwrappedModel(primaryData);

		boolean isNew = primaryData.isNew();

		Session session = null;

		try {
			session = openSession();

			if (primaryData.isNew()) {
				session.save(primaryData);

				primaryData.setNew(false);
			}
			else {
				session.merge(primaryData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PrimaryDataModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
			PrimaryDataImpl.class, primaryData.getPrimaryKey(), primaryData);

		clearUniqueFindersCache(primaryData);
		cacheUniqueFindersCache(primaryData);

		return primaryData;
	}

	protected PrimaryData toUnwrappedModel(PrimaryData primaryData) {
		if (primaryData instanceof PrimaryDataImpl) {
			return primaryData;
		}

		PrimaryDataImpl primaryDataImpl = new PrimaryDataImpl();

		primaryDataImpl.setNew(primaryData.isNew());
		primaryDataImpl.setPrimaryKey(primaryData.getPrimaryKey());

		primaryDataImpl.setPrimaryDataID(primaryData.getPrimaryDataID());
		primaryDataImpl.setName(primaryData.getName());
		primaryDataImpl.setPath(primaryData.getPath());
		primaryDataImpl.setLastModifiedDate(primaryData.getLastModifiedDate());

		return primaryDataImpl;
	}

	/**
	 * Returns the primary data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary data
	 * @return the primary data
	 * @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrimaryDataException, SystemException {
		PrimaryData primaryData = fetchByPrimaryKey(primaryKey);

		if (primaryData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrimaryDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return primaryData;
	}

	/**
	 * Returns the primary data with the primary key or throws a {@link org.gfbio.NoSuchPrimaryDataException} if it could not be found.
	 *
	 * @param primaryDataID the primary key of the primary data
	 * @return the primary data
	 * @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData findByPrimaryKey(long primaryDataID)
		throws NoSuchPrimaryDataException, SystemException {
		return findByPrimaryKey((Serializable)primaryDataID);
	}

	/**
	 * Returns the primary data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary data
	 * @return the primary data, or <code>null</code> if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PrimaryData primaryData = (PrimaryData)EntityCacheUtil.getResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
				PrimaryDataImpl.class, primaryKey);

		if (primaryData == _nullPrimaryData) {
			return null;
		}

		if (primaryData == null) {
			Session session = null;

			try {
				session = openSession();

				primaryData = (PrimaryData)session.get(PrimaryDataImpl.class,
						primaryKey);

				if (primaryData != null) {
					cacheResult(primaryData);
				}
				else {
					EntityCacheUtil.putResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
						PrimaryDataImpl.class, primaryKey, _nullPrimaryData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PrimaryDataModelImpl.ENTITY_CACHE_ENABLED,
					PrimaryDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return primaryData;
	}

	/**
	 * Returns the primary data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryDataID the primary key of the primary data
	 * @return the primary data, or <code>null</code> if a primary data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimaryData fetchByPrimaryKey(long primaryDataID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)primaryDataID);
	}

	/**
	 * Returns all the primary datas.
	 *
	 * @return the primary datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary datas
	 * @param end the upper bound of the range of primary datas (not inclusive)
	 * @return the range of primary datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary datas
	 * @param end the upper bound of the range of primary datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of primary datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PrimaryData> findAll(int start, int end,
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

		List<PrimaryData> list = (List<PrimaryData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRIMARYDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRIMARYDATA;

				if (pagination) {
					sql = sql.concat(PrimaryDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PrimaryData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PrimaryData>(list);
				}
				else {
					list = (List<PrimaryData>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the primary datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PrimaryData primaryData : findAll()) {
			remove(primaryData);
		}
	}

	/**
	 * Returns the number of primary datas.
	 *
	 * @return the number of primary datas
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

				Query q = session.createQuery(_SQL_COUNT_PRIMARYDATA);

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
	 * Initializes the primary data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gfbio.model.PrimaryData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrimaryData>> listenersList = new ArrayList<ModelListener<PrimaryData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrimaryData>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrimaryDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRIMARYDATA = "SELECT primaryData FROM PrimaryData primaryData";
	private static final String _SQL_SELECT_PRIMARYDATA_WHERE = "SELECT primaryData FROM PrimaryData primaryData WHERE ";
	private static final String _SQL_COUNT_PRIMARYDATA = "SELECT COUNT(primaryData) FROM PrimaryData primaryData";
	private static final String _SQL_COUNT_PRIMARYDATA_WHERE = "SELECT COUNT(primaryData) FROM PrimaryData primaryData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "primaryData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrimaryData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PrimaryData exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrimaryDataPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"primaryDataID", "lastModifiedDate"
			});
	private static PrimaryData _nullPrimaryData = new PrimaryDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrimaryData> toCacheModel() {
				return _nullPrimaryDataCacheModel;
			}
		};

	private static CacheModel<PrimaryData> _nullPrimaryDataCacheModel = new CacheModel<PrimaryData>() {
			@Override
			public PrimaryData toEntityModel() {
				return _nullPrimaryData;
			}
		};
}