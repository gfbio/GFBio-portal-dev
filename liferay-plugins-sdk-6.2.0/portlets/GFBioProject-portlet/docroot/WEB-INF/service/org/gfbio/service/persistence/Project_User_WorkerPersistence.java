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

import org.gfbio.model.Project_User_Worker;

/**
 * The persistence interface for the project_ user_ worker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author froemm
 * @see Project_User_WorkerPersistenceImpl
 * @see Project_User_WorkerUtil
 * @generated
 */
public interface Project_User_WorkerPersistence extends BasePersistence<Project_User_Worker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Project_User_WorkerUtil} to access the project_ user_ worker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project_ user_ workers where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Returns the first project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Returns the last project_ user_ worker in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Project_User_Worker[] findByProjectID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Removes all the project_ user_ workers where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ user_ workers where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ user_ workers where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Returns the first project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Returns the last project_ user_ worker in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user_ worker, or <code>null</code> if a matching project_ user_ worker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Project_User_Worker[] findByUserID_PrevAndNext(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Removes all the project_ user_ workers where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ user_ workers where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the project_ user_ worker in the entity cache if it is enabled.
	*
	* @param project_User_Worker the project_ user_ worker
	*/
	public void cacheResult(
		org.gfbio.model.Project_User_Worker project_User_Worker);

	/**
	* Caches the project_ user_ workers in the entity cache if it is enabled.
	*
	* @param project_User_Workers the project_ user_ workers
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Project_User_Worker> project_User_Workers);

	/**
	* Creates a new project_ user_ worker with the primary key. Does not add the project_ user_ worker to the database.
	*
	* @param project_User_WorkerPK the primary key for the new project_ user_ worker
	* @return the new project_ user_ worker
	*/
	public org.gfbio.model.Project_User_Worker create(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK);

	/**
	* Removes the project_ user_ worker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker that was removed
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker remove(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	public org.gfbio.model.Project_User_Worker updateImpl(
		org.gfbio.model.Project_User_Worker project_User_Worker)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ user_ worker with the primary key or throws a {@link org.gfbio.NoSuchProject_User_WorkerException} if it could not be found.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker
	* @throws org.gfbio.NoSuchProject_User_WorkerException if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker findByPrimaryKey(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_User_WorkerException;

	/**
	* Returns the project_ user_ worker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_User_WorkerPK the primary key of the project_ user_ worker
	* @return the project_ user_ worker, or <code>null</code> if a project_ user_ worker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User_Worker fetchByPrimaryKey(
		org.gfbio.service.persistence.Project_User_WorkerPK project_User_WorkerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ user_ workers.
	*
	* @return the project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User_Worker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Project_User_Worker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project_ user_ workers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ user_ workers.
	*
	* @return the number of project_ user_ workers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}