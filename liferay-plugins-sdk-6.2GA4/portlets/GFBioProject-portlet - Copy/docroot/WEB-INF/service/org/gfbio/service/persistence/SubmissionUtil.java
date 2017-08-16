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

import org.gfbio.model.Submission;

import java.util.List;

/**
 * The persistence utility for the submission service. This utility wraps {@link SubmissionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionPersistence
 * @see SubmissionPersistenceImpl
 * @generated
 */
public class SubmissionUtil {
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
	public static void clearCache(Submission submission) {
		getPersistence().clearCache(submission);
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
	public static List<Submission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Submission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Submission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Submission update(Submission submission)
		throws SystemException {
		return getPersistence().update(submission);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Submission update(Submission submission,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(submission, serviceContext);
	}

	/**
	* Returns all the submissions where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByResearchObjectID(researchObjectID);
	}

	/**
	* Returns a range of all the submissions where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where researchObjectID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectID(researchObjectID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_First(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectID_Last(researchObjectID,
			orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where researchObjectID = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByResearchObjectID_PrevAndNext(
		long submissionID, long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectID_PrevAndNext(submissionID,
			researchObjectID, orderByComparator);
	}

	/**
	* Removes all the submissions where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByResearchObjectID(researchObjectID);
	}

	/**
	* Returns the number of submissions where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByResearchObjectID(researchObjectID);
	}

	/**
	* Returns all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns a range of all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion, start, end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDAndVersion_First(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDAndVersion_Last(researchObjectID,
			researchObjectVersion, orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByResearchObjectIDAndVersion_PrevAndNext(
		long submissionID, long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectIDAndVersion_PrevAndNext(submissionID,
			researchObjectID, researchObjectVersion, orderByComparator);
	}

	/**
	* Removes all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns the number of submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByResearchObjectIDAndVersion(researchObjectID,
			researchObjectVersion);
	}

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged, retrieveFromCache);
	}

	/**
	* Removes the submission where researchObjectID = &#63; and lastChanged = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission removeByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .removeByResearchObjectIDWithLastChanges(researchObjectID,
			lastChanged);
	}

	/**
	* Returns the number of submissions where researchObjectID = &#63; and lastChanged = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the number of matching submissions
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
	* Returns all the submissions where archive = &#63;.
	*
	* @param archive the archive
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive);
	}

	/**
	* Returns a range of all the submissions where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByArchive(archive, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where archive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archive the archive
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByArchive(archive, start, end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_First(archive, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByArchive_Last(archive, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByArchive_Last(archive, orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where archive = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByArchive_PrevAndNext(
		long submissionID, java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByArchive_PrevAndNext(submissionID, archive,
			orderByComparator);
	}

	/**
	* Removes all the submissions where archive = &#63; from the database.
	*
	* @param archive the archive
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByArchive(archive);
	}

	/**
	* Returns the number of submissions where archive = &#63;.
	*
	* @param archive the archive
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByArchive(archive);
	}

	/**
	* Returns all the submissions where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBrokerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns a range of all the submissions where brokerSubmissionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brokerSubmissionID the broker submission i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrokerSubmissionID(brokerSubmissionID, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where brokerSubmissionID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param brokerSubmissionID the broker submission i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBrokerSubmissionID(brokerSubmissionID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByBrokerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByBrokerSubmissionID_First(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByBrokerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrokerSubmissionID_First(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByBrokerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByBrokerSubmissionID_Last(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByBrokerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrokerSubmissionID_Last(brokerSubmissionID,
			orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByBrokerSubmissionID_PrevAndNext(
		long submissionID, java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByBrokerSubmissionID_PrevAndNext(submissionID,
			brokerSubmissionID, orderByComparator);
	}

	/**
	* Removes all the submissions where brokerSubmissionID = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBrokerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBrokerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the number of submissions where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrokerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBrokerSubmissionID(brokerSubmissionID);
	}

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged, retrieveFromCache);
	}

	/**
	* Removes the submission where brokerSubmissionID = &#63; and lastChanged = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission removeByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .removeByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns the number of submissions where brokerSubmissionID = &#63; and lastChanged = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBrokerSubmissionIDWithLastChanges(brokerSubmissionID,
			lastChanged);
	}

	/**
	* Returns all the submissions where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPersistentIdentifierID(archivePID);
	}

	/**
	* Returns a range of all the submissions where archivePID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePID the archive p i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierID(archivePID, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where archivePID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePID the archive p i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierID(archivePID, start, end,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierID_First(archivePID,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierID_First(archivePID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierID_Last(archivePID,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierID_Last(archivePID,
			orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where archivePID = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByPersistentIdentifierID_PrevAndNext(
		long submissionID, java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierID_PrevAndNext(submissionID,
			archivePID, orderByComparator);
	}

	/**
	* Removes all the submissions where archivePID = &#63; from the database.
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
	* Returns the number of submissions where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPersistentIdentifierID(java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPersistentIdentifierID(archivePID);
	}

	/**
	* Returns all the submissions where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns a range of all the submissions where archivePIDType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePIDType the archive p i d type
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID(archivePIDType, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where archivePIDType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param archivePIDType the archive p i d type
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID(archivePIDType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_First(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierTypeID_First(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_Last(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPersistentIdentifierTypeID_Last(archivePIDType,
			orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where archivePIDType = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByPersistentIdentifierTypeID_PrevAndNext(
		long submissionID, long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByPersistentIdentifierTypeID_PrevAndNext(submissionID,
			archivePIDType, orderByComparator);
	}

	/**
	* Removes all the submissions where archivePIDType = &#63; from the database.
	*
	* @param archivePIDType the archive p i d type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns the number of submissions where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPersistentIdentifierTypeID(archivePIDType);
	}

	/**
	* Returns all the submissions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByUserID(
		long userID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns a range of all the submissions where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserID(userID, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where userID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userID the user i d
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserID(userID, start, end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_First(userID, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID_Last(userID, orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where userID = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByUserID_PrevAndNext(
		long submissionID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByUserID_PrevAndNext(submissionID, userID,
			orderByComparator);
	}

	/**
	* Removes all the submissions where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of submissions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Returns all the submissions where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic);
	}

	/**
	* Returns a range of all the submissions where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsPublic(isPublic, start, end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where isPublic = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByIsPublic_PrevAndNext(
		long submissionID, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByIsPublic_PrevAndNext(submissionID, isPublic,
			orderByComparator);
	}

	/**
	* Removes all the submissions where isPublic = &#63; from the database.
	*
	* @param isPublic the is public
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsPublic(isPublic);
	}

	/**
	* Returns the number of submissions where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsPublic(isPublic);
	}

	/**
	* Returns all the submissions where status = &#63;.
	*
	* @param status the status
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the submissions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the submissions where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the submissions before and after the current submission in the ordered set where status = &#63;.
	*
	* @param submissionID the primary key of the current submission
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission[] findByStatus_PrevAndNext(
		long submissionID, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence()
				   .findByStatus_PrevAndNext(submissionID, status,
			orderByComparator);
	}

	/**
	* Removes all the submissions where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of submissions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the submission in the entity cache if it is enabled.
	*
	* @param submission the submission
	*/
	public static void cacheResult(org.gfbio.model.Submission submission) {
		getPersistence().cacheResult(submission);
	}

	/**
	* Caches the submissions in the entity cache if it is enabled.
	*
	* @param submissions the submissions
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.Submission> submissions) {
		getPersistence().cacheResult(submissions);
	}

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionID the primary key for the new submission
	* @return the new submission
	*/
	public static org.gfbio.model.Submission create(long submissionID) {
		return getPersistence().create(submissionID);
	}

	/**
	* Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionID the primary key of the submission
	* @return the submission that was removed
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission remove(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().remove(submissionID);
	}

	public static org.gfbio.model.Submission updateImpl(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(submission);
	}

	/**
	* Returns the submission with the primary key or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param submissionID the primary key of the submission
	* @return the submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission findByPrimaryKey(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException {
		return getPersistence().findByPrimaryKey(submissionID);
	}

	/**
	* Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionID the primary key of the submission
	* @return the submission, or <code>null</code> if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission fetchByPrimaryKey(
		long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(submissionID);
	}

	/**
	* Returns all the submissions.
	*
	* @return the submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @return the range of submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the submissions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of submissions
	* @param end the upper bound of the range of submissions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of submissions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.Submission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the submissions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubmissionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubmissionPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					SubmissionPersistence.class.getName());

			ReferenceRegistry.registerReference(SubmissionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubmissionPersistence persistence) {
	}

	private static SubmissionPersistence _persistence;
}