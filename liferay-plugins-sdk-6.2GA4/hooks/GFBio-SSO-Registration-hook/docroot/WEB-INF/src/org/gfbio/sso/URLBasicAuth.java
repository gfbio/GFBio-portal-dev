package org.gfbio.sso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Locale;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;



public class URLBasicAuth {
	private static Log log = LogFactoryUtil.getLog(URLBasicAuth.class);
    @SuppressWarnings("null")
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