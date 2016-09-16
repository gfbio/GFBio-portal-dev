<script>


/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////


 	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#generic");
			
			if (data.projectid==0){
				if (data.researchobjectid==0){
					fillDefaultInformations(data, div);
				}else{
					if (document.getElementById("gwf_ro_id").innerHTML!= 0)
						fillDefaultResearchObjectInformations(data, div);
					fillResearchObjectInformations(data, div);
				}
			}else{
				if (data.researchobjectid==0){
					if (document.getElementById("gwf_project_id").innerHTML!= 0)
						fillDefaultInformations(data, div);
					fillProjectInformations(data, div);
					fillDefaultResearchObjectInformations(data, div);
				}else{
					if (document.getElementById("gwf_ro_id").innerHTML!= 0)
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

	
	//build default generic workflow without project or researchobject data
	AUI().ready(function(A){
		var div =   $("#generic");
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildGenericForm(data, div);
		fillDefaultInformations(data, div);
	});	
	
	
	
	//
	function buildGenericForm(data, div){
		
		if (data.userid != 0){

			div.append(
				"<h2>Generic Submission Workflow</h2>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 					id='gwf_project_id_l'> Project id </label>"+
						"<div class='field lfr-input-text-container' 	id='gwf_project_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='swHide'>"+
 					"<div class='control-group'>"+
						"<div class='control-label' > Submitter id </div>"+
						"<div class='field lfr-input-text-container' id='gwf_user_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label'> Submitter mail </label>"+
						"<div class='field lfr-input-text-container' id='gwf_user_mail' ></div>"+
					"</div>"+ 
				"</div>"+

				"<h3>Dataset Information</h3>"+

				"</br>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label'					id='gwf_ro_id'_l>Dataset id </label>"+
						"<div	class='field lfr-input-text-container'	id='gwf_ro_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 				   	id='gwf_ro_name_l'>Title </label>"+
					"<input	class='field lfr-input-text-container'	id='gwf_ro_name' type='text'  value=''>"+
				"</div >"+
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 				   	id='gwf_ro_version_l'>Version </label>"+
						"<div	class='field lfr-input-text-container'	id='gwf_ro_version'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label	class='control-label' 					id='gwf_ro_description_l'> Description </label>"+
					"<input	class='field lfr-input-text-container'	id='gwf_ro_description' type='text' value='' >"+
				"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' id='gwf_ro_dct_l'	id='gwf_ro_dct_l'> Data collection time </label>"+
					"<input class='field lfr-input-text-container'	id='gwf_ro_dct' 	type='text' value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='gwf_ro_label_l'> Dataset label </label>"+
					"<input class='field lfr-input-text-container'	id='gwf_ro_label'	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='gwf_ro_author_l'> Dataset author </label>"+
					"<input class='field lfr-input-text-container' 	id='gwf_ro_author' 	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_license_l'> Appropriate license   </label>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_license_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_licenselabel' name='<portlet:namespace/>gwf_ro_licenselabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='gwf_ro_publications_l'> Related publications </label>"+
					"<input class='field lfr-input-text-container'	id='gwf_ro_publications' type='text'  value=''>"+
				"</div>"+
				"<div class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_metadatalabel_l'> Metadata shema  </label>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_metadatalabel_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_metadatalabel' name='<portlet:namespace/>gwf_ro_metadatalabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='gwf_ro_embargo_l'> Embargo (example: 'embargo time to yyyy-mm-dd') </label>"+
					"<input class='field lfr-input-text-container' 	id='gwf_ro_embargo' 	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_legalrequirements_l'> Legal requirements  </label>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_legalrequirements_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_legalrequirements' name='<portlet:namespace/>gwf_ro_legalrequirements' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+

				"</br>"+
				"<div class='row' id='gwf_lf_comentarField'></div></br>"+
				"<div class='row' id='gwf_lf_submissioncomentarField'></div>"+
				
				"<div class='row'>"+
					"<span class='widthM' id='gwf_b_save' onclick='saveAllInput()'>		<span class='btn btn-primary'>Save dataset information</span></span>"+
					"<span class='widthM' id='gwf_b_validate' onclick='checkInput()'>	<span class='btn btn-primary'>Checking for completeness</span></span>"+
					"<span class='widthM' id='gwf_b_start' onclick='submitInput()'>		<span class='btn btn-primary'>Start submission</span></span>"+
				"</div>"					
				
			);
		}
	}
	
	
	//default fill function of generic submission workflow
	function fillDefaultInformations(data, div){
		fillDefaultProjectInformations(data, div);
		fillDefaultSubmitterInformations(data, div);
		fillDefaultResearchObjectInformations(data, div);
	}
	
	
	
	//default fill function of generic submission workflow
	function fillDefaultProjectInformations(data, div){

		document.getElementById("gwf_project_id").innerHTML= 0;
	}
	
	
	//
	function fillDefaultResearchObjectInformations(data, div){
	
		var url = document.getElementById('workflowgenericurl').value;
	
		document.getElementById("gwf_ro_id").innerHTML= 0;
		document.getElementById("gwf_ro_version").innerHTML= 1;
		document.getElementById("gwf_ro_name").value= "";
		document.getElementById("gwf_ro_label").value= "";
		
		var ajaxData = {"userid":data.userid};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getuserbyid"
			},
			async: false,
 			success :  function (obj){
				document.getElementById("gwf_ro_author").value= obj.fullname.concat(",");
 			}
 		});
 		
 		document.getElementById("gwf_ro_dct").value= "";
 		document.getElementById("gwf_ro_description").value= "";
 		document.getElementById("gwf_ro_publications").value= "";
 		document.getElementById("gwf_ro_metadatalabel").selectedIndex = 0;
 		
  		var div =   $("#gwf_ro_metadatalabel_v");
		div.empty();
		div.append(
			"<form action='select.html'>"+
				"<select id='gwf_ro_metadatalabel' name='<portlet:namespace/>gwf_ro_metadatalabel' size='1' style='width:90%'>"+
					"<option value='none'></option>"+
				"</select>"+
			"</form>"
		);
		
 		ajaxData = {"tablename":"gfbio_metadata"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){
 				var choMeta = $("#".concat('gwf_ro_metadatalabel'));
				choMeta.empty();
				choMeta.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					choMeta.append("<option id='gwf_ro_metadatalabel"+json.id+"' value='"+json.id+"'>"+json.label+"</option>");
				}
 			}
 		}); 

		
		ajaxData = {"tablename":"gfbio_license"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){

 				var divLi = $("#".concat('gwf_ro_licenselabel'));
				divLi.empty();
				divLi.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					if (json.label == "CC BY")
						divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"' selected=true>"+json.name+"</option>");
					else	
						divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
				}
 			}
 		});
 		
 		var divLi = $("#".concat('gwf_ro_legalrequirements'));
		divLi.empty();
		divLi.append(
			"<option value='none' selected=true></option>"+
			"<option value='Nagoya'>Nagoya</option>"+
			"<option value='Red List'>Red List</option>"+
			"<option value='Personal'>Personal</option>"+
			"<option value='Uncertain'>Uncertain</option>"
		);

	}

	
	//
	function fillDefaultSubmitterInformations(data, div){
		
		var url = document.getElementById('workflowgenericurl').value;
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
 				console.log(obj);
				document.getElementById("gwf_user_id").innerHTML= obj.userid;
				document.getElementById("gwf_user_mail").innerHTML= obj.emailaddress;
 			}
 		});
	}
	
	
	//default fill function of generic submission workflow
	function fillProjectInformations(data, div){
		if (Number(data.projectid)!=0)
			document.getElementById("gwf_project_id").innerHTML= data.projectid;
	}
	
	
	//
	function fillResearchObjectInformations(data, div){

		var url = document.getElementById('workflowgenericurl').value;
		if (Number(data.researchobjectid)!=0){
			var ajaxData = [{"researchobjectid":Number(data.researchobjectid)}];
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowGenericPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getresearchobjectbyid"
				},
				async: false,
	 			success :  function (obj){
	 				
	 				var div =   $("#gwf_ro_metadatalabel_v");
					var json = obj[0];
					var ed = json.extendeddata;
					for (i=0;i<ed.length/2;i++)
						ed = ed.replace("'",'"');
					var extendeddata = JSON.parse(ed);
					
					document.getElementById("gwf_ro_id").innerHTML= json.researchobjectid;
					document.getElementById("gwf_ro_version").innerHTML= json.researchobjectversion;
					document.getElementById("gwf_ro_name").value= json.name;
					document.getElementById("gwf_ro_label").value= json.label;
					
					if (extendeddata.datacollectiontime !=null)
						document.getElementById("gwf_ro_dct").value= extendeddata.datacollectiontime;
					else
						document.getElementById("gwf_ro_dct").value= "";
					
					document.getElementById("gwf_ro_description").value= json.description;
					div.empty();
					div.append(json.metadatalabel+
						"<div class='rowField'><input type='hidden' id='gwf_ro_metadatalabel' value='"+json.metadatalabel+"'></div>"
					);

					if (json.authorname != null){
						var author = (json.authorname).substring(1, (json.authorname.length)-1);
						for (i=0;i<author.length/2;i++)
							author = author.replace('"','');
						document.getElementById("gwf_ro_author").value= author;
					}else{
						document.getElementById("gwf_ro_author").value= "";
					}
					
					
					if (extendeddata.publications !=null)
						document.getElementById("gwf_ro_publications").value= extendeddata.publications;
					else
						document.getElementById("gwf_ro_publications").value= "";
					
					
					if (json.hasOwnProperty('licenseid')) {
						var licenseJson = JSON.parse(json.licenseid);
						for (i=0;i<licenseJson.length;i++)
							document.getElementById("gwf_ro_licenses"+licenseJson[i]).checked= "checked";
					}

	 			}
	 		});
		}
		
		
	}
	
	
	//
	function createGwfResearchObject(projectJson){

		console.log("create?");
		var researchObjectJson = buildResearchObjectJsonForCreate(projectJson);
		
		var url = document.getElementById('workflowgenericurl').value;
		console.log(researchObjectJson);
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(researchObjectJson),
				"<portlet:namespace />responseTarget" : "createresearchobject"
			},
			async: false,
			success :  function (obj){
				console.log("test");
				console.log(obj);
				if (obj.researchobjectid >0){
					document.getElementById("gwf_ro_id").innerHTML= obj.researchobjectid;
					document.getElementById("gwf_ro_version").innerHTML= obj.researchobjectversion;
					
					if (document.getElementById("gwf_ro_name").value =="")
						document.getElementById("gwf_ro_name").value = document.getElementById("gwf_ro_label").value;
					if (document.getElementById("gwf_ro_label").value=="")
						document.getElementById("gwf_ro_label").value = document.getElementById("gwf_ro_name").value;
					
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
			
		var url = document.getElementById('workflowgenericurl').value;
		
		data["path"]= document.getElementById("gwf_user_path").innerHTML;

		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "startsubmission"
			},
			async: false,
			success :  function (obj){
				var commentarField = $("#".concat('gwf_lf_submissioncomentarField'));
				commentarField.empty();
				commentarField.append("<div>The Submission information has been sent to the data curators of collections. One of them will be contact you shortly. </div>");
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