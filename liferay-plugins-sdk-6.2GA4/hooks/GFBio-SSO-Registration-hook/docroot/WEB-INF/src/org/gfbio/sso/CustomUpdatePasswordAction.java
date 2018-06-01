package org.gfbio.sso;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import javax.naming.NamingException;

import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.ServiceContextUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.theme.ThemeDisplay;

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
			ServiceContext serviceContext) throws PortalException, SystemException, UserPasswordException {
		User user = null;
		log.info(":: Hook on addUserWithWorkflow.");
		user = super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId,
				suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext);
		log.info(":: creatorUserId " + creatorUserId);
		if (creatorUserId != super.getDefaultUserId(companyId)) {
			// when an admin user add another user, password is invisible to the
			// new user
			log.info(":: added a user by admin.");
			password1 = user.getPasswordUnencrypted();
			// send a password reset link
			ServiceContext scNewUser = serviceContext;
			long groupId = GroupLocalServiceUtil.getFriendlyURLGroup(companyId, "/guest").getGroupId();
			long plid = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, "/sign-in").getPlid();
			scNewUser.setPlid(plid);

			sendPassword(user.getCompanyId(), user.getEmailAddress(), null, null, null, null, scNewUser);
		}
		boolean isUserAdded = false;
		try {
			isUserAdded = LDAPUserAccount.LDAPaddUser(user, password1);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error(e.toString());
		} catch (NamingException e) {
			e.printStackTrace();
			log.error(e.toString());
		}

		if (isUserAdded) { // create JIRA account
			log.info(":: LDAP user successfully added");
			URLBasicAuth.urlAuth(user.getEmailAddress(), password1);
		}
		return user;
	}

	@Override
	public User updatePassword(long userId, String password1, String password2, boolean passwordReset)
			throws PortalException, SystemException {
		// called when creating a new account, updateUser(hook)
		log.info(":: Hook on updatePassword 1.");
		User user = super.updatePassword(userId, password1, password2, passwordReset);

		if (password1.length() > 0) { // from setting new password
			log.info(":: change password");
			try {
				LDAPUserAccount.LDAPaddUser(user, password1);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.toString());
			}
		}
		return user;
	}

	@Override
	public User updatePassword(long userId, String password1, String password2, boolean passwordReset,
			boolean silentUpdate) throws PortalException, SystemException {
		// called when creating a new account, updateUser(hook)
		log.info(":: Hook on updatePassword 2.");
		User user = super.getUser(userId);
		boolean isVerified = user.getEmailAddressVerified();
		if (isVerified) {
			user = super.updatePassword(userId, password1, password2, passwordReset, silentUpdate);
			if (password1.length() > 0) { // from setting new password
				log.info(":: change password");
				try {
					LDAPUserAccount.LDAPaddUser(user, password1);
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e.toString());
				}
			}
		} else {// prevent re-sending a verification email
				// after adding LDAP user
			log.warn(":: no password update - non verified user");
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
			throws PortalException, SystemException, UserPasswordException {

		log.info(":: Hook on updateUser.");
		User user = super.getUser(userId);
		if (user != null) {
			boolean isVerified = user.getEmailAddressVerified();
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			try {
				if (isVerified || permissionChecker.isOmniadmin()) {
					user = super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset,
							reminderQueryQuestion, reminderQueryAnswer, screenName, emailAddress, facebookId, openId,
							languageId, timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId,
							suffixId, male, birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn, facebookSn, icqSn,
							jabberSn, msnSn, mySpaceSn, skypeSn, twitterSn, ymSn, jobTitle, groupIds, organizationIds,
							roleIds, userGroupRoles, userGroupIds, serviceContext);

					if (newPassword1.length() > 0) { // from setting new
														// password
						log.info(":: change password");
						// update LDAP user without connecting to JIRA
						try {
							LDAPUserAccount.LDAPaddUser(user, newPassword1);
						} catch (Exception e) {
							log.error(e.toString());
							e.printStackTrace();
						}
					}
				} else { // prevent re-sending a verification email after adding
							// LDAP user
					log.warn(":: no user update - non verified user");
				}
			} catch (NullPointerException e) {
				log.warn("Failed to import user " + userId + ".");
			}
		}
		return user;

	}

}