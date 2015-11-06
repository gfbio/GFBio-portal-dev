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

package org.gfbio.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubmissionRegistryLocalService}.
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryLocalService
 * @generated
 */
public class SubmissionRegistryLocalServiceWrapper
	implements SubmissionRegistryLocalService,
		ServiceWrapper<SubmissionRegistryLocalService> {
	public SubmissionRegistryLocalServiceWrapper(
		SubmissionRegistryLocalService submissionRegistryLocalService) {
		_submissionRegistryLocalService = submissionRegistryLocalService;
	}

	/**
	* Adds the submission registry to the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry addSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.addSubmissionRegistry(submissionRegistry);
	}

	/**
	* Creates a new submission registry with the primary key. Does not add the submission registry to the database.
	*
	* @param submissionRegistryPK the primary key for the new submission registry
	* @return the new submission registry
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry createSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK) {
		return _submissionRegistryLocalService.createSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Deletes the submission registry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry that was removed
	* @throws PortalException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry deleteSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.deleteSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Deletes the submission registry from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry deleteSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.deleteSubmissionRegistry(submissionRegistry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _submissionRegistryLocalService.dynamicQuery();
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
		return _submissionRegistryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _submissionRegistryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _submissionRegistryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _submissionRegistryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _submissionRegistryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.SubmissionRegistry fetchSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.fetchSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Returns the submission registry with the primary key.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry
	* @throws PortalException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry getSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistry(submissionRegistryPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistries(start,
			end);
	}

	/**
	* Returns the number of submission registries.
	*
	* @return the number of submission registries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSubmissionRegistriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistriesCount();
	}

	/**
	* Updates the submission registry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.SubmissionRegistry updateSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.updateSubmissionRegistry(submissionRegistry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _submissionRegistryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_submissionRegistryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _submissionRegistryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getSubmissionRegistriesByBrokerSubmissionId(
		org.json.simple.JSONArray requestJson)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistriesByBrokerSubmissionId(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getSubmissionRegistriesByResearchObjectId(
		org.json.simple.JSONArray requestJson) {
		return _submissionRegistryLocalService.getSubmissionRegistriesByResearchObjectId(requestJson);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryLocalService.getArchivePIdsOfENA(archivePId);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsWithTypeOfENA(
		java.lang.String archivePId, java.lang.String researchObjectType) {
		return _submissionRegistryLocalService.getArchivePIdsWithTypeOfENA(archivePId,
			researchObjectType);
	}

	@Override
	public java.util.List<java.lang.String> getArchivePIdsWithTypeSampleOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryLocalService.getArchivePIdsWithTypeSampleOfENA(archivePId);
	}

	@Override
	public long getArchivePIdType(java.lang.String archive) {
		return _submissionRegistryLocalService.getArchivePIdType(archive);
	}

	@Override
	public java.lang.String getArchivePIdWithTypeStudyOfENA(
		java.lang.String archivePId) {
		return _submissionRegistryLocalService.getArchivePIdWithTypeStudyOfENA(archivePId);
	}

	@Override
	public org.gfbio.model.SubmissionRegistry getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return _submissionRegistryLocalService.getLatestSubmissionByIds(researchObjectId,
			archive);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return _submissionRegistryLocalService.getLatestSubmissionsByArchive(archive);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchObjectId(
		long researchObjectId) {
		return _submissionRegistryLocalService.getLatestSubmissionsByResearchObjectId(researchObjectId);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		return _submissionRegistryLocalService.getLatestSubmissions();
	}

	@Override
	public java.lang.String getStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return _submissionRegistryLocalService.getStatus(researchObjectId,
			researchObjectVersion, archive, archivePId);
	}

	@Override
	public int getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getResearchObjectVersion(researchObjectId,
			archive, brokerSubmissionId);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistriesByBrokerSubmissionId(
		java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistriesByBrokerSubmissionId(brokerSubmissionId);
	}

	@Override
	public java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistriesByResearchObjectId(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _submissionRegistryLocalService.getSubmissionRegistriesByResearchObjectId(researchObjectId);
	}

	@Override
	public java.lang.String GetStatusByIds(long researchObjectId,
		int ResearchObjectVersion, java.lang.String archive) {
		return _submissionRegistryLocalService.GetStatusByIds(researchObjectId,
			ResearchObjectVersion, archive);
	}

	@Override
	public org.gfbio.model.SubmissionRegistry getSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive) {
		return _submissionRegistryLocalService.getSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive);
	}

	@Override
	public org.json.simple.JSONArray constructSubmissionRegistriesJson(
		java.util.List<org.gfbio.model.SubmissionRegistry> submissionRegistryList) {
		return _submissionRegistryLocalService.constructSubmissionRegistriesJson(submissionRegistryList);
	}

	@Override
	public org.json.simple.JSONObject constructSubmissionRegistryJson(
		org.gfbio.model.SubmissionRegistry submissionRegistry) {
		return _submissionRegistryLocalService.constructSubmissionRegistryJson(submissionRegistry);
	}

	@Override
	public org.json.simple.JSONArray createSubmissionRegistry(
		org.json.simple.JSONArray requestJson) {
		return _submissionRegistryLocalService.createSubmissionRegistry(requestJson);
	}

	@Override
	public org.json.simple.JSONObject createSubmissionRegistry(
		org.json.simple.JSONObject requestJson) {
		return _submissionRegistryLocalService.createSubmissionRegistry(requestJson);
	}

	@Override
	public org.json.simple.JSONArray updateSubmissionRegistry(
		org.json.simple.JSONArray requestJson) {
		return _submissionRegistryLocalService.updateSubmissionRegistry(requestJson);
	}

	@Override
	public org.json.simple.JSONObject updateSubmissionRegistry(
		org.json.simple.JSONObject requestJson) {
		return _submissionRegistryLocalService.updateSubmissionRegistry(requestJson);
	}

	@Override
	public java.lang.Boolean updateKernelSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		long userId) {
		return _submissionRegistryLocalService.updateKernelSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, userId);
	}

	@Override
	public java.lang.Boolean updateSubmissionRegistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status) {
		return _submissionRegistryLocalService.updateSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status);
	}

	@Override
	public java.lang.Boolean updateSubmissionRegistry(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId, java.lang.String archivePId,
		long archivePIdType, java.util.Date lastChanged, long userId,
		java.lang.String status, java.lang.Boolean isPublic,
		java.util.Date publicAfter) {
		return _submissionRegistryLocalService.updateSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status, isPublic, publicAfter);
	}

	@Override
	public java.lang.Boolean updateSubmissionRegistryWithoutPId(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		java.util.Date lastChanged, long userID, java.lang.String status) {
		return _submissionRegistryLocalService.updateSubmissionRegistryWithoutPId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, lastChanged,
			userID, status);
	}

	@Override
	public java.lang.Boolean updateArchivePId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return _submissionRegistryLocalService.updateArchivePId(researchObjectId,
			researchObjectVersion, archive, archivePId);
	}

	@Override
	public java.lang.Boolean updateArchivePIdType(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long archivePIdType) {
		return _submissionRegistryLocalService.updateArchivePIdType(researchObjectId,
			researchObjectVersion, archive, archivePIdType);
	}

	@Override
	public java.lang.Boolean updateBrokerSubmissionId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String brokerSubmissionId) {
		return _submissionRegistryLocalService.updateBrokerSubmissionId(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId);
	}

	@Override
	public java.lang.Boolean updateIsPublic(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.Boolean isPublic) {
		return _submissionRegistryLocalService.updateIsPublic(researchObjectId,
			researchObjectVersion, archive, isPublic);
	}

	@Override
	public java.lang.Boolean updateLastChanged(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date lastChanged) {
		return _submissionRegistryLocalService.updateLastChanged(researchObjectId,
			researchObjectVersion, archive, lastChanged);
	}

	@Override
	public java.lang.Boolean updatePublicAfter(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.util.Date publicAfter) {
		return _submissionRegistryLocalService.updatePublicAfter(researchObjectId,
			researchObjectVersion, archive, publicAfter);
	}

	@Override
	public java.lang.Boolean updateStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String status) {
		return _submissionRegistryLocalService.updateStatus(researchObjectId,
			researchObjectVersion, archive, status);
	}

	@Override
	public java.lang.Boolean updateUserId(long researchObjectId,
		int researchObjectVersion, java.lang.String archive, long userId) {
		return _submissionRegistryLocalService.updateUserId(researchObjectId,
			researchObjectVersion, archive, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SubmissionRegistryLocalService getWrappedSubmissionRegistryLocalService() {
		return _submissionRegistryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSubmissionRegistryLocalService(
		SubmissionRegistryLocalService submissionRegistryLocalService) {
		_submissionRegistryLocalService = submissionRegistryLocalService;
	}

	@Override
	public SubmissionRegistryLocalService getWrappedService() {
		return _submissionRegistryLocalService;
	}

	@Override
	public void setWrappedService(
		SubmissionRegistryLocalService submissionRegistryLocalService) {
		_submissionRegistryLocalService = submissionRegistryLocalService;
	}

	private SubmissionRegistryLocalService _submissionRegistryLocalService;
}