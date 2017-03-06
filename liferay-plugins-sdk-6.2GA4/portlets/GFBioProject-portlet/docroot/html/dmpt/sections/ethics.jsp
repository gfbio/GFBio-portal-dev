
<h2>Ethics and Legal Compliance</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>4. Ethics and Legal Compliance</h2>
	</div>
	<div class="row">
	    <h4>Will you collect sensitive data?</h4>
	    <div id="sensitiveData" class="col-md-12">
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
	<div class="row">
    	<h4>How will your data be licensed for reuse?</h4>
    </div>
	<div class="row">
        <h4>Do you need access restriction for your data?</h4>
        <div class="col-xs-6 col-sm-3">
            <input class="radio_input" name="restriction"
                type="radio" value="yes" />
          	<label>Yes</label>
        </div>
        <div class="col-xs-6 col-sm-3">
      		<input class="radio_input" name="restriction"
                type="radio" value="no" />
          	<label>No</label>
        </div>
        <div id="accessYes">
        	<label>For how long do you need exclusive use of the data?</label>
        	<input id="accessHowLong" name="accessHowLong" type="text" class="inputtext_long" 
        	placeholder="Other sensitive data"/>
        	<label>Why do you need exclusive use of the data?</label>
        	<input id="accessWhy" name="accessWhy" type="text" class="inputtext_long" 
        	placeholder="Other sensitive data"/>
       	</div>
    </div>
</section>