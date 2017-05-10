package org.gfbio.idmg.jiraclient;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import org.gfbio.idmg.dcrt.DCRTPortlet;
import org.gfbio.idmg.jiraclient.connection.Communicator;
import org.gfbio.idmg.jiraclient.connection.HTTPConnectionFactory;
import org.gfbio.idmg.jiraclient.connection.HTTPResponse;
import org.gfbio.idmg.jiraclient.model.Issue;

public class JIRAApi {

	private static Log _log = LogFactoryUtil.getLog(DCRTPortlet.class);
	
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
    	
    	return response.getResponse();
    }
    
    
}
