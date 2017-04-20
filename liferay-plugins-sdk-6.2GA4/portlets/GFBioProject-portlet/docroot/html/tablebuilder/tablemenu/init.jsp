<script>

	

	
	//
	function initiateTableMenu(targetId){
		
		//console.log(targetId);
		var div =   $("#"+targetId);
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildTableMenu(data, div);
		fillTableMenu(data, div);
	}

	
	//
	function buildTableMenu(data, div){
		
		if (data.userid != 0){
	
			div.empty();
			div.append(
				"<h2>Table Menu</h2>"+
				"</br>"+
				"<p 	class='field-description'				id='tbtm_tb_d'> The table menu help to change the basic structure of a hcc entity. </p>"+

				"<h3>0. Load existing table</h3>"+
				
				"<p 	class='field-description'				id='tbtm_tableload_d'>We distinguish in two types of tables in the head column content system (hcc). Entities stores the basicly information in the database. Relationsships interconnect the entity information. You can choose a hcc entity to see the basic structure of this table and to see their relationships.  </p>"+
				
				"<div 	class='field lfr-input-text-container' 	id='tbtm_tableload_v' type='text'  value=''>"+
					"<form action='select.html'>"+
						"<select id='tbtm_tableload' name='<portlet:namespace/>tbtm_tableload' size='1' style='width:100%'>"+
							"<option value='none'></option>"+
						"</select>"+
					"</form>"+
				"</div>"+
				
				"<h3>1. Column declaration</h3>"+
				
				"<p 	class='field-description'	id='tbtm_columndeclaration_d'>Here you can add, change and delete the columns of a new/selected table. </p>"+
				
				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<div class='control-label' > headid </div>"+
						"<div class='field lfr-input-text-container' id='tbtm_head_id'></div>"+
					"</div>"+
				"</div>"+
				
				"<div id='tbtm_columndeclaration'>"+
				"</div>"+
				
				"<h3>2. Set relationships</h3>"+
				
				"<h3>3. Finishing</h3>"+
				
				"<div>"+
					"<span  style='width:23%; display:inline-block' id='tbtm_' onclick='submitInput()'>		<span style='width:100%' class='btn btn-success'><i class='fa fa-play' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Start Create</span></span>"+
					"<span style='width:3%; display:inline-block'></span>"+
					"<span  style='width:23%; display:inline-block' id='tbtm_' onclick='resetInput()'>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-refresh' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Reset</span></span>"+
					"<span style='width:2%; display:inline-block'></span>"+
					"<span  style='width:23%; display:inline-block' id='tbtm_' onclick='resetInput()'>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-refresh' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Link</span></span>"+
					"<span style='width:3%; display:inline-block'></span>"+
					"<span  style='width:23%; display:inline-block' id='tbtm_' onclick='resetInput()'>		<span style='width:100%' class='btn btn-danger'> <i class='fa fa-trash-o' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Delete</span></span>"+
				"</div>"
				
				
			);
			var i =1;
			addColumnBlock('tbtm_columndeclaration','tbtm_column_'+i, 'Column '+i, '');
		}
	}
	



	//
	function fillTableMenu(data, div){
	
		var url = document.getElementById('tablebuilderurl').value;
	
		var div =   $("#tbtm_tableload_v");
		div.empty();
		div.append(
			"<form action='select.html'>"+
				"<select id='tbtm_tableloadlabel' name='<portlet:namespace/>tbtm_tableloadlabel' size='1' style='width:100%'>"+
					"<option value='none'></option>"+
				"</select>"+
			"</form>"
		);
		
 		ajaxData = {"tabletype":"entity"};
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/WorkflowGenericPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gethccentitylist"
			},
			async: false,
 			success :  function (obj){
 				console.log(obj);
 				var choTable = $("#".concat('tbtm_tableloadlabel'));
 				choTable.empty();
 				choTable.append("<option value='none'></option>");
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					choTable.append("<option id='tbtm_tableload"+json+"' value='"+json+"'>"+json+"</option>");
				}
 			}
 		});
	
	}





</script>