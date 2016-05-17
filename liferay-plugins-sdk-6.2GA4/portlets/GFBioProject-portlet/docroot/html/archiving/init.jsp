<script>

	/////////////////////////////////////////   portlet java communication  //////////////////////////////////////////////
	
	
	//Message from Hide Managment
	$(document).ready(function() {
		
		Liferay.on('gadget:gfbio.archiving.update', function(data) {
			if (!(data == undefined))
				if (data.updateproject==true){
					var choPro = $("#".concat("workflowChoPro"));
					choPro.append("<option value='"+data.projectid+"'>"+data.projectlabel+"</option>");
				}
		});
	});
	
	
	//generelly submission workflow fire to subworkflows
	function sentWorkflowInformations(hidecode, showhide, researchObjectId, projectId, userId) {
		var toSubmit = {
			"hidecode" : hidecode,
			"researchobjectid"   : researchObjectId,
			"projectid"   : projectId,
			"userid"   : userId,
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
				buildChooseRO(data, divId) ;
			}
		});
	}
	
	
/////////////////////////////////////////   build funtions  //////////////////////////////////////////////
	
	
	function buildChooseRO(data, divId){
			
		if (data.researchobjects == undefined)
			var roList = [];
		else
			var roList = data.researchobjects;

		var div =   $("#".concat(divId));
		var choRO = $("#".concat('workflowChooseRO'));
		
		if (data.projectid !=0){
			div.attr("class", "swMain");
			choRO.empty();
			choRO.append("<option value='none'></option>");
			for (i =0; i <roList.length;i++)
				choRO.append("<option value='"+roList[i].researchobjectid+"'>"+roList[i].name+" Version: "+ +roList[i].researchobjectversion+"</option>");
		}else{
			div.attr("class", "swHide");
			choRO.empty();
		}
	}

	
</script>