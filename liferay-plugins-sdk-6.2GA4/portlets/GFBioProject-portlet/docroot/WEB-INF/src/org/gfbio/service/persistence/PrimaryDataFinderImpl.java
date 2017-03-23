package org.gfbio.service.persistence;

import java.util.List;

import org.gfbio.model.PrimaryData;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class PrimaryDataFinderImpl extends BasePersistenceImpl<PrimaryData> implements PrimaryDataFinder {

	
	public static String FINDER_CLASS_NAME_ENTITY							 	= PrimaryDataFinderImpl.class.getName();
	public static String GET_CHECK_PRIMARYDATA_EXISTS 							= FINDER_CLASS_NAME_ENTITY + ".getCheckPrimaryDataExists";
	public static String GET_PATH_BY_PRIMARYDATAID	 							= FINDER_CLASS_NAME_ENTITY + ".getPathByPrimaryDataId";


	//check relation table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckPrimaryDataExists(String name, String path) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_PRIMARYDATA_EXISTS);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(name);
			qPos.add(path);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<String> getPathByPrimaryDataId(long primaryDataId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PATH_BY_PRIMARYDATAID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("path", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(primaryDataId);
			return (List<String>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}

}