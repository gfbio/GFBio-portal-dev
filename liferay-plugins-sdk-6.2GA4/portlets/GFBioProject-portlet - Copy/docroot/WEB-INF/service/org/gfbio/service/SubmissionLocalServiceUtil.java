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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Submission. This utility wraps
 * {@link org.gfbio.service.impl.SubmissionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see SubmissionLocalService
 * @see org.gfbio.service.base.SubmissionLocalServiceBaseImpl
 * @see org.gfbio.service.impl.SubmissionLocalServiceImpl
 * @generated
 */
public class SubmissionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.SubmissionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the submission to the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission addSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubmission(submission);
	}

	/**
	* Creates a new submission with the primary key. Does not add the submission to the database.
	*
	* @param submissionID the primary key for the new submission
	* @return the new submission
	*/
	public static org.gfbio.model.Submission createSubmission(long submissionID) {
		return getService().createSubmission(submissionID);
	}

	/**
	* Deletes the submission with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionID the primary key of the submission
	* @return the submission that was removed
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission deleteSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmission(submissionID);
	}

	/**
	* Deletes the submission from the database. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission deleteSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmission(submission);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.gfbio.model.Submission fetchSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubmission(submissionID);
	}

	/**
	* Returns the submission with the primary key.
	*
	* @param submissionID the primary key of the submission
	* @return the submission
	* @throws PortalException if a submission with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission getSubmission(long submissionID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmission(submissionID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.Submission> getSubmissions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissions(start, end);
	}

	/**
	* Returns the number of submissions.
	*
	* @return the number of submissions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubmissionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionsCount();
	}

	/**
	* Updates the submission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submission the submission
	* @return the submission that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Submission updateSubmission(
		org.gfbio.model.Submission submission)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubmission(submission);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.json.simple.JSONObject deleteSubmission(
		org.json.simple.JSONObject requestJson) {
		return getService().deleteSubmission(requestJson);
	}

	public static org.json.simple.JSONObject getBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return getService().getBrokerSubmissionId(requestJson);
	}

	public static org.json.simple.JSONArray getLatestXPublicSubmissionsByX(
		org.json.simple.JSONObject requestJson) {
		return getService().getLatestXPublicSubmissionsByX(requestJson);
	}

	public static org.json.simple.JSONArray getStatusByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return getService().getStatusByResearchObjectId(requestJson);
	}

	public static org.json.simple.JSONArray getStatusByResearchObjectIdAndVersion(
		org.json.simple.JSONObject requestJson) {
		return getService().getStatusByResearchObjectIdAndVersion(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionsByBrokerSubmissionId(
		org.json.simple.JSONObject requestJson) {
		return getService().getSubmissionsByBrokerSubmissionId(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionsByResearchObjectId(
		org.json.simple.JSONObject requestJson) {
		return getService().getSubmissionsByResearchObjectId(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionsByResearchObjectIdAndVersion(
		org.json.simple.JSONObject requestJson) {
		return getService()
				   .getSubmissionsByResearchObjectIdAndVersion(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionIdsByResearchObjectIdAndVersion(
		org.json.simple.JSONObject requestJson) {
		return getService()
				   .getSubmissionIdsByResearchObjectIdAndVersion(requestJson);
	}

	public static java.util.List<java.lang.String> getArchivePIdsOfENA(
		java.lang.String archivePId) {
		return getService().getArchivePIdsOfENA(archivePId);
	}

	public static java.util.List<java.lang.String> getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType) {
		return getService()
				   .getArchivePIdsWithTypeOfENA(archivePId, researchObjectType);
	}

	public static java.util.List<java.lang.String> getArchivePIdsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		return getService().getArchivePIdsWithTypeSampleOfENA(archivePId);
	}

	public static long getArchivePIdType(java.lang.String archive) {
		return getService().getArchivePIdType(archive);
	}

	public static java.lang.String getArchivePIdWithTypeStudyOfENA(
		java.lang.String archivePId) {
		return getService().getArchivePIdWithTypeStudyOfENA(archivePId);
	}

	public static java.lang.String getBrokerSubmissionIdByIds(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive) {
		return getService()
				   .getBrokerSubmissionIdByIds(researchObjectId,
			researchObjectVersion, archive);
	}

	public static org.gfbio.model.Submission getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return getService().getLatestSubmissionByIds(researchObjectId, archive);
	}

	public static java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return getService().getLatestSubmissionsByArchive(archive);
	}

	public static java.util.List<org.gfbio.model.Submission> getLatestSubmissionsByResearchObjectId(
		long researchObjectId) {
		return getService()
				   .getLatestSubmissionsByResearchObjectId(researchObjectId);
	}

	public static java.util.List<org.gfbio.model.Submission> getLatestSubmissions() {
		return getService().getLatestSubmissions();
	}

	public static java.util.List<org.gfbio.model.Submission> getLatestXPublicSubmissionsByX(
		int latestX) {
		return getService().getLatestXPublicSubmissionsByX(latestX);
	}

	public static java.lang.String getStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return getService()
				   .getStatus(researchObjectId, researchObjectVersion, archive,
			archivePId);
	}

	public static int getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId) {
		return getService()
				   .getResearchObjectVersion(researchObjectId, archive,
			brokerSubmissionId);
	}

	public static java.lang.String getStatusByIds(long researchObjectId,
		int ResearchObjectVersion, java.lang.String archive) {
		return getService()
				   .getStatusByIds(researchObjectId, ResearchObjectVersion,
			archive);
	}

	public static org.gfbio.model.Submission getSubmission(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive) {
		return getService()
				   .getSubmission(researchObjectId, researchObjectVersion,
			archive);
	}

	public static java.util.List<org.gfbio.model.Submission> getSubmissionsByBrokerSubmissionId(
		java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSubmissionsByBrokerSubmissionId(brokerSubmissionId);
	}

	public static java.util.List<org.gfbio.model.Submission> getSubmissionsByResearchObjectId(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionsByResearchObjectId(researchObjectId);
	}

	public static long getSubmissionIdByIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive) {
		return getService()
				   .getSubmissionIdByIds(researchObjectId,
			researchObjectVersion, archive);
	}

	public static java.lang.Boolean checkOfIds(long researchObjectId,
		int researchObjectVersion, java.lang.String archive) {
		return getService()
				   .checkOfIds(researchObjectId, researchObjectVersion, archive);
	}

	public static java.lang.Boolean checkOfSubmissionId(long submissionId) {
		return getService().checkOfSubmissionId(submissionId);
	}

	public static java.lang.Boolean checkOfBrokerSubmissionId(
		java.lang.String brokersubmissionid) {
		return getService().checkOfBrokerSubmissionId(brokersubmissionid);
	}

	public static java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getService()
				   .checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static long constructNewId() {
		return getService().constructNewId();
	}

	public static org.json.simple.JSONArray constructSubmissionsJson(
		java.util.List<org.gfbio.model.Submission> submissionList) {
		return getService().constructSubmissionsJson(submissionList);
	}

	public static org.json.simple.JSONObject constructSubmissionJson(
		org.gfbio.model.Submission submission) {
		return getService().constructSubmissionJson(submission);
	}

	public static org.json.simple.JSONArray createSubmission(
		org.json.simple.JSONArray requestJson) {
		return getService().createSubmission(requestJson);
	}

	public static org.json.simple.JSONObject createSubmission(
		org.json.simple.JSONObject requestJson) {
		return getService().createSubmission(requestJson);
	}

	public static org.json.simple.JSONArray updateSubmission(
		org.json.simple.JSONArray requestJson) {
		return getService().updateSubmission(requestJson);
	}

	public static org.json.simple.JSONObject updateSubmission(
		org.json.simple.JSONObject requestJson) {
		return getService().updateSubmission(requestJson);
	}

	public static java.lang.Boolean updateKernelSubmission(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		long userId) {
		return getService()
				   .updateKernelSubmission(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, userId);
	}

	public static java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status) {
		return getService()
				   .updateSubmission(researchObjectId, researchObjectVersion,
			archive, brokerSubmissionId, archivePId, archivePIdType,
			lastChanged, userId, status);
	}

	public static java.lang.Boolean updateSubmission(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status, java.lang.Boolean isPublic,
		java.util.Date publicAfter) {
		return getService()
				   .updateSubmission(researchObjectId, researchObjectVersion,
			archive, brokerSubmissionId, archivePId, archivePIdType,
			lastChanged, userId, status, isPublic, publicAfter);
	}

	public static java.lang.Boolean updateSubmissionWithoutPId(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		java.util.Date lastChanged, long userID, java.lang.String status) {
		return getService()
				   .updateSubmissionWithoutPId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, lastChanged,
			userID, status);
	}

	public static java.lang.Boolean updateArchivePId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return getService()
				   .updateArchivePId(researchObjectId, researchObjectVersion,
			archive, archivePId);
	}

	public static java.lang.Boolean updateArchivePIdType(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, long archivePIdType) {
		return getService()
				   .updateArchivePIdType(researchObjectId,
			researchObjectVersion, archive, archivePIdType);
	}

	public static java.lang.Boolean updateBrokerSubmissionId(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId) {
		return getService()
				   .updateBrokerSubmissionId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId);
	}

	public static java.lang.Boolean updateIsPublic(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.Boolean isPublic) {
		return getService()
				   .updateIsPublic(researchObjectId, researchObjectVersion,
			archive, isPublic);
	}

	public static java.lang.Boolean updateJiraId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String jiraId) {
		return getService()
				   .updateJiraId(researchObjectId, researchObjectVersion,
			archive, jiraId);
	}

	public static java.lang.Boolean updateJiraKey(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String jiraKey) {
		return getService()
				   .updateJiraKey(researchObjectId, researchObjectVersion,
			archive, jiraKey);
	}

	public static java.lang.Boolean updateLastChanged(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date lastChanged) {
		return getService()
				   .updateLastChanged(researchObjectId, researchObjectVersion,
			archive, lastChanged);
	}

	public static java.lang.Boolean updatePublicAfter(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date publicAfter) {
		return getService()
				   .updatePublicAfter(researchObjectId, researchObjectVersion,
			archive, publicAfter);
	}

	public static java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) {
		return getService()
				   .updateStatus(researchObjectId, researchObjectVersion,
			archive, status);
	}

	public static java.lang.Boolean updateUserId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long userId) {
		return getService()
				   .updateUserId(researchObjectId, researchObjectVersion,
			archive, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubmissionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubmissionLocalService.class.getName());

			if (invokableLocalService instanceof SubmissionLocalService) {
				_service = (SubmissionLocalService)invokableLocalService;
			}
			else {
				_service = new SubmissionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SubmissionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubmissionLocalService service) {
	}

	private static SubmissionLocalService _service;
}