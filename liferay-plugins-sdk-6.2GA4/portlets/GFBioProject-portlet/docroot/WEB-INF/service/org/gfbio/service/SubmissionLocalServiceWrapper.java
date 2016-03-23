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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubmissionLocalService}.
 *
 * @author Marcel Froemming
 * @see SubmissionLocalService
 * @generated
 */
public class SubmissionLocalServiceWrapper implements SubmissionLocalService,
	ServiceWrapper<SubmissionLocalService> {
	public SubmissionLocalServiceWrapper(
		SubmissionLocalService submissionLocalService) {
		_submissionLocalService = submissionLocalService;
	}

	/**
	* Adds the submission to the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Submission addSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.addSubmission(submission);
	}

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionID the primary key for the new submission
	* @return the new submission
	*/
	@Override
	public org.gfbio.model.Submission createSubmission(long submissionID) {
		return _submissionLocalService.createSubmission(submissionID);
	}

	/**
	* Deletes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionID the primary key of the submission
	* @return the submission that was removed
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Submission deleteSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.deleteSubmission(submissionID);
	}

	/**
	* Deletes the submission from the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Submission deleteSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.deleteSubmission(submission);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _submissionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.Submission fetchSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.fetchSubmission(submissionID);
	}

	/**
	* Returns the submission with the primary key.
	*
	* @param submissionID the primary key of the submission
	* @return the submission
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Submission getSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getSubmission(submissionID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.gfbio.model.Submission> getSubmissions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getSubmissions(start, end);
	}

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubmissionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getSubmissionsCount();
	}

	/**
	* Updates the submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Submission updateSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.updateSubmission(submission);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONArray getLatestXPublicSubmissionsByX(
		org.json.simple.JSONObject requestJson) {
		return _submissionLocalService.getLatestXPublicSubmissionsByX(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getSubmissionsByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return _submissionLocalService.getSubmissionsByBrokerSubmissionId(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getSubmissionsByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return _submissionLocalService.getSubmissionsByResearchObjectId(requestJson);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsOfENA(
		java.lang.String archivePId) {
		return _submissionLocalService.getArchivePIdsOfENA(archivePId);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType) {
		return _submissionLocalService.getArchivePIdsWithTypeOfENA(archivePId,
			researchObjectType);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		return _submissionLocalService.getArchivePIdsWithTypeSampleOfENA(archivePId);
	}

	@Override
	public long getArchivePIdType(java.lang.String archive) {
		return _submissionLocalService.getArchivePIdType(archive);
	}

	@Override
	public java.lang.String getArchivePIdWithTypeStudyOfENA(
		java.lang.String archivePId) {
		return _submissionLocalService.getArchivePIdWithTypeStudyOfENA(archivePId);
	}

	@Override
	public org.gfbio.model.Submission getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return _submissionLocalService.getLatestSubmissionByIds(researchObjectId,
			archive);
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return _submissionLocalService.getLatestSubmissionsByArchive(archive);
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByResearchObjectId(
		long researchObjectId) {
		return _submissionLocalService.getLatestSubmissionsByResearchObjectId(researchObjectId);
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getLatestSubmissions() {
		return _submissionLocalService.getLatestSubmissions();
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getLatestXPublicSubmissionsByX(
		int latestX) {
		return _submissionLocalService.getLatestXPublicSubmissionsByX(latestX);
	}

	@Override
	public java.lang.String getStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return _submissionLocalService.getStatus(researchObjectId,
			researchObjectVersion, archive, archivePId);
	}

	@Override
	public int getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId) {
		return _submissionLocalService.getResearchObjectVersion(researchObjectId,
			archive, brokerSubmissionId);
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getSubmissionsByBrokerSubmissionId(
		java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getSubmissionsByBrokerSubmissionId(brokerSubmissionId);
	}

	@Override
	public java.util.List<org.gfbio.model.Submission> getSubmissionsByResearchObjectId(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionLocalService.getSubmissionsByResearchObjectId(researchObjectId);
	}

	@Override
	public java.lang.String GetStatusByIds(long researchObjectId,
		int ResearchObjectVersion, java.lang.String archive) {
		return _submissionLocalService.GetStatusByIds(researchObjectId,
			ResearchObjectVersion, archive);
	}

	@Override
	public long getSubmissionIdByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive) {
		return _submissionLocalService.getSubmissionIdByIds(researchObjectId,
			researchObjectVersion, archive);
	}

	@Override
	public org.gfbio.model.Submission getSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive) {
		return _submissionLocalService.getSubmission(researchObjectId,
			researchObjectVersion, archive);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _submissionLocalService.checkForIgnoredParameter(objects, keyList);
	}

	@Override
	public org.json.simple.JSONArray constructSubmissionsJson(
		java.util.List<org.gfbio.model.Submission> submissionList) {
		return _submissionLocalService.constructSubmissionsJson(submissionList);
	}

	@Override
	public org.json.simple.JSONObject constructSubmissionJson(
		org.gfbio.model.Submission submission) {
		return _submissionLocalService.constructSubmissionJson(submission);
	}

	@Override
	public org.json.simple.JSONArray createSubmission(
		org.json.simple.JSONArray requestJson) {
		return _submissionLocalService.createSubmission(requestJson);
	}

	@Override
	public org.json.simple.JSONObject createSubmission(
		org.json.simple.JSONObject requestJson) {
		return _submissionLocalService.createSubmission(requestJson);
	}

	@Override
	public org.json.simple.JSONArray updateSubmission(
		org.json.simple.JSONArray requestJson) {
		return _submissionLocalService.updateSubmission(requestJson);
	}

	@Override
	public org.json.simple.JSONObject updateSubmission(
		org.json.simple.JSONObject requestJson) {
		return _submissionLocalService.updateSubmission(requestJson);
	}

	@Override
	public java.lang.Boolean updateKernelSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, long userId) {
		return _submissionLocalService.updateKernelSubmission(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, userId);
	}

	@Override
	public java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status) {
		return _submissionLocalService.updateSubmission(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status);
	}

	@Override
	public java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status, java.lang.Boolean isPublic,
		java.util.Date publicAfter) {
		return _submissionLocalService.updateSubmission(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status, isPublic, publicAfter);
	}

	@Override
	public java.lang.Boolean updateSubmissionWithoutPId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.util.Date lastChanged,
		long userID, java.lang.String status) {
		return _submissionLocalService.updateSubmissionWithoutPId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, lastChanged,
			userID, status);
	}

	@Override
	public java.lang.Boolean updateArchivePId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return _submissionLocalService.updateArchivePId(researchObjectId,
			researchObjectVersion, archive, archivePId);
	}

	@Override
	public java.lang.Boolean updateArchivePIdType(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long archivePIdType) {
		return _submissionLocalService.updateArchivePIdType(researchObjectId,
			researchObjectVersion, archive, archivePIdType);
	}

	@Override
	public java.lang.Boolean updateBrokerSubmissionId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId) {
		return _submissionLocalService.updateBrokerSubmissionId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId);
	}

	@Override
	public java.lang.Boolean updateIsPublic(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.Boolean isPublic) {
		return _submissionLocalService.updateIsPublic(researchObjectId,
			researchObjectVersion, archive, isPublic);
	}

	@Override
	public java.lang.Boolean updateLastChanged(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date lastChanged) {
		return _submissionLocalService.updateLastChanged(researchObjectId,
			researchObjectVersion, archive, lastChanged);
	}

	@Override
	public java.lang.Boolean updatePublicAfter(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date publicAfter) {
		return _submissionLocalService.updatePublicAfter(researchObjectId,
			researchObjectVersion, archive, publicAfter);
	}

	@Override
	public java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) {
		return _submissionLocalService.updateStatus(researchObjectId,
			researchObjectVersion, archive, status);
	}

	@Override
	public java.lang.Boolean updateUserId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long userId) {
		return _submissionLocalService.updateUserId(researchObjectId,
			researchObjectVersion, archive, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionLocalService getWrappedSubmissionLocalService() {
		return _submissionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionLocalService(
		SubmissionLocalService submissionLocalService) {
		_submissionLocalService = submissionLocalService;
	}

	@Override
	public SubmissionLocalService getWrappedService() {
		return _submissionLocalService;
	}

	@Override
	public void setWrappedService(SubmissionLocalService submissionLocalService) {
		_submissionLocalService = submissionLocalService;
	}

	private SubmissionLocalService _submissionLocalService;
}