package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.PrimaryData_ResearchObject;
import org.gfbio.model.ResearchObject;
import org.gfbio.model.impl.ResearchObjectImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class PrimaryData_ResearchObjectFinderImpl extends BasePersistenceImpl<PrimaryData_ResearchObject> implements PrimaryData_ResearchObjectFinder {

	
	public static String FINDER_CLASS_NAME_ENTITY							 	= PrimaryData_ResearchObjectFinderImpl.class.getName();
	public static String GET_CHECK_OF_PRIMARYDATAID			 					= FINDER_CLASS_NAME_ENTITY + ".getCheckOfPrimaryDataId";
	public static String GET_CHECK_OF_RESEARCHOBJECTID			 				= FINDER_CLASS_NAME_ENTITY + ".getCheckOfResearchObjectId";
	public static String GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION 				= FINDER_CLASS_NAME_ENTITY + ".getCheckOfResearchObjectIdAndVersion";
	public static String GET_PRIMARYDATAIDS_BY_RESEARCHOBJECTID_AND_VERSION 	= FINDER_CLASS_NAME_ENTITY + ".getPrimaryDataIdsByResearchObjectIdAndVersion";
	public static String GET_RESEARCHOBJECTS_BY_PRIMARYDATAID 					= FINDER_CLASS_NAME_ENTITY + ".getResearchObjectsByPrimaryDataId";

	
	
	//check relation table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfPrimaryDataId(long primaryDataId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_PRIMARYDATAID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(primaryDataId);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	//check relation table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfResearchObjectId(long researchObjectId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_RESEARCHOBJECTID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//check relation table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get a list of primary data id's witch have a relation to a specific research object
	@SuppressWarnings("rawtypes")
	public List getPrimaryDataIdsByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PRIMARYDATAIDS_BY_RESEARCHOBJECTID_AND_VERSION);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("primarydataid", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get a list of researchobjects that have a relation to a specific primarydata. If more as one of researchobjects with the same ID has this relation, than the function get only the research object with the highest version.
	@SuppressWarnings("unchecked")
	public List<ResearchObject> getResearchObjectsByPrimaryDataId(long primaryDataId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RESEARCHOBJECTS_BY_PRIMARYDATAID);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addEntity("ResearchObject", ResearchObjectImpl.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(primaryDataId);
			qPos.add(primaryDataId);
			return (List<ResearchObject>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
}