<%@ include file="/html/dcrt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/idmg/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dcrt/dcrt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/idmg/jquery-ui.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dcrt/dcrt.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dcrt/spinner.css" rel="stylesheet" type="text/css">

<portlet:resourceURL var="ajaxUrlRadio" id="radio" />
<portlet:resourceURL var="ajaxUrlCategory" id="category" />
<portlet:resourceURL var="ajaxUrlContact" id="contact" />
<portlet:resourceURL var="ajaxUrlSubmission" id="submission" />

<script type="text/javascript">

var userEmail = '${email}';
var userName = '${username}';

$( document ).ready(function() {
	$("input[name=physical]").click(function () {
		$("input[name=taxon]").attr("checked", false);
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=alive]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
		$("div#below").show();
	})
	
	$("input[name=alive]").click(function () {
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
		$("input[name=taxon]").attr("checked", false);
	})
	
	$("input[name=taxon]").click(function () {
		$("input[name=sequenced]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})
		
	$("input[name=sequenced]").click(function () {
		$("input[name=taxon]").attr("checked", false);
		$("input[name=alive]").attr("checked", false);
		$("input[name=material]").attr("checked", false);
	})

	$("input[name=physical]").on("click", function (event) {
		$("div#defaultResult").show();
		$("input[name=physical]").off(event);
	})

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

    $("#category").on('change', function () {
    	category = $("#category").val();
    	categoryChange(category);
    });
	
    $("#material").on('change', function () {
    	category = $("#material").val();
    	categoryChange(category);
    });
    
    $("div#result").on('click', 'button[name=contactButton]', function () {
    	openConfirmDialog($(this));
    });
    
    $("div#defaultResult").on('click', 'button[name=contactButton]', function () {
    	openConfirmDialog($(this));
    });

    $("div#defaultResult").on('click', 'button[name=submissionButton]', function () {
    	var link = "https://www.gfbio.org/data/submit/generic";
    	window.open(link, '_self'); //open in the same window
    });
    
    $("div#result").on('click', "button[name=submissionButton]", function(){
		submissionRequest($(this));
	});
    
    $("div#result").on('click', "button[name=detailsButton]", function() {
		var dataCenter = $(this).parent().parent().find(
				"span[name='dataCenter']").attr("id");
		var link = themeDisplay.getPortalURL()
				+ "/about/data-centers#portfolio-"
				+ dataCenter.toLowerCase();
		window.open(link, '_blank'); //open in new window
	});
    
    var form = $("#dialogForm");
	form.validate({
		errorPlacement : function() {
			return false; // suppresses error message text
		},
		rules : {
			contactName : {
				required : true,
				minlength : 3
			},
			contactEmail : {
				required : true,
				email : true
			},
			contactMessage : {
				required : true
			}
		}
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

function openConfirmDialog(btnId) {
	
	var btn = $(btnId);
	var dataCenter = btn.parent().parent().find("span[name='dataCenter']").attr("id");
	console.log("DataCenter: " + dataCenter);
	
	var confirmDialog = $("#dialog-confirm").dialog({
		autoOpen: false,
	    resizable: false,
	    modal: true,
	    close: clearForm,
	    dialogClass: "contact-dialog custom-dialog",
	    title: "DCRT Contact Request for " + dataCenter,
	    buttons: {
	        'Send Message': function() {
	        	if ( $("#dialogForm").valid() ) {
	        		$('#dialogForm').hide();
        			$('#dialogLoader').show();
        			$('#dialog-confirm').dialog('option', 'buttons', {} )
              		createJiraTicket(dataCenter);
        			$('#dialog-confirm').dialog('option', 'buttons', {
        		    	'Ok': function() {
        		        	$(this).dialog('close');
        		    	}
        			});
	            }
	    	},
	        Cancel: function() {
	          	$(this).dialog( "close" );

	    	}
	 	}
	}).dialog('open');
}

function clearForm() {
	//reset input fields and remove validation classes
	var form = $('#dialogForm');
	
	$("input:text", form).each(function() {
		if (Liferay.ThemeDisplay.isSignedIn()) {
			if (this.id == 'contactName') {
				this.value = userName;
			} else if (this.id == 'contactEmail') {
				this.value = userEmail;
			}
		} else {
			this.value = "";
		}
        $(this).removeClass("error valid");
	});
	
	var textarea = $('textarea#message')
	textarea.val("");
    textarea.removeClass("error valid");
    
    $("#dialogForm").show();
    $("#successAnswer").hide();
    $("#errorAnswer").hide();
}

function getDataCenterList() {
	
	var list = []
	var data = $("span[name='dataCenter']");
	console.info("Data: " + data);
	
	$.each( data, function( index ) {
		list.push($(this).attr("id"));
		console.info("index: " + $(this).attr("id"));
	})
	
	return list;
}

function createJiraTicket(dc) {
	
	var dataCenter = dc;
	
	var contactName = $('input#contactName').val();
	var contactEmail = $('input#contactEmail').val();
	var message = $('textarea#message').val();
	
	if(typeof category != "string") {
		category = "None";
	}
	
	var dataCenterList = new Array;
	dataCenterList = getDataCenterList();
	
    $.ajax({
	        "method": "POST",
	        "url": '<%=ajaxUrlContact%>',
			"data" : {
				dataCenter : dataCenter,
				dataCenterList : dataCenterList,
				physical : physicalval,
				taxon : taxonval,
				alive : aliveval,
				sequenced : sequencedval,
				category : category,
				contactName : contactName,
				contactEmail : contactEmail,
				message : message
			},
			success : function(text) {
				answer("#successAnswer", text);
			},
			error : function(text) {
				answer("#errorAnswer", text);
			}
		});
	}

function answer(element, response) {
	//console.info(response);
	sleep(2000).then(function() {
		$("#dialogLoader").hide();
		$(element).show();
	});
}

function sleep (time) {
  	return new Promise(function(resolve) { 
  		return setTimeout(resolve, time);
  	});
}

function submissionRequest(btnId) {
	var btn = $(btnId);
	var dataCenter = btn.parent().parent().find("span[name='dataCenter']").attr("id");
	
	getRadioInputs();
	
	var dataCenterList = new Array;
	dataCenterList = getDataCenterList();
	
	category = $("#category").val();
	if(typeof category != "string") {
		category = "None";
	}
	material = $("#material").val();
	if(typeof material != "string") {
		material = "None";
	}
	
	$.ajax({
        "method": "POST",
        "url": '<%=ajaxUrlSubmission%>',
        "data": {
        	dataCenter : dataCenter,
			dataCenterList : dataCenterList,
        	category: category,
        	material: material,
        	physical: physicalval,
        	taxon: taxonval,
        	alive: aliveval,
        	sequenced: sequencedval
        },
        success: function(text) {
        	var link = text;
        	window.open(link, '_self' // open in the same window.
        			);
        }
       
	});
}
</script>

<div id="dialog-confirm" style="display: none;">
	<form id="dialogForm">
		<fieldset>
			<label for="contactName" style="display: block">Name</label> 
			<input id="contactName" type="text" name="<portlet:namespace />contactName" value="<c:out value="${username}" />"
				placeholder="Name" class="text ui-widget-content ui-corner-all dialogtext"> 
			<label for="contactEmail" style="display: block">E-Mail</label> 
			<input id="contactEmail" type="text" name="<portlet:namespace />contactEmail" value="<c:out value="${email}" />"
				placeholder="E-Mail" class="text ui-widget-content ui-corner-all dialogtext"> 
			<label for="message" style="display: block">Message</label>
			<textarea id="message" name="<portlet:namespace />contactMessage" rows="4" cols="100"
				placeholder="Your Message"></textarea>
		</fieldset>
	</form>
	<div id="dialogLoader" style="display: none">
		<div class="answer-wrapper">
			<svg viewBox="0 0 120 120" version="1.1"
				xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink">
      
			      <symbol id="s--circle">
			        <circle r="10" cx="20" cy="20"></circle>
			      </symbol>
			      
			      <g class="g-circles g-circles--v1">
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>  
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			        <g class="g--circle">
			          <use xlink:href="#s--circle" class="u--circle" />
			        </g>
			      </g>
			  </svg>
		</div>
	</div>
	<div id="successAnswer" style="display: none;">
		<div class="answer-wrapper">
			<img alt="Icon Check"
				src="/GFBioProject-portlet/images/circle-check.png">
			<p>Your message has been successfully sent.</p>
		</div>
	</div>
	<div id="errorAnswer" style="display: none;">
		<div class="answer-wrapper">
			<img alt="Icon Check"
				src="/GFBioProject-portlet/images/circle-close.png">
			<p>Your message could not been sent.</p>
		</div>
	</div>
</div>
	
<div class="container custom">
	<h1>Data Center Recommendation Tool</h1>
	<div class="row">
		<div id="above" class="col-md-12">

			<div style="margin-bottom: 10px; margin-top: 15px;">
				<div id="physical" name="question">
					Do you want to submit physical objects along with your data?
					<div style="display: block;">
						<input name="physical" type="radio" value="true"
							onClick="show('#alive'); hide('#categorySelection'); hideFirstLevelRight();" />
						Yes
					</div>
					<div style="display: block;">
						<input name="physical" type="radio" value="false"
							onClick="show('#sequenced'); hide('#materialSelection'); hideFirstLevelLeft();" />
						No
					</div>
				</div>
				<div id="alive" name="question" class="swHide">
					Is your object dead or alive?
					<div style="display: block;">
						<input name="alive" type="radio" value="true"
							onClick="hide('#materialSelection'); hide('#taxon')" /> 
						Alive
					</div>
					<div style="display: block;">
						<input name="alive" type="radio" value="false"
							onClick="show('#taxon'); hide('#materialSelection');" /> 
						Dead
					</div>
				</div>
				<div id="taxon" name="question" class="swHide">
					Is your object taxon-based?
					<div style="display: block;">
						<input name="taxon" type="radio" value="true"
							onClick="show('#materialSelection'); " /> 
						Yes
					</div>
					<div style="display: block;">
						<input name="taxon" type="radio" value="false" 
							onClick="hide('#materialSelection');" /> 
						No
					</div>
				</div>
				<div id="sequenced" name="question" class="swHide">
					Do you have mainly sequence data?
					<div style="display: block;">
						<input name="sequenced" type="radio" value="true"
							onClick="hide('#categorySelection');" /> 
						Yes
					</div>
					<div style="display: block;">
						<input name="sequenced" type="radio" value="false"
							onClick="show('#categorySelection');" /> 
						No
					</div>
				</div>

			</div>
			<div id="categorySelection" class="swHide">
				<div id="categorydiv" style="margin-left: 20px;">
					Please select a category
					<select id="category" name="category" style="display: block;">
						<option selected="selected" label="Select" value="default">Select</option>
						<c:forEach var="field" items="${researchfields}">
							<option label="<c:out value="${field.name}" />"
								value="<c:out value="${field.id}"/>"><c:out
									value="${field.name}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div id="materialSelection" class="swHide">
				<div id="materialdiv" style="margin-left: 20px;">
					Which kind of material would you deliver?
					<select id="material" name="material" style="display: block;">
						<option selected="selected" label="Select" value="default">Select</option>
						<c:forEach var="material" items="${materials}">
							<option label="<c:out value="${material.name}" />"
								value="<c:out value="${material.id}"/>"><c:out
									value="${material.name}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div id="below" class="swHide col-md-12">
			<div>
				<h3 style="margin-bottom: 20px;">Data Center Recommendation</h3>
			</div>
			<div id="result" style="text-align: left"></div>
			<div id="defaultResult" name="defaultContact"
				style="text-align: left" class="swHide">
				<h4 style="margin-bottom: 20px;">
					Do you need support in selecting a suitable data center or do you
					have further questions concerning data management?
					<br />
					Please use our generic submission or get in contact with us:
				</h4>
				<div class="row dcrttable">
					<div class="col-xs-3 col-sm-2 col-lg-2">
						<img src="/GFBioProject-portlet/images/gfbio_contact.jpg"
							style="width: 80px;" class="img-zoom" />
					</div>
					<div class="col-xs-9 col-sm-6 col-lg-7"
						style="padding-left: 25px; padding-top: 8px;">
						<span id="GFBio" name="dataCenter">German Federation for
							Biological Data (GFBio)</span>
					</div>
					<div class="col-xs-12 col-sm-4 col-lg-3"
						style="text-align: center; padding-top: 8px;">
						<button type="button" value="GFBioContact" name="contactButton"
							class="dcrtbutton contact">Contact</button>
						<button type="button" value="GFBioSubmission" name="submissionButton"
							class="dcrtbutton submission" style="margin-left: -1px;">Submission</button>
							
						<div style="display: inline-block; width: 63px; height: 10px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="clear" style="clear: both;"></div>
