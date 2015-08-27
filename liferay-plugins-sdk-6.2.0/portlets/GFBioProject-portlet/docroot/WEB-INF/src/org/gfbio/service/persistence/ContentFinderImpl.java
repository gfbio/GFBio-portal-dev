package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Head;
import org.gfbio.model.impl.ContentImpl;


import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ContentFinderImpl  extends BasePersistenceImpl<Head> implements ContentFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY = ContentFinderImpl.class.getName();
	public static String GET_COUNT_OF_ROW = FINDER_CLASS_NAME_ENTITY + ".getRowIds";
	public static String GET_CELL_CONTENT = FINDER_CLASS_NAME_ENTITY + ".getCellContent";

	
	public List getRowIds(long headId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COUNT_OF_ROW);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			//queryObject.addEntity("Content", ContentImpl.class);
			queryObject.addScalar("rowID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	public List getCellContent(long headId, long rowId, long columnId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CELL_CONTENT);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			//queryObject.addEntity("Content", ContentImpl.class);
			queryObject.addScalar("cellContent", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(rowId);
			qPos.add(columnId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}

}
