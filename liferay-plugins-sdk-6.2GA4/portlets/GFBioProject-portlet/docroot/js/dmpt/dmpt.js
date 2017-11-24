/*global $*/

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

function checkboxRequirement(event) {
	'use strict';
	
	var other = $("#requirementOther");
	if ($(event.target).is(':checked')) {
		other.show("slow");
	} else {
		other.hide();
		other.val("");
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
	        
	        $("input[name='policies']:checked").each(function() {
	          	if ($(this).attr("id") != "pol-none") {
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

function handleMetadataOther(event) {
	'use strict';
    
    if ($(event.target).is(':checked')) {
        $("#metadataDesc").show("slow");
    } else {
        $("#metadataDesc").hide();
        $("#metadataDesc").val("");
    }
}

function handleLicenses(event) {
	'use strict';
	
    var selection = $(event.target).val(),
    	other = $("#licenseOther");
    if (selection === "Other License") {
		other.show("slow");
	} else {
	    other.hide();
	    other.val("");
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

function showDataVolume(event) {
    'use strict';
    
    var volume = $(event.target).val();
    var answer = getDataVolumeBySliderValue(volume);
    $("#volume").html(answer);
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
        return "&lt; 100GB";
    } else if (number === "40") {
    	return "&gt; 100GB";
    }
}

function getSliderValueByDataVolume(value) {
	'use strict';
	
	if (value === "Cannot estimate") {
        return "0";
    } else if (value === "&lt; 1GB") {
        return "10";
    } else if (value === "&lt; 10GB") {
        return "20";
    } else if (value === "&lt; 100GB") {
        return "30";
    } else if (value === "&gt; 100GB") {
    	return "40";
    }
}

function showNumberOfDataSets(event) {
    'use strict';
    
    var number = $(event.target).val();
    var answer = getDataSetBySliderValue(number)
    $("#datasets").html(answer);
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
        $("#taxon").removeClass("disabledDiv");
    } else {
    	$("#taxon").addClass("disabledDiv");
    	resetInput("taxon");
    }
}

function hide(j) {
    'use strict';
    
	$(j).hide();
	$('[name="' + j + '"]').each(function () {
        this.checked = false;
    });
}

function resetInput(j) {
	'use strict';
	
	$('[name="' + j + '"]').each(function () {
		this.checked = false;
	});
}

function isEmpty(str) {
	'use strict'
	
	return (!str || 0 === str.length);
}