<%@ include file="/html/dcrt/init.jsp" %>

<script  src="<%=request.getContextPath()%>/js/dcrt/jquery-ui.min.js"       type="text/javascript"></script> <!--  jquery-ui.js  imports -->
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script  src="<%=request.getContextPath()%>/js/dcrt/dcrt.js"       type="text/javascript"></script> <!--  dcrt.js  imports -->

<link href="<%=request.getContextPath()%>/css/dcrt/jquery-ui.min.css" rel="stylesheet" type="text/css"> <!-- jquery-ui.css imports -->
<link href="<%=request.getContextPath()%>/css/dcrt/dcrt.css" rel="stylesheet" type="text/css"> <!-- dcrt.css imports -->

<portlet:resourceURL var="ajaxUrlRadio" id="radio" />
<portlet:resourceURL var="ajaxUrlCategory" id="category" />
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
   	    
   	    getRadioInputs();
    	
    	var response = '';
        $.ajax({
		            "method": "POST",
		            "url": '<%=ajaxUrlRadio%>',
		            "data": {
		            	physical: physicalval,
		            	taxon: taxonval,
		            	alive: aliveval,
		            	sequenced: sequencedval
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
    	   
    	category = $("#category").val();
    	
    	categoryChange(category);
    });
});

$(document).ready(function () {
    $("#material").on('change', function () {
    	   
    	category = $("#material").val();
    	
    	categoryChange(category);
    });
});

function categoryChange(category) {
	
	getRadioInputs();
	
	var response = '';
    $.ajax({
	            "method": "POST",
	            "url": '<%=ajaxUrlCategory%>',
	            "data": {
	            	category: category,
	            	physical: physicalval,
	            	taxon: taxonval,
	            	alive: aliveval,
	            	sequenced: sequencedval
	            },
	            success: function(text) {
                    response = text;
                    $("#result").html(response);
                }
               
    });
}

function getRadioInputs() {
	
	physicalval = $("input[name='physical']:checked").val();
	taxonval = $("input[name='taxon']:checked").val();
	aliveval = $("input[name='alive']:checked").val();
	sequencedval = $("input[name='sequenced']:checked").val();
}

$(document).ready(function () {
    $("div#result").on('click', 'button[name=contactButton]', function () {
    	openConfirmDialog("false", $(this));
    });
});

$(document).ready(function () {
    $("div#defaultResult").on('click', 'button[name=contactButton]', function () {
    	openConfirmDialog("true", $(this));
    });
});

function openConfirmDialog(defaultContact, btnId) {
	
	var confirmDialog = $("#dialog-confirm").dialog({
		autoOpen: false,
	    resizable: false,
	    height: "auto",
	    modal: true,
	    close: clearForm,
	    dialogClass: "contact-dialog custom-dialog",
	    buttons: {
	        'Create Ticket': function() {
	        	if ( $("#dialogForm").valid() ) {
	                $( this ).dialog( 'close' );
	                createJiraTicket(defaultContact, btnId);
	            }
	    	},
	        Cancel: function() {
	          	$(this).dialog( "close" );

	    	}
	 	}
	}).dialog('open');
}

function clearForm() {
	//$('#dialogForm').resetForm();	
}

function createJiraTicket(defaultContact, id) {
	
	var btn = $(id);
	var dataCenter = btn.parent().parent().find("span[name='dataCenter']").attr("id");
	
	var contactName = $("input#contactName").val();
	var contactEmail = $("input#contactEmail").val();
	var message = $("textarea#message").val();
	
	if(typeof category != "string") {
		category = "None";
	}
	
	var dataCenterList = new Array;
	var data = $("span[name='dataCenter']");
	if(defaultContact === "true") {
		$.each( data, function( index ) {
			dataCenterList.push($(this).attr("id"));
			console.info("index" + $(this).attr("id"));
		})
	}
	
    $.ajax({
	            "method": "POST",
	            "url": '<%=ajaxUrlContact%>',
	            "data": {
	            	dataCenter: 	dataCenter,
	            	dataCenterList: dataCenterList,
	            	physical: 		physicalval,
	            	taxon: 			taxonval,
	            	alive: 			aliveval,
	            	sequenced: 		sequencedval,
	            	category: 		category,
	            	contactName: 	contactName,
	            	contactEmail: 	contactEmail,
	            	message: 		message
	            },
	            success: function(text) {
                     var response = text;
                     console.info(response);
                     var succcessButton = $("#dialog-success").dialog({
                    	 autoOpen: false,
                    	 resizable: false,
                 	     width: "auto",
                 	     modal: true,
                 	     dialogClass: "contact-dialog custom-dialog custom-dialog-success",
                         buttons: {
                           Ok: function() {
                             $( this ).dialog("close");
                           }
                         }
                       }).dialog('open');
                }
               
    });
}

$(document).ready(function () {
    $("div#result").on('click', "button[name=submissionButton]", function () {
    	
    });
});

$(document).ready(function () {
    $("div#result").on('click', "button[name=detailsButton]", function () {
    	var dataCenter = $(this).parent().parent().find("span[name='dataCenter']").attr("id");
    	var link = "http://www.gfbio.org/about/data-centers#portfolio-" + dataCenter.toLowerCase();
    	window.open (
    		link,
    		'_blank' // open in a new window.
    	);
    });
});

$(document).ready(function () {
	var form = $("#dialogForm");
	form.validate({
		errorPlacement: function(){
            return false;  // suppresses error message text
        },
		rules : {
            contactName : {
				required: true,
	            minlength: 3
			},
			contactEmail : {
                required: true,
                email: true
            },
            contactMessage : {
            	required: true
            }
		}
	});
});
</script>

<%
List<GCategory> categories = DCRTPortlet.getCategoryResearchFieldList();
List<GCategory> materials = DCRTPortlet.getCategoryMaterialList();
%>

<div id="dialog-confirm" title="DCRT Contact Request" style="display: none;">
	<form id="dialogForm">
	    <fieldset>
		    <label for="contactName" style="display: block">Name</label>
		    <input type="text" name="contactName" id="contactName" 
		    placeholder="Name" class="text ui-widget-content ui-corner-all dialogtext">
		    <label for="contactEmail" style="display: block">E-Mail</label>
		    <input type="text" name="contactEmail" id="contactEmail" 
		    placeholder="E-Mail" class="text ui-widget-content ui-corner-all dialogtext">
		    <label for="message" style="display: block">Message</label>
		    <textarea id="message" name="contactMessage" rows="4" cols="100" placeholder="Your Message"></textarea>
	     </fieldset>
     </form>
</div>
<div id="dialog-success" title="Create Ticket" style="display: none;" >
	<span class="ui-icon ui-icon-circle-check" style="float:left; margin:12px 12px 20px 0;" ></span>
	<p>Your JIRA Ticket was successfully created.</p>
</div>

<div class="container-fluid custom" >
	<h1 style="text-align: center;">Data Center Recommendation Tool</h1>
	<div class="row" >
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
					<h4>Please select a category</h4>
					
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
						for(GCategory m : materials) {
						%>
						<option label="<%=m.getName() %>" value="<%=m.getId() %>"><%=m.getName() %> </option>
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
						<img src="/GFBioProject-portlet/images/gfbio_contact.jpg" style="width: 80px;"/>
					</div>
					<div class="col-xs-9 col-sm-5 col-lg-6" style="padding-left: 25px; padding-top: 8px;">
						<span id="GFBio" name="dataCenter" >GFBio Contact</span>
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