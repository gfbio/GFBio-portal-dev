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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.PrimaryData;

/**
 * The persistence interface for the primary data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PrimaryDataPersistenceImpl
 * @see PrimaryDataUtil
 * @generated
 */
public interface PrimaryDataPersistence extends BasePersistence<PrimaryData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrimaryDataUtil} to access the primary data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the primary data where primaryDataID = &#63; or throws a {@link org.gfbio.NoSuchPrimaryDataException} if it could not be found.
	*
	* @param primaryDataID the primary data i d
	* @return the matching primary data
	* @throws org.gfbio.NoSuchPrimaryDataException if a matching primary data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData findByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryDataException;

	/**
	* Returns the primary data where primaryDataID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param primaryDataID the primary data i d
	* @return the matching primary data, or <code>null</code> if a matching primary data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData fetchByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary data where primaryDataID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param primaryDataID the primary data i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching primary data, or <code>null</code> if a matching primary data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData fetchByPrimaryDataID(
		long primaryDataID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the primary data where primaryDataID = &#63; from the database.
	*
	* @param primaryDataID the primary data i d
	* @return the primary data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData removeByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryDataException;

	/**
	* Returns the number of primary datas where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @return the number of matching primary datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the primary data in the entity cache if it is enabled.
	*
	* @param primaryData the primary data
	*/
	public void cacheResult(org.gfbio.model.PrimaryData primaryData);

	/**
	* Caches the primary datas in the entity cache if it is enabled.
	*
	* @param primaryDatas the primary datas
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.PrimaryData> primaryDatas);

	/**
	* Creates a new primary data with the primary key. Does not add the primary data to the database.
	*
	* @param primaryDataID the primary key for the new primary data
	* @return the new primary data
	*/
	public org.gfbio.model.PrimaryData create(long primaryDataID);

	/**
	* Removes the primary data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryDataID the primary key of the primary data
	* @return the primary data that was removed
	* @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData remove(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryDataException;

	public org.gfbio.model.PrimaryData updateImpl(
		org.gfbio.model.PrimaryData primaryData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary data with the primary key or throws a {@link org.gfbio.NoSuchPrimaryDataException} if it could not be found.
	*
	* @param primaryDataID the primary key of the primary data
	* @return the primary data
	* @throws org.gfbio.NoSuchPrimaryDataException if a primary data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData findByPrimaryKey(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryDataException;

	/**
	* Returns the primary data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryDataID the primary key of the primary data
	* @return the primary data, or <code>null</code> if a primary data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.PrimaryData fetchByPrimaryKey(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the primary datas.
	*
	* @return the primary datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.PrimaryData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.PrimaryData> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.PrimaryData> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the primary datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of primary datas.
	*
	* @return the number of primary datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}