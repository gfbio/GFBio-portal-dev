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

import org.gfbio.model.DataProvider;

/**
 * The persistence interface for the data provider service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProviderPersistenceImpl
 * @see DataProviderUtil
 * @generated
 */
public interface DataProviderPersistence extends BasePersistence<DataProvider> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataProviderUtil} to access the data provider persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the data providers where name = &#63;.
	*
	* @param name the name
	* @return the matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data providers where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @return the range of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data providers where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the first data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByName_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the last data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data providers before and after the current data provider in the ordered set where name = &#63;.
	*
	* @param dataProviderID the primary key of the current data provider
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data provider
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider[] findByName_PrevAndNext(
		long dataProviderID, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Removes all the data providers where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data providers where name = &#63;.
	*
	* @param name the name
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider where label = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param label the label
	* @return the matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param label the label
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param label the label
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByLabel(java.lang.String label,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the data provider where label = &#63; from the database.
	*
	* @param label the label
	* @return the data provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider removeByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the number of data providers where label = &#63;.
	*
	* @param label the label
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider where dataProviderID = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param dataProviderID the data provider i d
	* @return the matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dataProviderID the data provider i d
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dataProviderID the data provider i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByDataProviderID(
		long dataProviderID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the data provider where dataProviderID = &#63; from the database.
	*
	* @param dataProviderID the data provider i d
	* @return the data provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider removeByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the number of data providers where dataProviderID = &#63;.
	*
	* @param dataProviderID the data provider i d
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataProviderID(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data providers where providerType = &#63;.
	*
	* @param providerType the provider type
	* @return the matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByProviderType(
		java.lang.String providerType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data providers where providerType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param providerType the provider type
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @return the range of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByProviderType(
		java.lang.String providerType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data providers where providerType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param providerType the provider type
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findByProviderType(
		java.lang.String providerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data provider in the ordered set where providerType = &#63;.
	*
	* @param providerType the provider type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByProviderType_First(
		java.lang.String providerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the first data provider in the ordered set where providerType = &#63;.
	*
	* @param providerType the provider type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByProviderType_First(
		java.lang.String providerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data provider in the ordered set where providerType = &#63;.
	*
	* @param providerType the provider type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByProviderType_Last(
		java.lang.String providerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the last data provider in the ordered set where providerType = &#63;.
	*
	* @param providerType the provider type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByProviderType_Last(
		java.lang.String providerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data providers before and after the current data provider in the ordered set where providerType = &#63;.
	*
	* @param dataProviderID the primary key of the current data provider
	* @param providerType the provider type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data provider
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider[] findByProviderType_PrevAndNext(
		long dataProviderID, java.lang.String providerType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Removes all the data providers where providerType = &#63; from the database.
	*
	* @param providerType the provider type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProviderType(java.lang.String providerType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data providers where providerType = &#63;.
	*
	* @param providerType the provider type
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public int countByProviderType(java.lang.String providerType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the data provider in the entity cache if it is enabled.
	*
	* @param dataProvider the data provider
	*/
	public void cacheResult(org.gfbio.model.DataProvider dataProvider);

	/**
	* Caches the data providers in the entity cache if it is enabled.
	*
	* @param dataProviders the data providers
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.DataProvider> dataProviders);

	/**
	* Creates a new data provider with the primary key. Does not add the data provider to the database.
	*
	* @param dataProviderID the primary key for the new data provider
	* @return the new data provider
	*/
	public org.gfbio.model.DataProvider create(long dataProviderID);

	/**
	* Removes the data provider with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider that was removed
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider remove(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	public org.gfbio.model.DataProvider updateImpl(
		org.gfbio.model.DataProvider dataProvider)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider with the primary key or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider findByPrimaryKey(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException;

	/**
	* Returns the data provider with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider, or <code>null</code> if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider fetchByPrimaryKey(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data providers.
	*
	* @return the data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data providers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @return the range of data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data providers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProviderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data providers
	* @param end the upper bound of the range of data providers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of data providers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the data providers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data providers.
	*
	* @return the number of data providers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}