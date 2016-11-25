<script>


/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////


 	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#environmental");
			
			if (data.projectid==0){
				if (data.researchobjectid==0){
					fillDefaultInformations(data, div);
				}else{
					if (document.getElementById("ewf_ro_id").innerHTML!= 0)
						fillDefaultResearchObjectInformations(data, div);
					fillResearchObjectInformations(data, div);
				}
			}else{
				if (data.researchobjectid==0){
					if (document.getElementById("ewf_project_id").innerHTML!= 0)
						fillDefaultInformations(data, div);
					fillProjectInformations(data, div);
					fillDefaultResearchObjectInformations(data, div);
				}else{
					if (document.getElementById("ewf_ro_id").innerHTML!= 0)
						fillDefaultResearchObjectInformations(data, div);
					fillResearchObjectInformations(data, div);
				}
			}
		});
	});	
	
	
	//fire to update information to generally worflow portlet
	function sentWorkflowUpdate(project, projectId, projectLabel, researchObject) {
		var toUpdate = {
			"updateproject" : project,
			"projectid" : projectId,
			"projectlabel" : projectLabel,
			"updateresearchobject"   : researchObject,
		};
		Liferay.fire('gadget:gfbio.archiving.update', toUpdate);
	} 
	
	
	/////////////////////////////////////////   build funtions  //////////////////////////////////////////////

	
	//build default environmental workflow without project or researchobject data
	AUI().ready(function(A){
		var div =   $("#environmental");
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildEnvironmentalForm(data, div);
		fillDefaultInformations(data, div);
	});	
	
	
	
	//
	function buildEnvironmentalForm(data, div){
		
		if (data.userid != 0){

			div.append(
				"<h2>Environmental Submission Workflow</h2>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 					id='ewf_project_id_l'> Project id </label>"+
						"<div class='field lfr-input-text-container' 	id='ewf_project_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='swHide'>"+
 					"<div class='control-group'>"+
						"<div class='control-label' > Submitter id </div>"+
						"<div class='field lfr-input-text-container' id='ewf_user_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label'> Submitter mail </label>"+
						"<div class='field lfr-input-text-container' id='ewf_user_mail' ></div>"+
					"</div>"+ 
				"</div>"+

				"<h3>Dataset Information</h3>"+

				"</br>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label'					id='ewf_ro_id'_l>Dataset id </label>"+
						"<div	class='field lfr-input-text-container'	id='ewf_ro_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 				   	id='ewf_ro_name_l'>Title </label>"+
					"<input	class='field lfr-input-text-container'	id='ewf_ro_name' type='text'  value=''>"+
				"</div >"+
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 				   	id='ewf_ro_version_l'>Version </label>"+
						"<div	class='field lfr-input-text-container'	id='ewf_ro_version'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label	class='control-label' 					id='ewf_ro_description_l'> Description </label>"+
					"<input	class='field lfr-input-text-container'	id='ewf_ro_description' type='text' value='' >"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='ewf_ro_author_l'> Authors </label>"+
					"<input class='field lfr-input-text-container' 	id='ewf_ro_author' 	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group' >"+
					"<label class='control-label' 					id='ewf_ro_license_l'> License   </label>"+
					"<div 	class='field lfr-input-text-container' 	id='ewf_ro_license_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='ewf_ro_licenselabel' name='<portlet:namespace/>ewf_ro_licenselabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='ewf_ro_publications_l'> Related publications </label>"+
					"<input class='field lfr-input-text-container'	id='ewf_ro_publications' type='text'  value=''>"+
				"</div>"+

				"</br>"+
				"<div class='row' id='ewf_lf_comentarField'></div></br>"+
				"<div class='row' id='ewf_lf_submissioncomentarField'></div>"+
				
				"<div class='row'>"+
					//"<span class='widthM' id='ewf_b_save' onclick='saveAllInput()'>		<span class='btn btn-primary'>Save dataset information</span></span>"+
					"<span class='widthM' id='ewf_b_validate' onclick='checkInput()'>	<span class='btn btn-primary'>Checking for completeness</span></span>"+
					"<span class='widthM' id='ewf_b_start' onclick='submitInput()'>		<span class='btn btn-primary'>Start submission</span></span>"+
				"</div>"					
				
			);
		}
	}
	
	
	//default fill function of environmental submission workflow
	function fillDefaultInformations(data, div){
		fillDefaultProjectInformations(data, div);
		fillDefaultSubmitterInformations(data, div);
		fillDefaultResearchObjectInformations(data, div);
	}
	
	
	
	//default fill function of environmental submission workflow
	function fillDefaultProjectInformations(data, div){

		document.getElementById("ewf_project_id").innerHTML= 0;
	}
	
	
	//
	function fillDefaultResearchObjectInformations(data, div){
	
		var url = document.getElementById('workflowenvironmentalurl').value;
	
		document.getElementById("ewf_ro_id").innerHTML= 0;
		document.getElementById("ewf_ro_version").innerHTML= 1;
		document.getElementById("ewf_ro_name").value= "";
		
		var ajaxData = {"userid":data.userid};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowEnvironmentalPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getuserbyid"
			},
			async: false,
 			success :  function (obj){
				document.getElementById("ewf_ro_author").value= obj.fullname.concat(",");
 			}
 		});
 		
 		document.getElementById("ewf_ro_description").value= "";
 		document.getElementById("ewf_ro_publications").value= "";
		
		
		ajaxData = {"tablename":"gfbio_license"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowEnvironmentalPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){

 				var divLi = $("#".concat('ewf_ro_licenselabel'));
				divLi.empty();
				divLi.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					if (json.label == "CC BY")
						divLi.append("<option id='ewf_ro_licenses"+json.id+"' value='"+json.id+"' selected=true>"+json.name+"</option>");
					else	
						divLi.append("<option id='ewf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
				}
 			}
 		});
	}

	
	//
	function fillDefaultSubmitterInformations(data, div){
		
		var url = document.getElementById('workflowenvironmentalurl').value;
		var ajaxData = {"userid":data.userid};
		
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getuserbyid"
			},
			async: false,
 			success :  function (obj){
				document.getElementById("ewf_user_id").innerHTML= obj.userid;
				document.getElementById("ewf_user_mail").innerHTML= obj.emailaddress;
 			}
 		});
	}
	
	
	//default fill function of environmental submission workflow
	function fillProjectInformations(data, div){
		if (Number(data.projectid)!=0)
			document.getElementById("ewf_project_id").innerHTML= data.projectid;
	}
	
	
	//
	function fillResearchObjectInformations(data, div){

		var url = document.getElementById('workflowenvironmentalurl').value;
		if (Number(data.researchobjectid)!=0){
			var ajaxData = [{"researchobjectid":Number(data.researchobjectid)}];
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowEnvironmentalPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getresearchobjectbyid"
				},
				async: false,
	 			success :  function (obj){
	 				
					var json = obj[0];
					var ed = json.extendeddata;
					for (i=0;i<ed.length/2;i++)
						ed = ed.replace("'",'"');
					var extendeddata = JSON.parse(ed);
					
					document.getElementById("ewf_ro_id").innerHTML= json.researchobjectid;
					document.getElementById("ewf_ro_version").innerHTML= json.researchobjectversion;
					document.getElementById("ewf_ro_name").value= json.name;
					document.getElementById("ewf_ro_label").value= json.label;
					
					if (extendeddata.datacollectiontime !=null)
						document.getElementById("ewf_ro_dct").value= extendeddata.datacollectiontime;
					else
						document.getElementById("ewf_ro_dct").value= "";
					
					document.getElementById("ewf_ro_description").value= json.description;

					if (json.authorname != null){
						var author = (json.authorname).substring(1, (json.authorname.length)-1);
						for (i=0;i<author.length/2;i++)
							author = author.replace('"','');
						document.getElementById("ewf_ro_author").value= author;
					}else{
						document.getElementById("ewf_ro_author").value= "";
					}
					
					if (extendeddata.publications !=null)
						document.getElementById("ewf_ro_publications").value= extendeddata.publications;
					else
						document.getElementById("ewf_ro_publications").value= "";
					
					if (json.hasOwnProperty('licenseid')) {
						var licenseJson = JSON.parse(json.licenseid);
						for (i=0;i<licenseJson.length;i++)
							document.getElementById("ewf_ro_licenses"+licenseJson[i]).checked= "checked";
					}

	 			}
	 		});
		}
		
		
	}
	
	
	//
	function createEwfResearchObject(projectJson){

		var researchObjectJson = buildResearchObjectJsonForCreate(projectJson);
		var url = document.getElementById('workflowenvironmentalurl').value;

		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowEnvironmentalPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(researchObjectJson),
				"<portlet:namespace />responseTarget" : "createresearchobject"
			},
			async: false,
			success :  function (obj){
				if (obj.researchobjectid >0){
					document.getElementById("ewf_ro_id").innerHTML= obj.researchobjectid;
					document.getElementById("ewf_ro_version").innerHTML= obj.researchobjectversion;
					
					if (document.getElementById("ewf_ro_name").value =="")
						document.getElementById("ewf_ro_name").value = document.getElementById("ewf_ro_label").value;

					if (projectJson.projectid!=0)
						researchObjectJson["projectid"]=Number(projectJson.projectid);
					researchObjectJson["researchobjectid"]=Number(obj.researchobjectid);
					researchObjectJson["researchobjectversion"]=Number(obj.researchobjectversion);
				}
			}
		});
		return researchObjectJson;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	//
	function startSubmission(data){
			
		var url = document.getElementById('workflowenvironmentalurl').value;
		
		data["path"]= document.getElementById("ewf_user_path").innerHTML;

		console.log(data);
		
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowEnvironmentalPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "startsubmission"
			},
			async: false,
			success :  function (obj){
				var commentarField = $("#".concat('ewf_lf_submissioncomentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-success'>The Submission information has been sent to the data curators of collections. One of them will be contact you shortly. </div>");
				setTimeout(function(){commentarField.empty();}, 25000);
			},
			error :  function (obj){
				var commentarField = $("#".concat('cwf_lf_submissioncomentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-msg-error'>The Submission information transfer is failed. Please contact our technical support.</div>");
				setTimeout(function(){commentarField.empty();}, 25000);

			},		
		});	
	}
	
	
	


</script>