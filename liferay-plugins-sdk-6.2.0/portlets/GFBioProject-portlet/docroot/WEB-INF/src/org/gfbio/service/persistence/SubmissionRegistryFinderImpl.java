package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.SubmissionRegistry;
import org.gfbio.model.impl.SubmissionRegistryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class SubmissionRegistryFinderImpl  extends BasePersistenceImpl<SubmissionRegistry> implements SubmissionRegistryFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY						= SubmissionRegistryFinderImpl.class.getName();
	public static String GET_ARCHIVEPIDS_OF_ENA							= FINDER_CLASS_NAME_ENTITY + ".getArchivePIdsOfENA";
	public static String GET_ARCHIVEPIDS_WITH_TYPE_OF_ENA				= FINDER_CLASS_NAME_ENTITY + ".getArchivePIdsWithTypeOfENA";
	public static String GET_LATEST_SUBMISSION_BY_IDS					= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionByIds";	
	public static String GET_LATEST_SUBMISSIONS							= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissions";	
	public static String GET_LATEST_SUBMISSIONS_BY_ARCHIVE				= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionsByArchive";		
	public static String GET_LATEST_SUBMISSIONS_BY_RESEARCHOBJECTID		= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionsByResearchObjectId";			
	public static String GET_RESEARCHOBJECTVERSION						= FINDER_CLASS_NAME_ENTITY + ".getResearchObjectVersion";	
	public static String GET_STATUS_BY_IDS								= FINDER_CLASS_NAME_ENTITY + ".getStatusByIds";	
	public static String GET_SUBMISSIONREGISTRY							= FINDER_CLASS_NAME_ENTITY + ".getSubmissionRegistry";	


	
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getArchivePIdsOfENA(String  archivePId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ARCHIVEPIDS_OF_ENA);

			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("archive_pid", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(archivePId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getArchivePIdsWithTypeOfENA(String  archivePId, String researchObjectType) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ARCHIVEPIDS_WITH_TYPE_OF_ENA);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("archive_pid", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectType);
			qPos.add(archivePId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<SubmissionRegistry> getLatestSubmissionByIds(long researchObjectId, String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSION_BY_IDS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("SubmissionRegistry", SubmissionRegistryImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(archive);
			
			return (List<SubmissionRegistry>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<SubmissionRegistry> getLatestSubmissions() {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("SubmissionRegistry", SubmissionRegistryImpl.class);
			
			return (List<SubmissionRegistry>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<SubmissionRegistry> getLatestSubmissionsByArchive(String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS_BY_ARCHIVE);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("SubmissionRegistry", SubmissionRegistryImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(archive);
			
			return (List<SubmissionRegistry>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<SubmissionRegistry> getLatestSubmissionsByResearchObjectId(long researchObjectId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS_BY_RESEARCHOBJECTID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("SubmissionRegistry", SubmissionRegistryImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			
			return (List<SubmissionRegistry>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getResearchObjectVersion(long researchObjectId, String archive, String brokerSubmissionId) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RESEARCHOBJECTVERSION);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("researchobjectversion", Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(archive);
			qPos.add(brokerSubmissionId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getStatusByIds(long researchObjectId, int researchObjectVersion, String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_STATUS_BY_IDS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("status", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			qPos.add(archive);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({ "unchecked" })
	public List<SubmissionRegistry> getSubmissionRegistry(long researchObjectId, int researchObjectVersion, String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SUBMISSIONREGISTRY);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("SubmissionRegistry", SubmissionRegistryImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			qPos.add(archive);
			return (List<SubmissionRegistry>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}

}
