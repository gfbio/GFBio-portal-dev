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
 * Provides the local service utility for UserExtension. This utility wraps
 * {@link org.gfbio.service.impl.UserExtensionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Felicitas Loeffler
 * @see UserExtensionLocalService
 * @see org.gfbio.service.base.UserExtensionLocalServiceBaseImpl
 * @see org.gfbio.service.impl.UserExtensionLocalServiceImpl
 * @generated
 */
public class UserExtensionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.gfbio.service.impl.UserExtensionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user extension to the database. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension addUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserExtension(userExtension);
	}

	/**
	* Creates a new user extension with the primary key. Does not add the user extension to the database.
	*
	* @param userID the primary key for the new user extension
	* @return the new user extension
	*/
	public static org.gfbio.model.UserExtension createUserExtension(long userID) {
		return getService().createUserExtension(userID);
	}

	/**
	* Deletes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user extension
	* @return the user extension that was removed
	* @throws PortalException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension deleteUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserExtension(userID);
	}

	/**
	* Deletes the user extension from the database. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension deleteUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserExtension(userExtension);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.gfbio.model.UserExtension fetchUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserExtension(userID);
	}

	/**
	* Returns the user extension with the primary key.
	*
	* @param userID the primary key of the user extension
	* @return the user extension
	* @throws PortalException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension getUserExtension(long userID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserExtension(userID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.gfbio.model.UserExtension> getUserExtensions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserExtensions(start, end);
	}

	/**
	* Returns the number of user extensions.
	*
	* @return the number of user extensions
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserExtensionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserExtensionsCount();
	}

	/**
	* Updates the user extension in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userExtension the user extension
	* @return the user extension that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension updateUserExtension(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserExtension(userExtension);
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

	public static org.gfbio.model.UserExtension getUserExtensionById(
		long userExtensionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException {
		return getService().getUserExtensionById(userExtensionId);
	}

	public static com.liferay.portal.model.User getUserById(long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserById(userId);
	}

	public static org.json.simple.JSONObject getUserAsJsonById(long userId)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserAsJsonById(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserExtensionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserExtensionLocalService.class.getName());

			if (invokableLocalService instanceof UserExtensionLocalService) {
				_service = (UserExtensionLocalService)invokableLocalService;
			}
			else {
				_service = new UserExtensionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserExtensionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserExtensionLocalService service) {
	}

	private static UserExtensionLocalService _service;
}