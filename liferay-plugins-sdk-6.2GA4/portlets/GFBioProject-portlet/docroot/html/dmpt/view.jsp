<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<script type="text/javascript">   

var userEmail = '${email}';
var userName = '${username}';
var contextPath = '${contextPath}';

$(document).ready(function(){
	
	$("#download").click(function() {
		var fileName="test.pdf"; // any file
		window.location.href = contextPath + "/DownloadFile?fileName=" + fileName; 
	});
	
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
                   error.insertAfter(element.parent());
               } else if (element.attr("name") == "nature") {
			    error.attr("style", "display: block;")
                   error.insertAfter(element.parent().parent());
               } else if (element.attr("name") == "types" || element.attr("name") == "dataformat") {    
                   error.attr("style", "display: block;")
                   error.insertAfter(element.parent().parent().parent());
               } else {
                   error.attr("style", "display: block; margin-top: 5px")
			    error.insertAfter(element);
			}
		},
		rules : {
//              types : {
// 					required: true,
// 		            minlength: 1
// 				},
// 				nature : {
// 					required: true,
// 		            minlength: 1
// 				},
//                 email : {
//                     required: true,
//                     email: true
//                 },
//                 phoneNumber : {
//                     required: false,
//                     number: true
//                 },
//                 typesOther: {
//                     required: {
//                         depends: function(element) {
//                             return $("#types-cb").is(":checked");
//                         }
//                     }
//                 },
//                 funding: {
//                     notEqual: "select"
//                 },
//                 fundingOther: {
//                     required: {
//                         depends: function(element) {
//                             return $("#funding").val() == "other";
//                         }
//                     }
//                 },
//                 policies: {
//                     required: true
//                 },
//                 policyOther: {
//                     required: {
//                         depends: function(element) {
//                             return $("#policies").val() == "other";
//                         }
//                     }
//                 },
// 				dataformat: {
//                     required: true
//                 },
//                 dataformatOther: {
//                     required: {
//                         depends: function(element) {
//                             return $("#dataformat-cb").is(":checked");
//                         }
//                     }
//                 },
//              documentated: {
//                  required: true,
//                  minlength: 1
//              }
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
			$("#gfbioServicesStep").hide();
			$("#handleInput").show();
		},
		onInit : function() {
		    //General Information
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
		
		    //Data Collection DCRT
		    $("#alive").addClass("disabledDiv");
		    $("#taxon").addClass("disabledDiv");
		    $("#sequenced").addClass("disabledDiv");
		    
		    $("input[value='true'][name='physical']").on("click", handlePhysical);
		    $("input[value='false'][name='physical']").on("click", handlePhysical);
		
		    $("input[value='true'][name='alive']").on("click", handleAlive);
		    $("input[value='false'][name='alive']").on("click", handleAlive);
		    
		    //Data Collection
		    $("#dataformat-cb").on("click", checkboxDataformat);
		    $("#dataformatOther").hide();
		    
		    $("#volumeSlider").on("input change", showDataVolume);
		    $("#datasetSlider").on("input change", showNumberOfDatasets);
		    
		    //Documentation and Metadata
		    $("#metadata-other").on("click", handleMetadataOther);
		    $("#metadataDesc").hide();
		    
		    //Ethics and Legal Compliance
		    $("#legal-other").on("click", checkboxRequirement);
		    $("#requirementOther").hide();
		
		    $("#license-other").on("click", handleLicenses);
		    $("#licenseOther").hide();
		    $("#licensceUrl").hide();
		    
		    $("input[name='restriction']").on("change", handleRestriction);
		    $("#accessYes").hide();
		    
		    //Preservation and Sharing
		    $("#archives").on("change", handleArchives);
		    $("#archiveOther").hide();
		    
		    //Handling inputs at the end of the wizard
		    $("#handleInput").hide();
		}
  	})
});

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