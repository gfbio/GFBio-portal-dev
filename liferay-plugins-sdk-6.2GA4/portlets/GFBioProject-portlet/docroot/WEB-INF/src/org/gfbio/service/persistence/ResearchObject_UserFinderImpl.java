package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.ResearchObject_User;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ResearchObject_UserFinderImpl extends BasePersistenceImpl<ResearchObject_User> implements ResearchObject_UserFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY = ResearchObject_UserFinderImpl.class.getName();
	public static String GET_OWNERIDS_BY_RESEARCHOBJECTIDS = FINDER_CLASS_NAME_ENTITY + ".getOwnerIdsByResearchObjectIds";
	
	
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
}


	
