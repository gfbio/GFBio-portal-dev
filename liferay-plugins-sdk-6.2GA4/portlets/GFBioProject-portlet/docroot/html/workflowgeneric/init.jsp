<script>


/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////


/* 	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#generic");
			
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
	} */
	
	
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
				"</br>"+
/* 				"<h3>Project Information</h3>"+
				"</br>"+
				"<h4>Basic Information</h4>"+
				"</br>"+ */
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<label class='control-label' 					id='cwf_project_id_l'> Project id </label>"+
						"<div class='field lfr-input-text-container' 	id='cwf_project_id'></div>"+
					"</div>"+
				"</div>"+
/* 				"<div class='control-group'>"+
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
				"<div id='cwf_project_keywords'></div>"+ */
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
					"<span class='widthM' id='cwf_b_save' onclick='saveAllInput()'>		<span class='btn btn-primary'>Save dataset information</span></span>"+
					"<span class='widthM' id='cwf_b_validate' onclick='checkInput()'>	<span class='btn btn-primary'>Checking for completeness</span></span>"+
					"<span class='widthM' id='cwf_b_start' onclick='submitInput()'>		<span class='btn btn-primary'>Start submission</span></span>"+
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

		var url = document.getElementById('workflowgenericurl').value;
		//var ajaxData = {"relationtablename":"gfbio_category_type","entitytablename":"gfbio_type", "entitytablecellcontent":"research field"}

		document.getElementById("cwf_project_id").innerHTML= 0;
	}
	
	
	//
	function fillDefaultResearchObjectInformations(data, div){
	
		var url = document.getElementById('workflowgenericurl').value;
	
		document.getElementById("cwf_ro_id").innerHTML= 0;
		document.getElementById("cwf_ro_version").innerHTML= 1;
		document.getElementById("cwf_ro_name").value= "";
		document.getElementById("cwf_ro_label").value= "";
		
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
			"url": url.concat('/WorkflowGenericPortlet'),
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
			"url": url.concat('/WorkflowGenericPortlet'),
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
		
		var url = document.getElementById('workflowgenericurl').value;
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
				document.getElementById("cwf_user_id").innerHTML= data.userid;
				document.getElementById("cwf_user_name").innerHTML= obj.fullname;
				document.getElementById("cwf_user_mail").innerHTML= obj.emailaddress;
 			}
 		});
	}
	
	
	//default fill function of generic submission workflow
	function fillProjectInformations(data, div){
		
		var url = document.getElementById('workflowgenericurl').value;
		if (Number(data.projectid)!=0){
			document.getElementById("cwf_project_id").innerHTML= data.projectid;
/* 			var ajaxData = {"projectid": Number(data.projectid)};
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowGenericPortlet'),
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
	 		}); */
		}
	}
	
	
	//
	function fillResearchObjectInformations(data, div){

		var url = document.getElementById('workflowgenericsurl').value;
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
	
	
	
	
	
	


</script>