
success = "x";





/////////////////////////////////////////   hide/show scripts  //////////////////////////////////////////////	
	
function showhide(j) {
	visibleStateChoose(j);
	visibleValueChoose(j);
};
		
function visibleValueChoose(j){
	(document.getElementById("hide_but_".concat(j)).value.substring(0,4)=="hide") ? visibleValueChange("show", j) : visibleValueChange("hide", j);
}
		
function visibleValueChange(str, j){
	document.getElementById("hide_but_".concat(j)).value = str.concat(document.getElementById("hide_but_".concat(j)).value.substring(4));
}
		
function visibleStateChoose(j){
	(document.getElementById("hide_".concat(j)).className=="swHide") ? visibleShow(j) : visibleHide(j);
}
		
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
		
function visibleShow(j) {
	document.getElementById("hide_".concat(j)).className = "swMain";
};
		
function visibleHide(j) {
	document.getElementById("hide_".concat(j)).className = "swHide";
};
		
	
/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////

//check Content
function checkContent(check){
	if (check == "none")
		SubmitGCDJ('-21', "hide");
	else
		SubmitGCDJ('-21', "show");
}
	
	
// Method to choose a Proejct
function chooseProject(archivingURL, method, data, j){
	resourceMethod(archivingURL, method, data);
	visibleShow(j);
	window.setTimeout('reload()',5);
}


	
// Method for build a new Project
			
function newProject(archivingURL, method, name, size, hide,  userID){
	resourceMethod_I(archivingURL, method, name, size,  userID);
	cleanTextSet(name, size);
	updateLaVaSet_I(name, size);
	visibleShow(hide);
	reload();
}	
	

//generally Methods
function resourceMethod(archivingURL, method, data){
	ajaxRequest(archivingURL, method, data);
}

function resourceMethod_I(archivingURL, method, name, size, relationID){
	console.log("relationID: " +relationID);
	var str ;
	var data = new Object();
	data["relationID"] = relationID;
	for (var i = 0; i < size; i++){
		str = name.concat("_").concat(i);
		var topic = document.getElementById('lato'.concat(str)).textContent;
		console.log(topic + " | "+document.getElementById(str).value);
		data[topic] = document.getElementById(str).value;
	}
	ajaxRequest(archivingURL, method, data);
	updateLaVaSet_I(name, size);
};
	
function resourceMethod_JI(archivingURL, method, name, j, size){
	var str ;
	var data = new Object() ;
	for (var i = 0; i < size; i++){
		str = name.concat("_").concat(j).concat("_").concat(i);
		data[str] = document.getElementById(str).value;
	}
	ajaxRequest(archivingURL, method, data);
	updateLaVaSet_JI(name, j, size);
};
	

//////////////////////////////////////////////////  update Label-Value-Data in the view ///////////////////////////////////////////////


	
function updateLaVaSet_I (name, size){
	for (var i = 1; i < size; i++)
		 updateLaVa_I(name, i);
}
	
function updateLaVa_I(name, i){
	document.getElementById("lava".concat(name).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(i)).value;
}
	
	
function updateLaVaSet_JI (name, j, size){
	for (var i = 1; i < size; i++)
		 updateLaVa_JI(name, j, i);
}
	

function updateLaVa_JI(name, j, i){
	document.getElementById("lava".concat(name).concat("_").concat(j).concat("_").concat(i)).innerHTML= document.getElementById(name.concat("_").concat(j).concat("_").concat(i)).value;
}
	
	

//////////////////////////////////////////////////  made the input-fields empty ////////////////////////////////////////////////////////


function cleanTextSet(name, size){
	for (var i = 1; i < size; i++)
		cleanText(name, i);
}
	
function cleanText(name, i){
	document.getElementById(name.concat("_").concat(i)).value= "";
}
	

/////////////////////////////////////////   ActionRequest  //////////////////////////////////////////////	
	
function actionMethods(method){
	document.getElementById("<portlet:namespace/>".concat(method)).setAttribute('value',method);
};
		

function actionMethod(method, addon){
	document.getElementById("<portlet:namespace/>".concat(method.concat(addon))).setAttribute('value',method);
};

	
///////////////////////////////////////  reload page //////////////////////////////////////////////////////////////


function reload(){
	window.location.reload(true);
}

/////////////////////////////////////////////////// tabs ////////////////////////////////////////////////////


function showSection( sectionID ) {
    $('div.section').css( 'display', 'none' );
    $('div'+sectionID).css( 'display', 'block' );
    $('ul#verticalNav li a').removeClass('active');
    $('a#link'.concat(sectionID.substring(4))).addClass('active');

}

$(document).ready(function(){
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


///////////////////////////////////////  content //////////////////////////////////////////////////////////////
	

//page

function buildHelper(path,checker, archivingURL, namespace, userID){
	buildTabs(path,checker);
	buildPage(archivingURL, namespace, userID);
}

function buildTabs(path,checker){
	if (checker=="true"){
		$( "#tabNoSubmission" ).load( path.concat("/html/nosubmission.jsp"));
	}else{
		
		//$( "#tabSubmission" ).load( path.concat("/html/submission.jsp"));
		//$( "#tabProjProfile" ).load( path.concat("/html/nosubmission.jsp"));
	}
}


function buildPage(archivingURL, namespace, userID){
	var cssLato  = "rowLato";
	var cssLava  = "rowLava";
	var cssInput = "rowInput";
	var cssField = "widthL";
	buildNewProject(archivingURL, namespace, userID, "newProject", "muster", "newproj", cssLato, cssLava, cssInput, cssField);
}

//page blocks


function buildNewProject(archivingURL, namespace, userID, target, projna, na, cssLato, cssLava, cssInput, cssField){
	na = na.concat("_");
	rowFullLine__B(namespace, target, na.concat("B"),  cssLato, cssLava, cssInput, cssField,  "", "", "new Project","newProject('".concat(archivingURL)+"', 'newProject','newproj', '"+(loopSize(archivingURL, 'getProjectSize','muster')-1)+"')");
	rowLoop100 (archivingURL, namespace, target, projna, na, cssLato, cssLava, cssInput, cssField);
	rowFullLine(namespace, target, na.concat("0"),  cssLato, cssLava, cssInput, cssField,  "hidden", "", "", userID);

}



function rowLoop100 (archivingURL, namespace, target,  projna, na, cssLato, cssLava, cssInput, cssField){
	//console.log("mittelbereich: " +loopSize(archivingURL, "getProjectSize",projna));
	for (var i = loopSize(archivingURL, "getProjectSize",projna)-2; i >0;i--){
	//for (var i = 4-2; i >0;i--){
		var valLato  = labelValue(archivingURL, "getProjectTopic", projna,  i);
		var valLava  ="";
		var valField ="";
		rowFullLine(namespace, target, na.concat(i),  cssLato, cssLava, cssInput, cssField,  "text", valLato, valLava, valField);
	}
}

function rowFullLine (namespace, target, na,  cssLato, cssLava, cssInput, cssField,  show, valLato, valLava, valField){
	var row = $('<div/>').attr({class:'row'});
	rowDivLabel(namespace, na, cssLato, "lato").appendTo(row);
	rowDivLabel(namespace, na, cssLava, "lava").appendTo(row);
	rowDivField(namespace, na, cssInput, cssField, show, valField).appendTo(row);
	$(row).prependTo("#".concat(target));
	document.getElementById("lato".concat(na)).innerHTML = valLato;
	document.getElementById("lava".concat(na)).innerHTML = valLava;
};

function rowFullLine__B (namespace, target, na,  cssLato, cssLava, cssInput, cssField,  valLato, valLava, valField,funct){
	var row = $('<div/>').attr({class:'row'});
	rowDivLabel(namespace, na, cssLato, "lato").appendTo(row);
	rowDivLabel(namespace, na, cssLava, "lava").appendTo(row);
	rowDivButton(namespace, na, cssInput, cssField, valField, funct).appendTo(row);
	$(row).prependTo("#".concat(target));
	document.getElementById("lato".concat(na)).innerHTML = valLato;
	document.getElementById("lava".concat(na)).innerHTML = valLava;
};



//block parts


function rowDivLabel(namespace, na, cssClass, typ){
	var div = $('<div/>').attr({class:cssClass});
	rowLabel(namespace, na,  typ).appendTo(div);
	return div;
}

function rowDivField(namespace, na, cssInput, cssField, show, val){
	var div = $('<div/>').attr({class:cssInput});
	rowField(namespace, na, cssField, show, val).appendTo(div);
	return div;
}

function rowDivButton(namespace, na, cssInput, cssField, val, funct){
	var div = $('<div/>').attr({class:cssInput});
	rowButton(namespace, na, cssField, val, funct).appendTo(div);
	return div;
}




// basic support

function callbackSuccess(data){
	success = data.toString();
}

function labelValue(archivingURL, method, projna, i){
	var data = new Object;
	data["index"]=i;
	data["projna"]=projna;
	ajaxValueResponse(archivingURL, method, data);	//success will be change by callbackSuccess in ajaxValueResponse
	return success; 
}

function loopSize(archivingURL, method, projna){
	var data = new Object();
	ajaxValueResponse(archivingURL, method, data["projna"]=projna);	//success will be change by callbackSuccess in ajaxValueResponse
	//console.log("loopSite: "+JSON.stringify(data));
	return success;
}

function tester(){
	console.log("nur ein test");
}


//elemental brick


function rowButton(namespace, na, cssClass, val, funct){
	return $('<input/>').attr({class:cssClass, type:"Button", id:na, name:namespace.concat(na), value:val, onclick:funct});
};

function rowField(namespace, na, cssClass, show, val){
	return $('<input/>').attr({class:cssClass, type:show, id:na, name:namespace.concat(na), value:val});
};

function rowLabel(namespace, na, typ){
	return $('<label/>').attr({id:typ.concat(na), name:typ.concat(namespace).concat(na)});
}




	
	
		
