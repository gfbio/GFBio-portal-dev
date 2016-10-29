<%@ include file="/html/dcrt/init.jsp" %>

<script  src="<%=request.getContextPath()%>/js/dcrt/dcrt.js"       type="text/javascript"></script> <!--  dcrt.js  imports -->
<%-- <script  src="<%=request.getContextPath()%>/js/jquery-1.12.3.min.js"       type="text/javascript"></script>   --%>
<link href="<%=request.getContextPath()%>/css/dcrt.css" rel="stylesheet" type="text/css"> <!-- dcrt.css imports -->


<style>
	li .aui .control-group {
		margin-bottom: 0px !important;
	}
</style>

<portlet:resourceURL var="ajaxUrlRadio" id="radio" />
<portlet:resourceURL var="ajaxUrlCategory" id="category" />
<portlet:resourceURL var="ajaxUrlContact" id="contact" />
<portlet:resourceURL var="ajaxUrlSubmission" id="submission" />
<portlet:resourceURL var="ajaxUrlDetails" id="details" />

			
<script type="text/javascript" >

$( document ).ready(function() {
	$("input:radio").attr("checked", false);
	 document.getElementById("category").selectedIndex = 0;
}); 

$( document ).ready(function() {
	$("input[name=physical]").click(function () {
		$("input[name=taxon]").attr("checked", false);
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=alive]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})
	
	$("input[name=taxon]").click(function () {
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=alive]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})
	
	$("input[name=alive]").click(function () {
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})
	
	$("input[name=sequenced]").click(function () {
		$("input[name=taxon]").attr("checked", false);
		$("input[name=alive]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})
}); 


$(document).ready(function () {
	$("input[type='radio']").click(function () {
    

   	    document.getElementById("category").selectedIndex = 0;   	
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
     	console.log(physicalval);
     	console.log(taxonval);
     	console.log(aliveval);
     	console.log(sequencedval);
    	
    	var response = '';
        $.ajax({
		            "method": "POST",
		            "url": "<%=ajaxUrlRadio%>",
		            "data": {
		            	"<portlet:namespace />physical": physicalval,
		            	"<portlet:namespace />taxon": taxonval,
		            	"<portlet:namespace />alive": aliveval,
		            	"<portlet:namespace />sequenced": sequencedval
		            },
		            success: function(text) {
	                     response = text;
	                     document.getElementById("result").innerHTML = response;
	                     //ajaxForContactButtons();
	                     //ajaxForSubmissionButtons();
	                }
        });
    });
});

 
$(document).ready(function () {
    $(document.getElementById("category")).on('change', function () {
    	   
    	var e = document.getElementById("category");
    	var category = e.options[e.selectedIndex].value;
    	
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
    	console.log(physicalval);
     	console.log(taxonval);
     	console.log(aliveval);
     	console.log(sequencedval);
    	
    	var response = '';
        $.ajax({
		            "method": "POST",
		            "url": '<%=ajaxUrlCategory%>',
		            "data": {
		            	"<portlet:namespace />val": category,
		            	"<portlet:namespace />physical": physicalval,
		            	"<portlet:namespace />taxon": taxonval,
		            	"<portlet:namespace />alive": aliveval,
		            	"<portlet:namespace />sequenced": sequencedval
		            },
		            success: function(text) {
	                     response = text;
	                     document.getElementById("result").innerHTML = response;
	                     //ajaxForContactButtons();
	                     //ajaxForSubmissionButtons();
	                }
	               
        });
    });
});

function ajaxForContactButtons () {
    $("button[name=contactButton]").on('click', buttonClickHandler(<%="'" + ajaxUrlContact + "'"%>));
};

function ajaxForSubmissionButtons() {
    $("button[name=submissionButton]").on('click', buttonClickHandler(<%="'" + ajaxUrlSubmission + "'"%>));
};

function ajaxForDetailButtons() {
    $("button[name=detailButton]").on('click', buttonClickHandler(<%="'" + ajaxUrlDetails + "'"%>));
};

function buttonClickHandler(url) {
	
	buttonValue = $(this).attr("value");
	buttonText = $(this).attr("text");
	
	var response = '';
    $.ajax({
	            "method": "POST",
	            "url": url,
	            "data": {
	            	"<portlet:namespace />value": buttonValue,
	            	"<portlet:namespace />text": buttonText,
	            },
	            success: function(text) {
                     response = text;
                     alert("Values: " + text);
                }
               
    });
}

</script>

<%
List<GCategory> categories = DCRTPortlet.getCategoryList();

List<GMaterial> materials = DCRTPortlet.getMaterials();
%>

<div>
	<div id="left" style="display: block; float: left; margin-right: 20px; width: 35%; margin-left: 0%;">
		
		<ul style="list-style: none; margin: 0 0 10px 0;">
			<li id="physical" style="margin-left: 20px;">
				Do you want to submit physical objects along with your data?
				<div style="display:block;">
					<input name="physical" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleShowWithFullId('taxon'); visibleHide('categorySelection'); hideFirstLevelRight();" />
					Yes
				</div>
				<div style="display:block;">
					<input name="physical" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShowWithFullId('sequenced'); visibleHide('materialSelection'); hideFirstLevelLeft();" />
					No
				</div>
			</li>
			<li id="taxon" style="margin-left: 20px;" class="swHide">
				Do you have taxon-based or not taxon-based objects additional to your data?
				<div style="display:block;">
					<input name="taxon" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleShowWithFullId('alive'); visibleHide('materialSelection'); " />
					Taxon-based
				</div>
				<div style="display:block;">
					<input name="taxon" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShowWithFullId('alive'); visibleHide('materialSelection'); " />
					Non taxon-based
				</div>
			</li>
			<li id="alive" style="margin-left: 20px;" class="swHide">
				Is your object dead or alive?
				<div style="display:block;">
					<input name="alive" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleHideWithFullId('materialSelection');" />
					Alive
				</div>
				<div style="display:block;">
					<input name="alive" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShowWithFullId('materialSelection');" />
					Dead
				</div>
			</li>
			<li id="sequenced" style="margin-left: 20px;" class="swHide">
				Do you have primarily sequenced data?
				<div style="display:block;">
					<input name="sequenced" style="margin-bottom: 7px" type="radio" value="true" onClick="visibleHideWithFullId('categorySelection');" />
					Yes
				</div>
				<div style="display:block;">
					<input name="sequenced" style="margin-bottom: 7px" type="radio" value="false" onClick="visibleShowWithFullId('categorySelection');" />
					No
				</div>
			</li>
			
		</ul> 
		 <div id="categorySelection" class="swHide" style="float: left;">
			<div id="categorydiv" style="margin-left: 20px;">
				<h4>Select Category</h4>
				
				<select id="category" name="category" >
					<option selected="selected" label="Select" value="noselection" />
					<%
					for(GCategory c : categories) {
					%>
					<option label="<%=c.getName() %>" value="<%=c.getId()%>"><%=c.getName() %> </option>
					<%
					}
					%>
				</select>
			</div>
		</div>
		<div id="materialSelection" style="float: left;" class="swHide">
			<div id="materialdiv" style="margin-left: 20px;">
 				<h4>Which kind of material would you deliver?</h4>
				
				<select id="material" name="material" >
					<option selected="selected" label="Select" value="noselection" />
					<%
					for(GMaterial m : materials) {
					%>
					<option label="<%=m.toString() %>" value="<%=m %>"><%=m.toString() %> </option>
					<%
					}
					%>
				</select>
			</div>
		</div>
	</div>
	
	<div id="right" style="display: block; float: left; width: 720px; margin-right: 0%;">
		<h3 style="text-align: center">Data Provider Recommendations</h3>
			<div id="result" style="text-align: left">
				No choice has been made
			</div>
	</div>
</div>

<div id="clear" style="clear: both;" ></div>