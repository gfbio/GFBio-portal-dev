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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.DataProvider;

import java.util.List;

/**
 * The persistence utility for the data provider service. This utility wraps {@link DataProviderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProviderPersistence
 * @see DataProviderPersistenceImpl
 * @generated
 */
public class DataProviderUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DataProvider dataProvider) {
		getPersistence().clearCache(dataProvider);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataProvider> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataProvider> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataProvider> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DataProvider update(DataProvider dataProvider)
		throws SystemException {
		return getPersistence().update(dataProvider);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DataProvider update(DataProvider dataProvider,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dataProvider, serviceContext);
	}

	/**
	* Returns all the data providers where name = &#63;.
	*
	* @param name the name
	* @return the matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

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
	public static java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

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
	public static java.util.List<org.gfbio.model.DataProvider> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last data provider in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

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
	public static org.gfbio.model.DataProvider[] findByName_PrevAndNext(
		long dataProviderID, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence()
				   .findByName_PrevAndNext(dataProviderID, name,
			orderByComparator);
	}

	/**
	* Removes all the data providers where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of data providers where name = &#63;.
	*
	* @param name the name
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the data provider where label = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param label the label
	* @return the matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider findByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().findByLabel(label);
	}

	/**
	* Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param label the label
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label);
	}

	/**
	* Returns the data provider where label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param label the label
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByLabel(
		java.lang.String label, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label, retrieveFromCache);
	}

	/**
	* Removes the data provider where label = &#63; from the database.
	*
	* @param label the label
	* @return the data provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider removeByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().removeByLabel(label);
	}

	/**
	* Returns the number of data providers where label = &#63;.
	*
	* @param label the label
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLabel(label);
	}

	/**
	* Returns the data provider where dataProviderID = &#63; or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param dataProviderID the data provider i d
	* @return the matching data provider
	* @throws org.gfbio.NoSuchDataProviderException if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider findByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().findByDataProviderID(dataProviderID);
	}

	/**
	* Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dataProviderID the data provider i d
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDataProviderID(dataProviderID);
	}

	/**
	* Returns the data provider where dataProviderID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dataProviderID the data provider i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching data provider, or <code>null</code> if a matching data provider could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByDataProviderID(
		long dataProviderID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDataProviderID(dataProviderID, retrieveFromCache);
	}

	/**
	* Removes the data provider where dataProviderID = &#63; from the database.
	*
	* @param dataProviderID the data provider i d
	* @return the data provider that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider removeByDataProviderID(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().removeByDataProviderID(dataProviderID);
	}

	/**
	* Returns the number of data providers where dataProviderID = &#63;.
	*
	* @param dataProviderID the data provider i d
	* @return the number of matching data providers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDataProviderID(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDataProviderID(dataProviderID);
	}

	/**
	* Caches the data provider in the entity cache if it is enabled.
	*
	* @param dataProvider the data provider
	*/
	public static void cacheResult(org.gfbio.model.DataProvider dataProvider) {
		getPersistence().cacheResult(dataProvider);
	}

	/**
	* Caches the data providers in the entity cache if it is enabled.
	*
	* @param dataProviders the data providers
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.DataProvider> dataProviders) {
		getPersistence().cacheResult(dataProviders);
	}

	/**
	* Creates a new data provider with the primary key. Does not add the data provider to the database.
	*
	* @param dataProviderID the primary key for the new data provider
	* @return the new data provider
	*/
	public static org.gfbio.model.DataProvider create(long dataProviderID) {
		return getPersistence().create(dataProviderID);
	}

	/**
	* Removes the data provider with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider that was removed
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider remove(long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().remove(dataProviderID);
	}

	public static org.gfbio.model.DataProvider updateImpl(
		org.gfbio.model.DataProvider dataProvider)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dataProvider);
	}

	/**
	* Returns the data provider with the primary key or throws a {@link org.gfbio.NoSuchDataProviderException} if it could not be found.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider
	* @throws org.gfbio.NoSuchDataProviderException if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider findByPrimaryKey(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProviderException {
		return getPersistence().findByPrimaryKey(dataProviderID);
	}

	/**
	* Returns the data provider with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dataProviderID the primary key of the data provider
	* @return the data provider, or <code>null</code> if a data provider with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.DataProvider fetchByPrimaryKey(
		long dataProviderID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dataProviderID);
	}

	/**
	* Returns all the data providers.
	*
	* @return the data providers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.DataProvider> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gfbio.model.DataProvider> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gfbio.model.DataProvider> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the data providers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of data providers.
	*
	* @return the number of data providers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DataProviderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DataProviderPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					DataProviderPersistence.class.getName());

			ReferenceRegistry.registerReference(DataProviderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DataProviderPersistence persistence) {
	}

	private static DataProviderPersistence _persistence;
}