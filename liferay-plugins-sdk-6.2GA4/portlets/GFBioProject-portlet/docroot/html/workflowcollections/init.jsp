<script>


	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////

		
	//Message from Hide Managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.archiving.submit', function(data) {
			var div =   $("#collections");
			if (data == undefined || !(data.hidecode==="collections")){
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
	
	
	//
	function buildCollectionsForm(data, div){
		
		
		if (data.userid != 0){

			div.append(
				"<h2>submission of collection data</h2>"+
				"</br>"+
				"<h3>project informations</h3>"+
				"</br>"+
				"<h4>basic informations</h4>"+
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
					"<div class='rowLato' id='cwf_project_pi_l'> project PI / responsible person</div>"+
					"<div class='rowField'><input type='text' id='cwf_project_pi' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_project_description_l'> project abstract </div>"+
					"<div class='rowField'><textarea rows='5' id='cwf_project_description'></textarea></div>"+
				"</div>"+
				
				"</br>"+
				"<h4>optional keywords</h4>"+
				"<div id='cwf_project_keywords'></div>"+
				"<h3>submitter information</h3>"+
				"</br>"+
				
				"<div class='row'>"+
					"<div class='rowLato' > submitter / user id </div>"+
					"<div class='rowField' id='cwf_user_id'></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato'> submitter / user name </div>"+
					"<div class='rowField' id='cwf_user_name' ></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato'> submitter / user mail </div>"+
					"<div class='rowField' id='cwf_user_mail' ></div>"+
				"</div>"+
				
				"</br>"+
				"<h3>dataset information</h3>"+
				"</br>"+
				"<h4>basic informations</h4>"+
				"</br>"+
				
				"<div class='row'>"+
					"<div class='rowLato' > dataset id </div>"+
					"<div class='rowField' id='cwf_ro_id'></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato'> dataset version </div>"+
					"<div class='rowField' id='cwf_ro_version'></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_name_l'> dataset title </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_name' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_label_l'> dataset label </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_label' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_author_l'> dataset author </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_author' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_dct_l'> data collection time </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_dct' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_description_l'> dataset description </div>"+
					"<div class='rowField'><textarea rows='5' id='cwf_ro_description'></textarea></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_publications_l'> related publications </div>"+
					"<div class='rowField'><input type='text' id='cwf_ro_publications' value=''></div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_metadatalabel_l'> metadata shema / data type  </div>"+
					"<div class='rowField'>"+
						"<form action='select.html'>"+
							"<select id='cwf_ro_metadatalabel' name='<portlet:namespace/>cwf_ro_metadatalabel' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_pd_id_l'> file id </div>"+
					"<div class='rowField' id='cwf_pd_id'></div>"+
				"</div>"+
				
				"</br>"+				
				"<h4>licence information of dataset</h4>"+
				"</br>"+	
				
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_nagoja_l'> dataset is subject to the Nagoja Protocol? </div>"+
					"<div class='rowFieldB'>"+
					 	"<fieldset>"+ 
							"<input type='radio' id='cwf_ro_nagojayes' name='cwf_ro_nagoja' value='yes'>	<label for='cwf_ro_nagojayes'> yes</label>"+ 
							"<input type='radio' id='cwf_ro_nagojano'  name='cwf_ro_nagoja' value='no'>		<label for='cwf_ro_nagojano' > no </label>"+ 
						"</fieldset>"+
					"</div>"+
					"<div class='rowInput' id='cwf_ro_nagojadiv'></div>"+
				"</div>"+
				
				"<div class='row'>"+
					"<div class='rowLato' id='cwf_ro_license_l'> licence </div>"+
					"<div class='rowField'>"+
						"<form action='select.html'>"+
							"<select id='cwf_ro_license' name='<portlet:namespace/>cwf_ro_license' size='1' style='width:90%'>"+
								"<option value='none'></option>"+
							"</select>"+
						"</form>"+
					"</div>"+
				"</div>"+

				
				"</br>"+
				"<div class='row' id='cwf_lf_comentarField'>"+
				"</div>"+
				"</br>"+
				
				"<div class='row'>"+
					"<input type='button' class='widthM' id='cwf_b_save'  		value='save only project informations'	onclick='saveProjectInput()'>"+
					"<input type='button' class='widthM' id='cwf_b_save'  		value='save all' 			 			onclick='saveAllInput()'>"+
					"<input type='button' class='widthM' id='cwf_b_validate'  	value='Checking for completeness' 		onclick='checkInput()'>"+
					"<input type='button' class='widthM' id='cwf_b_start' 		value='start submission' 				onclick='submitInput()'>"+
				"</div>"
			);
		}
		document.getElementById("cwf_ro_nagojayes").onclick = function() {
			var radioNagoja = $("#".concat('cwf_ro_nagojadiv'));
			radioNagoja.empty();
			radioNagoja.append("<input type='text' id='cwf_ro_nagojadetails' value=''>");
		};
		document.getElementById("cwf_ro_nagojano").onclick = function() {
			var radioNagoja = $("#".concat('cwf_ro_nagojadiv'));
			radioNagoja.empty();
			
		};
	}
	
	
	//default fill function of collections submission workflow
	function fillDefaultInformations(data, div){

		document.getElementById("cwf_project_id").innerHTML= 0;
		
		Liferay.Service('/GFBioProject-portlet.content/get-row-informations-of-relationships-of-specific-cell-content',
			{
				requestJson: {"relationtablename":"gfbio_category_type","entitytablename":"gfbio_type", "entitytablecellcontent":"research field"}
			},
			function(obj) {
				var divKey = $("#".concat('cwf_project_keywords'));
				divKey.empty();
				//divKey.append("<form id='cwf_project_keywords_form'>");
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
				//divKey.append("</form>");
			}
		);
		
		Liferay.Service('/GFBioProject-portlet.userextension/get-user-by-id',
			{
				json: {"userid":data.userid}
			},
			function(obj) {
				document.getElementById("cwf_user_id").innerHTML= data.userid;
				document.getElementById("cwf_user_name").innerHTML= obj.fullname;
				document.getElementById("cwf_user_mail").innerHTML= obj.emailaddress;
				document.getElementById("cwf_ro_author").value= obj.fullname.concat(",");
			}
		);
		
		document.getElementById("cwf_ro_id").innerHTML= 0;
		document.getElementById("cwf_ro_version").innerHTML= 1;
		
		
		Liferay.Service('/GFBioProject-portlet.head/get-table-as-json-array-by-name',
				{
					requestJson: {"tablename":"gfbio_metadata"}
				},
				function(obj) {
					var choMeta = $("#".concat('cwf_ro_metadatalabel'));
					choMeta.empty();
					choMeta.append("<option value='none'></option>");
					for (i =0; i <obj.length;i++){
						var json = obj[i];
						choMeta.append("<option id='cwf_ro_metadatalabel"+json.id+"' value='"+json.id+"'>"+json.label+"</option>");
					}
						
					choMeta.append("<option value='other'>other</option>");
				}
			);
		
		document.getElementById("cwf_pd_id").innerHTML= 0;
		
		
		
		Liferay.Service('/GFBioProject-portlet.head/get-table-as-json-array-by-name',
			{
				requestJson: {"tablename":"gfbio_license"}
			},
			function(obj) {
				var choLi = $("#".concat('cwf_ro_license'));
				choLi.empty();
				choLi.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					choLi.append("<option id='cwf_ro_license"+json.id+"' value='"+json.id+"'>"+json.name+"</option>");
				}
					
				//choLi.append("<option value='other'>other</option>");
			}
		);
		
		


	}
	
	
	//default fill function of collections submission workflow
	function fillProjectInformations(data, div){

/* 		var workflowcollectionsURL = (document.getElementById("workflowcollectionsurl").value).toString();
		var url = workflowcollectionsURL.concat("/GFBioSubmissionWorkflow")
		console.log("++"+ document.getElementById("workflowcollectionsurl"));
		console.log("+++"+ document.getElementById("workflowcollectionsurl").value);
		console.log("++++"+workflowcollectionsURL.concat("/GFBioSubmissionWorkflow"));
		console.log("+++++");
		var method = "getproject"; 
		$.ajax({
			"type" : "POST",
			"url": url,
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: false,
			success : function (data){
				console.log("!! "+data);
				document.getElementById("cwf_ro_id").innerHTML= 0;
			}
		}); */
		Liferay.Service('/GFBioProject-portlet.project/get-project-by-id',
			{
				requestJson: {"projectid": Number(data.projectid)}
			},
			function(obj) 
			{	
				document.getElementById("cwf_project_id").innerHTML= obj.projectid;
				document.getElementById("cwf_project_name").value= obj.name;
				document.getElementById("cwf_project_label").value= obj.label;
				document.getElementById("cwf_project_description").value= obj.description;
				
				var json = JSON.parse(obj.categoryid);
				for (i=0;i<json.length;i++)
					document.getElementById("cwf_project_keywords"+json[i]).checked= "checked";
			}
		);
		
		Liferay.Service('/GFBioProject-portlet.project/get-full-names-as-string',
			{
				projectId: Number(data.projectid)
			},
			function(obj) {
				document.getElementById("cwf_project_pi").value= obj;
			}
		);
	}
	
	
	//
	function fillResearchObjectInformations(data, div){
		//console.log(data);

		Liferay.Service('/GFBioProject-portlet.researchobject/get-research-object-by-id',
				  {
				    requestJson: '[{"researchobjectid":'+Number(data.researchobjectid)+'}]'
				  },
				function(obj) {
					  console.log(obj);
					var json = obj[0];
					var ed = json.extendeddata;
					for (i=0;i<ed.length/2;i++)
						ed = ed.replace("'",'"');
					var extendeddata = JSON.parse(ed);
					var author = (json.authorname).substring(1, (json.authorname.length)-1);
					for (i=0;i<author.length/2;i++)
						author = author.replace('"','');

					document.getElementById("cwf_ro_id").innerHTML= json.researchobjectid;
					document.getElementById("cwf_ro_version").innerHTML= json.researchobjectversion;
					document.getElementById("cwf_ro_name").value= json.name;
					document.getElementById("cwf_ro_label").value= json.label;
					document.getElementById("cwf_ro_dct").value= extendeddata.datacollectiontime;
					document.getElementById("cwf_ro_description").value= json.description;
					document.getElementById("cwf_ro_metadatalabel"+json.metadataid).selected= true;
					document.getElementById("cwf_ro_author").value= author;
					document.getElementById("cwf_ro_publications").value= extendeddata.publications;
					document.getElementById("cwf_ro_license"+json.licenseid).selected= true;

				}
			);
	}
	

	
	
</script>