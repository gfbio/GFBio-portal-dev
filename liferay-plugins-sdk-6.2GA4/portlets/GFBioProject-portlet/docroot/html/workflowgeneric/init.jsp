<script>

	var fieldCheckList = ['gwf_ro_name', 'gwf_ro_description', 'gwf_ro_author', 'gwf_ro_license','gwf_ro_dct', 'gwf_ro_label', 'gwf_ro_publications', 'gwf_ro_embargo', 'gwf_ro_externalupload_path'];
	var limitExtrageSmall = 10;
	var limitSmall = 200;
	var limitSmall2 = 400;

	var limitLarge = 2000;
	var limitExtrageLarge = 15000;
	var buttonwidth = '220px';
	var sampleButtonWidth = '460px';

	
/////////////////////////////////////////   helper  //////////////////////////////////////////////
	
	//character counter for inputfields
	function countChars(countfrom,displayto, limit) {
		var len = limit - document.getElementById(countfrom).value.length;
		document.getElementById(displayto).innerHTML = len;
	}
	
/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////


 	//Message from Hide Managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#generic");

			if (data.projectid==0){
				if (data.researchobjectid==0){
					fillDefaultInformations(data, div);
				}else{
					if (document.getElementById("gwf_ro_id").innerHTML!= 0){
						fillDefaultResearchObjectInformations(data, div);
					}
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
	function sentWorkflowUpdate(project, projectId, projectName, researchObject) {
		
		var toUpdate = {
			"updateproject" : project,
			"projectid" : projectId,
			"projectName" : projectName,
			"updateresearchobject"   : researchObject,
		};
		Liferay.fire('gadget:gfbio.archiving.update', toUpdate);
	} 
	
	
	//fire to update information to generally worflow portlet
	function sentResetRequest() {
		
		var toUpdate = {
			"reset" : true,
		};
		Liferay.fire('gadget:gfbio.archiving.reset', toUpdate);
	} 
	
	
	//fire to update information to generally worflow portlet
	function sentShowHideInformation(show) {
		
		var showHide = {
			"show" : show,
		};
		Liferay.fire('gadget:gfbio.archiving.showhide', showHide);
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
	function addInputfieldTo(div, fieldBasicId, fileLabel, fieldLabelStar, fieldDescription, limit, fieldCheck,value){
		div.append(
			"<div 		class='control-group' style='width:100%'>"+
				"<label class='control-label' 				   	id='"+fieldBasicId+"_l'>"+fileLabel+"<span style='color:darkred'>"+fieldLabelStar+"</span> </label>"+
				"<p 	class='field-description'				id='"+fieldBasicId+"_d'>"+fieldDescription+"</p>"+
				"<p 	class='field-description'				style='text-align: right; color:#A9A9A9'><span title='left characters' id='"+fieldBasicId+"_c'>"+limit+"</span></p>"+
				"<input	class='field lfr-input-text-container'	style='width:100%' id='"+fieldBasicId+"' type='text' onchange=\"goToNormal(\'"+fieldCheck+"\')\"; onkeyup=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onkeydown=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onmouseout=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +");\" maxlength='"+limit +"' value='"+value+"'>"+
			"</div >"
		);
	}
	
	//
	function addInputfieldWithoutLabelTo(div, fieldBasicId, fieldDescription, limit, fieldCheck,value){
		div.append(
			"<div 		class='control-group' style='width:100%'>"+
				"<p 	class='field-description'				id='"+fieldBasicId+"_d'>"+fieldDescription+"</p>"+
				"<p 	class='field-description'				style='text-align: right; color:#A9A9A9'><span title='left characters' id='"+fieldBasicId+"_c'>"+limit+"</span></p>"+
				"<input	class='field lfr-input-text-container'	style='width:100%' id='"+fieldBasicId+"' type='text' onchange=\"goToNormal(\'"+fieldCheck+"\')\"; onkeyup=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onkeydown=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onmouseout=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +");\" maxlength='"+limit +"' value='"+value+"'>"+
				"<label class='swHide' 				   			id='"+fieldBasicId+"_l'><span style='color:darkred'></span> </label>"+
			"</div >"
		);
	}
	
	
	//
	function addInputAreaTo(div, fieldBasicId, fileLabel, fieldLabelStar, fieldDescription, limit, fieldCheck,value, rows){
		div.append(
			"<div 			class='control-group' style='width:100%'>"+
				"<label 	class='control-label' 				   	id='"+fieldBasicId+"_l'>"+fileLabel+"<span style='color:darkred'>"+fieldLabelStar+"</span> </label>"+
				"<p 		class='field-description'				id='"+fieldBasicId+"_d'>"+fieldDescription+"</p>"+
				"<p 		class='field-description'				style='text-align: right; color:#A9A9A9'><span title='left characters' id='"+fieldBasicId+"_c'>"+limit+"</span></p>"+
				"<textarea	class='field lfr-input-text-container'	style='width:100%' id='"+fieldBasicId+"' rows='"+rows+"' onchange=\"goToNormal(\'"+fieldCheck+"\')\"; onkeyup=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onkeydown=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +")\"; onmouseout=\"countChars(\'"+fieldBasicId+"\',\'"+fieldBasicId+"_c\', "+limit +");\" maxlength='"+limit  +"'></textarea>"+ 
			"</div >"
		);
	}
	
	
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
				//
				// templates
				//
				/*
				"<div>"+
				"Have a look at the GFBio example templates. You can also submit data in combination with the deposit of biological and environmental samples."+
				"</div>"+
				"<br>"+
				"<div>"+
				"<span style='width:25%; display:inline-block' id='gwf_b_templatewith' onclick=\"window.open('https://gfbio.biowikifarm.net/wiki/Data_submission_forms_for_the_deposit_of_biological_and_environmental_samples');\">		<span style='width:"+sampleButtonWidth+"' class='btn btn-primary'>Download templates for occurrence data <b>with</b> deposit of samples</span></span>"+
				"</div>"+
				"<br>"+
				
				
				"<div>"+
				"<span style='width:25%; display:inline-block' id='gwf_b_templatewith' onclick=\"window.open('https://gfbio.biowikifarm.net/wiki/Data_submission_forms_for_occurrence_data');\">		<span style='width:"+sampleButtonWidth+"' class='btn btn-primary'>Download templates for occurrence data <b>without</b> deposit of samples</span></span>"+
				"</div>"+
				"<br>"+
				*/
				////////////////
				////////////////
				
				
				"<h3>1. Dataset Information</h3><hr>"+
									
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
				"</div>"
			);
			addInputfieldTo(div, "gwf_ro_name", "Title", "*", "Provide a short, descriptive title for your dataset.", limitSmall, fieldCheckList[0],"");
			addInputAreaTo (div, "gwf_ro_description", "Description"		  , "*", "Provide a summary of the work you did to produce the dataset (similar to an article abstract)."	 , limitExtrageLarge, fieldCheckList[1],"", 6);
			addInputfieldTo(div, "gwf_ro_dct"  		 , "Data collection time" , "" , "Provide the time period, in which the data were collected or processed (yyyy-mm-dd to yyyy-mm-dd).", limitLarge		, fieldCheckList[4],"");
			addInputfieldTo(div, "gwf_ro_label"		 , "Dataset label"        , "" , "Please provide keywords for your dataset (use semicolon to separate the words). If available add identifiers (e.g. your Gepris-No.).", limitSmall, fieldCheckList[5],"");
			//addInputfieldTo(div, "gwf_ro_label"		 , "Dataset label"        , "" , "Provide labels for the dataset, describe it in keywords or use internal identifiers."              , limitSmall		, fieldCheckList[5],"");
			div.append(
				"<label class='control-label' 					id='gwf_ro_categories_l'> Categories  </label>"+
				"<p 	class='field-description'			 	id='gwf_ro_categories_d'>Choose one or more categories, that are related with the dataset.</p>"+
				"<div 											id='gwf_ro_categories'></div>"+
				"</br>"
			);
			addInputAreaTo (div, "gwf_ro_author", "Dataset author"		  , "*", "Please, enter the author(s) for the data set (one author per line)."	 , limitLarge, fieldCheckList[2],"", 3);
			div.append(
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_license_l'> License<span style='color:darkred'>*</span>   </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_license_d'> Under which license will your data be accessible?</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_license_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_licenselabel' name='<portlet:namespace/>gwf_ro_licenselabel' size='1' style='width:100%' onchange=\"goToNormal(\'"+fieldCheckList[3]+"\')\">"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"
			);
			addInputfieldTo(div, "gwf_ro_publications"  		 , "Related publication(s)" , "" , "Provide this information, if the dataset is related to a publication.", limitLarge		, fieldCheckList[6],"");
			div.append(	
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_metadatalabel_l'> Metadata schema  </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_metadatalabel_d'>Which metadata schema does your data support (if any)?</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_metadatalabel_v' type='text'  value=''>"+
						"<form action='select.html'>"+
							"<select id='gwf_ro_metadatalabel' name='<portlet:namespace/>gwf_ro_metadatalabel' size='1' style='width:100%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"
			);
			//addInputfieldTo(div, "gwf_ro_embargo"  		 , "Embargo" , "" , "Provide a date until which the dataset should be under an embargo  (yyyy-mm-dd').", limitExtrageSmall		, fieldCheckList[7],"");
 			div.append(
  				"<div 											class='control-group'>"+
 					"<label 									class='control-label' 					id='gwf_ro_embargo_l'> Embargo </label>"+
 					"<p 										class='field-description'			 	id='gwf_ro_embargo_d'>Provide a date until which the dataset should be under an embargo  (yyyy-mm-dd')</p>"+
 					"<br>"+
 					"<span onmousemove='datePickler()'><input   class='field lfr-input-text-container' 	id='gwf_ro_embargo' 	type='text'   value='' onchange=\"goToNormal(\'"+fieldCheckList[7]+"\')\" maxlength='"+limitExtrageSmall  +"'></span>"+
 				"</div>"+  
				"<div 		class='control-group' >"+
					"<label class='control-label' 					id='gwf_ro_legalrequirements_l'> Legal requirements  </label>"+
					"<p 	class='field-description'			 	id='gwf_ro_embargo_d'>Select legal requirements that apply to the dataset.</p>"+
					"<div 	class='field lfr-input-text-container' 	id='gwf_ro_legalrequirements' type='text'  value=''></div>"+
				"</div>"+

				"<h3>2. Dataset Upload</h3><hr>"+
				
				//"<p   class='field-description'			 	id='gwf_ro_upload_d'></p>"+
				//"<br>"+
				"<div 													class='control-group'>"+
						"<span style='width:48%; display:inline-block' 	class='field-description'><input type='radio' id='gwf_ro_upload_direct' 	name='gwf_ro_upload_radio' value='direct' 	onclick='primaryRadioButtonCheck()' checked='checked'> Upload from your file system</input></span>"+
						"<span style='width:2%; display:inline-block'></span>"+
						"<span style='width:50%; display:inline-block' 	class='field-description'><input type='radio' id='gwf_ro_upload_external' 	name='gwf_ro_upload_radio' value='external' onclick='primaryRadioButtonCheck()'>Link online ressource</input></span> "+
				"</div>"+
				"<div id='gwf_ro_upload'  placeholder='Choose Files'></div>"+
		
				"<h3>3. Submission Options</h3><hr>"+
								
				"<div>"+
					"<div id='gwf_dcrtdatacenter'></div>"+
					"<span  style='width:25%; display:inline-block' id='gwf_b_start' onclick='submitInput()'>		<span style='width:"+buttonwidth+"' class='btn btn-success'><i class='fa fa-play' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Request submission</span></span>"+
					"<span style='width:50%; display:inline-block'></span>"+
					"<span  style='width:25%; display:inline-block' id='gwf_b_reset' onclick='resetInput()'>		<span style='width:"+buttonwidth+"' class='btn btn-primary'><i class='fa fa-refresh' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Reset all information</span></span>"+
			
				"</div>"+
				"<br>"+
 				"<div class='row' id='gwf_lf_comentarField'><div id='gwf_lf_comentar'></div></div></br>"
 					
			);
		}
	}
		
	
	//
	function buildWaitringMessage(div){
		document.getElementById("generic").style.cursor="wait";
		var commentarField = $("#".concat(div));
		commentarField.empty();
		commentarField.append("<div class='portlet-success' id='gwf_lf_comentar'>The submission process is starting. Please wait until the process is finished.</div>");
	}
	
	
	//
	function buildErrorMessage(div, error){
		document.getElementById("generic").style.cursor="default";
		var commentarField = $("#".concat(div));
		commentarField.empty();
		commentarField.append("<div class='portlet-msg-error' id='gwf_lf_comentar'>"+error+ "</div>");
	}
	
	
	//
	function datePickler(){

		
		$( "#gwf_ro_embargo" ).datepicker({
			dateFormat: "yy-mm-dd",
			changeMonth: true,
			changeYear: true

		});
		
 		var style = document.getElementById("ui-datepicker-div").style;
		style["background-color"] = "white";
		style["border"] = "1px solid #c5dbec"; 
		
		var next = document.getElementsByClassName("ui-icon ui-icon-circle-triangle-e")[0];
		//next.empty();
		next.innerHTML ='';
		next.classList.remove ('ui-icon');
		next.classList.remove ('ui-icon-circle-triangle-e');
		next.classList.add ('fa');
		next.classList.add ('fa-chevron-circle-right');
		
		var prev = document.getElementsByClassName("ui-icon ui-icon-circle-triangle-w")[0];
		//prev.empty();
		prev.innerHTML ='';
		prev.classList.remove ('ui-icon');
		prev.classList.remove ('ui-icon-circle-triangle-w');
		prev.classList.add ('fa');
		prev.classList.add ('fa-chevron-circle-left');

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
				document.getElementById("gwf_ro_author").innerHTML= obj.fullname;
 			}
 		});
 		
 		document.getElementById("gwf_ro_dct").value= "";
 		document.getElementById("gwf_ro_description").value= "";
 		document.getElementById("gwf_ro_publications").value= "";
 		document.getElementById("gwf_ro_metadatalabel").selectedIndex = 0;
 		
 		//metadata
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
					if (json.preferredbygfbio =='true')
						if (json.label == 'other')
							choMeta.append("<option id='gwf_ro_metadata"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
						else
							choMeta.append("<option id='gwf_ro_metadata"+json.id+"' value='"+json.id+"'>"+json.label+" "+json.version+"</option>");
				}
 			}
 		}); 

 		
 		//license
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
					if (json.preferredbygfbio =='true')
						if (json.label == "other")
							divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
						else if (json.label == "CC BY")
							divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"' selected=true>"+json.label+": "+json.name+" "+json.version+"</option>");
							else	
								divLi.append("<option id='gwf_ro_licenses"+json.id+"' value='"+json.id+"'>"+json.label+": "+json.name+" "+json.version+"</option>");
				}
 			}
 		});
 		
 		
 		//legal requirements
		ajaxData = {"tablename":"gfbio_legalrequirement"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){
 				var divLR = $("#".concat('gwf_ro_legalrequirements'));
 				divLR.empty();
 				divLR.append("<br>");
 				for (i=0; i < obj.length;i++){
					if (i < obj.length-1){
						var j = i+1;
						divLR.append(
							"<div 		class='control-group'>"+
								"<span style='width:48%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_legalrequirements"+obj[i].id+"' name='legalrequirements' value='"+obj[i].id+"'> "+obj[i].name+"</span>"+
								"<span style='width:2%;  display:inline-block'></span>"+
								"<span style='width:50%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_legalrequirements"+obj[j].id+"' name='legalrequirements' value='"+obj[j].id+"'> "+obj[j].name+"</span>"+
							"</div>"		
						);
						i = i+1;
					}else{
						divLR.append(
							"<div 		class='control-group'>"+
								"<span style='width:48%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_legalrequirements"+obj[i].id+"' name='legalrequirements' value='"+obj[i].id+"'> "+obj[i].name+"</span>"+
							"</div>"
						);
					}
					divLR.append("<div style='clear:left'></div>");
					
				}
 			}
		});
 		
 		
  		//primarydata
  		primaryRadioButtonCheck();
		
		//categories
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
				divKey.append("<br>");
				for (i=0; i < obj.length;i++){
					if (i < obj.length-1){
						var j = i+1;
						divKey.append(
							"<div 		class='control-group'>"+
								"<span style='width:48%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_categories"+obj[i].id+"' name='categories' value='"+obj[i].id+"'> "+obj[i].name+"</span>"+
								"<span style='width:2%; display:inline-block'></span>"+
								"<span style='width:50%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_categories"+obj[j].id+"' name='categories' value='"+obj[j].id+"'> "+obj[j].name+"</span>"+
							"</div>"		
						);
						i = i+1;
					}else{
						divKey.append(
							"<div 		class='control-group'>"+
								"<span style='width:48%; display:inline-block' class='field-description'><input type='checkbox' id='gwf_ro_categories"+obj[i].id+"' name='categories' value='"+obj[i].id+"'> "+obj[i].name+"</span>"+
							"</div>"
						);
					}
					divKey.append("<div style='clear:left'></div>");
					
				}
			} 
		});
		
		//dcrt information
		var targetDcrtDiv = 'gwf_dcrtdatacenter';
		var divDcrt = $("#".concat(targetDcrtDiv));
		divDcrt.empty();
		setToDefaultArchive(targetDcrtDiv);
	}
	
		function primaryRadioButtonCheck(){
			console.log("primaryRadioButtonCheck");
	  		var uploadDivTarget = "gwf_ro_upload";
	  		var uploaddiv = $("#".concat(uploadDivTarget));
	  		uploaddiv.empty();
	  		
			if (document.getElementById("gwf_ro_upload_direct").checked){
				var uploaddiv = $("#".concat(uploadDivTarget));
				uploaddiv.append(
						"<p   class='field-description'			 	id='gwf_ro_upload_d'>Choose your files for upload. You can select more than one file with an upload. If the file size exceeds 20 MB, please upload only representative data. Later, a data curator will assist you in uploading the entire data set.<br/><span style='font-weight:bold'>For one upload, please select all your files.</span></p>"+
					"<div  class='fileUpload btn btn-primary'  style='width:25%'>"+
					    "<span><i class='fa fa-file-text-o' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Choose files</span>"+
					    "<input id='gwf_b_upload' type='file' class='upload' onchange='showUpload()' multiple/>"+
					"</div>"+
					"<div id='gwf_ro_upload' placeholder='Choose File' /></div>"
				);
			}else{
				//addInputfieldTo(uploaddiv, "gwf_ro_externalupload_path", 	"URL", 	""				,"Provide the URL of your dataset. Please use only http, https, ftp and sftp.", 			 limitSmall, fieldCheckList[8],"");
				addInputfieldTo(uploaddiv, "gwf_ro_externalupload_path", 	"URL", 	""				,"Provide the URL of your dataset. Please use only http, https, ftp and sftp.", 			 limitSmall2, fieldCheckList[8],"");
				document.getElementById("gwf_ro_externalupload_path").placeholder = "http://"; //placeholder="First name
				console.log(document.getElementById("gwf_ro_externalupload_path"));
			} 
			uploaddiv.append("<span id='gwf_b_upload_inputarea'></span>");
		}

	function setToDefaultArchive(targetDiv){
		var divDcrt = $("#".concat(targetDiv));
		divDcrt.empty();
		divDcrt.append(	"<div 		class='control-group'>");
		if (document.getElementById("gwf_dcrtassignee").innerHTML!='null'){
			divDcrt.append("<p class='field-description' id='gwf_ro_dcrt_d'>With the start of submission you will send your information to the curator of "+document.getElementById("gwf_dcrtassignee").innerHTML+". A contact person will get in touch with you as soon as possible. This curator will suport you through the rest of submission process.</p>");
		}else{
			divDcrt.append("<p class='field-description' id='gwf_ro_dcrt_d'>With the start of submission you will send your information to the GFBio curator team. A contact person will get in touch with you as soon as possible. This curator will suport you through the rest of submission process.</p>");
		}
		divDcrt.append(	"</div><br><br><br>");

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
			var ajaxData = [{"researchobjectid":Number(data.researchobjectid), "kindofresponse":"extended"}];
	 		$.ajax({
				"type" : "POST",
				"url": url.concat('/WorkflowGenericPortlet'),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(ajaxData),
					"<portlet:namespace />responseTarget" : "getresearchobjectbyid"
				},
				async: false,
	 			success :  function (obj){
					var json = obj[0];
					if (json.extendeddata != "")
						var ed = json.extendeddata;
					else
						var ed = "[]";					
					for (i=0;i<ed.length/2;i++){
						ed = ed.replace("'",'"');
					}
					var extendeddata = ed;

					document.getElementById("gwf_ro_id").innerHTML= json.researchobjectid;
					document.getElementById("gwf_ro_version").innerHTML= json.researchobjectversion;
					document.getElementById("gwf_ro_name").value= json.name;
					countChars('gwf_ro_name', 'gwf_ro_name_c', limitSmall);
					document.getElementById("gwf_ro_label").value= json.label;
					countChars('gwf_ro_label', 'gwf_ro_label_c', limitSmall);

					//datacolectiontime
					if (extendeddata.datacollectiontime !=null)
						document.getElementById("gwf_ro_dct").value= extendeddata.datacollectiontime;
					else
						document.getElementById("gwf_ro_dct").value= "";
					countChars('gwf_ro_dct', 'gwf_ro_dct_c', limitLarge);

					//description
					document.getElementById("gwf_ro_description").value= json.description;
					countChars('gwf_ro_description', 'gwf_ro_description_c', limitExtrageLarge);
					
					//metadata
					if (json.hasOwnProperty('metadataid')) {
						var metadataJson = JSON.parse(json.metadataid);
						document.getElementById("gwf_ro_metadatalabel").value= metadataJson;
					}
					
					//author
					if (json.authorname != null && json.authorname.length !=0){
						var author ="";
						for (i=0;i<json.authorname.length;i++)
							author = author + json.authorname[i]+"\n";
		
						document.getElementById("gwf_ro_author").innerHTML= author;
					}else
						document.getElementById("gwf_ro_author").innerHTML= "";
					countChars('gwf_ro_author', 'gwf_ro_author_c', limitLarge);

					
					//category
					if (json.categoryids !=null && json.categoryids!="")
						for (i =0; i < json.categoryids.length;i++)
							document.getElementById("gwf_ro_categories"+json.categoryids[i]).checked  =true;
					
					//publications
					if (extendeddata.publications !=null)
						document.getElementById("gwf_ro_publications").value= extendeddata.publications;
					else
						document.getElementById("gwf_ro_publications").value= "";
					countChars('gwf_ro_publications', 'gwf_ro_publications_c', limitLarge);
					
					//embargo
					if (extendeddata.embargo !=null)
						document.getElementById("gwf_ro_embargo").value= extendeddata.embargo;
					else
						document.getElementById("gwf_ro_embargo").value= "";

					//legal requirements
					if (extendeddata.legalrequirements !=null && extendeddata.legalrequirements!="")
						for (i =0; i < extendeddata.legalrequirements.length;i++)
							if (extendeddata.legalrequirements[i]=="Nagoya")
								document.getElementById("gwf_ro_legalrequirements_nagoya").checked  =true;
							else
								if (extendeddata.legalrequirements[i]=="Red List")
									document.getElementById("gwf_ro_legalrequirements_red").checked  =true;
								else
									if (extendeddata.legalrequirements[i]=="Personal")
										document.getElementById("gwf_ro_legalrequirements_personal").checked  =true;
									else
										if (extendeddata.legalrequirements[i]=="Uncertain")
											document.getElementById("gwf_ro_legalrequirements_uncertain").checked  =true;
					
					//license
					if (json.hasOwnProperty('licenseid')) {
						var licenseid = JSON.parse(json.licenseid);
						document.getElementById("gwf_ro_licenselabel").value =licenseid;
					}

					//primarydata
					if (json.primarydata !=null && json.primarydata.length!=0){
				    	var nameList = "";
				    	nameList = nameList + '<ul>';
					    for (i =0; i < json.primarydata.length;i++)
					    	nameList = nameList +"<li><span id='gwf_ro_upload"+json.primarydata[i].name+"'>"+json.primarydata[i].name+ "</span></li>";
					    nameList = nameList + '</ul>';

					    document.getElementById("gwf_ro_upload").innerHTML = nameList;
					}

	 			},
				error :  function (obj){
					console.log("error");
					console.log(obj);
				}
				
	 		});
		}
	}
	

	//
	function goToNormal(block){
		if(document.getElementById("gwf_lf_comentar").className == 'portlet-msg-error'){
			document.getElementById(block+"_l").className="control-label";
			document.getElementById(block+"_d").className="field-description";
			var testfield = $("#".concat("gwf_lf_comentarField"));
			if (block == fieldCheckList[0] || block == fieldCheckList[4] || block == fieldCheckList[5] || block == fieldCheckList[6] || block == fieldCheckList[7]|| block == fieldCheckList[8]){
				document.getElementById(block).className = 'field lfr-input-text-container';
				document.getElementById(block).style = 'width: 100%';
			}else
				if (block == fieldCheckList[1]|| block == fieldCheckList[2])
					document.getElementById(block).style = 'width: 100%';
				else
					if (block == fieldCheckList[3])
						document.getElementById(block+"label").style = 'width: 100%';
			check = true
			for (i =0;i<fieldCheckList.length;i++){
				if(document.getElementById(fieldCheckList[i]+"_l").className == 'labelFalse'){
					check = false;
				}
			}
			if(check){
				var commentarField = $("#".concat("gwf_lf_comentarField"));
				commentarField.empty();
				commentarField.append("<div id='gwf_lf_comentar'></div>");
			}
				
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

		console.log(data);
		
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
				
				if (!obj.hasOwnProperty("ERROR"))
					buildWaitringMessage('gwf_lf_comentarField');
				else
					buildErrorMessage('gwf_lf_comentarField', 'The Submission information transfer was stopped because there is already a submission of this data set, with the same version on this workflow.');
					
			}		
		});	
	}
	
	

	
	
	////////////////////////////////////////////////////////////////// upload 
	
	
	//
	function fileUplaod(){

		if (document.getElementById("gwf_ro_upload_direct").checked){
			var url = document.getElementById('workflowgenericurl').value;
			var formData = new FormData();
		    var uploadInformation = new File(['{"researchobjectid":'+Number(document.getElementById('gwf_ro_id').innerHTML)+',"researchobjectversion":'+Number(document.getElementById('gwf_ro_version').innerHTML)+',"userid":'+Number(document.getElementById('gwf_user_id').innerHTML) +'}'], "uploadInformation.txt");
	
			formData.append('file', uploadInformation);
						var fileSelect = document.getElementById('gwf_b_upload');
			
			var files = fileSelect.files;
			var check = true; 
			var file_size_total = 0;
			
			//only a total file size of 20MB is permitted
			for (var i = 0; i < files.length; i++){
				file_size_total = file_size_total + files[i].size;
				
				if (file_size_total >= 20971520){
			  		document.getElementById("gwf_ro_upload"+files[i].name).className="labelFalse";
			  		check = false;
			  	}
			}
			if (check==true){
			
				for (var i = 0; i < files.length; i++)
				  	formData.append('file', files[i]);
		
		 		$.ajax({
		 			"url": url.concat('/WorkflowCollectionsPortlet'),
		 			"type" : "POST",
					processData: false,
					contentType: false,
					"data" : formData,
					async: false,
					success :  function (){
						buildWaitringMessage('gwf_lf_comentarField');
					} 
				});
			}else{
				document.getElementById("gwf_ro_upload_d").className="labelFalse";
				buildErrorMessage('gwf_lf_comentarField', 'You exceeded the total upload size of 20 MB. Please provide a link to an online resource or contact our helpdesk.');
			}
		}else{
			if (document.getElementById("gwf_ro_externalupload").value.length !=0){
				
				var data ="";
				
				$.ajax({
					"type" : "POST",
					"url": url.concat('/WorkflowCollectionsPortlet'),
					"data" : {
						"<portlet:namespace />data" : JSON.stringify(data),
						"<portlet:namespace />responseTarget" : "createExternalUpload"
					},
					async: false,
					success :  function (obj){
						buildWaitringMessage('gwf_lf_comentarField');
					}		
				});	
				
			}
		}
	}
	
	
	//
	function showUpload(){
		/*
						"<p   class='field-description'			 	id='gwf_ro_upload_d'>Choose your files for upload. You can select more than one file with an upload. If the file size exceeds 20 MB, please upload only representative data. Later, a data curator will assist you in uploading the entire data set.</p>"+
				"<div  class='fileUpload btn btn-primary'  style='width:25%'>"+
				    "<span><i class='fa fa-file-text-o' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Choose file</span>"+
				    "<input id='gwf_b_upload' type='file' class='upload' onchange='showUpload()' multiple/>"+
				"</div>"+
				"<div id='gwf_ro_upload' placeholder='Choose File' /></div>"
		*/
		if(document.getElementById("gwf_lf_comentar").className == 'portlet-msg-error'){
		
			document.getElementById("gwf_ro_id").innerHTML= 0;
			document.getElementById("gwf_ro_version").innerHTML= 1;
			document.getElementById("gwf_ro_upload_d").className='field-description';
			var commentarField = $("#".concat("gwf_lf_comentarField"));
			commentarField.empty();
			commentarField.append("<div id='gwf_lf_comentar'></div>");
		}
		
		var nameList = "";
	    var bttn = $("#".concat('gwf_b_upload'));
	    var fileList = bttn[0].files;
	    if (fileList.length>0){
	    	nameList = nameList + '<ul>';
		    for (i =0; i < fileList.length;i++)
		    	nameList = nameList +"<li><span id='gwf_ro_upload"+fileList[i].name+"'>"+fileList[i].name+ "</span></li>";
		    nameList = nameList + '</ul>';
		}
	    document.getElementById("gwf_b_upload_inputarea").innerHTML = nameList;
	}
	
	
	//////////////////////////////////////////////////////////////////////////// submission
	
	
	//
	function startSubmission(data){
			
		var url = document.getElementById('workflowgenericurl').value;
		data["path"]= document.getElementById("gwf_user_path").innerHTML;
		
		var responseData ={};
		responseData["researchobjectid"]= data.mrr.researchobjects.researchobjectid;
		responseData["researchobjectversion"]= data.mrr.researchobjects.researchobjectversion;
		responseData["archive"]= "GFBio collections";
		
		//
		if (document.getElementById("gwf_dcrtassignee").innerHTML!='null'){
			responseData["archive"]= document.getElementById("gwf_dcrtassignee").innerHTML;
			console.log(responseData["archive"]);
		}
		//
		
  		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "startsubmission"
			},
			async: false,
			success :  function (obj){
				console.log('this is object returned');
				console.log(obj);
				
				if(obj &&  obj.key )
				{

					document.getElementById("generic").style.cursor="default";
					var brokerSubmissionId = getBrokerSubmissionId(responseData);
					
					sentShowHideInformation(false);
					var div =   $("#generic");
					div.empty();
					div.append(
						"<div class='portlet-success'>"+
							"The submission information has been sent to the data curators of collections. One of them will contact you shortly. <br> <br>"+
							"Your submission ID is: "+brokerSubmissionId+"<br><br>"+
							"Via our Help Center, you can follow the submission process under <a href='https://helpdesk.gfbio.org/servicedesk/customer/portal/2/"+obj.key+"' style='color:darkblue; font-weight:bold'><i aria-hidden='true' class='fa fa-external-link' style='font-size:12px;'>&nbsp;</i>"+obj.key+"</a>"+
						"</div>"+
						"<span class='widthM' id='gwf_b_reset' onclick='restartInput()'>		<span class='btn btn-primary'>Start new Submission</span></span>"
					);
				}
				else
				{
					
					console.log("sub error");
					deleteSubmissionRegistryEntry(responseData);
					buildErrorMessage('gwf_lf_comentarField', "The Submission information transfer failed. Please contact our technical support via our <a href='/contact' style='color:darkred; font-weight: bold'> contact form</a>.");
				}	
			
			},
			error :  function (obj){
				console.log("sub error");
				deleteSubmissionRegistryEntry(responseData);
				buildErrorMessage('gwf_lf_comentarField', "The Submission information transfer failed. Please contact our technical support via our <a href='/contact' style='color:darkred; font-weight: bold'> contact form</a>.");
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
			}
	
		});	 
	}
	
	
	function resetDCRTInput(){

		var url = document.getElementById('workflowgenericurl').value;

		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />responseTarget" : "resetportletsession"
			},
			async: false,
			success :  function (obj){
				document.getElementById("gwf_dcrtassignee").innerHTML = "null";
				document.getElementById("gwf_dcrtinput").innerHTML = "";
				document.getElementById("gwf_dcrtrecommendation").innerHTML = "";
			},
			error :  function (obj){
				console.log("error");
			}
		});
	}
	
	
	function getBrokerSubmissionId(data){
		
		var brokerSubmissionId ="";
		var url = document.getElementById('workflowgenericurl').value;
		//
		console.log("input data for getting broker Sub");
		console.log(data);
		//
		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : "getbrokersubmissionid"
			},
			async: false,
			success :  function (obj){
				brokerSubmissionId = obj.brokersubmissionid;
				//
				console.log("This is brokerSubmissionId");
				console.log(brokerSubmissionId);
				//
			}
		});	 
		return brokerSubmissionId;
	}
	
	//
/* 	function sentToBroker(data){
			
		var url = "https://c103-171.cloud.gwdg.de/api/submissions/generic";
		
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
	} */

</script>
