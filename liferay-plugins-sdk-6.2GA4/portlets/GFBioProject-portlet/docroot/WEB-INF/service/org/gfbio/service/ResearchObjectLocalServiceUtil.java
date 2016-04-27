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
 * Provides the local service utility for ResearchObject. This utility wraps
 * {@link org.gfbio.service.impl.ResearchObjectLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see ResearchObjectLocalService
 * @see org.gfbio.service.base.ResearchObjectLocalServiceBaseImpl
 * @see org.gfbio.service.impl.ResearchObjectLocalServiceImpl
 * @generated
 */
public class ResearchObjectLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.ResearchObjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the research object to the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject addResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addResearchObject(researchObject);
	}

	/**
	* Creates a new research object with the primary key. Does not add the research object to the database.
	*
	* @param researchObjectPK the primary key for the new research object
	* @return the new research object
	*/
	public static org.gfbio.model.ResearchObject createResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK) {
		return getService().createResearchObject(researchObjectPK);
	}

	/**
	* Deletes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object that was removed
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResearchObject(researchObjectPK);
	}

	/**
	* Deletes the research object from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResearchObject(researchObject);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.ResearchObject fetchResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchResearchObject(researchObjectPK);
	}

	/**
	* Returns the research object with the primary key.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject getResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObject(researchObjectPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the research objects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research objects
	* @param end the upper bound of the range of research objects (not inclusive)
	* @return the range of research objects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObjects(start, end);
	}

	/**
	* Returns the number of research objects.
	*
	* @return the number of research objects
	* @throws SystemException if a system exception occurred
	*/
	public static int getResearchObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResearchObjectsCount();
	}

	/**
	* Updates the research object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.ResearchObject updateResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateResearchObject(researchObject);
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

	public static org.json.simple.JSONArray getResearchObjectAsJsonById(
		org.json.simple.JSONArray requestJson) {
		return getService().getResearchObjectAsJsonById(requestJson);
	}

	public static org.json.simple.JSONObject getResearchObjectASJsonById(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectASJsonById(requestJson);
	}

	public static org.json.simple.JSONObject getResearchObjectAbsolutParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectAbsolutParent(requestJson);
	}

	public static org.json.simple.JSONArray getResearchObjectsByParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectsByParent(requestJson);
	}

	public static org.json.simple.JSONObject getResearchObjectParent(
		org.json.simple.JSONObject requestJson) {
		return getService().getResearchObjectParent(requestJson);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getAllChildren(
		long researchObjectId) {
		return getService().getAllChildren(researchObjectId);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getDirectChildren(
		long researchObjectId) {
		return getService().getDirectChildren(researchObjectId);
	}

	public static org.gfbio.model.ResearchObject getDirectParent(
		long researchObjectId) {
		return getService().getDirectParent(researchObjectId);
	}

	public static org.gfbio.model.ResearchObject getLatestResearchObjectById(
		long researchObjectId) {
		return getService().getLatestResearchObjectById(researchObjectId);
	}

	public static int getLatestVersionById(long researchObjectId) {
		return getService().getLatestVersionById(researchObjectId);
	}

	public static long getProjectIdByIds(long researchObjectId,
		int researchObjectVersion) {
		return getService()
				   .getProjectIdByIds(researchObjectId, researchObjectVersion);
	}

	public static java.util.List<org.gfbio.model.ResearchObject> getResearchObjectById(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return getService().getResearchObjectById(researchObjectId);
	}

	public static org.gfbio.model.ResearchObject getTopParent(
		long researchObjectId) {
		return getService().getTopParent(researchObjectId);
	}

	public static java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return getService().checkForIgnoredParameter(objects, keyList);
	}

	public static org.json.simple.JSONObject checkHCCBackground(
		java.lang.String tableName, java.lang.String columnName,
		java.lang.String label) {
		return getService().checkHCCBackground(tableName, columnName, label);
	}

	public static org.json.simple.JSONObject checkNullParent(
		org.json.simple.JSONObject json) {
		return getService().checkNullParent(json);
	}

	public static java.lang.Boolean checkParentAttributById(
		long researchObjectId) {
		return getService().checkParentAttributById(researchObjectId);
	}

	public static java.lang.Boolean checkResearchObjectId(long researchObjectId) {
		return getService().checkResearchObjectId(researchObjectId);
	}

	public static java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return getService()
				   .checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	public static org.json.simple.JSONObject constructResearchObjectJson(
		org.gfbio.model.ResearchObject researchObject) {
		return getService().constructResearchObjectJson(researchObject);
	}

	public static org.json.simple.JSONArray constructResearchObjectsJson(
		java.util.List<org.gfbio.model.ResearchObject> researchObjectList) {
		return getService().constructResearchObjectsJson(researchObjectList);
	}

	public static org.json.simple.JSONArray createResearchObjectByJson(
		org.json.simple.JSONArray requestJson) {
		return getService().createResearchObjectByJson(requestJson);
	}

	public static org.json.simple.JSONObject createResearchObjectByJson(
		org.json.simple.JSONObject requestJson) {
		return getService().createResearchObjectByJson(requestJson);
	}

	public static org.json.simple.JSONArray updateResearchObjectByJson(
		org.json.simple.JSONArray requestJson) {
		return getService().updateResearchObjectByJson(requestJson);
	}

	public static org.json.simple.JSONObject updateResearchObjectByJson(
		org.json.simple.JSONObject requestJson) {
		return getService().updateResearchObjectByJson(requestJson);
	}

	public static long createResearchObject(java.lang.String name,
		java.lang.String label, java.lang.String extendedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createResearchObject(name, label, extendedData);
	}

	public static long updateKernelResearchObject(long researchObjectId,
		int researchObjectVersion, java.lang.String name,
		java.lang.String label, java.lang.String extendedData) {
		return getService()
				   .updateKernelResearchObject(researchObjectId,
			researchObjectVersion, name, label, extendedData);
	}

	public static long updateResearchObjectWithProject(long projectId,
		long researchObjectId, int researchObjectVersion,
		java.lang.String name, java.lang.String label,
		java.lang.String extendedData, java.lang.String researchObjectType) {
		return getService()
				   .updateResearchObjectWithProject(projectId,
			researchObjectId, researchObjectVersion, name, label, extendedData,
			researchObjectType);
	}

	public static java.lang.Boolean updateAuthorId(long researchObjectId,
		int researchObjectVersion, java.lang.String authorMail) {
		return getService()
				   .updateAuthorId(researchObjectId, researchObjectVersion,
			authorMail);
	}

	public static java.lang.Boolean updateAuthorId(long researchObjectId,
		int researchObjectVersion, long authorId) {
		return getService()
				   .updateAuthorId(researchObjectId, researchObjectVersion,
			authorId);
	}

	public static java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, java.lang.String licenseLabel) {
		return getService()
				   .updateLicenseId(researchObjectId, researchObjectVersion,
			licenseLabel);
	}

	public static java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, long licenseId) {
		return getService()
				   .updateLicenseId(researchObjectId, researchObjectVersion,
			licenseId);
	}

	public static java.lang.Boolean updateMetadataId(long researchObjectId,
		int researchObjectVersion, long metadataId) {
		return getService()
				   .updateMetadataId(researchObjectId, researchObjectVersion,
			metadataId);
	}

	public static java.lang.Boolean updateParentResearchObjectIdByIds(
		long researchObjectId, int researchObjectVersion,
		long parentResearchObjectId) {
		return getService()
				   .updateParentResearchObjectIdByIds(researchObjectId,
			researchObjectVersion, parentResearchObjectId);
	}

	public static java.lang.Boolean updateResearchObjectType(
		long researchObjectId, int researchObjectVersion,
		java.lang.String researchObjectType) {
		return getService()
				   .updateResearchObjectType(researchObjectId,
			researchObjectVersion, researchObjectType);
	}

	public static int updateResearchObjectVersion(long researchObjectId,
		int researchObjectVersion) {
		return getService()
				   .updateResearchObjectVersion(researchObjectId,
			researchObjectVersion);
	}

	public static void clearService() {
		_service = null;
	}

	public static ResearchObjectLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ResearchObjectLocalService.class.getName());

			if (invokableLocalService instanceof ResearchObjectLocalService) {
				_service = (ResearchObjectLocalService)invokableLocalService;
			}
			else {
				_service = new ResearchObjectLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ResearchObjectLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ResearchObjectLocalService service) {
	}

	private static ResearchObjectLocalService _service;
}