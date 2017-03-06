package org.gfbio.service.persistence;


import java.util.List;

import org.gfbio.model.Submission;
import org.gfbio.model.impl.SubmissionImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


public class SubmissionFinderImpl  extends BasePersistenceImpl<Submission> implements SubmissionFinder{
	
	public static String FINDER_CLASS_NAME_ENTITY							= SubmissionFinderImpl.class.getName();
	public static String GET_ARCHIVE_BY_ID									= FINDER_CLASS_NAME_ENTITY + ".getArchiveById";	
	public static String GET_ARCHIVEPIDS_OF_ENA								= FINDER_CLASS_NAME_ENTITY + ".getArchivePIdsOfENA";
	public static String GET_ARCHIVEPIDS_WITH_TYPE_OF_ENA					= FINDER_CLASS_NAME_ENTITY + ".getArchivePIdsWithTypeOfENA";
	public static String GET_CHECK_OF_BROKERSUBMISSIONID					= FINDER_CLASS_NAME_ENTITY + ".getCheckOfBrokerSubmissionId";
	public static String GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION			= FINDER_CLASS_NAME_ENTITY + ".getCheckOfResearchObjectIdAndVersion";
	public static String GET_LATEST_SUBMISSION_BY_IDS						= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionByIds";	
	public static String GET_LATEST_SUBMISSIONS								= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissions";	
	public static String GET_LATEST_SUBMISSIONS_BY_ARCHIVE					= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionsByArchive";		
	public static String GET_LATEST_SUBMISSIONS_BY_RESEARCHOBJECTID			= FINDER_CLASS_NAME_ENTITY + ".getLatestSubmissionsByResearchObjectId";			
	public static String GET_RESEARCHOBJECTVERSION							= FINDER_CLASS_NAME_ENTITY + ".getResearchObjectVersion";	
	public static String GET_LATEST_X_PUBLIC_SUBMISSIONS_BY_X				= FINDER_CLASS_NAME_ENTITY + ".getLatestXPublicSubmissionsByX";
	public static String GET_STATUS_BY_IDS									= FINDER_CLASS_NAME_ENTITY + ".getStatusByIds";	
	public static String GET_SUBMISSION										= FINDER_CLASS_NAME_ENTITY + ".getSubmission";	
	public static String GET_SUBMISSIONID_BY_IDS							= FINDER_CLASS_NAME_ENTITY + ".getSubmissionIdByIds";	
	public static String GET_SUBMISSIONIDS_BY_RESEARCHOBJECTID_AND_VERSION	= FINDER_CLASS_NAME_ENTITY + ".getSubmissionIdsByResearchObjectIdAndVersion";
	
//
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getArchiveById(long submissionId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ARCHIVE_BY_ID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("archive", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(submissionId);
			
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
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
	

	//check submission entity for a specific brokersubmissionid. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfBrokerSubmissionId(String brokersubmissionid) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_BROKERSUBMISSIONID);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(brokersubmissionid);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//check entity table for a specific research object. If this in the relation table, then 'check' is true, else 'check' is wrong.
	@SuppressWarnings({  "unchecked" })
	public List<Boolean> getCheckOfResearchObjectIdAndVersion(long researchObjectId, int researchObjectVersion) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_CHECK_OF_RESEARCHOBJECTID_AND_VERSION);
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			queryObject.addScalar("check", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			return (List<Boolean>) queryObject.list();
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Submission> getLatestSubmissionByIds(long researchObjectId, String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSION_BY_IDS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(archive);
			
			return (List<Submission>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Submission> getLatestSubmissions() {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			
			return (List<Submission>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Submission> getLatestSubmissionsByArchive(String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS_BY_ARCHIVE);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(archive);
			
			return (List<Submission>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "unchecked" })
	public List<Submission> getLatestSubmissionsByResearchObjectId(long researchObjectId) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_SUBMISSIONS_BY_RESEARCHOBJECTID);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			
			return (List<Submission>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings("unchecked")
	public List<Submission> getLatestXPublicSubmissionsByX(int latestX) {
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LATEST_X_PUBLIC_SUBMISSIONS_BY_X);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(latestX);
			
			return (List<Submission>) queryObject.list();
			
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
	public List<Submission> getSubmission(long researchObjectId, int researchObjectVersion, String archive) {
		
		Session session = null;
		try {
		
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SUBMISSION);
			
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addEntity("Submission", SubmissionImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			qPos.add(archive);
			return (List<Submission>) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	
	//
	@SuppressWarnings({  "rawtypes" })
	public List getSubmissionIdByIds(long researchObjectId, int researchObjectVersion, String archive) {
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SUBMISSIONID_BY_IDS);
		
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("submissionid", Type.LONG);
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
	@SuppressWarnings("rawtypes")
	public List getSubmissionIdsByResearchObjectIdAndVersion (long researchObjectId, int researchObjectVersion){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SUBMISSIONIDS_BY_RESEARCHOBJECTID_AND_VERSION);
		
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			
			queryObject.addScalar("submissionid", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(researchObjectId);
			qPos.add(researchObjectVersion);
			return (List) queryObject.list();
			
		} catch (Exception e) {e.printStackTrace();}
		finally {
			closeSession(session);
		}
		return null;
	}
	
	


}
