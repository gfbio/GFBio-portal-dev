
<h2>Preservation and Sharing</h2>
<section>
	<div name="title" class="visible-xs">
		<h2>5. Preservation and Sharing</h2>
	</div>
	<div class="question_div">
        <label>Where will your data be archived?</label>
        <div id="dataArchives" class="answer_div">
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
	<div class="question_div">
        <label>Do you need a persistent idenfifier (e.g. ePIC PID / DOI) for your data?</label>
        <div id="persistentIdentifier" class="answer_div fs_small">
            <label>
                <input class="radio_input" name="pid"
                type="radio" value="yes" />
                Yes (recommended)
            </label>
            <label>
                <input class="radio_input" name="pid"
                type="radio" value="no" />
                No
            </label>
            <label>
                <input class="radio_input" name="pid"
                type="radio" value="dontknow" />
                Don't know yet
            </label>
        </div>
    </div>
	<div class="question_div">
	    <label>Do you need help estimating the cost and effort for data management?</label>
	    <div id="needHelp" class="answer_div fs_small">
	        <label>
	            <input class="radio_input" name="help"
	            type="radio" value="yes" />
	            Yes
	        </label>
	        <label style="margin-left: 10px;">
	            <input class="radio_input" name="help"
	            type="radio" value="no" />
	            No
	        </label>
	    </div>
	</div>
</section>