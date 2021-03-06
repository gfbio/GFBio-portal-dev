<script>

	/////////////////////////////////////////   portlet java communication  //////////////////////////////////////////////
	
	
	//Message from Hide Managment
 	AUI().ready(function(A){

		Liferay.on('gadget:gfbio.archiving.update', function(data) {

			if (!(data == undefined)){
				 if (data.updateproject==true){
					var choPro = $("#".concat("workflowChooseRO"));
					choPro.append(
							"<option id='workflowChooseRO"+	data.updateresearchobject.researchobjectid+"' value='"+data.updateresearchobject.researchobjectid+"'>"+data.updateresearchobject.name+""+" with Version"+ data.updateresearchobject.researchobjectversion+"</option>");
					document.getElementById("workflowChooseRO"+data.updateresearchobject.researchobjectid).checked=true;
				 }
			}
		});
	}); 
	
	
	//Message from Hide Managment
 	AUI().ready(function(A){

		Liferay.on('gadget:gfbio.archiving.showhide', function(data) {

			if (!(data == undefined))
				 if (data.show==true)
					document.getElementById("workflowform").className='swMain';
				else
					document.getElementById("workflowform").className='swHide';
		});
	}); 
	
	
	//Message from Hide Managment
 	AUI().ready(function(A){

		Liferay.on('gadget:gfbio.archiving.reset', function(data) {

			if (!(data == undefined))
				 if (data.reset==true)
					 cleanSubmissionWorkflow();
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
		 cleanSubmissionWorkflow();
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
			for (i =0; i <roList.length;i++)
				choRO.append("<option value='"+roList[i].researchobjectid+"'>"+roList[i].name+" with version "+ +roList[i].researchobjectversion+"</option>");
			var v = 'none';
			document.getElementById("workflowChooseRO").value = v;
			
		}else{
			choRO.empty();
		}
	}
	
	function buildChooseROOfUser(data){
		
		var choRO = $("#".concat('workflowChooseRO'));
		
		choRO.empty();
		choRO.append("<option value='none'></option>");
		for (i =0; i <data.length;i++){
			choRO.append("<option value='"+data[i].researchobjectid+"'>"+data[i].name+" with Version: "+ +data[i].researchobjectversion+"</option>");
		}
		var v = 'none';
		document.getElementById("workflowChooseRO").value = v;
	}
	
	
	//
	function cleanSubmissionWorkflow(){
		var v = 'none';
		document.getElementById("workflowChooseRO").value = v;
	}

	
</script>