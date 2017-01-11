<%@ include file="/html/dmpt/init.jsp"%>

<script src="<%=request.getContextPath()%>/js/dmpt/jquery.steps.min.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/dmpt/dmpt.js"	type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/css/dmpt/dmpt.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/dmpt/jquery-steps.css"	rel="stylesheet" type="text/css">

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
                types : {
					required: true,
		            minlength: 1
				},
				nature : {
					required: true,
		            minlength: 1
				},
                email : {
                    required: true,
                    email: true
                },
                phoneNumber : {
                    required: false,
                    number: true
                },
                typesOther: {
                    required: {
                        depends: function(element) {
                            return $("#types-cb").is(":checked");
                        }
                    }
                },
                funding: {
                    notEqual: "select"
                },
                fundingOther: {
                    required: {
                        depends: function(element) {
                            return $("#funding").val() == "other";
                        }
                    }
                },
                policies: {
                    required: true
                },
                policyOther: {
                    required: {
                        depends: function(element) {
                            return $("#policies").val() == "other";
                        }
                    }
                },
				dataformat: {
                    required: true
                },
                dataformatOther: {
                    required: {
                        depends: function(element) {
                            return $("#dataformat-cb").is(":checked");
                        }
                    }
                },
                documentated: {
                    required: true,
                    minlength: 1
                }
			}
		});
		form.children("div").steps({
			headerTag : "h3",
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
                $("#firstInput").on("keyup focus", handlePrincipalButton);
                $("#types-cb").on("click", checkboxTypes);
                $("#princButton").on("click", addInputField);
                $("#funding").on("change", handleFunding);
                $("#fundingOther").hide();
                $("#fundingLink").hide();

                $("#policies").on("change", handlePolicy);
                $("#policyOther").hide();
                $("#policyLink").hide();

                $("#dataformat-cb").on("click", checkboxDataformat);
                $("#volumeSlider").on("input change", showDataVolume);
                $("#datasetSlider").on("input change", showNumberOfDatasets);
                
            }
        })
	});
    </script>
</head>
<body>
<div>
	<form id="example-form" action="#">
		<div>
			<h3>General Project Information</h3>
			<section>
				<div>
					<label for="name">What's the official name of your research project?</label>
                    <div class="answer_div">
					   <input id="name" name="projectName" type="text" class="required" placeholder="Project Name"/>
				    </div>
                </div>
                <div class="question_div">
                    <label for="nature">What is the nature of your research project?</label>
                    <div id="nature" class="answer_div fs_small">
                        <label>
                            <input class="radio_input" name="nature"
                            type="radio" value="reapeatable" />
                            Repeatable
                        </label>
                        <label style="margin-left: 10px;">
                            <input class="radio_input" name="nature"
                            type="radio" value="snapshot" />
                            Snapshot
                        </label>
                    </div>
				</div>
                <div class="question_div">
                    <label>Please specify your project type.</label> 
                    <div id="projectTypes" class="answer_div flex">
                        <div class="fl_w15">
                            <div>
                                <input name="types" type="checkbox"/>
                                <label>Field Work</label>
                            </div>
                            <div>
                                <input name="types" type="checkbox"/>
                                <label>Observational</label>
                            </div>
                        </div>
                        <div class="fl_w15">
                            <div>
                                <input name="types" type="checkbox"/>
                                <label>Simulation</label>
                            </div>
                            <div>
                                <input name="types" type="checkbox"/>
                                <label>Assimilation</label>
                            </div>
                        </div>
                        <div class="fl_w15">
                            <div>	
                                <input name="types" type="checkbox"/>
                                <label>Experimental</label>
                            </div>
                            <div>	
                                <input name="types" type="checkbox"/>
                                <label>Laboratory</label>
                            </div>
                        </div>
                        <div class="fs_small">
                            <div>
                                <input name="types" type="checkbox"/>
                                <label>Modelling</label>
                            </div>
                            <div>	
                                <input id="types-cb" name="types" type="checkbox"/>
                                <label>Other</label>
                                <input id="typesOther" name="typesOther" class="other_input" type="text" disabled="disabled" />
                            </div>
                        </div>
                    </div>
				</div>
                <div class="question_div">
                    <label>Provide your project abstract or describe your work and the data involved.</label>
                    <div id="projectAbstract" class="answer_div">
                        <textarea id="abstract" class="required" rows="5" cols="100" placeholder="Project Abstract"></textarea>
                    </div>
                </div>
                <div class="question_div">
                    <label>Who is/are the principal investigator/s?</label>
                    <div class="answer_div block">
                        <div id="principal">
                            <input id="firstInput" name="investigator" type="text" class="inputtext required" 
                                   placeholder="Principal Investigator" />
                        </div>
                        <div style="margin-top: 5px;">
                            <input id="princButton" type="button" value="Add principal investigator" disabled="disabled" />
                        </div>    
                    </div>
                </div>
                <div class="question_div">
                    <label>Who is responsible for the project data?</label>
                    <div id="responsible" class="answer_div" style="overflow: auto;">
                        <div style="width: 100%">
                            <input id="responsibleName" name="responsibleName" type="text" class="required inputtext fl" placeholder="Name" onfocus="getPrincipal()" />
                            <input name="email" type="email" class="inputtext mlten fl" placeholder="E-Mail"/>
                        </div>
                        <div>
                            
                        </div>
                        <div class="fl" style="width: 100%" >
                            <input name="phoneNumber" type="tel" class="inputtext" placeholder="Phone Number"/> 
                        </div>
                    </div>
                </div>
                <div class="question_div">
                    <label>For which funding are you applying?</label>
                    <div id="fundings" class="answer_div">
                        <select id="funding" name="funding">
                            <option selected="selected" label="Select" value="select" />
                            <option label="DFG Individual Grants Programmes" value="individual" />
                            <option label="DFG Coordinated Programmes" value="coordinated" />
                            <option label="DFG Excellence Strategy" value="excellence" />
                            <option label="DFG Research Infrastructure" value="research" />
                            <option label="DFG International Programmes" value="international" />
                            <option label="Other" value="other" />
                            <option label="None" value="none" />
                        </select>
                        <div>
                        <input id="fundingLink" type="text" class="inputtext_long" placeholder="Link your funding call or programme"/>
                        <input id="fundingOther" name="fundingOther" type="text" class="inputtext_long" placeholder="Please name the funding you apply for"/>
                        </div>
                    </div>
                </div>
                <div class="question_div">
                    <label>Which policies or guideliness for research data management will you follow?</label>
                    <div id="follow-policies" class="answer_div">
                        <select id="policies" name="policies" multiple="multiple" size="5">
                            <option label="DFG Guidelines on the Handling of Research Data" value="individual" />
                            <option label="DFG Guidelines on the Handling of Research Data in Biodiversity Research" value="coordinated" />
                            <option label="DFG Guidelines for Safeguarding Good Scientific Practice" value="excellence" />
                            <option label="Other" value="other" />
                            <option label="None" value="none" />
                        </select>
                        <div>
                        <input id="policyOther" name="policyOther" type="text" class="inputtext_long" placeholder="Other Research Data Policy and Guideline"/>
                        <input id="policyLink" type="text" class="inputtext_long" placeholder="Link Research Data Policy or Guideline"/>
                        </div>
                    </div>   
                </div>
			</section>
			<h3>Data Collection</h3>
			<section>
                <div class="question_div">
                    <label>DCRT Input</label>
                </div>
				<div class="question_div">
                    <label>What type of data format will you create?</label>
                    <div id="projectTypes" class="answer_div flex">
                        <div class="fl_w20">
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>Text (notes, surveys, etc.)</label>
                            </div>
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>Models, code</label>
                            </div>
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>GIS data</label>
                            </div>
                            <div>
                                <input id="dataformat-cb" name="dataformat" type="checkbox"/>
                                <label>Other</label>
                            </div>
                        </div>
                        <div class="fs_small" style="width: 30%">
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>Numeric (spreadsheet, measurements, etc.)</label>
                            </div>
                            <div>	
                                <input name="dataformat" type="checkbox"/>
                                <label>Multimedia (images, sounds, video, etc.)</label>
                            </div>
                            <div>	
                                <input name="dataformat" type="checkbox"/>
                                <label>Moleculare Sequence Data </label>
                            </div>
                            <div>	
                                <input id="dataformatOther" name="dataformatOther" class="df_input" type="text" disabled="disabled" placeholder="Other Format" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="question_div">
                    <label>Will your data format be openly documented?</label>
                     <div id="formatDocumentated" class="answer_div fs_small flex">
                        <div>
                            <input name="documentated" type="checkbox"/>
                            <label>Openly documented</label>
                        </div>
                        <div style="margin-left: 10px;">
                            <input name="documentated" type="checkbox"/>
                            <label>Only legible with special software</label>
                        </div>
                    </div>
                </div>
                <div class="question_div">
                    <label>Please estimate the data volume you will create.</label>
                    <div id="dataVolume" class="answer_div">
                        <input id="volumeSlider" type="range" min="0" max="40" value="0" step="10"/>
                        <span id="volume" class="fs_small">&lt; 1GB</span>
                    </div>
                </div>
                <div class="question_div">
                    <label>Please estimate the number of data sets (files) you will create.</label>
                    <div id="datasetNumber" class="answer_div">
                        <input id="datasetSlider" type="range" min="0" max="40" value="0" step="10"/>
                        <span id="datasets" class="fs_small">&lt; 10</span>
                    </div>
                </div>
                <div class="question_div">
                    <label>What standards, methodologies or tools for data collection will you use (e.g. Diversity Workbench, BExIS)?</label>
                    <div id="methodologies" class="answer_div">
                        <textarea id="methodologies" class="required" rows="5" cols="100" placeholder="Standards, methodologies and tools"></textarea>
                    </div>
                </div>
			</section>
			<h3>Documentation and Metadata</h3>
			<section>
				<div class="question_div">
                    <label>What metadata will accompany the data?</label>
                    <div id="metadata" class="answer_div flex fl_w20">
                        <div>
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>ABCD 2.06</label>
                            </div>
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>Dublin Core (Metadata Elements Set V1.1)</label>
                            </div>
                            <div>
                                <input name="dataformat" type="checkbox"/>
                                <label>Darwin Core</label>
                            </div>
                            <div>
                                <input id="dataformat-cb" name="dataformat" type="checkbox"/>
                                <label>Other</label>
                            </div>
                        </div>
                    </div>
                </div>
			</section>
			<h3>Ethics and Legal Compliance</h3>
			<section>
				<div class="question_div">
                    <label>Will you collect sensitive data?</label>
                </div>
				<div class="question_div">
                    <label>How will your data be licensed for reuse?</label>
                </div>
				<div class="question_div">
                    <label>Do you need access restriction for your data?</label>
                </div>
			</section>
            <h3>Preservation and Sharing</h3>
			<section>
				<div class="question_div">
                    <label>Where will your data be archived?</label>
                </div>
				<div class="question_div">
                    <label>Do you need a persistent idenfifier (e.g. ePIC PID / DOI) for your data?</label>
                </div>
				<div class="question_div">
                    <label>Do you need help estimating the cost and effort for data management?</label>
                </div>
			</section>
            <h3>GFBio Services</h3>
			<section>
                <div class="question_div">
                    <label>What GFBio services are you interested in?</label>
                </div>
			</section>
		</div>
	</form>
</div>

<div id="clear" style="clear: both;"></div>