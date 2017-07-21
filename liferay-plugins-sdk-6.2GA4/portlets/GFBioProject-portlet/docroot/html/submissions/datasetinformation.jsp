<%@page import="com.google.gson.stream.JsonReader"%>
<%@page import="org.gfbio.service.ResearchObjectLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %> <!-- library imports -->

<portlet:defineObjects />

 Hallooooooooo
 Long userId; 
 userId = <%=session.getAttribute("sessionId") %>
 
JSONArray requestJson = new JSONArray();
requestJson.put("researchobjectid", 70101);
requestJson.put("kindofresponse", "extended");


System.out.println(ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(requestJson));
  
<br/>
<br/>

 <%

	JSONObject requestJson = new JSONObject();
	requestJson.put("researchobjectid", 70101);
	requestJson.put("kindofresponse", "extended");

	JSONObject  researchObject = new JSONObject();

try{researchObject=(JSONObject)ResearchObjectLocalServiceUtil.getResearchObjectAsJsonById(requestJson);
	}catch(Exception e){System.out.println("Error"+e.toString());}

    String extendDataString = (String) researchObject.get("extendeddata");
    JSONObject  extendData = new JSONObject();
    JSONParser parser = new JSONParser();
	try {extendData = (JSONObject) parser.parse(extendDataString);}
	catch (ParseException e) {e.printStackTrace();}
	Object[] extendDataKeySet = (extendData.keySet()).toArray();

    String firstcolum = "30%";
    String secoundcolum = "2%";
    String thirdcolum = "65%";
%>

<%= researchObject%><br>
<br>
<%= extendData%>

		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Title </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("name") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Description </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("description") %>	</span>
		</div >

		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Label </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("label") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Version </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=researchObject.get("researchobjectversion") %>	</span>
		</div >
		
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Last modification date </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=researchObject.get("lastmodifieddate") %>
</span>
		</div >
		
		
		
		<!--  better for the extendedData is a loop over all key of
extendedData, for example David sent us more extended data as only data
collection time publications and embargo-->
		<div 	  class='control-group'>
			<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Data collection time </span>
			<span style='width:<%=secoundcolum %>; display:inline-block'></span>
			<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=extendData.get("datacollectiontime") %>
</span>
		</div >
		
		
<%-- 		<hr>
		
		<%for (int i =0;i<extendDataKeySet.length;i++){ %>
			<% if (extendData.get(extendDataKeySet[i].toString())!=null){ %>
				<div 	  class='control-group'>
					<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'
> <%=extendDataKeySet[i].toString() %> </span>
					<span style='width:<%=secoundcolum %>; display:inline-block'></span>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=extendData.get(extendDataKeySet[i].toString() ) %>	</span>
				</div >
			<%} %>
		<%} %>
		
		<hr> --%>
		
		<!--  optional parameter and extended data-->
		<% if (extendData.get("embargo")!=null){ %>
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Embargo </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	><%=extendData.get("embargo") %>	</span>
			</div >
		<%} %>
		
		
		
		<!--  optional parameter and extended data-->
		
			<div 	  class='control-group'>
				<span style='width:<%=firstcolum %>; display:inline-block;
font-weight:bold' class='field-description'	>Parental Dataset ID </span>
				<span style='width:<%=secoundcolum %>; display:inline-block'></span>
				<% if (researchObject.get("parentresearchobjectid")!=null){ %>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'
> <%=researchObject.get("parentresearchobjectid") %>	</span>
				<%}else{ %>
					<span style='width:<%=thirdcolum %>; display:inline-block'
class='field-description'	>N/A	</span>
				<%} %>
			</div >

