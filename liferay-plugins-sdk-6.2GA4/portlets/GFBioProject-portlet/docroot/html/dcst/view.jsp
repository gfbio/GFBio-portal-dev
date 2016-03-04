<%@ include file="/html/dcst/init.jsp" %>

<liferay-ui:success key="success" message="successfully-saved" />
<liferay-ui:error key="unable-to-create-project" message="unable-to-create-project" />
<liferay-ui:error key="provide-a-name-for-project" message="provide-a-name-for-project" />

<!--  Form to create sample entry -->
<%
/*
actionURL
 - name: zeigt auf die Methode in DCSTPortlet mit gleichem Namen
 - var: dient als Variable in der JSP zum Aufruf als HTTP POST (siehe aui:form)
*/
%>
<portlet:actionURL name="sampleProject" var="sampleProjectURL">
	<portlet:param name="jspPage" value="/html/dcst/view.jsp" />
</portlet:actionURL>

<%
/*
aui:form
 - action: ist die in der actionURL definierte Variable mit dem Link als Ziel
 - method: POST, immer bei Forms die Daten an das Backend senden
 
aui:input - Eingabefeld für eine Variable
 - name: Variablenname im Backend! (hier erforderliche zum Absenden der Form)
*/

List <Project> projectList = new ArrayList<Project>();
projectList = DCSTPortlet.listProjects();
boolean disabled = false;
disabled = !projectList.isEmpty();
%>
Es gibt <%=projectList.size() %> Projekte.

<aui:form action="<%= sampleProjectURL.toString() %>" method="post">
	<aui:fieldset>
		<aui:input name="projectName" id="projectName" label="name-of-project" size="70" maxlength="75">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:button-row>
        	<aui:button type="submit" value="Add Sample Event" disabled="<%=disabled %>" />
        </aui:button-row>
	</aui:fieldset>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="there-are-no-projects" delta="15" >
	<liferay-ui:search-container-results>
		<%		
		results = ListUtil.subList(projectList, searchContainer.getStart(), searchContainer.getEnd());
		total	= projectList.size();
		
		pageContext.setAttribute("results", results);
		pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="org.gfbio.model.Project" keyProperty="projectID" modelVar="project">
		
		<liferay-ui:search-container-column-text name="id" property="projectID" />
		
		<liferay-ui:search-container-column-text name="name" property="name" />
		
		<liferay-ui:search-container-column-text name="label" property="label" />
		
		<liferay-ui:search-container-column-text name="description" property="description" />
		
		<liferay-ui:search-container-column-text name="start-date" property="startDate" />
		
		<liferay-ui:search-container-column-text name="end-date" property="endDate" />

	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

