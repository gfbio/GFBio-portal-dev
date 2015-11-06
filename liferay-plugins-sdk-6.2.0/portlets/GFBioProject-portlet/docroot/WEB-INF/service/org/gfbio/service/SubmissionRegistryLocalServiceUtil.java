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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SubmissionRegistry. This utility wraps
 * {@link org.gfbio.service.impl.SubmissionRegistryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see SubmissionRegistryLocalService
 * @see org.gfbio.service.base.SubmissionRegistryLocalServiceBaseImpl
 * @see org.gfbio.service.impl.SubmissionRegistryLocalServiceImpl
 * @generated
 */
public class SubmissionRegistryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.SubmissionRegistryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the submission registry to the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry addSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubmissionRegistry(submissionRegistry);
	}

	/**
	* Creates a new submission registry with the primary key. Does not add the submission registry to the database.
	*
	* @param submissionRegistryPK the primary key for the new submission registry
	* @return the new submission registry
	*/
	public static org.gfbio.model.SubmissionRegistry createSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK) {
		return getService().createSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Deletes the submission registry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry that was removed
	* @throws PortalException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry deleteSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Deletes the submission registry from the database. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry deleteSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubmissionRegistry(submissionRegistry);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.SubmissionRegistryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.SubmissionRegistry fetchSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubmissionRegistry(submissionRegistryPK);
	}

	/**
	* Returns the submission registry with the primary key.
	*
	* @param submissionRegistryPK the primary key of the submission registry
	* @return the submission registry
	* @throws PortalException if a submission registry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry getSubmissionRegistry(
		org.gfbio.service.persistence.SubmissionRegistryPK submissionRegistryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionRegistry(submissionRegistryPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionRegistries(start, end);
	}

	/**
	* Returns the number of submission registries.
	*
	* @return the number of submission registries
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubmissionRegistriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubmissionRegistriesCount();
	}

	/**
	* Updates the submission registry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param submissionRegistry the submission registry
	* @return the submission registry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.SubmissionRegistry updateSubmissionRegistry(
		org.gfbio.model.SubmissionRegistry submissionRegistry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubmissionRegistry(submissionRegistry);
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

	public static org.json.simple.JSONArray getSubmissionRegistriesByBrokerSubmissionId(
		org.json.simple.JSONArray requestJson)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSubmissionRegistriesByBrokerSubmissionId(requestJson);
	}

	public static org.json.simple.JSONArray getSubmissionRegistriesByResearchObjectId(
		org.json.simple.JSONArray requestJson) {
		return getService()
				   .getSubmissionRegistriesByResearchObjectId(requestJson);
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

	public static org.gfbio.model.SubmissionRegistry getLatestSubmissionByIds(
		long researchObjectId, java.lang.String archive) {
		return getService().getLatestSubmissionByIds(researchObjectId, archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByArchive(
		java.lang.String archive) {
		return getService().getLatestSubmissionsByArchive(archive);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissionsByResearchObjectId(
		long researchObjectId) {
		return getService()
				   .getLatestSubmissionsByResearchObjectId(researchObjectId);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getLatestSubmissions() {
		return getService().getLatestSubmissions();
	}

	public static java.lang.String getStatus(long researchObjectId,
		int researchObjectVersion, java.lang.String archive,
		java.lang.String archivePId) {
		return getService()
				   .getStatus(researchObjectId, researchObjectVersion, archive,
			archivePId);
	}

	public static int getResearchObjectVersion(long researchObjectId,
		java.lang.String archive, java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getResearchObjectVersion(researchObjectId, archive,
			brokerSubmissionId);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistriesByBrokerSubmissionId(
		java.lang.String brokerSubmissionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSubmissionRegistriesByBrokerSubmissionId(brokerSubmissionId);
	}

	public static java.util.List<org.gfbio.model.SubmissionRegistry> getSubmissionRegistriesByResearchObjectId(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSubmissionRegistriesByResearchObjectId(researchObjectId);
	}

	public static java.lang.String GetStatusByIds(long researchObjectId,
		int ResearchObjectVersion, java.lang.String archive) {
		return getService()
				   .GetStatusByIds(researchObjectId, ResearchObjectVersion,
			archive);
	}

	public static org.gfbio.model.SubmissionRegistry getSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive) {
		return getService()
				   .getSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive);
	}

	public static org.json.simple.JSONArray constructSubmissionRegistriesJson(
		java.util.List<org.gfbio.model.SubmissionRegistry> submissionRegistryList) {
		return getService()
				   .constructSubmissionRegistriesJson(submissionRegistryList);
	}

	public static org.json.simple.JSONObject constructSubmissionRegistryJson(
		org.gfbio.model.SubmissionRegistry submissionRegistry) {
		return getService().constructSubmissionRegistryJson(submissionRegistry);
	}

	public static org.json.simple.JSONArray createSubmissionRegistry(
		org.json.simple.JSONArray requestJson) {
		return getService().createSubmissionRegistry(requestJson);
	}

	public static org.json.simple.JSONObject createSubmissionRegistry(
		org.json.simple.JSONObject requestJson) {
		return getService().createSubmissionRegistry(requestJson);
	}

	public static org.json.simple.JSONArray updateSubmissionRegistry(
		org.json.simple.JSONArray requestJson) {
		return getService().updateSubmissionRegistry(requestJson);
	}

	public static org.json.simple.JSONObject updateSubmissionRegistry(
		org.json.simple.JSONObject requestJson) {
		return getService().updateSubmissionRegistry(requestJson);
	}

	public static java.lang.Boolean updateKernelSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		long userId) {
		return getService()
				   .updateKernelSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, userId);
	}

	public static java.lang.Boolean updateSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		java.lang.String archivePId, long archivePIdType,
		java.util.Date lastChanged, long userId, java.lang.String status) {
		return getService()
				   .updateSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status);
	}

	public static java.lang.Boolean updateSubmissionRegistry(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		java.lang.String archivePId, long archivePIdType,
		java.util.Date lastChanged, long userId, java.lang.String status,
		java.lang.Boolean isPublic, java.util.Date publicAfter) {
		return getService()
				   .updateSubmissionRegistry(researchObjectId,
			researchObjectVersion, archive, brokerSubmissionId, archivePId,
			archivePIdType, lastChanged, userId, status, isPublic, publicAfter);
	}

	public static java.lang.Boolean updateSubmissionRegistryWithoutPId(
		long researchObjectId, int researchObjectVersion,
		java.lang.String archive, java.lang.String brokerSubmissionId,
		java.util.Date lastChanged, long userID, java.lang.String status) {
		return getService()
				   .updateSubmissionRegistryWithoutPId(researchObjectId,
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

	public static SubmissionRegistryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SubmissionRegistryLocalService.class.getName());

			if (invokableLocalService instanceof SubmissionRegistryLocalService) {
				_service = (SubmissionRegistryLocalService)invokableLocalService;
			}
			else {
				_service = new SubmissionRegistryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SubmissionRegistryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SubmissionRegistryLocalService service) {
	}

	private static SubmissionRegistryLocalService _service;
}