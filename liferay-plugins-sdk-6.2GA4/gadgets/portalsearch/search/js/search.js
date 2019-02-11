var searchAPI = "//ws.pangaea.de/es/dataportal-gfbio/pansimple/_search";
var cartAddTitle = "Click to add dataset to VAT basket.";
var cartRemTitle = "Click to remove dataset from VAT basket.";
//var cartDiv = "<div id='cart' class='cart_unselected invisible' title='"+cartAddTitle+"'></div>";
var cartCheckbox = "<input type='checkbox' class='basketCheck'></input>";
var cartDivDisabled = 'This dataset cannot be visualized.';
var ratingDiv = "<div id='ratingDiv' title='Please provide us your feedback of this result (5:Highly relevant - 1:Irrelevant)'><select class='ratebar'><option value='5'>5</option><option value='4'>4</option><option value='3'>3</option><option value='2'>2</option><option value='1'>1</option></select></div>";
var VATpage = '/data/visualizeandanalyze';
var linkVAT = '<a href="javascript:showBasketDialog();" class="basketIcon invisible" title="Download or see your basket in VAT."></a>';
var showRating = 0;
var saveSearch = 1;

/////////////////////////////// Search initial functions ////////////////////////////////
/*
 * Description: Make enter press in search textbox equivalent to clicking search button
 */
function listenToEnterPress() {
	$("#gfbioSearchInput").keyup(function (event) {
		if (event.keyCode == 13) {
			$('#gfbioSearchInput').autocomplete('close');
			searchButtonClicked();
		}
	});
}

function resetSearch(){
	$("#visualBasket").val("");
	$("#basketID").val(0); 
	$("#queryJSON").val("");
	$("#queryKeyword").val("");
	$("#queryFilter").val("[]");
	$("#gfbioSearchInput").val("");
	insertParam("q", "");
	insertParam("filter", "");
	insertParam("year", "");
	
	if (gadgets.Hub.isConnected()){
		gadgets.Hub.publish('gfbio.search.facetreset', 'reset');
	}
	
	showLatestTenDataset([],"");
}
function resetFilter(){
	$("#visualBasket").val("");
	$("#basketID").val(0); 
	$("#queryJSON").val("");
	$("#queryKeyword").val("");
	$("#queryFilter").val("[]");
	insertParam("filter", "");
	insertParam("year", "");
}
function searchButtonClicked(){
	var value = $("#gfbioSearchInput").val();
	insertParam("q", value);
	if (value == ''){
		resetSearch();
	}else{
		if (gadgets.Hub.isConnected()){
			gadgets.Hub.publish('gfbio.search.facetreset', 'reset');
		}
		resetFilter();
		newQuery(true);
	}
}

function isValueNotEmpty(value){
	return (!value.isArray && value!='' & value !='[]') || (value.isArray && value.length >0);
}

function insertParam(key, value) {
	var urlString = document.referrer;
	var valueNotEmpty = isValueNotEmpty(value);
	if (parent.history.state != null){ 
		//if any parameter has been popped to the state
		//console.log(':::insertParam parent.history.state.path');	
		//console.log(parent.history.state.path);
		urlString = parent.history.state.path;
	}
	var url = urlString.split('?');
	var urlDomain = url[0];
	//console.log(url);
	var newUrl = urlDomain;
	 
	value = encodeURIComponent(value);
		
	var isNewParam = true;
	if (url.length >1){
		// if url already has parameters
		//console.log(':::insertParam append Parameter');	
		var urlParam = url[1];
		var paramsArray = urlParam.split('&');
		var paramsString = '';
		// check the current parameters, replace when the key is matched
		for (i=0; i< paramsArray.length; i++){
			// replace the inserted value that matched with the key
			var par = paramsArray[i].split('=');
			// find if the parameter is already added to the url
			if (par[0] == key) {
				//console.log(':::insertParam replace parameter');	
				par[1] = value;
				isNewParam = false;
			}
			if (par[0] != key || valueNotEmpty){
				if (paramsString == ''){
					paramsString += par.join('=');
				}else{
					paramsString += '&'+par.join('=');
				}
			}
		}
			
		if (paramsString!=''){
			//console.log(':::insertParam append to Params in URL');	
			newUrl += '?'+paramsString;
			if (isNewParam && valueNotEmpty) {
				newUrl += '&'+key+"="+value;
			}
		}else{
			//console.log(':::insertParam add to URL');	
			if (isNewParam && valueNotEmpty) {
				newUrl += '?'+key+"="+value;
			}
		}
	}
	else if (url.length==1 && valueNotEmpty){
		//if no parameter in url, and there is a parameter to update
		//console.log(':::insertParam add new Parameter');	
		newUrl += "?"+key+"="+value;
	}
		
	// push new url to the history state	
	if (parent.history.pushState && newUrl!='') {
		//console.log(':::pushstate');
		//console.log(newUrl);
		parent.history.pushState({path:newUrl},'',newUrl);
	}
}
/*
 * Description: set autocomplete to the search textbox
 */
function setAutoComplete() {
	$('#gfbioSearchInput').autocomplete({
		minLength: 1,
		delay: 0,
		source: function (request, response) {
			$.ajax('//ws.pangaea.de/es/dataportal-gfbio/_suggest', {
				contentType: 'application/json; charset=UTF-8',
				type: 'POST',
				data: JSON.stringify({
					'suggest': {
						'text': request.term,
						'completion': {
							'field': 'suggest',
							'size': 12,
						},
					},
				}),
				dataType: 'json',
				success: function (data) {
					response($.map(data.suggest[0].options, function (item) {
							return item.text;
						}));
				},
			});
		},
		open: function () {
			var maxWidth = $(document).width() - $(this).offset().left - 16;
			$(this).autocomplete('widget').css({
				'max-width': maxWidth + "px"
			});
		},
	});
}

/*
 * Description: Read URL and extract variable
 * Input: variable name, e.g. "q"
 * Return: keyword attaced to the variable
 */
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
			if (pair[0] == variable) {
				return decodeURIComponent(pair[1]);
			}
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
			"bDestroy": true,
			"bPaginate": true,
			"sPaginationType": "simple",
			"bJQueryUI": true,
			"bProcessing": true,
			"bServerSide": true,
			"sAjaxSource": searchAPI,
			"bRetrieve": true,
			"fnServerData": getFilteredLatestDataset(filter, yearRange),
			// for the first time loading, filter and yearRange = ""
			// assign only 3 columns for the result table
			"aoColumns": [{
					// score column is used for sorting, hide it
					"data": "score",
					"visible": false,
					"sortable": false
				}, {
					// html column is the main display
					"data": "html",
					"visible": true,
					"sortable": false
				}, {
					// column displays color palette and basket cart icon
					"class": "color-control",
					"sortable": false,
					"data": null,
					"defaultContent": "<div id='divCheck' class='invisible'>"
					+ cartCheckbox
					+ "<input type='text' class='full-spectrum'/>" +"</div>"
					+ linkVAT
					+ ((showRating) ? ratingDiv : '')
				}
			],
			"sDom": '<"top"l<"divline"ip>>rt<"bottom"<"divline"ip>><"clear">',
			"sAutoWidth": true,
			// define the event after the search result is returned
			"fnDrawCallback": function (oSettings) {
				//console.log(':Search: table draw callback');
				// do nothing if table is empty
				if (!$(".dataTables_empty")[0]) {
					addColorPicker();
					setSelectedRowStyle();
					// activate parameter show/hide event
					toggleParametersField();
					if (showRating) {
						setRatingBar();
					}
				}
			},
			// define the event after each table row is created
			"fnRowCallback": function (nRow, aData, iDisplayIndex) {
				showCartIcon(nRow, aData);
			},
			"oLanguage": {
				"sLengthMenu": "Show _MENU_ entries per page"
			}
		});
	// activate the row click event (broadcast a message to mini-map)
	onRowClick();
};
function setRatingBar() {
	$('.ratebar').barrating('show', {
		theme: 'bars-horizontal',
		reverse: true,
		initialRating: null,
		hoverState: false,
		onSelect: function (value, text, event) {
			if (typeof(event) !== 'undefined') {
				var parent = event.target.parentElement.parentElement.parentElement;
			} else {
			}
		}
	});
	$(".br-widget a").removeClass('br-selected');
	$(".br-current-rating").empty();
}
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
		var filteredQuery = getFilteredQuery("", filter, yearRange);
		var boostedQuery = applyBoost(filteredQuery);
		var completeQuery = getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength);

		// add sorting by citation date
		completeQuery.sort = {
			"citation_yearFacet" : {
				"order": "desc"
			}
		};

		// Store query string for sending to VAT
		var strCompletQuery = JSON.stringify(completeQuery);
		$("#queryJSON").val(strCompletQuery);
		// Send request via AJAX
		$.ajax(sSource, {
			contentType: 'application/json; charset=UTF-8',
			type: 'POST',
			data: JSON.stringify(completeQuery),
			dataType: 'json',
			success: function (json) {
				var datasrc = json.hits.hits;
				// display facet only if the search return more than 1 result
				if (datasrc.length > 0) {
					var facet = json.aggregations;
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', facet);
					}
				} else {// clear facet
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', '');	
					}
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
	// clear visualBasket if the clearBasket flag is true
	if (clearBasket){
		$("#visualBasket").val("");
		$("#basketID").val(0); 
		//create a new basket for every query
		$("#queryJSON").val("");
		$("#queryKeyword").val("");
		$("#queryFilter").val("[]");
	}
	var filter = [];
	var yearFilter = '';
	// read search keywords
	var keyword = $("#gfbioSearchInput").val();
	//console.log('newQuery');
	//console.log(keyword);
	var urlFilter = getQueryVariable('filter');
	var urlYear = getQueryVariable('year');
	if (urlFilter !=''){
	//console.log(':filter:'+urlFilter);
		filter = JSON.parse(urlFilter);
	}
	if (urlYear !=''){
	//console.log(':year:'+urlYear);
		yearFilter = urlYear;
	}
	//setCookie("gfbioSearchInput", keyword);
	// reset facet gadget
	if (gadgets.Hub.isConnected()){
		gadgets.Hub.publish('gfbio.search.facetreset', 'reset');
		//console.log('search:reset facet');
	}
	// autocomplete from the textbox doesn't automatically closed
	$('#gfbioSearchInput').autocomplete('close');
	// send query to pansimple and parse result to the table
	console.log(':: newQuery');
	getSearchResult(keyword, filter, yearFilter);
	// Save query to DB
	if (saveSearch && keyword != "" && clearBasket) {
		saveSearchHistory(keyword, filter);
		var strFilters = JSON.stringify(filter);
		$("#filters").val(strFilters);
	}

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
	//console.log(':: getSearchResult');
	// every submitted query must be sent to TS gadget too
	if (gadgets.Hub.isConnected() && (keyword != "")) {
		// prevent calling ts when keyword box is empty
		//console.log(':: TS :'+keyword);
		gadgets.Hub.publish('gfbio.search.ts', keyword);
	}
	// create a result table as a placeholder
	writeResultTable();
	// bound a datatable to pansimple API query
	var oTable = $('#tableId').DataTable({
			"bDestroy": true,
			"bPaginate": true,
			"sPaginationType": "simple",
			"bJQueryUI": true,
			"bProcessing": true,
			"bServerSide": true,
			"sAjaxSource": searchAPI, // the URL of Search API
			"bRetrieve": true,
			"fnServerData": submitQueryToServer(keyword, filter, yearRange),
			// assign only 3 columns for the result table
			"aoColumns": [{
					// score column is used for sorting, hide it
					"data": "score",
					"visible": false,
					"sortable": false
				}, {
					// html column is the main display
					"data": "html",
					"visible": true,
					"sortable": false
				}, {
					// column displays color palette and basket cart icon
					"class": "color-control",
					"sortable": false,
					"data": null,
					"defaultContent": "<div id='divCheck' class='invisible'>"
					+ cartCheckbox
					+ "<input type='text' class='full-spectrum'/>" +"</div>"
					+ linkVAT
					+ ((showRating) ? ratingDiv : '')
				}
			],
			"sDom": '<"top"l<"divline"ip>>rt<"bottom"<"divline"ip>><"clear">',
			"sAutoWidth": true,
			// define the event after the search result is returned
			"fnDrawCallback": function (oSettings) {
				// do nothing if table is empty
				if (!$(".dataTables_empty")[0]) {
					//console.log(':: writeResultTable');
					addColorPicker();
					setSelectedRowStyle();
					// activate parameter show/hide event
					toggleParametersField();
					if (showRating) {
						setRatingBar();
					}
				}
			},
			// define the event after each table row is created
			"fnRowCallback": function (nRow, aData, iDisplayIndex) {
				showCartIcon(nRow, aData);
			},
			"oLanguage": {
				"sLengthMenu": "Show _MENU_ entries per page"
			}
		});
	// activate the row click event
	onRowClick();
}

function saveSearchHistory(keyword, filter) {
	//TODO: overwrite the record, if the same keyword and filter are added
	var recordid = 0; //For a new record
	var uid = parent.Liferay.ThemeDisplay.getUserId();
	//console.log('saveSearchHistory');
	parent.Liferay.Service(
		'/GFBio-Search-Service-portlet.searchhistory/update-search-history', {
		searchHistoryId: recordid,
		userID: uid,
		queryString: keyword,
		queryFilter: filter
	},
		function (obj) {
		//console.log('Query is recorded.');
		//if (!isNaN(obj)) {}
	});
}
function saveSearchFeedback(datasetDetail, datasetRank, rating) {
	//TODO: overwrite the record, if the same keyword, filter, rank are added
	var keyword = $("#gfbioSearchInput").val();
	var filter = $("#filters").val();
	var recordid = 0; //For a new record
	var uid = parent.Liferay.ThemeDisplay.getUserId();
	//console.log('saveSearchFeedback');
	parent.Liferay.Service(
		'/GFBio-Search-Service-portlet.searchfeedback/update-search-feedback', {
		searchHistoryId: recordid,
		userID: uid,
		queryString: keyword,
		queryFilter: filter,
		datasetDetail: datasetDetail,
		datasetRank: datsetRank,
		rating: rating
	},
		function (obj) {
		//console.log('Rating is recorded.');
		//if (!isNaN(obj)) {}
	});
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
		var filteredQuery = getFilteredQuery(keyword, filter, yearRange);
		var boostedQuery = applyBoost(filteredQuery);
		var completeQuery = getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength);
		
		// Store query string for sending to VAT
		var strCompleteQuery = JSON.stringify(completeQuery);
		$("#queryJSON").val(strCompleteQuery);

		// Send request via AJAX
		$.ajax(sSource, {
			contentType: 'application/json; charset=UTF-8',
			type: 'POST',
			data: JSON.stringify(completeQuery),
			dataType: 'json',
			success: function (result) {
				// get JSON result back from the server
				var datasrc = result.hits.hits;
				//console.log(datasrc);
				// display facet only if the search return more than 1 result
				if (datasrc.length > 0) {
					var facet = result.aggregations;
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', facet);
						//console.log('search:set facet to:');
						//console.log(facet);
					}
				} else {
					if (gadgets.Hub.isConnected()){
						gadgets.Hub.publish('gfbio.search.facet', '');
						//console.log('search:clear facet');
					}
				}
				var res = parseReturnedJSONfromSearch(datasrc);
				result.iTotalRecords = result.hits.total;
				result.iTotalDisplayRecords = result.hits.total;
				result.data = res;
				//console.log("submitQueryToServer");
				//console.log(result);
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
	console.log(':: filterArray '+ JSON.stringify(filterArray));
	if (keyword != "") {
		queryObj = {
			"simple_query_string": {
				"query": keyword,
				"fields": ["fulltext", "fulltext.folded^.7", "citation^3", "citation.folded^2.1"],
				"default_operator": "and"
			}
		};
	} else {
		queryObj = {
			"match_all": {}
		};
	}
	// save Keyword to invisible field for basket
	$("#queryKeyword").val(keyword);
	var filterObj;
	if (yearRange.trim() == "") {
		if (isValueNotEmpty(filterArray)) {
			// remove empty items from the array!
			filterObj = filterArray.filter(Boolean);
		} else {
			return {
				"bool": {
					"must": queryObj
				}
			};
		}
	} else {
		var splitPos = yearRange.indexOf(' - ');
		var minYear = yearRange.substring(0, splitPos);
		var maxYear = yearRange.substring(splitPos + 3);
		//console.log(minYear + "-" + maxYear);
		yearFilter = {
			"range": {
				"citation_yearFacet": {
					"gte": minYear,
					"lte": maxYear
				}
			}
		};
		filterObj = filterArray;
		filterObj.push(yearFilter);
	}
	// save filterObj to invisible field for basket
	var strFilter = JSON.stringify(filterObj);
	$("#queryFilter").val(strFilter);
		
	return {
		"bool": {
			"must": queryObj,
			"filter": filterObj
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
		"function_score": {
			"query": query,
			"functions": [{
					"field_value_factor": {
						"field": "boost"
					}
				}
			],
			"score_mode": "multiply"
		}
	}
}

/*
 * Description: Complete a JSON query message with query size, query field, and facets options
 * Input: JSONObject boostedQuery : a JSON query mesage with filter and boost parameters
 *        int iDisplayStart : starting index of dataset (read from pagination option)
 *        int iDisplayLength : size of dataset (read from pagination option)
 * Output: JSONObject : a complete JSON request message
 */
function getCompleteQuery(boostedQuery, iDisplayStart, iDisplayLength) {
	return {
		'query': boostedQuery,
		'from': iDisplayStart,
		'size': iDisplayLength,
		'aggs': {
			'author': {
				'terms': {
					'field': 'citation_authorFacet',
					'size': 50
				}
			},
			'year': {
				'terms': {
					'field': 'citation_yearFacet',
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
			},
			'license': {
				'terms': {
					'field': 'licenseFacet',
					'size': 50
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
		var fields = datasrc[i]._source;
		inner.score = score;
		//console.log('parseReturnedJSONfromSearch:fields');
		inner.title = getMultiValueField(fields, "citation_title");
		// **************** IMPORTANT ***************** //
		// https://project.gfbio.org/issues/1034        //
		// The authors field must be presented in array //
		// as agreed with VAT system                    //
		inner.authors = getJSONArrayFromField(fields, "citation_authors");
		// ******************************************** //
		inner.description = getMultiValueField(fields, "description");
		inner.dataCenter = getMultiValueField(fields, "dataCenter");
		inner.region = getMultiValueField(fields, "region");
		inner.project = getMultiValueField(fields, "project");
		inner.parameter = getMultiValueField(fields, "parameter");
		inner.investigator = getMultiValueField(fields, "investigator");
		inner.timeStamp = getMultiValueField(fields, "internal-datestamp");
		inner.maxLatitude = getMultiValueField(fields, "maxLatitude");
		inner.minLatitude = getMultiValueField(fields, "minLatitude");
		inner.maxLongitude = getMultiValueField(fields, "maxLongitude");
		inner.minLongitude = getMultiValueField(fields, "minLongitude");
		inner.metadatalink = getMultiValueField(fields, "metadatalink");
		inner.datalink = getMultiValueField(fields, "datalink");
		inner.vatVisualizable = getMultiValueField(fields, "vatVisualizable");
		/* pangeae doesn't return license field
		inner.license = getMultiValueField(fields, "license");*/
		inner.format = getMultiValueField(fields, "format");
		if (fields["html-1"]) {
			// this field is used only for displaying data
			var html = fields["html-1"];
			html = html.replace(/@target@/gi, "_blank").replace("<table", "<table class=\"html-1\"");

			inner.html = writeShowHideFields(html);
		} 
		else{
			inner.html = "";
		}
		if (fields["xml"]) {
			// this field contains raw data, is used for basket
			var xml = fields["xml"];
			inner.xml2 = xml;
			// creates object instantce of XMLtoJSON
			var xml2json = new XMLtoJSON();
			var json = xml2json.fromStr(xml);
			inner.xml = json; //JSON.stringify(json);

			if (isJArray(json.dataset["parentIdentifier"])) {
				inner.parentIdentifier = getStringFromJSONArray(json.dataset, "parentIdentifier");
			} else {
				inner.parentIdentifier = json.dataset["parentIdentifier"];
			}

			inner.dcIdentifier = json.dataset["dc:identifier"];
			if (isJArray(json.dataset["dc:type"])) {
				inner.dcType = "Unit";
				inner.unitType = getValueFromJSONArray(json.dataset, "dc:type");
			} else {
				if (json.dataset["dc:type"] == "Dataset") {
					inner.dcType = "Dataset";
					inner.unitType = "";
				} else {
					inner.dcType = "Unit";
					inner.unitType = getValueFromJSONArray(json.dataset, "dc:type");
				}
			}
		} else {
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
	var div = $('#search_result_table');
	div.html(displaytext);
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
	$("#basketID").val(data.basketID);
	$("#visualBasket").val(data.basketContent);
		var query = JSON.parse(data.query);
	var queryStr = query.query.function_score.query.filtered.query.simple_query_string.query;
	//console.log(queryStr);
	var searchbox = $("#gfbioSearchInput");
	searchbox.val(queryStr);
	newQuery(false);
}

/*
 * Description: Update basket content to the basket table on GFBio DB
 * Effect: If the basket is already exist (from loadBasket function), append the content and update it.
 *         Otherwise, create a new basket from the selected dataset(s).
 */
function addBasket() {
	var val = $("#visualBasket").val();
	if (val == "") {
		//console.log('No basket selected.');
	} else {
		// read the current portal user id for authentication in service invokation
		var uid = parent.Liferay.ThemeDisplay.getUserId();
		var basketid = $("#basketID").val();
		//console.log("addBasket:"+basketid);
		var query = $("#queryJSON").val();
		
		/*console.log("addBasket queryJSON:");
		console.log(query);*/
		var keyword = $("#queryKeyword").val();
		var filter = $("#queryFilter").val();
		
		/*console.log("addBasket queryKeyword:");
		console.log(keyword);
		console.log("addBasket queryFilter:");
		console.log(filter);*/
		parent.Liferay.Service(
			'/GFBioProject-portlet.basket/update-basket', {
			basketID : basketid,
			userID : uid,
			name : uid + '_basket',
			basketContent : val,
			queryJSON : query,
			queryKeyword :keyword,
			queryFilter : filter
		},
			function (obj) {
			// set the return id as the current basket id
			if (!isNaN(obj)) {
				$("#basketID").val(obj);
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
	var basket = $("#visualBasket");
	var basketStr = basket.val();
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
///////////////////////////////////////  Basket Dialog  /////////////////////////////////////
function addBasketDialogToPage() {
	// The dialog must be a children of the page, not the gadget.
	var iFrame = window.parent.document.getElementById(window.frameElement.id)
	var newDivInParent = window.parent.document.createElement('div');
	newDivInParent.setAttribute("id", "dialogBasket");
	newDivInParent.setAttribute("title", "Basket");
	newDivInParent.setAttribute("class", "robotofont");
	// Write a dialog placeholder on the page
	iFrame.parentNode.appendChild(newDivInParent);
	// set behaviour of dialog box
	dialog = window.parent.$('#dialogBasket').dialog({
			autoOpen : false,
			modal : true,
			height : 350,
			width : 500,
			buttons : [
				{
					text: "Download Datasets",
					click : function () {
						console.log('download');
						filesToDownload();
						dialog.dialog("close");
					}
				},
				{
					text: "View in VAT",
					click : function(){
						console.log('go to VAT');
						linkToVAT();
						dialog.dialog("close");
					}
				}
				/*{
					text: "Cancel",
					icons: { primary: "ui-icon-closethick" },
					click: function(){
						console.log('close dialog');
						dialog.dialog("close");
					}
				}*/
			],
			close : function () {
				/* Do nothing */
			}
		});
}

$(function() { 	
	$("#checkAll").change(function () {
		if($("#checkAll").is(':checked'))
		{
			//#divCheck > input.basketCheck
			$("input.basketCheck:not(:checked)").each(function(){
				$(this).click();
			});
		}else{
			$("input.basketCheck:checked").each(function(){
				$(this).click();
			});
		}
	});

    $("#button_download").click(function(){
		$(this).button('loading').delay(1000).queue(function() {
			var basket = $("#visualBasket");
			var jsonBasket = JSON.parse(basket.val());
			var selectedBasket = jsonBasket.selected;
			
			var zip = new JSZip();
			
			$.each(selectedBasket, function (index, result) {	
				var linkages = [];
				
				if(typeof result['xml']['dataset']['linkage'] === "string")
				{
					linkages = [result['xml']['dataset']['linkage']];
				}
				else
				{
					linkages = result['xml']['dataset']['linkage'];
				}
				
				var metadatalink = decodeURIComponent(result['metadatalink']);
				var identifier = result['xml']['dataset']['dc:identifier'].replace(/[` ~!@#$%^&*()_|+\-=÷¿?;:'",.<>\{\}\[\]\\\/]/gi, '');
				
				for ( var i = 0; i < linkages.length; i++) {				
					var linkURL = decodeURIComponent(linkages[i]);
									
					if (linkURL === metadatalink)
					{
						zip.file(identifier + "_metadata.xml", result['xml2']);
						continue;
					}
					
					var xhr = new XMLHttpRequest();
					xhr.open('GET', 'https://cors-anywhere.herokuapp.com/' + linkURL, false);
					xhr.overrideMimeType('text\/plain; charset=x-user-defined');
					xhr.send(null);
					
					var headers = xhr.getAllResponseHeaders();
					
					if (xhr.readyState === 4) {
					
						var filestream = xhr.responseText;
						var out;
						out = '';
						for (i = 0; i < filestream.length; i++) {
							out+=String.fromCharCode(filestream.charCodeAt(i) & 0xff);
						}
						var out64 = window.btoa(out);
					
						var filename = /(?:^|\s)filename=(.*?)(?:\s|$)/.exec(headers);
						
						if(filename == null){
							zip.file(identifier + "_" + decodeURIComponent(linkURL.substring(linkURL.lastIndexOf('/')+1)), out64, {base64:true});
						}
						else
						{
							zip.file(identifier + "_" + filename[1], out64, {base64:true});			
						}
					}
			    }
			});
			
			zip.generateAsync({type:"blob"}).then(function (blob) { // 1) generate the zip file
				saveAs(blob, "gfbio_basket_" + Date.now() + ".zip");                          // 2) trigger the download
			}, function (err) {
				$("#blob").text(err);
			});
			
			$(this).button('reset');
			$(this).dequeue();
        });        
    });
});

function showBasketDialog() {
	var basket = $("#visualBasket");
	console.log('showBasketDialog');
	var jsonBasket = JSON.parse(basket.val());
	console.log(jsonBasket);
	var selectedBasket = jsonBasket.selected;
	console.log(selectedBasket);
	console.log($("#basketID").val());
	console.log($("#gfbioSearchInput").val());
	var displayHTML = "<h3>Basket ID: "+$("#basketID").val()+"</h3>";
	console.log('-------------------------');
	$.each(selectedBasket, function (index, result) {
		console.log(result['metadatalink']);
		displayHTML += "<p>Item:"+(index+1)+"</br>"+result['metadatalink']+"</p>";
		console.log('-------------------------');
	});
	var dialogDiv = window.parent.$("#dialogBasket");
	$(dialogDiv).html(displayHTML);
	window.parent.$('#dialogBasket').dialog("open");
}
/////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////// Facet filter functions ////////////////////////////////////
/*
 * Description: Parse facet filter message sent from the facet gadget
 * Effect: The selected facet is appended to the filter list and requery for the search result
 */
function applyFacetFilter(topic, data, subscriberData) {
	var facetFilters = data.filtered;
	var filterArray = [];
	var yearRange = "";
	//console.log(':Search: receive facet filter ');
	console.log('filter length:: '+facetFilters.length);
	for (var i = 0; i < facetFilters.length; i++) {
		var facetFilter = facetFilters[i];
		if ((facetFilter.facetCat == "citation_yearFacet") && (facetFilter.facetTerm.indexOf(" - ") > 0)) {
			yearRange = facetFilter.facetTerm;
		} else {
			var filterStr = "{\"term\":{\"{0}\":\"{1}\"}}".format(facetFilter.facetCat, facetFilter.facetTerm);
			console.log(':Search: filterStr - '+filterStr);
			var filterTerm = JSON.parse(filterStr);
			filterArray.push(filterTerm);
		}
	}
		
	console.log('applyFacetFilter:: '+JSON.stringify(filterArray));
	insertParam("filter", JSON.stringify(filterArray));

	//console.log('applyFacetFilter:: '+yearRange);
	insertParam("year", yearRange);
	
	console.log('filter:: '+JSON.stringify(filterArray));
	filterQuery(filterArray, yearRange);
};

/*
 * Description: Clear the result table and requery for the filtered result
 * Effect: If the keyword is provided, call getSearchResult.
 *         Otherwise call showLatestTenDataset.
 */
function filterQuery(filter, yearRange) {
	// keep only filtered items
	// clear result table
	console.log('new filter:: '+JSON.stringify(filter));
	$('#tableId').DataTable().clear();
	var keyword = $("#gfbioSearchInput").val();
	// resubmit a query with filter to pansimple and rewrite the result table
	if (keyword != "") {
		getSearchResult(keyword, filter, yearRange);
	} else {
		showLatestTenDataset(filter, yearRange);
	}
	// Save query to DB
	if (saveSearch && keyword != "") {
		var filterObj = filter;
		filterObj.push(yearRange);
		saveSearchHistory(keyword, filterObj);
		$("#filters").val(filterObj);
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
	var basket = $("#visualBasket");
	var basketStr = basket.val();
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
					var basketCell = row.childNodes[1];
					//var cartDiv = $(basketCell).find('#cart')[0];
					var divCheck = $(basketCell).find('#divCheck')[0];
					$(divCheck).attr('title', cartRemTitle);
					// show color palette
					$($(basketCell).find('.sp-replacer')[0]).removeClass("invisible");
					var isUserSignedIn = parent.Liferay.ThemeDisplay.isSignedIn();
					// show VAT link only if this user is logged in
					//var vatLink = $(basketCell).find('.basketIcon')[0];
					//if (isUserSignedIn){$(vatLink).removeClass('invisible');}
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
	$('#tableId tbody').on('click', '.basketCheck', function (e) {
	
		var isUserSignedIn = parent.Liferay.ThemeDisplay.isSignedIn();
		if(isUserSignedIn)
		{
			$('#button_download').prop('disabled', $('.basketCheck').filter(':checked').length < 1);
			$('#button_vat').prop('disabled', $('.basketCheck').filter(':checked').length < 1);
		}else{
			$('#button_download').hide();
			$('#button_vat').hide();
		}

		if (!$(this).attr('disabled')){
			var div = $(this).parent();
			var cell = $(div).parent();
			var row = $(cell).parent();
			var icol = $(row).children().index(cell);
			var irow = $(row).parent().children().index(row);
			// class of the table row
			row.toggleClass('selected');

			// get Element visual basket for updating
			var basket = $("#visualBasket");
			var basketStr = basket.val();
			var jsonData = {};
			var selected = [];
			//var vatLink = $(cell).find('.basketIcon')[0];
			var isUserSignedIn = parent.Liferay.ThemeDisplay.isSignedIn();// toggle basket
			if (row.hasClass('selected')) {
				$(this).attr('title', cartRemTitle);
				$($(".sp-replacer")[irow]).removeClass("invisible");
				// show VAT link only if this user is logged in
				//if (isUserSignedIn){$(vatLink).removeClass('invisible');}
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
				var strJSONData = JSON.stringify(jsonData);
				basket.val(strJSONData);
			} else {
				$(this).attr('title', cartAddTitle);
				$($(".sp-replacer")[irow]).addClass("invisible");
				// hide VAT link
				//$(vatLink).addClass('invisible');
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
					var strJSONData = JSON.stringify(jsonData);
					basket.val(strJSONData);
				}
			}
			//update visualisation
			updateMap();
		}
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
		"metadatalink": value.metadatalink,
		"datalink": value.datalink,
		"format": value.format,
		"timeStamp": value.timeStamp,
		"maxLatitude": value.maxLatitude,
		"minLatitude": value.minLatitude,
		"maxLongitude": value.maxLongitude,
		"minLongitude": value.minLongitude,
		"color": rgbToHex(color),
		"title": value.title,
		"authors": value.authors,
		"description": value.description,
		"dataCenter": value.dataCenter,
		"dcType": value.dcType,
		"unitType": value.unitType,
		"parentIdentifier": value.parentIdentifier,
		"dcIdentifier": value.dcIdentifier,
		"parameter": value.parameter,
		"xml": value.xml,
		"xml2": value.xml2,
		"vatVisualizable": value.vatVisualizable,
		/* pangeae doesn't return license field
		"license":value.license*/
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
	jsonData.queryStr = $("#queryJSON").val();
	// add queryKeyword and queryFilter to jsonData
	// store in database (for use later)
	jsonData.queryKeyword = $("#queryKeyword").val();
	jsonData.queryFilter = $("#queryFilter").val();
	addBasket();
	// then send info to VAT
	if (gadgets.Hub.isConnected()) {
		//console.log(':Search: fire selected data: ');
		//console.log(jsonData);
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
					var input = $(elm[j]).find('.full-spectrum')[0];
					var divCheck = $(elm[j]).find('#divCheck')[0];
					$(input).val(color);
					var basketCheck = $(divCheck).find('.basketCheck')[0];
					if ($(basketCheck).attr('disabled')){
						$(divCheck).css('background-color','rgb(204, 204, 204)');
					}
					else{
						$(divCheck).css('background-color',color);
					}
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
		showInitial: true,
		showPalette: true,
		showSelectionPalette: true,
		maxPaletteSize: 10,
		palette: [
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
		change: function (color) {
			//console.log('spectrum changed');
			// read basket value
			var basket = $("#visualBasket");
			var basketStr = basket.val();
			if (basketStr != "") {
				var jsonData = {};
				jsonData = JSON.parse(basketStr);
				// get metadata link of the current row
				var checkDiv = $(this).parent();
				var cell = $(checkDiv).parent();
				var row = $(cell).parent();
				var tb = $('#tableId').DataTable();
				var rowInd = $(row).index();
				var metadatalink = tb.rows().data()[rowInd].metadatalink;
				// loop compare with the link in basket
				$.each(jsonData.selected, function (index, result) {
					var selectedLink = result['metadatalink'];
					if (selectedLink == metadatalink) {
						// if found the link, update row detail
						jsonData.selected[index].color = color.toHexString();
						checkDiv.css('background-color',color.toHexString());
					}
				});
				var strJSONData = JSON.stringify(jsonData);
				basket.val(strJSONData);
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
	// read the current row number and get a div for the cart
	var elmRow = $(nRow);
	var elmTD = $(elmRow[0].lastElementChild);
	var divCheck = $($(elmTD[0]).find('#divCheck')[0]);
	//console.log('showCartIcon: '+isUserSignedIn);
	// show the cart icon only if the visualizable flag is true
	// show the basket checkbox div		
	$(divCheck).removeClass('invisible');
	$(divCheck).attr('title', cartAddTitle);
	// if (aData.vatVisualizable) {
		// $(divCheck).attr('title', cartAddTitle);
	// }
	// else{
		// $(divCheck).attr('title', cartDivDisabled);
		// $(divCheck).css('background-color','rgb(128,128,128)');
		// var basketCheck = $(divCheck).find('.basketCheck')[0];
		// $(basketCheck).attr("disabled", true);
	// }
}

function linkToVAT(){
	var basketID = $('#basketID').val();
	var linkURL = VATpage;
	//console.log('linkToVAT:'+basketID);
	if (basketID!=0){
		linkURL += '?gfbioBasketId='+basketID;
	}
	var win = window.open(linkURL, '_blank');
	win.focus();
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
		json_str = json_str.replace(/\n/g, '');
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
function getMultiValueField(jObj, id){
	if ($.isArray(jObj)){
		var jArr = jObj[id];
		if (jArr.length > 0){
		    return jArr;
		}
	}
	else{
		if (jObj[id] != null)
		  return jObj[id];
		else return "";
		// return the object as it is
	}
	return "";
}
function getJSONArrayFromField(jObj, name){
	if ($.isArray(jObj[name])){
		var jArr = jObj[name];
		if (jArr.length > 0){
		    return jArr;
		}
	}
	else{
		if (jObj[name]!=null)
			return [jObj[name]];
	}
	return [];
}

function getValueFromJSONArray(jObj, name) {
	if (jObj[name] !== undefined) {
		var jArr = jObj[name];
		if (jArr.length > 0){
		    return jArr;
		}
	}
	return [];
}

function getStringFromJSONArray(jObj, name) {
	if (jObj[name] !== undefined) {
		var res = "";
		var jArr = jObj[name];
		for (var i=0; i<jArr.length; i++){
			res += jArr[i];
			if (i != jArr.length-1){
				res += ";";
			}
		}
		return res;
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
		adjustGadgetHeight();
	});
};

function getCookie(name) {
	var re = new RegExp(name + "=([^;]+)");
	var value = re.exec(document.cookie);
	//console.log('getCookie:'+name);
	//console.log(value);
	return (value != null) ? unescape(value[1]) : null;
}

function setCookie(name, value) {
	var today = new Date();
	var expiry = new Date(today.getTime() + 7 * 24 * 3600 * 1000); // plus 7 days
	document.cookie = name + "=" + escape(value) + "; path=/; expires=" + expiry.toGMTString();
	//console.log('setCookie:'+name);
	//console.log(value);
}  

function deleteCookie(name) {
	document.cookie = name + "=null; path=/; expires=" + expired.toGMTString();
}

function isJArray(elm) {
	return Object.prototype.toString.call(elm) === '[object Array]';
}

if (!String.prototype.startsWith) {
	String.prototype.startsWith = function (searchString, position) {
		position = position || 0;
		return this.indexOf(searchString, position) === position;
	};
}
///////////////////////////////////  End Misc functions  //////////////////////////////////