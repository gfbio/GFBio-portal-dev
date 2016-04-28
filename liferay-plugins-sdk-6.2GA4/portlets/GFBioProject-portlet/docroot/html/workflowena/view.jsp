<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

  <html lang="en"  style="height: 100%;">
			
            <head>
			
                <title ng-bind="pageTitle"></title>
                <link href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet">
                <link rel="stylesheet" type="text/css" href="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.css" />
				<style type="text/css">
					.swHide {display: none}
					.swMain{display: block}
				</style>
                <script type="text/javascript" src="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.js"></script>
				
			<script>
				
			
				gadgets.HubSettings.onConnect = function(hub, suc, err) {
					gadgets.Hub.subscribe("gfbio.archiving.submit", receiveRequest);
				};
					
				function receiveRequest(topic, data, subscriberData) {
				    
					if (data.showhide == "show" && data.hidecode=='-21'){
					  
					    visibleShow(data.hidecode);
                        //$( "#hide_-21:not(:contains('submittingUser'))" ).prepend("{{ addToConfig('submittingUser','"+data.userid+"') }}");
	    
					}else{
					    visibleHide(data.hidecode);
					}
					adjust();
				}
				
				
				function adjust(){
				    var height = $('body').height()+20;
    				if (height < 950 && height > 50){ 
    				    height = 2500;
     				}
    				gadgets.window.adjustHeight(height);
				};
				
				
				function visibleShow(j) {
					document.getElementById("hide_".concat(j)).className = "swMain";
				};
						
			
				function visibleHide(j) {
					document.getElementById("hide_".concat(j)).className = "swHide";
				};

			</script>

            </head>
            
            <body ng-app="enaWidget" ng-controller="AppCtrl as appctrl">
            
                {{ addToConfig('submittingUser','15926') }}
			
				<div id="hide_-21" class="swHide">
				
				
				
					<nav class="navbar navbar-default" role="navigation">
						<div class="container-fluid">
							<div class="navbar-header">
								<button type="button" class="navbar-toggle" data-toggle="collapse"
										data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<a class="navbar-brand" href="#">ENA Submission</a>
							</div>

							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav">
									<li><a ui-sref="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
									<li><a ui-sref="study"><span class="glyphicon glyphicon-edit"></span> Study</a></li>
									<li><a ui-sref="sample"><span class="glyphicon glyphicon-edit"></span> Sample</a></li>
									<li><a ui-sref="gcdj"><span class="glyphicon glyphicon-plus"></span> Contextual Data</a></li>
									<li><a ui-sref="experiment"><span class="glyphicon glyphicon-edit"></span> Experiment</a></li>
									<li><a ui-sref="run"><span class="glyphicon glyphicon-edit"></span> Run</a></li>
									<li><a ui-sref="submission"><span class="glyphicon glyphicon-send"></span> Submit</a></li>
								</ul>
							</div>
						</div>
					</nav>
					<div class="container">
						<div ui-view="main"></div>
					</div>
					
				</div>
			
            </body>
            </html>
