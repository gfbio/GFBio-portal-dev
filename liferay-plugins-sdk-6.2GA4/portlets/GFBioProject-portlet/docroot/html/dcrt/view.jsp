<%@ include file="/html/dcrt/init.jsp" %>

<script  src="<%=request.getContextPath()%>/js/dcrt/dcrt.js"       type="text/javascript"></script> <!--  dcrt.js  imports -->
<link href="<%=request.getContextPath()%>/css/dcrt.css" rel="stylesheet" type="text/css"> <!-- dcrt.css imports -->

<portlet:resourceURL var="ajaxUrlRadio" id="radio" />
<portlet:resourceURL var="ajaxUrlCategory" id="category" />
<portlet:resourceURL var="ajaxUrlMaterial" id="material" />
<portlet:resourceURL var="ajaxUrlContact" id="contact" />
<portlet:resourceURL var="ajaxUrlSubmission" id="submission" />
<portlet:resourceURL var="ajaxUrlDetails" id="details" />
	
<script type="text/javascript" >

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
    

   	    $("#category").val("default");
   	    $("#material").val("default");
   	    
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
    	
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
	                     $("#result").html(response);
	                     //ajaxForContactButtons();
	                     //ajaxForSubmissionButtons();
	                }
        });
    });
});

 
$(document).ready(function () {
    $($("#category")).on('change', function () {
    	   
    	var category = $("#category").val();
    	
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
    	
    	var response = '';
        $.ajax({
		            "method": "POST",
		            "url": '<%=ajaxUrlCategory%>',
		            "data": {
		            	"<portlet:namespace />category": category,
		            	"<portlet:namespace />physical": physicalval,
		            	"<portlet:namespace />taxon": taxonval,
		            	"<portlet:namespace />alive": aliveval,
		            	"<portlet:namespace />sequenced": sequencedval
		            },
		            success: function(text) {
	                     response = text;
	                     $("#result").html(response);
	                     //ajaxForContactButtons();
	                     //ajaxForSubmissionButtons();
	                }
	               
        });
    });
});

$(document).ready(function () {
    $($("#material")).on('change', function () {
    	   
    	var material = $("#material").val();
    	
    	physicalval = $("input[name='physical']:checked").val();
    	taxonval = $("input[name='taxon']:checked").val();
    	aliveval = $("input[name='alive']:checked").val();
    	sequencedval = $("input[name='sequenced']:checked").val();
    	
    	var response = '';
        $.ajax({
		            "method": "POST",
		            "url": '<%=ajaxUrlMaterial%>',
		            "data": {
		            	"<portlet:namespace />material": material,
		            	"<portlet:namespace />physical": physicalval,
		            	"<portlet:namespace />taxon": taxonval,
		            	"<portlet:namespace />alive": aliveval,
		            	"<portlet:namespace />sequenced": sequencedval
		            },
		            success: function(text) {
	                     response = text;
	                     $("#result").html(response);
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

<div class="container-fluid" >
	<h1>Data Center Recommendation Tool</h1>
	<div class="row">
		<div id="left" class="col-md-4" > <!-- style="display: block; float: left; margin-right: 20px; width: 35%; margin-left: 0%;" -->
			
			<div style="margin-bottom: 10px; margin-top: 15px;">
				<div id="physical" name="question" >
					Do you want to submit physical objects along with your data?
					<div style="display:block;">
						<input name="physical" type="radio" value="true" onClick="show('#taxon'); hide('#categorySelection'); hideFirstLevelRight();" />
						Yes
					</div>
					<div style="display:block;">
						<input name="physical" type="radio" value="false" onClick="show('#sequenced'); hide('#materialSelection'); hideFirstLevelLeft();" />
						No
					</div>
				</div>
				<div id="taxon" name="question" class="swHide">
					Do you have taxon-based or not taxon-based objects additional to your data?
					<div style="display:block;">
						<input name="taxon" type="radio" value="true" onClick="show('#alive'); hide('#materialSelection'); " />
						Taxon-based
					</div>
					<div style="display:block;">
						<input name="taxon" type="radio" value="false" onClick="show('#alive'); hide('#materialSelection'); " />
						Non taxon-based
					</div>
				</div>
				<div id="alive" name="question" class="swHide">
					Is your object dead or alive?
					<div style="display:block;">
						<input name="alive" type="radio" value="true" onClick="hide('#materialSelection');" />
						Alive
					</div>
					<div style="display:block;">
						<input name="alive" type="radio" value="false" onClick="show('#materialSelection');" />
						Dead
					</div>
				</div>
				<div id="sequenced" name="question" class="swHide">
					Do you have primarily sequenced data?
					<div style="display:block;">
						<input name="sequenced" type="radio" value="true" onClick="hide('#categorySelection');" />
						Yes
					</div>
					<div style="display:block;">
						<input name="sequenced" type="radio" value="false" onClick="show('#categorySelection');" />
						No
					</div>
				</div>
				
			</div> 
			 <div id="categorySelection" class="swHide">
				<div id="categorydiv" style="margin-left: 20px;">
					<h4>Select Category</h4>
					
					<select id="category" name="category" >
						<option selected="selected" label="Select" value="default" />
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
			<div id="materialSelection" class="swHide">
				<div id="materialdiv" style="margin-left: 20px;">
	 				<h4>Which kind of material would you deliver?</h4>
					
					<select id="material" name="material" >
						<option selected="selected" label="Select" value="default" />
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
		
		<div id="right" class="col-md-8" > <!-- style="display: block; float: left; width: 720px; margin-right: 0%;" -->
			<div>
				<h3 style="text-align: center">Data Center Recommendation</h3>
			</div>
			<div id="result" style="text-align: left">
				No choice has been made
			</div>
		</div>
	</div>
</div>

<div id="clear" style="clear: both;" ></div>