<script>
	////////////////////////////////////////////   ActionRequest  ////////////////////////////////////////////
	
	
	//----------------------------------------   Choose & Create  -----------------------------------------//

	var changeProjectId ="suma_changeProject";
	var dataSubmissionId = "suma_dataSubmission";
	var dcrtId = "suma_DCRT";
	var managmentPlanId = "suma_managmentPlan";
	var newProjectId ="suma_newProject";
	var newROId ="suma_newRO";
	var projectProfileId ="suma_projectProfile";




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

		var changeProject =   $("#"+changeProjectId);	
		var dataSubmission =  $("#"+dataSubmissionId); 
		var dcrt =  $("#"+dcrtId);
		var managmentPlan = $("#"+managmentPlanId);
		var newRO = $("#"+newROId);
		var newProject = $("#"+newProjectId);
		var projectProfile =   $("#"+projectProfileId);	

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
			console.log(data);
			console.log("--------------------------");
			console.log(data.projectid);
			dataSubmission.append("Data Submission");
			dataSubmission.attr("class", "button_right_lightblue");
			dataSubmission.on("click", {data:data.projectid},startDataSubmission);
			
			
			dcrt.append("DataCenter Recomendation Tool");
			
			managmentPlan.append("Managment Plan");
			
			newRO.attr("class", "button_right_WIP");
			
			projectProfile.attr("class", "button_right_green");
			projectProfile.on("click", {data:data},startProjectProfile);
	
		}else{

			changeProject.attr("class", "button_right_grey");
			
			dataSubmission.append("Data Submission <br/> (without project context)");
			dataSubmission.attr("class", "button_right_WIP");
			
			dcrt.append("DataCenter Recomendation Tool  <br/>(without project context)");
			
			managmentPlan.append("Managment Plan  <br/> (without project context)");
			
			newRO.attr("class", "button_right_grey");
				
			projectProfile.addClass("button_right_grey");
		}
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