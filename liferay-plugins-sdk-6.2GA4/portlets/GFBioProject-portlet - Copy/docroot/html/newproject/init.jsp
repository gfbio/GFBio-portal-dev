
<script>
	
/////////////////////////////////////////   portlet portlet communication  //////////////////////////////////////////////
	
	
	//Message from hide managment
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.submissionmanager.hidemanagment', function(data) {
			if (data == undefined){}
			else{
				var newProject =   $("#newProject");
				newProject.attr("class", data.view);			
			}
		});
	});
	
	
	//Message from Submission Manager
	AUI().ready(function(A){
		Liferay.on('gadget:gfbio.submissionmanager.newproject', function(data) {
			if (data == undefined){}
			else{
				var newProject =   $("#newProject");
				newProject.attr("class", data.view);	
			}
		});
	});
	

	
	</script>