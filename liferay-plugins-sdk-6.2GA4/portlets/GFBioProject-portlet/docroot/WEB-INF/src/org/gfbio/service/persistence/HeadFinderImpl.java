package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Head;
import org.gfbio.model.impl.ColumnImpl;
import org.gfbio.model.impl.ContentImpl;
import org.gfbio.model.impl.HeadImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
 


public class HeadFinderImpl extends BasePersistenceImpl<Head> implements HeadFinder {
	
	public static String FINDER_CLASS_NAME_ENTITY 	= HeadFinderImpl.class.getName();
	public static String GET_ENITIES_BY_HEADID 		= FINDER_CLASS_NAME_ENTITY + ".getEntitiesByHeadId";
	public static String GET_HEAD_BETWEEN_HEAD_IDS 	= FINDER_CLASS_NAME_ENTITY + ".getHeadBetweenHeadIds";
	public static String GET_HEADID_BY_TABLENAME 	= FINDER_CLASS_NAME_ENTITY + ".getHeadIdByTableName";	
	public static String GET_TABLENAME_BY_ID 		= FINDER_CLASS_NAME_ENTITY + ".getTableNameById";	
	public static String GET_TABLENAME_BY_TABLETYPE = FINDER_CLASS_NAME_ENTITY + ".getTableNamesByTableType";
	
	

	
	//get the complete table (head, column, content) with a specific Id as list 
	@SuppressWarnings("rawtypes")
	public List getEntitiesByHeadId(long headId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ENITIES_BY_HEADID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addEntity("Head", HeadImpl.class);
			queryObject.addEntity("Column", ColumnImpl.class);
			queryObject.addEntity("Content", ContentImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get a list of heads that have IDs from start to end
	@SuppressWarnings("unchecked")
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
	
	
	//get the ID of a table with a specific name 
	@SuppressWarnings("rawtypes")
	public List getHeadIdByTableName(String tableName) {
	
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_HEADID_BY_TABLENAME);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("headid", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(tableName);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get the name of a specific table with a specific id
	@SuppressWarnings("rawtypes")
	public List getTableNameById(long headId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_TABLENAME_BY_ID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("table_name", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	//get the name of a specific table with a specific id
	@SuppressWarnings("rawtypes")
	public List getTableNamesByTableType(String tableType) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_TABLENAME_BY_TABLETYPE);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("table_name", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(tableType);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	

			

}
