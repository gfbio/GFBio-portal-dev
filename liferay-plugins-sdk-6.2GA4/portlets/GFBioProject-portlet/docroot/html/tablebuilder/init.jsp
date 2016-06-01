<script>


	/////////////////////////////////////////   ActionRequest  //////////////////////////////////////////////
	
	
	//
	function ajaxTableBuilderActionRequest_Choose(archivingURL, method, data, withoutRelationship, withRelationship, as) {
			$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function(data) {
				
				var withoutRelation = data.withoutRelationIdList;
				var withoutSelect = $("#".concat(withoutRelationship));  
				withoutSelect.empty();
				
				var withRelation = data.withRelationIdList;
				var withSelect = $("#".concat(withRelationship));   
				withSelect.empty();
				
				for (y = 0; y < withoutRelation.length; y++){
					withoutSelect.append("<option value='" + withoutRelation[y]+ "'>" + data.withoutJson[withoutRelation[y]] + "</option>");
				}
	
				for (y = 0; y < withRelation.length; y++){
					withSelect.append("<option value='" + withRelation[y]+ "'>" + data.withJson[withRelation[y]] + "</option>");
				}
					
			}
		});
	}


	/////////////////////////////////////////   ResourceRequest  //////////////////////////////////////////////
	
	
	//
	function ajaxTableBuilderRequest(archivingURL, method, data, as) {
 		$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function() {}
		});
	}
	
</script>