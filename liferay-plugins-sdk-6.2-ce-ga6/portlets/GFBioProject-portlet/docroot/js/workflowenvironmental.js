//
function buildCommonResearchObjectJson(projectJson){

	var authornames = (document.getElementById("ewf_ro_author").value).trim();
	if (authornames.charAt(authornames.length-1)==',')
		authornames = authornames.substring(0, authornames.length-1);
	authornames = ('["'.concat(authornames).concat('"]')).replace(/,/g,'","');

	var extendetdata = {
		"publications":document.getElementById("ewf_ro_publications").value,
	}

	var researchObjectJson = {
		"authornames": authornames,
		"name":document.getElementById("ewf_ro_name").value, 
		"label":document.getElementById("ewf_ro_name").value,
		"description":document.getElementById("ewf_ro_description").value,
		"extendeddata": extendetdata		
	};

	if (projectJson.projectid!=0)
		researchObjectJson["projectid"]= projectJson.projectid;
	
	researchObjectJson["submitterid"]=Number(document.getElementById("ewf_user_id").innerHTML);
	
	return researchObjectJson;
}


//
function buildResearchObjectJsonForCreate(projectJson){
	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["metadataid"]= 1909;
	researchObjectJson ["licenseid"] = Number(document.getElementById("ewf_ro_licenselabel").value);
	return researchObjectJson;
}


//
function buildResearchObjectJsonForUpdate(projectJson){

	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["researchobjectid"]= Number(document.getElementById("ewf_ro_id").innerHTML);
	researchObjectJson["researchobjectversion"]= Number(document.getElementById("ewf_ro_version").innerHTML);
	return researchObjectJson;
}



//
function checkInput(){
	var check = true;
	check = checkMinimalInput();
	
	if (!check){
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Please fill the empty fields.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Checking complete</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
		
	return check;
}


//
function checkMinimalInput(){
	var check = true;
	check = checkMinimalResearchObjectInput();
	return check;
}


//
function buildMrr(){
	var projectJson = {};
	if (checkMinimalInput()){
		var researchObjectJson = {};
		researchObjectJson = buildResearchObjectJsonForCreate(projectJson);		
		projectJson["projectid"]= document.getElementById("ewf_project_id").innerHTML;
		projectJson["researchobjects"]= researchObjectJson;
		projectJson["submittermail"]=document.getElementById("ewf_user_mail").innerHTML;
	}
	
	return projectJson
}


//
function checkMinimalResearchObjectInput(){

	
	var check = true;
	
	if (document.getElementById("ewf_ro_name").value==""){
		check = false;
		document.getElementById("ewf_ro_name_l").className="labelFalse";
	}else
		document.getElementById("ewf_ro_name_l").className="control-label";
	
	
	if (document.getElementById("ewf_ro_description").value==""){
		check = false;
		document.getElementById("ewf_ro_description_l").className="labelFalse";
	}else
		document.getElementById("ewf_ro_description_l").className="control-label";
	

	if (document.getElementById("ewf_ro_author").value==""){
		check = false;
		document.getElementById("ewf_ro_author_l").className="labelFalse";
	}else
		document.getElementById("ewf_ro_author_l").className="control-label";

	
	
	if (document.getElementById("ewf_ro_licenselabel").value=="none") {
		check = false; 
		document.getElementById("ewf_ro_license_l").className="labelFalse";
	}else
		document.getElementById("ewf_ro_license_l").className="control-label";
	
	
	if (!check){
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Please fill the empty fields.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Checking complete</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
		
	}

	return check;
}


//
function saveAllInput(){

	var projectJson = {};
	if (checkMinimalInput()){
		projectJson = saveProjectInput();
		projectJson = saveResearchObjectInput(projectJson);
		projectJson["submittermail"]=document.getElementById("ewf_user_mail").innerHTML;
	}
	return projectJson;
}


//
function saveProjectInput(){
	
	var projectJson = {};
	projectJson["projectid"]= document.getElementById("ewf_project_id").innerHTML;
	return projectJson;
}


//
function saveResearchObjectInput(projectJson){
	
	if (document.getElementById("ewf_ro_id").innerHTML==0){
		if (checkMinimalResearchObjectInput())
			researchObjectJson = createEwfResearchObject(projectJson);
	}else{
		if (checkMinimalResearchObjectInput())
			researchObjectJson = updateEwfResearchObject(projectJson);
	}
	
	projectJson["researchobjects"]= researchObjectJson;
	
	if (researchObjectJson.researchobjectid >0){
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Data were stored.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('ewf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	
	return projectJson;
}


//
function submitInput(url){
	
	if (checkInput()){
		
		var mrrJson = buildMrr();
		//var registryJson = buildSubmissionJsonForRegistry(mrrJson.researchobjects);
		//startSubmissionRegistry(registryJson);
		
		if(document.getElementById("ewf_lf_submissioncomentarField").className != 'portlet-msg-error'){
			var data ={};
			data["mrr"]= mrrJson;
			//data["submissionregistry"]= registryJson;

			startSubmission(data);
		}
	}
}


//
function updateEwfResearchObject(projectJson){
	
	var researchObjectJson = buildResearchObjectJsonForUpdate(projectJson);
	Liferay.Service('/GFBioProject-portlet.researchobject/update-research-object',
		{
			requestJson: '['.concat(JSON.stringify(researchObjectJson)).concat(']')
		},
		function(obj) {
			var json = obj[0];
			if (json.researchobjectid >0){
				document.getElementById("ewf_ro_version").innerHTML= json.researchobjectversion;
				
				if (document.getElementById("ewf_ro_name").value =="")
					document.getElementById("ewf_ro_name").value = document.getElementById("ewf_ro_label").value;
				
				var commentarField = $("#".concat('ewf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-success'>Data were stored.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('ewf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}
		}
	);
	return researchObjectJson;
}