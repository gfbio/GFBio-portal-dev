package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.Project_User;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class Project_UserFinderImpl extends BasePersistenceImpl<Project_User> implements Project_UserFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY = Project_UserFinderImpl.class.getName();
	public static String GET_OWNER_AND_PI_BY_PROJECTID 	= FINDER_CLASS_NAME_ENTITY + ".getOwnerAndPiByProjectId";
	public static String GET_PROJECTIDS_BY_USERID 		= FINDER_CLASS_NAME_ENTITY + ".getProjectIdsByUserId";
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Long> getOwnerAndPiByProjectId(long projectId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_OWNER_AND_PI_BY_PROJECTID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("userid", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(projectId);
			return (List<Long>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Long> getProjectIdsByUserId(long userId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PROJECTIDS_BY_USERID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("projectid", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(userId);
			return (List<Long>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
}


	
