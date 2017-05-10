package org.gfbio.sso;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.model.UserGroupRole;

public class CustomUpdatePasswordAction extends UserLocalServiceWrapper {

	public static Properties env = new Properties();
	private static Log log = LogFactoryUtil.getLog(CustomUpdatePasswordAction.class);
	public static String ldapUri = "";
	public static String admindn = "";
	public static String admincred = "";
	public static String usersContainer = "";

	public CustomUpdatePasswordAction(UserLocalService userLocalService) {
		super(userLocalService);
		ldapUri = PropsUtil.get("ldap.base.provider.url");
		usersContainer = PropsUtil.get("ldap.base.dn");
		admindn = PropsUtil.get("ldap.security.principal");
		admincred = PropsUtil.get("ldap.security.credentials");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapUri);
		env.put(Context.SECURITY_PRINCIPAL, admindn);
		env.put(Context.SECURITY_CREDENTIALS, admincred);
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
			//log.info(":: updateUser 2");
			log.error(e.toString());
			return null;
		}

		return user;
	}

	@Override
	public User updatePassword(long userId, String password1,String password2, boolean passwordReset)
			throws PortalException, SystemException {
		// called when creating a new account, updateUser(hook)
		log.info(":: Hook on update Password (4 args).");
		User user = super.getUser(userId);
		try {
			boolean isUserAdded = LDAPaddUser(user, password1);
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

	private boolean LDAPaddUser(User user, String password) throws Exception {

		String cn = user.getScreenName();
		List<Organization> organizations = user.getOrganizations();

		Attribute givenName = new BasicAttribute("givenname");
		Attribute surname = new BasicAttribute("sn");
		Attribute email = new BasicAttribute("mail");
		Attribute pwd = new BasicAttribute("userpassword");
		Attribute jobTitle = new BasicAttribute("title");
		Attribute screenName = new BasicAttribute("cn");
		Attribute uid = new BasicAttribute("uid");
		Attribute objclass = new BasicAttribute("objectclass");

		givenName.add(user.getFirstName());
		surname.add(user.getLastName());
		email.add(user.getEmailAddress());
		pwd.add(encryptSHA(password));
		for (int i = 0; i < organizations.size(); i++) {
			log.info("Organizations: " + organizations.get(i).getName());
			jobTitle.add(organizations.get(i).getName());
		}
		screenName.add(cn);
		String strId = Long.toString(user.getUserId());
		uid.add(strId);
		objclass.add("inetOrgPerson");

		DirContext ctx = new InitialDirContext(env);
		String fullCN = "cn=" + cn + "," + usersContainer;
		Attributes attrs = new BasicAttributes(true);

		attrs.put(givenName);
		if (surname.size() > 0) {
			attrs.put(surname);
		} else {
			return false;
		}
		attrs.put(email);
		attrs.put(pwd);
		if (jobTitle.size() > 0) {
			attrs.put(jobTitle);
		}
		attrs.put(screenName);
		attrs.put(uid);
		attrs.put(objclass);

		try {
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

			// check if this user is already exist in LDAP?
			NamingEnumeration<?> resp = ctx.search(usersContainer, "(mail=" + user.getEmailAddress() + ")",
					constraints);
			while (resp.hasMore()) {
				SearchResult res = (SearchResult) resp.next();
				log.info(res.getName());
				log.warn("user exists!");
				ctx.modifyAttributes(fullCN, DirContext.REPLACE_ATTRIBUTE, attrs);

				log.info("updatePasswordManually");
				UserLocalServiceUtil.updatePasswordManually(user.getUserId(), password, false, false,
						new java.util.Date());
				return true;
			}
			//log.info("check point x");
			ctx.createSubcontext(fullCN, attrs);
			log.info("AddUser: added entry x " + fullCN + ".");
			UserLocalServiceUtil.updatePasswordManually(user.getUserId(), password, false, false, new java.util.Date());
			return true;
		} catch (InvalidAttributeValueException e) {
			log.info("AddUser: added entry " + fullCN + " failed.");
			log.info(attrs);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			ctx.close();
		}
		return false;
	}

	public static String encryptSHA(String pwdPlainText) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(pwdPlainText.getBytes(StandardCharsets.US_ASCII));

		byte byteData[] = md.digest();
		String result = "{SHA}" + Base64.getEncoder().encodeToString(byteData);
		log.info("userpassword in LDAP:" + result);
		return result;
	}

	
	public boolean isReservedEmail(User user) throws Exception {
		long companyId = user.getCompanyId();
		String emailAddress = user.getEmailAddress();
		String[] reservedEmailAddresses = PrefsPropsUtil.getStringArray(companyId,
				PropsKeys.ADMIN_RESERVED_EMAIL_ADDRESSES, StringPool.NEW_LINE,
				PropsUtil.getArray(PropsKeys.ADMIN_RESERVED_EMAIL_ADDRESSES));

		for (String reservedEmailAddress : reservedEmailAddresses) {
			if (StringUtil.equalsIgnoreCase(emailAddress, reservedEmailAddress)) {

				return true;
			}
		}
		return false;
	}
}