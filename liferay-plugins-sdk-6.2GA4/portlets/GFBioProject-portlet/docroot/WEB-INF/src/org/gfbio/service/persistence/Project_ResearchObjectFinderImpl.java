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

	
	public static String FINDER_CLASS_NAME_ENTITY = Project_ResearchObjectFinderImpl.class.getName();
	public static String GET_PROJECTID_BY_RESEARCHOBJECTID_AND_VERSION = FINDER_CLASS_NAME_ENTITY + ".getProjectIdByResearchObjectIdAndVersion";
	public static String GET_RESEARCHOBJECTS_BY_PROJECTID = FINDER_CLASS_NAME_ENTITY + ".getResearchObjectsByProjectId";

	
	
	//
	@SuppressWarnings("rawtypes")
	public List getProjectIdByResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PROJECTID_BY_RESEARCHOBJECTID_AND_VERSION);
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
	
	
	//get a list of heads that have IDs from start to end
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
			return (List<ResearchObject>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
}





