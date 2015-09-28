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
 * Provides the local service utility for Project_User. This utility wraps
 * {@link org.gfbio.service.impl.Project_UserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Marcel Froemming
 * @see Project_UserLocalService
 * @see org.gfbio.service.base.Project_UserLocalServiceBaseImpl
 * @see org.gfbio.service.impl.Project_UserLocalServiceImpl
 * @generated
 */
public class Project_UserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.Project_UserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project_ user to the database. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User addProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProject_User(project_User);
	}

	/**
	* Creates a new project_ user with the primary key. Does not add the project_ user to the database.
	*
	* @param project_UserPK the primary key for the new project_ user
	* @return the new project_ user
	*/
	public static org.gfbio.model.Project_User createProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK) {
		return getService().createProject_User(project_UserPK);
	}

	/**
	* Deletes the project_ user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user that was removed
	* @throws PortalException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User deleteProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject_User(project_UserPK);
	}

	/**
	* Deletes the project_ user from the database. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User deleteProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProject_User(project_User);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.Project_UserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.Project_User fetchProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProject_User(project_UserPK);
	}

	/**
	* Returns the project_ user with the primary key.
	*
	* @param project_UserPK the primary key of the project_ user
	* @return the project_ user
	* @throws PortalException if a project_ user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User getProject_User(
		org.gfbio.service.persistence.Project_UserPK project_UserPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_User(project_UserPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.Project_User> getProject_Users(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_Users(start, end);
	}

	/**
	* Returns the number of project_ users.
	*
	* @return the number of project_ users
	* @throws SystemException if a system exception occurred
	*/
	public static int getProject_UsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProject_UsersCount();
	}

	/**
	* Updates the project_ user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param project_User the project_ user
	* @return the project_ user that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.Project_User updateProject_User(
		org.gfbio.model.Project_User project_User)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProject_User(project_User);
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

	public static java.util.List<org.gfbio.model.Project_User> getProjectIDList(
		long userID) {
		return getService().getProjectIDList(userID);
	}

	public static long updateProjectUser(long projectID, long userID,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchProject_UserException {
		return getService()
				   .updateProjectUser(projectID, userID, startDate, endDate);
	}

	public static void clearService() {
		_service = null;
	}

	public static Project_UserLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					Project_UserLocalService.class.getName());

			if (invokableLocalService instanceof Project_UserLocalService) {
				_service = (Project_UserLocalService)invokableLocalService;
			}
			else {
				_service = new Project_UserLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(Project_UserLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(Project_UserLocalService service) {
	}

	private static Project_UserLocalService _service;
}