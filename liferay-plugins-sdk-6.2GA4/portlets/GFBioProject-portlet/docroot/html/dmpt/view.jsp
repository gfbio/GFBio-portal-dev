<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">

<script type="text/javascript">     
	$(document).ready(function() {
        $.validator.addMethod("notEqual", function(value, element, param) {
            return this.optional(element) || value != param;
        }, "Please specify a non-default value");
        
		var form = $("#example-form");
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
				alert("Submitted!");
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

                //Data Collection
                $("#dataformat-cb").on("click", checkboxDataformat);
                $("#dataformatOther").hide();
                
                $("#volumeSlider").on("input change", showDataVolume);
                $("#datasetSlider").on("input change", showNumberOfDatasets);
                
                //Documentation and Metadata
                $("#metadataOther").click(handleMetadataOther);
                $("#metadataDesc").hide();
                
                //Ethics and Legal Compliance
                $("#sensitive").click(handleSensitive);
                $("#sensitiveOther").hide();
                
                $("input[name='restriction']").on("change", handleRestriction);
                $("#accessYes").hide();
                
                //Preservation and Sharing
                $("#archives").on("change", handleArchives);
                $("#archiveOther").hide();
                
            }
        })
	});
</script>

<body>
	<div class="container wizard_main">
		<form id="example-form" action="#">
			<div>
  				<jsp:include page="sections/general_information.jsp" />
 				
  				<jsp:include page="sections/data_collection.jsp" />
			
 				<jsp:include page="sections/metadata.jsp" />
			
				<jsp:include page="sections/ethics.jsp" />
				
 				<jsp:include page="sections/preservation.jsp" />
				
 				<jsp:include page="sections/gfbio_services.jsp" />
			</div>
		</form>
	</div>
	
	<div id="clear" style="clear: both;"></div>
</body>