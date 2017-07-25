
<h2>Preservation and Sharing</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>5. Preservation and Sharing</h2>
	</div>
	<div class="row">
        <h4>Where will your data be archived?</h4>
        <div id="dataArchives" class="col-md-12">
            <select id="archives" name="sensitive" multiple="multiple" size="6">
                <option value="gfbio" >GFBio Consortium</option>
                <option value="dsmz" >DSMZ</option>
                <option value="ena" >ENA</option>
                <option value="mfn" >MfN</option>
                <option value="pangaea" >PANGAEA</option>
                <option value="smns" >SMNS</option>
                <option value="snsb" >SNSB</option>
                <option value="zfmk" >ZFMK</option>
                <option value="other" >Other</option>
            </select>
            <div>
             <input id="archiveOther" name="archiveOther" type="text" class="inputtext_long" 
             placeholder="Other archive"/>
            </div>
        </div>
    </div>
	<div class="row">
        <h4>Do you need a persistent idenfifier (e.g. ePIC PID / DOI) for your data?
        	<a href="#" title="With a persistent identifiers (PID) - like DOI - you make your data citable and linkable to publications which is increasingly required by journals. GFBio recommends to add a PID to your data.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
        </h4>
        <div id="persistentIdentifier">
	        <div style="display: block;">
	            <label><input class="radio_input" name="pid"
	                type="radio" value="yes" />Yes (recommended)</label>
	        </div>
	        <div style="display: block;">
                <label><input class="radio_input" name="pid"
	                type="radio" value="no" />No</label>
	        </div>
	        <div style="display: block;">
	        	<label><input class="radio_input" name="pid"
	                type="radio" value="dontknow" />Don't know yet</label>
	        </div>
        </div>
    </div>
	<div class="row">
	    <h4>Do you need help estimating the cost and effort for data management?</h4>
	    <div id="needHelp">
	    	<div style="display: block;">
	            <label><input class="radio_input" name="help"
	            type="radio" value="yes" />Yes</label>
	        </div>
	        <div style="display: block;">
	            <label><input class="radio_input" name="help"
	            type="radio" value="no" />No</label>
	        </div>
	    </div>
	</div>
</section>