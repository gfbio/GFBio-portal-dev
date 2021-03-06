/*global $*/

function isEmpty(str) {
	'use strict';
	
	return (!str || 0 === str.length);
}

function clearValidAndHideInputElement(element) {
		element.val("");
		element.valid();
		element.hide();
}

function simpleToggle(element, checked) {
	if (checked) {
        element.show("slow");
    } else {
        clearValidAndHideInputElement(element);
    }
}

function hideGeneralInformation() {
	'use strict';
	
	$("div.steps").hide();
	$("div.actions").hide();
	$("div[name='title']").hide();
	$("#generalinformation").hide();
}

function showGeneralInformation() {
	'use strict';
	
	$("#dmppreview").hide();
	
	$("div.steps").show();
	$("div.actions").show();
	$("div[name='title']").show();
	$("#generalinformation").show();
}

function sameContact(event) {
    'use strict';
    
    var name = $("#responsibleName").val();
    if ($(event.target).prop("checked")) {
    	$("#firstPrincInput").val(name);
    } else {
    	$("#firstPrincInput").val("");
    }
}

function handlePrincipalButton(event) {
    'use strict';
    
    var button = $("#princButton"),
        input = $(event.target),
        inputs = $("[name='investigator']"),
        x = 0;
    
    if (input.val().length < 3) {
        button.prop("disabled", true);
    } else {
        $.each(inputs, function (index, value) {
            if ($(value).val().length < 3) {
                button.prop("disabled", true);
            } else {
                button.prop("disabled", false);
            }
        });
    }
}

function removePrincipalInput(event) {
    'use strict';
    
    var input = $(event.target);
    if (input.val().length === 0) {
        event.stopPropagation();
        input.remove();
    }
}

function addInputField(event) {
    'use strict';
    
    var newinput = $('<input/>', {
        type: 'text',
        name: 'investigator',
        "class": 'inputtext',
        placeholder: 'Principal Investigator'
    });
    
    newinput.on("keyup focus", handlePrincipalButton);
    newinput.on("focusout", removePrincipalInput);
    newinput.hide();
    newinput.appendTo("#principal");
    newinput.show("slow");
    newinput.focus();
    
    event.target.disabled = true;
}

function checkboxTypes(event) {
    'use strict';
    simpleToggle($("#typesOther"), $(event.target).is(':checked'));
}

function checkboxDatatype(event) {
    'use strict';
    simpleToggle($("#datatypeOther"), $(event.target).is(':checked'));
}

function getPrincipal() {
    'use strict';
    
    var principal = $("#firstInput");
    $("#responsibleName").val(principal.val());
}

function handleFunding(event) {
    'use strict';
    
    var selection = $(event.target).val(),
		link = $("#fundingLink"),
		other = $("#fundingOther");
    if (selection !== "none" && selection !== "Select") {
        link.show("slow");
    } else {
    	clearValidAndHideInputElement(link);
        other.val("");
    }
    if (selection === "other") {
        other.show("slow");
    } else {
    	clearValidAndHideInputElement(other);
    }
}

function policies(event) {
	'use strict';
	
	var other = $("#policyOther"),
        link = $("#policyLink"),
        value = $(event.target).val();
	
	if (value === "None") {
		if ($(event.target).is(':checked')) {
			clearValidAndHideInputElement(other);
			clearValidAndHideInputElement(link);
	        
	        $("input[name='policies']:checked").each(function () {
                if ($(this).attr("id") !== "pol-none") {
                    $(this).prop("checked", false);
                }
            });
	    }
	} else {
		if ($("#pol-none").is(":checked")) {
			$("#pol-none").prop("checked", false);
		}
	}
	
	if (value === "Other") {
		if ($(event.target).is(':checked')) {
	        other.show("slow");
	        link.show("slow");
	    } else {
	    	clearValidAndHideInputElement(other);
			clearValidAndHideInputElement(link);
	    }
	}
}

function showMetadataInformation(event) {
	'use strict';
	
	var selection = $(event.target).val(),
	metainformation = $("#metainformation-" + selection), 
	metaurl = $("#metaurl-" + selection), 
	metadesc = $("#metadesc-" + selection),
	descriptioninput = $("#metadataDesc");
	if ($(event.target).is(':checked')) {
		if (!isEmpty(metaurl.text()) || !isEmpty(metadesc.text())) {
			metainformation.show("slow");
		} else if (isEmpty(metaurl.text()) && isEmpty(metadesc.text())) {
			descriptioninput.show("slow");
		}
	} else {
		metainformation.hide();
		if (isEmpty(metaurl.text()) && isEmpty(metadesc.text())) {
			clearValidAndHideInputElement(descriptioninput);
		}
	}
}

function toggleMetaInfos(event) {
	'use strict';
	
	var selection = $(event.target).attr('id'),
	metaurl = $("#metaurl-" + selection), 
	metadesc = $("#metadesc-" + selection);
		
	$(event.target).toggleClass('rotate');
    $(event.target).toggleClass('rotate2');
    
    if (!isEmpty(metaurl.text())) {
    	metaurl.toggle();
    }
    if (!isEmpty(metadesc.text())) {
    	metadesc.toggle();
    }
}

function requirements() {
	'use strict';
	
	var other = $("#requirementOther"),
        id = $(event.target).attr("id");
	
	if (id === "legal-none") {
		if ($(event.target).is(':checked')) {
			clearValidAndHideInputElement(other);
	        
	        $("input[name='requirements']:checked").each(function () {
                if ($(this).attr("id") !== "legal-none") {
                    $(this).prop("checked", false);
                }
            });
	    }
	} else {
		if ($("#legal-none").is(":checked")) {
			$("#legal-none").prop("checked", false);
		}
	}
	
	if (id === "legal-other") {
		simpleToggle(other, $(event.target).is(':checked'));
	}
}

function handleLicenses(event) {
	'use strict';
	
    var licenseId = $(event.target).val(),
	    licensemd = $("#licensemd-" + licenseId), 
		licenseurl = $("#licenseurl-" + licenseId), 
		licensedesc = $("#licensedesc-" + licenseId),
    	license = $("#licenses option:selected").text(),
        other = $("#licenseOther");
    
    $("div[id*='licensemd']").hide();
   	if (license.includes("Other")) {
		other.show("slow");
	} else {
		clearValidAndHideInputElement(other);
	    
	    if (!isEmpty(licenseurl.text()) || !isEmpty(licensedesc.text())) {
	    	licensemd.show("slow");
		}
	}
	
}

function handleRestriction(event) {
	'use strict';
	
	var selection = $(event.target).val(),
		howLong = $("#accessDuration"),
		why = $("#accessReason"),
		div = $("#accessYes");
	if (selection === "true") {
		div.show("slow");
	} else {
		howLong.val("");
		why.val("");
		howLong.valid();
		why.valid();
		div.hide();
	}
}

function handleSubmission(event) {
	'use strict';
	simpleToggle($("#submitOther"), $(event.target).is(':checked'));
}

function handleArchives(event) {
	'use strict';
	simpleToggle($("#archiveOther"), $(event.target).is(':checked'));
}

function getDataVolumeBySliderValue(number) {
	'use strict';
	
	if (number === "0") {
        return "Cannot estimate";
    } else if (number === "10") {
        return "&lt; 1GB";
    } else if (number === "20") {
    	return "&lt; 10GB";
    } else if (number === "30") {
        return "&lt; 1TB";
    } else if (number === "40") {
        return "&lt; 5TB";
    } else if (number === "50") {
    	return "&lt; 10TB";
    } else if (number === "60") {
        return "&gt; 10TB";
    }
}

function showDataVolume(event) {
    'use strict';
    
    var volume = $(event.target).val(),
        answer = getDataVolumeBySliderValue(volume);
    $("#volume").html(answer);
}


function getSliderValueByDataVolume(value) {
	'use strict';
	
	if (value === "Cannot estimate") {
        return "0";
    } else if (value === "&lt; 1GB") {
        return "10";
    } else if (value === "&lt; 10GB") {
        return "20";
    } else if (value === "&lt; 1TB") {
        return "30";
    } else if (value === "&lt; 5TB") {
    	return "40";
    } else if (value === "&lt; 10TB") {
    	return "50";
    } else if (value === "&gt; 10TB") {
        return "60";
    }
}

function getDataSetBySliderValue(number) {
	'use strict';
	
	if (number === "0") {
        return "Cannot estimate";
    } else if (number === "10") {
        return "&lt; 10";
    } else if (number === "20") {
        return "&lt; 100";
    } else if (number === "30") {
        return "&lt; 1000";
    } else if (number === "40") {
        return "&gt; 1000";
    }
}

function showNumberOfDataSets(event) {
    'use strict';
    
    var number = $(event.target).val(),
        answer = getDataSetBySliderValue(number);
    $("#datasets").html(answer);
}

function getSliderValueByDataSet(value) {
	'use strict';
	
	if (value === "Cannot estimate") {
        return "0";
    } else if (value === "&lt; 10") {
        return "10";
    } else if (value === "&lt; 100") {
        return "20";
    } else if (value === "&lt; 1000") {
        return "30";
    } else if (value === "&gt; 1000") {
        return "40";
    }
}

function resetInput(j) {
	'use strict';
	
	$('[name="' + j + '"]').each(function () {
		this.checked = false;
	});
}

function handlePhysical(event) {
	'use strict';
	
	if ($(event.target).is(':checked') && $(event.target).val() === "true") {
        $("#alive").removeClass("disabledDiv");
    } else {
        $("#alive").addClass("disabledDiv");
        resetInput("alive");
        $("#taxon").addClass("disabledDiv");
        resetInput("taxon");
    }
}

function handleAlive(event) {
	'use strict';
	
	if ($(event.target).is(':checked') && $(event.target).val() === "true") {
		$("#taxon").addClass("disabledDiv");
        resetInput("taxon");
    } else {
        $("#taxon").removeClass("disabledDiv");
    }
}

function hide(j) {
    'use strict';
    
	$(j).hide();
	$('[name="' + j + '"]').each(function () {
        this.checked = false;
    });
}

// Get services for sending request
function getServices() {
	'use strict';
	
	var list = [];
	var services = $("input[name='gfbio_services']:checked");
	
	$.each( services, function( index ) {
		list.push($(this).val());
	})
	
	return list;
}

// Method for saving all inputs as json in db
function getInputAsJson() {
	'use strict';
	
    // 01 General Information
	var projectName = $("#name").val(),
        category = $("#category").find(":selected").text(),
        reproducible = [],
        reproducibleText = $("#reproducibleText").val(),
        projectTypes = [],
        projectAbstract = $("#abstract").val(),
        responsibleName = $("#responsibleName").val(),
        phoneNumber = $("#phone").val(),
        email = $("#email").val(),
        investigators = [],
        funding = $("#funding option:selected").text(),
        fundingLink = $("#fundingLink").val(),
        coordinatedProgramme = $("#coordinatedProgramme").val(),
        researchUnit = $("#researchUnit").prop("checked"),
        researchProposal = $("#researchProposal").val(),
        policies = [],
        policyLink = "",
        // 02 Data Collection
        physical = $("input[name='physical']:checked").val(),
        alive = $("input[name='alive']:checked").val(),
        taxon = $("input[name='taxon']:checked").val(),
        sequenced = $("input[name='sequenced']:checked").val(),
        datatypes = [],
        createFormats = $("#createFormats").val(),
        dataVolume = getDataVolumeBySliderValue($("#volumeSlider").val()),
        dataSet = getDataSetBySliderValue($("#datasetSlider").val()),
        methodologies = $("#methodologies").val(),
        // 03 Metadata
        metadata = [],
        metadataDesc = "",
        // 04 Ethics
        requirements = [],
        license = $("#licenses option:selected").text().trim(),
        accessRestriction = $("input[name='restriction']:checked").val(),
        accessDuration = "",
        accessReason = "",
        // 05 Preservation
        dataSubmissions = [],
        backup = $("#backup").val(),
        dataArchives = [],
        pid = $("input[name='pid']:checked").val();
    
    // 01 General Information
	if (category === "Select") {
        category = "";
    }
	
	$("input[name='reproducible']:checked").each(function () {
		reproducible.push($(this).val());
    });
    
	$("input[name='types']:checked").each(function () {
        projectTypes.push($(this).siblings('span').text());
    });
    
	if ($.inArray("Other", projectTypes) > -1) {
		projectTypes.splice($.inArray("Other", projectTypes), 1);
		projectTypes.push($("#typesOther").val());
	}
	
	$("input[name='investigator']").each(function () {
		investigators.push($(this).val());
    });

	if (funding === "other") {
		funding = $("#fundingOther").val();
	} else if (funding === "Select") {
		funding = "";
	}
	
	$("input[name='policies']:checked").each(function () {
        policies.push($(this).siblings('span').text());
    });
	
	if ($.inArray("Other", policies) > -1) {
		policies.splice($.inArray("Other", policies), 1);
		if ($("#policyOther").val() !== "") {
			policies.push($("#policyOther").val());
		}
		policyLink = $("#policyLink").val();
	}
	
	// 02 Data Collection
	$("input[name='datatype']:checked").each(function () {
		datatypes.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", datatypes) > -1) {
		datatypes.splice($.inArray("Other", datatypes), 1);
		datatypes.push($("#datatypeOther").val());
	}
	
	// 03 Metadata
	$("input[name='metadata']:checked").each(function () {
		// Save only the name of the selected metadata
		var substring = $(this).siblings('span').text().split(", ")
		metadata.push(substring[0]);
    });
	if (metadata.includes("Other metadata or documentation")) {
		metadataDesc = $("#metadataDesc").val();
	}

	// 04 Ethics
	$("input[name='requirements']:checked").each(function () {
		requirements.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", requirements) > -1) {
		requirements.splice($.inArray("Other", requirements), 1);
		requirements.push($("#requirementOther").val());
	}
	
	if (license === "Other License") {
		license = $("#licenseOther").val();
	} else if (license === "Select") {
		license = "";
	}

	if (accessRestriction) {
		accessDuration = $("#accessDuration").val();
		accessReason = $("#accessReason").val();
	}
	
	// 05 Preservation
	$("input[name='dataSubmission']:checked").each(function () {
		dataSubmissions.push($(this).siblings('span').text());
    });
	if ($.inArray("Other submission plan", dataSubmissions) > -1) {
		dataSubmissions.splice($.inArray("Other submission plan", dataSubmissions), 1);
		dataSubmissions.push($("#submitOther").val());
	}
	
	$("input[name='archives']:checked").each(function () {
		dataArchives.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", dataArchives) > -1) {
		dataArchives.splice($.inArray("Other", dataArchives), 1);
		dataArchives.push($("#archiveOther").val());
	}
	
	// Create jsonObject
	var dmptInput = {
			// 01 General Information
			"projectName" : projectName,
			"category" : category,
			"reproducible" : [],
			"reproducibleText" : reproducibleText,
			"projectTypes": [],
			"projectAbstract" : projectAbstract,
			"responsibleName" : responsibleName,
			"phoneNumber" : phoneNumber,
			"email" : email,
			"investigators" : [],
			"funding" : {
				"name" : funding
			},
			"fundingLink" : fundingLink,
			"coordinatedProgramme" : coordinatedProgramme,
	        "researchUnit" : researchUnit,
	        "researchProposal" : researchProposal,
			"policies" : [],
			"policyLink" : policyLink,
			// 02 Data Collection
			"physical" : physical,
			"alive" : alive,
			"taxon" : taxon,
			"sequenced" : sequenced,
			"datatypes" : [],
			"createFormats" : createFormats,
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
			"dataSubmissions" : [],
			"backup" : backup,
			"dataArchives" : [],
			"pid" : pid
        };
    
	// Set Arrays
	if (reproducible) {
		dmptInput.reproducible = reproducible;
	}
	
	if (projectTypes) {
		dmptInput.projectTypes = projectTypes;
	}

	if (investigators) {
		dmptInput.investigators = investigators;
	}
		
    if (policies) {
        policies.map(function (value) {
            dmptInput.policies.push({
                "name" : value
            });
        });
    }

	if (datatypes) {
		dmptInput.datatypes = datatypes;
	}
	
	if (metadata) {
		metadata.map(function (value) {
			dmptInput.metadata.push({
				"name" : value
            });
        });
	}
	
	if (requirements) {
		requirements.map(function (value) {
			dmptInput.requirements.push({
				"name" : value
			});
		});
	}
	
	if (dataSubmissions) {
		dmptInput.dataSubmissions = dataSubmissions;
	}
	
	if (dataArchives) {
		dmptInput.dataArchives = dataArchives;
	}
	
	//console.log("Json:", dmptInput);
	return JSON.stringify(dmptInput);
}

function addInvestigator(investigator) {
    'use strict';

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


// Method for loading Json data and initialize the wizard
function initializeWizard(dmptInput, id) {
	'use strict';
	// Enable all tabs
	$("li.disabled").each(function () {
		$(this).removeClass("disabled").addClass("done");
	})
		
	// 01 General Information
	$("#dmpId").val(id);
	$("#name").val(dmptInput.projectName);
	if (!isEmpty(dmptInput.category)) {
		$("#category").val(dmptInput.category);
	}
	
	if (!isEmpty(dmptInput.reproducible)) {
		var reproducible = dmptInput.reproducible;
		for (i = 0; i < reproducible.length; i++) {
			$("input[name='reproducible']").each(function () {
				if ($(this).val() === reproducible[i]) {
					$(this).prop("checked", true);
				}
			});
		}
	}
	
	if (!isEmpty(dmptInput.reproducibleText)) {
		$("#reproducibleText").val(dmptInput.reproducibleText);
	}
	
	//Variable for for-loops
    var i;
    
	if (dmptInput.projectTypes) {
		var projectTypes = dmptInput.projectTypes;
		for (i = 0; i < projectTypes.length; i++) {
			var found = false;
			$("input[name='types']").each(function () {
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
		$("#abstract").val(dmptInput.projectAbstract);
	}
	
	if (!isEmpty(dmptInput.responsibleName)) {
		$("#responsibleName").val(dmptInput.responsibleName);
	}
	
	if (!isEmpty(dmptInput.phoneNumber)) {
		$("#phone").val(dmptInput.phoneNumber);
	}
	
	if (dmptInput.investigators) {
		var investigators = dmptInput.investigators;
		$("input[name='investigator']").val(investigators[0]);
		if (investigators.length > 1) {
			for (i = 1; i < investigators.length; i++) {
				addInvestigator(investigators[i]);
			}
		}
	}
	
	if (dmptInput.funding) {
		var found = false,
			funding = dmptInput.funding.name;
		if (funding === "") funding = "Select";
		$("#funding option").each(function () {
			if ($(this).text() === funding) {
				$(this).prop("selected", true);
				found = true;
			}
	    });
		if (!found) {
			$("#funding").val("other");
			$("#fundingOther").val(funding);
			$("#fundingOther").show();
		}
		
		if (funding !== "None" && funding !== "Select") {
			if (!isEmpty(dmptInput.fundingLink)) {
				$("#fundingLink").val(dmptInput.fundingLink);
			}
			$("#fundingLink").show();
		}
	}
	
	if (!isEmpty(dmptInput.coordinatedProgramme)) {
		$("#coordinatedProgramme").val(dmptInput.coordinatedProgramme);
	}
	
	var researchUnit = dmptInput.researchUnit;
	if (researchUnit) {
		$("#researchUnit").prop("checked", true);
	}
	
	if (!isEmpty(dmptInput.researchProposal)) {
		$("#researchProposal").val(dmptInput.researchProposal);
	}
	
	if (dmptInput.policies) {
		var policies = dmptInput.policies;
		for (i = 0; i < policies.length; i++) {
			var found = false;
			$("input[name='policies']").each(function () {
                if ($(this).siblings('span').text() === policies[i].name) {
                    $(this).prop("checked", true);
                    found = true;
                }
            });
			if (!found) {
				$("input[name='policies'][value='Other']").prop("checked", true);
				$("#policyLink").show();
				if (!isEmpty(dmptInput.policyLink)) {
					$("#policyLink").val(dmptInput.policyLink);
				}
				$("#policyOther").show();
				$("#policyOther").val(policies[i].name);
			}
		}
	}
	
	// 02 Data Collection
	var physical = dmptInput.physical,
		alive = dmptInput.alive,
		taxon = dmptInput.taxon,
		sequenced = dmptInput.sequenced;
	if (physical !== null) {
		$("input[name='physical'][value='" + dmptInput.physical + "']").prop("checked", true);
	}
	if (alive === "true" || alive === "false") {
		$("input[name='alive'][value='" + dmptInput.alive + "']").prop("checked", true);
		$("#alive").removeClass("disabledDiv");
	}
	if (taxon === "true" || taxon === "false") {
		$("input[name='taxon'][value='" + dmptInput.taxon + "']").prop("checked", true);
		$("#taxon").removeClass("disabledDiv");
	}
	if (sequenced === "true" || sequenced === "false") {
		$("input[name='sequenced'][value='" + dmptInput.sequenced + "']").prop("checked", true);
	}
	
	if (dmptInput.datatypes) {
		var datatypes = dmptInput.datatypes;
		for (i = 0; i < datatypes.length; i++) {
			var found = false;
			$("input[name='datatype']").each(function () {
				if ($(this).siblings('span').text() === datatypes[i]) {
					$(this).prop("checked", true);
					found = true;
				}
			});
			if (!found) {
				$("input[name='datatype'][value='Other']").prop("checked", true);
				$("#datatypeOther").val(datatypes[i]);
				$("#datatypeOther").show();
			}
		}
	}
	
	if (!isEmpty(dmptInput.createFormats)) {
		$("#createFormats").val(dmptInput.createFormats);
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
		$("#methodologies").val(dmptInput.methodologies);
	}
	
	// 03 Metadata
	if (dmptInput.metadata) {
		var metadata = dmptInput.metadata;
		for (i = 0; i < metadata.length; i++) {
			$("input[name='metadata']").each(function () {
				var substring = $(this).siblings('span').text().split(", ");
                if (substring[0] === metadata[i].name) {
                    $(this).prop("checked", true);
                    // Show metadata additional information div
                    $("input[name='" + metadata[i].name + "']").parent().show();
                }
            });
			if (metadata[i].name.includes("Other")) {
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
		for (i = 0; i < requirements.length; i++) {
			var found = false;
			$("input[name='requirements']").each(function () {
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
		var found = false, 
			license = dmptInput.license.name;
		if (license === "") license = "Select";
		$("#licenses option").each(function () {
			if ($(this).text().trim() === license) {
				$("#licenses").val($('#licenses option').filter(function () { return $(this).html().trim() == license; }).val());
				found = true;
				// Show additional information - url
				$("input[name*='" + license + "']").parent().show();
			}
	    });
		if (!found) {
			$("#licenses").val($('#licenses option').filter(function () { return $(this).html() == "Other License"; }).val());
			$("#licenseOther").val(dmptInput.license.name);
			$("#licenseOther").show();
		}
	}
	 
	if (dmptInput.accessRestriction !== null) {
		if (dmptInput.accessRestriction === "true") {
			$("input[name='restriction'][value='true']").prop("checked", true);
			if (dmptInput.accessDuration) {
                $("#accessDuration").val(dmptInput.accessDuration);
			}
			if (dmptInput.accessReason) {
				$("#accessReason").val(dmptInput.accessReason);
			}
			$("#accessYes").show();
        } else if (dmptInput.accessRestriction === "false") {
            $("input[name='restriction'][value='false']").prop("checked", true);
        }
	}
	
	// 05 Preservation
	if (dmptInput.dataSubmissions) {
		var dataSubmissions = dmptInput.dataSubmissions;
		for (i = 0; i < dataSubmissions.length; i++) {
			var found = false;
			$("input[name='dataSubmission']").each(function () {
				if ($(this).siblings('span').text() === dataSubmissions[i]) {
					$(this).prop("checked", true);
					found = true;
				}
			});
			if (!found) {
				$("input[name='dataSubmission'][value='Other submission plan']").prop("checked", true);
				$("#submitOther").val(dataSubmissions[i]);
				$("#submitOther").show();
			}
		}
	}
	
	if (!isEmpty(dmptInput.backup)) {
		$("#backup").val(dmptInput.backup);
	}
	
	if (dmptInput.dataArchives) {
		var dataArchives = dmptInput.dataArchives;
		for (i = 0; i < dataArchives.length; i++) {
			var found = false;
			$("input[name='archives']").each(function () {
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

	if (dmptInput.pid !== null) {
		$("input[name='pid'][value='" + dmptInput.pid + "']").prop("checked", true);
	}
		
}