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
                x = 1;
            }
        });
        if (Boolean(x)) {
            button.prop("disabled", true);
        } else {
            button.prop("disabled", false);
        }
    }
    
}

function checkboxTypes(event) {
    'use strict';
    
    if ($(event.target).is(':checked')) {
        $("#typesOther").prop("disabled", false);
    } else {
        $("#typesOther").prop("disabled", true);
        $("#typesOther").val("");
    }
}

function checkboxDataformat(event) {
    'use strict';
    
    if ($(event.target).is(':checked')) {
        $("#dataformatOther").prop("disabled", false);
    } else {
        $("#dataformatOther").prop("disabled", true);
        $("#dataformatOther").val("");
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
    
    $(event.target).disabled = true;
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

function handleSensitive(event) {
	'use strict';
	
	var selection = $(event.target).val(),
		other = $("#sensitiveOther");
	if ($.inArray("other", selection) !== -1) {
		other.show("slow");
	} else {
		other.hide();
		other.val("");
	}
}

function handleRestriction(event) {
	'use strict';
	
	var selection = $(event.target).val(),
		howLong = $("#accessHowLong"),
		why = $("#accessWhy"),
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
