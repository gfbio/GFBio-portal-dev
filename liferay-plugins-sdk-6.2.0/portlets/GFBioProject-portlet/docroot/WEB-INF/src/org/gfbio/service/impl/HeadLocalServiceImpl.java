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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.gfbio.NoSuchHeadException;
import org.gfbio.NoSuchPositionException;
import org.gfbio.model.Head;
import org.gfbio.model.Position;
import org.gfbio.service.HeadLocalServiceUtil;
import org.gfbio.service.PositionLocalServiceUtil;
import org.gfbio.service.base.HeadLocalServiceBaseImpl;

/**
 * The implementation of the head local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gfbio.service.HeadLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Felicitas Loeffler
 * @see org.gfbio.service.base.HeadLocalServiceBaseImpl
 * @see org.gfbio.service.HeadLocalServiceUtil
 */
public class HeadLocalServiceImpl extends HeadLocalServiceBaseImpl {
	
	public void deleteCompleteHead(long headId) throws SystemException, PortalException{
		System.out.println(headId);
		
		
		
		// delete relations of table
		List <Head> headListC1 = headPersistence.findByColumn01(HeadLocalServiceUtil.getName(headId));
		if (headListC1.size()>0) 
			for (int i=0; i < headListC1.size();i++){
				List <Position> tempList = PositionLocalServiceUtil.getPositionsbyHeadId(headListC1.get(i).getHeadID());
				for (int j=0; j < tempList.size();j++ )
					PositionLocalServiceUtil.deletePosition(tempList.get(j).getPositionID());
				HeadLocalServiceUtil.deleteHead(headListC1.get(i).getHeadID());
			}
		
		List <Head> headListC2 = headPersistence.findByColumn02(HeadLocalServiceUtil.getName(headId));
		if (headListC2.size()>0)
			for (int i=0; i < headListC2.size();i++){
				List <Position> tempList = PositionLocalServiceUtil.getPositionsbyHeadId(headListC2.get(i).getHeadID());
				for (int j=0; j < tempList.size();j++ )
					PositionLocalServiceUtil.deletePosition(tempList.get(j).getPositionID());
				HeadLocalServiceUtil.deleteHead(headListC2.get(i).getHeadID());
			}
			
		// delete Content of table
		List <Position> positionList = PositionLocalServiceUtil.getPositionsbyHeadId(headId);
		for (int i=0; i < positionList.size();i++)
			PositionLocalServiceUtil.deletePosition(positionList.get(i));
			
		// delete table in head
		HeadLocalServiceUtil.deleteHead(headId);
	}
	

	public int getColumnCount(long headId) throws NoSuchHeadException, SystemException {

		Head head = getHeadById(headId);
		int size = 0;

		if (head.getColumn01().startsWith(" ")){}
		else {size++; if (head.getColumn02().startsWith(" ")){}
			else {size++;if (head.getColumn03().startsWith(" ")){}
				else {size++;if (head.getColumn04().startsWith(" ")){}
					else {size++;if (head.getColumn05().startsWith(" ")){}
						else {size++;if (head.getColumn06().startsWith(" ")){}
							else {size++;if (head.getColumn07().startsWith(" ")){}
								else {size++;if (head.getColumn08().startsWith(" ")){}
									else {size++;if (head.getColumn09().startsWith(" ")){}
										else {size++;if (head.getColumn10().startsWith(" ")){}
											else {size++;if (head.getColumn11().startsWith(" ")){}
												else {size++;if (head.getColumn12().startsWith(" ")){}
													else {size++;if (head.getColumn13().startsWith(" ")){}
														else {size++;if (head.getColumn14().startsWith(" ")){}
															else {size++;if (head.getColumn15().startsWith(" ")){}
																else {size++;if (head.getColumn16().startsWith(" ")){}
																	else {size++;if (head.getColumn17().startsWith(" ")){}
																		else {size++;if (head.getColumn18().startsWith(" ")){}
																			else {size++;if (head.getColumn19().startsWith(" ")){}
																				else {size++;if (head.getColumn20().startsWith(" ")){}
																					else {size++;
		} } } } } } } } } } } } } } } } } } } }
		return size;
	}

	public String getColumnName(long headId, int i) throws NoSuchHeadException, SystemException {
		Head head = getHeadById(headId);
		String column = "";
		if (i == 1)column = head.getColumn01(); else
			if (i == 2)column = head.getColumn02(); else
				if (i == 3)column = head.getColumn03(); else
					if (i == 4)column = head.getColumn04(); else
						if (i == 5)column = head.getColumn05(); else
							if (i == 6)column = head.getColumn06(); else
								if (i == 7)column = head.getColumn07(); else
									if (i == 8)column = head.getColumn08(); else
										if (i == 9)column = head.getColumn09(); else
											if (i == 10)column = head.getColumn10(); else
												if (i == 11)column = head.getColumn11(); else
													if (i == 12)column = head.getColumn12(); else
														if (i == 13)column = head.getColumn13(); else
															if (i == 14)column = head.getColumn14(); else
																if (i == 15)column = head.getColumn15(); else
																	if (i == 16)column = head.getColumn16(); else
																		if (i == 17)column = head.getColumn17(); else
																			if (i == 18)column = head.getColumn18(); else
																				if (i == 19)column = head.getColumn19(); else
																					if (i == 20)column = head.getColumn20();
		return column;
	}
	

	public Long getHeadID(String name) throws NoSuchHeadException, SystemException {
		return headPersistence.findByName(name).getHeadID();
	}
	
	public Head getHeadById(long headId) throws NoSuchHeadException, SystemException {
		return headPersistence.findByHeadID(headId);
	}

	
	public Head getHeadbyName(String name) throws NoSuchHeadException, SystemException {
		return headPersistence.findByName(name);
	}

	
	public List<Head> getHeads() throws SystemException {
		System.out.println(headPersistence.findAll().toString());
		return headPersistence.findAll();
	}
	
	public List<Head> getHeadsByTask(String task) throws SystemException {
		return headPersistence.findByTask(task);
	}
	

	public String getName(long headId) throws NoSuchHeadException, SystemException {
		return headPersistence.findByHeadID(headId).getName();
	}
	

	public String[] getNameArray(String task) throws SystemException  {

		List<Head> headList;
		if (task.equals(""))
			headList = null;
		else
			headList = getHeadsByTask(task);
		return getNameArray(headList);
	}
	
	public String[] getNameArray(List<Head> headList) throws SystemException {

		String[] names = null;
		if (headList == null)
			headList = headPersistence.findAll();

		names = new String[headList.size()];
		if (headList!= null)
			for (int i = 0; i<headList.size(); i++)
				names[i] = headList.get(i).getName();

		return names;
	}

	
	public Boolean setStandard() throws SystemException {
		Boolean check = true;
		//check = updateHead(0, "gfbio_", "", "","","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_category"    			, "table","name","label","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_datamanagmentsoftware" , "table","name","label","version","local_usible","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_fileformat"   			, "table","name","labe","version","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_metadata"    			, "table","name","label","version","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_persistentidentifier" 	, "table","name","label","has_fee_on_id_registration","kind_of_id_organisation","change_on_id_possible","resolves_data_types","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_researchfield"   		, "table","name","","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_type"     				, "table","name","","","","","","","","","","","","","","","","","","","");

		check = updateHead(0, "gfbio_category_researchfield"   			, "relation","categoryid","researchfieldid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_category_type"						, "relation","categoryid","typeid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_datamanagmentsoftware_dataprovider", "relation","datamanagmentsoftwareid","dataproviderid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_datamanagmentsoftware_fileformat" 	, "relation","datamanagmentsoftwareid","fileformatid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_datamanagmentsoftware_metadata" 	, "relation","datamanagmentsoftwareid","metadataid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_dataprovider_metadata"    			, "relation","dataproviderid","metadataid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_dataprovider_persistentidentifier" , "relation","dataproviderid","persistentidentifierid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_gfbio_fileformat_license"			, "relation","fileformatid", "licenseid","","","","","","","","","","","","","","","","","","");
		check = updateHead(0, "gfbio_gfbio_persistentidentifier_rule"	, "relation","persistentidentifierid","ruleid","","","","","","","","","","","","","","","","","","");

/*		try {
			check  = updateHead(0, "gfbio_keytable", "tablelocation","system","name","function","","","","","","","","","","","","","","","","","");
			long headID = getHeadID("gfbio_keytable");
			check = PositionLocalServiceUtil.updatePosition(0, headID, String.valueOf(HeadLocalServiceUtil.getHeadID("gfbio_metadata")), "gfbio_metadata", "table", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
			check = PositionLocalServiceUtil.updatePosition(0, headID, String.valueOf(HeadLocalServiceUtil.getHeadID("gfbio_datamanagmentsoftware")), "gfbio_datamanagmentsoftware", "table", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		} catch (SystemException | NoSuchHeadException e) {e.printStackTrace();}
		
		check  = updateHead(0, "gfbio_relationtable", "system","m_table","n_table","","","","","","","","","","","","","","","","","","");
	*/
		return check;
	}
	
	public Boolean updateHead(long headId, String name, String task, String column01, String column02, String column03, String column04, String column05, String column06, String column07, String column08, String column09, String column10, String column11, String column12, String column13, String column14, String column15, String column16, String column17, String column18, String column19, String column20)throws SystemException {

		Boolean check = true;
		Head head = null;

		try {
			head = headPersistence.findByHeadID(headId);
		} catch (NoSuchHeadException e) {e.printStackTrace();}

		//create new head
		if (head == null) {
			try {
				head = headPersistence.findByName(name);
			} catch (NoSuchHeadException e) {e.printStackTrace();}

			if (head != null)
				check = false;
			else
				head = headPersistence.create(CounterLocalServiceUtil.increment(getModelClassName()));
				head.setName(name);
				head.setTask(task);
				head.setColumn01(column01);
				head.setColumn02(column02);
				head.setColumn03(column03);
				head.setColumn04(column04);
				head.setColumn05(column05);
				head.setColumn06(column06);
				head.setColumn07(column07);
				head.setColumn08(column08);
				head.setColumn09(column09);
				head.setColumn10(column10);
				head.setColumn11(column11);
				head.setColumn12(column12);
				head.setColumn13(column13);
				head.setColumn14(column14);
				head.setColumn15(column15);
				head.setColumn16(column16);
				head.setColumn17(column17);
				head.setColumn18(column18);
				head.setColumn19(column19);
				head.setColumn20(column20);
				super.updateHead(head);
		}else {
			//update head
			head.setName(name);
			head.setTask(task);
			head.setColumn01(column01);
			head.setColumn02(column02);
			head.setColumn03(column03);
			head.setColumn04(column04);
			head.setColumn05(column05);
			head.setColumn06(column06);
			head.setColumn07(column07);
			head.setColumn08(column08);
			head.setColumn09(column09);
			head.setColumn10(column10);
			head.setColumn11(column11);
			head.setColumn12(column12);
			head.setColumn13(column13);
			head.setColumn14(column14);
			head.setColumn15(column15);
			head.setColumn16(column16);
			head.setColumn17(column17);
			head.setColumn18(column18);
			head.setColumn19(column19);
			head.setColumn20(column20);
			super.updateHead(head);
		}

		return check;
	}
	
	public Boolean updateRelationTable(long headId, String mtable, String ntable)throws SystemException, NoSuchHeadException, NoSuchPositionException{

		Boolean check = true;
		mtable = mtable.trim();
		ntable = ntable.trim();
		//List<Position> rows = positionPersistence.findByHeadID(HeadLocalServiceUtil.getHeadID("gfbio_relationtable"));
		

		
		List <Head> headList = HeadLocalServiceUtil.getHeadsByTask("relation");
		
		
		if (mtable.equals(ntable))
			check = false;
		else{
			
			//sort table names
			List <String> names = new ArrayList<String>();
			names.add(mtable);
			names.add(ntable);
			Collections.sort(names);
			mtable = names.get(0);
			ntable = names.get(1);
			
			//check, that relation table do not existing
			for (int i =0;i < headList.size();i++){
				System.out.println(i+" "+mtable+" "+headList.get(i).getColumn01());
				if (mtable.equals(headList.get(i).getColumn01()))
					if (ntable.equals(headList.get(i).getColumn01()))
						check = false;
				if (ntable.equals(headList.get(i).getColumn01()))
					if (mtable.equals(headList.get(i).getColumn01()))
						check = false;
			}
		}
				
		if (check == true)
			check = updateHead(headId, "gfbio_".concat(mtable.substring(6)).concat("_").concat(ntable.substring(6)), "relation", mtable, ntable,"","","","","","","","","","","","","","","","","","");
		
		System.out.println(check);
		return check;
	}

}