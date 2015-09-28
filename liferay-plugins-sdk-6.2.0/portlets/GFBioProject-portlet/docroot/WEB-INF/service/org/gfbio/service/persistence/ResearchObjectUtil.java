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

import org.gfbio.model.ResearchObject;

import java.util.List;

/**
 * The persistence utility for the research object service. This utility wraps {@link ResearchObjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObjectPersistence
 * @see ResearchObjectPersistenceImpl
 * @generated
 */
public class ResearchObjectUtil {
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
	public static void clearCache(ResearchObject researchObject) {
		getPersistence().clearCache(researchObject);
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
	public static List<ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ResearchObject update(ResearchObject researchObject)
		throws SystemException {
		return getPersistence().update(researchObject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ResearchObject update(ResearchObject researchObject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(researchObject, serviceContext);
	}

	/**
	* Returns all the research objects where name = &#63;.
	*
	* @param name the name
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the research objects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the research objects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last research object in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the research objects before and after the current research object in the ordered set where name = &#63;.
	*
	* @param researchObjectID the primary key of the current research object
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject[] findByName_PrevAndNext(
		long researchObjectID, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence()
				   .findByName_PrevAndNext(researchObjectID, name,
			orderByComparator);
	}

	/**
	* Removes all the research objects where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of research objects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the research objects where label = &#63;.
	*
	* @param label the label
	* @return the matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLabel(label);
	}

	/**
	* Returns a range of all the research objects where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLabel(label, start, end);
	}

	/**
	* Returns an ordered range of all the research objects where label = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label the label
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findByLabel(
		java.lang.String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLabel(label, start, end, orderByComparator);
	}

	/**
	* Returns the first research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByLabel_First(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByLabel_First(label, orderByComparator);
	}

	/**
	* Returns the first research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByLabel_First(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel_First(label, orderByComparator);
	}

	/**
	* Returns the last research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByLabel_Last(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByLabel_Last(label, orderByComparator);
	}

	/**
	* Returns the last research object in the ordered set where label = &#63;.
	*
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByLabel_Last(
		java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel_Last(label, orderByComparator);
	}

	/**
	* Returns the research objects before and after the current research object in the ordered set where label = &#63;.
	*
	* @param researchObjectID the primary key of the current research object
	* @param label the label
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject[] findByLabel_PrevAndNext(
		long researchObjectID, java.lang.String label,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence()
				   .findByLabel_PrevAndNext(researchObjectID, label,
			orderByComparator);
	}

	/**
	* Removes all the research objects where label = &#63; from the database.
	*
	* @param label the label
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLabel(label);
	}

	/**
	* Returns the number of research objects where label = &#63;.
	*
	* @param label the label
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLabel(label);
	}

	/**
	* Returns the research object where researchObjectID = &#63; or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @return the matching research object
	* @throws org.gfbio.NoSuchResearchObjectException if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the research object where researchObjectID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @return the matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the research object where researchObjectID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching research object, or <code>null</code> if a matching research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByResearchObjectID(
		long researchObjectID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID(researchObjectID, retrieveFromCache);
	}

	/**
	* Removes the research object where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @return the research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject removeByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().removeByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the number of research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResearchObjectID(researchObjectID);
	}

	/**
	* Caches the research object in the entity cache if it is enabled.
	*
	* @param researchObject the research object
	*/
	public static void cacheResult(
		org.gfbio.model.ResearchObject researchObject) {
		getPersistence().cacheResult(researchObject);
	}

	/**
	* Caches the research objects in the entity cache if it is enabled.
	*
	* @param researchObjects the research objects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.ResearchObject> researchObjects) {
		getPersistence().cacheResult(researchObjects);
	}

	/**
	* Creates a new research object with the primary key. Does not add the research object to the database.
	*
	* @param researchObjectID the primary key for the new research object
	* @return the new research object
	*/
	public static org.gfbio.model.ResearchObject create(long researchObjectID) {
		return getPersistence().create(researchObjectID);
	}

	/**
	* Removes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObjectID the primary key of the research object
	* @return the research object that was removed
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject remove(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().remove(researchObjectID);
	}

	public static org.gfbio.model.ResearchObject updateImpl(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(researchObject);
	}

	/**
	* Returns the research object with the primary key or throws a {@link org.gfbio.NoSuchResearchObjectException} if it could not be found.
	*
	* @param researchObjectID the primary key of the research object
	* @return the research object
	* @throws org.gfbio.NoSuchResearchObjectException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject findByPrimaryKey(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getPersistence().findByPrimaryKey(researchObjectID);
	}

	/**
	* Returns the research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param researchObjectID the primary key of the research object
	* @return the research object, or <code>null</code> if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject fetchByPrimaryKey(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(researchObjectID);
	}

	/**
	* Returns all the research objects.
	*
	* @return the research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of research objects.
	*
	* @return the number of research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ResearchObjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ResearchObjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ResearchObjectPersistence.class.getName());

			ReferenceRegistry.registerReference(ResearchObjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ResearchObjectPersistence persistence) {
	}

	private static ResearchObjectPersistence _persistence;
}