<script>


	//////////////////////////////////////////////Builder  ///////////////////////////////////////////////////

	
	//
	function addColumnBlock (targetDiv, id, name, value){

		var div = $("#"+targetDiv);
		div.append(
			"<div 		class='control-group'					id='"+id+"_div'>"+
				"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
				"<div>"+
					"<input	class='field lfr-input-text-container'	id='"+id+"' type='text'  value='"+value+"' style='width:87%; display:inline-block'>"+
					"<span style='width:1%; display:inline-block'></span>"+
					"<span id='"+id+"_b_del' onclick=deleteColumnBlock('"+id+"') style='width:12%; display:inline-block'>		<span class='btn btn-danger' style='width:100%'><i class='fa fa-trash-o' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Delete</span></span>"+
		
				"</div>"+
			"</div >"
		);
	}
	
	
	//
	function addStandardBlock (targetDiv, id, name, description, value){

		var div = $("#"+targetDiv);
		div.append(
			"<div 		class='control-group' id='"+id+"_div'>"+
				"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
				"<p 	class='field-description'				id='"+id+"_d'>"+description+"</p>"+
				"<input	class='field lfr-input-text-container'	id='"+id+"' type='text'  value='"+value+"'>"+
			"</div >"
		);
	}
	
	
	//
	function deleteColumnBlock(id){
		console.log(id+"_div");
		var div = $("#"+id+"_div");
		div.remove();
	}
	
	

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