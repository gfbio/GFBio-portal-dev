package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.ResearchObject;
import org.gfbio.model.ResearchObject_User;
import org.gfbio.model.impl.ResearchObjectImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ResearchObject_UserFinderImpl extends BasePersistenceImpl<ResearchObject_User> implements ResearchObject_UserFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY = ResearchObject_UserFinderImpl.class.getName();

	public static String GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION 		= FINDER_CLASS_NAME_ENTITY + ".getCheckOfResearchObjectIdAndVersion";
	public static String GET_OWNERIDS_BY_RESEARCHOBJECTIDS 				= FINDER_CLASS_NAME_ENTITY + ".getOwnerIdsByResearchObjectIds";
	public static String GET_RESEARCHOBJECTS_BY_USERID 					= FINDER_CLASS_NAME_ENTITY + ".getResearchObjectsByUserId";
	public static String GET_USERIDS_BY_RESEARCHOBJECTID_AND_VERSION 	= FINDER_CLASS_NAME_ENTITY + ".getUserIdsByResearchObjectIdAndVersion";
	
	
	
	//check entity table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
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
	@SuppressWarnings({  "unchecked" })
	public List<Long> getOwnerIdsByResearchObjectIds(long researchObjectId, int researchObjectVersion) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_OWNERIDS_BY_RESEARCHOBJECTIDS);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("userid", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			return (List<Long>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public List<ResearchObject> getResearchObjectsByUserId(long userId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RESEARCHOBJECTS_BY_USERID);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addEntity("ResearchObject", ResearchObjectImpl.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(userId);
			return (List<ResearchObject>) queryObject.list();
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


	
