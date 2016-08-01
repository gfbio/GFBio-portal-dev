package org.gfbio.sso;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;

/**
 * Portlet implementation class registrationForm
 */
public class registrationForm extends GenericPortlet {
	// TODO: retrieve these information from DB
	public static String ldapUri = "";
	public static String admindn = "";
	public static String admincred = "";
	public static String usersContainer = "";

	public static Properties env = new Properties();
	private static Log log = LogFactoryUtil.getLog(registrationForm.class);

	public void init() {
		ldapUri = PropsUtil.get("ldap.base.provider.url");
		usersContainer = PropsUtil.get("ldap.base.dn");
		admindn = PropsUtil.get("ldap.security.principal");
		admincred = PropsUtil.get("ldap.security.credentials");
		log.info(ldapUri);
		log.info(usersContainer);
		log.info(admindn);
		log.info(admincred);

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapUri);
		env.put(Context.SECURITY_PRINCIPAL, admindn);
		env.put(Context.SECURITY_CREDENTIALS, admincred);

		viewTemplate = getInitParameter("view-template");

	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
//		User user = (User) renderRequest.getAttribute(WebKeys.USER);
//		if (user != null) {
//			if (!user.getFirstName().equals(null))
//				renderRequest.setAttribute("firstname", user.getFirstName());
//			else
//				renderRequest.setAttribute("firstname", "");
//			if (!user.getLastName().equals(null))
//				renderRequest.setAttribute("lastname", user.getLastName());
//			else
//				renderRequest.setAttribute("lastname", "");
//			if (user.getFirstName().equals(null)|| user.getLastName().equals(null) 
//					|| user.getEmailAddress().equals(null)){
//				renderRequest.setAttribute("submit", "disabled=\"true\"");
//				renderRequest.setAttribute("email", "");
//			}else{
//				renderRequest.setAttribute("email", user.getEmailAddress());
//			}
//		}
		include(viewTemplate, renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		User user = (User) actionRequest.getAttribute(WebKeys.USER);

		String password = actionRequest.getParameter("passwordform");

		try {

			boolean userAdded = addUser(user, password);
			if (userAdded) {
				String successMsg = "Account updated Successfully!";
				SessionMessages.add(actionRequest, "request_processed",
						successMsg);
			}

		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;

	private boolean addUser(User user, String password) throws Exception {

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
		pwd.add(encrypt(password));
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
			NamingEnumeration<?> resp = ctx.search(usersContainer, "(mail="
					+ user.getEmailAddress() + ")", constraints);
			while (resp.hasMore()) {
				SearchResult res = (SearchResult) resp.next();
				log.info(res.getName());
				log.warn("user exists!");
				ctx.modifyAttributes(fullCN, DirContext.REPLACE_ATTRIBUTE,
						attrs);
				return true;
			}

			ctx.createSubcontext(fullCN, attrs);
			log.info("AddUser: added entry " + fullCN + ".");
			log.info(attrs);
			return true;
		} catch (NamingException e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			ctx.close();
		}
		return false;
	}

	public static String encrypt(String pwdPlainText) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(pwdPlainText.getBytes("UTF8"));

		byte byteData[] = md.digest();
		String result = "{SHA}" + Base64.encode(byteData);
		log.info("userpassword in LDAP:" + result);
		return result;
	}
}
