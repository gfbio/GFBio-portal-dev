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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchPositionException;
import org.gfbio.model.Head;
import org.gfbio.model.Position;
import org.gfbio.service.HeadLocalServiceUtil;

import org.gfbio.service.base.PositionLocalServiceBaseImpl;

/**
 * The implementation of the position local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.PositionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.PositionLocalServiceBaseImpl
 * @see org.gfbio.service.PositionLocalServiceUtil
 */
public class PositionLocalServiceImpl extends PositionLocalServiceBaseImpl {

	public String getColumnContent(long positionId, int i) throws SystemException {
		Position position = null;

		try {
			position = getPositionbyId(positionId);
		} catch (NoSuchPositionException e) {e.printStackTrace();}
		String column = "";
		if (i == 1)column = position.getColumn01(); else
			if (i == 2)column = position.getColumn02(); else
				if (i == 3)column = position.getColumn03(); else
					if (i == 4)column = position.getColumn04(); else
						if (i == 5)column = position.getColumn05(); else
							if (i == 6)column = position.getColumn06(); else
								if (i == 7)column = position.getColumn07(); else
									if (i == 8)column = position.getColumn08(); else
										if (i == 9)column = position.getColumn09(); else
											if (i == 10)column = position.getColumn10(); else
												if (i == 11)column = position.getColumn11(); else
													if (i == 12)column = position.getColumn12(); else
														if (i == 13)column = position.getColumn13(); else
															if (i == 14)column = position.getColumn14(); else
																if (i == 15)column = position.getColumn15(); else
																	if (i == 16)column = position.getColumn16(); else
																		if (i == 17)column = position.getColumn17(); else
																			if (i == 18)column = position.getColumn18(); else
																				if (i == 19)column = position.getColumn19(); else
																					if (i == 20)column = position.getColumn20();
		return column;
	}
	
	public List<Position> getPositionsbyColumnName(String content, int i) throws SystemException{
		return positionPersistence.findByColumn01(content);
	}
	
	public String[] getNameArray(long headId) throws NoSuchHeadException {

		
		List<Position> positionList;
		String[] names = null;
		try {
			positionList = getPositionsbyHeadId(headId);
			names = new String[positionList.size()];
			
			for (int j =1;j<= 20;j++)
				if (HeadLocalServiceUtil.getColumnName(headId, j).trim().equals("name"))
					if (positionList!= null)
						for (int i = 0; i<positionList.size(); i++)
							names[i] = getColumnContent(positionList.get(i).getPositionID(),j);
		} catch (SystemException e1) {e1.printStackTrace();	}

		return names;
	}

	public Position getPositionbyId(long positionId) throws NoSuchPositionException, SystemException {
		return positionPersistence.findByPositionID(positionId);
	}
	
	public Position getPositionByHeadIdAndName(long headId, String name) throws SystemException {
		List<Position> positionList;
		Position position = null;
		positionList = getPositionsbyHeadId(headId);
		for (int i =0; i < positionList.size();i++)
			if (name.equals(positionList.get(i).getColumn01()))
				position = positionList.get(i);
		return position;
	}

	public List<Position> getPositionsbyHeadId(long headId) throws SystemException {
		return positionPersistence.findByHeadID(headId);
	}

	public String[][] getTable(long headID) throws NoSuchHeadException, SystemException {

		List<Position> rows = positionPersistence.findByHeadID(headID);
		String[][] table = new String[(1 + HeadLocalServiceUtil.getColumnCount(headID))][(rows.size()+1)];

		table[0][0]= "ID";

		for (int j = 1; j < table.length; j++)
			table[j][0]= HeadLocalServiceUtil.getColumnName(headID, j);

		for (int i = 1; i < (table[0].length); i++) {
			for (int j = 0; j < table.length; j++)

				if (j == 0)
					table[j][i] = Long.toString(rows.get(i-1).getPositionID());
				else
					table[j][i] = getColumnContent(rows.get(i-1).getPositionID(), j);
		}

		return table;
	}
	


	public Boolean updatePosition(long positionID, long headID, String column01, String column02, String column03, String column04, String column05, String column06, String column07, String column08, String column09, String column10, String column11, String column12, String column13, String column14, String column15, String column16, String column17, String column18, String column19, String column20)throws SystemException {
		
		Boolean check = true;
		Position position = null;
		Head head = null;

		try {
			position = positionPersistence.findByPositionID(positionID);
		} catch (NoSuchPositionException e) {e.printStackTrace();}

		try {
			head = headPersistence.findByHeadID(headID);
		} catch (NoSuchHeadException e) {e.printStackTrace();}

		if (head != null) {

			int columncount = 0;
			try {
				columncount = HeadLocalServiceUtil.getColumnCount(headID);
			} catch (NoSuchHeadException e) {e.printStackTrace();}
			
			//create new position
			if (position == null)
				position = positionPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
			//update position
			position.setHeadID(headID);

			if (columncount >= 1){ position.setColumn01(column01);
				if (columncount >= 2){ position.setColumn02(column02);
					if (columncount >= 3){ position.setColumn03(column03);
						if (columncount >= 4){ position.setColumn04(column04);
							if (columncount >= 5){ position.setColumn05(column05);
								if (columncount >= 6){ position.setColumn06(column06);
									if (columncount >= 7){ position.setColumn07(column07);
										if (columncount >= 8){ position.setColumn08(column08);
											if (columncount >= 9){ position.setColumn09(column09);
												if (columncount >= 10){ position.setColumn10(column10);
													if (columncount >= 11){ position.setColumn11(column11);
														if (columncount >= 12){ position.setColumn12(column12);
															if (columncount >= 13){ position.setColumn13(column13);
																if (columncount >= 14){ position.setColumn14(column14);
																	if (columncount >= 15){ position.setColumn15(column15);
																		if (columncount >= 16){ position.setColumn16(column16);
																			if (columncount >= 17){ position.setColumn17(column17);
																				if (columncount >= 18){ position.setColumn18(column18);
																					if (columncount >= 19){ position.setColumn19(column19);
																						if (columncount >= 20){ position.setColumn20(column20);
			}	}	}	}	}	}	}	}	}	}	}	}	}	}	}	}	}	}	}	}
			
		
			super.updatePosition(position);
		}

		else
			check = false;

		return check;
	}

}