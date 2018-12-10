

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
 <% ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); %> 
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
    
			
<%@ include file="/html/workflowena/init.jsp" %> <!-- library imports --> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"         integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<title>GFBio | Molecular Data Submission</title>
		

<!-- <link href="//c103-171.cloud.gwdg.de/static/ui/molecular/main.css" rel="stylesheet">-->
<link href="https://submission.gfbio.org/static/ui/molecular/main.css" rel="stylesheet">
		


<%if (PortalUtil.getUser(request)==null){ %>
	<!-- <div class="portlet-msg-alert" style='margin-left:25%; margin-right:25%; margin-top:40px'>
				Only logged in users get access to the different submission workflows. Please <a href="<%=PortalUtil.getPortalURL(request) %>/sign-in?saveLastPath=0"><span style="color:#006400; font-weight:bold">sign in</span></a> to continue the process. 
			</div>
		--> 
			<!--<script> window.location.href="<%=PortalUtil.getPortalURL(request) %>/<%=PropsUtil.get("submission.NotLoggedIn.page.url") %>" </script>--> 
			<!--  <script> window.location.href="<%=PortalUtil.getPortalURL(request) %>/notloginuser" </script>-->
			<% 
String footerContent = "";
//String pageName="footer";
String pageName = com.liferay.portal.kernel.util.PropsUtil.get("login.required.webcontent");

try{ 
	JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), pageName);
	String articleId = journalArticle.getArticleId();
	JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(themeDisplay.getScopeGroupId(),articleId, "","",themeDisplay);
 	footerContent = articleDisplay.getContent();
} catch (Exception e){
	footerContent = "Sorry, there is no web content with this "+ pageName;
	

}

%>
<%=footerContent%>

<%}else { %>
   

		<div id="ui-molecular-data-submission"
		     userid="<%=PortalUtil.getUserId(request) %>" token="<%=PropsUtil.get("jira.gfbio.submission.brokeragenttoken") %>"
		     style="margin-top: 100px;">
		</div> 
   
	

<%} %>


<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"		integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7"		crossorigin="anonymous"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"		crossorigin="anonymous"></script>
<!--<script type="text/javascript" src="//c103-171.cloud.gwdg.de/static/ui/molecular/main.js"></script>-->
<script type="text/javascript" src="https://submission.gfbio.org/static/ui/molecular/main.js"></script>


<!-- <script type="text/javascript" src="https://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.js"></script> -->
