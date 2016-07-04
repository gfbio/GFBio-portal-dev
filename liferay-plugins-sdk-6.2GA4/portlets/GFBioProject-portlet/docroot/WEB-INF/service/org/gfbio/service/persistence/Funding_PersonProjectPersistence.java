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

import org.gfbio.model.Funding_PersonProject;

/**
 * The persistence interface for the funding_ person project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectPersistenceImpl
 * @see Funding_PersonProjectUtil
 * @generated
 */
public interface Funding_PersonProjectPersistence extends BasePersistence<Funding_PersonProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Funding_PersonProjectUtil} to access the funding_ person project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the funding_ person projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ person projects where fundingAgencyID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundingAgencyID the funding agency i d
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @return the range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ person projects where fundingAgencyID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundingAgencyID the funding agency i d
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ person projects before and after the current funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param funding_PersonProjectPK the primary key of the current funding_ person project
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject[] findByFundingAgencyID_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Removes all the funding_ person projects where fundingAgencyID = &#63; from the database.
	*
	* @param fundingAgencyID the funding agency i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ person projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param personType the person type
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @return the range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param personID the person i d
	* @param personType the person type
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByPerson_First(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the first funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByPerson_First(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByPerson_Last(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the last funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByPerson_Last(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ person projects before and after the current funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param funding_PersonProjectPK the primary key of the current funding_ person project
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject[] findByPerson_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long personID,
		java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Removes all the funding_ person projects where personID = &#63; and personType = &#63; from the database.
	*
	* @param personID the person i d
	* @param personType the person type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPerson(long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByPerson(long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ person projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ person projects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @return the range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ person projects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the first funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the last funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ person projects before and after the current funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param funding_PersonProjectPK the primary key of the current funding_ person project
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject[] findByProjectID_PrevAndNext(
		Funding_PersonProjectPK funding_PersonProjectPK, long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Removes all the funding_ person projects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ person projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the funding_ person project in the entity cache if it is enabled.
	*
	* @param funding_PersonProject the funding_ person project
	*/
	public void cacheResult(
		org.gfbio.model.Funding_PersonProject funding_PersonProject);

	/**
	* Caches the funding_ person projects in the entity cache if it is enabled.
	*
	* @param funding_PersonProjects the funding_ person projects
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Funding_PersonProject> funding_PersonProjects);

	/**
	* Creates a new funding_ person project with the primary key. Does not add the funding_ person project to the database.
	*
	* @param funding_PersonProjectPK the primary key for the new funding_ person project
	* @return the new funding_ person project
	*/
	public org.gfbio.model.Funding_PersonProject create(
		Funding_PersonProjectPK funding_PersonProjectPK);

	/**
	* Removes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project that was removed
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject remove(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	public org.gfbio.model.Funding_PersonProject updateImpl(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ person project with the primary key or throws a {@link org.gfbio.NoSuchFunding_PersonProjectException} if it could not be found.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject findByPrimaryKey(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException;

	/**
	* Returns the funding_ person project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project, or <code>null</code> if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_PersonProject fetchByPrimaryKey(
		Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ person projects.
	*
	* @return the funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ person projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @return the range of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ person projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_PersonProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ person projects
	* @param end the upper bound of the range of funding_ person projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_PersonProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funding_ person projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ person projects.
	*
	* @return the number of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}