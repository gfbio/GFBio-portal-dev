package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.Project;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
 


public class ProjectFinderImpl extends BasePersistenceImpl<Project> implements ProjectFinder {

	public static String FINDER_CLASS_NAME_ENTITY 						= ProjectFinderImpl.class.getName();
	public static String GET_CHECK_ON_ID 								= FINDER_CLASS_NAME_ENTITY + ".getCheckOnId";
	public static String CHECK_PROJECT_ON_SUBMISSIONS 					= FINDER_CLASS_NAME_ENTITY + ".checkProjectOnSubmissions";
	public static String GET_USERIDS_BY_RESEARCHOBJECTID_AND_VERSION 	= FINDER_CLASS_NAME_ENTITY + ".getUserIdsByResearchObjectIdAndVersion";
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOnId(long projectId) {
		System.out.println("0 "+projectId);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_ON_ID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(projectId);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List checkProjectOnSubmissions(long projectId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CHECK_PROJECT_ON_SUBMISSIONS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(projectId);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get a list of user id's witch have a relation to a specific research object
	@SuppressWarnings("rawtypes")
	public List getUserIdsByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_USERIDS_BY_RESEARCHOBJECTID_AND_VERSION);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("userid", Type.LONG);

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

	
}
