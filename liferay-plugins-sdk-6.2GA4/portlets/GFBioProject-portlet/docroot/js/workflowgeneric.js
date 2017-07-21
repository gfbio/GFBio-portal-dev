


//
function buildCommonResearchObjectJson(projectJson){
	var roName = document.getElementById("gwf_ro_name").value;
	var roLabel = document.getElementById("gwf_ro_label").value;

	if (roName =="")	roName = roLabel;
	if (roLabel=="")	roLabel = roName;

	//authornames
	var authornames = (document.getElementById("gwf_ro_author").value).trim();
	
	if (authornames.charAt(authornames.length-1)==',')
		authornames = authornames.substring(0, authornames.length-1);
	authornames = ('["'.concat(authornames).concat('"]')).replace(/\n/g,'","');

	var authorNamesArray = JSON.parse(authornames);
	
	for (i =0; i < authorNamesArray.length;i++){
		var name = authorNamesArray[i];
		while (name.charAt(name.length-1)==',')
			name = name.substring(0, name.length-1);
		authorNamesArray[i] = name;
	}
	authornames = JSON.stringify(authorNamesArray);

	
	//legalrequirements
	var legalrequirements =[];
	for (i =0; i<document.getElementsByName("legalrequirements").length;i++)
		if (document.getElementsByName("legalrequirements")[i].checked)
			legalrequirements.push(document.getElementsByName("legalrequirements")[i].value);
		
	
	var category =[];
	for (i =0; i<document.getElementsByName("categories").length;i++)
		if (document.getElementsByName("categories")[i].checked)
			category.push(document.getElementsByName("categories")[i].value);

	
	var extendetdata = {
		"publications":document.getElementById("gwf_ro_publications").value,
		"datacollectiontime":document.getElementById("gwf_ro_dct").value,
		"embargo":document.getElementById("gwf_ro_embargo").value,
		"legalrequirements":legalrequirements,
	}

	var researchObjectJson = {
		"authornames": authornames,
		"name":roName,
		"label":roLabel,
		"description":document.getElementById("gwf_ro_description").value,
		"extendeddata": extendetdata,
		"categoryids":category,
	};

	if (projectJson.projectid!=0)
		researchObjectJson["projectid"]= projectJson.projectid;
		
	researchObjectJson["userid"]=Number(document.getElementById("gwf_user_id").innerHTML);

	return researchObjectJson;
}


//
function buildResearchObjectJsonForCreate(projectJson){
	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	
	if (document.getElementById("gwf_ro_metadatalabel").value != 'none')
		researchObjectJson["metadataid"]= Number(document.getElementById("gwf_ro_metadatalabel").value);
	
	researchObjectJson["licenseid"] = Number(document.getElementById("gwf_ro_licenselabel").value);
	researchObjectJson["researchobjecttype"]= document.getElementById("gwf_ro_researchobjecttype").innerHTML;
	return researchObjectJson;
}


//
function buildResearchObjectJsonForUpdate(projectJson){

	var researchObjectJson = buildCommonResearchObjectJson(projectJson);
	researchObjectJson["researchobjectid"]= Number(document.getElementById("gwf_ro_id").innerHTML);
	researchObjectJson["researchobjectversion"]= Number(document.getElementById("gwf_ro_version").innerHTML);
	if (document.getElementById("gwf_ro_metadatalabel").value != 'none')
		researchObjectJson["metadataid"]= Number(document.getElementById("gwf_ro_metadatalabel").value);
	return researchObjectJson;
}


//
function buildSubmissionJsonForRegistry(researchObjectJson){
	var registryJson = {};
	registryJson["researchobjectid"]= researchObjectJson.researchobjectid;
	registryJson["researchobjectversion"]= researchObjectJson.researchobjectversion;
	registryJson["archive"] = "GFBio collections";
	//registryJson["brokersubmissionid"] ="";
	registryJson["userid"]=  Number(document.getElementById("gwf_user_id").innerHTML);
	return registryJson;
}


//
function checkEmbargoDate(date){
	return /^2\d{3}-[01]\d-[0123]\d$/.test(date);
}


//
function checkInput(){
	var check = true;
	check = checkMinimalInput();
	
	if (!check)
		buildErrorMessage('gwf_lf_comentarField',"Please correct or fill the marked fields." );
	else
		buildWaitringMessage('gwf_lf_comentarField');

	return check;
}


//
function checkMinimalInput(){
	var check = true;
	check = checkMinimalResearchObjectInput();
	return check;
}


function checkInputLength(){
	
	check = true;
	failList = [];
	failListLength =0;
	
	console.log(check);
	
	if ((document.getElementById("gwf_ro_name").value).length > 200){
		check = false;
		failList.push(" title");
		document.getElementById("gwf_ro_name_l").className="labelFalse";
		document.getElementById("gwf_ro_name_d").className="labelFalse";
	    document.getElementById("gwf_ro_name").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_name_l").className="control-label";
		document.getElementById("gwf_ro_name_d").className="field-description";
		document.getElementById("gwf_ro_name").className="field lfr-input-text-container";
	}
	
	
	if ((document.getElementById("gwf_ro_dct").value).length > 2200){
		check = false;
		failList.push(" data collection time");
		document.getElementById("gwf_ro_dct_l").className="labelFalse";
		document.getElementById("gwf_ro_dct_d").className="labelFalse";
	    document.getElementById("gwf_ro_dct").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_dct_l").className="control-label";
		document.getElementById("gwf_ro_dct_d").className="field-description";
		document.getElementById("gwf_ro_dct").className="field lfr-input-text-container";
	}
	
	
	if ((document.getElementById("gwf_ro_label").value).length > 200){
		check = false;
		failList.push(" dataset label");
		document.getElementById("gwf_ro_label_l").className="labelFalse";
		document.getElementById("gwf_ro_label_d").className="labelFalse";
	    document.getElementById("gwf_ro_label").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_label_l").className="control-label";
		document.getElementById("gwf_ro_label_d").className="field-description";
		document.getElementById("gwf_ro_label").className="field lfr-input-text-container";
	}

	console.log(check);
	
	if (!check)
		buildErrorMessage('gwf_lf_comentarField',"Please reduce the length of"+failList +" under 200 characters." );
	else
		buildWaitringMessage('gwf_lf_comentarField');
	
	return check;
}


//
function checkMinimalResearchObjectInput(){

	
	var check = true;
	
	//title
	if (document.getElementById("gwf_ro_name").value==""){
		check = false;
		document.getElementById("gwf_ro_name_l").className="labelFalse";
		document.getElementById("gwf_ro_name_d").className="labelFalse";
	    document.getElementById("gwf_ro_name").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_name_l").className="control-label";
		document.getElementById("gwf_ro_name_d").className="field-description";
		document.getElementById("gwf_ro_name").className="field lfr-input-text-container"; //field lfr-input-text error-field
	}
	
	//description
	var description = document.getElementById("gwf_ro_description").value;
	if (description=="" || description.length > 15000){
		check = false;
		document.getElementById("gwf_ro_description_l").className="labelFalse";
		document.getElementById("gwf_ro_description_d").className="labelFalse";
		document.getElementById("gwf_ro_description").style='border-color:darkred !important';
	}else{
		document.getElementById("gwf_ro_description_l").className="control-label";
		document.getElementById("gwf_ro_description_d").className="field-description";
		document.getElementById("gwf_ro_description").style='';
	}
	

	//author
	if (document.getElementById("gwf_ro_author").value==""){
		check = false;
		document.getElementById("gwf_ro_author_l").className="labelFalse";
		document.getElementById("gwf_ro_author_d").className="labelFalse";
		document.getElementById("gwf_ro_author").style='border-color:darkred !important';
	}else{
		document.getElementById("gwf_ro_author_l").className="control-label";
		document.getElementById("gwf_ro_author_d").className="field-description";
		document.getElementById("gwf_ro_author").style='';
	}

	
	//license
	if (document.getElementById("gwf_ro_licenselabel").value=="none") 			{
		check = false; 
		document.getElementById("gwf_ro_license_l").className="labelFalse";
		document.getElementById("gwf_ro_license_d").className="labelFalse";
		document.getElementById("gwf_ro_licenselabel").style='width:100%; border-color:darkred !important';
	}else{
		document.getElementById("gwf_ro_license_l").className="control-label";
		document.getElementById("gwf_ro_license_d").className="field-description";
		document.getElementById("gwf_ro_licenselabel").style='width:100%';
	}
	
	
	if ((document.getElementById("gwf_ro_publications").value).length > 2200){
		check = false;
		document.getElementById("gwf_ro_publications_l").className="labelFalse";
		document.getElementById("gwf_ro_publications_d").className="labelFalse";
	    document.getElementById("gwf_ro_publications").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_publications_l").className="control-label";
		document.getElementById("gwf_ro_publications_d").className="field-description";
		document.getElementById("gwf_ro_publications").className="field lfr-input-text-container";
	}
	
	
	//embargo
	if ((!document.getElementById("gwf_ro_embargo").value=="")){
		var subcheck = checkEmbargoDate((document.getElementById("gwf_ro_embargo").value).trim());
		if (!subcheck){
			document.getElementById("gwf_ro_embargo_l").className="labelFalse";
			document.getElementById("gwf_ro_embargo_d").className="labelFalse";
			document.getElementById("gwf_ro_embargo").style='border-color:darkred !important';
		}else{
			document.getElementById("gwf_ro_embargo_l").className="control-label";
			document.getElementById("gwf_ro_embargo_d").className="field-description";
			document.getElementById("gwf_ro_embargo").style='';
		}
	
		if(!subcheck)
			check = subcheck;
	}
	
	/*
	 * 	if (document.getElementById("gwf_ro_name").value==""){
		check = false;
		document.getElementById("gwf_ro_name_l").className="labelFalse";
		document.getElementById("gwf_ro_name_d").className="labelFalse";
		document.getElementById("gwf_ro_name").className="inputTextContainerFalse";
	}else{
		document.getElementById("gwf_ro_name_l").className="control-label";
		document.getElementById("gwf_ro_name_d").className="field-description";
		document.getElementById("gwf_ro_name").className="field lfr-input-text-container";
	}
	 */
	
	if (!check)
		buildErrorMessage('gwf_lf_comentarField', "Please correct or fill the marked fields.")
	else
		buildWaitringMessage('gwf_lf_comentarField')

	return check;
}


//
function resetInput(){
	sentShowHideInformation(true);
	var div =   $("#generic");
	div.empty();
	var data = {"userid":Number(themeDisplay.getUserId())};
	buildGenericForm(data, div);
	fillDefaultInformations(data, div);
	sentResetRequest();
}


//
function setComentarFieldEmpty(field){
	var commentarField = $("#".concat(field));
	commentarField.empty();
}


//
function saveAllInput(){

	var projectJson = {};
	if (checkMinimalInput()){
		projectJson = saveProjectInput();
		projectJson = saveResearchObjectInput(projectJson);
		projectJson["submittermail"]=document.getElementById("gwf_user_mail").innerHTML;
		
		if (document.getElementById("gwf_dcrtinformation").innerHTML!=null)
			projectJson["dcrtinformation"]=document.getElementById("gwf_dcrtinformation").innerHTML;
		
		
		if (projectJson.researchobjects.researchobjectid >0){
			console.log('Information were stored');
			buildWaitringMessage('gwf_lf_comentarField');
			sentWorkflowUpdate(true, projectJson.projectid, "", projectJson.researchobjects);
		}else{
			buildErrorMessage('gwf_lf_comentarField', "Failed to store the information.");
		}
		
	}
	return projectJson;
}


//
function saveProjectInput(){
	
	var projectJson = {};
	projectJson["projectid"]= document.getElementById("gwf_project_id").innerHTML;
	return projectJson;
}


//
function saveResearchObjectInput(projectJson){
	
	if (document.getElementById("gwf_ro_id").innerHTML==0){
		if (checkMinimalResearchObjectInput())
			researchObjectJson = createGwfResearchObject(projectJson);
	}else
		if (checkMinimalResearchObjectInput())
			researchObjectJson = updateGwfResearchObject(projectJson);
	
	
	projectJson["researchobjects"]= researchObjectJson;
	
	return projectJson;
}


//
function submitInput(url){
	
	if(document.getElementById("gwf_lf_comentar").className != 'portlet-msg-error'){
		
		if (checkInput()){
			
			if (checkInputLength()){
			
				//create research object /project
				var mrrJson = saveAllInput();
				
				//create primary data
				if(document.getElementById("gwf_lf_comentar").className != 'portlet-msg-error'){
					if (Number(document.getElementById("gwf_ro_id").innerHTML)!=0)
						fileUplaod();
				
					//create submission registry
					if(document.getElementById("gwf_lf_comentar").className != 'portlet-msg-error'){
						startSubmissionRegistry(buildSubmissionJsonForRegistry(mrrJson.researchobjects));
						
						//sent to JIRA
						if(document.getElementById("gwf_lf_comentar").className != 'portlet-msg-error'){
							var data ={};
							data["mrr"]= mrrJson;
							startSubmission(data);
							
							//sent to Broker
							//data["submissionregistry"]= registryJson;
							//sentToBroker(data);
						}
					}
				}
			}
		}
	}else
		console.log("submit no");
}


//
function updateGwfResearchObject(projectJson){
	
	var researchObjectJson = buildResearchObjectJsonForUpdate(projectJson);
	Liferay.Service('/GFBioProject-portlet.researchobject/update-research-object',
		{
			requestJson: '['.concat(JSON.stringify(researchObjectJson)).concat(']')
		},
		function(obj) {
			var json = obj[0];
			if (json.researchobjectid >0){
				document.getElementById("gwf_ro_version").innerHTML= json.researchobjectversion;
				
				if (document.getElementById("gwf_ro_name").value =="")
					document.getElementById("gwf_ro_name").value = document.getElementById("gwf_ro_label").value;
				if (document.getElementById("gwf_ro_label").value=="")
					document.getElementById("gwf_ro_label").value = document.getElementById("gwf_ro_name").value;
							
				buildWaitringMessage('gwf_lf_comentarField');
			}else
				buildErrorMessage('gwf_lf_comentarField', "Failed to save the data.");
		}
	);
	return researchObjectJson;
}