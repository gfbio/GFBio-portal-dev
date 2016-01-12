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

package org.gfbio.service.impl;

import java.util.List;

import org.gfbio.NoSuchDataProvider_PersistentIdentifierException;
import org.gfbio.model.DataProvider_PersistentIdentifier;
import org.gfbio.service.base.DataProvider_PersistentIdentifierLocalServiceBaseImpl;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierFinderUtil;
import org.gfbio.service.persistence.DataProvider_PersistentIdentifierPK;



import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the data provider_ persistent identifier local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.DataProvider_PersistentIdentifierLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.DataProvider_PersistentIdentifierLocalServiceBaseImpl
 * @see org.gfbio.service.DataProvider_PersistentIdentifierLocalServiceUtil
 */
public class DataProvider_PersistentIdentifierLocalServiceImpl extends DataProvider_PersistentIdentifierLocalServiceBaseImpl {
	
	
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getDataProviderIds (long persistentIdentiferId){
		return DataProvider_PersistentIdentifierFinderUtil.getDataProviderIds(persistentIdentiferId);
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getPersistentIdentiferIds (long dataProviderId){
		return DataProvider_PersistentIdentifierFinderUtil.getPersistentIdentiferIds(dataProviderId);
	}
	
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	// update or create a new relationship between data provider and persistent identifier (content)
	public Boolean updateDataProvider_PersistentIdentifier(long dataProviderId, long persistentIdentifierId)  {

		Boolean check = false;
		DataProvider_PersistentIdentifierPK pk = new DataProvider_PersistentIdentifierPK(dataProviderId, persistentIdentifierId);
		DataProvider_PersistentIdentifier relationship = null;
		
		try {
			relationship = dataProvider_PersistentIdentifierPersistence.findByPrimaryKey(pk);
		} catch (NoSuchDataProvider_PersistentIdentifierException | SystemException e1) {e1.printStackTrace();}

		if (relationship == null) 
			relationship = dataProvider_PersistentIdentifierPersistence.create(pk);
		try {
			super.updateDataProvider_PersistentIdentifier(relationship);
			check = true;
		} catch (SystemException e) {e.printStackTrace();}

		return check;
	}
}