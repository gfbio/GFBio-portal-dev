<script>

	/////////////////////////////////////////   portlet java communication  //////////////////////////////////////////////
	
		
	//
	function ajaxActionRequest_ChooseResearchObject(archivingURL, method, data, divId, as) {
		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success :  function (data){
				buildResearchObject(data, divId) 
			}
		});
	}
	
	
	//
	function ajaxActionRequest_ChooseProjProProject(archivingURL, method, data, divId, as) {
			$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function (data){
				buildProject(data, divId) ;
			}
		});
	}
	
	
/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////
	
	
	//Message from hide managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.submissionmanager.hidemanagment', function(data) {
		
			if (data == undefined){}
			else{
				var projectProfile =   $("#projectProfile");
				projectProfile.attr("class", data.view);			
			}
		});
	});
	
	
	//Message from Submission Manager
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.submissionmanager.projectprofile', function(data) {
			
			if (data == undefined){}
			else{
				visibleHide('choPro');
				buildProject(data.details[0], 'projectProfileProject');
				var projectProfile =   $("#projectProfile");
				projectProfile.attr("class", "swMain");	
				
			}
		});
	});
	

	
	
	
	
	
	
/////////////////////////////////////////   build funtions  //////////////////////////////////////////////
	
	
	function buildProject(data, divId){
	
		if (data.researchobjects == undefined){
			var roList = [];
		}else{
			var roList = data.researchobjects;
		}

		var div =   $("#".concat(divId));
		div.empty();
		
		if (data.projectid !=0){
			
			div.append(
				
				"<h3> basic data </h3>"+
				
					"<div class='row'>"+
						"<div class='rowLato'> GFBio ID of this project</div>"+
						"<div class='rowField'>" + data.projectid + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> name</div>"+
						"<div class='rowField'>" + data.name + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> label</div>"+
						"<div class='rowField'>" + data.label + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> description</div>"+
						"<div class='rowField'>" + data.description + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> start date</div>"+
						"<div class='rowField'>" + data.startdate + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> end date </div>"+
						"<div class='rowField'>" + data.enddate + "</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='rowLato'> status</div>"+
						"<div class='rowField'>" + data.status + "</div>"+
					"</div>"+
				
				"<h3> extended data </h3>"+
				
					"<div class='row'>"+
						"<div class='rowLato'> [ToDo]</div>"+
						"<div class='rowField'>" + data.extendeddata + "</div>"+
					"</div>"+
				
				"<h3> relations to research projects </h3>"+
					
					"<div class='row'>"+
						"<div class='rowLato'> [ToDo]</div>"+
					"</div>"+	
					
				"<h3> policy </h3>"+
				
					"<div class='row'>"+
						"<div class='rowLato'> [ToDo]</div>"+
					"</div>"+
				
				"<h3> categories </h3>"+
					
					"<div class='row'>"+
						"<div class='rowLato'> [ToDo]</div>"+
					"</div>"+
				
				"<h3> Research Object </h3>"+
					
					"<form action='select.html'>"+
						"<select id='projectProfileChooseRO' name='<portlet:namespace/>projectProfileChooseRO' size='1' style='width:50%'>"+
							"<option selected value='none'>None </option>"+
						"</select>"+
					"</form>"+
					
					"<div id='projectProfileRO'>"+
					"</div>"
			);

			var choRO = $("#".concat('projectProfileChooseRO'));
			for (i =0; i <roList.length;i++){
				choRO.append("<option value='"+roList[i].researchobjectid+"'>"+roList[i].name+" Version: "+ +roList[i].researchobjectversion+"</option>");
			}
			choRO.on('change', function(){
				var method = 'chooseRO';
				var researchobjectId = this.form.projectProfileChooseRO.options[this.form.projectProfileChooseRO.selectedIndex].value;
				var divId = 'projectProfileRO';
				chooseROX(method, researchobjectId, divId);
			});
		}
	}

	
	
	//
	function buildResearchObject(data, divId){
		
			var div =   $("#".concat(divId));
			div.empty();
			
				if (data.researchobjectid !=0){
					div.append(
							"<h4> basic data </h4>"+
							

								"<div class='row'>"+
									"<div class='rowLato'> GFBio ID of this research object</div>"+
									"<div class='rowField'>" + data.researchobjectid + "</div>"+
								"</div>"+
								"<div class='row'>"+
									"<div class='rowLato'> name</div>"+
									"<div class='rowField'>" + data.name + "</div>"+
								"</div>"+
									
	 							"<div class='row'>"+
									"<div class='rowLato'> label</div>"+
									"<div class='rowField'>" + data.label + "</div>"+
								"</div>"+
								
	 							"<div class='row'>"+
									"<div class='rowLato'> version</div>"+
									"<div class='rowField'>" + data.researchobjectversion + "</div>"+
								"</div>"+
								
	 						"<h4> extended data </h4>"+
	 							
							"<div class='row'>"+
								"<div class='rowLato'> type of metadata</div>"+
								"<div class='rowField'>" + data.researchobjecttype + "</div>"+
							"</div>"+
	 						
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
									"<div class='rowField'>" + data.extendeddata + "</div>"+
								"</div>"+
								
							"<h4> relations to research objects </h4>"+
									
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"+	
								
							"<h4> policy </h4>"+
								
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"+
								
							"<h4> license </h4>"+
								
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"+
							
							"<h4> categories </h4>"+
								
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"+
								
							"<h4> example data </h4>"+
								
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"+
							
							"<h4> submission package leaflet information </h4>"+
								
								"<div class='row'>"+
									"<div class='rowLato'> [ToDo]</div>"+
								"</div>"
									
					);
					//Submissionregistry
					createSubmissionRegistry(data.researchobjectid, divId);
				}
	}





</script>