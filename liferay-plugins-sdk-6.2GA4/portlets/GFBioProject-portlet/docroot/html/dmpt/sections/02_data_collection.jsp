
<h2>Data Collection</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>2. Data Collection</h2>
	</div>
    <div id="physical" class="row">
       	<h4>Do you want to submit physical objects along with your data?</h4> 
       	<div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="physical" type="radio" value="true" />
					<span>Yes</span>
				</label>
     		</div>
      		<div class="col-xs-6 col-md-3">
		        <label class="mod-cb">
			        <input name="physical" type="radio" value="false" />
			        <span>No</span>
		        </label>
          	</div>
		</div>
    </div>
    <div id="alive" class="row">
       	<h4>Is your object dead or alive?</h4> 
       	<div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="alive" type="radio" value="true" />
					<span>Alive</span>
				</label>
			</div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="alive" type="radio" value="false" />
					<span>Dead</span>
				</label>
			</div>
		</div>
		
    </div>
    <div id="taxon" class="row">
       	<h4>Is your object taxon-based?</h4> 
       	<div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="taxon" type="radio" value="true" />
					<span>Yes</span>
				</label>
			</div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="taxon" type="radio" value="false" />
					<span>No</span>
				</label>
			</div>
		</div>
		
    </div>
    <div id="sequenced" class="row">
       	<h4>Do you have mainly sequence data?</h4> 
       	<div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="sequenced" type="radio" value="true" />
					<span>Yes</span>
				</label>
			</div>
			<div class="col-xs-6 col-md-3">
				<label class="mod-cb">
					<input name="sequenced" type="radio" value="false" >
					<span>No</span>
				</label>
			</div>
		</div>
    </div>
	<div class="row">
      	<h4>What type of data format will you create?
      		<a name="title" title="You can combine several options.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
      	</h4>
        	<div>
              	<div class="col-md-6">
	                <div>
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>Text (notes, surveys, etc.)</span>
	                    </label>
	                </div>
	                <div>
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>Models, code</span>
                    	</label>
	                </div>
	                <div>
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>GIS data</span>
                    	</label>
	                </div>
            	</div>
	            <div class="col-md-6">
	                <div>
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>Numeric (spreadsheet, measurements, etc.)</span>
                    	</label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>Multimedia (images, sounds, video, etc.)</span>
                    	</label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
	                    	<input name="dataformat" type="checkbox"/>
	                    	<span>Moleculare Sequence Data</span>
                   		</label>
	                </div>
	            </div>
	            <div class="col-md-6">
	            	<div>
	                    <label class="mod-cb">
	                    	<input id="dataformat-cb" name="dataformat" type="checkbox" value="Other"/>
	                    	<span>Other</span>
	                    </label>
	                </div>
	            </div>
	            <div class="col-md-12">
	            	<div>	
	                    <input id="dataformatOther" name="dataformatOther" class="df_input" type="text" placeholder="Other Format" />
	                </div>
	            </div>
          </div>
    </div>
	<div class="row">
	  	<h4>Will your data format be openly documented?
	  		<a name="title" title="According to DFG, we recommend the use of openly documented formats. 
&#34;the use of open or openly documented formats is recommended; if data are only legible with special software, the software has to be documented or included in the database (if permitted under copyright)&#34; - DFG: Guidelines on the Handling of Reserach Data in Biodiversity Reserach.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
	  	</h4>
	    <div id="formatDocumentated">
	        <div class="col-md-6">
				<label class="mod-cb">
					<input name="documentated" type="radio" value="Openly documentated" />
					<span>Openly documented</span>
				</label>
			</div>
			<div class="col-md-6">
				<label class="mod-cb">
					<input name="documentated" type="radio" value="Only legible with special software" >
					<span>Only legible with special software</span>
				</label>
			</div>
	    </div>
	</div>
	<div class="row">
	    <h4>Please estimate the data volume you will create.
	    	<a name="title" title="Please estimate roughly your expected data volume.
Think about the data you plan to collect. Will there be any areal photos or video files? Multimedia files produce much more volume than e.g. spreadsheets do.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
		</h4>
		<div>
		    <div id="dataVolume" class="col-sm-8 col-lg-6" style="text-align: center">
		        <input id="volumeSlider" type="range" min="0" max="40" value="0" step="10"/>
		        <span id="volume" >Cannot estimate</span>
		    </div>
	    </div>
	</div>
	<div class="row">
	    <h4>Please estimate the number of data sets (files) you will create.
	    	<a name="title" title="Do you plan to create a lot of single data sets or will there likely be only few?
The amount of data sets you will create is closely linked to your style of working and managing data. For example, you could use a single spreadsheet for each planned vegetation mapping or you could as well put hunderts of vegetation mappings in a single spreadsheet. Just give a brief impression of how many data sets might result from your work.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
		</h4>
		<div>
		    <div id="datasetNumber" class="col-sm-8 col-lg-6" style="text-align: center">
		        <input id="datasetSlider" type="range" min="0" max="40" value="0" step="10"/>
		        <span id="datasets" >Cannot estimate</span>
		    </div>
	    </div>
	</div>
	<div class="row">
	    <h4>What standards, methodologies or tools will you use to collect, manage and process your data?
	    	<a href="/support/wiki" title="There are many different ways of collecting, managing and processing research data. Try to document as detailled as possible and describe your workflows for data handling. Do you plan to use specific tools like Diversity Workbench or BExIS? Name common standards for data collection or methodologies you refer to. - Find examples for tools and management systems in our Wiki.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
	    </h4>
	    <div class="col-md-12">
	    <!-- required -->
	        <textarea id="methodologies" rows="5" cols="100" placeholder="Standards, methodologies and tools"></textarea>
	    </div>
	</div>
</section>
