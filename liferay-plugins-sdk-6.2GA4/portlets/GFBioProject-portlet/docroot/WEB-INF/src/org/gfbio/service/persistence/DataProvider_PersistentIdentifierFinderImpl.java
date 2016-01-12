package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.DataProvider_PersistentIdentifier;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class DataProvider_PersistentIdentifierFinderImpl  extends BasePersistenceImpl<DataProvider_PersistentIdentifier> implements DataProvider_PersistentIdentifierFinder{

	public static String FINDER_CLASS_NAME_ENTITY = DataProvider_PersistentIdentifierFinderImpl.class.getName();
	public static String GET_DATAPROVIDERIDS = FINDER_CLASS_NAME_ENTITY + ".getDataProviderIds";
	public static String GET_PERSISTENTIDENTIFIERIDS = FINDER_CLASS_NAME_ENTITY + ".getPersistentIdentiferIds";	
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getDataProviderIds(long persistentIdentiferId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_DATAPROVIDERIDS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("gfbio_dataprovider", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(persistentIdentiferId);
			return (List) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "rawtypes" })
	public List getPersistentIdentiferIds(long dataProviderId) {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PERSISTENTIDENTIFIERIDS);

			SQLQuery queryObject = session.createSQLQuery(sql);

			queryObject.setCacheable(false);
			queryObject.addScalar("gfbio_persistentidentifier", Type.LONG);

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