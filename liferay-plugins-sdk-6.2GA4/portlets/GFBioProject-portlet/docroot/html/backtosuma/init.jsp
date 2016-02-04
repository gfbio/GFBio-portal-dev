<script>

	//
	$(document).ready(function() {	
		var backtosubmissionManager =   $("#backtosubmissionManager");
		backtosubmissionManager.attr("class", "swHide");	
		var data = {"view" : "swHide",
				"suma":false};
		Liferay.fire('gadget:gfbio.submissionmanager.hidemanagment', data);
	});
	
	
	//Message from Submission Manager
	$(document).ready(function() {
		
		Liferay.on('gadget:gfbio.submissionmanager.datasubmission', function(data) {
			if (data == undefined){}
			else{
				var backtosubmissionManager =   $("#backtosubmissionManager");
				backtosubmissionManager.attr("class", "swMain");	
			}
		});
		
		Liferay.on('gadget:gfbio.submissionmanager.newproject', function(data) {
			if (data == undefined){}
			else{
				var backtosubmissionManager =   $("#backtosubmissionManager");
				backtosubmissionManager.attr("class", "swMain");	
			}
		});
		
		
		Liferay.on('gadget:gfbio.submissionmanager.projectprofile', function(data) {
			if (data == undefined){}
			else{
				var backtosubmissionManager =   $("#backtosubmissionManager");
				backtosubmissionManager.attr("class", "swMain");	
			}
		});
	});
	
	
	//
	function backToSuMa(){
		
		var backtosubmissionManager =   $("#backtosubmissionManager");
		backtosubmissionManager.attr("class", "swHide");	
		var data = {
				"view" : "swHide",
				"suma":true};
		Liferay.fire('gadget:gfbio.submissionmanager.hidemanagment', data);
	}
	
</script>