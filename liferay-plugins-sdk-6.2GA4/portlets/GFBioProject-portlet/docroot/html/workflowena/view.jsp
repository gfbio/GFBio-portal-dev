

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
    
			
<%@ include file="/html/workflowena/init.jsp" %> <!-- library imports --> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"         integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<title>GFBio | Molecular Data Submission</title>
		

<link href="//c103-171.cloud.gwdg.de/static/ui/molecular/main.css" rel="stylesheet">
		


<%if (PortalUtil.getUser(request)==null){ %>
	

			<div class="portlet-msg-alert" style='margin-left:25%; margin-right:25%; margin-top:40px'>
				Only logged in users get access to the different submission workflows. Please <a href="<%=PortalUtil.getPortalURL(request) %>/sign-in"><span style="color:#006400; font-weight:bold">sign in</span></a> to continue the process. 
			</div>
<%}else { %>
   

		<div id="ui-molecular-data-submission"
		     userid="<%=PortalUtil.getUserId(request) %>" token="<%=WorkflowENAPortlet.getServerToken(getServletContext().getRealPath("/"),"token") %>"
		     style="margin-top: 100px;">
		</div> 
   
	

<%} %>


<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"		integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7"		crossorigin="anonymous"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"		crossorigin="anonymous"></script>
<script type="text/javascript" src="//c103-171.cloud.gwdg.de/static/ui/molecular/main.js"></script>

<!-- <script type="text/javascript" src="https://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.js"></script> -->
