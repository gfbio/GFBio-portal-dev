//
function chooseWorkflowProject(method, projectId  ,divId, userId){
	if (projectId == "none")
		projectId =0;
	workflowURL = document.getElementById('archivingURL').value;
	var data = {};
	data["projectid"] = Number(projectId);
	data["userid"] = Number(userId);
	ajaxActionRequest_ChooseWorkflowProject(workflowURL, method, data, divId,false);
	sentProjectInformations(userId, projectId)
}


//
function chooseWorkflowResearchObject( userId, researchObjectId){
//	if (projectId == "none")
		projectId =0;
	if (researchObjectId == "none")
		researchObjectId =0;
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

