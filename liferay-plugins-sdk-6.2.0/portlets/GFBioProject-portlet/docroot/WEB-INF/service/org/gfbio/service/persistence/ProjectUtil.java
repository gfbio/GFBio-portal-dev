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

import org.gfbio.model.Project;

import java.util.List;

/**
 * The persistence utility for the project service. This utility wraps {@link ProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author froemm
 * @see ProjectPersistence
 * @see ProjectPersistenceImpl
 * @generated
 */
public class ProjectUtil {
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
	public static void clearCache(Project project) {
		getPersistence().clearCache(project);
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
	public static List<Project> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Project> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Project> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Project update(Project project) throws SystemException {
		return getPersistence().update(project);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Project update(Project project, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(project, serviceContext);
	}

	/**
	* Returns all the projects where name = &#63;.
	*
	* @param name the name
	* @return the matching projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the projects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @return the range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the projects where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first project in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project
	* @throws org.gfbio.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first project in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project, or <code>null</code> if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last project in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project
	* @throws org.gfbio.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last project in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project, or <code>null</code> if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the projects before and after the current project in the ordered set where name = &#63;.
	*
	* @param projectID the primary key of the current project
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project
	* @throws org.gfbio.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project[] findByName_PrevAndNext(
		long projectID, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence()
				   .findByName_PrevAndNext(projectID, name, orderByComparator);
	}

	/**
	* Removes all the projects where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of projects where name = &#63;.
	*
	* @param name the name
	* @return the number of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the project where projectID = &#63; or throws a {@link org.gfbio.NoSuchProjectException} if it could not be found.
	*
	* @param projectID the project i d
	* @return the matching project
	* @throws org.gfbio.NoSuchProjectException if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project findByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().findByProjectID(projectID);
	}

	/**
	* Returns the project where projectID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectID the project i d
	* @return the matching project, or <code>null</code> if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project fetchByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProjectID(projectID);
	}

	/**
	* Returns the project where projectID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectID the project i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching project, or <code>null</code> if a matching project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project fetchByProjectID(long projectID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByProjectID(projectID, retrieveFromCache);
	}

	/**
	* Removes the project where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @return the project that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Caches the project in the entity cache if it is enabled.
	*
	* @param project the project
	*/
	public static void cacheResult(org.gfbio.model.Project project) {
		getPersistence().cacheResult(project);
	}

	/**
	* Caches the projects in the entity cache if it is enabled.
	*
	* @param projects the projects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Project> projects) {
		getPersistence().cacheResult(projects);
	}

	/**
	* Creates a new project with the primary key. Does not add the project to the database.
	*
	* @param projectID the primary key for the new project
	* @return the new project
	*/
	public static org.gfbio.model.Project create(long projectID) {
		return getPersistence().create(projectID);
	}

	/**
	* Removes the project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectID the primary key of the project
	* @return the project that was removed
	* @throws org.gfbio.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project remove(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().remove(projectID);
	}

	public static org.gfbio.model.Project updateImpl(
		org.gfbio.model.Project project)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(project);
	}

	/**
	* Returns the project with the primary key or throws a {@link org.gfbio.NoSuchProjectException} if it could not be found.
	*
	* @param projectID the primary key of the project
	* @return the project
	* @throws org.gfbio.NoSuchProjectException if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project findByPrimaryKey(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProjectException {
		return getPersistence().findByPrimaryKey(projectID);
	}

	/**
	* Returns the project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectID the primary key of the project
	* @return the project, or <code>null</code> if a project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project fetchByPrimaryKey(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(projectID);
	}

	/**
	* Returns all the projects.
	*
	* @return the projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @return the range of projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of projects
	* @param end the upper bound of the range of projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of projects.
	*
	* @return the number of projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					ProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(ProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProjectPersistence persistence) {
	}

	private static ProjectPersistence _persistence;
}