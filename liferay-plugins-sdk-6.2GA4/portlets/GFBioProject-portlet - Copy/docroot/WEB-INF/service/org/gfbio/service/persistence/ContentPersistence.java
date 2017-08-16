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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gfbio.model.Content;

/**
 * The persistence interface for the content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Marcel Froemming
 * @see ContentPersistenceImpl
 * @see ContentUtil
 * @generated
 */
public interface ContentPersistence extends BasePersistence<Content> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentUtil} to access the content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the content where contentID = &#63; or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	*
	* @param contentID the content i d
	* @return the matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByContentId(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the content where contentID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param contentID the content i d
	* @return the matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByContentId(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content where contentID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param contentID the content i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByContentId(long contentID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the content where contentID = &#63; from the database.
	*
	* @param contentID the content i d
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content removeByContentId(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the number of contents where contentID = &#63;.
	*
	* @param contentID the content i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByContentId(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content where columnID = &#63; and rowID = &#63; or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	*
	* @param columnID the column i d
	* @param rowID the row i d
	* @return the matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByTableIds(long columnID, long rowID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the content where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param columnID the column i d
	* @param rowID the row i d
	* @return the matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByTableIds(long columnID, long rowID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content where columnID = &#63; and rowID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param columnID the column i d
	* @param rowID the row i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByTableIds(long columnID, long rowID,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the content where columnID = &#63; and rowID = &#63; from the database.
	*
	* @param columnID the column i d
	* @param rowID the row i d
	* @return the content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content removeByTableIds(long columnID, long rowID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the number of contents where columnID = &#63; and rowID = &#63;.
	*
	* @param columnID the column i d
	* @param rowID the row i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByTableIds(long columnID, long rowID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents where headID = &#63;.
	*
	* @param headID the head i d
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByHeadId(long headID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where headID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param headID the head i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByHeadId(long headID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByHeadId_First(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where headID = &#63;.
	*
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByHeadId_Last(long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where headID = &#63;.
	*
	* @param contentID the primary key of the current content
	* @param headID the head i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content[] findByHeadId_PrevAndNext(long contentID,
		long headID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Removes all the contents where headID = &#63; from the database.
	*
	* @param headID the head i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where headID = &#63;.
	*
	* @param headID the head i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByHeadId(long headID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents where columnID = &#63;.
	*
	* @param columnID the column i d
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where columnID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param columnID the column i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByColumnId(
		long columnID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where columnID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param columnID the column i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByColumnId(
		long columnID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where columnID = &#63;.
	*
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByColumnId_First(long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where columnID = &#63;.
	*
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByColumnId_First(long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where columnID = &#63;.
	*
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByColumnId_Last(long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where columnID = &#63;.
	*
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByColumnId_Last(long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where columnID = &#63;.
	*
	* @param contentID the primary key of the current content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content[] findByColumnId_PrevAndNext(
		long contentID, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Removes all the contents where columnID = &#63; from the database.
	*
	* @param columnID the column i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where columnID = &#63;.
	*
	* @param columnID the column i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByColumnId(long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents where rowID = &#63;.
	*
	* @param rowID the row i d
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByRowId(long rowID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where rowID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rowID the row i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByRowId(long rowID,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where rowID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rowID the row i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByRowId(long rowID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where rowID = &#63;.
	*
	* @param rowID the row i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByRowId_First(long rowID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where rowID = &#63;.
	*
	* @param rowID the row i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByRowId_First(long rowID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where rowID = &#63;.
	*
	* @param rowID the row i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByRowId_Last(long rowID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where rowID = &#63;.
	*
	* @param rowID the row i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByRowId_Last(long rowID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where rowID = &#63;.
	*
	* @param contentID the primary key of the current content
	* @param rowID the row i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content[] findByRowId_PrevAndNext(long contentID,
		long rowID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Removes all the contents where rowID = &#63; from the database.
	*
	* @param rowID the row i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRowId(long rowID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where rowID = &#63;.
	*
	* @param rowID the row i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByRowId(long rowID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContent(
		java.lang.String cellContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where cellContent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellContent the cell content
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContent(
		java.lang.String cellContent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where cellContent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellContent the cell content
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContent(
		java.lang.String cellContent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByCellContent_First(
		java.lang.String cellContent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByCellContent_First(
		java.lang.String cellContent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByCellContent_Last(
		java.lang.String cellContent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByCellContent_Last(
		java.lang.String cellContent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where cellContent = &#63;.
	*
	* @param contentID the primary key of the current content
	* @param cellContent the cell content
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content[] findByCellContent_PrevAndNext(
		long contentID, java.lang.String cellContent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Removes all the contents where cellContent = &#63; from the database.
	*
	* @param cellContent the cell content
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCellContent(java.lang.String cellContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where cellContent = &#63;.
	*
	* @param cellContent the cell content
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByCellContent(java.lang.String cellContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @return the matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContentOfColumn(
		java.lang.String cellContent, long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents where cellContent = &#63; and columnID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContentOfColumn(
		java.lang.String cellContent, long columnID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents where cellContent = &#63; and columnID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findByCellContentOfColumn(
		java.lang.String cellContent, long columnID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first content in the ordered set where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByCellContentOfColumn_First(
		java.lang.String cellContent, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the first content in the ordered set where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByCellContentOfColumn_First(
		java.lang.String cellContent, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last content in the ordered set where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content
	* @throws org.gfbio.NoSuchContentException if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByCellContentOfColumn_Last(
		java.lang.String cellContent, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the last content in the ordered set where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching content, or <code>null</code> if a matching content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByCellContentOfColumn_Last(
		java.lang.String cellContent, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contents before and after the current content in the ordered set where cellContent = &#63; and columnID = &#63;.
	*
	* @param contentID the primary key of the current content
	* @param cellContent the cell content
	* @param columnID the column i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content[] findByCellContentOfColumn_PrevAndNext(
		long contentID, java.lang.String cellContent, long columnID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Removes all the contents where cellContent = &#63; and columnID = &#63; from the database.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCellContentOfColumn(java.lang.String cellContent,
		long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents where cellContent = &#63; and columnID = &#63;.
	*
	* @param cellContent the cell content
	* @param columnID the column i d
	* @return the number of matching contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByCellContentOfColumn(java.lang.String cellContent,
		long columnID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the content in the entity cache if it is enabled.
	*
	* @param content the content
	*/
	public void cacheResult(org.gfbio.model.Content content);

	/**
	* Caches the contents in the entity cache if it is enabled.
	*
	* @param contents the contents
	*/
	public void cacheResult(java.util.List<org.gfbio.model.Content> contents);

	/**
	* Creates a new content with the primary key. Does not add the content to the database.
	*
	* @param contentID the primary key for the new content
	* @return the new content
	*/
	public org.gfbio.model.Content create(long contentID);

	/**
	* Removes the content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentID the primary key of the content
	* @return the content that was removed
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content remove(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	public org.gfbio.model.Content updateImpl(org.gfbio.model.Content content)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the content with the primary key or throws a {@link org.gfbio.NoSuchContentException} if it could not be found.
	*
	* @param contentID the primary key of the content
	* @return the content
	* @throws org.gfbio.NoSuchContentException if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content findByPrimaryKey(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gfbio.NoSuchContentException;

	/**
	* Returns the content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contentID the primary key of the content
	* @return the content, or <code>null</code> if a content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gfbio.model.Content fetchByPrimaryKey(long contentID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contents.
	*
	* @return the contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @return the range of contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.gfbio.model.impl.ContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contents
	* @param end the upper bound of the range of contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gfbio.model.Content> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contents.
	*
	* @return the number of contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}