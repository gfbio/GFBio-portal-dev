package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Column;
import org.gfbio.model.impl.ColumnImpl;






import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ColumnFinderImpl  extends BasePersistenceImpl<Column> implements ColumnFinder{

	public static String FINDER_CLASS_NAME_ENTITY 							= ColumnFinderImpl.class.getName();
	public static String CHECK_EXISTENCE_OF_COLUMN							= FINDER_CLASS_NAME_ENTITY + ".checkExistenceOfColumn";	
	public static String GET_COLUMNID_BY_NAMES 								= FINDER_CLASS_NAME_ENTITY + ".getColumnIdByNames";	
	public static String GET_COLUMNNAME_BY_ID 								= FINDER_CLASS_NAME_ENTITY + ".getColumnNameById";	
	public static String GET_COLUMNS_WITH_RELATION 							= FINDER_CLASS_NAME_ENTITY + ".getColumnsWithRelation";
	public static String GET_COUNT_OF_COLUMNS 								= FINDER_CLASS_NAME_ENTITY + ".getCountofColumns";
	public static String GET_HEADIDS_BY_COLUMNNAME 							= FINDER_CLASS_NAME_ENTITY + ".getHeadIdsByColumnName";
	public static String GET_HEADIDS_WITHOUT_RELATIONSHIPS_BY_COLUMNNAME 	= FINDER_CLASS_NAME_ENTITY + ".getHeadIdsWithoutRelationshipsByColumnName";
	public static String GET_MAX_ID 										= FINDER_CLASS_NAME_ENTITY + ".getMaxId";
	

	//
	@SuppressWarnings({  "rawtypes" })
	public List checkExistenceOfColumn(long headId, String columnName) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CHECK_EXISTENCE_OF_COLUMN);
			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(columnName);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getColumnIdByNames(String tableName, String columnName) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNID_BY_NAMES);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("columnid", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(tableName);
			qPos.add(columnName);
			return (List<Column>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get the name of a column with a specific id
	@SuppressWarnings({  "rawtypes" })
	public List getColumnNameById(long columnid) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNNAME_BY_ID);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("column_name", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnid);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get all Columns of all relation tables that include a specific table name as column name
	@SuppressWarnings("unchecked")
	public List<Column> getColumnsWithRelation(String columnName) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNS_WITH_RELATION);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addEntity("Column", ColumnImpl.class);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName);
			qPos.add(columnName);
			return (List<Column>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get the count of columns of a specific table
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getCountofColumns(long headId) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COUNT_OF_COLUMNS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("count", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			return (List<Column>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get all IDs of heads that have a column with a specific name 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getHeadIdsByColumnName(String columnName) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_HEADIDS_BY_COLUMNNAME);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("headID", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName);
			return (List<Column>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get all IDs Columns that have the specific same name
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getHeadIdsWithoutRelationshipsByColumnName(String columnName) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_HEADIDS_WITHOUT_RELATIONSHIPS_BY_COLUMNNAME);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("headID", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName);
			qPos.add(columnName);
			return (List<Column>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getMaxId() {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_MAX_ID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("columnid", Type.LONG);

			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
}
