package org.gfbio.sso;

import java.net.URL;
import java.net.URLConnection;
import com.liferay.portal.kernel.util.Base64;


public class URLBasicAuth {

    public static void urlAuth(String user, String password) {
        try {
        	
			URL url = new URL("https://helpdesk.gfbio.org/rest/api/2/myself");
			URLConnection conn = url.openConnection();

            String encoding = Base64.encode((user+":"+password).getBytes());
            conn.setRequestProperty("User-Agent", "Mozilla/4.0");
            conn.setRequestProperty("Authorization Basic", encoding);
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.connect();
            System.out.println("Headers of " + url + " => "
                    + conn.getHeaderFields());
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } 
    }

}