
success = "x";


//
function pseudoaccordion(j) {
	showhide(j);
	changePlusMinus("h_".concat(j));
}


//
function changePlusMinus(j) {
	(document.getElementById(j).innerHTML== "-") ? changeToPlus(j) : changeToMinus(j);
}


//
function changeToPlus(j) {
	document.getElementById(j).innerHTML= "+";
}


//
function changeToMinus(j) {
	document.getElementById(j).innerHTML= "-";
}


/////////////////////////////////////////   hide/show scripts  //////////////////////////////////////////////


//
function iconshowhidesinmple(j, iconid){

	showhide(j);
	(document.getElementById(iconid).className=="icon-plus") ?document.getElementById(iconid).className = "icon-minus" : document.getElementById(iconid).className = "icon-plus";
}


//
function iconshowhide(i,j, iconid){
	
	if(document.getElementById("hide_".concat(i)).className=="swHide" && document.getElementById("hide_".concat(j)).className=="swHide") visibleShow(i);
	if(document.getElementById("hide_".concat(i)).className=="swMain" && document.getElementById("hide_".concat(j)).className=="swMain") visibleHide(i);
	showhide(j);
	(document.getElementById(iconid).className=="icon-plus") ?document.getElementById(iconid).className = "icon-minus" : document.getElementById(iconid).className = "icon-plus";
}


//
function hideswitch(i,j) {
	visibleStateChoose(i);
	visibleStateChoose(j);
};


//
function showhide(j) {
	visibleStateChoose(j);
};





//
function radiohide(j) {
	if (j != "none"){
		if (j<=(-100)){
			for (var i=1010; i <= 1011; i++)
				visibleHide("-".concat(i));
			visibleShow(j);
		}else{
			for (var i=10; i <= 11; i++)
				visibleHide("-".concat(i));
			visibleShow(j);
		}
	}
};


//
function visibleStateChoose(j) {
	(document.getElementById("hide_".concat(j)).className=="swHide") ? visibleShow(j) : visibleHide(j);
}


//
function visibleShow(j) {
	document.getElementById("hide_".concat(j)).className = "swMain";
};


//
function visibleShowWithFullId(j) {
	document.getElementById(j).className = "swMain";
};


//
function visibleHide(j) {
	document.getElementById(j).className  = "swHide";
};

//
function visibleHideWithFullId(j) {
	document.getElementById(j).className  = "swHide";
};


/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////


//check Content
function checkContent(check) {
	if (check == "none")
		SubmitGCDJ('-21', "hide");
	else
		SubmitGCDJ('-21', "show");
}


//Method to choose a Proejct
function chooseTable(method, data) {
	resourceMethod(document.getElementById('tablebuilderurl').value, method, data, false);

}


/*// Method to choose a Project
function chooseProject(url, method, data, j) {
	resourceMethod(url, method, data, false);
	window.setTimeout('reload()',5);
}*/


/*//Method to choose a Project
function chooseProject2(archivingURL, method, id, name, j) {
	var data = {};
	data["id"] = id;
	data["name"] = name;
	resourceMethod(archivingURL, method, data, false);
	visibleShow(j);
	window.setTimeout('reload()',5);
}*/


// Method for build a new Project
function checkDate(name, size) {
	var check = true;
	var numbers =['0','1','2','3','4','5','6','7','8','9' ];
	var sign = ['-'];
	var str ;
	var data = {};
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(i);
		var topic = document.getElementById('lato'.concat(str)).textContent;
		data[topic] = document.getElementById(str).value;
	}
	var checkList = ["startDate", "endDate"];
	for (i =0;i<=1;i++) {
		checkDate = checkList[i];
		if (data[checkDate].length-1 >=7) {
			if (numbers.indexOf(data[checkDate].charAt(0))<0){check=false;}
			if (numbers.indexOf(data[checkDate].charAt(1))<0){check=false;}
			if (numbers.indexOf(data[checkDate].charAt(2))<0){check=false;}
			if (numbers.indexOf(data[checkDate].charAt(3))<0){check=false;}
			if (sign.indexOf(data[checkDate].charAt(4))<0){check=false;}
			if (numbers.indexOf(data[checkDate].charAt(5))<0){check=false;}
			if (numbers.indexOf(data[checkDate].charAt(6))<0){if (sign.indexOf(data[checkDate].charAt(6))<0){check=false;}}
			if (numbers.indexOf(data[checkDate].charAt(7))<0){if (sign.indexOf(data[checkDate].charAt(7))<0){check=false;}}
			if (data[checkDate].length-1 >=8){if (numbers.indexOf(data[checkDate].charAt(8))<0){if (sign.indexOf(data[checkDate].charAt(8))<0){check=false;}}}
			if (data[checkDate].length-1 >=9){if (numbers.indexOf(data[checkDate].charAt(9))<0){if (sign.indexOf(data[checkDate].charAt(9))<0){check=false;}}}
		}else {
			check=false;
		}
	}
	return check
}



// Method to update a Project
function updateProject (archivingURL, method, name, size, hide, userID) {
	var check = checkDate(name, size);
	if (check == true) {
		resourceMethod_I(archivingURL, method, name, size, userID, false);
		visibleShow(hide);
		window.setTimeout('visibleHide('+hide+')',1500);
	}else{
		visibleShow('2'+hide.substring(1));
		window.setTimeout('visibleHide('+'2'+hide.substring(1)+')',1500);
	}
}




/*//generally Methods
function resourceMethod_ChooseProject(projectProfileURL, method, projectId,  divId,async) {
	var data = {};
	data["projectid"] = projectId;
	ajaxActionRequest_ChooseProject(projectProfileURL, method, data, divId,async);
}*/


//generally Methods
function resourceMethod_Choose(archivingURL, method, rowid, headid1, headid2,withoutRelationship, withRelationship, async) {
	var data = {};
	data["rowid"] = rowid;
	data["headid1"] = headid1;
	data["headid2"] = headid2;
	ajaxActionRequest_Choose(archivingURL, method, data, withoutRelationship, withRelationship, async);
}


//generally Methods
function resourceMethod(archivingURL, method, data, async) {
	ajaxRequest(archivingURL, method, data, async);
}


//
function resourceMethod_I_to(archivingURL, method, name, size, relationID, async, runningNumber) {
	console.log (archivingURL+ " | "+ method+ " | "+ name+ " | "+ size+ " | "+ relationID+ " | "+ async+ " | "+ runningNumber);
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
	console.log("data: "+data);
	ajaxRequest(archivingURL, method, data, async);
};


//
function resourceMethod_I(archivingURL, method, name, size, relationID, async) {

	var str ;
	var data = {};
	data["relationID"] = relationID;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(i);
		var topic = document.getElementById('lato'.concat(str)).textContent;
		data[topic] = document.getElementById(str).value;
	}
	ajaxRequest(archivingURL, method, data, async);
};



//
function resourceMethod_JI(archivingURL, method, name, j, size, async) {
	var str ;
	var data = new Object() ;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(j).concat("_").concat(i);
		data[str] = document.getElementById(str).value;
	}
	ajaxRequest(archivingURL, method, data, async);
	updateLaVaSet_JI(name, j, size);
};


/////////////////////////////////////////   build JSON  //////////////////////////////////////////////


//build JSON of Column
function buildJsonColum(columnId, headId, columnName){
	var json = {};
	json["columnid"]=columnId;
	json["headid"]=headId;
	json["column_name"]=columnName;
	return json;
}


//build JSON of Content
function buildJsonContent(contentId, headId, columnId, rowId, content){
	var json = {};
	json["contentid"]=contentId;
	json["headid"]=headId;
	json["columnid"]=columnId;
	json["rowid"]=rowId;
	json["cellcontent"]=content;
	return json;
}


//build JSON of Head
function buildJsonHead(headId, tableName, tableType){
	var json = {};
	json["headid"]=headId;
	json["table_name"]=tableName;
	json["table_type"]=tableType;
	return json;
}


//add a sub JSON to a JSON
function addSubJsonToJson(json, subjson, key){
	json[key] = subjson;
	return json;
}


//test function dcst portlet
function getCategory(category) {
	ajaxGetCategory(category);
}

//////////////////////////////////////////////////  update Label-Value-Data in the view ///////////////////////////////////////////////


//
function updateLaVaSet_I (name, size) {
	for (var i = 0; i < size; i++){
		updateLaVa_I(name, i);
	}
}


//
function updateLaVa_I(name, i) {
	document.getElementById("lava".concat(name).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(i)).value;
}


//
function updateLaVaSet_JI (name, j, size) {
	for (var i = 1; i < size; i++)
		 updateLaVa_JI(name, j, i);
}


//
function updateLaVa_JI(name, j, i) {
	document.getElementById("lava".concat(name).concat("_").concat(j).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(j).concat("_").concat(i)).value;
}


//////////////////////////////////////////////////  made the input-fields empty ////////////////////////////////////////////////////////


//
function cleanTextSet(name, size) {
	for (var i = 1; i < size; i++)
		cleanText(name, i);
}


//
function cleanText(name, i) {
	document.getElementById(name.concat("_").concat(i)).value= "";
}


/////////////////////////////////////////   ActionRequest  //////////////////////////////////////////////


//
function actionMethods(method) {
	document.getElementById("<portlet:namespace/>".concat(method)).setAttribute('value',method);
};



//
function actionMethod(method, addon) {
	document.getElementById("<portlet:namespace/>".concat(method.concat(addon))).setAttribute('value',method);
};


///////////////////////////////////////  reload page //////////////////////////////////////////////////////////////


//
function reload() {
	window.location.reload(true);
}


/////////////////////////////////////////////////// tabs ////////////////////////////////////////////////////


//
AUI().ready(function(A){
	if ($('ul#verticalNav li a').length && $('div.section').length ) {
		$('div.section').css( 'display', 'none' );
		$('ul#verticalNav li a').click(function() {
			showSection( $(this).attr('href') );
		});
		if(window.location.hash) 
			showSection( window.location.hash);
		else 
			$('ul#verticalNav li:first-child a').click();
	}
});


//
function showSection( sectionID ) {
	$('div.section').css( 'display', 'none' );
	$('div'+sectionID).css( 'display', 'block' );
	$('ul#verticalNav li a').removeClass('active');
	$('a#link'.concat(sectionID.substring(4))).addClass('active');
}


//
function showDiv( sectionID, divID ) {
	$('div.section').css( 'display', 'none' );
	$('div'+sectionID).css( 'display', 'block' );
	$('ul#verticalNav li a').removeClass('active');
	$('a#link'.concat(sectionID.substring(4))).addClass('active');
	pseudoaccordion(divID);
}