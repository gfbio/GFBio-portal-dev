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

package org.gfbio.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.gfbio.NoSuchDataManagementPlanException;
import org.gfbio.NoSuchDataProviderException;
import org.gfbio.model.DataManagementPlan;
import org.gfbio.model.DataProvider;
import org.gfbio.model.UserExtension;
import org.gfbio.service.UserExtensionLocalServiceUtil;
import org.gfbio.service.base.DataManagementPlanLocalServiceBaseImpl;
import org.gfbio.service.persistence.DataManagementPlanFinderUtil;
import org.gfbio.service.persistence.DataProviderFinderUtil;
import org.gfbio.submissionworkflow.WorkflowGeneric;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

/**
 * The implementation of the data management plan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.DataManagementPlanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.DataManagementPlanLocalServiceBaseImpl
 * @see org.gfbio.service.DataManagementPlanLocalServiceUtil
 */


public class DataManagementPlanLocalServiceImpl extends DataManagementPlanLocalServiceBaseImpl {


    private static Log _log = LogFactoryUtil.getLog(WorkflowGeneric.class);
    
	///////////////////////////////////// Get Functions ///////////////////////////////////////////////////
	
	
	// get entry from gfbio_datamanagementplan as java class by dmpId
	public DataManagementPlan getDmpById(long dmpId){
		DataManagementPlan dmp = null;
		try {dmp = dataManagementPlanPersistence.findByDmpID(dmpId);}
		catch (SystemException | NoSuchDataManagementPlanException e) {e.printStackTrace();}
		return dmp;
	}
	
	
	// get list of entries from gfbio_datamanagementplan as java class by userId. All entities of this list, are related to this user.
	public List<DataManagementPlan> getdmpListByUserId(long userId){
		List<DataManagementPlan> dmpList = null;
		try {dmpList = dataManagementPlanPersistence.findByUserID(userId);}
		catch (SystemException e) {e.printStackTrace();}
		return dmpList;
	}
	
	///////////////////////////////////// Helper Functions ///////////////////////////////////////////////////
	
	//
	@SuppressWarnings("rawtypes")
	private long getMaxId(){
		long id = 0;
		List idList = DataManagementPlanFinderUtil.getMaxId();
		if (idList.size()>0)
			if (idList.get(0) != null)
				id = (long) idList.get(0);
		return id;
	}
	
	
	//
	public long constructNewId(){
		long id = 0;
		try {
			if (CounterLocalServiceUtil.increment(getModelClassName())<getMaxId())
				CounterLocalServiceUtil.reset(getModelClassName(), getMaxId());
			id = CounterLocalServiceUtil.increment(getModelClassName());
		} 
		catch (SystemException e) {e.printStackTrace();}
		return id;
	}
	
	///////////////////////////////////// Update Functions ///////////////////////////////////////////////////
	
	
	
	//
	public DataManagementPlan updateDataManagementPlan (DataManagementPlan dmp) {
		
		DataManagementPlan newDmp = null;
		
		if (!dmp.getName().equals("")) {
			
			User user = null;
			try {
				user = userPersistence.findByPrimaryKey(dmp.getUserID());
			} catch (NoSuchUserException | SystemException e2) {
				_log.error("no User with userID "+dmp.getUserID()+ " exists.");
			}
			
			if (user != null) {
		
				try {
					newDmp = dataManagementPlanPersistence.findByPrimaryKey(dmp.getDmpID());
				} catch (SystemException | NoSuchDataManagementPlanException e1) {
					_log.error("no User with dmpID "+dmp.getDmpID()+ " exists.");
				}
		
				if (newDmp == null) {
					newDmp = dataManagementPlanPersistence.create(constructNewId());
					newDmp.setDmpTInput((dmp.getDmpTInput()).trim());
					newDmp.setName((dmp.getName()).trim());
					newDmp.setUserID(dmp.getUserID());
				} else {
					newDmp = (DataManagementPlan) dmp.clone();
				}
				newDmp.setLastModifiedDate(new Timestamp(new Date().getTime()));
				
				System.out.println("super dmp: " + newDmp);
				
				try {
					super.updateDataManagementPlan(newDmp);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		return newDmp;
	}
	
	
}