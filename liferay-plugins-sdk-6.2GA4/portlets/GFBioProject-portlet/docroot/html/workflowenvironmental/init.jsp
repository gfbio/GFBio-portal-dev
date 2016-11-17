<script>


	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////

			 
	//Message from Hide Managment
	AUI().ready(function(A){ 
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			
			var div =   $("#environmental");
			
			if (data.projectid==0){
				fillDefaultInformations(data, div);
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
	
		
	/////////////////////////////////////////   build funtions  //////////////////////////////////////////////
	

 	//build default collection workflow without project or researchobject data
	AUI().ready(function(A){
		console.log("todo");
 		var div =   $("#environmental");
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildEnvironmentalForm(data, div);
		fillDefaultInformations(data, div); 
	}); 

	

/* 	**: automatic
	* : manditory
	-	Project **: PANGAEA Data Archiving & Publication 
	-	Issue Type**: Data Submission Data Submission 
	X	Summary* : Data submission 2016-07-07T08:22:38Z (Marcel Frömming, Uni Jena)
	X	Atuhor(s)* : Frömming, Marcel
	X	Title: 
	X	Description: 
	/	Keywords:
		Attachment
	X	License: CC...
		Labels: Begin typing to find and create labels or press down to select a suggested label. Context of the data submission, e.g. PROJECT, institute, etc. Labels have to be one word!
	X	Data used/published in the following article/manuscript: 

 */
	
	//
	function buildEnvironmentalForm(data, div){
		
		if (data.userid != 0){

			div.append(
				"<h2>Submission of Environmental data</h2>"+
				"</br>"+
				"<h3>Project Informations</h3>"+
				"</br>"+
				"<h4>Basic Informations</h4>"+
				"</br>"+
				
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_id_l'> project id </div>"+
					"<div class='rowField' id='cwf_project_id'></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_name_l'> project title </div>"+
					"<div class='rowField'><input type='text' id='cwf_project_name' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_label_l'> project label </br>(like abbreviation of DFG )</div>"+
					"<div class='rowField'><input type='text' id='cwf_project_label' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_authors_l'> authors</div>"+
					"<div class='rowField'><input type='text' id='cwf_project_authors' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_description_l'> project abstract </div>"+
					"<div class='rowField'><textarea rows='5' id='cwf_project_description'></textarea></div>"+
				"</div>"+
				
				"</br>"+
				"<h4>Optional Keywords</h4>"+
				"<div id='cwf_project_keywords'></div>"+
				
				"<h3>DataSet Informations</h3>"+

				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_publications_l'> related publications </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_publications' value=''></div>"+
				"</div>"+
			
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_pd_id_l'> file id </div>"+
					"<div class='rowField' id='cwf_pd_id'></div>"+
				"</div>"+
				
				"<div class='row'>"+
				"<div class='rowLato' id='cwf_ro_morinformations_l'> further information </div>"+
				"<div class='rowField'><input type='text' id='cwf_ro_morinformation' value=''></div>"+
			"</div>"+
				
				"</br>"+				
				"<h4>Licence Information of Dataset</h4>"+
				"</br>"+	
				
				"<div class='row'>Please select the appropriate licenses </div>"+
				"<div id='cwf_ro_licenses'></div>"+
						
				"</br>"+
				"<div class='row' id='cwf_lf_comentarField'>"+
				"</div>"+
				"</br>"+
				
				"<div class='row'>"+
					"<span class='widthM' id='cwf_b_save' 		onclick='saveProjectInput()' >	<span class='btn btn-primary'>Save only project informations</span></span>"+
					"<span class='widthM' id='cwf_b_save' 		onclick='saveAllInput()' >		<span class='btn btn-primary'>Save all informations</span></span>"+
					"<span class='widthM' id='cwf_b_validate' 	onclick='checkInput()' >		<span class='btn btn-primary'>Checking for completeness</span></span>"+
					"<span class='widthM' id='cwf_b_start' 		onclick='submitInput()' >		<span class='btn btn-primary'>Start submission</span></span>"+
				"</div>"
			);
		}
	}
	
	
	//default fill function of collections submission workflow
	function fillDefaultInformations(data, div){
		fillDefaultProjectInformations(data, div);
		//fillDefaultSubmitterInformations(data, div);
		fillDefaultResearchObjectInformations(data, div);
	}
	
	
	//default fill function of collections submission workflow
	function fillDefaultProjectInformations(data, div){

		var url = document.getElementById('workflowenvironmentalurl').value;
		var ajaxData = {"relationtablename":"gfbio_category_type","entitytablename":"gfbio_type", "entitytablecellcontent":"research field"}

		document.getElementById("cwf_project_id").innerHTML= 0;
		document.getElementById("cwf_project_name").value= "";
		document.getElementById("cwf_project_label").value= "";
		document.getElementById("cwf_project_description").value= "";
		
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowPangaeaPortlet'),
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
							"<div class='row'>"+
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
							"<div class='row'>"+
								"<div class='rowLato'>"+
									"<input type='checkbox' id='cwf_project_keywords"+obj[i].id+"' name='keywords' value='"+obj[i].id+"'> "+obj[i].name+
								"</div>"+
							"</div>"
						);
					}
				}
			} 
		}); 
	
	}
	
			
	//
	function fillDefaultResearchObjectInformations(data, div){
	
		var url = document.getElementById('workflowenvironmentalurl').value;
	
 		document.getElementById("cwf_ro_publications").value= "";
 		document.getElementById("cwf_pd_id").innerHTML= 0;
		
		ajaxData = {"tablename":"gfbio_license"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowPangaeaPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gettablebyname"
			},
			async: false,
 			success :  function (obj){
				var divLi = $("#".concat('cwf_ro_licenses'));
				divLi.empty();
				for (i=0; i < obj.length;i++)
					divLi.append(
						"<div class='row'>"+
								"<input type='checkbox' id='cwf_ro_licenses"+obj[i].id+"' name='licenses' value='"+obj[i].id+"'> "+obj[i].name+
						"</div>"
					);		
 			}
 		});
			
	}
	
	/* 
	
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
					var json = JSON.parse(obj.categoryid);
					for (i=0;i<json.length;i++)
						document.getElementById("cwf_project_keywords"+json[i]).checked= "checked";
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
					
					

					if (extendeddata.nagoja !=null){
						if (extendeddata.nagoja == "no"){
							document.getElementById("cwf_ro_nagojano").checked = true;
						}else{
							document.getElementById("cwf_ro_nagojayes").checked = true;
							document.getElementById("cwf_ro_nagojayes").value =extendeddata.nagoja;
						}
					}else{
						document.getElementById("cwf_ro_nagojano").checked = true;
					}
					
					var licenseJson = JSON.parse(json.licenseid);
					for (i=0;i<licenseJson.length;i++)
						document.getElementById("cwf_ro_licenses"+licenseJson[i]).checked= "checked";

	 			}
	 		});
		}
		
		
	} */
	

	
	
</script>