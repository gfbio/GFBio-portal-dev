<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<html lang="en"  style="height: 100%;">
			
	<head>
			
		<title ng-bind="pageTitle"></title>
				
		<%@ include file="/html/workflowena/init.jsp" %> <!-- library imports -->
		
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.css" />
				
		<script type="text/javascript" src="http://c103-170.cloud.gwdg.de/static/ena_widget/assets/enaWidget.js"></script>
				
	 </head>
            
    <body ng-app="enaWidget" ng-controller="AppCtrl as appctrl">
            
              
		{{ addToConfig('submittingUser','<%=PortalUtil.getUserId(request) %>') }}
				
				
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
					
		
			
	</body>
</html>
