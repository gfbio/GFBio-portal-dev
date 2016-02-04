<script>

	/////////////////////////////////////////   portlet java communication  //////////////////////////////////////////////
	
	//
	function ajaxActionRequest_choosedpmaDataProvider(archivingURL, method, data, divId, as) {
			$.ajax({
			"type" : "POST",
			"url": archivingURL.concat("/GFBioArchiving"),
			"data" : {
				"<portlet:namespace />data" : JSON.stringify(data),
				"<portlet:namespace />responseTarget" : method
			},
			async: as,
			success : function (data){
				buildDataProvider(data, divId) ;
			}
		});
	}
	
	function buildDataProvider(data, divId){
		
		var div =   $("#".concat(divId));
		div.empty();
		
		if (data.label !=0){
			console.log(data);
			div.append(
					
				"<h3> basic data </h3>"+
				
				"<div class='row'>"+
					"<div class='rowLato'> GFBio ID of this data provider</div>"+
					"<div class='rowField'>" + data.dataproviderid + "</div>"+
				"</div>"+	
				"<div class='row'>"+
					"<div class='rowLato'> name</div>"+
					"<div class='rowField'>" + data.name + "</div>"+
				"</div>"+
				"<div class='row'>"+
					"<div class='rowLato'> label</div>"+
					"<div class='rowField'>" + data.label + "</div>"+
				"</div>"+	
				"<div class='row'>"+
					"<div class='rowLato'> description</div>"+
					"<div class='rowField'>" + data.description + "</div>"+
				"</div>"+	
				"<div class='row'>"+
					"<div class='rowLato'> adress</div>"+
					"<div class='rowField'>" + data.adress + "</div>"+
				"</div>"+	
				"<div class='row'>"+
					"<div class='rowLato'> website</div>"+
					"<div class='rowField'>" + data.website + "</div>"+
				"</div>"+	
				"<div class='row'>"+
					"<div class='rowLato'> training [ToDo]</div>"+
					"<div class='rowField'>" + data.training + "</div>"+
				"</div>"+
				
				"<h3> contact data </h3>"+
				
				"<div class='row'>"+
					"<div class='rowLato'> [ToDo]</div>"+
				"</div>"+
				
				"<h3> Data provider identifier standard </h3>"+
				
				"<div class='row'>"+
					"<div class='rowLato'> [ToDo]</div>"+
				"</div>"+
				
				"<h3> categories </h3>"
			);
			
			div.append("<h4> edit category profile of "+ data.label +" </h4>"+
				"<div class='row'></div>"+
				"<div class='row'>"+
					"<div class='rowLato'>  [ToDo]</div>"+
				"</div>"
			);
			
			div.append( 
					"<h4> category profile </h4>"+
					"<div class='row'></div>"+
					"<div class='row'>"+
							"<div class='dynamicTable1st'>  id</div>"+
							"<div class='dynamicHeadIst'> name</div>"+
							"<div class='dynamicHeadIst'>label</div>"+
							"<div class='dynamicHeadIst'>type</div>"+
							"<div class='dynamicHeadIst'>description</div>"+
							
						"</div>"

			); 
			
			Liferay.Service(
					  '/GFBioProject-portlet.content/get-content-ids-with-normal-table-relationships',
					  {
					    rowId: data.dataproviderid,
					    tableName: 'gfbio_category_dataprovider',
					    columnName1: 'gfbio_dataprovider',
					    columnName2: 'gfbio_category'
					  },
				function(obj) {

					var list = obj.split(",").map(Number);
					for (i = 0; i <list.length;i++){
						
					    div.append(
							"<div class='row'></div>"+
							"<div id='dpmaCategoryRow"+list[i]+"' class='row'>"+
							"<div class='dynamicTable1st'>"+list[i]+"</div>"+
							"</div>"
						); 
					    
					    Liferay.Service(
					    	'/GFBioProject-portlet.content/get-row-information-of-relation-by-content-id',
					    	{
								contentId: list[i],
							    tableName1: 'gfbio_category',
							    tableName2: 'gfbio_type'
							},
							function(obj) {
								var catDiv =   $("#dpmaCategoryRow".concat(obj[0].id));
								if(obj[0].name!=""){var dpmaName =obj[0].name;} 						else {var dpmaName = '&nbsp;';}
								if(obj[0].label!=""){var dpmaLabel =obj[0].label;} 						else {var dpmaLabel = '&nbsp;';}
								if(+obj[1].name!=""){var dpmaType =obj[1].name;} 						else {var dpmaType = '&nbsp;';}
								if(obj[0].description!=""){var dpmaDescription =obj[0].description;} 	else {var dpmaDescription = '&nbsp;';}
								catDiv.append(
										"<div class='dynamicTableIst'>"+ dpmaName+			"</div>"+
										"<div class='dynamicTableIst'>"+ dpmaLabel+			"</div>"+
										"<div class='dynamicTableIst'>"+ dpmaType+			"</div>"+
										"<div class='dynamicTableIst'>"+ dpmaDescription+	"</div>"
								); 
							}
						);
					}
				}
			);	
		}
	}

</script>