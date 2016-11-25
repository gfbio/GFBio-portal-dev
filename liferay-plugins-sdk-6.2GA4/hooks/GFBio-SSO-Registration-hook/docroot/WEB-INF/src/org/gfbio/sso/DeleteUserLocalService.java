package org.gfbio.sso;

import com.liferay.portal.service.UserLocalServiceWrapper;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;

public class DeleteUserLocalService extends UserLocalServiceWrapper {

	public static Properties env = new Properties();
	private static Log log = LogFactoryUtil.getLog(DeleteUserLocalService.class);
	public static String ldapUri = "";
	public static String admindn = "";
	public static String admincred = "";
	public static String usersContainer = "";

	public DeleteUserLocalService(UserLocalService userLocalService) {
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
	public com.liferay.portal.model.User deleteUser(long userId)
			throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			User user = getUserById(userId);
			String cn = user.getScreenName();
			String fullCN = "cn=" + cn + "," + usersContainer;
			log.info(fullCN);
			DirContext ctx = new InitialDirContext(env);
			log.info("delete user from LDAP");
			ctx.destroySubcontext(fullCN);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		log.info("delete user from Portal");
		return super.deleteUser(userId);
	}
}