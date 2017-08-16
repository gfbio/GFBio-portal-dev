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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.PrimaryData_ResearchObject;

import java.util.List;

/**
 * The persistence utility for the primary data_ research object service. This utility wraps {@link PrimaryData_ResearchObjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see PrimaryData_ResearchObjectPersistence
 * @see PrimaryData_ResearchObjectPersistenceImpl
 * @generated
 */
public class PrimaryData_ResearchObjectUtil {
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
	public static void clearCache(
		PrimaryData_ResearchObject primaryData_ResearchObject) {
		getPersistence().clearCache(primaryData_ResearchObject);
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
	public static List<PrimaryData_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PrimaryData_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PrimaryData_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PrimaryData_ResearchObject update(
		PrimaryData_ResearchObject primaryData_ResearchObject)
		throws SystemException {
		return getPersistence().update(primaryData_ResearchObject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PrimaryData_ResearchObject update(
		PrimaryData_ResearchObject primaryData_ResearchObject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(primaryData_ResearchObject, serviceContext);
	}

	/**
	* Returns all the primary data_ research objects where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @return the matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryDataID(primaryDataID);
	}

	/**
	* Returns a range of all the primary data_ research objects where primaryDataID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param primaryDataID the primary data i d
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @return the range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryDataID(primaryDataID, start, end);
	}

	/**
	* Returns an ordered range of all the primary data_ research objects where primaryDataID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param primaryDataID the primary data i d
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByPrimaryDataID(
		long primaryDataID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrimaryDataID(primaryDataID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByPrimaryDataID_First(
		long primaryDataID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByPrimaryDataID_First(primaryDataID, orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByPrimaryDataID_First(
		long primaryDataID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryDataID_First(primaryDataID, orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByPrimaryDataID_Last(
		long primaryDataID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByPrimaryDataID_Last(primaryDataID, orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByPrimaryDataID_Last(
		long primaryDataID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrimaryDataID_Last(primaryDataID, orderByComparator);
	}

	/**
	* Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where primaryDataID = &#63;.
	*
	* @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	* @param primaryDataID the primary data i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject[] findByPrimaryDataID_PrevAndNext(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long primaryDataID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByPrimaryDataID_PrevAndNext(primaryData_ResearchObjectPK,
			primaryDataID, orderByComparator);
	}

	/**
	* Removes all the primary data_ research objects where primaryDataID = &#63; from the database.
	*
	* @param primaryDataID the primary data i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrimaryDataID(primaryDataID);
	}

	/**
	* Returns the number of primary data_ research objects where primaryDataID = &#63;.
	*
	* @param primaryDataID the primary data i d
	* @return the number of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrimaryDataID(long primaryDataID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPrimaryDataID(primaryDataID);
	}

	/**
	* Returns all the primary data_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResearchObjectID(researchObjectID);
	}

	/**
	* Returns a range of all the primary data_ research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @return the range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end);
	}

	/**
	* Returns an ordered range of all the primary data_ research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject[] findByResearchObjectID_PrevAndNext(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_PrevAndNext(primaryData_ResearchObjectPK,
			researchObjectID, orderByComparator);
	}

	/**
	* Removes all the primary data_ research objects where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the number of primary data_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResearchObjectID(researchObjectID);
	}

	/**
	* Returns all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns a range of all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @return the range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, start, end);
	}

	/**
	* Returns an ordered range of all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, start, end, orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the first primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDAndVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching primary data_ research object, or <code>null</code> if a matching primary data_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDAndVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the primary data_ research objects before and after the current primary data_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param primaryData_ResearchObjectPK the primary key of the current primary data_ research object
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject[] findByResearchObjectIDAndVersion_PrevAndNext(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK,
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_PrevAndNext(primaryData_ResearchObjectPK,
			researchObjectID, researchObjectVersion, orderByComparator);
	}

	/**
	* Removes all the primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns the number of primary data_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Caches the primary data_ research object in the entity cache if it is enabled.
	*
	* @param primaryData_ResearchObject the primary data_ research object
	*/
	public static void cacheResult(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject) {
		getPersistence().cacheResult(primaryData_ResearchObject);
	}

	/**
	* Caches the primary data_ research objects in the entity cache if it is enabled.
	*
	* @param primaryData_ResearchObjects the primary data_ research objects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.PrimaryData_ResearchObject> primaryData_ResearchObjects) {
		getPersistence().cacheResult(primaryData_ResearchObjects);
	}

	/**
	* Creates a new primary data_ research object with the primary key. Does not add the primary data_ research object to the database.
	*
	* @param primaryData_ResearchObjectPK the primary key for the new primary data_ research object
	* @return the new primary data_ research object
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject create(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK) {
		return getPersistence().create(primaryData_ResearchObjectPK);
	}

	/**
	* Removes the primary data_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	* @return the primary data_ research object that was removed
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject remove(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence().remove(primaryData_ResearchObjectPK);
	}

	public static org.gfbio.model.PrimaryData_ResearchObject updateImpl(
		org.gfbio.model.PrimaryData_ResearchObject primaryData_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(primaryData_ResearchObject);
	}

	/**
	* Returns the primary data_ research object with the primary key or throws a {@link org.gfbio.NoSuchPrimaryData_ResearchObjectException} if it could not be found.
	*
	* @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	* @return the primary data_ research object
	* @throws org.gfbio.NoSuchPrimaryData_ResearchObjectException if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject findByPrimaryKey(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPrimaryData_ResearchObjectException {
		return getPersistence().findByPrimaryKey(primaryData_ResearchObjectPK);
	}

	/**
	* Returns the primary data_ research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryData_ResearchObjectPK the primary key of the primary data_ research object
	* @return the primary data_ research object, or <code>null</code> if a primary data_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.PrimaryData_ResearchObject fetchByPrimaryKey(
		org.gfbio.service.persistence.PrimaryData_ResearchObjectPK primaryData_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(primaryData_ResearchObjectPK);
	}

	/**
	* Returns all the primary data_ research objects.
	*
	* @return the primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the primary data_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @return the range of primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the primary data_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PrimaryData_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of primary data_ research objects
	* @param end the upper bound of the range of primary data_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.PrimaryData_ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the primary data_ research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of primary data_ research objects.
	*
	* @return the number of primary data_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PrimaryData_ResearchObjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PrimaryData_ResearchObjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					PrimaryData_ResearchObjectPersistence.class.getName());

			ReferenceRegistry.registerReference(PrimaryData_ResearchObjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		PrimaryData_ResearchObjectPersistence persistence) {
	}

	private static PrimaryData_ResearchObjectPersistence _persistence;
}