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
 * Provides a wrapper for {@link ResearchObjectLocalService}.
 *
 * @author Marcel Froemming
 * @see ResearchObjectLocalService
 * @generated
 */
public class ResearchObjectLocalServiceWrapper
	implements ResearchObjectLocalService,
		ServiceWrapper<ResearchObjectLocalService> {
	public ResearchObjectLocalServiceWrapper(
		ResearchObjectLocalService researchObjectLocalService) {
		_researchObjectLocalService = researchObjectLocalService;
	}

	/**
	* Adds the research object to the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject addResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.addResearchObject(researchObject);
	}

	/**
	* Creates a new research object with the primary key. Does not add the research object to the database.
	*
	* @param researchObjectPK the primary key for the new research object
	* @return the new research object
	*/
	@Override
	public org.gfbio.model.ResearchObject createResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK) {
		return _researchObjectLocalService.createResearchObject(researchObjectPK);
	}

	/**
	* Deletes the research object with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object that was removed
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.deleteResearchObject(researchObjectPK);
	}

	/**
	* Deletes the research object from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject deleteResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.deleteResearchObject(researchObject);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _researchObjectLocalService.dynamicQuery();
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
		return _researchObjectLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _researchObjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _researchObjectLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.ResearchObject fetchResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.fetchResearchObject(researchObjectPK);
	}

	/**
	* Returns the research object with the primary key.
	*
	* @param researchObjectPK the primary key of the research object
	* @return the research object
	* @throws PortalException if a research object with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject getResearchObject(
		org.gfbio.service.persistence.ResearchObjectPK researchObjectPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.getResearchObject(researchObjectPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjects(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.getResearchObjects(start, end);
	}

	/**
	* Returns the number of research objects.
	*
	* @return the number of research objects
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getResearchObjectsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.getResearchObjectsCount();
	}

	/**
	* Updates the research object in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchObject the research object
	* @return the research object that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject updateResearchObject(
		org.gfbio.model.ResearchObject researchObject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.updateResearchObject(researchObject);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _researchObjectLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_researchObjectLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _researchObjectLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONArray getResearchObjectAsJsonById(
		org.json.simple.JSONArray requestJson) {
		return _researchObjectLocalService.getResearchObjectAsJsonById(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getResearchObjectASJsonById(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.getResearchObjectASJsonById(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getResearchObjectAbsolutParent(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.getResearchObjectAbsolutParent(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getResearchObjectsByParent(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.getResearchObjectsByParent(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getResearchObjectParent(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.getResearchObjectParent(requestJson);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getAllChildren(
		long researchObjectId) {
		return _researchObjectLocalService.getAllChildren(researchObjectId);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getDirectChildren(
		long researchObjectId) {
		return _researchObjectLocalService.getDirectChildren(researchObjectId);
	}

	@Override
	public org.gfbio.model.ResearchObject getDirectParent(long researchObjectId) {
		return _researchObjectLocalService.getDirectParent(researchObjectId);
	}

	@Override
	public org.gfbio.model.ResearchObject getLatestResearchObjectById(
		long researchObjectId) {
		return _researchObjectLocalService.getLatestResearchObjectById(researchObjectId);
	}

	@Override
	public int getLatestVersionById(long researchObjectId) {
		return _researchObjectLocalService.getLatestVersionById(researchObjectId);
	}

	@Override
	public long getProjectIdByIds(long researchObjectId,
		int researchObjectVersion) {
		return _researchObjectLocalService.getProjectIdByIds(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjectById(
		long researchObjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchResearchObjectException {
		return _researchObjectLocalService.getResearchObjectById(researchObjectId);
	}

	@Override
	public org.gfbio.model.ResearchObject getTopParent(long researchObjectId) {
		return _researchObjectLocalService.getTopParent(researchObjectId);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _researchObjectLocalService.checkForIgnoredParameter(objects,
			keyList);
	}

	@Override
	public org.json.simple.JSONObject checkHCCBackground(
		java.lang.String tableName, java.lang.String columnName,
		java.lang.String label) {
		return _researchObjectLocalService.checkHCCBackground(tableName,
			columnName, label);
	}

	@Override
	public org.json.simple.JSONObject checkNullParent(
		org.json.simple.JSONObject json) {
		return _researchObjectLocalService.checkNullParent(json);
	}

	@Override
	public java.lang.Boolean checkParentAttributById(long researchObjectId) {
		return _researchObjectLocalService.checkParentAttributById(researchObjectId);
	}

	@Override
	public java.lang.Boolean checkResearchObjectId(long researchObjectId) {
		return _researchObjectLocalService.checkResearchObjectId(researchObjectId);
	}

	@Override
	public java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return _researchObjectLocalService.checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public org.json.simple.JSONObject constructResearchObjectJson(
		org.gfbio.model.ResearchObject researchObject) {
		return _researchObjectLocalService.constructResearchObjectJson(researchObject);
	}

	@Override
	public org.json.simple.JSONArray constructResearchObjectsJson(
		java.util.List<org.gfbio.model.ResearchObject> researchObjectList) {
		return _researchObjectLocalService.constructResearchObjectsJson(researchObjectList);
	}

	@Override
	public org.json.simple.JSONArray createResearchObjectByJson(
		org.json.simple.JSONArray requestJson) {
		return _researchObjectLocalService.createResearchObjectByJson(requestJson);
	}

	@Override
	public org.json.simple.JSONObject createResearchObjectByJson(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.createResearchObjectByJson(requestJson);
	}

	@Override
	public org.json.simple.JSONArray updateResearchObjectByJson(
		org.json.simple.JSONArray requestJson) {
		return _researchObjectLocalService.updateResearchObjectByJson(requestJson);
	}

	@Override
	public org.json.simple.JSONObject updateResearchObjectByJson(
		org.json.simple.JSONObject requestJson) {
		return _researchObjectLocalService.updateResearchObjectByJson(requestJson);
	}

	@Override
	public long createResearchObject(java.lang.String name,
		java.lang.String label, java.lang.String extendedData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObjectLocalService.createResearchObject(name, label,
			extendedData);
	}

	@Override
	public long updateKernelResearchObject(long researchObjectId,
		int researchObjectVersion, java.lang.String name,
		java.lang.String label, java.lang.String extendedData) {
		return _researchObjectLocalService.updateKernelResearchObject(researchObjectId,
			researchObjectVersion, name, label, extendedData);
	}

	@Override
	public long updateResearchObjectWithProject(long projectId,
		long researchObjectId, int researchObjectVersion,
		java.lang.String name, java.lang.String label,
		java.lang.String extendedData, java.lang.String researchObjectType) {
		return _researchObjectLocalService.updateResearchObjectWithProject(projectId,
			researchObjectId, researchObjectVersion, name, label, extendedData,
			researchObjectType);
	}

	@Override
	public java.lang.Boolean updateAuthorId(long researchObjectId,
		int researchObjectVersion, java.lang.String authorMail) {
		return _researchObjectLocalService.updateAuthorId(researchObjectId,
			researchObjectVersion, authorMail);
	}

	@Override
	public java.lang.Boolean updateAuthorId(long researchObjectId,
		int researchObjectVersion, long authorId) {
		return _researchObjectLocalService.updateAuthorId(researchObjectId,
			researchObjectVersion, authorId);
	}

	@Override
	public java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, java.lang.String licenseLabel) {
		return _researchObjectLocalService.updateLicenseId(researchObjectId,
			researchObjectVersion, licenseLabel);
	}

	@Override
	public java.lang.Boolean updateLicenseId(long researchObjectId,
		int researchObjectVersion, long licenseId) {
		return _researchObjectLocalService.updateLicenseId(researchObjectId,
			researchObjectVersion, licenseId);
	}

	@Override
	public java.lang.Boolean updateMetadataId(long researchObjectId,
		int researchObjectVersion, long metadataId) {
		return _researchObjectLocalService.updateMetadataId(researchObjectId,
			researchObjectVersion, metadataId);
	}

	@Override
	public java.lang.Boolean updateParentResearchObjectIdByIds(
		long researchObjectId, int researchObjectVersion,
		long parentResearchObjectId) {
		return _researchObjectLocalService.updateParentResearchObjectIdByIds(researchObjectId,
			researchObjectVersion, parentResearchObjectId);
	}

	@Override
	public java.lang.Boolean updateResearchObjectType(long researchObjectId,
		int researchObjectVersion, java.lang.String researchObjectType) {
		return _researchObjectLocalService.updateResearchObjectType(researchObjectId,
			researchObjectVersion, researchObjectType);
	}

	@Override
	public int updateResearchObjectVersion(long researchObjectId,
		int researchObjectVersion) {
		return _researchObjectLocalService.updateResearchObjectVersion(researchObjectId,
			researchObjectVersion);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResearchObjectLocalService getWrappedResearchObjectLocalService() {
		return _researchObjectLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResearchObjectLocalService(
		ResearchObjectLocalService researchObjectLocalService) {
		_researchObjectLocalService = researchObjectLocalService;
	}

	@Override
	public ResearchObjectLocalService getWrappedService() {
		return _researchObjectLocalService;
	}

	@Override
	public void setWrappedService(
		ResearchObjectLocalService researchObjectLocalService) {
		_researchObjectLocalService = researchObjectLocalService;
	}

	private ResearchObjectLocalService _researchObjectLocalService;
}