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
 * Provides a wrapper for {@link Project_UserLocalService}.
 *
 * @author Marcel Froemming
 * @see Project_UserLocalService
 * @generated
 */
public class Project_UserLocalServiceWrapper implements Project_UserLocalService,
	ServiceWrapper<Project_UserLocalService> {
	public Project_UserLocalServiceWrapper(
		Project_UserLocalService project_UserLocalService) {
		_project_UserLocalService = project_UserLocalService;
	}

	/**
	* Adds the project_ user to the database. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project_User addProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.addProject_User(project_User);
	}

	/**
	* Creates a new project_ user with the primary key. Does not add the project_ user to the database.
	*
	* @param project_UserPK the primary key for the new project_ user
	* @return the new project_ user
	*/
	@Override
	public org.gfbio.model.Project_User createProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK) {
		return _project_UserLocalService.createProject_User(project_UserPK);
	}

	/**
	* Deletes the project_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user that was removed
	* @throws PortalException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project_User deleteProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.deleteProject_User(project_UserPK);
	}

	/**
	* Deletes the project_ user from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project_User deleteProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.deleteProject_User(project_User);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _project_UserLocalService.dynamicQuery();
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
		return _project_UserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _project_UserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _project_UserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _project_UserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _project_UserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.Project_User fetchProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.fetchProject_User(project_UserPK);
	}

	/**
	* Returns the project_ user with the primary key.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user
	* @throws PortalException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project_User getProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.getProject_User(project_UserPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the project_ users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project_ users
	* @param end the upper bound of the range of project_ users (not inclusive)
	* @return the range of project_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.Project_User> getProject_Users(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.getProject_Users(start, end);
	}

	/**
	* Returns the number of project_ users.
	*
	* @return the number of project_ users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProject_UsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.getProject_UsersCount();
	}

	/**
	* Updates the project_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.Project_User updateProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project_UserLocalService.updateProject_User(project_User);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _project_UserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_project_UserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _project_UserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONArray getProjectIdsByUserId(
		org.json.simple.JSONObject requestJson) {
		return _project_UserLocalService.getProjectIdsByUserId(requestJson);
	}

	@Override
	public java.lang.String getFullNamesAsString(
		org.json.simple.JSONArray requestJson) {
		return _project_UserLocalService.getFullNamesAsString(requestJson);
	}

	@Override
	public org.json.simple.JSONArray getOwnerAndPiByProjectId(long projectId) {
		return _project_UserLocalService.getOwnerAndPiByProjectId(projectId);
	}

	@Override
	public java.util.List<java.lang.Long> getOwnerAndPiIdByProjectId(
		long projectId) {
		return _project_UserLocalService.getOwnerAndPiIdByProjectId(projectId);
	}

	@Override
	public java.util.List<org.gfbio.model.Project_User> getProjectIdList(
		long userID) {
		return _project_UserLocalService.getProjectIdList(userID);
	}

	@Override
	public java.lang.Boolean updateProjectUser(long projectId, long userId,
		java.lang.String userType) {
		return _project_UserLocalService.updateProjectUser(projectId, userId,
			userType);
	}

	@Override
	public java.lang.Boolean updateProjectUser(long projectID, long userID,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String userType) {
		return _project_UserLocalService.updateProjectUser(projectID, userID,
			startDate, endDate, userType);
	}

	@Override
	public java.util.List<org.gfbio.model.Project_User> getProjectIDList(
		long userID) {
		return _project_UserLocalService.getProjectIDList(userID);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Project_UserLocalService getWrappedProject_UserLocalService() {
		return _project_UserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProject_UserLocalService(
		Project_UserLocalService project_UserLocalService) {
		_project_UserLocalService = project_UserLocalService;
	}

	@Override
	public Project_UserLocalService getWrappedService() {
		return _project_UserLocalService;
	}

	@Override
	public void setWrappedService(
		Project_UserLocalService project_UserLocalService) {
		_project_UserLocalService = project_UserLocalService;
	}

	private Project_UserLocalService _project_UserLocalService;
}