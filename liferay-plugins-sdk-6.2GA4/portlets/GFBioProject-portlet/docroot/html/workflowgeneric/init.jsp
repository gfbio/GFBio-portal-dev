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
				//"<h2>Generic Submission Workflow</h2>"+
				
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
					"<div 		class='control-group'>"+
						"<label class='control-label'					id='gwf_ro_id'_l>Dataset id </label>"+
						"<div	class='field lfr-input-text-container'	id='gwf_ro_id'></div>"+
					"</div>"+
					"<div 		class='control-group'>"+
						"<label class='control-label' 				   	id='gwf_ro_version_l'>Version </label>"+
						"<div	class='field lfr-input-text-container'	id='gwf_ro_version'></div>"+
					"</div>"+
					"<div 		class='control-group'>"+
						"<label class='control-label' 					id='gwf_ro_researchobjecttype_l'> Type </label>"+
						"<div 	class='field lfr-input-text-container' 	id='gwf_ro_researchobjecttype'></div>"+
					"</div>"+
				"</div>"+
				"<div 		class='control-group'>"+
					"<label class='control-label' 				   	id='gwf_ro_name_l'>Title* </label>"+
					"<p 	class='field-description'				id='gwf_ro_name_d'>Provide a short, descriptive title for your dataset.</p>"+
					"<input	class='field lfr-input-text-container'	id='gwf_ro_name' type='text'  value=''>"+
				"</div >"+
				"<div 			class='control-group'>"+
					"<label		class='control-label' 					id='gwf_ro_description_l'> Description* </label>"+
					"<p 		class='field-description'				id='gwf_ro_description_d'>Provide a summary of the work you did to produce the dataset (similar to an article abstract).</p>"+
					"<textarea	class='field lfr-input-text-container'	id='gwf_ro_description' rows='6' ></textarea>"+
				"</div>"+
				"</div>"+
				"<div 		class='control-group'>"+
					"<label class='control-label' id='gwf_ro_dct_l'	id='gwf_ro_dct_l'> Data collection time </label>"+
					"<p 	class='field-description'				id='gwf_ro_description_d'>Provide a time periode, where the data are collected or processed.</p>"+
					"<input class='field lfr-input-text-container'	id='gwf_ro_dct' 	type='text' value=''>"+
				"</div>"+
				"<div 		class='control-group'>"+
					"<label class='control-label' 					 id='gwf_ro_label_l'> Dataset label </label>"+
					"<p 	class='field-description'				 id='gwf_ro_labels_d'>Use labels, to typing the dataset, describe it in keywords or use your internal signifier.</p>"+
					"<input class='field lfr-input-text-container'	 id='gwf_ro_label'	type='text'  value=''>"+
				"</div>"+
				"<label class='control-label' 					id='gwf_ro_categories_l'> Categories  </label>"+
				"<p 	class='field-description'			 	id='gwf_ro_categories_d'>Choose one or more categories, that are related with the dataset.</p>"+
				"<div 											id='gwf_ro_categories'></div>"+
				"</br>"+
				"<div 			class='control-group'>"+
					"<label 	class='control-label' 					id='gwf_ro_author_l'> Dataset author* </label>"+
					"<p 		class='field-description'			 	id='gwf_ro_author_d'>Please, enter the author(s) for the data set (one author per line).</p>"+
					"<textarea	class='field lfr-input-text-container'	id='gwf_ro_author' rows='3' ></textarea>"+
				"</div>"+
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_license_l'> Appropriate license*   </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_license_d'>Select the license that you prefer for your dataset.</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_license_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_licenselabel' name='<portlet:namespace/>gwf_ro_licenselabel' size='1' style='width:100%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div 		class='control-group'>"+
					"<label class='control-label' 					id='gwf_ro_publications_l'> Related publications </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_publications_d'>Provide this information, if the dataset related to a publication.</p>"+
					"<input class='field lfr-input-text-container'	id='gwf_ro_publications' type='text'  value=''>"+
				"</div>"+
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_metadatalabel_l'> Metadata schema  </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_metadatalabel_d'>Select the metadata schema, that you use for your dataset.</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_metadatalabel_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_metadatalabel' name='<portlet:namespace/>gwf_ro_metadatalabel' size='1' style='width:100%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div 											class='control-group'>"+
					"<label 									class='control-label' 					id='gwf_ro_embargo_l'> Embargo </label>"+
					"<p 										class='field-description'			 	id='gwf_ro_embargo_d'>Provide a date at which the dataset should be under an embargo  (yyyy-mm-dd')</p>"+
					"<span onmousemove='datePickler()'><input   class='field lfr-input-text-container' 	id='gwf_ro_embargo' 	type='text'   value=''></span>"+
				"</div>"+
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_legalrequirements_l'> Legal requirements  </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_embargo_d'>Select legal requirements that apply to the dataset.</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_legalrequirements' type='text'  value=''></div>"+
				"</div>"+

				"<h3>Dataset Upload</h3>"+
				
				"<form id='file-form' >"+
				  	"<input type='file' id='file-select'   multiple/>"+
				"</form>"+
				
				"</br>"+
				"<div class='row' id='gwf_lf_comentarField'></div></br>"+
				"<div class='row' id='gwf_lf_storecomentarField'></div>"+
				"<div class='row' id='gwf_lf_uploadcomentarField'></div>"+
				"<div class='row' id='gwf_lf_registrycomentarField'></div>"+
				"<div class='row' id='gwf_lf_submissioncomentarField'></div>"+
				
				"<div class='row'>"+
/* 					"<span class='widthM' id='gwf_b_save' onclick='saveAllInput()'>		<span class='btn btn-primary'>Save dataset information</span></span>"+
					"<span class='widthM' id='gwf_b_validate' onclick='checkInput()'>	<span class='btn btn-primary'>Checking for completeness</span></span>"+
 */					"<span class='widthM' id='gwf_b_start' onclick='submitInput()'>		<span class='btn btn-success'>Start submission</span></span>"+
 					"<span class='widthM' id='gwf_b_reset' onclick='resetInput()'>		<span class='btn btn-primary'>Reset</span></span>"+
				"</div>"

			);
		}
	}
	
	
	
	
	//
	function datePickler(){
		$( "#gwf_ro_embargo" ).datepicker({
			dateFormat: "yy-mm-dd",
			//changeMonth: true,
			//changeYear: true
		});
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
		document.getElementById("gwf_ro_researchobjecttype").innerHTML= "Dataset";
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
				document.getElementById("gwf_ro_author").innerHTML= obj.fullname.concat(",");
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
				"<select id='gwf_ro_metadatalabel' name='<portlet:namespace/>gwf_ro_metadatalabel' size='1' style='width:100%'>"+
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
					if (json.label == "other")
						divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
					else if (json.label == "CC BY")
						divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"' selected=true>"+json.label+": "+json.name+" "+json.version+"</option>");
						else	
							divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.label+": "+json.name+" "+json.version+"</option>");
				}
 			}
 		});
 		
 		
 		var divLi = $("#".concat('gwf_ro_legalrequirements'));
		divLi.empty();
		divLi.append(
			"<div class='row2'>"+
				"<div class='rowLato'> <input type='checkbox' id='gwf_ro_legalrequirements_nagoya' name='legalrequirements' value='Nagoya'> Nagoya</div>"+
				"<div class='rowField'><input type='checkbox' id='gwf_ro_legalrequirements_red'    name='legalrequirements' value='Red List'>  Red List</div>"+
			"</div>"+
			"<div class='row2'>"+
				"<div class='rowLato'> <input type='checkbox' id='gwf_ro_legalrequirements_personal'   name='legalrequirements' value='Personal'> Personal</div>"+
				"<div class='rowField'><input type='checkbox' id='gwf_ro_legalrequirements_uncertain'  name='legalrequirements' value='Uncertain'>  Uncertain</div>"+
			"</div>"+
			"<div style='clear:left'></div>"
		);
		

		
		
		ajaxData = {"relationtablename":"gfbio_category_type","entitytablename":"gfbio_type", "entitytablecellcontent":"research field"}
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getresearchfieldinformations"
			},
			async: false,
 			success :  function (obj){
				var divKey = $("#".concat('gwf_ro_categories'));
				divKey.empty();

				for (i=0; i < obj.length;i++){
					if (i < obj.length-1){
						var j = i+1;
						divKey.append(
							"<div class='row2'>"+
								"<div class='rowLato'>"+
									"<input type='checkbox' id='gwf_ro_categories"+obj[i].id+"' name='categories' value='"+obj[i].id+"'> "+obj[i].name+
								"</div>"+
								"<div class='rowField'>"+
									"<input type='checkbox' id='gwf_ro_categories"+obj[j].id+"' name='categories' value='"+obj[j].id+"'> "+obj[j].name+
								"</div>"+
							"</div>"
						);
						i = i+1;
					}else{
						divKey.append(
							"<div class='row2'>"+
								"<div class='rowLato'>"+
									"<input type='checkbox' id='gwf_ro_categories"+obj[i].id+"' name='categories' value='"+obj[i].id+"'> "+obj[i].name+
								"</div>"+
							"</div>"
						);
					}
					divKey.append("<div style='clear:left'></div>");
					
				}
			} 
		}); 

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
						document.getElementById("gwf_ro_author").innerHTML= author;
					}else{
						document.getElementById("gwf_ro_author").innerHTML= "";
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
		
		var researchObjectJson = buildResearchObjectJsonForCreate(projectJson);
		var url = document.getElementById('workflowgenericurl').value;

		
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(researchObjectJson),
				"<portlet:namespace />responseTarget" : "createresearchobject"
			},
			async: false,
			success :  function (obj){

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
			},
			error :  function (obj){
				console.log("error");
			}
			
		});
		return researchObjectJson;
	}
	
	
	//
	function startSubmissionRegistry(data){

		var url = document.getElementById('workflowgenericurl').value;
		
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "createsubmissionregistry"
			},
			async: false,
			success :  function (obj){
				if (!obj.hasOwnProperty("ERROR")){
					var commentarField = $("#".concat('gwf_lf_registrycomentarField'));
					commentarField.empty();
					commentarField.append("<div class='portlet-success' id='gwf_lf_subreg'>Submission entry is written in the registry.</div>");
					//setTimeout(function(){commentarField.empty();}, 5000);
				}else{
					var commentarField = $("#".concat('gwf_lf_registrycomentarField'));
					document.getElementById("gwf_lf_submissioncomentarField").className="portlet-msg-error";
					commentarField.empty();
					commentarField.append("<div class='portlet-msg-error'>The Submission information transfer was stopped because there is already a submission of this data set, with the same version on this workflow. </div>");
/* 					setTimeout(function(){
						commentarField.empty();
						document.getElementById("gwf_lf_submissioncomentarField").className="row";;
					}, 25000); */
				}
					
			}		
		});	
	}
	
	
	////////////////////////////////////////////////////////////////// upload tests
	
	
	function fileUplaod(){
	
		var url = document.getElementById('workflowgenericurl').value;
		var formData = new FormData();
	  //var uploadInformation = new File(['{"researchobjectid":'+Number(document.getElementById('gwf_ro_id').innerHTML)+',"researchobjectversion":'+Number(document.getElementById('gwf_ro_version').innerHTML)+',"userid":'+Number(document.getElementById('gwf_user_id').innerHTML)+',"path":"'+document.getElementById('gwf_user_path').innerHTML+'"}'], "uploadInformation.txt");
	    var uploadInformation = new File(['{"researchobjectid":'+Number(document.getElementById('gwf_ro_id').innerHTML)+',"researchobjectversion":'+Number(document.getElementById('gwf_ro_version').innerHTML)+',"userid":'+Number(document.getElementById('gwf_user_id').innerHTML)															   +'}'], "uploadInformation.txt");

		formData.append('file', uploadInformation);

		var fileSelect = document.getElementById('file-select');
		var files = fileSelect.files;

		for (var i = 0; i < files.length; i++){ 
		  	formData.append('file', files[i]);
		}
		
 		$.ajax({
 			"url": url.concat('/WorkflowCollectionsPortlet'),
 			"type" : "POST",
			processData: false,
			contentType: false,
			"data" : formData,
			async: false,
			success :  function (){
				
				
				var commentarField = $("#".concat('gwf_lf_uploadcomentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-success' id='gwf_lf_subreg'>File upload complete to GFBio.</div>");
				//setTimeout(function(){commentarField.empty();}, 5000);
			} 
		});
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////// submission
	
	
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
				commentarField.append("<div class='portlet-success'>The Submission information has been sent to the data curators of collections. Your submission key is: "+obj.key+". One of them will be contact you shortly. </div>");
				//setTimeout(function(){commentarField.empty();}, 25000);
			},
			error :  function (obj){
				var delSubRegdata ={};
				delSubRegdata["researchobjectid"]= data.mrr.researchobjects.researchobjectid;
				delSubRegdata["researchobjectversion"]= data.mrr.researchobjects.researchobjectversion;
				delSubRegdata["archive"]= "GFBio collections";
				deleteSubmissionRegistryEntry(delSubRegdata);
				
				var commentarField = $("#".concat('gwf_lf_submissioncomentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-msg-error'>The Submission information transfer is failed. Please contact our technical support. </div>");
				//setTimeout(function(){commentarField.empty();}, 25000);

			},		
		});	 
	}
	
	
	//
	function deleteSubmissionRegistryEntry(data){
			
		var url = document.getElementById('workflowgenericurl').value;
		
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "delsubreg"
			},
			async: false,
			success :  function (obj){
				console.log("del  subreg");
				console.log(obj);
			}
	
		});	 
	}
	
	
	//
	function sentToBroker(data){
			
		var url = "https://c103-171.cloud.gwdg.de/api/submissions/generic";
				
		//console.log(data);
		
		//data["path"]= document.getElementById("gwf_user_path").innerHTML;
		
 		$.ajax({
			"type" : "POST",
			"url": url,
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data)
			},
			async: false,
			success :  function (obj){
				console.log("broker jo");
				console.log(obj);
			},
			error :  function (obj){
				console.log("broker nope");
			},		
		});	 
	}
	
	
	


</script>