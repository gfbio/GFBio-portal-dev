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
 * Provides a wrapper for {@link ResearchObject_UserLocalService}.
 *
 * @author Marcel Froemming
 * @see ResearchObject_UserLocalService
 * @generated
 */
public class ResearchObject_UserLocalServiceWrapper
	implements ResearchObject_UserLocalService,
		ServiceWrapper<ResearchObject_UserLocalService> {
	public ResearchObject_UserLocalServiceWrapper(
		ResearchObject_UserLocalService researchObject_UserLocalService) {
		_researchObject_UserLocalService = researchObject_UserLocalService;
	}

	/**
	* Adds the research object_ user to the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject_User addResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.addResearchObject_User(researchObject_User);
	}

	/**
	* Creates a new research object_ user with the primary key. Does not add the research object_ user to the database.
	*
	* @param researchObject_UserPK the primary key for the new research object_ user
	* @return the new research object_ user
	*/
	@Override
	public org.gfbio.model.ResearchObject_User createResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK) {
		return _researchObject_UserLocalService.createResearchObject_User(researchObject_UserPK);
	}

	/**
	* Deletes the research object_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user that was removed
	* @throws PortalException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject_User deleteResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.deleteResearchObject_User(researchObject_UserPK);
	}

	/**
	* Deletes the research object_ user from the database. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject_User deleteResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.deleteResearchObject_User(researchObject_User);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _researchObject_UserLocalService.dynamicQuery();
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
		return _researchObject_UserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _researchObject_UserLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _researchObject_UserLocalService.dynamicQuery(dynamicQuery,
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
		return _researchObject_UserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _researchObject_UserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.ResearchObject_User fetchResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.fetchResearchObject_User(researchObject_UserPK);
	}

	/**
	* Returns the research object_ user with the primary key.
	*
	* @param researchObject_UserPK the primary key of the research object_ user
	* @return the research object_ user
	* @throws PortalException if a research object_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject_User getResearchObject_User(
		org.gfbio.service.persistence.ResearchObject_UserPK researchObject_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.getResearchObject_User(researchObject_UserPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the research object_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ResearchObject_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of research object_ users
	* @param end the upper bound of the range of research object_ users (not inclusive)
	* @return the range of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.ResearchObject_User> getResearchObject_Users(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.getResearchObject_Users(start,
			end);
	}

	/**
	* Returns the number of research object_ users.
	*
	* @return the number of research object_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getResearchObject_UsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.getResearchObject_UsersCount();
	}

	/**
	* Updates the research object_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param researchObject_User the research object_ user
	* @return the research object_ user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.ResearchObject_User updateResearchObject_User(
		org.gfbio.model.ResearchObject_User researchObject_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _researchObject_UserLocalService.updateResearchObject_User(researchObject_User);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _researchObject_UserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_researchObject_UserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _researchObject_UserLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.json.simple.JSONArray getUserIdsByResearchObject(
		org.json.simple.JSONObject requestJson) {
		return _researchObject_UserLocalService.getUserIdsByResearchObject(requestJson);
	}

	@Override
	public java.lang.String getFullNamesAsString(
		org.json.simple.JSONArray requestJson) {
		return _researchObject_UserLocalService.getFullNamesAsString(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getOwnerAndPiByResearchObjectId(
		long researchObjectId) {
		return _researchObject_UserLocalService.getOwnerAndPiByResearchObjectId(researchObjectId);
	}

	@Override
	public java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId) {
		return _researchObject_UserLocalService.getOwnerIdsByResearchObjectIds(researchObjectId);
	}

	@Override
	public java.util.List<java.lang.Long> getOwnerIdsByResearchObjectIds(
		long researchObjectId, int researchObjectVersion) {
		return _researchObject_UserLocalService.getOwnerIdsByResearchObjectIds(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject> getResearchObjectsByUserId(
		long userId) {
		return _researchObject_UserLocalService.getResearchObjectsByUserId(userId);
	}

	@Override
	public java.util.List<org.gfbio.model.ResearchObject_User> getResearchObjectIdList(
		long arg0) {
		return _researchObject_UserLocalService.getResearchObjectIdList(arg0);
	}

	@Override
	public java.lang.Boolean checkResearchObjectIdAndVersion(
		long researchObjectId, int researchObjectVersion) {
		return _researchObject_UserLocalService.checkResearchObjectIdAndVersion(researchObjectId,
			researchObjectVersion);
	}

	@Override
	public java.lang.Boolean updateResearchObjectUser(long researchObjectId,
		long userId, java.lang.String userType) {
		return _researchObject_UserLocalService.updateResearchObjectUser(researchObjectId,
			userId, userType);
	}

	@Override
	public java.lang.Boolean updateResearchObjectUser(long researchObjectId,
		int researchObjectVersion, long userId, java.lang.String userType) {
		return _researchObject_UserLocalService.updateResearchObjectUser(researchObjectId,
			researchObjectVersion, userId, userType);
	}

	@Override
	public java.lang.Boolean updateResearchObjectUser(long researchObjectId,
		int researchObjectVersion, long userId, java.util.Date startDate,
		java.util.Date endDate, java.lang.String userType) {
		return _researchObject_UserLocalService.updateResearchObjectUser(researchObjectId,
			researchObjectVersion, userId, startDate, endDate, userType);
	}

	@Override
	public java.lang.Boolean updateResearchObjectVersion(long userId,
		long researchObjectId, int oldResearchObjectVersion,
		int newResearchObjectVersion) {
		return _researchObject_UserLocalService.updateResearchObjectVersion(userId,
			researchObjectId, oldResearchObjectVersion, newResearchObjectVersion);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ResearchObject_UserLocalService getWrappedResearchObject_UserLocalService() {
		return _researchObject_UserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedResearchObject_UserLocalService(
		ResearchObject_UserLocalService researchObject_UserLocalService) {
		_researchObject_UserLocalService = researchObject_UserLocalService;
	}

	@Override
	public ResearchObject_UserLocalService getWrappedService() {
		return _researchObject_UserLocalService;
	}

	@Override
	public void setWrappedService(
		ResearchObject_UserLocalService researchObject_UserLocalService) {
		_researchObject_UserLocalService = researchObject_UserLocalService;
	}

	private ResearchObject_UserLocalService _researchObject_UserLocalService;
}