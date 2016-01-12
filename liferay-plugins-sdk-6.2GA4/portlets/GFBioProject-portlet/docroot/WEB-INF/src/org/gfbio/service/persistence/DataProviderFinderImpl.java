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
	
	public static String FINDER_CLASS_NAME_ENTITY = DataProviderFinderImpl.class.getName();
	public static String GET_DATAPROVIDERID_BY_LABEL = FINDER_CLASS_NAME_ENTITY + ".getDataProviderIdByLabel";
	public static String GET_LABBEL_BY_ID = FINDER_CLASS_NAME_ENTITY + ".getLabelById";


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
			String sql = CustomSQLUtil.get(GET_DATAPROVIDERID_BY_LABEL);

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
}
