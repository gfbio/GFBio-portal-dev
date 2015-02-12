<%@ page import="javax.portlet.RenderResponse"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%!RenderResponse renderResponse;%>

<portlet:defineObjects />
<portlet:resourceURL id="terminologyURL" var="terminologyURL"
	escapeXml="false" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css"></link>

<script type="text/javascript">
var narrowerHint = "Retrieves the terms that are one level narrower than a given one.";
var allnarrowerHint = "Retrieves all terms that are narrower of a given one including each possible path to the leaves of the hierarchy.";
var broaderHint = "Retrieves the terms that are one level broader than a given one.";
var allbroaderHint = "Retrieves all terms that are broader of a given one including each possible path to the top.";
window.onload=function() {
	$( "#terminologyTabs" ).tabs();
	$.ajax({
		"url": "<%=terminologyURL%>"
		+ "/GFBioTerminology",
		"data" : {
			"<portlet:namespace />mode" : "getTerminologiesList"
		},
		"type" : "POST",

        success : function(d) {
			writeTerminologyMultipleSelection(d);
			writeTerminologySingleSelection(d);
        }
	});
	searchReset();
	 
	 $( "#searchOption" ).dialog({
		 autoOpen: false,
		 height:350,
		 width: 380,
		 modal: true,
		 buttons: {
			 "OK": function(){
				 $( this ).dialog( "close" );
			 },
			 "Reset": function(){
				 searchReset();
			 }
		 },
		 close: function() {
			 $( this ).dialog( "close" );
		 }
	});
	 $( "#termDetail" ).dialog({
		 autoOpen: false,
		 height: 'auto',
		 maxHeight: $(window).height()-200,
		 width: 'auto',
		 maxWidth: $(window).width()-200,
		 show: "slide",
		 modal: true,
		 buttons: {
			 "OK": function(){
				 $( this ).dialog( "close" );
			 }
		 },
		 close: function() {
			 $( this ).dialog( "close" );
		 }
	});
	// show processing mouse while waiting for ajax result
	 $(document).ajaxStart(function ()
	 		{
	 		    $('body').addClass('wait');

	 		}).ajaxComplete(function () {

	 		    $('body').removeClass('wait');

	 		});

		listenToEnterPress();
};


function listTermInfo(){
	var terminology = getSelectedTerminologies("terminologyInfoSelect");
	$.ajax({
			"url": "<%=terminologyURL%>" + "/GFBioTerminology",
				"data" : {
					"<portlet:namespace />mode" : "listAllTerm",
					"<portlet:namespace />terminologies" : encodeURI(terminology)
				},
				"type" : "POST",

				success : function(d) {
					clearContext('search_result');
					clearContext('termDetail');

					writeTerminologyInfo(d,'termInfo_result',terminology);
				}
			});
}

function terminologySearch(){
	var searchTerm = document.getElementById("terminologySearchInput").value;
	var term = getSelectedTerminologies("searchTerminologiesSelect");
	var matchTypeSelect = document.getElementById("matchType");
	var matchType = matchTypeSelect.options[matchTypeSelect.selectedIndex].value;
	var firstHitSelect = document.getElementById("firstHit");
	var firstHit = firstHitSelect.options[firstHitSelect.selectedIndex].value;
	var betaTerminology = document.getElementById("betaServer").checked;

	$.ajax({
		"url": "<%=terminologyURL%>" + "/GFBioTerminology",
			"data" : {
				"<portlet:namespace />mode" : "search",
				"<portlet:namespace />queryString" : encodeURI(searchTerm),
				"<portlet:namespace />terminologies" : encodeURI(term),
				"<portlet:namespace />matchType" : matchType,
				"<portlet:namespace />firstHit" : firstHit,
				"<portlet:namespace />betaTerminology" : betaTerminology
			},
			"type" : "POST",

			success : function(d) {
				clearContext('termInfo_result');
				clearContext('termDetail');
				writeTerminologyResult(d,'search_result');
			}
		});
	}
function showTermDetail(termName, uri,terminology){
	$.ajax({
		"url": "<%=terminologyURL%>/GFBioTerminology",
		"data" : {
			"<portlet:namespace />mode" : "getTermDetail",
			"<portlet:namespace />terminologies" : encodeURI(terminology),
			"<portlet:namespace />termuri" : encodeURI(uri)
		},
		"type" : "POST",

		success : function(d) {
			var jsonDataset = eval("(function(){return " + d
					+ ";})()");
			var termDetail = jsonDataset.termDetail;
			var relatedTerms = jsonDataset.relatedTerms;
			// display term detail
			writeTermsDetail(termName, termDetail,uri, terminology);
			writeRelatedTermsResult(relatedTerms);
			
			// add event listener when scope is changed
			$("#relatedTermsScope").buttonset().change(
					function(e){onScopeTermRelatedChange(e,uri,terminology);});

			$("#termDetail").dialog("open");
			    
		}
	});
}
function onScopeTermRelatedChange(e,termuri,terminology){
	    var hierarchy = e.target.id;
		$.ajax({
			"url": "<%=terminologyURL%>/GFBioTerminology",
			"data" : {
				"<portlet:namespace />mode" : "getTermRelated",
				"<portlet:namespace />terminologies" : encodeURI(terminology),
				"<portlet:namespace />termuri" : encodeURI(termuri),
				"<portlet:namespace />hierarchy" : hierarchy
			},
			"type" : "POST",

			success : function(d) {
				var jsonDataset = eval("(function(){return " + d
						+ ";})()");
				writeRelatedTermsResult(jsonDataset);
			}
		});
	}

function creatLink(uri, terminology) {
	var serverurl = "http://terminologies.gfbio.org/api/terminologies/";
	var formatSelect = document.getElementById("format");
	var format = formatSelect.options[formatSelect.selectedIndex].value;
	var url = serverurl + terminology + "/term?uri=" + uri;
	if (format == "csv"){
		url += "&format=csv";
		SaveToDisk(url,"term.csv");
	}else SaveToDisk(url, "term.json");
}

function SaveToDisk(fileURL, fileName) {
		$.ajax({
			"url": "<%=terminologyURL%>/GFBioTerminology",
			"data" : {
				"<portlet:namespace />mode" : "getDownloadFile",
					"<portlet:namespace />queryString" : encodeURI(fileURL)
			},
			"dataSrc" : "dataset",
			"type" : "POST",
			
	        success : function(data) {
	            var datatype = "text/csv";
	            if (fileName.endsWith('csv')){
	    			var jsonDataset = eval("(function(){return " + data
	    					+ ";})()");
	    			data = jsonDataset.response;
	    			datatype = "application/json";
	            }
	            download(fileName,data, datatype);
	        }	
		});
}
</script>
	
	
<div id="terminologyTabs">
<output></output>
	<ul>
	<li><a href="#termSearchTab">Terminology Search:</a></li>
	<li><a href="#termInfoTab">Terminology Information:</a></li>
	</ul>
	<div id="termSearchTab">
		<label><input id="terminologySearchInput"
			value="lepidoptera" /> <input id="terminologyButton" type="button"
			value="Go!" style="font-weight: bold"
			onclick="javascript:terminologySearch();" /> <a
			href="javascript:showSearchOption();" 
			title="Configuration" class="configIcon" 
			style='display:inline-block; vertical-align:middle;'></a>
			</label>
		<div id="searchOption" title="Search Configuration">
			<table>
				<tr style="vertical-align: top">
					<td>Vocabulary:</td>
					<td><select id="searchTerminologiesSelect" style="width: 100%"
						size="4" multiple="multiple" onchange="excludeFirstOption(this)"
						title="To specify the terminologies to search.">
					</select></td>
				</tr>
				<tr>
					<td>Match type:</td>
					<td><select id="matchType"
						title="Looks for exact and/or partial matches.">
							<option value="included" selected>Included</option>
							<option value="exact">Exact</option>
					</select></td>
				</tr>
				<tr>
					<td>First hit:</td>
					<td><select id="firstHit"
						title="To stop at the first terminology where a match is found.">
							<option value="false" selected>False</option>
							<option value="true">True</option>
					</select></td>
				</tr>
			</table>
		</div>
		<p><input type="checkbox" id="betaServer" value="betaServer"> Search in beta terminology</p>
		
			 
		<div id="search_result"></div>
	</div>
	<div id="termInfoTab">
		<label><select
			id="terminologyInfoSelect" style="width: auto" >
		</select> <input id="getTerminologyInfoButton" type="button" value="Go!"
			style="font-weight: bold; width: auto;" 
			onclick="javascript:listTermInfo();" /></label>
	
		<div id="termInfo_result"></div>
		
		<div id="termDetail" title="Term details:"></div>
	</div>
</div>
<!-- </div> -->
