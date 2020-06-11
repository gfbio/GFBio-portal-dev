package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Project_ResearchObject;
import org.gfbio.model.ResearchObject;
import org.gfbio.model.impl.ResearchObjectImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class Project_ResearchObjectFinderImpl extends BasePersistenceImpl<Project_ResearchObject> implements Project_ResearchObjectFinder {

	
	public static String FINDER_CLASS_NAME_ENTITY							 = Project_ResearchObjectFinderImpl.class.getName();
	public static String GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION 			= FINDER_CLASS_NAME_ENTITY + ".getCheckOfResearchObjectIdAndVersion";
	public static String GET_PROJECTIDS_BY_RESEARCHOBJECTID_AND_VERSION 		= FINDER_CLASS_NAME_ENTITY + ".getProjectIdsByResearchObjectIdAndVersion";
	public static String GET_RESEARCHOBJECTS_BY_PROJECTID 					= FINDER_CLASS_NAME_ENTITY + ".getResearchObjectsByProjectId";

	//
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
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getProjectIdsByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PROJECTIDS_BY_RESEARCHOBJECTID_AND_VERSION);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("projectid", Type.LONG);

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
	
	
	//get a list of researchobjects that have a relation to a specific project. If more as one of research objects with the same ID has this relation, than the function get only the research object with the highest version.
	@SuppressWarnings("unchecked")
	public List<ResearchObject> getResearchObjectsByProjectId(long projectId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RESEARCHOBJECTS_BY_PROJECTID);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addEntity("ResearchObject", ResearchObjectImpl.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(projectId);
			qPos.add(projectId);
			return (List<ResearchObject>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
}