var facetData;
var maxYear = (new Date()).getFullYear();
var minYear = maxYear;
var maxFilteredYear;
var minFilteredYear;

///////////////////////////////////////  Create Main Facet Tree  ////////////////////////////////////
function getQueryVariable(variable) {
	var url = document.referrer;
	if (parent.history.state != null){ 
		url = parent.history.state.path;
	}
	var query = url.split('?');
	if (query.length > 1){
		var vars = query[1].split('&');
		for (var i = 0; i < vars.length; i++) {
			var pair = vars[i].split('=');
			if (decodeURIComponent(pair[0]) == variable) {
				return decodeURIComponent(pair[1]);
			}
		}
	}
	return '';
}

function writeFacetTree(topic, data, subscriberData) {
	//console.log(':Facet: refresh facet tray');
	//console.log(data);
	facetData = data;
	var displayHTML = "";
	if (data != "") {
		// prepare data from main search interface
		var authorFacet = data.author.buckets;
		var yearFacet = data.year.buckets;
		var regionFacet = data.region.buckets;
		var dataCenterFacet = data.dataCenter.buckets;
		var licenseFacet = data.license.buckets;
		
		displayHTML += "<ol id='facet-tree'>";

		displayHTML += writeListFacet('citation_authorFacet', 'Author', authorFacet, 'author');

		displayHTML += writeListFacet('citation_yearFacet', 'Publication Year', yearFacet, 'year');

		displayHTML += writeListFacet('regionFacet', 'Geographical Region', regionFacet, 'region');

		displayHTML += writeListFacet('dataCenterFacet', 'Data Center', dataCenterFacet, 'dataCenter');
		
		displayHTML += writeListFacet('licenseFacet', 'License', licenseFacet, 'license');

		displayHTML += "</ol>";	

		/*displayHTML += 	"<input type='checkbox' id='showDirectAccess' value='showDirectAccess'"+
		" onchange='addToFacetTray(\"accessRestricted\",this.checked);return false;'>"+
		"Show only non-restricted access datasets</input>";*/
	}
	var facetfield = document.getElementById("search_facet_tree");
	facetfield.innerHTML = displayHTML;
	$('#facet-tree').bonsai({
		expandAll : true
	})
	.click(function () {
		adjustGadgetHeight();
	});
	// show the facet tree only if the content is available
	$("#facetDiv").removeClass("invisible");
	// Year facet offers a range selection via a slider
	createYearSlider();
	// automatically adjust height of the gadget
	adjustGadgetHeight();
};

function writeListFacet(catName, displayName, facetArray, fieldName) {
	var displayHTML = "";
	if (facetArray.length > 0) {
		if (fieldName == "year")
			displayHTML += writeYearFacet(catName, facetArray, fieldName);
		else {
			displayHTML += "<li data-value='{0}'>{1}<ol>".format(catName,displayName);
			for (var i = 0, iLen = facetArray.length; i < iLen; i++) {
				var key = facetArray[i].key;
				if (key.indexOf("\"")<0){
				//ignore the facet that contains " for now
				//TODO: find a permanent solution
					var ncount = facetArray[i].doc_count;
					if ((i < 5) && (fieldName != "year")) {
						displayHTML += "<li data-value='{0}'>".format(key);
						displayHTML += "<a href='#' onclick='addToFacetTray(\"{0}\",\"{1}\");return false;'>{2}</a>".format(catName,key,key);
						displayHTML += "<font style='font-style:italic'>({0})</font></li>".format(ncount);
					} else if (i == 5) {
						// create a link for each facet with parameters to adjust dialog content
						var link = createLinkToFacetDialog(catName, fieldName);
						displayHTML += "<li data-value='more'>{0}</li>".format(link);
					} else
						i = iLen;
				}
			}
			displayHTML += "</ol></li>";
		}
	}
	return displayHTML;
}

function writeYearFacet(catName, facetArray, fieldName) {
	setMinMaxYear(facetArray);
	var facetDialog = createLinkToFacetDialog(catName, fieldName);
	var yearFacet = "<p><label for=\"amount\">Publication Year(s):</label>";
	 yearFacet += "<input type=\"text\" id=\"amount\" readonly ";
	 yearFacet += "style=\"border:0; color:#f6931f; font-weight:bold; margin-left: 30px;\"></p>";
	 yearFacet += "<div id=\"slider-range\" style=\"margin-left: 30px; margin-right: 30px;\"></div>";
	 yearFacet += "<p style=\"margin-left: 35px;\">{0}</p>".format(facetDialog);
	 return yearFacet;
}
function createYearSlider() {
	$("#slider-range").slider({
		range : true,
		min : minYear,
		max : maxYear,
		values : [minFilteredYear, maxFilteredYear],
		change : function (event, ui) {
			var min = ui.values[0];
			var max = ui.values[1];
			$("#amount").val("{0} - {1}".format(min,max));
			// when a slider is moved, the previous year facet must be removed
			removeByFacetCatTray("citation_yearFacet");
			// and the new value of year range is added to facet list
			addToFacetTray("citation_yearFacet", "{0} - {1}".format(min,max));
		}
	});
	$("#amount").val($("#slider-range").slider("values", 0) +
		" - " + $("#slider-range").slider("values", 1));
}

function resetFacet(topic, data, subscriberData) {
	var urlFilter = getQueryVariable('filter');
	var urlYear = getQueryVariable('year');
	var keyword = getQueryVariable('q');
	if ((keyword == '')||((urlFilter =='')&& (urlYear ==''))){
		resetFacetTray();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////  More.. <facet> Dialog  /////////////////////////////////////
function addFacetDialogToPage() {
	// The dialog must be a children of the page, not the gadget.
	var iFrame = window.parent.document.getElementById(window.frameElement.id)

	var newDivInParent = window.parent.document.createElement('div');
	newDivInParent.setAttribute("id", "dialogFacet");
	newDivInParent.setAttribute("title", "More Facet Terms");
	newDivInParent.setAttribute("class", "robotofont");
	// Write a dialog placeholder on the page
	iFrame.parentNode.appendChild(newDivInParent);

	var displayHTML = "<input id='dialogFacetTerm' type='hidden'></input>";
	displayHTML += "<input id='dialogFacetCat' type='hidden'></input>";
	var dialogDiv = parent.document.getElementById("dialogFacet");
	dialogDiv.innerHTML = displayHTML;

	// set behaviour of dialog box
	dialog = window.parent.$('#dialogFacet').dialog({
			autoOpen : false,
			modal : true,
			height : 300,
			width : 350,
			buttons : {
				"Add to filter" : function () {
					var category = "";
					window.parent.$('#dialogFacet :checkbox:checked').each(function () {
						var checkedVal = $(this).val();
						var split = checkedVal.indexOf(':');
						category = checkedVal.substring(0, split);
						var value = checkedVal.substring(split + 1);
						addToFacetTray(category, value);
					});
					dialog.dialog("close");
				},
				Cancel : function () {
					// do nothing
					dialog.dialog("close");
				}
			},
			close : function () {
				var dialogFacetCat = window.parent.document.getElementById("dialogFacetCat").value;
				var dialogFacetTerm = window.parent.document.getElementById("dialogFacetTerm").value;
				if (dialogFacetTerm != "")
					addToFacetTray(dialogFacetCat, dialogFacetTerm);
			}

		});
}
function createLinkToFacetDialog(catName, field) {
	return "<a href='#' onclick='showMoreFacet(\"{0}\",\"{1}\");return false;'>More...</a>".format(catName,field);
}

function showMoreFacet(catName, field) {
	console.log('showMoreFacet');
	console.log(facetData[field]);
	var facetList = facetData[field].buckets;
	console.log(facetList);
	var displayHTML = "<input id='dialogFacetTerm' type='hidden'></input>"
		 + "<input id='dialogFacetCat' type='hidden'></input>";
	for (var i = 0, iLen = facetList.length; i < iLen; i++) {
		var facetTerm = facetList[i].key;
		var facetCount = facetList[i].doc_count;
	console.log(facetTerm);
	console.log(facetCount);
		if (facetTerm.indexOf("\"")<0){
				//ignore the facet that contains " for now
				//TODO: find a permanent solution
			if (field == "dataCenter") {
				displayHTML += "<input type='checkbox' style='vertical-align:bottom; margin: 0px 4px 3px 0px;' value='{0}:{1}'>".format(catName,facetTerm);
				displayHTML +=  "{0}<font style='font-style:italic'> ({1})</font></br>".format(facetTerm,facetCount);
			} else {
				displayHTML += "<a href='#' onclick='document.getElementById(\"dialogFacetCat\").value=\"{0}\";".format(catName);
				displayHTML += "document.getElementById(\"dialogFacetTerm\").value=\"{0}\";".format(facetTerm);
				displayHTML += "$(\"#dialogFacet\").dialog(\"close\");'>{0}</a>".format(facetTerm);
				displayHTML += "<font style='font-style:italic'> ({0})</font></br>".format(facetCount);

			}
		}
	}
	var dialogDiv = parent.document.getElementById("dialogFacet");
	dialogDiv.innerHTML = displayHTML;

	window.parent.$('#dialogFacet').dialog("open");
}
/////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////  Manage Facet Tray  /////////////////////////////////////////
function addToFacetTray(filterCat, filterTerm) {
	// add filterTerm to facetTray
	var tray = document.getElementById("facetTray");
	var trayStr = tray.value;
	var jsonData = {};
	var filtered = [];
	// add to tray
	if (trayStr == "") {
		jsonData.filtered = filtered;
	} else {
		jsonData = JSON.parse(trayStr);
	}
	// check if the facet is already selected, if not, then add
	
	var isExist = false;
	if (filterCat=="accessRestricted"){
		isExist = isInJSON(jsonData.filtered, "facetCat", "accessRestricted");
		//if the filterTerm == true, accessRestricted == false
		if (filterTerm){filterTerm = false;} //show only non-restricted download
		else {filterTerm = true;} // show all
	}else{
		isExist = isInJSON(jsonData.filtered, "facetTerm", filterTerm);
	}
	if (isExist == 0) { // if the facet has not been added
		var jsonArr = {
			"facetCat" : filterCat,
			"facetTerm" : filterTerm
		};
		if (filterCat=="accessRestricted"){
			if (filterTerm){ // show all
				removeByFacetCatTray(filterCat);
				console.log('remove facet');
				console.log(filterCat);
				console.log(filterTerm);
			}else{
				console.log('add to facet');
				jsonData.filtered.push(jsonArr);
				tray.value = JSON.stringify(jsonData);
			}
		}else{
			jsonData.filtered.push(jsonArr);
			tray.value = JSON.stringify(jsonData);
			// Display the selected facet as tagLabel
			$("#facetTags").tagit('createTag', filterTerm);
		}
		// apply the facet to the main search interface gadget
		fireFacetData();
	}
};

// publish the facet to the main search interface gadget
function fireFacetData() {
	var jsonData = {};
	var selected = [];
	var tray = document.getElementById("facetTray");
	var trayStr = tray.value;
	if (trayStr == "") {
		jsonData.selected = selected;
	} else {
		jsonData = JSON.parse(trayStr);
	}
	//console.log(':Facet: fire facet data: ' + JSON.stringify(jsonData));
	gadgets.Hub.publish('gfbio.search.facetfilter', jsonData);
}

//keep this separately to be called as a javascript function
function resetFacetTray() {
	//console.log(':Facet: reset facet tray');
	var tray = document.getElementById("facetTray");
	var jsonData = {};
	jsonData.filtered = [];
	tray.value = JSON.stringify(jsonData);
	// reset the Tag box
	$("#facetTags").tagit('removeAll');
}

function resetSearch(){
	resetFacetTray();
	
	if (gadgets.Hub.isConnected()){
		gadgets.Hub.publish('gfbio.search.resetsearch', 'reset');
	}
}

function removeFromFacetTray(filterTerm) {
	var tray = document.getElementById("facetTray");
	var trayStr = tray.value;
	if (trayStr != "") {
		jsonData = JSON.parse(trayStr);
		jsonData.filtered = removeFromJSON(jsonData.filtered, 'facetTerm', filterTerm);
		tray.value = JSON.stringify(jsonData);
	}
}

function removeByFacetCatTray(filterCat) {
	var tray = document.getElementById("facetTray");
	var trayStr = tray.value;
	if (trayStr != "") {
		jsonData = JSON.parse(trayStr);
		jsonData.filtered = removeFromJSON(jsonData.filtered, 'facetCat', filterCat);
		tray.value = JSON.stringify(jsonData);
	}
}

function removeFromJSON(array, property, value) {
	var resultArray = [];
	$.each(array, function (index, result) {
		if (result[property] == value) {
			// Remove from array is not working I don't know why,
			// just do it another way round

			var tagLabel = result[property];
			// -----------------------------------------
			// When the removed tag is a year range, then reset the slider
			if (result[property] == 'citation_yearFacet') {
				tagLabel = result['facetTerm'];

				var first = tagLabel.substring(0, 4);
				var last = tagLabel.substring(7, 11);
				if (isNumeric(first) && isNumeric(last) && (tagLabel.indexOf(' - ') == 4)) {
					$("#facetTags").tagit("removeTagByLabel", tagLabel);
					//var minYear = getMinYear(yearFacet);
					//var maxYear = getMaxYear(yearFacet);
					//var slider = document.getElementById("slider-range");
					//slider.slider("option", 'min', minYear*1);
					//slider.slider("option", 'max', maxYear*1);
				}
			}
			// -----------------------------------------
		} else {
			resultArray.push(result);
		}
	});
	return resultArray;
};
/////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////// Manage Year Range data /////////////////////////////////////////
function setMinMaxYear(facetArray) {
	minFilteredYear = 0;
	maxFilteredYear = 0;
	for (var i = 0, iLen = facetArray.length; i < iLen; i++) {
		var key = facetArray[i].key;
		if (i == 0) {
			minFilteredYear = key;
			maxFilteredYear = key;
		} else {
			if (key < minYear) {
				minYear = key;
			}
			if (key > maxYear) {
				maxYear = key;
			}
			if (key < minFilteredYear) {
				minFilteredYear = key;
			}
			if (key > maxFilteredYear) {
				maxFilteredYear = key;
			}
		}
	}
}
/*
function getMinYear(facetArray) {
var minYear = document.getElementById("minYear").value;
for (var i = 0, iLen = facetArray.length; i < iLen; i++) {
var key = facetArray[i].key;
if (minYear == "") {
minYear = key
document.getElementById("minYear").value = minYear;
} else if (key < minYear) {
minYear = key;
document.getElementById("minYear").value = minYear;
}
}
return minYear;
}
function getMaxYear(facetArray) {
var maxYear = document.getElementById("maxYear").value;
//var maxYear = (new Date()).getFullYear();
for (var i = 0, iLen = facetArray.length; i < iLen; i++) {
var key = facetArray[i].key;
if (maxYear == "") {
maxYear = key
document.getElementById("maxYear").value = maxYear;
} else if (key > maxYear) {
maxYear = key;
document.getElementById("maxYear").value = maxYear;
}
}
return maxYear;
}
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////  misc functions  ///////////////////////////////////////////
String.prototype.format = function() {
    var formatted = this;
    for( var arg in arguments ) {
        formatted = formatted.replace("{" + arg + "}", arguments[arg]);
    }
    return formatted;
};

function isInJSON(array, property, value) {
	var isExist = false;
	$.each(array, function (index, result) {
		if (result[property] == value) {
			isExist = true;
		};
	});
	return isExist;
};

function isNumeric(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}
function adjustGadgetHeight() {
	gadgets.window.adjustHeight();
	//console.log(':Facet: auto adjust height');
};
/////////////////////////////////////////////////////////////////////////////////////////////////////
