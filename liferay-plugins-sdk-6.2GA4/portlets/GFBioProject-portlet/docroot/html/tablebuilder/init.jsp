<script>


	//////////////////////////////////////////////Builder  ///////////////////////////////////////////////////

	
	//
	function addColumnBlock (targetDiv, id, name, value){

		var div = $("#"+targetDiv);
		div.append(
			"<div 		class='control-group'>"+
				"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
				"<div>"+
					"<input	class='field lfr-input-text-container'	id='"+id+"' type='text'  value='"+value+"' style='width:87%; display:inline-block'>"+
					"<span style='width:1%; display:inline-block'></span>"+
					"<span id='"+id+"_b_del' onclick='deleteColumnBlock("+targetDiv+", "+id+")' style='width:12%; display:inline-block'>		<span class='btn btn-danger' style='width:100%'><i class='fa fa-trash-o' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Delete</span></span>"+
				"</div>"+
			"</div >"
		);
	}
	
	
	//
	function addStandardBlock (targetDiv, id, name, description, value){

		var div = $("#"+targetDiv);
		div.append(
			"<div 		class='control-group'>"+
				"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
				"<p 	class='field-description'				id='"+id+"_d'>"+description+"</p>"+
				"<input	class='field lfr-input-text-container'	id='"+id+"' type='text'  value='"+value+"'>"+
			"</div >"
		);
	}
	
	//
	function addListBlock (targetDiv, id, name, smallDescriptionBold, smallDescription, mainDescriptionBold, mainDescription, btnfunction){

		var div = $("#"+targetDiv);
		div.append(
			"<div 		class='control-group'>"+
				"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
				"<div>"+
					"<span  style='width:84%; display:inline-block'>		<span style='width:100%' class='field-description' id='"+id+"_d'>"+"<b> "+smallDescriptionBold+"</b>"+smallDescription+"</span></span>"+
					"<span style='width:3%; display:inline-block'></span>"+
					"<span  style='width:13%; display:inline-block' id='"+id+"edit_btn' onclick='"+btnfunction+"'>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-edit' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Edit</span></span>"+
				"</div>"+
				"<p 	class='field-description'				id='"+id+"_c'>"+"<b>"+mainDescriptionBold+"</b> "+mainDescription+"</p>"+
			"</div >"
		);
	}
	
	
	//
	function deleteColumnBlock(targetDiv, id){
		console.log('del column' + column);
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