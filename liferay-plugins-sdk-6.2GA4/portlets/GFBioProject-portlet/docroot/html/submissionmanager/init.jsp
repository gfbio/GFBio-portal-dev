<script>
	////////////////////////////////////////////   ActionRequest  ////////////////////////////////////////////
	
	
	//----------------------------------------   Choose & Create  -----------------------------------------//

	var changeProjectId ="suma_changeProject";
	var changeROId ="suma_changeRO";
	var dataSubmissionId = "suma_dataSubmission";
	var dcrtId = "suma_DCRT";
	var managmentPlanId = "suma_managmentPlan";
	var newProjectId ="suma_newProject";
	var newROId ="suma_newRO";
	var projectProfileId ="suma_projectProfile";
	var submissionRegistryId ="suma_submissionRegistry";
	var uploadFileId ="suma_uploadFile";




	//
	function ajaxActionRequest_suma_ChooseProject(archivingURL, method, data, id, as) {
			$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioSubmissionManager"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function (data){
				buildWithProject (data); 
			}
		});
	}
	
	
	//
	function buildWithProject(data){

		var changeProject 		= $("#"+changeProjectId);
		var changeRO 			= $("#"+changeROId);
		var dataSubmission		= $("#"+dataSubmissionId); 
		var dcrt 				= $("#"+dcrtId);
		var managmentPlan 		= $("#"+managmentPlanId);
		var newRO 				= $("#"+newROId);
		var newProject 			= $("#"+newProjectId);
		var projectProfile 		= $("#"+projectProfileId);	
		var submissionRegistry 	= $("#"+submissionRegistryId);
		var uploadFile 			= $("#"+uploadFileId);

		//change project
		dataSubmission.off("click", startDataSubmission);
		newProject.off("click",startNewProject); 
		newProject.on("click",startNewProject); 
		projectProfile.off("click",startProjectProfile); 

		dataSubmission.empty();
		dcrt.empty();
		managmentPlan.empty();
		
		if (data.projectid !=0){

			changeProject.attr("class", "button_right_WIP");
			
			changeRO.attr("class", "button_right_WIP");

			dataSubmission.append("Data Submission");
			dataSubmission.attr("class", "button_right_lightblue");
			dataSubmission.on("click", {data:data.projectid},startDataSubmission);
				
			dcrt.append("DataCenter Recomendation Tool");
			
			managmentPlan.append("Managment Plan");
			
			newRO.attr("class", "button_right_WIP");
			
			projectProfile.attr("class", "button_right_green");
			projectProfile.on("click", {data:data},startProjectProfile);
			
			submissionRegistry.attr("class", "button_right_grey");
			
			uploadFile.attr("class", "button_right_WIP");
			
			buildAfterSubmissionCheck(data.projectid);
	
		}else{


			changeProject.attr("class", "button_right_grey");
			
			dataSubmission.append("Data Submission <br/> (without project context)");
			dataSubmission.attr("class", "button_right_WIP");
			
			dcrt.append("DataCenter Recomendation Tool  <br/>(without project context)");
			
			managmentPlan.append("Managment Plan  <br/> (without project context)");
			
			newRO.attr("class", "button_right_grey");
				
			projectProfile.attr("class", "button_right_grey");
			
			submissionRegistry.attr("class", "button_right_grey");
		}
		
		
	}

	
	//
	function buildAfterSubmissionCheck(projectId){

		var dataSubmission =  $("#"+dataSubmissionId); 
		var submissionRegistry =   $("#"+submissionRegistryId);
		
		Liferay.Service(
				  '/GFBioProject-portlet.project/check-project-on-submissions',
				  {
				    projectId: projectId
				  },
				  function(obj) {
				    
				    if (obj == true){
				    	
				    	dataSubmission.attr("class", "button_right_darkgreen");
				    	
				    	submissionRegistry.attr("class", "button_right_WIP");
				    }
				  }
				 
				);
	}
	
	/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////
	
	
		
	//send projectId to Project Profile
	function startDataSubmission(click){
		var submissionManager =   $("#submissionManager");
		submissionManager.attr("class", "swHide");
		var data = {
				"view" : "swMain",
				"projectid":click.data.data};
		Liferay.fire('gadget:gfbio.submissionmanager.datasubmission', data);
	}
	
	
	//send projectId to Project Profile
	function startNewProject(){
		var submissionManager =   $("#submissionManager");
		submissionManager.attr("class", "swHide");
		var data = {"view" : "swMain"};
		Liferay.fire('gadget:gfbio.submissionmanager.newproject', data);
	}
	
	
	//send projectId to Project Profile
	function startProjectProfile(click){
		var submissionManager =   $("#submissionManager");
		submissionManager.attr("class", "swHide");
		Liferay.fire('gadget:gfbio.submissionmanager.projectprofile', click.data.data);
	}
	
	
	//Message from Hide Managment
	$(document).ready(function() {
		Liferay.on('gadget:gfbio.submissionmanager.hidemanagment', function(data) {
		
			if (data == undefined || !data.suma){}
			else{
				var submissionManager =   $("#submissionManager");
				submissionManager.attr("class", "swMain");		
			}
		});
	});
	
	
	//
	$(document).ready(function() {
		var newProject = $("#"+newProjectId);
		newProject.on("click",startNewProject); 
	});
	

	
</script>