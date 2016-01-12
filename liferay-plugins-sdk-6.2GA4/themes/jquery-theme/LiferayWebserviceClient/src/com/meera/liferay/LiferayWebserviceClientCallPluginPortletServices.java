package com.meera.liferay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
public class LiferayWebserviceClientCallPluginPortletServices {
	public static void main(String[] args) throws ClientProtocolException,
	IOException {
	ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	HttpHost targetHost = new HttpHost("localhost", 8080, "http");
	DefaultHttpClient httpclient = new DefaultHttpClient();
	BasicHttpContext ctx = new BasicHttpContext();
	// Plugin Context Use for Liferay 6.1
	HttpPost post = new HttpPost("/LiferayJSONWebservices-portlet/api/jsonws/employee/get-employee");
	Base64 b = new Base64();
	String encoding = b.encodeAsString(new String("test@liferay.com:test").getBytes());
	post.setHeader("Authorization", "Basic " + encoding); 
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	params.add(new BasicNameValuePair("emplyeeId", "30722"));
	UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
	post.setEntity(entity);
	HttpResponse resp = httpclient.execute(targetHost, post, ctx);
	resp.getEntity().writeTo(System.out);
	httpclient.getConnectionManager().shutdown();
	}

}






