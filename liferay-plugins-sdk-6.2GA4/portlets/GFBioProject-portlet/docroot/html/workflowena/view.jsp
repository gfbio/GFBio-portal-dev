<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />


			
	<%@ include file="/html/workflowena/init.jsp" %> <!-- library imports --> 
		
<!-- 	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet" type="text/css"> -->
<%--   	<link href="${pageContext.request.contextPath}/css/ena-widget.css" 					rel="stylesheet" type="text/css">  --%>
<!-- 	<link rel="stylesheet" type="text/css" href="https://colab.mpi-bremen.de/stash/projects/GFBIO/repos/ena_widget/browse/src/assets/css/debug.css?at=refs%2Fheads%2Ffeature%2FGFBIO-1395-remove-css-conflicts&raw"/> -->
		<link rel="stylesheet" type="text/css" href="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.css" />
		
<script type="text/javascript" src="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.js"></script>


   
<div id="please_dont_kill_my_css" ng-app="enaWidget" ng-controller="AppCtrl as appctrl">

<%= WorkflowENAPortlet.getServerToken(getServletContext().getRealPath("/"),"dev")%>
    {{ addToConfig('authorization',  '<%=WorkflowENAPortlet.getServerToken(getServletContext().getRealPath("/"),"dev") %>') }}
    {{ addToConfig('submittingUser', '<%=PortalUtil.getUserId(request) %>')}}

    <enawidget>    </enawidget>
    
    

</div>






