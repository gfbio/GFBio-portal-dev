
<h2>Data Collection</h2>
<section>
	<div name="title" class="visible-xs">
		<h2>2. Data Collection</h2>
	</div>
    <div class="question_div">
       	<label>DCRT Input</label>             
    </div>
	<div class="question_div">
      	<label>What type of data format will you create?</label>
        	<div id="projectTypes" class="answer_div flex">
              	<div class="fl_w20">
	                <div>
	                    <input name="dataformat" type="checkbox"/>
	                    <label>Text (notes, surveys, etc.)</label>
	                </div>
	                <div>
	                    <input name="dataformat" type="checkbox"/>
	                    <label>Models, code</label>
	                </div>
	                <div>
	                    <input name="dataformat" type="checkbox"/>
	                    <label>GIS data</label>
	                </div>
	                <div>
	                    <input id="dataformat-cb" name="dataformat" type="checkbox"/>
	                    <label>Other</label>
	                </div>
            	</div>
	            <div class="fs_small" style="width: 30%">
	                <div>
	                    <input name="dataformat" type="checkbox"/>
	                    <label>Numeric (spreadsheet, measurements, etc.)</label>
	                </div>
	                <div>	
	                    <input name="dataformat" type="checkbox"/>
	                    <label>Multimedia (images, sounds, video, etc.)</label>
	                </div>
	                <div>	
	                    <input name="dataformat" type="checkbox"/>
	                    <label>Moleculare Sequence Data </label>
	                </div>
	                <div>	
	                    <input id="dataformatOther" name="dataformatOther" class="df_input" type="text" disabled="disabled" placeholder="Other Format" />
	                </div>
	            </div>
          </div>
    </div>
	<div class="question_div">
	    <label>Will your data format be openly documented?</label>
	     <div id="formatDocumentated" class="answer_div fs_small flex">
	        <div>
	            <input name="documentated" type="checkbox"/>
	            <label>Openly documented</label>
	        </div>
	        <div style="margin-left: 10px;">
	            <input name="documentated" type="checkbox"/>
	            <label>Only legible with special software</label>
	        </div>
	    </div>
	</div>
	<div class="question_div">
	    <label>Please estimate the data volume you will create.</label>
	    <div id="dataVolume" class="answer_div slider_w25">
	        <input id="volumeSlider" type="range" min="0" max="40" value="0" step="10"/>
	        <span id="volume" class="fs_small">&lt; 1GB</span>
	    </div>
	</div>
	<div class="question_div">
	    <label>Please estimate the number of data sets (files) you will create.</label>
	    <div id="datasetNumber" class="answer_div slider_w25">
	        <input id="datasetSlider" type="range" min="0" max="40" value="0" step="10"/>
	        <span id="datasets" class="fs_small">&lt; 10</span>
	    </div>
	</div>
	<div class="question_div">
	    <label>What standards, methodologies or tools for data collection will you use (e.g. Diversity Workbench, BExIS)?</label>
	    <div id="methodologies" class="answer_div">
	    <!-- required -->
	        <textarea id="methodologies" rows="5" cols="100" placeholder="Standards, methodologies and tools"></textarea>
	    </div>
	</div>
</section>
