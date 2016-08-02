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

import org.gfbio.model.User_SSO;

import java.util.List;

/**
 * The persistence utility for the user_ s s o service. This utility wraps {@link User_SSOPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see User_SSOPersistence
 * @see User_SSOPersistenceImpl
 * @generated
 */
public class User_SSOUtil {
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
	public static void clearCache(User_SSO user_SSO) {
		getPersistence().clearCache(user_SSO);
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
	public static List<User_SSO> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<User_SSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<User_SSO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static User_SSO update(User_SSO user_SSO) throws SystemException {
		return getPersistence().update(user_SSO);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static User_SSO update(User_SSO user_SSO,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(user_SSO, serviceContext);
	}

	/**
	* Returns the user_ s s o where token = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	*
	* @param token the token
	* @return the matching user_ s s o
	* @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO findByUserID(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().findByUserID(token);
	}

	/**
	* Returns the user_ s s o where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param token the token
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByUserID(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(token);
	}

	/**
	* Returns the user_ s s o where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param token the token
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByUserID(
		java.lang.String token, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserID(token, retrieveFromCache);
	}

	/**
	* Removes the user_ s s o where token = &#63; from the database.
	*
	* @param token the token
	* @return the user_ s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO removeByUserID(
		java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().removeByUserID(token);
	}

	/**
	* Returns the number of user_ s s os where token = &#63;.
	*
	* @param token the token
	* @return the number of matching user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserID(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserID(token);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	*
	* @param userID the user i d
	* @return the matching user_ s s o
	* @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO findByToken(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().findByToken(userID);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userID the user i d
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByToken(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(userID);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByToken(long userID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByToken(userID, retrieveFromCache);
	}

	/**
	* Removes the user_ s s o where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @return the user_ s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO removeByToken(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().removeByToken(userID);
	}

	/**
	* Returns the number of user_ s s os where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByToken(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByToken(userID);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	*
	* @param userID the user i d
	* @return the matching user_ s s o
	* @throws org.gfbio.NoSuchUser_SSOException if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO findByLastModifiedDate(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().findByLastModifiedDate(userID);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userID the user i d
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByLastModifiedDate(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLastModifiedDate(userID);
	}

	/**
	* Returns the user_ s s o where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user_ s s o, or <code>null</code> if a matching user_ s s o could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByLastModifiedDate(
		long userID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLastModifiedDate(userID, retrieveFromCache);
	}

	/**
	* Removes the user_ s s o where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @return the user_ s s o that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO removeByLastModifiedDate(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().removeByLastModifiedDate(userID);
	}

	/**
	* Returns the number of user_ s s os where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLastModifiedDate(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLastModifiedDate(userID);
	}

	/**
	* Caches the user_ s s o in the entity cache if it is enabled.
	*
	* @param user_SSO the user_ s s o
	*/
	public static void cacheResult(org.gfbio.model.User_SSO user_SSO) {
		getPersistence().cacheResult(user_SSO);
	}

	/**
	* Caches the user_ s s os in the entity cache if it is enabled.
	*
	* @param user_SSOs the user_ s s os
	*/
	public static void cacheResult(
		java.util.List<org.gfbio.model.User_SSO> user_SSOs) {
		getPersistence().cacheResult(user_SSOs);
	}

	/**
	* Creates a new user_ s s o with the primary key. Does not add the user_ s s o to the database.
	*
	* @param userID the primary key for the new user_ s s o
	* @return the new user_ s s o
	*/
	public static org.gfbio.model.User_SSO create(long userID) {
		return getPersistence().create(userID);
	}

	/**
	* Removes the user_ s s o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user_ s s o
	* @return the user_ s s o that was removed
	* @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO remove(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().remove(userID);
	}

	public static org.gfbio.model.User_SSO updateImpl(
		org.gfbio.model.User_SSO user_SSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(user_SSO);
	}

	/**
	* Returns the user_ s s o with the primary key or throws a {@link org.gfbio.NoSuchUser_SSOException} if it could not be found.
	*
	* @param userID the primary key of the user_ s s o
	* @return the user_ s s o
	* @throws org.gfbio.NoSuchUser_SSOException if a user_ s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO findByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUser_SSOException {
		return getPersistence().findByPrimaryKey(userID);
	}

	/**
	* Returns the user_ s s o with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userID the primary key of the user_ s s o
	* @return the user_ s s o, or <code>null</code> if a user_ s s o with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gfbio.model.User_SSO fetchByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userID);
	}

	/**
	* Returns all the user_ s s os.
	*
	* @return the user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.User_SSO> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gfbio.model.User_SSO> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user_ s s os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.User_SSOModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_ s s os
	* @param end the upper bound of the range of user_ s s os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gfbio.model.User_SSO> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user_ s s os from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user_ s s os.
	*
	* @return the number of user_ s s os
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static User_SSOPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (User_SSOPersistence)PortletBeanLocatorUtil.locate(org.gfbio.service.ClpSerializer.getServletContextName(),
					User_SSOPersistence.class.getName());

			ReferenceRegistry.registerReference(User_SSOUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(User_SSOPersistence persistence) {
	}

	private static User_SSOPersistence _persistence;
}