package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.DataProvider;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
 


public class DataProviderFinderImpl extends BasePersistenceImpl<DataProvider> implements DataProviderFinder {
	
	public static String FINDER_CLASS_NAME_ENTITY 		= DataProviderFinderImpl.class.getName();
	public static String GET_CHECK_OF_LABEL 			= FINDER_CLASS_NAME_ENTITY + ".getCheckOfLabel";
	public static String GET_DATAPROVIDERID_BY_LABEL 	= FINDER_CLASS_NAME_ENTITY + ".getDataProviderIdByLabel";
	public static String GET_LABEL_BY_ID 				= FINDER_CLASS_NAME_ENTITY + ".getLabelById";
	public static String GET_LABELS 					= FINDER_CLASS_NAME_ENTITY + ".getLabels";
	public static String GET_NAME_BY_ID 				= FINDER_CLASS_NAME_ENTITY + ".getNameById";
	public static String GET_MAX_ID 					= FINDER_CLASS_NAME_ENTITY + ".getMaxId";

	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfLabel(String archiv) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_LABEL);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(archiv);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getDataProviderIdByLabel(String label) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_DATAPROVIDERID_BY_LABEL);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("dataProviderID", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(label);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getLabelById(long dataProviderId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LABEL_BY_ID);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("label", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(dataProviderId);
			return (List) queryObject.list();
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
			
			queryObject.addScalar("dataproviderid", Type.LONG);

			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getNameById(long dataProviderId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_NAME_BY_ID);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("name", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(dataProviderId);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getLabels() {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LABELS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("label", Type.STRING);

			//QueryPos qPos = QueryPos.getInstance(queryObject);

			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
}
