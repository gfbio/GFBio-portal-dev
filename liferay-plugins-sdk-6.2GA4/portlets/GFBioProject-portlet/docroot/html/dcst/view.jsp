<%@ include file="/html/dcst/init.jsp" %>

<script  src="<%=request.getContextPath()%>/js/dcst/dcst.js"       type="text/javascript"></script> <!--  dcst.js  imports -->
<script  src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"       type="text/javascript"></script>  
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet" type="text/css"> <!-- main.css imports -->


<style>
	li .aui .control-group {
		margin-bottom: 0px !important;
	}
</style>

<%
List<GCategory> categories = new ArrayList<GCategory>();
categories = DCSTPortlet.getCategoryList();
%>

<portlet:resourceURL var="ajaxUrl" id="radio" />
<portlet:resourceURL var="ajaxUrl2" id="category" />
			
<script type="text/javascript" >
$(document).ready(function () {
    $("input[type='radio']").click(function (callback) {
    
    	   	
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
        
    	var response = '';
        $.ajax({
		            method: 'post',
		            url: '<%=ajaxUrl%>',
		            data: {
		            	physical: physicalval,
		            	taxon: taxonval,
		            	alive: aliveval,
		            	sequenced: sequencedval
		            },
		            success: function(text) {
	                     response = text;
	                     document.getElementById("result").innerHTML = response;
	                }
	               
        });
    });
});

$(document).ready(function () {
    $(document.getElementById("researchfield")).on('change', function (callback) {
    
    	var e = document.getElementById("researchfield");
    	var value = e.options[e.selectedIndex].value;
    	
    	var response = '';
        $.ajax({
		            method: 'post',
		            url: '<%=ajaxUrl2%>',
		            data: {
		            	val: value
		            },
		            success: function(text) {
	                     response = text;
	                     document.getElementById("categorylist").innerHTML = response;
	                }
	               
        });
    });
});
</script>

<div id="left" style="float: left; margin-right: 20px;">
	
	
	<h3>Selection Field 1</h3>
	
	<ul style="list-style: none; margin: 0 0 10px 0;">
		<li id="physical" style="margin-left: 20px;">
			Do you want to submit physical objects along with your data?
			<div style="display:block;">
				<input name="physical" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleShow('taxon'); hideFirstLevelRight();" />
				Yes
			</div>
			<div style="display:block;">
				<input name="physical" style="margin-bottom: 7px" type="radio" value="false" onClick="hideFirstLevelLeft(); visibleShow('sequenced');" />
				No
			</div>
		</li>
		<li id="taxon" style="margin-left: 20px;" class="swHide">
			Do you have taxon-based or not taxon-based objects additional to your data?
			<div style="display:block;">
				<input name="taxon" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleShow('alive'); visibleHide('selection2');" />
				Taxon-based
			</div>
			<div style="display:block;">
				<input name="taxon" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShow('selection2'); hideSecondLevelLeft();" />
				Non taxon-based
			</div>
		</li>
		<li id="alive" style="margin-left: 20px;" class="swHide">
			Is your object dead or alive?
			<div style="display:block;">
				<input name="alive" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleHide('material');" />
				Alive
			</div>
			<div style="display:block;">
				<input name="alive" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShow('material');" />
				Dead
			</div>
		</li>
		<li id="material" style="margin-left: 20px;" class="swHide">
			Which kind of material would you deliver?
			
		</li>
		<li id="sequenced" style="margin-left: 20px;" class="swHide">
			Do you have primarily sequenced data?
			<div style="display:block;">
				<input name="sequenced" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleHide('selection2');" />
				Yes
			</div>
			<div style="display:block;">
				<input name="sequenced" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShow('selection2');" />
				No
			</div>
		</li>
		
<%-- 		<li style="margin-left: 20px;">
			<portlet:actionURL name="sampleProject" var="sampleURL">
				<portlet:param name="jspPage" value="/html/dcst/view.jsp" />
			</portlet:actionURL>
			<aui:form action="<%= sampleURL.toString() %>" method="post">
				<aui:fieldset>
					<aui:button-row>
			        	<aui:button type="submit" value="Next" />
			        </aui:button-row>
				</aui:fieldset>
			</aui:form>
		</li> --%>
	</ul> 
	 <div id="selection2" class="swHide">
		<h3>Selection Field 2</h3>
		<div id="categorydiv" style="margin-left: 20px;">
			<h4>Select Category</h4>
			<select id="category" name="category" >
				<option label="Select" value="noselection" />
				<%
				for(GCategory c : categories) {
				%>
				<option label="<%=c.getName() %>" value="<%=c.getId()%>" />
				<%
				}
				%>
			</select>
		</div>
	</div>
</div>

<div id="right" style="float: right; width: 50%;">
	<h3>Data Provider Recommendations</h3>

		<div id="result" style="text-align: left">
			No choice has been made
		</div>
</div>

<div id="clear" style="clear: both;" ></div>