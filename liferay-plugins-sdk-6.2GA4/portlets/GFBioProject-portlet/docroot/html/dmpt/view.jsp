<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<portlet:resourceURL var="ajaxUrlWizard" id="wizard" />
<portlet:resourceURL var="ajaxUrlLicense" id="license" />
<portlet:resourceURL var="ajaxUrlSave" id="savedmp" />
<portlet:resourceURL var="ajaxUrlLoad" id="loaddmp" />

<script type="text/javascript">   

var userEmail = '${email}';
var userName = '${username}';
var contextPath = '${contextPath}';
var userHasDmps = '${hasDmps}';
var dmps = '${dmpsforuser}';

$(document).ready(function(){
	
      
    $.validator.addMethod("notEqual", function(value, element, param) {
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
		onStepChanging : function(event, currentIndex, newIndex) {
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
		onFinishing : function(event, currentIndex) {
			form.validate().settings.ignore = ":disabled";
			return form.valid();
		},
		onFinished : function(event, currentIndex) {
			$("div.steps").hide();
			$("div.actions").hide();
			$("div[name='title']").hide();
			$("#gfbioServicesStep").hide();
			$("#handleInput").show();
			sendInput();
		},
		onInit : function() {
			//If the user has dmps to load a preview '#dmppreview' will be shown
			if (userHasDmps === "true") {
				hideGeneralInformation();
				$("#dmppreview").show();
			}
			
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
		
		    $("#pol-cb").on("click", handlePolicy);
		    $("#pol-none").on("click", policyNone);
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
		    $("#datasetSlider").on("input change", showNumberOfDatasets);
		    
		    //03 Documentation and Metadata
		    $("#metadata-other").on("click", handleMetadataOther);
		    $("#metadataDesc").hide();
		    
		    //04 Ethics and Legal Compliance
		    $("#legal-other").on("click", checkboxRequirement);
		    $("#requirementOther").hide();
		
		    $("#licenses").on("change", function(event) {
		    	handleLicenses(event);
		    	getLicenseData();
		    });
		    $("#licenseOther").hide();
		    $("#licensceUrl").hide();
		    $("#licensceDescription").hide();
		    
		    $("input[name='restriction']").on("change", handleRestriction);
		    $("#accessYes").hide();
		    
		    //05 Preservation and Sharing
		    $("#archives-cb").on("click", handleArchives);
		    $("#archiveOther").hide();
		    
		    //07 Handling inputs at the end of the wizard
		    $("#handleInput").hide();
		    
		    $("#downloadDMP").click(function() {
				var fileName = $("#name").val() + ".pdf";
				fileName = fileName.replace(/\s/g, "_");
				window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
			});
		    
		    //$("#downloadDMPtest").click(function() {
			//	var fileName = $("#name").val();
			//	fileName = fileName.replace(/\s/g, "_");
			//	window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
			//});
		    
		    //Saving DMP
		    $("#saveDMP").on("click", saveDMPforUser);
		    
		    if(!Liferay.ThemeDisplay.isSignedIn()) {
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
		        content: function() {
		            return $(this).attr('title');
		        },
		        show: { 
		        	effect: "fade"
		        },
		        hide: {
		            effect: "fade",
		            delay: 500
		        }
		    }); 

		    $("span[title]").tooltip({
		    	tooltipClass: "jqueryTooltip",
		    	position: {
		    		my: "center top",
		            at: "center bottom+5"
		        },
		        content: function() {
		            return $(this).attr('title');
		        },
		        show: { 
		        	effect: "fade"
		        },
		        hide: {
		            effect: "fade",
		            delay: 500
		        }
		    });
		}
  	})
});

function getInputAsJson() {
	
	// 01 General Information
	var projectName = $("#name").val();
	var category = $("#category").find(":selected").text();
	console.log("Category: " + category);
	if (category === "Select") category = "";
	var reproducible = $("input[name='nature']:checked").val();
	
	var projectTypes = [];
	$("input[name='types']:checked").each(function() {
      	projectTypes.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", projectTypes) > -1) {
		projectTypes.splice($.inArray("Other", projectTypes), 1);
		projectTypes.push($("#typesOther").val());
	}
	
	var projectAbstract = $("#abstract").val();
	
	var investigators = [];
	$("input[name='investigator']").each(function() {
		investigators.push($(this).val());
    });
	
	var responsibleName = $("#responsibleName").val();
	var phoneNumber = $("#phone").val();
	var email = $("#email").val();
	
	var funding = $("#funding").val();
	var fundingLink = $("#fundingLink").val();
	if (funding === "other") {
		funding = $("#fundingOther").val();
	}
	
	var policies = [];
	$("input[name='policies']:checked").each(function() {
      	policies.push($(this).siblings('span').text());
    });
	//var policies = $("#policies").text();
	var policyLink = "";
	var policyOther = "";
	if ($.inArray("Other", policies) > -1) {
		policyOther = $("#policyOther").val();
		policyLink = $("#policyLink").val();
	}
	
	// 02 Data Collection
	
	var physical = $("input[name='physical']:checked").val();
	var alive = $("input[name='alive']:checked").val();
	var taxon = $("input[name='taxon']:checked").val();
	var sequenced = $("input[name='sequenced']:checked").val();
	
	var dataformats = [];
	$("input[name='dataformat']:checked").each(function() {
		dataformats.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", dataformats) > -1) {
		dataformats.splice($.inArray("Other", dataformats), 1);
		dataformats.push($("#dataformatOther").val());
	}
	
	var documentated = $("input[name='documentated']:checked").val();
	
	var dataVolume = $("#volumeSlider").val();
	var dataSet = $("#datasetSlider").val();

	var methodologies = $("#methodologies").val();
	
	// 03 Metadata
	
	var metadata = [];
	var metadataDesc = "";
	$("input[name='metadata']:checked").each(function() {
		dataformats.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", metadata) > -1) {
		metadata.splice($.inArray("Other metadata schema or version", metadata), 1);
		metadataDesc = $("metadataDesc").val();	
	}

	// 04 Ethics
	
	var requirements = [];
	$("input[name='requirements']:checked").each(function() {
		requirements.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", requirements) > -1) {
		requirements.splice($.inArray("Other", requirements), 1);
		requirements.push($("requirementOther").val());	
	}
	
	var license = $("input[name='license']:checked").val();
	var otherLicense = "";
	if (license === "Other License") {
		otherLicense = $("licenseOther").val()
	}
	 
	var accessRestriction = $("input[name='restriction']:checked").val();
	var accessDuration = "";
	var accessReason = "";
	if (accessRestriction) {
		accessDuration = $("#accessDuration").val();
		accessReason = $("#accessReason").val();
	}
	
	// 05 Preservation
	
	var dataArchives = [];
	
	// 06 GFBio Services
	
	// Create jsonObject
	var dmptInput = {
			// 01 General Information
			"projectName" : projectName,
			"category" : category,
			"reproducible" : reproducible,
			"projectTypes": [],
			"projectAbstract" : projectAbstract,
			"investigators" : [],
			"responsibleName" : responsibleName,
			"phoneNumber" : phoneNumber,
			"email" : email,
			"funding" : {
				"name" : funding
			},
			"fundingLink" : fundingLink,
			"fundingOther" : fundingOther,
			"policies" : [],
			"policyOther" : policyOther,
			"policyLink" : policyLink,
			// 02 Data Collection
			"physical" : physical,
			"alive" : alive,
			"taxon" : taxon,
			"sequenced" : sequenced,
			"dataformats" : [],
			"openlyDocumentated" : documentated,
			"dataVolume" : dataVolume,
			"dataSets" : dataSet,
			"methodologies" : methodologies,
			// 03 Metadata
			"metadata" : [],
			"metadataDescription" : metadataDesc
			// 04 Ethics
			
			// 05 Preservation
			
			
				
	};
	
	if (projectTypes != null) {
		dmptInput.projectTypes = projectTypes;
	}

	if (investigators != null) {
		dmptInput.investigators = investigators;
	}
	
	console.log(policies);
	
 	if (policies != null) {
// 		policies.map(function(item) {        
// 	  		dmptInput.policies.push({ 
// 	    		"value" : item,
// 	    	});
// 		});
 	}

	if (dataformats != null) {
		dmptInput.dataformats = dataformats;
	}
	
	if (metadata != null) {
		
	}
	
	console.log(dmptInput);
	console.log("JSon");
	
	return JSON.stringify(dmptInput);
	
}

function saveDMPforUser() {
	
	var projectName = $("#name").val();
	
	$.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlSave%>',
	   		"data": {
	   			name: projectName
	   		},
	   		success: function(text) {
	          	console.log("Save Answer: " + text);
	      	}
 	});
}

function sendInput() {
	
	var jsonInput = getInputAsJson();
	console.log("Send: " + jsonInput);
	
    $.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlWizard%>',
	   		"data": {
	   			json: jsonInput
	   		},
	   		success: function(text) {
	          	console.log(text);
	      	}
    });
}

function loadDmp() {
	
	console.log("LOADING...");
	var dmpID = $("#dmps").val();
	console.log("ID: " + dmpID);
	
	var selectedDmp = {};
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlLoad%>',
   		"data": {
   			dmpID: dmpID
   		},
   		success: function(response) {
   			console.log("JSON: " + response);
          	selectedDmp = JSON.parse(response);
   			console.log("Selected: " + selectedDmp);
			console.log("Name: " + selectedDmp.projectName);
   			initializeInputs(selectedDmp);
   			showGeneralInformation();
      	}
	});
}

function addInvestigator(investigator) {
	var newinput = $('<input/>', {
        type: 'text',
        name: 'investigator',
        "class": 'inputtext',
        placeholder: 'Principal Investigator'
    });
    
    newinput.on("keyup focus", handlePrincipalButton);
    newinput.on("focusout", removePrincipalInput);
    newinput.val(investigator);
    newinput.appendTo("#principal");
}

function initializeInputs(dmptInput) {
	// 01 General Information
	$("#name").val(dmptInput.projectName);
	if (dmptInput.category == null || dmptInput.category === "") {
		$("#category").val("Select");
	} else {
		$("#category").val(dmptInput.category);
	}
	
	if (dmptInput.reproducible != null) {
		$("input[name='nature'][value='" + dmptInput.reproducible + "']").prop("checked", true);
	}
	
	if (dmptInput.projectTypes != null) {
		var projectTypes = dmptInput.projectTypes;
		for (var i in projectTypes) {
			console.log("Ptype: " + projectTypes[i]);
			$("input[name='types'][value='" + projectTypes[i] + "']").prop("checked", true);
		}
	}
	
	if (dmptInput.projectAbstract != null) {
		var projectAbstract = $("#abstract").val(dmptInput.projectAbstract);
	}
	
	if (dmptInput.investigators != null) {
		var investigators = dmptInput.investigators;
		$("input[name='investigator']").val(investigators[0]);
		if (investigators.length > 1) {
			for (var i = 1; i < investigators.length; i++) {
				addInvestigator(investigators[i]);
			}
		}
	}
	
	if (dmptInput.responsibleName != null) {
		$("#responsibleName").val(dmptInput.responsibleName);
	}
	
	if (dmptInput.phoneNumber != null) {
		$("#phone").val(dmptInput.phoneNumber);
	}
	
	if (dmptInput.email != null) {
		$("#email").val(dmptInput.email);
	}
	
	if (dmptInput.funding != null) {
		$("#funding").val(dmptInput.funding);
		
		if (dmptInput.fundingLink != null) {
			$("#fundingLink").val(dmptInput.fundingLink);
			$("#fundingLink").show();
		}
		
		if (dmptInput.fundingOther != null) {
			$("#fundingOther").val(dmptInput.fundingOther);
			$("#fundingOther").show();	
		}
	}
	
	if (dmptInput.policies != null) {
		var policies = dmptInput.policies;
		for (var i in policies) {
			$("input[name='policies']").each(function() {
		      	if ($(this).siblings('span').text() === policies[i].name) {
		      		$(this).prop("checked", true);
		      	}
		    });
		}
		
		if (policyLink != null) {
			$("#policyLink").val(dmptInput.policyLink);
			$("#policyLink").show();
		}
		
		if (policyOther != null) {
			$("#policyOther").val(dmptInput.policyOther);
			$("#policyOther").show();
		}
	}
	
	// 02 Data Collection
	
// 	var physical = $("input[name='physical']:checked").val();
// 	var alive = $("input[name='alive']:checked").val();
// 	var taxon = $("input[name='taxon']:checked").val();
// 	var sequenced = $("input[name='sequenced']:checked").val();
	
// 	var dataformats = [];
// 	$("input[name='dataformat']:checked").each(function() {
// 		dataformats.push($(this).siblings('span').text());
//     });
// 	if ($.inArray("Other", dataformats) > -1) {
// 		dataformats.splice($.inArray("Other", dataformats), 1);
// 		dataformats.push($("#dataformatOther").val());
// 	}
	
// 	var documentated = $("input[name='documentated']:checked").val();
	
// 	var dataVolume = $("#volumeSlider").val();
// 	var dataSet = $("#datasetSlider").val();

// 	var methodologies = $("#methodologies").val();
	
	// 03 Metadata
	
// 	var metadata = [];
// 	var metadataDesc = "";
// 	$("input[name='metadata']:checked").each(function() {
// 		dataformats.push($(this).siblings('span').text());
//     });
// 	if ($.inArray("Other", metadata) > -1) {
// 		metadata.splice($.inArray("Other metadata schema or version", metadata), 1);
// 		metadataDesc = $("metadataDesc").val();	
// 	}

	// 04 Ethics
	
// 	var requirements = [];
// 	$("input[name='requirements']:checked").each(function() {
// 		requirements.push($(this).siblings('span').text());
//     });
// 	if ($.inArray("Other", requirements) > -1) {
// 		requirements.splice($.inArray("Other", requirements), 1);
// 		requirements.push($("requirementOther").val());	
// 	}
	
// 	var license = $("input[name='license']:checked").val();
// 	var otherLicense = "";
// 	if (license === "Other License") {
// 		otherLicense = $("licenseOther").val()
// 	}
	 
// 	var accessRestriction = $("input[name='restriction']:checked").val();
// 	var accessDuration = "";
// 	var accessReason = "";
// 	if (accessRestriction) {
// 		accessDuration = $("#accessDuration").val();
// 		accessReason = $("#accessReason").val();
// 	}
	
	// 05 Preservation
	
	// var dataArchives = [];
	
	// 06 GFBio Services
}

function getLicenseData() {
	
	var license = $("#licenses").val();
	console.log("License: " + license);
	
    $.ajax({
	   		"method": "POST",
	   		"url": '<%=ajaxUrlLicense%>',
	   		"data": {
	   			license: license
	   		},
	   		success: function(text) {
	          	console.log(text);
	          	
          		var results = text.split(',');
          		console.log(results[0]);
          		if (results[0] !== "url") {
          			console.log(results[0]);
          			$("#licensceUrl").href = results[0];
          			$("#licensceUrl").innerHTML = results[0];
          			$("#licensceUrl").show("slow");
          		} else {
          			$("#licensceUrl").hide();
          		}
          		if (results[1] !== "desc") {
          			$("#licenseDescription").innerHTML = results[1];
          			$("#licenseDescription").show("slow");
          		} else {
          			$("#licenseDescription").hide();
          		}
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