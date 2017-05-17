package org.gfbio.sso;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.model.UserGroupRole;

public class CustomUpdatePasswordAction extends UserLocalServiceWrapper {

	private static Log log = LogFactoryUtil.getLog(CustomUpdatePasswordAction.class);
	
	public CustomUpdatePasswordAction(UserLocalService userLocalService) {
		super(userLocalService);
		LDAPUserAccount.init();
	}

	@Override
	public User updateUser(long userId, String oldPassword, String newPassword1, String newPassword2,
			boolean passwordReset, String reminderQueryQuestion, String reminderQueryAnswer, String screenName,
			String emailAddress, long facebookId, String openId, String languageId, String timeZoneId, String greeting,
			String comments, String firstName, String middleName, String lastName, int prefixId, int suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String smsSn, String aimSn,
			String facebookSn, String icqSn, String jabberSn, String msnSn, String mySpaceSn, String skypeSn,
			String twitterSn, String ymSn, String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds,
			List<UserGroupRole> userGroupRoles, long[] userGroupIds, ServiceContext serviceContext)
			throws PortalException, SystemException {
		// called when login, change password, reset password
		log.info(":: Hook on update user.");
		if (groupIds != null)log.info(":: groupIds:"+Arrays.toString(groupIds));
		if (organizationIds != null)log.info(":: organizationIds:"+Arrays.toString(organizationIds));
		if (roleIds != null)log.info(":: roleIds:"+Arrays.toString(roleIds));
		if (userGroupRoles != null)	log.info(":: userGroupRoles:"+ userGroupRoles.toString());
		if (userGroupIds !=null)log.info(":: userGroupIds:"+Arrays.toString(userGroupIds));

		User user = super.getUser(userId);
		try {
//			if (!isReservedEmail(user)) {
				// If the email is used by the backend (e.g. Portal mail
				// settings), the password should not be updated
//			}
			log.info(":: updateUser "+userId);
				user = super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset,
						reminderQueryQuestion, reminderQueryAnswer, screenName, emailAddress, facebookId, openId,
						languageId, timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId, suffixId,
						male, birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn,
						msnSn, mySpaceSn, skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds, roleIds,
						userGroupRoles, userGroupIds, serviceContext);
				if (newPassword1.trim() != "" && newPassword1 != null) {
					updatePassword(userId, newPassword1,newPassword2, false);
					log.info(":: updatePassword");
				}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			return null;
		}
		return user;
	}
	@Override 
	public User addUserWithWorkflow(long creatorUserId, long companyId, boolean autoPassword, 
    		String password1, String password2, boolean autoScreenName, String screenName, 
    		String emailAddress, long facebookId, String openId, Locale locale, 
    		String firstName, String middleName, String lastName, int prefixId, 
    		int suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, 
    		String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, 
    		long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext) throws PortalException, SystemException {

		log.info(":: Hook on addUserWithWorkflow.");
    	try{
    		
    		User user = super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
    		
			boolean isUserAdded = LDAPUserAccount.LDAPaddUser(user, password1);
			if (isUserAdded){ // create JIRA account
				log.info(":: LDAP user successfully added");
				URLBasicAuth.urlAuth(user.getEmailAddress(), password1);
			}
    		return user;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			return null;
		}
    }

    @Override
    public User addUser(long creatorUserId, long companyId, boolean autoPassword, 
    		String password1, String password2, boolean autoScreenName, String screenName, 
    		String emailAddress, long facebookId, String openId, Locale locale, 
    		String firstName, String middleName, String lastName, int prefixId, 
    		int suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, 
    		String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds, 
    		long[] userGroupIds, boolean sendEmail, ServiceContext serviceContext) throws PortalException, SystemException {

		log.info(":: Hook on add user.");
    	try{
    		
    		User user = super.addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
    		
//			boolean isUserAdded = LDAPUserAccount.LDAPaddUser(user, password1);
//			if (isUserAdded){ // create JIRA account
//				log.info(":: LDAP user successfully added");
//				URLBasicAuth.urlAuth(user.getEmailAddress(), password1);
//			}
    		return user;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			return null;
		}
    }
    
	@Override
	public User updatePassword(long userId, String password1,String password2, boolean passwordReset)
			throws PortalException, SystemException {
		// called when creating a new account, updateUser(hook)
		log.info(":: Hook on update Password (4 args).");
		User user = super.getUser(userId);
		try {
			boolean isUserAdded = LDAPUserAccount.LDAPaddUser(user, password1);
			if (isUserAdded){
				log.info(":: LDAP user successfully added");
				URLBasicAuth.urlAuth(user.getEmailAddress(), password1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		return user;
	}

}