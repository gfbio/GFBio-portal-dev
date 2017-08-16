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

import org.gfbio.model.ResearchObject_User;

/**
 * The persistence interface for the research object_ user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ResearchObject_UserPersistenceImpl
 * @see ResearchObject_UserUtil
 * @generated
 */
public interface ResearchObject_UserPersistence extends BasePersistence<ResearchObject_User> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResearchObject_UserUtil} to access the research object_ user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the research object_ users where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByresearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research object_ users where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @return the range of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByresearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research object_ users where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByresearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object_ user in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByresearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the first research object_ user in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByresearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object_ user in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByresearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the last research object_ user in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByresearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object_ users before and after the current research object_ user in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObject_UserPK the primary key of the current research object_ user
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User[] findByresearchObjectID_PrevAndNext(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Removes all the research object_ users where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByresearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research object_ users where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByresearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research object_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research object_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @return the range of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research object_ users where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first research object_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the first research object_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last research object_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the last research object_ user in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object_ users before and after the current research object_ user in the ordered set where userID = &#63;.
	*
	* @param researchObject_UserPK the primary key of the current research object_ user
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User[] findByUserID_PrevAndNext(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Removes all the research object_ users where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research object_ users where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object_ user where researchObjectID = &#63; and userID = &#63; or throws a {@link org.gfbio.NoSuchResearchObject_UserException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @param userID the user i d
	* @return the matching research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByfindByPrimaryKey(
		long researchObjectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the research object_ user where researchObjectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param userID the user i d
	* @return the matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByfindByPrimaryKey(
		long researchObjectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object_ user where researchObjectID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching research object_ user, or <code>null</code> if a matching research object_ user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByfindByPrimaryKey(
		long researchObjectID, long userID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the research object_ user where researchObjectID = &#63; and userID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param userID the user i d
	* @return the research object_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User removeByfindByPrimaryKey(
		long researchObjectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the number of research object_ users where researchObjectID = &#63; and userID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param userID the user i d
	* @return the number of matching research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByPrimaryKey(long researchObjectID, long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the research object_ user in the entity cache if it is enabled.
	*
	* @param researchObject_User the research object_ user
	*/
	public void cacheResult(
		org.gfbio.model.ResearchObject_User researchObject_User);

	/**
	* Caches the research object_ users in the entity cache if it is enabled.
	*
	* @param researchObject_Users the research object_ users
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.ResearchObject_User> researchObject_Users);

	/**
	* Creates a new research object_ user with the primary key. Does not add the research object_ user to the database.
	*
	* @param researchObject_UserPK the primary key for the new research object_ user
	* @return the new research object_ user
	*/
	public org.gfbio.model.ResearchObject_User create(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK);

	/**
	* Removes the research object_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user that was removed
	* @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User remove(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	public org.gfbio.model.ResearchObject_User updateImpl(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the research object_ user with the primary key or throws a {@link org.gfbio.NoSuchResearchObject_UserException} if it could not be found.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user
	* @throws org.gfbio.NoSuchResearchObject_UserException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User findByPrimaryKey(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObject_UserException;

	/**
	* Returns the research object_ user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user, or <code>null</code> if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.ResearchObject_User fetchByPrimaryKey(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the research object_ users.
	*
	* @return the research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the research object_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @return the range of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the research object_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.ResearchObject_User> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the research object_ users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of research object_ users.
	*
	* @return the number of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}