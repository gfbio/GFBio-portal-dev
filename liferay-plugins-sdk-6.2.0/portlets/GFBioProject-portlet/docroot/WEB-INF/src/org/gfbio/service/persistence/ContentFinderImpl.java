package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.Content;

import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class ContentFinderImpl  extends BasePersistenceImpl<Content> implements ContentFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY = ContentFinderImpl.class.getName();
	public static String GET_CELL_CONTENT = FINDER_CLASS_NAME_ENTITY + ".getCellContent";
	public static String GET_CELL_CONTENT_BY_CONTENTID = FINDER_CLASS_NAME_ENTITY + ".getCellContentByContentId";
	public static String GET_COLUMNID_BY_ID = FINDER_CLASS_NAME_ENTITY + ".getColumnIdById";
	public static String GET_CONTENTIDS_WITHOUT_RELATIONSHIPS = FINDER_CLASS_NAME_ENTITY + ".getContentIdsWithoutRelationships";
	public static String GET_CONTENTIDS_WITH_RELATIONSHIPS = FINDER_CLASS_NAME_ENTITY + ".getContentIdsWithRelationships";
	public static String GET_COUNT_OF_ROW = FINDER_CLASS_NAME_ENTITY + ".getRowIds";
	public static String GET_ROWID_BY_CELLCONTENT = FINDER_CLASS_NAME_ENTITY + ".getRowIdByCellContent";
	public static String GET_HEADID_BY_ID = FINDER_CLASS_NAME_ENTITY + ".getHeadIdById";
	public static String GET_CONTENTIDS_BY_ROWID = FINDER_CLASS_NAME_ENTITY + ".getContentIdsByRowId";
	public static String GET_ROWID_BY_CONTENTID = FINDER_CLASS_NAME_ENTITY + ".getRowIdByContentId";
	public static String GET_ROWID_OF_RELATION = FINDER_CLASS_NAME_ENTITY + ".getRowIdOfRelation";
	
	

	//
	@SuppressWarnings("rawtypes")
	public List getCellContent(long headId, long rowId, long columnId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CELL_CONTENT);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
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
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getCellContentByContentId(long contentId) {
		System.out.println(contentId);
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CELL_CONTENT_BY_CONTENTID);
			System.out.println(sql);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("cellContent", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(contentId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {closeSession(session);	}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithoutRelationships(long rowId, String columnName1, String columnName2) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_WITHOUT_RELATIONSHIPS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("contentID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName1);
			qPos.add(columnName2);
			qPos.add(Long.toString(rowId));
			qPos.add(Long.toString(rowId));
			qPos.add(columnName2);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithRelationships(long rowId, String columnName1, String columnName2) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_WITH_RELATIONSHIPS);
			System.out.println(GET_CONTENTIDS_WITH_RELATIONSHIPS);
			System.out.println(sql);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("contentID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName1);
			qPos.add(columnName2);
			qPos.add(Long.toString(rowId));
			qPos.add(Long.toString(rowId));
			qPos.add(columnName1);
			qPos.add(columnName2);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getColumnIdById(long contentId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COLUMNID_BY_ID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("columnID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(contentId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	

	//
	@SuppressWarnings("rawtypes")
	public  List getRowIds(long headId) {
	
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
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getRowIdByCellContent(long headId, String columnName, String cellContent) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROWID_BY_CELLCONTENT);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("rowID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(headId);
			qPos.add(columnName);
			qPos.add(cellContent);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public List getRowIdByContentId(long contentId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROWID_BY_CONTENTID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("rowId", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(contentId);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getHeadIdById(long contentId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_HEADID_BY_ID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("headID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(contentId);

			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getContentIdsByRowId(long rowId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_BY_ROWID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("contentID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(rowId);

			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getRowIdOfRelation(String cellContent1, String cellContent2) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROWID_OF_RELATION);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("rowID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(cellContent1);
			qPos.add(cellContent2);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
}


