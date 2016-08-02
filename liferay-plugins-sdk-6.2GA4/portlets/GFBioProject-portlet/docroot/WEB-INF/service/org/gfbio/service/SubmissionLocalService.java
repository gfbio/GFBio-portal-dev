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

package org.gfbio.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Submission. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Marcel Froemming
 * @see SubmissionLocalServiceUtil
 * @see org.gfbio.service.base.SubmissionLocalServiceBaseImpl
 * @see org.gfbio.service.impl.SubmissionLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SubmissionLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubmissionLocalServiceUtil} to access the submission local service. Add custom service methods to {@link org.gfbio.service.impl.SubmissionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the submission to the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Submission addSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionID the primary key for the new submission
	* @return the new submission
	*/
	public org.gfbio.model.Submission createSubmission(long submissionID);

	/**
	* Deletes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionID the primary key of the submission
	* @return the submission that was removed
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Submission deleteSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the submission from the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.gfbio.model.Submission deleteSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Submission fetchSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the submission with the primary key.
	*
	* @param submissionID the primary key of the submission
	* @return the submission
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Submission getSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getSubmissions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSubmissionsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.gfbio.model.Submission updateSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getLatestXPublicSubmissionsByX(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getSubmissionsByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.json.simple.JSONArray getSubmissionsByResearchObjectId(
		org.json.simple.JSONObject requestJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getArchivePIdsOfENA(
		java.lang.String archivePId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.String> getArchivePIdsWithTypeSampleOfENA(
		java.lang.String archivePId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getArchivePIdType(java.lang.String archive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getArchivePIdWithTypeStudyOfENA(
		java.lang.String archivePId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Submission getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByArchive(
		java.lang.String archive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByResearchObjectId(
		long researchObjectId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissions();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getLatestXPublicSubmissionsByX(
		int latestX);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getSubmissionsByBrokerSubmissionId(
		java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gfbio.model.Submission> getSubmissionsByResearchObjectId(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String GetStatusByIds(long researchObjectId,
		int ResearchObjectVersion, java.lang.String archive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getSubmissionIdByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gfbio.model.Submission getSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive);

	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList);

	public org.json.simple.JSONArray constructSubmissionsJson(
		java.util.List<org.gfbio.model.Submission> submissionList);

	public org.json.simple.JSONObject constructSubmissionJson(
		org.gfbio.model.Submission submission);

	public org.json.simple.JSONArray createSubmission(
		org.json.simple.JSONArray requestJson);

	public org.json.simple.JSONObject createSubmission(
		org.json.simple.JSONObject requestJson);

	public org.json.simple.JSONArray updateSubmission(
		org.json.simple.JSONArray requestJson);

	public org.json.simple.JSONObject updateSubmission(
		org.json.simple.JSONObject requestJson);

	public java.lang.Boolean updateKernelSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, long userId);

	public java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status);

	public java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status, java.lang.Boolean isPublic,
		java.util.Date publicAfter);

	public java.lang.Boolean updateSubmissionWithoutPId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.util.Date lastChanged,
		long userID, java.lang.String status);

	public java.lang.Boolean updateArchivePId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId);

	public java.lang.Boolean updateArchivePIdType(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long archivePIdType);

	public java.lang.Boolean updateBrokerSubmissionId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId);

	public java.lang.Boolean updateIsPublic(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.Boolean isPublic);

	public java.lang.Boolean updateLastChanged(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date lastChanged);

	public java.lang.Boolean updatePublicAfter(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date publicAfter);

	public java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status);

	public java.lang.Boolean updateUserId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long userId);
}