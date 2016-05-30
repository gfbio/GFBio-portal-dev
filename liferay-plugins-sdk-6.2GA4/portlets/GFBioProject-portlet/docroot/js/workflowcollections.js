

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
function saveProjectInput(){
	
	var projectJson = {};
	if (document.getElementById("cwf_project_id").innerHTML==0){
		if (checkMinimalProjectInput())
			projectJson = createCwfProject();
	}else{
		if (checkMinimalProjectInput())
			projectJson = updateCwfProject();
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
function submitInput(){
	
	if (checkInput()){
		var mrrJson = saveAllInput();

		var researchObjectoJson = mrrJson.researchobjects;
		//submissionregistryKontakt

		var registryJson = buildSubmissionJsonForRegistry(researchObjectoJson);

		Liferay.Service('/GFBioProject-portlet.submission/create-submission',
			{
				requestJson: '['.concat(JSON.stringify(registryJson)).concat(']')
			},
			function(obj) {
				//sendMail(obj);
			}
		);
		
	}else{
		console.log("=(");
	}
}


//
function sendMail(obj) {
	var uri='//helpdesk.gfbio.org/rest/api/6/issue/';

	var submitData = {
		    "fields": {
		        "project":
		        { 
		           "key": "TEST"
		        },
		        "summary": "REST ye merry gentlemen.",
		        "description": "Creating of an issue using project keys and issue type names using the REST API",
		        "issuetype": {
		           "name": "Bug"
		        }
		    }
		 };

	
/*																					//http://host:port/context/rest/api-name/api-version/resource-name
	curl -u admin:admin -X POST --data submitData -H "Content-Type: application/json" http:uri 
	*/
	

/*	$.ajax({
		  type: "POST",
		  url: url,
		  data: data,
		  success: success,
		  dataType: dataType
		});*/

}


//
function checkInput(){
	var check = true;
	if (document.getElementById("cwf_project_name").value=="") 					{	check = false; document.getElementById("cwf_project_name_l").className="rowLatofalse";}			else{document.getElementById("cwf_project_name_l").className="rowLato";}
	if (document.getElementById("cwf_project_label").value=="") 				{	check = false; document.getElementById("cwf_project_label_l").className="rowLatofalse";}		else{document.getElementById("cwf_project_label_l").className="rowLato";}
	if (document.getElementById("cwf_project_pi").value=="") 					{	check = false; document.getElementById("cwf_project_pi_l").className="rowLatofalse";}			else{document.getElementById("cwf_project_pi_l").className="rowLato";}
	if (document.getElementById("cwf_project_description").value=="") 			{	check = false; document.getElementById("cwf_project_description_l").className="rowLatofalse";}	else{document.getElementById("cwf_project_description_l").className="rowLato";}
	
	if (document.getElementById("cwf_ro_name").value=="") 						{	check = false; document.getElementById("cwf_ro_name_l").className="rowLatofalse";}				else{document.getElementById("cwf_ro_name_l").className="rowLato";}
	if (document.getElementById("cwf_ro_label").value=="") 						{	check = false; document.getElementById("cwf_ro_label_l").className="rowLatofalse";}				else{document.getElementById("cwf_ro_label_l").className="rowLato";}
	if (document.getElementById("cwf_ro_author").value=="") 					{	check = false; document.getElementById("cwf_ro_author_l").className="rowLatofalse";}			else{document.getElementById("cwf_ro_author_l").className="rowLato";}
	if (document.getElementById("cwf_ro_dct").value=="") 						{	check = false; document.getElementById("cwf_ro_dct_l").className="rowLatofalse";}				else{document.getElementById("cwf_ro_dct_l").className="rowLato";}
	if (document.getElementById("cwf_ro_description").value=="") 				{	check = false; document.getElementById("cwf_ro_description_l").className="rowLatofalse";}		else{document.getElementById("cwf_ro_description_l").className="rowLato";}
	if (document.getElementById("cwf_ro_metadatalabel").value=="none") 			{	check = false; document.getElementById("cwf_ro_metadatalabel_l").className="rowLatofalse";}		else{document.getElementById("cwf_ro_metadatalabel_l").className="rowLato";}
	
	if (!(document.getElementById("cwf_ro_nagojayes").checked=="checked") &&
		!(document.getElementById("cwf_ro_nagojano").checked=="checked") &&
		  document.getElementById("cwf_ro_nagojadiv").value=="") 				{	check = false; document.getElementById("cwf_ro_nagoja_l").className="rowLatofalse";}			else{document.getElementById("cwf_ro_nagoja_l").className="rowLato";}
	//if (document.getElementById("cwf_ro_license").value=="none") 				{	check = false; document.getElementById("cwf_ro_license_l").className="rowLatofalse";}			else{document.getElementById("cwf_ro_license_l").className="rowLato";}

	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Please fill the empty / red fields.");
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Checking complete");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
		
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
		document.getElementById("cwf_project_label_l").className="rowLatofalse";
		document.getElementById("cwf_project_name_l").className="rowLatofalse";
	}else{
		document.getElementById("cwf_project_label_l").className="rowLato";
		document.getElementById("cwf_project_name_l").className="rowLato";
	}
	
	if (document.getElementById("cwf_project_description").value=="") 			{	check = false; document.getElementById("cwf_project_description_l").className="rowLatofalse";}	else{document.getElementById("cwf_project_description_l").className="rowLato";}

	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Please fill the empty / red fields.");
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Checking complete");
		setTimeout(function(){commentarField.empty();}, 5000);
	}
	return check;
}


//
function checkMinimalResearchObjectInput(){

	var check = true;
	if (document.getElementById("cwf_ro_name").value=="" && document.getElementById("cwf_ro_label").value==""){
		check = false; 
		document.getElementById("cwf_ro_label_l").className="rowLatofalse";
		document.getElementById("cwf_ro_name_l").className="rowLatofalse";
	}else{
		document.getElementById("cwf_ro_label_l").className="rowLato";
		document.getElementById("cwf_ro_name_l").className="rowLato";
	}
	
	if (document.getElementById("cwf_ro_metadatalabel").value=="none") 			{	check = false; document.getElementById("cwf_ro_metadatalabel_l").className="rowLatofalse";}		else{document.getElementById("cwf_ro_metadatalabel_l").className="rowLato";}
	
	if (!check){
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Please fill the empty / red fields.");
	}else{
		var commentarField = $("#".concat('cwf_lf_comentarField'));
		commentarField.empty();
		commentarField.append("Checking complete");
		setTimeout(function(){commentarField.empty();}, 5000);
	}

	return check;
}


//save


function createCwfResearchObject(projectJson){

	var researchObjectJson = buildResearchObjectJsonForCreate(projectJson);
	Liferay.Service('/GFBioProject-portlet.researchobject/create-research-object',
		{
			requestJson: '['.concat(JSON.stringify(researchObjectJson)).concat(']')
		},
		function(obj) {
			var json = obj[0];
			if (json.researchobjectid >0){
				document.getElementById("cwf_ro_id").innerHTML= json.researchobjectid;
				document.getElementById("cwf_ro_version").innerHTML= json.researchobjectversion;
				
				if (document.getElementById("cwf_ro_name").value =="")
					document.getElementById("cwf_ro_name").value = document.getElementById("cwf_ro_label").value;
				if (document.getElementById("cwf_ro_label").value=="")
					document.getElementById("cwf_ro_label").value = document.getElementById("cwf_ro_name").value;
				
				researchObjectJson["researchobjectid"]=json.researchobjectid;
				researchObjectJson["researchobjectversion"]=json.researchobjectversion;

				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Data were stored.");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Failed to save the data.");
			}
		}
	);
	return researchObjectJson;
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
				commentarField.append("Data were stored.");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Failed to save the data.");
			}
		}
	);
	return researchObjectJson;
}


//
function createCwfProject(){
	var projectJson = buildProjectJsonForCreate();
	Liferay.Service('/GFBioProject-portlet.project/create-project',
		{
			requestJson: projectJson
		},
		function(obj) {
			if (obj.projectid >0){
				sentWorkflowUpdate(true, obj.projectid, projectJson.label, false);
				document.getElementById("cwf_project_id").innerHTML= obj.projectid;
				
				if (document.getElementById("cwf_project_name").value =="")
					document.getElementById("cwf_project_name").value = document.getElementById("cwf_project_label").value;
				if (document.getElementById("cwf_project_label").value=="")
					document.getElementById("cwf_project_label").value = document.getElementById("cwf_project_name").value;
				
				projectJson["projectid"]=obj.projectid;
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Data were stored.");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Failed to save the data.");
			}
		}
	);
	return projectJson;
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
				commentarField.append("Data were stored.");
				setTimeout(function(){commentarField.empty();}, 5000);
			}else{
				var commentarField = $("#".concat('cwf_lf_comentarField'));
				commentarField.empty();
				commentarField.append("Failed to save the data.");
			}
		}
	);
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

	var extendetdata ={
		"pi": document.getElementById("cwf_project_pi").value//need a solution	
	}

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
function buildResearchObjectJsonForUpdate(projectJson){

	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["researchobjectid"]= Number(document.getElementById("cwf_ro_id").innerHTML);
	researchObjectJson["researchobjectversion"]= Number(document.getElementById("cwf_ro_version").innerHTML);

	return researchObjectJson;
}


//
function buildResearchObjectJsonForCreate(projectJson){
	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["metadataid"]= Number(document.getElementById("cwf_ro_metadatalabel").value);
	return researchObjectJson;
}


//
function buildCommonResearchObjectJson(projectJson){
	var roName = document.getElementById("cwf_ro_name").value;
	var roLabel = document.getElementById("cwf_ro_label").value;

	if (roName =="")	roName = roLabel;
	if (roLabel=="")	roLabel = roName;
	
	var nagoja ="";
	if (document.getElementById("cwf_ro_nagojano").checked)		nagoja = 'no';
	else														nagoja = document.getElementById("cwf_ro_nagojadetails").value;

	var authornames = (document.getElementById("cwf_ro_author").value).trim();
	if (authornames.charAt(authornames.length-1)==',')
		authornames = authornames.substring(0, authornames.length-1);
	authornames = ('["'.concat(authornames).concat('"]')).replace(/,/g,'","');

	var extendetdata = {
		"publications":document.getElementById("cwf_ro_publications").value,
		"datacollectiontime":document.getElementById("cwf_ro_dct").value,
		"nagoja": nagoja
	}

	var researchObjectJson = {
		"authornames": authornames,
		"name":roName,
		"label":roLabel,
		"description":document.getElementById("cwf_ro_description").value,
		"extendeddata": extendetdata,
		"projectid": projectJson.projectid
	};

	var licenseJson =[];
	for (i =0; i<document.getElementsByName("licenses").length;i++)
		if (document.getElementsByName("licenses")[i].checked)
			licenseJson.push(document.getElementsByName("licenses")[i].value);
	
	if (!(licenseJson.toString()==""))
		researchObjectJson["licenseids"] = licenseJson.toString();
	return researchObjectJson;
}