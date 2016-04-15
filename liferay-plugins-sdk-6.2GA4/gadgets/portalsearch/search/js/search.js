
			
				function updateVisualisation() {
					var jsonData = getSelectedResult();
					// Add query message in JSON format
					var queryJSON = document.getElementById("queryJSON").value;
					jsonData.queryStr = queryJSON;
					console.log(':Search: fire selected data: ' + JSON.stringify(jsonData));
					addBasket();
					if (gadgets.Hub.isConnected()) {
						gadgets.Hub.publish('gfbio.search.selectedData', jsonData);
					}
				}

				function addBasket() {
					var val = document.getElementById("visualBasket").value;
					if (val == "") {
						console.log('No basket selected.');
					} else {
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
							console.log("Post return: " + obj);
							// if the returned value is basket id
							if (!isNaN(obj)) {
								document.getElementById("basketID").value = obj;
							}
						});
					}
				}

				function newQuery(clearBasket) {
					$('#tableId').DataTable().clear();
					var keyword = document.getElementById("gfbioSearchInput").value;
					var filter = [];

					if (gadgets.Hub.isConnected())
						gadgets.Hub.publish('gfbio.search.facetreset', 'reset');

					$('#gfbioSearchInput').autocomplete('close');

					getSearchResult(keyword, filter, "");
					var visualBasket = document.getElementById("visualBasket");
					// clear visualBasket if the clearBasket flag is true
					if (clearBasket)
						visualBasket.value = "";
					updateVisualisation();
				}

				function filterQuery(filter, yearRange) {
					// keep only filtered items
					$('#tableId').DataTable().clear();
					var keyword = document.getElementById("gfbioSearchInput").value;

					getSearchResult(keyword, filter, yearRange);
				}

				function getSearchResult(keyword, filter, yearRange) {
					//console.log(':Search: getSearchResult: '+keyword);
					if (gadgets.Hub.isConnected() && (keyword != "")) {
						// prevent calling ts when keyword box is empty
						gadgets.Hub.publish('gfbio.search.ts', keyword);
					}
					writeResultTable();
					var oTable = $('#tableId').DataTable({
							"bDestroy" : true,
							"bPaginate" : true,
							"bJQueryUI" : true,
							"bProcessing" : true,
							"bServerSide" : true,
							"sAjaxSource" : 'http://ws.pangaea.de/es/dataportal-gfbio/pansimple/_search',
							"bRetrieve" : true,
							"fnServerData" : fnServerObjectToArray(keyword, filter, yearRange),

							"aoColumns" : [{
									"data" : "score",
									"visible" : false,
									"sortable" : false
								}, {
									"data" : "html",
									"visible" : true,
									"sortable" : false
								}, {
									"class" : "color-control",
									"sortable" : false,
									"data" : null,
									"defaultContent" : "<input type='text' class='full-spectrum'/><div id='cart' class='cart_unselected invisible' title='Click to add/remove dataset to/from VAT (for registered user).'/>",
								}
							],
							"sDom" : '<"top"l<"divline"ip>>rt<"bottom"<"divline"ip>><"clear">', //'lrtip',
							//"order" : [ [ 0, "desc" ] ],
							"sAutoWidth" : true,

							"fnDrawCallback" : function (oSettings) {
								// do nothing if table is empty
								//console.log(':Search: table draw callback');
								if (!$(".dataTables_empty")[0]) {
									addColorPicker();
									setSelectedRowStyle();
									// activate parameter show/hide event
									toggleParametersField()
								}					
							},
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

				function fnServerObjectToArray(keyword, filterArray, yearRange) {
					return function (sSource, aoData, fnCallback) {

						var iDisplayStart = getValueByAttribute(aoData, "name", "iDisplayStart");
						var iDisplayLength = getValueByAttribute(aoData, "name", "iDisplayLength");
						// Construct query message in JSON format
						var queryfield = createQueryFieldArray();
						var filteredQuery = getFilteredQuery(keyword, filterArray, yearRange);
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
							success : function (json) {
								var datasrc = json.hits.hits;
								// display facet only if the search return more than 1 result
								if (datasrc.length > 0) {
									var facet = json.aggregations;
									console.log(facet);
									if (gadgets.Hub.isConnected())
										gadgets.Hub.publish('gfbio.search.facet', facet);
								} else {
									if (gadgets.Hub.isConnected())
										gadgets.Hub.publish('gfbio.search.facet', '');
								}
								var res = parseReturnedJSONfromSearch(datasrc);
								json.iTotalRecords = json.hits.total;
								json.iTotalDisplayRecords = json.hits.total;
								json.data = res;
								fnCallback(json);
							}
						});
					};
				};

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
							var selectedLink = result['metadataLink'];
							var tb = $('#tableId').DataTable();
							var displayedResult = tb.rows().data();

							$.each(displayedResult, function (ind2, res2) {
								var displayedLink = res2.metadataLink;
								if (selectedLink == displayedLink) {
									// if yes, toggle class to selected.
									var row = tb.rows().nodes()[ind2];
									row.className += ' selected';
									//console.log('found selected row: '+ind2);
									row.childNodes[1].childNodes[2].className = 'cart_selected';
									$(row.childNodes[1].childNodes[1]).removeClass("invisible");
								}
							});
						});
					}
				}

				function onRowClick() {
					$('#tableId tbody').off('click');
					$('#tableId tbody').on('click', '#cart', function (e) {
						var cell = $(this).parent();
						var row = cell.parent();
						var icol = row.children().index(cell);
						var irow = row.parent().children().index(row);

						row.toggleClass('selected');

						// get Element visual basket for updating
						var basket = document.getElementById("visualBasket");
						var basketStr = basket.value;
						var jsonData = {};
						var selected = [];
						// toggle basket
						if (row.hasClass('selected')) {
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
							var resultArray = createResultArray(nRow, tRows);
							jsonData.selected.push(resultArray);
							// store basket in string format
							basket.value = JSON.stringify(jsonData);
						} else {
							$(this).attr('class', 'cart_unselected');
							$($(".sp-replacer")[irow]).addClass("invisible");
							// remove from basket
							if (basketStr != "") {
								jsonData = JSON.parse(basketStr);
								// get row index to find metadatalink as id
								var nRow = row[0];
								var tRows = $('#tableId').DataTable().rows();
								var resultArray = createResultArray(nRow, tRows);
								// metadataLink is supposed to be unique for each dataset,
								// so I use it as an id for each row.
								jsonData.selected = JSONfindAndRemove(jsonData.selected, 'metadataLink', resultArray.metadataLink);
								basket.value = JSON.stringify(jsonData);
							}
						}
						//	    	console.log(':Search: basket: ');
						//    		console.log(JSON.stringify(document.getElementById("visualBasket").value));

						//update visualisation
						updateVisualisation();
					});
				}

				function listenToEnterPress() {
					$("#gfbioSearchInput").keyup(function (event) {
						if (event.keyCode == 13) {
							$('#gfbioSearchInput').autocomplete('close');
							$("#QueryButton").click();
						}
					});
				}

				function setAutoComplete() {
					// this function is recommended by pansimple
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
				function getQueryVariable(variable) {
					var query = document.referrer;
					var vars = query.split('&');
					for (var i = 0; i < vars.length; i++) {
						var pair = vars[i].split('=');
						if (decodeURIComponent(pair[0]) == variable) {
							return decodeURIComponent(pair[1]);
						}
					}
					//console.log('Query variable %s not found', variable);
					return '';
				}

				function createQueryFieldArray() {
					// list all the return field from elasticSearch here
					var jArr = [];
					jArr.push("_score");
					jArr.push("citation_title");
					jArr.push("citation_authors");
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
					jArr.push("xml");
					return jArr;
				}
				function getFilteredQuery(keyword, filterArray, yearRange) {
					var queryObj = {
						"simple_query_string" : {
							"query" : keyword,
							"fields" : ["fulltext", "fulltext.folded^.7", "citation^3", "citation.folded^2.1"],
							"default_operator" : "and"
						}
					};
					var filterObj;

					if (yearRange == "") {
						filterObj = {
							"and" : {
								"filters" : filterArray
							}
						};
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

				function createResultArray(nRow, tRows) {
					var div = nRow.getElementsByClassName("sp-preview-inner")[0];
					var color = getStyle(div, "background-color");
					var iRow = nRow._DT_RowIndex;
					var value = tRows.data()[iRow];
					var result = {
						"metadataLink" : value.metadataLink,
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
						"xml" : value.xml
					};
					return result;
				}

				function parseReturnedJSONfromSearch(datasrc) {
					var res = [];
					for (var i = 0, iLen = datasrc.length; i < iLen; i++) {
						var inner = new Object();
						var score = datasrc[i]._score;
						var sourceObj = datasrc[i].fields;
						//console.log('parseReturnedJSONfromSearch');
						//console.log(sourceObj);
						inner.score = score;
						if (sourceObj["citation_title"] !== undefined)
							inner.title = sourceObj["citation_title"][0];
						else
							inner.title = "";
						if (sourceObj["citation_authors"] !== undefined)
							inner.authors = sourceObj["citation_authors"];
						else
							inner.authors = "";
						if (sourceObj["description"] !== undefined)
							inner.description = sourceObj["description"][0];
						else
							inner.description = "";
						if (sourceObj["dataCenter"] !== undefined)
							inner.dataCenter = sourceObj["dataCenter"][0];
						else
							inner.dataCenter = "";
						if (sourceObj["region"] !== undefined)
							inner.region = sourceObj["region"];
						else
							inner.region = "";
						if (sourceObj["project"] !== undefined)
							inner.project = sourceObj["project"];
						else
							inner.project = "";
						if (sourceObj["citation.date"] !== undefined)
							inner.citationDate = sourceObj["citation.date"];
						else
							inner.citationDate = "";
						if (sourceObj["parameter"] !== undefined)
							inner.parameter = sourceObj["parameter"];
						else
							inner.parameter = "";
						if (sourceObj["investigator"] !== undefined)
							inner.investigator = sourceObj["investigator"];
						else
							inner.investigator = "";
						if (sourceObj["internal-datestamp"] !== undefined)
							inner.timeStamp = sourceObj["internal-datestamp"][0];
						else
							inner.timeStamp = "";
						if (sourceObj["maxLatitude"] !== undefined)
							inner.maxLatitude = sourceObj["maxLatitude"][0];
						else
							inner.maxLatitude = undefined;
						if (sourceObj["minLatitude"] !== undefined)
							inner.minLatitude = sourceObj["minLatitude"][0];
						else
							inner.minLatitude = undefined;
						if (sourceObj["maxLongitude"] !== undefined)
							inner.maxLongitude = sourceObj["maxLongitude"][0];
						else
							inner.maxLongitude = undefined;
						if (sourceObj["minLongitude"] !== undefined)
							inner.minLongitude = sourceObj["minLongitude"][0];
						else
							inner.minLongitude = undefined;
						if (sourceObj["taxonomy"] !== undefined)
							inner.taxonomy = sourceObj["taxonomy"];
						else
							inner.taxonomy = "";
						if (sourceObj["datalink"])
							inner.dataLink = sourceObj["datalink"];
						else
							inner.dataLink = "";

						if (sourceObj["metadatalink"])
							inner.metadataLink = sourceObj["metadatalink"][0];
						else
							inner.metadataLink = "";

						if (sourceObj["html-1"]) { // this field is used only for displaying data
							var html = sourceObj["html-1"][0];
							html = html.replace("@target@", "_blank").replace("<table", "<table class=\"html-1\"");
							inner.html = writeShowHideParameterField(html);
						} else
							inner.html = "";

						if (sourceObj["xml"]) { // this field contains raw data, is used for basket
							var xml = sourceObj["xml"];
							// creates object instantce of XMLtoJSON
							var xml2json = new XMLtoJSON();
							var json = xml2json.fromStr(xml);
							inner.xml = json; //JSON.stringify(json);
						} else
							inner.xml = "";

						res.push(inner);
					}
					return res;
				}

				function writeShowHideParameterField(orgHTML){
					var d = document.createElement('div');
					d.innerHTML = orgHTML;
					var elms = d.getElementsByClassName('desc-right');
					$.each(elms, function(index,elm){
						var descLeft = elm.previousElementSibling;
						var field = descLeft.childNodes[0].nodeValue;
						
						if (field.startsWith('Parameters')){
							var paramStr = elm.textContent;
							var limitLen = 180;
							if ((paramStr.length > limitLen)&&(paramStr.length > limitLen+5)){
								// set two length to prevent the expansion for less than 5 characters
								var trimmedContent = paramStr.substring(0,limitLen);
								var shortenedParam = '<span class="paramExpanded">'+paramStr
												+'</span>'
												+'<span class="paramCollapsed">'+trimmedContent
												+'...</span>'
												+'<a href="javascript:void(0)" class="paramCollapsed">(+)</a>'
												+'<a href="javascript:void(0)" class="paramExpanded">(-)</a>';
								d.innerHTML = d.innerHTML.replace(paramStr,shortenedParam);
							}
						}
					});
					return d.innerHTML;
				}
				
				function writeResultTable() {
					var displaytext = "<table style='border: 0; cellpadding: 0; cellspacing: 0;' id='tableId' class='display'>";
					var div = document.getElementById('search_result_table');
					div.innerHTML = displaytext;
				}

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

				function componentFromStr(numStr, percent) {
					var num = Math.max(0, parseInt(numStr, 10));
					return percent ?
					Math.floor(255 * Math.min(100, num) / 100) : Math.min(255, num);
				}

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
									//				console.log(color);
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
							["rgb(102, 0, 0)", 		// maroon red
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
								var metadataLink = tb.rows().data()[row.rowIndex - 1].metadataLink;
								// loop compare with the link in basket
								$.each(jsonData.selected, function (index, result) {
									var selectedLink = result['metadataLink'];
									if (selectedLink == metadataLink) {
										// if found the link, update row detail
										jsonData.selected[index].color = color.toHexString();
									}
								});
								basket.value = JSON.stringify(jsonData);
								updateVisualisation();
							}
						}
					});
					$(".sp-replacer").addClass("invisible").attr("title", "Select color to display on VAT (for registered user).");
				}

				/*
				 * Description: Convert RGB code to Hex number
				 * Usage: Color for each item in basket
				 * Parameter: RGB code
				 * Return: Hexadecimal value
				 */
				function rgbToHex(rgb) {
					var rgbRegex = /^rgb\(\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*,\s*(-?\d+)(%?)\s*\)$/;
					var result;
					var r;
					var g;
					var b;
					var hex = "";
					if ((result = rgbRegex.exec(rgb))) {
						r = componentFromStr(result[1], result[2]);
						g = componentFromStr(result[3], result[4]);
						b = componentFromStr(result[5], result[6]);

						hex = "0x" + (0x1000000 + (r << 16) + (g << 8) + b).toString(16).slice(1);
					}
					return hex;
				}

				function getStyle(x, styleProp) {
					if (x.currentStyle)
						var y = x.currentStyle[styleProp];
					else if (window.getComputedStyle)
						var y = document.defaultView.getComputedStyle(x, null).getPropertyValue(styleProp);
					return y;
				}

				function tog(v) {
					return v ? 'addClass' : 'removeClass';
				}

				/*
				 * Description: Adjust gadget's height according to the content
				 * Parameter: nRow - row number of search result, aData - json data of that row of search result
				 * Return: -
				 * Effect: Cart icon will appear for each search result if they have geological data
				 */
				function showCartIcon(nRow, aData) {
					// show the cart icon only if the geological data is provided
					if (((aData.maxLatitude != undefined) || (aData.minLatitude != undefined)) &&
						((aData.maxLongitude != undefined) || (aData.minLongitude != undefined))) {
						// read the current row number and get a div for the cart
						var elmRow = $(nRow);
						var elmTD = $(elmRow[0].lastElementChild);
						var elmDiv = $(elmTD[0].lastElementChild);
						// show the cart's div
						elmDiv.removeClass('invisible');
					}
				}

				/*
				 * Description: Adjust gadget's height according to the content
				 * Parameter: -
				 * Return: -
				 * Effect: Gadget's height is automatically adjusted
				 */
				function adjust() {
					//console.log('auto adjust height');
					// use the height of search_gadget div + offset
					var height = $('#search_gadget').height() + 20;
					// keep minimum height to 350
					if (height < 350) {
						height = 350;
					}
					gadgets.window.adjustHeight(height);
				}
				function XMLtoJSON() {
					var me = this; // stores the object instantce

					// gets the content of an xml file and returns it in
					me.fromFile = function (xml, rstr) {
						console.log('XMLtoJSON-fromFile');
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
						console.log('XMLtoJSON-fromStr');
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
						json_str = json_str.replace('\n','');

						// sets and returns the JSON object, if "rstr" undefined (not passed), else, returns JSON string
						if (typeof(rstr) == 'undefined') {
							try{ 
								return JSON.parse(json_str)
							}
							catch(e){
								console.log(e); //error in the above string(in this case,yes)!
								return ''
							} 
						}else {
							return json_str;
						}
					}

					// receives XML DOM object, returns converted JSON object
					var setJsonObj = function (xml) {
						//console.log('XMLtoJSON-setJsonObj');
						var js_obj = {};
						if (xml.nodeType == 1) {// element
							if (xml.attributes.length > 0) {
								//js_obj["@attributes"] = {};
								for (var j = 0; j < xml.attributes.length; j++) {
									var attribute = xml.attributes.item(j);
									//js_obj["@attributes"][attribute.nodeName] = attribute.value;
									js_obj[attribute.nodeName] = attribute.value;
									//console.log('XMLtoJSON-nodeType-element:'+attribute.nodeName+" : "+attribute.value);
								}
							}
						} else if (xml.nodeType == 3) {// text
							js_obj = xml.nodeValue;
							//console.log('XMLtoJSON-nodeType-text:'+xml.nodeValue);
						}
						// do children
						if (xml.hasChildNodes()) {
							for (var i = 0; i < xml.childNodes.length; i++) {
								var item = xml.childNodes.item(i);
								var nodeName = item.nodeName;
								if (typeof(js_obj[nodeName]) == "undefined") {
									if (nodeName == "#text") js_obj = item.textContent;
									else js_obj[nodeName] = setJsonObj(item);
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
						var rejsn = JSON.stringify(js_obj, undefined, 2).replace(/(\\t|\\r|\\n)/g, '').replace(/"",[\n\t\r\s]+""[,]*/g, '').replace(/(\n[\t\s\r]*\n)/g, '').replace(/[\s\t]{2,}""[,]{0,1}/g, '').replace(/"[\s\t]{1,}"[,]{0,1}/g, '').replace(/\[[\t\s]*\]/g, '""');
						return (rejsn.indexOf('"parsererror": {') == -1) ? rejsn : 'Invalid XML format';
					}
				};
				
				function toggleParametersField(){
					$(".paramExpanded").hide();	
					$(".paramExpanded, .paramCollapsed").click(function() {
						$(this).parent().children(".paramExpanded, .paramCollapsed").toggle();
						adjust();
					});
				};