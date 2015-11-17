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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.DataProvider_PersistentIdentifier;

/**
 * The persistence interface for the data provider_ persistent identifier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see DataProvider_PersistentIdentifierPersistenceImpl
 * @see DataProvider_PersistentIdentifierUtil
 * @generated
 */
public interface DataProvider_PersistentIdentifierPersistence
	extends BasePersistence<DataProvider_PersistentIdentifier> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataProvider_PersistentIdentifierUtil} to access the data provider_ persistent identifier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @return the matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @return the range of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByDataProvider(
		long gfbioDataProvider, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier findByDataProvider_First(
		long gfbioDataProvider,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Returns the first data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchByDataProvider_First(
		long gfbioDataProvider,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier findByDataProvider_Last(
		long gfbioDataProvider,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Returns the last data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchByDataProvider_Last(
		long gfbioDataProvider,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider_ persistent identifiers before and after the current data provider_ persistent identifier in the ordered set where gfbioDataProvider = &#63;.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the current data provider_ persistent identifier
	* @param gfbioDataProvider the gfbio data provider
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier[] findByDataProvider_PrevAndNext(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK,
		long gfbioDataProvider,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Removes all the data provider_ persistent identifiers where gfbioDataProvider = &#63; from the database.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDataProvider(long gfbioDataProvider)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data provider_ persistent identifiers where gfbioDataProvider = &#63;.
	*
	* @param gfbioDataProvider the gfbio data provider
	* @return the number of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataProvider(long gfbioDataProvider)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @return the matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @return the range of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findByPersistentIdentifier(
		long gfbioPersistentIdentifier, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier findByPersistentIdentifier_First(
		long gfbioPersistentIdentifier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Returns the first data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchByPersistentIdentifier_First(
		long gfbioPersistentIdentifier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier findByPersistentIdentifier_Last(
		long gfbioPersistentIdentifier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Returns the last data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data provider_ persistent identifier, or <code>null</code> if a matching data provider_ persistent identifier could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchByPersistentIdentifier_Last(
		long gfbioPersistentIdentifier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider_ persistent identifiers before and after the current data provider_ persistent identifier in the ordered set where gfbioPersistentIdentifier = &#63;.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the current data provider_ persistent identifier
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier[] findByPersistentIdentifier_PrevAndNext(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK,
		long gfbioPersistentIdentifier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Removes all the data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63; from the database.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPersistentIdentifier(long gfbioPersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data provider_ persistent identifiers where gfbioPersistentIdentifier = &#63;.
	*
	* @param gfbioPersistentIdentifier the gfbio persistent identifier
	* @return the number of matching data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public int countByPersistentIdentifier(long gfbioPersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the data provider_ persistent identifier in the entity cache if it is enabled.
	*
	* @param dataProvider_PersistentIdentifier the data provider_ persistent identifier
	*/
	public void cacheResult(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier);

	/**
	* Caches the data provider_ persistent identifiers in the entity cache if it is enabled.
	*
	* @param dataProvider_PersistentIdentifiers the data provider_ persistent identifiers
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> dataProvider_PersistentIdentifiers);

	/**
	* Creates a new data provider_ persistent identifier with the primary key. Does not add the data provider_ persistent identifier to the database.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key for the new data provider_ persistent identifier
	* @return the new data provider_ persistent identifier
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier create(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK);

	/**
	* Removes the data provider_ persistent identifier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	* @return the data provider_ persistent identifier that was removed
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier remove(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	public org.gfbio.model.DataProvider_PersistentIdentifier updateImpl(
		org.gfbio.model.DataProvider_PersistentIdentifier dataProvider_PersistentIdentifier)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data provider_ persistent identifier with the primary key or throws a {@link org.gfbio.NoSuchDataProvider_PersistentIdentifierException} if it could not be found.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	* @return the data provider_ persistent identifier
	* @throws org.gfbio.NoSuchDataProvider_PersistentIdentifierException if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier findByPrimaryKey(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchDataProvider_PersistentIdentifierException;

	/**
	* Returns the data provider_ persistent identifier with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dataProvider_PersistentIdentifierPK the primary key of the data provider_ persistent identifier
	* @return the data provider_ persistent identifier, or <code>null</code> if a data provider_ persistent identifier with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.DataProvider_PersistentIdentifier fetchByPrimaryKey(
		org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK dataProvider_PersistentIdentifierPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data provider_ persistent identifiers.
	*
	* @return the data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data provider_ persistent identifiers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @return the range of data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data provider_ persistent identifiers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.DataProvider_PersistentIdentifierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data provider_ persistent identifiers
	* @param end the upper bound of the range of data provider_ persistent identifiers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.DataProvider_PersistentIdentifier> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the data provider_ persistent identifiers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data provider_ persistent identifiers.
	*
	* @return the number of data provider_ persistent identifiers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}