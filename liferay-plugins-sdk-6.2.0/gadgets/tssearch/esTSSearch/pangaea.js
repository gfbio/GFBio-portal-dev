var PAN = {
	container : null,
	autocontainer : null,
	init : function(resultcontainer, autocompletecontainer){
		PAN.container = resultcontainer;
		PAN.autocontainer = autocompletecontainer;

		//init autocomplete input
		$('#' + autocompletecontainer).autocomplete({
			source : function(request, response){
				var url = 'http://ws.pangaea.de/es/portals/_suggest';
				var parameters = PAN.getSuggestSearchObject(request.term);
				$.post(url, JSON.stringify(parameters), function(data){
					var items = [];
					if(data.suggest[0].options){
						$.each(data.suggest[0].options,function(){
							items.push(this.text);
						});
					}
					response(items);
				})
			},
		},'json');
	},
	

	getSearchObject : function(term){
		return {
			 'from' : 0,
			 'size' : 10,
			 '_source' : 'html-1',
			 'query' : {
			  'function_score' : {
			   'query' : {
				 'simple_query_string' : {
				  'fields' : ['fulltext', 'citation^3'],
				  'default_operator' : 'or',
				  'query' : term,
				  'analyzer' : 'classic'
				 }
			   },
			   'functions' : [{
				 'field_value_factor' : {
				  'field' : 'boost'
				 }
				}
			   ],
			   'score_mode' : 'multiply'
			  }
			 }
			};
	},

	getSuggestSearchObject : function(term){
		return {
          'suggest': {
            'text': term,
            'completion': {
              'field': 'suggest',
              'size': 12,
            },
          },
        };
	},

	performSearch : function(term){
		var INDEX = 'dataportal-gfbio';
		var url = 'http://ws.pangaea.de/es/' + INDEX + '/pansimple/_search'
		var parameters = PAN.getSearchObject(term);
		var resultHtml = [];
	
		$.post(url,JSON.stringify(parameters),function(data){
			if (data.hits && data.hits.hits) {

				var timeToSearchStr = data.hits.total + ' datasets found in ' + data.took + 'ms';
				$('#' + PAN.container).append($('<p>').text(timeToSearchStr))
				var entrys = $('<ol>');
				$.each(data.hits.hits, function(){
					var html = this._source['html-1'];
					var score = Math.round(this._score / data.hits.max_score * 100.0);
					var entry = $('<li>').html(html);
					$(entry.children('.info')).append(' - Score: ' + score + '%');
					entrys.append(entry);
				});
			}
			$('#' + PAN.container).append(entrys);
		});
	},

	cleanUp : function(){
		$('#' + PAN.container).empty();
	}

};
