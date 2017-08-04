<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<portlet:resourceURL var="ajaxUrlWizard" id="wizard" />

<script type="text/javascript">   

var userEmail = '${email}';
var userName = '${username}';
var contextPath = '${contextPath}';

$(document).ready(function(){
	
    $(document).tooltip({
    	tooltipClass: "jqueryTooltip",
    	position: {
            my: "left center", // the "anchor point" in the tooltip element
            at: "right+5 center", // the position of that anchor point relative to selected element
        },
        content: function() {
            return $(this).attr('title');
        },
        show: { 
        	effect: "fade"
        },
        hide: {
            effect: "fade",
            delay: 600
        }
   	});   
    
    $.validator.addMethod("notEqual", function(value, element, param) {
        return this.optional(element) || value != param;
    }, "Please specify a non-default value");
    
    var form = $("#dmpt-wizard");
	form.validate({
		errorPlacement : function errorPlacement(error, element) {
			if (element.attr("name") == "responsibleName" || element.attr("name") == "email") {
               	error.hide();
           	} else if (element.attr("name") == "nature") {
   				error.attr("style", "display: block;")
               	error.insertAfter(element.parent().parent());
           	} else {
               	error.attr("style", "display: block; margin-top: 5px")
   				error.insertAfter(element);
			}
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
           		required: true,
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
		    //01 General Information
			$("#firstPrincInput").on("keyup focus", handlePrincipalButton);
		    
		    $("#types-cb").on("click", checkboxTypes);
		    $("#typesOther").hide();
		    
		    $("#princButton").on("click", addInputField);
		    
		    $("#funding").on("change", handleFunding);
		    $("#fundingOther").hide();
		    $("#fundingLink").hide();
		
		    $("#policies").on("change", handlePolicy);
		    $("#policyOther").hide();
		    $("#policyLink").hide();
		
		    //02 Data Collection DCRT
		    $("#alive").addClass("disabledDiv");
		    $("#taxon").addClass("disabledDiv");
		    $("#sequenced").addClass("disabledDiv");
		    
		    $("input[value='true'][name='physical']").on("click", handlePhysical);
		    $("input[value='false'][name='physical']").on("click", handlePhysical);
		
		    $("input[value='true'][name='alive']").on("click", handleAlive);
		    $("input[value='false'][name='alive']").on("click", handleAlive);
		    
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
		
		    $("#license-other").on("click", handleLicenses);
		    $("#licenseOther").hide();
		    $("#licensceUrl").hide();
		    
		    $("input[name='restriction']").on("change", handleRestriction);
		    $("#accessYes").hide();
		    
		    //05 Preservation and Sharing
		    $("#archives").on("change", handleArchives);
		    $("#archiveOther").hide();
		    
		    //07 Handling inputs at the end of the wizard
		    $("#handleInput").hide();
		    
		    $("#downloadDMP").click(function() {
				var fileName = $("#name").val() + ".pdf";
				fileName = fileName.replace(/\s/g, "_");
				window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
			});
		    $("#downloadDMPtest").click(function() {
				var fileName = $("#name").val();
				fileName = fileName.replace(/\s/g, "_");
				window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
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
      	projectTypes.push($(this).parent().text());
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
	var fundingLink = "";
	if (funding === "other") {
		funding = $("#fundingOther").val();
		fundingLink = $("#fundingLink").val();
	}
	
	var policies = $("#policies").text();
	var policyLink = "";
	if ($.inArray("Other", policies) > -1) {
		policies.splice($.inArray("Other", policies), 1);
		policies.push($("#policyOther").val());
		policyLink = $("#policyLink").val();
	}
	
	// 02 Data Collection
	
	var dmptInput = {
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
			"policies" : []
				
	};
	
	console.log(projectTypes);
	
	if (projectTypes != null) {
		dmptInput.projectTypes = projectTypes;
	}

	if (investigators != null) {
		dmptInput.investigators = investigators;
	}
	
// 	if (policies != null) {
// 		policies.map(function(item) {        
// 	  		dmptInput.policies.push({ 
// 	    		"value" : item,
// 	    	});
// 		});
// 	}
	
	console.log(dmptInput);
	console.log("JSon");
	
	return JSON.stringify(dmptInput);
	
}

function sendInput() {
	
	jsonInput = getInputAsJson();
	console.log("Send: " + jsonInput);
	
	var response = '';
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