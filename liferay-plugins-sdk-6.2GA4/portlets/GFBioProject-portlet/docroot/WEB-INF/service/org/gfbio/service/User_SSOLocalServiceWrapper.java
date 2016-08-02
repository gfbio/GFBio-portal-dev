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
 * Provides a wrapper for {@link User_SSOLocalService}.
 *
 * @author Marcel Froemming
 * @see User_SSOLocalService
 * @generated
 */
public class User_SSOLocalServiceWrapper implements User_SSOLocalService,
	ServiceWrapper<User_SSOLocalService> {
	public User_SSOLocalServiceWrapper(
		User_SSOLocalService user_SSOLocalService) {
		_user_SSOLocalService = user_SSOLocalService;
	}

	/**
	* Adds the user_ s s o to the database. Also notifies the appropriate model listeners.
	*
	* @param user_SSO the user_ s s o
	* @return the user_ s s o that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.User_SSO addUser_SSO(
		org.gfbio.model.User_SSO user_SSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.addUser_SSO(user_SSO);
	}

	/**
	* Creates a new user_ s s o with the primary key. Does not add the user_ s s o to the database.
	*
	* @param userID the primary key for the new user_ s s o
	* @return the new user_ s s o
	*/
	@Override
	public org.gfbio.model.User_SSO createUser_SSO(long userID) {
		return _user_SSOLocalService.createUser_SSO(userID);
	}

	/**
	* Deletes the user_ s s o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user_ s s o
	* @return the user_ s s o that was removed
	* @throws PortalException if a user_ s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.User_SSO deleteUser_SSO(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.deleteUser_SSO(userID);
	}

	/**
	* Deletes the user_ s s o from the database. Also notifies the appropriate model listeners.
	*
	* @param user_SSO the user_ s s o
	* @return the user_ s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.User_SSO deleteUser_SSO(
		org.gfbio.model.User_SSO user_SSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.deleteUser_SSO(user_SSO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _user_SSOLocalService.dynamicQuery();
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
		return _user_SSOLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _user_SSOLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _user_SSOLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _user_SSOLocalService.dynamicQueryCount(dynamicQuery);
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
		return _user_SSOLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.gfbio.model.User_SSO fetchUser_SSO(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.fetchUser_SSO(userID);
	}

	/**
	* Returns the user_ s s o with the primary key.
	*
	* @param userID the primary key of the user_ s s o
	* @return the user_ s s o
	* @throws PortalException if a user_ s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.User_SSO getUser_SSO(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.getUser_SSO(userID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user_ s s os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_ s s os
	* @param end the upper bound of the range of user_ s s os (not inclusive)
	* @return the range of user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.User_SSO> getUser_SSOs(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.getUser_SSOs(start, end);
	}

	/**
	* Returns the number of user_ s s os.
	*
	* @return the number of user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUser_SSOsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.getUser_SSOsCount();
	}

	/**
	* Updates the user_ s s o in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param user_SSO the user_ s s o
	* @return the user_ s s o that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.User_SSO updateUser_SSO(
		org.gfbio.model.User_SSO user_SSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _user_SSOLocalService.updateUser_SSO(user_SSO);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _user_SSOLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_user_SSOLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _user_SSOLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public User_SSOLocalService getWrappedUser_SSOLocalService() {
		return _user_SSOLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUser_SSOLocalService(
		User_SSOLocalService user_SSOLocalService) {
		_user_SSOLocalService = user_SSOLocalService;
	}

	@Override
	public User_SSOLocalService getWrappedService() {
		return _user_SSOLocalService;
	}

	@Override
	public void setWrappedService(User_SSOLocalService user_SSOLocalService) {
		_user_SSOLocalService = user_SSOLocalService;
	}

	private User_SSOLocalService _user_SSOLocalService;
}