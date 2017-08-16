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
 * Provides a wrapper for {@link UserExtensionLocalService}.
 *
 * @author Marcel Froemming
 * @see UserExtensionLocalService
 * @generated
 */
public class UserExtensionLocalServiceWrapper
	implements UserExtensionLocalService,
		ServiceWrapper<UserExtensionLocalService> {
	public UserExtensionLocalServiceWrapper(
		UserExtensionLocalService userExtensionLocalService) {
		_userExtensionLocalService = userExtensionLocalService;
	}

	/**
	* Adds the user extension to the database. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.UserExtension addUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.addUserExtension(userExtension);
	}

	/**
	* Creates a new user extension with the primary key. Does not add the user extension to the database.
	*
	* @param userID the primary key for the new user extension
	* @return the new user extension
	*/
	@Override
	public org.gfbio.model.UserExtension createUserExtension(long userID) {
		return _userExtensionLocalService.createUserExtension(userID);
	}

	/**
	* Deletes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user extension
	* @return the user extension that was removed
	* @throws PortalException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.UserExtension deleteUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.deleteUserExtension(userID);
	}

	/**
	* Deletes the user extension from the database. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.UserExtension deleteUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.deleteUserExtension(userExtension);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userExtensionLocalService.dynamicQuery();
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
		return _userExtensionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userExtensionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userExtensionLocalService.dynamicQuery(dynamicQuery, start,
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
		return _userExtensionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userExtensionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.gfbio.model.UserExtension fetchUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.fetchUserExtension(userID);
	}

	/**
	* Returns the user extension with the primary key.
	*
	* @param userID the primary key of the user extension
	* @return the user extension
	* @throws PortalException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.UserExtension getUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.getUserExtension(userID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user extensions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user extensions
	* @param end the upper bound of the range of user extensions (not inclusive)
	* @return the range of user extensions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.gfbio.model.UserExtension> getUserExtensions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.getUserExtensions(start, end);
	}

	/**
	* Returns the number of user extensions.
	*
	* @return the number of user extensions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserExtensionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.getUserExtensionsCount();
	}

	/**
	* Updates the user extension in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.gfbio.model.UserExtension updateUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.updateUserExtension(userExtension);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userExtensionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userExtensionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userExtensionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.json.simple.JSONObject getUserExtentionById(
		org.json.simple.JSONObject requestJson) {
		return _userExtensionLocalService.getUserExtentionById(requestJson);
	}

	@Override
	public org.json.simple.JSONObject getUserExtentionByEmailAddress(
		org.json.simple.JSONObject requestJson) {
		return _userExtensionLocalService.getUserExtentionByEmailAddress(requestJson);
	}

	@Override
	public java.lang.Boolean checkExistenceOfUserId(long userId) {
		return _userExtensionLocalService.checkExistenceOfUserId(userId);
	}

	@Override
	public java.lang.Boolean checkExistenceOfUserMail(
		java.lang.String eMailAddress) {
		return _userExtensionLocalService.checkExistenceOfUserMail(eMailAddress);
	}

	@Override
	public java.lang.String checkForIgnoredParameter(
		java.lang.Object[] objects, java.util.Set<java.lang.String> keyList) {
		return _userExtensionLocalService.checkForIgnoredParameter(objects,
			keyList);
	}

	@Override
	public org.json.simple.JSONObject constructUserExtentionJsonById(
		com.liferay.portal.model.User user)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userExtensionLocalService.constructUserExtentionJsonById(user);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserExtensionLocalService getWrappedUserExtensionLocalService() {
		return _userExtensionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserExtensionLocalService(
		UserExtensionLocalService userExtensionLocalService) {
		_userExtensionLocalService = userExtensionLocalService;
	}

	@Override
	public UserExtensionLocalService getWrappedService() {
		return _userExtensionLocalService;
	}

	@Override
	public void setWrappedService(
		UserExtensionLocalService userExtensionLocalService) {
		_userExtensionLocalService = userExtensionLocalService;
	}

	private UserExtensionLocalService _userExtensionLocalService;
}