package org.gfbio.sso;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;

public class LDAPUserAccount {

	public static Properties env = new Properties();
	private static Log log = LogFactoryUtil.getLog(LDAPUserAccount.class);
	public static String ldapUri = "";
	public static String admindn = "";
	public static String admincred = "";
	public static String usersContainer = "";
	
	public static void init(){
		ldapUri = PropsUtil.get("ldap.base.provider.url");
		usersContainer = PropsUtil.get("ldap.base.dn");
		admindn = PropsUtil.get("ldap.security.principal");
		admincred = PropsUtil.get("ldap.security.credentials");
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapUri);
		env.put(Context.SECURITY_PRINCIPAL, admindn);
		env.put(Context.SECURITY_CREDENTIALS, admincred);
	}

	public static boolean LDAPaddUser(User user, String password) throws Exception {

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
				return true;
			}
			//log.info("check point x");
			ctx.createSubcontext(fullCN, attrs);
			log.info("AddUser: added entry x " + fullCN + ".");
//			UserLocalServiceUtil.updatePasswordManually(user.getUserId(), password, false, false, new java.util.Date());
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

	
/*	public boolean isReservedEmail(User user) throws Exception {
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
	}*/
}
