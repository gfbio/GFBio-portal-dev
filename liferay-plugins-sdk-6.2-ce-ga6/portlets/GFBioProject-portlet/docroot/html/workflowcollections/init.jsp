

<script>


	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////

		
/* 	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			var div =   $("#collections");
			if (data == undefined || !(data.workflow==="collections")){
				div.attr("class", "swHide");
				div.empty();
			}else {
				if (div.attr("class")=="swHide"){
					div.attr("class", "swMain");
					buildCollectionsForm(data, div);
					fillDefaultInformations(data, div);
					if (data.projectid!=0)
						fillProjectInformations(data, div);
					if (data.researchobjectid!=0)
						fillResearchObjectInformations(data, div);
				}
			}
		});
	});
	 */
	 
	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#collections");
			
			if (data.projectid==0){
				if (data.researchobjectid==0){
					fillDefaultInformations(data, div);
				}else{
					if (document.getElementById("cwf_ro_id").innerHTML!= 0)
						fillDefaultResearchObjectInformations(data, div);
					fillResearchObjectInformations(data, div);
				}
			}else{
				if (data.researchobjectid==0){
					if (document.getElementById("cwf_project_id").innerHTML!= 0)
						fillDefaultInformations(data, div);
					fillProjectInformations(data, div);
					fillDefaultResearchObjectInformations(data, div);
				}else{
					if (document.getElementById("cwf_ro_id").innerHTML!= 0)
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
	
	
	//build default collection workflow without project or researchobject data
	AUI().ready(function(A){
		var div =   $("#collections");
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildCollectionsForm(data, div);
		fillDefaultInformations(data, div);
	});	
	
	
	
	//
	function buildCollectionsForm(data, div){
		
		if (data.userid != 0){

			div.append(
				"<h2>Submission of Collection data</h2>"+
				"</br>"+
				"<h3>Project Information</h3>"+
				"</br>"+
				"<h4>Basic Information</h4>"+
				"</br>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 					id='cwf_project_id_l'> Project id </label>"+
						"<div class='field lfr-input-text-container' 	id='cwf_project_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_project_name_l' >Project title  </label>"+
					"<input class='field lfr-input-text-container' 	id='cwf_project_name'	type='text'  value=''>"+
				"</div>"+ 
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_project_label_l'> Project label (like abbreviation of DFG ) </label>"+
					"<input	class='field lfr-input-text-container'	id='cwf_project_label'	type='text'  value=''>"+
				"</div>"+ 
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_project_pi_l'> Project PI / responsible person</label>"+
					"<input class='field lfr-input-text-container' 	id='cwf_project_pi'		type='text'  value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 				    id='cwf_project_description_l'> Project abstract </label>"+
					"<input class='field lfr-input-text-container' 	id='cwf_project_description'  type='text'  value=''>"+
				"</div>"+

				"</br>"+
				"<h4>Optional Keywords</h4>"+
				"<div id='cwf_project_keywords'></div>"+
				"<h3>Submitter information</h3>"+
				"</br>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<div class='control-label' > Submitter id </div>"+
						"<div class='field lfr-input-text-container' id='cwf_user_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label'> Submitter name </label>"+
					"<div class='field lfr-input-text-container' id='cwf_user_name' ></div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label'> Submitter mail </label>"+
					"<div class='field lfr-input-text-container' id='cwf_user_mail' ></div>"+
				"</div>"+
				
				"</br>"+
				"<h3>Dataset Information</h3>"+
				"</br>"+
				"<h4>Basic Information</h4>"+
				"</br>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label'					id='cwf_ro_id'_l>Dataset id </label>"+
						"<div	class='field lfr-input-text-container'	id='cwf_ro_id'></div>"+
					"</div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 				   	id='cwf_ro_name_l'>Dataset title </label>"+
					"<input	class='field lfr-input-text-container'	id='cwf_ro_name' type='text'  value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 				   	id='cwf_ro_version_l'>Dataset version </label>"+
					"<div	class='field lfr-input-text-container'	id='cwf_ro_version'></div>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_ro_label_l'> Dataset label </label>"+
					"<input class='field lfr-input-text-container'	id='cwf_ro_label'	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_ro_author_l'> Dataset author </label>"+
					"<input class='field lfr-input-text-container' 	id='cwf_ro_author' 	type='text'  value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' id='cwf_ro_dct_l'	id='cwf_ro_dct_l'> Data collection time </label>"+
					"<input class='field lfr-input-text-container'	id='cwf_ro_dct' 	type='text' value=''>"+
				"</div>"+
				"<div class='control-group'>"+
					"<label	class='control-label' 					id='cwf_ro_description_l'> Dataset description </label>"+
					"<input	class='field lfr-input-text-container'	id='cwf_ro_description' type='text' value='' >"+
				"</div>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_ro_publications_l'> Related publications </label>"+
					"<input class='field lfr-input-text-container'	id='cwf_ro_publications' type='text'  value=''>"+
				"</div>"+
				"<div class='control-group' >"+
					"<label class='control-label' 					id='cwf_ro_metadatalabel_l'> Metadata shema / data type  </label>"+
					"<div 	class='field lfr-input-text-container' 	id='cwf_ro_metadatalabel_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='cwf_ro_metadatalabel' name='<portlet:namespace/>cwf_ro_metadatalabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 					id='cwf_pd_id_l'> file id </label>"+
						"<div class='field lfr-input-text-container' 	id='cwf_pd_id'></div>"+
					"</div>"+
				"</div>"+
				
				"</br>"+				
				"<h4>Licence Information of Dataset</h4>"+
				"</br>"+	
				
				"<div class='control-group'>"+
					"<label class='control-label' id='cwf_ro_nagoya_l'> Dataset is subject to the Nagoya Protocol? </label>"+
					"<div class='field lfr-input-text-container'>"+
					 	"<fieldset>"+ 
							"<input class='field lfr-input-text-container' type='radio' id='cwf_ro_nagoyayes' name='cwf_ro_nagoya' value='yes'>	 yes </br>"+ 
							"<input class='field lfr-input-text-container' type='radio' id='cwf_ro_nagoyano'  name='cwf_ro_nagoya' value='no'>		 no  </br>"+ 
						"</fieldset>"+
					"</div>"+
					"<div style='clear:left' id='cwf_ro_nagoyadiv'></div>"+
				"</div>"+
				
				
				"<div class='control-group' >"+
					"<label class='control-label' 					id='cwf_ro_license_l'> Appropriate license   </label>"+
					"<div 	class='field lfr-input-text-container' 	id='cwf_ro_license_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='cwf_ro_licenselabel' name='<portlet:namespace/>cwf_ro_licenselabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				
				
						
				"</br>"+
				"<div class='row' id='cwf_lf_comentarField'>"+
				"</div>"+
				"</br>"+
				"<div class='row' id='cwf_lf_submissioncomentarField'>"+
				"</div>"+
				"</br>"+
				
				"<div class='row'>"+
					"<span class='widthM' id='cwf_b_save' onclick='saveAllInput()'>		<span class='btn btn-primary'>Save all information</span></span>"+
					"<span class='widthM' id='cwf_b_validate' onclick='checkInput()'>	<span class='btn btn-primary'>Checking for completeness</span></span>"+
					"<span class='widthM' id='cwf_b_save' onclick='saveProjectInput()'>	<span class='btn btn-primary'>Save only project information</span></span>"+
					"<span class='widthM' id='cwf_b_start' onclick='submitInput()'>		<span class='btn btn-primary'>Start submission</span></span>"+
				"</div>"					
				
			);
		}
/* 		document.getElementById("cwf_ro_nagoyayes").onclick = function() {
			var radioNagoya = $("#".concat('cwf_ro_nagoyadiv'));
			radioNagoya.empty();
			radioNagoya.append(
				"</br>"+
				"<div class='control-group'>"+
					"<label class='control-label' 					id='cwf_ro_nagoyadetails_l'> URL to details </label>"+
					"<input class='field lfr-input-text-container'	id='cwf_ro_nagoyadetails' type='text'  value=''>"
			);
		}; */
/* 		document.getElementById("cwf_ro_nagoyano").onclick = function() {
			var radioNagoya = $("#".concat('cwf_ro_nagoyadiv'));
			radioNagoya.empty();
			
		}; */
	}
	
	
	//default fill function of collections submission workflow
	function fillDefaultInformations(data, div){
		fillDefaultProjectInformations(data, div);
		fillDefaultSubmitterInformations(data, div);
		fillDefaultResearchObjectInformations(data, div);
	}
	
	
	//default fill function of collections submission workflow
	function fillDefaultProjectInformations(data, div){

		var url = document.getElementById('workflowcollectionsurl').value;
		var ajaxData = {"relationtablename":"gfbio_category_type","entitytablename":"gfbio_type", "entitytablecellcontent":"research field"}

		document.getElementById("cwf_project_id").innerHTML= 0;
		document.getElementById("cwf_project_name").value= "";
		document.getElementById("cwf_project_label").value= "";
		document.getElementById("cwf_project_description").value= "";
		
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "getresearchfieldinformations"
			},
			async: false,
 			success :  function (obj){
				var divKey = $("#".concat('cwf_project_keywords'));
				divKey.empty();

				for (i=0; i < obj.length;i++){
					if (i < obj.length-1){
						var j = i+1;
						divKey.append(
							"<div class='row2'>"+
								"<div class='rowLato'>"+
									"<input type='checkbox' id='cwf_project_keywords"+obj[i].id+"' name='keywords' value='"+obj[i].id+"'> "+obj[i].name+
								"</div>"+
								"<div class='rowField'>"+
									"<input type='checkbox' id='cwf_project_keywords"+obj[j].id+"' name='keywords' value='"+obj[j].id+"'> "+obj[j].name+
								"</div>"+
							"</div>"
						);
						i = i+1;
					}else{
						divKey.append(
							"<div class='row2'>"+
								"<div class='rowLato'>"+
									"<input type='checkbox' id='cwf_project_keywords"+obj[i].id+"' name='keywords' value='"+obj[i].id+"'> "+obj[i].name+
								"</div>"+
							"</div>"
						);
					}
					divKey.append("<div style='clear:left'></div>");
					
				}
			} 
		}); 
		
		ajaxData = {"tablename":"gfbio_metadata"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){
 				var choMeta = $("#".concat('cwf_ro_metadatalabel'));
				choMeta.empty();
				choMeta.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					choMeta.append("<option id='cwf_ro_metadatalabel"+json.id+"' value='"+json.id+"'>"+json.label+"</option>");
				}
					
				//choMeta.append("<option value='other'>other</option>");
 			}
 		});
				
		
	}
	
	
	//
	function fillDefaultResearchObjectInformations(data, div){
	
		var url = document.getElementById('workflowcollectionsurl').value;
	
		document.getElementById("cwf_ro_id").innerHTML= 0;
		document.getElementById("cwf_ro_version").innerHTML= 1;
		document.getElementById("cwf_ro_name").value= "";
		document.getElementById("cwf_ro_label").value= "";
		
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
				document.getElementById("cwf_ro_author").value= obj.fullname.concat(",");
 			}
 		});
 		
 		document.getElementById("cwf_ro_dct").value= "";
 		document.getElementById("cwf_ro_description").value= "";
 		document.getElementById("cwf_ro_publications").value= "";
 		
 		
 		
 		
 		document.getElementById("cwf_ro_metadatalabel").selectedIndex = 0;
 		
  		var div =   $("#cwf_ro_metadatalabel_v");
		div.empty();
		div.append(
			"<form action='select.html'>"+
				"<select id='cwf_ro_metadatalabel' name='<portlet:namespace/>cwf_ro_metadatalabel' size='1' style='width:90%'>"+
					"<option value='none'></option>"+
				"</select>"+
			"</form>"
		);
		
 		ajaxData = {"tablename":"gfbio_metadata"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){
 				var choMeta = $("#".concat('cwf_ro_metadatalabel'));
				choMeta.empty();
				choMeta.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					choMeta.append("<option id='cwf_ro_metadatalabel"+json.id+"' value='"+json.id+"'>"+json.label+"</option>");
				}
 			}
 		}); 

 		document.getElementById("cwf_pd_id").innerHTML= 0;
		document.getElementById("cwf_ro_nagoyano").checked = true;
		var radioNagoya = $("#".concat('cwf_ro_nagoyadiv'));
		radioNagoya.empty();
		
		ajaxData = {"tablename":"gfbio_license"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){

 				var divLi = $("#".concat('cwf_ro_licenselabel'));
				divLi.empty();
				divLi.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					if (json.label == "CC BY")
						divLi.append("<option id='cwf_ro_licenses"+json.id+"' value='"+json.id+"' selected=true>"+json.name+"</option>");
					else	
						divLi.append("<option id='cwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");

				}
 			}
 		});
			
	}
	
	
	
	//
	function fillDefaultSubmitterInformations(data, div){
		
		var url = document.getElementById('workflowcollectionsurl').value;
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
				document.getElementById("cwf_user_id").innerHTML= data.userid;
				document.getElementById("cwf_user_name").innerHTML= obj.fullname;
				document.getElementById("cwf_user_mail").innerHTML= obj.emailaddress;
 			}
 		});
	}
	
	

	
	//default fill function of collections submission workflow
	function fillProjectInformations(data, div){
		
		var url = document.getElementById('workflowcollectionsurl').value;
		if (Number(data.projectid)!=0){
			var ajaxData = {"projectid": Number(data.projectid)};
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowCollectionsPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getproject"
				},
				async: false,
	 			success :  function (obj){
					document.getElementById("cwf_project_id").innerHTML= obj.projectid;
					document.getElementById("cwf_project_name").value= obj.name;
					document.getElementById("cwf_project_label").value= obj.label;
					document.getElementById("cwf_project_description").value= obj.description;
					
					if (obj.hasOwnProperty('categoryid')) {
						var json = JSON.parse(obj.categoryid);
						for (i=0;i<json.length;i++)
							document.getElementById("cwf_project_keywords"+json[i]).checked= "checked";
					}
					
	 			}
	 		});
	 		
	 		
			ajaxData = {"projectid": Number(data.projectid)};
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowCollectionsPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getfullnames"
				},
				async: false,
	 			success :  function (obj){
	 				document.getElementById("cwf_project_pi").value= obj.projectpi;
	 			}
	 		});
		}
	}
	
	
	//
	function fillResearchObjectInformations(data, div){

		var url = document.getElementById('workflowcollectionsurl').value;
		if (Number(data.researchobjectid)!=0){
			var ajaxData = [{"researchobjectid":Number(data.researchobjectid)}];
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowCollectionsPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getresearchobjectbyid"
				},
				async: false,
	 			success :  function (obj){
	 				
	 				var div =   $("#cwf_ro_metadatalabel_v");
					var json = obj[0];
					var ed = json.extendeddata;
					for (i=0;i<ed.length/2;i++)
						ed = ed.replace("'",'"');
					var extendeddata = JSON.parse(ed);
					
					document.getElementById("cwf_ro_id").innerHTML= json.researchobjectid;
					document.getElementById("cwf_ro_version").innerHTML= json.researchobjectversion;
					document.getElementById("cwf_ro_name").value= json.name;
					document.getElementById("cwf_ro_label").value= json.label;
					
					if (extendeddata.datacollectiontime !=null)
						document.getElementById("cwf_ro_dct").value= extendeddata.datacollectiontime;
					else
						document.getElementById("cwf_ro_dct").value= "";
					
					document.getElementById("cwf_ro_description").value= json.description;
					div.empty();
					div.append(json.metadatalabel+
						"<div class='rowField'><input type='hidden' id='cwf_ro_metadatalabel' value='"+json.metadatalabel+"'></div>"
					);

					if (json.authorname != null){
						var author = (json.authorname).substring(1, (json.authorname.length)-1);
						for (i=0;i<author.length/2;i++)
							author = author.replace('"','');
						document.getElementById("cwf_ro_author").value= author;
					}else{
						document.getElementById("cwf_ro_author").value= "";
					}
					
					
					if (extendeddata.publications !=null)
						document.getElementById("cwf_ro_publications").value= extendeddata.publications;
					else
						document.getElementById("cwf_ro_publications").value= "";
					
					

					if (extendeddata.nagoya !=null){
						if (extendeddata.nagoya == "no"){
							document.getElementById("cwf_ro_nagoyano").checked = true;
						}else{
							document.getElementById("cwf_ro_nagoyayes").checked = true;
							document.getElementById("cwf_ro_nagoyayes").value =extendeddata.nagoya;
						}
					}else{
						document.getElementById("cwf_ro_nagoyano").checked = true;
					}
					
					if (json.hasOwnProperty('licenseid')) {
						var licenseJson = JSON.parse(json.licenseid);
						for (i=0;i<licenseJson.length;i++)
							document.getElementById("cwf_ro_licenses"+licenseJson[i]).checked= "checked";
					}

	 			}
	 		});
		}
		
		
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////
	
	
	//
	function startSubmission(data){
			
		var url = document.getElementById('workflowcollectionsurl').value;
		
		console.log("start with");
		console.log(data);
		
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "startsubmission"
			},
			async: false,
			success :  function (obj){
				var commentarField = $("#".concat('cwf_lf_submissioncomentarField'));
				commentarField.empty();
				commentarField.append("<div class='portlet-success'>The Submission information has been sent to the data curators of collections. One of them will be contact you shortly. The ID of this Submission is "+obj.key+"</div>");
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
	
	
	//
	function startSubmissionRegistry(data){

		var url = document.getElementById('workflowcollectionsurl').value;

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
					var commentarField = $("#".concat('cwf_lf_comentarField'));
					commentarField.empty();
					commentarField.append("<div class='portlet-success' id='cwf_lf_subreg'>Submission entry is written in the registry.</div>");
					setTimeout(function(){commentarField.empty();}, 5000);
				}else{
					var commentarField = $("#".concat('cwf_lf_submissioncomentarField'));
					document.getElementById("cwf_lf_submissioncomentarField").className="portlet-msg-error";
					commentarField.empty();
					commentarField.append("<div class='portlet-msg-error'>The Submission information transfer was stopped because there is already a submission of this data set, with the same version on this workflow. </div>");
					setTimeout(function(){
						commentarField.empty();
						document.getElementById("cwf_lf_submissioncomentarField").className="row";;
					}, 25000);
				}
					
			}		
		});	
	}

	
	//
	function createCwfProject(){
		var projectJson = buildProjectJsonForCreate();
		var url = document.getElementById('workflowcollectionsurl').value;
		
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(projectJson),
				"<portlet:namespace />responseTarget" : "createproject"
			},
			async: false,
			success :  function (obj){
				if (obj.projectid >0){
					sentWorkflowUpdate(true, obj.projectid, projectJson.label, false);
					document.getElementById("cwf_project_id").innerHTML= obj.projectid;
					if (document.getElementById("cwf_project_name").value =="")
						document.getElementById("cwf_project_name").value = document.getElementById("cwf_project_label").value;
					if (document.getElementById("cwf_project_label").value=="")
						document.getElementById("cwf_project_label").value = document.getElementById("cwf_project_name").value;
					projectJson["projectid"]= Number (obj.projectid);
				}
			}
		});	
		return projectJson;
	}
	
	
	//
	function createCwfResearchObject(projectJson){

		var researchObjectJson = buildResearchObjectJsonForCreate(projectJson);
		var url = document.getElementById('workflowcollectionsurl').value;

		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowCollectionsPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(researchObjectJson),
				"<portlet:namespace />responseTarget" : "createresearchobject"
			},
			async: false,
			success :  function (obj){
				if (obj.researchobjectid >0){
					document.getElementById("cwf_ro_id").innerHTML= obj.researchobjectid;
					document.getElementById("cwf_ro_version").innerHTML= obj.researchobjectversion;
					if (document.getElementById("cwf_ro_name").value =="")
						document.getElementById("cwf_ro_name").value = document.getElementById("cwf_ro_label").value;
					if (document.getElementById("cwf_ro_label").value=="")
						document.getElementById("cwf_ro_label").value = document.getElementById("cwf_ro_name").value;
					researchObjectJson["projectid"]=Number(projectJson.projectid);
					researchObjectJson["researchobjectid"]=Number(obj.researchobjectid);
					researchObjectJson["researchobjectversion"]=Number(obj.researchobjectversion);
				}
			}
		});
		return researchObjectJson;
	}
	
	
	
	////////////////////////////////////////////////////////////////// upload tests
	
	
	function testSubmit(){
		
		console.log("1");
	
		var url = document.getElementById('workflowcollectionsurl').value;
		var formData = new FormData();
		/* 		
		var id = '10';
		var version = '1';
		var text = id +";" +version;
				
		console.log("2");
		  console.log(text);
		
 		var textFile = null;
		var makeTextFile = function (text) {
			console.log("2.0.1");
			var data = new Blob([text], {type: 'text/plain'});
			console.log("2.0.2");
		    // If we are replacing a previously generated file we need to
		    // manually revoke the object URL to avoid memory leaks.
		    if (textFile !== null) {
				console.log("2.0.3");
		    	window.URL.revokeObjectURL(textFile);
		    }

			console.log("2.0.4");
			console.log(data);	
		    textFile = window.URL.createObjectURL(data);

			console.log("2.0.5");
			  console.log(textFile);			
		    return textFile;
		  }; 
		  console.log("2.1");
		  console.log(textFile);
		

		  var txtFile = "test.txt";
		  console.log("2.2");
		  console.log(txtFile);
		 //var file = new File(txtFile);
		  var file = textFile;
		  console.log("2.3");
		  console.log(file);
		  var str = text;
		  console.log("2.4");
		  console.log(str);
		  file.open("w"); // open file with write access
//		  file.writeln("First line of text");
//		  file.writeln("Second line of text " + str);
		  file.write(str);
		  console.log("2.5");
		  file.close();
		  console.log("2.6");

			console.log("3");
		  
		 */
		 var txtFile = "test.txt";
		 
		formData.append('file', txtFile);
		 
		var fileSelect = document.getElementById('file-select');
		console.log (fileSelect);
		
		var files = fileSelect.files;
		console.log (files);
		
		for (var i = 0; i < files.length; i++) 
		  	formData.append('file', files[i]);
		console.log (formData);
		
		console.log(formData.getAll('file'));
	  	
/*  		var json = {};
		json["<portlet:namespace />responseTarget"] = "uploadfile";
		console.log(json);
		formData.append('json', json);
		console.log(formData.getAll('json'));  */
	  	

 		$.ajax({
 			"url": url.concat('/WorkflowCollectionsPortlet'),
 			"type" : "POST",
			processData: false,
			contentType: false,
			"data" : formData,
			async: false,
			success :  function (){
				console.log("yeah");
			} 
		});

	}
	
	

	
</script>