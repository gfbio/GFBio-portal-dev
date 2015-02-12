


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
		for (var i=10; i <= 11; i++)
			visibleHide("-".concat(i));
		visibleShow(j);
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
		if (check == "none"){}
		else
			SubmitGCDJ('-21');
	}
	
	
	// Method to choose a Proejct
	function chooseProject(archivingURL, method, data, j){
		resourceMethod(archivingURL, method, data);
		visibleShow(j);
	}
	

	
	function newProUser(archivingURL, method, name, size){
		newProject(archivingURL, method, name, size);
		window.location.reload(true);
	}
	
	// Method for build a new Project
	function newProject(archivingURL, method, name, size){
		resourceMethod_I(archivingURL, method, name, size);
		cleanTextSet(name, size);
		updateLaVaSet_I(name, size);
		showhide(-2);
		//window.location.reload(true);
	}
	

	
	//generally Methods
	function resourceMethod(archivingURL, method, data){
		if (data == "none"){}
		else{
			console.log("startschuss");
			ajaxRequest(archivingURL, method, data);
		}
	}

	
	function resourceMethod_I(archivingURL, method, name, size){
		var str ;
		var data = new Object() ;
		for (var i = 0; i < size; i++){
			str = name.concat("_").concat(i);
			data[str] = document.getElementById(str).value;
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

	
	///////////////////////////////////////  Update reader //////////////////////////////////////////////////////////////







	
	
		
