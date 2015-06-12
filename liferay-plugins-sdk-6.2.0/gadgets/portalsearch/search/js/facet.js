
function listenToPubSub() {
	gadgets.Hub.subscribe("gfbio.search.facet", refreshFacet);
	gadgets.Hub.subscribe("gfbio.search.facetreset", resetFacet);
}

function appendDivAfteriFrame() {
	 var iFrame = window.parent.document.getElementById(window.frameElement.id)
	 
	 var newDivInParent = window.parent.document.createElement('div');
	 newDivInParent.setAttribute("id", "dialogFacet");
	 newDivInParent.setAttribute("title", "More Facet Terms");
	 newDivInParent.setAttribute("class", "robotofont");
	 
	 iFrame.parentNode.appendChild(newDivInParent);  
	
	 var displayHTML = "<input id='dialogFacetTerm' type='hidden'></input>";
	 displayHTML += "<input id='dialogFacetCat' type='hidden'></input>";
	var dialogDiv = parent.document.getElementById("dialogFacet");
	dialogDiv.innerHTML = displayHTML;
	
	dialog = window.parent.$('#dialogFacet').dialog({
				autoOpen: false,
				height: 300,
				width: 350,
				modal: true,
				buttons: {
					Cancel: function() {
						dialog.dialog( "close" );
					}
				},
	});         
}
					
function createYearSlider(yearFacet) {
	var minYear = getMinYear(yearFacet);
	var maxYear = getMaxYear(yearFacet);
	var minYearSelected = document.getElementById("minYearSelected").value;
	if (minYearSelected == "") minYearSelected = minYear;
	
	var maxYearSelected = document.getElementById("maxYearSelected").value;
	if (maxYearSelected == "") maxYearSelected = maxYear;
	var isSlider = $( "#slider-range" ).hasClass("ui-slider");
	if (isSlider) $( "#slider-range" ).slider( "destroy" );
	$( "#slider-range" ).slider({
	  range: true,
	  min: 	1 * minYear, // force to integer
	  max: 	1 * maxYear,
	  values: [ 1 * minYearSelected, 1 * maxYearSelected ],
	  change: function( event, ui ) {
		removeByFacetCatBasket("citation.yearFacet");
		var min = ui.values[0];
		var max = ui.values[1];
		document.getElementById("minYearSelected").value = min;
		document.getElementById("maxYearSelected").value = max;
		$( "#amount" ).val(min + " - " + max);
		addToFacetBasket("citation.yearFacet", min + " - " + max);
	  }
	});
	$( "#amount" ).val( $( "#slider-range" ).slider( "values", 0 ) +
	   " - " + $( "#slider-range" ).slider("values", 1) );
}
function writeListFacet(catName, displayName, facetArray, fieldName){
	var displayHTML = "";
	if (facetArray.length > 0){
		if (fieldName == "year") {
			displayHTML += writeYearSlider(catName,fieldName)
		}
		else {
			displayHTML += "<li data-value='"+catName+"'>"+displayName+"<ol>";
			for (var i = 0, iLen = facetArray.length; i < iLen ; i++) {
				var key = facetArray[i].key;
				var ncount = facetArray[i].doc_count;
				if ((i <5)&&(fieldName != "year")) {
					displayHTML += createFacetList(key,catName,ncount);
				}
				else if (i==5){
						displayHTML += "<li data-value='more'>"+createFacetDialog(catName,fieldName)
										+"</li>";
				}else i = iLen;
				
			}					    
			displayHTML += "</ol></li>";
		}
	}
	return displayHTML;
}

function writeYearSlider(catName,fieldName){
	return "<p><label for=\"amount\">Publication Year(s):</label>"
				+"<input type=\"text\" id=\"amount\" readonly "
				+"style=\"border:0; color:#f6931f; font-weight:bold; margin-left: 30px;\"></p>"
				+"<div id=\"slider-range\" style=\"margin-left: 30px; margin-right: 30px;\"></div>"
				+"<p style=\"margin-left: 35px;\">"+createFacetDialog(catName,fieldName)+"</p>";
}

function showMoreFacet(catName,field){
	var facetList = facetData[field].buckets;
	var displayHTML = "<input id='dialogFacetTerm' type='hidden'></input>";
	 displayHTML += "<input id='dialogFacetCat' type='hidden'></input>";
	for (var i = 0, iLen = facetList.length; i < iLen ; i++) {
		var facetTerm = facetList[i].key;
		var facetCount = facetList[i].doc_count;
		if (field == "dataCenter"){
			displayHTML += "<input type='checkbox' style='vertical-align:bottom; margin: 0px 4px 3px 0px;' value='"
						+catName+":"+facetTerm+"'>"+facetTerm
						+"<font style='font-style:italic'> ("
						+facetCount+")</font></br>";
		}
		else {
			displayHTML += "<a href='#' onclick='document.getElementById(\"dialogFacetCat\").value=\""
						+catName+"\";document.getElementById(\"dialogFacetTerm\").value=\""+facetTerm
						+"\";$(\"#dialogFacet\").dialog(\"close\");'>"+facetTerm+"</a>"
						+"<font style='font-style:italic'> ("
						+facetCount+")</font></br>";
						 
		}
	}
	var dialogDiv = parent.document.getElementById("dialogFacet");
	dialogDiv.innerHTML = displayHTML;
	
	window.parent.$('#dialogFacet').dialog("open");
}

function refreshFacet(topic, data, subscriberData) {
	var displayHTML = "";
	if (data != ""){
		var authorFacet = data.author.buckets;
		var yearFacet = data.year.buckets;
		var regionFacet = data.region.buckets;
		var dataCenterFacet = data.dataCenter.buckets;

		displayHTML += "<ol id='facet-tree'>";
		
		displayHTML += writeListFacet('citation.authorFacet', 'Author', authorFacet, 'author');

		displayHTML += writeListFacet('citation.yearFacet', 'Publication Year', yearFacet, 'year');

		displayHTML += writeListFacet('regionFacet', 'Geographical Region', regionFacet, 'region');

		displayHTML += writeListFacet('dataCenterFacet', 'Data Center', dataCenterFacet, 'dataCenter');

		displayHTML += "</ol>";		
		var facetfield = document.getElementById("search_facet_tree");
		facetfield.innerHTML = displayHTML;		
		createYearSlider(yearFacet);		
		$('#facet-tree').bonsai({expandAll: true})
		.click(function() {
			adjust();
		});
		$("#facetDiv").removeClass("invisible");	
		adjust();
	}
};

function resetFacet(topic, data, subscriberData){
	console.log(':Facet: reset facet basket');
	var basket = document.getElementById("facetBasket");
	var jsonData = {};
	jsonData.filtered = [];
	basket.value = JSON.stringify(jsonData);
	$("#facetTags").tagit('removeAll');
	var minYear = document.getElementById("minYear");
	minYear.value = "";
	var maxYear = document.getElementById("maxYear");
	maxYear.value = "";
}

function addToFacetBasket(filterCat, filterTerm){
	// add filterTerm to facetBasket
	var basket = document.getElementById("facetBasket");
	var basketStr = basket.value;
	var jsonData = {};
	var filtered = [];
	// add to basket
	if (basketStr=="") {
		jsonData.filtered = filtered;
	}else {
		jsonData = JSON.parse(basketStr);
	}
	// check if the facet is already selected, if not, then add
	var isExist = isInJSON(jsonData.filtered,"facetTerm",filterTerm);
	if (isExist==0){
		var jsonArr = {"facetCat":	filterCat,
					"facetTerm": filterTerm};
		jsonData.filtered.push(jsonArr);
		basket.value = JSON.stringify(jsonData);
		$("#facetTags").tagit('createTag',filterTerm);
		fireFacetData();
	}
};
				
function fireFacetData(){
	var jsonData = getFacetBasketJSON();
	console.log(':Facet: fire facet basket data: '+JSON.stringify(jsonData));
	gadgets.Hub.publish('gfbio.search.facetfilter', jsonData);
}

function createFacetList(dataVal,cat,count){
	return "<li data-value='"+dataVal+"'><a href='#' onclick='addToFacetBasket(\""+
			cat+"\",\""+dataVal+"\");return false;'>"+
			dataVal+"</a><font style='font-style:italic'> ("+
			count+")</font></li>";
}

function createFacetDialog(catName,field){
	return "<a href='#' onclick='showMoreFacet(\""
			+catName+"\",\""+field+"\");return false;'>More...</a>";
}

function isInJSON(array, property, value) {
	var isExist = false;
  $.each(array, function(index, result) {
	  if (result[property] == value) {
			isExist = true;
	  };
	});
	return isExist;
}

function removeFromFacetBasket(filterTerm){
	var basket = document.getElementById("facetBasket");
	var basketStr = basket.value;
	if (basketStr!="") {
		jsonData = JSON.parse(basketStr);
		jsonData.filtered = JSONfindAndRemove(jsonData.filtered,'facetTerm',filterTerm);
		basket.value = JSON.stringify(jsonData);
	}
}

function JSONfindAndRemove(array, property, value) {
	var resultArray = [];
	   $.each(array, function(index, result) {
		  if (result[property] == value) {
			  // Remove from array is not working I don't know why,
			  // just do it another way round
			  
			  // -----------------------------------------
			  // When the removed tag is a year range, then reset the slider
			  var tagLabel = result[property];
			  $("#facetTags").tagit("removeTagByLabel", tagLabel);
			  var first = tagLabel.substring(0,4);
			  var last = tagLabel.substring(7,4);
			  console.log(first);
			  console.log(last);
			  if (isNumeric(first) && isNumeric(last) && (tagLabel.indexOf(' - ') ==4)){
				var minYear = getMinYear(yearFacet);
				var maxYear = getMaxYear(yearFacet);
				var slider = document.getElementById("slider-range");
				slider.slider("option", 'min', minYear*1);
				slider.slider("option", 'max', maxYear*1);
			  }
			  // -----------------------------------------
		  }    else {
			  resultArray.push(result);
		  }
		});
	   return resultArray;
}

function getFacetBasketJSON() {
	var jsonData = {};
	var selected = [];
	var basket = document.getElementById("facetBasket");
	var basketStr = basket.value;
	if (basketStr=="") {
		jsonData.selected = selected;
	}else {
		jsonData = JSON.parse(basketStr);
	}

	return jsonData;
}

function removeByFacetCatBasket(filterCat){
	var basket = document.getElementById("facetBasket");
	var basketStr = basket.value;
	if (basketStr!="") {
		jsonData = JSON.parse(basketStr);
		jsonData.filtered = JSONfindAndRemoveWithTagRemove(jsonData.filtered,'facetCat',filterCat);
		basket.value = JSON.stringify(jsonData);
	}
}

function JSONfindAndRemoveWithTagRemove(array, property, value) {
	var resultArray = [];
	   $.each(array, function(index, result) {
		  if (result[property] == value) {
			  // Remove from array is not working I don't know why,
			  // just do it another way round
			  console.log('*****************');
			  console.log(result['facetTerm']);
			  console.log('*****************');
			  //var tagLabel = result['facetTerm'];
		  }    
		  else {
			  resultArray.push(result);
		  }
		});
	   return resultArray;
}

function getMinYear(facetArray){
	var minYear = document.getElementById("minYear").value;
	for (var i = 0, iLen = facetArray.length; i < iLen ; i++) {
		var key = facetArray[i].key;
		if (minYear=="") {
			minYear=key
			document.getElementById("minYear").value = minYear;
		}
		else if (key < minYear){ 
			minYear = key;
			document.getElementById("minYear").value = minYear;
		}
	}
	return minYear;
}
function getMaxYear(facetArray){
	var maxYear = document.getElementById("maxYear").value;
	//var maxYear = (new Date()).getFullYear();
	for (var i = 0, iLen = facetArray.length; i < iLen ; i++) {
		var key = facetArray[i].key;
		if (maxYear=="") {
			maxYear=key
			document.getElementById("maxYear").value = maxYear;
		}
		else if (key > maxYear){ 
			maxYear = key;
			document.getElementById("maxYear").value = maxYear;
		}
	}
	return maxYear;
}

function isNumeric(n) {
  return !isNaN(parseFloat(n)) && isFinite(n);
}

function adjust() {
   gadgets.window.adjustHeight();
   //console.log(':Facet: auto adjust height');
}

/*function resetFacet(topic, data, subscriberData){
	resetFacetBasket();
}*/

/*function addFilter(){
	//var allVals = [];
	var category = "";
	window.parent.$('#dialogFacet :checkbox:checked').each(function() {
	   //allVals.push($(this).val());
	   var checkedVal = $(this).val();
	   var split = checkedVal.indexOf(':');
	   category = checkedVal.substring(0,split);
	   var value = checkedVal.substring(split+1);
	   addToFacetBasket(category, value);
	});
	//console.log(allVals);
};*/

/*function closeDialog(){
	//form[ 0 ].reset();
	//allFields.removeClass( "ui-state-error" );
	var dialogFacetCat = window.parent.document.getElementById("dialogFacetCat").value;
	var dialogFacetTerm = window.parent.document.getElementById("dialogFacetTerm").value;
	if (dialogFacetTerm != "")addToFacetBasket(dialogFacetCat, dialogFacetTerm);
};*/