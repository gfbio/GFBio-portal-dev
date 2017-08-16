

//
function chooseProjProProject(method, projectId  ,divId){
	projectProfileURL = document.getElementById('projectprofileurl').value;
	var data = {};
	data["projectid"] = projectId;
	ajaxActionRequest_ChooseProjProProject(projectProfileURL, method, data, divId,false);
}



//
function chooseROX(method, researchobjectId  , divId){
	projectProfileURL = document.getElementById('projectprofileurl').value;
	var data = {};
	data["researchobjectid"] = researchobjectId;
	ajaxActionRequest_ChooseResearchObject(projectProfileURL, method, data, divId,false);
}

	

//
function createSubmissionRegistry (roId, divId){

	var div =   $("#".concat(divId));
	Liferay.Service(
			'/GFBioProject-portlet.submission/get-submisions-by-research-object-id',
			{
				requestJson: {"researchobjectid":roId}
			},
			function(obj) {
				div.append(
				"<h4> submission registry </h4>"
				);
				
				for (i =0; i <obj.length;i++){
 				div.append(
 					"<h5> submission "+ i+" </h5>"+	
 						
 	 				"<div class='row'>"+
						"<div class='rowLato'> user to do submission </div>"+
						"<div class='rowField'>"+ obj[i].userid+"</div>"+
					"</div>"+
 					
 					"<div class='row'>"+
						"<div class='rowLato'> GFBio ID of this research object</div>"+
						"<div class='rowField'>"+ obj[i].researchobjectid+"</div>"+
					"</div>"+
					
 					"<div class='row'>"+
						"<div class='rowLato'> version of this research object </div>"+
						"<div class='rowField'>"+ obj[i].researchobjectversion+"</div>"+
					"</div>"+
					
					
 					"<div class='row'>"+
						"<div class='rowLato'> archive </div>"+
						"<div class='rowField'>"+ obj[i].archive+"</div>"+
					"</div>"+
					
 	 				"<div class='row'>"+
						"<div class='rowLato'>"+ obj[i].archivepidtype+ " (pID-Type) from archive  </div>"+
						"<div class='rowField'>"+ obj[i].archivepid+"</div>"+
					"</div>"+
					
 	 				"<div class='row'>"+
						"<div class='rowLato'> broker submission ID  </div>"+
						"<div class='rowField'>"+ obj[i].brokersubmissionid+"</div>"+
					"</div>"+
					
 	 				"<div class='row'>"+
						"<div class='rowLato'> last changed on  </div>"+
						"<div class='rowField'>"+ obj[i].lastchanged+"</div>"+
					"</div>"+
					
 	 				"<div class='row'>"+
						"<div class='rowLato'> status</div>"+
						"<div class='rowField'>"+ obj[i].status+"</div>"+
					"</div>"+
					
	 	 			"<div class='row'>"+
						"<div class='rowLato'> is public</div>"+
						"<div class='rowField'>"+ obj[i].ispublic+"</div>"+
					"</div>"+
					
					"<div class='row'>"+
						"<div class='rowLato'> will public after</div>"+
						"<div class='rowField'>"+ obj[i].publicafter+"</div>"+
					"</div>"
	 			);
				}
			}
		);
}