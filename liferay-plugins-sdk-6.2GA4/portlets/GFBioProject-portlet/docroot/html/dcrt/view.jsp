<%@ include file="/html/dcrt/init.jsp" %>

<script  src="<%=request.getContextPath()%>/js/dcrt/dcrt.js"       type="text/javascript"></script> <!--  dcrt.js  imports -->
<script  src="<%=request.getContextPath()%>/js/dcrt/jquery-ui.min.js"       type="text/javascript"></script> <!--  jquery-ui.js  imports -->
<link href="<%=request.getContextPath()%>/css/dcrt/dcrt.css" rel="stylesheet" type="text/css"> <!-- dcrt.css imports -->
<link href="<%=request.getContextPath()%>/css/dcrt/jquery-ui.min.css" rel="stylesheet" type="text/css"> <!-- jquery-ui.css imports -->

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
	$("input[name=physical]").on("click", function (event) {
		$("div#defaultResult").show();
		$("input[name=physical]").off(event);
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
	                }
        });
    });
});

 
$(document).ready(function () {
    $("#category").on('change', function () {
    	   
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
	                }
	               
        });
    });
});

$(document).ready(function () {
    $("#material").on('change', function () {
    	   
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
	                }
	               
        });
    });
});

$(document).ready(function () {
    $("div#result").on('click', 'button[name=contactButton]', function () {
		var btnId = $(this).attr("id");
    	
    	var confirmDialog = $("#dialog-confirm").dialog({
    		autoOpen: false,
    	    resizable: false,
    	    height: "auto",
    	    modal: false,
    	    buttons: {
    	        Yes: function() {
    	          $(this).dialog( "close" );
    	         buttonClickHandler(<%="'" + ajaxUrlContact + "'"%>, btnId);
    	    },
    	        No: function() {
    	          $(this).dialog( "close" );

    	    }
    	 }
    	}).dialog('open');
    });
});

$(document).ready(function () {
    $("div#result").on('click', "button[name=submissionButton]", function () {
    	buttonClickHandler(<%="'" + ajaxUrlSubmission + "'"%>, $(this));
    });
});

$(document).ready(function () {
    $("div#result").on('click', "button[name=detailsButton]", function () {
    	buttonClickHandler(<%="'" + ajaxUrlDetails + "'"%>, $(this));
    });
});

function buttonClickHandler(url, id) {
	
	var btn = $(id);
	buttonValue = btn.attr("value");
	buttonText = btn.html();
	
	dataCenter = btn.parent().parent().find("span[name='dataCenter']").text();
	
    $.ajax({
	            "method": "POST",
	            "url": url,
	            "data": {
	            	"<portlet:namespace />dataCenter": dataCenter,
	            	"<portlet:namespace />physical": physicalval,
	            	"<portlet:namespace />taxon": taxonval,
	            	"<portlet:namespace />alive": aliveval,
	            	"<portlet:namespace />sequenced": sequencedval
	            },
	            success: function(text) {
                     var response = text;
                     //alert("Values: " + text);
                     var succcessButton = $("#dialog-success").dialog({
                    	 autoOpen: false,
                    	 resizable: false,
                 	     height: "auto",
                 	     width: "auto",
                 	     modal: false,
                         buttons: {
                           Ok: function() {
                             $( this ).dialog("close");
                           }
                         }
                       }).html(response).dialog('open');
                }
               
    });
}

</script>

<%
List<GCategory> categories = DCRTPortlet.getCategoryList();
List<GMaterial> materials = DCRTPortlet.getMaterials();
%>

<div id="dialog-confirm" title="Create Ticket" style="display: none;">
	<p><span class="ui-icon ui-icon-contact" style="float:left; margin:12px 12px 20px 0;"></span>Do you want to create a JIRA Ticket?</p>
</div>
<div id="dialog-success" title="Create Ticket" style="display: none;">
	<p><span class="ui-icon ui-icon-circle-check" style="float:left; margin:12px 12px 20px 0;"></span></p>
</div>

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
		
		<div id="right" class="col-md-8" > 
			<div>
				<h3 style="text-align: center; margin-bottom: 20px;">Data Center Recommendation</h3>
			</div>
			<div id="result" style="text-align: left">
				No choice has been made
			</div>
			<div id="defaultResult" name="defaultContact" style="text-align: left" class="swHide">
				<h4 style="margin-bottom: 20px;">No appropriate Data Center found?</h4>
				<div class="row dcrttable">
					<div class="col-xs-3 col-sm-2 col-lg-2">
						<img src="/GFBioProject-portlet/images/contact.jpg" style="width: 80px;"/>
					</div>
					<div class="col-xs-9 col-sm-5 col-lg-6" style="padding-left: 25px; padding-top: 8px;">
						<span>GFBio Contact</span>
					</div>
					<div class="col-xs-12 col-sm-5 col-lg-4" style="text-align: center; padding-top: 8px;">
						<button type="button" value="GFBioContact" name="contactButton" class="dcrtbutton default">Contact</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="clear" style="clear: both;" ></div>