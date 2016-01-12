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

import org.gfbio.model.Project_User_PI;

import java.util.List;

/**
 * The persistence utility for the project_ user_ p i service. This utility wraps {@link Project_User_PIPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_User_PIPersistence
 * @see Project_User_PIPersistenceImpl
 * @generated
 */
public class Project_User_PIUtil {
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
	public static void clearCache(Project_User_PI project_User_PI) {
		getPersistence().clearCache(project_User_PI);
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
	public static List<Project_User_PI> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Project_User_PI> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Project_User_PI> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Project_User_PI update(Project_User_PI project_User_PI)
		throws SystemException {
		return getPersistence().update(project_User_PI);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Project_User_PI update(Project_User_PI project_User_PI,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(project_User_PI, serviceContext);
	}

	/**
	* Returns all the project_ user_ p is where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID);
	}

	/**
	* Returns a range of all the project_ user_ p is where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @return the range of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ p is where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProjectID(projectID, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ user_ p i in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence()
				   .findByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the first project_ user_ p i in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ p i in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence()
				   .findByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ p i in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the project_ user_ p is before and after the current project_ user_ p i in the ordered set where projectID = &#63;.
	*
	* @param project_User_PIPK the primary key of the current project_ user_ p i
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI[] findByProjectID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence()
				   .findByProjectID_PrevAndNext(project_User_PIPK, projectID,
			orderByComparator);
	}

	/**
	* Removes all the project_ user_ p is where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of project_ user_ p is where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Returns all the project_ user_ p is where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the project_ user_ p is where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @return the range of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ p is where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ user_ p i in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI findByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first project_ user_ p i in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ p i in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI findByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ p i in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ p i, or <code>null</code> if a matching project_ user_ p i could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI fetchByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the project_ user_ p is before and after the current project_ user_ p i in the ordered set where userID = &#63;.
	*
	* @param project_User_PIPK the primary key of the current project_ user_ p i
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI[] findByUserID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence()
				   .findByUserID_PrevAndNext(project_User_PIPK, userID,
			orderByComparator);
	}

	/**
	* Removes all the project_ user_ p is where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of project_ user_ p is where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Caches the project_ user_ p i in the entity cache if it is enabled.
	*
	* @param project_User_PI the project_ user_ p i
	*/
	public static void cacheResult(
		org.gfbio.model.Project_User_PI project_User_PI) {
		getPersistence().cacheResult(project_User_PI);
	}

	/**
	* Caches the project_ user_ p is in the entity cache if it is enabled.
	*
	* @param project_User_PIs the project_ user_ p is
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Project_User_PI> project_User_PIs) {
		getPersistence().cacheResult(project_User_PIs);
	}

	/**
	* Creates a new project_ user_ p i with the primary key. Does not add the project_ user_ p i to the database.
	*
	* @param project_User_PIPK the primary key for the new project_ user_ p i
	* @return the new project_ user_ p i
	*/
	public static org.gfbio.model.Project_User_PI create(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK) {
		return getPersistence().create(project_User_PIPK);
	}

	/**
	* Removes the project_ user_ p i with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_PIPK the primary key of the project_ user_ p i
	* @return the project_ user_ p i that was removed
	* @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI remove(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence().remove(project_User_PIPK);
	}

	public static org.gfbio.model.Project_User_PI updateImpl(
		org.gfbio.model.Project_User_PI project_User_PI)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(project_User_PI);
	}

	/**
	* Returns the project_ user_ p i with the primary key or throws a {@link org.gfbio.NoSuchProject_User_PIException} if it could not be found.
	*
	* @param project_User_PIPK the primary key of the project_ user_ p i
	* @return the project_ user_ p i
	* @throws org.gfbio.NoSuchProject_User_PIException if a project_ user_ p i with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI findByPrimaryKey(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_PIException {
		return getPersistence().findByPrimaryKey(project_User_PIPK);
	}

	/**
	* Returns the project_ user_ p i with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_User_PIPK the primary key of the project_ user_ p i
	* @return the project_ user_ p i, or <code>null</code> if a project_ user_ p i with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_PI fetchByPrimaryKey(
		org.gfbio.service.persistence.Project_User_PIPK project_User_PIPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(project_User_PIPK);
	}

	/**
	* Returns all the project_ user_ p is.
	*
	* @return the project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project_ user_ p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @return the range of project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ p is.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_PIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ user_ p is
	* @param end the upper bound of the range of project_ user_ p is (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_PI> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the project_ user_ p is from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project_ user_ p is.
	*
	* @return the number of project_ user_ p is
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Project_User_PIPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Project_User_PIPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Project_User_PIPersistence.class.getName());

			ReferenceRegistry.registerReference(Project_User_PIUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Project_User_PIPersistence persistence) {
	}

	private static Project_User_PIPersistence _persistence;
}