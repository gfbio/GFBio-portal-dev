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
	
	public static String FINDER_CLASS_NAME_ENTITY 								= ContentFinderImpl.class.getName();
	public static String CHECK_EXISTENCE_OF_KEYID								= FINDER_CLASS_NAME_ENTITY + ".checkExistenceOfKeyId";
	public static String CHECK_KEYPAIR_IN_RELATIONSHIP							= FINDER_CLASS_NAME_ENTITY + ".checkKeyPairInRelationship";
	public static String GET_CELL_CONTENT 										= FINDER_CLASS_NAME_ENTITY + ".getCellContent";
	public static String GET_CELL_CONTENT_BY_CONTENTID 							= FINDER_CLASS_NAME_ENTITY + ".getCellContentByContentId";
	public static String GET_CELLCONTENT_BY_ROWID_AND_COLUMNNAME				= FINDER_CLASS_NAME_ENTITY + ".getCellContentByRowIdAndColumnName";
	public static String GET_COLUMNID_BY_ID 									= FINDER_CLASS_NAME_ENTITY + ".getColumnIdById";
	public static String GET_CONTENTIDS_OF_RELATIONSHIPS_OF_SPECIFIC_CELLCONTENT= FINDER_CLASS_NAME_ENTITY + ".getContentIdsOfRelationshipsOfSpecificCellContent";
	public static String GET_CONTENTIDS_WITHOUT_RELATIONSHIPS 					= FINDER_CLASS_NAME_ENTITY + ".getContentIdsWithoutRelationships";
	public static String GET_CONTENTIDS_WITH_NORMAL_TABLE_RELATIONSHIPS 		= FINDER_CLASS_NAME_ENTITY + ".getContentIdsWithNormalTableRelationships";
	public static String GET_CONTENTIDS_WITH_RELATIONSHIPS 						= FINDER_CLASS_NAME_ENTITY + ".getContentIdsWithRelationships";
	public static String GET_COUNT_OF_ROW 										= FINDER_CLASS_NAME_ENTITY + ".getRowIds";
	public static String GET_ROWID_BY_CELLCONTENT 								= FINDER_CLASS_NAME_ENTITY + ".getRowIdByCellContent";
	public static String GET_HEADID_BY_ID 										= FINDER_CLASS_NAME_ENTITY + ".getHeadIdById";
	public static String GET_CONTENTIDS_BY_ROWID 								= FINDER_CLASS_NAME_ENTITY + ".getContentIdsByRowId";
	public static String GER_OPPOSITE_CELLCONTENT_OF_RELATIONS_BY_CELLCONTENT	= FINDER_CLASS_NAME_ENTITY + ".getOppositeCellContentsOfRelationsByCellContent";
	public static String GET_ROWID_BY_CONTENTID									= FINDER_CLASS_NAME_ENTITY + ".getRowIdByContentId";
	public static String GET_ROWID_OF_RELATION 									= FINDER_CLASS_NAME_ENTITY + ".getRowIdOfRelation";
	public static String GET_ROW_INFORMATION_BY_CONTENTID						= FINDER_CLASS_NAME_ENTITY + ".getRowInformationByContentId";
	public static String GET_ROW_INFORMATION_BY_ROWID							= FINDER_CLASS_NAME_ENTITY + ".getRowInformationByRowId";
	
	
	//Is  pk in table with headid, the Boolean is true
	@SuppressWarnings("rawtypes")
	public List checkExistenceOfKeyId(long headId, String pk) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(CHECK_EXISTENCE_OF_KEYID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("check", Type.BOOLEAN);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(pk);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//Are pk1 and pk2 in table with headid, the Boolean is false, because the function will is useing in relationship table update
	@SuppressWarnings("rawtypes")
	public List checkKeyPairInRelationship(long headId, String pk1, String pk2) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(CHECK_KEYPAIR_IN_RELATIONSHIP);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("check", Type.BOOLEAN);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(pk1);
			qPos.add(pk2);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get the content of cell with a specific row and column in a specific table
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
	
	
	//get the content of cell with a specific id
	@SuppressWarnings("rawtypes")
	public List getCellContentByContentId(long contentId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CELL_CONTENT_BY_CONTENTID);
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
	
	
	///get the content of cell with a specific id
	@SuppressWarnings("rawtypes")
	public List getCellContentByRowIdAndColumnName(long rowId, String columnName) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CELLCONTENT_BY_ROWID_AND_COLUMNNAME);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("cellContent", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(rowId);
			qPos.add(columnName);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {closeSession(session);	}
		return null;
	}
	
	
	//get List of content IDs from a relationship between two entities. The list has only IDs from one of the entities. The not list entity has a condition in cell content column. Example: the function get all category entries of the relationship between category and types, where the type cell content is 'research field'    
	@SuppressWarnings("rawtypes")
	public  List getContentIdsOfRelationshipsOfSpecificCellContent(long relationTableHeadId, long entitiyTableHeadId, String entityTableCellContent) {
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_OF_RELATIONSHIPS_OF_SPECIFIC_CELLCONTENT);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("contentid", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(relationTableHeadId);
			qPos.add(entitiyTableHeadId);
			qPos.add(entityTableCellContent);
			qPos.add(entitiyTableHeadId);
			qPos.add(entityTableCellContent);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get List of content IDs, without content of relationship tables
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
	
	
	//get List of content IDs, with content of relationship tables
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithNormalTableRelationships(long rowId, String tableName, String columnName1, String columnName2) {
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_WITH_NORMAL_TABLE_RELATIONSHIPS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("contentID", Type.LONG);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(columnName1);
			qPos.add(tableName);
			qPos.add(Long.toString(rowId));
			qPos.add(columnName2);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	//get List of content IDs, with content of relationship tables
	@SuppressWarnings("rawtypes")
	public  List getContentIdsWithRelationships(long rowId, String columnName1, String columnName2) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CONTENTIDS_WITH_RELATIONSHIPS);
			
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
	
	
	//get the id of a column that have cell with specific cell 
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
	
	
	//get all IDs of cells in a specific row
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
	
	
	//get the ID of a table that include a cell with a specific ID
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
	
	
	//get List of content IDs, with content of relationship tables
	@SuppressWarnings("rawtypes")
	public  List getOppositeCellContentsOfRelationsByCellContent(long headId, String cellcontent) {
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GER_OPPOSITE_CELLCONTENT_OF_RELATIONS_BY_CELLCONTENT);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("cellcontent", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(headId);
			qPos.add(cellcontent);
			qPos.add(headId);
			qPos.add(cellcontent);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	

	//get all IDs of rows of a specific table
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
	
	
	//get ID of a row that are in a specific table and column and content in the cell of column in table
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
	
	
	//get the ID of a row that include a cell with a specific ID
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
	
	
	//get the ID of a row in a relation table with specific content
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
	
	
	//get ID of a row that are in a specific table and column and content in the cell of column in table
	@SuppressWarnings("rawtypes")
	public  List getRowInformationByContentId(long contentId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROW_INFORMATION_BY_CONTENTID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("column", Type.STRING);
			queryObject.addScalar("content", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(contentId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//get ID of a row that are in a specific table and column and content in the cell of column in table
	@SuppressWarnings("rawtypes")
	public  List getRowInformationByRowId(long rowId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROW_INFORMATION_BY_ROWID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("column", Type.STRING);
			queryObject.addScalar("content", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(rowId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
}


