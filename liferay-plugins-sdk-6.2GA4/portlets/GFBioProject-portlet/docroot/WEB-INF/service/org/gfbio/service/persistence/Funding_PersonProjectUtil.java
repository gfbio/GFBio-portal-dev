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

import org.gfbio.model.Funding_PersonProject;

import java.util.List;

/**
 * The persistence utility for the funding_ person project service. This utility wraps {@link Funding_PersonProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see Funding_PersonProjectPersistence
 * @see Funding_PersonProjectPersistenceImpl
 * @generated
 */
public class Funding_PersonProjectUtil {
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
	public static void clearCache(Funding_PersonProject funding_PersonProject) {
		getPersistence().clearCache(funding_PersonProject);
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
	public static List<Funding_PersonProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Funding_PersonProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Funding_PersonProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Funding_PersonProject update(
		Funding_PersonProject funding_PersonProject) throws SystemException {
		return getPersistence().update(funding_PersonProject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Funding_PersonProject update(
		Funding_PersonProject funding_PersonProject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(funding_PersonProject, serviceContext);
	}

	/**
	* Returns all the funding_ person projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFundingAgencyID(fundingAgencyID);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundingAgencyID(fundingAgencyID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByFundingAgencyID(
		long fundingAgencyID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundingAgencyID(fundingAgencyID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject findByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByFundingAgencyID_First(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the first funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByFundingAgencyID_First(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundingAgencyID_First(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject findByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByFundingAgencyID_Last(fundingAgencyID,
			orderByComparator);
	}

	/**
	* Returns the last funding_ person project in the ordered set where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByFundingAgencyID_Last(
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundingAgencyID_Last(fundingAgencyID,
			orderByComparator);
	}

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
	public static org.gfbio.model.Funding_PersonProject[] findByFundingAgencyID_PrevAndNext(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK,
		long fundingAgencyID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByFundingAgencyID_PrevAndNext(funding_PersonProjectPK,
			fundingAgencyID, orderByComparator);
	}

	/**
	* Removes all the funding_ person projects where fundingAgencyID = &#63; from the database.
	*
	* @param fundingAgencyID the funding agency i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns the number of funding_ person projects where fundingAgencyID = &#63;.
	*
	* @param fundingAgencyID the funding agency i d
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFundingAgencyID(long fundingAgencyID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFundingAgencyID(fundingAgencyID);
	}

	/**
	* Returns all the funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPerson(personID, personType);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPerson(personID, personType, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByPerson(
		long personID, java.lang.String personType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPerson(personID, personType, start, end,
			orderByComparator);
	}

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
	public static org.gfbio.model.Funding_PersonProject findByPerson_First(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByPerson_First(personID, personType, orderByComparator);
	}

	/**
	* Returns the first funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByPerson_First(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPerson_First(personID, personType, orderByComparator);
	}

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
	public static org.gfbio.model.Funding_PersonProject findByPerson_Last(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByPerson_Last(personID, personType, orderByComparator);
	}

	/**
	* Returns the last funding_ person project in the ordered set where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByPerson_Last(
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPerson_Last(personID, personType, orderByComparator);
	}

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
	public static org.gfbio.model.Funding_PersonProject[] findByPerson_PrevAndNext(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK,
		long personID, java.lang.String personType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByPerson_PrevAndNext(funding_PersonProjectPK, personID,
			personType, orderByComparator);
	}

	/**
	* Removes all the funding_ person projects where personID = &#63; and personType = &#63; from the database.
	*
	* @param personID the person i d
	* @param personType the person type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPerson(long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPerson(personID, personType);
	}

	/**
	* Returns the number of funding_ person projects where personID = &#63; and personType = &#63;.
	*
	* @param personID the person i d
	* @param personType the person type
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPerson(long personID, java.lang.String personType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPerson(personID, personType);
	}

	/**
	* Returns all the funding_ person projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProjectID(projectID, start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findByProjectID(
		long projectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProjectID(projectID, start, end, orderByComparator);
	}

	/**
	* Returns the first funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject findByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the first funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByProjectID_First(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_First(projectID, orderByComparator);
	}

	/**
	* Returns the last funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject findByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByProjectID_Last(projectID, orderByComparator);
	}

	/**
	* Returns the last funding_ person project in the ordered set where projectID = &#63;.
	*
	* @param projectID the project i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching funding_ person project, or <code>null</code> if a matching funding_ person project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByProjectID_Last(
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProjectID_Last(projectID, orderByComparator);
	}

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
	public static org.gfbio.model.Funding_PersonProject[] findByProjectID_PrevAndNext(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK,
		long projectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence()
				   .findByProjectID_PrevAndNext(funding_PersonProjectPK,
			projectID, orderByComparator);
	}

	/**
	* Removes all the funding_ person projects where projectID = &#63; from the database.
	*
	* @param projectID the project i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProjectID(projectID);
	}

	/**
	* Returns the number of funding_ person projects where projectID = &#63;.
	*
	* @param projectID the project i d
	* @return the number of matching funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProjectID(long projectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProjectID(projectID);
	}

	/**
	* Caches the funding_ person project in the entity cache if it is enabled.
	*
	* @param funding_PersonProject the funding_ person project
	*/
	public static void cacheResult(
		org.gfbio.model.Funding_PersonProject funding_PersonProject) {
		getPersistence().cacheResult(funding_PersonProject);
	}

	/**
	* Caches the funding_ person projects in the entity cache if it is enabled.
	*
	* @param funding_PersonProjects the funding_ person projects
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Funding_PersonProject> funding_PersonProjects) {
		getPersistence().cacheResult(funding_PersonProjects);
	}

	/**
	* Creates a new funding_ person project with the primary key. Does not add the funding_ person project to the database.
	*
	* @param funding_PersonProjectPK the primary key for the new funding_ person project
	* @return the new funding_ person project
	*/
	public static org.gfbio.model.Funding_PersonProject create(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK) {
		return getPersistence().create(funding_PersonProjectPK);
	}

	/**
	* Removes the funding_ person project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project that was removed
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject remove(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence().remove(funding_PersonProjectPK);
	}

	public static org.gfbio.model.Funding_PersonProject updateImpl(
		org.gfbio.model.Funding_PersonProject funding_PersonProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(funding_PersonProject);
	}

	/**
	* Returns the funding_ person project with the primary key or throws a {@link org.gfbio.NoSuchFunding_PersonProjectException} if it could not be found.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project
	* @throws org.gfbio.NoSuchFunding_PersonProjectException if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject findByPrimaryKey(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchFunding_PersonProjectException {
		return getPersistence().findByPrimaryKey(funding_PersonProjectPK);
	}

	/**
	* Returns the funding_ person project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param funding_PersonProjectPK the primary key of the funding_ person project
	* @return the funding_ person project, or <code>null</code> if a funding_ person project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Funding_PersonProject fetchByPrimaryKey(
		org.gfbio.service.persistence.Funding_PersonProjectPK funding_PersonProjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(funding_PersonProjectPK);
	}

	/**
	* Returns all the funding_ person projects.
	*
	* @return the funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gfbio.model.Funding_PersonProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the funding_ person projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of funding_ person projects.
	*
	* @return the number of funding_ person projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Funding_PersonProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Funding_PersonProjectPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					Funding_PersonProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(Funding_PersonProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(Funding_PersonProjectPersistence persistence) {
	}

	private static Funding_PersonProjectPersistence _persistence;
}