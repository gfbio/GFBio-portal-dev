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


import org.gfbio.NoSuchProject_User_WorkerException;

import org.gfbio.model.Project_User_Worker;
import org.gfbio.service.base.Project_User_WorkerLocalServiceBaseImpl;
import org.gfbio.service.persistence.Project_User_WorkerPK;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the project_ user_ worker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.Project_User_WorkerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author froemm
 * @see org.gfbio.service.base.Project_User_WorkerLocalServiceBaseImpl
 * @see org.gfbio.service.Project_User_WorkerLocalServiceUtil
 */
public class Project_User_WorkerLocalServiceImpl extends Project_User_WorkerLocalServiceBaseImpl {
	
	public long updateProjectUserWorker(long projectID, long userID) throws SystemException, NoSuchProject_User_WorkerException{
		
		Project_User_Worker relation=null;
		Project_User_WorkerPK pk = new Project_User_WorkerPK(projectID, userID);
		
		relation = project_User_WorkerPersistence.findByPrimaryKey(pk);
		
		//create new project
		if(relation==null)
			relation = project_User_WorkerPersistence.create(pk);

		//update project
		else{
			//exception?
		}
		
		super.updateProject_User_Worker(relation);
		return relation.getUserID() + relation.getProjectID();
	}

}