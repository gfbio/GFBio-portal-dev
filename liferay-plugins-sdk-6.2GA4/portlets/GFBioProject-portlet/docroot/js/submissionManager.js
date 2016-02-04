


function helpdeskInfo(path, trigger){
	var id = "suma_left_botton";
	var div =   $("#".concat(id));
	var path = path+trigger;
	div.empty();
	div.append(
			"<img id='suma_left_botton_img' src='"+path+"' style='width:100%; position:relative;' />"
	);
}


//
function chooseSuMaProject(method, projectId){
	projectProfileURL = document.getElementById('submissionmanagerurl').value;
	var data = {};
	data["projectid"] = projectId;
	ajaxActionRequest_suma_ChooseProject(projectProfileURL, method, data, false);
}