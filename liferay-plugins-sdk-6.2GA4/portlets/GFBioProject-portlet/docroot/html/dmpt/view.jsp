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
			getInput();
		},
		onInit : function() {
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
				window.open(contextPath + '/DownloadFile?fileName=' + fileName, '_blank')
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
		            effect: "fade"
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
	   		success: function(text) {
	          	console.log(text);
	      	}
    });
}

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
	if (funding === "Other") {
		funding = $("#fundingOther").val();
	}
	var fundingLink = $("#fundingLink").val();
	
	var policies = [];
	$("input[name='policies']:checked").each(function() {
      	policies.push($(this).siblings('span').text());
    });
	
	var policyLink = "";
	if ($.inArray("Other", policies) > -1) {
		policies.splice($.inArray("Other", policies), 1);
		policies.push($("#policyOther").val());
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
	
	var dataVolume = getDataVolumeBySliderValue($("#volumeSlider").val());
	var dataSet = getDataSetBySliderValue($("#datasetSlider").val());

	var methodologies = $("#methodologies").val();
	
	// 03 Metadata
	
	var metadata = [];
	var metadataDesc = "";
	$("input[name='metadata']:checked").each(function() {
		metadata.push($(this).siblings('span').text());
    });
	if ($.inArray("Other metadata schema or version", metadata) > -1) {
		metadataDesc = $("#metadataDesc").val();	
	}

	// 04 Ethics
	
	var requirements = [];
	$("input[name='requirements']:checked").each(function() {
		requirements.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", requirements) > -1) {
		requirements.splice($.inArray("Other", requirements), 1);
		requirements.push($("#requirementOther").val());	
	}
	
	var license = $("#licenses").val();
	if (license === "Other License") {
		license = $("#licenseOther").val();
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
	$("input[name='archives']:checked").each(function() {
		dataArchives.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", dataArchives) > -1) {
		dataArchives.splice($.inArray("Other", dataArchives), 1);
		dataArchives.push($("#archiveOther").val());	
	}
	
	var pid = $("input[name='pid']:checked").val();
	
	// 06 GFBio Services
	
	var services = [];
	$("input[name='services']:checked").each(function() {
		services.push($(this).siblings('span').text());
    });
	
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
			"metadataDescription" : metadataDesc,
			// 04 Ethics
			"requirements" : [],
			"license" : {
				"name" : license
			},
			"accessRestriction" : accessRestriction,
			"accessDuration" : accessDuration,
			"accessReason" : accessReason,
			// 05 Preservation
			"dataArchives" : [],
			"pid" : pid,
			// 06 GFbio Services
			"gfbioServices" : []			
	};
	
	// Set Arrays
	if (projectTypes) {
		dmptInput.projectTypes = projectTypes;
	}

	if (investigators) {
		dmptInput.investigators = investigators;
	}
		
 	if (policies) {
 		policies.map(function(value) {      
 	  		dmptInput.policies.push({ 
 	    		"name" : value
 	    	});
 		});
 	}

	if (dataformats) {
		dmptInput.dataformats = dataformats;
	}
	
	if (metadata) {
		metadata.map(function(value) {
			dmptInput.metadata.push({
				"name" : value
			})
		})
	}
	
	if (requirements) {
		requirements.map(function(value) {
			dmptInput.requirements.push({
				"name" : value
			})
			
		})
	}
	
	if (dataArchives) {
		dmptInput.dataArchives = dataArchives;
	}
	
	if (services) {
		dmptInput.gfbioServices = services;
	}
	
	console.log("Json:", dmptInput);
	
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
	   		success: function(response) {
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
	      Ok: function() {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}

function deleteDmp() {
	console.log("Deleting...");
	
	var dmpID = $("#dmps").val();
	console.log("ID: " + dmpID);
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlDelete%>',
   		"data": {
   			dmpID: dmpID
   		},
   		success: function(response) {
   			openDeletedDialog(response);
   			
   			if (response.includes("success")) {
   				$("#dmps option[value='" + dmpID + "']").remove();
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
	      Ok: function() {
	        $( this ).dialog( "close" );
	      }
	    }
    });
}


function loadDmp() {
	
	console.log("LOADING...");
	var dmpID = $("#dmps").val();
	console.log("ID: " + dmpID);
	
	$.ajax({
   		"method": "POST",
   		"url": '<%=ajaxUrlLoad%>',
   		"data": {
   			dmpID: dmpID
   		},
   		success: function(response) {
   			console.log("JSON: " + response);
          	var selectedDmp = JSON.parse(response);
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
	if (!isEmpty(dmptInput.category)) {
		$("#category").val(dmptInput.category);
	}
	
	if (dmptInput.reproducible) {
		$("input[name='nature'][value='" + dmptInput.reproducible + "']").prop("checked", true);
	}
	
	if (dmptInput.projectTypes) {
		var projectTypes = dmptInput.projectTypes;
		for (var i in projectTypes) {
			console.log("Ptype: " + projectTypes[i]);
			var found = false;
			$("input[name='types']").each(function() {
				if ($(this).val() === projectTypes[i]) {
					$(this).prop("checked", true);
					found = true;
				} 
			});
			if (!found) {
				$("input[name='types'][value='Other']").prop("checked", true);
				$("#typesOther").val(projectTypes[i]);
				$("#typesOther").show();
			}
			
		}
	}
	
	if (!isEmpty(dmptInput.projectAbstract)) {
		var projectAbstract = $("#abstract").val(dmptInput.projectAbstract);
	}
	
	if (dmptInput.investigators) {
		var investigators = dmptInput.investigators;
		$("input[name='investigator']").val(investigators[0]);
		if (investigators.length > 1) {
			for (var i = 1; i < investigators.length; i++) {
				addInvestigator(investigators[i]);
			}
		}
	}
	
	if (!isEmpty(dmptInput.responsibleName)) {
		$("#responsibleName").val(dmptInput.responsibleName);
	}
	
	if (!isEmpty(dmptInput.phoneNumber)) {
		$("#phone").val(dmptInput.phoneNumber);
	}
	
	if (!isEmpty(dmptInput.email)) {
		$("#email").val(dmptInput.email);
	}
	
	if (dmptInput.funding) {
		var found = false;
		$("#funding option").each(function() {
			if ($(this).val() === dmptInput.funding.name) {
				$("#funding").val(dmptInput.funding.name);
				found = true;
			}
	    });
		if (!found) {
			$("#funding").val("Other");
			$("#fundingOther").val(dmptInput.funding.name);
			$("#fundingOther").show();
			//Bug
		}
		
		if (dmptInput.funding.name !== "None" && dmptInput.funding.name !== "select") {
			if (!isEmpty(dmptInput.fundingLink)) {
				$("#fundingLink").val(dmptInput.fundingLink);
				$("#fundingLink").show();
			}
		}
	}
	
	if (dmptInput.policies) {
		var policies = dmptInput.policies;
		console.log("Policies: ", policies);
		for (var i in policies) {
			var found = false;
			$("input[name='policies']").each(function() {
		      	if ($(this).siblings('span').text() === policies[i].name) {
		      		$(this).prop("checked", true);
		      		found = true;
		      	}
		    });
			if (!found) {
				$("input[name='policies'][value='Other']").prop("checked", true);
				if (!isEmpty(dmptInput.policyLink)) {
					$("#policyLink").val(dmptInput.policyLink);
					$("#policyLink").show();
				}
				if (!isEmpty(dmptInput.policyOther)) {
					$("#policyOther").val(policies[i].name);
					$("#policyOther").show();
				}
			}
		}
	}
	
	// 02 Data Collection
	
	if (dmptInput.physical != null) {
		$("input[name='physical'][value='" + dmptInput.physical + "']").prop("checked", true);
	}

	if (dmptInput.alive != null) {
		$("input[name='alive'][value='" + dmptInput.alive + "']").prop("checked", true);
		$("#alive").removeClass("disabledDiv");
	}
	
	if (dmptInput.taxon != null) {
		$("input[name='taxon'][value='" + dmptInput.taxon + "']").prop("checked", true);
		$("#taxon").removeClass("disabledDiv");
	}
	
	if (dmptInput.sequenced != null) {
		$("input[name='sequenced'][value='" + dmptInput.sequenced + "']").prop("checked", true);
		$("#sequenced").removeClass("disabledDiv");
	}
	
	if (dmptInput.dataformats) {
		var dataformats = dmptInput.dataformats;
		for (var i in dataformats) {
			console.log("Dataformat: " + dataformats[i]);
			var found = false;
			$("input[name='dataformat']").each(function() {
				if ($(this).val() === dataformats[i]) {
					$(this).prop("checked", true);
					found = true;
				} 
			});
			if (!found) {
				$("input[name='dataformat'][value='Other']").prop("checked", true);
				$("#dataformatOther").val(dataformats[i]);
				$("#dataformatOther").show();
			}
		}
	}
	
	if (dmptInput.openlyDocumented != null) {
		$("input[name='documentated'][value='" + dmptInput.openlyDocumented + "']").prop("checked", true);
	}
		
	if (!isEmpty(dmptInput.dataVolume)) {
		$("#volumeSlider").val(getSliderValueByDataVolume(dmptInput.dataVolume));
		$("#volume").html(dmptInput.dataVolume);
	}
		
	if (!isEmpty(dmptInput.dataSets)) {
		$("#datasetSlider").val(getSliderValueByDataSet(dmptInput.dataSets));
		$("#datasets").html(dmptInput.dataSets);
	}
	
	if (!isEmpty(dmptInput.methodologies)) {
		var projectAbstract = $("#abstract").val(dmptInput.methodologies);
	}
	
	// 03 Metadata
	
	if (dmptInput.metadata) {
		var metadata = dmptInput.metadata;
		console.log("metadata: ", metadata);
		for (var i in metadata) {
			$("input[name='metadata']").each(function() {
		      	if ($(this).siblings('span').text() === metadata[i].name) {
		      		$(this).prop("checked", true);
		      	}
		    });
			
			if (metadata[i].name === "Other metadata schema or version") {
				if (!isEmpty(dmptInput.metadataDescription)) {
					$("#metadataDesc").val(dmptInput.metadataDescription);
					$("#metadataDesc").show();
				}
			}
		}
	}

	// 04 Ethics
	
	if (dmptInput.requirements) {
		var requirements = dmptInput.requirements;
		console.log("requirements: ", requirements);
		for (var i in requirements) {
			var found = false;
			$("input[name='requirements']").each(function() {
		      	if ($(this).siblings('span').text() === requirements[i].name) {
		      		$(this).prop("checked", true);
		      		found = true;
		      	}
		    });
			if (!found) {
				$("input[name='requirements'][value='Other']").prop("checked", true);
				$("#requirementOther").val(requirements[i].name);
				$("#requirementOther").show();
			}
		}
	}
	
	if (dmptInput.license) {
		var found = false;
		$("#licenses option").each(function() {
			if ($(this).val() === dmptInput.license.name) {
				$("#licenses").val(dmptInput.license.name);
				found = true;
			}
	    });
		if (!found) {
			$("#licenses").val("Other License");
			$("#licenseOther").val(dmptInput.license.name);
			$("#licenseOther").show();
		}
	}
	 
	if (dmptInput.accessRestriction != null) {
		if (dmptInput.accessRestriction === "true") {
			$("input[name='restriction'][value='true']").prop("checked", true);
			if (dmptInput.accessDuration) {
			$("#accessDuration").val(dmptInput.accessDuration);
			}
			if (dmptInput.accessReason) {
				$("#accessReason").val(dmptInput.accessReason);
			}
			$("#accessYes").show();
	 	} else {
			$("input[name='restriction'][value='false']").prop("checked", true);
	 	}
	}
	
	// 05 Preservation
	
	if (dmptInput.dataArchives) {
		var dataArchives = dmptInput.dataArchives;
		for (var i in dataArchives) {
			console.log("DataArchive: " + dataArchives[i]);
			var found = false;
			$("input[name='archives']").each(function() {
				if ($(this).siblings('span').text() === dataArchives[i]) {
					$(this).prop("checked", true);
					found = true;
				} 
			});
			if (!found) {
				$("input[name='archives'][value='Other']").prop("checked", true);
				$("#archiveOther").val(dataArchives[i]);
				$("#archiveOther").show();
			}
		}
	}
	

	if (dmptInput.pid != null) {
		$("input[name='pid'][value='" + dmptInput.pid + "']").prop("checked", true);
	}
		
	// 06 GFBio Services
	
	if (dmptInput.gfbioServices) {
		var gfbioServices = dmptInput.gfbioServices;
		for (var i in gfbioServices) {
			console.log("Service: " + gfbioServices[i]);
			$("input[name='services']").each(function() {
				if ($(this).siblings('span').text() === gfbioServices[i]) {
					$(this).prop("checked", true);
				} 
			});
		}
	}
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