<script>

	var tbtmColumnConter =1;
	
	//
	function addListBlock (targetDiv, id, name, smallDescriptionBold, smallDescription, mainDescriptionBold, mainDescription, btnfunction, buildButton){
	
		var div = $("#"+targetDiv);
		if(buildButton)
			div.append(
				"<div 		class='control-group' id='"+id+"_div'>"+
					"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
					"<div >"+
						"<span  style='width:73%; display:inline-block'>		<span style='width:100%' class='field-description' id='"+id+"_d'>"+"<b> "+smallDescriptionBold+"</b>"+smallDescription+"</span></span>"+
						"<span style='width:3%; display:inline-block'></span>"+
						"<span  style='width:11%; display:inline-block' id='"+id+"edit_btn' onclick='"+btnfunction+"'>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-edit' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Edit</span></span>"+
						"<span style='width:1%; display:inline-block'></span>"+
						"<span  style='width:11%; display:inline-block' id='"+id+"delete_btn' onclick=deleteTable('"+id+"')>		<span style='width:100%' class='btn btn-danger'><i class='fa fa-trash' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Delete</span></span>"+
					"</div>"+
					"<p 	class='field-description'				id='"+id+"_c'>"+"<b>"+mainDescriptionBold+"</b> "+mainDescription+"</p>"+
				"</div >"
			);
		else
			div.append(
					"<div 		class='control-group' id='"+id+"_div'>"+
						"<label class='control-label' 				   	id='"+id+"_l'>"+name+" </label>"+
						"<div >"+
							"<span  style='width:73%; display:inline-block'>		<span style='width:100%' class='field-description' id='"+id+"_d'>"+"<b> "+smallDescriptionBold+"</b>"+smallDescription+"</span></span>"+
							"<span style='width:3%; display:inline-block'></span>"+
							"<span  style='width:11%; display:inline-block' id='"+id+"edit_btn' onclick='"+btnfunction+"'>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-edit' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Edit</span></span>"+
							"<span style='width:1%; display:inline-block'></span>"+
						"</div>"+
						"<p 	class='field-description'				id='"+id+"_c'>"+"<b>"+mainDescriptionBold+"</b> "+mainDescription+"</p>"+
					"</div >"
				);
			
	}

	

	
	//
	function buildTableListFooter(data, targetId){
		var div =   $("#"+targetId);
		div.append(
			"<div>"+
				"<span  style='width:22%; display:inline-block' id='newtable_btn' onclick=buildNewTable('"+targetId+"')>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-plus' 		aria-hidden='true'>&nbsp; &nbsp;  </i>new table</span></span>"+
			"</div>"+
			"</br>"
		);
	}
	
	
	//
	function buildTableHead(targetId){
		var div =   $("#"+targetId);
		div.empty();
		div.append(
			"<h2>Table Menu</h2>"+
			"</br>"+
			"<p 	class='field-description'				id='tbtm_tb_d'> The table menu help to change the basic structure of a hcc entity. </p>"
		);
	}
	
		
	function buildTableList(data, targetId){
		var url = document.getElementById('tablebuilderurl').value;
		
		buildTableHead(targetId);
		var div =   $("#"+targetId);
 		ajaxData = {"tabletype":"entity"};
 		ajaxData["kindofresponse"] ="extended";
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/TableBuilderPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(ajaxData),
				"<portlet:namespace />responseTarget" : "gethccentitylist"
			},
			async: false,
 			success :  function (obj){
 				console.log(obj);
				for (i =0; i <obj.length;i++){
					var json = obj[i];
					addListBlock ('tableBuilder', json['tablename'], json['tablename'], 'Column: ',(json['columnnames'].toString()).replace(/,/g,", "), 'Description: ',json['description'], 'buildTableEdit("'+json['tablename']+'","'+targetId+'")');
					div.append("<hr>");
				}
 			}
 		});
	}

	//
	function buildNewTableEdit(data, targetId){
		console.log(WIP);
	}
	
	
	function resetNewTable(targetId){
		tbtmColumnConter =1;
		var div =   $("#"+targetId);
		div.empty();
		buildNewTable(targetId);
		
	}
	
	//
	function buildNewTable(targetId){
		
		var div =   $("#"+targetId);
		//if (data.userid != 0){

		buildTableHead(targetId);
		div.append("<h3>1. Table name</h3>");
		addStandardBlock (targetId, "tablename", "", "Please fill out the name field. All gfbio tables have the prefix 'gfbio_'", "gfbio_");
		div.append(
/* 			"<h3>0. Load existing table</h3>"+
				
			"<p 	class='field-description'				id='tbtm_tableload_d'>We distinguish in two types of tables in the head column content system (hcc). Entities stores the basicly information in the database. Relationsships interconnect the entity information. You can choose a hcc entity to see the basic structure of this table and to see their relationships.  </p>"+
				
				"<div 	class='field lfr-input-text-container' 	id='tbtm_tableload_v' type='text'  value=''>"+
					"<form action='select.html'>"+
						"<select id='tbtm_tableload' name='<portlet:namespace/>tbtm_tableload' size='1' style='width:100%'>"+
							"<option value='none'></option>"+
						"</select>"+
					"</form>"+
				"</div>"+ */
				
				
				"<h3>2. Column declaration</h3>"+
				
				"<p 	class='field-description'	id='tbtm_columndeclaration_d'>Here you can add, change and delete the columns of a new/selected table. <br/><br/>A <b>id</b> and a <b>timestamp</b> column will be createt automaticly.</p>"+
				
/* 				"<div class='swHide'>"+
					"<div class='control-group'>"+
						"<div class='control-label' > headid </div>"+
						"<div class='field lfr-input-text-container' id='tbtm_head_id'></div>"+
					"</div>"+
				"</div>"+ */
				
				"<div id='tbtm_columndeclaration'>"+
				"</div>"+
				
				"<h3>3. Set relationships</h3>"+
				
				"<h3>4. Finishing</h3>"+
				
				"<div>"+
					"<span  style='width:23%; 	display:inline-block' id='tbtm_' onclick=submitInput()>						<span style='width:100%' class='btn btn-success'><i class='fa fa-play' 		aria-hidden='true'>&nbsp; &nbsp;  </i>Start Create</span></span>"+
					"<span style='width:3%; 	display:inline-block'></span>"+
					"<span  style='width:23%; 	display:inline-block' id='tbtm_' onclick=resetNewTable('"+targetId+"')>		<span style='width:100%' class='btn btn-primary'><i class='fa fa-refresh' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Reset</span></span>"+
					"<span style='width:2%; 	display:inline-block'></span>"+
					"<span  style='width:23%; 	display:inline-block' id='tbtm_' onclick=initiateTableMenu('"+targetId+"')>	<span style='width:100%' class='btn btn-primary'><i class='fa fa-list-ul' 	aria-hidden='true'>&nbsp; &nbsp;  </i>Back to list</span></span>"+
				"</div>"+
				"<br/>"
			);
			addColumnBlock('tbtm_columndeclaration','tbtm_column_'+tbtmColumnConter, 'Column '+tbtmColumnConter, '');
			document.getElementById('tbtm_column_'+tbtmColumnConter).onclick = function () {
				addAddColumnEvent();
			};
		//}
	}
	
	function addAddColumnEvent(){
		if (tbtmColumnConter>1){
			var check = true;
			var checker = 0;
			var newCollumnNumber = 0;
			
			for (i =1;i<tbtmColumnConter+1;i++)
				if (document.getElementById('tbtm_column_'+i) != null)
					if (document.getElementById('tbtm_column_'+i).value == "")
						checker = checker +1;
			if (checker >1)
				check = false;
			if (check){
				tbtmColumnConter = tbtmColumnConter+1;
				addColumnBlock('tbtm_columndeclaration','tbtm_column_'+tbtmColumnConter, 'Column '+tbtmColumnConter, '');
				document.getElementById('tbtm_column_'+tbtmColumnConter).onclick = function () {
					addAddColumnEvent();
				};
			}
		}else{
			tbtmColumnConter = tbtmColumnConter+1;
			addColumnBlock('tbtm_columndeclaration','tbtm_column_'+tbtmColumnConter, 'Column '+tbtmColumnConter, '');
			document.getElementById('tbtm_column_'+tbtmColumnConter).onclick = function () {
				addAddColumnEvent();
			}
		}
	}

	function deleteTable(targetId){
		console.log("|"+targetId+"|");
		var url = document.getElementById('tablebuilderurl').value;
		var div =   $("#"+targetId+"_div");
 		$.ajax({
			"type" : "POST",
			"url": url.concat('/TableBuilderPortlet'),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(targetId),
				"<portlet:namespace />responseTarget" : "deleteTable"
			},
			async: false,
 			success :  function (obj){
				console.log(obj);
				div.empty();
 			}
 		});
	}
	
	//
	function initiateTableMenu(targetId){
		
		console.log(targetId);
		var data = {"userid":Number(themeDisplay.getUserId())};
		buildTableList(data, targetId);
		//buildTableEdit(data, div);
		//fillTableEdit(data, div);
		buildTableListFooter(data, targetId);
	}



	//
	function fillTableEdit(data, targetId){
	
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