<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/idmg/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/idmg/jquery-ui.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/idmg/spinner.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<portlet:resourceURL var="ajaxUrlWizard" id="wizard" />
<portlet:resourceURL var="ajaxUrlLicense" id="license" />
<portlet:resourceURL var="ajaxUrlSave" id="savedmp" />
<portlet:resourceURL var="ajaxUrlLoad" id="loaddmp" />
<portlet:resourceURL var="ajaxUrlDelete" id="deletedmp" />
<portlet:resourceURL var="ajaxUrlSend" id="senddmp" />

<script type="text/javascript">   

var userEmail = '${email}';
var userName = '${username}';
var contextPath = '${contextPath}';
var userHasDmps = '${hasDmps}';
var portalUrl = '${portalurl}';
var saved = false;

$(document).ready(function () {
	
	// Short regex for small input fields e.g. project name
    $.validator.addMethod('regexshort', function (value, element, parameter) {
    	return !/[^A-Za-z0-9 äöüß´`^\']/.test(value);
    }, 'Following special characters are allowed: äöüß\'´`^');
	
	// Regex for textareas/larger inputs e.g. projact abstract
    $.validator.addMethod('regexlong', function (value, element, parameter) {
    	return !/[^A-Za-z0-9 .,;:\-_!§$%&/()=?äöüß´`^+*#\'\"\t\n]/.test(value);
    }, 'Following special characters are allowed: .,;:\"-_\'!§$%&/()=?äöüß´`^+*#');
    
 	// Regex for urls
    $.validator.addMethod('regexurl', function (value, element, parameter) {
    	var expression = /^$|^[-a-zA-Z0-9@:%_\+.~#?&//=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&//=]*)?/gi;
    	var regex = new RegExp(expression);
    	return value.match(regex);
    }, 'Invalid URL');
	
    var form = $("#dmpt-wizard");
	form.validate({
		errorPlacement : function errorPlacement(error, element) {
			
			if (error.html() == "This field is required.") {
				// Hide required Errors
				error.hide();
			} else if (element.hasClass("before_error")) {
				// Place error before element
				error.insertBefore(element);
			} else if (element.hasClass("parent_error")) {
				// Place error to begin of the parent div
				error.prependTo(element.parent("div"));
			} else {
				// Default
				error.hide();
			}
		},
		rules : {
			//01 General Information
			projectName : {
				required: true,
				regexshort: true,
         		minlength: 3
           	},
           	reproducibleText : {
           		regexlong: true
           	},
           	typesOther : {
           		regexshort: true
           	},
           	projectAbstract : {
           		regexlong: true
           	},
           	responsibleName: {
           		required: true,
           		regexshort: true,
           		minlength: 3
           	},
           	email : {
             	required: true,
             	email: true
           	},
           	phoneNumber : {
           		//required: true,
           		//number: true
           	},
           	investigator : {
           		regexshort: true
           	},
           	fundingLink: {
           		regexurl: true
           	},
           	fundingOther: {
           		regexshort: true
           	},
           	programme: {
           		regexlong: true
           	},
           	policyOther: {
           		regexshort: true
           	},
           	policyLink: {
           		regexurl: true
           	},
          	//02 Data Collection
           	datatypeOther: {
           		regexshort: true
           	},
           	createFormats: {
           		regexlong: true
           	},
           	methodologies: {
           		regexlong: true
           	},
          	//03 Documentation and Metadata
           	metadataDesc: {
           		regexlong: true
           	},
          	//04 Ethics and Legal Compliance
           	requirementOther: {
           		regexshort: true
           	},
           	licenseOther: {
           		// urls should be possible
           		regexlong: true
           	},
           	accessDuration: {
           		regexshort: true
           	},
           	accessReason: {
           		regexshort: true
           	},
          	//05 Preservation and Sharing
           	submitOther: {
           		regexshort: true
           	},
           	backup: {
           		regexlong: true
           	},
           	archiveOther: {
           		regexshort: true
           	},
           	// Request Dialog
           	additionalText: {
           		regexlong: true
           	}
           	
		}
	});
	
	form.children("div").steps({
		headerTag : "h2",
		bodyTag : "section",
		transitionEffect : "fade",
		onStepChanging : function (event, currentIndex, newIndex) {
			// Allways allow previous action even if the current form is not valid!
	        if (currentIndex > newIndex)
	        {
	            return true;
	        }
			// Needed in some cases if the user went back (clean up)
	        if (currentIndex < newIndex)
	        {
	            // To remove error styles
	            form.find(".body:eq(" + newIndex + ") label.error").remove();
	            form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
	        }
			form.validate().settings.ignore = ":disabled,:hidden";
			return form.valid();
		},
		onFinishing : function (event, currentIndex) {
			form.validate().settings.ignore = ":disabled";
			return form.valid();
		},
		onFinished : function (event, currentIndex) {
			$("div.steps").hide();
			$("div.actions").hide();
			$("div[name='title']").hide();
			$("#lastTab").hide();
			$("#handleInput").show();
			getInput();
		},
		onInit : function () {
			//If the user has dmps to load a preview '#dmppreview' will be shown
			if (userHasDmps === "true") {
				hideGeneralInformation();
				$("#dmppreview").show();
			}
			
			$("#delete").on("click", openConfirmDeleteDialog);
			
			$("#load").on("click", loadDmp);
			
			$("#start").on("click", showGeneralInformation);
			
		    //01 General Information
			$("#firstPrincInput").on("keyup focus", handlePrincipalButton);
		    
		    $("#types-cb").on("click", checkboxTypes);
		    $("#typesOther").hide();
		    
		    $("#sameContact").on("click", sameContact);		    
		    $("#princButton").on("click", addInputField);
		    
		    $("#funding").on("change", handleFunding);
		    $("#fundingOther").hide();
		    $("#fundingLink").hide();
		
		    $("input[name='policies']").on("click", policies);
		    $("#policyOther").hide();
		    $("#policyLink").hide();
		
		    //02 Data Collection DCRT
		    $("#alive").addClass("disabledDiv");
		    $("#taxon").addClass("disabledDiv");
		    
		    $("input[name='physical']").on("click", handlePhysical);
		
		    $("input[name='alive']").on("click", handleAlive);
		    
		    //02 Data Collection
		    $("#datatype-cb").on("click", checkboxDatatype);
		    $("#datatypeOther").hide();
		    
		    $("#volumeSlider").on("input change", showDataVolume);
		    $("#datasetSlider").on("input change", showNumberOfDataSets);
		    
		    //03 Documentation and Metadata
		    $("input[name='metadata']").on("click", showMetadataInformation);
		    $("#metadataDesc").hide();
		    $("span[name='show-meta-info']").on("click", toggleMetaInfos)
		    
		    //04 Ethics and Legal Compliance
		    $("input[name='requirements']").on("click", requirements);
		    $("#requirementOther").hide();
		
		    $("#licenses").on("change", handleLicenses);
		    $("#licenseOther").hide();
		    //$("span[name='show-license-info']").on("click", toggleLicenseInfos)
		    
		    $("input[name='restriction']").on("change", handleRestriction);
		    $("#accessYes").hide();
		    
		    //05 Preservation and Sharing
		    $("#submit-cb").on("click", handleSubmission);
		    $("#submitOther").hide();
		    
		    $("#archives-cb").on("click", handleArchives);
		    $("#archiveOther").hide();
		    
		    //06 Handling inputs at the end of the wizard
		    $("#handleInput").hide();
		    
		    //Download PDF
		    $("#downloadDMP").click(function () {
				var fileName = $("#name").val() + ".pdf";
				fileName = fileName.replace(/\s/g, "_");
				window.open(contextPath + '/DownloadFile?fileName=' + fileName, '_blank');
			});
		    
		    //Saving DMP
		    $("#saveDMP").on("click", saveDMP);
		    
		    if(!Liferay.ThemeDisplay.isSignedIn()) {
		    	$("#save-message").show();
		    	$("#autosaveMessage").hide();
		    	
		    	$("#saveDMP").prop("disabled", true);
				$("#saveDMP").prop("title", "You need to be logged in");
			   	$("#saveDMP").addClass("wizarddisabled");
		    }
		    
		    //Send DMP Request
		    $("#sendDMP").on("click", openSendRequestDialog);
		    
		    //Finish Wizard
		    $("#finishDMP").click(function() {
    			location.reload();
			});
		    
		    //Tooltips
		    $("a[name=title]").tooltip({
		    	tooltipClass: "jqueryTooltip",
		    	position: {
		            my: "left center", // the "anchor point" in the tooltip element
		            at: "right+5 center" // the position of that anchor point relative to selected element
		        },
		        content: function () {
		            return $(this).attr('title');
		        },
		        show: { 
		        	effect: "fade"
		        },
		        hide: {
		            effect: "fade"
		        },
		        disabled: true,
		        close: function( event, ui ) { 
		            $(this).tooltip('disable'); 
		            /* instead of $(this) you could also use $(event.target) */
		        }
		    }); 
		    
		    $('a[name=title]').on('click', function () {
		        $(this).tooltip('enable').tooltip('open');
		   });

		    $("span[title]").tooltip({
		    	tooltipClass: "jqueryTooltip",
		    	position: {
		    		my: "center top",
		            at: "center bottom+5"
		        },
		        content: function () {
		            return $(this).attr('title');
		        },
		        show: { 
		        	effect: "fade"
		        },
		        hide: {
		            effect: "fade"
		        }
		    });
		}
  	})
});

function getInput() {
	
	var jsonInput = getInputAsJson();
	//console.log("Send: " + jsonInput);
	
    $.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlWizard%>',
	   		"data": {
	   			json: jsonInput
	   		},
	   		success: function (text) {
	          	//console.log(text); //TODO
	      	}
    });
}

function saveDMP() {
	saveDMPforUser();
	openSavedDialog();
	saved = true;
}

function saveDMPforUser() {
	
	var projectName = $("#name").val(),
		dmpId = $("#dmpId").val();
	
	$.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlSave%>',
	   		"data": {
	   			name: projectName,
	   			dmpId: dmpId
	   		},
	   		success: function (response) {
	          	//console.log("Saving Response: " + response); //TODO
	          	
	          	if (response.includes("success")) {
		          	$("#saveDMP").prop("disabled", true);
		          	$("#saveDMP").addClass("wizarddisabled");
		          	$("#saveDMP").val("Saved");
	          	}
	          	
	          	$("#save-answer").html("<p>" + response + "</p>");
	      	}
 	});
}

function openSavedDialog() {
	$("#dialog-save").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "custom-dialog",
	    buttons: {
	      Ok: function () {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}

function deleteDmp() {
	var dmpId = $("#dmps").val();
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlDelete%>',
   		"data": {
   			dmpId: dmpId
   		},
   		success: function (response) {
   			openDeleteLoadDialog(response);
   			$("#dmps option[value='" + dmpId + "']").remove();
      	},
      	error: function (error) {
      		openDeleteLoadDialog(error.responseText);
      	}
	});
}

function openConfirmDeleteDialog() {
	$("#delete-load-answer").html("<p>Do you want to delete the data management plan?</p>");
	
	$("#dialog-delete-load").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "custom-dialog",
	    buttons: {
	      Yes: function () {
	    	deleteDmp();
	      },
	      Cancel: function () {
	    	$( this ).dialog( "close" );  
	      }
	    }
    });
}

function openDeleteLoadDialog(response) {
	$("#delete-load-answer").html("<p>" + response + "</p>");
	
	$("#dialog-delete-load").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "custom-dialog",
	    buttons: {
	      Ok: function () {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}

function loadDmp() {
	var dmpId = $("#dmps").val();
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlLoad%>',
   		"data": {
   			dmpId: dmpId
   		},
   		success: function (response) {
          	var selectedDmp = JSON.parse(response);
			//console.log("Loaded: " + selectedDmp.projectName);
   			initializeWizard(selectedDmp, dmpId);
   			showGeneralInformation();
      	},
      	error: function (error) {
			openDeleteLoadDialog(error.responseText);
		}
	});
}

function openSendRequestDialog() {
	$("#dialog-request").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "request-dialog custom-dialog",
	    title: "Data Management Plan Request",
	    buttons: {
	      "Send DMP Support Request": function () {
	    	$("#send-request").hide();  
	    	$('#dialogLoader').show();
	    	$('#dialog-request').dialog('option', 'buttons', {} )
			sendRequest();
	      },
	      Cancel: function () {
		   	$( this ).dialog( "close" );  
		  }
	    }
    });
}

function sendRequest() {
	var services = new Array,
		information;
	services = getServices();
	information = $("#additinalText").val();
	//console.info("Services: " + services);
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlSend%>',
   		"data": {
   			services: services,
   			infos: information
   		},
   		success : function(text) {
			answer("#successAnswer", text);
		},
		error : function(text) {
			answer("#errorAnswer", text);
		}
	});
	// Saving the dmp automatically after the request
	if (!saved) {
		saveDMPforUser();
	}
}

function answer(element, response) {
	//console.info(response);
	sleep(2000).then(function() {
		$("#dialogLoader").hide();
		$(element).show();
		$('#dialog-request').dialog('option', 'buttons', {
	    	'Ok': function() {
	        	$(this).dialog('close');
	        	$(element).hide();
	        	$("#send-request").show();
	    	}
		});
	});
}

function sleep (time) {
  	return new Promise(function(resolve) { 
  		return setTimeout(resolve, time);
  	});
}

</script>

<body>
	<div class="container wizard_main">
		<form id="dmpt-wizard" action="#">
			<div>
  				<jsp:include page="sections/01_general_information.jsp" />
 				
  				<jsp:include page="sections/02_data_collection.jsp" />
			
 				<jsp:include page="sections/03_metadata.jsp" />
			
				<jsp:include page="sections/04_ethics.jsp" />
				
				<!-- Note: 06_finish_wizard.jsp is included at the end of section 05_preservation -->
 				<jsp:include page="sections/05_preservation.jsp" />
 				
				<!-- Send Request Dialog -->
				<jsp:include page="request_dialog.jsp" />
			</div>
		</form>
	</div>
	
	<div id="clear" style="clear: both;"></div>
</body>