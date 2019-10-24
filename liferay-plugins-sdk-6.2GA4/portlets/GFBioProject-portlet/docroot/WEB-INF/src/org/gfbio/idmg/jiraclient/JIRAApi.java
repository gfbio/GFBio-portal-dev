package org.gfbio.idmg.jiraclient;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gfbio.idmg.jiraclient.connection.Communicator;
import org.gfbio.idmg.jiraclient.connection.HTTPConnectionFactory;
import org.gfbio.idmg.jiraclient.connection.HTTPResponse;
import org.gfbio.idmg.jiraclient.model.AttachmentInput;
import org.gfbio.idmg.jiraclient.model.Body;
import org.gfbio.idmg.jiraclient.model.Issue;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class JIRAApi {

	private static Log _log = LogFactoryUtil.getLog(JIRAApi.class);
	
	private final Communicator client;
	private final Gson gson;

	private final String BASE_URL;
	private final String LOGIN;
	
    private static final String CREATE_TICKET_ENDPOINT = "/rest/api/2/issue/";
    private static final String FILE_BODY_TYPE = "file";
    
    private final String PHP_SCRIPT_LOGIN;

    private static final String PHP_SCRIPT_ENDPOINT = "/internal/getorcreateuser.php";
    
    
    /**
     * Provide a client instance with matching configuration
     *
     * @param client
     */
    public JIRAApi(Communicator client) {
        this.client = client;
        
        this.BASE_URL = PropsUtil.get("jira.gfbio.url");
        this.LOGIN = PropsUtil.get("jira.gfbio.login");
        
        this.PHP_SCRIPT_LOGIN = PropsUtil.get("jira.gfbio.phpscript.login"); 

        this.gson = new Gson();
    }
    
    /*
     * Creating jira issue
     */
    public String createDataCenterTicket(Issue issue) throws IOException {
    	
    	byte[] encodedBytes = Base64.encodeBase64(LOGIN.getBytes());
    	String json = gson.toJson(issue);
    	HTTPResponse response = client.putJson(CREATE_TICKET_ENDPOINT, HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), json);
    	return response.getResponse();
    }
    
    /*
     * Adding attachments to a jira issue
     */
    public boolean addAttachments(long issueKey, AttachmentInput... attachments) {
    	
    	String auth = new String(Base64.encodeBase64(LOGIN.getBytes()));
    	
    	//HTTPResponse response = client.attachFile(CREATE_TICKET_ENDPOINT + issueKey + "/attachments", HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), path);
    	
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(BASE_URL + CREATE_TICKET_ENDPOINT + issueKey + "/attachments");
        httppost.setHeader("X-Atlassian-Token", "nocheck");
        httppost.setHeader("Authorization", "Basic "+auth);
        
        MultipartEntityBuilder builder = MultipartEntityBuilder.create(); 
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        for (AttachmentInput attachmentInput : attachments) {
			builder.addPart(FILE_BODY_TYPE, new InputStreamBody(attachmentInput.getInputStream(), attachmentInput.getFilename()));
		}

        HttpEntity entity = builder.build();
        httppost.setEntity(entity);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httppost);
        } catch (IOException e) {
        	_log.error(e);
            return false;
        }
        
        HttpEntity result = response.getEntity();

        if (response.getStatusLine().getStatusCode() == 200) {
        	return true;
        } else {
        	_log.error("Response: " + response.toString());
        	_log.error("Result: " + result);
        	return false;
        }
    }
    
    /*
     * Adding comment to a jira issue
     */
    public boolean addComment(long issueKey, Body message) {
    	
    	byte[] encodedBytes = Base64.encodeBase64(LOGIN.getBytes());
    	String json = gson.toJson(message);
    	_log.info("JSON: " + json);
    	
    	try {
    		HTTPResponse response = client.putJson(CREATE_TICKET_ENDPOINT + issueKey + "/comment", HTTPConnectionFactory.RequestMethod.POST, new String(encodedBytes), json);
    	
	    	if (response.getResponseCode() == 200) {
	        	return true;
	        } else {
	        	_log.error("Response: " + response.toString());
	        	return false;
	        }
    	} catch (IOException e) {
        	_log.error(e);
            return false;
        }
    }
    
    public String getJiraUsername(String goeId, String email, String fullname) {
    	fullname = fullname.replace(" ", "%20");
    	byte[] encodedBytes = Base64.encodeBase64(PHP_SCRIPT_LOGIN.getBytes());
    	String requestUrl = PHP_SCRIPT_ENDPOINT + "?username=" + goeId + "&email=" + email + "&fullname=" + fullname;
    	
    	try {
    		HTTPResponse response = client.put(requestUrl, HTTPConnectionFactory.RequestMethod.GET, new String(encodedBytes));
    		if (response.getResponseCode() == 200) {
	        	return response.getResponse();
	        } else {
	        	_log.error("Response: " + response.toString());
	        	return null;
	        }
    	} catch (IOException e) {
        	_log.error(e);
            return null;
        }
    }
}
