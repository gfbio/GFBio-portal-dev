/*global $*/

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

//function handleRequirement(event) {
//	'use strict';
//	
//	var selection = $(event.target).val(),
//		other = $("#requirementOther");
//	if (selection === "other") {
//		other.show("slow");
//	} else {
//		other.hide();
//		other.val("");
//	}
//}

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

function handlePolicy(event) {
    'use strict';
    
    var selection = $(event.target).val(),
        other = $("#policyOther"),
        link = $("#policyLink");
    if ($.inArray("other", selection) !== -1) {
        other.show("slow");
        link.show("slow");
    } else {
        other.hide();
        link.hide();
        other.val("");
        link.val("");
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
	if (selection === "other") {
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
	if (selection === "yes") {
		div.show("slow");
	} else {
		div.hide();
		howLong.val("");
		why.val("");
	}
}

function handleArchives(event) {
	'use strict';
	
	var selection = $(event.target).val(),
		other = $("#archiveOther");
	if ($.inArray("other", selection) !== -1) {
		other.show("slow");
	} else {
		other.hide();
		other.val("");
	}
}

function showDataVolume(event) {
    'use strict';
    
    var volume = $(event.target).val(), answer = "Cannot estimate";
    if (volume === "0") {
        answer = "&lt; 1GB";
    } else if (volume === "10") {
        answer = "&lt; 10GB";
    } else if (volume === "20") {
        answer = "&lt; 100GB";
    } else if (volume === "30") {
        answer = "&gt; 100GB";
    }
    document.getElementById("volume").innerHTML = answer;
}

function showNumberOfDatasets(event) {
    'use strict';
    
    var number = $(event.target).val(), answer = "Cannot estimate";
    if (number === "0") {
        answer = "&lt; 10";
    } else if (number === "10") {
        answer = "&lt; 100";
    } else if (number === "20") {
        answer = "&lt; 1000";
    } else if (number === "30") {
        answer = "&gt; 1000";
    }
    document.getElementById("datasets").innerHTML = answer;
}

function handlePhysical(event) {
	'use strict';
	
	if ($(event.target).is(':checked') && $(event.target).val() === "true") {
        $("#alive").removeClass("disabledDiv");
        $("#sequenced").addClass("disabledDiv");
        resetInput("#sequenced");
    } else {
        $("#sequenced").removeClass("disabledDiv");
        $("#alive").addClass("disabledDiv");
        resetInput("#alive");
        $("#taxon").addClass("disabledDiv");
        resetInput("#taxon");
    }
}

function handleAlive(event) {
	'use strict';
	
	if ($(event.target).is(':checked') && $(event.target).val() === "true") {
        $("#taxon").removeClass("disabledDiv");
    } else {
    	$("#taxon").addClass("disabledDiv");
    	resetInput("#taxon");
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