<input type='hidden' name='csrfmiddlewaretoken' value='HSujo2ODIdggzYB7imfBM4Nh17ZcEp2C' />

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%!RenderResponse renderResponse;%>


<jsp:useBean id="keyWords" class="java.lang.String" scope="request" />

<portlet:defineObjects />
<portlet:resourceURL id="archivingURL" var="archivingURL" escapeXml="false" />
<meta charset="UTF-8">



<%@include file="/init.jsp"%>																		<!--  library imports -->
<script src="${pageContext.request.contextPath}/js/main.js" 	type="text/javascript"></script> 	<!--  jqery.js  imports -->  
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/main.css" type="text/css"	>		<!--  main.css imports -->
 
 
 


 
<!---------------------------------------------------------------------------------------------------------------------------------------->
<!--------------------------------------------            Body           ----------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->




<!------------------------------------------------        Tabs        -------------------------------------------------------------------->
<!---------------------------------------------------------------------------------------------------------------------------------------->


 <%   String redirect = ParamUtil.getString(request, "redirect");%>
<portlet:renderURL var="viewBackURL" />


<div id="myTab">
    <ul class="nav nav-tabs">
        <li class="active"><a href="#tab-1">Data Submission </a></li>
        <li><a href="#tab-2">User Profile </a></li>
        <li><a href="#tab-3">Project Profile </a></li>
        <li><a href="#tab-4">Information </a></li>
    </ul>



    <div class="tab-content">



        <div id="tab-1">
            <liferay-util:include 	page="/html/submission.jsp"	servletContext="<%= application %>">
                <liferay-util:param name="redirect"				value="<%= String.valueOf(redirect) %>" />
            </liferay-util:include>
        </div>

        <div id="tab-2" class="tab-pane">
            <liferay-util:include page="/html/userprofile.jsp"	servletContext="<%= application %>">
                <liferay-util:param name="redirect"	   			 value="<%= String.valueOf(redirect) %>" />
            </liferay-util:include>
        </div>

        <div id="tab-3" class="tab-pane">
            <liferay-util:include page="/html/projectprofile.jsp"	servletContext="<%= application %>">
				<liferay-util:param name="redirect"	value="<%= String.valueOf(redirect) %>" />
            </liferay-util:include>
		 </div>

        <div id="tab-4" class="tab-pane">
            <liferay-util:include page="/html/information.jsp"	servletContext="<%= application %>">
				<liferay-util:param name="redirect"			value="<%= String.valueOf(redirect) %>" />
            </liferay-util:include>
        </div>
    </div>

</div>

<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'

      }
    ).render();
  }
);
</aui:script>








