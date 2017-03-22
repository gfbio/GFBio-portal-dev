<script>

	/////////////////////////////////////////   portlet java communication  //////////////////////////////////////////////
	
	
	//Message from Hide Managment
 	AUI().ready(function(A){

		console.log("updateChooser 0");
		Liferay.on('gadget:gfbio.archiving.update', function(data) {

			console.log("updateChooser 1");
			if (!(data == undefined)){
				console.log("updateChooser 2");
				 if (data.updateproject==true){
					 console.log("updateChooser 3");
					 console.log(data);
					var choPro = $("#".concat("workflowChooseRO"));
					choPro.append(
							"<option id='workflowChooseRO"+	data.updateresearchobject.researchobjectid+"' value='"+data.updateresearchobject.researchobjectid+"'>"+data.updateresearchobject.name+""+" with Version"+ data.updateresearchobject.researchobjectversion+"</option>");
					document.getElementById("workflowChooseRO"+data.updateresearchobject.researchobjectid).checked=true;
				
				 }

			}
		});
	}); 
	
	
	//generelly submission workflow fire to subworkflows
	function sentWorkflowInformations(workflow, showhide, researchObjectId, projectId, userId) {
		var showhide;
		var hidecode;
		if (workflow =='ena'){
			showhide = 'show';
			hidecode = '-21';
		}
		else{
			showhide = 'hide';
			hidecode = '-21';
		}
 		var toSubmit = {
			"workflow" : workflow,
			"researchobjectid"   : researchObjectId,
			"projectid"   : projectId,
			"userid"   : userId,
			"hidecode": hidecode,
			"showhide": showhide
		};
		Liferay.fire('gadget:gfbio.archiving.submit', toSubmit); 
	}
	
	
	//
	function sentProjectInformations(userId, projectId){
		var toSubmit = {
			"userid"   : userId,
			"projectid"   : projectId,
			"researchobjectid"   : 0,
		}
		Liferay.fire('gadget:gfbio.archiving.submit', toSubmit); 
	}
	
	
	//
	function sentResearchObjectInformations(userId, projectId, researchObjectId) {
 		var toSubmit = {
 			"userid"   : userId,
 			"projectid"   : projectId,
 			"researchobjectid"   : researchObjectId,
		};
		Liferay.fire('gadget:gfbio.archiving.submit', toSubmit); 
	}
	
		
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
	function ajaxActionRequest_ChooseWorkflowProject(archivingURL, method, data, divId, as) {
		
		if (data.projectid !=0){
			$.ajax({
				"type" : "POST",
				"url": archivingURL.concat("/GFBioArchiving"),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(data),
					"<portlet:namespace />responseTarget" : method
				},
				async: as,
				success : function (data){
					buildChooseROOfProject(data, divId) ;
				}
			});
		}else{
			$.ajax({
				"type" : "POST",
				"url": archivingURL.concat("/GFBioArchiving"),
				"data" : {
					"<portlet:namespace />data" : JSON.stringify(data),
					"<portlet:namespace />responseTarget" : "getResearchObjectsOfUser"
				},
				async: as,
				success : function (data){
					buildChooseROOfUser(data);
				}
			});
		}
	}
	
	
/////////////////////////////////////////   build funtions  //////////////////////////////////////////////
	
	
	AUI().ready(function(A){
		 //document.getElementById("workflowChoPro").selectedIndex = 0;
		 //document.getElementById("choWorkflow").selectedIndex = 0;
	});
	
	
	//
	function buildChooseROOfProject(data, divId){

		//cleanSubmissionWorkflow();
			
		if (data.researchobjects == undefined)
			var roList = [];
		else
			var roList = data.researchobjects;

		var div =   $("#".concat(divId));
		var choRO = $("#".concat('workflowChooseRO'));
		
		if (data.projectid !=0){
			//div.attr("class", "swMain");
			choRO.empty();
			choRO.append("<option value='none' selected=true></option>");
			for (i =0; i <roList.length;i++){
				choRO.append("<option value='"+roList[i].researchobjectid+"'>"+roList[i].name+" with version "+ +roList[i].researchobjectversion+"</option>");
				console.log(roList[i]);
			}
			document.getElementById("workflowChooseRO").selectedIndex = 0;
		}else{
			choRO.empty();
		}
	}
	
	function buildChooseROOfUser(data){
		
		var choRO = $("#".concat('workflowChooseRO'));
		
		choRO.empty();
		choRO.append("<option value='none'></option>");
		for (i =0; i <data.length;i++){
			console.log(data[i]);
			choRO.append("<option value='"+data[i].researchobjectid+"'>"+data[i].name+" with Version: "+ +data[i].researchobjectversion+"</option>");
		}
		document.getElementById("workflowChooseRO").selectedIndex = 0;
	}
	
	
	//
	function cleanSubmissionWorkflow(){
		document.getElementById("choWorkflow").selectedIndex = 0;
	}

	
</script>