package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.DataManagementPlan;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
 



public class DataManagementPlanFinderImpl  extends BasePersistenceImpl<DataManagementPlan> implements DataManagementPlanFinder {
	
	public static String FINDER_CLASS_NAME_ENTITY 		= DataManagementPlanFinderImpl.class.getName();
	public static String GET_MAX_ID 					= FINDER_CLASS_NAME_ENTITY + ".getMaxId";

	
	
	//
	@SuppressWarnings("rawtypes")
	public  List getMaxId() {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_MAX_ID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("dmpid", Type.LONG);

			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
}