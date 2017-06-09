package org.gfbio.sso;

import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.service.persistence.UserPersistence;

public class CustomUpdatePasswordAction extends UserLocalServiceWrapper {

	private static Log log = LogFactoryUtil.getLog(CustomUpdatePasswordAction.class);

	public CustomUpdatePasswordAction(UserLocalService userLocalService) {
		super(userLocalService);
		LDAPUserAccount.init();
	}

	@Override // add user with email-validation
	public User addUserWithWorkflow(long creatorUserId, long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName, String emailAddress, long facebookId,
			String openId, Locale locale, String firstName, String middleName, String lastName, int prefixId,
			int suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
			long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException, SystemException {

		log.info(":: Hook on addUserWithWorkflow.");
		try {		
			User user = super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName,
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			log.info(":: creatorUserId "+creatorUserId);
			if (creatorUserId == super.getDefaultUserId(companyId)) {
				boolean isUserAdded = LDAPUserAccount.LDAPaddUser(user, password1);

				if (isUserAdded) { // create JIRA account
					log.info(":: LDAP user successfully added");
					URLBasicAuth.urlAuth(user.getEmailAddress(), password1);
				}
			}else{
				log.info(":: added a user by admin.");
				//TODO: add LDAP user, JIRA account
				//TODO: send a password reset link
//				log.info(user.getPassword());
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			return null;
		}
	}

	/*
	 * @Override public User updatePassword(long userId, String password1,
	 * String password2, boolean passwordReset) throws PortalException,
	 * SystemException { // called when creating a new account, updateUser(hook)
	 * log.info(":: Hook on updatePassword 1."); User user =
	 * super.updatePassword(userId, password1, password2, passwordReset); try {
	 * // log.info(":: "+password1); // boolean isUserAdded =
	 * LDAPUserAccount.LDAPaddUser(user, password1); // if (isUserAdded) { //
	 * log.info(":: LDAP user successfully added"); //
	 * URLBasicAuth.urlAuth(user.getEmailAddress(), password1); // } } catch
	 * (Exception e) { e.printStackTrace(); log.error(e.toString()); } return
	 * user; }
	 */
	@Override
	public User updatePassword(long userId, String password1, String password2, boolean passwordReset,
			boolean silentUpdate) throws PortalException, SystemException {
		// called when creating a new account, updateUser(hook)
		User user = super.getUser(userId);
		boolean isVerified = user.getEmailAddressVerified();
		if (isVerified) {
			user = super.updatePassword(userId, password1, password2, passwordReset, silentUpdate);
		} else {// prevent re-sending a verification email after adding LDAP
				// user
			log.warn(":: no password update - unverified user");
		}
		return user;
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

		log.info(":: Hook on updateUser.");
		try {
			User user = super.getUser(userId);
			if (newPassword1.length() > 0) { // from setting new password
				log.info(":: change password");
				log.info(":: " + newPassword1);
				// update LDAP user without connecting to JIRA
				LDAPUserAccount.LDAPaddUser(user, newPassword1);
			} /*else { // no new password is set
				if (oldPassword.length() > 0) { // add new user
					log.info(":: add new user");
				} else {
					log.info(":: update user without changing password");
				}
			}*/
			boolean isVerified = user.getEmailAddressVerified();
			if (isVerified) {
				user = super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset,
						reminderQueryQuestion, reminderQueryAnswer, screenName, emailAddress, facebookId, openId,
						languageId, timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId, suffixId,
						male, birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn, jabberSn,
						msnSn, mySpaceSn, skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds, roleIds,
						userGroupRoles, userGroupIds, serviceContext);
			} else { // prevent re-sending a verification email after adding
						// LDAP user
				log.warn(":: no user update - unverified user");
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			return null;
		}
	}

}