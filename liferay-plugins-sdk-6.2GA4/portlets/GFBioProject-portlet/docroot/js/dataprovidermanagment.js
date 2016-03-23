

//
function choosedpmaDataProvider(method, label  ,divId){
	dataProviderManagmentURL = document.getElementById('dataprovidermanagmenturl').value;
	var data = {};
	data["label"] = label;
	ajaxActionRequest_choosedpmaDataProvider(dataProviderManagmentURL, method, data, divId,false);
}