package org.gfbio.sso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
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
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

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
		/*log.info(ldapUri);
		log.info(usersContainer);
		log.info(admindn);
		log.info(admincred);*/

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
				UserLocalServiceUtil.updatePasswordManually(user.getUserId(), password, false, false, new java.util.Date());
				String successMsg = "Account updated Successfully! Please sign out and sign in again with your new password.";
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
				urlAuth(user.getEmailAddress(), password);
				return true;
			}

			ctx.createSubcontext(fullCN, attrs);
			log.info("AddUser: added entry " + fullCN + ".");
			log.info(attrs);
			urlAuth(user.getEmailAddress(), password);
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
		md.update(pwdPlainText.getBytes(StandardCharsets.US_ASCII));

		byte byteData[] = md.digest();
		String result = "{SHA}" + Base64.getEncoder().encodeToString(byteData);
		log.info("userpassword in LDAP:" + result);
		return result;
	}

	public static void urlAuth(String user, String password) {
        try {
			URL url = new URL("https://helpdesk.gfbio.org/servicedesk/customer/portal/5");
			HttpURLConnection  conn = (HttpURLConnection) url.openConnection();
			String encoding = Base64.getEncoder().encodeToString((user+":"+password).getBytes(StandardCharsets.US_ASCII));
            conn.setRequestProperty("User-Agent", "GFBio Portal");
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic "+encoding);
            log.info(":: RequestProperties of " + url + " => "
                    + conn.getRequestProperties());
            conn.setUseCaches(false);
            
            conn.connect();
            log.info(":: HeaderFields of " + url + " => "
                    + conn.getHeaderFields());
            checkResponseCode(conn);
            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } 
    }
	   private static boolean checkResponseCode(HttpURLConnection conn) throws IOException, GeneralSecurityException {
	        if (conn.getResponseCode() >= 400) {
	          log.error("JIRA returned an error #" + conn.getResponseCode() + 
	                " (" + conn.getResponseMessage() + ") for url: " + conn.getURL());
	          Charset charset = StandardCharsets.ISO_8859_1;
	          final String contentType = conn.getContentType();
	          // code cloned from ContentStreamBase, but post.jar should be standalone!
	          if (contentType != null) {
	            int idx = contentType.toLowerCase(Locale.ROOT).indexOf("charset=");
	            if (idx > 0) {
	              charset = Charset.forName(contentType.substring(idx + "charset=".length()).trim());
	            }
	          }
	          // Print the response returned
	          try (InputStream errStream = conn.getErrorStream()) {
	            if (errStream != null) {
	              BufferedReader br = new BufferedReader(new InputStreamReader(errStream, charset));
	              final StringBuilder response = new StringBuilder("Response: ");
	              int ch;
	              while ((ch = br.read()) != -1) {
	                response.append((char) ch);
	              }
	              log.info(response.toString().trim());
	            }
	          }
	          if (conn.getResponseCode() == 401) {
	            throw new GeneralSecurityException("JIRA requires authentication (response 401).");
	          }
	          if (conn.getResponseCode() == 403) {
	            throw new GeneralSecurityException("You are not authorized to perform this action against JIRA. (response 403)");
	          }
	          return false;
	        }
	        return true;
	    }

}
