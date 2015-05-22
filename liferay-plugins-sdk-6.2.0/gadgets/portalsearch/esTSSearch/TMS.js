var TMS = {
	doubleClickTermFunc : null,
	searchDoneFunc : null,
	searchDone : function(f){
		TMS.searchDoneFunc = f;
	},
	doubleClickTerm : function(f){
		TMS.doubleClickTermFunc = f;
	},	
	
	init: function(container) {
		//Create all html elements:
		var menu = $('<ul>').attr('id','terminology_menu')
							.addClass('ui-widget-content');
	
		menu.css('width','200px')
			.css('float','left');

		
		var spinenrImg = $('<img>').attr('src','http://portals-dev.inf-bb.uni-jena.de/gfbio/esTSSearch/spinner.gif')
									.attr('id','spinner_image');


		var infobox_title = $('<h3>').addClass('ui-widget-header')
									 .addClass('ui-corner-all')
									 .html('Info');

		
		var rank = $('<tr>').append($('<td>').html('Rank').attr('id','rank_key'))
							.append($('<td>').attr('id','rank'));

		var label = $('<tr>').append($('<td>').html('Label').attr('id','label_key'))
							 .append($('<td>').attr('id','label'));

		var kingdom = $('<tr>').append($('<td>').html('Kingdom').attr('id','kingdom_key'))
								.append($('<td>').attr('id','kingdom'));

		var status = $('<tr>').append($('<td>').html('Status').attr('id','status_key'))
								.append($('<td>').attr('id','status'));

		var externalID = $('<tr>').append($('<td>').html('URI').attr('id','externalID_key'))
								.append($('<td>').attr('id','externalID'));

		var domain = $('<tr>').append($('<td>').html('Domain').attr('id','domain_key'))
								.append($('<td>').attr('id','domain'));
		
		var description = $('<tr>').append($('<td>').html('Description').attr('id','description_key'))
		.append($('<td>').attr('id','description'));

		var sourceTerminology = $('<tr>').append($('<td>').html('SourceTerminology').attr('id','sourceTerminology_key'))
								.append($('<td>').attr('id','sourceTerminology'));

		var uri = $('<tr>').append($('<td>').html('URI'))
								.append($('<td>').attr('id','uri'));


		var infobox_table = $('<table>').append(rank)
										.append(label)
										.append(kingdom)
										.append(status)
										.append(externalID)
										.append(domain)
										.append(description)
										.append(sourceTerminology)
										.append(uri);						
		
		var infobox = $('<div>').attr('id','infobox')
								.addClass('ui-widget-content')
								.append(infobox_title)
								.append(infobox_table)
								.css('padding', '0.2em')
								.css('position', 'absolute');


		
		infobox.hide();
		menu.menu();
		menu.hide();
		spinenrImg.hide();

		//hide infobox, if user clicks outsite the infobox
		$(document).mouseup(function (e){
			if (!infobox.is(e.target)
				&& infobox.has(e.target).length === 0){
				infobox.hide();
			}
		});

		//add menu & infobox to document
		$('#' + container).append(spinenrImg);
		$('#' + container).append(menu);
		$('#' + container).append(infobox);
	},

	dictionary : {
		domains : [],
		getDomain : function (domainName){
			for(var i = 0; i < TMS.dictionary.domains.length; i++){
				if(TMS.dictionary.domains[i].name == domainName){
					return TMS.dictionary.domains[i];
				}
			}
			return null;
		},
		addDomain : function(domainName, results){
			this.domains.push({"name":domainName, "results":[results]});
		},
		clear : function(){
			this.domains = [];
		}
	},

	handleTableColmn : function(result, keyName) {
		if(result[keyName]){
			$('#' + keyName).html(result[keyName]);
			$('#' + keyName).show();
			$('#' + keyName + '_key').show();
		}else{
			$('#' + keyName).hide();
			$('#' + keyName + '_key').hide();
		}
	},

	performSearch : function(searchquery){
		//var restfulws_url = 'http://localhost:8080/GFBioRESTfulWS/terminologies/search';
		var restfulws_url = 'http://terminologies.gfbio.org/api/beta/terminologies/search';
		$('#spinner_image').show();
		$.getJSON(restfulws_url, {query : searchquery}, function(data){
			if(data){
				//add data to dictionary
				$.each(data.results, function(){
					if(!this.domain){
						this.domain = "Uncategorized";
					}

					var domain = TMS.dictionary.getDomain(this.domain);
					if(domain == null){
						TMS.dictionary.addDomain(this.domain, this);
					}else{
						domain.results.push(this);
					}
				});
			}
			$('#spinner_image').hide();
			$('#terminology_menu').show();
			$.each(TMS.dictionary.domains, function(index, domain){
				var domainEntry = $('<li>').attr('id',domain.name)
											.text(domain.name + '(' + domain.results.length + ')')
											.addClass('ui-widget-header')
											.addClass('removable');

				var entryContainer = $('<div>');

				domainEntry.click(function(){
					entryContainer.toggle('fast');
				});
				$.each(this.results,function(index,result){
					var resultEntry = $('<li>').attr('id',result.uri)
												.text(result.label)
												.addClass('removable');
					//Mouse animation
					resultEntry.mouseover(function(){
						$(this).animate({backgroundColor: '#C7C7C7'}, 40);
					});
					resultEntry.mouseout(function(){
						$(this).animate({backgroundColor: 'transparent'}, 40);
					});
					//Push event when user doubleclicked term
					resultEntry.dblclick(function(){
						if(TMS.doubleClickTermFunc != null){
							TMS.doubleClickTermFunc(result.label);
							resultEntry.animate({backgroundColor: '#C7C7C7'}, 40);
						}
					});

					//disable text selection for user
					resultEntry.attr('unselectable', 'on')
								.css('user-select', 'none')
								.on('selectstart', false);

					//Open infobox when user clicked on the term
					resultEntry.click(function(){
						$('#infobox').hide(50, function() {
							TMS.handleTableColmn(result,'rank');
							TMS.handleTableColmn(result,'label');
							TMS.handleTableColmn(result,'kingdom');
							TMS.handleTableColmn(result,'status');
							TMS.handleTableColmn(result,'externalID');
							TMS.handleTableColmn(result,'domain');
							TMS.handleTableColmn(result,'sourceTerminology');
							TMS.handleTableColmn(result,'description');
							$('#uri').html($('<a>').attr('href',result.uri).text(result.uri));
							//Move infobox to selected item
							var offset = resultEntry.offset();
							$('#infobox').css({
								top: offset.top - 10 + "px",
								left: (offset.left + resultEntry.width() + 5) + "px"
							});
							$('#infobox').show('fast');
						});
					});
					entryContainer.hide();
					entryContainer.append(resultEntry);
					$('#terminology_menu').append(domainEntry);
				});//end of result iteration
				$('#terminology_menu').append(entryContainer);
			});//end of domain iteration
			//if(TMS.searchDone != null)
			//	TMS.searchDoneFunc();
		});//end of getJSON
	},

	cleanUp : function(){
		$('#terminology_menu').hide();
		$('#infobox').hide();
		$('#terminology_menu').empty();
		TMS.dictionary.clear();
	}
};
