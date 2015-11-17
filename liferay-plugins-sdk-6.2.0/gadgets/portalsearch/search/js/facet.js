
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
			  var first = tagLabel.substring(0,4);
			  var last = tagLabel.substring(7,4);
			  console.log(first);
			  console.log(last);
			  if (isNumeric(first) && isNumeric(last) && (tagLabel.indexOf(' - ') ==4)){
				$("#facetTags").tagit("removeTagByLabel", tagLabel);
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