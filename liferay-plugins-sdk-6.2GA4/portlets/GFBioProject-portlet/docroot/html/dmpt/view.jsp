<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/idmg/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/idmg/jquery-ui.min.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<portlet:resourceURL var="ajaxUrlWizard" id="wizard" />
<portlet:resourceURL var="ajaxUrlLicense" id="license" />
<portlet:resourceURL var="ajaxUrlSave" id="savedmp" />
<portlet:resourceURL var="ajaxUrlLoad" id="loaddmp" />
<portlet:resourceURL var="ajaxUrlDelete" id="deletedmp" />

<script type="text/javascript">   

var userEmail = '${email}';
var userName = '${username}';
var contextPath = '${contextPath}';
var userHasDmps = '${hasDmps}';
var dmps = '${dmpsforuser}';

$(document).ready(function () {
	
      
    $.validator.addMethod("notEqual", function (value, element, param) {
        return this.optional(element) || value != param;
    }, "Please specify a non-default value");
    
    var form = $("#dmpt-wizard");
	form.validate({
		errorPlacement : function errorPlacement(error, element) {
            error.hide();
		},
		rules : {
			projectName : {
				required: true,
         		minlength: 3
           	},
           	responsibleName: {
           		required: true,
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
			$("#gfbioServicesStep").hide();
			$("#handleInput").show();
			getInput();
		},
		onInit : function () {
			//If the user has dmps to load a preview '#dmppreview' will be shown
			if (userHasDmps === "true") {
				hideGeneralInformation();
				$("#dmppreview").show();
			}
			
			$("#delete").on("click", deleteDmp);
			
			$("#load").on("click", loadDmp);
			
			$("#start").on("click", showGeneralInformation);
			
		    //01 General Information
			$("#firstPrincInput").on("keyup focus", handlePrincipalButton);
		    
		    $("#types-cb").on("click", checkboxTypes);
		    $("#typesOther").hide();
		    
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
		    $("#sequenced").addClass("disabledDiv");
		    
		    $("input[name='physical']").on("click", handlePhysical);
		
		    $("input[name='alive']").on("click", handleAlive);
		    
		    //02 Data Collection
		    $("#dataformat-cb").on("click", checkboxDataformat);
		    $("#dataformatOther").hide();
		    
		    $("#volumeSlider").on("input change", showDataVolume);
		    $("#datasetSlider").on("input change", showNumberOfDataSets);
		    
		    //03 Documentation and Metadata
		    $("input[name='metadata']").on("click", showMetadataInformation);
		    $("#metadataDesc").hide();
		    $("span[name='show-meta-info']").on("click", toggleMetaInfos)
		    
		    //04 Ethics and Legal Compliance
		    $("#legal-other").on("click", checkboxRequirement);
		    $("#requirementOther").hide();
		
		    $("#licenses").on("change", handleLicenses);
		    $("#licenseOther").hide();
		    $("span[name='show-license-info']").on("click", toggleLicenseInfos)
		    
		    $("input[name='restriction']").on("change", handleRestriction);
		    $("#accessYes").hide();
		    
		    //05 Preservation and Sharing
		    $("#archives-cb").on("click", handleArchives);
		    $("#archiveOther").hide();
		    
		    //07 Handling inputs at the end of the wizard
		    $("#handleInput").hide();
		    
		    $("#downloadDMP").click(function () {
				var fileName = $("#name").val() + ".pdf";
				fileName = fileName.replace(/\s/g, "_");
				window.open(contextPath + '/DownloadFile?fileName=' + fileName, '_blank');
			});
		    
		    //$("#downloadDMPtest").click(function () {
			//	var fileName = $("#name").val();
			//	fileName = fileName.replace(/\s/g, "_");
			//	window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
			//});
		    
		    //Saving DMP
		    $("#saveDMP").on("click", saveDMPforUser);
		    
		    if(!Liferay.ThemeDisplay.isSignedIn()) {
		    	$("#save-message").show();
		    	
		    	$("#saveDMP").prop("disabled", true);
				$("#saveDMP").prop("title", "You need to be logged in");
			   	$("#saveDMP").addClass("wizarddisabled");
		    }
		    
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
	console.log("Send: " + jsonInput);
	
    $.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlWizard%>',
	   		"data": {
	   			json: jsonInput
	   		},
	   		success: function (text) {
	          	console.log(text);
	      	}
    });
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
	          	console.log("Save Answer: " + response);
	          	
	          	if (response.includes("success")) {
		          	$("#saveDMP").prop("disabled", true);
		          	$("#saveDMP").addClass("wizarddisabled");
		          	$("#saveDMP").val("Saved");
	          	}
	          	openSavedDialog(response);
	      	}
 	});
}

function openSavedDialog(response) {
	$("#save-answer").html("<p>" + response + "</p>");
	
	$("#dialog-save").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "answer-dialog custom-dialog",
	    buttons: {
	      Ok: function () {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}

function deleteDmp() {
	var dmpId = $("#dmps").val();
	console.log("ID: " + dmpId);
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlDelete%>',
   		"data": {
   			dmpId: dmpId
   		},
   		success: function (response) {
   			openDeletedDialog(response);
   			
   			if (response.includes("success")) {
   				$("#dmps option[value='" + dmpId + "']").remove();
   			}
      	}
	});
	
}

function openDeletedDialog(response) {
	$("#delete-answer").html("<p>" + response + "</p>");
	
	$("#dialog-delete").dialog({
	    modal: true,
	    resizable: false,
	    dialogClass: "answer-dialog custom-dialog",
	    buttons: {
	      Ok: function () {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}


function loadDmp() {
	var dmpId = $("#dmps").val();
	console.log("Load dmp with Id: " + dmpId);
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlLoad%>',
   		"data": {
   			dmpId: dmpId
   		},
   		success: function (response) {
   			console.log("JSON: " + response);
          	var selectedDmp = JSON.parse(response);
   			console.log("Selected: ", selectedDmp);
			console.log("Name: " + selectedDmp.projectName);
   			initializeInputs(selectedDmp, dmpId);
   			showGeneralInformation();
      	}
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
				
 				<jsp:include page="sections/05_preservation.jsp" />
				
 				<jsp:include page="sections/06_gfbio_services.jsp" />
			</div>
		</form>
	</div>
	
	<div id="clear" style="clear: both;"></div>
</body>