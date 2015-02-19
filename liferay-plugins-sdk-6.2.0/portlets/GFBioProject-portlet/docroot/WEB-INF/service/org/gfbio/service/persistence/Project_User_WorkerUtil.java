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

import org.gfbio.model.Project_User_Worker;

import java.util.List;

/**
 * The persistence utility for the project_ user_ worker service. This utility wraps {@link Project_User_WorkerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author froemm
 * @see Project_User_WorkerPersistence
 * @see Project_User_WorkerPersistenceImpl
 * @generated
 */
public class Project_User_WorkerUtil {
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
	public static void clearCache(Project_User_Worker project_User_Worker) {
		getPersistence().clearCache(project_User_Worker);
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
	public static List<Project_User_Worker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Project_User_Worker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Project_User_Worker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Project_User_Worker update(
		Project_User_Worker project_User_Worker) throws SystemException {
		return getPersistence().update(project_User_Worker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Project_User_Worker update(
		Project_User_Worker project_User_Worker, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(project_User_Worker, serviceContext);
	}

	/**
	* Returns all the project_ user_ workers where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID);
	}

	/**
	* Returns a range of all the project_ user_ workers where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @return the range of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ workers where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProjectID(projectID, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence()
				   .findByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the first project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence()
				   .findByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the project_ user_ workers before and after the current project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param project_User_WorkerPK the primary key of the current project_ user_ worker
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker[] findByProjectID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence()
				   .findByProjectID_PrevAndNext(project_User_WorkerPK,
			projectID, orderByComparator);
	}

	/**
	* Removes all the project_ user_ workers where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of project_ user_ workers where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Returns all the project_ user_ workers where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the project_ user_ workers where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @return the range of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ workers where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker findByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker findByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker fetchByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the project_ user_ workers before and after the current project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param project_User_WorkerPK the primary key of the current project_ user_ worker
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker[] findByUserID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence()
				   .findByUserID_PrevAndNext(project_User_WorkerPK, userID,
			orderByComparator);
	}

	/**
	* Removes all the project_ user_ workers where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of project_ user_ workers where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Caches the project_ user_ worker in the entity cache if it is enabled.
	*
	* @param project_User_Worker the project_ user_ worker
	*/
	public static void cacheResult(
		org.gfbio.model.Project_User_Worker project_User_Worker) {
		getPersistence().cacheResult(project_User_Worker);
	}

	/**
	* Caches the project_ user_ workers in the entity cache if it is enabled.
	*
	* @param project_User_Workers the project_ user_ workers
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Project_User_Worker> project_User_Workers) {
		getPersistence().cacheResult(project_User_Workers);
	}

	/**
	* Creates a new project_ user_ worker with the primary key. Does not add the project_ user_ worker to the database.
	*
	* @param project_User_WorkerPK the primary key for the new project_ user_ worker
	* @return the new project_ user_ worker
	*/
	public static org.gfbio.model.Project_User_Worker create(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK) {
		return getPersistence().create(project_User_WorkerPK);
	}

	/**
	* Removes the project_ user_ worker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker that was removed
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker remove(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence().remove(project_User_WorkerPK);
	}

	public static org.gfbio.model.Project_User_Worker updateImpl(
		org.gfbio.model.Project_User_Worker project_User_Worker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(project_User_Worker);
	}

	/**
	* Returns the project_ user_ worker with the primary key or throws a {@link org.gfbio.NoSuchProject_User_WorkerException} if it could not be found.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker findByPrimaryKey(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException {
		return getPersistence().findByPrimaryKey(project_User_WorkerPK);
	}

	/**
	* Returns the project_ user_ worker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker, or <code>null</code> if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User_Worker fetchByPrimaryKey(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(project_User_WorkerPK);
	}

	/**
	* Returns all the project_ user_ workers.
	*
	* @return the project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project_ user_ workers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @return the range of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project_ user_ workers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_User_WorkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ user_ workers
	* @param end the upper bound of the range of project_ user_ workers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_User_Worker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the project_ user_ workers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project_ user_ workers.
	*
	* @return the number of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Project_User_WorkerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Project_User_WorkerPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Project_User_WorkerPersistence.class.getName());

			ReferenceRegistry.registerReference(Project_User_WorkerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Project_User_WorkerPersistence persistence) {
	}

	private static Project_User_WorkerPersistence _persistence;
}