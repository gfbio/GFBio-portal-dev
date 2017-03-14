package org.gfbio.sso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;


public class URLBasicAuth {
	private static Log log = LogFactoryUtil.getLog(URLBasicAuth.class);

    @SuppressWarnings("null")
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
            log.info(":: Headers of " + url + " => "
                    + conn.getHeaderFields());
            BufferedReader bufferedReader = new BufferedReader(
            		new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder content = null;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
              content.append(line + "\n");
            }
            bufferedReader.close();
            log.info(content.toString());
            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        } 
    }

}