package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Head;
import org.gfbio.model.impl.ColumnImpl;
import org.gfbio.model.impl.HeadImpl;
import org.gfbio.model.impl.PositionImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
 


public class HeadFinderImpl extends BasePersistenceImpl<Head> implements HeadFinder {
	
	public static String FINDER_CLASS_NAME_ENTITY = HeadFinderImpl.class.getName();
	public static String GET_HEAD_BETWEEN_HEAD_IDS = FINDER_CLASS_NAME_ENTITY + ".getHeadBetweenHeadIds";
	public static String GET_ENITIES_BY_HEADID = FINDER_CLASS_NAME_ENTITY + ".getEntitiesByHeadId";

	
	public List<Head> getHeadBetweenHeadIds(int start, int end) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_HEAD_BETWEEN_HEAD_IDS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addEntity("Head", HeadImpl.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(start);
			qPos.add(end);
			return (List<Head>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public List getEntitiesByHeadId(long headId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ENITIES_BY_HEADID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addEntity("Head", HeadImpl.class);
			queryObject.addEntity("Column", ColumnImpl.class);
			queryObject.addEntity("Position", PositionImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
			

}
