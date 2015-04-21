
success = "x";



function pseudoaccordion(j) {
	showhide2(j);
	changePlusMinus("h_".concat(j));
}

function changePlusMinus(j) {
	(document.getElementById(j).innerHTML== "-") ? changeToPlus(j) : changeToMinus(j);
}

function changeToPlus(j) {
	document.getElementById(j).innerHTML= "+";
}

function changeToMinus(j) {
	document.getElementById(j).innerHTML= "-";
}



/////////////////////////////////////////   hide/show scripts  //////////////////////////////////////////////

function showhide2(j) {
	visibleStateChoose(j);
}

function showhide(j) {
	visibleStateChoose(j);
	visibleValueChoose(j);
};

function visibleValueChoose(j) {
	(document.getElementById("hide_but_".concat(j)).value.substring(0,4)=="hide") ? visibleValueChange("show", j) : visibleValueChange("hide", j);
}

function visibleValueChange(str, j) {
	document.getElementById("hide_but_".concat(j)).value = str.concat(document.getElementById("hide_but_".concat(j)).value.substring(4));
}

function visibleStateChoose(j) {
	(document.getElementById("hide_".concat(j)).className=="swHide") ? visibleShow(j) : visibleHide(j);
}

function radiohide(j) {
	if (j != "none") {
		if (j<=(-100)) {
			for (var i=1010; i <= 1011; i++)
				visibleHide("-".concat(i));
			visibleShow(j);
		}else {
			for (var i=10; i <= 11; i++)
				visibleHide("-".concat(i));
			visibleShow(j);
		}
	}
};

function visibleShow(j) {
	document.getElementById("hide_".concat(j)).className = "swMain";
};

function visibleHide(j) {
	document.getElementById("hide_".concat(j)).className = "swHide";
};


/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////

//check Content
function checkContent(check) {
	if (check == "none")
		SubmitGCDJ('-21', "hide");
	else
		SubmitGCDJ('-21', "show");
}


// Method to choose a Proejct
function chooseProject(archivingURL, method, data, j) {
	resourceMethod(archivingURL, method, data);
	visibleShow(j);
	window.setTimeout('reload()',5);
}



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



function newProject(archivingURL, method, name, size, hide,  userID) {

	var check = checkDate(name, size);
	if (check == true) {
		resourceMethod_I(archivingURL, method, name, size,  userID);
		cleanTextSet(name, size);
		updateLaVaSet_I(name, size);
		visibleShow(hide);
		reload();
	}
	else
	{
		visibleShow('2'+hide.substring(1));
		window.setTimeout('visibleHide('+'2'+hide.substring(1)+')',1500);
	}
}

function newTable(archivingURL, method, name, size, hide) {

	console.log(archivingURL + ' '+ method + ' '+ name + ' '+ size);
	resourceMethod_I(archivingURL, method, name, size,  0);
	cleanTextSet(name, size);
	updateLaVaSet_I(name, size);
	visibleShow(hide.concat("_true"));
	reload();

}


// Method to update a Project
function updateProject (archivingURL, method, name, size, hide, userID) {

	var check = checkDate(name, size);

	if (check == true) {
		resourceMethod_I(archivingURL, method, name, size, userID);
		visibleShow(hide);
		window.setTimeout('visibleHide('+hide+')',1500);
	}
	else
	{
		visibleShow('2'+hide.substring(1));
		window.setTimeout('visibleHide('+'2'+hide.substring(1)+')',1500);
	}
}


//Method to update a RelationTable in Head
function updateRelationTable (archivingURL, method, mtable, ntable, hide) {
	console.log(archivingURL+ " || "+ method+ " || "+  mtable+ " || "+ ntable+ " || "+ hide);
	var data = {};
	data["mtable"] = mtable;
	data["ntable"] = ntable;
	resourceMethod(archivingURL, method, data);
	visibleShow(hide);
	window.setTimeout("visibleHide('+hide+')",1500);
}

//Method to update a Table in Head
function updateTable (archivingURL, method, name, size, hide) {

	resourceMethod_I(archivingURL, method, name, size, 0);
	visibleShow(hide);
	window.setTimeout("visibleHide('+hide+')",1500);
}

//generally Methods
function resourceMethod(archivingURL, method, data) {
	ajaxRequest(archivingURL, method, data);
}

function resourceMethod_I(archivingURL, method, name, size, relationID) {
	var str ;
	var data = {};
	data["relationID"] = relationID;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(i);
		var topic = document.getElementById('lato'.concat(str)).textContent;

		data[topic] = document.getElementById(str).value;
		console.log(str+ " | "+ topic + " | "+document.getElementById(str).value);
	}
	ajaxRequest(archivingURL, method, data);
	updateLaVaSet_I(name, size);
};

function resourceMethod_JI(archivingURL, method, name, j, size) {
	var str ;
	var data = new Object() ;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(j).concat("_").concat(i);
		data[str] = document.getElementById(str).value;
	}
	ajaxRequest(archivingURL, method, data);
	updateLaVaSet_JI(name, j, size);
};


//////////////////////////////////////////////////  update Label-Value-Data in the view ///////////////////////////////////////////////



function updateLaVaSet_I (name, size) {
	for (var i = 1; i < size; i++)
		 updateLaVa_I(name, i);
}

function updateLaVa_I(name, i) {
	document.getElementById("lava".concat(name).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(i)).value;
}


function updateLaVaSet_JI (name, j, size) {
	for (var i = 1; i < size; i++)
		 updateLaVa_JI(name, j, i);
}


function updateLaVa_JI(name, j, i) {
	document.getElementById("lava".concat(name).concat("_").concat(j).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(j).concat("_").concat(i)).value;
}



//////////////////////////////////////////////////  made the input-fields empty ////////////////////////////////////////////////////////


function cleanTextSet(name, size) {
	for (var i = 1; i < size; i++)
		cleanText(name, i);
}

function cleanText(name, i) {
	document.getElementById(name.concat("_").concat(i)).value= "";
}


/////////////////////////////////////////   ActionRequest  //////////////////////////////////////////////

function actionMethods(method) {
	document.getElementById("<portlet:namespace/>".concat(method)).setAttribute('value',method);
};


function actionMethod(method, addon) {
	document.getElementById("<portlet:namespace/>".concat(method.concat(addon))).setAttribute('value',method);
};


///////////////////////////////////////  reload page //////////////////////////////////////////////////////////////


function reload() {
	window.location.reload(true);
}







