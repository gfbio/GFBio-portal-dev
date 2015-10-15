package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.ResearchObject;
import org.gfbio.model.impl.ResearchObjectImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;



public class ResearchObjectFinderImpl  extends BasePersistenceImpl<ResearchObject> implements ResearchObjectFinder{

	
	public static String FINDER_CLASS_NAME_ENTITY = ResearchObjectFinderImpl.class.getName();
	public static String GET_CHECK_OF_DIRECT_PARENT = FINDER_CLASS_NAME_ENTITY + ".getCheckOfDirectParent";	
	public static String GET_DIRECT_PARENT = FINDER_CLASS_NAME_ENTITY + ".getDirectParent";

	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfDirectParent(long researchObjectId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_DIRECT_PARENT);
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
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<ResearchObject> getDirectParent(long researchObjectId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_DIRECT_PARENT);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addEntity("ResearchObject", ResearchObjectImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			
			return (List<ResearchObject>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
}
