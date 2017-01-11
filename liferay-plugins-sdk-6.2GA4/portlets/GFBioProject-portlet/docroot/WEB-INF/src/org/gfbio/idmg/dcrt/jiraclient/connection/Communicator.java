package org.gfbio.idmg.dcrt.jiraclient.connection;

import org.gfbio.idmg.dcrt.jiraclient.connection.HTTPConnectionFactory.RequestMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Communicator {
	
	private final String REQUESTPROTOCOL;
    private final String REQUESTHOST;
    private final int TIMEOUT;
    
    /**
     * Provide host URL and timeout in milliseconds to wait for response
     */
    public Communicator() {
        
        this.REQUESTPROTOCOL = "https://";
        this.REQUESTHOST = "helpdesk.gfbio.org";
        this.TIMEOUT = 4000;
    }

    /**
     * Call an endpoint using defined request method
     * @param endpoint
     * @param requestMethod
     * @return
     * @throws IOException 
     */
    public HTTPResponse put(String endpoint, RequestMethod requestMethod, String base64login) throws IOException {
        return putJson(endpoint, requestMethod, base64login, null);
    }
    
    /**
     * Write out a JSON formatted String to endpoint
     * @param endpoint
     * @param requestMethod
     * @param content
     * @return
     * @throws IOException 
     */
    public HTTPResponse putJson(String endpoint, RequestMethod requestMethod, String base64login, String content) throws IOException {
        HttpURLConnection httpConnection = HTTPConnectionFactory.getConnection(REQUESTPROTOCOL, base64login, REQUESTHOST, endpoint, requestMethod, TIMEOUT);
        
        if (content != null) {
            HTTPConnectionFactory.setHTTPConnectionContent(httpConnection, content);
        }
        httpConnection.connect();
        
        if (content != null) {
            HTTPConnectionFactory.sendRequestToOpenHTTPConnection(httpConnection, content);
        }
        
        String result = getResponse(httpConnection);
        String responseMessage = httpConnection.getResponseMessage();
        String location = httpConnection.getHeaderField("location");
        HTTPResponse response = new HTTPResponse(httpConnection.getResponseCode(), responseMessage, location, result);
        
        httpConnection.disconnect();
        
        return response;
    }
    
    private String getResponse(HttpURLConnection httpConnection) throws IOException {
        InputStream stream = httpConnection.getInputStream();
        InputStreamReader isReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isReader);
        
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        
        return stringBuilder.toString();
    }
}
