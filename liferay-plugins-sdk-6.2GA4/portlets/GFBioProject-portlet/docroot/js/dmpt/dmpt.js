/*global $*/

function isEmpty(str) {
	'use strict';
	
	return (!str || 0 === str.length);
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
    
    if ($(event.target).is(':checked')) {
        $("#typesOther").show("slow");
    } else {
        $("#typesOther").hide();
        $("#typesOther").val("");
    }
}

function checkboxDataformat(event) {
    'use strict';
    
    if ($(event.target).is(':checked')) {
        $("#dataformatOther").show("slow");
    } else {
        $("#dataformatOther").hide();
        $("#dataformatOther").val("");
    }
}

function requirements() {
	'use strict';
	
	var other = $("#requirementOther"),
        id = $(event.target).attr("id");
	
	if (id === "legal-none") {
		if ($(event.target).is(':checked')) {
	        other.hide();
	        other.val("");
	        
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
		if ($(event.target).is(':checked')) {
	        other.show("slow");
	    } else {
	        other.hide();
	        other.val("");
	    }
	}
}

function getPrincipal() {
    'use strict';
    
    var principal = $("#firstInput");
    $("#responsibleName").val(principal.val());
}

function handleFunding(event) {
    'use strict';
    
    var selection = $(event.target).val();
    if (selection !== "none" && selection !== "select") {
        $("#fundingLink").show("slow");
    } else {
        $("#fundingLink").hide();
        $("#fundingLink").val("");
        $("#fundingOther").val("");
    }
    if (selection === "other") {
        $("#fundingOther").show("slow");
    } else {
        $("#fundingOther").hide();
        $("#fundingOther").val("");
    }
}

function policies(event) {
	'use strict';
	
	var other = $("#policyOther"),
        link = $("#policyLink"),
        value = $(event.target).val();
	
	if (value === "None") {
		if ($(event.target).is(':checked')) {
	        other.hide();
	        link.hide();
	        other.val("");
	        link.val("");
	        
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
	        other.hide();
	        link.hide();
	        other.val("");
	        link.val("");
	    }
	}
}

function showMetadataInformation(event) {
	'use strict';
	
	var selection = $(event.target).val(),
	metainformation = $("#metainformation-" + selection), 
	metaurl = $("#metaurl-" + selection), 
	metadesc = $("#metadesc-" + selection);
	if ($(event.target).is(':checked')) {
		if (!isEmpty(metaurl.text()) || !isEmpty(metadesc.text())) {
			metainformation.show("slow");
		} else if (isEmpty(metaurl.text()) && isEmpty(metadesc.text())) {
			$("#metadataDesc").show("slow");
		}
	} else {
		metainformation.hide();
		if (isEmpty(metaurl.text()) && isEmpty(metadesc.text())) {
			$("#metadataDesc").hide();
	        $("#metadataDesc").val("");
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
	    other.hide();
	    other.val("");
	    
	    if (!isEmpty(licenseurl.text()) || !isEmpty(licensedesc.text())) {
	    	licensemd.show("slow");
		}
	}
	
}

//function toggleLicenseInfos(event) {
//	'use strict';
//	
//	var licenseId = $(event.target).attr('id'),
//	licenseurl = $("#licenseurl-" + licenseId), 
//	licensedesc = $("#licensedesc-" + licenseId);
//		
//	$(event.target).toggleClass('rotate');
//    $(event.target).toggleClass('rotate2');
//    
//    if (!isEmpty(licenseurl.text())) {
//    	licenseurl.toggle();
//    }
//    if (!isEmpty(licensedesc.text())) {
//    	licensedesc.toggle();
//    }
//}

function handleRestriction(event) {
	'use strict';
	
	var selection = $(event.target).val(),
		howLong = $("#accessDuration"),
		why = $("#accessReason"),
		div = $("#accessYes");
	if (selection === "true") {
		div.show("slow");
	} else {
		div.hide();
		howLong.val("");
		why.val("");
	}
}

function handleArchives(event) {
	'use strict';
	
	var other = $("#archiveOther");
	if ($(event.target).is(':checked')) {
		other.show("slow");
	} else {
		other.hide();
		other.val("");
	}
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
        $("#sequenced").addClass("disabledDiv");
        resetInput("sequenced");
    } else {
        $("#sequenced").removeClass("disabledDiv");
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

// Method for saving all inputs as json in db
function getInputAsJson() {
	'use strict';
	
    // 01 General Information
	var projectName = $("#name").val(),
        category = $("#category").find(":selected").text(),
        reproducible = $("input[name='nature']:checked").val(),
        reproducibleText = $("#reproducibleText").val(),
        projectTypes = [],
        projectAbstract = $("#abstract").val(),
        investigators = [],
        responsibleName = $("#responsibleName").val(),
        phoneNumber = $("#phone").val(),
        email = $("#email").val(),
        funding = $("#funding").val(),
        fundingLink = $("#fundingLink").val(),
        policies = [],
        policyLink = "",
        // 02 Data Collection
        physical = $("input[name='physical']:checked").val(),
        alive = $("input[name='alive']:checked").val(),
        taxon = $("input[name='taxon']:checked").val(),
        sequenced = $("input[name='sequenced']:checked").val(),
        dataformats = [],
        createFormats = $("#createFormats").val(),
        dataVolume = getDataVolumeBySliderValue($("#volumeSlider").val()),
        dataSet = getDataSetBySliderValue($("#datasetSlider").val()),
        methodologies = $("#methodologies").val(),
        // 03 Metadata
        metadata = [],
        metadataDesc = "",
        // 04 Ethics
        requirements = [],
        license = $("#licenses option:selected").text(),
        accessRestriction = $("input[name='restriction']:checked").val(),
        accessDuration = "",
        accessReason = "",
        // 05 Preservation
        backup = $("#backup").val(),
        dataArchives = [],
        pid = $("input[name='pid']:checked").val(),
        // 06 GFBio Services
        services = [];
    
    // 01 General Information
	if (category === "Select") {
        category = "";
    }
    
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
	}
	
	$("input[name='policies']:checked").each(function () {
        policies.push($(this).siblings('span').text());
    });
	
	if ($.inArray("Other", policies) > -1) {
		policies.splice($.inArray("Other", policies), 1);
		policies.push($("#policyOther").val());
		policyLink = $("#policyLink").val();
	}
	
	// 02 Data Collection
	$("input[name='dataformat']:checked").each(function () {
		dataformats.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", dataformats) > -1) {
		dataformats.splice($.inArray("Other", dataformats), 1);
		dataformats.push($("#dataformatOther").val());
	}
	
	// 03 Metadata
	$("input[name='metadata']:checked").each(function () {
		// Save only the name of the selected metadata
		var substring = $(this).siblings('span').text().split(", ")
		metadata.push(substring[0]);
    });
	if ($.inArray("Other metadata schema or version", metadata) > -1) {
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
	}

	if (accessRestriction) {
		accessDuration = $("#accessDuration").val();
		accessReason = $("#accessReason").val();
	}
	
	// 05 Preservation
	$("input[name='archives']:checked").each(function () {
		dataArchives.push($(this).siblings('span').text());
    });
	if ($.inArray("Other", dataArchives) > -1) {
		dataArchives.splice($.inArray("Other", dataArchives), 1);
		dataArchives.push($("#archiveOther").val());
	}
	
	// 06 GFBio Services
	$("input[name='services']:checked").each(function () {
		services.push($(this).siblings('span').text());
    });
	
	// Create jsonObject
	var dmptInput = {
			// 01 General Information
			"projectName" : projectName,
			"category" : category,
			"reproducible" : reproducible,
			"reproducibleText" : reproducibleText,
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
			"policies" : [],
			"policyLink" : policyLink,
			// 02 Data Collection
			"physical" : physical,
			"alive" : alive,
			"taxon" : taxon,
			"sequenced" : sequenced,
			"dataformats" : [],
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
			"backup" : backup,
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
        policies.map(function (value) {
            dmptInput.policies.push({
                "name" : value
            });
        });
    }

	if (dataformats) {
		dmptInput.dataformats = dataformats;
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
	
	if (dataArchives) {
		dmptInput.dataArchives = dataArchives;
	}
	
	if (services) {
		dmptInput.gfbioServices = services;
	}
	
	console.log("Json:", dmptInput);
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
function initializeInputs(dmptInput, id) {
	'use strict';
	
	// 01 General Information
	$("#dmpId").val(id);
	$("#name").val(dmptInput.projectName);
	if (!isEmpty(dmptInput.category)) {
		$("#category").val(dmptInput.category);
	}
	
	if (!isEmpty(dmptInput.reproducible)) {
		$("input[name='nature'][value='" + dmptInput.reproducible + "']").prop("checked", true);
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
	
	if (dmptInput.investigators) {
		var investigators = dmptInput.investigators;
		$("input[name='investigator']").val(investigators[0]);
		if (investigators.length > 1) {
			for (i = 1; i < investigators.length; i++) {
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
		$("#funding option").each(function () {
			if ($(this).val() === dmptInput.funding.name) {
				$("#funding").val(dmptInput.funding.name);
				found = true;
			}
	    });
		if (!found) {
			$("#funding").val("other");
			$("#fundingOther").val(dmptInput.funding.name);
			$("#fundingOther").show();
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
		$("#sequenced").removeClass("disabledDiv");
	}
	
	if (dmptInput.dataformats) {
		var dataformats = dmptInput.dataformats;
		for (i = 0; i < dataformats.length; i++) {
			var found = false;
			$("input[name='dataformat']").each(function () {
				if ($(this).siblings('span').text() === dataformats[i]) {
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
		var found = false;
		$("#licenses option").each(function () {
			if ($(this).text() === dmptInput.license.name) {
				$("#licenses").val($('#licenses option').filter(function () { return $(this).html() == dmptInput.license.name; }).val());
				console.info("Id: " + $("#licenses").find("option[text='" + dmptInput.license.name + "']").val());
				found = true;
				// Show additional information - url
				$("input[name='" + dmptInput.license.name + "']").parent().show();
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
        } else {
            $("input[name='restriction'][value='false']").prop("checked", true);
        }
	}
	
	// 05 Preservation
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
		
	// 06 GFBio Services
	if (dmptInput.gfbioServices) {
		var gfbioServices = dmptInput.gfbioServices;
		for (i = 0; i < gfbioServices.length; i++) {
			$("input[name='services']").each(function () {
				if ($(this).siblings('span').text() === gfbioServices[i]) {
					$(this).prop("checked", true);
				}
			});
		}
	}
}