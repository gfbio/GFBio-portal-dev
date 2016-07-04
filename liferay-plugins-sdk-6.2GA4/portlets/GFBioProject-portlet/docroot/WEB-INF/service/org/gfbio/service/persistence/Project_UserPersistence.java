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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.Project_User;

/**
 * The persistence interface for the project_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Project_UserPersistenceImpl
 * @see Project_UserUtil
 * @generated
 */
public interface Project_UserPersistence extends BasePersistence<Project_User> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Project_UserUtil} to access the project_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project_ users where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project_ users where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @return the range of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project_ users where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ user in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByProjectID_First(long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the first project_ user in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByProjectID_First(long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ user in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByProjectID_Last(long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the last project_ user in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByProjectID_Last(long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ users before and after the current project_ user in the ordered set where projectID = &#63;.
	*
	* @param project_UserPK the primary key of the current project_ user
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User[] findByProjectID_PrevAndNext(
		Project_UserPK project_UserPK, long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Removes all the project_ users where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ users where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @return the range of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first project_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the first project_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last project_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the last project_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ users before and after the current project_ user in the ordered set where userID = &#63;.
	*
	* @param project_UserPK the primary key of the current project_ user
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User[] findByUserID_PrevAndNext(
		Project_UserPK project_UserPK, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Removes all the project_ users where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ user where projectID = &#63; and userID = &#63; or throws a {@link org.gfbio.NoSuchProject_UserException} if it could not be found.
	*
	* @param projectID the project i d
	* @param userID the user i d
	* @return the matching project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByfindByPrimaryKey(long projectID,
		long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the project_ user where projectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param projectID the project i d
	* @param userID the user i d
	* @return the matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByfindByPrimaryKey(
		long projectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ user where projectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param projectID the project i d
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching project_ user, or <code>null</code> if a matching project_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByfindByPrimaryKey(
		long projectID, long userID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the project_ user where projectID = &#63; and userID = &#63; from the database.
	*
	* @param projectID the project i d
	* @param userID the user i d
	* @return the project_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User removeByfindByPrimaryKey(
		long projectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the number of project_ users where projectID = &#63; and userID = &#63;.
	*
	* @param projectID the project i d
	* @param userID the user i d
	* @return the number of matching project_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByPrimaryKey(long projectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the project_ user in the entity cache if it is enabled.
	*
	* @param project_User the project_ user
	*/
	public void cacheResult(org.gfbio.model.Project_User project_User);

	/**
	* Caches the project_ users in the entity cache if it is enabled.
	*
	* @param project_Users the project_ users
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Project_User> project_Users);

	/**
	* Creates a new project_ user with the primary key. Does not add the project_ user to the database.
	*
	* @param project_UserPK the primary key for the new project_ user
	* @return the new project_ user
	*/
	public org.gfbio.model.Project_User create(Project_UserPK project_UserPK);

	/**
	* Removes the project_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user that was removed
	* @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User remove(Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	public org.gfbio.model.Project_User updateImpl(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project_ user with the primary key or throws a {@link org.gfbio.NoSuchProject_UserException} if it could not be found.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user
	* @throws org.gfbio.NoSuchProject_UserException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User findByPrimaryKey(
		Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException;

	/**
	* Returns the project_ user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user, or <code>null</code> if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Project_User fetchByPrimaryKey(
		Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project_ users.
	*
	* @return the project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the project_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @return the range of project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the project_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Project_User> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project_ users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project_ users.
	*
	* @return the number of project_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}