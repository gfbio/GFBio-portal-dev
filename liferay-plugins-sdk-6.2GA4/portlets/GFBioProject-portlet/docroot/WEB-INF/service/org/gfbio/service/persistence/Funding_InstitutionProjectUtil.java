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

import org.gfbio.model.Funding_InstitutionProject;

import java.util.List;

/**
 * The persistence utility for the funding_ institution project service. This utility wraps {@link Funding_InstitutionProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_InstitutionProjectPersistence
 * @see Funding_InstitutionProjectPersistenceImpl
 * @generated
 */
public class Funding_InstitutionProjectUtil {
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
	public static void clearCache(
		Funding_InstitutionProject funding_InstitutionProject) {
		getPersistence().clearCache(funding_InstitutionProject);
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
	public static List<Funding_InstitutionProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Funding_InstitutionProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Funding_InstitutionProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Funding_InstitutionProject update(
		Funding_InstitutionProject funding_InstitutionProject)
		throws SystemException {
		return getPersistence().update(funding_InstitutionProject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Funding_InstitutionProject update(
		Funding_InstitutionProject funding_InstitutionProject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(funding_InstitutionProject, serviceContext);
	}

	/**
	* Returns all the funding_ institution projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFundingAgencyID(fundingAgencyID);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundingAgencyID(fundingAgencyID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundingAgencyID(fundingAgencyID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByFundingAgencyID_First(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundingAgencyID_First(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByFundingAgencyID_Last(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundingAgencyID_Last(fundingAgencyID,
			orderByComparator);
	}

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
	public static org.gfbio.model.Funding_InstitutionProject[] findByFundingAgencyID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByFundingAgencyID_PrevAndNext(funding_InstitutionProjectPK,
			fundingAgencyID, orderByComparator);
	}

	/**
	* Removes all the funding_ institution projects where fundingAgencyID = &#63; from the database.
	*
	* @param fundingAgencyID the funding agency i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns the number of funding_ institution projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns all the funding_ institution projects where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitutionID(institutionID);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByInstitutionID(institutionID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByInstitutionID(
		long institutionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByInstitutionID(institutionID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByInstitutionID_First(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByInstitutionID_First(institutionID, orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByInstitutionID_First(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitutionID_First(institutionID, orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByInstitutionID_Last(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByInstitutionID_Last(institutionID, orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByInstitutionID_Last(
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByInstitutionID_Last(institutionID, orderByComparator);
	}

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
	public static org.gfbio.model.Funding_InstitutionProject[] findByInstitutionID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long institutionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByInstitutionID_PrevAndNext(funding_InstitutionProjectPK,
			institutionID, orderByComparator);
	}

	/**
	* Removes all the funding_ institution projects where institutionID = &#63; from the database.
	*
	* @param institutionID the institution i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByInstitutionID(long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByInstitutionID(institutionID);
	}

	/**
	* Returns the number of funding_ institution projects where institutionID = &#63;.
	*
	* @param institutionID the institution i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByInstitutionID(long institutionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByInstitutionID(institutionID);
	}

	/**
	* Returns all the funding_ institution projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProjectID(projectID, start, end, orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the first funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the last funding_ institution project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ institution project, or <code>null</code> if a matching funding_ institution project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_Last(projectID, orderByComparator);
	}

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
	public static org.gfbio.model.Funding_InstitutionProject[] findByProjectID_PrevAndNext(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence()
				   .findByProjectID_PrevAndNext(funding_InstitutionProjectPK,
			projectID, orderByComparator);
	}

	/**
	* Removes all the funding_ institution projects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of funding_ institution projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Caches the funding_ institution project in the entity cache if it is enabled.
	*
	* @param funding_InstitutionProject the funding_ institution project
	*/
	public static void cacheResult(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject) {
		getPersistence().cacheResult(funding_InstitutionProject);
	}

	/**
	* Caches the funding_ institution projects in the entity cache if it is enabled.
	*
	* @param funding_InstitutionProjects the funding_ institution projects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Funding_InstitutionProject> funding_InstitutionProjects) {
		getPersistence().cacheResult(funding_InstitutionProjects);
	}

	/**
	* Creates a new funding_ institution project with the primary key. Does not add the funding_ institution project to the database.
	*
	* @param funding_InstitutionProjectPK the primary key for the new funding_ institution project
	* @return the new funding_ institution project
	*/
	public static org.gfbio.model.Funding_InstitutionProject create(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK) {
		return getPersistence().create(funding_InstitutionProjectPK);
	}

	/**
	* Removes the funding_ institution project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project that was removed
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject remove(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence().remove(funding_InstitutionProjectPK);
	}

	public static org.gfbio.model.Funding_InstitutionProject updateImpl(
		org.gfbio.model.Funding_InstitutionProject funding_InstitutionProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(funding_InstitutionProject);
	}

	/**
	* Returns the funding_ institution project with the primary key or throws a {@link org.gfbio.NoSuchFunding_InstitutionProjectException} if it could not be found.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project
	* @throws org.gfbio.NoSuchFunding_InstitutionProjectException if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject findByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_InstitutionProjectException {
		return getPersistence().findByPrimaryKey(funding_InstitutionProjectPK);
	}

	/**
	* Returns the funding_ institution project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funding_InstitutionProjectPK the primary key of the funding_ institution project
	* @return the funding_ institution project, or <code>null</code> if a funding_ institution project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_InstitutionProject fetchByPrimaryKey(
		Funding_InstitutionProjectPK funding_InstitutionProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(funding_InstitutionProjectPK);
	}

	/**
	* Returns all the funding_ institution projects.
	*
	* @return the funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_InstitutionProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the funding_ institution projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of funding_ institution projects.
	*
	* @return the number of funding_ institution projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Funding_InstitutionProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Funding_InstitutionProjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Funding_InstitutionProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(Funding_InstitutionProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		Funding_InstitutionProjectPersistence persistence) {
	}

	private static Funding_InstitutionProjectPersistence _persistence;
}