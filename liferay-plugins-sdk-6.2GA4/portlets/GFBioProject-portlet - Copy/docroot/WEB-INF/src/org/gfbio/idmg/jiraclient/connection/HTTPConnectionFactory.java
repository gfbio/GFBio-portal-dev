package org.gfbio.idmg.jiraclient.connection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.gfbio.idmg.jiraclient.security.TrustAllCertificates;

public class HTTPConnectionFactory {

	public enum RequestMethod {

        GET, POST, PUT, DELETE
    }

    public static HttpURLConnection getConnection(String requestProtocol, String authorization, String host, String endpoint, RequestMethod requestMethod, int timeout) throws IOException {
        String url = requestProtocol + host + endpoint;
        URL apiUrl = new URL(url);

        if (requestProtocol.equals("https://")) {
        	TrustAllCertificates.run();
            HttpsURLConnection httpsConnection = (HttpsURLConnection) apiUrl.openConnection();
            setHTTPConnectionHeader(httpsConnection, authorization, host, requestMethod, timeout);
            return httpsConnection;
        } else {
            HttpURLConnection httpConnection = (HttpURLConnection) apiUrl.openConnection();
            setHTTPConnectionHeader(httpConnection, authorization, host, requestMethod, timeout);
            return httpConnection;
        }
    }

    private static void setHTTPConnectionHeader(HttpURLConnection httpConnection, String authorization, String host, RequestMethod requestMethod, int timeout) throws ProtocolException {
        httpConnection.setRequestMethod(requestMethod.toString());
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.setRequestProperty("Authorization", "Basic " + authorization);
        httpConnection.setRequestProperty("host", host);
        httpConnection.setReadTimeout(timeout);
        httpConnection.setConnectTimeout(timeout);
    }

    public static void setHTTPConnectionContent(HttpURLConnection httpConnection, String content) throws ProtocolException {
        httpConnection.setRequestProperty("Content-Length", String.valueOf(content.length()));
        httpConnection.setDoOutput(true);
    }

    public static void sendRequestToOpenHTTPConnection(HttpURLConnection httpConnection, String content) throws IOException {
        try (OutputStream writer = httpConnection.getOutputStream()) {
            writer.write(content.getBytes());
            writer.flush();
        }
    }
}
