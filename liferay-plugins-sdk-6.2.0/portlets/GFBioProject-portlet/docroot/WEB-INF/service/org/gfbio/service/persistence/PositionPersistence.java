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

import org.gfbio.model.Position;

/**
 * The persistence interface for the position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Felicitas Loeffler
 * @see PositionPersistenceImpl
 * @see PositionUtil
 * @generated
 */
public interface PositionPersistence extends BasePersistence<Position> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PositionUtil} to access the position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the position where positionID = &#63; or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the position i d
	* @return the matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param positionID the position i d
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the position where positionID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param positionID the position i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPositionID(long positionID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the position where positionID = &#63; from the database.
	*
	* @param positionID the position i d
	* @return the position that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position removeByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the number of positions where positionID = &#63;.
	*
	* @param positionID the position i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByPositionID(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByHeadID(long headID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByHeadID_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByHeadID_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByHeadID_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByHeadID_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where headID = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByHeadID_PrevAndNext(
		long positionID, long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadID(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn01(
		java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column01 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column01 the column01
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn01(
		java.lang.String column01, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column01 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column01 the column01
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn01(
		java.lang.String column01, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn01_First(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn01_Last(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column01 = &#63;.
	*
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn01_Last(
		java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column01 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column01 the column01
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn01_PrevAndNext(
		long positionID, java.lang.String column01,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column01 = &#63; from the database.
	*
	* @param column01 the column01
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column01 = &#63;.
	*
	* @param column01 the column01
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn01(java.lang.String column01)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn02(
		java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column02 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column02 the column02
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn02(
		java.lang.String column02, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column02 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column02 the column02
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn02(
		java.lang.String column02, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn02_First(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn02_Last(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column02 = &#63;.
	*
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn02_Last(
		java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column02 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column02 the column02
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn02_PrevAndNext(
		long positionID, java.lang.String column02,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column02 = &#63; from the database.
	*
	* @param column02 the column02
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column02 = &#63;.
	*
	* @param column02 the column02
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn02(java.lang.String column02)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn03(
		java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column03 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column03 the column03
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn03(
		java.lang.String column03, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column03 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column03 the column03
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn03(
		java.lang.String column03, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn03_First(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn03_Last(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column03 = &#63;.
	*
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn03_Last(
		java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column03 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column03 the column03
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn03_PrevAndNext(
		long positionID, java.lang.String column03,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column03 = &#63; from the database.
	*
	* @param column03 the column03
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column03 = &#63;.
	*
	* @param column03 the column03
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn03(java.lang.String column03)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn04(
		java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column04 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column04 the column04
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn04(
		java.lang.String column04, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column04 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column04 the column04
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn04(
		java.lang.String column04, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn04_First(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn04_Last(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column04 = &#63;.
	*
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn04_Last(
		java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column04 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column04 the column04
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn04_PrevAndNext(
		long positionID, java.lang.String column04,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column04 = &#63; from the database.
	*
	* @param column04 the column04
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column04 = &#63;.
	*
	* @param column04 the column04
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn04(java.lang.String column04)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn05(
		java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column05 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column05 the column05
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn05(
		java.lang.String column05, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column05 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column05 the column05
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn05(
		java.lang.String column05, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn05_First(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn05_Last(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column05 = &#63;.
	*
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn05_Last(
		java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column05 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column05 the column05
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn05_PrevAndNext(
		long positionID, java.lang.String column05,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column05 = &#63; from the database.
	*
	* @param column05 the column05
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column05 = &#63;.
	*
	* @param column05 the column05
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn05(java.lang.String column05)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn06(
		java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column06 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column06 the column06
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn06(
		java.lang.String column06, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column06 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column06 the column06
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn06(
		java.lang.String column06, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn06_First(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn06_Last(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column06 = &#63;.
	*
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn06_Last(
		java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column06 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column06 the column06
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn06_PrevAndNext(
		long positionID, java.lang.String column06,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column06 = &#63; from the database.
	*
	* @param column06 the column06
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column06 = &#63;.
	*
	* @param column06 the column06
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn06(java.lang.String column06)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn07(
		java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column07 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column07 the column07
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn07(
		java.lang.String column07, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column07 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column07 the column07
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn07(
		java.lang.String column07, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn07_First(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn07_Last(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column07 = &#63;.
	*
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn07_Last(
		java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column07 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column07 the column07
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn07_PrevAndNext(
		long positionID, java.lang.String column07,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column07 = &#63; from the database.
	*
	* @param column07 the column07
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column07 = &#63;.
	*
	* @param column07 the column07
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn07(java.lang.String column07)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn08(
		java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column08 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column08 the column08
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn08(
		java.lang.String column08, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column08 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column08 the column08
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn08(
		java.lang.String column08, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn08_First(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn08_Last(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column08 = &#63;.
	*
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn08_Last(
		java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column08 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column08 the column08
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn08_PrevAndNext(
		long positionID, java.lang.String column08,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column08 = &#63; from the database.
	*
	* @param column08 the column08
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column08 = &#63;.
	*
	* @param column08 the column08
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn08(java.lang.String column08)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn09(
		java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column09 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column09 the column09
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn09(
		java.lang.String column09, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column09 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column09 the column09
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn09(
		java.lang.String column09, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn09_First(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn09_Last(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column09 = &#63;.
	*
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn09_Last(
		java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column09 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column09 the column09
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn09_PrevAndNext(
		long positionID, java.lang.String column09,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column09 = &#63; from the database.
	*
	* @param column09 the column09
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column09 = &#63;.
	*
	* @param column09 the column09
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn09(java.lang.String column09)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn10(
		java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column10 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column10 the column10
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn10(
		java.lang.String column10, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column10 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column10 the column10
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn10(
		java.lang.String column10, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn10_First(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn10_Last(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column10 = &#63;.
	*
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn10_Last(
		java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column10 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column10 the column10
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn10_PrevAndNext(
		long positionID, java.lang.String column10,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column10 = &#63; from the database.
	*
	* @param column10 the column10
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column10 = &#63;.
	*
	* @param column10 the column10
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn10(java.lang.String column10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn11(
		java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column11 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column11 the column11
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn11(
		java.lang.String column11, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column11 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column11 the column11
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn11(
		java.lang.String column11, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn11_First(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn11_Last(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column11 = &#63;.
	*
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn11_Last(
		java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column11 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column11 the column11
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn11_PrevAndNext(
		long positionID, java.lang.String column11,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column11 = &#63; from the database.
	*
	* @param column11 the column11
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column11 = &#63;.
	*
	* @param column11 the column11
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn11(java.lang.String column11)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn12(
		java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column12 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column12 the column12
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn12(
		java.lang.String column12, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column12 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column12 the column12
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn12(
		java.lang.String column12, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn12_First(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn12_Last(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column12 = &#63;.
	*
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn12_Last(
		java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column12 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column12 the column12
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn12_PrevAndNext(
		long positionID, java.lang.String column12,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column12 = &#63; from the database.
	*
	* @param column12 the column12
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column12 = &#63;.
	*
	* @param column12 the column12
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn12(java.lang.String column12)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn13(
		java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column13 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column13 the column13
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn13(
		java.lang.String column13, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column13 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column13 the column13
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn13(
		java.lang.String column13, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn13_First(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn13_Last(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column13 = &#63;.
	*
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn13_Last(
		java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column13 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column13 the column13
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn13_PrevAndNext(
		long positionID, java.lang.String column13,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column13 = &#63; from the database.
	*
	* @param column13 the column13
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column13 = &#63;.
	*
	* @param column13 the column13
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn13(java.lang.String column13)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn14(
		java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column14 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column14 the column14
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn14(
		java.lang.String column14, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column14 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column14 the column14
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn14(
		java.lang.String column14, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn14_First(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn14_Last(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column14 = &#63;.
	*
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn14_Last(
		java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column14 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column14 the column14
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn14_PrevAndNext(
		long positionID, java.lang.String column14,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column14 = &#63; from the database.
	*
	* @param column14 the column14
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column14 = &#63;.
	*
	* @param column14 the column14
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn14(java.lang.String column14)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn15(
		java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column15 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column15 the column15
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn15(
		java.lang.String column15, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column15 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column15 the column15
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn15(
		java.lang.String column15, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn15_First(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn15_Last(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column15 = &#63;.
	*
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn15_Last(
		java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column15 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column15 the column15
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn15_PrevAndNext(
		long positionID, java.lang.String column15,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column15 = &#63; from the database.
	*
	* @param column15 the column15
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column15 = &#63;.
	*
	* @param column15 the column15
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn15(java.lang.String column15)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn16(
		java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column16 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column16 the column16
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn16(
		java.lang.String column16, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column16 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column16 the column16
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn16(
		java.lang.String column16, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn16_First(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn16_Last(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column16 = &#63;.
	*
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn16_Last(
		java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column16 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column16 the column16
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn16_PrevAndNext(
		long positionID, java.lang.String column16,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column16 = &#63; from the database.
	*
	* @param column16 the column16
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column16 = &#63;.
	*
	* @param column16 the column16
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn16(java.lang.String column16)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn17(
		java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column17 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column17 the column17
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn17(
		java.lang.String column17, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column17 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column17 the column17
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn17(
		java.lang.String column17, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn17_First(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn17_Last(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column17 = &#63;.
	*
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn17_Last(
		java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column17 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column17 the column17
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn17_PrevAndNext(
		long positionID, java.lang.String column17,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column17 = &#63; from the database.
	*
	* @param column17 the column17
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column17 = &#63;.
	*
	* @param column17 the column17
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn17(java.lang.String column17)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn18(
		java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column18 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column18 the column18
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn18(
		java.lang.String column18, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column18 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column18 the column18
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn18(
		java.lang.String column18, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn18_First(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn18_Last(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column18 = &#63;.
	*
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn18_Last(
		java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column18 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column18 the column18
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn18_PrevAndNext(
		long positionID, java.lang.String column18,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column18 = &#63; from the database.
	*
	* @param column18 the column18
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column18 = &#63;.
	*
	* @param column18 the column18
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn18(java.lang.String column18)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn19(
		java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column19 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column19 the column19
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn19(
		java.lang.String column19, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column19 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column19 the column19
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn19(
		java.lang.String column19, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn19_First(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn19_Last(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column19 = &#63;.
	*
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn19_Last(
		java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column19 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column19 the column19
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn19_PrevAndNext(
		long positionID, java.lang.String column19,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column19 = &#63; from the database.
	*
	* @param column19 the column19
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column19 = &#63;.
	*
	* @param column19 the column19
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn19(java.lang.String column19)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn20(
		java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions where column20 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column20 the column20
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn20(
		java.lang.String column20, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions where column20 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param column20 the column20
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findByColumn20(
		java.lang.String column20, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first position in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the first position in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn20_First(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last position in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position
	* @throws org.gfbio.NoSuchPositionException if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByColumn20_Last(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the last position in the ordered set where column20 = &#63;.
	*
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position, or <code>null</code> if a matching position could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByColumn20_Last(
		java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the positions before and after the current position in the ordered set where column20 = &#63;.
	*
	* @param positionID the primary key of the current position
	* @param column20 the column20
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position[] findByColumn20_PrevAndNext(
		long positionID, java.lang.String column20,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Removes all the positions where column20 = &#63; from the database.
	*
	* @param column20 the column20
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions where column20 = &#63;.
	*
	* @param column20 the column20
	* @return the number of matching positions
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumn20(java.lang.String column20)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the position in the entity cache if it is enabled.
	*
	* @param position the position
	*/
	public void cacheResult(org.gfbio.model.Position position);

	/**
	* Caches the positions in the entity cache if it is enabled.
	*
	* @param positions the positions
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Position> positions);

	/**
	* Creates a new position with the primary key. Does not add the position to the database.
	*
	* @param positionID the primary key for the new position
	* @return the new position
	*/
	public org.gfbio.model.Position create(long positionID);

	/**
	* Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param positionID the primary key of the position
	* @return the position that was removed
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position remove(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	public org.gfbio.model.Position updateImpl(
		org.gfbio.model.Position position)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the position with the primary key or throws a {@link org.gfbio.NoSuchPositionException} if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position
	* @throws org.gfbio.NoSuchPositionException if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position findByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchPositionException;

	/**
	* Returns the position with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param positionID the primary key of the position
	* @return the position, or <code>null</code> if a position with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Position fetchByPrimaryKey(long positionID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the positions.
	*
	* @return the positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @return the range of positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the positions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.PositionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of positions
	* @param end the upper bound of the range of positions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of positions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Position> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the positions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of positions.
	*
	* @return the number of positions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}