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

import org.gfbio.model.Project_ResearchObject;

import java.util.List;

/**
 * The persistence utility for the project_ research object service. This utility wraps {@link Project_ResearchObjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_ResearchObjectPersistence
 * @see Project_ResearchObjectPersistenceImpl
 * @generated
 */
public class Project_ResearchObjectUtil {
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
	public static void clearCache(Project_ResearchObject project_ResearchObject) {
		getPersistence().clearCache(project_ResearchObject);
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
	public static List<Project_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Project_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Project_ResearchObject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Project_ResearchObject update(
		Project_ResearchObject project_ResearchObject)
		throws SystemException {
		return getPersistence().update(project_ResearchObject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Project_ResearchObject update(
		Project_ResearchObject project_ResearchObject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(project_ResearchObject, serviceContext);
	}

	/**
	* Returns all the project_ research objects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID);
	}

	/**
	* Returns a range of all the project_ research objects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @return the range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ research objects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProjectID(projectID, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the project_ research objects before and after the current project_ research object in the ordered set where projectID = &#63;.
	*
	* @param project_ResearchObjectPK the primary key of the current project_ research object
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject[] findByProjectID_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK, long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByProjectID_PrevAndNext(project_ResearchObjectPK,
			projectID, orderByComparator);
	}

	/**
	* Removes all the project_ research objects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of project_ research objects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Returns all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns a range of all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @return the range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID,
			researchObjectVersion, start, end);
	}

	/**
	* Returns an ordered range of all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int researchObjectVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID,
			researchObjectVersion, start, end, orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByResearchObjectID_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByResearchObjectID_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByResearchObjectID_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the project_ research objects before and after the current project_ research object in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param project_ResearchObjectPK the primary key of the current project_ research object
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject[] findByResearchObjectID_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK,
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID_PrevAndNext(project_ResearchObjectPK,
			researchObjectID, researchObjectVersion, orderByComparator);
	}

	/**
	* Removes all the project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectID(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByResearchObjectID(researchObjectID, researchObjectVersion);
	}

	/**
	* Returns the number of project_ research objects where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResearchObjectID(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns all the project_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResearchObjectID2(researchObjectID);
	}

	/**
	* Returns a range of all the project_ research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @return the range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID2(researchObjectID, start, end);
	}

	/**
	* Returns an ordered range of all the project_ research objects where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID2(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID2(researchObjectID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByResearchObjectID2_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID2_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByResearchObjectID2_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID2_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByResearchObjectID2_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID2_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByResearchObjectID2_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID2_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the project_ research objects before and after the current project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param project_ResearchObjectPK the primary key of the current project_ research object
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject[] findByResearchObjectID2_PrevAndNext(
		Project_ResearchObjectPK project_ResearchObjectPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence()
				   .findByResearchObjectID2_PrevAndNext(project_ResearchObjectPK,
			researchObjectID, orderByComparator);
	}

	/**
	* Removes all the project_ research objects where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectID2(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResearchObjectID2(researchObjectID);
	}

	/**
	* Returns the number of project_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID2(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResearchObjectID2(researchObjectID);
	}

	/**
	* Caches the project_ research object in the entity cache if it is enabled.
	*
	* @param project_ResearchObject the project_ research object
	*/
	public static void cacheResult(
		org.gfbio.model.Project_ResearchObject project_ResearchObject) {
		getPersistence().cacheResult(project_ResearchObject);
	}

	/**
	* Caches the project_ research objects in the entity cache if it is enabled.
	*
	* @param project_ResearchObjects the project_ research objects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Project_ResearchObject> project_ResearchObjects) {
		getPersistence().cacheResult(project_ResearchObjects);
	}

	/**
	* Creates a new project_ research object with the primary key. Does not add the project_ research object to the database.
	*
	* @param project_ResearchObjectPK the primary key for the new project_ research object
	* @return the new project_ research object
	*/
	public static org.gfbio.model.Project_ResearchObject create(
		Project_ResearchObjectPK project_ResearchObjectPK) {
		return getPersistence().create(project_ResearchObjectPK);
	}

	/**
	* Removes the project_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object that was removed
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject remove(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence().remove(project_ResearchObjectPK);
	}

	public static org.gfbio.model.Project_ResearchObject updateImpl(
		org.gfbio.model.Project_ResearchObject project_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(project_ResearchObject);
	}

	/**
	* Returns the project_ research object with the primary key or throws a {@link org.gfbio.NoSuchProject_ResearchObjectException} if it could not be found.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject findByPrimaryKey(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException {
		return getPersistence().findByPrimaryKey(project_ResearchObjectPK);
	}

	/**
	* Returns the project_ research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object, or <code>null</code> if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_ResearchObject fetchByPrimaryKey(
		Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(project_ResearchObjectPK);
	}

	/**
	* Returns all the project_ research objects.
	*
	* @return the project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @return the range of project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project_ research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ research objects
	* @param end the upper bound of the range of project_ research objects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Project_ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the project_ research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project_ research objects.
	*
	* @return the number of project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Project_ResearchObjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Project_ResearchObjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Project_ResearchObjectPersistence.class.getName());

			ReferenceRegistry.registerReference(Project_ResearchObjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Project_ResearchObjectPersistence persistence) {
	}

	private static Project_ResearchObjectPersistence _persistence;
}