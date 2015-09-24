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

import org.gfbio.model.SubmissionRegistry;

import java.util.List;

/**
 * The persistence utility for the submission registry service. This utility wraps {@link SubmissionRegistryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryPersistence
 * @see SubmissionRegistryPersistenceImpl
 * @generated
 */
public class SubmissionRegistryUtil {
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
	public static void clearCache(SubmissionRegistry submissionRegistry) {
		getPersistence().clearCache(submissionRegistry);
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
	public static List<SubmissionRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubmissionRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubmissionRegistry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SubmissionRegistry update(
		SubmissionRegistry submissionRegistry) throws SystemException {
		return getPersistence().update(submissionRegistry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SubmissionRegistry update(
		SubmissionRegistry submissionRegistry, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(submissionRegistry, serviceContext);
	}

	/**
	* Returns all the submission registries where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResearchObjectID(researchObjectID);
	}

	/**
	* Returns a range of all the submission registries where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where researchObjectID = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByResearchObjectID_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectID_PrevAndNext(submissionRegistryPK,
			researchObjectID, orderByComparator);
	}

	/**
	* Removes all the submission registries where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the number of submission registries where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResearchObjectID(researchObjectID);
	}

	/**
	* Returns all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns a range of all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion, start, end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectIDWithVersion_First(
		long researchObjectID, long researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectIDWithVersion_Last(
		long researchObjectID, long researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByResearchObjectIDWithVersion_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		long researchObjectID, long researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectIDWithVersion_PrevAndNext(submissionRegistryPK,
			researchObjectID, researchObjectVersion, orderByComparator);
	}

	/**
	* Removes all the submission registries where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns the number of submission registries where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectIDWithVersion(
		long researchObjectID, long researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResearchObjectIDWithVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the submission registry where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged, retrieveFromCache);
	}

	/**
	* Removes the submission registry where researchObjectID = &#63; and lastChanged = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the submission registry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry removeByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .removeByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the number of submission registries where researchObjectID = &#63; and lastChanged = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns all the submission registries where archive = &#63;.
	*
	* @param archive the archive
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByArchive(
		java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive);
	}

	/**
	* Returns a range of all the submission registries where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByArchive(
		java.lang.String archive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByArchive(
		java.lang.String archive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArchive(archive, start, end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByArchive_Last(archive, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_Last(archive, orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where archive = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByArchive_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByArchive_PrevAndNext(submissionRegistryPK, archive,
			orderByComparator);
	}

	/**
	* Removes all the submission registries where archive = &#63; from the database.
	*
	* @param archive the archive
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArchive(archive);
	}

	/**
	* Returns the number of submission registries where archive = &#63;.
	*
	* @param archive the archive
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArchive(archive);
	}

	/**
	* Returns all the submission registries where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByBrockerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrockerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns a range of all the submission registries where brokerSubmissionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brokerSubmissionID the broker submission i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByBrockerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrockerSubmissionID(brokerSubmissionID, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where brokerSubmissionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brokerSubmissionID the broker submission i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByBrockerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrockerSubmissionID(brokerSubmissionID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByBrockerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByBrockerSubmissionID_First(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByBrockerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrockerSubmissionID_First(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByBrockerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByBrockerSubmissionID_Last(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByBrockerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrockerSubmissionID_Last(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByBrockerSubmissionID_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByBrockerSubmissionID_PrevAndNext(submissionRegistryPK,
			brokerSubmissionID, orderByComparator);
	}

	/**
	* Removes all the submission registries where brokerSubmissionID = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrockerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrockerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the number of submission registries where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrockerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrockerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByBrockerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByBrockerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByBrockerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrockerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByBrockerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrockerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged, retrieveFromCache);
	}

	/**
	* Removes the submission registry where brokerSubmissionID = &#63; and lastChanged = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the submission registry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry removeByBrockerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .removeByBrockerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the number of submission registries where brokerSubmissionID = &#63; and lastChanged = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrockerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBrockerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns all the submission registries where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierID(
		java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPersistentIdentifierID(archivePID);
	}

	/**
	* Returns a range of all the submission registries where archivePID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePID the archive p i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierID(archivePID, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where archivePID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePID the archive p i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierID(archivePID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierID_First(archivePID,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierID_First(archivePID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierID_Last(archivePID,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierID_Last(archivePID,
			orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where archivePID = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByPersistentIdentifierID_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierID_PrevAndNext(submissionRegistryPK,
			archivePID, orderByComparator);
	}

	/**
	* Removes all the submission registries where archivePID = &#63; from the database.
	*
	* @param archivePID the archive p i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPersistentIdentifierID(
		java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPersistentIdentifierID(archivePID);
	}

	/**
	* Returns the number of submission registries where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPersistentIdentifierID(java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPersistentIdentifierID(archivePID);
	}

	/**
	* Returns all the submission registries where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns a range of all the submission registries where archivePIDType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePIDType the archive p i d type
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID(archivePIDType, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where archivePIDType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePIDType the archive p i d type
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID(archivePIDType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_First(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierTypeID_First(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_Last(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierTypeID_Last(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where archivePIDType = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByPersistentIdentifierTypeID_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_PrevAndNext(submissionRegistryPK,
			archivePIDType, orderByComparator);
	}

	/**
	* Removes all the submission registries where archivePIDType = &#63; from the database.
	*
	* @param archivePIDType the archive p i d type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns the number of submission registries where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns all the submission registries where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the submission registries where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByUserID_First(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByUserID_Last(
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where userID = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByUserID_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByUserID_PrevAndNext(submissionRegistryPK, userID,
			orderByComparator);
	}

	/**
	* Removes all the submission registries where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of submission registries where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Returns all the submission registries where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByIsPublic(
		java.lang.Boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic);
	}

	/**
	* Returns a range of all the submission registries where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByIsPublic(
		java.lang.Boolean isPublic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByIsPublic(
		java.lang.Boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsPublic(isPublic, start, end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByIsPublic_First(
		java.lang.Boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByIsPublic_First(
		java.lang.Boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByIsPublic_Last(
		java.lang.Boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByIsPublic_Last(
		java.lang.Boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where isPublic = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByIsPublic_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		java.lang.Boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByIsPublic_PrevAndNext(submissionRegistryPK, isPublic,
			orderByComparator);
	}

	/**
	* Removes all the submission registries where isPublic = &#63; from the database.
	*
	* @param isPublic the is public
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsPublic(java.lang.Boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsPublic(isPublic);
	}

	/**
	* Returns the number of submission registries where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsPublic(java.lang.Boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsPublic(isPublic);
	}

	/**
	* Returns all the submission registries where status = &#63;.
	*
	* @param status the status
	* @return the matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the submission registries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the submission registries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first submission registry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last submission registry in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission registry, or <code>null</code> if a matching submission registry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the submission registries before and after the current submission registry in the ordered set where status = &#63;.
	*
	* @param submissionRegistryPK the primary key of the current submission registry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry[] findByStatus_PrevAndNext(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK,
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence()
				   .findByStatus_PrevAndNext(submissionRegistryPK, status,
			orderByComparator);
	}

	/**
	* Removes all the submission registries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of submission registries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the submission registry in the entity cache if it is enabled.
	*
	* @param submissionRegistry the submission registry
	*/
	public static void cacheResult(
		org.gfbio.model.SubmissionRegistry submissionRegistry) {
		getPersistence().cacheResult(submissionRegistry);
	}

	/**
	* Caches the submission registries in the entity cache if it is enabled.
	*
	* @param submissionRegistries the submission registries
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.SubmissionRegistry> submissionRegistries) {
		getPersistence().cacheResult(submissionRegistries);
	}

	/**
	* Creates a new submission registry with the primary key. Does not add the submission registry to the database.
	*
	* @param submissionRegistryPK the primary key for the new submission registry
	* @return the new submission registry
	*/
	public static org.gfbio.model.SubmissionRegistry create(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK) {
		return getPersistence().create(submissionRegistryPK);
	}

	/**
	* Removes the submission registry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry that was removed
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry remove(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().remove(submissionRegistryPK);
	}

	public static org.gfbio.model.SubmissionRegistry updateImpl(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(submissionRegistry);
	}

	/**
	* Returns the submission registry with the primary key or throws a {@link org.gfbio.NoSuchSubmissionRegistryException} if it could not be found.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry
	* @throws org.gfbio.NoSuchSubmissionRegistryException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry findByPrimaryKey(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionRegistryException {
		return getPersistence().findByPrimaryKey(submissionRegistryPK);
	}

	/**
	* Returns the submission registry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry, or <code>null</code> if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry fetchByPrimaryKey(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(submissionRegistryPK);
	}

	/**
	* Returns all the submission registries.
	*
	* @return the submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the submission registries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @return the range of submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the submission registries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submission registries
	* @param end the upper bound of the range of submission registries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.SubmissionRegistry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the submission registries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of submission registries.
	*
	* @return the number of submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubmissionRegistryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubmissionRegistryPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					SubmissionRegistryPersistence.class.getName());

			ReferenceRegistry.registerReference(SubmissionRegistryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubmissionRegistryPersistence persistence) {
	}

	private static SubmissionRegistryPersistence _persistence;
}