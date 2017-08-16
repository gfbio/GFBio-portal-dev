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

package org.gfbio.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.gfbio.model.UserSSO;

import java.util.List;

/**
 * The persistence utility for the user s s o service. This utility wraps {@link UserSSOPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see UserSSOPersistence
 * @see UserSSOPersistenceImpl
 * @generated
 */
public class UserSSOUtil {
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
	public static void clearCache(UserSSO userSSO) {
		getPersistence().clearCache(userSSO);
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
	public static List<UserSSO> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserSSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserSSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserSSO update(UserSSO userSSO) throws SystemException {
		return getPersistence().update(userSSO);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserSSO update(UserSSO userSSO, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(userSSO, serviceContext);
	}

	/**
	* Returns the user s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	*
	* @param userID the user i d
	* @return the matching user s s o
	* @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO findByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().findByUserID(userID);
	}

	/**
	* Returns the user s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userID the user i d
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(userID);
	}

	/**
	* Returns the user s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByUserID(long userID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(userID, retrieveFromCache);
	}

	/**
	* Removes the user s s o where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @return the user s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().removeByUserID(userID);
	}

	/**
	* Returns the number of user s s os where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(userID);
	}

	/**
	* Returns the user s s o where token = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	*
	* @param token the token
	* @return the matching user s s o
	* @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO findByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().findByToken(token);
	}

	/**
	* Returns the user s s o where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param token the token
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(token);
	}

	/**
	* Returns the user s s o where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param token the token
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByToken(java.lang.String token,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(token, retrieveFromCache);
	}

	/**
	* Removes the user s s o where token = &#63; from the database.
	*
	* @param token the token
	* @return the user s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO removeByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().removeByToken(token);
	}

	/**
	* Returns the number of user s s os where token = &#63;.
	*
	* @param token the token
	* @return the number of matching user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByToken(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByToken(token);
	}

	/**
	* Returns the user s s o where lastModifiedDate = &#63; or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	*
	* @param lastModifiedDate the last modified date
	* @return the matching user s s o
	* @throws org.gfbio.NoSuchUserSSOException if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO findByLastModifiedDate(
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().findByLastModifiedDate(lastModifiedDate);
	}

	/**
	* Returns the user s s o where lastModifiedDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lastModifiedDate the last modified date
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByLastModifiedDate(
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLastModifiedDate(lastModifiedDate);
	}

	/**
	* Returns the user s s o where lastModifiedDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lastModifiedDate the last modified date
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user s s o, or <code>null</code> if a matching user s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByLastModifiedDate(
		java.util.Date lastModifiedDate, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLastModifiedDate(lastModifiedDate, retrieveFromCache);
	}

	/**
	* Removes the user s s o where lastModifiedDate = &#63; from the database.
	*
	* @param lastModifiedDate the last modified date
	* @return the user s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO removeByLastModifiedDate(
		java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().removeByLastModifiedDate(lastModifiedDate);
	}

	/**
	* Returns the number of user s s os where lastModifiedDate = &#63;.
	*
	* @param lastModifiedDate the last modified date
	* @return the number of matching user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLastModifiedDate(java.util.Date lastModifiedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLastModifiedDate(lastModifiedDate);
	}

	/**
	* Caches the user s s o in the entity cache if it is enabled.
	*
	* @param userSSO the user s s o
	*/
	public static void cacheResult(org.gfbio.model.UserSSO userSSO) {
		getPersistence().cacheResult(userSSO);
	}

	/**
	* Caches the user s s os in the entity cache if it is enabled.
	*
	* @param userSSOs the user s s os
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.UserSSO> userSSOs) {
		getPersistence().cacheResult(userSSOs);
	}

	/**
	* Creates a new user s s o with the primary key. Does not add the user s s o to the database.
	*
	* @param userID the primary key for the new user s s o
	* @return the new user s s o
	*/
	public static org.gfbio.model.UserSSO create(long userID) {
		return getPersistence().create(userID);
	}

	/**
	* Removes the user s s o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user s s o
	* @return the user s s o that was removed
	* @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO remove(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().remove(userID);
	}

	public static org.gfbio.model.UserSSO updateImpl(
		org.gfbio.model.UserSSO userSSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userSSO);
	}

	/**
	* Returns the user s s o with the primary key or throws a {@link org.gfbio.NoSuchUserSSOException} if it could not be found.
	*
	* @param userID the primary key of the user s s o
	* @return the user s s o
	* @throws org.gfbio.NoSuchUserSSOException if a user s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO findByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserSSOException {
		return getPersistence().findByPrimaryKey(userID);
	}

	/**
	* Returns the user s s o with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userID the primary key of the user s s o
	* @return the user s s o, or <code>null</code> if a user s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.UserSSO fetchByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userID);
	}

	/**
	* Returns all the user s s os.
	*
	* @return the user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserSSO> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user s s os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user s s os
	* @param end the upper bound of the range of user s s os (not inclusive)
	* @return the range of user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserSSO> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user s s os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.UserSSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user s s os
	* @param end the upper bound of the range of user s s os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.UserSSO> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user s s os from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user s s os.
	*
	* @return the number of user s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserSSOPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserSSOPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					UserSSOPersistence.class.getName());

			ReferenceRegistry.registerReference(UserSSOUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserSSOPersistence persistence) {
	}

	private static UserSSOPersistence _persistence;
}