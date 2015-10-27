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

	public static String FINDER_CLASS_NAME_ENTITY = ColumnFinderImpl.class.getName();
	public static String GET_COLUMNS_WITH_RELATION = FINDER_CLASS_NAME_ENTITY + ".getColumnsWithRelation";
	public static String GET_COLUMNIDS_WITHOUT_RELATION = FINDER_CLASS_NAME_ENTITY + ".getColumnIdsWithoutRelation";
	public static String GET_COLUMNNAME_BY_ID = FINDER_CLASS_NAME_ENTITY + ".getColumnNameById";	
	public static String GET_COUNT_OF_COLUMNS = FINDER_CLASS_NAME_ENTITY + ".getCountofColumns";	
	public static String GET_HEADIDS_BY_COLUMNNAME = FINDER_CLASS_NAME_ENTITY + ".getHeadIdsByColumnName";

	
	
	
	
	

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
	
	
	//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getColumnIdsWithoutRelation(String columnName) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNIDS_WITHOUT_RELATION);

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
	@SuppressWarnings({  "rawtypes" })
	public List getColumnNameById(long columnid) {
		System.out.println("Finder "+ columnid);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNNAME_BY_ID);
			System.out.println(sql);

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
	
	
	
	//
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
	
	
	//
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
	
	

	


}
