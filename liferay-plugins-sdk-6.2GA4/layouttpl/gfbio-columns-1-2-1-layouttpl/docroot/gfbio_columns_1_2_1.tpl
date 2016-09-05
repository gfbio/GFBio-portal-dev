<div class="2-1Columns30-70-layouttpl" id="main-content" role="main">

  	<div class="portlet-layout row-fluid">
       	<div class="portlet-column portlet-column-only span12" id="column-1">
           	$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
       	</div>
	</div>

	<div class="portlet-layout row-fluid">
		<!-- make the right column goes on top in mobile view -->
		<div class="portlet-column row-fluid col-md-8 col-md-push-4" id="column-2">
			$processor.processColumn("column-2", "portlet-column-content")
		</div>
		<div class="portlet-column row-fluid col-md-4 col-md-pull-8" id="column-3">
			$processor.processColumn("column-3", "portlet-column-content")
		</div>
	</div>
	
  	<div class="portlet-layout row-fluid">
       	<div class="portlet-column portlet-column-only span12" id="column-4">
           	$processor.processColumn("column-4", "portlet-column-content portlet-column-content-only")
       	</div>
	</div>
	
</div>