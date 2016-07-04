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

import org.gfbio.model.Funding_InstitutionProject;

/**
 * The persistence interface for the funding_ institution project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProjectPersistenceImpl
 * @see Funding_InstitutionProjectUtil
 * @generated
 */
public interface Funding_InstitutionProjectPersistence extends BasePersistence<Funding_InstitutionProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Funding_InstitutionProjectUtil} to access the funding_ institution project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the funding_ institution projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ institution projects where fundingAgencyID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundingAgencyID the funding agency i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @return the range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ institution projects where fundingAgencyID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundingAgencyID the funding agency i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject[] findByFundingAgencyID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Removes all the funding_ institution projects where fundingAgencyID = &#63; from the database.
	*
	* @param fundingAgencyID the funding agency i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ institution projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ institution projects where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ institution projects where institutionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionID the institution i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @return the range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ institution projects where institutionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param institutionID the institution i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByInstitutionID_First(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByInstitutionID_First(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByInstitutionID_Last(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByInstitutionID_Last(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject[] findByInstitutionID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Removes all the funding_ institution projects where institutionID = &#63; from the database.
	*
	* @param institutionID the institution i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByInstitutionID(long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ institution projects where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByInstitutionID(long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ institution projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ institution projects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @return the range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ institution projects where projectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectID the project i d
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ institution projects before and after the current funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param funding_InstitutionProjectPK the primary key of the current funding_ institution project
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject[] findByProjectID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Removes all the funding_ institution projects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ institution projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the funding_ institution project in the entity cache if it is enabled.
	*
	* @param funding_InstitutionProject the funding_ institution project
	*/
	public void cacheResult(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject);

	/**
	* Caches the funding_ institution projects in the entity cache if it is enabled.
	*
	* @param funding_InstitutionProjects the funding_ institution projects
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Funding_InstitutionProject> funding_InstitutionProjects);

	/**
	* Creates a new funding_ institution project with the primary key. Does not add the funding_ institution project to the database.
	*
	* @param funding_InstitutionProjectPK the primary key for the new funding_ institution project
	* @return the new funding_ institution project
	*/
	public org.gfbio.model.Funding_InstitutionProject create(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK);

	/**
	* Removes the funding_ institution project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project that was removed
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject remove(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	public org.gfbio.model.Funding_InstitutionProject updateImpl(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the funding_ institution project with the primary key or throws a {@link org.gfbio.NoSuchFunding_InstitutionProjectException} if it could not be found.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject findByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException;

	/**
	* Returns the funding_ institution project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project, or <code>null</code> if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Funding_InstitutionProject fetchByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the funding_ institution projects.
	*
	* @return the funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the funding_ institution projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @return the range of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the funding_ institution projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Funding_InstitutionProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of funding_ institution projects
	* @param end the upper bound of the range of funding_ institution projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the funding_ institution projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of funding_ institution projects.
	*
	* @return the number of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}