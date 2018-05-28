package org.gfbio.idmg.jiraclient;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gfbio.idmg.jiraclient.connection.Communicator;
import org.gfbio.idmg.jiraclient.connection.HTTPConnectionFactory;
import org.gfbio.idmg.jiraclient.connection.HTTPResponse;
import org.gfbio.idmg.jiraclient.model.Issue;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class JIRAApi {

	private static Log _log = LogFactoryUtil.getLog(JIRAApi.class);
	
	private final Communicator client;
	private final Gson gson;

    public final static String CREATE_TICKET_ENDPOINT = "/rest/api/2/issue/";
    public final static String LOGIN = "Gfbio-outreach:gfbio_2016";

    /**
     * Provide a client instance with matching configuration
     *
     * @param client
     */
    public JIRAApi(Communicator client) {
        this.client = client;
        this.gson = new Gson();
    }
    
    public String createDataCenterTicket(Issue issue) throws IOException {
    	
    	byte[] encodedBytes = Base64.encodeBase64(LOGIN.getBytes());
    	String json = gson.toJson(issue);
    	_log.info(json);
    	HTTPResponse response = client.putJson(CREATE_TICKET_ENDPOINT, HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), json);
    	_log.info("Response: " + response.getResponse());
    	return response.getResponse();
    }
    
    public boolean addAttachmentToIssue(String issueKey, String path) throws IOException {
    	
    	String auth = new String(Base64.encodeBase64(LOGIN.getBytes()));
    	
    	//HTTPResponse response = client.attachFile(CREATE_TICKET_ENDPOINT + issueKey + "/attachments", HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), path);
    	
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(CREATE_TICKET_ENDPOINT + issueKey + "/attachments");
        httppost.setHeader("X-Atlassian-Token", "nocheck");
        httppost.setHeader("Authorization", "Basic "+auth);
        
        MultipartEntityBuilder builder = MultipartEntityBuilder.create(); 
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        FileBody fileBody = new FileBody(new File(path));
        builder.addPart("file", fileBody);

        HttpEntity entity = builder.build();
        httppost.setEntity(entity);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httppost);
        } catch (ClientProtocolException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        HttpEntity result = response.getEntity();

        if(response.getStatusLine().getStatusCode() == 200) {
        	return true;
        } else {
        	_log.error("Attachment for issue " + issueKey + " could not been uploaded");
        	return false;
        }
    }
}
