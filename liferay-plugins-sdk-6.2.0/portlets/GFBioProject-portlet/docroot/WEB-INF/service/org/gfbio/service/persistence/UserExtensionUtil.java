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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.UserExtension;

import java.util.List;

/**
 * The persistence utility for the user extension service. This utility wraps {@link UserExtensionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see UserExtensionPersistence
 * @see UserExtensionPersistenceImpl
 * @generated
 */
public class UserExtensionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserExtension userExtension) {
		getPersistence().clearCache(userExtension);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserExtension> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserExtension> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserExtension> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserExtension update(UserExtension userExtension)
		throws SystemException {
		return getPersistence().update(userExtension);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserExtension update(UserExtension userExtension,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userExtension, serviceContext);
	}

	/**
	* Returns the user extension where userID = &#63; or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	*
	* @param userID the user i d
	* @return the matching user extension
	* @throws org.gfbio.NoSuchUserExtensionException if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension findByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userID the user i d
	* @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension fetchByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(userID);
	}

	/**
	* Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension fetchByUserID(long userID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(userID, retrieveFromCache);
	}

	/**
	* Removes the user extension where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @return the user extension that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException {
		return getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of user extensions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching user extensions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Caches the user extension in the entity cache if it is enabled.
	*
	* @param userExtension the user extension
	*/
	public static void cacheResult(org.gfbio.model.UserExtension userExtension) {
		getPersistence().cacheResult(userExtension);
	}

	/**
	* Caches the user extensions in the entity cache if it is enabled.
	*
	* @param userExtensions the user extensions
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.UserExtension> userExtensions) {
		getPersistence().cacheResult(userExtensions);
	}

	/**
	* Creates a new user extension with the primary key. Does not add the user extension to the database.
	*
	* @param userID the primary key for the new user extension
	* @return the new user extension
	*/
	public static org.gfbio.model.UserExtension create(long userID) {
		return getPersistence().create(userID);
	}

	/**
	* Removes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user extension
	* @return the user extension that was removed
	* @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension remove(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException {
		return getPersistence().remove(userID);
	}

	public static org.gfbio.model.UserExtension updateImpl(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userExtension);
	}

	/**
	* Returns the user extension with the primary key or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	*
	* @param userID the primary key of the user extension
	* @return the user extension
	* @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension findByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException {
		return getPersistence().findByPrimaryKey(userID);
	}

	/**
	* Returns the user extension with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userID the primary key of the user extension
	* @return the user extension, or <code>null</code> if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserExtension fetchByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userID);
	}

	/**
	* Returns all the user extensions.
	*
	* @return the user extensions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserExtension> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gfbio.model.UserExtension> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user extensions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserExtensionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user extensions
	* @param end the upper bound of the range of user extensions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user extensions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserExtension> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user extensions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user extensions.
	*
	* @return the number of user extensions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserExtensionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserExtensionPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					UserExtensionPersistence.class.getName());

			ReferenceRegistry.registerReference(UserExtensionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserExtensionPersistence persistence) {
	}

	private static UserExtensionPersistence _persistence;
}