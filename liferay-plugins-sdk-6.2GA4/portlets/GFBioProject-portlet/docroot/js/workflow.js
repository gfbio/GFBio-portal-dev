//
function chooseWorkflowProject(method, projectId  ,divId, userId){
	if (projectId == "none")
		projectId =0;
	console.log(projectId);
	console.log(method+ " | "+projectId+ " | "+divId+ " | "+userId);
	workflowURL = document.getElementById('archivingURL').value;
	var data = {};
	data["projectid"] = Number(projectId);
	ajaxActionRequest_ChooseWorkflowProject(workflowURL, method, data, divId,false);
	sentProjectInformations(userId, projectId)
}


//
function chooseWorkflowResearchObject( userId, projectId, researchObjectId){
	if (projectId == "none")
		projectId =0;
	if (researchObjectId == "none")
		researchObjectId =0;
	console.log(userId+ " | "+projectId+ " | "+researchObjectId);
	sentResearchObjectInformations(userId, projectId, researchObjectId)
}


//
function startSubmissionWorkflow(workflow, researchObjectId, projectId, userId){
	if (projectId == "none")
		projectId =0;
	if (researchObjectId == "none")
		researchObjectId =0;
	sentWorkflowInformations(workflow, "hide", researchObjectId, projectId, userId);
}
