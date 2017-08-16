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

import org.gfbio.model.Submission;

/**
 * The persistence interface for the submission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see SubmissionPersistenceImpl
 * @see SubmissionUtil
 * @generated
 */
public interface SubmissionPersistence extends BasePersistence<Submission> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmissionUtil} to access the submission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the submissions where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectID(
		long researchObjectID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectID_First(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectID_Last(
		long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByResearchObjectID_PrevAndNext(
		long submissionID, long researchObjectID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where researchObjectID = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where researchObjectID = &#63;.
	*
	* @param researchObjectID the research object i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchObjectID(long researchObjectID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByResearchObjectIDAndVersion(
		long researchObjectID, int researchObjectVersion, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission findByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectIDAndVersion_First(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission findByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectIDAndVersion_Last(
		long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByResearchObjectIDAndVersion_PrevAndNext(
		long submissionID, long researchObjectID, int researchObjectVersion,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where researchObjectID = &#63; and researchObjectVersion = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @throws SystemException if a system exception occurred
	*/
	public void removeByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where researchObjectID = &#63; and researchObjectVersion = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param researchObjectVersion the research object version
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchObjectIDAndVersion(long researchObjectID,
		int researchObjectVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission where researchObjectID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the submission where researchObjectID = &#63; and lastChanged = &#63; from the database.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission removeByResearchObjectIDWithLastChanges(
		long researchObjectID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the number of submissions where researchObjectID = &#63; and lastChanged = &#63;.
	*
	* @param researchObjectID the research object i d
	* @param lastChanged the last changed
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByResearchObjectIDWithLastChanges(long researchObjectID,
		java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where archive = &#63;.
	*
	* @param archive the archive
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByArchive(
		java.lang.String archive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByArchive_First(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where archive = &#63;.
	*
	* @param archive the archive
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByArchive_Last(
		java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByArchive_PrevAndNext(
		long submissionID, java.lang.String archive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where archive = &#63; from the database.
	*
	* @param archive the archive
	* @throws SystemException if a system exception occurred
	*/
	public void removeByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where archive = &#63;.
	*
	* @param archive the archive
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByArchive(java.lang.String archive)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByBrokerSubmissionID(
		java.lang.String brokerSubmissionID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByBrokerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByBrokerSubmissionID_First(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByBrokerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByBrokerSubmissionID_Last(
		java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByBrokerSubmissionID_PrevAndNext(
		long submissionID, java.lang.String brokerSubmissionID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where brokerSubmissionID = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBrokerSubmissionID(java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where brokerSubmissionID = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrokerSubmissionID(java.lang.String brokerSubmissionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission where brokerSubmissionID = &#63; and lastChanged = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the submission where brokerSubmissionID = &#63; and lastChanged = &#63; from the database.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission removeByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the number of submissions where brokerSubmissionID = &#63; and lastChanged = &#63;.
	*
	* @param brokerSubmissionID the broker submission i d
	* @param lastChanged the last changed
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByBrokerSubmissionIDWithLastChanges(
		java.lang.String brokerSubmissionID, java.util.Date lastChanged)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierID(
		java.lang.String archivePID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByPersistentIdentifierID_First(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByPersistentIdentifierID_Last(
		java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByPersistentIdentifierID_PrevAndNext(
		long submissionID, java.lang.String archivePID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where archivePID = &#63; from the database.
	*
	* @param archivePID the archive p i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPersistentIdentifierID(java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where archivePID = &#63;.
	*
	* @param archivePID the archive p i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPersistentIdentifierID(java.lang.String archivePID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByPersistentIdentifierTypeID(
		long archivePIDType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByPersistentIdentifierTypeID_First(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByPersistentIdentifierTypeID_Last(
		long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByPersistentIdentifierTypeID_PrevAndNext(
		long submissionID, long archivePIDType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where archivePIDType = &#63; from the database.
	*
	* @param archivePIDType the archive p i d type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where archivePIDType = &#63;.
	*
	* @param archivePIDType the archive p i d type
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPersistentIdentifierTypeID(long archivePIDType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByUserID(
		long userID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByUserID(
		long userID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByUserID_First(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where userID = &#63;.
	*
	* @param userID the user i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByUserID_Last(long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByUserID_PrevAndNext(
		long submissionID, long userID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByIsPublic(
		boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByIsPublic_First(boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByIsPublic_First(boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByIsPublic_Last(boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByIsPublic_Last(boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByIsPublic_PrevAndNext(
		long submissionID, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where isPublic = &#63; from the database.
	*
	* @param isPublic the is public
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions where status = &#63;.
	*
	* @param status the status
	* @return the matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the first submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission
	* @throws org.gfbio.NoSuchSubmissionException if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the last submission in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching submission, or <code>null</code> if a matching submission could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gfbio.model.Submission[] findByStatus_PrevAndNext(
		long submissionID, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Removes all the submissions where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions where status = &#63;.
	*
	* @param status the status
	* @return the number of matching submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the submission in the entity cache if it is enabled.
	*
	* @param submission the submission
	*/
	public void cacheResult(org.gfbio.model.Submission submission);

	/**
	* Caches the submissions in the entity cache if it is enabled.
	*
	* @param submissions the submissions
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.Submission> submissions);

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionID the primary key for the new submission
	* @return the new submission
	*/
	public org.gfbio.model.Submission create(long submissionID);

	/**
	* Removes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionID the primary key of the submission
	* @return the submission that was removed
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission remove(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	public org.gfbio.model.Submission updateImpl(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission with the primary key or throws a {@link org.gfbio.NoSuchSubmissionException} if it could not be found.
	*
	* @param submissionID the primary key of the submission
	* @return the submission
	* @throws org.gfbio.NoSuchSubmissionException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission findByPrimaryKey(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchSubmissionException;

	/**
	* Returns the submission with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param submissionID the primary key of the submission
	* @return the submission, or <code>null</code> if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Submission fetchByPrimaryKey(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the submissions.
	*
	* @return the submissions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Submission> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.Submission> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the submissions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}