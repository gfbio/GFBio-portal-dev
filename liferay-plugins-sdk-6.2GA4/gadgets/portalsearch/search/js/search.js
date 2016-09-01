
				var searchAPI = 'http://ws.pangaea.de/es/dataportal-gfbio/pansimple/_search';
var cartDiv = "<div id='cart' class='cart_unselected invisible' title='Click to add/remove dataset to/from VAT (for registered user).'/>";

/////////////////////////////// Search initial functions ////////////////////////////////
/*
 * Description: Make enter press in search textbox equivalent to clicking search button
 */
function listenToEnterPress() {
	$("#gfbioSearchInput").keyup(function (event) {
		if (event.keyCode == 13) {
			$('#gfbioSearchInput').autocomplete('close');
			$("#QueryButton").click();
		}
	});
}

/*
 * Description: set autocomplete to the search textbox
 */
function setAutoComplete() {
	$('#gfbioSearchInput').autocomplete({
		minLength : 1,
		delay : 0,
		source : function (request, response) {
			$.ajax('http://ws.pangaea.de/es/portals/_suggest', {
				contentType : 'application/json; charset=UTF-8',
				type : 'POST',
				data : JSON.stringify({
					'suggest' : {
						'text' : request.term,
						'completion' : {
							'field' : 'suggest',
							'size' : 12,
						},
					},
				}),
				dataType : 'json',
				success : function (data) {
					response($.map(data.suggest[0].options, function (item) {
							return item.text;
						}));
				},
			});
		},
		open : function () {
			var maxWidth = $(document).width() - $(this).offset().left - 16;
			$(this).autocomplete('widget').css({
				'max-width' : maxWidth + "px"
			});
		},
	});
}

/*
 * Description: Read URL and extract variable
 * Input: variable name, e.g. "q_"
 * Return: keyword attaced to the variable
 */
function getQueryVariable(variable) {
	var query = document.referrer;
	var vars = query.split('&');
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split('=');
		if (decodeURIComponent(pair[0]) == variable) {
			return decodeURIComponent(pair[1]);
		}
	}
	return '';
}

/*
 * Description: Query for the latest 10 dataset and display to the result table
 * Input: JSONArray filter : filter option (Authors, Region, Data Center)
 *        String yearRange : year range option (e.g. 1999-2016)
 * Effect: The result table and facet gadget are updated
 */
function showLatestTenDataset(filter, yearRange) {
	// clear result table
	$('#tableId').DataTable().clear();
	// initiate result table
	writeResultTable();
	var oTable = $('#tableId').DataTable({
			"bDestroy" : true,
			"bPaginate" : true,
			"sPaginationType" : "simple",
			"bJQueryUI" : true,
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : searchAPI,
			"bRetrieve" : true,
			"fnServerData" : getFilteredLatestDataset(filter, yearRange),
			// for the first time loading, filter and yearRange = ""
			// assign only 3 columns for the result table
			"aoColumns" : [{
					// score column is used for sorting, hide it
					"data" : "score",
					"visible" : false,
					"sortable" : false
				}, {
					// html column is the main display
					"data" : "html",
					"visible" : true,
					"sortable" : false
				}, {
					// column displays color palette and basket cart icon
					"class" : "color-control",
					"sortable" : false,
					"data" : null,
					"defaultContent" : "<input type='text' class='full-spectrum'/>" + cartDiv
				}
			],
			"sDom" : '<"top"l<"divline"ip>>rt<"bottom"<"divline"ip>><"clear">',
			"sAutoWidth" : true,
			// define the event after the search result is returned
			"fnDrawCallback" : function (oSettings) {
				//console.log(':Search: table draw callback');
				// do nothing if table is empty
				if (!$(".dataTables_empty")[0]) {
					addColorPicker();
					setSelectedRowStyle();
					// activate parameter show/hide event
					toggleParametersField();
				}
			},
			// define the event after each table row is created
			"fnRowCallback" : function (nRow, aData, iDisplayIndex) {
				showCartIcon(nRow, aData);
			},
			"oLanguage" : {
				"sLengthMenu" : "Show _MENU_ entries per page"
			}
		});
	// activate the row click event (broadcast a message to mini-map)
	onRowClick();
};

/*
 * Description: Get latest dataset with (or without) filtering option, no keyword.
 * Input: JSONArray filter : filter option (Authors, Region, Data Center)
 *        String yearRange : year range option (e.g. 1999-2016)
 * Return: Data to display on the search result table
 */
function getFilteredLatestDataset(filter, yearRange) {
	return function (sSource, aoData, fnCallback) {
		// Read pagination parameters
		var iDisplayStart = getValueByAttribute(aoData, "name", "iDisplayStart");
		var iDisplayLength = getValueByAttribute(aoData, "name", "iDisplayLength");
		// Construct query message in JSON format
		var queryfield = createQueryFieldArray();
		var filteredQuery = getFilteredQuery("", filter, yearRange);
		var boostedQuery = applyBoost(filteredQuery);
		var completeQuery = getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength, queryfield);

		// add sorting by citation date
		completeQuery.sort = {
			"citation_date" : {
				"order" : "desc"
			}
		};

		// Store query string for sending to VAT
		document.getElementById("queryJSON").value = JSON.stringify(completeQuery);
		// Send request via AJAX
		$.ajax(sSource, {
			contentType : 'application/json; charset=UTF-8',
			type : 'POST',
			data : JSON.stringify(completeQuery),
			dataType : 'json',
			success : function (json) {
				var datasrc = json.hits.hits;
				// display facet only if the search return more than 1 result
				if (datasrc.length > 0) {
					var facet = json.aggregations;
					if (gadgets.Hub.isConnected())
						gadgets.Hub.publish('gfbio.search.facet', facet);
				} else {
					if (gadgets.Hub.isConnected())
						gadgets.Hub.publish('gfbio.search.facet', '');
				}
				// Prepare the returned result in usable format
				var res = parseReturnedJSONfromSearch(datasrc);
				json.iTotalRecords = json.hits.total;
				json.iTotalDisplayRecords = json.hits.total;
				json.data = res;
				// Return the search result to display on the table
				fnCallback(json);
			}
		});
	}
};
///////////////////////////// End Search initial functions ///////////////////////////////

/////////////////////////////// Main search functions ////////////////////////////////////

/*
 * Description: Read a keyword parameter and call getSearchResult
 *              to submit a query and display search result
 * Input: boolean clearBasket: submit a new query with clear basket command or not
 * Effect: Show the result, refresh facet and VAT
 */
function newQuery(clearBasket) {
	// clear result table
	$('#tableId').DataTable().clear();
	// read search keywords
	var keyword = document.getElementById("gfbioSearchInput").value;
	setCookie("gfbioSearchInput", keyword);
	var filter = [];
	// reset facet gadget
	if (gadgets.Hub.isConnected()){
		gadgets.Hub.publish('gfbio.search.facetreset', 'reset');
		console.log('search:reset facet');
	}
	// autocomplete from the textbox doesn't automatically closed
	$('#gfbioSearchInput').autocomplete('close');
	// send query to pansimple and parse result to the table
	getSearchResult(keyword, filter, "");

	// clear visualBasket if the clearBasket flag is true
	var visualBasket = document.getElementById("visualBasket");
	if (clearBasket)
		visualBasket.value = "";

	// send content of visual basket to the mini-map gadget
	updateMap();
}

/*
 * Description: Read and submit a keyword to search engine and display on the result table
 * Input: String keyword : search keyword
 *        JSONArray filter : filter option (Authors, Region, Data Center)
 *        String yearRange : year range option (e.g. 1999-2016)
 * Effect: Update TS, rewrite the result table
 */
function getSearchResult(keyword, filter, yearRange) {
	// every submitted query must be sent to TS gadget too
	if (gadgets.Hub.isConnected() && (keyword != "")) {
		// prevent calling ts when keyword box is empty
		gadgets.Hub.publish('gfbio.search.ts', keyword);
	}
	// create a result table as a placeholder
	writeResultTable();
	// bound a datatable to pansimple API query
	var oTable = $('#tableId').DataTable({
			"bDestroy" : true,
			"bPaginate" : true,
			"sPaginationType" : "simple",
			"bJQueryUI" : true,
			"bProcessing" : true,
			"bServerSide" : true,
			"sAjaxSource" : searchAPI, // the URL of Search API
			"bRetrieve" : true,
			"fnServerData" : submitQueryToServer(keyword, filter, yearRange),
			// assign only 3 columns for the result table
			"aoColumns" : [{
					// score column is used for sorting, hide it
					"data" : "score",
					"visible" : false,
					"sortable" : false
				}, {
					// html column is the main display
					"data" : "html",
					"visible" : true,
					"sortable" : false
				}, {
					// column displays color palette and basket cart icon
					"class" : "color-control",
					"sortable" : false,
					"data" : null,
					"defaultContent" : "<input type='text' class='full-spectrum'/>" + cartDiv
				}
			],
			"sDom" : '<"top"l<"divline"ip>>rt<"bottom"<"divline"ip>><"clear">',
			"sAutoWidth" : true,
			// define the event after the search result is returned
			"fnDrawCallback" : function (oSettings) {
				// do nothing if table is empty
				if (!$(".dataTables_empty")[0]) {
					addColorPicker();
					setSelectedRowStyle();
					// activate parameter show/hide event
					toggleParametersField()
				}
			},
			// define the event after each table row is created
			"fnRowCallback" : function (nRow, aData, iDisplayIndex) {
				showCartIcon(nRow, aData);
			},
			"oLanguage" : {
				"sLengthMenu" : "Show _MENU_ entries per page"
			}
		});
	// activate the row click event
	onRowClick();
}

/*
 * Description: Get search result from submitted keyword with (or without) filtering option
 * Input: String keyword : search keyword
 *        JSONArray filter : filter option (Authors, Region, Data Center)
 *        String yearRange : year range option (e.g. 1999-2016)
 * Output: JSONObject result : Data to display on the search result table
 */
function submitQueryToServer(keyword, filter, yearRange) {
	return function (sSource, aoData, fnCallback) {
		// set value for pagination
		var iDisplayStart = getValueByAttribute(aoData, "name", "iDisplayStart");
		var iDisplayLength = getValueByAttribute(aoData, "name", "iDisplayLength");

		// Construct query message in JSON format
		var queryfield = createQueryFieldArray();
		var filteredQuery = getFilteredQuery(keyword, filter, yearRange);
		var boostedQuery = applyBoost(filteredQuery);
		var completeQuery = getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength, queryfield);

		// Store query string for sending to VAT
		document.getElementById("queryJSON").value = JSON.stringify(completeQuery);

		// Send request via AJAX
		$.ajax(sSource, {
			contentType : 'application/json; charset=UTF-8',
			type : 'POST',
			data : JSON.stringify(completeQuery),
			dataType : 'json',
			success : function (result) {
				// get JSON result back from the server
				var datasrc = result.hits.hits;

				// display facet only if the search return more than 1 result
				if (datasrc.length > 0) {
					var facet = result.aggregations;
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', facet);
						console.log('search:set facet to:');
						console.log(facet);
					}
				} else {
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', '');
						console.log('search:clear facet');
					}
				}
				var res = parseReturnedJSONfromSearch(datasrc);
				result.iTotalRecords = result.hits.total;
				result.iTotalDisplayRecords = result.hits.total;
				result.data = res;
				// return result object
				fnCallback(result);
			}
		});
	};
};

/*
 * Description: Create a JSON Array indicating required result fields
 * Output: JSONArray jArr: array of query fields
 */
function createQueryFieldArray() {
	// list all the return field from elasticSearch here
	var jArr = [];
	jArr.push("_score");
	jArr.push("citation_title");
	jArr.push("citation_authors");
	jArr.push("description");
	jArr.push("dataCenter");
	jArr.push("region");
	jArr.push("project");
	jArr.push("parameter");
	jArr.push("investigator");
	jArr.push("internal-datestamp");
	jArr.push("maxLatitude");
	jArr.push("minLatitude");
	jArr.push("maxLongitude");
	jArr.push("minLongitude");
	//jArr.push("taxonomy");
	jArr.push("datalink");
	jArr.push("format");
	jArr.push("metadatalink");
	jArr.push("html-1");
	jArr.push("xml");
	return jArr;
}

/*
 * Description: Add filter to a JSON query message
 * Input: String keyword : search keyword
 *        JSONArray filter : filter option (Authors, Region, Data Center)
 *        String yearRange : year range option (e.g. 1999-2016)
 * Output: JSONObject : filtered query
 */
function getFilteredQuery(keyword, filterArray, yearRange) {

	var queryObj;
	if (keyword != "") {
		queryObj = {
			"simple_query_string" : {
				"query" : keyword,
				"fields" : ["fulltext", "fulltext.folded^.7", "citation^3", "citation.folded^2.1"],
				"default_operator" : "and"
			}
		};
	} else {
		queryObj = {
			"match_all" : {}
		};
	}
	var filterObj;

	if (yearRange == "") {
		if (filterArray != "") {
			filterObj = {
				"and" : {
					"filters" : filterArray
				}
			};
		} else {
			return {
				"filtered" : {
					"query" : queryObj
				}
			};
		}
	} else {
		var splitPos = yearRange.indexOf(' - ');
		var minYear = yearRange.substring(0, splitPos);
		var maxYear = yearRange.substring(splitPos + 3);
		console.log(minYear + "-" + maxYear);
		filterObj = [{
				"and" : {
					"filters" : filterArray
				}
			}, {
				"range" : {
					"citation_yearFacet" : {
						"gte" : minYear,
						"lte" : maxYear
					}
				}
			}
		]
	}

	return {
		"filtered" : {
			"query" : queryObj,
			"filter" : filterObj
		}
	};
}

/*
 * Description: Apply boosting option to a JSON query message
 * Input: JSONObject query : JSON query message with filter option
 * Output: JSONObject : boosted query
 */
function applyBoost(query) {
	return {
		"function_score" : {
			"query" : query,
			"functions" : [{
					"field_value_factor" : {
						"field" : "boost"
					}
				}
			],
			"score_mode" : "multiply"
		}
	}
}

/*
 * Description: Complete a JSON query message with query size, query field, and facets options
 * Input: JSONObject boostedQuery : a JSON query mesage with filter and boost parameters
 *        int iDisplayStart : starting index of dataset (read from pagination option)
 *        int iDisplayLength : size of dataset (read from pagination option)
 *        JSONArray queryfield : array of query fields
 * Output: JSONObject : a complete JSON request message
 */
function getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength, queryfield) {
	return {
		'query' :
		boostedQuery,
		'from' : iDisplayStart,
		'size' : iDisplayLength,
		'fields' : queryfield,
		'aggs' : {
			'author' : {
				'terms' : {
					'field' : 'citation_authorFacet',
					'size' : 50
				}
			},
			'year' : {
				'terms' : {
					'field' : 'citation_yearFacet',
					'size' : 50
				}
			},
			'region' : {
				'terms' : {
					'field' : 'regionFacet',
					'size' : 50
				}
			},
			'dataCenter' : {
				'terms' : {
					'field' : 'dataCenterFacet',
					'size' : 50
				}
			}
		}
	}
}

/*
 * Description: Read a raw JSONObject message and convert into a usable format
 * Input: JSONObject datasrc : a raw JSON message returned from the search engine
 * Output: JSONArray : a parsed returned result ready to be used by the result table
 */
function parseReturnedJSONfromSearch(datasrc) {
	var res = [];
	//console.log('parseReturnedJSONfromSearch');
	//console.log(datasrc);
	for (var i = 0, iLen = datasrc.length; i < iLen; i++) {
		var inner = new Object();
		var score = datasrc[i]._score;
		var fields = datasrc[i].fields;
		inner.score = score;
		//console.log('parseReturnedJSONfromSearch:fields');
		//console.log(fields);
		inner.title = getValueFromJSONObject(fields, "citation_title", 0);
		inner.authors = getValueFromJSONArray(fields, "citation_authors");
		inner.description = getValueFromJSONObject(fields, "description", 0);
		inner.dataCenter = getValueFromJSONObject(fields, "dataCenter", 0);
		inner.region = getValueFromJSONArray(fields, "region");
		inner.project = getValueFromJSONArray(fields, "project");
		inner.parameter = getValueFromJSONArray(fields, "parameter");
		inner.investigator = getValueFromJSONArray(fields, "investigator");
		inner.timeStamp = getValueFromJSONObject(fields, "internal-datestamp", 0);
		inner.maxLatitude = getValueFromJSONObject(fields, "maxLatitude", 0);
		inner.minLatitude = getValueFromJSONObject(fields, "minLatitude", 0);
		inner.maxLongitude = getValueFromJSONObject(fields, "maxLongitude", 0);
		inner.minLongitude = getValueFromJSONObject(fields, "minLongitude", 0);
		inner.metadatalink = getValueFromJSONObject(fields, "metadatalink", 0);
		inner.datalink = getValueFromJSONObject(fields, "datalink", 0);
		inner.format = getValueFromJSONObject(fields, "format", 0);
		if (fields["html-1"]) { 
			// this field is used only for displaying data
			var html = fields["html-1"][0];
			html = html.replace("@target@", "_blank").replace("<table", "<table class=\"html-1\"");
			inner.html = writeShowHideFields(html);
		} 
		else{
			inner.html = "";
		}
		if (fields["xml"]) { 
			// this field contains raw data, is used for basket
			var xml = fields["xml"];
			// creates object instantce of XMLtoJSON
			var xml2json = new XMLtoJSON();
			var json = xml2json.fromStr(xml);
			inner.xml = json; //JSON.stringify(json);
			console.log('-----------------');
						
			if (isJArray(json.dataset["parentIdentifier"])){
				inner.parentIdentifier = getValueFromJSONArray(json.dataset,"parentIdentifier");
			}else{
				inner.parentIdentifier = json.dataset["parentIdentifier"];
			}
			
			inner.dcIdentifier = json.dataset["dc:identifier"];
			
			if (isJArray(json.dataset["dc:type"])){
				inner.dcType = getValueFromJSONArray(json.dataset,"dc:type");
			}else{
				inner.dcType = json.dataset["dc:type"];
			}
			
		} else{
			inner.xml = "";
		}
		res.push(inner);
		//console.log('parseReturnedJSONfromSearch:inner');
		//console.log(inner);
	}
	return res;
}

/*
 * Description: Initiate a result table
 * Effect: rewrite the result table
 */
function writeResultTable() {
	var displaytext = "<table style='border: 0; cellpadding: 0; cellspacing: 0;' id='tableId' class='display'>";
	var div = document.getElementById('search_result_table');
	div.innerHTML = displaytext;
}
/////////////////////////////// End main search functions ////////////////////////////////////

//////////////////////////////////// Basket functions ////////////////////////////////////////

/*
 * Description: Load a basket data, with stored keyword and selected datasets.
 *              This function is called from a basket manager gadget, which is not currently in used
 * Input: PubSubMessage data : a message contain the basket content published by the basket manager
 * Effect: The search box is automatically filled with the basket's keyword and submitted for search
 */
function loadBasket(topic, data, subscriberData) {
	document.getElementById("basketID").value = data.basketID;
	document.getElementById("visualBasket").value = data.basketContent
		var query = JSON.parse(data.query);
	var queryStr = query.query.function_score.query.filtered.query.simple_query_string.query;
	//console.log(queryStr);
	var searchbox = document.getElementById("gfbioSearchInput");
	searchbox.value = queryStr;
	newQuery(false);
}

/*
 * Description: Update basket content to the basket table on GFBio DB
 * Effect: If the basket is already exist (from loadBasket function), append the content and update it.
 *         Otherwise, create a new basket from the selected dataset(s).
 */
function addBasket() {
	var val = document.getElementById("visualBasket").value;
	if (val == "") {
		console.log('No basket selected.');
	} else {
		// read the current portal user id for authentication in service invokation
		var uid = parent.Liferay.ThemeDisplay.getUserId();
		var basketid = document.getElementById("basketID").value;
		var query = document.getElementById("queryJSON").value;
		parent.Liferay.Service(
			'/GFBioProject-portlet.basket/update-basket', {
			basketID : basketid,
			userID : uid,
			name : uid + '_basket',
			basketContent : val,
			queryJSON : query
		},
			function (obj) {
			// set the return id as the current basket id
			if (!isNaN(obj)) {
				document.getElementById("basketID").value = obj;
			}
		});
	}
}

/*
 * Description: Read selected dataset information from the result table
 * Output: JSONObject jsonData
 */
function getSelectedResult() {
	var jsonData = {};
	var selected = [];
	var basket = document.getElementById("visualBasket");
	var basketStr = basket.value;
	// if nothing selected, return empty array []
	if (basketStr == "") {
		jsonData.selected = selected;
	} else {
		// convert basketStr to JSON object
		jsonData = JSON.parse(basketStr);
	}

	return jsonData;
}
//////////////////////////////// End Basket functions /////////////////////////////////////

/////////////////////////////// Facet filter functions ////////////////////////////////////
/*
 * Description: Parse facet filter message sent from the facet gadget
 * Effect: The selected facet is appended to the filter list and requery for the search result
 */
function applyFacetFilter(topic, data, subscriberData) {
	var facetFilters = data.filtered;
	var filteredArray = [];
	var yearRange = "";
	//console.log(':Search: receive facet filter - '+JSON.stringify(facetFilters));
	for (var i = 0; i < facetFilters.length; i++) {
		var facetFilter = facetFilters[i];
		if ((facetFilter.facetCat == "citation_yearFacet") && (facetFilter.facetTerm.indexOf(" - ") > 0)) {
			yearRange = facetFilter.facetTerm;
		} else {
			var filterStr = "{\"term\":{\"{0}\":\"{1}\"}}".format(facetFilter.facetCat, facetFilter.facetTerm);
			//console.log(':Search: filterStr - '+filterStr);
			var filterTerm = JSON.parse(filterStr);
			filteredArray.push(filterTerm);
		}
	}
	filterQuery(filteredArray, yearRange);
};

/*
 * Description: Clear the result table and requery for the filtered result
 * Effect: If the keyword is provided, call getSearchResult.
 *         Otherwise call showLatestTenDataset.
 */
function filterQuery(filter, yearRange) {
	// keep only filtered items
	// clear result table
	$('#tableId').DataTable().clear();
	var keyword = document.getElementById("gfbioSearchInput").value;
	// resubmit a query with filter to pansimple and rewrite the result table
	if (keyword != "") {
		getSearchResult(keyword, filter, yearRange);
	} else {
		showLatestTenDataset(filter, yearRange);
	}
}
/////////////////////////////// End Facet filter functions /////////////////////////////////

/////////////////////////////// Search Result UI functions /////////////////////////////////
/*
 * Description: Hilight the selected row on the result table
 * Effect: Refresh the basket value corresponding to the data selection
 */
function setSelectedRowStyle() {
	// read basket value
	var basket = document.getElementById("visualBasket");
	var basketStr = basket.value;
	var jsonData = {};
	if (basketStr != "") {
		jsonData = JSON.parse(basketStr);
		// loop through each value and compare if the
		// similar value exists on the current page
		$.each(jsonData.selected, function (index, result) {
			var selectedLink = result['metadatalink'];
			var tb = $('#tableId').DataTable();
			var displayedResult = tb.rows().data();

			$.each(displayedResult, function (ind2, res2) {
				var displayedLink = res2.metadatalink;
				if (selectedLink == displayedLink) {
					// if yes, toggle class to selected.
					var row = tb.rows().nodes()[ind2];
					row.className += ' selected';
					row.childNodes[1].childNodes[2].className = 'cart_selected';
					$(row.childNodes[1].childNodes[1]).removeClass("invisible");
				}
			});
		});
	}
}

/*
 * Description: Define event when a row on the result table is clicked
 * Effect: Toggle the row class between selected/unselected, toggle the basket cart icon,
 *         read selected data and update the basket content, and then update the mini-map.
 */
function onRowClick() {
	$('#tableId tbody').off('click');
	$('#tableId tbody').on('click', '#cart', function (e) {
		var cell = $(this).parent();
		var row = cell.parent();
		var icol = row.children().index(cell);
		var irow = row.parent().children().index(row);
		// class of the table row
		row.toggleClass('selected');

		// get Element visual basket for updating
		var basket = document.getElementById("visualBasket");
		var basketStr = basket.value;
		var jsonData = {};
		var selected = [];
		// toggle basket
		if (row.hasClass('selected')) {
			// show the icon that this item has been selected
			$(this).attr('class', 'cart_selected');
			$($(".sp-replacer")[irow]).removeClass("invisible");
			// add to basket
			if (basketStr == "") {
				jsonData.selected = selected;
			} else {
				jsonData = JSON.parse(basketStr);
			}

			var nRow = row[0];
			var tRows = $('#tableId').DataTable().rows();
			var resultArray = getDataFromSelectedRow(nRow, tRows);
			jsonData.selected.push(resultArray);
			// store basket in string format
			basket.value = JSON.stringify(jsonData);
		} else {
			// show the icon that this item is unselected,
			// and ready to be added into a cart/basket
			$(this).attr('class', 'cart_unselected');
			$($(".sp-replacer")[irow]).addClass("invisible");
			// remove from basket
			if (basketStr != "") {
				jsonData = JSON.parse(basketStr);
				// get row index to find metadatalink as id
				var nRow = row[0];
				var tRows = $('#tableId').DataTable().rows();
				var resultArray = getDataFromSelectedRow(nRow, tRows);
				// metadataLink is supposed to be unique for each dataset,
				// so I use it as an id for each row.
				jsonData.selected = JSONfindAndRemove(jsonData.selected,
						'metadatalink', resultArray.metadatalink);
				basket.value = JSON.stringify(jsonData);
			}
		}
		//update visualisation
		updateMap();
	});
}

/*
 * Description: Read dataset information from the selected row
 * Input: int nRow : row index
 *        int tRows : row's columns
 * Output: JSONObject result: Information of the selected dataset + color code
 */
function getDataFromSelectedRow(nRow, tRows) {
	var div = nRow.getElementsByClassName("sp-preview-inner")[0];
	var color = getStyle(div, "background-color");
	var iRow = nRow._DT_RowIndex;
	var value = tRows.data()[iRow];
	var result = {
		"metadatalink" : value.metadatalink,
		"datalink" : value.datalink,
		"format" : value.format,
		"timeStamp" : value.timeStamp,
		"maxLatitude" : value.maxLatitude,
		"minLatitude" : value.minLatitude,
		"maxLongitude" : value.maxLongitude,
		"minLongitude" : value.minLongitude,
		"color" : rgbToHex(color),
		"title" : value.title,
		"authors" : value.authors,
		"description" : value.description,
		"dataCenter" : value.dataCenter,
		"dcType" : value.dcType,
		"parentIdentifier": value.parentIdentifier,
		"dcIdentifier": value.dcIdentifier,
		"parameter": value.parameter,
		"xml" : value.xml
	};
	return result;
}

/*
 * Description: Check if the content in Parameters or Summary fields are too long.
 *              If yes, then truncate it and make the expand/collapse option.
 * Input: String orgHTML: the original HTML text to be displayed
 * Output: String : html text for displaying on the result table
 */
function writeShowHideFields(orgHTML) {
	var d = document.createElement('div');
	d.innerHTML = orgHTML;
	var elms = d.getElementsByClassName('desc-right');
	$.each(elms, function (index, elm) {
		var descLeft = elm.previousElementSibling;
		var field = descLeft.childNodes[0].nodeValue;

		if (field.startsWith('Parameters') || field.startsWith('Summary')) {
			var fullStr = elm.textContent;
			var limitLen = 180;
			if ((fullStr.length > limitLen) && (fullStr.length > limitLen + 5)) {
				// set two length to prevent the expansion for less than 5 characters
				var trimmedContent = fullStr.substring(0, limitLen);
				var shortenedText = '<span class="textExpanded">{0}</span>'.format(fullStr)
					 + '<span class="textCollapsed">{0}...</span>'.format(trimmedContent)
					 + '<a href="javascript:void(0)" class="textCollapsed">(+)</a>'
					 + '<a href="javascript:void(0)" class="textExpanded">(-)</a>';
				elm.innerHTML = shortenedText;
			}
		}
	});
	return d.innerHTML;
}

/*
 * Description: Update the visualisation map with selected dataset
 * Effect: Update basket content and publish the selected data to the mini map
 */
function updateMap() {
	var jsonData = getSelectedResult();
	// Add query message in JSON format
	var queryJSON = document.getElementById("queryJSON").value;
	jsonData.queryStr = queryJSON;
	addBasket();
	if (gadgets.Hub.isConnected()) {
		console.log(':Search: fire selected data: ');
		console.log(jsonData);
		gadgets.Hub.publish('gfbio.search.selectedData', jsonData);
	}
}

/*
 * Description: Create a color picker for each result row
 */
function addColorPicker() {
	// check color code at http://www.htmlcsscolor.com
	var i = 0;
	var color = "rgb(204, 204, 204)"; // #CCCCCC very light grey
	// define 10 colors preset
	$("#tableId tbody tr").each(function () {
		var row = i % 10;
		i++;
		switch (row) {
		case 0:
			color = "rgb(224, 102, 102)"; // #E06666 roman red
			break;
		case 1:
			color = "rgb(246, 178, 107)"; // #F6B26B rajah yellow
			break;
		case 2:
			color = "rgb(255, 217, 102)"; // #FFD966 dandelion yellow
			break;
		case 3:
			color = "rgb(147, 196, 125)"; // #93C47D gossip green
			break;
		case 4:
			color = "rgb(118, 165, 175)"; // #76A5AF neptune blue
			break;
		case 5:
			color = "rgb(109, 158, 235)"; // #6D9EEB cornflower blue
			break;
		case 6:
			color = "rgb(111, 168, 220)"; // #6FA8DC jordy blue
			break;
		case 7:
			color = "rgb(142, 124, 195)"; // #8E7CC3 true v violet
			break;
		case 8:
			color = "rgb(204, 0, 0)"; // #CC0000 free speech red
			break;
		case 9:
			color = "rgb(106, 168, 79)"; // #6AA84F apple green
			break;
		}
		var elm = $(this).context.childNodes;
		for (j in elm) {
			var tdClass = elm[j].className;
			if (tdClass !== undefined) {
				if (tdClass.indexOf("color-control") >= 0) {
					//console.log(color);
					var input = elm[j].childNodes[0];
					input.value = color;
					break;
				}
			}
		}
	});
	// define preset colors in selection panel
	$("input.full-spectrum").spectrum({
		//			    color: "rgb(244, 204, 204)", // default color
		//			    showInput: true, // display rgb code input
		//			    preferredFormat: "hex",
		showInitial : true,
		showPalette : true,
		showSelectionPalette : true,
		maxPaletteSize : 10,
		palette : [
			["rgb(0, 0, 0)", // black
				"rgb(67, 67, 67)", // charcoal grey
				"rgb(102, 102, 102)", // dim grey
				"rgb(204, 204, 204)", // very light grey
				"rgb(217, 217, 217)", // gainsboro grey
				"rgb(255, 255, 255)"], // white
			["rgb(244, 204, 204)", // vanilla ice pink
				"rgb(252, 229, 205)", // bisque cream
				"rgb(255, 242, 204)", // oasis cream
				"rgb(217, 234, 211)", // peppermint green
				"rgb(208, 224, 227)", // mabel blue
				"rgb(201, 218, 248)", // hawkes blue
				"rgb(207, 226, 243)", // pattens blue
				"rgb(217, 210, 233)"], // fog grey
			["rgb(234, 153, 153)", // sweet pink
				"rgb(249, 203, 156)", // peach-orange
				"rgb(255, 229, 153)", // cream brulee
				"rgb(182, 215, 168)", // madang green
				"rgb(162, 196, 201)", // jungle mist blue
				"rgb(164, 194, 244)", // tropical blue
				"rgb(159, 197, 232)", // sail blue
				"rgb(180, 167, 214)"], // biloba flower violet
			["rgb(224, 102, 102)", // roman red
				"rgb(246, 178, 107)", // rajah yellow
				"rgb(255, 217, 102)", // dandelion yellow
				"rgb(147, 196, 125)", // gossip green
				"rgb(118, 165, 175)", // neptune blue
				"rgb(109, 158, 235)", // cornflower blue
				"rgb(111, 168, 220)", // jordy blue
				"rgb(142, 124, 195)"], // true v violet
			["rgb(204, 0, 0)", // free speech red
				"rgb(230, 145, 56)", // california orange
				"rgb(241, 194, 50)", // saffron yellow
				"rgb(106, 168, 79)", // apple green
				"rgb(69, 129, 142)", // jelly bean blue
				"rgb(60, 120, 216)", // royal blue
				"rgb(61, 133, 198)", // curious blue
				"rgb(103, 78, 167)"], // blue marguerite
			["rgb(102, 0, 0)", // maroon red
				"rgb(120, 63, 4)", // raw umber brown
				"rgb(127, 96, 0)", // raw umber greenish brown
				"rgb(39, 78, 19)", // myrtle green
				"rgb(12, 52, 61)", // nordic blue
				"rgb(28, 69, 135)", // dark cerulean blue
				"rgb(7, 55, 99)", // prussian blue
				"rgb(32, 18, 77)"]// violent violet
		],
		change : function (color) {
			// read basket value
			var basket = document.getElementById("visualBasket");
			var basketStr = basket.value;
			if (basketStr != "") {
				var jsonData = {};
				jsonData = JSON.parse(basketStr);
				// get metadata link of the current row
				var col = this.parentElement;
				var row = col.parentElement;
				var tb = $('#tableId').DataTable();
				var metadatalink = tb.rows().data()[row.rowIndex - 1].metadataLink;
				// loop compare with the link in basket
				$.each(jsonData.selected, function (index, result) {
					var selectedLink = result['metadatalink'];
					if (selectedLink == metadatalink) {
						// if found the link, update row detail
						jsonData.selected[index].color = color.toHexString();
					}
				});
				basket.value = JSON.stringify(jsonData);
				updateMap();
			}
		}
	});
	$(".sp-replacer").addClass("invisible").attr("title", "Select color to display on VAT (for registered user).");
}

/*
 * Description: Display cart icon for each dataset when a location detail is available.
 * Input: nRow - row number of search result
 *        aData - json data of that row of search result
 * Effect: Cart icon will appear for each search result if they have geological data
 */
function showCartIcon(nRow, aData) {
	// show the cart icon only if the geological data is provided
	if (((aData.maxLatitude != '') || (aData.minLatitude != '')) &&
		((aData.maxLongitude != '') || (aData.minLongitude != ''))) {
		// read the current row number and get a div for the cart
		var elmRow = $(nRow);
		var elmTD = $(elmRow[0].lastElementChild);
		var elmDiv = $(elmTD[0].lastElementChild);
		// show the cart's div
		elmDiv.removeClass('invisible');
	}
}
//////////////////////////// End Search result UI functions //////////////////////////////

///////////////////////////////////  Misc functions  /////////////////////////////////////
/*
 * Description: Convert RGB code to Hex number
 * Usage: Color for each item in basket
 * Input: RGB code
 * Output: Hexadecimal value
 */
function rgbToHex(rgb) {
	var rgbRegex = /^rgb\(\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*\)$/;
	var result;
	var r;
	var g;
	var b;
	var hex = "";
	if ((result = rgbRegex.exec(rgb))) {
		r = colorCompositeFromStr(result[1], result[2]);
		g = colorCompositeFromStr(result[3], result[4]);
		b = colorCompositeFromStr(result[5], result[6]);

		hex = "0x" + (0x1000000 + (r << 16) + (g << 8) + b).toString(16).slice(1);
	}
	return hex;
}

/*
 * Description: Convert number to RGB value
 */
function colorCompositeFromStr(numStr, percent) {
	var num = Math.max(0, parseInt(numStr, 10));
	return percent ?
	Math.floor(255 * Math.min(100, num) / 100) : Math.min(255, num);
}

/*
 * Description: Read list and find a value from a matching attribute
 */
function getValueByAttribute(list, attr, val) {
	var result = null;
	$.each(list, function (index, item) {
		if (item[attr].toString() == val.toString()) {
			result = list[index].value;
			return false; // breaks the $.each() loop
		}
	});
	return result;
}

/*
 * Description: Find an object in JSON Object and remove it
 */
function JSONfindAndRemove(array, property, value) {
	var resultArray = [];
	$.each(array, function (index, result) {
		if (result[property] == value) {
			// Remove from array is not working I don't know why,
			// just do it another way round
		} else {
			resultArray.push(result);
		}
	});
	return resultArray;
}

/*
 * Description: Get HTML element's style
 */
function getStyle(x, styleProp) {
	if (x.currentStyle)
		var y = x.currentStyle[styleProp];
	else if (window.getComputedStyle)
		var y = document.defaultView.getComputedStyle(x, null).getPropertyValue(styleProp);
	return y;
}

/*
 * Description: Equilvalent to JAVA's String.format()
 */
String.prototype.format = function () {
	var formatted = this;
	for (var arg in arguments) {
		formatted = formatted.replace("{" + arg + "}", arguments[arg]);
	}
	return formatted;
};

/*
 * Description: Adjust gadget's height according to the content
 * Effect: Gadget's height is automatically adjusted
 */
function adjustGadgetHeight() {
	//console.log('auto adjust height');
	// use the height of search_gadget div + offset
	var height = $('#search_gadget').height() + 20;
	// keep minimum height to 350
	if (height < 350) {
		height = 350;
	}
	gadgets.window.adjustHeight(height);
}

/*
 * Description: Convert XML to JSON format. Used for the basket.
 */
function XMLtoJSON() {
	var me = this; // stores the object instantce

	// gets the content of an xml file and returns it in
	me.fromFile = function (xml, rstr) {
		//console.log('XMLtoJSON-fromFile');
		// Cretes a instantce of XMLHttpRequest object
		var xhttp = (window.XMLHttpRequest) ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
		// sets and sends the request for calling "xml"
		xhttp.open("GET", xml, false);
		xhttp.send(null);

		// gets the JSON string
		var json_str = jsontoStr(setJsonObj(xhttp.responseXML));

		// sets and returns the JSON object, if "rstr" undefined (not passed), else, returns JSON string
		return (typeof(rstr) == 'undefined') ? JSON.parse(json_str) : json_str;
	}

	// returns XML DOM from string with xml content
	me.fromStr = function (xml, rstr) {
		//console.log('XMLtoJSON-fromStr');
		// for non IE browsers
		if (window.DOMParser) {
			var getxml = new DOMParser();
			var xmlDoc = getxml.parseFromString(xml, "text/xml");
		} else {
			// for Internet Explorer
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.async = "false";
		}

		// gets the JSON string
		var json_str = jsontoStr(setJsonObj(xmlDoc));
		json_str = json_str.replace('\n', '');
		// sets and returns the JSON object, if "rstr" undefined (not passed), else, returns JSON string
		if (typeof(rstr) == 'undefined') {
			try {
				return JSON.parse(json_str)
			} catch (e) {
				console.log(e); //error in the above string(in this case,yes)!
				return ''
			}
		} else {
			return json_str;
		}
	}

	// receives XML DOM object, returns converted JSON object
	var setJsonObj = function (xml) {
		//console.log('XMLtoJSON-setJsonObj');
		var js_obj = {};
		if (xml.nodeType == 1) { // element
			if (xml.attributes.length > 0) {
				//js_obj["@attributes"] = {};
				for (var j = 0; j < xml.attributes.length; j++) {
					var attribute = xml.attributes.item(j);
					//js_obj["@attributes"][attribute.nodeName] = attribute.value;
					js_obj[attribute.nodeName] = attribute.value;
					//console.log('XMLtoJSON-nodeType-element:'+attribute.nodeName+" : "+attribute.value);
				}
			}
		} else if (xml.nodeType == 3) { // text
			js_obj = xml.nodeValue;
			//console.log('XMLtoJSON-nodeType-text:'+xml.nodeValue);
		}
		// do children
		if (xml.hasChildNodes()) {
			for (var i = 0; i < xml.childNodes.length; i++) {
				var item = xml.childNodes.item(i);
				var nodeName = item.nodeName;
				if (typeof(js_obj[nodeName]) == "undefined") {
					if (nodeName == "#text") {
						var content = item.textContent.trim();
						if (content != "") {
							js_obj = content;
						}
					} else
						js_obj[nodeName] = setJsonObj(item);
				} else {
					if (typeof(js_obj[nodeName].push) == "undefined") {
						var old = js_obj[nodeName];
						js_obj[nodeName] = [];
						js_obj[nodeName].push(old);
					}
					js_obj[nodeName].push(setJsonObj(item));
				}
			}
		}
		return js_obj;
	}

	// converts JSON object to string (human readablle).
	// Removes '\t\r\n', rows with multiples '""', multiple empty rows, '  "",', and "  ",; replace empty [] with ""
	var jsontoStr = function (js_obj) {
		var rejsn = JSON.stringify(js_obj, undefined, 2).replace(/(\\t|\\r|\\n)/g, '').replace(/"",[\n\t\r\s]+""[,]*/g, '')
			.replace(/(\n[\t\s\r]*\n)/g, '').replace(/[\s\t]{2,}""[,]{0,1}/g, '')
			.replace(/"[\s\t]{1,}"[,]{0,1}/g, '').replace(/\[[\t\s]*\]/g, '""');
		return (rejsn.indexOf('"parsererror": {') == -1) ? rejsn : 'Invalid XML format';
	}
};

/*
 * Description: Read value from a JSONObject
 */
function getValueFromJSONArray(jObj, name) {
	if (jObj[name] !== undefined) {
		//var res = "";
		var jArr = jObj[name];
		if (jArr.length >1){
		    return jArr;
		}else if (jArr.length =1){
		    return jArr[0];
		}
		else return "";
		/*for (var i = 0; i < jArr.length; i++) {
			res += jArr[i];
			if (i < jArr.length - 1)
				res += "; ";
		}
		return res;*/
	} else
		return "";
}

/*
 * Description: Read value[ind] from a JSONObject
 */
function getValueFromJSONObject(jObj, name, ind) {
	if (jObj[name] !== undefined)
		return jObj[name][ind];
	else
		return "";
}

/*
 * Description: Toggle collapse/expand style
 */
function toggleParametersField() {
	$(".textExpanded").hide();
	$(".textExpanded, .textCollapsed").click(function () {
		$(this).parent().children(".textExpanded, .textCollapsed").toggle();
		adjust();
	});
};

function getCookie(name) {
	var re = new RegExp(name + "=([^;]+)");
	var value = re.exec(document.cookie);
	console.log('getCookie:'+name);
	console.log(value);
	return (value != null) ? unescape(value[1]) : null;
}

function setCookie(name, value) {
	var today = new Date();
	var expiry = new Date(today.getTime() + 7 * 24 * 3600 * 1000); // plus 7 days
	document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiry.toGMTString();
	console.log('setCookie:'+name);
	console.log(value);
}  

function deleteCookie(name)
{
    document.cookie=name + "=null; path=/; expires=" + expired.toGMTString();
}

function isJArray(elm) {
    return Object.prototype.toString.call(elm) === '[object Array]';
}
///////////////////////////////////  End Misc functions  //////////////////////////////////
