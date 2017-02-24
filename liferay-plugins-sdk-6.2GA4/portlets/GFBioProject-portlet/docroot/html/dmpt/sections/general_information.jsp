
<h2>General Project Information</h2>
<section>

	<div name="title" class="hidden-md hidden-lg">
		<h2>1. General Project Information</h2>
	</div>
	<div>
		<label for="name">What's the official name of your research project?</label>
        <div class="answer_div">
		   <input id="name" name="projectName" type="text" placeholder="Project Name"/> <!-- required -->
		</div>
	</div>
  	<div class="question_div">
      	<label for="nature">What is the nature of your research project?</label>
      	<div id="nature" class="answer_div">
          	<label>
	              <input name="nature"
	              type="radio" value="reapeatable" />
	              Repeatable
          	</label>
          	<label style="margin-left: 10px;">
                  <input name="nature"
                  type="radio" value="snapshot" />
                  Snapshot
           	</label>
     	</div>
	</div>
    <div class=" container question_div">
   		<label>Please specify your project type.</label> 
        <div id="projectTypes" class=" row answer_div">
        	<div class="col-sm-3 col-md-6">
            	<div>
                	<input name="types" type="checkbox"/>
                    <label>Field Work</label>
                </div>
                <div>
                      <input name="types" type="checkbox"/>
                      <label>Observational</label>
                </div>
            </div>
            <div class="col-sm-3 col-md-6">
           		<div>
                	<input name="types" type="checkbox"/>
                    <label>Simulation</label>
                </div>
                <div>
                  	<input name="types" type="checkbox"/>
                    <label>Assimilation</label>
                </div>
            </div>
            <div class="col-sm-3 col-md-6">
            	<div>	
                	<input name="types" type="checkbox"/>
                    <label>Experimental</label>
                </div>
                <div>	
                    <input name="types" type="checkbox"/>
                    <label>Laboratory</label>
                </div>
            </div>
            <div class="col-sm-3 col-md-6">
                <div>
                    <input name="types" type="checkbox"/>
                    <label>Modelling</label>
                </div>
                <div>	
                    <input id="types-cb" name="types" type="checkbox"/>
                    <label>Other</label>
                </div>
            </div>
            <div class="col-md-12">
            	<input id="typesOther" name="typesOther" type="text" />
            </div>
        </div>
        
	</div>
	<div class="question_div">
    	<label>Provide your project abstract or describe your work and the data involved.</label>
        <div id="projectAbstract" class="answer_div">
      		<textarea id="abstract" rows="5" cols="100" placeholder="Project Abstract"></textarea> 
    	</div>
	</div>
	<div class="question_div">
    	<label>Who is/are the principal investigator/s?</label>
    	<div class="answer_div block">
        	<div id="principal">
        	<!-- required -->
     		<input id="firstPrincInput" name="investigator" type="text"  
            	placeholder="Principal Investigator" />
 			</div>
 			<div style="margin-top: 5px;">
            	<input id="princButton" type="button" value="Add principal investigator" disabled="disabled" />
        	</div>    
    	</div>
	</div>
	<div class="container question_div">
    	<label>Who is responsible for the project data?</label>
    	<div id="responsible" class="row answer_div" style="overflow: auto;">
	 		<div class="col-md-6">
	    		<input id="responsibleName" name="responsibleName" type="text" placeholder="Name" onfocus="getPrincipal()" />
	    	</div>
	    	
		 	<div class="col-md-6">
		    	<input name="phoneNumber" type="tel" placeholder="Phone Number"/> 
		    </div>
		    
		    <div class="col-md-12">
	     		<input name="email" type="email" placeholder="E-Mail"/>
	 		</div>
    	</div>
	</div>
	<div class="question_div">
    	<label>For which funding are you applying?</label>
    	<div id="fundings" class="answer_div">
        	<select id="funding" name="funding">
	            <option selected="selected" label="Select" value="select" >Select</option>
	          	<option value="individual" >DFG Individual Grants Programmes</option>
	        	<option value="coordinated" >DFG Coordinated Programmes</option>
	            <option value="excellence" >DFG Excellence Strategy</option>
	            <option value="research" >DFG Research Infrastructure</option>
	            <option value="international" >DFG International Programmes</option>
	            <option value="other" >Other</option>
	            <option value="none" >None</option>
        	</select>
        	<div>
        	<input id="fundingLink" type="text" placeholder="Link your funding call or programme"/>
        	<input id="fundingOther" name="fundingOther" type="text" placeholder="Please name the funding you apply for"/>
        	</div>
    	</div>
	</div>
	<div class="question_div">
    	<label>Which policies or guideliness for research data management will you follow?</label>
	    <div id="follow-policies" class="answer_div">
	        <select id="policies" name="policies" multiple="multiple" size="5">
	            <option value="individual" >DFG Guidelines on the Handling of Research Data</option>
	            <option value="coordinated" >DFG Guidelines on the Handling of Research Data in Biodiversity Research</option>
	            <option value="excellence" >DFG Guidelines for Safeguarding Good Scientific Practice</option>
	            <option value="other" >Other</option>
	            <option value="none" >None</option>
	        </select>
	        <div>
	         	<input id="policyOther" name="policyOther" type="text" class="inputtext_long" placeholder="Other Research Data Policy and Guideline"/>
	         	<input id="policyLink" type="text" class="inputtext_long" placeholder="Link Research Data Policy or Guideline"/>
	        </div>
	    </div>   
	</div>
</section>