
function createQueryFieldArray() {
	var jArr = [];
		jArr.push("_score");
		jArr.push("citation.title");
		jArr.push("citation.authors");
		jArr.push("description");
		jArr.push("dataCenter");
		//jArr.push("region");
		//jArr.push("project");
		//jArr.push("citation.date");
		//jArr.push("parameter");
		//jArr.push("investigator");
		jArr.push("internal-datestamp");
		jArr.push("maxLatitude");
		jArr.push("minLatitude");
		jArr.push("maxLongitude");
		jArr.push("minLongitude");
		//jArr.push("taxonomy");
		//jArr.push("datalink");
		jArr.push("metadatalink");
				jArr.push("html-1");
	return jArr;
}
function getFilteredQuery(keyword,filterArray,yearRange){
	var queryObj = {"simple_query_string": {
						"query":keyword,
						"fields": [ "fulltext", "fulltext.folded^.7", "citation^3", "citation.folded^2.1" ],
						"default_operator": "and"
					}};
	var filterObj;
	
	if (yearRange == "")
	{
		filterObj = {"and":{
						"filters":filterArray
						}
					};
	}
	else{
		var splitPos = yearRange.indexOf(' - ');
		var minYear = yearRange.substring(0, splitPos);
		var maxYear = yearRange.substring(splitPos+3);
		console.log(minYear+"-"+maxYear);
		filterObj =[{"and":{
						"filters":filterArray
					}},
					{"range": {
						"citation.yearFacet": {
							"gte": minYear,
							"lte": maxYear
						}
					}}
					]
	}
	
	return {"filtered":{
				"query":queryObj,
				"filter":filterObj
			}};
}
function applyBoost(query) {
	return {
		"function_score": {
		 "query": query,
		 "functions": [{
		   "field_value_factor": {
			 "field": "boost"
		   }
		 }],
		 "score_mode": "multiply"
	   }
	 }
}
function getCompleteQuery(boostedQuery,iDisplayStart,iDisplayLength,queryfield){
	return {
			  'query': 
				boostedQuery
			  ,
			  'from':iDisplayStart,
			  'size':iDisplayLength,
			  'fields': queryfield,
			  'aggs': {
				'author': {
					'terms': {
					'field': 'citation.authorFacet',
					'size': 50
					}
									},
				'year': {
					'terms': {
					'field': 'citation.yearFacet',
					'size': 50
					}
				},
				'region': {
					'terms': {
					'field': 'regionFacet',
					'size': 50
					}
				 },
				'dataCenter': {
					'terms': {
					'field': 'dataCenterFacet',
					'size': 50
					}
				}
			 }
		}
}

function createResultArray(nRow,tRows) {
	var div = nRow.getElementsByClassName("sp-preview-inner")[0];
	var color = getStyle(div, "background-color");
	var iRow = nRow._DT_RowIndex;
	var value = tRows.data()[iRow];
	var result = {"metadataLink":value.metadataLink,
	"timeStamp": value.timeStamp,
	"maxLatitude": value.maxLatitude,
	"minLatitude": value.minLatitude,
	"maxLongitude": value.maxLongitude,
	"minLongitude": value.minLongitude,
	"color":rgbToHex(color),
	"title": value.title,
	"authors": value.authors,
	"description": value.description,
	"dataCenter": value.dataCenter};
	return result;
}

function parseReturnedJSONfromSearch(datasrc){
	var res = [];
	for (var i = 0, iLen = datasrc.length; i < iLen; i++) {
		var inner = new Object();
		var score = datasrc[i]._score;
		var sourceObj = datasrc[i].fields;
		//console.log(sourceObj);
		inner.score  = score;
		if (sourceObj["citation.title"] !== undefined)
			inner.title  = sourceObj["citation.title"][0];
		else inner.title = "";
		if (sourceObj["citation.authors"] !== undefined)
			inner.authors = sourceObj["citation.authors"];
		else inner.authors = "";
		if (sourceObj["description"] !== undefined)
			inner.description = sourceObj["description"][0];
		else inner.description = "";
		if (sourceObj["dataCenter"] !== undefined)
			inner.dataCenter = sourceObj["dataCenter"][0];
		else inner.dataCenter = "";
		if (sourceObj["region"] !== undefined)
			inner.region = sourceObj["region"];
		else inner.region = "";
		if (sourceObj["project"] !== undefined)
			inner.project = sourceObj["project"];
		else inner.project = "";
		if (sourceObj["citation.date"] !== undefined)
			inner.citationDate = sourceObj["citation.date"];
		else inner.citationDate = "";
		if (sourceObj["parameter"] !== undefined)
			inner.parameter = sourceObj["parameter"];
		else inner.parameter = "";
		if (sourceObj["investigator"] !== undefined)
			inner.investigator = sourceObj["investigator"];
		else inner.investigator = "";
		if (sourceObj["internal-datestamp"] !== undefined)
			inner.timeStamp = sourceObj["internal-datestamp"][0];
		else inner.timeStamp = "";
		if (sourceObj["maxLatitude"] !== undefined)
			inner.maxLatitude = sourceObj["maxLatitude"][0];
		else inner.maxLatitude = undefined;
		if (sourceObj["minLatitude"] !== undefined)
			inner.minLatitude = sourceObj["minLatitude"][0];
		else inner.minLatitude = undefined;
		if (sourceObj["maxLongitude"] !== undefined)
			inner.maxLongitude = sourceObj["maxLongitude"][0];
		else inner.maxLongitude = undefined;
		if (sourceObj["minLongitude"] !== undefined)
			inner.minLongitude = sourceObj["minLongitude"][0];
		else inner.minLongitude = undefined;
		if (sourceObj["taxonomy"] !== undefined)
			inner.taxonomy = sourceObj["taxonomy"];
		else inner.taxonomy = "";
		if (sourceObj["datalink"])
			inner.dataLink = sourceObj["datalink"];
		else inner.dataLink = "";
		
		if (sourceObj["metadatalink"])
			inner.metadataLink = sourceObj["metadatalink"][0];
		else inner.metadataLink = "";
		
		if (sourceObj["html-1"]){
			var html = sourceObj["html-1"][0];
			inner.html = html.replace("@target@","_blank").replace("<table","<table class=\"html-1\"");
		}
		else inner.html = "";
		
		res.push(inner);
	}
	return res;
}
				
function writeResultTable() {
	var displaytext = "<table style='border: 0; cellpadding: 0; cellspacing: 0;' id='tableId' class='display'>";
	var div = document.getElementById('search_result_table');
	div.innerHTML = displaytext;
}

function getValueByAttribute(list, attr, val) {
	var result = null;
	$.each(list, function(index, item) {
		if (item[attr].toString() == val.toString()) {
			result = list[index].value;
			return false; // breaks the $.each() loop
		}
	});
	return result;
}

function JSONfindAndRemove(array, property, value) {
	var resultArray = [];
	   $.each(array, function(index, result) {
		  if (result[property] == value) {
			  // Remove from array is not working I don't know why,
			  // just do it another way round
		  }    else {
			  resultArray.push(result);
		  }
		});
	   return resultArray;
}

function componentFromStr(numStr, percent) {
	var num = Math.max(0, parseInt(numStr, 10));
	return percent ?
		Math.floor(255 * Math.min(100, num) / 100) : Math.min(255, num);
}

function rgbToHex(rgb) {
	var rgbRegex = /^rgb\(\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*\)$/;
	var result;
	var r;
	var g;
	var b;
	var hex = "";
	if ( (result = rgbRegex.exec(rgb)) ) {
		r = componentFromStr(result[1], result[2]);
		g = componentFromStr(result[3], result[4]);
		b = componentFromStr(result[5], result[6]);

		hex = "0x" + (0x1000000 + (r << 16) + (g << 8) + b).toString(16).slice(1);
	}
	return hex;
}

function getStyle(x,styleProp)
{
	if (x.currentStyle)
		var y = x.currentStyle[styleProp];
	else if (window.getComputedStyle)
		var y = document.defaultView.getComputedStyle(x,null).getPropertyValue(styleProp);
	return y;
}

function tog(v){return v?'addClass':'removeClass';} 