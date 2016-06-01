//////////////////////////////////////////////   Helper  ///////////////////////////////////////////////////


//
function loadPath (path){
	console.log(path);
	$( "#".concat(tab)).load( document.getElementById("path").value.concat(path));
}


//
function loadPath (path1, path2){
	console.log(path1 +"" | "+path2");
	$( "#".concat(tab1)).load( document.getElementById("path").value.concat(path1));
	$( "#".concat(tab2)).load( document.getElementById("path").value.concat(path2));
}

/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////


//
function chooseTableForRelationship(method, rowid, headid1, headid2, archivingURL, withoutRelationship, withRelationship){
	var archivingURL = document.getElementById('tablebuilderurl').value;
	var async = false;
	var data = {};
	data["rowid"] = rowid;
	data["headid1"] = headid1;
	data["headid2"] = headid2;
	ajaxTableBuilderActionRequest_Choose(archivingURL, method, data, withoutRelationship, withRelationship, async);
}


//
function deleteRelationContent(method, rowid, contentid, tab, path){
	var data = {};
	data["rowid"] = rowid;
	data["contentid"] = contentid;
	tablebuilderURL = document.getElementById('tablebuilderurl').value;
	ajaxTableBuilderRequest(tablebuilderURL, method, data, false);
	loadPath (path);
	document.getElementById('tablebuilderurl').value = tablebuilderURL;
}


//
function deleteContent(method, data, tab, path){
	ajaxTableBuilderRequest(document.getElementById('tablebuilderurl').value, method, data, false);
	loadPath (path);
}


//
function deleteColumn(method, data, tab1, path1,tab2,path2){
	ajaxTableBuilderRequest(document.getElementById('tablebuilderurl').value, method, data, false);
	loadPaths (path1, path2);
}


//
function deleteTable(method, data, tab1, path1,tab2,path2){
	ajaxTableBuilderRequest(document.getElementById('tablebuilderurl').value, method, data, false);
	loadPath (path1, path2);
}


//Method to update a RelationTable in Head
function updateRelationTable (method, mtable, ntable,tab,  path) {
	var data = {};
	data["mtable"] = mtable;
	data["ntable"] = ntable;
	ajaxTableBuilderRequest(document.getElementById('tablebuilderurl').value, method, data, false);
	loadPath (path);
}


//
function updateRelationContent(method, tablename, rowid,contentid, tab1,  path1, tab2,  path2) {
	var data = {};
	data["tablename"] = tablename;
	data["rowid"] = rowid;
	data["contentid"] = contentid;
	tablebuilderURL = document.getElementById('tablebuilderurl').value;
	ajaxTableBuilderRequest(tablebuilderURL, method, data, false);
	loadPath (path1, path2);
	document.getElementById('tablebuilderurl').value = tablebuilderURL;
}


//Method to update a Row in Head/Position
function updateTable (method, name, size, task, tab1, path1, tab2, path2,runningNumber) {
	var archivingURL = document.getElementById('tablebuilderurl').value;
	var relationID = task;
	var async = false;
	var str ;
	var headStr;
	var data = {};
	var contentName;
	if (method == 'updateContent'){
		contentName = name;
		name ="dyta_".concat(runningNumber);
	}
	headStr = name.concat("_").concat("table_name");
	data = buildJsonHead(document.getElementById('top'.concat(headStr)).value,  document.getElementById(headStr).value, relationID);
	if (method == 'addColumnToTable')
		size=size-1;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(i);
		var subdata = buildJsonColum(document.getElementById('top'.concat(str)).value, document.getElementById('top'.concat(headStr)).value, document.getElementById(str).value);
		if (method == 'updateContent')
			data = addSubJsonToJson(data, addSubJsonToJson(subdata, buildJsonContent(document.getElementById("top".concat(contentName).concat("_").concat(i+1)).value, document.getElementById('top'.concat(headStr)).value, document.getElementById('top'.concat(str)).value, document.getElementById(contentName.concat("_rowID")).value, document.getElementById(contentName.concat("_").concat(i+1)).value),0), i);
		else
			data = addSubJsonToJson(data, subdata, i);
	}
	if (method =='addColumnToTable'){
		var subdata = buildJsonColum("0", document.getElementById('top'.concat(headStr)).value, "");
		data = addSubJsonToJson(data, subdata, size);
	}
	ajaxTableBuilderRequest(archivingURL, method, data, async);
	loadPath (path1, path2);
}



