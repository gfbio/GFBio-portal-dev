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

import java.util.Date;

import org.gfbio.NoSuchProjectException;
import org.gfbio.model.Project;
import org.gfbio.service.ProjectLocalServiceUtil;
import org.gfbio.service.Project_User_WorkerLocalServiceUtil;
import org.gfbio.service.base.ProjectLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.ProjectLocalServiceBaseImpl
 * @see org.gfbio.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.gfbio.service.ProjectLocalServiceUtil} to access the project local service.
	 */
	
	public long updateProject(long userID, long projectID, String name, String description, Date begin, Date end, String status) throws SystemException{
		Project project=null;
		try {
			project = projectPersistence.findByPrimaryKey(projectID);
			Long foo = Project_User_WorkerLocalServiceUtil.updateProjectUserWorker(projectID, userID);
		} catch (NoSuchProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create new project
		if(project==null){
			
			project = projectPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			project.setName(name);
			project.setDescription(description);
			project.setBegin(begin);
			project.setEnd(end);
			project.setStatus(status);
		}
		//update project
		else{
			project.setName(name);
			project.setDescription(description);
			project.setBegin(begin);
			project.setEnd(end);
			project.setStatus(status);
		}
		
		super.updateProject(project);
		
		return project.getProjectID();
	}

	@Override
	public long updateProject(long projectID, String name, String description)
			throws SystemException {
		// TODO Auto-generated method stub
		return 0;
	}
}