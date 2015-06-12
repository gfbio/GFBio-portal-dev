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
import java.util.List;

import org.gfbio.NoSuchCellException;
import org.gfbio.NoSuchProjectException;
import org.gfbio.NoSuchProject_UserException;
import org.gfbio.model.Cell;
import org.gfbio.model.Project;
import org.gfbio.service.CellLocalServiceUtil;
import org.gfbio.service.Project_UserLocalServiceUtil;
import org.gfbio.service.base.CellLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the cell local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.CellLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Marcel Froemming
 * @see org.gfbio.service.base.CellLocalServiceBaseImpl
 * @see org.gfbio.service.CellLocalServiceUtil
 */
public class CellLocalServiceImpl extends CellLocalServiceBaseImpl {
	
	public List <Cell> getCellsByTask(String task) throws SystemException{
		return cellPersistence.findByTask(task);
	}
	
	public Cell getCellById(long cellId) throws NoSuchCellException, SystemException{
		return cellPersistence.findByCellId(cellId);
	}
	
	public Cell getCellByContent(String content) throws NoSuchCellException, SystemException{
		return cellPersistence.findByContent(content);
	}
	
	public String getContent(long cellId) throws NoSuchCellException, SystemException{
		return cellPersistence.findByCellId(cellId).getContent();
	}
	
	public Boolean updateCell (long cellId, String task, String content){
		
		Cell cell = null;
		try {
			cell = CellLocalServiceUtil.getCellById(cellId);
		} catch (PortalException | SystemException e1) {e1.printStackTrace();}
		
		if(cell == null)
			try {
				cell = cellPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			} catch (SystemException e) {e.printStackTrace();}
		cell.setTask(task);
		cell.setContent(content);
		try {
			super.updateCell(cell);
		} catch (SystemException e) {e.printStackTrace();}
		
		return true;
	}
	
	
	
	
	
	
	
}