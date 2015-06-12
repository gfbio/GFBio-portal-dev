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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.UserExtension;

/**
 * The persistence interface for the user extension service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see UserExtensionPersistenceImpl
 * @see UserExtensionUtil
 * @generated
 */
public interface UserExtensionPersistence extends BasePersistence<UserExtension> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserExtensionUtil} to access the user extension persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user extension where userID = &#63; or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	*
	* @param userID the user i d
	* @return the matching user extension
	* @throws org.gfbio.NoSuchUserExtensionException if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension findByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException;

	/**
	* Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userID the user i d
	* @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension fetchByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user extension where userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userID the user i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user extension, or <code>null</code> if a matching user extension could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension fetchByUserID(long userID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user extension where userID = &#63; from the database.
	*
	* @param userID the user i d
	* @return the user extension that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension removeByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException;

	/**
	* Returns the number of user extensions where userID = &#63;.
	*
	* @param userID the user i d
	* @return the number of matching user extensions
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserID(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user extension in the entity cache if it is enabled.
	*
	* @param userExtension the user extension
	*/
	public void cacheResult(org.gfbio.model.UserExtension userExtension);

	/**
	* Caches the user extensions in the entity cache if it is enabled.
	*
	* @param userExtensions the user extensions
	*/
	public void cacheResult(
		java.util.List<org.gfbio.model.UserExtension> userExtensions);

	/**
	* Creates a new user extension with the primary key. Does not add the user extension to the database.
	*
	* @param userID the primary key for the new user extension
	* @return the new user extension
	*/
	public org.gfbio.model.UserExtension create(long userID);

	/**
	* Removes the user extension with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the user extension
	* @return the user extension that was removed
	* @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension remove(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException;

	public org.gfbio.model.UserExtension updateImpl(
		org.gfbio.model.UserExtension userExtension)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user extension with the primary key or throws a {@link org.gfbio.NoSuchUserExtensionException} if it could not be found.
	*
	* @param userID the primary key of the user extension
	* @return the user extension
	* @throws org.gfbio.NoSuchUserExtensionException if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension findByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchUserExtensionException;

	/**
	* Returns the user extension with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userID the primary key of the user extension
	* @return the user extension, or <code>null</code> if a user extension with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.UserExtension fetchByPrimaryKey(long userID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user extensions.
	*
	* @return the user extensions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.UserExtension> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.UserExtension> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gfbio.model.UserExtension> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user extensions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user extensions.
	*
	* @return the number of user extensions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}