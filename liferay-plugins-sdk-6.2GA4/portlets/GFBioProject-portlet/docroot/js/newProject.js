//
function newProject(method, name, size, userId) {
	var str ;
	var data = {};
	data["userid"] = userId;
	for (var i = 0; i < size; i++) {
		str = name.concat("_").concat(i);
		if (document.getElementById(str).value.length != 0){
			var topic = document.getElementById('lato'.concat(str)).textContent;
			data[topic] = document.getElementById(str).value;
		}
	}
	Liferay.Service(
			  '/GFBioProject-portlet.project/create-project',
			  {
			    requestJson: data 
			  },
			  function(obj) {
				for (var i = 0; i < size; i++) {
					str = name.concat("_").concat(i);
					document.getElementById(str).value ='';
				}
			  }
			);
}