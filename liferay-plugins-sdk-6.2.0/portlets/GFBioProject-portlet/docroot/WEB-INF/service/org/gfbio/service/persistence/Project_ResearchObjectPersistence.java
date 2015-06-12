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

import org.gfbio.model.Project_ResearchObject;

/**
 * The persistence interface for the project_ research object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_ResearchObjectPersistenceImpl
 * @see Project_ResearchObjectUtil
 * @generated
 */
public interface Project_ResearchObjectPersistence extends BasePersistence<Project_ResearchObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Project_ResearchObjectUtil} to access the project_ research object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project_ research objects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Returns the first project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Returns the last project_ research object in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Project_ResearchObject[] findByProjectID_PrevAndNext(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Removes all the project_ research objects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ research objects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Returns the first project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Returns the last project_ research object in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ research object, or <code>null</code> if a matching project_ research object could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Project_ResearchObject[] findByResearchObjectID_PrevAndNext(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Removes all the project_ research objects where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ research objects where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the project_ research object in the entity cache if it is enabled.
	*
	* @param project_ResearchObject the project_ research object
	*/
	public void cacheResult(
		org.gfbio.model.Project_ResearchObject project_ResearchObject);

	/**
	* Caches the project_ research objects in the entity cache if it is enabled.
	*
	* @param project_ResearchObjects the project_ research objects
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Project_ResearchObject> project_ResearchObjects);

	/**
	* Creates a new project_ research object with the primary key. Does not add the project_ research object to the database.
	*
	* @param project_ResearchObjectPK the primary key for the new project_ research object
	* @return the new project_ research object
	*/
	public org.gfbio.model.Project_ResearchObject create(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK);

	/**
	* Removes the project_ research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object that was removed
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject remove(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	public org.gfbio.model.Project_ResearchObject updateImpl(
		org.gfbio.model.Project_ResearchObject project_ResearchObject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ research object with the primary key or throws a {@link org.gfbio.NoSuchProject_ResearchObjectException} if it could not be found.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object
	* @throws org.gfbio.NoSuchProject_ResearchObjectException if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject findByPrimaryKey(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_ResearchObjectException;

	/**
	* Returns the project_ research object with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_ResearchObjectPK the primary key of the project_ research object
	* @return the project_ research object, or <code>null</code> if a project_ research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_ResearchObject fetchByPrimaryKey(
		org.gfbio.service.persistence.Project_ResearchObjectPK project_ResearchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ research objects.
	*
	* @return the project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_ResearchObject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_ResearchObject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project_ research objects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ research objects.
	*
	* @return the number of project_ research objects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}