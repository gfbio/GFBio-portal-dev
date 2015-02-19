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

import org.gfbio.model.tab_ResearchObject;

import java.util.List;

/**
 * The persistence utility for the tab_ research object service. This utility wraps {@link tab_ResearchObjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see tab_ResearchObjectPersistence
 * @see tab_ResearchObjectPersistenceImpl
 * @generated
 */
public class tab_ResearchObjectUtil {
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
	public static void clearCache(tab_ResearchObject tab_ResearchObject) {
		getPersistence().clearCache(tab_ResearchObject);
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
	public static List<tab_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<tab_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<tab_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static tab_ResearchObject update(
		tab_ResearchObject tab_ResearchObject) throws SystemException {
		return getPersistence().update(tab_ResearchObject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static tab_ResearchObject update(
		tab_ResearchObject tab_ResearchObject, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tab_ResearchObject, serviceContext);
	}

	/**
	* Returns all the tab_ research objects where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @return the matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(ro_name);
	}

	/**
	* Returns a range of all the tab_ research objects where ro_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ro_name the ro_name
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @return the range of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(ro_name, start, end);
	}

	/**
	* Returns an ordered range of all the tab_ research objects where ro_name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ro_name the ro_name
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findByName(
		java.lang.String ro_name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(ro_name, start, end, orderByComparator);
	}

	/**
	* Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject findByName_First(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException {
		return getPersistence().findByName_First(ro_name, orderByComparator);
	}

	/**
	* Returns the first tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject fetchByName_First(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(ro_name, orderByComparator);
	}

	/**
	* Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject findByName_Last(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException {
		return getPersistence().findByName_Last(ro_name, orderByComparator);
	}

	/**
	* Returns the last tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tab_ research object, or <code>null</code> if a matching tab_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject fetchByName_Last(
		java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(ro_name, orderByComparator);
	}

	/**
	* Returns the tab_ research objects before and after the current tab_ research object in the ordered set where ro_name = &#63;.
	*
	* @param ro_ID the primary key of the current tab_ research object
	* @param ro_name the ro_name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject[] findByName_PrevAndNext(
		long ro_ID, java.lang.String ro_name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException {
		return getPersistence()
				   .findByName_PrevAndNext(ro_ID, ro_name, orderByComparator);
	}

	/**
	* Removes all the tab_ research objects where ro_name = &#63; from the database.
	*
	* @param ro_name the ro_name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(ro_name);
	}

	/**
	* Returns the number of tab_ research objects where ro_name = &#63;.
	*
	* @param ro_name the ro_name
	* @return the number of matching tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String ro_name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(ro_name);
	}

	/**
	* Caches the tab_ research object in the entity cache if it is enabled.
	*
	* @param tab_ResearchObject the tab_ research object
	*/
	public static void cacheResult(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject) {
		getPersistence().cacheResult(tab_ResearchObject);
	}

	/**
	* Caches the tab_ research objects in the entity cache if it is enabled.
	*
	* @param tab_ResearchObjects the tab_ research objects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.tab_ResearchObject> tab_ResearchObjects) {
		getPersistence().cacheResult(tab_ResearchObjects);
	}

	/**
	* Creates a new tab_ research object with the primary key. Does not add the tab_ research object to the database.
	*
	* @param ro_ID the primary key for the new tab_ research object
	* @return the new tab_ research object
	*/
	public static org.gfbio.model.tab_ResearchObject create(long ro_ID) {
		return getPersistence().create(ro_ID);
	}

	/**
	* Removes the tab_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object that was removed
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject remove(long ro_ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException {
		return getPersistence().remove(ro_ID);
	}

	public static org.gfbio.model.tab_ResearchObject updateImpl(
		org.gfbio.model.tab_ResearchObject tab_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tab_ResearchObject);
	}

	/**
	* Returns the tab_ research object with the primary key or throws a {@link org.gfbio.NoSuchtab_ResearchObjectException} if it could not be found.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object
	* @throws org.gfbio.NoSuchtab_ResearchObjectException if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject findByPrimaryKey(
		long ro_ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchtab_ResearchObjectException {
		return getPersistence().findByPrimaryKey(ro_ID);
	}

	/**
	* Returns the tab_ research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ro_ID the primary key of the tab_ research object
	* @return the tab_ research object, or <code>null</code> if a tab_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.tab_ResearchObject fetchByPrimaryKey(
		long ro_ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ro_ID);
	}

	/**
	* Returns all the tab_ research objects.
	*
	* @return the tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tab_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @return the range of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tab_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.tab_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tab_ research objects
	* @param end the upper bound of the range of tab_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.tab_ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tab_ research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tab_ research objects.
	*
	* @return the number of tab_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static tab_ResearchObjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (tab_ResearchObjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					tab_ResearchObjectPersistence.class.getName());

			ReferenceRegistry.registerReference(tab_ResearchObjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(tab_ResearchObjectPersistence persistence) {
	}

	private static tab_ResearchObjectPersistence _persistence;
}