<div class="columns_1-2_container-1-layouttpl" id="main-content" role="main">

  	<div class="portlet-layout row-fluid">
       	<div class="portlet-column portlet-column-only span12" id="column-1">
           	$processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")
       	</div>
	</div>

	<div class="container">
		<div class="portlet-layout row-fluid">
			<div class="portlet-column portlet-column-first span6" id="column-2">
				$processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
			</div>
			<div class="portlet-column span6" id="column-3">
				$processor.processColumn("column-3", "portlet-column-content portlet-column-content-last")
			</div>
		</div>
	</div>
	
  	<div class="portlet-layout row-fluid">
       	<div class="portlet-column portlet-column-only span12" id="column-4">
           	$processor.processColumn("column-4", "portlet-column-content portlet-column-content-only")
       	</div>
	</div>
	
</div>