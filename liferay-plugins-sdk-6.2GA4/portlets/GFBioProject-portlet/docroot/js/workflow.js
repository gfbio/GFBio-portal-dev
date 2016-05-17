function chooseProjProProject(method, projectId  ,divId){
	workflowURL = document.getElementById('archivingURL').value;
	var data = {};
	data["projectid"] = projectId;
	ajaxActionRequest_ChooseProjProProject(workflowURL, method, data, divId,false);
}

//
function startSubmissionWorkflow(workflow, researchObjectId, projectId, userId){
	if (projectId == "none")
		projectId =0;
	if (researchObjectId == "none")
		researchObjectId =0;
	sentWorkflowInformations(workflow, "hide", researchObjectId, projectId, userId);
}

