
<h2>Ethics and Legal Compliance</h2>
<section>
	<div name="title" class="visible-xs">
		<h2>4. Ethics and Legal Compliance</h2>
	</div>
	<div class="question_div">
	    <label>Will you collect sensitive data?</label>
	    <div id="sensitiveData" class="answer_div">
	       	<select id="sensitive" name="sensitive" multiple="multiple" size="6">
	           <option value="individual" >Nagoya Protocol</option>
	           <option value="coordinated" >Red List</option>
	           <option value="excellence" >Personally Identifiable Information</option>
	           <option value="other" >Other</option>
	           <option value="uncertain" >Uncertain</option>
	           <option value="none" >None</option>
	       	</select>
	       	<div>
				<input id="sensitiveOther" name="sensitiveOther" type="text" class="inputtext_long" 
	        	placeholder="Other sensitive data"/>
	       </div>
	   	</div>
    </div>
	<div class="question_div">
    	<label>How will your data be licensed for reuse?</label>
    </div>
	<div class="question_div">
        <label>Do you need access restriction for your data?</label>
        <div id="accessRestriction" class="answer_div fs_small">
            <label>
                <input class="radio_input" name="restriction"
                type="radio" value="yes" />
                Yes
            </label>
            <label style="margin-left: 10px;">
                <input class="radio_input" name="restriction"
                type="radio" value="no" />
                No
            </label>
            <div id="accessYes">
            	<label>For how long do you need exclusive use of the data?</label>
            	<input id="accessHowLong" name="accessHowLong" type="text" class="inputtext_long" 
            	placeholder="Other sensitive data"/>
            	<label>Why do you need exclusive use of the data?</label>
            	<input id="accessWhy" name="accessWhy" type="text" class="inputtext_long" 
            	placeholder="Other sensitive data"/>
           	</div>
        </div>
    </div>
</section>