
//
function buildCommonProjectJson(){
	
	var dcrtJson =[];
	for (i =0; i<document.getElementsByName("keywords").length;i++)
		if (document.getElementsByName("keywords")[i].checked)
			dcrtJson.push(document.getElementsByName("keywords")[i].value);
	
	var projectName = document.getElementById("cwf_project_name").value;
	var projectLabel = document.getElementById("cwf_project_label").value;

	if (projectName =="")
		projectName = projectLabel;
	if (projectLabel=="")
		projectLabel = projectName;

	var extendetdata = {};
	extendetdata["pi"] = document.getElementById("cwf_project_pi").value;

	var projectJson = {
		"name":projectName,
		"label":projectLabel,
		"description":document.getElementById("cwf_project_description").value,
		"extendeddata": JSON.stringify(extendetdata)		
	};

	if (!(dcrtJson.toString()==""))
		projectJson["dcrtids"] = dcrtJson.toString();

	return projectJson;
}


//
function buildProjectJsonForCreate(){
	var projectJson = buildCommonProjectJson();
	projectJson["userid"]=Number(document.getElementById("cwf_user_id").innerHTML);
	return projectJson;
}


//
function buildProjectJsonForUpdate(){
	var projectJson = buildCommonProjectJson();
	projectJson["projectid"]=Number(document.getElementById("cwf_project_id").innerHTML);
	return projectJson;
}


//
function buildCommonResearchObjectJson(projectJson){
	var roName = document.getElementById("cwf_ro_name").value;
	var roLabel = document.getElementById("cwf_ro_label").value;

	if (roName =="")	roName = roLabel;
	if (roLabel=="")	roLabel = roName;
	
	var nagoya ="";
	if (document.getElementById("cwf_ro_nagoyano").checked)		nagoya = 'no';
	else														nagoya = 'yes';
	//else														nagoya = document.getElementById("cwf_ro_nagoyadetails").value;

	var authornames = (document.getElementById("cwf_ro_author").value).trim();
	if (authornames.charAt(authornames.length-1)==',')
		authornames = authornames.substring(0, authornames.length-1);
	authornames = ('["'.concat(authornames).concat('"]')).replace(/,/g,'","');

	var extendetdata = {
		"publications":document.getElementById("cwf_ro_publications").value,
		"datacollectiontime":document.getElementById("cwf_ro_dct").value,
		"nagoya": nagoya
	}

	var researchObjectJson = {
		"authornames": authornames,
		"name":roName,
		"label":roLabel,
		"description":document.getElementById("cwf_ro_description").value,
		"extendeddata": extendetdata,
		"projectid": projectJson.projectid
	};

	
	return researchObjectJson;
}


//
function buildResearchObjectJsonForUpdate(projectJson){

	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["researchobjectid"]= Number(document.getElementById("cwf_ro_id").innerHTML);
	researchObjectJson["researchobjectversion"]= Number(document.getElementById("cwf_ro_version").innerHTML);
	researchObjectJson["metadataid"]= document.getElementById("cwf_ro_metadatalabel").value;
	return researchObjectJson;
}


//
function buildResearchObjectJsonForCreate(projectJson){
	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["metadataid"]= Number(document.getElementById("cwf_ro_metadatalabel").value);
	researchObjectJson["licenseid"] = Number(document.getElementById("cwf_ro_licenselabel").value);
	return researchObjectJson;
}


//
function saveAllInput(){

	var projectJson = {};
	if (checkMinimalInput()){
		projectJson = saveProjectInput();
		projectJson = saveResearchObjectInput(projectJson);
	}
	return projectJson;
}


//
function buildSubmissionJsonForRegistry(researchObjectJson){
	var registryJson = {};
	registryJson["researchobjectid"]= researchObjectJson.researchobjectid;
	registryJson["researchobjectversion"]= researchObjectJson.researchobjectversion;
	registryJson["archive"] = "GFBio collections";
	registryJson["brokersubmissionid"] ="";
	registryJson["userid"]=  Number(document.getElementById("cwf_user_id").innerHTML);
	return registryJson;
}


//
function checkInput(){
	console.log("check");
	var check = true;
	if (document.getElementById("cwf_project_name").value=="") 					{	check = false; document.getElementById("cwf_project_name_l").className="labelFalse";			document.getElementById("cwf_project_name").className="inputTextContainerFalse";}			else{document.getElementById("cwf_project_name_l").className="control-label";			document.getElementById("cwf_project_name").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_project_label").value=="") 				{	check = false; document.getElementById("cwf_project_label_l").className="labelFalse";			document.getElementById("cwf_project_label").className="inputTextContainerFalse";}			else{document.getElementById("cwf_project_label_l").className="control-label";			document.getElementById("cwf_project_label").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_project_pi").value=="") 					{	check = false; document.getElementById("cwf_project_pi_l").className="labelFalse";				document.getElementById("cwf_project_pi").className="inputTextContainerFalse";}				else{document.getElementById("cwf_project_pi_l").className="control-label";				document.getElementById("cwf_project_pi").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_project_description").value=="") 			{	check = false; document.getElementById("cwf_project_description_l").className="labelFalse";		document.getElementById("cwf_project_description").className="inputTextContainerFalse";}	else{document.getElementById("cwf_project_description_l").className="control-label";	document.getElementById("cwf_project_description").className="field lfr-input-text-container";}
	
	if (document.getElementById("cwf_ro_name").value=="") 						{	check = false; document.getElementById("cwf_ro_name_l").className="labelFalse";					document.getElementById("cwf_ro_name").className="inputTextContainerFalse";}				else{document.getElementById("cwf_ro_name_l").className="control-label";				document.getElementById("cwf_ro_name").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_ro_label").value=="") 						{	check = false; document.getElementById("cwf_ro_label_l").className="labelFalse";				document.getElementById("cwf_ro_label").className="inputTextContainerFalse";}				else{document.getElementById("cwf_ro_label_l").className="control-label";				document.getElementById("cwf_ro_label").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_ro_author").value=="") 					{	check = false; document.getElementById("cwf_ro_author_l").className="labelFalse";				document.getElementById("cwf_ro_author").className="inputTextContainerFalse";}				else{document.getElementById("cwf_ro_author_l").className="control-label";				document.getElementById("cwf_ro_author").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_ro_dct").value=="") 						{	check = false; document.getElementById("cwf_ro_dct_l").className="labelFalse";					document.getElementById("cwf_ro_dct").className="inputTextContainerFalse";}					else{document.getElementById("cwf_ro_dct_l").className="control-label";					document.getElementById("cwf_ro_dct").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_ro_description").value=="") 				{	check = false; document.getElementById("cwf_ro_description_l").className="labelFalse";			document.getElementById("cwf_ro_description").className="inputTextContainerFalse";}			else{document.getElementById("cwf_ro_description_l").className="control-label";			document.getElementById("cwf_ro_description").className="field lfr-input-text-container";}
	if (document.getElementById("cwf_ro_metadatalabel").value=="none") 			{	check = false; document.getElementById("cwf_ro_metadatalabel_l").className="labelFalse";		document.getElementById("cwf_ro_metadatalabel").className="inputTextContainerFalse";}		else{document.getElementById("cwf_ro_metadatalabel_l").className="control-label";		document.getElementById("cwf_ro_metadatalabel").className="field lfr-input-text-container";}
	
	if (!(document.getElementById("cwf_ro_nagoyayes").checked==false) &&
		!(document.getElementById("cwf_ro_nagoyano").checked==false) ) 		{	check = false; 
		
																					document.getElementById("cwf_ro_nagoya_l").className="labelFalse";
																					document.getElementById("cwf_ro_nagoyayes").className="labelFalse";
																					document.getElementById("cwf_ro_nagoyano").className="labelFalse";
																				}else{
																					document.getElementById("cwf_ro_nagoya_l").className="control-label";
																					document.getElementById("cwf_ro_nagoyayes").className="control-label";
																					document.getElementById("cwf_ro_nagoyano").className="control-label";
																				}
	//if (document.getElementById("cwf_ro_license").value=="none") 				{	check = false; document.getElementById("cwf_ro_license_l").className="rowLatofalse";			document.getElementById("cwf_ro_license").className="inputTextContainerFalse";}				else{document.getElementById("cwf_ro_license_l").className="field lfr-input-text-container";}

	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Please fill the empty fields.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Checking complete</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	console.log(check);
	return check;
}


//
function checkMinimalInput(){
	var check = true;
	check = checkMinimalProjectInput();
	check = checkMinimalResearchObjectInput();
	
	return check;
}


//
function checkMinimalProjectInput(){
	var check = true;
	if (document.getElementById("cwf_project_name").value=="" && document.getElementById("cwf_project_label").value==""){
		check = false; 
		document.getElementById("cwf_project_label_l").className="labelFalse";
		document.getElementById("cwf_project_name_l").className="labelFalse";
	}else{
		document.getElementById("cwf_project_label_l").className="control-label";
		document.getElementById("cwf_project_name_l").className="control-label";
	}
	
	if (document.getElementById("cwf_project_description").value=="") {
		check = false; document.getElementById("cwf_project_description_l").className="labelFalse";
	}else{
		document.getElementById("cwf_project_description_l").className="control-label";
	}

	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Please fill the empty fields.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Checking complete</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	return check;
}


//
function checkMinimalResearchObjectInput(){

	var check = true;
	if (document.getElementById("cwf_ro_name").value=="" && document.getElementById("cwf_ro_label").value==""){
		check = false; 
		document.getElementById("cwf_ro_label_l").className="labelFalse";
		document.getElementById("cwf_ro_name_l").className="labelFalse";
	}else{
		document.getElementById("cwf_ro_label_l").className="control-label";
		document.getElementById("cwf_ro_name_l").className="control-label";
	}
	
	if (document.getElementById("cwf_ro_metadatalabel").value=="none") 			{	check = false; document.getElementById("cwf_ro_metadatalabel_l").className="labelFalse";}		else{document.getElementById("cwf_ro_metadatalabel_l").className="control-label";}
	
	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Please fill the empty fields.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Checking complete</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}

	return check;
}


//
function saveProjectInput(){
	
	var projectJson = {};
	if (document.getElementById("cwf_project_id").innerHTML==0){
		if (checkMinimalProjectInput())
			projectJson = createCwfProject();
	}else{
		if (checkMinimalProjectInput())
			projectJson = updateCwfProject();
	}
	
	if (projectJson.projectid > 0){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Data were stored.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	return projectJson;
}


//
function saveResearchObjectInput(projectJson){
	
	if (document.getElementById("cwf_ro_id").innerHTML==0){
		if (checkMinimalResearchObjectInput())
			researchObjectJson = createCwfResearchObject(projectJson);
	}else{
		if (checkMinimalResearchObjectInput())
			researchObjectJson = updateCwfResearchObject(projectJson);
	}
	
	projectJson["researchobjects"]= researchObjectJson;
	
	if (researchObjectJson.researchobjectid >0){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-success'>Data were stored.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	
	return projectJson;
}


//
function submitInput(url){
	
	console.log("start submission");
	
	if (checkInput()){
		
		console.log("now start submission");
		
		
		var mrrJson = saveAllInput();
		console.log(mrrJson);
		var registryJson = buildSubmissionJsonForRegistry(mrrJson.researchobjects);
		
		console.log(registryJson);
		
		//startSubmissionRegistry(registryJson);
		
		if(document.getElementById("cwf_lf_submissioncomentarField").className != 'portlet-msg-error'){
			console.log('yes');
			var data ={};
			data["mrr"]= mrrJson;
			data["submissionregistry"]= registryJson;

			startSubmission(data);
		}
	}
}


//
function updateCwfProject(){
	var projectJson = buildProjectJsonForUpdate();
	Liferay.Service('/GFBioProject-portlet.project/update-project',
		{
			requestJson: projectJson
		},
		function(obj) {
			if (obj.projectid >0){
				//bei label aenderung wird noch nicht an das archiving-portlet geschickt
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				
				if (document.getElementById("cwf_project_name").value =="")
					document.getElementById("cwf_project_name").value = document.getElementById("cwf_project_label").value;
				if (document.getElementById("cwf_project_label").value=="")
					document.getElementById("cwf_project_label").value = document.getElementById("cwf_project_name").value;
				
				commentarField.empty();
				commentarField.append("<div class='portlet-success'>Data were stored.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}
		}
	);
	return projectJson;
}


//
function updateCwfResearchObject(projectJson){
	
	var researchObjectJson = buildResearchObjectJsonForUpdate(projectJson);
	Liferay.Service('/GFBioProject-portlet.researchobject/update-research-object',
		{
			requestJson: '['.concat(JSON.stringify(researchObjectJson)).concat(']')
		},
		function(obj) {
			var json = obj[0];
			if (json.researchobjectid >0){
				document.getElementById("cwf_ro_version").innerHTML= json.researchobjectversion;
				
				if (document.getElementById("cwf_ro_name").value =="")
					document.getElementById("cwf_ro_name").value = document.getElementById("cwf_ro_label").value;
				if (document.getElementById("cwf_ro_label").value=="")
					document.getElementById("cwf_ro_label").value = document.getElementById("cwf_ro_name").value;
				
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-success'>Data were stored.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-msg-error'>Failed to save the data.</div>");
				setTimeout(function(){commentarField.empty();}, 5000);
			}
		}
	);
	return researchObjectJson;
}

