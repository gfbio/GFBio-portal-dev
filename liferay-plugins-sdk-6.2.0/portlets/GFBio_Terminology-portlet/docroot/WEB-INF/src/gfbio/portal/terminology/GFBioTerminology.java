package gfbio.portal.terminology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;

public class GFBioTerminology extends GenericPortlet {
	protected static final String JSP_VIEW = "/view.jsp";
	static String serverurl = "http://terminologies.gfbio.org/api/terminologies/";
	static String serverurlbeta = "http://terminologies.gfbio.org/api/beta/terminologies/";

	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType(request.getResponseContentType());
		getPortletContext().getRequestDispatcher(JSP_VIEW).include(request,
				response);
	}

	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {

		try {
			response.setContentType("text/html");
			String keyword = request.getParameter("queryString");
			String mode = request.getParameter("mode");
			String terminologies = request.getParameter("terminologies");
			String matchType = request.getParameter("matchType");
			String firstHit = request.getParameter("firstHit");
			String hierarchy = request.getParameter("hierarchy");
			String termuri = request.getParameter("termuri");
			String betaTerminology = request.getParameter("betaTerminology");

			System.out.println(betaTerminology);
			JSONObject json = new JSONObject();
			String query = "";
			// -------------------First tab function------------------------
			if (mode.equals("search")) {
				// search term 
				query = "search?query=" + keyword;
				if (betaTerminology.equals("false")){
					if (!terminologies.trim().equals("")) {
						query += "&terminologies=" + terminologies;
						if (firstHit.equals("true")) query+="&first_hit=true";
					}
					if (matchType.equals("exact")) query+="&match_type=exact";
					System.out.println(query);
					json = HttpGet(serverurl + query);
				}
				else {
					// have only 1 option for beta server now
					query += "&match_type=exact";
					System.out.println(query);
					json = HttpGet(serverurlbeta + query);
				}
			} else if (mode.equals("getTermDetail")) {
				// display more detail on each term in search result
				query = terminologies+"/term?uri="+termuri;
				json.put("termDetail", HttpGet(serverurl + query));
				query = terminologies+"/narrower?uri="+termuri;

				json.put("relatedTerms", HttpGet(serverurl + query));
			} else if (mode.equals("getTermRelated")){
				// consequently called after getTermDetail
				// for related term
				query = terminologies;
				if (hierarchy.equals("narrower")) {
					query+= "/narrower?uri=";
				}else if(hierarchy.equals("allnarrower")) {
					query+= "/allnarrower?uri=";
				}else if(hierarchy.equals("broader")) {
					query+= "/broader?uri=";
				}else {
					query+= "/allbroader?uri=";
				}
				query += termuri;
//				System.out.println(query);
				json = HttpGet(serverurl + query);
			} else if (mode.equals("getDownloadFile")){
				// get file for download in termDetail dialog
				query = keyword;
				if (query.endsWith("csv")){
					json.put("response", HttpGetString(query));
				}
				else{
					json = HttpGet(query);
				}
			}
			// -------------------Second tab function------------------------
			else if (mode.equals("getTerminologiesList")) { 
				// initiate terminology list
				query = "";
				json = HttpGet(serverurl + query);
			} else if (mode.equals("listAllTerm")) {
				// get all term from selected terminology list
				query = terminologies;
				json.put("terminologyInfo", HttpGet(serverurl + query));
				query = terminologies + "/allterms";
				json.put("allTerm", HttpGet(serverurl + query));
			} 
			
			System.out.println(json);
			PrintWriter writer = response.getWriter();
			writer.print(json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JSONObject HttpGet(String query) {
		JSONObject ret = null;
		try {
			URL url = new URL(query);
			System.out.println(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			String out = "";
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				out += output;
			}

			conn.disconnect();
			ret = new JSONObject(out);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return ret;
	}
	public static String HttpGetString(String query) {
		String ret = "";
		try {
			URL url = new URL(query);
			System.out.println(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			String out = "";
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				out += output;
			}

			conn.disconnect();
			ret = out;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return ret;
	}
}
